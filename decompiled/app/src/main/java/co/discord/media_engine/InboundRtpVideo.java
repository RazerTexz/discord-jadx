package co.discord.media_engine;

import a0.a.a.a;
import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Statistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\n\u0010*\u001a\u00060\u0005j\u0002`\u0006\u0012\b\u0010+\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010,\u001a\u00020\u0005\u0012\u0006\u0010-\u001a\u00020\r\u0012\u0006\u0010.\u001a\u00020\r\u0012\u0006\u0010/\u001a\u00020\r\u0012\u0006\u00100\u001a\u00020\r\u0012\u0006\u00101\u001a\u00020\u0013\u0012\u0006\u00102\u001a\u00020\u0002\u0012\u0006\u00103\u001a\u00020\r\u0012\u0006\u00104\u001a\u00020\r\u0012\u0006\u00105\u001a\u00020\r\u0012\u0006\u00106\u001a\u00020\r\u0012\u0006\u00107\u001a\u00020\r\u0012\u0006\u00108\u001a\u00020\r\u0012\u0006\u00109\u001a\u00020\u0005\u0012\u0006\u0010:\u001a\u00020\u0005\u0012\u0006\u0010;\u001a\u00020\u0005\u0012\u0006\u0010<\u001a\u00020\u0005\u0012\u0006\u0010=\u001a\u00020\u0005\u0012\u0006\u0010>\u001a\u00020\u0005\u0012\u0006\u0010?\u001a\u00020\u0005\u0012\u0006\u0010@\u001a\u00020\u0005\u0012\u0006\u0010A\u001a\u00020\u0005\u0012\u0006\u0010B\u001a\u00020&¢\u0006\u0004\bk\u0010lJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000fJ\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000fJ\u0010\u0010\u0018\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u000fJ\u0010\u0010\u0019\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u000fJ\u0010\u0010\u001a\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u000fJ\u0010\u0010\u001b\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u000fJ\u0010\u0010\u001c\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u000fJ\u0010\u0010\u001d\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\bJ\u0010\u0010\u001e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\bJ\u0010\u0010\u001f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001f\u0010\bJ\u0010\u0010 \u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b \u0010\bJ\u0010\u0010!\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b!\u0010\bJ\u0010\u0010\"\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010\bJ\u0010\u0010#\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b#\u0010\bJ\u0010\u0010$\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b$\u0010\bJ\u0010\u0010%\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b%\u0010\bJ\u0010\u0010'\u001a\u00020&HÆ\u0003¢\u0006\u0004\b'\u0010(J\u009a\u0002\u0010C\u001a\u00020\u00002\b\b\u0002\u0010)\u001a\u00020\u00022\f\b\u0002\u0010*\u001a\u00060\u0005j\u0002`\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\r2\b\b\u0002\u0010.\u001a\u00020\r2\b\b\u0002\u0010/\u001a\u00020\r2\b\b\u0002\u00100\u001a\u00020\r2\b\b\u0002\u00101\u001a\u00020\u00132\b\b\u0002\u00102\u001a\u00020\u00022\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u00020\r2\b\b\u0002\u00105\u001a\u00020\r2\b\b\u0002\u00106\u001a\u00020\r2\b\b\u0002\u00107\u001a\u00020\r2\b\b\u0002\u00108\u001a\u00020\r2\b\b\u0002\u00109\u001a\u00020\u00052\b\b\u0002\u0010:\u001a\u00020\u00052\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00052\b\b\u0002\u0010=\u001a\u00020\u00052\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00052\b\b\u0002\u0010A\u001a\u00020\u00052\b\b\u0002\u0010B\u001a\u00020&HÆ\u0001¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bE\u0010\u0004J\u0010\u0010F\u001a\u00020\rHÖ\u0001¢\u0006\u0004\bF\u0010\u000fJ\u001a\u0010I\u001a\u00020H2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bI\u0010JR\u0019\u0010)\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010K\u001a\u0004\bL\u0010\u0004R\u0019\u0010;\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010M\u001a\u0004\bN\u0010\bR\u0019\u0010=\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010M\u001a\u0004\bO\u0010\bR\u0019\u0010<\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010M\u001a\u0004\bP\u0010\bR\u0019\u00106\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010Q\u001a\u0004\bR\u0010\u000fR\u0019\u00100\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010Q\u001a\u0004\bS\u0010\u000fR\u001b\u0010+\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010T\u001a\u0004\bU\u0010\u000bR\u0019\u00109\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010M\u001a\u0004\bV\u0010\bR\u0019\u0010/\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010Q\u001a\u0004\bW\u0010\u000fR\u0019\u00101\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010X\u001a\u0004\bY\u0010\u0015R\u0019\u00107\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010Q\u001a\u0004\bZ\u0010\u000fR\u0019\u0010:\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010M\u001a\u0004\b[\u0010\bR\u0019\u0010>\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010M\u001a\u0004\b\\\u0010\bR\u0019\u0010.\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010Q\u001a\u0004\b]\u0010\u000fR\u0019\u00108\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010Q\u001a\u0004\b^\u0010\u000fR\u0019\u00104\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010Q\u001a\u0004\b_\u0010\u000fR\u0019\u00105\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010Q\u001a\u0004\b`\u0010\u000fR\u0019\u0010?\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010M\u001a\u0004\ba\u0010\bR\u0019\u0010A\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010M\u001a\u0004\bb\u0010\bR\u0019\u0010-\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010Q\u001a\u0004\bc\u0010\u000fR\u0019\u00103\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010Q\u001a\u0004\bd\u0010\u000fR\u0019\u00102\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010K\u001a\u0004\be\u0010\u0004R\u001d\u0010*\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010M\u001a\u0004\bf\u0010\bR\u0019\u0010@\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010M\u001a\u0004\bg\u0010\bR\u0019\u0010B\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010h\u001a\u0004\bi\u0010(R\u0019\u0010,\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010M\u001a\u0004\bj\u0010\b¨\u0006m"}, d2 = {"Lco/discord/media_engine/InboundRtpVideo;", "", "", "component1", "()Ljava/lang/String;", "", "Lco/discord/media_engine/U32;", "component2", "()J", "Lco/discord/media_engine/StatsCodec;", "component3", "()Lco/discord/media_engine/StatsCodec;", "component4", "", "component5", "()I", "component6", "component7", "component8", "Lco/discord/media_engine/Resolution;", "component9", "()Lco/discord/media_engine/Resolution;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "", "component26", "()D", "type", "ssrc", "codec", "bytesReceived", "packetsReceived", "packetsLost", ModelAuditLogEntry.CHANGE_KEY_BITRATE, "averageDecodeTime", "resolution", "decoderImplementationName", "framesDecoded", "framesDropped", "framesReceived", "frameRateDecode", "frameRateNetwork", "frameRateRender", "firCount", "nackCount", "pliCount", "qpSum", "freezeCount", "pauseCount", "totalFreezesDuration", "totalPausesDuration", "totalFramesDuration", "sumOfSquaredFramesDurations", "copy", "(Ljava/lang/String;JLco/discord/media_engine/StatsCodec;JIIIILco/discord/media_engine/Resolution;Ljava/lang/String;IIIIIIJJJJJJJJJD)Lco/discord/media_engine/InboundRtpVideo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", "J", "getPliCount", "getFreezeCount", "getQpSum", "I", "getFrameRateDecode", "getAverageDecodeTime", "Lco/discord/media_engine/StatsCodec;", "getCodec", "getFirCount", "getBitrate", "Lco/discord/media_engine/Resolution;", "getResolution", "getFrameRateNetwork", "getNackCount", "getPauseCount", "getPacketsLost", "getFrameRateRender", "getFramesDropped", "getFramesReceived", "getTotalFreezesDuration", "getTotalFramesDuration", "getPacketsReceived", "getFramesDecoded", "getDecoderImplementationName", "getSsrc", "getTotalPausesDuration", "D", "getSumOfSquaredFramesDurations", "getBytesReceived", "<init>", "(Ljava/lang/String;JLco/discord/media_engine/StatsCodec;JIIIILco/discord/media_engine/Resolution;Ljava/lang/String;IIIIIIJJJJJJJJJD)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class InboundRtpVideo {
    private final int averageDecodeTime;
    private final int bitrate;
    private final long bytesReceived;
    private final StatsCodec codec;
    private final String decoderImplementationName;
    private final long firCount;
    private final int frameRateDecode;
    private final int frameRateNetwork;
    private final int frameRateRender;
    private final int framesDecoded;
    private final int framesDropped;
    private final int framesReceived;
    private final long freezeCount;
    private final long nackCount;
    private final int packetsLost;
    private final int packetsReceived;
    private final long pauseCount;
    private final long pliCount;
    private final long qpSum;
    private final Resolution resolution;
    private final long ssrc;
    private final double sumOfSquaredFramesDurations;
    private final long totalFramesDuration;
    private final long totalFreezesDuration;
    private final long totalPausesDuration;
    private final String type;

    public InboundRtpVideo(String str, long j, StatsCodec statsCodec, long j2, int i, int i2, int i3, int i4, Resolution resolution, String str2, int i5, int i6, int i7, int i8, int i9, int i10, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, double d) {
        Intrinsics3.checkNotNullParameter(str, "type");
        Intrinsics3.checkNotNullParameter(resolution, "resolution");
        Intrinsics3.checkNotNullParameter(str2, "decoderImplementationName");
        this.type = str;
        this.ssrc = j;
        this.codec = statsCodec;
        this.bytesReceived = j2;
        this.packetsReceived = i;
        this.packetsLost = i2;
        this.bitrate = i3;
        this.averageDecodeTime = i4;
        this.resolution = resolution;
        this.decoderImplementationName = str2;
        this.framesDecoded = i5;
        this.framesDropped = i6;
        this.framesReceived = i7;
        this.frameRateDecode = i8;
        this.frameRateNetwork = i9;
        this.frameRateRender = i10;
        this.firCount = j3;
        this.nackCount = j4;
        this.pliCount = j5;
        this.qpSum = j6;
        this.freezeCount = j7;
        this.pauseCount = j8;
        this.totalFreezesDuration = j9;
        this.totalPausesDuration = j10;
        this.totalFramesDuration = j11;
        this.sumOfSquaredFramesDurations = d;
    }

    public static /* synthetic */ InboundRtpVideo copy$default(InboundRtpVideo inboundRtpVideo, String str, long j, StatsCodec statsCodec, long j2, int i, int i2, int i3, int i4, Resolution resolution, String str2, int i5, int i6, int i7, int i8, int i9, int i10, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, double d, int i11, Object obj) {
        return inboundRtpVideo.copy((i11 & 1) != 0 ? inboundRtpVideo.type : str, (i11 & 2) != 0 ? inboundRtpVideo.ssrc : j, (i11 & 4) != 0 ? inboundRtpVideo.codec : statsCodec, (i11 & 8) != 0 ? inboundRtpVideo.bytesReceived : j2, (i11 & 16) != 0 ? inboundRtpVideo.packetsReceived : i, (i11 & 32) != 0 ? inboundRtpVideo.packetsLost : i2, (i11 & 64) != 0 ? inboundRtpVideo.bitrate : i3, (i11 & 128) != 0 ? inboundRtpVideo.averageDecodeTime : i4, (i11 & 256) != 0 ? inboundRtpVideo.resolution : resolution, (i11 & 512) != 0 ? inboundRtpVideo.decoderImplementationName : str2, (i11 & 1024) != 0 ? inboundRtpVideo.framesDecoded : i5, (i11 & 2048) != 0 ? inboundRtpVideo.framesDropped : i6, (i11 & 4096) != 0 ? inboundRtpVideo.framesReceived : i7, (i11 & 8192) != 0 ? inboundRtpVideo.frameRateDecode : i8, (i11 & 16384) != 0 ? inboundRtpVideo.frameRateNetwork : i9, (i11 & 32768) != 0 ? inboundRtpVideo.frameRateRender : i10, (i11 & 65536) != 0 ? inboundRtpVideo.firCount : j3, (i11 & 131072) != 0 ? inboundRtpVideo.nackCount : j4, (i11 & 262144) != 0 ? inboundRtpVideo.pliCount : j5, (i11 & 524288) != 0 ? inboundRtpVideo.qpSum : j6, (i11 & 1048576) != 0 ? inboundRtpVideo.freezeCount : j7, (i11 & 2097152) != 0 ? inboundRtpVideo.pauseCount : j8, (i11 & 4194304) != 0 ? inboundRtpVideo.totalFreezesDuration : j9, (i11 & 8388608) != 0 ? inboundRtpVideo.totalPausesDuration : j10, (i11 & 16777216) != 0 ? inboundRtpVideo.totalFramesDuration : j11, (i11 & 33554432) != 0 ? inboundRtpVideo.sumOfSquaredFramesDurations : d);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDecoderImplementationName() {
        return this.decoderImplementationName;
    }

    /* renamed from: component11, reason: from getter */
    public final int getFramesDecoded() {
        return this.framesDecoded;
    }

    /* renamed from: component12, reason: from getter */
    public final int getFramesDropped() {
        return this.framesDropped;
    }

    /* renamed from: component13, reason: from getter */
    public final int getFramesReceived() {
        return this.framesReceived;
    }

    /* renamed from: component14, reason: from getter */
    public final int getFrameRateDecode() {
        return this.frameRateDecode;
    }

    /* renamed from: component15, reason: from getter */
    public final int getFrameRateNetwork() {
        return this.frameRateNetwork;
    }

    /* renamed from: component16, reason: from getter */
    public final int getFrameRateRender() {
        return this.frameRateRender;
    }

    /* renamed from: component17, reason: from getter */
    public final long getFirCount() {
        return this.firCount;
    }

    /* renamed from: component18, reason: from getter */
    public final long getNackCount() {
        return this.nackCount;
    }

    /* renamed from: component19, reason: from getter */
    public final long getPliCount() {
        return this.pliCount;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* renamed from: component20, reason: from getter */
    public final long getQpSum() {
        return this.qpSum;
    }

    /* renamed from: component21, reason: from getter */
    public final long getFreezeCount() {
        return this.freezeCount;
    }

    /* renamed from: component22, reason: from getter */
    public final long getPauseCount() {
        return this.pauseCount;
    }

    /* renamed from: component23, reason: from getter */
    public final long getTotalFreezesDuration() {
        return this.totalFreezesDuration;
    }

    /* renamed from: component24, reason: from getter */
    public final long getTotalPausesDuration() {
        return this.totalPausesDuration;
    }

    /* renamed from: component25, reason: from getter */
    public final long getTotalFramesDuration() {
        return this.totalFramesDuration;
    }

    /* renamed from: component26, reason: from getter */
    public final double getSumOfSquaredFramesDurations() {
        return this.sumOfSquaredFramesDurations;
    }

    /* renamed from: component3, reason: from getter */
    public final StatsCodec getCodec() {
        return this.codec;
    }

    /* renamed from: component4, reason: from getter */
    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPacketsReceived() {
        return this.packetsReceived;
    }

    /* renamed from: component6, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    /* renamed from: component7, reason: from getter */
    public final int getBitrate() {
        return this.bitrate;
    }

    /* renamed from: component8, reason: from getter */
    public final int getAverageDecodeTime() {
        return this.averageDecodeTime;
    }

    /* renamed from: component9, reason: from getter */
    public final Resolution getResolution() {
        return this.resolution;
    }

    public final InboundRtpVideo copy(String type, long ssrc, StatsCodec codec, long bytesReceived, int packetsReceived, int packetsLost, int bitrate, int averageDecodeTime, Resolution resolution, String decoderImplementationName, int framesDecoded, int framesDropped, int framesReceived, int frameRateDecode, int frameRateNetwork, int frameRateRender, long firCount, long nackCount, long pliCount, long qpSum, long freezeCount, long pauseCount, long totalFreezesDuration, long totalPausesDuration, long totalFramesDuration, double sumOfSquaredFramesDurations) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(resolution, "resolution");
        Intrinsics3.checkNotNullParameter(decoderImplementationName, "decoderImplementationName");
        return new InboundRtpVideo(type, ssrc, codec, bytesReceived, packetsReceived, packetsLost, bitrate, averageDecodeTime, resolution, decoderImplementationName, framesDecoded, framesDropped, framesReceived, frameRateDecode, frameRateNetwork, frameRateRender, firCount, nackCount, pliCount, qpSum, freezeCount, pauseCount, totalFreezesDuration, totalPausesDuration, totalFramesDuration, sumOfSquaredFramesDurations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundRtpVideo)) {
            return false;
        }
        InboundRtpVideo inboundRtpVideo = (InboundRtpVideo) other;
        return Intrinsics3.areEqual(this.type, inboundRtpVideo.type) && this.ssrc == inboundRtpVideo.ssrc && Intrinsics3.areEqual(this.codec, inboundRtpVideo.codec) && this.bytesReceived == inboundRtpVideo.bytesReceived && this.packetsReceived == inboundRtpVideo.packetsReceived && this.packetsLost == inboundRtpVideo.packetsLost && this.bitrate == inboundRtpVideo.bitrate && this.averageDecodeTime == inboundRtpVideo.averageDecodeTime && Intrinsics3.areEqual(this.resolution, inboundRtpVideo.resolution) && Intrinsics3.areEqual(this.decoderImplementationName, inboundRtpVideo.decoderImplementationName) && this.framesDecoded == inboundRtpVideo.framesDecoded && this.framesDropped == inboundRtpVideo.framesDropped && this.framesReceived == inboundRtpVideo.framesReceived && this.frameRateDecode == inboundRtpVideo.frameRateDecode && this.frameRateNetwork == inboundRtpVideo.frameRateNetwork && this.frameRateRender == inboundRtpVideo.frameRateRender && this.firCount == inboundRtpVideo.firCount && this.nackCount == inboundRtpVideo.nackCount && this.pliCount == inboundRtpVideo.pliCount && this.qpSum == inboundRtpVideo.qpSum && this.freezeCount == inboundRtpVideo.freezeCount && this.pauseCount == inboundRtpVideo.pauseCount && this.totalFreezesDuration == inboundRtpVideo.totalFreezesDuration && this.totalPausesDuration == inboundRtpVideo.totalPausesDuration && this.totalFramesDuration == inboundRtpVideo.totalFramesDuration && Double.compare(this.sumOfSquaredFramesDurations, inboundRtpVideo.sumOfSquaredFramesDurations) == 0;
    }

    public final int getAverageDecodeTime() {
        return this.averageDecodeTime;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    public final StatsCodec getCodec() {
        return this.codec;
    }

    public final String getDecoderImplementationName() {
        return this.decoderImplementationName;
    }

    public final long getFirCount() {
        return this.firCount;
    }

    public final int getFrameRateDecode() {
        return this.frameRateDecode;
    }

    public final int getFrameRateNetwork() {
        return this.frameRateNetwork;
    }

    public final int getFrameRateRender() {
        return this.frameRateRender;
    }

    public final int getFramesDecoded() {
        return this.framesDecoded;
    }

    public final int getFramesDropped() {
        return this.framesDropped;
    }

    public final int getFramesReceived() {
        return this.framesReceived;
    }

    public final long getFreezeCount() {
        return this.freezeCount;
    }

    public final long getNackCount() {
        return this.nackCount;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final int getPacketsReceived() {
        return this.packetsReceived;
    }

    public final long getPauseCount() {
        return this.pauseCount;
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

    public final double getSumOfSquaredFramesDurations() {
        return this.sumOfSquaredFramesDurations;
    }

    public final long getTotalFramesDuration() {
        return this.totalFramesDuration;
    }

    public final long getTotalFreezesDuration() {
        return this.totalFreezesDuration;
    }

    public final long getTotalPausesDuration() {
        return this.totalPausesDuration;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iA = (b.a(this.ssrc) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        StatsCodec statsCodec = this.codec;
        int iA2 = (((((((((b.a(this.bytesReceived) + ((iA + (statsCodec != null ? statsCodec.hashCode() : 0)) * 31)) * 31) + this.packetsReceived) * 31) + this.packetsLost) * 31) + this.bitrate) * 31) + this.averageDecodeTime) * 31;
        Resolution resolution = this.resolution;
        int iHashCode = (iA2 + (resolution != null ? resolution.hashCode() : 0)) * 31;
        String str2 = this.decoderImplementationName;
        return a.a(this.sumOfSquaredFramesDurations) + ((b.a(this.totalFramesDuration) + ((b.a(this.totalPausesDuration) + ((b.a(this.totalFreezesDuration) + ((b.a(this.pauseCount) + ((b.a(this.freezeCount) + ((b.a(this.qpSum) + ((b.a(this.pliCount) + ((b.a(this.nackCount) + ((b.a(this.firCount) + ((((((((((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.framesDecoded) * 31) + this.framesDropped) * 31) + this.framesReceived) * 31) + this.frameRateDecode) * 31) + this.frameRateNetwork) * 31) + this.frameRateRender) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundRtpVideo(type=");
        sbU.append(this.type);
        sbU.append(", ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", codec=");
        sbU.append(this.codec);
        sbU.append(", bytesReceived=");
        sbU.append(this.bytesReceived);
        sbU.append(", packetsReceived=");
        sbU.append(this.packetsReceived);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", bitrate=");
        sbU.append(this.bitrate);
        sbU.append(", averageDecodeTime=");
        sbU.append(this.averageDecodeTime);
        sbU.append(", resolution=");
        sbU.append(this.resolution);
        sbU.append(", decoderImplementationName=");
        sbU.append(this.decoderImplementationName);
        sbU.append(", framesDecoded=");
        sbU.append(this.framesDecoded);
        sbU.append(", framesDropped=");
        sbU.append(this.framesDropped);
        sbU.append(", framesReceived=");
        sbU.append(this.framesReceived);
        sbU.append(", frameRateDecode=");
        sbU.append(this.frameRateDecode);
        sbU.append(", frameRateNetwork=");
        sbU.append(this.frameRateNetwork);
        sbU.append(", frameRateRender=");
        sbU.append(this.frameRateRender);
        sbU.append(", firCount=");
        sbU.append(this.firCount);
        sbU.append(", nackCount=");
        sbU.append(this.nackCount);
        sbU.append(", pliCount=");
        sbU.append(this.pliCount);
        sbU.append(", qpSum=");
        sbU.append(this.qpSum);
        sbU.append(", freezeCount=");
        sbU.append(this.freezeCount);
        sbU.append(", pauseCount=");
        sbU.append(this.pauseCount);
        sbU.append(", totalFreezesDuration=");
        sbU.append(this.totalFreezesDuration);
        sbU.append(", totalPausesDuration=");
        sbU.append(this.totalPausesDuration);
        sbU.append(", totalFramesDuration=");
        sbU.append(this.totalFramesDuration);
        sbU.append(", sumOfSquaredFramesDurations=");
        sbU.append(this.sumOfSquaredFramesDurations);
        sbU.append(")");
        return sbU.toString();
    }
}
