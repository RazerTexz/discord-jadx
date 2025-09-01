package com.discord.widgets.tabs;

import android.animation.ValueAnimator;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: WidgetTabsHost.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "animator", "", "onAnimationUpdate", "(Landroid/animation/ValueAnimator;)V", "com/discord/widgets/tabs/WidgetTabsHost$updateViews$5$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetTabsHost2 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WidgetTabsHost this$0;

    public WidgetTabsHost2(WidgetTabsHost widgetTabsHost) {
        this.this$0 = widgetTabsHost;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        TabsHostBottomNavigationView tabsHostBottomNavigationView = WidgetTabsHost.access$getBinding$p(this.this$0).f2664b;
        Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationView, "binding.widgetTabsHostBottomNavigationView");
        Intrinsics3.checkNotNullExpressionValue(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        tabsHostBottomNavigationView.setTranslationY(((Float) animatedValue).floatValue());
    }
}
