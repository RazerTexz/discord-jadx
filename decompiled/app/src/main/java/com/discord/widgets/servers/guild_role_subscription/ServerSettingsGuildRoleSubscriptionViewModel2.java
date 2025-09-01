package com.discord.widgets.servers.guild_role_subscription;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils2;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$StoreState;", "invoke", "()Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionViewModel2 extends Lambda implements Function0<ServerSettingsGuildRoleSubscriptionViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildRoleSubscriptions $storeGuildRoleSubscriptions;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionViewModel2(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, long j, StoreGuilds storeGuilds) {
        super(0);
        this.$storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.$guildId = j;
        this.$storeGuilds = storeGuilds;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel.StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsGuildRoleSubscriptionViewModel.StoreState invoke() {
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;
        StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionState = this.$storeGuildRoleSubscriptions.getGuildRoleSubscriptionState(this.$guildId);
        Boolean fullServerGatingOverwrite = null;
        StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded loaded = (StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) (!(guildRoleSubscriptionState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) ? null : guildRoleSubscriptionState);
        if (loaded != null && (guildRoleSubscriptionGroupListing = loaded.getGuildRoleSubscriptionGroupListing()) != null) {
            fullServerGatingOverwrite = GuildRoleSubscriptionUtils2.getFullServerGatingOverwrite(guildRoleSubscriptionGroupListing, this.$storeGuilds.getRoles().get(Long.valueOf(this.$guildId)));
        }
        return new ServerSettingsGuildRoleSubscriptionViewModel.StoreState(guildRoleSubscriptionState, fullServerGatingOverwrite);
    }
}
