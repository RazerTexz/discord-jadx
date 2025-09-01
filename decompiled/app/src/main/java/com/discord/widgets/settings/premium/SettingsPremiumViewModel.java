package com.discord.widgets.settings.premium;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.billing.ModelInvoicePreview;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreEntitlements;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StorePaymentSources;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.a.NeverObservableHolder;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: SettingsPremiumViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006-./012BI\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010%\u001a\u00020$\u0012\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0016\u0010\u0005R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR:\u0010\"\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\u00120\u0012 !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\u00120\u0012\u0018\u00010 0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u00063"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState;", "", "onCancelError", "()V", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$StoreState;)V", "Lcom/discord/models/domain/ModelSubscription;", "sub", "", "getPastDueGracePeriodDays", "(Lcom/discord/models/domain/ModelSubscription;)I", "markBusy", "fetchData", "Lrx/Observable;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event;", "getEventSubject", "()Lrx/Observable;", "onRetryClicked", "cancelSubscription", "Lcom/discord/stores/StoreSubscriptions;", "storeSubscriptions", "Lcom/discord/stores/StoreSubscriptions;", "Lcom/discord/stores/StoreGuildBoost;", "storeGuildBoost", "Lcom/discord/stores/StoreGuildBoost;", "Lcom/discord/stores/StorePaymentSources;", "storePaymentsSources", "Lcom/discord/stores/StorePaymentSources;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/StoreEntitlements;", "storeEntitlements", "Lcom/discord/stores/StoreEntitlements;", "storeObservable", "<init>", "(Lcom/discord/stores/StorePaymentSources;Lcom/discord/stores/StoreSubscriptions;Lcom/discord/stores/StoreEntitlements;Lcom/discord/stores/StoreGuildBoost;Lcom/discord/utilities/rest/RestAPI;Lrx/Observable;)V", "Companion", "Event", "InvoicePreviewFetch", "StoreState", "SubscriptionAndInvoice", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SettingsPremiumViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final RestAPI restAPI;
    private final StoreEntitlements storeEntitlements;
    private final StoreGuildBoost storeGuildBoost;
    private final StorePaymentSources storePaymentsSources;
    private final StoreSubscriptions storeSubscriptions;

    /* compiled from: SettingsPremiumViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$1, reason: invalid class name */
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
            SettingsPremiumViewModel.access$handleStoreState(SettingsPremiumViewModel.this, storeState);
        }
    }

    /* compiled from: SettingsPremiumViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJU\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Companion;", "", "Lcom/discord/stores/StorePaymentSources;", "storePaymentsSources", "Lcom/discord/stores/StoreSubscriptions;", "storeSubscriptions", "Lcom/discord/stores/StoreEntitlements;", "storeEntitlements", "Lcom/discord/stores/StoreGuildBoost;", "storeGuildBoost", "Lcom/discord/stores/StoreGooglePlaySkuDetails;", "storeGooglePlaySkuDetails", "Lcom/discord/stores/StoreGooglePlayPurchases;", "storeGooglePlayPurchases", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lrx/Observable;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$StoreState;", "observeStores", "(Lcom/discord/stores/StorePaymentSources;Lcom/discord/stores/StoreSubscriptions;Lcom/discord/stores/StoreEntitlements;Lcom/discord/stores/StoreGuildBoost;Lcom/discord/stores/StoreGooglePlaySkuDetails;Lcom/discord/stores/StoreGooglePlayPurchases;Lcom/discord/stores/StoreExperiments;Lcom/discord/utilities/rest/RestAPI;)Lrx/Observable;", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "state", "", "applyEntitlements", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$SubscriptionAndInvoice;", "getSubscriptionsAndInvoicePreview", "(Lcom/discord/utilities/rest/RestAPI;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Z)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$getSubscriptionsAndInvoicePreview(Companion companion, RestAPI restAPI, StoreSubscriptions.SubscriptionsState subscriptionsState, boolean z2) {
            return companion.getSubscriptionsAndInvoicePreview(restAPI, subscriptionsState, z2);
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, StoreEntitlements storeEntitlements, StoreGuildBoost storeGuildBoost, StoreGooglePlaySkuDetails storeGooglePlaySkuDetails, StoreGooglePlayPurchases storeGooglePlayPurchases, StoreExperiments storeExperiments, RestAPI restAPI) {
            return companion.observeStores(storePaymentSources, storeSubscriptions, storeEntitlements, storeGuildBoost, storeGooglePlaySkuDetails, storeGooglePlayPurchases, storeExperiments, restAPI);
        }

        private final Observable<SubscriptionAndInvoice> getSubscriptionsAndInvoicePreview(RestAPI restAPI, StoreSubscriptions.SubscriptionsState state, boolean applyEntitlements) {
            String id2;
            if (!(state instanceof StoreSubscriptions.SubscriptionsState.Loaded)) {
                Observable observable = NeverObservableHolder.k;
                Intrinsics3.checkNotNullExpressionValue(observable, "Observable.never()");
                return observable;
            }
            ModelSubscription premiumSubscription = ((StoreSubscriptions.SubscriptionsState.Loaded) state).getPremiumSubscription();
            if (premiumSubscription == null || (id2 = premiumSubscription.getId()) == null) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new SubscriptionAndInvoice(state, new InvoicePreviewFetch.Invoice(null)));
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(\n       …nvoice(null))\n          )");
                return scalarSynchronousObservable;
            }
            Observable<SubscriptionAndInvoice> observableM = ObservableExtensionsKt.restSubscribeOn$default(restAPI.getInvoicePreview(new RestAPIParams.InvoicePreviewBody(id2, true, applyEntitlements && !premiumSubscription.isGoogleSubscription())), false, 1, null).G(new SettingsPremiumViewModel2(state)).M(new SettingsPremiumViewModel3(state));
            Intrinsics3.checkNotNullExpressionValue(observableM, "restAPI\n              .g…ch.Error)\n              }");
            return observableM;
        }

        private final Observable<StoreState> observeStores(StorePaymentSources storePaymentsSources, StoreSubscriptions storeSubscriptions, StoreEntitlements storeEntitlements, StoreGuildBoost storeGuildBoost, StoreGooglePlaySkuDetails storeGooglePlaySkuDetails, StoreGooglePlayPurchases storeGooglePlayPurchases, StoreExperiments storeExperiments, RestAPI restAPI) {
            Observable<StoreState> observableE = Observable.e(storePaymentsSources.observePaymentSourcesState(), storeSubscriptions.observeSubscriptions().Y(new SettingsPremiumViewModel4(restAPI)), storeSubscriptions.observeSubscriptions().Y(new SettingsPremiumViewModel5(restAPI)), storeEntitlements.observeEntitlementState(), StoreGuildBoost.observeGuildBoostState$default(storeGuildBoost, null, 1, null), storeGooglePlaySkuDetails.observeState(), storeGooglePlayPurchases.observeState(), SettingsPremiumViewModel6.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n          .co…            )\n          }");
            return observableE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsPremiumViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event;", "", "<init>", "()V", "ErrorToast", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event$ErrorToast;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: SettingsPremiumViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event$ErrorToast;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event;", "", "component1", "()I", "errorStringResId", "copy", "(I)Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event$ErrorToast;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getErrorStringResId", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ErrorToast extends Event {
            private final int errorStringResId;

            public ErrorToast(@StringRes int i) {
                super(null);
                this.errorStringResId = i;
            }

            public static /* synthetic */ ErrorToast copy$default(ErrorToast errorToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = errorToast.errorStringResId;
                }
                return errorToast.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getErrorStringResId() {
                return this.errorStringResId;
            }

            public final ErrorToast copy(@StringRes int errorStringResId) {
                return new ErrorToast(errorStringResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ErrorToast) && this.errorStringResId == ((ErrorToast) other).errorStringResId;
                }
                return true;
            }

            public final int getErrorStringResId() {
                return this.errorStringResId;
            }

            public int hashCode() {
                return this.errorStringResId;
            }

            public String toString() {
                return outline.B(outline.U("ErrorToast(errorStringResId="), this.errorStringResId, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsPremiumViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;", "", "<init>", "()V", "Error", "Invoice", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch$Invoice;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch$Error;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class InvoicePreviewFetch {

        /* compiled from: SettingsPremiumViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch$Error;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends InvoicePreviewFetch {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* compiled from: SettingsPremiumViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch$Invoice;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;", "Lcom/discord/models/domain/billing/ModelInvoicePreview;", "component1", "()Lcom/discord/models/domain/billing/ModelInvoicePreview;", "modelInvoicePreview", "copy", "(Lcom/discord/models/domain/billing/ModelInvoicePreview;)Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch$Invoice;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/billing/ModelInvoicePreview;", "getModelInvoicePreview", "<init>", "(Lcom/discord/models/domain/billing/ModelInvoicePreview;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Invoice extends InvoicePreviewFetch {
            private final ModelInvoicePreview modelInvoicePreview;

            public Invoice(ModelInvoicePreview modelInvoicePreview) {
                super(null);
                this.modelInvoicePreview = modelInvoicePreview;
            }

            public static /* synthetic */ Invoice copy$default(Invoice invoice, ModelInvoicePreview modelInvoicePreview, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvoicePreview = invoice.modelInvoicePreview;
                }
                return invoice.copy(modelInvoicePreview);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelInvoicePreview getModelInvoicePreview() {
                return this.modelInvoicePreview;
            }

            public final Invoice copy(ModelInvoicePreview modelInvoicePreview) {
                return new Invoice(modelInvoicePreview);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Invoice) && Intrinsics3.areEqual(this.modelInvoicePreview, ((Invoice) other).modelInvoicePreview);
                }
                return true;
            }

            public final ModelInvoicePreview getModelInvoicePreview() {
                return this.modelInvoicePreview;
            }

            public int hashCode() {
                ModelInvoicePreview modelInvoicePreview = this.modelInvoicePreview;
                if (modelInvoicePreview != null) {
                    return modelInvoicePreview.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Invoice(modelInvoicePreview=");
                sbU.append(this.modelInvoicePreview);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private InvoicePreviewFetch() {
        }

        public /* synthetic */ InvoicePreviewFetch(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsPremiumViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u000e\u0012\u0006\u0010\u001e\u001a\u00020\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u0015¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J`\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0019\u0010\u001a\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b-\u0010\nR\u0019\u0010\u001c\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b/\u0010\u0010R\u0019\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00100\u001a\u0004\b1\u0010\rR\u0019\u0010\u001e\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00102\u001a\u0004\b3\u0010\u0014R\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00104\u001a\u0004\b5\u0010\u0007R\u0019\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010.\u001a\u0004\b6\u0010\u0010R\u0019\u0010\u001f\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b8\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00109\u001a\u0004\b:\u0010\u0004¨\u0006="}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$StoreState;", "", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "component1", "()Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "component2", "()Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "Lcom/discord/stores/StoreEntitlements$State;", "component3", "()Lcom/discord/stores/StoreEntitlements$State;", "Lcom/discord/stores/StoreGuildBoost$State;", "component4", "()Lcom/discord/stores/StoreGuildBoost$State;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;", "component5", "()Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;", "component6", "Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "component7", "()Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "Lcom/discord/stores/StoreGooglePlayPurchases$State;", "component8", "()Lcom/discord/stores/StoreGooglePlayPurchases$State;", "paymentSourcesState", "subscriptionsState", "entitlementState", "guildBoostState", "renewalInvoicePreviewFetch", "currentInvoicePreviewFetch", "skuDetailsState", "purchaseState", "copy", "(Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Lcom/discord/stores/StoreEntitlements$State;Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;Lcom/discord/stores/StoreGooglePlaySkuDetails$State;Lcom/discord/stores/StoreGooglePlayPurchases$State;)Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreEntitlements$State;", "getEntitlementState", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;", "getRenewalInvoicePreviewFetch", "Lcom/discord/stores/StoreGuildBoost$State;", "getGuildBoostState", "Lcom/discord/stores/StoreGooglePlaySkuDetails$State;", "getSkuDetailsState", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "getSubscriptionsState", "getCurrentInvoicePreviewFetch", "Lcom/discord/stores/StoreGooglePlayPurchases$State;", "getPurchaseState", "Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;", "getPaymentSourcesState", "<init>", "(Lcom/discord/stores/StorePaymentSources$PaymentSourcesState;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Lcom/discord/stores/StoreEntitlements$State;Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;Lcom/discord/stores/StoreGooglePlaySkuDetails$State;Lcom/discord/stores/StoreGooglePlayPurchases$State;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final InvoicePreviewFetch currentInvoicePreviewFetch;
        private final StoreEntitlements.State entitlementState;
        private final StoreGuildBoost.State guildBoostState;
        private final StorePaymentSources.PaymentSourcesState paymentSourcesState;
        private final StoreGooglePlayPurchases.State purchaseState;
        private final InvoicePreviewFetch renewalInvoicePreviewFetch;
        private final StoreGooglePlaySkuDetails.State skuDetailsState;
        private final StoreSubscriptions.SubscriptionsState subscriptionsState;

        public StoreState(StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState, StoreEntitlements.State state, StoreGuildBoost.State state2, InvoicePreviewFetch invoicePreviewFetch, InvoicePreviewFetch invoicePreviewFetch2, StoreGooglePlaySkuDetails.State state3, StoreGooglePlayPurchases.State state4) {
            Intrinsics3.checkNotNullParameter(paymentSourcesState, "paymentSourcesState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            Intrinsics3.checkNotNullParameter(state, "entitlementState");
            Intrinsics3.checkNotNullParameter(state2, "guildBoostState");
            Intrinsics3.checkNotNullParameter(invoicePreviewFetch, "renewalInvoicePreviewFetch");
            Intrinsics3.checkNotNullParameter(invoicePreviewFetch2, "currentInvoicePreviewFetch");
            Intrinsics3.checkNotNullParameter(state3, "skuDetailsState");
            Intrinsics3.checkNotNullParameter(state4, "purchaseState");
            this.paymentSourcesState = paymentSourcesState;
            this.subscriptionsState = subscriptionsState;
            this.entitlementState = state;
            this.guildBoostState = state2;
            this.renewalInvoicePreviewFetch = invoicePreviewFetch;
            this.currentInvoicePreviewFetch = invoicePreviewFetch2;
            this.skuDetailsState = state3;
            this.purchaseState = state4;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState, StoreEntitlements.State state, StoreGuildBoost.State state2, InvoicePreviewFetch invoicePreviewFetch, InvoicePreviewFetch invoicePreviewFetch2, StoreGooglePlaySkuDetails.State state3, StoreGooglePlayPurchases.State state4, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.paymentSourcesState : paymentSourcesState, (i & 2) != 0 ? storeState.subscriptionsState : subscriptionsState, (i & 4) != 0 ? storeState.entitlementState : state, (i & 8) != 0 ? storeState.guildBoostState : state2, (i & 16) != 0 ? storeState.renewalInvoicePreviewFetch : invoicePreviewFetch, (i & 32) != 0 ? storeState.currentInvoicePreviewFetch : invoicePreviewFetch2, (i & 64) != 0 ? storeState.skuDetailsState : state3, (i & 128) != 0 ? storeState.purchaseState : state4);
        }

        /* renamed from: component1, reason: from getter */
        public final StorePaymentSources.PaymentSourcesState getPaymentSourcesState() {
            return this.paymentSourcesState;
        }

        /* renamed from: component2, reason: from getter */
        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        /* renamed from: component3, reason: from getter */
        public final StoreEntitlements.State getEntitlementState() {
            return this.entitlementState;
        }

        /* renamed from: component4, reason: from getter */
        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        /* renamed from: component5, reason: from getter */
        public final InvoicePreviewFetch getRenewalInvoicePreviewFetch() {
            return this.renewalInvoicePreviewFetch;
        }

        /* renamed from: component6, reason: from getter */
        public final InvoicePreviewFetch getCurrentInvoicePreviewFetch() {
            return this.currentInvoicePreviewFetch;
        }

        /* renamed from: component7, reason: from getter */
        public final StoreGooglePlaySkuDetails.State getSkuDetailsState() {
            return this.skuDetailsState;
        }

        /* renamed from: component8, reason: from getter */
        public final StoreGooglePlayPurchases.State getPurchaseState() {
            return this.purchaseState;
        }

        public final StoreState copy(StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState, StoreEntitlements.State entitlementState, StoreGuildBoost.State guildBoostState, InvoicePreviewFetch renewalInvoicePreviewFetch, InvoicePreviewFetch currentInvoicePreviewFetch, StoreGooglePlaySkuDetails.State skuDetailsState, StoreGooglePlayPurchases.State purchaseState) {
            Intrinsics3.checkNotNullParameter(paymentSourcesState, "paymentSourcesState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            Intrinsics3.checkNotNullParameter(entitlementState, "entitlementState");
            Intrinsics3.checkNotNullParameter(guildBoostState, "guildBoostState");
            Intrinsics3.checkNotNullParameter(renewalInvoicePreviewFetch, "renewalInvoicePreviewFetch");
            Intrinsics3.checkNotNullParameter(currentInvoicePreviewFetch, "currentInvoicePreviewFetch");
            Intrinsics3.checkNotNullParameter(skuDetailsState, "skuDetailsState");
            Intrinsics3.checkNotNullParameter(purchaseState, "purchaseState");
            return new StoreState(paymentSourcesState, subscriptionsState, entitlementState, guildBoostState, renewalInvoicePreviewFetch, currentInvoicePreviewFetch, skuDetailsState, purchaseState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.paymentSourcesState, storeState.paymentSourcesState) && Intrinsics3.areEqual(this.subscriptionsState, storeState.subscriptionsState) && Intrinsics3.areEqual(this.entitlementState, storeState.entitlementState) && Intrinsics3.areEqual(this.guildBoostState, storeState.guildBoostState) && Intrinsics3.areEqual(this.renewalInvoicePreviewFetch, storeState.renewalInvoicePreviewFetch) && Intrinsics3.areEqual(this.currentInvoicePreviewFetch, storeState.currentInvoicePreviewFetch) && Intrinsics3.areEqual(this.skuDetailsState, storeState.skuDetailsState) && Intrinsics3.areEqual(this.purchaseState, storeState.purchaseState);
        }

        public final InvoicePreviewFetch getCurrentInvoicePreviewFetch() {
            return this.currentInvoicePreviewFetch;
        }

        public final StoreEntitlements.State getEntitlementState() {
            return this.entitlementState;
        }

        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        public final StorePaymentSources.PaymentSourcesState getPaymentSourcesState() {
            return this.paymentSourcesState;
        }

        public final StoreGooglePlayPurchases.State getPurchaseState() {
            return this.purchaseState;
        }

        public final InvoicePreviewFetch getRenewalInvoicePreviewFetch() {
            return this.renewalInvoicePreviewFetch;
        }

        public final StoreGooglePlaySkuDetails.State getSkuDetailsState() {
            return this.skuDetailsState;
        }

        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        public int hashCode() {
            StorePaymentSources.PaymentSourcesState paymentSourcesState = this.paymentSourcesState;
            int iHashCode = (paymentSourcesState != null ? paymentSourcesState.hashCode() : 0) * 31;
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.subscriptionsState;
            int iHashCode2 = (iHashCode + (subscriptionsState != null ? subscriptionsState.hashCode() : 0)) * 31;
            StoreEntitlements.State state = this.entitlementState;
            int iHashCode3 = (iHashCode2 + (state != null ? state.hashCode() : 0)) * 31;
            StoreGuildBoost.State state2 = this.guildBoostState;
            int iHashCode4 = (iHashCode3 + (state2 != null ? state2.hashCode() : 0)) * 31;
            InvoicePreviewFetch invoicePreviewFetch = this.renewalInvoicePreviewFetch;
            int iHashCode5 = (iHashCode4 + (invoicePreviewFetch != null ? invoicePreviewFetch.hashCode() : 0)) * 31;
            InvoicePreviewFetch invoicePreviewFetch2 = this.currentInvoicePreviewFetch;
            int iHashCode6 = (iHashCode5 + (invoicePreviewFetch2 != null ? invoicePreviewFetch2.hashCode() : 0)) * 31;
            StoreGooglePlaySkuDetails.State state3 = this.skuDetailsState;
            int iHashCode7 = (iHashCode6 + (state3 != null ? state3.hashCode() : 0)) * 31;
            StoreGooglePlayPurchases.State state4 = this.purchaseState;
            return iHashCode7 + (state4 != null ? state4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(paymentSourcesState=");
            sbU.append(this.paymentSourcesState);
            sbU.append(", subscriptionsState=");
            sbU.append(this.subscriptionsState);
            sbU.append(", entitlementState=");
            sbU.append(this.entitlementState);
            sbU.append(", guildBoostState=");
            sbU.append(this.guildBoostState);
            sbU.append(", renewalInvoicePreviewFetch=");
            sbU.append(this.renewalInvoicePreviewFetch);
            sbU.append(", currentInvoicePreviewFetch=");
            sbU.append(this.currentInvoicePreviewFetch);
            sbU.append(", skuDetailsState=");
            sbU.append(this.skuDetailsState);
            sbU.append(", purchaseState=");
            sbU.append(this.purchaseState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: SettingsPremiumViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$SubscriptionAndInvoice;", "", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "component1", "()Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;", "component2", "()Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;", "subscriptionsState", "invoicePreviewFetch", "copy", "(Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;)Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$SubscriptionAndInvoice;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;", "getInvoicePreviewFetch", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "getSubscriptionsState", "<init>", "(Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$InvoicePreviewFetch;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class SubscriptionAndInvoice {
        private final InvoicePreviewFetch invoicePreviewFetch;
        private final StoreSubscriptions.SubscriptionsState subscriptionsState;

        public SubscriptionAndInvoice(StoreSubscriptions.SubscriptionsState subscriptionsState, InvoicePreviewFetch invoicePreviewFetch) {
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            Intrinsics3.checkNotNullParameter(invoicePreviewFetch, "invoicePreviewFetch");
            this.subscriptionsState = subscriptionsState;
            this.invoicePreviewFetch = invoicePreviewFetch;
        }

        public static /* synthetic */ SubscriptionAndInvoice copy$default(SubscriptionAndInvoice subscriptionAndInvoice, StoreSubscriptions.SubscriptionsState subscriptionsState, InvoicePreviewFetch invoicePreviewFetch, int i, Object obj) {
            if ((i & 1) != 0) {
                subscriptionsState = subscriptionAndInvoice.subscriptionsState;
            }
            if ((i & 2) != 0) {
                invoicePreviewFetch = subscriptionAndInvoice.invoicePreviewFetch;
            }
            return subscriptionAndInvoice.copy(subscriptionsState, invoicePreviewFetch);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        /* renamed from: component2, reason: from getter */
        public final InvoicePreviewFetch getInvoicePreviewFetch() {
            return this.invoicePreviewFetch;
        }

        public final SubscriptionAndInvoice copy(StoreSubscriptions.SubscriptionsState subscriptionsState, InvoicePreviewFetch invoicePreviewFetch) {
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            Intrinsics3.checkNotNullParameter(invoicePreviewFetch, "invoicePreviewFetch");
            return new SubscriptionAndInvoice(subscriptionsState, invoicePreviewFetch);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubscriptionAndInvoice)) {
                return false;
            }
            SubscriptionAndInvoice subscriptionAndInvoice = (SubscriptionAndInvoice) other;
            return Intrinsics3.areEqual(this.subscriptionsState, subscriptionAndInvoice.subscriptionsState) && Intrinsics3.areEqual(this.invoicePreviewFetch, subscriptionAndInvoice.invoicePreviewFetch);
        }

        public final InvoicePreviewFetch getInvoicePreviewFetch() {
            return this.invoicePreviewFetch;
        }

        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        public int hashCode() {
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.subscriptionsState;
            int iHashCode = (subscriptionsState != null ? subscriptionsState.hashCode() : 0) * 31;
            InvoicePreviewFetch invoicePreviewFetch = this.invoicePreviewFetch;
            return iHashCode + (invoicePreviewFetch != null ? invoicePreviewFetch.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("SubscriptionAndInvoice(subscriptionsState=");
            sbU.append(this.subscriptionsState);
            sbU.append(", invoicePreviewFetch=");
            sbU.append(this.invoicePreviewFetch);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: SettingsPremiumViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState;", "", "<init>", "()V", "Failure", "Loaded", "Loading", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState$Loaded;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState$Loading;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState$Failure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: SettingsPremiumViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState$Failure;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Failure extends ViewState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: SettingsPremiumViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010#\u001a\u00020\t\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\u0016\u0010%\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000e\u0012\u0006\u0010&\u001a\u00020\t\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0015\u0012\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u000e\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0005\u0012\u0006\u0010+\u001a\u00020\u001e¢\u0006\u0004\bE\u0010FJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ \u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000eHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000bJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u001c\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u000eHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0013J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\bJ\u0010\u0010\u001f\u001a\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J²\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010#\u001a\u00020\t2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0018\b\u0002\u0010%\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000e2\b\b\u0002\u0010&\u001a\u00020\t2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00152\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u000e2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\b\b\u0002\u0010+\u001a\u00020\u001eHÆ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b0\u0010 J\u001a\u00103\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u000101HÖ\u0003¢\u0006\u0004\b3\u00104R\u0019\u0010+\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u00105\u001a\u0004\b6\u0010 R%\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b)\u00107\u001a\u0004\b8\u0010\u0013R\u0019\u0010#\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b#\u00109\u001a\u0004\b#\u0010\u000bR\u001f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010:\u001a\u0004\b;\u0010\bR\u001b\u0010'\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010<\u001a\u0004\b=\u0010\u0017R\u001b\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010>\u001a\u0004\b?\u0010\u0004R)\u0010%\u001a\u0012\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b%\u00107\u001a\u0004\b@\u0010\u0013R\u0019\u0010&\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b&\u00109\u001a\u0004\bA\u0010\u000bR\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010:\u001a\u0004\bB\u0010\bR\u001b\u0010(\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010<\u001a\u0004\bC\u0010\u0017R\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010:\u001a\u0004\bD\u0010\b¨\u0006G"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState$Loaded;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState;", "Lcom/discord/models/domain/ModelSubscription;", "component1", "()Lcom/discord/models/domain/ModelSubscription;", "", "Lcom/discord/models/domain/ModelPaymentSource;", "component2", "()Ljava/util/List;", "", "component3", "()Z", "Lcom/discord/models/domain/ModelEntitlement;", "component4", "", "", "Lcom/discord/primitives/GuildBoostSlotId;", "Lcom/discord/models/domain/ModelGuildBoostSlot;", "component5", "()Ljava/util/Map;", "component6", "Lcom/discord/models/domain/billing/ModelInvoicePreview;", "component7", "()Lcom/discord/models/domain/billing/ModelInvoicePreview;", "component8", "", "Lcom/android/billingclient/api/SkuDetails;", "component9", "Lcom/android/billingclient/api/Purchase;", "component10", "", "component11", "()I", "premiumSubscription", "paymentSources", "isBusy", "entitlements", "guildSubscriptions", "hasAnyGuildBoosts", "renewalInvoicePreview", "currentInvoicePreview", "skuDetails", "purchases", "pastDueGracePeriodDays", "copy", "(Lcom/discord/models/domain/ModelSubscription;Ljava/util/List;ZLjava/util/List;Ljava/util/Map;ZLcom/discord/models/domain/billing/ModelInvoicePreview;Lcom/discord/models/domain/billing/ModelInvoicePreview;Ljava/util/Map;Ljava/util/List;I)Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState$Loaded;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getPastDueGracePeriodDays", "Ljava/util/Map;", "getSkuDetails", "Z", "Ljava/util/List;", "getPurchases", "Lcom/discord/models/domain/billing/ModelInvoicePreview;", "getRenewalInvoicePreview", "Lcom/discord/models/domain/ModelSubscription;", "getPremiumSubscription", "getGuildSubscriptions", "getHasAnyGuildBoosts", "getPaymentSources", "getCurrentInvoicePreview", "getEntitlements", "<init>", "(Lcom/discord/models/domain/ModelSubscription;Ljava/util/List;ZLjava/util/List;Ljava/util/Map;ZLcom/discord/models/domain/billing/ModelInvoicePreview;Lcom/discord/models/domain/billing/ModelInvoicePreview;Ljava/util/Map;Ljava/util/List;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final ModelInvoicePreview currentInvoicePreview;
            private final List<ModelEntitlement> entitlements;
            private final Map<Long, ModelGuildBoostSlot> guildSubscriptions;
            private final boolean hasAnyGuildBoosts;
            private final boolean isBusy;
            private final int pastDueGracePeriodDays;
            private final List<ModelPaymentSource> paymentSources;
            private final ModelSubscription premiumSubscription;
            private final List<Purchase> purchases;
            private final ModelInvoicePreview renewalInvoicePreview;
            private final Map<String, SkuDetails> skuDetails;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(ModelSubscription modelSubscription, List<? extends ModelPaymentSource> list, boolean z2, List<ModelEntitlement> list2, Map<Long, ModelGuildBoostSlot> map, boolean z3, ModelInvoicePreview modelInvoicePreview, ModelInvoicePreview modelInvoicePreview2, Map<String, ? extends SkuDetails> map2, List<? extends Purchase> list3, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "paymentSources");
                Intrinsics3.checkNotNullParameter(list2, "entitlements");
                Intrinsics3.checkNotNullParameter(map, "guildSubscriptions");
                Intrinsics3.checkNotNullParameter(map2, "skuDetails");
                Intrinsics3.checkNotNullParameter(list3, "purchases");
                this.premiumSubscription = modelSubscription;
                this.paymentSources = list;
                this.isBusy = z2;
                this.entitlements = list2;
                this.guildSubscriptions = map;
                this.hasAnyGuildBoosts = z3;
                this.renewalInvoicePreview = modelInvoicePreview;
                this.currentInvoicePreview = modelInvoicePreview2;
                this.skuDetails = map2;
                this.purchases = list3;
                this.pastDueGracePeriodDays = i;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelSubscription modelSubscription, List list, boolean z2, List list2, Map map, boolean z3, ModelInvoicePreview modelInvoicePreview, ModelInvoicePreview modelInvoicePreview2, Map map2, List list3, int i, int i2, Object obj) {
                return loaded.copy((i2 & 1) != 0 ? loaded.premiumSubscription : modelSubscription, (i2 & 2) != 0 ? loaded.paymentSources : list, (i2 & 4) != 0 ? loaded.isBusy : z2, (i2 & 8) != 0 ? loaded.entitlements : list2, (i2 & 16) != 0 ? loaded.guildSubscriptions : map, (i2 & 32) != 0 ? loaded.hasAnyGuildBoosts : z3, (i2 & 64) != 0 ? loaded.renewalInvoicePreview : modelInvoicePreview, (i2 & 128) != 0 ? loaded.currentInvoicePreview : modelInvoicePreview2, (i2 & 256) != 0 ? loaded.skuDetails : map2, (i2 & 512) != 0 ? loaded.purchases : list3, (i2 & 1024) != 0 ? loaded.pastDueGracePeriodDays : i);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelSubscription getPremiumSubscription() {
                return this.premiumSubscription;
            }

            public final List<Purchase> component10() {
                return this.purchases;
            }

            /* renamed from: component11, reason: from getter */
            public final int getPastDueGracePeriodDays() {
                return this.pastDueGracePeriodDays;
            }

            public final List<ModelPaymentSource> component2() {
                return this.paymentSources;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsBusy() {
                return this.isBusy;
            }

            public final List<ModelEntitlement> component4() {
                return this.entitlements;
            }

            public final Map<Long, ModelGuildBoostSlot> component5() {
                return this.guildSubscriptions;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getHasAnyGuildBoosts() {
                return this.hasAnyGuildBoosts;
            }

            /* renamed from: component7, reason: from getter */
            public final ModelInvoicePreview getRenewalInvoicePreview() {
                return this.renewalInvoicePreview;
            }

            /* renamed from: component8, reason: from getter */
            public final ModelInvoicePreview getCurrentInvoicePreview() {
                return this.currentInvoicePreview;
            }

            public final Map<String, SkuDetails> component9() {
                return this.skuDetails;
            }

            public final Loaded copy(ModelSubscription premiumSubscription, List<? extends ModelPaymentSource> paymentSources, boolean isBusy, List<ModelEntitlement> entitlements, Map<Long, ModelGuildBoostSlot> guildSubscriptions, boolean hasAnyGuildBoosts, ModelInvoicePreview renewalInvoicePreview, ModelInvoicePreview currentInvoicePreview, Map<String, ? extends SkuDetails> skuDetails, List<? extends Purchase> purchases, int pastDueGracePeriodDays) {
                Intrinsics3.checkNotNullParameter(paymentSources, "paymentSources");
                Intrinsics3.checkNotNullParameter(entitlements, "entitlements");
                Intrinsics3.checkNotNullParameter(guildSubscriptions, "guildSubscriptions");
                Intrinsics3.checkNotNullParameter(skuDetails, "skuDetails");
                Intrinsics3.checkNotNullParameter(purchases, "purchases");
                return new Loaded(premiumSubscription, paymentSources, isBusy, entitlements, guildSubscriptions, hasAnyGuildBoosts, renewalInvoicePreview, currentInvoicePreview, skuDetails, purchases, pastDueGracePeriodDays);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.premiumSubscription, loaded.premiumSubscription) && Intrinsics3.areEqual(this.paymentSources, loaded.paymentSources) && this.isBusy == loaded.isBusy && Intrinsics3.areEqual(this.entitlements, loaded.entitlements) && Intrinsics3.areEqual(this.guildSubscriptions, loaded.guildSubscriptions) && this.hasAnyGuildBoosts == loaded.hasAnyGuildBoosts && Intrinsics3.areEqual(this.renewalInvoicePreview, loaded.renewalInvoicePreview) && Intrinsics3.areEqual(this.currentInvoicePreview, loaded.currentInvoicePreview) && Intrinsics3.areEqual(this.skuDetails, loaded.skuDetails) && Intrinsics3.areEqual(this.purchases, loaded.purchases) && this.pastDueGracePeriodDays == loaded.pastDueGracePeriodDays;
            }

            public final ModelInvoicePreview getCurrentInvoicePreview() {
                return this.currentInvoicePreview;
            }

            public final List<ModelEntitlement> getEntitlements() {
                return this.entitlements;
            }

            public final Map<Long, ModelGuildBoostSlot> getGuildSubscriptions() {
                return this.guildSubscriptions;
            }

            public final boolean getHasAnyGuildBoosts() {
                return this.hasAnyGuildBoosts;
            }

            public final int getPastDueGracePeriodDays() {
                return this.pastDueGracePeriodDays;
            }

            public final List<ModelPaymentSource> getPaymentSources() {
                return this.paymentSources;
            }

            public final ModelSubscription getPremiumSubscription() {
                return this.premiumSubscription;
            }

            public final List<Purchase> getPurchases() {
                return this.purchases;
            }

            public final ModelInvoicePreview getRenewalInvoicePreview() {
                return this.renewalInvoicePreview;
            }

            public final Map<String, SkuDetails> getSkuDetails() {
                return this.skuDetails;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                ModelSubscription modelSubscription = this.premiumSubscription;
                int iHashCode = (modelSubscription != null ? modelSubscription.hashCode() : 0) * 31;
                List<ModelPaymentSource> list = this.paymentSources;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                boolean z2 = this.isBusy;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                List<ModelEntitlement> list2 = this.entitlements;
                int iHashCode3 = (i2 + (list2 != null ? list2.hashCode() : 0)) * 31;
                Map<Long, ModelGuildBoostSlot> map = this.guildSubscriptions;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                boolean z3 = this.hasAnyGuildBoosts;
                int i3 = (iHashCode4 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
                ModelInvoicePreview modelInvoicePreview = this.renewalInvoicePreview;
                int iHashCode5 = (i3 + (modelInvoicePreview != null ? modelInvoicePreview.hashCode() : 0)) * 31;
                ModelInvoicePreview modelInvoicePreview2 = this.currentInvoicePreview;
                int iHashCode6 = (iHashCode5 + (modelInvoicePreview2 != null ? modelInvoicePreview2.hashCode() : 0)) * 31;
                Map<String, SkuDetails> map2 = this.skuDetails;
                int iHashCode7 = (iHashCode6 + (map2 != null ? map2.hashCode() : 0)) * 31;
                List<Purchase> list3 = this.purchases;
                return ((iHashCode7 + (list3 != null ? list3.hashCode() : 0)) * 31) + this.pastDueGracePeriodDays;
            }

            public final boolean isBusy() {
                return this.isBusy;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(premiumSubscription=");
                sbU.append(this.premiumSubscription);
                sbU.append(", paymentSources=");
                sbU.append(this.paymentSources);
                sbU.append(", isBusy=");
                sbU.append(this.isBusy);
                sbU.append(", entitlements=");
                sbU.append(this.entitlements);
                sbU.append(", guildSubscriptions=");
                sbU.append(this.guildSubscriptions);
                sbU.append(", hasAnyGuildBoosts=");
                sbU.append(this.hasAnyGuildBoosts);
                sbU.append(", renewalInvoicePreview=");
                sbU.append(this.renewalInvoicePreview);
                sbU.append(", currentInvoicePreview=");
                sbU.append(this.currentInvoicePreview);
                sbU.append(", skuDetails=");
                sbU.append(this.skuDetails);
                sbU.append(", purchases=");
                sbU.append(this.purchases);
                sbU.append(", pastDueGracePeriodDays=");
                return outline.B(sbU, this.pastDueGracePeriodDays, ")");
            }
        }

        /* compiled from: SettingsPremiumViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState$Loading;", "Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    /* compiled from: SettingsPremiumViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$cancelSubscription$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            SettingsPremiumViewModel.access$fetchData(SettingsPremiumViewModel.this);
        }
    }

    /* compiled from: SettingsPremiumViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.settings.premium.SettingsPremiumViewModel$cancelSubscription$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
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
            SettingsPremiumViewModel.access$onCancelError(SettingsPremiumViewModel.this);
        }
    }

    public SettingsPremiumViewModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SettingsPremiumViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, StoreEntitlements storeEntitlements, StoreGuildBoost storeGuildBoost, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableAccess$observeStores;
        StorePaymentSources paymentSources = (i & 1) != 0 ? StoreStream.INSTANCE.getPaymentSources() : storePaymentSources;
        StoreSubscriptions subscriptions = (i & 2) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions;
        StoreEntitlements entitlements = (i & 4) != 0 ? StoreStream.INSTANCE.getEntitlements() : storeEntitlements;
        StoreGuildBoost guildBoosts = (i & 8) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : storeGuildBoost;
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 32) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableAccess$observeStores = Companion.access$observeStores(companion, companion2.getPaymentSources(), companion2.getSubscriptions(), companion2.getEntitlements(), companion2.getGuildBoosts(), companion2.getGooglePlaySkuDetails(), companion2.getGooglePlayPurchases(), companion2.getExperiments(), RestAPI.INSTANCE.getApi());
        } else {
            observableAccess$observeStores = observable;
        }
        this(paymentSources, subscriptions, entitlements, guildBoosts, api, observableAccess$observeStores);
    }

    public static final /* synthetic */ void access$fetchData(SettingsPremiumViewModel settingsPremiumViewModel) {
        settingsPremiumViewModel.fetchData();
    }

    public static final /* synthetic */ void access$handleStoreState(SettingsPremiumViewModel settingsPremiumViewModel, StoreState storeState) {
        settingsPremiumViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$onCancelError(SettingsPremiumViewModel settingsPremiumViewModel) {
        settingsPremiumViewModel.onCancelError();
    }

    private final void fetchData() {
        this.storePaymentsSources.fetchPaymentSources();
        this.storeSubscriptions.fetchSubscriptions();
        this.storeEntitlements.fetchMyEntitlementsForApplication(521842831262875670L);
        this.storeGuildBoost.fetchUserGuildBoostState();
        GooglePlayBillingManager.INSTANCE.querySkuDetails();
    }

    private final int getPastDueGracePeriodDays(ModelSubscription sub) {
        if (sub != null && !sub.isMobileManaged()) {
            String paymentSourceId = sub.getPaymentSourceId();
            if (!(paymentSourceId == null || StringsJVM.isBlank(paymentSourceId))) {
                return 7;
            }
        }
        return 3;
    }

    private final void handleStoreState(StoreState storeState) {
        ViewState loaded;
        StorePaymentSources.PaymentSourcesState paymentSourcesState = storeState.getPaymentSourcesState();
        StoreSubscriptions.SubscriptionsState subscriptionsState = storeState.getSubscriptionsState();
        StoreEntitlements.State entitlementState = storeState.getEntitlementState();
        StoreGuildBoost.State guildBoostState = storeState.getGuildBoostState();
        InvoicePreviewFetch renewalInvoicePreviewFetch = storeState.getRenewalInvoicePreviewFetch();
        InvoicePreviewFetch currentInvoicePreviewFetch = storeState.getCurrentInvoicePreviewFetch();
        StoreGooglePlaySkuDetails.State skuDetailsState = storeState.getSkuDetailsState();
        StoreGooglePlayPurchases.State purchaseState = storeState.getPurchaseState();
        if ((paymentSourcesState instanceof StorePaymentSources.PaymentSourcesState.Loaded) && (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loaded) && (entitlementState instanceof StoreEntitlements.State.Loaded) && (guildBoostState instanceof StoreGuildBoost.State.Loaded) && (renewalInvoicePreviewFetch instanceof InvoicePreviewFetch.Invoice) && (currentInvoicePreviewFetch instanceof InvoicePreviewFetch.Invoice) && (skuDetailsState instanceof StoreGooglePlaySkuDetails.State.Loaded) && (purchaseState instanceof StoreGooglePlayPurchases.State.Loaded)) {
            ModelSubscription premiumSubscription = ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsState).getPremiumSubscription();
            boolean zHasAnyOfPlans = premiumSubscription != null ? premiumSubscription.hasAnyOfPlans(Sets5.setOf((Object[]) new Long[]{Long.valueOf(SubscriptionPlanType.PREMIUM_GUILD_MONTH.getPlanId()), Long.valueOf(SubscriptionPlanType.PREMIUM_GUILD_3_MONTH.getPlanId()), Long.valueOf(SubscriptionPlanType.PREMIUM_GUILD_6_MONTH.getPlanId()), Long.valueOf(SubscriptionPlanType.PREMIUM_GUILD_YEAR.getPlanId())})) : false;
            List<ModelPaymentSource> paymentSources = ((StorePaymentSources.PaymentSourcesState.Loaded) paymentSourcesState).getPaymentSources();
            List<ModelEntitlement> listEmptyList = ((StoreEntitlements.State.Loaded) entitlementState).getOwnedEntitlements().get(521842831262875670L);
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            loaded = new ViewState.Loaded(premiumSubscription, paymentSources, false, listEmptyList, ((StoreGuildBoost.State.Loaded) guildBoostState).getBoostSlotMap(), zHasAnyOfPlans, ((InvoicePreviewFetch.Invoice) renewalInvoicePreviewFetch).getModelInvoicePreview(), ((InvoicePreviewFetch.Invoice) currentInvoicePreviewFetch).getModelInvoicePreview(), ((StoreGooglePlaySkuDetails.State.Loaded) skuDetailsState).getSkuDetails(), ((StoreGooglePlayPurchases.State.Loaded) purchaseState).getPurchases(), getPastDueGracePeriodDays(premiumSubscription));
        } else {
            loaded = ((paymentSourcesState instanceof StorePaymentSources.PaymentSourcesState.Failure) || (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Failure) || (guildBoostState instanceof StoreGuildBoost.State.Failure) || (renewalInvoicePreviewFetch instanceof InvoicePreviewFetch.Error) || (skuDetailsState instanceof StoreGooglePlaySkuDetails.State.Failure)) ? ViewState.Failure.INSTANCE : ViewState.Loading.INSTANCE;
        }
        updateViewState(loaded);
    }

    private final void markBusy() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, null, null, true, null, null, false, null, null, null, null, 0, 2043, null));
        }
    }

    private final void onCancelError() {
        if (getViewState() instanceof ViewState.Loaded) {
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(new Event.ErrorToast(R.string.premium_alert_error_title));
        }
    }

    @MainThread
    public final void cancelSubscription() {
        ModelSubscription premiumSubscription;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (premiumSubscription = loaded.getPremiumSubscription()) == null) {
            return;
        }
        markBusy();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.deleteSubscription(premiumSubscription.getId()), false, 1, null), this, null, 2, null), SettingsPremiumViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    @MainThread
    public final Observable<Event> getEventSubject() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onRetryClicked() {
        fetchData();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsPremiumViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, StoreEntitlements storeEntitlements, StoreGuildBoost storeGuildBoost, RestAPI restAPI, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(storePaymentSources, "storePaymentsSources");
        Intrinsics3.checkNotNullParameter(storeSubscriptions, "storeSubscriptions");
        Intrinsics3.checkNotNullParameter(storeEntitlements, "storeEntitlements");
        Intrinsics3.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.storePaymentsSources = storePaymentSources;
        this.storeSubscriptions = storeSubscriptions;
        this.storeEntitlements = storeEntitlements;
        this.storeGuildBoost = storeGuildBoost;
        this.restAPI = restAPI;
        this.eventSubject = PublishSubject.k0();
        fetchData();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), SettingsPremiumViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
