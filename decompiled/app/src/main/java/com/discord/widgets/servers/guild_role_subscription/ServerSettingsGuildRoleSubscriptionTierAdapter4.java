package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter2;
import kotlin.Metadata;

/* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.TierViewHolder$TierItemViewHolder$configureUI$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierAdapter4 implements View.OnClickListener {
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener $itemClickListener;
    public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier $tierAdapterItem;

    public ServerSettingsGuildRoleSubscriptionTierAdapter4(ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener, ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier tier) {
        this.$itemClickListener = itemClickListener;
        this.$tierAdapterItem = tier;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$itemClickListener.onTierItemClick(this.$tierAdapterItem.getTierListingId());
    }
}
