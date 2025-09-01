package com.discord.utilities.animations;

import android.view.ViewPropertyAnimator;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.DebugProbes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import s.a.CancellableContinuationImpl5;

/* compiled from: AnimationCoroutineUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"Landroid/view/ViewPropertyAnimator;", "", "await", "(Landroid/view/ViewPropertyAnimator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.animations.AnimationCoroutineUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnimationCoroutineUtils {
    public static final Object await(ViewPropertyAnimator viewPropertyAnimator, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.A();
        cancellableContinuationImpl5.f(new AnimationCoroutineUtils2(viewPropertyAnimator));
        viewPropertyAnimator.setListener(new AnimationCoroutineUtils3(cancellableContinuationImpl5, viewPropertyAnimator));
        viewPropertyAnimator.start();
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objU;
    }
}
