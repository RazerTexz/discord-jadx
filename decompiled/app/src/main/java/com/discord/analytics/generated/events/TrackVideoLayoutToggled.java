package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackVideoLayoutToggled.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0005R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R\u001b\u0010%\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001fR\u001b\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012R$\u0010*\u001a\u0004\u0018\u00010)8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00100\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b1\u0010\u0012R\u001b\u00102\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0010\u001a\u0004\b3\u0010\u0012R\u001b\u00104\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\u001d\u001a\u0004\b5\u0010\u001fR\u001b\u00106\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u001d\u001a\u0004\b7\u0010\u001fR\u001b\u00108\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u001d\u001a\u0004\b9\u0010\u001f¨\u0006:"}, d2 = {"Lcom/discord/analytics/generated/events/TrackVideoLayoutToggled;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "voiceStateCount", "Ljava/lang/Long;", "getVoiceStateCount", "()Ljava/lang/Long;", "gameId", "getGameId", "guildId", "getGuildId", "videoEnabled", "Ljava/lang/Boolean;", "getVideoEnabled", "()Ljava/lang/Boolean;", "", "gamePlatform", "Ljava/lang/CharSequence;", "getGamePlatform", "()Ljava/lang/CharSequence;", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "channelType", "getChannelType", "mediaSessionId", "getMediaSessionId", "streamerUserId", "getStreamerUserId", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "channelId", "getChannelId", "videoStreamCount", "getVideoStreamCount", "videoStreamState", "getVideoStreamState", "gameName", "getGameName", "videoLayout", "getVideoLayout", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackVideoLayoutToggled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long voiceStateCount = null;
    private final Long videoStreamCount = null;
    private final Boolean videoEnabled = null;
    private final CharSequence gameName = null;
    private final Long gameId = null;
    private final CharSequence videoLayout = null;
    private final CharSequence gamePlatform = null;
    private final Long streamerUserId = null;
    private final CharSequence videoStreamState = null;
    private final CharSequence mediaSessionId = null;
    private final transient String analyticsSchemaTypeName = "video_layout_toggled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoLayoutToggled)) {
            return false;
        }
        TrackVideoLayoutToggled trackVideoLayoutToggled = (TrackVideoLayoutToggled) other;
        return Intrinsics3.areEqual(this.guildId, trackVideoLayoutToggled.guildId) && Intrinsics3.areEqual(this.channelId, trackVideoLayoutToggled.channelId) && Intrinsics3.areEqual(this.channelType, trackVideoLayoutToggled.channelType) && Intrinsics3.areEqual(this.voiceStateCount, trackVideoLayoutToggled.voiceStateCount) && Intrinsics3.areEqual(this.videoStreamCount, trackVideoLayoutToggled.videoStreamCount) && Intrinsics3.areEqual(this.videoEnabled, trackVideoLayoutToggled.videoEnabled) && Intrinsics3.areEqual(this.gameName, trackVideoLayoutToggled.gameName) && Intrinsics3.areEqual(this.gameId, trackVideoLayoutToggled.gameId) && Intrinsics3.areEqual(this.videoLayout, trackVideoLayoutToggled.videoLayout) && Intrinsics3.areEqual(this.gamePlatform, trackVideoLayoutToggled.gamePlatform) && Intrinsics3.areEqual(this.streamerUserId, trackVideoLayoutToggled.streamerUserId) && Intrinsics3.areEqual(this.videoStreamState, trackVideoLayoutToggled.videoStreamState) && Intrinsics3.areEqual(this.mediaSessionId, trackVideoLayoutToggled.mediaSessionId);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.channelId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelType;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.voiceStateCount;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.videoStreamCount;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.videoEnabled;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence = this.gameName;
        int iHashCode7 = (iHashCode6 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l6 = this.gameId;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.videoLayout;
        int iHashCode9 = (iHashCode8 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gamePlatform;
        int iHashCode10 = (iHashCode9 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l7 = this.streamerUserId;
        int iHashCode11 = (iHashCode10 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.videoStreamState;
        int iHashCode12 = (iHashCode11 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.mediaSessionId;
        return iHashCode12 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVideoLayoutToggled(guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", voiceStateCount=");
        sbU.append(this.voiceStateCount);
        sbU.append(", videoStreamCount=");
        sbU.append(this.videoStreamCount);
        sbU.append(", videoEnabled=");
        sbU.append(this.videoEnabled);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", videoLayout=");
        sbU.append(this.videoLayout);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", streamerUserId=");
        sbU.append(this.streamerUserId);
        sbU.append(", videoStreamState=");
        sbU.append(this.videoStreamState);
        sbU.append(", mediaSessionId=");
        return outline.E(sbU, this.mediaSessionId, ")");
    }
}
