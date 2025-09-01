package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackThread;
import com.discord.analytics.generated.traits.TrackThread2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackJoinThread.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001b\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR$\u0010#\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010)\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001dR\u001c\u0010+\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u0006R\u001b\u0010.\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001d¨\u00060"}, d2 = {"Lcom/discord/analytics/generated/events/TrackJoinThread;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackThreadReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "isSelfJoin", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", "parentId", "Ljava/lang/Long;", "getParentId", "()Ljava/lang/Long;", "channelId", "getChannelId", "targetUserId", "getTargetUserId", "Lcom/discord/analytics/generated/traits/TrackThread;", "trackThread", "Lcom/discord/analytics/generated/traits/TrackThread;", "getTrackThread", "()Lcom/discord/analytics/generated/traits/TrackThread;", "setTrackThread", "(Lcom/discord/analytics/generated/traits/TrackThread;)V", "guildId", "getGuildId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "channelType", "getChannelType", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackJoinThread implements AnalyticsSchema, TrackBase2, TrackThread2 {
    private TrackBase trackBase;
    private TrackThread trackThread;
    private final Long channelId = null;
    private final Long parentId = null;
    private final Long guildId = null;
    private final Long channelType = null;
    private final Long targetUserId = null;
    private final Boolean isSelfJoin = null;
    private final transient String analyticsSchemaTypeName = "join_thread";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackJoinThread)) {
            return false;
        }
        TrackJoinThread trackJoinThread = (TrackJoinThread) other;
        return Intrinsics3.areEqual(this.channelId, trackJoinThread.channelId) && Intrinsics3.areEqual(this.parentId, trackJoinThread.parentId) && Intrinsics3.areEqual(this.guildId, trackJoinThread.guildId) && Intrinsics3.areEqual(this.channelType, trackJoinThread.channelType) && Intrinsics3.areEqual(this.targetUserId, trackJoinThread.targetUserId) && Intrinsics3.areEqual(this.isSelfJoin, trackJoinThread.isSelfJoin);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.parentId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.channelType;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.targetUserId;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.isSelfJoin;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackJoinThread(channelId=");
        sbU.append(this.channelId);
        sbU.append(", parentId=");
        sbU.append(this.parentId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", targetUserId=");
        sbU.append(this.targetUserId);
        sbU.append(", isSelfJoin=");
        return outline.D(sbU, this.isSelfJoin, ")");
    }
}
