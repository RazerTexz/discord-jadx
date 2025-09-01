package androidx.work;

import androidx.annotation.RestrictTo;
import b.i.b.d.a.ListenableFuture8;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.DebugProbes;
import d0.z.d.InlineMarker;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import s.a.CancellableContinuationImpl5;

/* compiled from: ListenableFuture.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087Hø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"R", "Lb/i/b/d/a/a;", "await", "(Lb/i/b/d/a/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime-ktx_release"}, k = 2, mv = {1, 4, 0})
/* renamed from: androidx.work.ListenableFutureKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ListenableFuture3 {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <R> Object await(ListenableFuture8<R> listenableFuture8, Continuation<? super R> continuation) throws Throwable {
        if (listenableFuture8.isDone()) {
            try {
                return listenableFuture8.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        listenableFuture8.addListener(new ListenableFuture4(cancellableContinuationImpl5, listenableFuture8), DirectExecutor.INSTANCE);
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private static final Object await$$forInline(ListenableFuture8 listenableFuture8, Continuation continuation) throws Throwable {
        if (listenableFuture8.isDone()) {
            try {
                return listenableFuture8.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        }
        InlineMarker.mark(0);
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        listenableFuture8.addListener(new ListenableFuture4(cancellableContinuationImpl5, listenableFuture8), DirectExecutor.INSTANCE);
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return objU;
    }
}
