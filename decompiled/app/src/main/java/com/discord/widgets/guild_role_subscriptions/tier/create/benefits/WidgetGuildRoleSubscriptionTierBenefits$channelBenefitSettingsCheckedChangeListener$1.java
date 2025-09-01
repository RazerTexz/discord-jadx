package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.widget.RadioGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "checkedId", "", "onCheckedChanged", "(Landroid/widget/RadioGroup;I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$channelBenefitSettingsCheckedChangeListener$1 implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    public WidgetGuildRoleSubscriptionTierBenefits$channelBenefitSettingsCheckedChangeListener$1(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        MaterialRadioButton materialRadioButton = WidgetGuildRoleSubscriptionTierBenefits.access$getBinding$p(this.this$0).f2439b;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionTierAllChannels");
        if (i == materialRadioButton.getId()) {
            WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0).setCanAccessAllChannels(true);
            return;
        }
        MaterialRadioButton materialRadioButton2 = WidgetGuildRoleSubscriptionTierBenefits.access$getBinding$p(this.this$0).g;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.guildRoleSubscriptionTierManualChannels");
        if (i == materialRadioButton2.getId()) {
            WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0).setCanAccessAllChannels(false);
        }
    }
}
