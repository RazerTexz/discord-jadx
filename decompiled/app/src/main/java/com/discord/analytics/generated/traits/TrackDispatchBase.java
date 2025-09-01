package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackDispatchBase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackDispatchBase;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "branchId", "Ljava/lang/Long;", "getBranchId", "()Ljava/lang/Long;", "buildId", "getBuildId", "", "nonce", "Ljava/lang/CharSequence;", "getNonce", "()Ljava/lang/CharSequence;", "", "manifestIds", "Ljava/util/List;", "getManifestIds", "()Ljava/util/List;", "applicationId", "getApplicationId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackDispatchBase {
    private final Long applicationId = null;
    private final Long branchId = null;
    private final Long buildId = null;
    private final List<Long> manifestIds = null;
    private final CharSequence nonce = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDispatchBase)) {
            return false;
        }
        TrackDispatchBase trackDispatchBase = (TrackDispatchBase) other;
        return Intrinsics3.areEqual(this.applicationId, trackDispatchBase.applicationId) && Intrinsics3.areEqual(this.branchId, trackDispatchBase.branchId) && Intrinsics3.areEqual(this.buildId, trackDispatchBase.buildId) && Intrinsics3.areEqual(this.manifestIds, trackDispatchBase.manifestIds) && Intrinsics3.areEqual(this.nonce, trackDispatchBase.nonce);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.branchId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.buildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.manifestIds;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        CharSequence charSequence = this.nonce;
        return iHashCode4 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDispatchBase(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", branchId=");
        sbU.append(this.branchId);
        sbU.append(", buildId=");
        sbU.append(this.buildId);
        sbU.append(", manifestIds=");
        sbU.append(this.manifestIds);
        sbU.append(", nonce=");
        return outline.E(sbU, this.nonce, ")");
    }
}
