package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import b.d.b.a.outline;
import com.android.billingclient.api.Purchase;
import com.discord.restapi.RestAPIParams;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.BillingUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.p.Schedulers2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import retrofit2.HttpException;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: StoreGooglePlayPurchases.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 v2\u00020\u0001:\u0006wvxyz{B7\u0012\u0006\u0010g\u001a\u00020f\u0012\u0006\u0010k\u001a\u00020j\u0012\u0006\u0010n\u001a\u00020m\u0012\u0006\u0010Y\u001a\u00020X\u0012\u0006\u0010a\u001a\u00020`\u0012\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\bt\u0010uJ\u001f\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\u00020\t2\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\t2\n\u0010\f\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\u0010\f\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0019\u001a\u00020\t2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u001c\u0010\u000eJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u001d\u0010\u000eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010\"J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\u0013\u0010'\u001a\b\u0012\u0004\u0012\u00020#0&¢\u0006\u0004\b'\u0010(J\r\u0010*\u001a\u00020)¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\b\u0012\u0004\u0012\u00020)0&¢\u0006\u0004\b,\u0010(J\u0013\u0010.\u001a\b\u0012\u0004\u0012\u00020-0&¢\u0006\u0004\b.\u0010(J=\u00108\u001a\u00020\t2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\n\u00101\u001a\u00060/j\u0002`02\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J)\u0010<\u001a\u00020\t2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0003¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\t2\n\u0010\f\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b>\u0010\u000eJ\u0019\u0010?\u001a\u00020\t2\n\u0010\f\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b?\u0010\u000eJ\u0017\u0010A\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\bA\u0010\u0014J\u000f\u0010B\u001a\u00020\tH\u0016¢\u0006\u0004\bB\u0010CJ%\u0010E\u001a\u00020\t2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0004\bE\u0010\u001aJ\r\u0010F\u001a\u00020\t¢\u0006\u0004\bF\u0010CJ\r\u0010G\u001a\u00020 ¢\u0006\u0004\bG\u0010HJ\r\u0010I\u001a\u00020\t¢\u0006\u0004\bI\u0010CJ\r\u0010J\u001a\u00020\t¢\u0006\u0004\bJ\u0010CJ\u0015\u0010M\u001a\u00020\t2\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bM\u0010NJ\u0015\u0010O\u001a\u00020\t2\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bO\u0010NR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0016\u0010Y\u001a\u00020X8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010\u00118B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010e\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010dR\u0016\u0010g\u001a\u00020f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010i\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010_R\u0016\u0010k\u001a\u00020j8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010n\u001a\u00020m8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR:\u0010r\u001a&\u0012\f\u0012\n q*\u0004\u0018\u00010-0- q*\u0012\u0012\f\u0012\n q*\u0004\u0018\u00010-0-\u0018\u00010p0p8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010s¨\u0006|"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases;", "Lcom/discord/stores/StoreV2;", "", "", "Lcom/discord/primitives/PaymentGatewaySkuId;", "Lcom/discord/stores/StoreGooglePlayPurchases$AnalyticsTrait;", "getCachedAnalyticsTraitsMap", "()Ljava/util/Map;", "analyticsTraitsMap", "", "cacheAnalyticsTraits", "(Ljava/util/Map;)V", "paymentGatewaySkuId", "clearAnalyticsTraits", "(Ljava/lang/String;)V", "getOrClearAnalyticsTraits", "(Ljava/lang/String;)Lcom/discord/stores/StoreGooglePlayPurchases$AnalyticsTrait;", "Lcom/discord/stores/PendingDowngrade;", "downgrade", "doDowngrade", "(Lcom/discord/stores/PendingDowngrade;)V", "", "Lcom/android/billingclient/api/Purchase;", "newPurchases", "skuType", "handlePurchases", "(Ljava/util/List;Ljava/lang/String;)V", "newSkuName", "handleDowngradeSuccess", "handleDowngradeFailure", "", "throwable", "", "shouldRetryDowngrade", "(Ljava/lang/Throwable;)Z", "Lcom/discord/stores/StoreGooglePlayPurchases$State;", "getState", "()Lcom/discord/stores/StoreGooglePlayPurchases$State;", "Lrx/Observable;", "observeState", "()Lrx/Observable;", "Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;", "getQueryState", "()Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;", "observeQueryState", "Lcom/discord/stores/StoreGooglePlayPurchases$Event;", "observeEvents", "", "Lcom/discord/primitives/SkuId;", "skuId", "Lcom/discord/utilities/analytics/Traits$Location;", "locationTrait", "Lcom/discord/utilities/analytics/Traits$StoreSku;", "storeSkuTrait", "Lcom/discord/utilities/analytics/Traits$Payment;", "paymentTrait", "trackPaymentFlowStarted", "(Ljava/lang/String;JLcom/discord/utilities/analytics/Traits$Location;Lcom/discord/utilities/analytics/Traits$StoreSku;Lcom/discord/utilities/analytics/Traits$Payment;)V", "fromStep", "toStep", "trackPaymentFlowStep", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "trackPaymentFlowFailed", "trackPaymentFlowCompleted", "newPendingDowngrade", "updatePendingDowngrade", "snapshotData", "()V", "purchases", "processPurchases", "downgradePurchase", "hasSeenGiftingWarning", "()Z", "markViewedGiftingWarning", "onVerificationStart", "Lcom/discord/stores/StoreGooglePlayPurchases$VerificationResult;", "verificationResult", "onVerificationSuccess", "(Lcom/discord/stores/StoreGooglePlayPurchases$VerificationResult;)V", "onVerificationFailure", "Lcom/discord/utilities/analytics/AnalyticsTracker;", "analyticsTracker", "Lcom/discord/utilities/analytics/AnalyticsTracker;", "getIapPurchases", "()Ljava/util/List;", "iapPurchases", "getSubscriptionPurchases", "subscriptionPurchases", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "getPendingDowngrade", "()Lcom/discord/stores/PendingDowngrade;", "pendingDowngrade", "storeStateSnapshot", "Lcom/discord/stores/StoreGooglePlayPurchases$State;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "queryStateSnapshot", "Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;", "queryState", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "storeState", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/utilities/time/Clock;Lcom/google/gson/Gson;Lcom/discord/utilities/analytics/AnalyticsTracker;)V", "Companion", "AnalyticsTrait", "Event", "QueryState", "State", "VerificationResult", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGooglePlayPurchases extends StoreV2 {
    private static final long CACHED_ANALYTICS_TTL = 259200000;
    private static final String CACHE_KEY_PAYMENT_FLOW_ANALYTICS = "CACHE_KEY_PAYMENT_FLOW_ANALYTICS";
    private static final String VIEWED_GIFTING_WARNING_DIALOG = "VIEWED_GIFTING_WARNING_DIALOG";
    private final AnalyticsTracker analyticsTracker;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final PublishSubject<Event> eventSubject;
    private final Gson gson;
    private final ObservationDeck observationDeck;
    private QueryState queryState;
    private QueryState queryStateSnapshot;
    private final RestAPI restAPI;
    private State storeState;
    private State storeStateSnapshot;

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u0006\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b+\u0010,J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\u0016\u001a\u00020\u00002\f\b\u0002\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u0012\u001a\u00060\u0002j\u0002`\u00062\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001d\u0010\u0011\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u0005R\u0019\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010\u0010R\u0019\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010\rR\u001d\u0010\u0012\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b(\u0010\u0005R\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\n¨\u0006-"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$AnalyticsTrait;", "", "", "Lcom/discord/primitives/SkuId;", "component1", "()J", "Lcom/discord/primitives/Timestamp;", "component2", "Lcom/discord/utilities/analytics/Traits$Location;", "component3", "()Lcom/discord/utilities/analytics/Traits$Location;", "Lcom/discord/utilities/analytics/Traits$StoreSku;", "component4", "()Lcom/discord/utilities/analytics/Traits$StoreSku;", "Lcom/discord/utilities/analytics/Traits$Payment;", "component5", "()Lcom/discord/utilities/analytics/Traits$Payment;", "skuId", "timestamp", "locationTrait", "storeSkuTrait", "paymentTrait", "copy", "(JJLcom/discord/utilities/analytics/Traits$Location;Lcom/discord/utilities/analytics/Traits$StoreSku;Lcom/discord/utilities/analytics/Traits$Payment;)Lcom/discord/stores/StoreGooglePlayPurchases$AnalyticsTrait;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getSkuId", "Lcom/discord/utilities/analytics/Traits$Payment;", "getPaymentTrait", "Lcom/discord/utilities/analytics/Traits$StoreSku;", "getStoreSkuTrait", "getTimestamp", "Lcom/discord/utilities/analytics/Traits$Location;", "getLocationTrait", "<init>", "(JJLcom/discord/utilities/analytics/Traits$Location;Lcom/discord/utilities/analytics/Traits$StoreSku;Lcom/discord/utilities/analytics/Traits$Payment;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class AnalyticsTrait {
        private final Traits.Location locationTrait;
        private final Traits.Payment paymentTrait;
        private final long skuId;
        private final Traits.StoreSku storeSkuTrait;
        private final long timestamp;

        public AnalyticsTrait(long j, long j2, Traits.Location location, Traits.StoreSku storeSku, Traits.Payment payment) {
            Intrinsics3.checkNotNullParameter(location, "locationTrait");
            Intrinsics3.checkNotNullParameter(storeSku, "storeSkuTrait");
            Intrinsics3.checkNotNullParameter(payment, "paymentTrait");
            this.skuId = j;
            this.timestamp = j2;
            this.locationTrait = location;
            this.storeSkuTrait = storeSku;
            this.paymentTrait = payment;
        }

        public static /* synthetic */ AnalyticsTrait copy$default(AnalyticsTrait analyticsTrait, long j, long j2, Traits.Location location, Traits.StoreSku storeSku, Traits.Payment payment, int i, Object obj) {
            return analyticsTrait.copy((i & 1) != 0 ? analyticsTrait.skuId : j, (i & 2) != 0 ? analyticsTrait.timestamp : j2, (i & 4) != 0 ? analyticsTrait.locationTrait : location, (i & 8) != 0 ? analyticsTrait.storeSkuTrait : storeSku, (i & 16) != 0 ? analyticsTrait.paymentTrait : payment);
        }

        /* renamed from: component1, reason: from getter */
        public final long getSkuId() {
            return this.skuId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* renamed from: component3, reason: from getter */
        public final Traits.Location getLocationTrait() {
            return this.locationTrait;
        }

        /* renamed from: component4, reason: from getter */
        public final Traits.StoreSku getStoreSkuTrait() {
            return this.storeSkuTrait;
        }

        /* renamed from: component5, reason: from getter */
        public final Traits.Payment getPaymentTrait() {
            return this.paymentTrait;
        }

        public final AnalyticsTrait copy(long skuId, long timestamp, Traits.Location locationTrait, Traits.StoreSku storeSkuTrait, Traits.Payment paymentTrait) {
            Intrinsics3.checkNotNullParameter(locationTrait, "locationTrait");
            Intrinsics3.checkNotNullParameter(storeSkuTrait, "storeSkuTrait");
            Intrinsics3.checkNotNullParameter(paymentTrait, "paymentTrait");
            return new AnalyticsTrait(skuId, timestamp, locationTrait, storeSkuTrait, paymentTrait);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnalyticsTrait)) {
                return false;
            }
            AnalyticsTrait analyticsTrait = (AnalyticsTrait) other;
            return this.skuId == analyticsTrait.skuId && this.timestamp == analyticsTrait.timestamp && Intrinsics3.areEqual(this.locationTrait, analyticsTrait.locationTrait) && Intrinsics3.areEqual(this.storeSkuTrait, analyticsTrait.storeSkuTrait) && Intrinsics3.areEqual(this.paymentTrait, analyticsTrait.paymentTrait);
        }

        public final Traits.Location getLocationTrait() {
            return this.locationTrait;
        }

        public final Traits.Payment getPaymentTrait() {
            return this.paymentTrait;
        }

        public final long getSkuId() {
            return this.skuId;
        }

        public final Traits.StoreSku getStoreSkuTrait() {
            return this.storeSkuTrait;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            int iA = (b.a(this.timestamp) + (b.a(this.skuId) * 31)) * 31;
            Traits.Location location = this.locationTrait;
            int iHashCode = (iA + (location != null ? location.hashCode() : 0)) * 31;
            Traits.StoreSku storeSku = this.storeSkuTrait;
            int iHashCode2 = (iHashCode + (storeSku != null ? storeSku.hashCode() : 0)) * 31;
            Traits.Payment payment = this.paymentTrait;
            return iHashCode2 + (payment != null ? payment.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("AnalyticsTrait(skuId=");
            sbU.append(this.skuId);
            sbU.append(", timestamp=");
            sbU.append(this.timestamp);
            sbU.append(", locationTrait=");
            sbU.append(this.locationTrait);
            sbU.append(", storeSkuTrait=");
            sbU.append(this.storeSkuTrait);
            sbU.append(", paymentTrait=");
            sbU.append(this.paymentTrait);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$Event;", "", "<init>", "()V", "PurchaseQueryFailure", "PurchaseQuerySuccess", "Lcom/discord/stores/StoreGooglePlayPurchases$Event$PurchaseQuerySuccess;", "Lcom/discord/stores/StoreGooglePlayPurchases$Event$PurchaseQueryFailure;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: StoreGooglePlayPurchases.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$Event$PurchaseQueryFailure;", "Lcom/discord/stores/StoreGooglePlayPurchases$Event;", "", "component1", "()Ljava/lang/String;", "newSkuName", "copy", "(Ljava/lang/String;)Lcom/discord/stores/StoreGooglePlayPurchases$Event$PurchaseQueryFailure;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getNewSkuName", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class PurchaseQueryFailure extends Event {
            private final String newSkuName;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PurchaseQueryFailure(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "newSkuName");
                this.newSkuName = str;
            }

            public static /* synthetic */ PurchaseQueryFailure copy$default(PurchaseQueryFailure purchaseQueryFailure, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = purchaseQueryFailure.newSkuName;
                }
                return purchaseQueryFailure.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getNewSkuName() {
                return this.newSkuName;
            }

            public final PurchaseQueryFailure copy(String newSkuName) {
                Intrinsics3.checkNotNullParameter(newSkuName, "newSkuName");
                return new PurchaseQueryFailure(newSkuName);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof PurchaseQueryFailure) && Intrinsics3.areEqual(this.newSkuName, ((PurchaseQueryFailure) other).newSkuName);
                }
                return true;
            }

            public final String getNewSkuName() {
                return this.newSkuName;
            }

            public int hashCode() {
                String str = this.newSkuName;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("PurchaseQueryFailure(newSkuName="), this.newSkuName, ")");
            }
        }

        /* compiled from: StoreGooglePlayPurchases.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JJ\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR!\u0010\r\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\bR!\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001d\u0010\bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$Event$PurchaseQuerySuccess;", "Lcom/discord/stores/StoreGooglePlayPurchases$Event;", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/SkuId;", "component2", "()Ljava/lang/Long;", "Lcom/discord/primitives/PlanId;", "component3", "component4", "newSkuName", "skuId", "subscriptionPlanId", "giftCode", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/discord/stores/StoreGooglePlayPurchases$Event$PurchaseQuerySuccess;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getSkuId", "getSubscriptionPlanId", "Ljava/lang/String;", "getNewSkuName", "getGiftCode", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class PurchaseQuerySuccess extends Event {
            private final String giftCode;
            private final String newSkuName;
            private final Long skuId;
            private final Long subscriptionPlanId;

            public /* synthetic */ PurchaseQuerySuccess(String str, Long l, Long l2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : str2);
            }

            public static /* synthetic */ PurchaseQuerySuccess copy$default(PurchaseQuerySuccess purchaseQuerySuccess, String str, Long l, Long l2, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = purchaseQuerySuccess.newSkuName;
                }
                if ((i & 2) != 0) {
                    l = purchaseQuerySuccess.skuId;
                }
                if ((i & 4) != 0) {
                    l2 = purchaseQuerySuccess.subscriptionPlanId;
                }
                if ((i & 8) != 0) {
                    str2 = purchaseQuerySuccess.giftCode;
                }
                return purchaseQuerySuccess.copy(str, l, l2, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getNewSkuName() {
                return this.newSkuName;
            }

            /* renamed from: component2, reason: from getter */
            public final Long getSkuId() {
                return this.skuId;
            }

            /* renamed from: component3, reason: from getter */
            public final Long getSubscriptionPlanId() {
                return this.subscriptionPlanId;
            }

            /* renamed from: component4, reason: from getter */
            public final String getGiftCode() {
                return this.giftCode;
            }

            public final PurchaseQuerySuccess copy(String newSkuName, Long skuId, Long subscriptionPlanId, String giftCode) {
                Intrinsics3.checkNotNullParameter(newSkuName, "newSkuName");
                return new PurchaseQuerySuccess(newSkuName, skuId, subscriptionPlanId, giftCode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PurchaseQuerySuccess)) {
                    return false;
                }
                PurchaseQuerySuccess purchaseQuerySuccess = (PurchaseQuerySuccess) other;
                return Intrinsics3.areEqual(this.newSkuName, purchaseQuerySuccess.newSkuName) && Intrinsics3.areEqual(this.skuId, purchaseQuerySuccess.skuId) && Intrinsics3.areEqual(this.subscriptionPlanId, purchaseQuerySuccess.subscriptionPlanId) && Intrinsics3.areEqual(this.giftCode, purchaseQuerySuccess.giftCode);
            }

            public final String getGiftCode() {
                return this.giftCode;
            }

            public final String getNewSkuName() {
                return this.newSkuName;
            }

            public final Long getSkuId() {
                return this.skuId;
            }

            public final Long getSubscriptionPlanId() {
                return this.subscriptionPlanId;
            }

            public int hashCode() {
                String str = this.newSkuName;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                Long l = this.skuId;
                int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
                Long l2 = this.subscriptionPlanId;
                int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
                String str2 = this.giftCode;
                return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("PurchaseQuerySuccess(newSkuName=");
                sbU.append(this.newSkuName);
                sbU.append(", skuId=");
                sbU.append(this.skuId);
                sbU.append(", subscriptionPlanId=");
                sbU.append(this.subscriptionPlanId);
                sbU.append(", giftCode=");
                return outline.J(sbU, this.giftCode, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PurchaseQuerySuccess(String str, Long l, Long l2, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "newSkuName");
                this.newSkuName = str;
                this.skuId = l;
                this.subscriptionPlanId = l2;
                this.giftCode = str2;
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;", "", "<init>", "()V", "InProgress", "NotInProgress", "Lcom/discord/stores/StoreGooglePlayPurchases$QueryState$NotInProgress;", "Lcom/discord/stores/StoreGooglePlayPurchases$QueryState$InProgress;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class QueryState {

        /* compiled from: StoreGooglePlayPurchases.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$QueryState$InProgress;", "Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class InProgress extends QueryState {
            public static final InProgress INSTANCE = new InProgress();

            private InProgress() {
                super(null);
            }
        }

        /* compiled from: StoreGooglePlayPurchases.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$QueryState$NotInProgress;", "Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class NotInProgress extends QueryState {
            public static final NotInProgress INSTANCE = new NotInProgress();

            private NotInProgress() {
                super(null);
            }
        }

        private QueryState() {
        }

        public /* synthetic */ QueryState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$State;", "", "<init>", "()V", "Loaded", "Uninitialized", "Lcom/discord/stores/StoreGooglePlayPurchases$State$Uninitialized;", "Lcom/discord/stores/StoreGooglePlayPurchases$State$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        /* compiled from: StoreGooglePlayPurchases.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$State$Uninitialized;", "Lcom/discord/stores/StoreGooglePlayPurchases$State;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends State {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private State() {
        }

        /* compiled from: StoreGooglePlayPurchases.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b \u0010!J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ<\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001f\u0010\u0005¨\u0006\""}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$State$Loaded;", "Lcom/discord/stores/StoreGooglePlayPurchases$State;", "", "Lcom/android/billingclient/api/Purchase;", "getPurchases", "()Ljava/util/List;", "component1", "component2", "Lcom/discord/stores/PendingDowngrade;", "component3", "()Lcom/discord/stores/PendingDowngrade;", "subscriptionPurchases", "iapPurchases", "pendingDowngrade", "copy", "(Ljava/util/List;Ljava/util/List;Lcom/discord/stores/PendingDowngrade;)Lcom/discord/stores/StoreGooglePlayPurchases$State$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/PendingDowngrade;", "getPendingDowngrade", "Ljava/util/List;", "getSubscriptionPurchases", "getIapPurchases", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/discord/stores/PendingDowngrade;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends State {
            private final List<Purchase> iapPurchases;
            private final StoreGooglePlayPurchases2 pendingDowngrade;
            private final List<Purchase> subscriptionPurchases;

            public /* synthetic */ Loaded(List list, List list2, StoreGooglePlayPurchases2 storeGooglePlayPurchases2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? Collections2.emptyList() : list, (i & 2) != 0 ? Collections2.emptyList() : list2, storeGooglePlayPurchases2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, List list2, StoreGooglePlayPurchases2 storeGooglePlayPurchases2, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.subscriptionPurchases;
                }
                if ((i & 2) != 0) {
                    list2 = loaded.iapPurchases;
                }
                if ((i & 4) != 0) {
                    storeGooglePlayPurchases2 = loaded.pendingDowngrade;
                }
                return loaded.copy(list, list2, storeGooglePlayPurchases2);
            }

            public final List<Purchase> component1() {
                return this.subscriptionPurchases;
            }

            public final List<Purchase> component2() {
                return this.iapPurchases;
            }

            /* renamed from: component3, reason: from getter */
            public final StoreGooglePlayPurchases2 getPendingDowngrade() {
                return this.pendingDowngrade;
            }

            public final Loaded copy(List<? extends Purchase> subscriptionPurchases, List<? extends Purchase> iapPurchases, StoreGooglePlayPurchases2 pendingDowngrade) {
                Intrinsics3.checkNotNullParameter(subscriptionPurchases, "subscriptionPurchases");
                Intrinsics3.checkNotNullParameter(iapPurchases, "iapPurchases");
                return new Loaded(subscriptionPurchases, iapPurchases, pendingDowngrade);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.subscriptionPurchases, loaded.subscriptionPurchases) && Intrinsics3.areEqual(this.iapPurchases, loaded.iapPurchases) && Intrinsics3.areEqual(this.pendingDowngrade, loaded.pendingDowngrade);
            }

            public final List<Purchase> getIapPurchases() {
                return this.iapPurchases;
            }

            public final StoreGooglePlayPurchases2 getPendingDowngrade() {
                return this.pendingDowngrade;
            }

            public final List<Purchase> getPurchases() {
                return _Collections.plus((Collection) this.subscriptionPurchases, (Iterable) this.iapPurchases);
            }

            public final List<Purchase> getSubscriptionPurchases() {
                return this.subscriptionPurchases;
            }

            public int hashCode() {
                List<Purchase> list = this.subscriptionPurchases;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                List<Purchase> list2 = this.iapPurchases;
                int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
                StoreGooglePlayPurchases2 storeGooglePlayPurchases2 = this.pendingDowngrade;
                return iHashCode2 + (storeGooglePlayPurchases2 != null ? storeGooglePlayPurchases2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(subscriptionPurchases=");
                sbU.append(this.subscriptionPurchases);
                sbU.append(", iapPurchases=");
                sbU.append(this.iapPurchases);
                sbU.append(", pendingDowngrade=");
                sbU.append(this.pendingDowngrade);
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends Purchase> list, List<? extends Purchase> list2, StoreGooglePlayPurchases2 storeGooglePlayPurchases2) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "subscriptionPurchases");
                Intrinsics3.checkNotNullParameter(list2, "iapPurchases");
                this.subscriptionPurchases = list;
                this.iapPurchases = list2;
                this.pendingDowngrade = storeGooglePlayPurchases2;
            }
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$VerificationResult;", "", "Lcom/android/billingclient/api/Purchase;", "component1", "()Lcom/android/billingclient/api/Purchase;", "Lcom/discord/restapi/RestAPIParams$VerifyPurchaseResponse;", "component2", "()Lcom/discord/restapi/RestAPIParams$VerifyPurchaseResponse;", "purchase", "apiResponse", "copy", "(Lcom/android/billingclient/api/Purchase;Lcom/discord/restapi/RestAPIParams$VerifyPurchaseResponse;)Lcom/discord/stores/StoreGooglePlayPurchases$VerificationResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/android/billingclient/api/Purchase;", "getPurchase", "Lcom/discord/restapi/RestAPIParams$VerifyPurchaseResponse;", "getApiResponse", "<init>", "(Lcom/android/billingclient/api/Purchase;Lcom/discord/restapi/RestAPIParams$VerifyPurchaseResponse;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class VerificationResult {
        private final RestAPIParams.VerifyPurchaseResponse apiResponse;
        private final Purchase purchase;

        public VerificationResult(Purchase purchase, RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse) {
            Intrinsics3.checkNotNullParameter(purchase, "purchase");
            this.purchase = purchase;
            this.apiResponse = verifyPurchaseResponse;
        }

        public static /* synthetic */ VerificationResult copy$default(VerificationResult verificationResult, Purchase purchase, RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse, int i, Object obj) {
            if ((i & 1) != 0) {
                purchase = verificationResult.purchase;
            }
            if ((i & 2) != 0) {
                verifyPurchaseResponse = verificationResult.apiResponse;
            }
            return verificationResult.copy(purchase, verifyPurchaseResponse);
        }

        /* renamed from: component1, reason: from getter */
        public final Purchase getPurchase() {
            return this.purchase;
        }

        /* renamed from: component2, reason: from getter */
        public final RestAPIParams.VerifyPurchaseResponse getApiResponse() {
            return this.apiResponse;
        }

        public final VerificationResult copy(Purchase purchase, RestAPIParams.VerifyPurchaseResponse apiResponse) {
            Intrinsics3.checkNotNullParameter(purchase, "purchase");
            return new VerificationResult(purchase, apiResponse);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerificationResult)) {
                return false;
            }
            VerificationResult verificationResult = (VerificationResult) other;
            return Intrinsics3.areEqual(this.purchase, verificationResult.purchase) && Intrinsics3.areEqual(this.apiResponse, verificationResult.apiResponse);
        }

        public final RestAPIParams.VerifyPurchaseResponse getApiResponse() {
            return this.apiResponse;
        }

        public final Purchase getPurchase() {
            return this.purchase;
        }

        public int hashCode() {
            Purchase purchase = this.purchase;
            int iHashCode = (purchase != null ? purchase.hashCode() : 0) * 31;
            RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse = this.apiResponse;
            return iHashCode + (verifyPurchaseResponse != null ? verifyPurchaseResponse.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("VerificationResult(purchase=");
            sbU.append(this.purchase);
            sbU.append(", apiResponse=");
            sbU.append(this.apiResponse);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Ljava/lang/Throwable;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Throwable, Boolean> {
        public AnonymousClass1(StoreGooglePlayPurchases storeGooglePlayPurchases) {
            super(1, storeGooglePlayPurchases, StoreGooglePlayPurchases.class, "shouldRetryDowngrade", "shouldRetryDowngrade(Ljava/lang/Throwable;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
            return Boolean.valueOf(invoke2(th));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Throwable th) {
            Intrinsics3.checkNotNullParameter(th, "p1");
            return StoreGooglePlayPurchases.access$shouldRetryDowngrade((StoreGooglePlayPurchases) this.receiver, th);
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Object, Unit> {
        public final /* synthetic */ String $newSkuName;

        /* compiled from: StoreGooglePlayPurchases.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$2$1, reason: invalid class name */
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
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreGooglePlayPurchases.access$handleDowngradeSuccess(StoreGooglePlayPurchases.this, anonymousClass2.$newSkuName);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$newSkuName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            StoreGooglePlayPurchases.access$getDispatcher$p(StoreGooglePlayPurchases.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $newSkuName;

        /* compiled from: StoreGooglePlayPurchases.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$3$1, reason: invalid class name */
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
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreGooglePlayPurchases.access$handleDowngradeFailure(StoreGooglePlayPurchases.this, anonymousClass3.$newSkuName);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str) {
            super(1);
            this.$newSkuName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreGooglePlayPurchases.access$getDispatcher$p(StoreGooglePlayPurchases.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$downgradePurchase$1, reason: invalid class name */
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
            State stateAccess$getStoreState$p = StoreGooglePlayPurchases.access$getStoreState$p(StoreGooglePlayPurchases.this);
            if (stateAccess$getStoreState$p instanceof State.Loaded) {
                State.Loaded loaded = (State.Loaded) stateAccess$getStoreState$p;
                if (loaded.getPendingDowngrade() != null) {
                    StoreGooglePlayPurchases.access$setQueryState$p(StoreGooglePlayPurchases.this, QueryState.InProgress.INSTANCE);
                    StoreGooglePlayPurchases.this.markChanged();
                    StoreGooglePlayPurchases.access$doDowngrade(StoreGooglePlayPurchases.this, loaded.getPendingDowngrade());
                }
            }
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;", "invoke", "()Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$observeQueryState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<QueryState> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ QueryState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final QueryState invoke() {
            return StoreGooglePlayPurchases.this.getQueryStateSnapshot();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$State;", "invoke", "()Lcom/discord/stores/StoreGooglePlayPurchases$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$observeState$1, reason: invalid class name */
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
            return StoreGooglePlayPurchases.this.getStoreStateSnapshot();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$onVerificationFailure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VerificationResult $verificationResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(VerificationResult verificationResult) {
            super(0);
            this.$verificationResult = verificationResult;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ArrayList<String> arrayListB = this.$verificationResult.getPurchase().b();
            Intrinsics3.checkNotNullExpressionValue(arrayListB, "verificationResult.purchase.skus");
            for (String str : arrayListB) {
                PublishSubject publishSubjectAccess$getEventSubject$p = StoreGooglePlayPurchases.access$getEventSubject$p(StoreGooglePlayPurchases.this);
                Intrinsics3.checkNotNullExpressionValue(str, "sku");
                publishSubjectAccess$getEventSubject$p.k.onNext(new Event.PurchaseQueryFailure(str));
            }
            StoreGooglePlayPurchases.access$setQueryState$p(StoreGooglePlayPurchases.this, QueryState.NotInProgress.INSTANCE);
            StoreGooglePlayPurchases.this.markChanged();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$onVerificationStart$1, reason: invalid class name */
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
            StoreGooglePlayPurchases.access$setQueryState$p(StoreGooglePlayPurchases.this, QueryState.InProgress.INSTANCE);
            StoreGooglePlayPurchases.this.markChanged();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$processPurchases$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $purchases;
        public final /* synthetic */ String $skuType;

        /* compiled from: StoreGooglePlayPurchases.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreGooglePlayPurchases$processPurchases$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01161 extends Lambda implements Function1<QueryState, Unit> {
            public C01161() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QueryState queryState) {
                invoke2(queryState);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QueryState queryState) {
                if (queryState instanceof QueryState.NotInProgress) {
                    BillingUtils.INSTANCE.verifyPurchases(AnonymousClass1.this.$purchases);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, String str) {
            super(0);
            this.$purchases = list;
            this.$skuType = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGooglePlayPurchases.access$handlePurchases(StoreGooglePlayPurchases.this, this.$purchases, this.$skuType);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreGooglePlayPurchases.this.observeQueryState(), 0L, false, 3, null), StoreGooglePlayPurchases.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C01161(), 62, (Object) null);
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$updatePendingDowngrade$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ StoreGooglePlayPurchases2 $newPendingDowngrade;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreGooglePlayPurchases2 storeGooglePlayPurchases2) {
            super(0);
            this.$newPendingDowngrade = storeGooglePlayPurchases2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGooglePlayPurchases storeGooglePlayPurchases = StoreGooglePlayPurchases.this;
            StoreGooglePlayPurchases.access$setStoreState$p(storeGooglePlayPurchases, new State.Loaded(StoreGooglePlayPurchases.access$getSubscriptionPurchases$p(storeGooglePlayPurchases), StoreGooglePlayPurchases.access$getIapPurchases$p(StoreGooglePlayPurchases.this), this.$newPendingDowngrade));
            StoreGooglePlayPurchases.this.markChanged();
        }
    }

    public StoreGooglePlayPurchases(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI, Clock clock, Gson gson, AnalyticsTracker analyticsTracker) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(gson, "gson");
        Intrinsics3.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.clock = clock;
        this.gson = gson;
        this.analyticsTracker = analyticsTracker;
        State.Uninitialized uninitialized = State.Uninitialized.INSTANCE;
        this.storeState = uninitialized;
        this.storeStateSnapshot = uninitialized;
        QueryState.NotInProgress notInProgress = QueryState.NotInProgress.INSTANCE;
        this.queryState = notInProgress;
        this.queryStateSnapshot = notInProgress;
        this.eventSubject = PublishSubject.k0();
    }

    public static final /* synthetic */ void access$doDowngrade(StoreGooglePlayPurchases storeGooglePlayPurchases, StoreGooglePlayPurchases2 storeGooglePlayPurchases2) {
        storeGooglePlayPurchases.doDowngrade(storeGooglePlayPurchases2);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.dispatcher;
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.eventSubject;
    }

    public static final /* synthetic */ List access$getIapPurchases$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.getIapPurchases();
    }

    public static final /* synthetic */ QueryState access$getQueryState$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.queryState;
    }

    public static final /* synthetic */ State access$getStoreState$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.storeState;
    }

    public static final /* synthetic */ List access$getSubscriptionPurchases$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.getSubscriptionPurchases();
    }

    public static final /* synthetic */ void access$handleDowngradeFailure(StoreGooglePlayPurchases storeGooglePlayPurchases, String str) {
        storeGooglePlayPurchases.handleDowngradeFailure(str);
    }

    public static final /* synthetic */ void access$handleDowngradeSuccess(StoreGooglePlayPurchases storeGooglePlayPurchases, String str) {
        storeGooglePlayPurchases.handleDowngradeSuccess(str);
    }

    public static final /* synthetic */ void access$handlePurchases(StoreGooglePlayPurchases storeGooglePlayPurchases, List list, String str) {
        storeGooglePlayPurchases.handlePurchases(list, str);
    }

    public static final /* synthetic */ void access$setQueryState$p(StoreGooglePlayPurchases storeGooglePlayPurchases, QueryState queryState) {
        storeGooglePlayPurchases.queryState = queryState;
    }

    public static final /* synthetic */ void access$setStoreState$p(StoreGooglePlayPurchases storeGooglePlayPurchases, State state) {
        storeGooglePlayPurchases.storeState = state;
    }

    public static final /* synthetic */ boolean access$shouldRetryDowngrade(StoreGooglePlayPurchases storeGooglePlayPurchases, Throwable th) {
        return storeGooglePlayPurchases.shouldRetryDowngrade(th);
    }

    private final void cacheAnalyticsTraits(Map<String, AnalyticsTrait> analyticsTraitsMap) throws JsonIOException {
        getPrefs().edit().putString(CACHE_KEY_PAYMENT_FLOW_ANALYTICS, this.gson.m(analyticsTraitsMap)).apply();
    }

    private final void clearAnalyticsTraits(String paymentGatewaySkuId) throws JsonIOException {
        Map<String, AnalyticsTrait> cachedAnalyticsTraitsMap = getCachedAnalyticsTraitsMap();
        cachedAnalyticsTraitsMap.remove(paymentGatewaySkuId);
        cacheAnalyticsTraits(cachedAnalyticsTraitsMap);
    }

    @Store3
    private final void doDowngrade(StoreGooglePlayPurchases2 downgrade) {
        String purchaseToken = downgrade.getPurchaseToken();
        String subscriptionId = downgrade.getSubscriptionId();
        String newSkuName = downgrade.getNewSkuName();
        RestAPIParams.DowngradeSubscriptionBody downgradeSubscriptionBody = new RestAPIParams.DowngradeSubscriptionBody(subscriptionId, purchaseToken, newSkuName);
        RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
        Observable<Object> observableX = this.restAPI.downgradeSubscription(downgradeSubscriptionBody).X(Schedulers2.c());
        Intrinsics3.checkNotNullExpressionValue(observableX, "restAPI\n        .downgra…scribeOn(Schedulers.io())");
        ObservableExtensionsKt.appSubscribe$default(RetryWithDelay.restRetry$default(retryWithDelay, observableX, 0L, null, null, new AnonymousClass1(this), 1, null), StoreGooglePlayPurchases.class, (Context) null, (Function1) null, new AnonymousClass3(newSkuName), (Function0) null, (Function0) null, new AnonymousClass2(newSkuName), 54, (Object) null);
    }

    private final Map<String, AnalyticsTrait> getCachedAnalyticsTraitsMap() {
        String string = getPrefs().getString(CACHE_KEY_PAYMENT_FLOW_ANALYTICS, null);
        if (string != null) {
            Map<String, AnalyticsTrait> map = (Map) this.gson.g(string, new StoreGooglePlayPurchases4().getType());
            if (map != null) {
                return map;
            }
        }
        return new LinkedHashMap();
    }

    private final List<Purchase> getIapPurchases() {
        State storeStateSnapshot = getStoreStateSnapshot();
        if (!(storeStateSnapshot instanceof State.Loaded)) {
            storeStateSnapshot = null;
        }
        State.Loaded loaded = (State.Loaded) storeStateSnapshot;
        List<Purchase> iapPurchases = loaded != null ? loaded.getIapPurchases() : null;
        return iapPurchases != null ? iapPurchases : Collections2.emptyList();
    }

    private final AnalyticsTrait getOrClearAnalyticsTraits(String paymentGatewaySkuId) throws JsonIOException {
        AnalyticsTrait analyticsTrait = getCachedAnalyticsTraitsMap().get(paymentGatewaySkuId);
        if (analyticsTrait == null) {
            return null;
        }
        if (!(this.clock.currentTimeMillis() - analyticsTrait.getTimestamp() > CACHED_ANALYTICS_TTL)) {
            return analyticsTrait;
        }
        clearAnalyticsTraits(paymentGatewaySkuId);
        return null;
    }

    private final StoreGooglePlayPurchases2 getPendingDowngrade() {
        State storeStateSnapshot = getStoreStateSnapshot();
        if (!(storeStateSnapshot instanceof State.Loaded)) {
            storeStateSnapshot = null;
        }
        State.Loaded loaded = (State.Loaded) storeStateSnapshot;
        if (loaded != null) {
            return loaded.getPendingDowngrade();
        }
        return null;
    }

    private final List<Purchase> getSubscriptionPurchases() {
        State storeStateSnapshot = getStoreStateSnapshot();
        if (!(storeStateSnapshot instanceof State.Loaded)) {
            storeStateSnapshot = null;
        }
        State.Loaded loaded = (State.Loaded) storeStateSnapshot;
        List<Purchase> subscriptionPurchases = loaded != null ? loaded.getSubscriptionPurchases() : null;
        return subscriptionPurchases != null ? subscriptionPurchases : Collections2.emptyList();
    }

    @Store3
    private final void handleDowngradeFailure(String newSkuName) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.PurchaseQueryFailure(newSkuName));
        updatePendingDowngrade(null);
        this.queryState = QueryState.NotInProgress.INSTANCE;
        markChanged();
    }

    @Store3
    private final void handleDowngradeSuccess(String newSkuName) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.PurchaseQuerySuccess(newSkuName, null, null, null, 14, null));
        updatePendingDowngrade(null);
        this.queryState = QueryState.NotInProgress.INSTANCE;
        markChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b7  */
    @Store3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handlePurchases(List<? extends Purchase> newPurchases, String skuType) {
        State loaded;
        int iHashCode = skuType.hashCode();
        boolean z2 = false;
        if (iHashCode == 3541555 ? !(!skuType.equals("subs") || newPurchases == null || newPurchases.size() != getSubscriptionPurchases().size() || !newPurchases.containsAll(getSubscriptionPurchases()) || !getSubscriptionPurchases().containsAll(newPurchases)) : !(iHashCode != 100343516 || !skuType.equals("inapp") || newPurchases == null || newPurchases.size() != getIapPurchases().size() || !newPurchases.containsAll(getIapPurchases()) || !getIapPurchases().containsAll(newPurchases))) {
            z2 = true;
        }
        if (newPurchases != null && (!newPurchases.isEmpty()) && z2) {
            return;
        }
        int iHashCode2 = skuType.hashCode();
        if (iHashCode2 != 3541555) {
            if (iHashCode2 == 100343516 && skuType.equals("inapp")) {
                if (newPurchases == null) {
                    newPurchases = Collections2.emptyList();
                }
                loaded = new State.Loaded(getSubscriptionPurchases(), newPurchases, getPendingDowngrade());
            } else {
                loaded = State.Uninitialized.INSTANCE;
            }
        } else if (skuType.equals("subs")) {
            if (newPurchases == null) {
                newPurchases = Collections2.emptyList();
            }
            loaded = new State.Loaded(newPurchases, getIapPurchases(), getPendingDowngrade());
        }
        this.storeState = loaded;
        markChanged();
    }

    private final boolean shouldRetryDowngrade(Throwable throwable) {
        if (throwable instanceof TimeoutException) {
            return false;
        }
        if (!(throwable instanceof HttpException)) {
            return throwable instanceof IOException;
        }
        int iA = ((HttpException) throwable).a();
        return 500 <= iA && 599 >= iA;
    }

    public final void downgradePurchase() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    /* renamed from: getQueryState, reason: from getter */
    public final QueryState getQueryStateSnapshot() {
        return this.queryStateSnapshot;
    }

    /* renamed from: getState, reason: from getter */
    public final State getStoreStateSnapshot() {
        return this.storeStateSnapshot;
    }

    public final boolean hasSeenGiftingWarning() {
        return getPrefs().getBoolean(VIEWED_GIFTING_WARNING_DIALOG, false);
    }

    public final void markViewedGiftingWarning() {
        getPrefs().edit().putBoolean(VIEWED_GIFTING_WARNING_DIALOG, true).apply();
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<QueryState> observeQueryState() {
        Observable<QueryState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<State> observeState() {
        Observable<State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void onVerificationFailure(VerificationResult verificationResult) {
        Intrinsics3.checkNotNullParameter(verificationResult, "verificationResult");
        this.dispatcher.schedule(new AnonymousClass1(verificationResult));
    }

    public final void onVerificationStart() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void onVerificationSuccess(VerificationResult verificationResult) {
        Intrinsics3.checkNotNullParameter(verificationResult, "verificationResult");
        ArrayList<String> arrayListB = verificationResult.getPurchase().b();
        Intrinsics3.checkNotNullExpressionValue(arrayListB, "verificationResult.purchase.skus");
        Iterator<T> it = arrayListB.iterator();
        while (it.hasNext()) {
            this.dispatcher.schedule(new StoreGooglePlayPurchases3((String) it.next(), this, verificationResult));
        }
    }

    public final void processPurchases(List<? extends Purchase> purchases, String skuType) {
        Intrinsics3.checkNotNullParameter(skuType, "skuType");
        this.dispatcher.schedule(new AnonymousClass1(purchases, skuType));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        State stateCopy$default = this.storeState;
        if (stateCopy$default instanceof State.Loaded) {
            State.Loaded loaded = (State.Loaded) stateCopy$default;
            stateCopy$default = State.Loaded.copy$default(loaded, new ArrayList(loaded.getSubscriptionPurchases()), new ArrayList(loaded.getIapPurchases()), null, 4, null);
        } else if (!Intrinsics3.areEqual(stateCopy$default, State.Uninitialized.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.storeStateSnapshot = stateCopy$default;
        this.queryStateSnapshot = this.queryState;
    }

    public final void trackPaymentFlowCompleted(String paymentGatewaySkuId) throws JsonIOException {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        AnalyticsTrait orClearAnalyticsTraits = getOrClearAnalyticsTraits(paymentGatewaySkuId);
        if (orClearAnalyticsTraits != null) {
            AnalyticsTracker.paymentFlowCompleted$default(this.analyticsTracker, orClearAnalyticsTraits.getLocationTrait(), null, orClearAnalyticsTraits.getPaymentTrait(), orClearAnalyticsTraits.getStoreSkuTrait(), null, 18, null);
            clearAnalyticsTraits(paymentGatewaySkuId);
        }
    }

    public final void trackPaymentFlowFailed(String paymentGatewaySkuId) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        AnalyticsTrait orClearAnalyticsTraits = getOrClearAnalyticsTraits(paymentGatewaySkuId);
        if (orClearAnalyticsTraits != null) {
            AnalyticsTracker.paymentFlowFailed$default(this.analyticsTracker, orClearAnalyticsTraits.getLocationTrait(), null, orClearAnalyticsTraits.getStoreSkuTrait(), orClearAnalyticsTraits.getPaymentTrait(), 2, null);
            clearAnalyticsTraits(paymentGatewaySkuId);
        }
    }

    public final void trackPaymentFlowStarted(String paymentGatewaySkuId, long skuId, Traits.Location locationTrait, Traits.StoreSku storeSkuTrait, Traits.Payment paymentTrait) throws JsonIOException {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        Intrinsics3.checkNotNullParameter(locationTrait, "locationTrait");
        Intrinsics3.checkNotNullParameter(storeSkuTrait, "storeSkuTrait");
        Intrinsics3.checkNotNullParameter(paymentTrait, "paymentTrait");
        AnalyticsTrait analyticsTrait = new AnalyticsTrait(skuId, this.clock.currentTimeMillis(), locationTrait, storeSkuTrait, paymentTrait);
        Map<String, AnalyticsTrait> cachedAnalyticsTraitsMap = getCachedAnalyticsTraitsMap();
        cachedAnalyticsTraitsMap.put(paymentGatewaySkuId, analyticsTrait);
        cacheAnalyticsTraits(cachedAnalyticsTraitsMap);
        AnalyticsTracker.paymentFlowStarted$default(this.analyticsTracker, analyticsTrait.getLocationTrait(), null, analyticsTrait.getStoreSkuTrait(), analyticsTrait.getPaymentTrait(), 2, null);
    }

    public final void trackPaymentFlowStep(String paymentGatewaySkuId, String fromStep, String toStep) throws JsonIOException {
        outline.q0(paymentGatewaySkuId, "paymentGatewaySkuId", fromStep, "fromStep", toStep, "toStep");
        AnalyticsTrait orClearAnalyticsTraits = getOrClearAnalyticsTraits(paymentGatewaySkuId);
        if (orClearAnalyticsTraits != null) {
            AnalyticsTracker.paymentFlowStep$default(this.analyticsTracker, orClearAnalyticsTraits.getLocationTrait(), null, toStep, fromStep, orClearAnalyticsTraits.getStoreSkuTrait(), orClearAnalyticsTraits.getPaymentTrait(), 2, null);
        }
    }

    public final void updatePendingDowngrade(StoreGooglePlayPurchases2 newPendingDowngrade) {
        this.dispatcher.schedule(new AnonymousClass1(newPendingDowngrade));
    }
}
