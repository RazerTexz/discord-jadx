package com.discord.widgets.servers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.widgets.servers.WidgetServerSettingsOverview;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetServerSettingsOverview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/servers/WidgetServerSettingsOverview$AfkBottomSheet$onViewCreated$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsOverview$AfkBottomSheet$onViewCreated$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsOverview2 implements View.OnClickListener {
    public final /* synthetic */ CharSequence $afkTimeoutString;
    public final /* synthetic */ int $afkTimeoutValue;
    public final /* synthetic */ WidgetServerSettingsOverview $settingsFrag$inlined;
    public final /* synthetic */ WidgetServerSettingsOverview.AfkBottomSheet this$0;

    public WidgetServerSettingsOverview2(CharSequence charSequence, int i, WidgetServerSettingsOverview.AfkBottomSheet afkBottomSheet, WidgetServerSettingsOverview widgetServerSettingsOverview) {
        this.$afkTimeoutString = charSequence;
        this.$afkTimeoutValue = i;
        this.this$0 = afkBottomSheet;
        this.$settingsFrag$inlined = widgetServerSettingsOverview;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsOverview widgetServerSettingsOverview = this.$settingsFrag$inlined;
        StatefulViews statefulViewsAccess$getState$p = WidgetServerSettingsOverview.access$getState$p(widgetServerSettingsOverview);
        TextView textView = WidgetServerSettingsOverview.access$getBinding$p(widgetServerSettingsOverview).f2582b.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.afk.afkTimeout");
        statefulViewsAccess$getState$p.put(textView.getId(), this.$afkTimeoutString);
        StatefulViews statefulViewsAccess$getState$p2 = WidgetServerSettingsOverview.access$getState$p(widgetServerSettingsOverview);
        LinearLayout linearLayout = WidgetServerSettingsOverview.access$getBinding$p(widgetServerSettingsOverview).f2582b.e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.afk.afkTimeoutWrap");
        statefulViewsAccess$getState$p2.put(linearLayout.getId(), Integer.valueOf(this.$afkTimeoutValue));
        TextView textView2 = WidgetServerSettingsOverview.access$getBinding$p(widgetServerSettingsOverview).f2582b.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.afk.afkTimeout");
        textView2.setText(this.$afkTimeoutString);
        LinearLayout linearLayout2 = WidgetServerSettingsOverview.access$getBinding$p(widgetServerSettingsOverview).f2582b.e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.afk.afkTimeoutWrap");
        linearLayout2.setTag(this.$afkTimeoutString);
        this.this$0.dismiss();
    }
}
