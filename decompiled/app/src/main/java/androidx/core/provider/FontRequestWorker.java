package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class FontRequestWorker {
    public static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
    public static final Object LOCK = new Object();

    @GuardedBy("LOCK")
    public static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES = new SimpleArrayMap<>();

    /* renamed from: androidx.core.provider.FontRequestWorker$1, reason: invalid class name */
    public class AnonymousClass1 implements Callable<TypefaceResult> {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$id;
        public final /* synthetic */ FontRequest val$request;
        public final /* synthetic */ int val$style;

        public AnonymousClass1(String str, Context context, FontRequest fontRequest, int i) {
            this.val$id = str;
            this.val$context = context;
            this.val$request = fontRequest;
            this.val$style = i;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ TypefaceResult call() throws Exception {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public TypefaceResult call() {
            return FontRequestWorker.getFontSync(this.val$id, this.val$context, this.val$request, this.val$style);
        }
    }

    /* renamed from: androidx.core.provider.FontRequestWorker$2, reason: invalid class name */
    public class AnonymousClass2 implements Consumer<TypefaceResult> {
        public final /* synthetic */ CallbackWithHandler val$callback;

        public AnonymousClass2(CallbackWithHandler callbackWithHandler) {
            this.val$callback = callbackWithHandler;
        }

        @Override // androidx.core.util.Consumer
        public /* bridge */ /* synthetic */ void accept(TypefaceResult typefaceResult) {
            accept2(typefaceResult);
        }

        /* renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(TypefaceResult typefaceResult) {
            this.val$callback.onTypefaceResult(typefaceResult);
        }
    }

    /* renamed from: androidx.core.provider.FontRequestWorker$3, reason: invalid class name */
    public class AnonymousClass3 implements Callable<TypefaceResult> {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$id;
        public final /* synthetic */ FontRequest val$request;
        public final /* synthetic */ int val$style;

        public AnonymousClass3(String str, Context context, FontRequest fontRequest, int i) {
            this.val$id = str;
            this.val$context = context;
            this.val$request = fontRequest;
            this.val$style = i;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ TypefaceResult call() throws Exception {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public TypefaceResult call() {
            return FontRequestWorker.getFontSync(this.val$id, this.val$context, this.val$request, this.val$style);
        }
    }

    /* renamed from: androidx.core.provider.FontRequestWorker$4, reason: invalid class name */
    public class AnonymousClass4 implements Consumer<TypefaceResult> {
        public final /* synthetic */ String val$id;

        public AnonymousClass4(String str) {
            this.val$id = str;
        }

        @Override // androidx.core.util.Consumer
        public /* bridge */ /* synthetic */ void accept(TypefaceResult typefaceResult) {
            accept2(typefaceResult);
        }

        /* renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(TypefaceResult typefaceResult) {
            synchronized (FontRequestWorker.LOCK) {
                SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> simpleArrayMap = FontRequestWorker.PENDING_REPLIES;
                ArrayList<Consumer<TypefaceResult>> arrayList = simpleArrayMap.get(this.val$id);
                if (arrayList == null) {
                    return;
                }
                simpleArrayMap.remove(this.val$id);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).accept(typefaceResult);
                }
            }
        }
    }

    private FontRequestWorker() {
    }

    private static String createCacheId(@NonNull FontRequest fontRequest, int i) {
        return fontRequest.getId() + "-" + i;
    }

    @SuppressLint({"WrongConstant"})
    private static int getFontFamilyResultStatus(@NonNull FontsContractCompat.FontFamilyResult fontFamilyResult) {
        int i = 1;
        if (fontFamilyResult.getStatusCode() != 0) {
            return fontFamilyResult.getStatusCode() != 1 ? -3 : -2;
        }
        FontsContractCompat.FontInfo[] fonts = fontFamilyResult.getFonts();
        if (fonts != null && fonts.length != 0) {
            i = 0;
            for (FontsContractCompat.FontInfo fontInfo : fonts) {
                int resultCode = fontInfo.getResultCode();
                if (resultCode != 0) {
                    if (resultCode < 0) {
                        return -3;
                    }
                    return resultCode;
                }
            }
        }
        return i;
    }

    @NonNull
    public static TypefaceResult getFontSync(@NonNull String str, @NonNull Context context, @NonNull FontRequest fontRequest, int i) {
        LruCache<String, Typeface> lruCache = sTypefaceCache;
        Typeface typeface = lruCache.get(str);
        if (typeface != null) {
            return new TypefaceResult(typeface);
        }
        try {
            FontsContractCompat.FontFamilyResult fontFamilyResult = FontProvider.getFontFamilyResult(context, fontRequest, null);
            int fontFamilyResultStatus = getFontFamilyResultStatus(fontFamilyResult);
            if (fontFamilyResultStatus != 0) {
                return new TypefaceResult(fontFamilyResultStatus);
            }
            Typeface typefaceCreateFromFontInfo = TypefaceCompat.createFromFontInfo(context, null, fontFamilyResult.getFonts(), i);
            if (typefaceCreateFromFontInfo == null) {
                return new TypefaceResult(-3);
            }
            lruCache.put(str, typefaceCreateFromFontInfo);
            return new TypefaceResult(typefaceCreateFromFontInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(-1);
        }
    }

    public static Typeface requestFontAsync(@NonNull Context context, @NonNull FontRequest fontRequest, int i, @Nullable Executor executor, @NonNull CallbackWithHandler callbackWithHandler) {
        String strCreateCacheId = createCacheId(fontRequest, i);
        Typeface typeface = sTypefaceCache.get(strCreateCacheId);
        if (typeface != null) {
            callbackWithHandler.onTypefaceResult(new TypefaceResult(typeface));
            return typeface;
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(callbackWithHandler);
        synchronized (LOCK) {
            SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> simpleArrayMap = PENDING_REPLIES;
            ArrayList<Consumer<TypefaceResult>> arrayList = simpleArrayMap.get(strCreateCacheId);
            if (arrayList != null) {
                arrayList.add(anonymousClass2);
                return null;
            }
            ArrayList<Consumer<TypefaceResult>> arrayList2 = new ArrayList<>();
            arrayList2.add(anonymousClass2);
            simpleArrayMap.put(strCreateCacheId, arrayList2);
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(strCreateCacheId, context, fontRequest, i);
            if (executor == null) {
                executor = DEFAULT_EXECUTOR_SERVICE;
            }
            RequestExecutor.execute(executor, anonymousClass3, new AnonymousClass4(strCreateCacheId));
            return null;
        }
    }

    public static Typeface requestFontSync(@NonNull Context context, @NonNull FontRequest fontRequest, @NonNull CallbackWithHandler callbackWithHandler, int i, int i2) {
        String strCreateCacheId = createCacheId(fontRequest, i);
        Typeface typeface = sTypefaceCache.get(strCreateCacheId);
        if (typeface != null) {
            callbackWithHandler.onTypefaceResult(new TypefaceResult(typeface));
            return typeface;
        }
        if (i2 == -1) {
            TypefaceResult fontSync = getFontSync(strCreateCacheId, context, fontRequest, i);
            callbackWithHandler.onTypefaceResult(fontSync);
            return fontSync.mTypeface;
        }
        try {
            TypefaceResult typefaceResult = (TypefaceResult) RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, new AnonymousClass1(strCreateCacheId, context, fontRequest, i), i2);
            callbackWithHandler.onTypefaceResult(typefaceResult);
            return typefaceResult.mTypeface;
        } catch (InterruptedException unused) {
            callbackWithHandler.onTypefaceResult(new TypefaceResult(-3));
            return null;
        }
    }

    public static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }

    public static final class TypefaceResult {
        public final int mResult;
        public final Typeface mTypeface;

        public TypefaceResult(int i) {
            this.mTypeface = null;
            this.mResult = i;
        }

        @SuppressLint({"WrongConstant"})
        public boolean isSuccess() {
            return this.mResult == 0;
        }

        @SuppressLint({"WrongConstant"})
        public TypefaceResult(@NonNull Typeface typeface) {
            this.mTypeface = typeface;
            this.mResult = 0;
        }
    }
}
