package com.discord.stores;

import android.content.Context;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: StoreGuildJoinRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b6\u00107J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\n0\t0\b¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\r0\t0\b¢\u0006\u0004\b\u000e\u0010\fJ!\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\u0019\u0010\u0007J#\u0010\u001b\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u001a\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001f\u001a\u00020\u00052\n\u0010\u001e\u001a\u00060\u0002j\u0002`\u001d2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0017¢\u0006\u0004\b!\u0010\u0014R&\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\r0\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R:\u0010&\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\n0$j\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\n`%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R:\u0010(\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\r0$j\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\r`%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R&\u00105\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010#¨\u00068"}, d2 = {"Lcom/discord/stores/StoreGuildJoinRequest;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "handleGuildJoinRequestApproved", "(J)V", "Lrx/Observable;", "", "Lcom/discord/models/guild/Guild;", "observePendingGuilds", "()Lrx/Observable;", "Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "observeGuildJoinRequests", "observeGuildJoinRequest", "(J)Lrx/Observable;", "getGuildJoinRequest", "(J)Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "fetchPendingGuilds", "()V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "handleGuildRemove", "request", "handleGuildJoinRequestCreateOrUpdate", "(JLcom/discord/api/guildjoinrequest/GuildJoinRequest;)V", "Lcom/discord/primitives/UserId;", "userId", "handleGuildJoinRequestDelete", "(JJ)V", "snapshotData", "guildJoinRequestsSnapshot", "Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "pendingGuilds", "Ljava/util/HashMap;", "guildJoinRequests", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreGuilds;", "pendingGuildsSnapshot", "<init>", "(Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildJoinRequest extends StoreV2 {
    private final Dispatcher dispatcher;
    private final HashMap<Long, GuildJoinRequest> guildJoinRequests;
    private Map<Long, GuildJoinRequest> guildJoinRequestsSnapshot;
    private final StoreGuilds guildsStore;
    private final ObservationDeck observationDeck;
    private HashMap<Long, Guild> pendingGuilds;
    private Map<Long, Guild> pendingGuildsSnapshot;
    private final StoreUser userStore;

    /* compiled from: StoreGuildJoinRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildJoinRequest$fetchPendingGuilds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

        /* compiled from: StoreGuildJoinRequest.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/api/guild/Guild;", "results", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildJoinRequest$fetchPendingGuilds$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01191 extends Lambda implements Function1<List<? extends com.discord.api.guild.Guild>, Unit> {

            /* compiled from: StoreGuildJoinRequest.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreGuildJoinRequest$fetchPendingGuilds$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01201 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $results;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01201(List list) {
                    super(0);
                    this.$results = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    for (com.discord.api.guild.Guild guild : this.$results) {
                        StoreGuildJoinRequest.access$getPendingGuilds$p(StoreGuildJoinRequest.this).put(Long.valueOf(guild.getId()), new Guild(guild));
                    }
                    StoreGuildJoinRequest.this.markChanged();
                }
            }

            public C01191() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.discord.api.guild.Guild> list) {
                invoke2((List<com.discord.api.guild.Guild>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<com.discord.api.guild.Guild> list) {
                Intrinsics3.checkNotNullParameter(list, "results");
                StoreGuildJoinRequest.access$getDispatcher$p(StoreGuildJoinRequest.this).schedule(new C01201(list));
            }
        }

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map<Long, Guild> guilds = StoreGuildJoinRequest.access$getGuildsStore$p(StoreGuildJoinRequest.this).getGuilds();
            Set setKeySet = StoreGuildJoinRequest.access$getGuildJoinRequests$p(StoreGuildJoinRequest.this).keySet();
            Intrinsics3.checkNotNullExpressionValue(setKeySet, "guildJoinRequests.keys");
            ArrayList arrayList = new ArrayList();
            Iterator it = setKeySet.iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Long l = (Long) next;
                Intrinsics3.checkNotNullExpressionValue(l, "it");
                if (!guilds.containsKey(l) && !StoreGuildJoinRequest.access$getPendingGuilds$p(StoreGuildJoinRequest.this).containsKey(l)) {
                    z2 = true;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getUserJoinRequestGuilds(), false, 1, null), StoreGuildJoinRequest.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C01191(), 62, (Object) null);
            }
        }
    }

    /* compiled from: StoreGuildJoinRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "invoke", "()Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildJoinRequest$observeGuildJoinRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<GuildJoinRequest> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ GuildJoinRequest invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GuildJoinRequest invoke() {
            return (GuildJoinRequest) StoreGuildJoinRequest.access$getGuildJoinRequestsSnapshot$p(StoreGuildJoinRequest.this).get(Long.valueOf(this.$guildId));
        }
    }

    /* compiled from: StoreGuildJoinRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildJoinRequest$observeGuildJoinRequests$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends GuildJoinRequest>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends GuildJoinRequest> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends GuildJoinRequest> invoke2() {
            return StoreGuildJoinRequest.access$getGuildJoinRequestsSnapshot$p(StoreGuildJoinRequest.this);
        }
    }

    /* compiled from: StoreGuildJoinRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildJoinRequest$observePendingGuilds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Guild>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Guild> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Guild> invoke2() {
            return StoreGuildJoinRequest.access$getPendingGuildsSnapshot$p(StoreGuildJoinRequest.this);
        }
    }

    public StoreGuildJoinRequest(StoreUser storeUser, StoreGuilds storeGuilds, Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.userStore = storeUser;
        this.guildsStore = storeGuilds;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.pendingGuilds = new HashMap<>();
        this.pendingGuildsSnapshot = Maps6.emptyMap();
        this.guildJoinRequests = new HashMap<>();
        this.guildJoinRequestsSnapshot = Maps6.emptyMap();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getGuildJoinRequests$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.guildJoinRequests;
    }

    public static final /* synthetic */ Map access$getGuildJoinRequestsSnapshot$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.guildJoinRequestsSnapshot;
    }

    public static final /* synthetic */ StoreGuilds access$getGuildsStore$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.guildsStore;
    }

    public static final /* synthetic */ HashMap access$getPendingGuilds$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.pendingGuilds;
    }

    public static final /* synthetic */ Map access$getPendingGuildsSnapshot$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.pendingGuildsSnapshot;
    }

    public static final /* synthetic */ void access$setGuildJoinRequestsSnapshot$p(StoreGuildJoinRequest storeGuildJoinRequest, Map map) {
        storeGuildJoinRequest.guildJoinRequestsSnapshot = map;
    }

    public static final /* synthetic */ void access$setPendingGuilds$p(StoreGuildJoinRequest storeGuildJoinRequest, HashMap map) {
        storeGuildJoinRequest.pendingGuilds = map;
    }

    public static final /* synthetic */ void access$setPendingGuildsSnapshot$p(StoreGuildJoinRequest storeGuildJoinRequest, Map map) {
        storeGuildJoinRequest.pendingGuildsSnapshot = map;
    }

    private final void handleGuildJoinRequestApproved(long guildId) {
        Guild guild = this.guildsStore.getGuild(guildId);
        if ((guild != null ? guild.getName() : null) != null) {
            MemberVerificationSuccessDialog.INSTANCE.enqueue(guildId);
        }
    }

    public final void fetchPendingGuilds() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final GuildJoinRequest getGuildJoinRequest(long guildId) {
        return this.guildJoinRequestsSnapshot.get(Long.valueOf(guildId));
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<GuildJoinRequest> guildJoinRequests = payload.getGuildJoinRequests();
        if (guildJoinRequests != null) {
            for (GuildJoinRequest guildJoinRequest : guildJoinRequests) {
                HashMap<Long, GuildJoinRequest> map = this.guildJoinRequests;
                Long lValueOf = Long.valueOf(guildJoinRequest.getGuildId());
                Intrinsics3.checkNotNullExpressionValue(guildJoinRequest, "joinRequest");
                map.put(lValueOf, guildJoinRequest);
            }
        }
        markChanged();
    }

    @Store3
    public final void handleGuildJoinRequestCreateOrUpdate(long guildId, GuildJoinRequest request) {
        Intrinsics3.checkNotNullParameter(request, "request");
        if (request.getUserId() == this.userStore.getMeSnapshot().getId()) {
            this.guildJoinRequests.put(Long.valueOf(guildId), request);
            if (request.getApplicationStatus() == ApplicationStatus.APPROVED && request.getLastSeen() == null) {
                handleGuildJoinRequestApproved(guildId);
            }
            markChanged();
        }
    }

    @Store3
    public final void handleGuildJoinRequestDelete(long userId, long guildId) {
        if (userId == this.userStore.getMeSnapshot().getId()) {
            this.guildJoinRequests.remove(Long.valueOf(guildId));
            this.pendingGuilds.remove(Long.valueOf(guildId));
            markChanged();
        }
    }

    @Store3
    public final void handleGuildRemove(long guildId) {
        if (this.guildJoinRequests.remove(Long.valueOf(guildId)) != null) {
            markChanged();
        }
    }

    public final Observable<GuildJoinRequest> observeGuildJoinRequest(long guildId) {
        Observable<GuildJoinRequest> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, GuildJoinRequest>> observeGuildJoinRequests() {
        Observable<Map<Long, GuildJoinRequest>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Guild>> observePendingGuilds() {
        Observable<Map<Long, Guild>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.guildJoinRequestsSnapshot = new HashMap(this.guildJoinRequests);
        this.pendingGuildsSnapshot = new HashMap(this.pendingGuilds);
    }
}
