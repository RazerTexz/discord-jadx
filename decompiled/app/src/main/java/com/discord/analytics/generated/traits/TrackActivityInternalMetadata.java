package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackActivityInternalMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u001b\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010¨\u0006\""}, d2 = {"Lcom/discord/analytics/generated/traits/TrackActivityInternalMetadata;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "activityVersion", "Ljava/lang/CharSequence;", "getActivityVersion", "()Ljava/lang/CharSequence;", "userSessionId", "getUserSessionId", "activityInstanceId", "getActivityInstanceId", "", "numConcurrentUsers", "Ljava/lang/Long;", "getNumConcurrentUsers", "()Ljava/lang/Long;", "activityApplicationId", "getActivityApplicationId", "participationMode", "getParticipationMode", "activityGuildId", "getActivityGuildId", "groupSessionId", "getGroupSessionId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackActivityInternalMetadata {
    private final Long activityApplicationId = null;
    private final CharSequence groupSessionId = null;
    private final CharSequence userSessionId = null;
    private final CharSequence activityInstanceId = null;
    private final CharSequence activityVersion = null;
    private final Long numConcurrentUsers = null;
    private final Long activityGuildId = null;
    private final CharSequence participationMode = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalMetadata)) {
            return false;
        }
        TrackActivityInternalMetadata trackActivityInternalMetadata = (TrackActivityInternalMetadata) other;
        return Intrinsics3.areEqual(this.activityApplicationId, trackActivityInternalMetadata.activityApplicationId) && Intrinsics3.areEqual(this.groupSessionId, trackActivityInternalMetadata.groupSessionId) && Intrinsics3.areEqual(this.userSessionId, trackActivityInternalMetadata.userSessionId) && Intrinsics3.areEqual(this.activityInstanceId, trackActivityInternalMetadata.activityInstanceId) && Intrinsics3.areEqual(this.activityVersion, trackActivityInternalMetadata.activityVersion) && Intrinsics3.areEqual(this.numConcurrentUsers, trackActivityInternalMetadata.numConcurrentUsers) && Intrinsics3.areEqual(this.activityGuildId, trackActivityInternalMetadata.activityGuildId) && Intrinsics3.areEqual(this.participationMode, trackActivityInternalMetadata.participationMode);
    }

    public int hashCode() {
        Long l = this.activityApplicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.groupSessionId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.userSessionId;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.activityInstanceId;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.activityVersion;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l2 = this.numConcurrentUsers;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.activityGuildId;
        int iHashCode7 = (iHashCode6 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.participationMode;
        return iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackActivityInternalMetadata(activityApplicationId=");
        sbU.append(this.activityApplicationId);
        sbU.append(", groupSessionId=");
        sbU.append(this.groupSessionId);
        sbU.append(", userSessionId=");
        sbU.append(this.userSessionId);
        sbU.append(", activityInstanceId=");
        sbU.append(this.activityInstanceId);
        sbU.append(", activityVersion=");
        sbU.append(this.activityVersion);
        sbU.append(", numConcurrentUsers=");
        sbU.append(this.numConcurrentUsers);
        sbU.append(", activityGuildId=");
        sbU.append(this.activityGuildId);
        sbU.append(", participationMode=");
        return outline.E(sbU, this.participationMode, ")");
    }
}
