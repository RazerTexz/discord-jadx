package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001B[\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0006\u0012\n\u0010\u0012\u001a\u00060\bj\u0002`\t\u0012\n\u0010\u0013\u001a\u00060\bj\u0002`\t\u0012\n\u0010\u0014\u001a\u00060\bj\u0002`\t\u0012\n\u0010\u0015\u001a\u00060\bj\u0002`\t\u0012\n\u0010\u0016\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b*\u0010+J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\n\u001a\u00060\bj\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\f\u001a\u00060\bj\u0002`\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0014\u0010\r\u001a\u00060\bj\u0002`\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0014\u0010\u000e\u001a\u00060\bj\u0002`\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0014\u0010\u000f\u001a\u00060\bj\u0002`\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJr\u0010\u0017\u001a\u00020\u00002\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u0011\u001a\u00060\u0002j\u0002`\u00062\f\b\u0002\u0010\u0012\u001a\u00060\bj\u0002`\t2\f\b\u0002\u0010\u0013\u001a\u00060\bj\u0002`\t2\f\b\u0002\u0010\u0014\u001a\u00060\bj\u0002`\t2\f\b\u0002\u0010\u0015\u001a\u00060\bj\u0002`\t2\f\b\u0002\u0010\u0016\u001a\u00060\bj\u0002`\tHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0005J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010\u0016\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b\"\u0010\u000bR\u001d\u0010\u0015\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b#\u0010\u000bR\u001d\u0010\u0013\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b$\u0010\u000bR\u001d\u0010\u0011\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010\u0005R\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b'\u0010\u0005R\u001d\u0010\u0014\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b(\u0010\u000bR\u001d\u0010\u0012\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b)\u0010\u000b¨\u0006,"}, d2 = {"Lco/discord/media_engine/internal/RtcpStats;", "", "", "Lco/discord/media_engine/internal/U8;", "component1", "()I", "Lco/discord/media_engine/internal/I32;", "component2", "", "Lco/discord/media_engine/internal/U32;", "component3", "()J", "component4", "component5", "component6", "component7", "fractionLost", "packetsLost", "firPackets", "nackPackets", "nackRequests", "pliPackets", "uniqueNackRequests", "copy", "(IIJJJJJ)Lco/discord/media_engine/internal/RtcpStats;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getUniqueNackRequests", "getPliPackets", "getNackPackets", "I", "getPacketsLost", "getFractionLost", "getNackRequests", "getFirPackets", "<init>", "(IIJJJJJ)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class RtcpStats {
    private final long firPackets;
    private final int fractionLost;
    private final long nackPackets;
    private final long nackRequests;
    private final int packetsLost;
    private final long pliPackets;
    private final long uniqueNackRequests;

    public RtcpStats(int i, int i2, long j, long j2, long j3, long j4, long j5) {
        this.fractionLost = i;
        this.packetsLost = i2;
        this.firPackets = j;
        this.nackPackets = j2;
        this.nackRequests = j3;
        this.pliPackets = j4;
        this.uniqueNackRequests = j5;
    }

    public static /* synthetic */ RtcpStats copy$default(RtcpStats rtcpStats, int i, int i2, long j, long j2, long j3, long j4, long j5, int i3, Object obj) {
        return rtcpStats.copy((i3 & 1) != 0 ? rtcpStats.fractionLost : i, (i3 & 2) != 0 ? rtcpStats.packetsLost : i2, (i3 & 4) != 0 ? rtcpStats.firPackets : j, (i3 & 8) != 0 ? rtcpStats.nackPackets : j2, (i3 & 16) != 0 ? rtcpStats.nackRequests : j3, (i3 & 32) != 0 ? rtcpStats.pliPackets : j4, (i3 & 64) != 0 ? rtcpStats.uniqueNackRequests : j5);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFractionLost() {
        return this.fractionLost;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    /* renamed from: component3, reason: from getter */
    public final long getFirPackets() {
        return this.firPackets;
    }

    /* renamed from: component4, reason: from getter */
    public final long getNackPackets() {
        return this.nackPackets;
    }

    /* renamed from: component5, reason: from getter */
    public final long getNackRequests() {
        return this.nackRequests;
    }

    /* renamed from: component6, reason: from getter */
    public final long getPliPackets() {
        return this.pliPackets;
    }

    /* renamed from: component7, reason: from getter */
    public final long getUniqueNackRequests() {
        return this.uniqueNackRequests;
    }

    public final RtcpStats copy(int fractionLost, int packetsLost, long firPackets, long nackPackets, long nackRequests, long pliPackets, long uniqueNackRequests) {
        return new RtcpStats(fractionLost, packetsLost, firPackets, nackPackets, nackRequests, pliPackets, uniqueNackRequests);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RtcpStats)) {
            return false;
        }
        RtcpStats rtcpStats = (RtcpStats) other;
        return this.fractionLost == rtcpStats.fractionLost && this.packetsLost == rtcpStats.packetsLost && this.firPackets == rtcpStats.firPackets && this.nackPackets == rtcpStats.nackPackets && this.nackRequests == rtcpStats.nackRequests && this.pliPackets == rtcpStats.pliPackets && this.uniqueNackRequests == rtcpStats.uniqueNackRequests;
    }

    public final long getFirPackets() {
        return this.firPackets;
    }

    public final int getFractionLost() {
        return this.fractionLost;
    }

    public final long getNackPackets() {
        return this.nackPackets;
    }

    public final long getNackRequests() {
        return this.nackRequests;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPliPackets() {
        return this.pliPackets;
    }

    public final long getUniqueNackRequests() {
        return this.uniqueNackRequests;
    }

    public int hashCode() {
        return b.a(this.uniqueNackRequests) + ((b.a(this.pliPackets) + ((b.a(this.nackRequests) + ((b.a(this.nackPackets) + ((b.a(this.firPackets) + (((this.fractionLost * 31) + this.packetsLost) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("RtcpStats(fractionLost=");
        sbU.append(this.fractionLost);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", firPackets=");
        sbU.append(this.firPackets);
        sbU.append(", nackPackets=");
        sbU.append(this.nackPackets);
        sbU.append(", nackRequests=");
        sbU.append(this.nackRequests);
        sbU.append(", pliPackets=");
        sbU.append(this.pliPackets);
        sbU.append(", uniqueNackRequests=");
        return outline.C(sbU, this.uniqueNackRequests, ")");
    }
}
