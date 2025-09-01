package com.discord.widgets.media;

import android.animation.ValueAnimator;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: WidgetMedia.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "animator", "", "onAnimationUpdate", "(Landroid/animation/ValueAnimator;)V", "com/discord/widgets/media/WidgetMedia$configureAndStartControlsAnimation$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.media.WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetMedia2 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WidgetMedia this$0;

    public WidgetMedia2(WidgetMedia widgetMedia) {
        this.this$0 = widgetMedia;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics3.checkNotNullExpressionValue(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        AppBarLayout appBarLayout = WidgetMedia.access$getBinding$p(this.this$0).f2486b;
        Intrinsics3.checkNotNullExpressionValue(appBarLayout, "binding.actionBarToolbarLayout");
        appBarLayout.setTranslationY(fFloatValue);
        if (!WidgetMedia.access$isVideo(this.this$0) || WidgetMedia.access$getPlayerControlsHeight$p(this.this$0) <= 0) {
            return;
        }
        PlayerControlView playerControlView = WidgetMedia.access$getBinding$p(this.this$0).f;
        Intrinsics3.checkNotNullExpressionValue(playerControlView, "binding.mediaPlayerControlView");
        playerControlView.setTranslationY((-fFloatValue) / (WidgetMedia.access$getToolbarHeight$p(this.this$0) / WidgetMedia.access$getPlayerControlsHeight$p(this.this$0)));
    }
}
