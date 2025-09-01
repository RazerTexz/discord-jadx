package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import b.d.b.a.outline;
import com.discord.stores.StoreV2;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.a0.MathJVM;
import d0.d0._Ranges;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.MutablePropertyReference1Impl;
import d0.z.d.Reflection2;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: StoreConnectivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 A2\u00020\u0001:\u0003ABCB\u001f\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b?\u0010@J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b \u0010\nJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\"\u0010\nJ\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0007H\u0007¢\u0006\u0004\b$\u0010\nR\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0013\u0010*\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u00102R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R+\u0010\u0003\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u00118B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006D"}, d2 = {"Lcom/discord/stores/StoreConnectivity;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/utilities/networking/NetworkMonitor$State;", "state", "", "handleDeviceNetworkStateUpdated", "(Lcom/discord/utilities/networking/NetworkMonitor$State;)V", "", "channelMessagesLoading", "handleChannelMessagesLoading", "(Z)V", "updateConnectivityState", "()V", "", "defaultDelay", "getStateDelay", "(J)J", "Lcom/discord/stores/StoreConnectivity$DelayedState;", "Lcom/discord/stores/StoreConnectivity$State;", "nextState", "getNextStateDelayInitial", "(Lcom/discord/stores/StoreConnectivity$DelayedState;Lcom/discord/stores/StoreConnectivity$State;)J", "getStateActiveMillis", "()J", "Lrx/Observable;", "observeState", "()Lrx/Observable;", "Lcom/discord/utilities/networking/NetworkMonitor;", "networkMonitor", "init", "(Lcom/discord/utilities/networking/NetworkMonitor;)V", "backgrounded", "handleBackgrounded", "connected", "handleConnected", "connectionReady", "handleConnectionReady", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "deviceNetworkState", "Lcom/discord/utilities/networking/NetworkMonitor$State;", "isConnected", "()Z", "stateTriggeredDelay", "J", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "isReadyPayloadReceived", "Z", "stateTriggeredTimeMillis", "Ljava/lang/Long;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "<set-?>", "state$delegate", "Lcom/discord/stores/StoreV2$MarkChangedDelegate;", "getState", "()Lcom/discord/stores/StoreConnectivity$DelayedState;", "setState", "(Lcom/discord/stores/StoreConnectivity$DelayedState;)V", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/time/Clock;)V", "Companion", "DelayedState", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreConnectivity extends StoreV2 {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection2.mutableProperty1(new MutablePropertyReference1Impl(StoreConnectivity.class, "state", "getState()Lcom/discord/stores/StoreConnectivity$DelayedState;", 0))};
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final long DELAY_EXTENDED = 10000;

    @Deprecated
    public static final long DELAY_INTERVAL = 100;

    @Deprecated
    public static final long DELAY_NOMINAL = 1000;
    private boolean channelMessagesLoading;
    private final Clock clock;
    private NetworkMonitor.State deviceNetworkState;
    private final Dispatcher dispatcher;
    private boolean isReadyPayloadReceived;

    /* renamed from: state$delegate, reason: from kotlin metadata */
    private final StoreV2.MarkChangedDelegate state;
    private long stateTriggeredDelay;
    private Long stateTriggeredTimeMillis;
    private final StoreStream stream;

    /* compiled from: StoreConnectivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/discord/stores/StoreConnectivity$Companion;", "", "", "DELAY_EXTENDED", "J", "DELAY_INTERVAL", "DELAY_NOMINAL", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreConnectivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/stores/StoreConnectivity$DelayedState;", "", "Lcom/discord/stores/StoreConnectivity$State;", "component1", "()Lcom/discord/stores/StoreConnectivity$State;", "", "component2", "()J", "state", "delay", "copy", "(Lcom/discord/stores/StoreConnectivity$State;J)Lcom/discord/stores/StoreConnectivity$DelayedState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreConnectivity$State;", "getState", "J", "getDelay", "<init>", "(Lcom/discord/stores/StoreConnectivity$State;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class DelayedState {
        private final long delay;
        private final State state;

        public DelayedState(State state, long j) {
            Intrinsics3.checkNotNullParameter(state, "state");
            this.state = state;
            this.delay = j;
        }

        public static /* synthetic */ DelayedState copy$default(DelayedState delayedState, State state, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                state = delayedState.state;
            }
            if ((i & 2) != 0) {
                j = delayedState.delay;
            }
            return delayedState.copy(state, j);
        }

        /* renamed from: component1, reason: from getter */
        public final State getState() {
            return this.state;
        }

        /* renamed from: component2, reason: from getter */
        public final long getDelay() {
            return this.delay;
        }

        public final DelayedState copy(State state, long delay) {
            Intrinsics3.checkNotNullParameter(state, "state");
            return new DelayedState(state, delay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DelayedState)) {
                return false;
            }
            DelayedState delayedState = (DelayedState) other;
            return Intrinsics3.areEqual(this.state, delayedState.state) && this.delay == delayedState.delay;
        }

        public final long getDelay() {
            return this.delay;
        }

        public final State getState() {
            return this.state;
        }

        public int hashCode() {
            State state = this.state;
            return b.a(this.delay) + ((state != null ? state.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("DelayedState(state=");
            sbU.append(this.state);
            sbU.append(", delay=");
            return outline.C(sbU, this.delay, ")");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ DelayedState(State state, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 2) != 0) {
                StoreConnectivity.access$Companion();
                j = 1000;
            }
            this(state, j);
        }
    }

    /* compiled from: StoreConnectivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/stores/StoreConnectivity$State;", "", "<init>", "(Ljava/lang/String;I)V", "ONLINE", "OFFLINE", "OFFLINE_AIRPLANE_MODE", "CONNECTING", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum State {
        ONLINE,
        OFFLINE,
        OFFLINE_AIRPLANE_MODE,
        CONNECTING
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            State.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[State.ONLINE.ordinal()] = 1;
            iArr[State.OFFLINE.ordinal()] = 2;
            iArr[State.OFFLINE_AIRPLANE_MODE.ordinal()] = 3;
            iArr[State.CONNECTING.ordinal()] = 4;
        }
    }

    /* compiled from: StoreConnectivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreConnectivity$handleChannelMessagesLoading$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $channelMessagesLoading;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$channelMessagesLoading = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreConnectivity.access$setChannelMessagesLoading$p(StoreConnectivity.this, this.$channelMessagesLoading);
            StoreConnectivity.access$updateConnectivityState(StoreConnectivity.this);
        }
    }

    /* compiled from: StoreConnectivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreConnectivity$handleDeviceNetworkStateUpdated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ NetworkMonitor.State $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(NetworkMonitor.State state) {
            super(0);
            this.$state = state;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreConnectivity.access$setDeviceNetworkState$p(StoreConnectivity.this, this.$state);
            StoreConnectivity.access$updateConnectivityState(StoreConnectivity.this);
        }
    }

    /* compiled from: StoreConnectivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/networking/NetworkMonitor$State;", "p1", "", "invoke", "(Lcom/discord/utilities/networking/NetworkMonitor$State;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreConnectivity$init$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<NetworkMonitor.State, Unit> {
        public AnonymousClass1(StoreConnectivity storeConnectivity) {
            super(1, storeConnectivity, StoreConnectivity.class, "handleDeviceNetworkStateUpdated", "handleDeviceNetworkStateUpdated(Lcom/discord/utilities/networking/NetworkMonitor$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NetworkMonitor.State state) {
            invoke2(state);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NetworkMonitor.State state) {
            Intrinsics3.checkNotNullParameter(state, "p1");
            StoreConnectivity.access$handleDeviceNetworkStateUpdated((StoreConnectivity) this.receiver, state);
        }
    }

    /* compiled from: StoreConnectivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreConnectivity$init$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass2(StoreConnectivity storeConnectivity) {
            super(1, storeConnectivity, StoreConnectivity.class, "handleChannelMessagesLoading", "handleChannelMessagesLoading(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            StoreConnectivity.access$handleChannelMessagesLoading((StoreConnectivity) this.receiver, z2);
        }
    }

    /* compiled from: StoreConnectivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreConnectivity$DelayedState;", "invoke", "()Lcom/discord/stores/StoreConnectivity$DelayedState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreConnectivity$observeState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<DelayedState> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ DelayedState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DelayedState invoke() {
            return StoreConnectivity.access$getState$p(StoreConnectivity.this);
        }
    }

    public StoreConnectivity(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.state = new StoreV2.MarkChangedDelegate(new DelayedState(State.CONNECTING, 10000L), null, 2, null);
        this.stateTriggeredDelay = 10000L;
        this.deviceNetworkState = NetworkMonitor.State.OFFLINE;
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    public static final /* synthetic */ boolean access$getChannelMessagesLoading$p(StoreConnectivity storeConnectivity) {
        return storeConnectivity.channelMessagesLoading;
    }

    public static final /* synthetic */ NetworkMonitor.State access$getDeviceNetworkState$p(StoreConnectivity storeConnectivity) {
        return storeConnectivity.deviceNetworkState;
    }

    public static final /* synthetic */ DelayedState access$getState$p(StoreConnectivity storeConnectivity) {
        return storeConnectivity.getState();
    }

    public static final /* synthetic */ void access$handleChannelMessagesLoading(StoreConnectivity storeConnectivity, boolean z2) {
        storeConnectivity.handleChannelMessagesLoading(z2);
    }

    public static final /* synthetic */ void access$handleDeviceNetworkStateUpdated(StoreConnectivity storeConnectivity, NetworkMonitor.State state) {
        storeConnectivity.handleDeviceNetworkStateUpdated(state);
    }

    public static final /* synthetic */ void access$setChannelMessagesLoading$p(StoreConnectivity storeConnectivity, boolean z2) {
        storeConnectivity.channelMessagesLoading = z2;
    }

    public static final /* synthetic */ void access$setDeviceNetworkState$p(StoreConnectivity storeConnectivity, NetworkMonitor.State state) {
        storeConnectivity.deviceNetworkState = state;
    }

    public static final /* synthetic */ void access$setState$p(StoreConnectivity storeConnectivity, DelayedState delayedState) {
        storeConnectivity.setState(delayedState);
    }

    public static final /* synthetic */ void access$updateConnectivityState(StoreConnectivity storeConnectivity) {
        storeConnectivity.updateConnectivityState();
    }

    private final long getNextStateDelayInitial(DelayedState state, State nextState) {
        int iOrdinal = nextState.ordinal();
        if (iOrdinal == 0) {
            return 1000L;
        }
        boolean z2 = true;
        if (iOrdinal == 1 || iOrdinal == 2) {
            return 1000L;
        }
        if (iOrdinal != 3) {
            throw new NoWhenBranchMatchedException();
        }
        State state2 = state.getState();
        if (state2 != State.OFFLINE && state2 != State.OFFLINE_AIRPLANE_MODE) {
            z2 = false;
        }
        return (!z2 || getStateActiveMillis() <= 1000) ? 10000L : 1000L;
    }

    private final DelayedState getState() {
        return (DelayedState) this.state.getValue(this, $$delegatedProperties[0]);
    }

    private final long getStateActiveMillis() {
        Long l = this.stateTriggeredTimeMillis;
        if (l == null) {
            return 0L;
        }
        return this.clock.currentTimeMillis() - l.longValue();
    }

    private final long getStateDelay(long defaultDelay) {
        return _Ranges.coerceAtLeast(MathJVM.roundToInt((defaultDelay - getStateActiveMillis()) / 100) * 100, 0L);
    }

    private final void handleChannelMessagesLoading(boolean channelMessagesLoading) {
        this.dispatcher.schedule(new AnonymousClass1(channelMessagesLoading));
    }

    private final void handleDeviceNetworkStateUpdated(NetworkMonitor.State state) {
        this.dispatcher.schedule(new AnonymousClass1(state));
    }

    private final void setState(DelayedState delayedState) {
        this.state.setValue(this, $$delegatedProperties[0], delayedState);
    }

    private final void updateConnectivityState() {
        NetworkMonitor.State state = this.deviceNetworkState;
        State state2 = state == NetworkMonitor.State.OFFLINE ? State.OFFLINE : state == NetworkMonitor.State.OFFLINE_AIRPLANE_MODE ? State.OFFLINE_AIRPLANE_MODE : (!this.isReadyPayloadReceived || this.channelMessagesLoading) ? State.CONNECTING : State.ONLINE;
        if (getState().getState() != state2 || this.stateTriggeredTimeMillis == null) {
            this.stateTriggeredTimeMillis = Long.valueOf(this.clock.currentTimeMillis());
            this.stateTriggeredDelay = getNextStateDelayInitial(getState(), state2);
        }
        setState(new DelayedState(state2, getStateDelay(this.stateTriggeredDelay)));
    }

    @Store3
    public final void handleBackgrounded(boolean backgrounded) {
        if (backgrounded) {
            this.stateTriggeredDelay -= getStateActiveMillis();
        }
        if (this.stateTriggeredTimeMillis != null) {
            this.stateTriggeredTimeMillis = Long.valueOf(this.clock.currentTimeMillis());
        }
        updateConnectivityState();
    }

    @Store3
    public final void handleConnected(boolean connected) {
        if (connected) {
            return;
        }
        this.isReadyPayloadReceived = false;
        updateConnectivityState();
    }

    @Store3
    public final void handleConnectionReady(boolean connectionReady) {
        this.isReadyPayloadReceived = connectionReady;
        updateConnectivityState();
    }

    @Store3
    public final void init(NetworkMonitor networkMonitor) {
        Intrinsics3.checkNotNullParameter(networkMonitor, "networkMonitor");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(networkMonitor.observeState()), StoreConnectivity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getMessagesLoader().observeChannelMessagesLoading(), StoreConnectivity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }

    public final boolean isConnected() {
        return getState().getState() == State.ONLINE;
    }

    public final Observable<DelayedState> observeState() {
        Observable<DelayedState> observableR = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider\n…  .distinctUntilChanged()");
        return observableR;
    }
}
