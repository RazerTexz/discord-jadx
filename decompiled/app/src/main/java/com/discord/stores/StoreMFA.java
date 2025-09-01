package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.stores.updates.ObservationDeck;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreMFA.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/discord/stores/StoreMFA;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/user/User;", "user", "", "handleUserUpdated", "(Lcom/discord/api/user/User;)V", "Lcom/discord/stores/StoreMFA$MFAActivationState;", "newActivationState", "updatePendingMFAState", "(Lcom/discord/stores/StoreMFA$MFAActivationState;)V", "togglingSMSBackup", "()V", "Lrx/Observable;", "Lcom/discord/stores/StoreMFA$State;", "observeState", "()Lrx/Observable;", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "state", "Lcom/discord/stores/StoreMFA$State;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "MFAActivationState", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMFA extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private State state;
    private final StoreStream stream;

    /* compiled from: StoreMFA.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/stores/StoreMFA$MFAActivationState;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING_ENABLED", "PENDING_DISABLED", "NONE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum MFAActivationState {
        PENDING_ENABLED,
        PENDING_DISABLED,
        NONE
    }

    /* compiled from: StoreMFA.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/stores/StoreMFA$State;", "", "Lcom/discord/stores/StoreMFA$MFAActivationState;", "component1", "()Lcom/discord/stores/StoreMFA$MFAActivationState;", "", "component2", "()Z", "activationState", "isTogglingSMSBackup", "copy", "(Lcom/discord/stores/StoreMFA$MFAActivationState;Z)Lcom/discord/stores/StoreMFA$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/stores/StoreMFA$MFAActivationState;", "getActivationState", "<init>", "(Lcom/discord/stores/StoreMFA$MFAActivationState;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class State {
        private final MFAActivationState activationState;
        private final boolean isTogglingSMSBackup;

        public State(MFAActivationState mFAActivationState, boolean z2) {
            Intrinsics3.checkNotNullParameter(mFAActivationState, "activationState");
            this.activationState = mFAActivationState;
            this.isTogglingSMSBackup = z2;
        }

        public static /* synthetic */ State copy$default(State state, MFAActivationState mFAActivationState, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                mFAActivationState = state.activationState;
            }
            if ((i & 2) != 0) {
                z2 = state.isTogglingSMSBackup;
            }
            return state.copy(mFAActivationState, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final MFAActivationState getActivationState() {
            return this.activationState;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsTogglingSMSBackup() {
            return this.isTogglingSMSBackup;
        }

        public final State copy(MFAActivationState activationState, boolean isTogglingSMSBackup) {
            Intrinsics3.checkNotNullParameter(activationState, "activationState");
            return new State(activationState, isTogglingSMSBackup);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.activationState, state.activationState) && this.isTogglingSMSBackup == state.isTogglingSMSBackup;
        }

        public final MFAActivationState getActivationState() {
            return this.activationState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MFAActivationState mFAActivationState = this.activationState;
            int iHashCode = (mFAActivationState != null ? mFAActivationState.hashCode() : 0) * 31;
            boolean z2 = this.isTogglingSMSBackup;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isTogglingSMSBackup() {
            return this.isTogglingSMSBackup;
        }

        public String toString() {
            StringBuilder sbU = outline.U("State(activationState=");
            sbU.append(this.activationState);
            sbU.append(", isTogglingSMSBackup=");
            return outline.O(sbU, this.isTogglingSMSBackup, ")");
        }
    }

    /* compiled from: StoreMFA.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreMFA$State;", "invoke", "()Lcom/discord/stores/StoreMFA$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMFA$observeState$1, reason: invalid class name */
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
            return StoreMFA.access$getState$p(StoreMFA.this);
        }
    }

    /* compiled from: StoreMFA.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMFA$togglingSMSBackup$1, reason: invalid class name */
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
            StoreMFA storeMFA = StoreMFA.this;
            StoreMFA.access$setState$p(storeMFA, State.copy$default(StoreMFA.access$getState$p(storeMFA), null, true, 1, null));
            StoreMFA.this.markChanged();
        }
    }

    /* compiled from: StoreMFA.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMFA$updatePendingMFAState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MFAActivationState $newActivationState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MFAActivationState mFAActivationState) {
            super(0);
            this.$newActivationState = mFAActivationState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMFA storeMFA = StoreMFA.this;
            StoreMFA.access$setState$p(storeMFA, State.copy$default(StoreMFA.access$getState$p(storeMFA), this.$newActivationState, false, 2, null));
            StoreMFA.this.markChanged();
        }
    }

    public StoreMFA(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.state = new State(MFAActivationState.NONE, false);
    }

    public static final /* synthetic */ State access$getState$p(StoreMFA storeMFA) {
        return storeMFA.state;
    }

    public static final /* synthetic */ void access$setState$p(StoreMFA storeMFA, State state) {
        storeMFA.state = state;
    }

    @Store3
    public final void handleUserUpdated(User user) {
        Intrinsics3.checkNotNullParameter(user, "user");
        if (user.getId() == this.stream.getUsers().getMe().getId()) {
            this.state = new State(MFAActivationState.NONE, false);
            markChanged();
        }
    }

    public final Observable<State> observeState() {
        Observable<State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void togglingSMSBackup() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void updatePendingMFAState(MFAActivationState newActivationState) {
        Intrinsics3.checkNotNullParameter(newActivationState, "newActivationState");
        this.dispatcher.schedule(new AnonymousClass1(newActivationState));
    }
}
