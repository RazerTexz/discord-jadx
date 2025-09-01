package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackSourceMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackSourceMetadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "sourcePromotionId", "Ljava/lang/Long;", "getSourcePromotionId", "()Ljava/lang/Long;", "", "sourceSection", "Ljava/lang/CharSequence;", "getSourceSection", "()Ljava/lang/CharSequence;", "sourceObject", "getSourceObject", "sourcePage", "getSourcePage", "sourceObjectType", "getSourceObjectType", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackSourceMetadata {
    private final CharSequence sourceObject;
    private final CharSequence sourceObjectType;
    private final CharSequence sourcePage;
    private final Long sourcePromotionId;
    private final CharSequence sourceSection;

    public TrackSourceMetadata() {
        this(null, null, null, null, null, 31);
    }

    public TrackSourceMetadata(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Long l, int i) {
        int i2 = i & 2;
        int i3 = i & 4;
        int i4 = i & 8;
        int i5 = i & 16;
        this.sourcePage = (i & 1) != 0 ? null : charSequence;
        this.sourceSection = null;
        this.sourceObject = null;
        this.sourceObjectType = null;
        this.sourcePromotionId = null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSourceMetadata)) {
            return false;
        }
        TrackSourceMetadata trackSourceMetadata = (TrackSourceMetadata) other;
        return Intrinsics3.areEqual(this.sourcePage, trackSourceMetadata.sourcePage) && Intrinsics3.areEqual(this.sourceSection, trackSourceMetadata.sourceSection) && Intrinsics3.areEqual(this.sourceObject, trackSourceMetadata.sourceObject) && Intrinsics3.areEqual(this.sourceObjectType, trackSourceMetadata.sourceObjectType) && Intrinsics3.areEqual(this.sourcePromotionId, trackSourceMetadata.sourcePromotionId);
    }

    public int hashCode() {
        CharSequence charSequence = this.sourcePage;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.sourceSection;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.sourceObject;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.sourceObjectType;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.sourcePromotionId;
        return iHashCode4 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSourceMetadata(sourcePage=");
        sbU.append(this.sourcePage);
        sbU.append(", sourceSection=");
        sbU.append(this.sourceSection);
        sbU.append(", sourceObject=");
        sbU.append(this.sourceObject);
        sbU.append(", sourceObjectType=");
        sbU.append(this.sourceObjectType);
        sbU.append(", sourcePromotionId=");
        return outline.G(sbU, this.sourcePromotionId, ")");
    }
}
