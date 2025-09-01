package com.discord.widgets.channels.list;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.directories.DirectoryUtils2;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemActiveEvent;
import com.discord.widgets.channels.list.items.ChannelListItemActiveEvent2;
import com.discord.widgets.channels.list.items.ChannelListItemAddServer;
import com.discord.widgets.channels.list.items.ChannelListItemCategory;
import com.discord.widgets.channels.list.items.ChannelListItemDirectory;
import com.discord.widgets.channels.list.items.ChannelListItemEventsSeparator;
import com.discord.widgets.channels.list.items.ChannelListItemGuildJoinRequest;
import com.discord.widgets.channels.list.items.ChannelListItemGuildRoleSubscriptionsOverview;
import com.discord.widgets.channels.list.items.ChannelListItemGuildScheduledEvents;
import com.discord.widgets.channels.list.items.ChannelListItemInvite;
import com.discord.widgets.channels.list.items.ChannelListItemMfaNotice;
import com.discord.widgets.channels.list.items.ChannelListItemStageAudienceCount;
import com.discord.widgets.channels.list.items.ChannelListItemStageVoiceChannel;
import com.discord.widgets.channels.list.items.ChannelListItemTextChannel;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceChannel;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.model.StageChannel;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MutableCollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetChannelListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0003-./BM\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\u0004\b+\u0010,J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\bJZ\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0013\u0010\"\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b\u0012\u0010\u000bR\u0019\u0010\u0014\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010\u000bR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010\u0004R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b(\u0010\bR\u0019\u0010\u0013\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b)\u0010\u000bR\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b*\u0010\b¨\u00060"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListModel;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "component2", "()Ljava/util/List;", "", "component3", "()Z", "component4", "component5", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component6", "selectedGuild", "items", "isGuildSelected", "showPremiumGuildHint", "showEmptyState", "guildScheduledEvents", "copy", "(Lcom/discord/models/guild/Guild;Ljava/util/List;ZZZLjava/util/List;)Lcom/discord/widgets/channels/list/WidgetChannelListModel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "getStartsWithPaddedElement", "startsWithPaddedElement", "Z", "getShowEmptyState", "Lcom/discord/models/guild/Guild;", "getSelectedGuild", "Ljava/util/List;", "getItems", "getShowPremiumGuildHint", "getGuildScheduledEvents", "<init>", "(Lcom/discord/models/guild/Guild;Ljava/util/List;ZZZLjava/util/List;)V", "Companion", "ThreadSpineType", "VoiceStates", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class WidgetChannelListModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<GuildScheduledEvent> guildScheduledEvents;
    private final boolean isGuildSelected;
    private final List<ChannelListItem> items;
    private final Guild selectedGuild;
    private final boolean showEmptyState;
    private final boolean showPremiumGuildHint;

    /* compiled from: WidgetChannelListModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002?@B\t\b\u0002¢\u0006\u0004\b=\u0010>J\u0081\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u001c\u0010\u000e\u001a\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00042\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u000f0\u00042\n\u0010\u0011\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014JÁ\u0003\u00104\u001a\b\u0012\u0004\u0012\u0002030\t2\n\u0010\u0016\u001a\u00060\u0005j\u0002`\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u000f0\u00042&\u0010\u0019\u001a\"\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00180\u00040\u00042\u0016\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u001a0\u00042\u0010\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0011\u001a\u00060\u0005j\u0002`\u00062\u001c\u0010\u000e\u001a\u0018\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00042\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u00042\u0010\u0010!\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u001c2\u0010\u0010\"\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u001c2\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0016\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020#0\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%2\"\u0010*\u001a\u001e\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\t0(0\u00042\u0016\u0010,\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020+0\u00042\"\u0010.\u001a\u001e\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\t0(0\u00042\b\u00100\u001a\u0004\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0004\b4\u00105J\u0015\u00108\u001a\b\u0012\u0004\u0012\u00020706H\u0002¢\u0006\u0004\b8\u00109J!\u0010:\u001a\b\u0012\u0004\u0012\u000207062\n\u0010\u0016\u001a\u00060\u0005j\u0002`\u0015H\u0002¢\u0006\u0004\b:\u0010;J\u0013\u0010<\u001a\b\u0012\u0004\u0012\u00020706¢\u0006\u0004\b<\u00109¨\u0006A"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListModel$Companion;", "", "Lcom/discord/utilities/channel/GuildChannelsInfo;", "guildChannelsInfo", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/widgets/stage/model/StageChannel;", "stageChannels", "", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvents", "", "Lcom/discord/widgets/channels/list/items/ChannelListItemVoiceUser;", "voiceStates", "Lcom/discord/api/channel/Channel;", "guildChannels", "selectedVoiceChannelId", "Lcom/discord/widgets/channels/list/items/ChannelListItemActiveEventData;", "getChannelEventNoticeData", "(Lcom/discord/utilities/channel/GuildChannelsInfo;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;J)Lcom/discord/widgets/channels/list/items/ChannelListItemActiveEventData;", "Lcom/discord/primitives/GuildId;", "selectedGuildId", "guild", "Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "activeJoinedGuildThreads", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "joinedThreads", "", "channelsWithActiveThreads", "selectedChannel", "", "mentionCounts", "unreadChannelIds", "collapsedCategories", "Lcom/discord/api/stageinstance/StageInstance;", "stageInstances", "", "canCreateAnyEvent", "canSeeGuildRoleSubscriptions", "Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/directory/DirectoryEntryGuild;", "directories", "Lcom/discord/stores/StoreMessageAck$Ack;", "messageAcks", "Lcom/discord/api/directory/DirectoryEntryEvent;", "directoryEvents", "Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "guildJoinRequest", "Lcom/discord/models/member/GuildMember;", "member", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "guildListBuilder", "(JLcom/discord/utilities/channel/GuildChannelsInfo;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Lcom/discord/api/channel/Channel;JLjava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;ZZLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/discord/api/guildjoinrequest/GuildJoinRequest;Lcom/discord/models/member/GuildMember;)Ljava/util/List;", "Lrx/Observable;", "Lcom/discord/widgets/channels/list/WidgetChannelListModel;", "getPrivateChannelList", "()Lrx/Observable;", "getSelectedGuildChannelList", "(J)Lrx/Observable;", "get", "<init>", "()V", "TextLikeChannelData", "VocalChannelData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        /* compiled from: WidgetChannelListModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListModel$Companion$TextLikeChannelData;", "", "", "component1", "()Z", "", "component2", "()I", "component3", "component4", "component5", "selected", "mentionCount", "unread", ModelAuditLogEntry.CHANGE_KEY_LOCKED, "hide", "copy", "(ZIZZZ)Lcom/discord/widgets/channels/list/WidgetChannelListModel$Companion$TextLikeChannelData;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getSelected", "I", "getMentionCount", "getHide", "getUnread", "getLocked", "<init>", "(ZIZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class TextLikeChannelData {
            private final boolean hide;
            private final boolean locked;
            private final int mentionCount;
            private final boolean selected;
            private final boolean unread;

            public TextLikeChannelData(boolean z2, int i, boolean z3, boolean z4, boolean z5) {
                this.selected = z2;
                this.mentionCount = i;
                this.unread = z3;
                this.locked = z4;
                this.hide = z5;
            }

            public static /* synthetic */ TextLikeChannelData copy$default(TextLikeChannelData textLikeChannelData, boolean z2, int i, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    z2 = textLikeChannelData.selected;
                }
                if ((i2 & 2) != 0) {
                    i = textLikeChannelData.mentionCount;
                }
                int i3 = i;
                if ((i2 & 4) != 0) {
                    z3 = textLikeChannelData.unread;
                }
                boolean z6 = z3;
                if ((i2 & 8) != 0) {
                    z4 = textLikeChannelData.locked;
                }
                boolean z7 = z4;
                if ((i2 & 16) != 0) {
                    z5 = textLikeChannelData.hide;
                }
                return textLikeChannelData.copy(z2, i3, z6, z7, z5);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getSelected() {
                return this.selected;
            }

            /* renamed from: component2, reason: from getter */
            public final int getMentionCount() {
                return this.mentionCount;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getUnread() {
                return this.unread;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getLocked() {
                return this.locked;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getHide() {
                return this.hide;
            }

            public final TextLikeChannelData copy(boolean selected, int mentionCount, boolean unread, boolean locked, boolean hide) {
                return new TextLikeChannelData(selected, mentionCount, unread, locked, hide);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TextLikeChannelData)) {
                    return false;
                }
                TextLikeChannelData textLikeChannelData = (TextLikeChannelData) other;
                return this.selected == textLikeChannelData.selected && this.mentionCount == textLikeChannelData.mentionCount && this.unread == textLikeChannelData.unread && this.locked == textLikeChannelData.locked && this.hide == textLikeChannelData.hide;
            }

            public final boolean getHide() {
                return this.hide;
            }

            public final boolean getLocked() {
                return this.locked;
            }

            public final int getMentionCount() {
                return this.mentionCount;
            }

            public final boolean getSelected() {
                return this.selected;
            }

            public final boolean getUnread() {
                return this.unread;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v10 */
            /* JADX WARN: Type inference failed for: r0v11 */
            /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
            /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
            public int hashCode() {
                boolean z2 = this.selected;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = ((r0 * 31) + this.mentionCount) * 31;
                ?? r2 = this.unread;
                int i2 = r2;
                if (r2 != 0) {
                    i2 = 1;
                }
                int i3 = (i + i2) * 31;
                ?? r22 = this.locked;
                int i4 = r22;
                if (r22 != 0) {
                    i4 = 1;
                }
                int i5 = (i3 + i4) * 31;
                boolean z3 = this.hide;
                return i5 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("TextLikeChannelData(selected=");
                sbU.append(this.selected);
                sbU.append(", mentionCount=");
                sbU.append(this.mentionCount);
                sbU.append(", unread=");
                sbU.append(this.unread);
                sbU.append(", locked=");
                sbU.append(this.locked);
                sbU.append(", hide=");
                return outline.O(sbU, this.hide, ")");
            }
        }

        /* compiled from: WidgetChannelListModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u000e\u0010\u0019\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0018\u0010\u000e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J|\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\u0010\b\u0002\u0010\u0019\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\"\u0010\bJ\u001a\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b)\u0010\u0004R!\u0010\u0019\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b+\u0010\u000fR\u0019\u0010\u001a\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b-\u0010\bR\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010&\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b.\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b/\u0010\bR\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b0\u0010\u0004¨\u00063"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListModel$Companion$VocalChannelData;", "", "", "component1", "()Z", "component2", "", "component3", "()I", "component4", "component5", "component6", "", "Lcom/discord/api/permission/PermissionBit;", "component7", "()Ljava/lang/Long;", "component8", "component9", "component10", "voiceChannelSelected", "textChannelSelected", "mentionCount", "unread", ModelAuditLogEntry.CHANGE_KEY_LOCKED, ModelAuditLogEntry.CHANGE_KEY_NSFW, "permission", "numUsersConnected", "isGuildRoleSubscriptionLockedChannel", "isGuildRoleSubscriptionChannel", "copy", "(ZZIZZZLjava/lang/Long;IZZ)Lcom/discord/widgets/channels/list/WidgetChannelListModel$Companion$VocalChannelData;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getNsfw", "getTextChannelSelected", "getLocked", "Ljava/lang/Long;", "getPermission", "I", "getNumUsersConnected", "getVoiceChannelSelected", "getMentionCount", "getUnread", "<init>", "(ZZIZZZLjava/lang/Long;IZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class VocalChannelData {
            private final boolean isGuildRoleSubscriptionChannel;
            private final boolean isGuildRoleSubscriptionLockedChannel;
            private final boolean locked;
            private final int mentionCount;
            private final boolean nsfw;
            private final int numUsersConnected;
            private final Long permission;
            private final boolean textChannelSelected;
            private final boolean unread;
            private final boolean voiceChannelSelected;

            public VocalChannelData(boolean z2, boolean z3, int i, boolean z4, boolean z5, boolean z6, Long l, int i2, boolean z7, boolean z8) {
                this.voiceChannelSelected = z2;
                this.textChannelSelected = z3;
                this.mentionCount = i;
                this.unread = z4;
                this.locked = z5;
                this.nsfw = z6;
                this.permission = l;
                this.numUsersConnected = i2;
                this.isGuildRoleSubscriptionLockedChannel = z7;
                this.isGuildRoleSubscriptionChannel = z8;
            }

            public static /* synthetic */ VocalChannelData copy$default(VocalChannelData vocalChannelData, boolean z2, boolean z3, int i, boolean z4, boolean z5, boolean z6, Long l, int i2, boolean z7, boolean z8, int i3, Object obj) {
                return vocalChannelData.copy((i3 & 1) != 0 ? vocalChannelData.voiceChannelSelected : z2, (i3 & 2) != 0 ? vocalChannelData.textChannelSelected : z3, (i3 & 4) != 0 ? vocalChannelData.mentionCount : i, (i3 & 8) != 0 ? vocalChannelData.unread : z4, (i3 & 16) != 0 ? vocalChannelData.locked : z5, (i3 & 32) != 0 ? vocalChannelData.nsfw : z6, (i3 & 64) != 0 ? vocalChannelData.permission : l, (i3 & 128) != 0 ? vocalChannelData.numUsersConnected : i2, (i3 & 256) != 0 ? vocalChannelData.isGuildRoleSubscriptionLockedChannel : z7, (i3 & 512) != 0 ? vocalChannelData.isGuildRoleSubscriptionChannel : z8);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getVoiceChannelSelected() {
                return this.voiceChannelSelected;
            }

            /* renamed from: component10, reason: from getter */
            public final boolean getIsGuildRoleSubscriptionChannel() {
                return this.isGuildRoleSubscriptionChannel;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getTextChannelSelected() {
                return this.textChannelSelected;
            }

            /* renamed from: component3, reason: from getter */
            public final int getMentionCount() {
                return this.mentionCount;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getUnread() {
                return this.unread;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getLocked() {
                return this.locked;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getNsfw() {
                return this.nsfw;
            }

            /* renamed from: component7, reason: from getter */
            public final Long getPermission() {
                return this.permission;
            }

            /* renamed from: component8, reason: from getter */
            public final int getNumUsersConnected() {
                return this.numUsersConnected;
            }

            /* renamed from: component9, reason: from getter */
            public final boolean getIsGuildRoleSubscriptionLockedChannel() {
                return this.isGuildRoleSubscriptionLockedChannel;
            }

            public final VocalChannelData copy(boolean voiceChannelSelected, boolean textChannelSelected, int mentionCount, boolean unread, boolean locked, boolean nsfw, Long permission, int numUsersConnected, boolean isGuildRoleSubscriptionLockedChannel, boolean isGuildRoleSubscriptionChannel) {
                return new VocalChannelData(voiceChannelSelected, textChannelSelected, mentionCount, unread, locked, nsfw, permission, numUsersConnected, isGuildRoleSubscriptionLockedChannel, isGuildRoleSubscriptionChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof VocalChannelData)) {
                    return false;
                }
                VocalChannelData vocalChannelData = (VocalChannelData) other;
                return this.voiceChannelSelected == vocalChannelData.voiceChannelSelected && this.textChannelSelected == vocalChannelData.textChannelSelected && this.mentionCount == vocalChannelData.mentionCount && this.unread == vocalChannelData.unread && this.locked == vocalChannelData.locked && this.nsfw == vocalChannelData.nsfw && Intrinsics3.areEqual(this.permission, vocalChannelData.permission) && this.numUsersConnected == vocalChannelData.numUsersConnected && this.isGuildRoleSubscriptionLockedChannel == vocalChannelData.isGuildRoleSubscriptionLockedChannel && this.isGuildRoleSubscriptionChannel == vocalChannelData.isGuildRoleSubscriptionChannel;
            }

            public final boolean getLocked() {
                return this.locked;
            }

            public final int getMentionCount() {
                return this.mentionCount;
            }

            public final boolean getNsfw() {
                return this.nsfw;
            }

            public final int getNumUsersConnected() {
                return this.numUsersConnected;
            }

            public final Long getPermission() {
                return this.permission;
            }

            public final boolean getTextChannelSelected() {
                return this.textChannelSelected;
            }

            public final boolean getUnread() {
                return this.unread;
            }

            public final boolean getVoiceChannelSelected() {
                return this.voiceChannelSelected;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v20 */
            /* JADX WARN: Type inference failed for: r0v21 */
            /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
            /* JADX WARN: Type inference failed for: r2v13, types: [boolean] */
            /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
            /* JADX WARN: Type inference failed for: r2v5, types: [boolean] */
            /* JADX WARN: Type inference failed for: r2v7, types: [boolean] */
            public int hashCode() {
                boolean z2 = this.voiceChannelSelected;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                ?? r2 = this.textChannelSelected;
                int i2 = r2;
                if (r2 != 0) {
                    i2 = 1;
                }
                int i3 = (((i + i2) * 31) + this.mentionCount) * 31;
                ?? r22 = this.unread;
                int i4 = r22;
                if (r22 != 0) {
                    i4 = 1;
                }
                int i5 = (i3 + i4) * 31;
                ?? r23 = this.locked;
                int i6 = r23;
                if (r23 != 0) {
                    i6 = 1;
                }
                int i7 = (i5 + i6) * 31;
                ?? r24 = this.nsfw;
                int i8 = r24;
                if (r24 != 0) {
                    i8 = 1;
                }
                int i9 = (i7 + i8) * 31;
                Long l = this.permission;
                int iHashCode = (((i9 + (l != null ? l.hashCode() : 0)) * 31) + this.numUsersConnected) * 31;
                ?? r25 = this.isGuildRoleSubscriptionLockedChannel;
                int i10 = r25;
                if (r25 != 0) {
                    i10 = 1;
                }
                int i11 = (iHashCode + i10) * 31;
                boolean z3 = this.isGuildRoleSubscriptionChannel;
                return i11 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isGuildRoleSubscriptionChannel() {
                return this.isGuildRoleSubscriptionChannel;
            }

            public final boolean isGuildRoleSubscriptionLockedChannel() {
                return this.isGuildRoleSubscriptionLockedChannel;
            }

            public String toString() {
                StringBuilder sbU = outline.U("VocalChannelData(voiceChannelSelected=");
                sbU.append(this.voiceChannelSelected);
                sbU.append(", textChannelSelected=");
                sbU.append(this.textChannelSelected);
                sbU.append(", mentionCount=");
                sbU.append(this.mentionCount);
                sbU.append(", unread=");
                sbU.append(this.unread);
                sbU.append(", locked=");
                sbU.append(this.locked);
                sbU.append(", nsfw=");
                sbU.append(this.nsfw);
                sbU.append(", permission=");
                sbU.append(this.permission);
                sbU.append(", numUsersConnected=");
                sbU.append(this.numUsersConnected);
                sbU.append(", isGuildRoleSubscriptionLockedChannel=");
                sbU.append(this.isGuildRoleSubscriptionLockedChannel);
                sbU.append(", isGuildRoleSubscriptionChannel=");
                return outline.O(sbU, this.isGuildRoleSubscriptionChannel, ")");
            }
        }

        private Companion() {
        }

        public static final /* synthetic */ Observable access$getPrivateChannelList(Companion companion) {
            return companion.getPrivateChannelList();
        }

        public static final /* synthetic */ Observable access$getSelectedGuildChannelList(Companion companion, long j) {
            return companion.getSelectedGuildChannelList(j);
        }

        public static final /* synthetic */ List access$guildListBuilder(Companion companion, long j, GuildChannelsInfo guildChannelsInfo, Map map, Map map2, Map map3, Set set, Channel channel, long j2, Map map4, Map map5, Set set2, Set set3, Map map6, Map map7, List list, boolean z2, boolean z3, Map map8, Map map9, Map map10, GuildJoinRequest guildJoinRequest, GuildMember guildMember) {
            return companion.guildListBuilder(j, guildChannelsInfo, map, map2, map3, set, channel, j2, map4, map5, set2, set3, map6, map7, list, z2, z3, map8, map9, map10, guildJoinRequest, guildMember);
        }

        /* JADX WARN: Removed duplicated region for block: B:111:0x0195 A[EDGE_INSN: B:111:0x0195->B:89:0x0195 BREAK  A[LOOP:3: B:73:0x0163->B:114:?], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:114:? A[LOOP:3: B:73:0x0163->B:114:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0190  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final ChannelListItemActiveEvent2 getChannelEventNoticeData(GuildChannelsInfo guildChannelsInfo, Map<Long, StageChannel> stageChannels, List<GuildScheduledEvent> guildScheduledEvents, Map<Long, ? extends Collection<ChannelListItemVoiceUser>> voiceStates, Map<Long, Channel> guildChannels, long selectedVoiceChannelId) {
            Object next;
            Object next2;
            GuildScheduledEventEntityMetadata entityMetadata;
            String location;
            boolean z2;
            Channel channel;
            List listEmptyList;
            ChannelListItemVoiceUser channelListItemVoiceUser;
            Object next3;
            Channel channel2;
            Long channelId;
            StageChannel stageChannel = (StageChannel) _Sequences2.firstOrNull(_Sequences2.filter(_Collections.asSequence(stageChannels.values()), WidgetChannelListModel$Companion$getChannelEventNoticeData$1.INSTANCE));
            if (stageChannel != null) {
                GuildScheduledEventLocationInfo.ChannelLocation channelLocation = new GuildScheduledEventLocationInfo.ChannelLocation(stageChannel.getChannel());
                int audienceSize = stageChannel.getAudienceSize();
                List<UserGuildMember> speakers = stageChannel.getSpeakers();
                boolean containsMe = stageChannel.getContainsMe();
                StageRoles stageRolesM46getMyRolestwRsX0 = stageChannel.m46getMyRolestwRsX0();
                boolean z3 = stageRolesM46getMyRolestwRsX0 != null && StageRoles.m33isSpeakerimpl(stageRolesM46getMyRolestwRsX0.m35unboximpl());
                StageInstance stageInstance = stageChannel.getStageInstance();
                return new ChannelListItemActiveEvent2(stageInstance != null ? stageInstance.getTopic() : null, channelLocation, audienceSize, speakers, containsMe, z3, null);
            }
            Iterator<T> it = guildScheduledEvents.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
                if (guildScheduledEvent.getStatus() == GuildScheduledEventStatus.ACTIVE && (channel2 = guildChannels.get(guildScheduledEvent.getChannelId())) != null && channel2.getType() == 2 && PermissionUtils.can(Permission.CONNECT, guildChannelsInfo.getChannelPermissions().get(guildScheduledEvent.getChannelId())) && ((channelId = guildScheduledEvent.getChannelId()) == null || channelId.longValue() != selectedVoiceChannelId)) {
                    break;
                }
            }
            GuildScheduledEvent guildScheduledEvent2 = (GuildScheduledEvent) next;
            if (guildScheduledEvent2 != null && (channel = guildChannels.get(guildScheduledEvent2.getChannelId())) != null) {
                Collection<ChannelListItemVoiceUser> collection = voiceStates.get(guildScheduledEvent2.getChannelId());
                if (collection != null) {
                    listEmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
                    for (ChannelListItemVoiceUser channelListItemVoiceUser2 : collection) {
                        listEmptyList.add(new UserGuildMember(channelListItemVoiceUser2.getUser(), channelListItemVoiceUser2.getComputed()));
                    }
                } else {
                    listEmptyList = null;
                }
                long id2 = StoreStream.INSTANCE.getUsers().getMeSnapshot().getId();
                Collection<ChannelListItemVoiceUser> collection2 = voiceStates.get(guildScheduledEvent2.getChannelId());
                if (collection2 != null) {
                    Iterator<T> it2 = collection2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next3 = null;
                            break;
                        }
                        next3 = it2.next();
                        if (((ChannelListItemVoiceUser) next3).getUser().getId() == id2) {
                            break;
                        }
                    }
                    channelListItemVoiceUser = (ChannelListItemVoiceUser) next3;
                } else {
                    channelListItemVoiceUser = null;
                }
                boolean z4 = channelListItemVoiceUser != null;
                if (!z4) {
                    GuildScheduledEventLocationInfo.ChannelLocation channelLocation2 = new GuildScheduledEventLocationInfo.ChannelLocation(channel);
                    if (listEmptyList == null) {
                        listEmptyList = Collections2.emptyList();
                    }
                    return new ChannelListItemActiveEvent2(guildScheduledEvent2.getName(), channelLocation2, 0, listEmptyList, z4, z4, null);
                }
            }
            Iterator<T> it3 = guildScheduledEvents.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it3.next();
                GuildScheduledEvent guildScheduledEvent3 = (GuildScheduledEvent) next2;
                if (guildScheduledEvent3.getStatus() != GuildScheduledEventStatus.ACTIVE || guildScheduledEvent3.getEntityType() != GuildScheduledEventEntityType.EXTERNAL) {
                    z2 = false;
                    if (!z2) {
                        break;
                    }
                } else {
                    GuildScheduledEventEntityMetadata entityMetadata2 = guildScheduledEvent3.getEntityMetadata();
                    if ((entityMetadata2 != null ? entityMetadata2.getLocation() : null) != null) {
                        z2 = true;
                    }
                    if (!z2) {
                    }
                }
            }
            GuildScheduledEvent guildScheduledEvent4 = (GuildScheduledEvent) next2;
            return (guildScheduledEvent4 == null || (entityMetadata = guildScheduledEvent4.getEntityMetadata()) == null || (location = entityMetadata.getLocation()) == null) ? (ChannelListItemActiveEvent2) null : new ChannelListItemActiveEvent2(guildScheduledEvent4.getName(), new GuildScheduledEventLocationInfo.ExternalLocation(location), 0, Collections2.emptyList(), false, false, Long.valueOf(guildScheduledEvent4.getId()));
        }

        private final Observable<WidgetChannelListModel> getPrivateChannelList() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreChannels channels = companion.getChannels();
            StoreChannelsSelected channelsSelected = companion.getChannelsSelected();
            StoreUserPresence presences = companion.getPresences();
            StoreMessagesMostRecent messagesMostRecent = companion.getMessagesMostRecent();
            StoreMentions mentions = companion.getMentions();
            StoreApplicationStreaming applicationStreaming = companion.getApplicationStreaming();
            StoreUserGuildSettings userGuildSettings = companion.getUserGuildSettings();
            StoreExperiments experiments = companion.getExperiments();
            StoreUserConnections userConnections = companion.getUserConnections();
            Observable<WidgetChannelListModel> observableG = ObservableExtensionsKt.leadingEdgeThrottle(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{channels, channelsSelected, presences, messagesMostRecent, mentions, applicationStreaming, userGuildSettings, experiments, userConnections}, false, null, null, 14, null), 250L, TimeUnit.MILLISECONDS).G(new WidgetChannelListModel$Companion$getPrivateChannelList$1(channels, messagesMostRecent, channelsSelected, presences, mentions, applicationStreaming, userGuildSettings, experiments, userConnections));
            Intrinsics3.checkNotNullExpressionValue(observableG, "ObservationDeckProvider\n…            )\n          }");
            return observableG;
        }

        private final Observable<WidgetChannelListModel> getSelectedGuildChannelList(long selectedGuildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            long id2 = companion.getUsers().getMeSnapshot().getId();
            Observable<GuildChannelsInfo> observable = GuildChannelsInfo.INSTANCE.get(selectedGuildId);
            Observable observableObserveChannelsForGuild$default = StoreChannels.observeChannelsForGuild$default(companion.getChannels(), selectedGuildId, null, 2, null);
            Observable<Map<Long, StoreThreadsJoined.JoinedThread>> observableObserveJoinedThreads = companion.getThreadsJoined().observeJoinedThreads();
            Observable<Map<Long, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>>> observableObserveActiveJoinedThreadsForGuild = companion.getThreadsActiveJoined().observeActiveJoinedThreadsForGuild(selectedGuildId);
            Observable<Set<Long>> observableObserveChannelsWithActiveThreadsByGuild = companion.getThreadsActive().observeChannelsWithActiveThreadsByGuild(selectedGuildId);
            Observable<Channel> observableObserveSelectedChannel = companion.getChannelsSelected().observeSelectedChannel();
            Observable<Long> observableObserveSelectedVoiceChannelId = companion.getVoiceChannelSelected().observeSelectedVoiceChannelId();
            Observable observable2 = VoiceStates.get$default(VoiceStates.INSTANCE, selectedGuildId, null, 2, null);
            Observable<Map<Long, Integer>> observableObserveMentionCounts = companion.getMentions().observeMentionCounts();
            Observable<Set<Long>> unreadChannelIds = companion.getReadStates().getUnreadChannelIds();
            Observable<Set<Long>> observableObserveCollapsedCategories = companion.getStoreChannelCategories().observeCollapsedCategories(selectedGuildId);
            Observable<StoreNux.NuxState> nuxState = companion.getNux().getNuxState();
            Observable<Map<Long, StageChannel>> observableObserveGuildStageChannels = companion.getStageChannels().observeGuildStageChannels(selectedGuildId);
            Observable<Map<Long, StageInstance>> observableObserveStageInstancesForGuild = companion.getStageInstances().observeStageInstancesForGuild(selectedGuildId);
            Observable observableObserveGuildScheduledEvents$default = StoreGuildScheduledEvents.observeGuildScheduledEvents$default(companion.getGuildScheduledEvents(), selectedGuildId, false, 2, null);
            Observable observableObserveCanCreateAnyEvent$default = GuildScheduledEventUtilities.Companion.observeCanCreateAnyEvent$default(GuildScheduledEventUtilities.INSTANCE, selectedGuildId, null, null, null, 14, null);
            Observable<Boolean> observableObserveCanGuildSeeGuildRoleSubscriptions = GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildSeeGuildRoleSubscriptions(selectedGuildId);
            Observable<Map<Long, RestCallState<List<DirectoryEntryGuild>>>> observableObserveDirectories = companion.getDirectories().observeDirectories();
            Observable<Map<Long, StoreMessageAck.Ack>> observableObserveAll = companion.getMessageAck().observeAll();
            Observable<Map<Long, RestCallState<List<DirectoryEntryGuild2>>>> observableObserveDirectoryGuildScheduledEvents = companion.getDirectories().observeDirectoryGuildScheduledEvents();
            Observable<GuildJoinRequest> observableObserveGuildJoinRequest = companion.getGuildJoinRequests().observeGuildJoinRequest(selectedGuildId);
            Observable<GuildMember> observableObserveGuildMember = companion.getGuilds().observeGuildMember(selectedGuildId, id2);
            Intrinsics3.checkNotNullExpressionValue(observableObserveGuildMember, "StoreStream\n            …er(selectedGuildId, meId)");
            return ObservableCombineLatestOverloads2.combineLatest(observable, observableObserveChannelsForGuild$default, observableObserveJoinedThreads, observableObserveActiveJoinedThreadsForGuild, observableObserveChannelsWithActiveThreadsByGuild, observableObserveSelectedChannel, observableObserveSelectedVoiceChannelId, observable2, observableObserveMentionCounts, unreadChannelIds, observableObserveCollapsedCategories, nuxState, observableObserveGuildStageChannels, observableObserveStageInstancesForGuild, observableObserveGuildScheduledEvents$default, observableObserveCanCreateAnyEvent$default, observableObserveCanGuildSeeGuildRoleSubscriptions, observableObserveDirectories, observableObserveAll, observableObserveDirectoryGuildScheduledEvents, observableObserveGuildJoinRequest, observableObserveGuildMember, new WidgetChannelListModel$Companion$getSelectedGuildChannelList$1(selectedGuildId));
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:67:0x03d0. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:132:0x04f8  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x04fb  */
        /* JADX WARN: Removed duplicated region for block: B:164:0x0609  */
        /* JADX WARN: Removed duplicated region for block: B:167:0x0624  */
        /* JADX WARN: Removed duplicated region for block: B:192:0x0630 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0080  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final List<ChannelListItem> guildListBuilder(long selectedGuildId, GuildChannelsInfo guild, Map<Long, Channel> guildChannels, Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> activeJoinedGuildThreads, Map<Long, StoreThreadsJoined.JoinedThread> joinedThreads, Set<Long> channelsWithActiveThreads, Channel selectedChannel, long selectedVoiceChannelId, Map<Long, ? extends Collection<ChannelListItemVoiceUser>> voiceStates, Map<Long, Integer> mentionCounts, Set<Long> unreadChannelIds, Set<Long> collapsedCategories, Map<Long, StageChannel> stageChannels, Map<Long, StageInstance> stageInstances, List<GuildScheduledEvent> guildScheduledEvents, boolean canCreateAnyEvent, boolean canSeeGuildRoleSubscriptions, Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild>>> directories, Map<Long, StoreMessageAck.Ack> messageAcks, Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild2>>> directoryEvents, GuildJoinRequest guildJoinRequest, GuildMember member) {
            boolean z2;
            WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$3;
            WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$2;
            ChannelListItemInvite channelListItemInvite;
            HashSet hashSet;
            Map<Long, Collection<Channel>> map;
            WidgetChannelListModel$Companion$guildListBuilder$5 widgetChannelListModel$Companion$guildListBuilder$5;
            WidgetChannelListModel$Companion$guildListBuilder$4 widgetChannelListModel$Companion$guildListBuilder$4;
            boolean z3;
            Set<Long> set;
            Channel channel;
            ArrayList arrayList;
            boolean z4;
            ChannelListItemTextChannel channelListItemTextChannelInvoke;
            Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild>>> map2;
            long messageId;
            List listEmptyList;
            char c;
            boolean z5;
            List list;
            Set<Long> set2 = collapsedCategories;
            ArrayList arrayList2 = new ArrayList(activeJoinedGuildThreads.size() + guildChannels.size());
            if (guild.getUnelevated()) {
                arrayList2.add(new ChannelListItemMfaNotice());
            }
            ChannelListItemActiveEvent2 channelEventNoticeData = getChannelEventNoticeData(guild, stageChannels, guildScheduledEvents, voiceStates, guildChannels, selectedVoiceChannelId);
            if (channelEventNoticeData != null) {
                arrayList2.add(new ChannelListItemEventsSeparator(true));
                arrayList2.add(new ChannelListItemActiveEvent(channelEventNoticeData));
                arrayList2.add(new ChannelListItemEventsSeparator(false));
            }
            Guild guild2 = guild.getGuild();
            if (guild2 != null) {
                if ((guildScheduledEvents.isEmpty() ^ true) || (guild2.getFeatures().contains(GuildFeature.COMMUNITY) && canCreateAnyEvent)) {
                    arrayList2.add(new ChannelListItemGuildScheduledEvents(guildScheduledEvents, guild2));
                }
            }
            if (canSeeGuildRoleSubscriptions) {
                arrayList2.add(ChannelListItemGuildRoleSubscriptionsOverview.INSTANCE);
            }
            Map<Long, Collection<Channel>> mapSortThreadsForChannelList = ThreadUtils.INSTANCE.sortThreadsForChannelList(activeJoinedGuildThreads, selectedChannel);
            Map<Long, Collection<Channel>> sortedCategories = guild.getSortedCategories(guildChannels);
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            Guild guild3 = guild.getGuild();
            boolean z6 = guild3 != null && guild3.isHub();
            ChannelListItemInvite channelListItemInvite2 = new ChannelListItemInvite(selectedGuildId, z6);
            WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$22 = new WidgetChannelListModel$Companion$guildListBuilder$2(arrayList2, hashSet2, set2);
            WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$32 = new WidgetChannelListModel$Companion$guildListBuilder$3(unreadChannelIds);
            WidgetChannelListModel$Companion$guildListBuilder$4 widgetChannelListModel$Companion$guildListBuilder$42 = new WidgetChannelListModel$Companion$guildListBuilder$4(mapSortThreadsForChannelList, widgetChannelListModel$Companion$guildListBuilder$32);
            WidgetChannelListModel$Companion$guildListBuilder$5 widgetChannelListModel$Companion$guildListBuilder$52 = new WidgetChannelListModel$Companion$guildListBuilder$5(mapSortThreadsForChannelList, selectedChannel);
            for (Map.Entry<Long, Collection<Channel>> entry : sortedCategories.entrySet()) {
                WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$33 = widgetChannelListModel$Companion$guildListBuilder$32;
                long jLongValue = entry.getKey().longValue();
                Collection<Channel> value = entry.getValue();
                WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$23 = widgetChannelListModel$Companion$guildListBuilder$22;
                ChannelListItemInvite channelListItemInvite3 = channelListItemInvite2;
                Map<Long, Collection<Channel>> map3 = mapSortThreadsForChannelList;
                ArrayList arrayList3 = arrayList2;
                boolean zCan = PermissionUtils.can(Permission.VIEW_CHANNEL, guild.getChannelPermissions().get(Long.valueOf(jLongValue)));
                boolean zCan2 = PermissionUtils.can(16L, guild.getChannelPermissions().get(Long.valueOf(jLongValue)));
                if (zCan && zCan2) {
                    hashSet2.add(Long.valueOf(jLongValue));
                }
                ModelNotificationSettings.ChannelOverride channelOverride = guild.getNotificationSettings().getChannelOverride(jLongValue);
                boolean z7 = channelOverride != null && channelOverride.isMuted();
                for (Channel channel2 : value) {
                    long id2 = channel2.getId();
                    Long l = guild.getChannelPermissions().get(Long.valueOf(id2));
                    ModelNotificationSettings.ChannelOverride channelOverride2 = guild.getNotificationSettings().getChannelOverride(id2);
                    boolean z8 = channelOverride2 != null && channelOverride2.isMuted();
                    if (z6) {
                        z2 = z8;
                        if (channel2.getType() != 14 && !GrowthTeamFeatures.INSTANCE.hubStudyGroupEnabled()) {
                            widgetChannelListModel$Companion$guildListBuilder$3 = widgetChannelListModel$Companion$guildListBuilder$33;
                            widgetChannelListModel$Companion$guildListBuilder$2 = widgetChannelListModel$Companion$guildListBuilder$23;
                            channelListItemInvite = channelListItemInvite3;
                            z3 = z6;
                            hashSet = hashSet2;
                            set = set2;
                            widgetChannelListModel$Companion$guildListBuilder$5 = widgetChannelListModel$Companion$guildListBuilder$52;
                            widgetChannelListModel$Companion$guildListBuilder$4 = widgetChannelListModel$Companion$guildListBuilder$42;
                            arrayList = arrayList3;
                            map = map3;
                            z4 = zCan2;
                        }
                        arrayList3 = arrayList;
                        z6 = z3;
                        zCan2 = z4;
                        widgetChannelListModel$Companion$guildListBuilder$33 = widgetChannelListModel$Companion$guildListBuilder$3;
                        widgetChannelListModel$Companion$guildListBuilder$23 = widgetChannelListModel$Companion$guildListBuilder$2;
                        channelListItemInvite3 = channelListItemInvite;
                        hashSet2 = hashSet;
                        map3 = map;
                        widgetChannelListModel$Companion$guildListBuilder$52 = widgetChannelListModel$Companion$guildListBuilder$5;
                        widgetChannelListModel$Companion$guildListBuilder$42 = widgetChannelListModel$Companion$guildListBuilder$4;
                        set2 = set;
                    } else {
                        z2 = z8;
                    }
                    boolean z9 = z2;
                    widgetChannelListModel$Companion$guildListBuilder$3 = widgetChannelListModel$Companion$guildListBuilder$33;
                    widgetChannelListModel$Companion$guildListBuilder$2 = widgetChannelListModel$Companion$guildListBuilder$23;
                    channelListItemInvite = channelListItemInvite3;
                    boolean z10 = z6;
                    hashSet = hashSet2;
                    map = map3;
                    boolean z11 = zCan2;
                    ArrayList arrayList4 = arrayList3;
                    widgetChannelListModel$Companion$guildListBuilder$5 = widgetChannelListModel$Companion$guildListBuilder$52;
                    widgetChannelListModel$Companion$guildListBuilder$4 = widgetChannelListModel$Companion$guildListBuilder$42;
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1(z7, guild, hashSet2, z6, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$52, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$42, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList4, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2(id2, channel2, l, guild, hashSet, z10, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList4, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$3 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$3 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$3(channel2, l, widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1, z9, guild, hashSet, z10, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList4, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1, guild, hashSet, z10, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList4, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$5 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$5 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$5(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2, channel2, l, guild, hashSet, z10, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList4, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$6 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$6 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$6(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2, channel2, l, guild, hashSet, z10, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList4, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4, guild, hashSet, z10, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList4, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$8 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$8 = new WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$8(id2, guild, hashSet, z10, selectedChannel, mentionCounts, unreadChannelIds, selectedGuildId, widgetChannelListModel$Companion$guildListBuilder$5, collapsedCategories, widgetChannelListModel$Companion$guildListBuilder$3, hashSet3, widgetChannelListModel$Companion$guildListBuilder$4, selectedVoiceChannelId, voiceStates, canSeeGuildRoleSubscriptions, channelsWithActiveThreads, guildScheduledEvents, stageInstances, stageChannels, map, joinedThreads, arrayList4, widgetChannelListModel$Companion$guildListBuilder$2, messageAcks, directories, directoryEvents);
                    int type = channel2.getType();
                    if (type == 0) {
                        z3 = z10;
                        set = collapsedCategories;
                        channel = channel2;
                        arrayList = arrayList4;
                        z4 = z11;
                        channelListItemTextChannelInvoke = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$3.invoke();
                        if (channelListItemTextChannelInvoke == null) {
                            arrayList.add(channelListItemTextChannelInvoke);
                            arrayList.addAll(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7.invoke2(channel));
                        }
                    } else if (type == 2) {
                        z3 = z10;
                        set = collapsedCategories;
                        arrayList = arrayList4;
                        z4 = z11;
                        ChannelListItemVoiceChannel channelListItemVoiceChannelInvoke = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$5.invoke();
                        if (channelListItemVoiceChannelInvoke != null) {
                            arrayList.add(channelListItemVoiceChannelInvoke);
                            Collection<ChannelListItemVoiceUser> collectionEmptyList = voiceStates.get(Long.valueOf(id2));
                            if (collectionEmptyList == null) {
                                collectionEmptyList = Collections2.emptyList();
                            }
                            arrayList.addAll(collectionEmptyList);
                        }
                    } else if (type == 4) {
                        z3 = z10;
                        arrayList = arrayList4;
                        widgetChannelListModel$Companion$guildListBuilder$2.invoke2();
                        set = collapsedCategories;
                        z4 = z11;
                        arrayList.add(new ChannelListItemCategory(channel2, set.contains(Long.valueOf(id2)), z9, z4));
                    } else if (type != 5) {
                        channelListItemGuildScheduledEvents = null;
                        ChannelListItem channelListItemGuildScheduledEvents = null;
                        switch (type) {
                            case 13:
                                z3 = z10;
                                arrayList = arrayList4;
                                ChannelListItemStageVoiceChannel channelListItemStageVoiceChannelInvoke = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$6.invoke();
                                if (channelListItemStageVoiceChannelInvoke != null) {
                                    arrayList.add(channelListItemStageVoiceChannelInvoke);
                                    arrayList.addAll(widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$8.invoke2());
                                    StageChannel stageChannel = stageChannels.get(Long.valueOf(id2));
                                    Integer numValueOf = stageChannel != null ? Integer.valueOf(stageChannel.getAudienceSize()) : null;
                                    if (numValueOf != null && (numValueOf.intValue() > 0 || channelListItemStageVoiceChannelInvoke.getHasActiveEvent() || channelListItemStageVoiceChannelInvoke.getHasSpeakers())) {
                                        arrayList.add(new ChannelListItemStageAudienceCount(channel2, numValueOf.intValue()));
                                    }
                                }
                                set = collapsedCategories;
                                z4 = z11;
                                break;
                            case 14:
                                if (PermissionUtils.INSTANCE.hasAccess(channel2, l) && GrowthTeamFeatures.INSTANCE.isHubEnabled()) {
                                    StoreMessageAck.Ack ack = messageAcks.get(Long.valueOf(id2));
                                    if (ack != null) {
                                        messageId = ack.getMessageId();
                                        map2 = directories;
                                    } else {
                                        map2 = directories;
                                        messageId = 0;
                                    }
                                    RestCallState restCallState = (RestCallState) outline.d(channel2, map2);
                                    List listEmptyList2 = restCallState != null ? (List) restCallState.invoke() : null;
                                    if (listEmptyList2 == null) {
                                        listEmptyList2 = Collections2.emptyList();
                                    }
                                    ArrayList arrayList5 = new ArrayList();
                                    for (Object obj : listEmptyList2) {
                                        DirectoryEntryGuild directoryEntryGuild = (DirectoryEntryGuild) obj;
                                        if (messageId != 0 && DirectoryUtils2.hasMinimumMemberCount(directoryEntryGuild) && ((directoryEntryGuild.getCreatedAt().getDateTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22) > messageId) {
                                            arrayList5.add(obj);
                                        }
                                    }
                                    ChannelListItemDirectory channelListItemDirectory = new ChannelListItemDirectory(channel2, selectedChannel != null && channel2.getId() == selectedChannel.getId(), Math.min(5, arrayList5.size()));
                                    z3 = z10;
                                    if (z3 && GrowthTeamFeatures.INSTANCE.isHubEnabled()) {
                                        RestCallState restCallState2 = (RestCallState) outline.d(channel2, directoryEvents);
                                        if (restCallState2 == null || (list = (List) restCallState2.invoke()) == null) {
                                            listEmptyList = null;
                                        } else {
                                            listEmptyList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                                            Iterator it = list.iterator();
                                            while (it.hasNext()) {
                                                listEmptyList.add(((DirectoryEntryGuild2) it.next()).getGuildScheduledEvent());
                                            }
                                        }
                                        if (listEmptyList == null) {
                                            listEmptyList = Collections2.emptyList();
                                        }
                                        ChannelListItem[] channelListItemArr = new ChannelListItem[4];
                                        Guild guild4 = guild.getGuild();
                                        if (guild4 != null) {
                                            if (ChannelUtils.x(channel2)) {
                                                c = 1;
                                            } else {
                                                c = 1;
                                                z5 = GrowthTeamFeatures.INSTANCE.hubEventsEnabled(channel2.getGuildId(), true);
                                                if (!z5) {
                                                    guild4 = null;
                                                }
                                                if (guild4 != null) {
                                                    channelListItemGuildScheduledEvents = new ChannelListItemGuildScheduledEvents(listEmptyList, guild4);
                                                }
                                            }
                                            if (!z5) {
                                            }
                                            if (guild4 != null) {
                                            }
                                        } else {
                                            c = 1;
                                        }
                                        channelListItemArr[0] = channelListItemGuildScheduledEvents;
                                        channelListItemArr[c] = channelListItemDirectory;
                                        channelListItemArr[2] = new ChannelListItemAddServer();
                                        channelListItemArr[3] = new ChannelListItemInvite(selectedGuildId, z3);
                                        List listListOfNotNull = Collections2.listOfNotNull((Object[]) channelListItemArr);
                                        arrayList = arrayList4;
                                        arrayList.addAll(listListOfNotNull);
                                    } else {
                                        arrayList = arrayList4;
                                        arrayList.add(channelListItemDirectory);
                                    }
                                } else {
                                    z3 = z10;
                                    arrayList = arrayList4;
                                }
                                set = collapsedCategories;
                                z4 = z11;
                                break;
                            case 15:
                                break;
                            default:
                                z3 = z10;
                                arrayList = arrayList4;
                                set = collapsedCategories;
                                z4 = z11;
                                break;
                        }
                    } else {
                        z3 = z10;
                        channel = channel2;
                        arrayList = arrayList4;
                        set = collapsedCategories;
                        z4 = z11;
                        channelListItemTextChannelInvoke = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$3.invoke();
                        if (channelListItemTextChannelInvoke == null) {
                        }
                    }
                    arrayList3 = arrayList;
                    z6 = z3;
                    zCan2 = z4;
                    widgetChannelListModel$Companion$guildListBuilder$33 = widgetChannelListModel$Companion$guildListBuilder$3;
                    widgetChannelListModel$Companion$guildListBuilder$23 = widgetChannelListModel$Companion$guildListBuilder$2;
                    channelListItemInvite3 = channelListItemInvite;
                    hashSet2 = hashSet;
                    map3 = map;
                    widgetChannelListModel$Companion$guildListBuilder$52 = widgetChannelListModel$Companion$guildListBuilder$5;
                    widgetChannelListModel$Companion$guildListBuilder$42 = widgetChannelListModel$Companion$guildListBuilder$4;
                    set2 = set;
                }
                widgetChannelListModel$Companion$guildListBuilder$32 = widgetChannelListModel$Companion$guildListBuilder$33;
                widgetChannelListModel$Companion$guildListBuilder$22 = widgetChannelListModel$Companion$guildListBuilder$23;
                channelListItemInvite2 = channelListItemInvite3;
                arrayList2 = arrayList3;
                mapSortThreadsForChannelList = map3;
                hashSet2 = hashSet2;
            }
            WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$24 = widgetChannelListModel$Companion$guildListBuilder$22;
            ChannelListItemInvite channelListItemInvite4 = channelListItemInvite2;
            boolean z12 = z6;
            ArrayList arrayList6 = arrayList2;
            if (guild.getAbleToInstantInvite() && !z12) {
                arrayList6.add(guild.getUnelevated() ? 1 : 0, channelListItemInvite4);
            }
            if (guildJoinRequest != null && member != null && guildJoinRequest.getApplicationStatus() != ApplicationStatus.APPROVED && member.getPending()) {
                boolean unelevated = guild.getUnelevated();
                arrayList6.add(unelevated ? 1 : 0, new ChannelListItemEventsSeparator(false));
                arrayList6.add(unelevated ? 1 : 0, new ChannelListItemGuildJoinRequest(guildJoinRequest, member));
            }
            widgetChannelListModel$Companion$guildListBuilder$24.invoke2();
            return arrayList6;
        }

        public final Observable<WidgetChannelListModel> get() {
            Observable<WidgetChannelListModel> observableR = StoreStream.INSTANCE.getGuildSelected().observeSelectedGuildId().Y(WidgetChannelListModel$Companion$get$1.INSTANCE).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n          .g…  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelListModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType;", "", "<init>", "()V", "End", "Middle", "Single", "Start", "Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType$Start;", "Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType$Middle;", "Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType$End;", "Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType$Single;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ThreadSpineType {

        /* compiled from: WidgetChannelListModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType$End;", "Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class End extends ThreadSpineType {
            public static final End INSTANCE = new End();

            private End() {
                super(null);
            }
        }

        /* compiled from: WidgetChannelListModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType$Middle;", "Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Middle extends ThreadSpineType {
            public static final Middle INSTANCE = new Middle();

            private Middle() {
                super(null);
            }
        }

        /* compiled from: WidgetChannelListModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType$Single;", "Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Single extends ThreadSpineType {
            public static final Single INSTANCE = new Single();

            private Single() {
                super(null);
            }
        }

        /* compiled from: WidgetChannelListModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType$Start;", "Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Start extends ThreadSpineType {
            public static final Start INSTANCE = new Start();

            private Start() {
                super(null);
            }
        }

        private ThreadSpineType() {
        }

        public /* synthetic */ ThreadSpineType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelListModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006JÑ\u0001\u0010\u0019\u001a\u0018\u0012\b\u0012\u00060\bj\u0002`\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u00072\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\n0\u00072\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\f0\u00072\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u000e0\u00072\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u00072\u0016\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u00130\u00072\u001a\u0010\u0016\u001a\u0016\u0012\b\u0012\u00060\bj\u0002`\u0010\u0012\b\u0012\u00060\bj\u0002`\u00150\u00072\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJO\u0010\u001e\u001a\u001e\u0012\u001a\u0012\u0018\u0012\b\u0012\u00060\bj\u0002`\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u00070\u001d2\n\u0010\u001c\u001a\u00060\bj\u0002`\u001b2\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelListModel$VoiceStates;", "", "Ljava/util/Comparator;", "Lcom/discord/widgets/channels/list/items/ChannelListItemVoiceUser;", "Lkotlin/Comparator;", "createVoiceUserComparator", "()Ljava/util/Comparator;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/api/voice/state/VoiceState;", "voiceStates", "Lcom/discord/models/user/User;", "users", "Lcom/discord/models/member/GuildMember;", "computed", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "channels", "Lcom/discord/models/domain/ModelApplicationStream;", "guildStreams", "Lcom/discord/api/permission/PermissionBit;", "guildPermissions", "voiceUserComparator", "", "createVoiceStates", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Comparator;)Ljava/util/Map;", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "get", "(JLjava/util/Comparator;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class VoiceStates {
        public static final VoiceStates INSTANCE = new VoiceStates();

        private VoiceStates() {
        }

        public static final /* synthetic */ Map access$createVoiceStates(VoiceStates voiceStates, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Comparator comparator) {
            return voiceStates.createVoiceStates(map, map2, map3, map4, map5, map6, comparator);
        }

        private final Map<Long, List<ChannelListItemVoiceUser>> createVoiceStates(Map<Long, VoiceState> voiceStates, Map<Long, ? extends User> users, Map<Long, GuildMember> computed, Map<Long, Channel> channels, Map<Long, ? extends ModelApplicationStream> guildStreams, Map<Long, Long> guildPermissions, Comparator<ChannelListItemVoiceUser> voiceUserComparator) {
            Long channelId;
            Channel channel;
            HashMap map = new HashMap();
            for (VoiceState voiceState : voiceStates.values()) {
                long userId = voiceState.getUserId();
                User user = users.get(Long.valueOf(userId));
                if (user != null && (channelId = voiceState.getChannelId()) != null) {
                    long jLongValue = channelId.longValue();
                    boolean zCan = PermissionUtils.can(Permission.CONNECT, guildPermissions.get(Long.valueOf(jLongValue)));
                    Long lValueOf = Long.valueOf(jLongValue);
                    Object arrayList = map.get(lValueOf);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        map.put(lValueOf, arrayList);
                    }
                    List list = (List) arrayList;
                    GuildMember guildMember = computed.get(Long.valueOf(userId));
                    if (guildMember != null && (channel = channels.get(Long.valueOf(jLongValue))) != null) {
                        list.add(new ChannelListItemVoiceUser(channel, voiceState, user, guildMember, guildStreams.containsKey(Long.valueOf(userId)), zCan));
                    }
                }
            }
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                MutableCollectionsJVM.sortWith((List) ((Map.Entry) it.next()).getValue(), voiceUserComparator);
            }
            return map;
        }

        private final Comparator<ChannelListItemVoiceUser> createVoiceUserComparator() {
            return WidgetChannelListModel$VoiceStates$createVoiceUserComparator$1.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable get$default(VoiceStates voiceStates, long j, Comparator comparator, int i, Object obj) {
            if ((i & 2) != 0) {
                comparator = voiceStates.createVoiceUserComparator();
            }
            return voiceStates.get(j, comparator);
        }

        public final Observable<Map<Long, List<ChannelListItemVoiceUser>>> get(long guildId, Comparator<ChannelListItemVoiceUser> voiceUserComparator) {
            Intrinsics3.checkNotNullParameter(voiceUserComparator, "voiceUserComparator");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableF = Observable.f(companion.getApplicationStreaming().observeStreamsForGuild(guildId), ObservableExtensionsKt.leadingEdgeThrottle(companion.getVoiceStates().observe(guildId), 200L, TimeUnit.MILLISECONDS), companion.getUsers().observeAllUsers(), companion.getGuilds().observeComputed(guildId), StoreChannels.observeChannelsForGuild$default(companion.getChannels(), guildId, null, 2, null), companion.getPermissions().observeChannelPermissionsForGuild(guildId), new WidgetChannelListModel$VoiceStates$get$1(voiceUserComparator));
            Intrinsics3.checkNotNullExpressionValue(observableF, "Observable\n          .co…            )\n          }");
            Observable<Map<Long, List<ChannelListItemVoiceUser>>> observableR = ObservableExtensionsKt.computationLatest(observableF).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
            return observableR;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelListModel(Guild guild, List<? extends ChannelListItem> list, boolean z2, boolean z3, boolean z4, List<GuildScheduledEvent> list2) {
        Intrinsics3.checkNotNullParameter(list, "items");
        Intrinsics3.checkNotNullParameter(list2, "guildScheduledEvents");
        this.selectedGuild = guild;
        this.items = list;
        this.isGuildSelected = z2;
        this.showPremiumGuildHint = z3;
        this.showEmptyState = z4;
        this.guildScheduledEvents = list2;
    }

    public static /* synthetic */ WidgetChannelListModel copy$default(WidgetChannelListModel widgetChannelListModel, Guild guild, List list, boolean z2, boolean z3, boolean z4, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetChannelListModel.selectedGuild;
        }
        if ((i & 2) != 0) {
            list = widgetChannelListModel.items;
        }
        List list3 = list;
        if ((i & 4) != 0) {
            z2 = widgetChannelListModel.isGuildSelected;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            z3 = widgetChannelListModel.showPremiumGuildHint;
        }
        boolean z6 = z3;
        if ((i & 16) != 0) {
            z4 = widgetChannelListModel.showEmptyState;
        }
        boolean z7 = z4;
        if ((i & 32) != 0) {
            list2 = widgetChannelListModel.guildScheduledEvents;
        }
        return widgetChannelListModel.copy(guild, list3, z5, z6, z7, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final Guild getSelectedGuild() {
        return this.selectedGuild;
    }

    public final List<ChannelListItem> component2() {
        return this.items;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsGuildSelected() {
        return this.isGuildSelected;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getShowPremiumGuildHint() {
        return this.showPremiumGuildHint;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getShowEmptyState() {
        return this.showEmptyState;
    }

    public final List<GuildScheduledEvent> component6() {
        return this.guildScheduledEvents;
    }

    public final WidgetChannelListModel copy(Guild selectedGuild, List<? extends ChannelListItem> items, boolean isGuildSelected, boolean showPremiumGuildHint, boolean showEmptyState, List<GuildScheduledEvent> guildScheduledEvents) {
        Intrinsics3.checkNotNullParameter(items, "items");
        Intrinsics3.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
        return new WidgetChannelListModel(selectedGuild, items, isGuildSelected, showPremiumGuildHint, showEmptyState, guildScheduledEvents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelListModel)) {
            return false;
        }
        WidgetChannelListModel widgetChannelListModel = (WidgetChannelListModel) other;
        return Intrinsics3.areEqual(this.selectedGuild, widgetChannelListModel.selectedGuild) && Intrinsics3.areEqual(this.items, widgetChannelListModel.items) && this.isGuildSelected == widgetChannelListModel.isGuildSelected && this.showPremiumGuildHint == widgetChannelListModel.showPremiumGuildHint && this.showEmptyState == widgetChannelListModel.showEmptyState && Intrinsics3.areEqual(this.guildScheduledEvents, widgetChannelListModel.guildScheduledEvents);
    }

    public final List<GuildScheduledEvent> getGuildScheduledEvents() {
        return this.guildScheduledEvents;
    }

    public final List<ChannelListItem> getItems() {
        return this.items;
    }

    public final Guild getSelectedGuild() {
        return this.selectedGuild;
    }

    public final boolean getShowEmptyState() {
        return this.showEmptyState;
    }

    public final boolean getShowPremiumGuildHint() {
        return this.showPremiumGuildHint;
    }

    public final boolean getStartsWithPaddedElement() {
        ChannelListItem channelListItem = (ChannelListItem) _Collections.firstOrNull((List) this.items);
        if (channelListItem != null) {
            return (channelListItem instanceof ChannelListItemInvite) || (channelListItem instanceof ChannelListItemMfaNotice) || (channelListItem instanceof ChannelListItemCategory) || (channelListItem instanceof ChannelListItemEventsSeparator) || (channelListItem instanceof ChannelListItemGuildJoinRequest);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Guild guild = this.selectedGuild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        List<ChannelListItem> list = this.items;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isGuildSelected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        boolean z3 = this.showPremiumGuildHint;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.showEmptyState;
        int i5 = (i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
        List<GuildScheduledEvent> list2 = this.guildScheduledEvents;
        return i5 + (list2 != null ? list2.hashCode() : 0);
    }

    public final boolean isGuildSelected() {
        return this.isGuildSelected;
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetChannelListModel(selectedGuild=");
        sbU.append(this.selectedGuild);
        sbU.append(", items=");
        sbU.append(this.items);
        sbU.append(", isGuildSelected=");
        sbU.append(this.isGuildSelected);
        sbU.append(", showPremiumGuildHint=");
        sbU.append(this.showPremiumGuildHint);
        sbU.append(", showEmptyState=");
        sbU.append(this.showEmptyState);
        sbU.append(", guildScheduledEvents=");
        return outline.L(sbU, this.guildScheduledEvents, ")");
    }

    public /* synthetic */ WidgetChannelListModel(Guild guild, List list, boolean z2, boolean z3, boolean z4, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guild, list, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? Collections2.emptyList() : list2);
    }
}
