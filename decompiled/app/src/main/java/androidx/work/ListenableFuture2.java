package androidx.work;

import b.i.b.d.a.ListenableFuture8;
import d0.Result2;
import d0.Result3;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: ListenableFuture.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"R", "", "run", "()V", "androidx/work/ListenableFutureKt$await$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* renamed from: androidx.work.CoroutineWorker$await$$inlined$suspendCancellableCoroutine$lambda$2, reason: use source file name */
/* loaded from: classes.dex */
public final class ListenableFuture2 implements Runnable {
    public final /* synthetic */ CancellableContinuation $cancellableContinuation;
    public final /* synthetic */ ListenableFuture8 $this_await$inlined;

    public ListenableFuture2(CancellableContinuation cancellableContinuation, ListenableFuture8 listenableFuture8) {
        this.$cancellableContinuation = cancellableContinuation;
        this.$this_await$inlined = listenableFuture8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            CancellableContinuation cancellableContinuation = this.$cancellableContinuation;
            V v = this.$this_await$inlined.get();
            Result2.a aVar = Result2.j;
            cancellableContinuation.resumeWith(Result2.m97constructorimpl(v));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.$cancellableContinuation.k(cause);
                return;
            }
            CancellableContinuation cancellableContinuation2 = this.$cancellableContinuation;
            Result2.a aVar2 = Result2.j;
            cancellableContinuation2.resumeWith(Result2.m97constructorimpl(Result3.createFailure(cause)));
        }
    }
}
