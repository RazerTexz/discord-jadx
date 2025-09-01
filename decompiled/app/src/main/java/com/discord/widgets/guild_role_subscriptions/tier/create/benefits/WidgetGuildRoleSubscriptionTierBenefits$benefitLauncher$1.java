package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;", "existingChannelBenefit", "newChannelBenefit", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$benefitLauncher$1 extends Lambda implements Function2<Benefit, Benefit, Unit> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$benefitLauncher$1(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        super(2);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Benefit benefit, Benefit benefit2) {
        invoke2(benefit, benefit2);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Benefit benefit, Benefit benefit2) {
        WidgetGuildRoleSubscriptionTierBenefits.access$getViewModel$p(this.this$0).updateBenefit(benefit, benefit2);
    }
}
