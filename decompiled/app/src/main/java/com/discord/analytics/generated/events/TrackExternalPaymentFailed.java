package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackExternalPaymentFailed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R!\u0010\u0017\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R!\u0010$\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001aR\u001b\u0010&\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001aR\u001b\u0010(\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0018\u001a\u0004\b)\u0010\u001aR!\u0010*\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001aR\u001b\u0010,\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010\u001aR\u001b\u0010.\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0018\u001a\u0004\b/\u0010\u001aR\u001b\u00100\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010!\u001a\u0004\b1\u0010#R\u001b\u00102\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0018\u001a\u0004\b3\u0010\u001aR\u001b\u00104\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0018\u001a\u0004\b5\u0010\u001aR\u001b\u00106\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010!\u001a\u0004\b7\u0010#R\u001b\u00108\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u0018\u001a\u0004\b9\u0010\u001aR\u001b\u0010:\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0018\u001a\u0004\b;\u0010\u001aR\u001b\u0010<\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0018\u001a\u0004\b=\u0010\u001aR\u001b\u0010>\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u0018\u001a\u0004\b?\u0010\u001aR\u001b\u0010@\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u0018\u001a\u0004\bA\u0010\u001aR\u001b\u0010B\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u0018\u001a\u0004\bC\u0010\u001aR\u001c\u0010D\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u0005¨\u0006G"}, d2 = {"Lcom/discord/analytics/generated/events/TrackExternalPaymentFailed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "Lcom/discord/primitives/Timestamp;", "subscriptionCurrentPeriodStart", "Ljava/lang/Long;", "getSubscriptionCurrentPeriodStart", "()Ljava/lang/Long;", "subscriptionPremiumGuildQuantity", "getSubscriptionPremiumGuildQuantity", "price", "getPrice", "", "paymentType", "Ljava/lang/CharSequence;", "getPaymentType", "()Ljava/lang/CharSequence;", "createdAt", "getCreatedAt", "amount", "getAmount", "skuId", "getSkuId", "subscriptionCurrentPeriodEnd", "getSubscriptionCurrentPeriodEnd", "skuSubscriptionPlanId", "getSkuSubscriptionPlanId", "subscriptionPremiumPlanId", "getSubscriptionPremiumPlanId", "subscriptionPaymentGatewayPlanId", "getSubscriptionPaymentGatewayPlanId", "skuType", "getSkuType", "subscriptionPremiumGuildPlanId", "getSubscriptionPremiumGuildPlanId", "currency", "getCurrency", "amountRefunded", "getAmountRefunded", "subscriptionType", "getSubscriptionType", "paymentGateway", "getPaymentGateway", "paymentId", "getPaymentId", "subscriptionId", "getSubscriptionId", "subscriptionPlanId", "getSubscriptionPlanId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackExternalPaymentFailed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long amount = null;
    private final Long createdAt = null;
    private final CharSequence currency = null;
    private final Long amountRefunded = null;
    private final Long paymentGateway = null;
    private final Long paymentId = null;
    private final CharSequence paymentType = null;
    private final Long price = null;
    private final Long skuId = null;
    private final Long skuSubscriptionPlanId = null;
    private final Long skuType = null;
    private final Long subscriptionCurrentPeriodEnd = null;
    private final Long subscriptionCurrentPeriodStart = null;
    private final Long subscriptionId = null;
    private final CharSequence subscriptionPaymentGatewayPlanId = null;
    private final Long subscriptionPlanId = null;
    private final Long subscriptionPremiumGuildPlanId = null;
    private final Long subscriptionPremiumGuildQuantity = null;
    private final Long subscriptionPremiumPlanId = null;
    private final Long subscriptionType = null;
    private final transient String analyticsSchemaTypeName = "external_payment_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackExternalPaymentFailed)) {
            return false;
        }
        TrackExternalPaymentFailed trackExternalPaymentFailed = (TrackExternalPaymentFailed) other;
        return Intrinsics3.areEqual(this.amount, trackExternalPaymentFailed.amount) && Intrinsics3.areEqual(this.createdAt, trackExternalPaymentFailed.createdAt) && Intrinsics3.areEqual(this.currency, trackExternalPaymentFailed.currency) && Intrinsics3.areEqual(this.amountRefunded, trackExternalPaymentFailed.amountRefunded) && Intrinsics3.areEqual(this.paymentGateway, trackExternalPaymentFailed.paymentGateway) && Intrinsics3.areEqual(this.paymentId, trackExternalPaymentFailed.paymentId) && Intrinsics3.areEqual(this.paymentType, trackExternalPaymentFailed.paymentType) && Intrinsics3.areEqual(this.price, trackExternalPaymentFailed.price) && Intrinsics3.areEqual(this.skuId, trackExternalPaymentFailed.skuId) && Intrinsics3.areEqual(this.skuSubscriptionPlanId, trackExternalPaymentFailed.skuSubscriptionPlanId) && Intrinsics3.areEqual(this.skuType, trackExternalPaymentFailed.skuType) && Intrinsics3.areEqual(this.subscriptionCurrentPeriodEnd, trackExternalPaymentFailed.subscriptionCurrentPeriodEnd) && Intrinsics3.areEqual(this.subscriptionCurrentPeriodStart, trackExternalPaymentFailed.subscriptionCurrentPeriodStart) && Intrinsics3.areEqual(this.subscriptionId, trackExternalPaymentFailed.subscriptionId) && Intrinsics3.areEqual(this.subscriptionPaymentGatewayPlanId, trackExternalPaymentFailed.subscriptionPaymentGatewayPlanId) && Intrinsics3.areEqual(this.subscriptionPlanId, trackExternalPaymentFailed.subscriptionPlanId) && Intrinsics3.areEqual(this.subscriptionPremiumGuildPlanId, trackExternalPaymentFailed.subscriptionPremiumGuildPlanId) && Intrinsics3.areEqual(this.subscriptionPremiumGuildQuantity, trackExternalPaymentFailed.subscriptionPremiumGuildQuantity) && Intrinsics3.areEqual(this.subscriptionPremiumPlanId, trackExternalPaymentFailed.subscriptionPremiumPlanId) && Intrinsics3.areEqual(this.subscriptionType, trackExternalPaymentFailed.subscriptionType);
    }

    public int hashCode() {
        Long l = this.amount;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.createdAt;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.currency;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.amountRefunded;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.paymentGateway;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.paymentId;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.paymentType;
        int iHashCode7 = (iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l6 = this.price;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.skuId;
        int iHashCode9 = (iHashCode8 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.skuSubscriptionPlanId;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.skuType;
        int iHashCode11 = (iHashCode10 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.subscriptionCurrentPeriodEnd;
        int iHashCode12 = (iHashCode11 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.subscriptionCurrentPeriodStart;
        int iHashCode13 = (iHashCode12 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.subscriptionId;
        int iHashCode14 = (iHashCode13 + (l12 != null ? l12.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.subscriptionPaymentGatewayPlanId;
        int iHashCode15 = (iHashCode14 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l13 = this.subscriptionPlanId;
        int iHashCode16 = (iHashCode15 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.subscriptionPremiumGuildPlanId;
        int iHashCode17 = (iHashCode16 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.subscriptionPremiumGuildQuantity;
        int iHashCode18 = (iHashCode17 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.subscriptionPremiumPlanId;
        int iHashCode19 = (iHashCode18 + (l16 != null ? l16.hashCode() : 0)) * 31;
        Long l17 = this.subscriptionType;
        return iHashCode19 + (l17 != null ? l17.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackExternalPaymentFailed(amount=");
        sbU.append(this.amount);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", currency=");
        sbU.append(this.currency);
        sbU.append(", amountRefunded=");
        sbU.append(this.amountRefunded);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", paymentId=");
        sbU.append(this.paymentId);
        sbU.append(", paymentType=");
        sbU.append(this.paymentType);
        sbU.append(", price=");
        sbU.append(this.price);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", skuSubscriptionPlanId=");
        sbU.append(this.skuSubscriptionPlanId);
        sbU.append(", skuType=");
        sbU.append(this.skuType);
        sbU.append(", subscriptionCurrentPeriodEnd=");
        sbU.append(this.subscriptionCurrentPeriodEnd);
        sbU.append(", subscriptionCurrentPeriodStart=");
        sbU.append(this.subscriptionCurrentPeriodStart);
        sbU.append(", subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", subscriptionPaymentGatewayPlanId=");
        sbU.append(this.subscriptionPaymentGatewayPlanId);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", subscriptionPremiumGuildPlanId=");
        sbU.append(this.subscriptionPremiumGuildPlanId);
        sbU.append(", subscriptionPremiumGuildQuantity=");
        sbU.append(this.subscriptionPremiumGuildQuantity);
        sbU.append(", subscriptionPremiumPlanId=");
        sbU.append(this.subscriptionPremiumPlanId);
        sbU.append(", subscriptionType=");
        return outline.G(sbU, this.subscriptionType, ")");
    }
}
