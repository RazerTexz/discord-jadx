package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: PriceTierPickerBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000e\u000f\u0010B!\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState;", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$StoreState;)V", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "storeGuildRoleSubscriptions", "Lrx/Observable;", "storeObservable", "<init>", "(Lcom/discord/stores/StoreGuildRoleSubscriptions;Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PriceTierPickerBottomSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guild_role_subscriptions.PriceTierPickerBottomSheetViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            PriceTierPickerBottomSheetViewModel.access$handleStoreState(PriceTierPickerBottomSheetViewModel.this, storeState);
        }
    }

    /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$Companion;", "", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/StoreGuildRoleSubscriptions;", "storeGuildRoleSubscriptions", "Lrx/Observable;", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/StoreGuildRoleSubscriptions;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildRoleSubscriptions}, false, null, null, new PriceTierPickerBottomSheetViewModel2(storeGuildRoleSubscriptions), 14, null);
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, int i, Object obj) {
            if ((i & 1) != 0) {
                observationDeck = ObservationDeck4.get();
            }
            if ((i & 2) != 0) {
                storeGuildRoleSubscriptions = StoreStream.INSTANCE.getGuildRoleSubscriptions();
            }
            return companion.observeStoreState(observationDeck, storeGuildRoleSubscriptions);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$StoreState;", "", "Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState;", "component1", "()Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState;", "priceTierState", "copy", "(Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState;)Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState;", "getPriceTierState", "<init>", "(Lcom/discord/stores/StoreGuildRoleSubscriptions$PriceTierState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final StoreGuildRoleSubscriptions.PriceTierState priceTierState;

        public StoreState(StoreGuildRoleSubscriptions.PriceTierState priceTierState) {
            Intrinsics3.checkNotNullParameter(priceTierState, "priceTierState");
            this.priceTierState = priceTierState;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreGuildRoleSubscriptions.PriceTierState priceTierState, int i, Object obj) {
            if ((i & 1) != 0) {
                priceTierState = storeState.priceTierState;
            }
            return storeState.copy(priceTierState);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreGuildRoleSubscriptions.PriceTierState getPriceTierState() {
            return this.priceTierState;
        }

        public final StoreState copy(StoreGuildRoleSubscriptions.PriceTierState priceTierState) {
            Intrinsics3.checkNotNullParameter(priceTierState, "priceTierState");
            return new StoreState(priceTierState);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && Intrinsics3.areEqual(this.priceTierState, ((StoreState) other).priceTierState);
            }
            return true;
        }

        public final StoreGuildRoleSubscriptions.PriceTierState getPriceTierState() {
            return this.priceTierState;
        }

        public int hashCode() {
            StoreGuildRoleSubscriptions.PriceTierState priceTierState = this.priceTierState;
            if (priceTierState != null) {
                return priceTierState.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(priceTierState=");
            sbU.append(this.priceTierState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState;", "", "<init>", "()V", "Failed", "Loaded", "Loading", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState$Failed;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState$Failed;", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState$Loaded;", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState;", "", "", "component1", "()Ljava/util/List;", "priceTiers", "copy", "(Ljava/util/List;)Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getPriceTiers", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final List<Integer> priceTiers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<Integer> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "priceTiers");
                this.priceTiers = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.priceTiers;
                }
                return loaded.copy(list);
            }

            public final List<Integer> component1() {
                return this.priceTiers;
            }

            public final Loaded copy(List<Integer> priceTiers) {
                Intrinsics3.checkNotNullParameter(priceTiers, "priceTiers");
                return new Loaded(priceTiers);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.priceTiers, ((Loaded) other).priceTiers);
                }
                return true;
            }

            public final List<Integer> getPriceTiers() {
                return this.priceTiers;
            }

            public int hashCode() {
                List<Integer> list = this.priceTiers;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(priceTiers="), this.priceTiers, ")");
            }
        }

        /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState$Loading;", "Lcom/discord/widgets/guild_role_subscriptions/PriceTierPickerBottomSheetViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PriceTierPickerBottomSheetViewModel() {
        this(null, null, 3, null);
    }

    public /* synthetic */ PriceTierPickerBottomSheetViewModel(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions, (i & 2) != 0 ? Companion.observeStoreState$default(INSTANCE, null, null, 3, null) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(PriceTierPickerBottomSheetViewModel priceTierPickerBottomSheetViewModel, StoreState storeState) {
        priceTierPickerBottomSheetViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        StoreGuildRoleSubscriptions.PriceTierState priceTierState = storeState.getPriceTierState();
        if (priceTierState instanceof StoreGuildRoleSubscriptions.PriceTierState.Loading) {
            updateViewState(ViewState.Loading.INSTANCE);
        } else if (priceTierState instanceof StoreGuildRoleSubscriptions.PriceTierState.Failed) {
            updateViewState(ViewState.Failed.INSTANCE);
        } else if (priceTierState instanceof StoreGuildRoleSubscriptions.PriceTierState.Loaded) {
            updateViewState(new ViewState.Loaded(((StoreGuildRoleSubscriptions.PriceTierState.Loaded) storeState.getPriceTierState()).getPriceTiers()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceTierPickerBottomSheetViewModel(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        storeGuildRoleSubscriptions.fetchPriceTiersIfNonExisting();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), PriceTierPickerBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
