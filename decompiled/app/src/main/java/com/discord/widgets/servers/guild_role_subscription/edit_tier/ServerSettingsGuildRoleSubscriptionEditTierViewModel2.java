package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;

/* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00020\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/Pair;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData;", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "invoke", "()Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionEditTierViewModel2 extends Lambda implements Function0<Tuples2<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $guildRoleSubscriptionTierListingId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionEditTierViewModel2(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, StoreChannels storeChannels, StoreGuilds storeGuilds, long j2) {
        super(0);
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$storeChannels = storeChannels;
        this.$storeGuilds = storeGuilds;
        this.$guildRoleSubscriptionTierListingId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Tuples2<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Tuples2<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>> invoke2() {
        StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionState = this.$storeGuildRoleSubscriptions.getGuildRoleSubscriptionState(this.$guildId);
        return new Tuples2<>(new ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData(guildRoleSubscriptionState, this.$storeGuilds.getRoles().get(Long.valueOf(this.$guildId)), this.$storeGuildRoleSubscriptions.getGuildRoleSubscriptionFreeTrialForListing(this.$guildId, this.$guildRoleSubscriptionTierListingId)), this.$storeChannels.getChannelsForGuild(this.$guildId));
    }
}
