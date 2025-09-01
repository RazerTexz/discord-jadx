package com.discord.stores;

import android.content.Context;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StoreGuildRoleMemberCounts.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001#B!\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b!\u0010\"J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u000b\u001a\u0014\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\r\u0010\u0007J\u001b\u0010\u000e\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019RZ\u0010\u001c\u001aF\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u0004\u0012\u00020\n0\b0\u001aj\"\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u0004\u0012\u00020\n0\b`\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR:\u0010\u001e\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00020\u001aj\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0002`\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR6\u0010\u001f\u001a\"\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u0004\u0012\u00020\n0\b0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/discord/stores/StoreGuildRoleMemberCounts;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "fetchGuildRoleMemberCountsIfNecessary", "(J)V", "", "Lcom/discord/primitives/RoleId;", "", "getGuildRoleMemberCounts", "(J)Ljava/util/Map;", "fetchGuildRoleMemberCounts", "handleGuildRemove", "snapshotData", "()V", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "guildRoleMemberCounts", "Ljava/util/HashMap;", "guildRoleMemberCountFetchTimes", "guildMemberCountsSnapshot", "Ljava/util/Map;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/time/Clock;Lcom/discord/utilities/rest/RestAPI;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildRoleMemberCounts extends StoreV2 {
    private static final int CACHE_TIME_MS = 120000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private Map<Long, ? extends Map<Long, Integer>> guildMemberCountsSnapshot;
    private final HashMap<Long, Long> guildRoleMemberCountFetchTimes;
    private final HashMap<Long, Map<Long, Integer>> guildRoleMemberCounts;
    private final RestAPI restApi;

    /* compiled from: StoreGuildRoleMemberCounts.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCounts$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleMemberCounts.access$fetchGuildRoleMemberCountsIfNecessary(StoreGuildRoleMemberCounts.this, this.$guildId);
        }
    }

    /* compiled from: StoreGuildRoleMemberCounts.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/RoleId;", "", "roleMemberCounts", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Map<Long, ? extends Integer>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends Integer> map) {
            invoke2((Map<Long, Integer>) map);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, Integer> map) {
            if (map != null) {
                StoreGuildRoleMemberCounts.access$getDispatcher$p(StoreGuildRoleMemberCounts.this).schedule(new StoreGuildRoleMemberCounts2(map, this));
            }
        }
    }

    /* compiled from: StoreGuildRoleMemberCounts.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildRoleMemberCounts.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildRoleMemberCounts$fetchGuildRoleMemberCountsIfNecessary$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
                StoreGuildRoleMemberCounts.access$getGuildRoleMemberCountFetchTimes$p(StoreGuildRoleMemberCounts.this).remove(Long.valueOf(AnonymousClass2.this.$guildId));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreGuildRoleMemberCounts.access$getDispatcher$p(StoreGuildRoleMemberCounts.this).schedule(new AnonymousClass1());
        }
    }

    public /* synthetic */ StoreGuildRoleMemberCounts(Dispatcher dispatcher, Clock clock, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ void access$fetchGuildRoleMemberCountsIfNecessary(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts, long j) {
        storeGuildRoleMemberCounts.fetchGuildRoleMemberCountsIfNecessary(j);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts) {
        return storeGuildRoleMemberCounts.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getGuildRoleMemberCountFetchTimes$p(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts) {
        return storeGuildRoleMemberCounts.guildRoleMemberCountFetchTimes;
    }

    public static final /* synthetic */ HashMap access$getGuildRoleMemberCounts$p(StoreGuildRoleMemberCounts storeGuildRoleMemberCounts) {
        return storeGuildRoleMemberCounts.guildRoleMemberCounts;
    }

    @Store3
    private final void fetchGuildRoleMemberCountsIfNecessary(long guildId) {
        Long l = this.guildRoleMemberCountFetchTimes.get(Long.valueOf(guildId));
        if (this.guildRoleMemberCounts.get(Long.valueOf(guildId)) == null || l == null || this.clock.currentTimeMillis() - l.longValue() >= CACHE_TIME_MS) {
            this.guildRoleMemberCountFetchTimes.put(Long.valueOf(guildId), Long.valueOf(this.clock.currentTimeMillis()));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getGuildRoleMemberCounts(guildId), false, 1, null), StoreGuildRoleMemberCounts.class, (Context) null, (Function1) null, new AnonymousClass2(guildId), (Function0) null, (Function0) null, new AnonymousClass1(guildId), 54, (Object) null);
        }
    }

    public final void fetchGuildRoleMemberCounts(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final Map<Long, Integer> getGuildRoleMemberCounts(long guildId) {
        return this.guildMemberCountsSnapshot.get(Long.valueOf(guildId));
    }

    @Store3
    public final void handleGuildRemove(long guildId) {
        this.guildRoleMemberCounts.remove(Long.valueOf(guildId));
        this.guildRoleMemberCountFetchTimes.remove(Long.valueOf(guildId));
        markChanged();
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.guildMemberCountsSnapshot = new HashMap(this.guildRoleMemberCounts);
    }

    public StoreGuildRoleMemberCounts(Dispatcher dispatcher, Clock clock, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.restApi = restAPI;
        this.guildRoleMemberCounts = new HashMap<>();
        this.guildMemberCountsSnapshot = Maps6.emptyMap();
        this.guildRoleMemberCountFetchTimes = new HashMap<>();
    }
}
