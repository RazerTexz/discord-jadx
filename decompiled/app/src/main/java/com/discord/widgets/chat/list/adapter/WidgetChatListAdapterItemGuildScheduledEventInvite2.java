package com.discord.widgets.chat.list.adapter;

import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite;
import com.discord.widgets.chat.list.entries.GuildScheduledEventInviteEntry;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model;", "invoke", "()Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion$observe$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildScheduledEventInvite2 extends Lambda implements Function0<WidgetChatListAdapterItemGuildScheduledEventInvite.Model> {
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventStore;
    public final /* synthetic */ StoreGuilds $guildStore;
    public final /* synthetic */ GuildScheduledEventInviteEntry $item;
    public final /* synthetic */ StorePermissions $permissionStore;
    public final /* synthetic */ StoreUser $userStore;
    public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildScheduledEventInvite2(GuildScheduledEventInviteEntry guildScheduledEventInviteEntry, StoreGuilds storeGuilds, StoreUser storeUser, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions) {
        super(0);
        this.$item = guildScheduledEventInviteEntry;
        this.$guildStore = storeGuilds;
        this.$userStore = storeUser;
        this.$guildScheduledEventStore = storeGuildScheduledEvents;
        this.$channelStore = storeChannels;
        this.$voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.$permissionStore = storePermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite.Model invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChatListAdapterItemGuildScheduledEventInvite.Model invoke() {
        Channel channelA;
        GuildScheduledEvent guildScheduledEvent = this.$item.getGuildScheduledEvent();
        Channel channel = this.$item.getInvite().getChannel();
        Guild guild = null;
        if (channel != null) {
            com.discord.api.guild.Guild guild2 = this.$item.getInvite().guild;
            channelA = Channel.a(channel, null, 0, guild2 != null ? guild2.getId() : 0L, null, 0L, 0L, 0L, null, null, 0, null, 0, 0, null, 0L, 0L, null, false, 0L, null, 0, null, null, null, null, null, null, null, null, null, null, null, -5);
        } else {
            channelA = null;
        }
        UserGuildMember creatorUserGuildMember$default = GuildScheduledEventUtilities5.getCreatorUserGuildMember$default(guildScheduledEvent, (StoreGuilds) null, (StoreUser) null, 3, (Object) null);
        ModelInvite invite = this.$item.getInvite();
        boolean z2 = this.$guildStore.getMember(this.$item.getGuildScheduledEvent().getGuildId(), this.$userStore.getMeSnapshot().getId()) != null;
        boolean zIsMeRsvpedToEvent = this.$guildScheduledEventStore.isMeRsvpedToEvent(this.$item.getGuildScheduledEvent().getGuildId(), this.$item.getGuildScheduledEvent().getId());
        Channel channel2 = channelA != null ? this.$channelStore.getChannel(channelA.getId()) : null;
        Guild guild3 = this.$guildStore.getGuild(this.$item.getGuildScheduledEvent().getGuildId());
        if (guild3 != null) {
            guild = guild3;
        } else {
            com.discord.api.guild.Guild guild4 = this.$item.getInvite().guild;
            if (guild4 != null) {
                Intrinsics3.checkNotNullExpressionValue(guild4, "apiGuild");
                guild = new Guild(guild4);
            }
        }
        return new WidgetChatListAdapterItemGuildScheduledEventInvite.Model(invite, z2, zIsMeRsvpedToEvent, guildScheduledEvent, channel2, guild, creatorUserGuildMember$default, Long.valueOf(this.$voiceChannelSelectedStore.getSelectedVoiceChannelId()), channelA != null ? PermissionUtils.can(Permission.CONNECT, this.$permissionStore.getPermissionsByChannel().get(Long.valueOf(channelA.getId()))) : false, GuildScheduledEventUtilities.Companion.canShareEvent$default(GuildScheduledEventUtilities.INSTANCE, this.$item.getGuildScheduledEvent().getChannelId(), this.$item.getGuildScheduledEvent().getGuildId(), this.$channelStore, this.$guildStore, null, null, 48, null));
    }
}
