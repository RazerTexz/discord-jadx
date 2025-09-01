package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackVoiceConnectionFailure.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012R\u001b\u0010)\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u001fR\u001b\u0010+\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u001d\u001a\u0004\b,\u0010\u001fR\u001b\u0010-\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010\u0012R\u001b\u0010/\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u001d\u001a\u0004\b0\u0010\u001fR\u001b\u00101\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0010\u001a\u0004\b2\u0010\u0012R\u001b\u00103\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b4\u0010\u0012R\u001c\u00105\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0005R\u001b\u00108\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u0010\u001a\u0004\b9\u0010\u0012¨\u0006:"}, d2 = {"Lcom/discord/analytics/generated/events/TrackVoiceConnectionFailure;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "rtcConnectionId", "Ljava/lang/CharSequence;", "getRtcConnectionId", "()Ljava/lang/CharSequence;", "voiceBackendVersion", "getVoiceBackendVersion", "rtcWorkerBackendVersion", "getRtcWorkerBackendVersion", "cloudflareBestRegion", "getCloudflareBestRegion", "hostname", "getHostname", "", "channelId", "Ljava/lang/Long;", "getChannelId", "()Ljava/lang/Long;", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "error", "getError", "guildId", "getGuildId", "connectCount", "getConnectCount", "mediaSessionId", "getMediaSessionId", "port", "getPort", "protocol", "getProtocol", "context", "getContext", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "sessionId", "getSessionId", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackVoiceConnectionFailure implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence error = null;
    private final CharSequence hostname = null;
    private final CharSequence cloudflareBestRegion = null;
    private final Long port = null;
    private final CharSequence protocol = null;
    private final CharSequence sessionId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence context = null;
    private final CharSequence rtcConnectionId = null;
    private final Long channelId = null;
    private final Long guildId = null;
    private final Long connectCount = null;
    private final CharSequence voiceBackendVersion = null;
    private final CharSequence rtcWorkerBackendVersion = null;
    private final transient String analyticsSchemaTypeName = "voice_connection_failure";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVoiceConnectionFailure)) {
            return false;
        }
        TrackVoiceConnectionFailure trackVoiceConnectionFailure = (TrackVoiceConnectionFailure) other;
        return Intrinsics3.areEqual(this.error, trackVoiceConnectionFailure.error) && Intrinsics3.areEqual(this.hostname, trackVoiceConnectionFailure.hostname) && Intrinsics3.areEqual(this.cloudflareBestRegion, trackVoiceConnectionFailure.cloudflareBestRegion) && Intrinsics3.areEqual(this.port, trackVoiceConnectionFailure.port) && Intrinsics3.areEqual(this.protocol, trackVoiceConnectionFailure.protocol) && Intrinsics3.areEqual(this.sessionId, trackVoiceConnectionFailure.sessionId) && Intrinsics3.areEqual(this.mediaSessionId, trackVoiceConnectionFailure.mediaSessionId) && Intrinsics3.areEqual(this.context, trackVoiceConnectionFailure.context) && Intrinsics3.areEqual(this.rtcConnectionId, trackVoiceConnectionFailure.rtcConnectionId) && Intrinsics3.areEqual(this.channelId, trackVoiceConnectionFailure.channelId) && Intrinsics3.areEqual(this.guildId, trackVoiceConnectionFailure.guildId) && Intrinsics3.areEqual(this.connectCount, trackVoiceConnectionFailure.connectCount) && Intrinsics3.areEqual(this.voiceBackendVersion, trackVoiceConnectionFailure.voiceBackendVersion) && Intrinsics3.areEqual(this.rtcWorkerBackendVersion, trackVoiceConnectionFailure.rtcWorkerBackendVersion);
    }

    public int hashCode() {
        CharSequence charSequence = this.error;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.hostname;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.cloudflareBestRegion;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.port;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.protocol;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.sessionId;
        int iHashCode6 = (iHashCode5 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.mediaSessionId;
        int iHashCode7 = (iHashCode6 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.context;
        int iHashCode8 = (iHashCode7 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.rtcConnectionId;
        int iHashCode9 = (iHashCode8 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode10 = (iHashCode9 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode11 = (iHashCode10 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.connectCount;
        int iHashCode12 = (iHashCode11 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.voiceBackendVersion;
        int iHashCode13 = (iHashCode12 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.rtcWorkerBackendVersion;
        return iHashCode13 + (charSequence10 != null ? charSequence10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVoiceConnectionFailure(error=");
        sbU.append(this.error);
        sbU.append(", hostname=");
        sbU.append(this.hostname);
        sbU.append(", cloudflareBestRegion=");
        sbU.append(this.cloudflareBestRegion);
        sbU.append(", port=");
        sbU.append(this.port);
        sbU.append(", protocol=");
        sbU.append(this.protocol);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", context=");
        sbU.append(this.context);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", connectCount=");
        sbU.append(this.connectCount);
        sbU.append(", voiceBackendVersion=");
        sbU.append(this.voiceBackendVersion);
        sbU.append(", rtcWorkerBackendVersion=");
        return outline.E(sbU, this.rtcWorkerBackendVersion, ")");
    }
}
