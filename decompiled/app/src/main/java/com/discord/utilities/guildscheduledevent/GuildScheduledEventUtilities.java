package com.discord.utilities.guildscheduledevent;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventUrlUtils;
import com.discord.widgets.voice.model.CallModel;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: GuildScheduledEventUtilities.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/discord/utilities/guildscheduledevent/GuildScheduledEventUtilities;", "", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildScheduledEventUtilities {
    public static final String ANALYTICS_SOURCE = "Guild Events";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String QUERY_PARAM_NAME = "event";

    /* compiled from: GuildScheduledEventUtilities.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b:\u0010;J5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0013\u001a\u00020\u00102\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014JQ\u0010\u001b\u001a\u00020\u00102\u000e\u0010\u0016\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00152\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u00102\u000e\u0010\u0016\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ=\u0010\u001f\u001a\u00020\u00102\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u000e\u0010\u0016\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010 J%\u0010$\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\n2\u000e\u0010#\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\"¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020\u00102\u000e\u0010&\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\"¢\u0006\u0004\b'\u0010\u001eJ1\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010)\u001a\u00020(2\u000e\u0010*\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\"2\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b,\u0010-J?\u00104\u001a\u0002032\u0006\u0010.\u001a\u00020\u00102\u0006\u00100\u001a\u00020/2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010!\u001a\u0004\u0018\u00010\n2\n\u00102\u001a\u00060\u0002j\u0002`1¢\u0006\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u0002068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u00108¨\u0006<"}, d2 = {"Lcom/discord/utilities/guildscheduledevent/GuildScheduledEventUtilities$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "", "Lcom/discord/api/channel/Channel;", "getGuildScheduledEventCreatableChannelsForGuild", "(JLcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;)Ljava/util/List;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lrx/Observable;", "", "observeCanCreateAnyEvent", "(JLcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;)Lrx/Observable;", "canCreateAnyEvent", "(JLcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;)Z", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreUser;", "usersStore", "canShareEvent", "(Ljava/lang/Long;JLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StorePermissions;)Z", "isEventViewableByEveryone", "(Ljava/lang/Long;)Z", "canStartEvent", "(JLjava/lang/Long;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;)Z", "channel", "Lcom/discord/api/permission/PermissionBit;", "channelPermissions", "canStartEventInChannel", "(Lcom/discord/api/channel/Channel;Ljava/lang/Long;)Z", "guildPermissions", "canCreateExternalEvent", "Lcom/discord/widgets/voice/model/CallModel;", "callModel", "myPermissions", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getGuildScheduledEventToEndForCall", "(Lcom/discord/widgets/voice/model/CallModel;Ljava/lang/Long;Lcom/discord/stores/StoreGuilds;)Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "canShare", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/discord/primitives/GuildScheduledEventId;", "guildEventId", "", "launchInvite", "(ZLandroidx/fragment/app/Fragment;JLcom/discord/api/channel/Channel;J)V", "", "ANALYTICS_SOURCE", "Ljava/lang/String;", "QUERY_PARAM_NAME", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ boolean canCreateAnyEvent$default(Companion companion, long j, StoreChannels storeChannels, StorePermissions storePermissions, int i, Object obj) {
            if ((i & 2) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            if ((i & 4) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            return companion.canCreateAnyEvent(j, storeChannels, storePermissions);
        }

        public static /* synthetic */ boolean canShareEvent$default(Companion companion, Long l, long j, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions, int i, Object obj) {
            return companion.canShareEvent(l, j, (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 16) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 32) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions);
        }

        public static /* synthetic */ boolean canStartEvent$default(Companion companion, long j, Long l, StoreChannels storeChannels, StorePermissions storePermissions, int i, Object obj) {
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            return companion.canStartEvent(j, l, storeChannels2, storePermissions);
        }

        private final List<Channel> getGuildScheduledEventCreatableChannelsForGuild(long guildId, StoreChannels channelsStore, StorePermissions permissionsStore) {
            Map<Long, Channel> channelsForGuild = channelsStore.getChannelsForGuild(guildId);
            Map<Long, Long> permissionsByChannel = permissionsStore.getPermissionsByChannel();
            Collection<Channel> collectionValues = channelsForGuild.values();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                Channel channel = (Channel) obj;
                if (GuildScheduledEventUtilities.INSTANCE.canStartEventInChannel(channel, (Long) outline.d(channel, permissionsByChannel))) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }

        public static /* synthetic */ List getGuildScheduledEventCreatableChannelsForGuild$default(Companion companion, long j, StoreChannels storeChannels, StorePermissions storePermissions, int i, Object obj) {
            if ((i & 2) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            if ((i & 4) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            return companion.getGuildScheduledEventCreatableChannelsForGuild(j, storeChannels, storePermissions);
        }

        public static /* synthetic */ GuildScheduledEvent getGuildScheduledEventToEndForCall$default(Companion companion, CallModel callModel, Long l, StoreGuilds storeGuilds, int i, Object obj) {
            if ((i & 4) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            return companion.getGuildScheduledEventToEndForCall(callModel, l, storeGuilds);
        }

        public static /* synthetic */ Observable observeCanCreateAnyEvent$default(Companion companion, long j, ObservationDeck observationDeck, StoreChannels storeChannels, StorePermissions storePermissions, int i, Object obj) {
            if ((i & 2) != 0) {
                observationDeck = ObservationDeck4.get();
            }
            ObservationDeck observationDeck2 = observationDeck;
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            return companion.observeCanCreateAnyEvent(j, observationDeck2, storeChannels2, storePermissions);
        }

        public final boolean canCreateAnyEvent(long guildId, StoreChannels channelsStore, StorePermissions permissionsStore) {
            Intrinsics3.checkNotNullParameter(channelsStore, "channelsStore");
            Intrinsics3.checkNotNullParameter(permissionsStore, "permissionsStore");
            Long l = permissionsStore.getGuildPermissions().get(Long.valueOf(guildId));
            if (l == null) {
                return false;
            }
            if (PermissionUtils.can(Permission.MANAGE_EVENTS, Long.valueOf(l.longValue()))) {
                return true;
            }
            return !getGuildScheduledEventCreatableChannelsForGuild(guildId, channelsStore, permissionsStore).isEmpty();
        }

        public final boolean canCreateExternalEvent(Long guildPermissions) {
            return PermissionUtils.can(Permission.MANAGE_EVENTS, guildPermissions);
        }

        public final boolean canShareEvent(Long channelId, long guildId, StoreChannels channelsStore, StoreGuilds guildsStore, StoreUser usersStore, StorePermissions permissionsStore) {
            GuildMember member;
            Intrinsics3.checkNotNullParameter(channelsStore, "channelsStore");
            Intrinsics3.checkNotNullParameter(guildsStore, "guildsStore");
            Intrinsics3.checkNotNullParameter(usersStore, "usersStore");
            Intrinsics3.checkNotNullParameter(permissionsStore, "permissionsStore");
            if (channelId == null) {
                return PermissionUtils.can(1L, permissionsStore.getGuildPermissions().get(Long.valueOf(guildId)));
            }
            Channel channel = channelsStore.getChannel(channelId.longValue());
            if (channel == null || !PermissionUtils.can(1L, permissionsStore.getPermissionsByChannel().get(channelId))) {
                return false;
            }
            PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
            Map<Long, GuildRole> mapEmptyMap = (Map) outline.c(channel, guildsStore.getRoles());
            if (mapEmptyMap == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            return (!permissionUtils.canEveryoneRole(Permission.VIEW_CHANNEL, channel, mapEmptyMap) || (member = guildsStore.getMember(channel.getGuildId(), usersStore.getMeSnapshot().getId())) == null || member.getPending()) ? false : true;
        }

        public final boolean canStartEvent(long guildId, Long channelId, StoreChannels channelsStore, StorePermissions permissionsStore) {
            Intrinsics3.checkNotNullParameter(channelsStore, "channelsStore");
            Intrinsics3.checkNotNullParameter(permissionsStore, "permissionsStore");
            if (channelId == null) {
                Long l = permissionsStore.getGuildPermissions().get(Long.valueOf(guildId));
                if (l != null) {
                    return PermissionUtils.can(Permission.MANAGE_EVENTS, Long.valueOf(l.longValue()));
                }
                return false;
            }
            Channel channel = channelsStore.getChannel(channelId.longValue());
            Long l2 = permissionsStore.getPermissionsByChannel().get(channelId);
            if (channel == null) {
                return false;
            }
            return canStartEventInChannel(channel, l2);
        }

        public final boolean canStartEventInChannel(Channel channel, Long channelPermissions) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            if (!PermissionUtils.can(8589935616L, channelPermissions)) {
                return false;
            }
            if (ChannelUtils.D(channel)) {
                return PermissionUtils.can(Permission.START_STAGE_EVENT, channelPermissions);
            }
            if (ChannelUtils.J(channel)) {
                return PermissionUtils.can(Permission.START_VOICE_EVENT, channelPermissions);
            }
            return false;
        }

        public final GuildScheduledEvent getGuildScheduledEventToEndForCall(CallModel callModel, Long myPermissions, StoreGuilds guildsStore) {
            GuildScheduledEvent liveEvent;
            Intrinsics3.checkNotNullParameter(callModel, "callModel");
            Intrinsics3.checkNotNullParameter(guildsStore, "guildsStore");
            Channel channel = callModel.getChannel();
            Guild guild = guildsStore.getGuild(channel.getGuildId());
            if (guild == null || (liveEvent = GuildScheduledEventUtilities5.getLiveEvent(callModel.getGuildScheduledEvents())) == null || !canStartEventInChannel(channel, myPermissions)) {
                return null;
            }
            Map map = (Map) outline.e(guild, guildsStore.getRoles());
            for (Map.Entry<Long, StoreVoiceParticipants.VoiceUser> entry : callModel.getParticipants().entrySet()) {
                long jLongValue = entry.getKey().longValue();
                if (!entry.getValue().isMe() && !canStartEventInChannel(channel, Long.valueOf(PermissionUtils.computeNonThreadPermissions(jLongValue, guild.getId(), guild.getOwnerId(), entry.getValue().getGuildMember(), map, channel.v())))) {
                    return null;
                }
            }
            return liveEvent;
        }

        public final boolean isEventViewableByEveryone(Long channelId) {
            if (channelId == null) {
                return true;
            }
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Channel channel = companion.getChannels().getChannel(channelId.longValue());
            if (channel != null) {
                PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
                Map<Long, GuildRole> mapEmptyMap = (Map) outline.c(channel, companion.getGuilds().getRoles());
                if (mapEmptyMap == null) {
                    mapEmptyMap = Maps6.emptyMap();
                }
                if (permissionUtils.canEveryoneRole(Permission.VIEW_CHANNEL, channel, mapEmptyMap)) {
                    return true;
                }
            }
            return false;
        }

        public final void launchInvite(boolean canShare, Fragment fragment, long guildId, Channel channel, long guildEventId) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            if (canShare) {
                Observable<Channel> observableZ = StoreStream.INSTANCE.getChannels().observeDefaultChannel(guildId).z();
                Intrinsics3.checkNotNullExpressionValue(observableZ, "StoreStream.getChannels(…dId)\n            .first()");
                ObservableExtensionsKt.appSubscribe$default(observableZ, fragment.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GuildScheduledEventUtilities3(fragment, channel, guildEventId), 62, (Object) null);
            } else {
                Context context = fragment.getContext();
                if (context != null) {
                    CharSequence eventDetailsUrl = GuildScheduledEventUrlUtils.INSTANCE.getEventDetailsUrl(guildId, guildEventId);
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    AppToast.c(context, eventDetailsUrl, 0, 4);
                }
            }
        }

        public final Observable<Boolean> observeCanCreateAnyEvent(long guildId, ObservationDeck observationDeck, StoreChannels channelsStore, StorePermissions permissionsStore) {
            Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
            Intrinsics3.checkNotNullParameter(channelsStore, "channelsStore");
            Intrinsics3.checkNotNullParameter(permissionsStore, "permissionsStore");
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{channelsStore, permissionsStore}, false, null, null, new GuildScheduledEventUtilities4(guildId, channelsStore, permissionsStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
