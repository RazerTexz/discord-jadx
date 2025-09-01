package com.discord.utilities.billing;

import b.d.b.a.outline;
import com.android.billingclient.api.SkuDetails;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GooglePlayInAppSku.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r¢\u0006\u0004\b*\u0010+J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJF\u0010\u0014\u001a\u00020\u00002\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR!\u0010\u0013\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010\u000fR$\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010#R\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\b\"\u0004\b&\u0010'R\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b)\u0010\u0005¨\u0006,"}, d2 = {"Lcom/discord/utilities/billing/GooglePlayInAppSku;", "", "", "Lcom/discord/primitives/PaymentGatewaySkuId;", "component1", "()Ljava/lang/String;", "Lcom/discord/utilities/billing/InAppSkuType;", "component2", "()Lcom/discord/utilities/billing/InAppSkuType;", "Lcom/android/billingclient/api/SkuDetails;", "component3", "()Lcom/android/billingclient/api/SkuDetails;", "", "Lcom/discord/primitives/SkuId;", "component4", "()Ljava/lang/Long;", "paymentGatewaySkuId", "type", "skuDetails", "skuId", "copy", "(Ljava/lang/String;Lcom/discord/utilities/billing/InAppSkuType;Lcom/android/billingclient/api/SkuDetails;Ljava/lang/Long;)Lcom/discord/utilities/billing/GooglePlayInAppSku;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getSkuId", "Lcom/android/billingclient/api/SkuDetails;", "getSkuDetails", "setSkuDetails", "(Lcom/android/billingclient/api/SkuDetails;)V", "Lcom/discord/utilities/billing/InAppSkuType;", "getType", "setType", "(Lcom/discord/utilities/billing/InAppSkuType;)V", "Ljava/lang/String;", "getPaymentGatewaySkuId", "<init>", "(Ljava/lang/String;Lcom/discord/utilities/billing/InAppSkuType;Lcom/android/billingclient/api/SkuDetails;Ljava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class GooglePlayInAppSku {
    private final String paymentGatewaySkuId;
    private SkuDetails skuDetails;
    private final Long skuId;
    private GooglePlayInAppSku4 type;

    public GooglePlayInAppSku(String str, GooglePlayInAppSku4 googlePlayInAppSku4, SkuDetails skuDetails, Long l) {
        Intrinsics3.checkNotNullParameter(str, "paymentGatewaySkuId");
        Intrinsics3.checkNotNullParameter(googlePlayInAppSku4, "type");
        this.paymentGatewaySkuId = str;
        this.type = googlePlayInAppSku4;
        this.skuDetails = skuDetails;
        this.skuId = l;
    }

    public static /* synthetic */ GooglePlayInAppSku copy$default(GooglePlayInAppSku googlePlayInAppSku, String str, GooglePlayInAppSku4 googlePlayInAppSku4, SkuDetails skuDetails, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = googlePlayInAppSku.paymentGatewaySkuId;
        }
        if ((i & 2) != 0) {
            googlePlayInAppSku4 = googlePlayInAppSku.type;
        }
        if ((i & 4) != 0) {
            skuDetails = googlePlayInAppSku.skuDetails;
        }
        if ((i & 8) != 0) {
            l = googlePlayInAppSku.skuId;
        }
        return googlePlayInAppSku.copy(str, googlePlayInAppSku4, skuDetails, l);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPaymentGatewaySkuId() {
        return this.paymentGatewaySkuId;
    }

    /* renamed from: component2, reason: from getter */
    public final GooglePlayInAppSku4 getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final SkuDetails getSkuDetails() {
        return this.skuDetails;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getSkuId() {
        return this.skuId;
    }

    public final GooglePlayInAppSku copy(String paymentGatewaySkuId, GooglePlayInAppSku4 type, SkuDetails skuDetails, Long skuId) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        Intrinsics3.checkNotNullParameter(type, "type");
        return new GooglePlayInAppSku(paymentGatewaySkuId, type, skuDetails, skuId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GooglePlayInAppSku)) {
            return false;
        }
        GooglePlayInAppSku googlePlayInAppSku = (GooglePlayInAppSku) other;
        return Intrinsics3.areEqual(this.paymentGatewaySkuId, googlePlayInAppSku.paymentGatewaySkuId) && Intrinsics3.areEqual(this.type, googlePlayInAppSku.type) && Intrinsics3.areEqual(this.skuDetails, googlePlayInAppSku.skuDetails) && Intrinsics3.areEqual(this.skuId, googlePlayInAppSku.skuId);
    }

    public final String getPaymentGatewaySkuId() {
        return this.paymentGatewaySkuId;
    }

    public final SkuDetails getSkuDetails() {
        return this.skuDetails;
    }

    public final Long getSkuId() {
        return this.skuId;
    }

    public final GooglePlayInAppSku4 getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.paymentGatewaySkuId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        GooglePlayInAppSku4 googlePlayInAppSku4 = this.type;
        int iHashCode2 = (iHashCode + (googlePlayInAppSku4 != null ? googlePlayInAppSku4.hashCode() : 0)) * 31;
        SkuDetails skuDetails = this.skuDetails;
        int iHashCode3 = (iHashCode2 + (skuDetails != null ? skuDetails.hashCode() : 0)) * 31;
        Long l = this.skuId;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public final void setSkuDetails(SkuDetails skuDetails) {
        this.skuDetails = skuDetails;
    }

    public final void setType(GooglePlayInAppSku4 googlePlayInAppSku4) {
        Intrinsics3.checkNotNullParameter(googlePlayInAppSku4, "<set-?>");
        this.type = googlePlayInAppSku4;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GooglePlayInAppSku(paymentGatewaySkuId=");
        sbU.append(this.paymentGatewaySkuId);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", skuDetails=");
        sbU.append(this.skuDetails);
        sbU.append(", skuId=");
        return outline.G(sbU, this.skuId, ")");
    }

    public /* synthetic */ GooglePlayInAppSku(String str, GooglePlayInAppSku4 googlePlayInAppSku4, SkuDetails skuDetails, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, googlePlayInAppSku4, (i & 4) != 0 ? null : skuDetails, (i & 8) != 0 ? null : l);
    }
}
