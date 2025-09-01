package com.discord.widgets.hubs;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetHubDescriptionViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/hubs/HubDescriptionState;", "invoke", "()Lcom/discord/widgets/hubs/HubDescriptionState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubDescriptionViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubDescriptionViewModel4 extends Lambda implements Function0<WidgetHubDescriptionViewModel3> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $guildStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescriptionViewModel4(StoreChannels storeChannels, long j, StoreGuilds storeGuilds, long j2) {
        super(0);
        this.$channelStore = storeChannels;
        this.$channelId = j;
        this.$guildStore = storeGuilds;
        this.$guildId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubDescriptionViewModel3 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubDescriptionViewModel3 invoke() {
        Channel channel = this.$channelStore.getChannel(this.$channelId);
        Guild guild = this.$guildStore.getGuild(this.$guildId);
        String name = guild != null ? guild.getName() : null;
        if (name == null) {
            name = "";
        }
        return new WidgetHubDescriptionViewModel3(channel, null, name, null, 10, null);
    }
}
