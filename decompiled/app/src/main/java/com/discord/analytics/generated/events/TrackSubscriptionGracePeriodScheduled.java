package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackSubscriptionGracePeriodScheduled.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR!\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0015\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R!\u0010\u0017\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010$\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u0014R\u001c\u0010&\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0006R\u001b\u0010)\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014R$\u0010,\u001a\u0004\u0018\u00010+8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/discord/analytics/generated/events/TrackSubscriptionGracePeriodScheduled;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/primitives/Timestamp;", "currentPeriodStart", "Ljava/lang/Long;", "getCurrentPeriodStart", "()Ljava/lang/Long;", "currentPeriodEnd", "getCurrentPeriodEnd", "invoiceDueAt", "getInvoiceDueAt", "paymentGateway", "getPaymentGateway", "gracePeriodDays", "getGracePeriodDays", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "subscriptionId", "getSubscriptionId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "invoiceId", "getInvoiceId", "Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;", "trackSubscriptionMetadata", "Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;", "getTrackSubscriptionMetadata", "()Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;", "setTrackSubscriptionMetadata", "(Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSubscriptionGracePeriodScheduled implements AnalyticsSchema, TrackBase2, TrackSubscriptionMetadata2 {
    private TrackBase trackBase;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final Long subscriptionId = null;
    private final Long paymentGateway = null;
    private final Long currentPeriodStart = null;
    private final Long currentPeriodEnd = null;
    private final Long invoiceId = null;
    private final Long invoiceDueAt = null;
    private final Long gracePeriodDays = null;
    private final transient String analyticsSchemaTypeName = "subscription_grace_period_scheduled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionGracePeriodScheduled)) {
            return false;
        }
        TrackSubscriptionGracePeriodScheduled trackSubscriptionGracePeriodScheduled = (TrackSubscriptionGracePeriodScheduled) other;
        return Intrinsics3.areEqual(this.subscriptionId, trackSubscriptionGracePeriodScheduled.subscriptionId) && Intrinsics3.areEqual(this.paymentGateway, trackSubscriptionGracePeriodScheduled.paymentGateway) && Intrinsics3.areEqual(this.currentPeriodStart, trackSubscriptionGracePeriodScheduled.currentPeriodStart) && Intrinsics3.areEqual(this.currentPeriodEnd, trackSubscriptionGracePeriodScheduled.currentPeriodEnd) && Intrinsics3.areEqual(this.invoiceId, trackSubscriptionGracePeriodScheduled.invoiceId) && Intrinsics3.areEqual(this.invoiceDueAt, trackSubscriptionGracePeriodScheduled.invoiceDueAt) && Intrinsics3.areEqual(this.gracePeriodDays, trackSubscriptionGracePeriodScheduled.gracePeriodDays);
    }

    public int hashCode() {
        Long l = this.subscriptionId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.paymentGateway;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.currentPeriodStart;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.currentPeriodEnd;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.invoiceId;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.invoiceDueAt;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.gracePeriodDays;
        return iHashCode6 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSubscriptionGracePeriodScheduled(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", currentPeriodStart=");
        sbU.append(this.currentPeriodStart);
        sbU.append(", currentPeriodEnd=");
        sbU.append(this.currentPeriodEnd);
        sbU.append(", invoiceId=");
        sbU.append(this.invoiceId);
        sbU.append(", invoiceDueAt=");
        sbU.append(this.invoiceDueAt);
        sbU.append(", gracePeriodDays=");
        return outline.G(sbU, this.gracePeriodDays, ")");
    }
}
