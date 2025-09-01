package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackNetworkInformation;
import com.discord.analytics.generated.traits.TrackNetworkInformation2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackJoinVoiceChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001aR\u001b\u0010&\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001aR\u001b\u0010(\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001b\u0010,\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010\u001aR\u001b\u0010.\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0018\u001a\u0004\b/\u0010\u001aR\u001b\u00100\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010!\u001a\u0004\b1\u0010#R\u001b\u00102\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0018\u001a\u0004\b3\u0010\u001aR\u001c\u00104\u001a\u00020\u00048\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0006R$\u00108\u001a\u0004\u0018\u0001078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010>\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010!\u001a\u0004\b?\u0010#R\u001b\u0010@\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010!\u001a\u0004\bA\u0010#R\u001b\u0010B\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u0018\u001a\u0004\bC\u0010\u001aR\u001b\u0010D\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\u0018\u001a\u0004\bE\u0010\u001a¨\u0006F"}, d2 = {"Lcom/discord/analytics/generated/events/TrackJoinVoiceChannel;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackNetworkInformationReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "", "channelType", "Ljava/lang/Long;", "getChannelType", "()Ljava/lang/Long;", "channelBitrate", "getChannelBitrate", "guildId", "getGuildId", "", "rtcConnectionId", "Ljava/lang/CharSequence;", "getRtcConnectionId", "()Ljava/lang/CharSequence;", "channelId", "getChannelId", "voiceStateCount", "getVoiceStateCount", "videoEnabled", "Ljava/lang/Boolean;", "getVideoEnabled", "()Ljava/lang/Boolean;", "stageInstanceId", "getStageInstanceId", "guildScheduledEventId", "getGuildScheduledEventId", "gameName", "getGameName", "customStatusCount", "getCustomStatusCount", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackNetworkInformation;", "trackNetworkInformation", "Lcom/discord/analytics/generated/traits/TrackNetworkInformation;", "getTrackNetworkInformation", "()Lcom/discord/analytics/generated/traits/TrackNetworkInformation;", "setTrackNetworkInformation", "(Lcom/discord/analytics/generated/traits/TrackNetworkInformation;)V", "gamePlatform", "getGamePlatform", "nonce", "getNonce", "gameId", "getGameId", "videoStreamCount", "getVideoStreamCount", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackJoinVoiceChannel implements AnalyticsSchema, TrackBase2, TrackNetworkInformation2 {
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
    private final Long guildScheduledEventId = null;
    private final transient String analyticsSchemaTypeName = "join_voice_channel";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackJoinVoiceChannel)) {
            return false;
        }
        TrackJoinVoiceChannel trackJoinVoiceChannel = (TrackJoinVoiceChannel) other;
        return Intrinsics3.areEqual(this.channelId, trackJoinVoiceChannel.channelId) && Intrinsics3.areEqual(this.channelType, trackJoinVoiceChannel.channelType) && Intrinsics3.areEqual(this.channelBitrate, trackJoinVoiceChannel.channelBitrate) && Intrinsics3.areEqual(this.guildId, trackJoinVoiceChannel.guildId) && Intrinsics3.areEqual(this.nonce, trackJoinVoiceChannel.nonce) && Intrinsics3.areEqual(this.rtcConnectionId, trackJoinVoiceChannel.rtcConnectionId) && Intrinsics3.areEqual(this.voiceStateCount, trackJoinVoiceChannel.voiceStateCount) && Intrinsics3.areEqual(this.videoStreamCount, trackJoinVoiceChannel.videoStreamCount) && Intrinsics3.areEqual(this.videoEnabled, trackJoinVoiceChannel.videoEnabled) && Intrinsics3.areEqual(this.gameName, trackJoinVoiceChannel.gameName) && Intrinsics3.areEqual(this.gamePlatform, trackJoinVoiceChannel.gamePlatform) && Intrinsics3.areEqual(this.gameId, trackJoinVoiceChannel.gameId) && Intrinsics3.areEqual(this.customStatusCount, trackJoinVoiceChannel.customStatusCount) && Intrinsics3.areEqual(this.stageInstanceId, trackJoinVoiceChannel.stageInstanceId) && Intrinsics3.areEqual(this.guildScheduledEventId, trackJoinVoiceChannel.guildScheduledEventId);
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
        int iHashCode14 = (iHashCode13 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.guildScheduledEventId;
        return iHashCode14 + (l10 != null ? l10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackJoinVoiceChannel(channelId=");
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
        sbU.append(this.stageInstanceId);
        sbU.append(", guildScheduledEventId=");
        return outline.G(sbU, this.guildScheduledEventId, ")");
    }
}
