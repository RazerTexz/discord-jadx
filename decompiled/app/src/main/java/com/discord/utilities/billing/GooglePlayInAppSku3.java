package com.discord.utilities.billing;

import com.android.billingclient.api.SkuDetails;
import com.discord.models.domain.ModelSku;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: GooglePlayInAppSku.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\u000b2\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0013R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R&\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u000e0\b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/discord/utilities/billing/GooglePlayInAppSkus;", "", "", "Lcom/discord/primitives/PaymentGatewaySkuId;", "paymentGatewaySkuId", "", "isInAppSku", "(Ljava/lang/String;)Z", "", "Lcom/android/billingclient/api/SkuDetails;", "skuDetails", "", "populateSkuDetails", "(Ljava/util/Map;)V", "Lcom/discord/utilities/billing/GooglePlayInAppSku;", "getInAppSku", "(Ljava/lang/String;)Lcom/discord/utilities/billing/GooglePlayInAppSku;", "Lcom/discord/models/domain/ModelSku;", "sku", "(Lcom/discord/models/domain/ModelSku;)Lcom/discord/utilities/billing/GooglePlayInAppSku;", "", "skus", "Ljava/util/List;", "getSkus", "()Ljava/util/List;", "getSkusById", "()Ljava/util/Map;", "skusById", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.billing.GooglePlayInAppSkus, reason: use source file name */
/* loaded from: classes2.dex */
public final class GooglePlayInAppSku3 {
    public static final GooglePlayInAppSku3 INSTANCE = new GooglePlayInAppSku3();
    private static final List<GooglePlayInAppSku> skus = GooglePlayInAppSku2.getPremiumGifts();

    private GooglePlayInAppSku3() {
    }

    private final Map<String, GooglePlayInAppSku> getSkusById() {
        List<GooglePlayInAppSku> list = skus;
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((GooglePlayInAppSku) obj).getPaymentGatewaySkuId(), obj);
        }
        return linkedHashMap;
    }

    public final GooglePlayInAppSku getInAppSku(String paymentGatewaySkuId) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        return getSkusById().get(paymentGatewaySkuId);
    }

    public final List<GooglePlayInAppSku> getSkus() {
        return skus;
    }

    public final boolean isInAppSku(String paymentGatewaySkuId) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        return getSkusById().containsKey(paymentGatewaySkuId);
    }

    public final void populateSkuDetails(Map<String, ? extends SkuDetails> skuDetails) {
        Intrinsics3.checkNotNullParameter(skuDetails, "skuDetails");
        for (Map.Entry<String, ? extends SkuDetails> entry : skuDetails.entrySet()) {
            GooglePlayInAppSku googlePlayInAppSku = INSTANCE.getSkusById().get(entry.getKey());
            if (googlePlayInAppSku != null) {
                googlePlayInAppSku.setSkuDetails(entry.getValue());
            }
        }
    }

    public final GooglePlayInAppSku getInAppSku(ModelSku sku) {
        Object next;
        Intrinsics3.checkNotNullParameter(sku, "sku");
        Iterator<T> it = GooglePlayInAppSku2.getPremiumGifts().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics3.areEqual(((GooglePlayInAppSku) next).getPaymentGatewaySkuId(), sku.getName())) {
                break;
            }
        }
        return (GooglePlayInAppSku) next;
    }
}
