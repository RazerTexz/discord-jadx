package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrackDispatchPatch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackDispatchPatch;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "targetBuildId", "Ljava/lang/Long;", "getTargetBuildId", "()Ljava/lang/Long;", "", "patchType", "Ljava/lang/CharSequence;", "getPatchType", "()Ljava/lang/CharSequence;", "", "targetManifestIds", "Ljava/util/List;", "getTargetManifestIds", "()Ljava/util/List;", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackDispatchPatch {
    private final Long targetBuildId = null;
    private final List<Long> targetManifestIds = null;
    private final CharSequence patchType = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDispatchPatch)) {
            return false;
        }
        TrackDispatchPatch trackDispatchPatch = (TrackDispatchPatch) other;
        return Intrinsics3.areEqual(this.targetBuildId, trackDispatchPatch.targetBuildId) && Intrinsics3.areEqual(this.targetManifestIds, trackDispatchPatch.targetManifestIds) && Intrinsics3.areEqual(this.patchType, trackDispatchPatch.patchType);
    }

    public int hashCode() {
        Long l = this.targetBuildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<Long> list = this.targetManifestIds;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        CharSequence charSequence = this.patchType;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDispatchPatch(targetBuildId=");
        sbU.append(this.targetBuildId);
        sbU.append(", targetManifestIds=");
        sbU.append(this.targetManifestIds);
        sbU.append(", patchType=");
        return outline.E(sbU, this.patchType, ")");
    }
}
