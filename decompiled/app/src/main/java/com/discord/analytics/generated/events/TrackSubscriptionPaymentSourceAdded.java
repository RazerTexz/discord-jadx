package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackSubscriptionPaymentSourceAdded.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R!\u0010&\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010\u0012R\u001b\u0010(\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0010\u001a\u0004\b)\u0010\u0012R\u001b\u0010*\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010\u0012R\u001c\u0010,\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0005R!\u0010/\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`%8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0012¨\u00061"}, d2 = {"Lcom/discord/analytics/generated/events/TrackSubscriptionPaymentSourceAdded;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "paymentSourceGateway", "Ljava/lang/Long;", "getPaymentSourceGateway", "()Ljava/lang/Long;", "paymentSourceId", "getPaymentSourceId", "planId", "getPlanId", "", "paymentGatewayPlanId", "Ljava/lang/CharSequence;", "getPaymentGatewayPlanId", "()Ljava/lang/CharSequence;", "paymentGateway", "getPaymentGateway", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/primitives/Timestamp;", "currentPeriodEnd", "getCurrentPeriodEnd", "subscriptionId", "getSubscriptionId", "subscriptionType", "getSubscriptionType", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "currentPeriodStart", "getCurrentPeriodStart", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSubscriptionPaymentSourceAdded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long subscriptionId = null;
    private final Long subscriptionType = null;
    private final CharSequence paymentGatewayPlanId = null;
    private final Long planId = null;
    private final Long paymentGateway = null;
    private final Long paymentSourceGateway = null;
    private final Long paymentSourceId = null;
    private final Long currentPeriodStart = null;
    private final Long currentPeriodEnd = null;
    private final transient String analyticsSchemaTypeName = "subscription_payment_source_added";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionPaymentSourceAdded)) {
            return false;
        }
        TrackSubscriptionPaymentSourceAdded trackSubscriptionPaymentSourceAdded = (TrackSubscriptionPaymentSourceAdded) other;
        return Intrinsics3.areEqual(this.subscriptionId, trackSubscriptionPaymentSourceAdded.subscriptionId) && Intrinsics3.areEqual(this.subscriptionType, trackSubscriptionPaymentSourceAdded.subscriptionType) && Intrinsics3.areEqual(this.paymentGatewayPlanId, trackSubscriptionPaymentSourceAdded.paymentGatewayPlanId) && Intrinsics3.areEqual(this.planId, trackSubscriptionPaymentSourceAdded.planId) && Intrinsics3.areEqual(this.paymentGateway, trackSubscriptionPaymentSourceAdded.paymentGateway) && Intrinsics3.areEqual(this.paymentSourceGateway, trackSubscriptionPaymentSourceAdded.paymentSourceGateway) && Intrinsics3.areEqual(this.paymentSourceId, trackSubscriptionPaymentSourceAdded.paymentSourceId) && Intrinsics3.areEqual(this.currentPeriodStart, trackSubscriptionPaymentSourceAdded.currentPeriodStart) && Intrinsics3.areEqual(this.currentPeriodEnd, trackSubscriptionPaymentSourceAdded.currentPeriodEnd);
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
        Long l5 = this.paymentSourceGateway;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.paymentSourceId;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.currentPeriodStart;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.currentPeriodEnd;
        return iHashCode8 + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSubscriptionPaymentSourceAdded(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", subscriptionType=");
        sbU.append(this.subscriptionType);
        sbU.append(", paymentGatewayPlanId=");
        sbU.append(this.paymentGatewayPlanId);
        sbU.append(", planId=");
        sbU.append(this.planId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", paymentSourceGateway=");
        sbU.append(this.paymentSourceGateway);
        sbU.append(", paymentSourceId=");
        sbU.append(this.paymentSourceId);
        sbU.append(", currentPeriodStart=");
        sbU.append(this.currentPeriodStart);
        sbU.append(", currentPeriodEnd=");
        return outline.G(sbU, this.currentPeriodEnd, ")");
    }
}
