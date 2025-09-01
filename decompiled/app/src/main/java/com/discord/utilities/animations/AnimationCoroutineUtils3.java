package com.discord.utilities.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import d0.Result2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: AnimationCoroutineUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b¸\u0006\u0000"}, d2 = {"com/discord/utilities/animations/AnimationCoroutineUtilsKt$await$2$2", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "(Landroid/animation/Animator;)V", "onAnimationEnd", "utils_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.animations.AnimationCoroutineUtilsKt$await$$inlined$suspendCancellableCoroutine$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnimationCoroutineUtils3 extends AnimatorListenerAdapter {
    public final /* synthetic */ CancellableContinuation $cont;
    public final /* synthetic */ ViewPropertyAnimator $this_await$inlined;

    public AnimationCoroutineUtils3(CancellableContinuation cancellableContinuation, ViewPropertyAnimator viewPropertyAnimator) {
        this.$cont = cancellableContinuation;
        this.$this_await$inlined = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        this.$this_await$inlined.setListener(null);
        if (this.$cont.a()) {
            this.$cont.k(null);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        this.$this_await$inlined.setListener(null);
        if (this.$cont.a()) {
            CancellableContinuation cancellableContinuation = this.$cont;
            Unit unit = Unit.a;
            Result2.a aVar = Result2.j;
            cancellableContinuation.resumeWith(Result2.m97constructorimpl(unit));
        }
    }
}
