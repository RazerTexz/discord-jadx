package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001BO\u0012\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0011\u001a\u00060\u0007j\u0002`\b\u0012\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u000b\u0012\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u000b\u0012\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u000b¢\u0006\u0004\b'\u0010(J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0014\u0010\t\u001a\u00060\u0007j\u0002`\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\f\u001a\u00060\u0002j\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\u0005J\u0014\u0010\r\u001a\u00060\u0002j\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u0005J\u0014\u0010\u000e\u001a\u00060\u0002j\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0005Jd\u0010\u0015\u001a\u00020\u00002\f\b\u0002\u0010\u000f\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u0011\u001a\u00060\u0007j\u0002`\b2\f\b\u0002\u0010\u0012\u001a\u00060\u0002j\u0002`\u000b2\f\b\u0002\u0010\u0013\u001a\u00060\u0002j\u0002`\u000b2\f\b\u0002\u0010\u0014\u001a\u00060\u0002j\u0002`\u000bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001a\u0010\nJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0012\u001a\u00060\u0002j\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u0005R\u001d\u0010\u0013\u001a\u00060\u0002j\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b!\u0010\u0005R\u001d\u0010\u000f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b\"\u0010\u0005R\u001d\u0010\u0014\u001a\u00060\u0002j\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b#\u0010\u0005R\u001d\u0010\u0011\u001a\u00060\u0007j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\nR\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b&\u0010\u0005¨\u0006)"}, d2 = {"Lco/discord/media_engine/internal/InboundRtpStats;", "", "", "Lco/discord/media_engine/internal/U32;", "component1", "()J", "component2", "", "Lco/discord/media_engine/internal/I32;", "component3", "()I", "Lco/discord/media_engine/internal/U64;", "component4", "component5", "component6", "packets", "jitter", "packetsLost", "headerBytes", "paddingBytes", "payloadBytes", "copy", "(JJIJJJ)Lco/discord/media_engine/internal/InboundRtpStats;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getHeaderBytes", "getPaddingBytes", "getPackets", "getPayloadBytes", "I", "getPacketsLost", "getJitter", "<init>", "(JJIJJJ)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class InboundRtpStats {
    private final long headerBytes;
    private final long jitter;
    private final long packets;
    private final int packetsLost;
    private final long paddingBytes;
    private final long payloadBytes;

    public InboundRtpStats(long j, long j2, int i, long j3, long j4, long j5) {
        this.packets = j;
        this.jitter = j2;
        this.packetsLost = i;
        this.headerBytes = j3;
        this.paddingBytes = j4;
        this.payloadBytes = j5;
    }

    public static /* synthetic */ InboundRtpStats copy$default(InboundRtpStats inboundRtpStats, long j, long j2, int i, long j3, long j4, long j5, int i2, Object obj) {
        return inboundRtpStats.copy((i2 & 1) != 0 ? inboundRtpStats.packets : j, (i2 & 2) != 0 ? inboundRtpStats.jitter : j2, (i2 & 4) != 0 ? inboundRtpStats.packetsLost : i, (i2 & 8) != 0 ? inboundRtpStats.headerBytes : j3, (i2 & 16) != 0 ? inboundRtpStats.paddingBytes : j4, (i2 & 32) != 0 ? inboundRtpStats.payloadBytes : j5);
    }

    /* renamed from: component1, reason: from getter */
    public final long getPackets() {
        return this.packets;
    }

    /* renamed from: component2, reason: from getter */
    public final long getJitter() {
        return this.jitter;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    /* renamed from: component4, reason: from getter */
    public final long getHeaderBytes() {
        return this.headerBytes;
    }

    /* renamed from: component5, reason: from getter */
    public final long getPaddingBytes() {
        return this.paddingBytes;
    }

    /* renamed from: component6, reason: from getter */
    public final long getPayloadBytes() {
        return this.payloadBytes;
    }

    public final InboundRtpStats copy(long packets, long jitter, int packetsLost, long headerBytes, long paddingBytes, long payloadBytes) {
        return new InboundRtpStats(packets, jitter, packetsLost, headerBytes, paddingBytes, payloadBytes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundRtpStats)) {
            return false;
        }
        InboundRtpStats inboundRtpStats = (InboundRtpStats) other;
        return this.packets == inboundRtpStats.packets && this.jitter == inboundRtpStats.jitter && this.packetsLost == inboundRtpStats.packetsLost && this.headerBytes == inboundRtpStats.headerBytes && this.paddingBytes == inboundRtpStats.paddingBytes && this.payloadBytes == inboundRtpStats.payloadBytes;
    }

    public final long getHeaderBytes() {
        return this.headerBytes;
    }

    public final long getJitter() {
        return this.jitter;
    }

    public final long getPackets() {
        return this.packets;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPaddingBytes() {
        return this.paddingBytes;
    }

    public final long getPayloadBytes() {
        return this.payloadBytes;
    }

    public int hashCode() {
        return b.a(this.payloadBytes) + ((b.a(this.paddingBytes) + ((b.a(this.headerBytes) + ((((b.a(this.jitter) + (b.a(this.packets) * 31)) * 31) + this.packetsLost) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundRtpStats(packets=");
        sbU.append(this.packets);
        sbU.append(", jitter=");
        sbU.append(this.jitter);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", headerBytes=");
        sbU.append(this.headerBytes);
        sbU.append(", paddingBytes=");
        sbU.append(this.paddingBytes);
        sbU.append(", payloadBytes=");
        return outline.C(sbU, this.payloadBytes, ")");
    }
}
