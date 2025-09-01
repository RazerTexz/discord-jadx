package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackStartListening.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014R$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001b\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010+\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*R\u001b\u0010-\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u001a\u001a\u0004\b.\u0010\u001cR\u001c\u0010/\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0007R\u001b\u00102\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0012\u001a\u0004\b3\u0010\u0014R\u001b\u00104\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010(\u001a\u0004\b5\u0010*R\u001b\u00106\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010(\u001a\u0004\b7\u0010*R$\u00109\u001a\u0004\u0018\u0001088\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001b\u0010?\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010\u0012\u001a\u0004\b@\u0010\u0014R$\u0010B\u001a\u0004\u0018\u00010A8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006H"}, d2 = {"Lcom/discord/analytics/generated/events/TrackStartListening;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "Lcom/discord/analytics/generated/traits/TrackGuildReceiver;", "Lcom/discord/analytics/generated/traits/TrackChannelReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "mediaSessionId", "Ljava/lang/CharSequence;", "getMediaSessionId", "()Ljava/lang/CharSequence;", "gamePlatform", "getGamePlatform", "rtcConnectionId", "getRtcConnectionId", "anyonePriority", "Ljava/lang/Boolean;", "getAnyonePriority", "()Ljava/lang/Boolean;", "mode", "getMode", "Lcom/discord/analytics/generated/traits/TrackChannel;", "trackChannel", "Lcom/discord/analytics/generated/traits/TrackChannel;", "getTrackChannel", "()Lcom/discord/analytics/generated/traits/TrackChannel;", "setTrackChannel", "(Lcom/discord/analytics/generated/traits/TrackChannel;)V", "", "server", "Ljava/lang/Long;", "getServer", "()Ljava/lang/Long;", "channel", "getChannel", ModelAuditLogEntry.CHANGE_KEY_MUTE, "getMute", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "gameName", "getGameName", "gameId", "getGameId", "voiceStateCount", "getVoiceStateCount", "Lcom/discord/analytics/generated/traits/TrackGuild;", "trackGuild", "Lcom/discord/analytics/generated/traits/TrackGuild;", "a", "()Lcom/discord/analytics/generated/traits/TrackGuild;", "c", "(Lcom/discord/analytics/generated/traits/TrackGuild;)V", "gameExeName", "getGameExeName", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackStartListening implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long channel = null;
    private final CharSequence mode = null;
    private final Boolean mute = null;
    private final Boolean anyonePriority = null;
    private final Long server = null;
    private final CharSequence gamePlatform = null;
    private final CharSequence gameName = null;
    private final CharSequence gameExeName = null;
    private final Long gameId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence rtcConnectionId = null;
    private final Long voiceStateCount = null;
    private final transient String analyticsSchemaTypeName = "start_listening";

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
        if (!(other instanceof TrackStartListening)) {
            return false;
        }
        TrackStartListening trackStartListening = (TrackStartListening) other;
        return Intrinsics3.areEqual(this.channel, trackStartListening.channel) && Intrinsics3.areEqual(this.mode, trackStartListening.mode) && Intrinsics3.areEqual(this.mute, trackStartListening.mute) && Intrinsics3.areEqual(this.anyonePriority, trackStartListening.anyonePriority) && Intrinsics3.areEqual(this.server, trackStartListening.server) && Intrinsics3.areEqual(this.gamePlatform, trackStartListening.gamePlatform) && Intrinsics3.areEqual(this.gameName, trackStartListening.gameName) && Intrinsics3.areEqual(this.gameExeName, trackStartListening.gameExeName) && Intrinsics3.areEqual(this.gameId, trackStartListening.gameId) && Intrinsics3.areEqual(this.mediaSessionId, trackStartListening.mediaSessionId) && Intrinsics3.areEqual(this.rtcConnectionId, trackStartListening.rtcConnectionId) && Intrinsics3.areEqual(this.voiceStateCount, trackStartListening.voiceStateCount);
    }

    public int hashCode() {
        Long l = this.channel;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.mode;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.mute;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.anyonePriority;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l2 = this.server;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.gamePlatform;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gameName;
        int iHashCode7 = (iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.gameExeName;
        int iHashCode8 = (iHashCode7 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.gameId;
        int iHashCode9 = (iHashCode8 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.mediaSessionId;
        int iHashCode10 = (iHashCode9 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.rtcConnectionId;
        int iHashCode11 = (iHashCode10 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l4 = this.voiceStateCount;
        return iHashCode11 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStartListening(channel=");
        sbU.append(this.channel);
        sbU.append(", mode=");
        sbU.append(this.mode);
        sbU.append(", mute=");
        sbU.append(this.mute);
        sbU.append(", anyonePriority=");
        sbU.append(this.anyonePriority);
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
        sbU.append(", voiceStateCount=");
        return outline.G(sbU, this.voiceStateCount, ")");
    }
}
