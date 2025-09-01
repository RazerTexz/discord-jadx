package androidx.activity.contextaware;

import android.content.Context;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.DebugProbes;
import d0.z.d.InlineMarker;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import s.a.CancellableContinuationImpl5;

/* compiled from: ContextAware.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"R", "Landroidx/activity/contextaware/ContextAware;", "Lkotlin/Function1;", "Landroid/content/Context;", "onContextAvailable", "withContextAvailable", "(Landroidx/activity/contextaware/ContextAware;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity-ktx_release"}, k = 2, mv = {1, 4, 1})
/* renamed from: androidx.activity.contextaware.ContextAwareKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ContextAware2 {
    public static final <R> Object withContextAvailable(ContextAware contextAware, Function1<? super Context, ? extends R> function1, Continuation<? super R> continuation) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return function1.invoke(contextPeekAvailableContext);
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.A();
        ContextAware3 contextAware3 = new ContextAware3(cancellableContinuationImpl5, contextAware, function1);
        contextAware.addOnContextAvailableListener(contextAware3);
        cancellableContinuationImpl5.f(new ContextAware4(contextAware3, contextAware, function1));
        Object objU = cancellableContinuationImpl5.u();
        if (objU != Intrinsics2.getCOROUTINE_SUSPENDED()) {
            return objU;
        }
        DebugProbes.probeCoroutineSuspended(continuation);
        return objU;
    }

    private static final Object withContextAvailable$$forInline(ContextAware contextAware, Function1 function1, Continuation continuation) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return function1.invoke(contextPeekAvailableContext);
        }
        InlineMarker.mark(0);
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.A();
        ContextAware3 contextAware3 = new ContextAware3(cancellableContinuationImpl5, contextAware, function1);
        contextAware.addOnContextAvailableListener(contextAware3);
        cancellableContinuationImpl5.f(new ContextAware4(contextAware3, contextAware, function1));
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return objU;
    }
}
