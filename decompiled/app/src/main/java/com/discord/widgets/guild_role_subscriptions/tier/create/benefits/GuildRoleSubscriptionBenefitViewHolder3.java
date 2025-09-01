package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder;
import kotlin.Metadata;

/* compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/guild_role_subscriptions/tier/create/benefits/GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$$special$$inlined$apply$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$$inlined$apply$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder3 implements View.OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem $data$inlined;
    public final /* synthetic */ GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder this$0;

    public GuildRoleSubscriptionBenefitViewHolder3(GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder freeTrialViewHolder, GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem freeTrialItem) {
        this.this$0 = freeTrialViewHolder;
        this.$data$inlined = freeTrialItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder.access$getListener$p(this.this$0).onTrialIntervalClick();
    }
}
