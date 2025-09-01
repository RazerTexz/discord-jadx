package com.discord.widgets.servers;

import android.view.View;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import kotlin.Metadata;

/* compiled from: WidgetServerSettingsEditIntegration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/servers/WidgetServerSettingsEditIntegration$setupRadioManager$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$setupRadioManager$$inlined$forEachIndexed$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration2 implements View.OnClickListener {
    public final /* synthetic */ CheckedSetting $checkedSetting;
    public final /* synthetic */ int $index;
    public final /* synthetic */ RadioManager $radioManager$inlined;
    public final /* synthetic */ int $stateKey$inlined;
    public final /* synthetic */ WidgetServerSettingsEditIntegration this$0;

    public WidgetServerSettingsEditIntegration2(CheckedSetting checkedSetting, int i, WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, RadioManager radioManager, int i2) {
        this.$checkedSetting = checkedSetting;
        this.$index = i;
        this.this$0 = widgetServerSettingsEditIntegration;
        this.$radioManager$inlined = radioManager;
        this.$stateKey$inlined = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$radioManager$inlined.a(this.$checkedSetting);
        WidgetServerSettingsEditIntegration.access$getState$p(this.this$0).put(this.$stateKey$inlined, Integer.valueOf(this.$index));
        WidgetServerSettingsEditIntegration.access$getState$p(this.this$0).configureSaveActionView(WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).o);
    }
}
