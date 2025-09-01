package co.discord.media_engine;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Statistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\bB\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\n\u0010)\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010*\u001a\u00020\t\u0012\u0006\u0010+\u001a\u00020\u0005\u0012\u0006\u0010,\u001a\u00020\u0005\u0012\u0006\u0010-\u001a\u00020\u000e\u0012\u0006\u0010.\u001a\u00020\u0011\u0012\u0006\u0010/\u001a\u00020\u000e\u0012\u0006\u00100\u001a\u00020\u000e\u0012\u0006\u00101\u001a\u00020\u000e\u0012\u0006\u00102\u001a\u00020\u0002\u0012\u0006\u00103\u001a\u00020\u000e\u0012\u0006\u00104\u001a\u00020\u0019\u0012\u0006\u00105\u001a\u00020\u0005\u0012\u0006\u00106\u001a\u00020\u0005\u0012\u0006\u00107\u001a\u00020\u000e\u0012\u0006\u00108\u001a\u00020\u000e\u0012\u0006\u00109\u001a\u00020\u0005\u0012\u0006\u0010:\u001a\u00020\u0005\u0012\u0006\u0010;\u001a\u00020\u0005\u0012\u0006\u0010<\u001a\u00020\u0005\u0012\u0006\u0010=\u001a\u00020$\u0012\u0006\u0010>\u001a\u00020$¢\u0006\u0004\bd\u0010eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0010J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0010J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\bJ\u0010\u0010\u001e\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0010J\u0010\u0010\u001f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0010J\u0010\u0010 \u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b \u0010\bJ\u0010\u0010!\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b!\u0010\bJ\u0010\u0010\"\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010\bJ\u0010\u0010#\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b#\u0010\bJ\u0010\u0010%\u001a\u00020$HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020$HÆ\u0003¢\u0006\u0004\b'\u0010&Jú\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\u00022\f\b\u0002\u0010)\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010*\u001a\u00020\t2\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u00112\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000e2\b\b\u0002\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u00022\b\b\u0002\u00103\u001a\u00020\u000e2\b\b\u0002\u00104\u001a\u00020\u00192\b\b\u0002\u00105\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u00020\u00052\b\b\u0002\u00107\u001a\u00020\u000e2\b\b\u0002\u00108\u001a\u00020\u000e2\b\b\u0002\u00109\u001a\u00020\u00052\b\b\u0002\u0010:\u001a\u00020\u00052\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00052\b\b\u0002\u0010=\u001a\u00020$2\b\b\u0002\u0010>\u001a\u00020$HÆ\u0001¢\u0006\u0004\b?\u0010@J\u0010\u0010A\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bA\u0010\u0004J\u0010\u0010B\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\bB\u0010\u0010J\u001a\u0010D\u001a\u00020$2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bD\u0010ER\u0019\u00100\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010F\u001a\u0004\bG\u0010\u0010R\u0019\u0010,\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010H\u001a\u0004\bI\u0010\bR\u0019\u00106\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010H\u001a\u0004\bJ\u0010\bR\u0019\u0010:\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010H\u001a\u0004\bK\u0010\bR\u0019\u0010+\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010H\u001a\u0004\bL\u0010\bR\u0019\u00103\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010F\u001a\u0004\bM\u0010\u0010R\u0019\u0010-\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010F\u001a\u0004\bN\u0010\u0010R\u0019\u00105\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010H\u001a\u0004\bO\u0010\bR\u0019\u00109\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010H\u001a\u0004\bP\u0010\bR\u0019\u00107\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010F\u001a\u0004\bQ\u0010\u0010R\u0019\u0010/\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010F\u001a\u0004\bR\u0010\u0010R\u0019\u00102\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010S\u001a\u0004\bT\u0010\u0004R\u0019\u00104\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010U\u001a\u0004\bV\u0010\u001bR\u0019\u00101\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010F\u001a\u0004\bW\u0010\u0010R\u001d\u0010)\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010H\u001a\u0004\bX\u0010\bR\u0019\u0010*\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010Y\u001a\u0004\bZ\u0010\u000bR\u0019\u0010.\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010[\u001a\u0004\b\\\u0010\u0013R\u0019\u00108\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010F\u001a\u0004\b]\u0010\u0010R\u0019\u0010;\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010H\u001a\u0004\b^\u0010\bR\u0019\u0010=\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010_\u001a\u0004\b`\u0010&R\u0019\u0010<\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010H\u001a\u0004\ba\u0010\bR\u0019\u0010(\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010S\u001a\u0004\bb\u0010\u0004R\u0019\u0010>\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010_\u001a\u0004\bc\u0010&¨\u0006f"}, d2 = {"Lco/discord/media_engine/OutboundRtpVideo;", "", "", "component1", "()Ljava/lang/String;", "", "Lco/discord/media_engine/U32;", "component2", "()J", "Lco/discord/media_engine/StatsCodec;", "component3", "()Lco/discord/media_engine/StatsCodec;", "component4", "component5", "", "component6", "()I", "", "component7", "()F", "component8", "component9", "component10", "component11", "component12", "Lco/discord/media_engine/Resolution;", "component13", "()Lco/discord/media_engine/Resolution;", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "", "component22", "()Z", "component23", "type", "ssrc", "codec", "bytesSent", "packetsSent", "packetsLost", "fractionLost", ModelAuditLogEntry.CHANGE_KEY_BITRATE, "bitrateTarget", "encodeUsage", "encoderImplementationName", "averageEncodeTime", "resolution", "framesSent", "framesEncoded", "frameRateInput", "frameRateEncode", "firCount", "nackCount", "pliCount", "qpSum", "bandwidthLimitedResolution", "cpuLimitedResolution", "copy", "(Ljava/lang/String;JLco/discord/media_engine/StatsCodec;JJIFIIILjava/lang/String;ILco/discord/media_engine/Resolution;JJIIJJJJZZ)Lco/discord/media_engine/OutboundRtpVideo;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getBitrateTarget", "J", "getPacketsSent", "getFramesEncoded", "getNackCount", "getBytesSent", "getAverageEncodeTime", "getPacketsLost", "getFramesSent", "getFirCount", "getFrameRateInput", "getBitrate", "Ljava/lang/String;", "getEncoderImplementationName", "Lco/discord/media_engine/Resolution;", "getResolution", "getEncodeUsage", "getSsrc", "Lco/discord/media_engine/StatsCodec;", "getCodec", "F", "getFractionLost", "getFrameRateEncode", "getPliCount", "Z", "getBandwidthLimitedResolution", "getQpSum", "getType", "getCpuLimitedResolution", "<init>", "(Ljava/lang/String;JLco/discord/media_engine/StatsCodec;JJIFIIILjava/lang/String;ILco/discord/media_engine/Resolution;JJIIJJJJZZ)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class OutboundRtpVideo {
    private final int averageEncodeTime;
    private final boolean bandwidthLimitedResolution;
    private final int bitrate;
    private final int bitrateTarget;
    private final long bytesSent;
    private final StatsCodec codec;
    private final boolean cpuLimitedResolution;
    private final int encodeUsage;
    private final String encoderImplementationName;
    private final long firCount;
    private final float fractionLost;
    private final int frameRateEncode;
    private final int frameRateInput;
    private final long framesEncoded;
    private final long framesSent;
    private final long nackCount;
    private final int packetsLost;
    private final long packetsSent;
    private final long pliCount;
    private final long qpSum;
    private final Resolution resolution;
    private final long ssrc;
    private final String type;

    public OutboundRtpVideo(String str, long j, StatsCodec statsCodec, long j2, long j3, int i, float f, int i2, int i3, int i4, String str2, int i5, Resolution resolution, long j4, long j5, int i6, int i7, long j6, long j7, long j8, long j9, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(str, "type");
        Intrinsics3.checkNotNullParameter(statsCodec, "codec");
        Intrinsics3.checkNotNullParameter(str2, "encoderImplementationName");
        Intrinsics3.checkNotNullParameter(resolution, "resolution");
        this.type = str;
        this.ssrc = j;
        this.codec = statsCodec;
        this.bytesSent = j2;
        this.packetsSent = j3;
        this.packetsLost = i;
        this.fractionLost = f;
        this.bitrate = i2;
        this.bitrateTarget = i3;
        this.encodeUsage = i4;
        this.encoderImplementationName = str2;
        this.averageEncodeTime = i5;
        this.resolution = resolution;
        this.framesSent = j4;
        this.framesEncoded = j5;
        this.frameRateInput = i6;
        this.frameRateEncode = i7;
        this.firCount = j6;
        this.nackCount = j7;
        this.pliCount = j8;
        this.qpSum = j9;
        this.bandwidthLimitedResolution = z2;
        this.cpuLimitedResolution = z3;
    }

    public static /* synthetic */ OutboundRtpVideo copy$default(OutboundRtpVideo outboundRtpVideo, String str, long j, StatsCodec statsCodec, long j2, long j3, int i, float f, int i2, int i3, int i4, String str2, int i5, Resolution resolution, long j4, long j5, int i6, int i7, long j6, long j7, long j8, long j9, boolean z2, boolean z3, int i8, Object obj) {
        String str3 = (i8 & 1) != 0 ? outboundRtpVideo.type : str;
        long j10 = (i8 & 2) != 0 ? outboundRtpVideo.ssrc : j;
        StatsCodec statsCodec2 = (i8 & 4) != 0 ? outboundRtpVideo.codec : statsCodec;
        long j11 = (i8 & 8) != 0 ? outboundRtpVideo.bytesSent : j2;
        long j12 = (i8 & 16) != 0 ? outboundRtpVideo.packetsSent : j3;
        int i9 = (i8 & 32) != 0 ? outboundRtpVideo.packetsLost : i;
        float f2 = (i8 & 64) != 0 ? outboundRtpVideo.fractionLost : f;
        int i10 = (i8 & 128) != 0 ? outboundRtpVideo.bitrate : i2;
        int i11 = (i8 & 256) != 0 ? outboundRtpVideo.bitrateTarget : i3;
        int i12 = (i8 & 512) != 0 ? outboundRtpVideo.encodeUsage : i4;
        return outboundRtpVideo.copy(str3, j10, statsCodec2, j11, j12, i9, f2, i10, i11, i12, (i8 & 1024) != 0 ? outboundRtpVideo.encoderImplementationName : str2, (i8 & 2048) != 0 ? outboundRtpVideo.averageEncodeTime : i5, (i8 & 4096) != 0 ? outboundRtpVideo.resolution : resolution, (i8 & 8192) != 0 ? outboundRtpVideo.framesSent : j4, (i8 & 16384) != 0 ? outboundRtpVideo.framesEncoded : j5, (i8 & 32768) != 0 ? outboundRtpVideo.frameRateInput : i6, (65536 & i8) != 0 ? outboundRtpVideo.frameRateEncode : i7, (i8 & 131072) != 0 ? outboundRtpVideo.firCount : j6, (i8 & 262144) != 0 ? outboundRtpVideo.nackCount : j7, (i8 & 524288) != 0 ? outboundRtpVideo.pliCount : j8, (i8 & 1048576) != 0 ? outboundRtpVideo.qpSum : j9, (i8 & 2097152) != 0 ? outboundRtpVideo.bandwidthLimitedResolution : z2, (i8 & 4194304) != 0 ? outboundRtpVideo.cpuLimitedResolution : z3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component10, reason: from getter */
    public final int getEncodeUsage() {
        return this.encodeUsage;
    }

    /* renamed from: component11, reason: from getter */
    public final String getEncoderImplementationName() {
        return this.encoderImplementationName;
    }

    /* renamed from: component12, reason: from getter */
    public final int getAverageEncodeTime() {
        return this.averageEncodeTime;
    }

    /* renamed from: component13, reason: from getter */
    public final Resolution getResolution() {
        return this.resolution;
    }

    /* renamed from: component14, reason: from getter */
    public final long getFramesSent() {
        return this.framesSent;
    }

    /* renamed from: component15, reason: from getter */
    public final long getFramesEncoded() {
        return this.framesEncoded;
    }

    /* renamed from: component16, reason: from getter */
    public final int getFrameRateInput() {
        return this.frameRateInput;
    }

    /* renamed from: component17, reason: from getter */
    public final int getFrameRateEncode() {
        return this.frameRateEncode;
    }

    /* renamed from: component18, reason: from getter */
    public final long getFirCount() {
        return this.firCount;
    }

    /* renamed from: component19, reason: from getter */
    public final long getNackCount() {
        return this.nackCount;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* renamed from: component20, reason: from getter */
    public final long getPliCount() {
        return this.pliCount;
    }

    /* renamed from: component21, reason: from getter */
    public final long getQpSum() {
        return this.qpSum;
    }

    /* renamed from: component22, reason: from getter */
    public final boolean getBandwidthLimitedResolution() {
        return this.bandwidthLimitedResolution;
    }

    /* renamed from: component23, reason: from getter */
    public final boolean getCpuLimitedResolution() {
        return this.cpuLimitedResolution;
    }

    /* renamed from: component3, reason: from getter */
    public final StatsCodec getCodec() {
        return this.codec;
    }

    /* renamed from: component4, reason: from getter */
    public final long getBytesSent() {
        return this.bytesSent;
    }

    /* renamed from: component5, reason: from getter */
    public final long getPacketsSent() {
        return this.packetsSent;
    }

    /* renamed from: component6, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    /* renamed from: component7, reason: from getter */
    public final float getFractionLost() {
        return this.fractionLost;
    }

    /* renamed from: component8, reason: from getter */
    public final int getBitrate() {
        return this.bitrate;
    }

    /* renamed from: component9, reason: from getter */
    public final int getBitrateTarget() {
        return this.bitrateTarget;
    }

    public final OutboundRtpVideo copy(String type, long ssrc, StatsCodec codec, long bytesSent, long packetsSent, int packetsLost, float fractionLost, int bitrate, int bitrateTarget, int encodeUsage, String encoderImplementationName, int averageEncodeTime, Resolution resolution, long framesSent, long framesEncoded, int frameRateInput, int frameRateEncode, long firCount, long nackCount, long pliCount, long qpSum, boolean bandwidthLimitedResolution, boolean cpuLimitedResolution) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(codec, "codec");
        Intrinsics3.checkNotNullParameter(encoderImplementationName, "encoderImplementationName");
        Intrinsics3.checkNotNullParameter(resolution, "resolution");
        return new OutboundRtpVideo(type, ssrc, codec, bytesSent, packetsSent, packetsLost, fractionLost, bitrate, bitrateTarget, encodeUsage, encoderImplementationName, averageEncodeTime, resolution, framesSent, framesEncoded, frameRateInput, frameRateEncode, firCount, nackCount, pliCount, qpSum, bandwidthLimitedResolution, cpuLimitedResolution);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutboundRtpVideo)) {
            return false;
        }
        OutboundRtpVideo outboundRtpVideo = (OutboundRtpVideo) other;
        return Intrinsics3.areEqual(this.type, outboundRtpVideo.type) && this.ssrc == outboundRtpVideo.ssrc && Intrinsics3.areEqual(this.codec, outboundRtpVideo.codec) && this.bytesSent == outboundRtpVideo.bytesSent && this.packetsSent == outboundRtpVideo.packetsSent && this.packetsLost == outboundRtpVideo.packetsLost && Float.compare(this.fractionLost, outboundRtpVideo.fractionLost) == 0 && this.bitrate == outboundRtpVideo.bitrate && this.bitrateTarget == outboundRtpVideo.bitrateTarget && this.encodeUsage == outboundRtpVideo.encodeUsage && Intrinsics3.areEqual(this.encoderImplementationName, outboundRtpVideo.encoderImplementationName) && this.averageEncodeTime == outboundRtpVideo.averageEncodeTime && Intrinsics3.areEqual(this.resolution, outboundRtpVideo.resolution) && this.framesSent == outboundRtpVideo.framesSent && this.framesEncoded == outboundRtpVideo.framesEncoded && this.frameRateInput == outboundRtpVideo.frameRateInput && this.frameRateEncode == outboundRtpVideo.frameRateEncode && this.firCount == outboundRtpVideo.firCount && this.nackCount == outboundRtpVideo.nackCount && this.pliCount == outboundRtpVideo.pliCount && this.qpSum == outboundRtpVideo.qpSum && this.bandwidthLimitedResolution == outboundRtpVideo.bandwidthLimitedResolution && this.cpuLimitedResolution == outboundRtpVideo.cpuLimitedResolution;
    }

    public final int getAverageEncodeTime() {
        return this.averageEncodeTime;
    }

    public final boolean getBandwidthLimitedResolution() {
        return this.bandwidthLimitedResolution;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final int getBitrateTarget() {
        return this.bitrateTarget;
    }

    public final long getBytesSent() {
        return this.bytesSent;
    }

    public final StatsCodec getCodec() {
        return this.codec;
    }

    public final boolean getCpuLimitedResolution() {
        return this.cpuLimitedResolution;
    }

    public final int getEncodeUsage() {
        return this.encodeUsage;
    }

    public final String getEncoderImplementationName() {
        return this.encoderImplementationName;
    }

    public final long getFirCount() {
        return this.firCount;
    }

    public final float getFractionLost() {
        return this.fractionLost;
    }

    public final int getFrameRateEncode() {
        return this.frameRateEncode;
    }

    public final int getFrameRateInput() {
        return this.frameRateInput;
    }

    public final long getFramesEncoded() {
        return this.framesEncoded;
    }

    public final long getFramesSent() {
        return this.framesSent;
    }

    public final long getNackCount() {
        return this.nackCount;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsSent() {
        return this.packetsSent;
    }

    public final long getPliCount() {
        return this.pliCount;
    }

    public final long getQpSum() {
        return this.qpSum;
    }

    public final Resolution getResolution() {
        return this.resolution;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.type;
        int iA = (b.a(this.ssrc) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        StatsCodec statsCodec = this.codec;
        int iFloatToIntBits = (((((((Float.floatToIntBits(this.fractionLost) + ((((b.a(this.packetsSent) + ((b.a(this.bytesSent) + ((iA + (statsCodec != null ? statsCodec.hashCode() : 0)) * 31)) * 31)) * 31) + this.packetsLost) * 31)) * 31) + this.bitrate) * 31) + this.bitrateTarget) * 31) + this.encodeUsage) * 31;
        String str2 = this.encoderImplementationName;
        int iHashCode = (((iFloatToIntBits + (str2 != null ? str2.hashCode() : 0)) * 31) + this.averageEncodeTime) * 31;
        Resolution resolution = this.resolution;
        int iA2 = (b.a(this.qpSum) + ((b.a(this.pliCount) + ((b.a(this.nackCount) + ((b.a(this.firCount) + ((((((b.a(this.framesEncoded) + ((b.a(this.framesSent) + ((iHashCode + (resolution != null ? resolution.hashCode() : 0)) * 31)) * 31)) * 31) + this.frameRateInput) * 31) + this.frameRateEncode) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z2 = this.bandwidthLimitedResolution;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iA2 + i) * 31;
        boolean z3 = this.cpuLimitedResolution;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("OutboundRtpVideo(type=");
        sbU.append(this.type);
        sbU.append(", ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", codec=");
        sbU.append(this.codec);
        sbU.append(", bytesSent=");
        sbU.append(this.bytesSent);
        sbU.append(", packetsSent=");
        sbU.append(this.packetsSent);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", fractionLost=");
        sbU.append(this.fractionLost);
        sbU.append(", bitrate=");
        sbU.append(this.bitrate);
        sbU.append(", bitrateTarget=");
        sbU.append(this.bitrateTarget);
        sbU.append(", encodeUsage=");
        sbU.append(this.encodeUsage);
        sbU.append(", encoderImplementationName=");
        sbU.append(this.encoderImplementationName);
        sbU.append(", averageEncodeTime=");
        sbU.append(this.averageEncodeTime);
        sbU.append(", resolution=");
        sbU.append(this.resolution);
        sbU.append(", framesSent=");
        sbU.append(this.framesSent);
        sbU.append(", framesEncoded=");
        sbU.append(this.framesEncoded);
        sbU.append(", frameRateInput=");
        sbU.append(this.frameRateInput);
        sbU.append(", frameRateEncode=");
        sbU.append(this.frameRateEncode);
        sbU.append(", firCount=");
        sbU.append(this.firCount);
        sbU.append(", nackCount=");
        sbU.append(this.nackCount);
        sbU.append(", pliCount=");
        sbU.append(this.pliCount);
        sbU.append(", qpSum=");
        sbU.append(this.qpSum);
        sbU.append(", bandwidthLimitedResolution=");
        sbU.append(this.bandwidthLimitedResolution);
        sbU.append(", cpuLimitedResolution=");
        return outline.O(sbU, this.cpuLimitedResolution, ")");
    }
}
