package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackThread.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0012\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackThread;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "threadAutoArchiveDurationMinutes", "Ljava/lang/Long;", "getThreadAutoArchiveDurationMinutes", "()Ljava/lang/Long;", "Lcom/discord/primitives/Timestamp;", "threadApproximateCreationDate", "getThreadApproximateCreationDate", "threadApproximateMemberCount", "getThreadApproximateMemberCount", "threadLocked", "Ljava/lang/Boolean;", "getThreadLocked", "()Ljava/lang/Boolean;", "threadArchived", "getThreadArchived", "threadApproximateMessageCount", "getThreadApproximateMessageCount", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackThread {
    private final Long threadApproximateMemberCount = null;
    private final Long threadApproximateMessageCount = null;
    private final Boolean threadArchived = null;
    private final Boolean threadLocked = null;
    private final Long threadAutoArchiveDurationMinutes = null;
    private final Long threadApproximateCreationDate = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackThread)) {
            return false;
        }
        TrackThread trackThread = (TrackThread) other;
        return Intrinsics3.areEqual(this.threadApproximateMemberCount, trackThread.threadApproximateMemberCount) && Intrinsics3.areEqual(this.threadApproximateMessageCount, trackThread.threadApproximateMessageCount) && Intrinsics3.areEqual(this.threadArchived, trackThread.threadArchived) && Intrinsics3.areEqual(this.threadLocked, trackThread.threadLocked) && Intrinsics3.areEqual(this.threadAutoArchiveDurationMinutes, trackThread.threadAutoArchiveDurationMinutes) && Intrinsics3.areEqual(this.threadApproximateCreationDate, trackThread.threadApproximateCreationDate);
    }

    public int hashCode() {
        Long l = this.threadApproximateMemberCount;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.threadApproximateMessageCount;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.threadArchived;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.threadLocked;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l3 = this.threadAutoArchiveDurationMinutes;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.threadApproximateCreationDate;
        return iHashCode5 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackThread(threadApproximateMemberCount=");
        sbU.append(this.threadApproximateMemberCount);
        sbU.append(", threadApproximateMessageCount=");
        sbU.append(this.threadApproximateMessageCount);
        sbU.append(", threadArchived=");
        sbU.append(this.threadArchived);
        sbU.append(", threadLocked=");
        sbU.append(this.threadLocked);
        sbU.append(", threadAutoArchiveDurationMinutes=");
        sbU.append(this.threadAutoArchiveDurationMinutes);
        sbU.append(", threadApproximateCreationDate=");
        return outline.G(sbU, this.threadApproximateCreationDate, ")");
    }
}
