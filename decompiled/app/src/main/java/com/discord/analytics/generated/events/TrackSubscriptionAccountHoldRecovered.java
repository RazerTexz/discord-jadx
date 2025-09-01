package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackSubscriptionAccountHoldRecovered.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R!\u0010\u001b\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R$\u0010\"\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R!\u0010(\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010\u0017R!\u0010*\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u0017R\u001c\u0010,\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0005¨\u0006/"}, d2 = {"Lcom/discord/analytics/generated/events/TrackSubscriptionAccountHoldRecovered;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "paymentGatewayPlanId", "Ljava/lang/CharSequence;", "getPaymentGatewayPlanId", "()Ljava/lang/CharSequence;", "", "subscriptionType", "Ljava/lang/Long;", "getSubscriptionType", "()Ljava/lang/Long;", "paymentGateway", "getPaymentGateway", "Lcom/discord/primitives/Timestamp;", "createdAt", "getCreatedAt", "planId", "getPlanId", "subscriptionId", "getSubscriptionId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "currentPeriodStart", "getCurrentPeriodStart", "currentPeriodEnd", "getCurrentPeriodEnd", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSubscriptionAccountHoldRecovered implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long subscriptionId = null;
    private final Long subscriptionType = null;
    private final CharSequence paymentGatewayPlanId = null;
    private final Long planId = null;
    private final Long paymentGateway = null;
    private final Long createdAt = null;
    private final Long currentPeriodStart = null;
    private final Long currentPeriodEnd = null;
    private final transient String analyticsSchemaTypeName = "subscription_account_hold_recovered";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionAccountHoldRecovered)) {
            return false;
        }
        TrackSubscriptionAccountHoldRecovered trackSubscriptionAccountHoldRecovered = (TrackSubscriptionAccountHoldRecovered) other;
        return Intrinsics3.areEqual(this.subscriptionId, trackSubscriptionAccountHoldRecovered.subscriptionId) && Intrinsics3.areEqual(this.subscriptionType, trackSubscriptionAccountHoldRecovered.subscriptionType) && Intrinsics3.areEqual(this.paymentGatewayPlanId, trackSubscriptionAccountHoldRecovered.paymentGatewayPlanId) && Intrinsics3.areEqual(this.planId, trackSubscriptionAccountHoldRecovered.planId) && Intrinsics3.areEqual(this.paymentGateway, trackSubscriptionAccountHoldRecovered.paymentGateway) && Intrinsics3.areEqual(this.createdAt, trackSubscriptionAccountHoldRecovered.createdAt) && Intrinsics3.areEqual(this.currentPeriodStart, trackSubscriptionAccountHoldRecovered.currentPeriodStart) && Intrinsics3.areEqual(this.currentPeriodEnd, trackSubscriptionAccountHoldRecovered.currentPeriodEnd);
    }

    public int hashCode() {
        Long l = this.subscriptionId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.subscriptionType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.paymentGatewayPlanId;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.planId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.paymentGateway;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.createdAt;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.currentPeriodStart;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.currentPeriodEnd;
        return iHashCode7 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSubscriptionAccountHoldRecovered(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", subscriptionType=");
        sbU.append(this.subscriptionType);
        sbU.append(", paymentGatewayPlanId=");
        sbU.append(this.paymentGatewayPlanId);
        sbU.append(", planId=");
        sbU.append(this.planId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", currentPeriodStart=");
        sbU.append(this.currentPeriodStart);
        sbU.append(", currentPeriodEnd=");
        return outline.G(sbU, this.currentPeriodEnd, ")");
    }
}
