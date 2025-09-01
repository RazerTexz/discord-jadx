package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/settings/WidgetSettings$onViewBound$1$7", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$4 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettings this$0;

    public WidgetSettings$onViewBound$$inlined$with$lambda$4(WidgetSettings widgetSettings) {
        this.this$0 = widgetSettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SettingsViewModel settingsViewModelAccess$getViewModel$p = WidgetSettings.access$getViewModel$p(this.this$0);
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
        settingsViewModelAccess$getViewModel$p.openRoleSubscriptionsManagement(context);
    }
}
