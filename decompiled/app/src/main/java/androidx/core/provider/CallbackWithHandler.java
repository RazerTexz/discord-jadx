package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;

/* loaded from: classes.dex */
public class CallbackWithHandler {

    @NonNull
    private final FontsContractCompat.FontRequestCallback mCallback;

    @NonNull
    private final Handler mCallbackHandler;

    /* renamed from: androidx.core.provider.CallbackWithHandler$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
        public final /* synthetic */ Typeface val$typeface;

        public AnonymousClass1(FontsContractCompat.FontRequestCallback fontRequestCallback, Typeface typeface) {
            this.val$callback = fontRequestCallback;
            this.val$typeface = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$callback.onTypefaceRetrieved(this.val$typeface);
        }
    }

    /* renamed from: androidx.core.provider.CallbackWithHandler$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        public final /* synthetic */ FontsContractCompat.FontRequestCallback val$callback;
        public final /* synthetic */ int val$reason;

        public AnonymousClass2(FontsContractCompat.FontRequestCallback fontRequestCallback, int i) {
            this.val$callback = fontRequestCallback;
            this.val$reason = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$callback.onTypefaceRequestFailed(this.val$reason);
        }
    }

    public CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback fontRequestCallback, @NonNull Handler handler) {
        this.mCallback = fontRequestCallback;
        this.mCallbackHandler = handler;
    }

    private void onTypefaceRequestFailed(int i) {
        this.mCallbackHandler.post(new AnonymousClass2(this.mCallback, i));
    }

    private void onTypefaceRetrieved(@NonNull Typeface typeface) {
        this.mCallbackHandler.post(new AnonymousClass1(this.mCallback, typeface));
    }

    public void onTypefaceResult(@NonNull FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.isSuccess()) {
            onTypefaceRetrieved(typefaceResult.mTypeface);
        } else {
            onTypefaceRequestFailed(typefaceResult.mResult);
        }
    }

    public CallbackWithHandler(@NonNull FontsContractCompat.FontRequestCallback fontRequestCallback) {
        this.mCallback = fontRequestCallback;
        this.mCallbackHandler = CalleeHandler.create();
    }
}
