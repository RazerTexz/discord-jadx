package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b \b\u0080\b\u0018\u00002\u00020\u0001B£\u0002\u0012\n\u0010#\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010$\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010%\u001a\u00020\n\u0012\n\u0010&\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010'\u001a\u00060\u0006j\u0002`\u000e\u0012\n\u0010(\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010)\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010*\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010+\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010,\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010-\u001a\u00060\u0006j\u0002`\u000e\u0012\n\u0010.\u001a\u00060\u0006j\u0002`\u000e\u0012\n\u0010/\u001a\u00060\u0006j\u0002`\u000e\u0012\n\u00100\u001a\u00060\u0006j\u0002`\u000e\u0012\n\u00101\u001a\u00060\u0006j\u0002`\u000e\u0012\n\u00102\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u00103\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u00104\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u00105\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u00106\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u00107\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u00108\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u00109\u001a\u00060\u0006j\u0002`\u000e\u0012\n\u0010:\u001a\u00060\u0006j\u0002`\u000e¢\u0006\u0004\b^\u0010_J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\r\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\u0005J\u0014\u0010\u000f\u001a\u00060\u0006j\u0002`\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\tJ\u0014\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0005J\u0014\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0005J\u0014\u0010\u0012\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\u0014\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0005J\u0014\u0010\u0014\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0005J\u0014\u0010\u0015\u001a\u00060\u0006j\u0002`\u000eHÆ\u0003¢\u0006\u0004\b\u0015\u0010\tJ\u0014\u0010\u0016\u001a\u00060\u0006j\u0002`\u000eHÆ\u0003¢\u0006\u0004\b\u0016\u0010\tJ\u0014\u0010\u0017\u001a\u00060\u0006j\u0002`\u000eHÆ\u0003¢\u0006\u0004\b\u0017\u0010\tJ\u0014\u0010\u0018\u001a\u00060\u0006j\u0002`\u000eHÆ\u0003¢\u0006\u0004\b\u0018\u0010\tJ\u0014\u0010\u0019\u001a\u00060\u0006j\u0002`\u000eHÆ\u0003¢\u0006\u0004\b\u0019\u0010\tJ\u0014\u0010\u001a\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\tJ\u0014\u0010\u001b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\tJ\u0014\u0010\u001c\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\u001c\u0010\tJ\u0014\u0010\u001d\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\u001d\u0010\tJ\u0014\u0010\u001e\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\u001e\u0010\tJ\u0014\u0010\u001f\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\u001f\u0010\tJ\u0014\u0010 \u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b \u0010\tJ\u0014\u0010!\u001a\u00060\u0006j\u0002`\u000eHÆ\u0003¢\u0006\u0004\b!\u0010\tJ\u0014\u0010\"\u001a\u00060\u0006j\u0002`\u000eHÆ\u0003¢\u0006\u0004\b\"\u0010\tJÜ\u0002\u0010;\u001a\u00020\u00002\f\b\u0002\u0010#\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010$\u001a\u00060\u0006j\u0002`\u00072\b\b\u0002\u0010%\u001a\u00020\n2\f\b\u0002\u0010&\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010'\u001a\u00060\u0006j\u0002`\u000e2\f\b\u0002\u0010(\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010)\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010*\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010+\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010,\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010-\u001a\u00060\u0006j\u0002`\u000e2\f\b\u0002\u0010.\u001a\u00060\u0006j\u0002`\u000e2\f\b\u0002\u0010/\u001a\u00060\u0006j\u0002`\u000e2\f\b\u0002\u00100\u001a\u00060\u0006j\u0002`\u000e2\f\b\u0002\u00101\u001a\u00060\u0006j\u0002`\u000e2\f\b\u0002\u00102\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u00103\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u00104\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u00105\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u00106\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u00107\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u00108\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u00109\u001a\u00060\u0006j\u0002`\u000e2\f\b\u0002\u0010:\u001a\u00060\u0006j\u0002`\u000eHÆ\u0001¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b=\u0010\fJ\u0010\u0010>\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b>\u0010\u0005J\u001a\u0010A\u001a\u00020@2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bA\u0010BR\u001d\u00109\u001a\u00060\u0006j\u0002`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010C\u001a\u0004\bD\u0010\tR\u001d\u0010'\u001a\u00060\u0006j\u0002`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010C\u001a\u0004\bE\u0010\tR\u001d\u0010&\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010F\u001a\u0004\bG\u0010\u0005R\u001d\u0010#\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010F\u001a\u0004\bH\u0010\u0005R\u001d\u0010(\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010F\u001a\u0004\bI\u0010\u0005R\u001d\u0010,\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010F\u001a\u0004\bJ\u0010\u0005R\u001d\u0010-\u001a\u00060\u0006j\u0002`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010C\u001a\u0004\bK\u0010\tR\u001d\u0010:\u001a\u00060\u0006j\u0002`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010C\u001a\u0004\bL\u0010\tR\u001d\u0010)\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010F\u001a\u0004\bM\u0010\u0005R\u001d\u0010$\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010C\u001a\u0004\bN\u0010\tR\u001d\u00107\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010C\u001a\u0004\bO\u0010\tR\u0019\u0010%\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010P\u001a\u0004\bQ\u0010\fR\u001d\u0010*\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010F\u001a\u0004\bR\u0010\u0005R\u001d\u00101\u001a\u00060\u0006j\u0002`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010C\u001a\u0004\bS\u0010\tR\u001d\u00108\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010C\u001a\u0004\bT\u0010\tR\u001d\u0010+\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010F\u001a\u0004\bU\u0010\u0005R\u001d\u00104\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010C\u001a\u0004\bV\u0010\tR\u001d\u00103\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010C\u001a\u0004\bW\u0010\tR\u001d\u00100\u001a\u00060\u0006j\u0002`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010C\u001a\u0004\bX\u0010\tR\u001d\u00106\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010C\u001a\u0004\bY\u0010\tR\u001d\u0010.\u001a\u00060\u0006j\u0002`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010C\u001a\u0004\bZ\u0010\tR\u001d\u00102\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010C\u001a\u0004\b[\u0010\tR\u001d\u00105\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010C\u001a\u0004\b\\\u0010\tR\u001d\u0010/\u001a\u00060\u0006j\u0002`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010C\u001a\u0004\b]\u0010\t¨\u0006`"}, d2 = {"Lco/discord/media_engine/internal/InboundAudio;", "", "", "Lco/discord/media_engine/internal/I32;", "component1", "()I", "", "Lco/discord/media_engine/internal/U64;", "component2", "()J", "", "component3", "()Ljava/lang/String;", "component4", "Lco/discord/media_engine/internal/U32;", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "audioLevel", "bytesReceived", "codecName", "codecPayloadType", "delayEstimate", "decodingCNG", "decodingMutedOutput", "decodingNormal", "decodingPLC", "decodingPLCCNG", "jitter", "jitterBuffer", "jitterBufferPreferred", "packetsLost", "packetsReceived", "opSilence", "opNormal", "opMerge", "opExpand", "opAccelerate", "opPreemptiveExpand", "opCNG", "speaking", "ssrc", "copy", "(IJLjava/lang/String;IJIIIIIJJJJJJJJJJJJJJ)Lco/discord/media_engine/internal/InboundAudio;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getSpeaking", "getDelayEstimate", "I", "getCodecPayloadType", "getAudioLevel", "getDecodingCNG", "getDecodingPLCCNG", "getJitter", "getSsrc", "getDecodingMutedOutput", "getBytesReceived", "getOpPreemptiveExpand", "Ljava/lang/String;", "getCodecName", "getDecodingNormal", "getPacketsReceived", "getOpCNG", "getDecodingPLC", "getOpMerge", "getOpNormal", "getPacketsLost", "getOpAccelerate", "getJitterBuffer", "getOpSilence", "getOpExpand", "getJitterBufferPreferred", "<init>", "(IJLjava/lang/String;IJIIIIIJJJJJJJJJJJJJJ)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class InboundAudio {
    private final int audioLevel;
    private final long bytesReceived;
    private final String codecName;
    private final int codecPayloadType;
    private final int decodingCNG;
    private final int decodingMutedOutput;
    private final int decodingNormal;
    private final int decodingPLC;
    private final int decodingPLCCNG;
    private final long delayEstimate;
    private final long jitter;
    private final long jitterBuffer;
    private final long jitterBufferPreferred;
    private final long opAccelerate;
    private final long opCNG;
    private final long opExpand;
    private final long opMerge;
    private final long opNormal;
    private final long opPreemptiveExpand;
    private final long opSilence;
    private final long packetsLost;
    private final long packetsReceived;
    private final long speaking;
    private final long ssrc;

    public InboundAudio(int i, long j, String str, int i2, long j2, int i3, int i4, int i5, int i6, int i7, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        Intrinsics3.checkNotNullParameter(str, "codecName");
        this.audioLevel = i;
        this.bytesReceived = j;
        this.codecName = str;
        this.codecPayloadType = i2;
        this.delayEstimate = j2;
        this.decodingCNG = i3;
        this.decodingMutedOutput = i4;
        this.decodingNormal = i5;
        this.decodingPLC = i6;
        this.decodingPLCCNG = i7;
        this.jitter = j3;
        this.jitterBuffer = j4;
        this.jitterBufferPreferred = j5;
        this.packetsLost = j6;
        this.packetsReceived = j7;
        this.opSilence = j8;
        this.opNormal = j9;
        this.opMerge = j10;
        this.opExpand = j11;
        this.opAccelerate = j12;
        this.opPreemptiveExpand = j13;
        this.opCNG = j14;
        this.speaking = j15;
        this.ssrc = j16;
    }

    public static /* synthetic */ InboundAudio copy$default(InboundAudio inboundAudio, int i, long j, String str, int i2, long j2, int i3, int i4, int i5, int i6, int i7, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i8, Object obj) {
        return inboundAudio.copy((i8 & 1) != 0 ? inboundAudio.audioLevel : i, (i8 & 2) != 0 ? inboundAudio.bytesReceived : j, (i8 & 4) != 0 ? inboundAudio.codecName : str, (i8 & 8) != 0 ? inboundAudio.codecPayloadType : i2, (i8 & 16) != 0 ? inboundAudio.delayEstimate : j2, (i8 & 32) != 0 ? inboundAudio.decodingCNG : i3, (i8 & 64) != 0 ? inboundAudio.decodingMutedOutput : i4, (i8 & 128) != 0 ? inboundAudio.decodingNormal : i5, (i8 & 256) != 0 ? inboundAudio.decodingPLC : i6, (i8 & 512) != 0 ? inboundAudio.decodingPLCCNG : i7, (i8 & 1024) != 0 ? inboundAudio.jitter : j3, (i8 & 2048) != 0 ? inboundAudio.jitterBuffer : j4, (i8 & 4096) != 0 ? inboundAudio.jitterBufferPreferred : j5, (i8 & 8192) != 0 ? inboundAudio.packetsLost : j6, (i8 & 16384) != 0 ? inboundAudio.packetsReceived : j7, (i8 & 32768) != 0 ? inboundAudio.opSilence : j8, (i8 & 65536) != 0 ? inboundAudio.opNormal : j9, (i8 & 131072) != 0 ? inboundAudio.opMerge : j10, (i8 & 262144) != 0 ? inboundAudio.opExpand : j11, (i8 & 524288) != 0 ? inboundAudio.opAccelerate : j12, (i8 & 1048576) != 0 ? inboundAudio.opPreemptiveExpand : j13, (i8 & 2097152) != 0 ? inboundAudio.opCNG : j14, (i8 & 4194304) != 0 ? inboundAudio.speaking : j15, (i8 & 8388608) != 0 ? inboundAudio.ssrc : j16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAudioLevel() {
        return this.audioLevel;
    }

    /* renamed from: component10, reason: from getter */
    public final int getDecodingPLCCNG() {
        return this.decodingPLCCNG;
    }

    /* renamed from: component11, reason: from getter */
    public final long getJitter() {
        return this.jitter;
    }

    /* renamed from: component12, reason: from getter */
    public final long getJitterBuffer() {
        return this.jitterBuffer;
    }

    /* renamed from: component13, reason: from getter */
    public final long getJitterBufferPreferred() {
        return this.jitterBufferPreferred;
    }

    /* renamed from: component14, reason: from getter */
    public final long getPacketsLost() {
        return this.packetsLost;
    }

    /* renamed from: component15, reason: from getter */
    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    /* renamed from: component16, reason: from getter */
    public final long getOpSilence() {
        return this.opSilence;
    }

    /* renamed from: component17, reason: from getter */
    public final long getOpNormal() {
        return this.opNormal;
    }

    /* renamed from: component18, reason: from getter */
    public final long getOpMerge() {
        return this.opMerge;
    }

    /* renamed from: component19, reason: from getter */
    public final long getOpExpand() {
        return this.opExpand;
    }

    /* renamed from: component2, reason: from getter */
    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    /* renamed from: component20, reason: from getter */
    public final long getOpAccelerate() {
        return this.opAccelerate;
    }

    /* renamed from: component21, reason: from getter */
    public final long getOpPreemptiveExpand() {
        return this.opPreemptiveExpand;
    }

    /* renamed from: component22, reason: from getter */
    public final long getOpCNG() {
        return this.opCNG;
    }

    /* renamed from: component23, reason: from getter */
    public final long getSpeaking() {
        return this.speaking;
    }

    /* renamed from: component24, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCodecName() {
        return this.codecName;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCodecPayloadType() {
        return this.codecPayloadType;
    }

    /* renamed from: component5, reason: from getter */
    public final long getDelayEstimate() {
        return this.delayEstimate;
    }

    /* renamed from: component6, reason: from getter */
    public final int getDecodingCNG() {
        return this.decodingCNG;
    }

    /* renamed from: component7, reason: from getter */
    public final int getDecodingMutedOutput() {
        return this.decodingMutedOutput;
    }

    /* renamed from: component8, reason: from getter */
    public final int getDecodingNormal() {
        return this.decodingNormal;
    }

    /* renamed from: component9, reason: from getter */
    public final int getDecodingPLC() {
        return this.decodingPLC;
    }

    public final InboundAudio copy(int audioLevel, long bytesReceived, String codecName, int codecPayloadType, long delayEstimate, int decodingCNG, int decodingMutedOutput, int decodingNormal, int decodingPLC, int decodingPLCCNG, long jitter, long jitterBuffer, long jitterBufferPreferred, long packetsLost, long packetsReceived, long opSilence, long opNormal, long opMerge, long opExpand, long opAccelerate, long opPreemptiveExpand, long opCNG, long speaking, long ssrc) {
        Intrinsics3.checkNotNullParameter(codecName, "codecName");
        return new InboundAudio(audioLevel, bytesReceived, codecName, codecPayloadType, delayEstimate, decodingCNG, decodingMutedOutput, decodingNormal, decodingPLC, decodingPLCCNG, jitter, jitterBuffer, jitterBufferPreferred, packetsLost, packetsReceived, opSilence, opNormal, opMerge, opExpand, opAccelerate, opPreemptiveExpand, opCNG, speaking, ssrc);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundAudio)) {
            return false;
        }
        InboundAudio inboundAudio = (InboundAudio) other;
        return this.audioLevel == inboundAudio.audioLevel && this.bytesReceived == inboundAudio.bytesReceived && Intrinsics3.areEqual(this.codecName, inboundAudio.codecName) && this.codecPayloadType == inboundAudio.codecPayloadType && this.delayEstimate == inboundAudio.delayEstimate && this.decodingCNG == inboundAudio.decodingCNG && this.decodingMutedOutput == inboundAudio.decodingMutedOutput && this.decodingNormal == inboundAudio.decodingNormal && this.decodingPLC == inboundAudio.decodingPLC && this.decodingPLCCNG == inboundAudio.decodingPLCCNG && this.jitter == inboundAudio.jitter && this.jitterBuffer == inboundAudio.jitterBuffer && this.jitterBufferPreferred == inboundAudio.jitterBufferPreferred && this.packetsLost == inboundAudio.packetsLost && this.packetsReceived == inboundAudio.packetsReceived && this.opSilence == inboundAudio.opSilence && this.opNormal == inboundAudio.opNormal && this.opMerge == inboundAudio.opMerge && this.opExpand == inboundAudio.opExpand && this.opAccelerate == inboundAudio.opAccelerate && this.opPreemptiveExpand == inboundAudio.opPreemptiveExpand && this.opCNG == inboundAudio.opCNG && this.speaking == inboundAudio.speaking && this.ssrc == inboundAudio.ssrc;
    }

    public final int getAudioLevel() {
        return this.audioLevel;
    }

    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    public final String getCodecName() {
        return this.codecName;
    }

    public final int getCodecPayloadType() {
        return this.codecPayloadType;
    }

    public final int getDecodingCNG() {
        return this.decodingCNG;
    }

    public final int getDecodingMutedOutput() {
        return this.decodingMutedOutput;
    }

    public final int getDecodingNormal() {
        return this.decodingNormal;
    }

    public final int getDecodingPLC() {
        return this.decodingPLC;
    }

    public final int getDecodingPLCCNG() {
        return this.decodingPLCCNG;
    }

    public final long getDelayEstimate() {
        return this.delayEstimate;
    }

    public final long getJitter() {
        return this.jitter;
    }

    public final long getJitterBuffer() {
        return this.jitterBuffer;
    }

    public final long getJitterBufferPreferred() {
        return this.jitterBufferPreferred;
    }

    public final long getOpAccelerate() {
        return this.opAccelerate;
    }

    public final long getOpCNG() {
        return this.opCNG;
    }

    public final long getOpExpand() {
        return this.opExpand;
    }

    public final long getOpMerge() {
        return this.opMerge;
    }

    public final long getOpNormal() {
        return this.opNormal;
    }

    public final long getOpPreemptiveExpand() {
        return this.opPreemptiveExpand;
    }

    public final long getOpSilence() {
        return this.opSilence;
    }

    public final long getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    public final long getSpeaking() {
        return this.speaking;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public int hashCode() {
        int iA = (b.a(this.bytesReceived) + (this.audioLevel * 31)) * 31;
        String str = this.codecName;
        return b.a(this.ssrc) + ((b.a(this.speaking) + ((b.a(this.opCNG) + ((b.a(this.opPreemptiveExpand) + ((b.a(this.opAccelerate) + ((b.a(this.opExpand) + ((b.a(this.opMerge) + ((b.a(this.opNormal) + ((b.a(this.opSilence) + ((b.a(this.packetsReceived) + ((b.a(this.packetsLost) + ((b.a(this.jitterBufferPreferred) + ((b.a(this.jitterBuffer) + ((b.a(this.jitter) + ((((((((((((b.a(this.delayEstimate) + ((((iA + (str != null ? str.hashCode() : 0)) * 31) + this.codecPayloadType) * 31)) * 31) + this.decodingCNG) * 31) + this.decodingMutedOutput) * 31) + this.decodingNormal) * 31) + this.decodingPLC) * 31) + this.decodingPLCCNG) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundAudio(audioLevel=");
        sbU.append(this.audioLevel);
        sbU.append(", bytesReceived=");
        sbU.append(this.bytesReceived);
        sbU.append(", codecName=");
        sbU.append(this.codecName);
        sbU.append(", codecPayloadType=");
        sbU.append(this.codecPayloadType);
        sbU.append(", delayEstimate=");
        sbU.append(this.delayEstimate);
        sbU.append(", decodingCNG=");
        sbU.append(this.decodingCNG);
        sbU.append(", decodingMutedOutput=");
        sbU.append(this.decodingMutedOutput);
        sbU.append(", decodingNormal=");
        sbU.append(this.decodingNormal);
        sbU.append(", decodingPLC=");
        sbU.append(this.decodingPLC);
        sbU.append(", decodingPLCCNG=");
        sbU.append(this.decodingPLCCNG);
        sbU.append(", jitter=");
        sbU.append(this.jitter);
        sbU.append(", jitterBuffer=");
        sbU.append(this.jitterBuffer);
        sbU.append(", jitterBufferPreferred=");
        sbU.append(this.jitterBufferPreferred);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", packetsReceived=");
        sbU.append(this.packetsReceived);
        sbU.append(", opSilence=");
        sbU.append(this.opSilence);
        sbU.append(", opNormal=");
        sbU.append(this.opNormal);
        sbU.append(", opMerge=");
        sbU.append(this.opMerge);
        sbU.append(", opExpand=");
        sbU.append(this.opExpand);
        sbU.append(", opAccelerate=");
        sbU.append(this.opAccelerate);
        sbU.append(", opPreemptiveExpand=");
        sbU.append(this.opPreemptiveExpand);
        sbU.append(", opCNG=");
        sbU.append(this.opCNG);
        sbU.append(", speaking=");
        sbU.append(this.speaking);
        sbU.append(", ssrc=");
        return outline.C(sbU, this.ssrc, ")");
    }
}
