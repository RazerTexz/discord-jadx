package d0.w.i.a;

import d0.w.CoroutineContextImpl4;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* compiled from: ContinuationImpl.kt */
/* renamed from: d0.w.i.a.i, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ContinuationImpl4 extends ContinuationImpl {
    public ContinuationImpl4(Continuation<Object> continuation) {
        super(continuation);
        if (continuation != null) {
            if (!(continuation.getContext() == CoroutineContextImpl4.j)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return CoroutineContextImpl4.j;
    }
}
