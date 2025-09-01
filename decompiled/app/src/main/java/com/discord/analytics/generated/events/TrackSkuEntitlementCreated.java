package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata2;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackSkuEntitlementCreated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\u00068\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010'\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010&R$\u0010*\u001a\u0004\u0018\u00010)8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R!\u00102\u001a\n\u0018\u000100j\u0004\u0018\u0001`18\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R$\u00107\u001a\u0004\u0018\u0001068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R!\u0010=\u001a\n\u0018\u000100j\u0004\u0018\u0001`18\u0006@\u0006¢\u0006\f\n\u0004\b=\u00103\u001a\u0004\b>\u00105¨\u0006?"}, d2 = {"Lcom/discord/analytics/generated/events/TrackSkuEntitlementCreated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackPaymentMetadataReceiver;", "Lcom/discord/analytics/generated/traits/TrackEntitlementMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;", "trackStoreSkuMetadata", "Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;", "getTrackStoreSkuMetadata", "()Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;", "setTrackStoreSkuMetadata", "(Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackEntitlementMetadata;", "trackEntitlementMetadata", "Lcom/discord/analytics/generated/traits/TrackEntitlementMetadata;", "getTrackEntitlementMetadata", "()Lcom/discord/analytics/generated/traits/TrackEntitlementMetadata;", "setTrackEntitlementMetadata", "(Lcom/discord/analytics/generated/traits/TrackEntitlementMetadata;)V", "", "redemptionCode", "Ljava/lang/CharSequence;", "getRedemptionCode", "()Ljava/lang/CharSequence;", "entitlementType", "getEntitlementType", "Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;", "trackPaymentMetadata", "Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;", "getTrackPaymentMetadata", "()Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;", "setTrackPaymentMetadata", "(Lcom/discord/analytics/generated/traits/TrackPaymentMetadata;)V", "", "Lcom/discord/primitives/Timestamp;", "startTimestamp", "Ljava/lang/Long;", "getStartTimestamp", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "endTimestamp", "getEndTimestamp", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSkuEntitlementCreated implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2, TrackPaymentMetadata2, TrackEntitlementMetadata2 {
    private TrackBase trackBase;
    private TrackEntitlementMetadata trackEntitlementMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence entitlementType = null;
    private final Long startTimestamp = null;
    private final Long endTimestamp = null;
    private final CharSequence redemptionCode = null;
    private final transient String analyticsSchemaTypeName = "sku_entitlement_created";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSkuEntitlementCreated)) {
            return false;
        }
        TrackSkuEntitlementCreated trackSkuEntitlementCreated = (TrackSkuEntitlementCreated) other;
        return Intrinsics3.areEqual(this.entitlementType, trackSkuEntitlementCreated.entitlementType) && Intrinsics3.areEqual(this.startTimestamp, trackSkuEntitlementCreated.startTimestamp) && Intrinsics3.areEqual(this.endTimestamp, trackSkuEntitlementCreated.endTimestamp) && Intrinsics3.areEqual(this.redemptionCode, trackSkuEntitlementCreated.redemptionCode);
    }

    public int hashCode() {
        CharSequence charSequence = this.entitlementType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.startTimestamp;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.endTimestamp;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.redemptionCode;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSkuEntitlementCreated(entitlementType=");
        sbU.append(this.entitlementType);
        sbU.append(", startTimestamp=");
        sbU.append(this.startTimestamp);
        sbU.append(", endTimestamp=");
        sbU.append(this.endTimestamp);
        sbU.append(", redemptionCode=");
        return outline.E(sbU, this.redemptionCode, ")");
    }
}
