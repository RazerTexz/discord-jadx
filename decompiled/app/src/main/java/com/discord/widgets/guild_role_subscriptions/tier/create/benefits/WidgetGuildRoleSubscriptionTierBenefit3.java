package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import d0.z.d.Lambda;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "invoke", "()Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionBenefitType;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$benefitType$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit3 extends Lambda implements Function0<GuildRoleSubscriptionBenefitType> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierBenefit3(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierBenefit;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildRoleSubscriptionBenefitType invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionBenefitType invoke() {
        Serializable serializableExtra = this.this$0.getMostRecentIntent().getSerializableExtra("INTENT_EXTRA_BENEFIT_TYPE");
        if (!(serializableExtra instanceof GuildRoleSubscriptionBenefitType)) {
            serializableExtra = null;
        }
        GuildRoleSubscriptionBenefitType guildRoleSubscriptionBenefitType = (GuildRoleSubscriptionBenefitType) serializableExtra;
        return guildRoleSubscriptionBenefitType != null ? guildRoleSubscriptionBenefitType : GuildRoleSubscriptionBenefitType.UNKNOWN;
    }
}
