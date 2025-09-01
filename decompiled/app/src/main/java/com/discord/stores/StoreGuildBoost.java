package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.Tuples;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGuildBoost.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001*B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004J\u001d\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00132\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&¨\u0006+"}, d2 = {"Lcom/discord/stores/StoreGuildBoost;", "Lcom/discord/stores/StoreV2;", "", "snapshotData", "()V", "handleFetchingState", "handleFetchError", "", "Lcom/discord/models/domain/ModelGuildBoostSlot;", "guildBoostSlots", "handleFetchStateSuccess", "(Ljava/util/List;)V", "newSlot", "updateGuildBoostSlot", "(Lcom/discord/models/domain/ModelGuildBoostSlot;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/stores/StoreGuildBoost$State;", "observeGuildBoostState", "(Ljava/lang/Long;)Lrx/Observable;", "getGuildBoostsState", "(Ljava/lang/Long;)Lcom/discord/stores/StoreGuildBoost$State;", "getState", "()Lcom/discord/stores/StoreGuildBoost$State;", "fetchUserGuildBoostState", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "getDispatcher", "()Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "getObservationDeck", "()Lcom/discord/stores/updates/ObservationDeck;", "state", "Lcom/discord/stores/StoreGuildBoost$State;", "stateSnapshot", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildBoost extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private State state;
    private State stateSnapshot;

    /* compiled from: StoreGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreGuildBoost$State;", "", "<init>", "()V", "Failure", "Loaded", "Loading", "Lcom/discord/stores/StoreGuildBoost$State$Loading;", "Lcom/discord/stores/StoreGuildBoost$State$Failure;", "Lcom/discord/stores/StoreGuildBoost$State$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        /* compiled from: StoreGuildBoost.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildBoost$State$Failure;", "Lcom/discord/stores/StoreGuildBoost$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: StoreGuildBoost.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u0005\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\r\u001a\u00020\u00002\u0018\b\u0002\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R)\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/discord/stores/StoreGuildBoost$State$Loaded;", "Lcom/discord/stores/StoreGuildBoost$State;", "", "Lcom/discord/primitives/GuildId;", "guildId", "filterByGuildId", "(Ljava/lang/Long;)Lcom/discord/stores/StoreGuildBoost$State$Loaded;", "", "Lcom/discord/primitives/GuildBoostSlotId;", "Lcom/discord/models/domain/ModelGuildBoostSlot;", "component1", "()Ljava/util/Map;", "boostSlotMap", "copy", "(Ljava/util/Map;)Lcom/discord/stores/StoreGuildBoost$State$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getBoostSlotMap", "<init>", "(Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends State {
            private final Map<Long, ModelGuildBoostSlot> boostSlotMap;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Map<Long, ModelGuildBoostSlot> map) {
                super(null);
                Intrinsics3.checkNotNullParameter(map, "boostSlotMap");
                this.boostSlotMap = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.boostSlotMap;
                }
                return loaded.copy(map);
            }

            public final Map<Long, ModelGuildBoostSlot> component1() {
                return this.boostSlotMap;
            }

            public final Loaded copy(Map<Long, ModelGuildBoostSlot> boostSlotMap) {
                Intrinsics3.checkNotNullParameter(boostSlotMap, "boostSlotMap");
                return new Loaded(boostSlotMap);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.boostSlotMap, ((Loaded) other).boostSlotMap);
                }
                return true;
            }

            public final Loaded filterByGuildId(Long guildId) {
                Map<Long, ModelGuildBoostSlot> map;
                if (guildId == null) {
                    map = this.boostSlotMap;
                } else {
                    Map<Long, ModelGuildBoostSlot> map2 = this.boostSlotMap;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<Long, ModelGuildBoostSlot> entry : map2.entrySet()) {
                        ModelAppliedGuildBoost premiumGuildSubscription = entry.getValue().getPremiumGuildSubscription();
                        if (Intrinsics3.areEqual(premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null, guildId)) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    map = linkedHashMap;
                }
                return new Loaded(map);
            }

            public final Map<Long, ModelGuildBoostSlot> getBoostSlotMap() {
                return this.boostSlotMap;
            }

            public int hashCode() {
                Map<Long, ModelGuildBoostSlot> map = this.boostSlotMap;
                if (map != null) {
                    return map.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.M(outline.U("Loaded(boostSlotMap="), this.boostSlotMap, ")");
            }
        }

        /* compiled from: StoreGuildBoost.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGuildBoost$State$Loading;", "Lcom/discord/stores/StoreGuildBoost$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends State {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$1, reason: invalid class name */
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
            StoreGuildBoost.this.handleFetchingState();
        }
    }

    /* compiled from: StoreGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

        /* compiled from: StoreGuildBoost.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$2$1, reason: invalid class name */
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
                StoreGuildBoost.this.handleFetchError();
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
            StoreGuildBoost.this.getDispatcher().schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/models/domain/ModelGuildBoostSlot;", "subscriptionsSlots", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<List<? extends ModelGuildBoostSlot>, Unit> {

        /* compiled from: StoreGuildBoost.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGuildBoost$fetchUserGuildBoostState$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $subscriptionsSlots;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$subscriptionsSlots = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildBoost.this.handleFetchStateSuccess(this.$subscriptionsSlots);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGuildBoostSlot> list) {
            invoke2((List<ModelGuildBoostSlot>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelGuildBoostSlot> list) {
            Intrinsics3.checkNotNullParameter(list, "subscriptionsSlots");
            StoreGuildBoost.this.getDispatcher().schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreGuildBoost$State;", "invoke", "()Lcom/discord/stores/StoreGuildBoost$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildBoost$observeGuildBoostState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<State> {
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(0);
            this.$guildId = l;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            State stateSnapshot = StoreGuildBoost.this.getStateSnapshot();
            return stateSnapshot instanceof State.Loaded ? ((State.Loaded) stateSnapshot).filterByGuildId(this.$guildId) : stateSnapshot;
        }
    }

    /* compiled from: StoreGuildBoost.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildBoost$updateGuildBoostSlot$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelGuildBoostSlot $newSlot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelGuildBoostSlot modelGuildBoostSlot) {
            super(0);
            this.$newSlot = modelGuildBoostSlot;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            State stateAccess$getState$p = StoreGuildBoost.access$getState$p(StoreGuildBoost.this);
            if (stateAccess$getState$p instanceof State.Loaded) {
                StoreGuildBoost.access$setState$p(StoreGuildBoost.this, new State.Loaded(Maps6.plus(((State.Loaded) stateAccess$getState$p).getBoostSlotMap(), Tuples.to(Long.valueOf(this.$newSlot.getId()), this.$newSlot))));
                StoreGuildBoost.this.markChanged();
            }
        }
    }

    public StoreGuildBoost(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        State.Loading loading = State.Loading.INSTANCE;
        this.state = loading;
        this.stateSnapshot = loading;
    }

    public static final /* synthetic */ State access$getState$p(StoreGuildBoost storeGuildBoost) {
        return storeGuildBoost.state;
    }

    public static final /* synthetic */ void access$setState$p(StoreGuildBoost storeGuildBoost, State state) {
        storeGuildBoost.state = state;
    }

    public static /* synthetic */ State getGuildBoostsState$default(StoreGuildBoost storeGuildBoost, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return storeGuildBoost.getGuildBoostsState(l);
    }

    public static /* synthetic */ Observable observeGuildBoostState$default(StoreGuildBoost storeGuildBoost, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return storeGuildBoost.observeGuildBoostState(l);
    }

    public final void fetchUserGuildBoostState() {
        this.dispatcher.schedule(new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getSubscriptionSlots(), false, 1, null), StoreGuildBoost.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass3(), 54, (Object) null);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final State getGuildBoostsState(Long guildId) {
        State stateSnapshot = getStateSnapshot();
        return stateSnapshot instanceof State.Loaded ? ((State.Loaded) stateSnapshot).filterByGuildId(guildId) : stateSnapshot;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    /* renamed from: getState, reason: from getter */
    public final State getStateSnapshot() {
        return this.stateSnapshot;
    }

    @Store3
    public final void handleFetchError() {
        this.state = State.Failure.INSTANCE;
        markChanged();
    }

    @Store3
    public final void handleFetchStateSuccess(List<ModelGuildBoostSlot> guildBoostSlots) {
        Intrinsics3.checkNotNullParameter(guildBoostSlots, "guildBoostSlots");
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(guildBoostSlots, 10)), 16));
        for (Object obj : guildBoostSlots) {
            linkedHashMap.put(Long.valueOf(((ModelGuildBoostSlot) obj).getId()), obj);
        }
        this.state = new State.Loaded(linkedHashMap);
        markChanged();
    }

    @Store3
    public final void handleFetchingState() {
        this.state = State.Loading.INSTANCE;
        markChanged();
    }

    public final Observable<State> observeGuildBoostState(Long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        State loaded = this.state;
        if (!(loaded instanceof State.Loading) && !(loaded instanceof State.Failure)) {
            if (!(loaded instanceof State.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            loaded = new State.Loaded(Maps6.toMap(((State.Loaded) loaded).getBoostSlotMap()));
        }
        this.stateSnapshot = loaded;
    }

    public final void updateGuildBoostSlot(ModelGuildBoostSlot newSlot) {
        Intrinsics3.checkNotNullParameter(newSlot, "newSlot");
        this.dispatcher.schedule(new AnonymousClass1(newSlot));
    }
}
