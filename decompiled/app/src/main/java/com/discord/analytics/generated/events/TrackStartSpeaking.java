package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackStartSpeaking.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u001b\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u001bR\u001b\u0010'\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001b\u00102\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\"\u001a\u0004\b3\u0010$R\u001b\u00104\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010\"\u001a\u0004\b5\u0010$R\u001b\u00106\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\"\u001a\u0004\b7\u0010$R\u001b\u00108\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u0019\u001a\u0004\b9\u0010\u001bR\u001b\u0010:\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\"\u001a\u0004\b;\u0010$R\u001b\u0010<\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0019\u001a\u0004\b=\u0010\u001bR\u001b\u0010>\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u0019\u001a\u0004\b?\u0010\u001bR\u001b\u0010@\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\"\u001a\u0004\bA\u0010$R\u001c\u0010B\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010\u0007R$\u0010F\u001a\u0004\u0018\u00010E8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001b\u0010L\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010\u0019\u001a\u0004\bM\u0010\u001b¨\u0006N"}, d2 = {"Lcom/discord/analytics/generated/events/TrackStartSpeaking;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "", "voiceStateCount", "Ljava/lang/Long;", "getVoiceStateCount", "()Ljava/lang/Long;", "packetsReceivedLost", "getPacketsReceivedLost", "server", "getServer", "", "rtcConnectionId", "Ljava/lang/CharSequence;", "getRtcConnectionId", "()Ljava/lang/CharSequence;", "gameId", "getGameId", "priority", "Ljava/lang/Boolean;", "getPriority", "()Ljava/lang/Boolean;", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "gameName", "getGameName", "gamePlatform", "getGamePlatform", "gameExeName", "getGameExeName", "channel", "getChannel", "mediaSessionId", "getMediaSessionId", "packetsReceived", "getPacketsReceived", "packetsSent", "getPacketsSent", "mode", "getMode", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "packetsSentLost", "getPacketsSentLost", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackStartSpeaking implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long channel = null;
    private final CharSequence mode = null;
    private final Boolean priority = null;
    private final Long server = null;
    private final CharSequence gamePlatform = null;
    private final CharSequence gameName = null;
    private final CharSequence gameExeName = null;
    private final Long gameId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence rtcConnectionId = null;
    private final Long packetsSent = null;
    private final Long packetsSentLost = null;
    private final Long packetsReceived = null;
    private final Long packetsReceivedLost = null;
    private final Long voiceStateCount = null;
    private final transient String analyticsSchemaTypeName = "start_speaking";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStartSpeaking)) {
            return false;
        }
        TrackStartSpeaking trackStartSpeaking = (TrackStartSpeaking) other;
        return Intrinsics3.areEqual(this.channel, trackStartSpeaking.channel) && Intrinsics3.areEqual(this.mode, trackStartSpeaking.mode) && Intrinsics3.areEqual(this.priority, trackStartSpeaking.priority) && Intrinsics3.areEqual(this.server, trackStartSpeaking.server) && Intrinsics3.areEqual(this.gamePlatform, trackStartSpeaking.gamePlatform) && Intrinsics3.areEqual(this.gameName, trackStartSpeaking.gameName) && Intrinsics3.areEqual(this.gameExeName, trackStartSpeaking.gameExeName) && Intrinsics3.areEqual(this.gameId, trackStartSpeaking.gameId) && Intrinsics3.areEqual(this.mediaSessionId, trackStartSpeaking.mediaSessionId) && Intrinsics3.areEqual(this.rtcConnectionId, trackStartSpeaking.rtcConnectionId) && Intrinsics3.areEqual(this.packetsSent, trackStartSpeaking.packetsSent) && Intrinsics3.areEqual(this.packetsSentLost, trackStartSpeaking.packetsSentLost) && Intrinsics3.areEqual(this.packetsReceived, trackStartSpeaking.packetsReceived) && Intrinsics3.areEqual(this.packetsReceivedLost, trackStartSpeaking.packetsReceivedLost) && Intrinsics3.areEqual(this.voiceStateCount, trackStartSpeaking.voiceStateCount);
    }

    public int hashCode() {
        Long l = this.channel;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.mode;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.priority;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.server;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.gamePlatform;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gameName;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.gameExeName;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.gameId;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.mediaSessionId;
        int iHashCode9 = (iHashCode8 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.rtcConnectionId;
        int iHashCode10 = (iHashCode9 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l4 = this.packetsSent;
        int iHashCode11 = (iHashCode10 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.packetsSentLost;
        int iHashCode12 = (iHashCode11 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.packetsReceived;
        int iHashCode13 = (iHashCode12 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.packetsReceivedLost;
        int iHashCode14 = (iHashCode13 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.voiceStateCount;
        return iHashCode14 + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStartSpeaking(channel=");
        sbU.append(this.channel);
        sbU.append(", mode=");
        sbU.append(this.mode);
        sbU.append(", priority=");
        sbU.append(this.priority);
        sbU.append(", server=");
        sbU.append(this.server);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gameExeName=");
        sbU.append(this.gameExeName);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", packetsSent=");
        sbU.append(this.packetsSent);
        sbU.append(", packetsSentLost=");
        sbU.append(this.packetsSentLost);
        sbU.append(", packetsReceived=");
        sbU.append(this.packetsReceived);
        sbU.append(", packetsReceivedLost=");
        sbU.append(this.packetsReceivedLost);
        sbU.append(", voiceStateCount=");
        return outline.G(sbU, this.voiceStateCount, ")");
    }
}
