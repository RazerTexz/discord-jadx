package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: TrackNetworkingSystemMetrics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012R\u001b\u0010!\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012R\u001b\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012R\u001b\u0010%\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012R\u001b\u0010'\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010\u0012R\u001b\u0010)\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0012R\u001b\u0010+\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0010\u001a\u0004\b,\u0010\u0012R\u001b\u0010-\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010\u0012R\u001b\u0010/\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0012R\u001b\u00101\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010\u0010\u001a\u0004\b2\u0010\u0012R\u001b\u00103\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b4\u0010\u0012R\u001b\u00105\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u0010\u001a\u0004\b6\u0010\u0012R\u001b\u00107\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0010\u001a\u0004\b8\u0010\u0012R\u001b\u00109\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0010\u001a\u0004\b:\u0010\u0012R\u001b\u0010;\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0010\u001a\u0004\b<\u0010\u0012R\u001b\u0010=\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b>\u0010\u0012R$\u0010@\u001a\u0004\u0018\u00010?8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001b\u0010F\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010\u0010\u001a\u0004\bG\u0010\u0012R\u001b\u0010H\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u0010\u001a\u0004\bI\u0010\u0012R\u001b\u0010J\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010\u0010\u001a\u0004\bK\u0010\u0012R\u001c\u0010L\u001a\u00020\u00038\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010\u0005R\u001b\u0010O\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010\u0010\u001a\u0004\bP\u0010\u0012R\u001b\u0010Q\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010\u0010\u001a\u0004\bR\u0010\u0012R\u001b\u0010S\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010\u0010\u001a\u0004\bT\u0010\u0012R\u001b\u0010U\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010\u0010\u001a\u0004\bV\u0010\u0012¨\u0006W"}, d2 = {"Lcom/discord/analytics/generated/events/TrackNetworkingSystemMetrics;", "Lcom/discord/api/science/AnalyticsSchema;", "Lcom/discord/analytics/generated/traits/TrackBaseReceiver;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "dataReceivedPerPollP95", "Ljava/lang/Long;", "getDataReceivedPerPollP95", "()Ljava/lang/Long;", "peerCount", "getPeerCount", "messagesDropped", "getMessagesDropped", "pingRttP95", "getPingRttP95", "routeChanges", "getRouteChanges", "dataSentPerPollP95", "getDataSentPerPollP95", "peerId", "getPeerId", "pollCalls", "getPollCalls", "dataSentBytesAvg", "getDataSentBytesAvg", "dataReceivedPerPollMax", "getDataReceivedPerPollMax", "dataSentBytesP95", "getDataSentBytesP95", "flushCalls", "getFlushCalls", "dataReceivedBytesMax", "getDataReceivedBytesMax", "messagesSent", "getMessagesSent", "dataReceivedBytesAvg", "getDataReceivedBytesAvg", "dataSentPerPollMax", "getDataSentPerPollMax", "dataSentBytesMax", "getDataSentBytesMax", "pingsSent", "getPingsSent", "pingRttStddev", "getPingRttStddev", "applicationId", "getApplicationId", "pongsReceived", "getPongsReceived", "dataReceived", "getDataReceived", "dataSent", "getDataSent", "Lcom/discord/analytics/generated/traits/TrackBase;", "trackBase", "Lcom/discord/analytics/generated/traits/TrackBase;", "getTrackBase", "()Lcom/discord/analytics/generated/traits/TrackBase;", "setTrackBase", "(Lcom/discord/analytics/generated/traits/TrackBase;)V", "messagesReceived", "getMessagesReceived", "pingRttAvg", "getPingRttAvg", "pingRttMax", "getPingRttMax", "analyticsSchemaTypeName", "Ljava/lang/String;", "d", "dataSentPerPollAvg", "getDataSentPerPollAvg", "intervalNs", "getIntervalNs", "dataReceivedBytesP95", "getDataReceivedBytesP95", "dataReceivedPerPollAvg", "getDataReceivedPerPollAvg", "analytics_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrackNetworkingSystemMetrics implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long peerId = null;
    private final Long intervalNs = null;
    private final Long messagesSent = null;
    private final Long messagesDropped = null;
    private final Long messagesReceived = null;
    private final Long dataReceivedBytesAvg = null;
    private final Long dataReceivedBytesMax = null;
    private final Long dataReceivedBytesP95 = null;
    private final Long dataSentBytesAvg = null;
    private final Long dataSentBytesMax = null;
    private final Long dataSentBytesP95 = null;
    private final Long dataSentPerPollAvg = null;
    private final Long dataSentPerPollMax = null;
    private final Long dataSentPerPollP95 = null;
    private final Long dataReceivedPerPollAvg = null;
    private final Long dataReceivedPerPollMax = null;
    private final Long dataReceivedPerPollP95 = null;
    private final Long pingsSent = null;
    private final Long pongsReceived = null;
    private final Long dataSent = null;
    private final Long dataReceived = null;
    private final Long routeChanges = null;
    private final Long pingRttAvg = null;
    private final Long pingRttMax = null;
    private final Long pingRttP95 = null;
    private final Long pingRttStddev = null;
    private final Long pollCalls = null;
    private final Long flushCalls = null;
    private final Long peerCount = null;
    private final transient String analyticsSchemaTypeName = "networking_system_metrics";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkingSystemMetrics)) {
            return false;
        }
        TrackNetworkingSystemMetrics trackNetworkingSystemMetrics = (TrackNetworkingSystemMetrics) other;
        return Intrinsics3.areEqual(this.applicationId, trackNetworkingSystemMetrics.applicationId) && Intrinsics3.areEqual(this.peerId, trackNetworkingSystemMetrics.peerId) && Intrinsics3.areEqual(this.intervalNs, trackNetworkingSystemMetrics.intervalNs) && Intrinsics3.areEqual(this.messagesSent, trackNetworkingSystemMetrics.messagesSent) && Intrinsics3.areEqual(this.messagesDropped, trackNetworkingSystemMetrics.messagesDropped) && Intrinsics3.areEqual(this.messagesReceived, trackNetworkingSystemMetrics.messagesReceived) && Intrinsics3.areEqual(this.dataReceivedBytesAvg, trackNetworkingSystemMetrics.dataReceivedBytesAvg) && Intrinsics3.areEqual(this.dataReceivedBytesMax, trackNetworkingSystemMetrics.dataReceivedBytesMax) && Intrinsics3.areEqual(this.dataReceivedBytesP95, trackNetworkingSystemMetrics.dataReceivedBytesP95) && Intrinsics3.areEqual(this.dataSentBytesAvg, trackNetworkingSystemMetrics.dataSentBytesAvg) && Intrinsics3.areEqual(this.dataSentBytesMax, trackNetworkingSystemMetrics.dataSentBytesMax) && Intrinsics3.areEqual(this.dataSentBytesP95, trackNetworkingSystemMetrics.dataSentBytesP95) && Intrinsics3.areEqual(this.dataSentPerPollAvg, trackNetworkingSystemMetrics.dataSentPerPollAvg) && Intrinsics3.areEqual(this.dataSentPerPollMax, trackNetworkingSystemMetrics.dataSentPerPollMax) && Intrinsics3.areEqual(this.dataSentPerPollP95, trackNetworkingSystemMetrics.dataSentPerPollP95) && Intrinsics3.areEqual(this.dataReceivedPerPollAvg, trackNetworkingSystemMetrics.dataReceivedPerPollAvg) && Intrinsics3.areEqual(this.dataReceivedPerPollMax, trackNetworkingSystemMetrics.dataReceivedPerPollMax) && Intrinsics3.areEqual(this.dataReceivedPerPollP95, trackNetworkingSystemMetrics.dataReceivedPerPollP95) && Intrinsics3.areEqual(this.pingsSent, trackNetworkingSystemMetrics.pingsSent) && Intrinsics3.areEqual(this.pongsReceived, trackNetworkingSystemMetrics.pongsReceived) && Intrinsics3.areEqual(this.dataSent, trackNetworkingSystemMetrics.dataSent) && Intrinsics3.areEqual(this.dataReceived, trackNetworkingSystemMetrics.dataReceived) && Intrinsics3.areEqual(this.routeChanges, trackNetworkingSystemMetrics.routeChanges) && Intrinsics3.areEqual(this.pingRttAvg, trackNetworkingSystemMetrics.pingRttAvg) && Intrinsics3.areEqual(this.pingRttMax, trackNetworkingSystemMetrics.pingRttMax) && Intrinsics3.areEqual(this.pingRttP95, trackNetworkingSystemMetrics.pingRttP95) && Intrinsics3.areEqual(this.pingRttStddev, trackNetworkingSystemMetrics.pingRttStddev) && Intrinsics3.areEqual(this.pollCalls, trackNetworkingSystemMetrics.pollCalls) && Intrinsics3.areEqual(this.flushCalls, trackNetworkingSystemMetrics.flushCalls) && Intrinsics3.areEqual(this.peerCount, trackNetworkingSystemMetrics.peerCount);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.peerId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.intervalNs;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.messagesSent;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.messagesDropped;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.messagesReceived;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.dataReceivedBytesAvg;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.dataReceivedBytesMax;
        int iHashCode8 = (iHashCode7 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.dataReceivedBytesP95;
        int iHashCode9 = (iHashCode8 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.dataSentBytesAvg;
        int iHashCode10 = (iHashCode9 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.dataSentBytesMax;
        int iHashCode11 = (iHashCode10 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.dataSentBytesP95;
        int iHashCode12 = (iHashCode11 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.dataSentPerPollAvg;
        int iHashCode13 = (iHashCode12 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.dataSentPerPollMax;
        int iHashCode14 = (iHashCode13 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.dataSentPerPollP95;
        int iHashCode15 = (iHashCode14 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.dataReceivedPerPollAvg;
        int iHashCode16 = (iHashCode15 + (l16 != null ? l16.hashCode() : 0)) * 31;
        Long l17 = this.dataReceivedPerPollMax;
        int iHashCode17 = (iHashCode16 + (l17 != null ? l17.hashCode() : 0)) * 31;
        Long l18 = this.dataReceivedPerPollP95;
        int iHashCode18 = (iHashCode17 + (l18 != null ? l18.hashCode() : 0)) * 31;
        Long l19 = this.pingsSent;
        int iHashCode19 = (iHashCode18 + (l19 != null ? l19.hashCode() : 0)) * 31;
        Long l20 = this.pongsReceived;
        int iHashCode20 = (iHashCode19 + (l20 != null ? l20.hashCode() : 0)) * 31;
        Long l21 = this.dataSent;
        int iHashCode21 = (iHashCode20 + (l21 != null ? l21.hashCode() : 0)) * 31;
        Long l22 = this.dataReceived;
        int iHashCode22 = (iHashCode21 + (l22 != null ? l22.hashCode() : 0)) * 31;
        Long l23 = this.routeChanges;
        int iHashCode23 = (iHashCode22 + (l23 != null ? l23.hashCode() : 0)) * 31;
        Long l24 = this.pingRttAvg;
        int iHashCode24 = (iHashCode23 + (l24 != null ? l24.hashCode() : 0)) * 31;
        Long l25 = this.pingRttMax;
        int iHashCode25 = (iHashCode24 + (l25 != null ? l25.hashCode() : 0)) * 31;
        Long l26 = this.pingRttP95;
        int iHashCode26 = (iHashCode25 + (l26 != null ? l26.hashCode() : 0)) * 31;
        Long l27 = this.pingRttStddev;
        int iHashCode27 = (iHashCode26 + (l27 != null ? l27.hashCode() : 0)) * 31;
        Long l28 = this.pollCalls;
        int iHashCode28 = (iHashCode27 + (l28 != null ? l28.hashCode() : 0)) * 31;
        Long l29 = this.flushCalls;
        int iHashCode29 = (iHashCode28 + (l29 != null ? l29.hashCode() : 0)) * 31;
        Long l30 = this.peerCount;
        return iHashCode29 + (l30 != null ? l30.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNetworkingSystemMetrics(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", peerId=");
        sbU.append(this.peerId);
        sbU.append(", intervalNs=");
        sbU.append(this.intervalNs);
        sbU.append(", messagesSent=");
        sbU.append(this.messagesSent);
        sbU.append(", messagesDropped=");
        sbU.append(this.messagesDropped);
        sbU.append(", messagesReceived=");
        sbU.append(this.messagesReceived);
        sbU.append(", dataReceivedBytesAvg=");
        sbU.append(this.dataReceivedBytesAvg);
        sbU.append(", dataReceivedBytesMax=");
        sbU.append(this.dataReceivedBytesMax);
        sbU.append(", dataReceivedBytesP95=");
        sbU.append(this.dataReceivedBytesP95);
        sbU.append(", dataSentBytesAvg=");
        sbU.append(this.dataSentBytesAvg);
        sbU.append(", dataSentBytesMax=");
        sbU.append(this.dataSentBytesMax);
        sbU.append(", dataSentBytesP95=");
        sbU.append(this.dataSentBytesP95);
        sbU.append(", dataSentPerPollAvg=");
        sbU.append(this.dataSentPerPollAvg);
        sbU.append(", dataSentPerPollMax=");
        sbU.append(this.dataSentPerPollMax);
        sbU.append(", dataSentPerPollP95=");
        sbU.append(this.dataSentPerPollP95);
        sbU.append(", dataReceivedPerPollAvg=");
        sbU.append(this.dataReceivedPerPollAvg);
        sbU.append(", dataReceivedPerPollMax=");
        sbU.append(this.dataReceivedPerPollMax);
        sbU.append(", dataReceivedPerPollP95=");
        sbU.append(this.dataReceivedPerPollP95);
        sbU.append(", pingsSent=");
        sbU.append(this.pingsSent);
        sbU.append(", pongsReceived=");
        sbU.append(this.pongsReceived);
        sbU.append(", dataSent=");
        sbU.append(this.dataSent);
        sbU.append(", dataReceived=");
        sbU.append(this.dataReceived);
        sbU.append(", routeChanges=");
        sbU.append(this.routeChanges);
        sbU.append(", pingRttAvg=");
        sbU.append(this.pingRttAvg);
        sbU.append(", pingRttMax=");
        sbU.append(this.pingRttMax);
        sbU.append(", pingRttP95=");
        sbU.append(this.pingRttP95);
        sbU.append(", pingRttStddev=");
        sbU.append(this.pingRttStddev);
        sbU.append(", pollCalls=");
        sbU.append(this.pollCalls);
        sbU.append(", flushCalls=");
        sbU.append(this.flushCalls);
        sbU.append(", peerCount=");
        return outline.G(sbU, this.peerCount, ")");
    }
}
