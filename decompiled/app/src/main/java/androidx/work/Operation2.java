package androidx.work;

import androidx.work.Operation;
import b.i.b.d.a.ListenableFuture8;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.DebugProbes;
import d0.z.d.InlineMarker;
import d0.z.d.Intrinsics3;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import s.a.CancellableContinuationImpl5;

/* compiled from: Operation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"Landroidx/work/Operation;", "Landroidx/work/Operation$State$SUCCESS;", "kotlin.jvm.PlatformType", "await", "(Landroidx/work/Operation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime-ktx_release"}, k = 2, mv = {1, 4, 0})
/* renamed from: androidx.work.OperationKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Operation2 {
    public static final Object await(Operation operation, Continuation<? super Operation.State.SUCCESS> continuation) throws Throwable {
        ListenableFuture8<Operation.State.SUCCESS> result = operation.getResult();
        Intrinsics3.checkExpressionValueIsNotNull(result, "result");
        if (result.isDone()) {
            try {
                return result.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        result.addListener(new ListenableFuture6(cancellableContinuationImpl5, result), DirectExecutor.INSTANCE);
        Object objU = cancellableContinuationImpl5.u();
        if (objU != Intrinsics2.getCOROUTINE_SUSPENDED()) {
            return objU;
        }
        DebugProbes.probeCoroutineSuspended(continuation);
        return objU;
    }

    private static final Object await$$forInline(Operation operation, Continuation continuation) throws Throwable {
        ListenableFuture8<Operation.State.SUCCESS> result = operation.getResult();
        Intrinsics3.checkExpressionValueIsNotNull(result, "result");
        if (result.isDone()) {
            try {
                return result.get();
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
        result.addListener(new ListenableFuture6(cancellableContinuationImpl5, result), DirectExecutor.INSTANCE);
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return objU;
    }
}
