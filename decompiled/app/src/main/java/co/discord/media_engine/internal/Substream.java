package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0080\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\n\u0010\u001c\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\n\u0010\u001e\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u001f\u001a\u00020\n\u0012\u0006\u0010 \u001a\u00020\n\u0012\n\u0010!\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\"\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010#\u001a\u00020\u0010\u0012\u0006\u0010$\u001a\u00020\u0013\u0012\n\u0010%\u001a\u00060\u0016j\u0002`\u0017\u0012\n\u0010&\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010'\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\bA\u0010BJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\t\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0014\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0005J\u0014\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001a\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0005J\u0014\u0010\u001b\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0005J¤\u0001\u0010(\u001a\u00020\u00002\f\b\u0002\u0010\u001c\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00062\f\b\u0002\u0010\u001e\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\n2\f\b\u0002\u0010!\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\"\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010#\u001a\u00020\u00102\b\b\u0002\u0010$\u001a\u00020\u00132\f\b\u0002\u0010%\u001a\u00060\u0016j\u0002`\u00172\f\b\u0002\u0010&\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010'\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b-\u0010\u0005J\u001a\u0010/\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100R\u0019\u0010\u001f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00101\u001a\u0004\b\u001f\u0010\fR\u0019\u0010\u001d\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00102\u001a\u0004\b3\u0010\bR\u0019\u0010$\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b$\u00104\u001a\u0004\b5\u0010\u0015R\u001d\u0010%\u001a\u00060\u0016j\u0002`\u00178\u0006@\u0006¢\u0006\f\n\u0004\b%\u00106\u001a\u0004\b7\u0010\u0019R\u0019\u0010 \u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b \u00101\u001a\u0004\b \u0010\fR\u001d\u0010!\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b!\u00108\u001a\u0004\b9\u0010\u0005R\u0019\u0010#\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010:\u001a\u0004\b;\u0010\u0012R\u001d\u0010&\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b&\u00108\u001a\u0004\b<\u0010\u0005R\u001d\u0010\u001e\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00108\u001a\u0004\b=\u0010\u0005R\u001d\u0010'\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b'\u00108\u001a\u0004\b>\u0010\u0005R\u001d\u0010\u001c\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00108\u001a\u0004\b?\u0010\u0005R\u001d\u0010\"\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00108\u001a\u0004\b@\u0010\u0005¨\u0006C"}, d2 = {"Lco/discord/media_engine/internal/Substream;", "", "", "Lco/discord/media_engine/internal/I32;", "component1", "()I", "Lco/discord/media_engine/internal/FrameCounts;", "component2", "()Lco/discord/media_engine/internal/FrameCounts;", "component3", "", "component4", "()Z", "component5", "component6", "component7", "Lco/discord/media_engine/internal/RtcpStats;", "component8", "()Lco/discord/media_engine/internal/RtcpStats;", "Lco/discord/media_engine/internal/RtpStats;", "component9", "()Lco/discord/media_engine/internal/RtpStats;", "", "Lco/discord/media_engine/internal/U32;", "component10", "()J", "component11", "component12", "avgDelay", "frameCounts", "height", "isFlexFEC", "isRTX", "maxDelay", "retransmitBitrate", "rtcpStats", "rtpStats", "ssrc", "totalBitrate", "width", "copy", "(ILco/discord/media_engine/internal/FrameCounts;IZZIILco/discord/media_engine/internal/RtcpStats;Lco/discord/media_engine/internal/RtpStats;JII)Lco/discord/media_engine/internal/Substream;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lco/discord/media_engine/internal/FrameCounts;", "getFrameCounts", "Lco/discord/media_engine/internal/RtpStats;", "getRtpStats", "J", "getSsrc", "I", "getMaxDelay", "Lco/discord/media_engine/internal/RtcpStats;", "getRtcpStats", "getTotalBitrate", "getHeight", "getWidth", "getAvgDelay", "getRetransmitBitrate", "<init>", "(ILco/discord/media_engine/internal/FrameCounts;IZZIILco/discord/media_engine/internal/RtcpStats;Lco/discord/media_engine/internal/RtpStats;JII)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Substream {
    private final int avgDelay;
    private final FrameCounts frameCounts;
    private final int height;
    private final boolean isFlexFEC;
    private final boolean isRTX;
    private final int maxDelay;
    private final int retransmitBitrate;
    private final RtcpStats rtcpStats;
    private final RtpStats rtpStats;
    private final long ssrc;
    private final int totalBitrate;
    private final int width;

    public Substream(int i, FrameCounts frameCounts, int i2, boolean z2, boolean z3, int i3, int i4, RtcpStats rtcpStats, RtpStats rtpStats, long j, int i5, int i6) {
        Intrinsics3.checkNotNullParameter(frameCounts, "frameCounts");
        Intrinsics3.checkNotNullParameter(rtcpStats, "rtcpStats");
        Intrinsics3.checkNotNullParameter(rtpStats, "rtpStats");
        this.avgDelay = i;
        this.frameCounts = frameCounts;
        this.height = i2;
        this.isFlexFEC = z2;
        this.isRTX = z3;
        this.maxDelay = i3;
        this.retransmitBitrate = i4;
        this.rtcpStats = rtcpStats;
        this.rtpStats = rtpStats;
        this.ssrc = j;
        this.totalBitrate = i5;
        this.width = i6;
    }

    public static /* synthetic */ Substream copy$default(Substream substream, int i, FrameCounts frameCounts, int i2, boolean z2, boolean z3, int i3, int i4, RtcpStats rtcpStats, RtpStats rtpStats, long j, int i5, int i6, int i7, Object obj) {
        return substream.copy((i7 & 1) != 0 ? substream.avgDelay : i, (i7 & 2) != 0 ? substream.frameCounts : frameCounts, (i7 & 4) != 0 ? substream.height : i2, (i7 & 8) != 0 ? substream.isFlexFEC : z2, (i7 & 16) != 0 ? substream.isRTX : z3, (i7 & 32) != 0 ? substream.maxDelay : i3, (i7 & 64) != 0 ? substream.retransmitBitrate : i4, (i7 & 128) != 0 ? substream.rtcpStats : rtcpStats, (i7 & 256) != 0 ? substream.rtpStats : rtpStats, (i7 & 512) != 0 ? substream.ssrc : j, (i7 & 1024) != 0 ? substream.totalBitrate : i5, (i7 & 2048) != 0 ? substream.width : i6);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAvgDelay() {
        return this.avgDelay;
    }

    /* renamed from: component10, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* renamed from: component11, reason: from getter */
    public final int getTotalBitrate() {
        return this.totalBitrate;
    }

    /* renamed from: component12, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component2, reason: from getter */
    public final FrameCounts getFrameCounts() {
        return this.frameCounts;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsFlexFEC() {
        return this.isFlexFEC;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsRTX() {
        return this.isRTX;
    }

    /* renamed from: component6, reason: from getter */
    public final int getMaxDelay() {
        return this.maxDelay;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRetransmitBitrate() {
        return this.retransmitBitrate;
    }

    /* renamed from: component8, reason: from getter */
    public final RtcpStats getRtcpStats() {
        return this.rtcpStats;
    }

    /* renamed from: component9, reason: from getter */
    public final RtpStats getRtpStats() {
        return this.rtpStats;
    }

    public final Substream copy(int avgDelay, FrameCounts frameCounts, int height, boolean isFlexFEC, boolean isRTX, int maxDelay, int retransmitBitrate, RtcpStats rtcpStats, RtpStats rtpStats, long ssrc, int totalBitrate, int width) {
        Intrinsics3.checkNotNullParameter(frameCounts, "frameCounts");
        Intrinsics3.checkNotNullParameter(rtcpStats, "rtcpStats");
        Intrinsics3.checkNotNullParameter(rtpStats, "rtpStats");
        return new Substream(avgDelay, frameCounts, height, isFlexFEC, isRTX, maxDelay, retransmitBitrate, rtcpStats, rtpStats, ssrc, totalBitrate, width);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Substream)) {
            return false;
        }
        Substream substream = (Substream) other;
        return this.avgDelay == substream.avgDelay && Intrinsics3.areEqual(this.frameCounts, substream.frameCounts) && this.height == substream.height && this.isFlexFEC == substream.isFlexFEC && this.isRTX == substream.isRTX && this.maxDelay == substream.maxDelay && this.retransmitBitrate == substream.retransmitBitrate && Intrinsics3.areEqual(this.rtcpStats, substream.rtcpStats) && Intrinsics3.areEqual(this.rtpStats, substream.rtpStats) && this.ssrc == substream.ssrc && this.totalBitrate == substream.totalBitrate && this.width == substream.width;
    }

    public final int getAvgDelay() {
        return this.avgDelay;
    }

    public final FrameCounts getFrameCounts() {
        return this.frameCounts;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getMaxDelay() {
        return this.maxDelay;
    }

    public final int getRetransmitBitrate() {
        return this.retransmitBitrate;
    }

    public final RtcpStats getRtcpStats() {
        return this.rtcpStats;
    }

    public final RtpStats getRtpStats() {
        return this.rtpStats;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final int getTotalBitrate() {
        return this.totalBitrate;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.avgDelay * 31;
        FrameCounts frameCounts = this.frameCounts;
        int iHashCode = (((i + (frameCounts != null ? frameCounts.hashCode() : 0)) * 31) + this.height) * 31;
        boolean z2 = this.isFlexFEC;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode + i2) * 31;
        boolean z3 = this.isRTX;
        int i4 = (((((i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.maxDelay) * 31) + this.retransmitBitrate) * 31;
        RtcpStats rtcpStats = this.rtcpStats;
        int iHashCode2 = (i4 + (rtcpStats != null ? rtcpStats.hashCode() : 0)) * 31;
        RtpStats rtpStats = this.rtpStats;
        return ((((b.a(this.ssrc) + ((iHashCode2 + (rtpStats != null ? rtpStats.hashCode() : 0)) * 31)) * 31) + this.totalBitrate) * 31) + this.width;
    }

    public final boolean isFlexFEC() {
        return this.isFlexFEC;
    }

    public final boolean isRTX() {
        return this.isRTX;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Substream(avgDelay=");
        sbU.append(this.avgDelay);
        sbU.append(", frameCounts=");
        sbU.append(this.frameCounts);
        sbU.append(", height=");
        sbU.append(this.height);
        sbU.append(", isFlexFEC=");
        sbU.append(this.isFlexFEC);
        sbU.append(", isRTX=");
        sbU.append(this.isRTX);
        sbU.append(", maxDelay=");
        sbU.append(this.maxDelay);
        sbU.append(", retransmitBitrate=");
        sbU.append(this.retransmitBitrate);
        sbU.append(", rtcpStats=");
        sbU.append(this.rtcpStats);
        sbU.append(", rtpStats=");
        sbU.append(this.rtpStats);
        sbU.append(", ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", totalBitrate=");
        sbU.append(this.totalBitrate);
        sbU.append(", width=");
        return outline.B(sbU, this.width, ")");
    }
}
