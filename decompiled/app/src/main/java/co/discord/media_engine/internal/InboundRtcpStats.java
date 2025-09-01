package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\r\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b!\u0010\"J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0014\u0010\t\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005JV\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\r\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005R\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001d\u0010\u0005R\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001e\u0010\u0005R\u001d\u0010\r\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001f\u0010\u0005R\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b \u0010\u0005¨\u0006#"}, d2 = {"Lco/discord/media_engine/internal/InboundRtcpStats;", "", "", "Lco/discord/media_engine/internal/U32;", "component1", "()J", "component2", "component3", "component4", "component5", "firPackets", "nackPackets", "nackRequests", "pliPackets", "uniqueNackRequests", "copy", "(JJJJJ)Lco/discord/media_engine/internal/InboundRtcpStats;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getNackPackets", "getFirPackets", "getUniqueNackRequests", "getPliPackets", "getNackRequests", "<init>", "(JJJJJ)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class InboundRtcpStats {
    private final long firPackets;
    private final long nackPackets;
    private final long nackRequests;
    private final long pliPackets;
    private final long uniqueNackRequests;

    public InboundRtcpStats(long j, long j2, long j3, long j4, long j5) {
        this.firPackets = j;
        this.nackPackets = j2;
        this.nackRequests = j3;
        this.pliPackets = j4;
        this.uniqueNackRequests = j5;
    }

    public static /* synthetic */ InboundRtcpStats copy$default(InboundRtcpStats inboundRtcpStats, long j, long j2, long j3, long j4, long j5, int i, Object obj) {
        return inboundRtcpStats.copy((i & 1) != 0 ? inboundRtcpStats.firPackets : j, (i & 2) != 0 ? inboundRtcpStats.nackPackets : j2, (i & 4) != 0 ? inboundRtcpStats.nackRequests : j3, (i & 8) != 0 ? inboundRtcpStats.pliPackets : j4, (i & 16) != 0 ? inboundRtcpStats.uniqueNackRequests : j5);
    }

    /* renamed from: component1, reason: from getter */
    public final long getFirPackets() {
        return this.firPackets;
    }

    /* renamed from: component2, reason: from getter */
    public final long getNackPackets() {
        return this.nackPackets;
    }

    /* renamed from: component3, reason: from getter */
    public final long getNackRequests() {
        return this.nackRequests;
    }

    /* renamed from: component4, reason: from getter */
    public final long getPliPackets() {
        return this.pliPackets;
    }

    /* renamed from: component5, reason: from getter */
    public final long getUniqueNackRequests() {
        return this.uniqueNackRequests;
    }

    public final InboundRtcpStats copy(long firPackets, long nackPackets, long nackRequests, long pliPackets, long uniqueNackRequests) {
        return new InboundRtcpStats(firPackets, nackPackets, nackRequests, pliPackets, uniqueNackRequests);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundRtcpStats)) {
            return false;
        }
        InboundRtcpStats inboundRtcpStats = (InboundRtcpStats) other;
        return this.firPackets == inboundRtcpStats.firPackets && this.nackPackets == inboundRtcpStats.nackPackets && this.nackRequests == inboundRtcpStats.nackRequests && this.pliPackets == inboundRtcpStats.pliPackets && this.uniqueNackRequests == inboundRtcpStats.uniqueNackRequests;
    }

    public final long getFirPackets() {
        return this.firPackets;
    }

    public final long getNackPackets() {
        return this.nackPackets;
    }

    public final long getNackRequests() {
        return this.nackRequests;
    }

    public final long getPliPackets() {
        return this.pliPackets;
    }

    public final long getUniqueNackRequests() {
        return this.uniqueNackRequests;
    }

    public int hashCode() {
        return b.a(this.uniqueNackRequests) + ((b.a(this.pliPackets) + ((b.a(this.nackRequests) + ((b.a(this.nackPackets) + (b.a(this.firPackets) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundRtcpStats(firPackets=");
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
