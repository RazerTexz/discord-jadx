package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackTransactionCompleted.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012R\u001c\u0010)\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0005R\u001b\u0010,\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010\u0012R\u001b\u0010.\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b/\u0010\u0012R!\u00101\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`08\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0010\u001a\u0004\b2\u0010\u0012R\u001b\u00103\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b4\u0010\u0012R\u001b\u00105\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0015\u001a\u0004\b6\u0010\u0017R\u001b\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010<\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0010\u001a\u0004\b=\u0010\u0012R\u001b\u0010>\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u0010\u001a\u0004\b?\u0010\u0012R\u001b\u0010@\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u0010\u001a\u0004\bA\u0010\u0012R\u001b\u0010B\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u0010\u001a\u0004\bC\u0010\u0012R\u001b\u0010D\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u0010\u001a\u0004\bE\u0010\u0012R\u001b\u0010F\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010\u0010\u001a\u0004\bG\u0010\u0012R\u001b\u0010H\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u0010\u001a\u0004\bI\u0010\u0012R\u001b\u0010J\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010\u0010\u001a\u0004\bK\u0010\u0012¨\u0006L"}, d2 = {"Lcom/discord/analytics/generated/events/TrackTransactionCompleted;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "transactionType", "Ljava/lang/Long;", "getTransactionType", "()Ljava/lang/Long;", "", "presentmentCurrency", "Ljava/lang/CharSequence;", "getPresentmentCurrency", "()Ljava/lang/CharSequence;", "settlementTax", "getSettlementTax", "netSettlementFees", "getNetSettlementFees", "settlementAmount", "getSettlementAmount", "netSettlementTax", "getNetSettlementTax", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "netPresentmentFees", "getNetPresentmentFees", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "settlementFees", "getSettlementFees", "netPresentmentTax", "getNetPresentmentTax", "Lcom/discord/primitives/Timestamp;", "createdAt", "getCreatedAt", "presentmentFees", "getPresentmentFees", "settlementCurrency", "getSettlementCurrency", "", "exchangeRate", "Ljava/lang/Float;", "getExchangeRate", "()Ljava/lang/Float;", "paymentGateway", "getPaymentGateway", "netPresentmentAmount", "getNetPresentmentAmount", "skuId", "getSkuId", "presentmentAmount", "getPresentmentAmount", "netSettlementAmount", "getNetSettlementAmount", "transactionId", "getTransactionId", "presentmentTax", "getPresentmentTax", "paymentId", "getPaymentId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackTransactionCompleted implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long paymentId = null;
    private final Long paymentGateway = null;
    private final Long createdAt = null;
    private final Long transactionId = null;
    private final Long transactionType = null;
    private final Long skuId = null;
    private final Float exchangeRate = null;
    private final CharSequence presentmentCurrency = null;
    private final CharSequence settlementCurrency = null;
    private final Long presentmentAmount = null;
    private final Long presentmentFees = null;
    private final Long presentmentTax = null;
    private final Long settlementAmount = null;
    private final Long settlementFees = null;
    private final Long settlementTax = null;
    private final Long netPresentmentAmount = null;
    private final Long netPresentmentFees = null;
    private final Long netPresentmentTax = null;
    private final Long netSettlementAmount = null;
    private final Long netSettlementFees = null;
    private final Long netSettlementTax = null;
    private final transient String analyticsSchemaTypeName = "transaction_completed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackTransactionCompleted)) {
            return false;
        }
        TrackTransactionCompleted trackTransactionCompleted = (TrackTransactionCompleted) other;
        return Intrinsics3.areEqual(this.paymentId, trackTransactionCompleted.paymentId) && Intrinsics3.areEqual(this.paymentGateway, trackTransactionCompleted.paymentGateway) && Intrinsics3.areEqual(this.createdAt, trackTransactionCompleted.createdAt) && Intrinsics3.areEqual(this.transactionId, trackTransactionCompleted.transactionId) && Intrinsics3.areEqual(this.transactionType, trackTransactionCompleted.transactionType) && Intrinsics3.areEqual(this.skuId, trackTransactionCompleted.skuId) && Intrinsics3.areEqual(this.exchangeRate, trackTransactionCompleted.exchangeRate) && Intrinsics3.areEqual(this.presentmentCurrency, trackTransactionCompleted.presentmentCurrency) && Intrinsics3.areEqual(this.settlementCurrency, trackTransactionCompleted.settlementCurrency) && Intrinsics3.areEqual(this.presentmentAmount, trackTransactionCompleted.presentmentAmount) && Intrinsics3.areEqual(this.presentmentFees, trackTransactionCompleted.presentmentFees) && Intrinsics3.areEqual(this.presentmentTax, trackTransactionCompleted.presentmentTax) && Intrinsics3.areEqual(this.settlementAmount, trackTransactionCompleted.settlementAmount) && Intrinsics3.areEqual(this.settlementFees, trackTransactionCompleted.settlementFees) && Intrinsics3.areEqual(this.settlementTax, trackTransactionCompleted.settlementTax) && Intrinsics3.areEqual(this.netPresentmentAmount, trackTransactionCompleted.netPresentmentAmount) && Intrinsics3.areEqual(this.netPresentmentFees, trackTransactionCompleted.netPresentmentFees) && Intrinsics3.areEqual(this.netPresentmentTax, trackTransactionCompleted.netPresentmentTax) && Intrinsics3.areEqual(this.netSettlementAmount, trackTransactionCompleted.netSettlementAmount) && Intrinsics3.areEqual(this.netSettlementFees, trackTransactionCompleted.netSettlementFees) && Intrinsics3.areEqual(this.netSettlementTax, trackTransactionCompleted.netSettlementTax);
    }

    public int hashCode() {
        Long l = this.paymentId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.paymentGateway;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.createdAt;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.transactionId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.transactionType;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.skuId;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Float f = this.exchangeRate;
        int iHashCode7 = (iHashCode6 + (f != null ? f.hashCode() : 0)) * 31;
        CharSequence charSequence = this.presentmentCurrency;
        int iHashCode8 = (iHashCode7 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.settlementCurrency;
        int iHashCode9 = (iHashCode8 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l7 = this.presentmentAmount;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.presentmentFees;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.presentmentTax;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.settlementAmount;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.settlementFees;
        int iHashCode14 = (iHashCode13 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.settlementTax;
        int iHashCode15 = (iHashCode14 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.netPresentmentAmount;
        int iHashCode16 = (iHashCode15 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.netPresentmentFees;
        int iHashCode17 = (iHashCode16 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.netPresentmentTax;
        int iHashCode18 = (iHashCode17 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.netSettlementAmount;
        int iHashCode19 = (iHashCode18 + (l16 != null ? l16.hashCode() : 0)) * 31;
        Long l17 = this.netSettlementFees;
        int iHashCode20 = (iHashCode19 + (l17 != null ? l17.hashCode() : 0)) * 31;
        Long l18 = this.netSettlementTax;
        return iHashCode20 + (l18 != null ? l18.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackTransactionCompleted(paymentId=");
        sbU.append(this.paymentId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", transactionId=");
        sbU.append(this.transactionId);
        sbU.append(", transactionType=");
        sbU.append(this.transactionType);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", exchangeRate=");
        sbU.append(this.exchangeRate);
        sbU.append(", presentmentCurrency=");
        sbU.append(this.presentmentCurrency);
        sbU.append(", settlementCurrency=");
        sbU.append(this.settlementCurrency);
        sbU.append(", presentmentAmount=");
        sbU.append(this.presentmentAmount);
        sbU.append(", presentmentFees=");
        sbU.append(this.presentmentFees);
        sbU.append(", presentmentTax=");
        sbU.append(this.presentmentTax);
        sbU.append(", settlementAmount=");
        sbU.append(this.settlementAmount);
        sbU.append(", settlementFees=");
        sbU.append(this.settlementFees);
        sbU.append(", settlementTax=");
        sbU.append(this.settlementTax);
        sbU.append(", netPresentmentAmount=");
        sbU.append(this.netPresentmentAmount);
        sbU.append(", netPresentmentFees=");
        sbU.append(this.netPresentmentFees);
        sbU.append(", netPresentmentTax=");
        sbU.append(this.netPresentmentTax);
        sbU.append(", netSettlementAmount=");
        sbU.append(this.netSettlementAmount);
        sbU.append(", netSettlementFees=");
        sbU.append(this.netSettlementFees);
        sbU.append(", netSettlementTax=");
        return outline.G(sbU, this.netSettlementTax, ")");
    }
}
