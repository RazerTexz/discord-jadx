package com.discord.widgets.settings.billing;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StorePaymentSources;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.billing.PaymentSourceAdapter;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: SettingsBillingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB+\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/settings/billing/SettingsBillingViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$ViewState;", "", "fetchData", "()V", "Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$StoreState;)V", "", "Lcom/discord/models/domain/ModelPaymentSource;", "paymentSources", "Lcom/discord/models/domain/ModelSubscription;", "premiumSubscription", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$Item;", "generateListItems", "(Ljava/util/List;Lcom/discord/models/domain/ModelSubscription;)Ljava/util/List;", "Lcom/discord/stores/StorePaymentSources;", "storePaymentSources", "Lcom/discord/stores/StorePaymentSources;", "Lcom/discord/stores/StoreSubscriptions;", "storeSubscriptions", "Lcom/discord/stores/StoreSubscriptions;", "Lrx/Observable;", "storeObservable", "<init>", "(Lcom/discord/stores/StorePaymentSources;Lcom/discord/stores/StoreSubscriptions;Lrx/Observable;)V", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SettingsBillingViewModel extends AppViewModel<ViewState> {
    private final StorePaymentSources storePaymentSources;
    private final StoreSubscriptions storeSubscriptions;

    /* compiled from: SettingsBillingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "kotlin.jvm.PlatformType", "paymentSourcesState", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "subscriptionsState", "Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.billing.SettingsBillingViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<StorePaymentSources.PaymentSourcesState, StoreSubscriptions.SubscriptionsState, StoreState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ StoreState call(StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            return call2(paymentSourcesState, subscriptionsState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StoreState call2(StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            Intrinsics3.checkNotNullExpressionValue(paymentSourcesState, "paymentSourcesState");
            Intrinsics3.checkNotNullExpressionValue(subscriptionsState, "subscriptionsState");
            return new StoreState(paymentSourcesState, subscriptionsState);
        }
    }

    /* compiled from: SettingsBillingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.billing.SettingsBillingViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
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
            SettingsBillingViewModel.access$handleStoreState(SettingsBillingViewModel.this, storeState);
        }
    }

    /* compiled from: SettingsBillingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$StoreState;", "", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "component1", "()Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "component2", "()Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "paymentSourceState", "subscriptionsState", "copy", "(Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "getSubscriptionsState", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "getPaymentSourceState", "<init>", "(Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final StorePaymentSources.PaymentSourcesState paymentSourceState;
        private final StoreSubscriptions.SubscriptionsState subscriptionsState;

        public StoreState(StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            Intrinsics3.checkNotNullParameter(paymentSourcesState, "paymentSourceState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            this.paymentSourceState = paymentSourcesState;
            this.subscriptionsState = subscriptionsState;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState, int i, Object obj) {
            if ((i & 1) != 0) {
                paymentSourcesState = storeState.paymentSourceState;
            }
            if ((i & 2) != 0) {
                subscriptionsState = storeState.subscriptionsState;
            }
            return storeState.copy(paymentSourcesState, subscriptionsState);
        }

        /* renamed from: component1, reason: from getter */
        public final StorePaymentSources.PaymentSourcesState getPaymentSourceState() {
            return this.paymentSourceState;
        }

        /* renamed from: component2, reason: from getter */
        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        public final StoreState copy(StorePaymentSources.PaymentSourcesState paymentSourceState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            Intrinsics3.checkNotNullParameter(paymentSourceState, "paymentSourceState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            return new StoreState(paymentSourceState, subscriptionsState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.paymentSourceState, storeState.paymentSourceState) && Intrinsics3.areEqual(this.subscriptionsState, storeState.subscriptionsState);
        }

        public final StorePaymentSources.PaymentSourcesState getPaymentSourceState() {
            return this.paymentSourceState;
        }

        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        public int hashCode() {
            StorePaymentSources.PaymentSourcesState paymentSourcesState = this.paymentSourceState;
            int iHashCode = (paymentSourcesState != null ? paymentSourcesState.hashCode() : 0) * 31;
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.subscriptionsState;
            return iHashCode + (subscriptionsState != null ? subscriptionsState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(paymentSourceState=");
            sbU.append(this.paymentSourceState);
            sbU.append(", subscriptionsState=");
            sbU.append(this.subscriptionsState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: SettingsBillingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$ViewState;", "", "<init>", "()V", "Failure", "Loaded", "Loading", "Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$ViewState$Loaded;", "Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$ViewState$Loading;", "Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$ViewState$Failure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: SettingsBillingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$ViewState$Failure;", "Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends ViewState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: SettingsBillingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$ViewState$Loaded;", "Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$ViewState;", "", "Lcom/discord/widgets/settings/billing/PaymentSourceAdapter$Item;", "component1", "()Ljava/util/List;", "paymentSourceItems", "copy", "(Ljava/util/List;)Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getPaymentSourceItems", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final List<PaymentSourceAdapter.Item> paymentSourceItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends PaymentSourceAdapter.Item> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "paymentSourceItems");
                this.paymentSourceItems = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.paymentSourceItems;
                }
                return loaded.copy(list);
            }

            public final List<PaymentSourceAdapter.Item> component1() {
                return this.paymentSourceItems;
            }

            public final Loaded copy(List<? extends PaymentSourceAdapter.Item> paymentSourceItems) {
                Intrinsics3.checkNotNullParameter(paymentSourceItems, "paymentSourceItems");
                return new Loaded(paymentSourceItems);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.paymentSourceItems, ((Loaded) other).paymentSourceItems);
                }
                return true;
            }

            public final List<PaymentSourceAdapter.Item> getPaymentSourceItems() {
                return this.paymentSourceItems;
            }

            public int hashCode() {
                List<PaymentSourceAdapter.Item> list = this.paymentSourceItems;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(paymentSourceItems="), this.paymentSourceItems, ")");
            }
        }

        /* compiled from: SettingsBillingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$ViewState$Loading;", "Lcom/discord/widgets/settings/billing/SettingsBillingViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    public SettingsBillingViewModel() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SettingsBillingViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storePaymentSources = (i & 1) != 0 ? StoreStream.INSTANCE.getPaymentSources() : storePaymentSources;
        storeSubscriptions = (i & 2) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions;
        if ((i & 4) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            observable = Observable.j(companion.getPaymentSources().observePaymentSourcesState(), companion.getSubscriptions().observeSubscriptions(), AnonymousClass1.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observable, "Observable\n      .combin…nsState\n        )\n      }");
        }
        this(storePaymentSources, storeSubscriptions, observable);
    }

    public static final /* synthetic */ void access$handleStoreState(SettingsBillingViewModel settingsBillingViewModel, StoreState storeState) {
        settingsBillingViewModel.handleStoreState(storeState);
    }

    private final void fetchData() {
        this.storePaymentSources.fetchPaymentSources();
        this.storeSubscriptions.fetchSubscriptions();
    }

    private final List<PaymentSourceAdapter.Item> generateListItems(List<? extends ModelPaymentSource> paymentSources, ModelSubscription premiumSubscription) {
        ArrayList arrayList = new ArrayList();
        if (!paymentSources.isEmpty()) {
            int i = 0;
            for (Object obj : paymentSources) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                ModelPaymentSource modelPaymentSource = (ModelPaymentSource) obj;
                PaymentSourceAdapter.PaymentSourceHeader.Type type = i != 0 ? i != 1 ? null : PaymentSourceAdapter.PaymentSourceHeader.Type.OTHER : PaymentSourceAdapter.PaymentSourceHeader.Type.DEFAULT;
                PaymentSourceAdapter.PaymentSourceHeader paymentSourceHeader = type != null ? new PaymentSourceAdapter.PaymentSourceHeader(type) : null;
                if (paymentSourceHeader != null) {
                    arrayList.add(paymentSourceHeader);
                }
                arrayList.add(new PaymentSourceAdapter.PaymentSourceItem(modelPaymentSource, Intrinsics3.areEqual(modelPaymentSource.getId(), premiumSubscription != null ? premiumSubscription.getPaymentSourceId() : null) && !premiumSubscription.getStatus().isCanceled()));
                i = i2;
            }
            arrayList.add(new PaymentSourceAdapter.PaymentSourceAddItem());
        }
        return arrayList;
    }

    private final void handleStoreState(StoreState storeState) {
        StorePaymentSources.PaymentSourcesState paymentSourceState = storeState.getPaymentSourceState();
        StoreSubscriptions.SubscriptionsState subscriptionsState = storeState.getSubscriptionsState();
        if ((paymentSourceState instanceof StorePaymentSources.PaymentSourcesState.Loaded) && (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loaded)) {
            updateViewState(new ViewState.Loaded(generateListItems(((StorePaymentSources.PaymentSourcesState.Loaded) paymentSourceState).getPaymentSources(), ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsState).getPremiumSubscription())));
        } else if ((paymentSourceState instanceof StorePaymentSources.PaymentSourcesState.Failure) || (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Failure)) {
            updateViewState(ViewState.Failure.INSTANCE);
        } else {
            updateViewState(ViewState.Loading.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsBillingViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(storePaymentSources, "storePaymentSources");
        Intrinsics3.checkNotNullParameter(storeSubscriptions, "storeSubscriptions");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.storePaymentSources = storePaymentSources;
        this.storeSubscriptions = storeSubscriptions;
        fetchData();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), SettingsBillingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
