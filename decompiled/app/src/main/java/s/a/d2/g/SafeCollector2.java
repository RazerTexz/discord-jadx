package s.a.d2.g;

import d0.w.CoroutineContextImpl4;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* compiled from: SafeCollector.kt */
/* renamed from: s.a.d2.g.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class SafeCollector2 implements Continuation<Object> {
    public static final SafeCollector2 j = new SafeCollector2();

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return CoroutineContextImpl4.j;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
    }
}
