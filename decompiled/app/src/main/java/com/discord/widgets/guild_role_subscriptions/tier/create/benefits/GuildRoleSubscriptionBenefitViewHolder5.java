package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder$configure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitViewHolder5 implements View.OnClickListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder this$0;

    public GuildRoleSubscriptionBenefitViewHolder5(GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder freeTrialViewHolder) {
        this.this$0 = freeTrialViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        GuildRoleSubscriptionBenefitAdapter.Listener listenerAccess$getListener$p = GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder.access$getListener$p(this.this$0);
        Intrinsics3.checkNotNullExpressionValue(GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder.access$getBinding$p(this.this$0).e, "binding.guildRoleSubscriptionFreeTrialEnableToggle");
        listenerAccess$getListener$p.onFreeTrialToggle(!r0.isChecked());
    }
}
