package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackVideoBackgroundFeedback.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017R\u001b\u0010)\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0012R\u001b\u0010+\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b,\u0010\u0012R\u001c\u0010-\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0005R\u001b\u00100\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b1\u0010\u0012R\u001b\u00102\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0015\u001a\u0004\b3\u0010\u0017R\u001b\u00104\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u0010\u001a\u0004\b5\u0010\u0012R\u001b\u00106\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u0010\u001a\u0004\b7\u0010\u0012R\u001b\u00108\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u0010\u001a\u0004\b9\u0010\u0012R\u001b\u0010:\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u0010\u001a\u0004\b;\u0010\u0012R\u001b\u0010<\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0015\u001a\u0004\b=\u0010\u0017R\u001b\u0010>\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u001b\u001a\u0004\b?\u0010\u001d¨\u0006@"}, d2 = {"Lcom/discord/analytics/generated/events/TrackVideoBackgroundFeedback;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "feedback", "Ljava/lang/CharSequence;", "getFeedback", "()Ljava/lang/CharSequence;", "", "channelId", "Ljava/lang/Long;", "getChannelId", "()Ljava/lang/Long;", "videoStreamCount", "getVideoStreamCount", "videoHardwareScalingEnabled", "Ljava/lang/Boolean;", "getVideoHardwareScalingEnabled", "()Ljava/lang/Boolean;", "duration", "getDuration", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "voiceStateCount", "getVoiceStateCount", "rtcConnectionId", "getRtcConnectionId", "mediaSessionId", "getMediaSessionId", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "videoEffectDetail", "getVideoEffectDetail", "guildId", "getGuildId", ModelAuditLogEntry.CHANGE_KEY_REASON, "getReason", "videoEffectType", "getVideoEffectType", "videoDeviceName", "getVideoDeviceName", "rating", "getRating", "channelType", "getChannelType", "videoEnabled", "getVideoEnabled", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackVideoBackgroundFeedback implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence reason = null;
    private final CharSequence rating = null;
    private final CharSequence feedback = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence rtcConnectionId = null;
    private final Long duration = null;
    private final CharSequence videoDeviceName = null;
    private final Boolean videoEnabled = null;
    private final Boolean videoHardwareScalingEnabled = null;
    private final Long videoStreamCount = null;
    private final Long voiceStateCount = null;
    private final CharSequence videoEffectType = null;
    private final CharSequence videoEffectDetail = null;
    private final transient String analyticsSchemaTypeName = "video_background_feedback";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoBackgroundFeedback)) {
            return false;
        }
        TrackVideoBackgroundFeedback trackVideoBackgroundFeedback = (TrackVideoBackgroundFeedback) other;
        return Intrinsics3.areEqual(this.reason, trackVideoBackgroundFeedback.reason) && Intrinsics3.areEqual(this.rating, trackVideoBackgroundFeedback.rating) && Intrinsics3.areEqual(this.feedback, trackVideoBackgroundFeedback.feedback) && Intrinsics3.areEqual(this.guildId, trackVideoBackgroundFeedback.guildId) && Intrinsics3.areEqual(this.channelId, trackVideoBackgroundFeedback.channelId) && Intrinsics3.areEqual(this.channelType, trackVideoBackgroundFeedback.channelType) && Intrinsics3.areEqual(this.mediaSessionId, trackVideoBackgroundFeedback.mediaSessionId) && Intrinsics3.areEqual(this.rtcConnectionId, trackVideoBackgroundFeedback.rtcConnectionId) && Intrinsics3.areEqual(this.duration, trackVideoBackgroundFeedback.duration) && Intrinsics3.areEqual(this.videoDeviceName, trackVideoBackgroundFeedback.videoDeviceName) && Intrinsics3.areEqual(this.videoEnabled, trackVideoBackgroundFeedback.videoEnabled) && Intrinsics3.areEqual(this.videoHardwareScalingEnabled, trackVideoBackgroundFeedback.videoHardwareScalingEnabled) && Intrinsics3.areEqual(this.videoStreamCount, trackVideoBackgroundFeedback.videoStreamCount) && Intrinsics3.areEqual(this.voiceStateCount, trackVideoBackgroundFeedback.voiceStateCount) && Intrinsics3.areEqual(this.videoEffectType, trackVideoBackgroundFeedback.videoEffectType) && Intrinsics3.areEqual(this.videoEffectDetail, trackVideoBackgroundFeedback.videoEffectDetail);
    }

    public int hashCode() {
        CharSequence charSequence = this.reason;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.rating;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.feedback;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.guildId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelType;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.mediaSessionId;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.rtcConnectionId;
        int iHashCode8 = (iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l4 = this.duration;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.videoDeviceName;
        int iHashCode10 = (iHashCode9 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.videoHardwareScalingEnabled;
        int iHashCode12 = (iHashCode11 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l5 = this.videoStreamCount;
        int iHashCode13 = (iHashCode12 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.voiceStateCount;
        int iHashCode14 = (iHashCode13 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.videoEffectType;
        int iHashCode15 = (iHashCode14 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.videoEffectDetail;
        return iHashCode15 + (charSequence8 != null ? charSequence8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVideoBackgroundFeedback(reason=");
        sbU.append(this.reason);
        sbU.append(", rating=");
        sbU.append(this.rating);
        sbU.append(", feedback=");
        sbU.append(this.feedback);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", duration=");
        sbU.append(this.duration);
        sbU.append(", videoDeviceName=");
        sbU.append(this.videoDeviceName);
        sbU.append(", videoEnabled=");
        sbU.append(this.videoEnabled);
        sbU.append(", videoHardwareScalingEnabled=");
        sbU.append(this.videoHardwareScalingEnabled);
        sbU.append(", videoStreamCount=");
        sbU.append(this.videoStreamCount);
        sbU.append(", voiceStateCount=");
        sbU.append(this.voiceStateCount);
        sbU.append(", videoEffectType=");
        sbU.append(this.videoEffectType);
        sbU.append(", videoEffectDetail=");
        return outline.E(sbU, this.videoEffectDetail, ")");
    }
}
