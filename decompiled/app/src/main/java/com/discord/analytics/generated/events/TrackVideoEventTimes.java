package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackVideoEventTimes.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012R\u001b\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012R\u001b\u0010$\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\u0012R\u0019\u0010'\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010+\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b,\u0010\u0012R\u001b\u0010-\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010\u0012R\u001b\u0010/\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0012R\u001c\u00101\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u0005¨\u00064"}, d2 = {"Lcom/discord/analytics/generated/events/TrackVideoEventTimes;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "connectionStreamFirstFrame", "Ljava/lang/Long;", "getConnectionStreamFirstFrame", "()Ljava/lang/Long;", "streamConnection", "getStreamConnection", "gatewayHello", "getGatewayHello", "voiceConnection", "getVoiceConnection", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "streamRequested", "getStreamRequested", "connectionVideoFirstFrame", "getConnectionVideoFirstFrame", "videoFirstFrame", "getVideoFirstFrame", "", "eventTimeName", "Ljava/lang/CharSequence;", "getEventTimeName", "()Ljava/lang/CharSequence;", "mediaEngineConnection", "getMediaEngineConnection", "streamFirstFrame", "getStreamFirstFrame", "gatewayConnection", "getGatewayConnection", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackVideoEventTimes implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName;
    private final Long connectionStreamFirstFrame;
    private final Long connectionVideoFirstFrame;
    private final CharSequence eventTimeName;
    private final Long gatewayConnection;
    private final Long gatewayHello;
    private final Long mediaEngineConnection;
    private final Long streamConnection;
    private final Long streamFirstFrame;
    private final Long streamRequested;
    private TrackBase trackBase;
    private final Long videoFirstFrame;
    private final Long voiceConnection;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoEventTimes)) {
            return false;
        }
        TrackVideoEventTimes trackVideoEventTimes = (TrackVideoEventTimes) other;
        return Intrinsics3.areEqual(this.gatewayConnection, trackVideoEventTimes.gatewayConnection) && Intrinsics3.areEqual(this.gatewayHello, trackVideoEventTimes.gatewayHello) && Intrinsics3.areEqual(this.voiceConnection, trackVideoEventTimes.voiceConnection) && Intrinsics3.areEqual(this.streamRequested, trackVideoEventTimes.streamRequested) && Intrinsics3.areEqual(this.streamConnection, trackVideoEventTimes.streamConnection) && Intrinsics3.areEqual(this.streamFirstFrame, trackVideoEventTimes.streamFirstFrame) && Intrinsics3.areEqual(this.videoFirstFrame, trackVideoEventTimes.videoFirstFrame) && Intrinsics3.areEqual(this.mediaEngineConnection, trackVideoEventTimes.mediaEngineConnection) && Intrinsics3.areEqual(this.connectionVideoFirstFrame, trackVideoEventTimes.connectionVideoFirstFrame) && Intrinsics3.areEqual(this.connectionStreamFirstFrame, trackVideoEventTimes.connectionStreamFirstFrame) && Intrinsics3.areEqual(this.eventTimeName, trackVideoEventTimes.eventTimeName);
    }

    public int hashCode() {
        Long l = this.gatewayConnection;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.gatewayHello;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.voiceConnection;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.streamRequested;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.streamConnection;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.streamFirstFrame;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.videoFirstFrame;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.mediaEngineConnection;
        int iHashCode8 = (iHashCode7 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.connectionVideoFirstFrame;
        int iHashCode9 = (iHashCode8 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.connectionStreamFirstFrame;
        int iHashCode10 = (iHashCode9 + (l10 != null ? l10.hashCode() : 0)) * 31;
        CharSequence charSequence = this.eventTimeName;
        return iHashCode10 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVideoEventTimes(gatewayConnection=");
        sbU.append(this.gatewayConnection);
        sbU.append(", gatewayHello=");
        sbU.append(this.gatewayHello);
        sbU.append(", voiceConnection=");
        sbU.append(this.voiceConnection);
        sbU.append(", streamRequested=");
        sbU.append(this.streamRequested);
        sbU.append(", streamConnection=");
        sbU.append(this.streamConnection);
        sbU.append(", streamFirstFrame=");
        sbU.append(this.streamFirstFrame);
        sbU.append(", videoFirstFrame=");
        sbU.append(this.videoFirstFrame);
        sbU.append(", mediaEngineConnection=");
        sbU.append(this.mediaEngineConnection);
        sbU.append(", connectionVideoFirstFrame=");
        sbU.append(this.connectionVideoFirstFrame);
        sbU.append(", connectionStreamFirstFrame=");
        sbU.append(this.connectionStreamFirstFrame);
        sbU.append(", eventTimeName=");
        return outline.E(sbU, this.eventTimeName, ")");
    }
}
