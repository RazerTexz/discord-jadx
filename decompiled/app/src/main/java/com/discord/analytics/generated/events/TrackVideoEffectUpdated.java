package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackVideoEffectUpdated.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0006R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R\u001b\u0010 \u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\u0016R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u001b\u0010$\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u001dR$\u0010'\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u0010-\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001dR\u001b\u0010/\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u0010\u0016R$\u00102\u001a\u0004\u0018\u0001018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u00108\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b8\u0010:R\u001b\u0010;\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u001b\u001a\u0004\b<\u0010\u001d¨\u0006="}, d2 = {"Lcom/discord/analytics/generated/events/TrackVideoEffectUpdated;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackLocationMetadataReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "", "effectState", "Ljava/lang/CharSequence;", "getEffectState", "()Ljava/lang/CharSequence;", "effectDetail", "getEffectDetail", "", "videoStreamCount", "Ljava/lang/Long;", "getVideoStreamCount", "()Ljava/lang/Long;", "effectType", "getEffectType", "rtcConnectionId", "getRtcConnectionId", "guildId", "getGuildId", "channelId", "getChannelId", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "trackLocationMetadata", "Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "getTrackLocationMetadata", "()Lcom/discord/analytics/generated/traits/TrackLocationMetadata;", "setTrackLocationMetadata", "(Lcom/discord/analytics/generated/traits/TrackLocationMetadata;)V", "channelType", "getChannelType", "mediaSessionId", "getMediaSessionId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "isAnimated", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "voiceStateCount", "getVoiceStateCount", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackVideoEffectUpdated implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence effectType = null;
    private final CharSequence effectDetail = null;
    private final CharSequence effectState = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long guildId = null;
    private final Long videoStreamCount = null;
    private final Long voiceStateCount = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence rtcConnectionId = null;
    private final Boolean isAnimated = null;
    private final transient String analyticsSchemaTypeName = "video_effect_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoEffectUpdated)) {
            return false;
        }
        TrackVideoEffectUpdated trackVideoEffectUpdated = (TrackVideoEffectUpdated) other;
        return Intrinsics3.areEqual(this.effectType, trackVideoEffectUpdated.effectType) && Intrinsics3.areEqual(this.effectDetail, trackVideoEffectUpdated.effectDetail) && Intrinsics3.areEqual(this.effectState, trackVideoEffectUpdated.effectState) && Intrinsics3.areEqual(this.channelId, trackVideoEffectUpdated.channelId) && Intrinsics3.areEqual(this.channelType, trackVideoEffectUpdated.channelType) && Intrinsics3.areEqual(this.guildId, trackVideoEffectUpdated.guildId) && Intrinsics3.areEqual(this.videoStreamCount, trackVideoEffectUpdated.videoStreamCount) && Intrinsics3.areEqual(this.voiceStateCount, trackVideoEffectUpdated.voiceStateCount) && Intrinsics3.areEqual(this.mediaSessionId, trackVideoEffectUpdated.mediaSessionId) && Intrinsics3.areEqual(this.rtcConnectionId, trackVideoEffectUpdated.rtcConnectionId) && Intrinsics3.areEqual(this.isAnimated, trackVideoEffectUpdated.isAnimated);
    }

    public int hashCode() {
        CharSequence charSequence = this.effectType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.effectDetail;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.effectState;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.channelId;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.channelType;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.videoStreamCount;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.voiceStateCount;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.mediaSessionId;
        int iHashCode9 = (iHashCode8 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.rtcConnectionId;
        int iHashCode10 = (iHashCode9 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Boolean bool = this.isAnimated;
        return iHashCode10 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVideoEffectUpdated(effectType=");
        sbU.append(this.effectType);
        sbU.append(", effectDetail=");
        sbU.append(this.effectDetail);
        sbU.append(", effectState=");
        sbU.append(this.effectState);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", videoStreamCount=");
        sbU.append(this.videoStreamCount);
        sbU.append(", voiceStateCount=");
        sbU.append(this.voiceStateCount);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", isAnimated=");
        return outline.D(sbU, this.isAnimated, ")");
    }
}
