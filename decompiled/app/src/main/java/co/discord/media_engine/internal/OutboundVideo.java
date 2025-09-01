package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b5\b\u0080\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\n\u0010#\u001a\u00060\u0005j\u0002`\u0006\u0012\n\u0010$\u001a\u00060\u0005j\u0002`\t\u0012\u0006\u0010%\u001a\u00020\u000b\u0012\u0006\u0010&\u001a\u00020\u000b\u0012\n\u0010'\u001a\u00060\u0005j\u0002`\t\u0012\n\u0010(\u001a\u00060\u0005j\u0002`\t\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\n\u0010*\u001a\u00060\u0012j\u0002`\u0013\u0012\n\u0010+\u001a\u00060\u0005j\u0002`\t\u0012\n\u0010,\u001a\u00060\u0005j\u0002`\t\u0012\n\u0010-\u001a\u00060\u0005j\u0002`\t\u0012\n\u0010.\u001a\u00060\u0005j\u0002`\t\u0012\n\u0010/\u001a\u00060\u0012j\u0002`\u001a\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0006\u00101\u001a\u00020\u000b\u0012\n\u00102\u001a\u00060\u0005j\u0002`\t¢\u0006\u0004\bP\u0010QJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\n\u001a\u00060\u0005j\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0014\u0010\u000f\u001a\u00060\u0005j\u0002`\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\bJ\u0014\u0010\u0010\u001a\u00060\u0005j\u0002`\tHÆ\u0003¢\u0006\u0004\b\u0010\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0014\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0016\u001a\u00060\u0005j\u0002`\tHÆ\u0003¢\u0006\u0004\b\u0016\u0010\bJ\u0014\u0010\u0017\u001a\u00060\u0005j\u0002`\tHÆ\u0003¢\u0006\u0004\b\u0017\u0010\bJ\u0014\u0010\u0018\u001a\u00060\u0005j\u0002`\tHÆ\u0003¢\u0006\u0004\b\u0018\u0010\bJ\u0014\u0010\u0019\u001a\u00060\u0005j\u0002`\tHÆ\u0003¢\u0006\u0004\b\u0019\u0010\bJ\u0014\u0010\u001b\u001a\u00060\u0012j\u0002`\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0015J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b \u0010\rJ\u0014\u0010!\u001a\u00060\u0005j\u0002`\tHÆ\u0003¢\u0006\u0004\b!\u0010\bJì\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u00022\f\b\u0002\u0010#\u001a\u00060\u0005j\u0002`\u00062\f\b\u0002\u0010$\u001a\u00060\u0005j\u0002`\t2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\f\b\u0002\u0010'\u001a\u00060\u0005j\u0002`\t2\f\b\u0002\u0010(\u001a\u00060\u0005j\u0002`\t2\b\b\u0002\u0010)\u001a\u00020\u00022\f\b\u0002\u0010*\u001a\u00060\u0012j\u0002`\u00132\f\b\u0002\u0010+\u001a\u00060\u0005j\u0002`\t2\f\b\u0002\u0010,\u001a\u00060\u0005j\u0002`\t2\f\b\u0002\u0010-\u001a\u00060\u0005j\u0002`\t2\f\b\u0002\u0010.\u001a\u00060\u0005j\u0002`\t2\f\b\u0002\u0010/\u001a\u00060\u0012j\u0002`\u001a2\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\b\u0002\u00101\u001a\u00020\u000b2\f\b\u0002\u00102\u001a\u00060\u0005j\u0002`\tHÆ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b5\u0010\u0004J\u0010\u00106\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b6\u0010\bJ\u001a\u00108\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b8\u00109R\u001d\u0010*\u001a\u00060\u0012j\u0002`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010:\u001a\u0004\b;\u0010\u0015R\u0019\u0010)\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010<\u001a\u0004\b=\u0010\u0004R\u0019\u00101\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010>\u001a\u0004\b?\u0010\rR\u001d\u0010$\u001a\u00060\u0005j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010@\u001a\u0004\bA\u0010\bR\u001d\u0010#\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010@\u001a\u0004\bB\u0010\bR\u001d\u0010+\u001a\u00060\u0005j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010@\u001a\u0004\bC\u0010\bR\u001d\u0010-\u001a\u00060\u0005j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010@\u001a\u0004\bD\u0010\bR\u001d\u0010(\u001a\u00060\u0005j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010@\u001a\u0004\bE\u0010\bR\u0019\u0010%\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010>\u001a\u0004\bF\u0010\rR\u001d\u0010'\u001a\u00060\u0005j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010@\u001a\u0004\bG\u0010\bR\u001d\u00102\u001a\u00060\u0005j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010@\u001a\u0004\bH\u0010\bR\u001d\u0010.\u001a\u00060\u0005j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010@\u001a\u0004\bI\u0010\bR\u001d\u0010,\u001a\u00060\u0005j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010@\u001a\u0004\bJ\u0010\bR\u001f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010K\u001a\u0004\bL\u0010\u001fR\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010<\u001a\u0004\bM\u0010\u0004R\u0019\u0010&\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010>\u001a\u0004\bN\u0010\rR\u001d\u0010/\u001a\u00060\u0012j\u0002`\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010:\u001a\u0004\bO\u0010\u0015¨\u0006R"}, d2 = {"Lco/discord/media_engine/internal/OutboundVideo;", "", "", "component1", "()Ljava/lang/String;", "", "Lco/discord/media_engine/internal/U8;", "component2", "()I", "Lco/discord/media_engine/internal/I32;", "component3", "", "component4", "()Z", "component5", "component6", "component7", "component8", "", "Lco/discord/media_engine/internal/U32;", "component9", "()J", "component10", "component11", "component12", "component13", "Lco/discord/media_engine/internal/I64;", "component14", "", "Lco/discord/media_engine/internal/Substream;", "component15", "()[Lco/discord/media_engine/internal/Substream;", "component16", "component17", "codecName", "codecPayloadType", "avgEncodeTime", "bwLimitedResolution", "cpuLimitedResolution", "encodeFrameRate", "encodeUsage", "encoderImplementationName", "framesEncoded", "inputFrameRate", "mediaBitrate", "numberOfCPUAdaptChanges", "numberOfQualityAdaptChanges", "qpSum", "substreams", "suspended", "targetMediaBitrate", "copy", "(Ljava/lang/String;IIZZIILjava/lang/String;JIIIIJ[Lco/discord/media_engine/internal/Substream;ZI)Lco/discord/media_engine/internal/OutboundVideo;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getFramesEncoded", "Ljava/lang/String;", "getEncoderImplementationName", "Z", "getSuspended", "I", "getAvgEncodeTime", "getCodecPayloadType", "getInputFrameRate", "getNumberOfCPUAdaptChanges", "getEncodeUsage", "getBwLimitedResolution", "getEncodeFrameRate", "getTargetMediaBitrate", "getNumberOfQualityAdaptChanges", "getMediaBitrate", "[Lco/discord/media_engine/internal/Substream;", "getSubstreams", "getCodecName", "getCpuLimitedResolution", "getQpSum", "<init>", "(Ljava/lang/String;IIZZIILjava/lang/String;JIIIIJ[Lco/discord/media_engine/internal/Substream;ZI)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class OutboundVideo {
    private final int avgEncodeTime;
    private final boolean bwLimitedResolution;
    private final String codecName;
    private final int codecPayloadType;
    private final boolean cpuLimitedResolution;
    private final int encodeFrameRate;
    private final int encodeUsage;
    private final String encoderImplementationName;
    private final long framesEncoded;
    private final int inputFrameRate;
    private final int mediaBitrate;
    private final int numberOfCPUAdaptChanges;
    private final int numberOfQualityAdaptChanges;
    private final long qpSum;
    private final Substream[] substreams;
    private final boolean suspended;
    private final int targetMediaBitrate;

    public OutboundVideo(String str, int i, int i2, boolean z2, boolean z3, int i3, int i4, String str2, long j, int i5, int i6, int i7, int i8, long j2, Substream[] substreamArr, boolean z4, int i9) {
        Intrinsics3.checkNotNullParameter(str, "codecName");
        Intrinsics3.checkNotNullParameter(str2, "encoderImplementationName");
        Intrinsics3.checkNotNullParameter(substreamArr, "substreams");
        this.codecName = str;
        this.codecPayloadType = i;
        this.avgEncodeTime = i2;
        this.bwLimitedResolution = z2;
        this.cpuLimitedResolution = z3;
        this.encodeFrameRate = i3;
        this.encodeUsage = i4;
        this.encoderImplementationName = str2;
        this.framesEncoded = j;
        this.inputFrameRate = i5;
        this.mediaBitrate = i6;
        this.numberOfCPUAdaptChanges = i7;
        this.numberOfQualityAdaptChanges = i8;
        this.qpSum = j2;
        this.substreams = substreamArr;
        this.suspended = z4;
        this.targetMediaBitrate = i9;
    }

    public static /* synthetic */ OutboundVideo copy$default(OutboundVideo outboundVideo, String str, int i, int i2, boolean z2, boolean z3, int i3, int i4, String str2, long j, int i5, int i6, int i7, int i8, long j2, Substream[] substreamArr, boolean z4, int i9, int i10, Object obj) {
        return outboundVideo.copy((i10 & 1) != 0 ? outboundVideo.codecName : str, (i10 & 2) != 0 ? outboundVideo.codecPayloadType : i, (i10 & 4) != 0 ? outboundVideo.avgEncodeTime : i2, (i10 & 8) != 0 ? outboundVideo.bwLimitedResolution : z2, (i10 & 16) != 0 ? outboundVideo.cpuLimitedResolution : z3, (i10 & 32) != 0 ? outboundVideo.encodeFrameRate : i3, (i10 & 64) != 0 ? outboundVideo.encodeUsage : i4, (i10 & 128) != 0 ? outboundVideo.encoderImplementationName : str2, (i10 & 256) != 0 ? outboundVideo.framesEncoded : j, (i10 & 512) != 0 ? outboundVideo.inputFrameRate : i5, (i10 & 1024) != 0 ? outboundVideo.mediaBitrate : i6, (i10 & 2048) != 0 ? outboundVideo.numberOfCPUAdaptChanges : i7, (i10 & 4096) != 0 ? outboundVideo.numberOfQualityAdaptChanges : i8, (i10 & 8192) != 0 ? outboundVideo.qpSum : j2, (i10 & 16384) != 0 ? outboundVideo.substreams : substreamArr, (32768 & i10) != 0 ? outboundVideo.suspended : z4, (i10 & 65536) != 0 ? outboundVideo.targetMediaBitrate : i9);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCodecName() {
        return this.codecName;
    }

    /* renamed from: component10, reason: from getter */
    public final int getInputFrameRate() {
        return this.inputFrameRate;
    }

    /* renamed from: component11, reason: from getter */
    public final int getMediaBitrate() {
        return this.mediaBitrate;
    }

    /* renamed from: component12, reason: from getter */
    public final int getNumberOfCPUAdaptChanges() {
        return this.numberOfCPUAdaptChanges;
    }

    /* renamed from: component13, reason: from getter */
    public final int getNumberOfQualityAdaptChanges() {
        return this.numberOfQualityAdaptChanges;
    }

    /* renamed from: component14, reason: from getter */
    public final long getQpSum() {
        return this.qpSum;
    }

    /* renamed from: component15, reason: from getter */
    public final Substream[] getSubstreams() {
        return this.substreams;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getSuspended() {
        return this.suspended;
    }

    /* renamed from: component17, reason: from getter */
    public final int getTargetMediaBitrate() {
        return this.targetMediaBitrate;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCodecPayloadType() {
        return this.codecPayloadType;
    }

    /* renamed from: component3, reason: from getter */
    public final int getAvgEncodeTime() {
        return this.avgEncodeTime;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getBwLimitedResolution() {
        return this.bwLimitedResolution;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCpuLimitedResolution() {
        return this.cpuLimitedResolution;
    }

    /* renamed from: component6, reason: from getter */
    public final int getEncodeFrameRate() {
        return this.encodeFrameRate;
    }

    /* renamed from: component7, reason: from getter */
    public final int getEncodeUsage() {
        return this.encodeUsage;
    }

    /* renamed from: component8, reason: from getter */
    public final String getEncoderImplementationName() {
        return this.encoderImplementationName;
    }

    /* renamed from: component9, reason: from getter */
    public final long getFramesEncoded() {
        return this.framesEncoded;
    }

    public final OutboundVideo copy(String codecName, int codecPayloadType, int avgEncodeTime, boolean bwLimitedResolution, boolean cpuLimitedResolution, int encodeFrameRate, int encodeUsage, String encoderImplementationName, long framesEncoded, int inputFrameRate, int mediaBitrate, int numberOfCPUAdaptChanges, int numberOfQualityAdaptChanges, long qpSum, Substream[] substreams, boolean suspended, int targetMediaBitrate) {
        Intrinsics3.checkNotNullParameter(codecName, "codecName");
        Intrinsics3.checkNotNullParameter(encoderImplementationName, "encoderImplementationName");
        Intrinsics3.checkNotNullParameter(substreams, "substreams");
        return new OutboundVideo(codecName, codecPayloadType, avgEncodeTime, bwLimitedResolution, cpuLimitedResolution, encodeFrameRate, encodeUsage, encoderImplementationName, framesEncoded, inputFrameRate, mediaBitrate, numberOfCPUAdaptChanges, numberOfQualityAdaptChanges, qpSum, substreams, suspended, targetMediaBitrate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutboundVideo)) {
            return false;
        }
        OutboundVideo outboundVideo = (OutboundVideo) other;
        return Intrinsics3.areEqual(this.codecName, outboundVideo.codecName) && this.codecPayloadType == outboundVideo.codecPayloadType && this.avgEncodeTime == outboundVideo.avgEncodeTime && this.bwLimitedResolution == outboundVideo.bwLimitedResolution && this.cpuLimitedResolution == outboundVideo.cpuLimitedResolution && this.encodeFrameRate == outboundVideo.encodeFrameRate && this.encodeUsage == outboundVideo.encodeUsage && Intrinsics3.areEqual(this.encoderImplementationName, outboundVideo.encoderImplementationName) && this.framesEncoded == outboundVideo.framesEncoded && this.inputFrameRate == outboundVideo.inputFrameRate && this.mediaBitrate == outboundVideo.mediaBitrate && this.numberOfCPUAdaptChanges == outboundVideo.numberOfCPUAdaptChanges && this.numberOfQualityAdaptChanges == outboundVideo.numberOfQualityAdaptChanges && this.qpSum == outboundVideo.qpSum && Intrinsics3.areEqual(this.substreams, outboundVideo.substreams) && this.suspended == outboundVideo.suspended && this.targetMediaBitrate == outboundVideo.targetMediaBitrate;
    }

    public final int getAvgEncodeTime() {
        return this.avgEncodeTime;
    }

    public final boolean getBwLimitedResolution() {
        return this.bwLimitedResolution;
    }

    public final String getCodecName() {
        return this.codecName;
    }

    public final int getCodecPayloadType() {
        return this.codecPayloadType;
    }

    public final boolean getCpuLimitedResolution() {
        return this.cpuLimitedResolution;
    }

    public final int getEncodeFrameRate() {
        return this.encodeFrameRate;
    }

    public final int getEncodeUsage() {
        return this.encodeUsage;
    }

    public final String getEncoderImplementationName() {
        return this.encoderImplementationName;
    }

    public final long getFramesEncoded() {
        return this.framesEncoded;
    }

    public final int getInputFrameRate() {
        return this.inputFrameRate;
    }

    public final int getMediaBitrate() {
        return this.mediaBitrate;
    }

    public final int getNumberOfCPUAdaptChanges() {
        return this.numberOfCPUAdaptChanges;
    }

    public final int getNumberOfQualityAdaptChanges() {
        return this.numberOfQualityAdaptChanges;
    }

    public final long getQpSum() {
        return this.qpSum;
    }

    public final Substream[] getSubstreams() {
        return this.substreams;
    }

    public final boolean getSuspended() {
        return this.suspended;
    }

    public final int getTargetMediaBitrate() {
        return this.targetMediaBitrate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.codecName;
        int iHashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.codecPayloadType) * 31) + this.avgEncodeTime) * 31;
        boolean z2 = this.bwLimitedResolution;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z3 = this.cpuLimitedResolution;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (((((i2 + i3) * 31) + this.encodeFrameRate) * 31) + this.encodeUsage) * 31;
        String str2 = this.encoderImplementationName;
        int iA = (b.a(this.qpSum) + ((((((((((b.a(this.framesEncoded) + ((i4 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31) + this.inputFrameRate) * 31) + this.mediaBitrate) * 31) + this.numberOfCPUAdaptChanges) * 31) + this.numberOfQualityAdaptChanges) * 31)) * 31;
        Substream[] substreamArr = this.substreams;
        int iHashCode2 = (iA + (substreamArr != null ? Arrays.hashCode(substreamArr) : 0)) * 31;
        boolean z4 = this.suspended;
        return ((iHashCode2 + (z4 ? 1 : z4 ? 1 : 0)) * 31) + this.targetMediaBitrate;
    }

    public String toString() {
        StringBuilder sbU = outline.U("OutboundVideo(codecName=");
        sbU.append(this.codecName);
        sbU.append(", codecPayloadType=");
        sbU.append(this.codecPayloadType);
        sbU.append(", avgEncodeTime=");
        sbU.append(this.avgEncodeTime);
        sbU.append(", bwLimitedResolution=");
        sbU.append(this.bwLimitedResolution);
        sbU.append(", cpuLimitedResolution=");
        sbU.append(this.cpuLimitedResolution);
        sbU.append(", encodeFrameRate=");
        sbU.append(this.encodeFrameRate);
        sbU.append(", encodeUsage=");
        sbU.append(this.encodeUsage);
        sbU.append(", encoderImplementationName=");
        sbU.append(this.encoderImplementationName);
        sbU.append(", framesEncoded=");
        sbU.append(this.framesEncoded);
        sbU.append(", inputFrameRate=");
        sbU.append(this.inputFrameRate);
        sbU.append(", mediaBitrate=");
        sbU.append(this.mediaBitrate);
        sbU.append(", numberOfCPUAdaptChanges=");
        sbU.append(this.numberOfCPUAdaptChanges);
        sbU.append(", numberOfQualityAdaptChanges=");
        sbU.append(this.numberOfQualityAdaptChanges);
        sbU.append(", qpSum=");
        sbU.append(this.qpSum);
        sbU.append(", substreams=");
        sbU.append(Arrays.toString(this.substreams));
        sbU.append(", suspended=");
        sbU.append(this.suspended);
        sbU.append(", targetMediaBitrate=");
        return outline.B(sbU, this.targetMediaBitrate, ")");
    }
}
