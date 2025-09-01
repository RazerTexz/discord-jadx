package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNotificationClicked.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0006R\u001b\u0010)\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u0010-\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0011\u001a\u0004\b.\u0010\u0013R\u001b\u0010/\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0016\u001a\u0004\b0\u0010\u0018R\u001b\u00101\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0011\u001a\u0004\b2\u0010\u0013R\u001b\u00103\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0016\u001a\u0004\b4\u0010\u0018R\u001b\u00105\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0011\u001a\u0004\b6\u0010\u0013R\u001b\u00107\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0011\u001a\u0004\b8\u0010\u0013R\u001b\u00109\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0011\u001a\u0004\b:\u0010\u0013R$\u0010<\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001b\u0010B\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u0011\u001a\u0004\bC\u0010\u0013R\u001b\u0010D\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u0016\u001a\u0004\bE\u0010\u0018R\u001b\u0010F\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010*\u001a\u0004\bG\u0010,¨\u0006H"}, d2 = {"Lcom/discord/analytics/generated/events/TrackNotificationClicked;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "guildId", "Ljava/lang/Long;", "getGuildId", "()Ljava/lang/Long;", "", "platformType", "Ljava/lang/CharSequence;", "getPlatformType", "()Ljava/lang/CharSequence;", "pushDataSize", "getPushDataSize", "messageDataSize", "getMessageDataSize", "relType", "getRelType", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "trackOverlayClientMetadata", "Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "getTrackOverlayClientMetadata", "()Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;", "setTrackOverlayClientMetadata", "(Lcom/discord/analytics/generated/traits/TrackOverlayClientMetadata;)V", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "notifInApp", "Ljava/lang/Boolean;", "getNotifInApp", "()Ljava/lang/Boolean;", "channelType", "getChannelType", "actionType", "getActionType", "messageType", "getMessageType", "activityName", "getActivityName", "channelId", "getChannelId", "activityType", "getActivityType", "notifUserId", "getNotifUserId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "messageId", "getMessageId", "notifType", "getNotifType", "hasMessage", "getHasMessage", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNotificationClicked implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Boolean notifInApp = null;
    private final CharSequence notifType = null;
    private final Long notifUserId = null;
    private final Long messageId = null;
    private final Long messageType = null;
    private final Boolean hasMessage = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long relType = null;
    private final CharSequence platformType = null;
    private final Long activityType = null;
    private final CharSequence activityName = null;
    private final CharSequence actionType = null;
    private final Long pushDataSize = null;
    private final Long messageDataSize = null;
    private final transient String analyticsSchemaTypeName = "notification_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationClicked)) {
            return false;
        }
        TrackNotificationClicked trackNotificationClicked = (TrackNotificationClicked) other;
        return Intrinsics3.areEqual(this.notifInApp, trackNotificationClicked.notifInApp) && Intrinsics3.areEqual(this.notifType, trackNotificationClicked.notifType) && Intrinsics3.areEqual(this.notifUserId, trackNotificationClicked.notifUserId) && Intrinsics3.areEqual(this.messageId, trackNotificationClicked.messageId) && Intrinsics3.areEqual(this.messageType, trackNotificationClicked.messageType) && Intrinsics3.areEqual(this.hasMessage, trackNotificationClicked.hasMessage) && Intrinsics3.areEqual(this.guildId, trackNotificationClicked.guildId) && Intrinsics3.areEqual(this.channelId, trackNotificationClicked.channelId) && Intrinsics3.areEqual(this.channelType, trackNotificationClicked.channelType) && Intrinsics3.areEqual(this.relType, trackNotificationClicked.relType) && Intrinsics3.areEqual(this.platformType, trackNotificationClicked.platformType) && Intrinsics3.areEqual(this.activityType, trackNotificationClicked.activityType) && Intrinsics3.areEqual(this.activityName, trackNotificationClicked.activityName) && Intrinsics3.areEqual(this.actionType, trackNotificationClicked.actionType) && Intrinsics3.areEqual(this.pushDataSize, trackNotificationClicked.pushDataSize) && Intrinsics3.areEqual(this.messageDataSize, trackNotificationClicked.messageDataSize);
    }

    public int hashCode() {
        Boolean bool = this.notifInApp;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.notifType;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.notifUserId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.messageId;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.messageType;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasMessage;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.channelId;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.channelType;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.relType;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.platformType;
        int iHashCode11 = (iHashCode10 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l8 = this.activityType;
        int iHashCode12 = (iHashCode11 + (l8 != null ? l8.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.activityName;
        int iHashCode13 = (iHashCode12 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.actionType;
        int iHashCode14 = (iHashCode13 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l9 = this.pushDataSize;
        int iHashCode15 = (iHashCode14 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.messageDataSize;
        return iHashCode15 + (l10 != null ? l10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNotificationClicked(notifInApp=");
        sbU.append(this.notifInApp);
        sbU.append(", notifType=");
        sbU.append(this.notifType);
        sbU.append(", notifUserId=");
        sbU.append(this.notifUserId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", messageType=");
        sbU.append(this.messageType);
        sbU.append(", hasMessage=");
        sbU.append(this.hasMessage);
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
        sbU.append(this.activityName);
        sbU.append(", actionType=");
        sbU.append(this.actionType);
        sbU.append(", pushDataSize=");
        sbU.append(this.pushDataSize);
        sbU.append(", messageDataSize=");
        return outline.G(sbU, this.messageDataSize, ")");
    }
}
