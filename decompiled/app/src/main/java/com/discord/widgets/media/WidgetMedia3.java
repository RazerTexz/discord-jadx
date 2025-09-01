package com.discord.widgets.media;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetMedia.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/discord/widgets/media/WidgetMedia$configureAndStartControlsAnimation$1$2", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "(Landroid/animation/Animator;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.media.WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetMedia3 extends AnimatorListenerAdapter {
    public final /* synthetic */ WidgetMedia this$0;

    public WidgetMedia3(WidgetMedia widgetMedia) {
        this.this$0 = widgetMedia;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics3.checkNotNullParameter(animation, "animation");
        WidgetMedia.access$setControlsAnimationAction$p(this.this$0, null);
    }
}
