package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNetworkingPeerMetrics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R\u001b\u0010 \u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012R\u001b\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b#\u0010\u0012R\u001b\u0010$\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\u0012R\u001b\u0010&\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010\u0012R$\u0010)\u001a\u0004\u0018\u00010(8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001b\u0010/\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0012¨\u00061"}, d2 = {"Lcom/discord/analytics/generated/events/TrackNetworkingPeerMetrics;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "pingRttMax", "Ljava/lang/Long;", "getPingRttMax", "()Ljava/lang/Long;", "pongsSent", "getPongsSent", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "applicationId", "getApplicationId", "pingsReceived", "getPingsReceived", "intervalNs", "getIntervalNs", "pingRttP95", "getPingRttP95", "pingRttStddev", "getPingRttStddev", "peerId", "getPeerId", "pongsReceived", "getPongsReceived", "pingRttAvg", "getPingRttAvg", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "pingsSent", "getPingsSent", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkingPeerMetrics implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long peerId = null;
    private final Long intervalNs = null;
    private final Long pingsSent = null;
    private final Long pingsReceived = null;
    private final Long pongsSent = null;
    private final Long pongsReceived = null;
    private final Long pingRttAvg = null;
    private final Long pingRttMax = null;
    private final Long pingRttP95 = null;
    private final Long pingRttStddev = null;
    private final transient String analyticsSchemaTypeName = "networking_peer_metrics";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkingPeerMetrics)) {
            return false;
        }
        TrackNetworkingPeerMetrics trackNetworkingPeerMetrics = (TrackNetworkingPeerMetrics) other;
        return Intrinsics3.areEqual(this.applicationId, trackNetworkingPeerMetrics.applicationId) && Intrinsics3.areEqual(this.peerId, trackNetworkingPeerMetrics.peerId) && Intrinsics3.areEqual(this.intervalNs, trackNetworkingPeerMetrics.intervalNs) && Intrinsics3.areEqual(this.pingsSent, trackNetworkingPeerMetrics.pingsSent) && Intrinsics3.areEqual(this.pingsReceived, trackNetworkingPeerMetrics.pingsReceived) && Intrinsics3.areEqual(this.pongsSent, trackNetworkingPeerMetrics.pongsSent) && Intrinsics3.areEqual(this.pongsReceived, trackNetworkingPeerMetrics.pongsReceived) && Intrinsics3.areEqual(this.pingRttAvg, trackNetworkingPeerMetrics.pingRttAvg) && Intrinsics3.areEqual(this.pingRttMax, trackNetworkingPeerMetrics.pingRttMax) && Intrinsics3.areEqual(this.pingRttP95, trackNetworkingPeerMetrics.pingRttP95) && Intrinsics3.areEqual(this.pingRttStddev, trackNetworkingPeerMetrics.pingRttStddev);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.peerId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.intervalNs;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.pingsSent;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.pingsReceived;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.pongsSent;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.pongsReceived;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.pingRttAvg;
        int iHashCode8 = (iHashCode7 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.pingRttMax;
        int iHashCode9 = (iHashCode8 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.pingRttP95;
        int iHashCode10 = (iHashCode9 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.pingRttStddev;
        return iHashCode10 + (l11 != null ? l11.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkingPeerMetrics(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", peerId=");
        sbU.append(this.peerId);
        sbU.append(", intervalNs=");
        sbU.append(this.intervalNs);
        sbU.append(", pingsSent=");
        sbU.append(this.pingsSent);
        sbU.append(", pingsReceived=");
        sbU.append(this.pingsReceived);
        sbU.append(", pongsSent=");
        sbU.append(this.pongsSent);
        sbU.append(", pongsReceived=");
        sbU.append(this.pongsReceived);
        sbU.append(", pingRttAvg=");
        sbU.append(this.pingRttAvg);
        sbU.append(", pingRttMax=");
        sbU.append(this.pingRttMax);
        sbU.append(", pingRttP95=");
        sbU.append(this.pingRttP95);
        sbU.append(", pingRttStddev=");
        return outline.G(sbU, this.pingRttStddev, ")");
    }
}
