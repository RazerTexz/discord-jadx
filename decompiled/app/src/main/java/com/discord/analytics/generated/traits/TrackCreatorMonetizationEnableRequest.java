package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackCreatorMonetizationEnableRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R!\u0010\u0019\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R!\u0010\u001d\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/discord/analytics/generated/traits/TrackCreatorMonetizationEnableRequest;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "creatorMonetizationEnableRequestId", "Ljava/lang/Long;", "getCreatorMonetizationEnableRequestId", "()Ljava/lang/Long;", "", "actionedNote", "Ljava/lang/CharSequence;", "getActionedNote", "()Ljava/lang/CharSequence;", "actionedReason", "getActionedReason", "Lcom/discord/primitives/Timestamp;", "actionedAt", "getActionedAt", "state", "getState", "termsAckedAt", "getTermsAckedAt", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackCreatorMonetizationEnableRequest {
    private final Long creatorMonetizationEnableRequestId = null;
    private final CharSequence state = null;
    private final CharSequence actionedReason = null;
    private final CharSequence actionedNote = null;
    private final Long actionedAt = null;
    private final Long termsAckedAt = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackCreatorMonetizationEnableRequest)) {
            return false;
        }
        TrackCreatorMonetizationEnableRequest trackCreatorMonetizationEnableRequest = (TrackCreatorMonetizationEnableRequest) other;
        return Intrinsics3.areEqual(this.creatorMonetizationEnableRequestId, trackCreatorMonetizationEnableRequest.creatorMonetizationEnableRequestId) && Intrinsics3.areEqual(this.state, trackCreatorMonetizationEnableRequest.state) && Intrinsics3.areEqual(this.actionedReason, trackCreatorMonetizationEnableRequest.actionedReason) && Intrinsics3.areEqual(this.actionedNote, trackCreatorMonetizationEnableRequest.actionedNote) && Intrinsics3.areEqual(this.actionedAt, trackCreatorMonetizationEnableRequest.actionedAt) && Intrinsics3.areEqual(this.termsAckedAt, trackCreatorMonetizationEnableRequest.termsAckedAt);
    }

    public int hashCode() {
        Long l = this.creatorMonetizationEnableRequestId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.state;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.actionedReason;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.actionedNote;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l2 = this.actionedAt;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.termsAckedAt;
        return iHashCode5 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackCreatorMonetizationEnableRequest(creatorMonetizationEnableRequestId=");
        sbU.append(this.creatorMonetizationEnableRequestId);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(", actionedReason=");
        sbU.append(this.actionedReason);
        sbU.append(", actionedNote=");
        sbU.append(this.actionedNote);
        sbU.append(", actionedAt=");
        sbU.append(this.actionedAt);
        sbU.append(", termsAckedAt=");
        return outline.G(sbU, this.termsAckedAt, ")");
    }
}
