package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackNetworkInformation;
import com.discord.analytics.generated.traits.TrackNetworkInformation2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackVideoStreamStarted.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0006R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013R\u001b\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001b\u0010$\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u001b\u0010&\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001fR\u001b\u0010(\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b)\u0010\u0013R\u001b\u0010*\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010\u001fR\u001b\u0010,\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u001fR\u001b\u0010.\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0011\u001a\u0004\b/\u0010\u0013R\u001b\u00100\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u001d\u001a\u0004\b1\u0010\u001fR$\u00103\u001a\u0004\u0018\u0001028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010@\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u0011\u001a\u0004\bA\u0010\u0013R\u001b\u0010B\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u0011\u001a\u0004\bC\u0010\u0013R\u001b\u0010D\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u001d\u001a\u0004\bE\u0010\u001fR\u001b\u0010F\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010\u0011\u001a\u0004\bG\u0010\u0013R\u001b\u0010H\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u0011\u001a\u0004\bI\u0010\u0013R\u001b\u0010J\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010\u0011\u001a\u0004\bK\u0010\u0013¨\u0006L"}, d2 = {"Lcom/discord/analytics/generated/events/TrackVideoStreamStarted;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackNetworkInformationReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "soundshareSession", "Ljava/lang/CharSequence;", "getSoundshareSession", "()Ljava/lang/CharSequence;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "shareApplicationExecutable", "getShareApplicationExecutable", "shareGameName", "getShareGameName", "", "videoInputFrameRate", "Ljava/lang/Long;", "getVideoInputFrameRate", "()Ljava/lang/Long;", "videoLayout", "getVideoLayout", "videoInputResolution", "getVideoInputResolution", "context", "getContext", "senderUserId", "getSenderUserId", "streamRegion", "getStreamRegion", "shareGameId", "getShareGameId", "channelId", "getChannelId", "shareApplicationName", "getShareApplicationName", "guildId", "getGuildId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "Lcom/discord/analytics/generated/traits/TrackNetworkInformation;", "trackNetworkInformation", "Lcom/discord/analytics/generated/traits/TrackNetworkInformation;", "getTrackNetworkInformation", "()Lcom/discord/analytics/generated/traits/TrackNetworkInformation;", "setTrackNetworkInformation", "(Lcom/discord/analytics/generated/traits/TrackNetworkInformation;)V", "participantType", "getParticipantType", "mediaSessionId", "getMediaSessionId", "shareApplicationId", "getShareApplicationId", "rtcConnectionId", "getRtcConnectionId", "guildRegion", "getGuildRegion", "parentMediaSessionId", "getParentMediaSessionId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackVideoStreamStarted implements AnalyticsSchema, TrackBase2, TrackNetworkInformation2 {
    private TrackBase trackBase;
    private TrackNetworkInformation trackNetworkInformation;
    private final Long guildId = null;
    private final Long channelId = null;
    private final CharSequence rtcConnectionId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence parentMediaSessionId = null;
    private final Long senderUserId = null;
    private final CharSequence context = null;
    private final CharSequence participantType = null;
    private final CharSequence shareApplicationName = null;
    private final Long shareApplicationId = null;
    private final CharSequence shareApplicationExecutable = null;
    private final CharSequence streamRegion = null;
    private final CharSequence guildRegion = null;
    private final CharSequence videoLayout = null;
    private final Long videoInputResolution = null;
    private final Long videoInputFrameRate = null;
    private final CharSequence soundshareSession = null;
    private final CharSequence shareGameName = null;
    private final Long shareGameId = null;
    private final transient String analyticsSchemaTypeName = "video_stream_started";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoStreamStarted)) {
            return false;
        }
        TrackVideoStreamStarted trackVideoStreamStarted = (TrackVideoStreamStarted) other;
        return Intrinsics3.areEqual(this.guildId, trackVideoStreamStarted.guildId) && Intrinsics3.areEqual(this.channelId, trackVideoStreamStarted.channelId) && Intrinsics3.areEqual(this.rtcConnectionId, trackVideoStreamStarted.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, trackVideoStreamStarted.mediaSessionId) && Intrinsics3.areEqual(this.parentMediaSessionId, trackVideoStreamStarted.parentMediaSessionId) && Intrinsics3.areEqual(this.senderUserId, trackVideoStreamStarted.senderUserId) && Intrinsics3.areEqual(this.context, trackVideoStreamStarted.context) && Intrinsics3.areEqual(this.participantType, trackVideoStreamStarted.participantType) && Intrinsics3.areEqual(this.shareApplicationName, trackVideoStreamStarted.shareApplicationName) && Intrinsics3.areEqual(this.shareApplicationId, trackVideoStreamStarted.shareApplicationId) && Intrinsics3.areEqual(this.shareApplicationExecutable, trackVideoStreamStarted.shareApplicationExecutable) && Intrinsics3.areEqual(this.streamRegion, trackVideoStreamStarted.streamRegion) && Intrinsics3.areEqual(this.guildRegion, trackVideoStreamStarted.guildRegion) && Intrinsics3.areEqual(this.videoLayout, trackVideoStreamStarted.videoLayout) && Intrinsics3.areEqual(this.videoInputResolution, trackVideoStreamStarted.videoInputResolution) && Intrinsics3.areEqual(this.videoInputFrameRate, trackVideoStreamStarted.videoInputFrameRate) && Intrinsics3.areEqual(this.soundshareSession, trackVideoStreamStarted.soundshareSession) && Intrinsics3.areEqual(this.shareGameName, trackVideoStreamStarted.shareGameName) && Intrinsics3.areEqual(this.shareGameId, trackVideoStreamStarted.shareGameId);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.rtcConnectionId;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.mediaSessionId;
        int iHashCode4 = (iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.parentMediaSessionId;
        int iHashCode5 = (iHashCode4 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l3 = this.senderUserId;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.context;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.participantType;
        int iHashCode8 = (iHashCode7 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.shareApplicationName;
        int iHashCode9 = (iHashCode8 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l4 = this.shareApplicationId;
        int iHashCode10 = (iHashCode9 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.shareApplicationExecutable;
        int iHashCode11 = (iHashCode10 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.streamRegion;
        int iHashCode12 = (iHashCode11 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.guildRegion;
        int iHashCode13 = (iHashCode12 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.videoLayout;
        int iHashCode14 = (iHashCode13 + (charSequence10 != null ? charSequence10.hashCode() : 0)) * 31;
        Long l5 = this.videoInputResolution;
        int iHashCode15 = (iHashCode14 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.videoInputFrameRate;
        int iHashCode16 = (iHashCode15 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence11 = this.soundshareSession;
        int iHashCode17 = (iHashCode16 + (charSequence11 != null ? charSequence11.hashCode() : 0)) * 31;
        CharSequence charSequence12 = this.shareGameName;
        int iHashCode18 = (iHashCode17 + (charSequence12 != null ? charSequence12.hashCode() : 0)) * 31;
        Long l7 = this.shareGameId;
        return iHashCode18 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVideoStreamStarted(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", parentMediaSessionId=");
        sbU.append(this.parentMediaSessionId);
        sbU.append(", senderUserId=");
        sbU.append(this.senderUserId);
        sbU.append(", context=");
        sbU.append(this.context);
        sbU.append(", participantType=");
        sbU.append(this.participantType);
        sbU.append(", shareApplicationName=");
        sbU.append(this.shareApplicationName);
        sbU.append(", shareApplicationId=");
        sbU.append(this.shareApplicationId);
        sbU.append(", shareApplicationExecutable=");
        sbU.append(this.shareApplicationExecutable);
        sbU.append(", streamRegion=");
        sbU.append(this.streamRegion);
        sbU.append(", guildRegion=");
        sbU.append(this.guildRegion);
        sbU.append(", videoLayout=");
        sbU.append(this.videoLayout);
        sbU.append(", videoInputResolution=");
        sbU.append(this.videoInputResolution);
        sbU.append(", videoInputFrameRate=");
        sbU.append(this.videoInputFrameRate);
        sbU.append(", soundshareSession=");
        sbU.append(this.soundshareSession);
        sbU.append(", shareGameName=");
        sbU.append(this.shareGameName);
        sbU.append(", shareGameId=");
        return outline.G(sbU, this.shareGameId, ")");
    }
}
