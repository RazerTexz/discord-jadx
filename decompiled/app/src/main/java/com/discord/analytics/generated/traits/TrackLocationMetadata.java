package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackLocationMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "locationPromotionId", "Ljava/lang/Long;", "getLocationPromotionId", "()Ljava/lang/Long;", "", "locationPage", "Ljava/lang/CharSequence;", "getLocationPage", "()Ljava/lang/CharSequence;", "locationSection", "getLocationSection", "locationObject", "getLocationObject", "locationObjectType", "getLocationObjectType", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackLocationMetadata {
    private final CharSequence locationPage = null;
    private final CharSequence locationSection = null;
    private final CharSequence locationObject = null;
    private final CharSequence locationObjectType = null;
    private final Long locationPromotionId = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLocationMetadata)) {
            return false;
        }
        TrackLocationMetadata trackLocationMetadata = (TrackLocationMetadata) other;
        return Intrinsics3.areEqual(this.locationPage, trackLocationMetadata.locationPage) && Intrinsics3.areEqual(this.locationSection, trackLocationMetadata.locationSection) && Intrinsics3.areEqual(this.locationObject, trackLocationMetadata.locationObject) && Intrinsics3.areEqual(this.locationObjectType, trackLocationMetadata.locationObjectType) && Intrinsics3.areEqual(this.locationPromotionId, trackLocationMetadata.locationPromotionId);
    }

    public int hashCode() {
        CharSequence charSequence = this.locationPage;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.locationSection;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.locationObject;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.locationObjectType;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.locationPromotionId;
        return iHashCode4 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackLocationMetadata(locationPage=");
        sbU.append(this.locationPage);
        sbU.append(", locationSection=");
        sbU.append(this.locationSection);
        sbU.append(", locationObject=");
        sbU.append(this.locationObject);
        sbU.append(", locationObjectType=");
        sbU.append(this.locationObjectType);
        sbU.append(", locationPromotionId=");
        return outline.G(sbU, this.locationPromotionId, ")");
    }
}
