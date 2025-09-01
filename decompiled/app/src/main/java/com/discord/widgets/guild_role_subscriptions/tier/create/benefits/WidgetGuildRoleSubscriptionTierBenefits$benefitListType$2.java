package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import d0.z.d.Lambda;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitListType;", "invoke", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitListType;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits$benefitListType$2 extends Lambda implements Function0<GuildRoleSubscriptionTierBenefitListType> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefits$benefitListType$2(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefits;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildRoleSubscriptionTierBenefitListType invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionTierBenefitListType invoke() {
        Serializable serializable = this.this$0.requireArguments().getSerializable(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE);
        if (!(serializable instanceof GuildRoleSubscriptionTierBenefitListType)) {
            serializable = null;
        }
        GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType = (GuildRoleSubscriptionTierBenefitListType) serializable;
        return guildRoleSubscriptionTierBenefitListType != null ? guildRoleSubscriptionTierBenefitListType : GuildRoleSubscriptionTierBenefitListType.ALL;
    }
}
