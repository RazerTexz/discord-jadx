package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackNetworkInformation;
import com.discord.analytics.generated.traits.TrackNetworkInformation2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackJoinStageInstance.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u001b\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013R\u001b\u0010(\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010!\u001a\u0004\b)\u0010#R\u001b\u0010*\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b+\u0010\u0013R\u001b\u0010,\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b-\u0010\u0013R\u001b\u0010.\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00102\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0011\u001a\u0004\b3\u0010\u0013R\u001b\u00104\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010!\u001a\u0004\b5\u0010#R\u001b\u00106\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010!\u001a\u0004\b7\u0010#R\u001b\u00108\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u0011\u001a\u0004\b9\u0010\u0013R\u001c\u0010:\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\u0006R$\u0010>\u001a\u0004\u0018\u00010=8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006D"}, d2 = {"Lcom/discord/analytics/generated/events/TrackJoinStageInstance;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackNetworkInformationReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "channelId", "Ljava/lang/Long;", "getChannelId", "()Ljava/lang/Long;", "gameId", "getGameId", "guildId", "getGuildId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "gamePlatform", "Ljava/lang/CharSequence;", "getGamePlatform", "()Ljava/lang/CharSequence;", "customStatusCount", "getCustomStatusCount", "channelType", "getChannelType", "rtcConnectionId", "getRtcConnectionId", "stageInstanceId", "getStageInstanceId", "channelBitrate", "getChannelBitrate", "videoEnabled", "Ljava/lang/Boolean;", "getVideoEnabled", "()Ljava/lang/Boolean;", "videoStreamCount", "getVideoStreamCount", "gameName", "getGameName", "nonce", "getNonce", "voiceStateCount", "getVoiceStateCount", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackNetworkInformation;", "trackNetworkInformation", "Lcom/discord/analytics/generated/traits/TrackNetworkInformation;", "getTrackNetworkInformation", "()Lcom/discord/analytics/generated/traits/TrackNetworkInformation;", "setTrackNetworkInformation", "(Lcom/discord/analytics/generated/traits/TrackNetworkInformation;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackJoinStageInstance implements AnalyticsSchema, TrackBase2, TrackNetworkInformation2 {
    private TrackBase trackBase;
    private TrackNetworkInformation trackNetworkInformation;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long channelBitrate = null;
    private final Long guildId = null;
    private final CharSequence nonce = null;
    private final CharSequence rtcConnectionId = null;
    private final Long voiceStateCount = null;
    private final Long videoStreamCount = null;
    private final Boolean videoEnabled = null;
    private final CharSequence gameName = null;
    private final CharSequence gamePlatform = null;
    private final Long gameId = null;
    private final Long customStatusCount = null;
    private final Long stageInstanceId = null;
    private final transient String analyticsSchemaTypeName = "join_stage_instance";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackJoinStageInstance)) {
            return false;
        }
        TrackJoinStageInstance trackJoinStageInstance = (TrackJoinStageInstance) other;
        return Intrinsics3.areEqual(this.channelId, trackJoinStageInstance.channelId) && Intrinsics3.areEqual(this.channelType, trackJoinStageInstance.channelType) && Intrinsics3.areEqual(this.channelBitrate, trackJoinStageInstance.channelBitrate) && Intrinsics3.areEqual(this.guildId, trackJoinStageInstance.guildId) && Intrinsics3.areEqual(this.nonce, trackJoinStageInstance.nonce) && Intrinsics3.areEqual(this.rtcConnectionId, trackJoinStageInstance.rtcConnectionId) && Intrinsics3.areEqual(this.voiceStateCount, trackJoinStageInstance.voiceStateCount) && Intrinsics3.areEqual(this.videoStreamCount, trackJoinStageInstance.videoStreamCount) && Intrinsics3.areEqual(this.videoEnabled, trackJoinStageInstance.videoEnabled) && Intrinsics3.areEqual(this.gameName, trackJoinStageInstance.gameName) && Intrinsics3.areEqual(this.gamePlatform, trackJoinStageInstance.gamePlatform) && Intrinsics3.areEqual(this.gameId, trackJoinStageInstance.gameId) && Intrinsics3.areEqual(this.customStatusCount, trackJoinStageInstance.customStatusCount) && Intrinsics3.areEqual(this.stageInstanceId, trackJoinStageInstance.stageInstanceId);
    }

    public int hashCode() {
        Long l = this.channelId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelType;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelBitrate;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence = this.nonce;
        int iHashCode5 = (iHashCode4 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.rtcConnectionId;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l5 = this.voiceStateCount;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.videoStreamCount;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode9 = (iHashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gameName;
        int iHashCode10 = (iHashCode9 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.gamePlatform;
        int iHashCode11 = (iHashCode10 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l7 = this.gameId;
        int iHashCode12 = (iHashCode11 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.customStatusCount;
        int iHashCode13 = (iHashCode12 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.stageInstanceId;
        return iHashCode13 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackJoinStageInstance(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", channelBitrate=");
        sbU.append(this.channelBitrate);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", nonce=");
        sbU.append(this.nonce);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", voiceStateCount=");
        sbU.append(this.voiceStateCount);
        sbU.append(", videoStreamCount=");
        sbU.append(this.videoStreamCount);
        sbU.append(", videoEnabled=");
        sbU.append(this.videoEnabled);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", customStatusCount=");
        sbU.append(this.customStatusCount);
        sbU.append(", stageInstanceId=");
        return outline.G(sbU, this.stageInstanceId, ")");
    }
}
