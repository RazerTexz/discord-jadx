package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.models.domain.ModelChannelFollowerStats;
import com.discord.models.domain.ModelChannelFollowerStatsDto;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;

/* compiled from: StoreChannelFollowerStats.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0003'&(B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b$\u0010%J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u000b\u0010\nJ#\u0010\u000e\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u001b\u0010\u0011\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u0011\u0010\u0007J!\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00122\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0015\u0010\u0007J\u000f\u0010\u0016\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR&\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R&\u0010#\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u001c0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001e¨\u0006)"}, d2 = {"Lcom/discord/stores/StoreChannelFollowerStats;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "fetchIfNonexistingOrStale", "(J)V", "", "isStale", "(J)Z", "isExisting", "Lcom/discord/models/domain/ModelChannelFollowerStats;", "channelFollowerStats", "handleChannelFollowerStatsFetchSuccess", "(JLcom/discord/models/domain/ModelChannelFollowerStats;)V", "handleChannelFollowerStatsFetchStart", "handleChannelFollowerStatsFetchFailed", "Lrx/Observable;", "observeChannelFollowerStats", "(J)Lrx/Observable;", "fetchChannelFollowerStats", "snapshotData", "()V", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "", "Lcom/discord/stores/StoreChannelFollowerStats$ChannelFollowerStatData;", "channelFollowerStatsState", "Ljava/util/Map;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "", "channelFollowerStatsStateSnapshot", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "ChannelFollowerStatData", "FetchState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreChannelFollowerStats extends StoreV2 {
    private static final int STALE_TIME_DIFF_MS = 3600000;
    private final Map<Long, ChannelFollowerStatData> channelFollowerStatsState;
    private Map<Long, ChannelFollowerStatData> channelFollowerStatsStateSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreChannelFollowerStats.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/stores/StoreChannelFollowerStats$ChannelFollowerStatData;", "", "Lcom/discord/stores/StoreChannelFollowerStats$FetchState;", "component1", "()Lcom/discord/stores/StoreChannelFollowerStats$FetchState;", "Lcom/discord/models/domain/ModelChannelFollowerStats;", "component2", "()Lcom/discord/models/domain/ModelChannelFollowerStats;", "fetchState", "data", "copy", "(Lcom/discord/stores/StoreChannelFollowerStats$FetchState;Lcom/discord/models/domain/ModelChannelFollowerStats;)Lcom/discord/stores/StoreChannelFollowerStats$ChannelFollowerStatData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreChannelFollowerStats$FetchState;", "getFetchState", "Lcom/discord/models/domain/ModelChannelFollowerStats;", "getData", "<init>", "(Lcom/discord/stores/StoreChannelFollowerStats$FetchState;Lcom/discord/models/domain/ModelChannelFollowerStats;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelFollowerStatData {
        private final ModelChannelFollowerStats data;
        private final FetchState fetchState;

        public ChannelFollowerStatData(FetchState fetchState, ModelChannelFollowerStats modelChannelFollowerStats) {
            Intrinsics3.checkNotNullParameter(fetchState, "fetchState");
            Intrinsics3.checkNotNullParameter(modelChannelFollowerStats, "data");
            this.fetchState = fetchState;
            this.data = modelChannelFollowerStats;
        }

        public static /* synthetic */ ChannelFollowerStatData copy$default(ChannelFollowerStatData channelFollowerStatData, FetchState fetchState, ModelChannelFollowerStats modelChannelFollowerStats, int i, Object obj) {
            if ((i & 1) != 0) {
                fetchState = channelFollowerStatData.fetchState;
            }
            if ((i & 2) != 0) {
                modelChannelFollowerStats = channelFollowerStatData.data;
            }
            return channelFollowerStatData.copy(fetchState, modelChannelFollowerStats);
        }

        /* renamed from: component1, reason: from getter */
        public final FetchState getFetchState() {
            return this.fetchState;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelChannelFollowerStats getData() {
            return this.data;
        }

        public final ChannelFollowerStatData copy(FetchState fetchState, ModelChannelFollowerStats data) {
            Intrinsics3.checkNotNullParameter(fetchState, "fetchState");
            Intrinsics3.checkNotNullParameter(data, "data");
            return new ChannelFollowerStatData(fetchState, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelFollowerStatData)) {
                return false;
            }
            ChannelFollowerStatData channelFollowerStatData = (ChannelFollowerStatData) other;
            return Intrinsics3.areEqual(this.fetchState, channelFollowerStatData.fetchState) && Intrinsics3.areEqual(this.data, channelFollowerStatData.data);
        }

        public final ModelChannelFollowerStats getData() {
            return this.data;
        }

        public final FetchState getFetchState() {
            return this.fetchState;
        }

        public int hashCode() {
            FetchState fetchState = this.fetchState;
            int iHashCode = (fetchState != null ? fetchState.hashCode() : 0) * 31;
            ModelChannelFollowerStats modelChannelFollowerStats = this.data;
            return iHashCode + (modelChannelFollowerStats != null ? modelChannelFollowerStats.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelFollowerStatData(fetchState=");
            sbU.append(this.fetchState);
            sbU.append(", data=");
            sbU.append(this.data);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ChannelFollowerStatData(FetchState fetchState, ModelChannelFollowerStats modelChannelFollowerStats, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fetchState, (i & 2) != 0 ? new ModelChannelFollowerStats(0L, null, null, null, null, null, null, Opcodes.LAND, null) : modelChannelFollowerStats);
        }
    }

    /* compiled from: StoreChannelFollowerStats.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/stores/StoreChannelFollowerStats$FetchState;", "", "<init>", "(Ljava/lang/String;I)V", "FETCHING", "FAILED", "SUCCEEDED", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum FetchState {
        FETCHING,
        FAILED,
        SUCCEEDED
    }

    /* compiled from: StoreChannelFollowerStats.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StoreChannelFollowerStats.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelChannelFollowerStatsDto;", "channelFollowerStats", "", "invoke", "(Lcom/discord/models/domain/ModelChannelFollowerStatsDto;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01001 extends Lambda implements Function1<ModelChannelFollowerStatsDto, Unit> {

            /* compiled from: StoreChannelFollowerStats.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01011 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ ModelChannelFollowerStatsDto $channelFollowerStats;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01011(ModelChannelFollowerStatsDto modelChannelFollowerStatsDto) {
                    super(0);
                    this.$channelFollowerStats = modelChannelFollowerStatsDto;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreChannelFollowerStats.access$handleChannelFollowerStatsFetchSuccess(StoreChannelFollowerStats.this, anonymousClass1.$channelId, ModelChannelFollowerStats.INSTANCE.fromResponse(this.$channelFollowerStats));
                }
            }

            public C01001() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelChannelFollowerStatsDto modelChannelFollowerStatsDto) {
                invoke2(modelChannelFollowerStatsDto);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelChannelFollowerStatsDto modelChannelFollowerStatsDto) {
                StoreChannelFollowerStats.access$getDispatcher$p(StoreChannelFollowerStats.this).schedule(new C01011(modelChannelFollowerStatsDto));
            }
        }

        /* compiled from: StoreChannelFollowerStats.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreChannelFollowerStats.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreChannelFollowerStats$fetchIfNonexistingOrStale$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01021 extends Lambda implements Function0<Unit> {
                public C01021() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreChannelFollowerStats.access$handleChannelFollowerStatsFetchFailed(StoreChannelFollowerStats.this, anonymousClass1.$channelId);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreChannelFollowerStats.access$getDispatcher$p(StoreChannelFollowerStats.this).schedule(new C01021());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            boolean z2 = StoreChannelFollowerStats.access$isExisting(StoreChannelFollowerStats.this, this.$channelId) && !StoreChannelFollowerStats.access$isStale(StoreChannelFollowerStats.this, this.$channelId);
            ChannelFollowerStatData channelFollowerStatData = (ChannelFollowerStatData) StoreChannelFollowerStats.access$getChannelFollowerStatsState$p(StoreChannelFollowerStats.this).get(Long.valueOf(this.$channelId));
            boolean z3 = (channelFollowerStatData != null ? channelFollowerStatData.getFetchState() : null) == FetchState.FETCHING;
            if (z2 || z3) {
                return;
            }
            StoreChannelFollowerStats.access$handleChannelFollowerStatsFetchStart(StoreChannelFollowerStats.this, this.$channelId);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getChannelFollowerStats(this.$channelId), false, 1, null), StoreChannelFollowerStats.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C01001(), 54, (Object) null);
        }
    }

    /* compiled from: StoreChannelFollowerStats.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/models/domain/ModelChannelFollowerStats;", "invoke", "()Lcom/discord/models/domain/ModelChannelFollowerStats;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreChannelFollowerStats$observeChannelFollowerStats$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ModelChannelFollowerStats> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ModelChannelFollowerStats invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ModelChannelFollowerStats invoke() {
            ChannelFollowerStatData channelFollowerStatData = (ChannelFollowerStatData) StoreChannelFollowerStats.access$getChannelFollowerStatsStateSnapshot$p(StoreChannelFollowerStats.this).get(Long.valueOf(this.$channelId));
            if (channelFollowerStatData != null) {
                return channelFollowerStatData.getData();
            }
            return null;
        }
    }

    public StoreChannelFollowerStats(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.channelFollowerStatsState = new HashMap();
        this.channelFollowerStatsStateSnapshot = new HashMap();
    }

    public static final /* synthetic */ Map access$getChannelFollowerStatsState$p(StoreChannelFollowerStats storeChannelFollowerStats) {
        return storeChannelFollowerStats.channelFollowerStatsState;
    }

    public static final /* synthetic */ Map access$getChannelFollowerStatsStateSnapshot$p(StoreChannelFollowerStats storeChannelFollowerStats) {
        return storeChannelFollowerStats.channelFollowerStatsStateSnapshot;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreChannelFollowerStats storeChannelFollowerStats) {
        return storeChannelFollowerStats.dispatcher;
    }

    public static final /* synthetic */ void access$handleChannelFollowerStatsFetchFailed(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        storeChannelFollowerStats.handleChannelFollowerStatsFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleChannelFollowerStatsFetchStart(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        storeChannelFollowerStats.handleChannelFollowerStatsFetchStart(j);
    }

    public static final /* synthetic */ void access$handleChannelFollowerStatsFetchSuccess(StoreChannelFollowerStats storeChannelFollowerStats, long j, ModelChannelFollowerStats modelChannelFollowerStats) {
        storeChannelFollowerStats.handleChannelFollowerStatsFetchSuccess(j, modelChannelFollowerStats);
    }

    public static final /* synthetic */ boolean access$isExisting(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        return storeChannelFollowerStats.isExisting(j);
    }

    public static final /* synthetic */ boolean access$isStale(StoreChannelFollowerStats storeChannelFollowerStats, long j) {
        return storeChannelFollowerStats.isStale(j);
    }

    public static final /* synthetic */ void access$setChannelFollowerStatsStateSnapshot$p(StoreChannelFollowerStats storeChannelFollowerStats, Map map) {
        storeChannelFollowerStats.channelFollowerStatsStateSnapshot = map;
    }

    @Store3
    private final void fetchIfNonexistingOrStale(long channelId) {
        this.dispatcher.schedule(new AnonymousClass1(channelId));
    }

    @Store3
    private final void handleChannelFollowerStatsFetchFailed(long channelId) {
        this.channelFollowerStatsState.put(Long.valueOf(channelId), new ChannelFollowerStatData(FetchState.FAILED, null, 2, null));
        markChanged();
    }

    @Store3
    private final void handleChannelFollowerStatsFetchStart(long channelId) {
        this.channelFollowerStatsState.put(Long.valueOf(channelId), new ChannelFollowerStatData(FetchState.FETCHING, null, 2, null));
        markChanged();
    }

    @Store3
    private final void handleChannelFollowerStatsFetchSuccess(long channelId, ModelChannelFollowerStats channelFollowerStats) {
        this.channelFollowerStatsState.put(Long.valueOf(channelId), new ChannelFollowerStatData(FetchState.SUCCEEDED, channelFollowerStats));
        markChanged();
    }

    @Store3
    private final boolean isExisting(long channelId) {
        ChannelFollowerStatData channelFollowerStatData = this.channelFollowerStatsState.get(Long.valueOf(channelId));
        return (channelFollowerStatData == null || channelFollowerStatData.getFetchState() == FetchState.FAILED) ? false : true;
    }

    @Store3
    private final boolean isStale(long channelId) {
        ModelChannelFollowerStats data;
        ChannelFollowerStatData channelFollowerStatData = this.channelFollowerStatsState.get(Long.valueOf(channelId));
        return ((channelFollowerStatData == null || (data = channelFollowerStatData.getData()) == null) ? 0L : data.getLastFetched() + ((long) 3600000)) <= ClockFactory.get().currentTimeMillis();
    }

    public final void fetchChannelFollowerStats(long channelId) {
        fetchIfNonexistingOrStale(channelId);
    }

    public final Observable<ModelChannelFollowerStats> observeChannelFollowerStats(long channelId) {
        Observable<ModelChannelFollowerStats> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.channelFollowerStatsStateSnapshot = new HashMap(this.channelFollowerStatsState);
    }
}
