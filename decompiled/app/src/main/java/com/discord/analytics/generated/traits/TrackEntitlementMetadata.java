package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackEntitlementMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackEntitlementMetadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "entitlementPaymentId", "Ljava/lang/Long;", "getEntitlementPaymentId", "()Ljava/lang/Long;", "entitlementCreatorId", "getEntitlementCreatorId", "giftCodeBatchId", "getGiftCodeBatchId", "entitlementId", "getEntitlementId", "giftStyle", "getGiftStyle", "entitlementSubscriptionPlanId", "getEntitlementSubscriptionPlanId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackEntitlementMetadata {
    private final Long entitlementId = null;
    private final Long entitlementCreatorId = null;
    private final Long entitlementSubscriptionPlanId = null;
    private final Long entitlementPaymentId = null;
    private final Long giftCodeBatchId = null;
    private final Long giftStyle = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackEntitlementMetadata)) {
            return false;
        }
        TrackEntitlementMetadata trackEntitlementMetadata = (TrackEntitlementMetadata) other;
        return Intrinsics3.areEqual(this.entitlementId, trackEntitlementMetadata.entitlementId) && Intrinsics3.areEqual(this.entitlementCreatorId, trackEntitlementMetadata.entitlementCreatorId) && Intrinsics3.areEqual(this.entitlementSubscriptionPlanId, trackEntitlementMetadata.entitlementSubscriptionPlanId) && Intrinsics3.areEqual(this.entitlementPaymentId, trackEntitlementMetadata.entitlementPaymentId) && Intrinsics3.areEqual(this.giftCodeBatchId, trackEntitlementMetadata.giftCodeBatchId) && Intrinsics3.areEqual(this.giftStyle, trackEntitlementMetadata.giftStyle);
    }

    public int hashCode() {
        Long l = this.entitlementId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.entitlementCreatorId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.entitlementSubscriptionPlanId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.entitlementPaymentId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.giftCodeBatchId;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.giftStyle;
        return iHashCode5 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackEntitlementMetadata(entitlementId=");
        sbU.append(this.entitlementId);
        sbU.append(", entitlementCreatorId=");
        sbU.append(this.entitlementCreatorId);
        sbU.append(", entitlementSubscriptionPlanId=");
        sbU.append(this.entitlementSubscriptionPlanId);
        sbU.append(", entitlementPaymentId=");
        sbU.append(this.entitlementPaymentId);
        sbU.append(", giftCodeBatchId=");
        sbU.append(this.giftCodeBatchId);
        sbU.append(", giftStyle=");
        return outline.G(sbU, this.giftStyle, ")");
    }
}
