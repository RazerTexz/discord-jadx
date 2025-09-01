package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0006\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\r\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0014\u0010\t\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005JH\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u000b\u001a\u00060\u0002j\u0002`\u00062\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\r\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001c\u0010\u0005R\u001d\u0010\r\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001d\u0010\u0005R\u001d\u0010\u000b\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001e\u0010\u0005¨\u0006!"}, d2 = {"Lco/discord/media_engine/internal/PacketStats;", "", "", "Lco/discord/media_engine/internal/U64;", "component1", "()J", "Lco/discord/media_engine/internal/U32;", "component2", "component3", "component4", "headerBytes", "packets", "paddingBytes", "payloadBytes", "copy", "(JJJJ)Lco/discord/media_engine/internal/PacketStats;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getPaddingBytes", "getHeaderBytes", "getPayloadBytes", "getPackets", "<init>", "(JJJJ)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class PacketStats {
    private final long headerBytes;
    private final long packets;
    private final long paddingBytes;
    private final long payloadBytes;

    public PacketStats(long j, long j2, long j3, long j4) {
        this.headerBytes = j;
        this.packets = j2;
        this.paddingBytes = j3;
        this.payloadBytes = j4;
    }

    public static /* synthetic */ PacketStats copy$default(PacketStats packetStats, long j, long j2, long j3, long j4, int i, Object obj) {
        return packetStats.copy((i & 1) != 0 ? packetStats.headerBytes : j, (i & 2) != 0 ? packetStats.packets : j2, (i & 4) != 0 ? packetStats.paddingBytes : j3, (i & 8) != 0 ? packetStats.payloadBytes : j4);
    }

    /* renamed from: component1, reason: from getter */
    public final long getHeaderBytes() {
        return this.headerBytes;
    }

    /* renamed from: component2, reason: from getter */
    public final long getPackets() {
        return this.packets;
    }

    /* renamed from: component3, reason: from getter */
    public final long getPaddingBytes() {
        return this.paddingBytes;
    }

    /* renamed from: component4, reason: from getter */
    public final long getPayloadBytes() {
        return this.payloadBytes;
    }

    public final PacketStats copy(long headerBytes, long packets, long paddingBytes, long payloadBytes) {
        return new PacketStats(headerBytes, packets, paddingBytes, payloadBytes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketStats)) {
            return false;
        }
        PacketStats packetStats = (PacketStats) other;
        return this.headerBytes == packetStats.headerBytes && this.packets == packetStats.packets && this.paddingBytes == packetStats.paddingBytes && this.payloadBytes == packetStats.payloadBytes;
    }

    public final long getHeaderBytes() {
        return this.headerBytes;
    }

    public final long getPackets() {
        return this.packets;
    }

    public final long getPaddingBytes() {
        return this.paddingBytes;
    }

    public final long getPayloadBytes() {
        return this.payloadBytes;
    }

    public int hashCode() {
        return b.a(this.payloadBytes) + ((b.a(this.paddingBytes) + ((b.a(this.packets) + (b.a(this.headerBytes) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PacketStats(headerBytes=");
        sbU.append(this.headerBytes);
        sbU.append(", packets=");
        sbU.append(this.packets);
        sbU.append(", paddingBytes=");
        sbU.append(this.paddingBytes);
        sbU.append(", payloadBytes=");
        return outline.C(sbU, this.payloadBytes, ")");
    }
}
