package com.discord.utilities.animations;

import android.animation.ValueAnimator;
import com.airbnb.lottie.LottieAnimationView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.ranges.Ranges2;

/* compiled from: LottieAnimationUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/utilities/animations/LoopAnimationListener;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "(Landroid/animation/ValueAnimator;)V", "Lcom/airbnb/lottie/LottieAnimationView;", "animationView", "Lcom/airbnb/lottie/LottieAnimationView;", "Lkotlin/ranges/IntRange;", "loopFrames", "Lkotlin/ranges/IntRange;", "", "triggerFrame", "I", "<init>", "(Lcom/airbnb/lottie/LottieAnimationView;ILkotlin/ranges/IntRange;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.animations.LoopAnimationListener, reason: use source file name */
/* loaded from: classes2.dex */
public final class LottieAnimationUtils implements ValueAnimator.AnimatorUpdateListener {
    private final LottieAnimationView animationView;
    private final Ranges2 loopFrames;
    private final int triggerFrame;

    public LottieAnimationUtils(LottieAnimationView lottieAnimationView, int i, Ranges2 ranges2) {
        Intrinsics3.checkNotNullParameter(lottieAnimationView, "animationView");
        Intrinsics3.checkNotNullParameter(ranges2, "loopFrames");
        this.animationView = lottieAnimationView;
        this.triggerFrame = i;
        this.loopFrames = ranges2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        if (this.animationView.getFrame() >= this.triggerFrame) {
            LottieAnimationView lottieAnimationView = this.animationView;
            lottieAnimationView.p.p(this.loopFrames.getFirst(), this.loopFrames.getLast());
            this.animationView.p.l.j.remove(this);
        }
    }
}
