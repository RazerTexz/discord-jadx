package com.discord.utilities.billing;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import b.a.d.AppScreen2;
import b.d.a.a.a;
import b.d.a.a.b;
import b.d.a.a.d;
import b.d.a.a.e;
import b.d.a.a.f;
import b.d.a.a.g;
import b.d.a.a.h;
import b.d.a.a.i;
import b.d.b.a.outline;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.app.AppActivity;
import com.discord.app.AppLog;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ActivityLifecycleCallbacks;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.google.gson.JsonIOException;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: GooglePlayBillingManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002JKB\t\b\u0002¢\u0006\u0004\bI\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0015\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0007J\r\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u0007J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0007J\u001d\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0005¢\u0006\u0004\b&\u0010\u0007J'\u0010*\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0016¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0005¢\u0006\u0004\b,\u0010\u0007J'\u0010.\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'H\u0016¢\u0006\u0004\b.\u0010+J-\u00104\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u00100\u001a\u00020/2\u000e\u00103\u001a\n\u0018\u000101j\u0004\u0018\u0001`2¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u0002018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u000e8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010>R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bD\u0010ER$\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\n0F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lcom/discord/utilities/billing/GooglePlayBillingManager;", "Lb/d/a/a/g;", "Lb/d/a/a/b;", "Lb/d/a/a/i;", "Lb/d/a/a/e;", "", "queryInAppSkuDetails", "()V", "Lcom/android/billingclient/api/Purchase;", "purchase", "Lcom/discord/utilities/billing/GooglePlayBillingManager$InAppSkuToConsume;", "inAppSkuToConsume", "handleConsumeStart", "(Lcom/android/billingclient/api/Purchase;Lcom/discord/utilities/billing/GooglePlayBillingManager$InAppSkuToConsume;)V", "", "purchaseToken", "handleConsumeSuccess", "(Ljava/lang/String;)V", "handleConsumeFailure", "handleConsumeEnd", "Landroid/app/Application;", "application", "init", "(Landroid/app/Application;)V", "onActivityCreated", "onActivityDestroyed", "Lcom/android/billingclient/api/BillingResult;", "billingResult", "onBillingSetupFinished", "(Lcom/android/billingclient/api/BillingResult;)V", "onBillingServiceDisconnected", "Landroid/app/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/android/billingclient/api/BillingFlowParams;", "params", "", "launchBillingFlow", "(Landroid/app/Activity;Lcom/android/billingclient/api/BillingFlowParams;)I", "querySkuDetails", "", "Lcom/android/billingclient/api/SkuDetails;", "skuDetails", "onSkuDetailsResponse", "(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V", "queryPurchases", "purchases", "onPurchasesUpdated", "Lcom/discord/utilities/billing/InAppSkuType;", "inAppSkuType", "", "Lcom/discord/primitives/SkuId;", "skuId", "consumePurchase", "(Lcom/android/billingclient/api/Purchase;Lcom/discord/utilities/billing/InAppSkuType;Ljava/lang/Long;)V", "onConsumeResponse", "(Lcom/android/billingclient/api/BillingResult;Ljava/lang/String;)V", "", "isAuthenticated", "Z", "DEFAULT_BACKOFF_TIME_MS", "J", "PLAY_STORE_SUBSCRIPTION_URL", "Ljava/lang/String;", "PLAY_STORE_SUBSCRIPTION_DEEPLINK_URL", "Ljava/util/concurrent/atomic/AtomicLong;", "backoffTimeMs", "Ljava/util/concurrent/atomic/AtomicLong;", "Lcom/android/billingclient/api/BillingClient;", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "", "inAppSkusToConsume", "Ljava/util/Map;", "<init>", "GooglePlayBillingManagerLifecycleListener", "InAppSkuToConsume", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GooglePlayBillingManager implements g, b, i, e {
    private static final long DEFAULT_BACKOFF_TIME_MS = 1000;
    public static final String PLAY_STORE_SUBSCRIPTION_DEEPLINK_URL = "https://play.google.com/store/account/subscriptions?sku=%s&package=%s";
    public static final String PLAY_STORE_SUBSCRIPTION_URL = "https://play.google.com/store/account/subscriptions";
    private static BillingClient billingClient;
    private static boolean isAuthenticated;
    public static final GooglePlayBillingManager INSTANCE = new GooglePlayBillingManager();
    private static AtomicLong backoffTimeMs = new AtomicLong(1000);
    private static Map<String, InAppSkuToConsume> inAppSkusToConsume = new HashMap();

    /* compiled from: GooglePlayBillingManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/discord/utilities/billing/GooglePlayBillingManager$GooglePlayBillingManagerLifecycleListener;", "Lcom/discord/utilities/rx/ActivityLifecycleCallbacks;", "Lcom/discord/app/AppActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/os/Bundle;", "savedInstanceState", "", "onActivityCreated", "(Lcom/discord/app/AppActivity;Landroid/os/Bundle;)V", "onActivityResumed", "(Lcom/discord/app/AppActivity;)V", "onActivityDestroyed", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class GooglePlayBillingManagerLifecycleListener extends ActivityLifecycleCallbacks {
        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityCreated(AppActivity activity, Bundle savedInstanceState) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityCreated(activity, savedInstanceState);
            AppScreen2 appScreen2 = AppScreen2.g;
            if (activity.g(AppScreen2.f)) {
                GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
                if (GooglePlayBillingManager.access$isAuthenticated$p(googlePlayBillingManager)) {
                    googlePlayBillingManager.onActivityCreated();
                }
            }
        }

        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityDestroyed(AppActivity activity) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityDestroyed(activity);
            AppScreen2 appScreen2 = AppScreen2.g;
            if (activity.g(AppScreen2.f)) {
                GooglePlayBillingManager.INSTANCE.onActivityDestroyed();
            }
        }

        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityResumed(AppActivity activity) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityResumed(activity);
            AppScreen2 appScreen2 = AppScreen2.g;
            if (activity.g(AppScreen2.f)) {
                GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
                if (GooglePlayBillingManager.access$isAuthenticated$p(googlePlayBillingManager)) {
                    googlePlayBillingManager.queryPurchases();
                }
            }
        }
    }

    /* compiled from: GooglePlayBillingManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u000e\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\n\u0010\u000f\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000b\u001a\u00060\tj\u0002`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\f\b\u0002\u0010\u000f\u001a\u00060\tj\u0002`\nHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u000f\u001a\u00060\tj\u0002`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R!\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lcom/discord/utilities/billing/GooglePlayBillingManager$InAppSkuToConsume;", "", "Lcom/discord/utilities/billing/InAppSkuType;", "component1", "()Lcom/discord/utilities/billing/InAppSkuType;", "", "Lcom/discord/primitives/SkuId;", "component2", "()Ljava/lang/Long;", "", "Lcom/discord/primitives/PaymentGatewaySkuId;", "component3", "()Ljava/lang/String;", "type", "skuId", "paymentGatewaySkuId", "copy", "(Lcom/discord/utilities/billing/InAppSkuType;Ljava/lang/Long;Ljava/lang/String;)Lcom/discord/utilities/billing/GooglePlayBillingManager$InAppSkuToConsume;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPaymentGatewaySkuId", "Lcom/discord/utilities/billing/InAppSkuType;", "getType", "Ljava/lang/Long;", "getSkuId", "<init>", "(Lcom/discord/utilities/billing/InAppSkuType;Ljava/lang/Long;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class InAppSkuToConsume {
        private final String paymentGatewaySkuId;
        private final Long skuId;
        private final GooglePlayInAppSku4 type;

        public InAppSkuToConsume(GooglePlayInAppSku4 googlePlayInAppSku4, Long l, String str) {
            Intrinsics3.checkNotNullParameter(googlePlayInAppSku4, "type");
            Intrinsics3.checkNotNullParameter(str, "paymentGatewaySkuId");
            this.type = googlePlayInAppSku4;
            this.skuId = l;
            this.paymentGatewaySkuId = str;
        }

        public static /* synthetic */ InAppSkuToConsume copy$default(InAppSkuToConsume inAppSkuToConsume, GooglePlayInAppSku4 googlePlayInAppSku4, Long l, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                googlePlayInAppSku4 = inAppSkuToConsume.type;
            }
            if ((i & 2) != 0) {
                l = inAppSkuToConsume.skuId;
            }
            if ((i & 4) != 0) {
                str = inAppSkuToConsume.paymentGatewaySkuId;
            }
            return inAppSkuToConsume.copy(googlePlayInAppSku4, l, str);
        }

        /* renamed from: component1, reason: from getter */
        public final GooglePlayInAppSku4 getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getSkuId() {
            return this.skuId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPaymentGatewaySkuId() {
            return this.paymentGatewaySkuId;
        }

        public final InAppSkuToConsume copy(GooglePlayInAppSku4 type, Long skuId, String paymentGatewaySkuId) {
            Intrinsics3.checkNotNullParameter(type, "type");
            Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
            return new InAppSkuToConsume(type, skuId, paymentGatewaySkuId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InAppSkuToConsume)) {
                return false;
            }
            InAppSkuToConsume inAppSkuToConsume = (InAppSkuToConsume) other;
            return Intrinsics3.areEqual(this.type, inAppSkuToConsume.type) && Intrinsics3.areEqual(this.skuId, inAppSkuToConsume.skuId) && Intrinsics3.areEqual(this.paymentGatewaySkuId, inAppSkuToConsume.paymentGatewaySkuId);
        }

        public final String getPaymentGatewaySkuId() {
            return this.paymentGatewaySkuId;
        }

        public final Long getSkuId() {
            return this.skuId;
        }

        public final GooglePlayInAppSku4 getType() {
            return this.type;
        }

        public int hashCode() {
            GooglePlayInAppSku4 googlePlayInAppSku4 = this.type;
            int iHashCode = (googlePlayInAppSku4 != null ? googlePlayInAppSku4.hashCode() : 0) * 31;
            Long l = this.skuId;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            String str = this.paymentGatewaySkuId;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("InAppSkuToConsume(type=");
            sbU.append(this.type);
            sbU.append(", skuId=");
            sbU.append(this.skuId);
            sbU.append(", paymentGatewaySkuId=");
            return outline.J(sbU, this.paymentGatewaySkuId, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            GooglePlayInAppSku4.values();
            int[] iArr = new int[1];
            $EnumSwitchMapping$0 = iArr;
            GooglePlayInAppSku4 googlePlayInAppSku4 = GooglePlayInAppSku4.PREMIUM_GIFT;
            iArr[googlePlayInAppSku4.ordinal()] = 1;
            GooglePlayInAppSku4.values();
            int[] iArr2 = new int[1];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[googlePlayInAppSku4.ordinal()] = 1;
            GooglePlayInAppSku4.values();
            $EnumSwitchMapping$2 = new int[1];
        }
    }

    /* compiled from: GooglePlayBillingManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.billing.GooglePlayBillingManager$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            GooglePlayBillingManager.access$setAuthenticated$p(GooglePlayBillingManager.INSTANCE, z2);
        }
    }

    /* compiled from: GooglePlayBillingManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.billing.GooglePlayBillingManager$onBillingServiceDisconnected$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ long $currentBackoffTimeMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$currentBackoffTimeMs = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
            if (GooglePlayBillingManager.access$getBillingClient$p(googlePlayBillingManager).d()) {
                return;
            }
            GooglePlayBillingManager.access$getBillingClient$p(googlePlayBillingManager).h(googlePlayBillingManager);
            GooglePlayBillingManager.access$getBackoffTimeMs$p(googlePlayBillingManager).set(this.$currentBackoffTimeMs * 2);
        }
    }

    /* compiled from: GooglePlayBillingManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002(\u0010\u0006\u001a$\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00050\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/android/billingclient/api/BillingResult;", "<anonymous parameter 0>", "", "Lcom/android/billingclient/api/Purchase;", "kotlin.jvm.PlatformType", "", "purchasesList", "", "onQueryPurchasesResponse", "(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.billing.GooglePlayBillingManager$queryPurchases$1, reason: invalid class name */
    public static final class AnonymousClass1 implements f {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // b.d.a.a.f
        public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
            Intrinsics3.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(list, "purchasesList");
            StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(list, "subs");
        }
    }

    /* compiled from: GooglePlayBillingManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002(\u0010\u0006\u001a$\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00050\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/android/billingclient/api/BillingResult;", "<anonymous parameter 0>", "", "Lcom/android/billingclient/api/Purchase;", "kotlin.jvm.PlatformType", "", "purchasesList", "", "onQueryPurchasesResponse", "(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.billing.GooglePlayBillingManager$queryPurchases$2, reason: invalid class name */
    public static final class AnonymousClass2 implements f {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // b.d.a.a.f
        public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
            Intrinsics3.checkNotNullParameter(billingResult, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(list, "purchasesList");
            StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(list, "inapp");
        }
    }

    private GooglePlayBillingManager() {
    }

    public static final /* synthetic */ AtomicLong access$getBackoffTimeMs$p(GooglePlayBillingManager googlePlayBillingManager) {
        return backoffTimeMs;
    }

    public static final /* synthetic */ BillingClient access$getBillingClient$p(GooglePlayBillingManager googlePlayBillingManager) {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        return billingClient2;
    }

    public static final /* synthetic */ boolean access$isAuthenticated$p(GooglePlayBillingManager googlePlayBillingManager) {
        return isAuthenticated;
    }

    public static final /* synthetic */ void access$setAuthenticated$p(GooglePlayBillingManager googlePlayBillingManager, boolean z2) {
        isAuthenticated = z2;
    }

    public static final /* synthetic */ void access$setBackoffTimeMs$p(GooglePlayBillingManager googlePlayBillingManager, AtomicLong atomicLong) {
        backoffTimeMs = atomicLong;
    }

    public static final /* synthetic */ void access$setBillingClient$p(GooglePlayBillingManager googlePlayBillingManager, BillingClient billingClient2) {
        billingClient = billingClient2;
    }

    private final void handleConsumeEnd(String purchaseToken) {
        InAppSkuToConsume inAppSkuToConsume = inAppSkusToConsume.get(purchaseToken);
        if (inAppSkuToConsume != null) {
            inAppSkuToConsume.getType();
        }
    }

    private final void handleConsumeFailure(String purchaseToken) {
        InAppSkuToConsume inAppSkuToConsume = inAppSkusToConsume.get(purchaseToken);
        if (inAppSkuToConsume != null) {
            StoreStream.INSTANCE.getGooglePlayPurchases().trackPaymentFlowFailed(inAppSkuToConsume.getPaymentGatewaySkuId());
        }
    }

    private final void handleConsumeStart(Purchase purchase, InAppSkuToConsume inAppSkuToConsume) {
        Map<String, InAppSkuToConsume> map = inAppSkusToConsume;
        String strA = purchase.a();
        Intrinsics3.checkNotNullExpressionValue(strA, "purchase.purchaseToken");
        map.put(strA, inAppSkuToConsume);
        if (inAppSkuToConsume.getType().ordinal() != 0) {
            throw new NoWhenBranchMatchedException();
        }
        KotlinExtensions.getExhaustive(Unit.a);
    }

    private final void handleConsumeSuccess(String purchaseToken) throws JsonIOException {
        InAppSkuToConsume inAppSkuToConsume = inAppSkusToConsume.get(purchaseToken);
        if (inAppSkuToConsume != null) {
            StoreStream.INSTANCE.getGooglePlayPurchases().trackPaymentFlowCompleted(inAppSkuToConsume.getPaymentGatewaySkuId());
            if (inAppSkuToConsume.getType().ordinal() != 0) {
                throw new NoWhenBranchMatchedException();
            }
            KotlinExtensions.getExhaustive(Unit.a);
        }
    }

    private final void queryInAppSkuDetails() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            List<GooglePlayInAppSku> skus = GooglePlayInAppSku3.INSTANCE.getSkus();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(skus, 10));
            Iterator<T> it = skus.iterator();
            while (it.hasNext()) {
                arrayList.add(((GooglePlayInAppSku) it.next()).getPaymentGatewaySkuId());
            }
            ArrayList arrayList2 = new ArrayList(arrayList);
            h hVar = new h();
            hVar.a = "inapp";
            hVar.f450b = arrayList2;
            Intrinsics3.checkNotNullExpressionValue(hVar, "SkuDetailsParams.newBuil…kuNames)\n        .build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.g(hVar, this);
        }
    }

    public final void consumePurchase(Purchase purchase, GooglePlayInAppSku4 inAppSkuType, Long skuId) {
        Intrinsics3.checkNotNullParameter(purchase, "purchase");
        Intrinsics3.checkNotNullParameter(inAppSkuType, "inAppSkuType");
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            String strA = purchase.a();
            if (strA == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            d dVar = new d();
            dVar.a = strA;
            Intrinsics3.checkNotNullExpressionValue(dVar, "ConsumeParams.newBuilder…se.purchaseToken).build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.a(dVar, this);
            ArrayList<String> arrayListB = purchase.b();
            Intrinsics3.checkNotNullExpressionValue(arrayListB, "purchase.skus");
            for (String str : arrayListB) {
                GooglePlayBillingManager googlePlayBillingManager = INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(str, "sku");
                googlePlayBillingManager.handleConsumeStart(purchase, new InAppSkuToConsume(inAppSkuType, skuId, str));
            }
        }
    }

    public final void init(Application application) {
        Intrinsics3.checkNotNullParameter(application, "application");
        Context applicationContext = application.getApplicationContext();
        if (applicationContext == null) {
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
        a aVar = new a(null, true, applicationContext, this);
        Intrinsics3.checkNotNullExpressionValue(aVar, "BillingClient.newBuilder…chases()\n        .build()");
        billingClient = aVar;
        application.registerActivityLifecycleCallbacks(new GooglePlayBillingManagerLifecycleListener());
        ObservableExtensionsKt.appSubscribe$default(StoreStream.INSTANCE.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), GooglePlayBillingManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    public final int launchBillingFlow(Activity activity, BillingFlowParams params) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(params, "params");
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (!billingClient2.d()) {
            return -1;
        }
        BillingClient billingClient3 = billingClient;
        if (billingClient3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        BillingResult billingResultE = billingClient3.e(activity, params);
        Intrinsics3.checkNotNullExpressionValue(billingResultE, "billingClient.launchBillingFlow(activity, params)");
        return billingResultE.a;
    }

    public final void onActivityCreated() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            return;
        }
        BillingClient billingClient3 = billingClient;
        if (billingClient3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        billingClient3.h(this);
    }

    public final void onActivityDestroyed() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.b();
        }
    }

    @Override // b.d.a.a.b
    public void onBillingServiceDisconnected() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.c() != 0) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            if (billingClient3.c() != 3) {
                return;
            }
        }
        long j = backoffTimeMs.get();
        Observable<Long> observableD0 = Observable.d0(j, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…s, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, GooglePlayBillingManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(j), 62, (Object) null);
    }

    @Override // b.d.a.a.b
    public void onBillingSetupFinished(BillingResult billingResult) {
        Intrinsics3.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.a == 0) {
            querySkuDetails();
            queryInAppSkuDetails();
            queryPurchases();
            backoffTimeMs.set(1000L);
        }
    }

    @Override // b.d.a.a.e
    public void onConsumeResponse(BillingResult billingResult, String purchaseToken) throws JsonIOException {
        Intrinsics3.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics3.checkNotNullParameter(purchaseToken, "purchaseToken");
        if (billingResult.a == 0) {
            handleConsumeSuccess(purchaseToken);
        } else {
            handleConsumeFailure(purchaseToken);
            AppLog appLog = AppLog.g;
            StringBuilder sbX = outline.X("Failed to consume purchase. ", "Billing Response Code: ");
            sbX.append(billingResult.a);
            sbX.append(", ");
            sbX.append("Purchase Token: ");
            sbX.append(purchaseToken);
            Logger.e$default(appLog, sbX.toString(), null, null, 6, null);
        }
        handleConsumeEnd(purchaseToken);
    }

    @Override // b.d.a.a.g
    public void onPurchasesUpdated(BillingResult billingResult, List<? extends Purchase> purchases) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.a != 0) {
            StoreStream.INSTANCE.getGooglePlayPurchases().updatePendingDowngrade(null);
        }
        int i = billingResult.a;
        if (i != 0) {
            if (i == 1) {
                AppLog.i("onPurchasesUpdated: User canceled the purchase");
                return;
            } else if (i == 5) {
                Logger.e$default(AppLog.g, "onPurchasesUpdated: Google Play doesn't recognize this app config. Verify the SKU product ID and the signed APK you are using.", null, null, 6, null);
                return;
            } else {
                if (i != 7) {
                    return;
                }
                AppLog.i("onPurchasesUpdated: The user already owns this item");
                return;
            }
        }
        if (purchases == null || purchases.isEmpty()) {
            StoreStream.INSTANCE.getGooglePlayPurchases().downgradePurchase();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (purchases != null) {
            for (Purchase purchase : purchases) {
                ArrayList<String> arrayListB = purchase.b();
                Intrinsics3.checkNotNullExpressionValue(arrayListB, "purchase.skus");
                if (arrayListB.isEmpty()) {
                    z2 = false;
                } else {
                    for (String str : arrayListB) {
                        GooglePlayInAppSku3 googlePlayInAppSku3 = GooglePlayInAppSku3.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(str, "sku");
                        if (googlePlayInAppSku3.isInAppSku(str)) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                }
                if (z2) {
                    arrayList2.add(purchase);
                } else {
                    arrayList.add(purchase);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(arrayList2, "inapp");
        }
        if (!arrayList.isEmpty()) {
            StoreStream.INSTANCE.getGooglePlayPurchases().processPurchases(arrayList, "subs");
        }
    }

    @Override // b.d.a.a.i
    public void onSkuDetailsResponse(BillingResult billingResult, List<? extends SkuDetails> skuDetails) {
        Intrinsics3.checkNotNullParameter(billingResult, "billingResult");
        int i = billingResult.a;
        String str = billingResult.f2003b;
        Intrinsics3.checkNotNullExpressionValue(str, "billingResult.debugMessage");
        switch (i) {
            case -2:
            case 1:
            case 7:
            case 8:
                StoreStream.INSTANCE.getGooglePlaySkuDetails().handleError();
                Logger.e$default(AppLog.g, "onSkuDetailsResponse: " + i + ' ' + str, null, null, 6, null);
                break;
            case -1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                StoreStream.INSTANCE.getGooglePlaySkuDetails().handleError();
                break;
            case 0:
                StoreGooglePlaySkuDetails googlePlaySkuDetails = StoreStream.INSTANCE.getGooglePlaySkuDetails();
                if (skuDetails == null) {
                    skuDetails = Collections2.emptyList();
                }
                googlePlaySkuDetails.updateSkuDetails(skuDetails);
                break;
        }
    }

    public final void queryPurchases() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.f("subs", AnonymousClass1.INSTANCE);
            BillingClient billingClient4 = billingClient;
            if (billingClient4 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient4.f("inapp", AnonymousClass2.INSTANCE);
        }
    }

    public final void querySkuDetails() {
        BillingClient billingClient2 = billingClient;
        if (billingClient2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
        }
        if (billingClient2.d()) {
            ArrayList arrayList = new ArrayList(GooglePlaySku.INSTANCE.getALL_SKU_NAMES());
            h hVar = new h();
            hVar.a = "subs";
            hVar.f450b = arrayList;
            Intrinsics3.checkNotNullExpressionValue(hVar, "SkuDetailsParams.newBuil…U_NAMES)\n        .build()");
            BillingClient billingClient3 = billingClient;
            if (billingClient3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("billingClient");
            }
            billingClient3.g(hVar, this);
        }
    }
}
