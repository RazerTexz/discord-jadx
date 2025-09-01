package com.discord.stores;

import b.d.b.a.outline;
import com.android.billingclient.api.SkuDetails;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.billing.GooglePlayInAppSku3;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGooglePlaySkuDetails.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001b¨\u0006 "}, d2 = {"Lcom/discord/stores/StoreGooglePlaySkuDetails;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "getState", "()Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "Lrx/Observable;", "observeState", "()Lrx/Observable;", "", "Lcom/android/billingclient/api/SkuDetails;", "skuDetails", "", "updateSkuDetails", "(Ljava/util/List;)V", "handleError", "()V", "handleFetchError", "newSkuDetails", "handleFetchSuccess", "snapshotData", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "skuStateSnapshot", "Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "skuState", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/Dispatcher;)V", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGooglePlaySkuDetails extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private State skuState;
    private State skuStateSnapshot;

    /* compiled from: StoreGooglePlaySkuDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "", "<init>", "()V", "Failure", "Loaded", "Uninitialized", "Lcom/discord/stores/StoreGooglePlaySkuDetails$State$Uninitialized;", "Lcom/discord/stores/StoreGooglePlaySkuDetails$State$Failure;", "Lcom/discord/stores/StoreGooglePlaySkuDetails$State$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        /* compiled from: StoreGooglePlaySkuDetails.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGooglePlaySkuDetails$State$Failure;", "Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: StoreGooglePlaySkuDetails.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\t\u001a\u00020\u00002\u0018\b\u0002\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R)\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/discord/stores/StoreGooglePlaySkuDetails$State$Loaded;", "Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "", "", "Lcom/discord/primitives/PaymentGatewaySkuId;", "Lcom/android/billingclient/api/SkuDetails;", "component1", "()Ljava/util/Map;", "skuDetails", "copy", "(Ljava/util/Map;)Lcom/discord/stores/StoreGooglePlaySkuDetails$State$Loaded;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getSkuDetails", "<init>", "(Ljava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends State {
            private final Map<String, SkuDetails> skuDetails;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Map<String, ? extends SkuDetails> map) {
                super(null);
                Intrinsics3.checkNotNullParameter(map, "skuDetails");
                this.skuDetails = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.skuDetails;
                }
                return loaded.copy(map);
            }

            public final Map<String, SkuDetails> component1() {
                return this.skuDetails;
            }

            public final Loaded copy(Map<String, ? extends SkuDetails> skuDetails) {
                Intrinsics3.checkNotNullParameter(skuDetails, "skuDetails");
                return new Loaded(skuDetails);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.skuDetails, ((Loaded) other).skuDetails);
                }
                return true;
            }

            public final Map<String, SkuDetails> getSkuDetails() {
                return this.skuDetails;
            }

            public int hashCode() {
                Map<String, SkuDetails> map = this.skuDetails;
                if (map != null) {
                    return map.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.M(outline.U("Loaded(skuDetails="), this.skuDetails, ")");
            }
        }

        /* compiled from: StoreGooglePlaySkuDetails.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGooglePlaySkuDetails$State$Uninitialized;", "Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends State {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGooglePlaySkuDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGooglePlaySkuDetails$handleError$1, reason: invalid class name */
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
            StoreGooglePlaySkuDetails.this.handleFetchError();
        }
    }

    /* compiled from: StoreGooglePlaySkuDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "invoke", "()Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGooglePlaySkuDetails$observeState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<State> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreGooglePlaySkuDetails.this.getSkuStateSnapshot();
        }
    }

    /* compiled from: StoreGooglePlaySkuDetails.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGooglePlaySkuDetails$updateSkuDetails$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $skuDetails;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$skuDetails = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGooglePlaySkuDetails.this.handleFetchSuccess(this.$skuDetails);
        }
    }

    public StoreGooglePlaySkuDetails(ObservationDeck observationDeck, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        State.Uninitialized uninitialized = State.Uninitialized.INSTANCE;
        this.skuState = uninitialized;
        this.skuStateSnapshot = uninitialized;
    }

    /* renamed from: getState, reason: from getter */
    public final State getSkuStateSnapshot() {
        return this.skuStateSnapshot;
    }

    public final void handleError() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    @Store3
    public final void handleFetchError() {
        this.skuState = State.Failure.INSTANCE;
        markChanged();
    }

    @Store3
    public final void handleFetchSuccess(List<? extends SkuDetails> newSkuDetails) {
        Intrinsics3.checkNotNullParameter(newSkuDetails, "newSkuDetails");
        State state = this.skuState;
        if (!(state instanceof State.Loaded)) {
            state = null;
        }
        State.Loaded loaded = (State.Loaded) state;
        Map<String, SkuDetails> skuDetails = loaded != null ? loaded.getSkuDetails() : null;
        if (skuDetails == null) {
            skuDetails = Maps6.emptyMap();
        }
        Map<String, ? extends SkuDetails> mutableMap = Maps6.toMutableMap(skuDetails);
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(newSkuDetails, 10)), 16));
        for (Object obj : newSkuDetails) {
            linkedHashMap.put(((SkuDetails) obj).d(), obj);
        }
        mutableMap.putAll(linkedHashMap);
        GooglePlayInAppSku3.INSTANCE.populateSkuDetails(mutableMap);
        this.skuState = new State.Loaded(mutableMap);
        markChanged();
    }

    public final Observable<State> observeState() {
        Observable<State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        State stateCopy = this.skuState;
        if (stateCopy instanceof State.Loaded) {
            State.Loaded loaded = (State.Loaded) stateCopy;
            stateCopy = loaded.copy(new HashMap(loaded.getSkuDetails()));
        } else if (!Intrinsics3.areEqual(stateCopy, State.Uninitialized.INSTANCE) && !Intrinsics3.areEqual(stateCopy, State.Failure.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.skuStateSnapshot = stateCopy;
    }

    public final void updateSkuDetails(List<? extends SkuDetails> skuDetails) {
        Intrinsics3.checkNotNullParameter(skuDetails, "skuDetails");
        this.dispatcher.schedule(new AnonymousClass1(skuDetails));
    }
}
