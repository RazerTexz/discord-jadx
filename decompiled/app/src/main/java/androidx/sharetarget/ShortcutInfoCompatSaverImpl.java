package androidx.sharetarget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import androidx.sharetarget.ShortcutsInfoSerialization;
import b.d.b.a.outline;
import b.i.b.d.a.ListenableFuture8;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ShortcutInfoCompatSaverImpl extends ShortcutInfoCompatSaver<ListenableFuture8<Void>> {
    private static final String DIRECTORY_BITMAPS = "ShortcutInfoCompatSaver_share_targets_bitmaps";
    private static final String DIRECTORY_TARGETS = "ShortcutInfoCompatSaver_share_targets";
    private static final int EXECUTOR_KEEP_ALIVE_TIME_SECS = 20;
    private static final String FILENAME_XML = "targets.xml";
    private static final Object GET_INSTANCE_LOCK = new Object();
    public static final String TAG = "ShortcutInfoCompatSaver";
    private static volatile ShortcutInfoCompatSaverImpl sInstance;
    public final File mBitmapsDir;
    public final ExecutorService mCacheUpdateService;
    public final Context mContext;
    private final ExecutorService mDiskIoService;
    public final File mTargetsXmlFile;
    public final Map<String, ShortcutsInfoSerialization.ShortcutContainer> mShortcutsMap = new ArrayMap();
    public final Map<String, ListenableFuture8<?>> mScheduledBitmapTasks = new ArrayMap();

    /* renamed from: androidx.sharetarget.ShortcutInfoCompatSaverImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ File val$workingDirectory;

        public AnonymousClass1(File file) {
            this.val$workingDirectory = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ShortcutInfoCompatSaverImpl.ensureDir(this.val$workingDirectory);
                ShortcutInfoCompatSaverImpl.ensureDir(ShortcutInfoCompatSaverImpl.this.mBitmapsDir);
                ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl = ShortcutInfoCompatSaverImpl.this;
                shortcutInfoCompatSaverImpl.mShortcutsMap.putAll(ShortcutsInfoSerialization.loadFromXml(shortcutInfoCompatSaverImpl.mTargetsXmlFile, shortcutInfoCompatSaverImpl.mContext));
                ShortcutInfoCompatSaverImpl.this.deleteDanglingBitmaps(new ArrayList(ShortcutInfoCompatSaverImpl.this.mShortcutsMap.values()));
            } catch (Exception e) {
                Log.w(ShortcutInfoCompatSaverImpl.TAG, "ShortcutInfoCompatSaver started with an exceptions ", e);
            }
        }
    }

    /* renamed from: androidx.sharetarget.ShortcutInfoCompatSaverImpl$10, reason: invalid class name */
    public class AnonymousClass10 implements Runnable {
        public final /* synthetic */ List val$containers;

        public AnonymousClass10(List list) {
            this.val$containers = list;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException, IOException, IllegalArgumentException {
            ShortcutInfoCompatSaverImpl.this.deleteDanglingBitmaps(this.val$containers);
            ShortcutsInfoSerialization.saveAsXml(this.val$containers, ShortcutInfoCompatSaverImpl.this.mTargetsXmlFile);
        }
    }

    /* renamed from: androidx.sharetarget.ShortcutInfoCompatSaverImpl$11, reason: invalid class name */
    public class AnonymousClass11 implements Runnable {
        public final /* synthetic */ ListenableFuture8 val$future;
        public final /* synthetic */ ResolvableFuture val$output;

        public AnonymousClass11(ListenableFuture8 listenableFuture8, ResolvableFuture resolvableFuture) {
            this.val$future = listenableFuture8;
            this.val$output = resolvableFuture;
        }

        @Override // java.lang.Runnable
        public void run() throws ExecutionException, InterruptedException {
            try {
                this.val$future.get();
                this.val$output.set(null);
            } catch (Exception e) {
                this.val$output.setException(e);
            }
        }
    }

    /* renamed from: androidx.sharetarget.ShortcutInfoCompatSaverImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        public final /* synthetic */ List val$idList;
        public final /* synthetic */ ResolvableFuture val$result;

        public AnonymousClass2(List list, ResolvableFuture resolvableFuture) {
            this.val$idList = list;
            this.val$result = resolvableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.val$idList) {
                ShortcutInfoCompatSaverImpl.this.mShortcutsMap.remove(str);
                ListenableFuture8<?> listenableFuture8Remove = ShortcutInfoCompatSaverImpl.this.mScheduledBitmapTasks.remove(str);
                if (listenableFuture8Remove != null) {
                    listenableFuture8Remove.cancel(false);
                }
            }
            ShortcutInfoCompatSaverImpl.this.scheduleSyncCurrentState(this.val$result);
        }
    }

    /* renamed from: androidx.sharetarget.ShortcutInfoCompatSaverImpl$3, reason: invalid class name */
    public class AnonymousClass3 implements Runnable {
        public final /* synthetic */ ResolvableFuture val$result;

        public AnonymousClass3(ResolvableFuture resolvableFuture) {
            this.val$result = resolvableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            ShortcutInfoCompatSaverImpl.this.mShortcutsMap.clear();
            Iterator<ListenableFuture8<?>> it = ShortcutInfoCompatSaverImpl.this.mScheduledBitmapTasks.values().iterator();
            while (it.hasNext()) {
                it.next().cancel(false);
            }
            ShortcutInfoCompatSaverImpl.this.mScheduledBitmapTasks.clear();
            ShortcutInfoCompatSaverImpl.this.scheduleSyncCurrentState(this.val$result);
        }
    }

    /* renamed from: androidx.sharetarget.ShortcutInfoCompatSaverImpl$4, reason: invalid class name */
    public class AnonymousClass4 implements Callable<ArrayList<ShortcutInfoCompat>> {
        public AnonymousClass4() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ ArrayList<ShortcutInfoCompat> call() throws Exception {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: avoid collision after fix types in other method */
        public ArrayList<ShortcutInfoCompat> call2() {
            ArrayList<ShortcutInfoCompat> arrayList = new ArrayList<>();
            Iterator<ShortcutsInfoSerialization.ShortcutContainer> it = ShortcutInfoCompatSaverImpl.this.mShortcutsMap.values().iterator();
            while (it.hasNext()) {
                arrayList.add(new ShortcutInfoCompat.Builder(it.next().mShortcutInfo).build());
            }
            return arrayList;
        }
    }

    /* renamed from: androidx.sharetarget.ShortcutInfoCompatSaverImpl$5, reason: invalid class name */
    public class AnonymousClass5 implements Callable<ShortcutsInfoSerialization.ShortcutContainer> {
        public final /* synthetic */ String val$shortcutId;

        public AnonymousClass5(String str) {
            this.val$shortcutId = str;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ ShortcutsInfoSerialization.ShortcutContainer call() throws Exception {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public ShortcutsInfoSerialization.ShortcutContainer call() {
            return ShortcutInfoCompatSaverImpl.this.mShortcutsMap.get(this.val$shortcutId);
        }
    }

    /* renamed from: androidx.sharetarget.ShortcutInfoCompatSaverImpl$6, reason: invalid class name */
    public class AnonymousClass6 implements Callable<Bitmap> {
        public final /* synthetic */ ShortcutsInfoSerialization.ShortcutContainer val$container;

        public AnonymousClass6(ShortcutsInfoSerialization.ShortcutContainer shortcutContainer) {
            this.val$container = shortcutContainer;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Bitmap call() throws Exception {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Bitmap call() {
            return BitmapFactory.decodeFile(this.val$container.mBitmapPath);
        }
    }

    /* renamed from: androidx.sharetarget.ShortcutInfoCompatSaverImpl$7, reason: invalid class name */
    public class AnonymousClass7 implements Runnable {
        public final /* synthetic */ List val$copy;
        public final /* synthetic */ ResolvableFuture val$result;

        /* renamed from: androidx.sharetarget.ShortcutInfoCompatSaverImpl$7$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            public final /* synthetic */ ListenableFuture8 val$future;
            public final /* synthetic */ String val$id;

            public AnonymousClass1(String str, ListenableFuture8 listenableFuture8) {
                this.val$id = str;
                this.val$future = listenableFuture8;
            }

            @Override // java.lang.Runnable
            public void run() throws ExecutionException, InterruptedException {
                ShortcutInfoCompatSaverImpl.this.mScheduledBitmapTasks.remove(this.val$id);
                if (this.val$future.isCancelled()) {
                    return;
                }
                try {
                    this.val$future.get();
                } catch (Exception e) {
                    AnonymousClass7.this.val$result.setException(e);
                }
            }
        }

        public AnonymousClass7(List list, ResolvableFuture resolvableFuture) {
            this.val$copy = list;
            this.val$result = resolvableFuture;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            for (ShortcutInfoCompat shortcutInfoCompat : this.val$copy) {
                Set<String> categories = shortcutInfoCompat.getCategories();
                if (categories != null && !categories.isEmpty()) {
                    ShortcutsInfoSerialization.ShortcutContainer shortcutContainerContainerFrom = ShortcutInfoCompatSaverImpl.this.containerFrom(shortcutInfoCompat);
                    Bitmap bitmap = shortcutContainerContainerFrom.mBitmapPath != null ? shortcutInfoCompat.getIcon().getBitmap() : null;
                    String id2 = shortcutInfoCompat.getId();
                    ShortcutInfoCompatSaverImpl.this.mShortcutsMap.put(id2, shortcutContainerContainerFrom);
                    if (bitmap != null) {
                        ListenableFuture8<Void> listenableFuture8ScheduleBitmapSaving = ShortcutInfoCompatSaverImpl.this.scheduleBitmapSaving(bitmap, shortcutContainerContainerFrom.mBitmapPath);
                        ListenableFuture8<?> listenableFuture8Put = ShortcutInfoCompatSaverImpl.this.mScheduledBitmapTasks.put(id2, listenableFuture8ScheduleBitmapSaving);
                        if (listenableFuture8Put != null) {
                            listenableFuture8Put.cancel(false);
                        }
                        listenableFuture8ScheduleBitmapSaving.addListener(new AnonymousClass1(id2, listenableFuture8ScheduleBitmapSaving), ShortcutInfoCompatSaverImpl.this.mCacheUpdateService);
                    }
                }
            }
            ShortcutInfoCompatSaverImpl.this.scheduleSyncCurrentState(this.val$result);
        }
    }

    /* renamed from: androidx.sharetarget.ShortcutInfoCompatSaverImpl$8, reason: invalid class name */
    public class AnonymousClass8 implements Runnable {
        public final /* synthetic */ Bitmap val$bitmap;
        public final /* synthetic */ String val$path;

        public AnonymousClass8(Bitmap bitmap, String str) {
            this.val$bitmap = bitmap;
            this.val$path = str;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            ShortcutInfoCompatSaverImpl.this.saveBitmap(this.val$bitmap, this.val$path);
        }
    }

    /* renamed from: androidx.sharetarget.ShortcutInfoCompatSaverImpl$9, reason: invalid class name */
    public class AnonymousClass9 implements Runnable {
        public final /* synthetic */ ResolvableFuture val$result;
        public final /* synthetic */ Runnable val$runnable;

        public AnonymousClass9(ResolvableFuture resolvableFuture, Runnable runnable) {
            this.val$result = resolvableFuture;
            this.val$runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$result.isCancelled()) {
                return;
            }
            try {
                this.val$runnable.run();
                this.val$result.set(null);
            } catch (Exception e) {
                this.val$result.setException(e);
            }
        }
    }

    @AnyThread
    public ShortcutInfoCompatSaverImpl(Context context, ExecutorService executorService, ExecutorService executorService2) {
        this.mContext = context.getApplicationContext();
        this.mCacheUpdateService = executorService;
        this.mDiskIoService = executorService2;
        File file = new File(context.getFilesDir(), DIRECTORY_TARGETS);
        this.mBitmapsDir = new File(file, DIRECTORY_BITMAPS);
        this.mTargetsXmlFile = new File(file, FILENAME_XML);
        executorService.submit(new AnonymousClass1(file));
    }

    @AnyThread
    public static ExecutorService createExecutorService() {
        return new ThreadPoolExecutor(0, 1, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static boolean ensureDir(File file) {
        if (file.exists() && !file.isDirectory() && !file.delete()) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    @AnyThread
    public static ShortcutInfoCompatSaverImpl getInstance(Context context) {
        if (sInstance == null) {
            synchronized (GET_INSTANCE_LOCK) {
                if (sInstance == null) {
                    sInstance = new ShortcutInfoCompatSaverImpl(context, createExecutorService(), createExecutorService());
                }
            }
        }
        return sInstance;
    }

    private ListenableFuture8<Void> submitDiskOperation(Runnable runnable) {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mDiskIoService.submit(new AnonymousClass9(resolvableFutureCreate, runnable));
        return resolvableFutureCreate;
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public /* bridge */ /* synthetic */ ListenableFuture8<Void> addShortcuts(List list) {
        return addShortcuts((List<ShortcutInfoCompat>) list);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShortcutsInfoSerialization.ShortcutContainer containerFrom(ShortcutInfoCompat shortcutInfoCompat) throws Resources.NotFoundException {
        String resourceName;
        String absolutePath;
        IconCompat icon = shortcutInfoCompat.getIcon();
        if (icon == null) {
            resourceName = null;
            absolutePath = null;
        } else {
            int type = icon.getType();
            if (type == 1) {
                absolutePath = new File(this.mBitmapsDir, UUID.randomUUID().toString()).getAbsolutePath();
                resourceName = null;
            } else if (type == 2) {
                resourceName = this.mContext.getResources().getResourceName(icon.getResId());
                absolutePath = null;
            } else if (type != 5) {
            }
        }
        return new ShortcutsInfoSerialization.ShortcutContainer(new ShortcutInfoCompat.Builder(shortcutInfoCompat).setIcon(null).build(), resourceName, absolutePath);
    }

    public void deleteDanglingBitmaps(List<ShortcutsInfoSerialization.ShortcutContainer> list) {
        ArrayList arrayList = new ArrayList();
        for (ShortcutsInfoSerialization.ShortcutContainer shortcutContainer : list) {
            if (!TextUtils.isEmpty(shortcutContainer.mBitmapPath)) {
                arrayList.add(shortcutContainer.mBitmapPath);
            }
        }
        for (File file : this.mBitmapsDir.listFiles()) {
            if (!arrayList.contains(file.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    @WorkerThread
    public IconCompat getShortcutIcon(String str) throws Exception {
        Bitmap bitmap;
        ShortcutsInfoSerialization.ShortcutContainer shortcutContainer = (ShortcutsInfoSerialization.ShortcutContainer) this.mCacheUpdateService.submit(new AnonymousClass5(str)).get();
        if (shortcutContainer == null) {
            return null;
        }
        if (!TextUtils.isEmpty(shortcutContainer.mResourceName)) {
            int identifier = 0;
            try {
                identifier = this.mContext.getResources().getIdentifier(shortcutContainer.mResourceName, null, null);
            } catch (Exception unused) {
            }
            if (identifier != 0) {
                return IconCompat.createWithResource(this.mContext, identifier);
            }
        }
        if (TextUtils.isEmpty(shortcutContainer.mBitmapPath) || (bitmap = (Bitmap) this.mDiskIoService.submit(new AnonymousClass6(shortcutContainer)).get()) == null) {
            return null;
        }
        return IconCompat.createWithBitmap(bitmap);
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @WorkerThread
    public List<ShortcutInfoCompat> getShortcuts() throws Exception {
        return (List) this.mCacheUpdateService.submit(new AnonymousClass4()).get();
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public /* bridge */ /* synthetic */ ListenableFuture8<Void> removeAllShortcuts() {
        return removeAllShortcuts();
    }

    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public /* bridge */ /* synthetic */ ListenableFuture8<Void> removeShortcuts(List list) {
        return removeShortcuts((List<String>) list);
    }

    @WorkerThread
    public void saveBitmap(Bitmap bitmap, String str) throws IOException {
        if (bitmap == null) {
            throw new IllegalArgumentException("bitmap is null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("path is empty");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            try {
                if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
                    fileOutputStream.close();
                    return;
                }
                Log.wtf(TAG, "Unable to compress bitmap");
                throw new RuntimeException("Unable to compress bitmap for saving " + str);
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | OutOfMemoryError | RuntimeException e) {
            Log.wtf(TAG, "Unable to write bitmap to file", e);
            throw new RuntimeException(outline.w("Unable to write bitmap to file ", str), e);
        }
    }

    public ListenableFuture8<Void> scheduleBitmapSaving(Bitmap bitmap, String str) {
        return submitDiskOperation(new AnonymousClass8(bitmap, str));
    }

    public void scheduleSyncCurrentState(ResolvableFuture<Void> resolvableFuture) {
        ListenableFuture8<Void> listenableFuture8SubmitDiskOperation = submitDiskOperation(new AnonymousClass10(new ArrayList(this.mShortcutsMap.values())));
        listenableFuture8SubmitDiskOperation.addListener(new AnonymousClass11(listenableFuture8SubmitDiskOperation, resolvableFuture), this.mCacheUpdateService);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public ListenableFuture8<Void> addShortcuts(List<ShortcutInfoCompat> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<ShortcutInfoCompat> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new ShortcutInfoCompat.Builder(it.next()).build());
        }
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mCacheUpdateService.submit(new AnonymousClass7(arrayList, resolvableFutureCreate));
        return resolvableFutureCreate;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public ListenableFuture8<Void> removeAllShortcuts() {
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mCacheUpdateService.submit(new AnonymousClass3(resolvableFutureCreate));
        return resolvableFutureCreate;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
    @AnyThread
    public ListenableFuture8<Void> removeShortcuts(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        ResolvableFuture resolvableFutureCreate = ResolvableFuture.create();
        this.mCacheUpdateService.submit(new AnonymousClass2(arrayList, resolvableFutureCreate));
        return resolvableFutureCreate;
    }
}
