package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNotificationViewed.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0006R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\u001b\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013R$\u0010#\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u0010.\u001a\u0004\u0018\u00010)8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-R\u001b\u00100\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0011\u001a\u0004\b1\u0010\u0013R\u001b\u00102\u001a\u0004\u0018\u00010)8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b3\u0010-R\u001b\u00104\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0011\u001a\u0004\b5\u0010\u0013R\u001b\u00106\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0011\u001a\u0004\b7\u0010\u0013R\u001b\u00108\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u0011\u001a\u0004\b9\u0010\u0013R\u001b\u0010:\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0011\u001a\u0004\b;\u0010\u0013¨\u0006<"}, d2 = {"Lcom/discord/analytics/generated/events/TrackNotificationViewed;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "messageId", "Ljava/lang/Long;", "getMessageId", "()Ljava/lang/Long;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "trackOverlayClientMetadata", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "getTrackOverlayClientMetadata", "()Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "setTrackOverlayClientMetadata", "(Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;)V", "channelType", "getChannelType", "relType", "getRelType", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "platformType", "Ljava/lang/CharSequence;", "getPlatformType", "()Ljava/lang/CharSequence;", "activityName", "getActivityName", "messageType", "getMessageType", "notifType", "getNotifType", "guildId", "getGuildId", "activityType", "getActivityType", "channelId", "getChannelId", "notifUserId", "getNotifUserId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNotificationViewed implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final CharSequence notifType = null;
    private final Long notifUserId = null;
    private final Long messageId = null;
    private final Long messageType = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long relType = null;
    private final CharSequence platformType = null;
    private final Long activityType = null;
    private final CharSequence activityName = null;
    private final transient String analyticsSchemaTypeName = "notification_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationViewed)) {
            return false;
        }
        TrackNotificationViewed trackNotificationViewed = (TrackNotificationViewed) other;
        return Intrinsics3.areEqual(this.notifType, trackNotificationViewed.notifType) && Intrinsics3.areEqual(this.notifUserId, trackNotificationViewed.notifUserId) && Intrinsics3.areEqual(this.messageId, trackNotificationViewed.messageId) && Intrinsics3.areEqual(this.messageType, trackNotificationViewed.messageType) && Intrinsics3.areEqual(this.guildId, trackNotificationViewed.guildId) && Intrinsics3.areEqual(this.channelId, trackNotificationViewed.channelId) && Intrinsics3.areEqual(this.channelType, trackNotificationViewed.channelType) && Intrinsics3.areEqual(this.relType, trackNotificationViewed.relType) && Intrinsics3.areEqual(this.platformType, trackNotificationViewed.platformType) && Intrinsics3.areEqual(this.activityType, trackNotificationViewed.activityType) && Intrinsics3.areEqual(this.activityName, trackNotificationViewed.activityName);
    }

    public int hashCode() {
        CharSequence charSequence = this.notifType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.notifUserId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.messageId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.messageType;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.channelId;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.channelType;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.relType;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.platformType;
        int iHashCode9 = (iHashCode8 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l8 = this.activityType;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.activityName;
        return iHashCode10 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNotificationViewed(notifType=");
        sbU.append(this.notifType);
        sbU.append(", notifUserId=");
        sbU.append(this.notifUserId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", messageType=");
        sbU.append(this.messageType);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", relType=");
        sbU.append(this.relType);
        sbU.append(", platformType=");
        sbU.append(this.platformType);
        sbU.append(", activityType=");
        sbU.append(this.activityType);
        sbU.append(", activityName=");
        return outline.E(sbU, this.activityName, ")");
    }
}
