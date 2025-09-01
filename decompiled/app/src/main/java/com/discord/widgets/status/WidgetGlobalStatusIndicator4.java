package com.discord.widgets.status;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetGlobalStatusIndicator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/status/WidgetGlobalStatusIndicator$connectingVectorReplayCallback$1", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "onAnimationEnd", "(Landroid/graphics/drawable/Drawable;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$connectingVectorReplayCallback$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicator4 extends Animatable2Compat.AnimationCallback {
    public final /* synthetic */ WidgetGlobalStatusIndicator this$0;

    public WidgetGlobalStatusIndicator4(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
        this.this$0 = widgetGlobalStatusIndicator;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        Intrinsics3.checkNotNullParameter(drawable, "drawable");
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatAccess$getConnectingVector$p = WidgetGlobalStatusIndicator.access$getConnectingVector$p(this.this$0);
        if (animatedVectorDrawableCompatAccess$getConnectingVector$p != null) {
            animatedVectorDrawableCompatAccess$getConnectingVector$p.start();
        }
    }
}
