package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackLfgGroup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/discord/analytics/generated/traits/TrackLfgGroup;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "title", "Ljava/lang/CharSequence;", "getTitle", "()Ljava/lang/CharSequence;", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "getDescription", "", "totalSize", "Ljava/lang/Long;", "getTotalSize", "()Ljava/lang/Long;", "ownerId", "getOwnerId", "freeSize", "getFreeSize", "gameId", "getGameId", "gameName", "getGameName", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackLfgGroup {
    private final CharSequence gameName = null;
    private final Long gameId = null;
    private final Long totalSize = null;
    private final Long freeSize = null;
    private final Long ownerId = null;
    private final CharSequence title = null;
    private final CharSequence description = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLfgGroup)) {
            return false;
        }
        TrackLfgGroup trackLfgGroup = (TrackLfgGroup) other;
        return Intrinsics3.areEqual(this.gameName, trackLfgGroup.gameName) && Intrinsics3.areEqual(this.gameId, trackLfgGroup.gameId) && Intrinsics3.areEqual(this.totalSize, trackLfgGroup.totalSize) && Intrinsics3.areEqual(this.freeSize, trackLfgGroup.freeSize) && Intrinsics3.areEqual(this.ownerId, trackLfgGroup.ownerId) && Intrinsics3.areEqual(this.title, trackLfgGroup.title) && Intrinsics3.areEqual(this.description, trackLfgGroup.description);
    }

    public int hashCode() {
        CharSequence charSequence = this.gameName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.gameId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.totalSize;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.freeSize;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.ownerId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.title;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.description;
        return iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackLfgGroup(gameName=");
        sbU.append(this.gameName);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", totalSize=");
        sbU.append(this.totalSize);
        sbU.append(", freeSize=");
        sbU.append(this.freeSize);
        sbU.append(", ownerId=");
        sbU.append(this.ownerId);
        sbU.append(", title=");
        sbU.append(this.title);
        sbU.append(", description=");
        return outline.E(sbU, this.description, ")");
    }
}
