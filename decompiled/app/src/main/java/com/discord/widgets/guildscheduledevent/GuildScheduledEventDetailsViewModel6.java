package com.discord.widgets.guildscheduledevent;

import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel;
import d0.f0._Sequences2;
import d0.t._Collections;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;

/* compiled from: GuildScheduledEventDetailsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;", "invoke", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventDetailsViewModel6 extends Lambda implements Function0<GuildScheduledEventDetailsViewModel.StoreState> {
    public final /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet2 $args;
    public final /* synthetic */ StoreChannels $channelsStore;
    public final /* synthetic */ StoreDirectories $directoriesStore;
    public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventsStore;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StorePermissions $permissionsStore;
    public final /* synthetic */ StoreVoiceChannelSelected $selectedVoiceChannelStore;
    public final /* synthetic */ StoreUserSettings $userSettingsStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDetailsViewModel6(WidgetGuildScheduledEventDetailsBottomSheet2 widgetGuildScheduledEventDetailsBottomSheet2, StoreDirectories storeDirectories, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, StoreUserSettings storeUserSettings) {
        super(0);
        this.$args = widgetGuildScheduledEventDetailsBottomSheet2;
        this.$directoriesStore = storeDirectories;
        this.$guildScheduledEventsStore = storeGuildScheduledEvents;
        this.$guildsStore = storeGuilds;
        this.$channelsStore = storeChannels;
        this.$selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.$permissionsStore = storePermissions;
        this.$userSettingsStore = storeUserSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildScheduledEventDetailsViewModel.StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0182  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final GuildScheduledEventDetailsViewModel.StoreState invoke() {
        GuildScheduledEvent guildScheduledEventFindEventFromStore$default;
        GuildScheduledEvent guildScheduledEvent;
        Guild guild;
        List<DirectoryEntryGuild2> listInvoke;
        Object next;
        int iOrdinal = this.$args.getSource().ordinal();
        if (iOrdinal == 0) {
            guildScheduledEventFindEventFromStore$default = StoreGuildScheduledEvents.findEventFromStore$default(this.$guildScheduledEventsStore, this.$args.getEventId(), null, 2, null);
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            Long channelId = this.$args.getChannelId();
            if (channelId != null) {
                RestCallState<List<DirectoryEntryGuild2>> guildScheduledEventsForChannel = this.$directoriesStore.getGuildScheduledEventsForChannel(channelId.longValue());
                if (guildScheduledEventsForChannel == null || (listInvoke = guildScheduledEventsForChannel.invoke()) == null) {
                    guildScheduledEventFindEventFromStore$default = null;
                } else {
                    Iterator<T> it = listInvoke.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (((DirectoryEntryGuild2) next).getGuildScheduledEvent().getId() == this.$args.getEventId()) {
                            break;
                        }
                    }
                    DirectoryEntryGuild2 directoryEntryGuild2 = (DirectoryEntryGuild2) next;
                    if (directoryEntryGuild2 != null) {
                        guildScheduledEventFindEventFromStore$default = directoryEntryGuild2.getGuildScheduledEvent();
                    }
                }
                if (guildScheduledEvent == null) {
                    return new GuildScheduledEventDetailsViewModel.StoreState(null, null, null, null, false, false, false, false, false, null, false, null, false, false, 16383, null);
                }
                int iOrdinal2 = this.$args.getSource().ordinal();
                if (iOrdinal2 == 0) {
                    guild = this.$guildsStore.getGuild(guildScheduledEvent.getGuildId());
                } else {
                    if (iOrdinal2 != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    com.discord.api.guild.Guild guild2 = guildScheduledEvent.getGuild();
                    guild = guild2 != null ? new Guild(guild2) : null;
                }
                boolean z2 = this.$guildsStore.getGuild(guildScheduledEvent.getGuildId()) != null;
                UserGuildMember creatorUserGuildMember$default = z2 ? GuildScheduledEventUtilities5.getCreatorUserGuildMember$default(guildScheduledEvent, (StoreGuilds) null, (StoreUser) null, 3, (Object) null) : null;
                List list = _Sequences2.toList(_Sequences2.map(_Collections.asSequence(this.$guildScheduledEventsStore.getGuildScheduledEventUsers(guildScheduledEvent.getId()).values()), new GuildScheduledEventDetailsViewModel7(guildScheduledEvent)));
                Long channelId2 = guildScheduledEvent.getChannelId();
                Channel channel = channelId2 != null ? this.$channelsStore.getChannel(channelId2.longValue()) : null;
                Long lValueOf = Long.valueOf(this.$selectedVoiceChannelStore.getSelectedVoiceChannelId());
                boolean zIsMeRsvpedToEvent = this.$guildScheduledEventsStore.isMeRsvpedToEvent(guildScheduledEvent.getGuildId(), this.$args.getEventId());
                GuildScheduledEventUtilities.Companion companion = GuildScheduledEventUtilities.INSTANCE;
                boolean zCanShareEvent$default = GuildScheduledEventUtilities.Companion.canShareEvent$default(companion, guildScheduledEvent.getChannelId(), guildScheduledEvent.getGuildId(), this.$channelsStore, this.$guildsStore, null, null, 48, null);
                boolean zCanStartEvent = companion.canStartEvent(guildScheduledEvent.getGuildId(), guildScheduledEvent.getChannelId(), this.$channelsStore, this.$permissionsStore);
                Long channelId3 = guildScheduledEvent.getChannelId();
                return new GuildScheduledEventDetailsViewModel.StoreState(guildScheduledEvent, channel, guild, creatorUserGuildMember$default, z2, zIsMeRsvpedToEvent, zCanShareEvent$default, zCanStartEvent, this.$userSettingsStore.getIsDeveloperMode(), lValueOf, channelId3 != null ? PermissionUtils.can(Permission.CONNECT, this.$permissionsStore.getPermissionsByChannel().get(Long.valueOf(channelId3.longValue()))) : false, list, this.$guildScheduledEventsStore.getIsFetchingGuildScheduledEventUsers(), this.$guildScheduledEventsStore.getIsGuildScheduledEventUsersError());
            }
            guildScheduledEvent = null;
            if (guildScheduledEvent == null) {
            }
        }
        guildScheduledEvent = guildScheduledEventFindEventFromStore$default;
        if (guildScheduledEvent == null) {
        }
    }
}
