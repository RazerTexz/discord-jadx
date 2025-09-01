package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackPaymentFailed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0014\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R\u001b\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0005R\u001b\u0010(\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0010\u001a\u0004\b)\u0010\u0012R\u001b\u0010*\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010\u0012R\u001b\u0010,\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010\u0012R\u001b\u0010.\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b/\u0010\u0012R$\u00101\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001b\u00107\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0010\u001a\u0004\b8\u0010\u0012R\u001b\u00109\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\"\u001a\u0004\b:\u0010$R\u001b\u0010;\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\"\u001a\u0004\b<\u0010$R!\u0010=\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b>\u0010\u0012R\u001b\u0010?\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010\"\u001a\u0004\b@\u0010$R\u001b\u0010A\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010\u0010\u001a\u0004\bB\u0010\u0012R\u001b\u0010C\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010\u0010\u001a\u0004\bD\u0010\u0012R\u001b\u0010E\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010\u0010\u001a\u0004\bF\u0010\u0012R!\u0010G\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u00138\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\u0010\u001a\u0004\bH\u0010\u0012R\u001b\u0010I\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010\"\u001a\u0004\bJ\u0010$R\u001b\u0010K\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010\u001b\u001a\u0004\bL\u0010\u001dR\u001b\u0010M\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010\u001b\u001a\u0004\bM\u0010\u001dR\u001b\u0010N\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010\"\u001a\u0004\bO\u0010$R\u001b\u0010P\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010\"\u001a\u0004\bQ\u0010$R!\u0010R\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u00138\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010\u0010\u001a\u0004\bS\u0010\u0012R\u001b\u0010T\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010\"\u001a\u0004\bU\u0010$R\u001b\u0010V\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bV\u0010\u0010\u001a\u0004\bW\u0010\u0012¨\u0006X"}, d2 = {"Lcom/discord/analytics/generated/events/TrackPaymentFailed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "subscriptionPlanId", "Ljava/lang/Long;", "getSubscriptionPlanId", "()Ljava/lang/Long;", "Lcom/discord/primitives/Timestamp;", "subscriptionCreatedAt", "getSubscriptionCreatedAt", "paymentSourceId", "getPaymentSourceId", "tax", "getTax", "captured", "Ljava/lang/Boolean;", "getCaptured", "()Ljava/lang/Boolean;", "subscriptionType", "getSubscriptionType", "", "failureSubCode", "Ljava/lang/CharSequence;", "getFailureSubCode", "()Ljava/lang/CharSequence;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "amountRefunded", "getAmountRefunded", "amount", "getAmount", "skuType", "getSkuType", "price", "getPrice", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "paymentGateway", "getPaymentGateway", "failureMessage", "getFailureMessage", "subscriptionPaymentGatewayPlanId", "getSubscriptionPaymentGatewayPlanId", "createdAt", "getCreatedAt", "currency", "getCurrency", "paymentId", "getPaymentId", "skuId", "getSkuId", "subscriptionId", "getSubscriptionId", "subscriptionCurrentPeriodStart", "getSubscriptionCurrentPeriodStart", "paymentSourceCountry", "getPaymentSourceCountry", "taxInclusive", "getTaxInclusive", "isGift", "failureCode", "getFailureCode", "failureReason", "getFailureReason", "subscriptionCurrentPeriodEnd", "getSubscriptionCurrentPeriodEnd", "paymentType", "getPaymentType", "skuSubscriptionPlanId", "getSkuSubscriptionPlanId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackPaymentFailed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence failureReason = null;
    private final Long paymentId = null;
    private final Long createdAt = null;
    private final CharSequence paymentType = null;
    private final Long paymentGateway = null;
    private final Long price = null;
    private final CharSequence currency = null;
    private final Long amount = null;
    private final Long amountRefunded = null;
    private final Long tax = null;
    private final Boolean taxInclusive = null;
    private final Long skuId = null;
    private final Long skuType = null;
    private final Long skuSubscriptionPlanId = null;
    private final Long subscriptionId = null;
    private final Long subscriptionType = null;
    private final CharSequence subscriptionPaymentGatewayPlanId = null;
    private final Long subscriptionPlanId = null;
    private final Long subscriptionCreatedAt = null;
    private final Long subscriptionCurrentPeriodStart = null;
    private final Long subscriptionCurrentPeriodEnd = null;
    private final Long paymentSourceId = null;
    private final CharSequence paymentSourceCountry = null;
    private final CharSequence failureMessage = null;
    private final Boolean isGift = null;
    private final CharSequence failureCode = null;
    private final CharSequence failureSubCode = null;
    private final Boolean captured = null;
    private final transient String analyticsSchemaTypeName = "payment_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentFailed)) {
            return false;
        }
        TrackPaymentFailed trackPaymentFailed = (TrackPaymentFailed) other;
        return Intrinsics3.areEqual(this.failureReason, trackPaymentFailed.failureReason) && Intrinsics3.areEqual(this.paymentId, trackPaymentFailed.paymentId) && Intrinsics3.areEqual(this.createdAt, trackPaymentFailed.createdAt) && Intrinsics3.areEqual(this.paymentType, trackPaymentFailed.paymentType) && Intrinsics3.areEqual(this.paymentGateway, trackPaymentFailed.paymentGateway) && Intrinsics3.areEqual(this.price, trackPaymentFailed.price) && Intrinsics3.areEqual(this.currency, trackPaymentFailed.currency) && Intrinsics3.areEqual(this.amount, trackPaymentFailed.amount) && Intrinsics3.areEqual(this.amountRefunded, trackPaymentFailed.amountRefunded) && Intrinsics3.areEqual(this.tax, trackPaymentFailed.tax) && Intrinsics3.areEqual(this.taxInclusive, trackPaymentFailed.taxInclusive) && Intrinsics3.areEqual(this.skuId, trackPaymentFailed.skuId) && Intrinsics3.areEqual(this.skuType, trackPaymentFailed.skuType) && Intrinsics3.areEqual(this.skuSubscriptionPlanId, trackPaymentFailed.skuSubscriptionPlanId) && Intrinsics3.areEqual(this.subscriptionId, trackPaymentFailed.subscriptionId) && Intrinsics3.areEqual(this.subscriptionType, trackPaymentFailed.subscriptionType) && Intrinsics3.areEqual(this.subscriptionPaymentGatewayPlanId, trackPaymentFailed.subscriptionPaymentGatewayPlanId) && Intrinsics3.areEqual(this.subscriptionPlanId, trackPaymentFailed.subscriptionPlanId) && Intrinsics3.areEqual(this.subscriptionCreatedAt, trackPaymentFailed.subscriptionCreatedAt) && Intrinsics3.areEqual(this.subscriptionCurrentPeriodStart, trackPaymentFailed.subscriptionCurrentPeriodStart) && Intrinsics3.areEqual(this.subscriptionCurrentPeriodEnd, trackPaymentFailed.subscriptionCurrentPeriodEnd) && Intrinsics3.areEqual(this.paymentSourceId, trackPaymentFailed.paymentSourceId) && Intrinsics3.areEqual(this.paymentSourceCountry, trackPaymentFailed.paymentSourceCountry) && Intrinsics3.areEqual(this.failureMessage, trackPaymentFailed.failureMessage) && Intrinsics3.areEqual(this.isGift, trackPaymentFailed.isGift) && Intrinsics3.areEqual(this.failureCode, trackPaymentFailed.failureCode) && Intrinsics3.areEqual(this.failureSubCode, trackPaymentFailed.failureSubCode) && Intrinsics3.areEqual(this.captured, trackPaymentFailed.captured);
    }

    public int hashCode() {
        CharSequence charSequence = this.failureReason;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.paymentId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.createdAt;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.paymentType;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.paymentGateway;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.price;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.currency;
        int iHashCode7 = (iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l5 = this.amount;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.amountRefunded;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.tax;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Boolean bool = this.taxInclusive;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l8 = this.skuId;
        int iHashCode12 = (iHashCode11 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.skuType;
        int iHashCode13 = (iHashCode12 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.skuSubscriptionPlanId;
        int iHashCode14 = (iHashCode13 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.subscriptionId;
        int iHashCode15 = (iHashCode14 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.subscriptionType;
        int iHashCode16 = (iHashCode15 + (l12 != null ? l12.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.subscriptionPaymentGatewayPlanId;
        int iHashCode17 = (iHashCode16 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l13 = this.subscriptionPlanId;
        int iHashCode18 = (iHashCode17 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.subscriptionCreatedAt;
        int iHashCode19 = (iHashCode18 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.subscriptionCurrentPeriodStart;
        int iHashCode20 = (iHashCode19 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.subscriptionCurrentPeriodEnd;
        int iHashCode21 = (iHashCode20 + (l16 != null ? l16.hashCode() : 0)) * 31;
        Long l17 = this.paymentSourceId;
        int iHashCode22 = (iHashCode21 + (l17 != null ? l17.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.paymentSourceCountry;
        int iHashCode23 = (iHashCode22 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.failureMessage;
        int iHashCode24 = (iHashCode23 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Boolean bool2 = this.isGift;
        int iHashCode25 = (iHashCode24 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.failureCode;
        int iHashCode26 = (iHashCode25 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.failureSubCode;
        int iHashCode27 = (iHashCode26 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        Boolean bool3 = this.captured;
        return iHashCode27 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPaymentFailed(failureReason=");
        sbU.append(this.failureReason);
        sbU.append(", paymentId=");
        sbU.append(this.paymentId);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", paymentType=");
        sbU.append(this.paymentType);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", price=");
        sbU.append(this.price);
        sbU.append(", currency=");
        sbU.append(this.currency);
        sbU.append(", amount=");
        sbU.append(this.amount);
        sbU.append(", amountRefunded=");
        sbU.append(this.amountRefunded);
        sbU.append(", tax=");
        sbU.append(this.tax);
        sbU.append(", taxInclusive=");
        sbU.append(this.taxInclusive);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", skuType=");
        sbU.append(this.skuType);
        sbU.append(", skuSubscriptionPlanId=");
        sbU.append(this.skuSubscriptionPlanId);
        sbU.append(", subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", subscriptionType=");
        sbU.append(this.subscriptionType);
        sbU.append(", subscriptionPaymentGatewayPlanId=");
        sbU.append(this.subscriptionPaymentGatewayPlanId);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", subscriptionCreatedAt=");
        sbU.append(this.subscriptionCreatedAt);
        sbU.append(", subscriptionCurrentPeriodStart=");
        sbU.append(this.subscriptionCurrentPeriodStart);
        sbU.append(", subscriptionCurrentPeriodEnd=");
        sbU.append(this.subscriptionCurrentPeriodEnd);
        sbU.append(", paymentSourceId=");
        sbU.append(this.paymentSourceId);
        sbU.append(", paymentSourceCountry=");
        sbU.append(this.paymentSourceCountry);
        sbU.append(", failureMessage=");
        sbU.append(this.failureMessage);
        sbU.append(", isGift=");
        sbU.append(this.isGift);
        sbU.append(", failureCode=");
        sbU.append(this.failureCode);
        sbU.append(", failureSubCode=");
        sbU.append(this.failureSubCode);
        sbU.append(", captured=");
        return outline.D(sbU, this.captured, ")");
    }
}
