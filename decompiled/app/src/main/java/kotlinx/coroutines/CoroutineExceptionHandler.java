package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes3.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.Element {
    public static final /* synthetic */ int g = 0;

    /* compiled from: CoroutineExceptionHandler.kt */
    public static final class a implements CoroutineContext.Key<CoroutineExceptionHandler> {
        public static final /* synthetic */ a a = new a();
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);
}
