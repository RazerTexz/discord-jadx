package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: PrivateChannelMemberListService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0013B%\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/channels/memberlist/PrivateChannelMemberListService;", "", "Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/channels/memberlist/PrivateChannelMemberListService$State;", "observeStateForGroupDm", "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreUserPresence;", "storePresences", "Lcom/discord/stores/StoreUserPresence;", "Lcom/discord/stores/StoreApplicationStreaming;", "storeApplicationStreaming", "Lcom/discord/stores/StoreApplicationStreaming;", "<init>", "(Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreUserPresence;Lcom/discord/stores/StoreApplicationStreaming;)V", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PrivateChannelMemberListService {
    private final StoreApplicationStreaming storeApplicationStreaming;
    private final StoreUserPresence storePresences;
    private final StoreUser storeUser;

    /* compiled from: PrivateChannelMemberListService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0016\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ \u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u000b0\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ \u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\r0\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJh\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00052\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u000b0\u00052\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\r0\u0005HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR)\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\r0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\nR)\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\u000b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b!\u0010\nR)\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b\"\u0010\nR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"Lcom/discord/widgets/channels/memberlist/PrivateChannelMemberListService$State;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "component2", "()Ljava/util/Map;", "Lcom/discord/models/presence/Presence;", "component3", "Lcom/discord/models/domain/ModelApplicationStream;", "component4", "channel", "users", "presences", "applicationStreams", "copy", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/channels/memberlist/PrivateChannelMemberListService$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getApplicationStreams", "getPresences", "getUsers", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class State {
        private final Map<Long, ModelApplicationStream> applicationStreams;
        private final Channel channel;
        private final Map<Long, Presence> presences;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public State(Channel channel, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(map, "users");
            Intrinsics3.checkNotNullParameter(map2, "presences");
            Intrinsics3.checkNotNullParameter(map3, "applicationStreams");
            this.channel = channel;
            this.users = map;
            this.presences = map2;
            this.applicationStreams = map3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Channel channel, Map map, Map map2, Map map3, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = state.channel;
            }
            if ((i & 2) != 0) {
                map = state.users;
            }
            if ((i & 4) != 0) {
                map2 = state.presences;
            }
            if ((i & 8) != 0) {
                map3 = state.applicationStreams;
            }
            return state.copy(channel, map, map2, map3);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, User> component2() {
            return this.users;
        }

        public final Map<Long, Presence> component3() {
            return this.presences;
        }

        public final Map<Long, ModelApplicationStream> component4() {
            return this.applicationStreams;
        }

        public final State copy(Channel channel, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(presences, "presences");
            Intrinsics3.checkNotNullParameter(applicationStreams, "applicationStreams");
            return new State(channel, users, presences, applicationStreams);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.channel, state.channel) && Intrinsics3.areEqual(this.users, state.users) && Intrinsics3.areEqual(this.presences, state.presences) && Intrinsics3.areEqual(this.applicationStreams, state.applicationStreams);
        }

        public final Map<Long, ModelApplicationStream> getApplicationStreams() {
            return this.applicationStreams;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, Presence> getPresences() {
            return this.presences;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Map<Long, User> map = this.users;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Presence> map2 = this.presences;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, ModelApplicationStream> map3 = this.applicationStreams;
            return iHashCode3 + (map3 != null ? map3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("State(channel=");
            sbU.append(this.channel);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", presences=");
            sbU.append(this.presences);
            sbU.append(", applicationStreams=");
            return outline.M(sbU, this.applicationStreams, ")");
        }
    }

    /* compiled from: PrivateChannelMemberListService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0014 \u0001*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/user/User;", "kotlin.jvm.PlatformType", "recipient", "", "Lcom/discord/primitives/UserId;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/user/User;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService$observeStateForGroupDm$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<com.discord.api.user.User, Long> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Long call(com.discord.api.user.User user) {
            return call2(user);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(com.discord.api.user.User user) {
            return Long.valueOf(user.getId());
        }
    }

    /* compiled from: PrivateChannelMemberListService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010!\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00070\u0007 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u00062>\u0010\u0005\u001a:\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002 \u0003*\u001c\u0012\u0016\u0012\u0014 \u0003*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00020\u0001j\u0002`\u0002\u0018\u00010\u00040\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "", "ids", "Lrx/Observable;", "Lcom/discord/widgets/channels/memberlist/PrivateChannelMemberListService$State;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService$observeStateForGroupDm$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<List<Long>, Observable<? extends State>> {
        public final /* synthetic */ Channel $channel;

        /* compiled from: PrivateChannelMemberListService.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a\n \u0004*\u0004\u0018\u00010\u000b0\u000b2.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u000026\u0010\b\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0006j\u0002`\u0007 \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\u00000\u00002.\u0010\n\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\t \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "kotlin.jvm.PlatformType", "users", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "presences", "Lcom/discord/models/domain/ModelApplicationStream;", "applicationStreams", "Lcom/discord/widgets/channels/memberlist/PrivateChannelMemberListService$State;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/channels/memberlist/PrivateChannelMemberListService$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService$observeStateForGroupDm$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends ModelApplicationStream>, State> {
            public AnonymousClass1() {
            }

            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ State call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
                return call2(map, (Map<Long, Presence>) map2, map3);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final State call2(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
                Channel channel = AnonymousClass2.this.$channel;
                Intrinsics3.checkNotNullExpressionValue(map, "users");
                Intrinsics3.checkNotNullExpressionValue(map2, "presences");
                Intrinsics3.checkNotNullExpressionValue(map3, "applicationStreams");
                return new State(channel, map, map2, map3);
            }
        }

        public AnonymousClass2(Channel channel) {
            this.$channel = channel;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends State> call(List<Long> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends State> call2(List<Long> list) {
            StoreUser storeUserAccess$getStoreUser$p = PrivateChannelMemberListService.access$getStoreUser$p(PrivateChannelMemberListService.this);
            Intrinsics3.checkNotNullExpressionValue(list, "ids");
            return Observable.i(storeUserAccess$getStoreUser$p.observeUsers(list), PrivateChannelMemberListService.access$getStorePresences$p(PrivateChannelMemberListService.this).observePresencesForUsers(list), PrivateChannelMemberListService.access$getStoreApplicationStreaming$p(PrivateChannelMemberListService.this).observeStreamsByUser(), new AnonymousClass1());
        }
    }

    public PrivateChannelMemberListService() {
        this(null, null, null, 7, null);
    }

    public PrivateChannelMemberListService(StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming) {
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "storePresences");
        Intrinsics3.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
        this.storeUser = storeUser;
        this.storePresences = storeUserPresence;
        this.storeApplicationStreaming = storeApplicationStreaming;
    }

    public static final /* synthetic */ StoreApplicationStreaming access$getStoreApplicationStreaming$p(PrivateChannelMemberListService privateChannelMemberListService) {
        return privateChannelMemberListService.storeApplicationStreaming;
    }

    public static final /* synthetic */ StoreUserPresence access$getStorePresences$p(PrivateChannelMemberListService privateChannelMemberListService) {
        return privateChannelMemberListService.storePresences;
    }

    public static final /* synthetic */ StoreUser access$getStoreUser$p(PrivateChannelMemberListService privateChannelMemberListService) {
        return privateChannelMemberListService.storeUser;
    }

    public final Observable<State> observeStateForGroupDm(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Observable<State> observableY = Observable.I(this.storeUser.observeMeId().Z(1).c0(5000L, TimeUnit.MILLISECONDS), Observable.B(channel.z()).G(AnonymousClass1.INSTANCE)).f0().Y(new AnonymousClass2(channel));
        Intrinsics3.checkNotNullExpressionValue(observableY, "Observable.merge(\n      …            }\n          }");
        return observableY;
    }

    public /* synthetic */ PrivateChannelMemberListService(StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 2) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence, (i & 4) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming);
    }
}
