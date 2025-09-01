package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannelMembers;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadMembers;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.lazy.memberlist.ChannelMemberList;
import com.discord.widgets.channels.memberlist.PrivateChannelMemberListService;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func5;
import rx.functions.Func9;

/* compiled from: WidgetChannelMembersListViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetChannelMembersListViewModel.StoreState>> {
    public final /* synthetic */ Observable $isPanelOpenObservable;
    public final /* synthetic */ PrivateChannelMemberListService $privateChannelMemberListService;
    public final /* synthetic */ StoreApplicationStreaming $storeApplicationStreaming;
    public final /* synthetic */ StoreChannelMembers $storeChannelMembers;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUserPresence $storePresence;
    public final /* synthetic */ StoreThreadMembers $storeThreadMembers;
    public final /* synthetic */ StoreThreadsJoined $storeThreadsJoined;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isPanelOpen", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$None;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$None;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Boolean, WidgetChannelMembersListViewModel.StoreState.None> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.None call(Boolean bool) {
            return call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelMembersListViewModel.StoreState.None call2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
            return new WidgetChannelMembersListViewModel.StoreState.None(bool.booleanValue());
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/widgets/channels/memberlist/PrivateChannelMemberListService$State;", "kotlin.jvm.PlatformType", "state", "", "isPanelOpen", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Private;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/channels/memberlist/PrivateChannelMemberListService$State;Ljava/lang/Boolean;)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Private;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<PrivateChannelMemberListService.State, Boolean, WidgetChannelMembersListViewModel.StoreState.Private> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Private call(PrivateChannelMemberListService.State state, Boolean bool) {
            return call2(state, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelMembersListViewModel.StoreState.Private call2(PrivateChannelMemberListService.State state, Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
            return new WidgetChannelMembersListViewModel.StoreState.Private(bool.booleanValue(), state.getChannel(), state.getUsers(), state.getPresences(), state.getApplicationStreams(), WidgetChannelMembersListViewModel2.this.$storeUserRelationships.getRelationships());
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "parentChannel", "Lrx/Observable;", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<Channel, Observable<? extends WidgetChannelMembersListViewModel.StoreState>> {
        public final /* synthetic */ Channel $channel;

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isPanelOpen", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$None;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$None;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Boolean, WidgetChannelMembersListViewModel.StoreState.None> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.None call(Boolean bool) {
                return call2(bool);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final WidgetChannelMembersListViewModel.StoreState.None call2(Boolean bool) {
                Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
                return new WidgetChannelMembersListViewModel.StoreState.None(bool.booleanValue());
            }
        }

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0011\u001a\n \u0004*\u0004\u0018\u00010\u000e0\u000e2\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062.\u0010\u000b\u001a*\u0012\b\u0012\u00060\u0000j\u0002`\t\u0012\u0004\u0012\u00020\n \u0004*\u0014\u0012\b\u0012\u00060\u0000j\u0002`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;", "kotlin.jvm.PlatformType", "channelMemberList", "", "isPanelOpen", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Guild;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;Ljava/lang/Boolean;Ljava/util/Map;Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Guild;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$2, reason: invalid class name */
        public static final class AnonymousClass2<T1, T2, T3, T4, T5, R> implements Func5<Long, ChannelMemberList, Boolean, Map<Long, ? extends GuildRole>, Guild, WidgetChannelMembersListViewModel.StoreState.Guild> {
            public final /* synthetic */ Channel $parentChannel;

            public AnonymousClass2(Channel channel) {
                this.$parentChannel = channel;
            }

            @Override // rx.functions.Func5
            public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Guild call(Long l, ChannelMemberList channelMemberList, Boolean bool, Map<Long, ? extends GuildRole> map, Guild guild) {
                return call2(l, channelMemberList, bool, (Map<Long, GuildRole>) map, guild);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final WidgetChannelMembersListViewModel.StoreState.Guild call2(Long l, ChannelMemberList channelMemberList, Boolean bool, Map<Long, GuildRole> map, Guild guild) {
                Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
                boolean zBooleanValue = bool.booleanValue();
                Channel channel = this.$parentChannel;
                Intrinsics3.checkNotNullExpressionValue(channelMemberList, "channelMemberList");
                Intrinsics3.checkNotNullExpressionValue(map, "roles");
                return new WidgetChannelMembersListViewModel.StoreState.Guild(zBooleanValue, channel, guild, channelMemberList, l, map);
            }
        }

        /* compiled from: WidgetChannelMembersListViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001c\u001a\n \u0003*\u0004\u0018\u00010\u00190\u00192\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u00002\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052.\u0010\n\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\b\u0012\u0004\u0012\u00020\t \u0003*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00070\u000726\u0010\r\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u000bj\u0002`\f \u0003*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u000bj\u0002`\f\u0018\u00010\u00070\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2.\u0010\u0011\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0010 \u0003*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00070\u000726\u0010\u0014\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0012j\u0002`\u0013 \u0003*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0018\u00010\u00070\u00072.\u0010\u0016\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0015 \u0003*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00070\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\n¢\u0006\u0004\b\u001a\u0010\u001b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "threadMembers", "", "isPanelOpen", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "guildMembers", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/user/User;", "users", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "presences", "Lcom/discord/models/domain/ModelApplicationStream;", "streams", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "joinedThread", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Thread;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Set;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/discord/stores/StoreThreadsJoined$JoinedThread;)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Thread;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$3$3, reason: invalid class name and collision with other inner class name */
        public static final class C02473<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Set<? extends Long>, Boolean, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends ModelApplicationStream>, StoreThreadsJoined.JoinedThread, WidgetChannelMembersListViewModel.StoreState.Thread> {
            public final /* synthetic */ Channel $parentChannel;

            public C02473(Channel channel) {
                this.$parentChannel = channel;
            }

            @Override // rx.functions.Func9
            public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Thread call(Set<? extends Long> set, Boolean bool, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Guild guild, Map<Long, ? extends User> map3, Map<Long, ? extends Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, StoreThreadsJoined.JoinedThread joinedThread) {
                return call2((Set<Long>) set, bool, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, guild, map3, (Map<Long, Presence>) map4, map5, joinedThread);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final WidgetChannelMembersListViewModel.StoreState.Thread call2(Set<Long> set, Boolean bool, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Guild guild, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, StoreThreadsJoined.JoinedThread joinedThread) {
                Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
                boolean zBooleanValue = bool.booleanValue();
                Channel channel = AnonymousClass3.this.$channel;
                Channel channel2 = this.$parentChannel;
                Intrinsics3.checkNotNullExpressionValue(map, "roles");
                Intrinsics3.checkNotNullExpressionValue(map2, "guildMembers");
                Intrinsics3.checkNotNullExpressionValue(map3, "users");
                Intrinsics3.checkNotNullExpressionValue(map4, "presences");
                Intrinsics3.checkNotNullExpressionValue(map5, "streams");
                Intrinsics3.checkNotNullExpressionValue(set, "threadMembers");
                return new WidgetChannelMembersListViewModel.StoreState.Thread(zBooleanValue, channel, channel2, guild, map, map2, map3, map4, map5, set, joinedThread);
            }
        }

        public AnonymousClass3(Channel channel) {
            this.$channel = channel;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelMembersListViewModel.StoreState> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends WidgetChannelMembersListViewModel.StoreState> call2(Channel channel) {
            if (channel == null) {
                return WidgetChannelMembersListViewModel2.this.$isPanelOpenObservable.G(AnonymousClass1.INSTANCE);
            }
            if (!ChannelUtils.i(channel)) {
                Observable<Set<Long>> observableObserveThreadMembers = WidgetChannelMembersListViewModel2.this.$storeThreadMembers.observeThreadMembers(this.$channel.getId());
                WidgetChannelMembersListViewModel2 widgetChannelMembersListViewModel2 = WidgetChannelMembersListViewModel2.this;
                return Observable.c(observableObserveThreadMembers, widgetChannelMembersListViewModel2.$isPanelOpenObservable, widgetChannelMembersListViewModel2.$storeGuilds.observeRoles(this.$channel.getGuildId()), WidgetChannelMembersListViewModel2.this.$storeGuilds.observeGuildMembers(this.$channel.getGuildId()), WidgetChannelMembersListViewModel2.this.$storeGuilds.observeGuild(this.$channel.getGuildId()), WidgetChannelMembersListViewModel2.this.$storeUser.observeAllUsers(), WidgetChannelMembersListViewModel2.this.$storePresence.observeAllPresences(), WidgetChannelMembersListViewModel2.this.$storeApplicationStreaming.observeStreamsByUser(), WidgetChannelMembersListViewModel2.this.$storeThreadsJoined.observeJoinedThread(this.$channel.getId()), new C02473(channel));
            }
            Observable<Long> observableObservePermissionsForChannel = WidgetChannelMembersListViewModel2.this.$storePermissions.observePermissionsForChannel(channel.getId());
            Observable<ChannelMemberList> observableObserveChannelMemberList = WidgetChannelMembersListViewModel2.this.$storeChannelMembers.observeChannelMemberList(channel.getGuildId(), channel.getId());
            WidgetChannelMembersListViewModel2 widgetChannelMembersListViewModel22 = WidgetChannelMembersListViewModel2.this;
            return Observable.g(observableObservePermissionsForChannel, observableObserveChannelMemberList, widgetChannelMembersListViewModel22.$isPanelOpenObservable, widgetChannelMembersListViewModel22.$storeGuilds.observeRoles(this.$channel.getGuildId()), WidgetChannelMembersListViewModel2.this.$storeGuilds.observeGuild(this.$channel.getGuildId()), new AnonymousClass2(channel));
        }
    }

    /* compiled from: WidgetChannelMembersListViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0011\u001a\n \u0006*\u0004\u0018\u00010\u000e0\u000e2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002.\u0010\u0007\u001a*\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00020\u00022\u000e\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\b2\u000e\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\n0\n2\u000e\u0010\r\u001a\n \u0006*\u0004\u0018\u00010\f0\fH\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "kotlin.jvm.PlatformType", "guildRoles", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;", "channelMemberList", "", "isPanelOpen", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Guild;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/lang/Long;Lcom/discord/utilities/lazy/memberlist/ChannelMemberList;Ljava/lang/Boolean;)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$StoreState$Guild;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$Companion$observeStoreState$1$4, reason: invalid class name */
    public static final class AnonymousClass4<T1, T2, T3, T4, T5, R> implements Func5<Guild, Map<Long, ? extends GuildRole>, Long, ChannelMemberList, Boolean, WidgetChannelMembersListViewModel.StoreState.Guild> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass4(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func5
        public /* bridge */ /* synthetic */ WidgetChannelMembersListViewModel.StoreState.Guild call(Guild guild, Map<Long, ? extends GuildRole> map, Long l, ChannelMemberList channelMemberList, Boolean bool) {
            return call2(guild, (Map<Long, GuildRole>) map, l, channelMemberList, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelMembersListViewModel.StoreState.Guild call2(Guild guild, Map<Long, GuildRole> map, Long l, ChannelMemberList channelMemberList, Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isPanelOpen");
            boolean zBooleanValue = bool.booleanValue();
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(channelMemberList, "channelMemberList");
            Intrinsics3.checkNotNullExpressionValue(map, "guildRoles");
            return new WidgetChannelMembersListViewModel.StoreState.Guild(zBooleanValue, channel, guild, channelMemberList, l, map);
        }
    }

    public WidgetChannelMembersListViewModel2(Observable observable, PrivateChannelMemberListService privateChannelMemberListService, StoreUserRelationships storeUserRelationships, StoreChannels storeChannels, StorePermissions storePermissions, StoreChannelMembers storeChannelMembers, StoreGuilds storeGuilds, StoreThreadMembers storeThreadMembers, StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming, StoreThreadsJoined storeThreadsJoined) {
        this.$isPanelOpenObservable = observable;
        this.$privateChannelMemberListService = privateChannelMemberListService;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storeChannels = storeChannels;
        this.$storePermissions = storePermissions;
        this.$storeChannelMembers = storeChannelMembers;
        this.$storeGuilds = storeGuilds;
        this.$storeThreadMembers = storeThreadMembers;
        this.$storeUser = storeUser;
        this.$storePresence = storeUserPresence;
        this.$storeApplicationStreaming = storeApplicationStreaming;
        this.$storeThreadsJoined = storeThreadsJoined;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelMembersListViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelMembersListViewModel.StoreState> call2(Channel channel) {
        return channel == null ? this.$isPanelOpenObservable.G(AnonymousClass1.INSTANCE) : ChannelUtils.B(channel) ? Observable.j(this.$privateChannelMemberListService.observeStateForGroupDm(channel), this.$isPanelOpenObservable, new AnonymousClass2()) : ChannelUtils.H(channel) ? this.$storeChannels.observeChannel(channel.getParentId()).Y(new AnonymousClass3(channel)) : Observable.g(this.$storeGuilds.observeGuild(channel.getGuildId()), this.$storeGuilds.observeRoles(channel.getGuildId()), this.$storePermissions.observePermissionsForChannel(channel.getId()), this.$storeChannelMembers.observeChannelMemberList(channel.getGuildId(), channel.getId()), this.$isPanelOpenObservable, new AnonymousClass4(channel));
    }
}
