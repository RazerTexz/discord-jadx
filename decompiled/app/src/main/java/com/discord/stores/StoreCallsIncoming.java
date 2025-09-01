package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelCall;
import com.discord.stores.updates.ObservationDeck;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreCallsIncoming.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b'\u0010(J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u001b\u0010\u0013\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\u0013\u0010\u0007J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001eR\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/discord/stores/StoreCallsIncoming;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "clearIncomingCall", "(J)V", "", "getIncomingCalls", "()Ljava/util/Set;", "Lrx/Observable;", "observeIncoming", "()Lrx/Observable;", "", "observeHasIncoming", "snapshotData", "()V", "removeIncomingCall", "handleVoiceChannelSelected", "Lcom/discord/models/domain/ModelCall;", NotificationCompat.CATEGORY_CALL, "handleCallCreateOrUpdate", "(Lcom/discord/models/domain/ModelCall;)V", "callDelete", "handleCallDelete", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "incomingCallSnapshot", "Ljava/util/Set;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "", "incomingCalls", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreUser;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreCallsIncoming extends StoreV2 {
    private final Dispatcher dispatcher;
    private Set<Long> incomingCallSnapshot;
    private final Set<Long> incomingCalls;
    private final ObservationDeck observationDeck;
    private final StoreUser userStore;

    /* compiled from: StoreCallsIncoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "kotlin.jvm.PlatformType", "incomingCalls", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Set;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCallsIncoming$observeHasIncoming$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Set<? extends Long>, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
            return call2((Set<Long>) set);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Set<Long> set) {
            Intrinsics3.checkNotNullExpressionValue(set, "incomingCalls");
            return Boolean.valueOf(!set.isEmpty());
        }
    }

    /* compiled from: StoreCallsIncoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "invoke", "()Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCallsIncoming$observeIncoming$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            return StoreCallsIncoming.this.getIncomingCalls();
        }
    }

    /* compiled from: StoreCallsIncoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCallsIncoming$removeIncomingCall$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

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
            StoreCallsIncoming.access$clearIncomingCall(StoreCallsIncoming.this, this.$channelId);
        }
    }

    public StoreCallsIncoming(Dispatcher dispatcher, ObservationDeck observationDeck, StoreUser storeUser) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.userStore = storeUser;
        this.incomingCalls = new HashSet();
        this.incomingCallSnapshot = new HashSet();
    }

    public static final /* synthetic */ void access$clearIncomingCall(StoreCallsIncoming storeCallsIncoming, long j) {
        storeCallsIncoming.clearIncomingCall(j);
    }

    @Store3
    private final void clearIncomingCall(long channelId) {
        if (this.incomingCalls.contains(Long.valueOf(channelId))) {
            this.incomingCalls.remove(Long.valueOf(channelId));
            markChanged();
        }
    }

    public final Set<Long> getIncomingCalls() {
        return this.incomingCallSnapshot;
    }

    @Store3
    public final void handleCallCreateOrUpdate(ModelCall call) {
        Intrinsics3.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        long channelId = call.getChannelId();
        if (!call.getRinging().contains(Long.valueOf(this.userStore.getMeSnapshot().getId()))) {
            clearIncomingCall(channelId);
        } else {
            if (this.incomingCalls.contains(Long.valueOf(channelId))) {
                return;
            }
            this.incomingCalls.add(Long.valueOf(channelId));
            markChanged();
        }
    }

    @Store3
    public final void handleCallDelete(ModelCall callDelete) {
        Intrinsics3.checkNotNullParameter(callDelete, "callDelete");
        clearIncomingCall(callDelete.getChannelId());
    }

    @Store3
    public final void handleVoiceChannelSelected(long channelId) {
        clearIncomingCall(channelId);
    }

    public final Observable<Boolean> observeHasIncoming() {
        Observable<Boolean> observableR = observeIncoming().G(AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeIncoming()\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Set<Long>> observeIncoming() {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final void removeIncomingCall(long channelId) {
        this.dispatcher.schedule(new AnonymousClass1(channelId));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.incomingCallSnapshot = new HashSet(this.incomingCalls);
    }
}
