package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import androidx.fragment.app.FragmentManager;
import com.discord.R;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet3;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"com/discord/widgets/guild_role_subscriptions/tier/create/benefits/WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapter$Listener;", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem;", "benefitAdapterItem", "", "onBenefitItemClick", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem;)V", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem;", "onAddBenefitItemClick", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem;)V", "", "isEnabled", "onFreeTrialToggle", "(Z)V", "onActiveTrialUserLimitClick", "()V", "onTrialIntervalClick", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 implements GuildRoleSubscriptionBenefitAdapter.Listener {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    public WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onActiveTrialUserLimitClick() {
        WidgetRadioSelectorBottomSheet.Companion companion = WidgetRadioSelectorBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = this.this$0.requireContext().getString(R.string.guild_role_subscription_setup_tier_active_trial_user_limit_title);
        Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getStri…e_trial_user_limit_title)");
        companion.show(parentFragmentManager, new WidgetRadioSelectorBottomSheet3(string, (List) WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitsViewModel$p(this.this$0).withViewState(new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1(this))), new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$2(this));
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onAddBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem benefitAdapterItem) {
        Intrinsics3.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        WidgetGuildRoleSubscriptionTierBenefit.Companion.launch$default(WidgetGuildRoleSubscriptionTierBenefit.INSTANCE, this.this$0.requireContext(), WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitLauncher$p(this.this$0), WidgetGuildRoleSubscriptionTierBenefits.access$getGuildId$p(this.this$0), benefitAdapterItem.getType(), benefitAdapterItem.getTierName(), null, 32, null);
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
        Intrinsics3.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
        if (benefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.BenefitItem) {
            GuildRoleSubscriptionBenefitAdapterItem.BenefitItem benefitItem = (GuildRoleSubscriptionBenefitAdapterItem.BenefitItem) benefitAdapterItem;
            WidgetGuildRoleSubscriptionTierBenefit.INSTANCE.launch(this.this$0.requireContext(), WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitLauncher$p(this.this$0), WidgetGuildRoleSubscriptionTierBenefits.access$getGuildId$p(this.this$0), benefitItem.getType(), benefitItem.getTierName(), benefitItem.getBenefit());
        }
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onFreeTrialToggle(boolean isEnabled) {
        if (isEnabled) {
            WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitsViewModel$p(this.this$0).withViewState(new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onFreeTrialToggle$1(this));
        } else {
            WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0).updateFreeTrialInterval(null);
        }
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter.Listener
    public void onTrialIntervalClick() {
        WidgetRadioSelectorBottomSheet.Companion companion = WidgetRadioSelectorBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = this.this$0.requireContext().getString(R.string.guild_role_subscription_setup_free_trial_time_limit_title);
        Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getStri…e_trial_time_limit_title)");
        companion.show(parentFragmentManager, new WidgetRadioSelectorBottomSheet3(string, (List) WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitsViewModel$p(this.this$0).withViewState(new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$1(this))), new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onTrialIntervalClick$2(this));
    }
}
