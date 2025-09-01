package com.discord.widgets.status;

import androidx.annotation.MainThread;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetGlobalStatusIndicatorState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fR:\u0010\u000f\u001a&\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\n0\n \u000e*\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\n0\n\u0018\u00010\r0\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState;", "", "", "isVisible", "isPrimaryBackground", "isViewingCall", "", "updateState", "(ZZZ)V", "Lrx/Observable;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;", "observeState", "()Lrx/Observable;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "stateSubject", "Lrx/subjects/BehaviorSubject;", "<init>", "()V", "Provider", "State", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicatorState {

    /* renamed from: Provider, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final WidgetGlobalStatusIndicatorState callIndicatorState = new WidgetGlobalStatusIndicatorState();
    private final BehaviorSubject<State> stateSubject = BehaviorSubject.k0();

    /* compiled from: WidgetGlobalStatusIndicatorState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$Provider;", "", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState;", "get", "()Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState;", "callIndicatorState", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorState$Provider, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetGlobalStatusIndicatorState get() {
            return WidgetGlobalStatusIndicatorState.access$getCallIndicatorState$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0007\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\t\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\b\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;", "", "", "component1", "()Z", "component2", "component3", "isVisible", "isCustomBackground", "isViewingCall", "copy", "(ZZZ)Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class State {
        private final boolean isCustomBackground;
        private final boolean isViewingCall;
        private final boolean isVisible;

        public State(boolean z2, boolean z3, boolean z4) {
            this.isVisible = z2;
            this.isCustomBackground = z3;
            this.isViewingCall = z4;
        }

        public static /* synthetic */ State copy$default(State state, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = state.isVisible;
            }
            if ((i & 2) != 0) {
                z3 = state.isCustomBackground;
            }
            if ((i & 4) != 0) {
                z4 = state.isViewingCall;
            }
            return state.copy(z2, z3, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsVisible() {
            return this.isVisible;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsCustomBackground() {
            return this.isCustomBackground;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsViewingCall() {
            return this.isViewingCall;
        }

        public final State copy(boolean isVisible, boolean isCustomBackground, boolean isViewingCall) {
            return new State(isVisible, isCustomBackground, isViewingCall);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.isVisible == state.isVisible && this.isCustomBackground == state.isCustomBackground && this.isViewingCall == state.isViewingCall;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isVisible;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.isCustomBackground;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z3 = this.isViewingCall;
            return i3 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isCustomBackground() {
            return this.isCustomBackground;
        }

        public final boolean isViewingCall() {
            return this.isViewingCall;
        }

        public final boolean isVisible() {
            return this.isVisible;
        }

        public String toString() {
            StringBuilder sbU = outline.U("State(isVisible=");
            sbU.append(this.isVisible);
            sbU.append(", isCustomBackground=");
            sbU.append(this.isCustomBackground);
            sbU.append(", isViewingCall=");
            return outline.O(sbU, this.isViewingCall, ")");
        }
    }

    public static final /* synthetic */ WidgetGlobalStatusIndicatorState access$getCallIndicatorState$cp() {
        return callIndicatorState;
    }

    public static /* synthetic */ void updateState$default(WidgetGlobalStatusIndicatorState widgetGlobalStatusIndicatorState, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            BehaviorSubject<State> behaviorSubject = widgetGlobalStatusIndicatorState.stateSubject;
            Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "stateSubject");
            State stateN0 = behaviorSubject.n0();
            z2 = stateN0 != null ? stateN0.isVisible() : false;
        }
        if ((i & 2) != 0) {
            BehaviorSubject<State> behaviorSubject2 = widgetGlobalStatusIndicatorState.stateSubject;
            Intrinsics3.checkNotNullExpressionValue(behaviorSubject2, "stateSubject");
            State stateN02 = behaviorSubject2.n0();
            z3 = stateN02 != null ? stateN02.isCustomBackground() : false;
        }
        if ((i & 4) != 0) {
            BehaviorSubject<State> behaviorSubject3 = widgetGlobalStatusIndicatorState.stateSubject;
            Intrinsics3.checkNotNullExpressionValue(behaviorSubject3, "stateSubject");
            State stateN03 = behaviorSubject3.n0();
            z4 = stateN03 != null ? stateN03.isViewingCall() : false;
        }
        widgetGlobalStatusIndicatorState.updateState(z2, z3, z4);
    }

    public final Observable<State> observeState() {
        Observable<State> observableR = this.stateSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "stateSubject.distinctUntilChanged()");
        return observableR;
    }

    @MainThread
    public final void updateState(boolean isVisible, boolean isPrimaryBackground, boolean isViewingCall) {
        this.stateSubject.onNext(new State(isVisible, isPrimaryBackground, isViewingCall));
    }
}
