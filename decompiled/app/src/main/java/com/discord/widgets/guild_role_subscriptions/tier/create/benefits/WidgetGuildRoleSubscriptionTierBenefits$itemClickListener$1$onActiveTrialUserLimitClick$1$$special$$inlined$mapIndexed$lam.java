package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.R;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;", "guildRoleSubscriptionTierViewModelState", "Lcom/discord/widgets/hubs/RadioSelectorItem;", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionTierViewModel$ViewState;)Lcom/discord/widgets/hubs/RadioSelectorItem;", "com/discord/widgets/guild_role_subscriptions/tier/create/benefits/WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1$$special$$inlined$mapIndexed$lambda$1 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, WidgetRadioSelectorBottomSheet2> {
    public final /* synthetic */ int $index;
    public final /* synthetic */ Integer $limitOption;
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1$$special$$inlined$mapIndexed$lambda$1(int i, Integer num, WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1 widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1) {
        super(1);
        this.$index = i;
        this.$limitOption = num;
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits$itemClickListener$1$onActiveTrialUserLimitClick$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetRadioSelectorBottomSheet2 invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        return invoke2(viewState);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetRadioSelectorBottomSheet2 invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        String string;
        Intrinsics3.checkNotNullParameter(viewState, "guildRoleSubscriptionTierViewModelState");
        int i = this.$index;
        Integer num = this.$limitOption;
        if (num == null || (string = String.valueOf(num.intValue())) == null) {
            string = this.this$0.this$0.this$0.getString(R.string.guild_role_subscription_setup_tier_active_trial_user_limit_none_option);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(\n             …                        )");
        }
        return new WidgetRadioSelectorBottomSheet2(i, string, Intrinsics3.areEqual(this.$limitOption, viewState.getGuildRoleSubscriptionTier().getActiveTrialUserLimit()));
    }
}
