package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata2;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadata2;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackSubscriptionPeriodScheduled.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R!\u0010)\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010\u0019R\u001b\u0010+\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010\u0019R!\u0010-\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`(8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0017\u001a\u0004\b.\u0010\u0019R\u001b\u0010/\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0012\u001a\u0004\b0\u0010\u0014R$\u00102\u001a\u0004\u0018\u0001018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u00108\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u0017\u001a\u0004\b9\u0010\u0019R\u001b\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R$\u0010@\u001a\u0004\u0018\u00010?8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001b\u0010F\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010\u0017\u001a\u0004\bG\u0010\u0019R\u001c\u0010H\u001a\u00020\u00068\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010\b¨\u0006K"}, d2 = {"Lcom/discord/analytics/generated/events/TrackSubscriptionPeriodScheduled;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackEntitlementMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackPaymentMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "expectedToAutorenew", "Ljava/lang/Boolean;", "getExpectedToAutorenew", "()Ljava/lang/Boolean;", "", "paymentId", "Ljava/lang/Long;", "getPaymentId", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;", "trackPaymentMetadata", "Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;", "getTrackPaymentMetadata", "()Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;", "setTrackPaymentMetadata", "(Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;)V", "Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;", "trackSubscriptionMetadata", "Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;", "getTrackSubscriptionMetadata", "()Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;", "setTrackSubscriptionMetadata", "(Lcom/discord/analytics/generated/traits/TrackSubscriptionMetadata;)V", "Lcom/discord/primitives/Timestamp;", "scheduledEndTimestamp", "getScheduledEndTimestamp", "paymentGateway", "getPaymentGateway", "scheduledStartTimestamp", "getScheduledStartTimestamp", "renewal", "getRenewal", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "subscriptionId", "getSubscriptionId", "", "accessType", "Ljava/lang/CharSequence;", "getAccessType", "()Ljava/lang/CharSequence;", "Lcom/discord/analytics/generated/traits/TrackEntitlementMetadata;", "trackEntitlementMetadata", "Lcom/discord/analytics/generated/traits/TrackEntitlementMetadata;", "getTrackEntitlementMetadata", "()Lcom/discord/analytics/generated/traits/TrackEntitlementMetadata;", "setTrackEntitlementMetadata", "(Lcom/discord/analytics/generated/traits/TrackEntitlementMetadata;)V", "skuId", "getSkuId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSubscriptionPeriodScheduled implements AnalyticsSchema, TrackBase2, TrackSubscriptionMetadata2, TrackEntitlementMetadata2, TrackPaymentMetadata2 {
    private TrackBase trackBase;
    private TrackEntitlementMetadata trackEntitlementMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final Long subscriptionId = null;
    private final Long paymentId = null;
    private final Long paymentGateway = null;
    private final Long skuId = null;
    private final Long scheduledStartTimestamp = null;
    private final Long scheduledEndTimestamp = null;
    private final CharSequence accessType = null;
    private final Boolean expectedToAutorenew = null;
    private final Boolean renewal = null;
    private final transient String analyticsSchemaTypeName = "subscription_period_scheduled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionPeriodScheduled)) {
            return false;
        }
        TrackSubscriptionPeriodScheduled trackSubscriptionPeriodScheduled = (TrackSubscriptionPeriodScheduled) other;
        return Intrinsics3.areEqual(this.subscriptionId, trackSubscriptionPeriodScheduled.subscriptionId) && Intrinsics3.areEqual(this.paymentId, trackSubscriptionPeriodScheduled.paymentId) && Intrinsics3.areEqual(this.paymentGateway, trackSubscriptionPeriodScheduled.paymentGateway) && Intrinsics3.areEqual(this.skuId, trackSubscriptionPeriodScheduled.skuId) && Intrinsics3.areEqual(this.scheduledStartTimestamp, trackSubscriptionPeriodScheduled.scheduledStartTimestamp) && Intrinsics3.areEqual(this.scheduledEndTimestamp, trackSubscriptionPeriodScheduled.scheduledEndTimestamp) && Intrinsics3.areEqual(this.accessType, trackSubscriptionPeriodScheduled.accessType) && Intrinsics3.areEqual(this.expectedToAutorenew, trackSubscriptionPeriodScheduled.expectedToAutorenew) && Intrinsics3.areEqual(this.renewal, trackSubscriptionPeriodScheduled.renewal);
    }

    public int hashCode() {
        Long l = this.subscriptionId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.paymentId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.paymentGateway;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.skuId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.scheduledStartTimestamp;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.scheduledEndTimestamp;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence = this.accessType;
        int iHashCode7 = (iHashCode6 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.expectedToAutorenew;
        int iHashCode8 = (iHashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.renewal;
        return iHashCode8 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSubscriptionPeriodScheduled(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", paymentId=");
        sbU.append(this.paymentId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", scheduledStartTimestamp=");
        sbU.append(this.scheduledStartTimestamp);
        sbU.append(", scheduledEndTimestamp=");
        sbU.append(this.scheduledEndTimestamp);
        sbU.append(", accessType=");
        sbU.append(this.accessType);
        sbU.append(", expectedToAutorenew=");
        sbU.append(this.expectedToAutorenew);
        sbU.append(", renewal=");
        return outline.D(sbU, this.renewal, ")");
    }
}
