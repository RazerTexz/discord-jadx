package com.discord.utilities.billing;

import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: BillingUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/utilities/billing/BillingUtils;", "", "Lcom/android/billingclient/api/Purchase;", "purchase", "", "sku", "", "verifyPurchase", "(Lcom/android/billingclient/api/Purchase;Ljava/lang/String;)V", "", "purchases", "verifyPurchases", "(Ljava/util/List;)V", "paymentGatewaySkuId", "", "skuId", "Lkotlin/Function0;", "onSuccess", "onFailure", "createPendingPurchaseMetadata", "(Ljava/lang/String;JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "amount", "microToMinor", "(J)J", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BillingUtils {
    public static final BillingUtils INSTANCE = new BillingUtils();

    /* compiled from: BillingUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.billing.BillingUtils$createPendingPurchaseMetadata$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ Function0 $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(1);
            this.$onSuccess = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            this.$onSuccess.invoke();
        }
    }

    /* compiled from: BillingUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.billing.BillingUtils$createPendingPurchaseMetadata$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Function0 $onFailure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function0 function0) {
            super(1);
            this.$onFailure = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            this.$onFailure.invoke();
        }
    }

    /* compiled from: BillingUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/restapi/RestAPIParams$VerifyPurchaseResponse;", "response", "", "invoke", "(Lcom/discord/restapi/RestAPIParams$VerifyPurchaseResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.billing.BillingUtils$verifyPurchase$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestAPIParams.VerifyPurchaseResponse, Unit> {
        public final /* synthetic */ Purchase $purchase;
        public final /* synthetic */ String $sku;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Purchase purchase, String str) {
            super(1);
            this.$purchase = purchase;
            this.$sku = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse) {
            invoke2(verifyPurchaseResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse) {
            StoreStream.INSTANCE.getGooglePlayPurchases().onVerificationSuccess(new StoreGooglePlayPurchases.VerificationResult(this.$purchase, verifyPurchaseResponse));
            GooglePlayInAppSku inAppSku = GooglePlayInAppSku3.INSTANCE.getInAppSku(this.$sku);
            if (inAppSku != null) {
                GooglePlayBillingManager.INSTANCE.consumePurchase(this.$purchase, inAppSku.getType(), verifyPurchaseResponse != null ? Long.valueOf(verifyPurchaseResponse.getVerifiedSkuId()) : null);
            }
        }
    }

    /* compiled from: BillingUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.billing.BillingUtils$verifyPurchase$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Purchase $purchase;
        public final /* synthetic */ String $sku;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Purchase purchase, String str) {
            super(1);
            this.$purchase = purchase;
            this.$sku = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreStream.Companion companion = StoreStream.INSTANCE;
            companion.getGooglePlayPurchases().onVerificationFailure(new StoreGooglePlayPurchases.VerificationResult(this.$purchase, null));
            companion.getGooglePlayPurchases().trackPaymentFlowFailed(this.$sku);
        }
    }

    private BillingUtils() {
    }

    private final void verifyPurchase(Purchase purchase, String sku) {
        String str;
        String str2;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        long id2 = companion.getUsers().getMeSnapshot().getId();
        if (GooglePlayInAppSku3.INSTANCE.isInAppSku(sku)) {
            str2 = sku;
            str = null;
        } else {
            str = sku;
            str2 = null;
        }
        String strA = purchase.a();
        Intrinsics3.checkNotNullExpressionValue(strA, "purchase.purchaseToken");
        String strOptString = purchase.c.optString("packageName");
        Intrinsics3.checkNotNullExpressionValue(strOptString, "purchase.packageName");
        RestAPIParams.VerifyPurchaseTokenBody verifyPurchaseTokenBody = new RestAPIParams.VerifyPurchaseTokenBody(strA, id2, strOptString, str, str2);
        companion.getGooglePlayPurchases().onVerificationStart();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().verifyPurchaseToken(verifyPurchaseTokenBody), false, 1, null), BillingUtils.class, (Context) null, (Function1) null, new AnonymousClass2(purchase, sku), (Function0) null, (Function0) null, new AnonymousClass1(purchase, sku), 54, (Object) null);
    }

    public final void createPendingPurchaseMetadata(String paymentGatewaySkuId, long skuId, Function0<Unit> onSuccess, Function0<Unit> onFailure) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics3.checkNotNullParameter(onFailure, "onFailure");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createPurchaseMetadata(new RestAPIParams.PurchaseMetadataBody(skuId, paymentGatewaySkuId)), false, 1, null), BillingUtils.class, (Context) null, (Function1) null, new AnonymousClass2(onFailure), (Function0) null, (Function0) null, new AnonymousClass1(onSuccess), 54, (Object) null);
    }

    public final long microToMinor(long amount) {
        return amount / 10000;
    }

    public final void verifyPurchases(List<? extends Purchase> purchases) {
        if (purchases != null) {
            for (Purchase purchase : purchases) {
                if ((purchase.c.optInt("purchaseState", 1) != 4 ? (char) 1 : (char) 2) == 1 && !purchase.c()) {
                    ArrayList<String> arrayListB = purchase.b();
                    Intrinsics3.checkNotNullExpressionValue(arrayListB, "purchase.skus");
                    for (String str : arrayListB) {
                        BillingUtils billingUtils = INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(str, "sku");
                        billingUtils.verifyPurchase(purchase, str);
                    }
                }
            }
        }
    }
}
