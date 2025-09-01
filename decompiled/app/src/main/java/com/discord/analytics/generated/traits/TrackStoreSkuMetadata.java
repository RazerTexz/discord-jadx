package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackStoreSkuMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/discord/analytics/generated/traits/TrackStoreSkuMetadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "skuId", "Ljava/lang/Long;", "getSkuId", "()Ljava/lang/Long;", "", "storeTitle", "Ljava/lang/CharSequence;", "getStoreTitle", "()Ljava/lang/CharSequence;", "quantity", "getQuantity", "applicationName", "getApplicationName", "skuType", "getSkuType", "distributionType", "getDistributionType", "applicationId", "getApplicationId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackStoreSkuMetadata {
    private final Long skuId = null;
    private final Long skuType = null;
    private final Long applicationId = null;
    private final CharSequence applicationName = null;
    private final CharSequence storeTitle = null;
    private final CharSequence distributionType = null;
    private final Long quantity = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreSkuMetadata)) {
            return false;
        }
        TrackStoreSkuMetadata trackStoreSkuMetadata = (TrackStoreSkuMetadata) other;
        return Intrinsics3.areEqual(this.skuId, trackStoreSkuMetadata.skuId) && Intrinsics3.areEqual(this.skuType, trackStoreSkuMetadata.skuType) && Intrinsics3.areEqual(this.applicationId, trackStoreSkuMetadata.applicationId) && Intrinsics3.areEqual(this.applicationName, trackStoreSkuMetadata.applicationName) && Intrinsics3.areEqual(this.storeTitle, trackStoreSkuMetadata.storeTitle) && Intrinsics3.areEqual(this.distributionType, trackStoreSkuMetadata.distributionType) && Intrinsics3.areEqual(this.quantity, trackStoreSkuMetadata.quantity);
    }

    public int hashCode() {
        Long l = this.skuId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.skuType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.applicationId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.applicationName;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.storeTitle;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.distributionType;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l4 = this.quantity;
        return iHashCode6 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStoreSkuMetadata(skuId=");
        sbU.append(this.skuId);
        sbU.append(", skuType=");
        sbU.append(this.skuType);
        sbU.append(", applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", applicationName=");
        sbU.append(this.applicationName);
        sbU.append(", storeTitle=");
        sbU.append(this.storeTitle);
        sbU.append(", distributionType=");
        sbU.append(this.distributionType);
        sbU.append(", quantity=");
        return outline.G(sbU, this.quantity, ")");
    }
}
