package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: GuildRoleSubscriptionBenefitListItemGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001as\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00002\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit$ChannelBenefit;", "channelBenefits", "Lcom/discord/widgets/guild_role_subscriptions/tier/model/Benefit$IntangibleBenefit;", "intangibleBenefits", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitListType;", "benefitListType", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "tierName", "", "canAccessAllChannels", "includeTrials", "Lcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;", "trialInterval", "", "activeTrialUserLimit", "Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitAdapterItem;", "generateGuildRoleSubscriptionBenefitListItems", "(Ljava/util/List;Ljava/util/List;Lcom/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionTierBenefitListType;JLjava/lang/String;Ljava/lang/Boolean;ZLcom/discord/api/guildrolesubscription/SubscriptionTrialInterval;Ljava/lang/Integer;)Ljava/util/List;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitListItemGeneratorKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitListItemGenerator {
    public static final List<GuildRoleSubscriptionBenefitAdapterItem> generateGuildRoleSubscriptionBenefitListItems(List<Benefit.ChannelBenefit> list, List<Benefit.IntangibleBenefit> list2, GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType, long j, String str, Boolean bool, boolean z2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num) {
        Intrinsics3.checkNotNullParameter(list, "channelBenefits");
        Intrinsics3.checkNotNullParameter(list2, "intangibleBenefits");
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierBenefitListType, "benefitListType");
        ArrayList arrayList = new ArrayList();
        if ((!Intrinsics3.areEqual(bool, Boolean.TRUE)) && (guildRoleSubscriptionTierBenefitListType == GuildRoleSubscriptionTierBenefitListType.ALL || guildRoleSubscriptionTierBenefitListType == GuildRoleSubscriptionTierBenefitListType.CHANNEL)) {
            arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.Header(GuildRoleSubscriptionBenefitType.CHANNEL));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.BenefitItem(GuildRoleSubscriptionBenefitType.CHANNEL, (Benefit.ChannelBenefit) it.next(), j, str));
            }
            arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem(GuildRoleSubscriptionBenefitType.CHANNEL, j, str));
        }
        if (guildRoleSubscriptionTierBenefitListType == GuildRoleSubscriptionTierBenefitListType.ALL || guildRoleSubscriptionTierBenefitListType == GuildRoleSubscriptionTierBenefitListType.INTANGIBLE) {
            arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.Header(GuildRoleSubscriptionBenefitType.INTANGIBLE));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.BenefitItem(GuildRoleSubscriptionBenefitType.INTANGIBLE, (Benefit.IntangibleBenefit) it2.next(), j, str));
            }
            arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem(GuildRoleSubscriptionBenefitType.INTANGIBLE, j, str));
        }
        if (z2) {
            arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem(subscriptionTrialInterval != null, subscriptionTrialInterval, num));
        }
        return arrayList;
    }
}
