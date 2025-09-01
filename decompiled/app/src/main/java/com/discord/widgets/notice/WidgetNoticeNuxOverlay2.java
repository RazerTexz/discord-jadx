package com.discord.widgets.notice;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetNoticeNuxOverlay.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "it", "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.notice.WidgetNoticeNuxOverlay$Companion$enqueue$notice$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetNoticeNuxOverlay2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public static final WidgetNoticeNuxOverlay2 INSTANCE = new WidgetNoticeNuxOverlay2();

    public WidgetNoticeNuxOverlay2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "it");
        WidgetNoticeNuxOverlay widgetNoticeNuxOverlay = new WidgetNoticeNuxOverlay();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "it.supportFragmentManager");
        widgetNoticeNuxOverlay.show(supportFragmentManager, Reflection2.getOrCreateKotlinClass(WidgetNoticeNuxOverlay.class).toString());
        AnalyticsTracker.openModal$default("Mobile Voice Overlay Upsell", "", null, 4, null);
        return true;
    }
}
