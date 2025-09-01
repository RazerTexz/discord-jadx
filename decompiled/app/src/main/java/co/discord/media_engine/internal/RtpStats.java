package co.discord.media_engine.internal;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lco/discord/media_engine/internal/RtpStats;", "", "Lco/discord/media_engine/internal/PacketStats;", "component1", "()Lco/discord/media_engine/internal/PacketStats;", "component2", "component3", "fec", "retransmitted", "transmitted", "copy", "(Lco/discord/media_engine/internal/PacketStats;Lco/discord/media_engine/internal/PacketStats;Lco/discord/media_engine/internal/PacketStats;)Lco/discord/media_engine/internal/RtpStats;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lco/discord/media_engine/internal/PacketStats;", "getRetransmitted", "getFec", "getTransmitted", "<init>", "(Lco/discord/media_engine/internal/PacketStats;Lco/discord/media_engine/internal/PacketStats;Lco/discord/media_engine/internal/PacketStats;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class RtpStats {
    private final PacketStats fec;
    private final PacketStats retransmitted;
    private final PacketStats transmitted;

    public RtpStats(PacketStats packetStats, PacketStats packetStats2, PacketStats packetStats3) {
        Intrinsics3.checkNotNullParameter(packetStats, "fec");
        Intrinsics3.checkNotNullParameter(packetStats2, "retransmitted");
        Intrinsics3.checkNotNullParameter(packetStats3, "transmitted");
        this.fec = packetStats;
        this.retransmitted = packetStats2;
        this.transmitted = packetStats3;
    }

    public static /* synthetic */ RtpStats copy$default(RtpStats rtpStats, PacketStats packetStats, PacketStats packetStats2, PacketStats packetStats3, int i, Object obj) {
        if ((i & 1) != 0) {
            packetStats = rtpStats.fec;
        }
        if ((i & 2) != 0) {
            packetStats2 = rtpStats.retransmitted;
        }
        if ((i & 4) != 0) {
            packetStats3 = rtpStats.transmitted;
        }
        return rtpStats.copy(packetStats, packetStats2, packetStats3);
    }

    /* renamed from: component1, reason: from getter */
    public final PacketStats getFec() {
        return this.fec;
    }

    /* renamed from: component2, reason: from getter */
    public final PacketStats getRetransmitted() {
        return this.retransmitted;
    }

    /* renamed from: component3, reason: from getter */
    public final PacketStats getTransmitted() {
        return this.transmitted;
    }

    public final RtpStats copy(PacketStats fec, PacketStats retransmitted, PacketStats transmitted) {
        Intrinsics3.checkNotNullParameter(fec, "fec");
        Intrinsics3.checkNotNullParameter(retransmitted, "retransmitted");
        Intrinsics3.checkNotNullParameter(transmitted, "transmitted");
        return new RtpStats(fec, retransmitted, transmitted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RtpStats)) {
            return false;
        }
        RtpStats rtpStats = (RtpStats) other;
        return Intrinsics3.areEqual(this.fec, rtpStats.fec) && Intrinsics3.areEqual(this.retransmitted, rtpStats.retransmitted) && Intrinsics3.areEqual(this.transmitted, rtpStats.transmitted);
    }

    public final PacketStats getFec() {
        return this.fec;
    }

    public final PacketStats getRetransmitted() {
        return this.retransmitted;
    }

    public final PacketStats getTransmitted() {
        return this.transmitted;
    }

    public int hashCode() {
        PacketStats packetStats = this.fec;
        int iHashCode = (packetStats != null ? packetStats.hashCode() : 0) * 31;
        PacketStats packetStats2 = this.retransmitted;
        int iHashCode2 = (iHashCode + (packetStats2 != null ? packetStats2.hashCode() : 0)) * 31;
        PacketStats packetStats3 = this.transmitted;
        return iHashCode2 + (packetStats3 != null ? packetStats3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("RtpStats(fec=");
        sbU.append(this.fec);
        sbU.append(", retransmitted=");
        sbU.append(this.retransmitted);
        sbU.append(", transmitted=");
        sbU.append(this.transmitted);
        sbU.append(")");
        return sbU.toString();
    }
}
