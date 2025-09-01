package s.a;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: Delay.kt */
/* renamed from: s.a.h0, reason: use source file name */
/* loaded from: classes3.dex */
public interface Delay {
    void c(long j, CancellableContinuation<? super Unit> cancellableContinuation);

    Job2 x(long j, Runnable runnable, CoroutineContext coroutineContext);
}
