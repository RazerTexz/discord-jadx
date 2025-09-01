package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackGuildLfgGroup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u001b\u0010 \u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010¨\u0006\""}, d2 = {"Lcom/discord/analytics/generated/traits/TrackGuildLfgGroup;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "lfgGroupOwnerId", "Ljava/lang/Long;", "getLfgGroupOwnerId", "()Ljava/lang/Long;", "lfgDirectoryGuildId", "getLfgDirectoryGuildId", "", "lfgDirectoryGuildName", "Ljava/lang/CharSequence;", "getLfgDirectoryGuildName", "()Ljava/lang/CharSequence;", "lfgGroupMaxSize", "getLfgGroupMaxSize", "lfgDirectoryChannelId", "getLfgDirectoryChannelId", "lfgGroupDescription", "getLfgGroupDescription", "lfgGroupChannelId", "getLfgGroupChannelId", "lfgGroupCurrentSize", "getLfgGroupCurrentSize", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackGuildLfgGroup {
    private final Long lfgGroupChannelId = null;
    private final Long lfgGroupOwnerId = null;
    private final Long lfgDirectoryChannelId = null;
    private final Long lfgDirectoryGuildId = null;
    private final CharSequence lfgDirectoryGuildName = null;
    private final Long lfgGroupMaxSize = null;
    private final Long lfgGroupCurrentSize = null;
    private final CharSequence lfgGroupDescription = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildLfgGroup)) {
            return false;
        }
        TrackGuildLfgGroup trackGuildLfgGroup = (TrackGuildLfgGroup) other;
        return Intrinsics3.areEqual(this.lfgGroupChannelId, trackGuildLfgGroup.lfgGroupChannelId) && Intrinsics3.areEqual(this.lfgGroupOwnerId, trackGuildLfgGroup.lfgGroupOwnerId) && Intrinsics3.areEqual(this.lfgDirectoryChannelId, trackGuildLfgGroup.lfgDirectoryChannelId) && Intrinsics3.areEqual(this.lfgDirectoryGuildId, trackGuildLfgGroup.lfgDirectoryGuildId) && Intrinsics3.areEqual(this.lfgDirectoryGuildName, trackGuildLfgGroup.lfgDirectoryGuildName) && Intrinsics3.areEqual(this.lfgGroupMaxSize, trackGuildLfgGroup.lfgGroupMaxSize) && Intrinsics3.areEqual(this.lfgGroupCurrentSize, trackGuildLfgGroup.lfgGroupCurrentSize) && Intrinsics3.areEqual(this.lfgGroupDescription, trackGuildLfgGroup.lfgGroupDescription);
    }

    public int hashCode() {
        Long l = this.lfgGroupChannelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.lfgGroupOwnerId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.lfgDirectoryChannelId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.lfgDirectoryGuildId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence = this.lfgDirectoryGuildName;
        int iHashCode5 = (iHashCode4 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l5 = this.lfgGroupMaxSize;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.lfgGroupCurrentSize;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.lfgGroupDescription;
        return iHashCode7 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildLfgGroup(lfgGroupChannelId=");
        sbU.append(this.lfgGroupChannelId);
        sbU.append(", lfgGroupOwnerId=");
        sbU.append(this.lfgGroupOwnerId);
        sbU.append(", lfgDirectoryChannelId=");
        sbU.append(this.lfgDirectoryChannelId);
        sbU.append(", lfgDirectoryGuildId=");
        sbU.append(this.lfgDirectoryGuildId);
        sbU.append(", lfgDirectoryGuildName=");
        sbU.append(this.lfgDirectoryGuildName);
        sbU.append(", lfgGroupMaxSize=");
        sbU.append(this.lfgGroupMaxSize);
        sbU.append(", lfgGroupCurrentSize=");
        sbU.append(this.lfgGroupCurrentSize);
        sbU.append(", lfgGroupDescription=");
        return outline.E(sbU, this.lfgGroupDescription, ")");
    }
}
