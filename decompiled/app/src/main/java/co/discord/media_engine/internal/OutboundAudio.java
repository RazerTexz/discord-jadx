package co.discord.media_engine.internal;

import a0.a.a.a;
import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bL\b\u0080\b\u0018\u00002\u00020\u0001B£\u0002\u0012\n\u0010/\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u00100\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u00101\u001a\u00020\n\u0012\n\u00102\u001a\u00060\u0002j\u0002`\r\u0012\n\u00103\u001a\u00060\u0002j\u0002`\r\u0012\n\u00104\u001a\u00060\u0002j\u0002`\r\u0012\n\u00105\u001a\u00060\u0011j\u0002`\u0012\u0012\n\u00106\u001a\u00060\u0011j\u0002`\u0012\u0012\n\u00107\u001a\u00060\u0016j\u0002`\u0017\u0012\n\u00108\u001a\u00060\u0002j\u0002`\r\u0012\n\u00109\u001a\u00060\u0002j\u0002`\r\u0012\n\u0010:\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010;\u001a\u00060\u0011j\u0002`\u0012\u0012\n\u0010<\u001a\u00060\u0011j\u0002`\u0012\u0012\n\u0010=\u001a\u00060\u0006j\u0002`\u001f\u0012\n\u0010>\u001a\u00060\u0006j\u0002`!\u0012\n\u0010?\u001a\u00060\u0006j\u0002`!\u0012\u0006\u0010@\u001a\u00020$\u0012\n\u0010A\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010B\u001a\u00060\u0006j\u0002`\u0007\u0012\b\u0010C\u001a\u0004\u0018\u00010$\u0012\u000e\u0010D\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\b\u0010E\u001a\u0004\u0018\u00010$\u0012\u000e\u0010F\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\bn\u0010oJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u000e\u001a\u00060\u0002j\u0002`\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0005J\u0014\u0010\u000f\u001a\u00060\u0002j\u0002`\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0005J\u0014\u0010\u0010\u001a\u00060\u0002j\u0002`\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0005J\u0014\u0010\u0013\u001a\u00060\u0011j\u0002`\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0015\u001a\u00060\u0011j\u0002`\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0014\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001a\u001a\u00060\u0002j\u0002`\rHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0005J\u0014\u0010\u001b\u001a\u00060\u0002j\u0002`\rHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0005J\u0014\u0010\u001c\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\u001c\u0010\tJ\u0014\u0010\u001d\u001a\u00060\u0011j\u0002`\u0012HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0014J\u0014\u0010\u001e\u001a\u00060\u0011j\u0002`\u0012HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0014J\u0014\u0010 \u001a\u00060\u0006j\u0002`\u001fHÆ\u0003¢\u0006\u0004\b \u0010\tJ\u0014\u0010\"\u001a\u00060\u0006j\u0002`!HÆ\u0003¢\u0006\u0004\b\"\u0010\tJ\u0014\u0010#\u001a\u00060\u0006j\u0002`!HÆ\u0003¢\u0006\u0004\b#\u0010\tJ\u0010\u0010%\u001a\u00020$HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0014\u0010'\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b'\u0010\tJ\u0014\u0010(\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b(\u0010\tJ\u0012\u0010)\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0004\b)\u0010*J\u0018\u0010+\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003¢\u0006\u0004\b+\u0010,J\u0012\u0010-\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0004\b-\u0010*J\u0018\u0010.\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003¢\u0006\u0004\b.\u0010,JÜ\u0002\u0010G\u001a\u00020\u00002\f\b\u0002\u0010/\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u00100\u001a\u00060\u0006j\u0002`\u00072\b\b\u0002\u00101\u001a\u00020\n2\f\b\u0002\u00102\u001a\u00060\u0002j\u0002`\r2\f\b\u0002\u00103\u001a\u00060\u0002j\u0002`\r2\f\b\u0002\u00104\u001a\u00060\u0002j\u0002`\r2\f\b\u0002\u00105\u001a\u00060\u0011j\u0002`\u00122\f\b\u0002\u00106\u001a\u00060\u0011j\u0002`\u00122\f\b\u0002\u00107\u001a\u00060\u0016j\u0002`\u00172\f\b\u0002\u00108\u001a\u00060\u0002j\u0002`\r2\f\b\u0002\u00109\u001a\u00060\u0002j\u0002`\r2\f\b\u0002\u0010:\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u0010;\u001a\u00060\u0011j\u0002`\u00122\f\b\u0002\u0010<\u001a\u00060\u0011j\u0002`\u00122\f\b\u0002\u0010=\u001a\u00060\u0006j\u0002`\u001f2\f\b\u0002\u0010>\u001a\u00060\u0006j\u0002`!2\f\b\u0002\u0010?\u001a\u00060\u0006j\u0002`!2\b\b\u0002\u0010@\u001a\u00020$2\f\b\u0002\u0010A\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u0010B\u001a\u00060\u0006j\u0002`\u00072\n\b\u0002\u0010C\u001a\u0004\u0018\u00010$2\u0010\b\u0002\u0010D\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\b\u0002\u0010E\u001a\u0004\u0018\u00010$2\u0010\b\u0002\u0010F\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0001¢\u0006\u0004\bG\u0010HJ\u0010\u0010I\u001a\u00020\nHÖ\u0001¢\u0006\u0004\bI\u0010\fJ\u0010\u0010J\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bJ\u0010\u0005J\u001a\u0010L\u001a\u00020$2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bL\u0010MR\u001d\u00100\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010N\u001a\u0004\bO\u0010\tR\u001d\u0010/\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010P\u001a\u0004\bQ\u0010\u0005R\u001d\u00104\u001a\u00060\u0002j\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010P\u001a\u0004\bR\u0010\u0005R\u001d\u0010;\u001a\u00060\u0011j\u0002`\u00128\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010S\u001a\u0004\bT\u0010\u0014R\u001d\u00105\u001a\u00060\u0011j\u0002`\u00128\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010S\u001a\u0004\bU\u0010\u0014R\u001d\u0010A\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010N\u001a\u0004\bV\u0010\tR!\u0010F\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010W\u001a\u0004\bX\u0010,R\u001d\u00108\u001a\u00060\u0002j\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010P\u001a\u0004\bY\u0010\u0005R!\u0010D\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010W\u001a\u0004\bZ\u0010,R\u0019\u00101\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010[\u001a\u0004\b\\\u0010\fR\u001d\u00107\u001a\u00060\u0016j\u0002`\u00178\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010]\u001a\u0004\b^\u0010\u0019R\u001b\u0010E\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010_\u001a\u0004\b`\u0010*R\u001d\u00102\u001a\u00060\u0002j\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010P\u001a\u0004\ba\u0010\u0005R\u001d\u0010>\u001a\u00060\u0006j\u0002`!8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010N\u001a\u0004\bb\u0010\tR\u001d\u0010?\u001a\u00060\u0006j\u0002`!8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010N\u001a\u0004\bc\u0010\tR\u001d\u0010<\u001a\u00060\u0011j\u0002`\u00128\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010S\u001a\u0004\bd\u0010\u0014R\u001d\u00103\u001a\u00060\u0002j\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010P\u001a\u0004\be\u0010\u0005R\u001d\u0010=\u001a\u00060\u0006j\u0002`\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010N\u001a\u0004\bf\u0010\tR\u001b\u0010C\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010_\u001a\u0004\bg\u0010*R\u001d\u00109\u001a\u00060\u0002j\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010P\u001a\u0004\bh\u0010\u0005R\u001d\u00106\u001a\u00060\u0011j\u0002`\u00128\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010S\u001a\u0004\bi\u0010\u0014R\u001d\u0010B\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010N\u001a\u0004\bj\u0010\tR\u0019\u0010@\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010k\u001a\u0004\bl\u0010&R\u001d\u0010:\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010N\u001a\u0004\bm\u0010\t¨\u0006p"}, d2 = {"Lco/discord/media_engine/internal/OutboundAudio;", "", "", "Lco/discord/media_engine/internal/I16;", "component1", "()I", "", "Lco/discord/media_engine/internal/U64;", "component2", "()J", "", "component3", "()Ljava/lang/String;", "Lco/discord/media_engine/internal/I32;", "component4", "component5", "component6", "", "Lco/discord/media_engine/internal/F64;", "component7", "()D", "component8", "", "Lco/discord/media_engine/internal/F32;", "component9", "()F", "component10", "component11", "component12", "component13", "component14", "Lco/discord/media_engine/internal/I64;", "component15", "Lco/discord/media_engine/internal/U32;", "component16", "component17", "", "component18", "()Z", "component19", "component20", "component21", "()Ljava/lang/Boolean;", "component22", "()Ljava/lang/Long;", "component23", "component24", "audioLevel", "bytesSent", "codecName", "codecPayloadType", "delayMedian", "delayStd", "echoReturnLoss", "echoReturnLossEnchancement", "fractionLost", "jitter", "packetsLost", "packetsSent", "residualEchoLikelihood", "residualEchoLikelihoodRecentMax", "rtt", "speaking", "ssrc", "typingNoiseDetected", "framesCaptured", "framesRendered", "noiseCancellerIsEnabled", "noiseCancellerProcessTime", "voiceActivityDetectorIsEnabled", "voiceActivityDetectorProcessTime", "copy", "(IJLjava/lang/String;IIIDDFIIJDDJJJZJJLjava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;)Lco/discord/media_engine/internal/OutboundAudio;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getBytesSent", "I", "getAudioLevel", "getDelayStd", "D", "getResidualEchoLikelihood", "getEchoReturnLoss", "getFramesCaptured", "Ljava/lang/Long;", "getVoiceActivityDetectorProcessTime", "getJitter", "getNoiseCancellerProcessTime", "Ljava/lang/String;", "getCodecName", "F", "getFractionLost", "Ljava/lang/Boolean;", "getVoiceActivityDetectorIsEnabled", "getCodecPayloadType", "getSpeaking", "getSsrc", "getResidualEchoLikelihoodRecentMax", "getDelayMedian", "getRtt", "getNoiseCancellerIsEnabled", "getPacketsLost", "getEchoReturnLossEnchancement", "getFramesRendered", "Z", "getTypingNoiseDetected", "getPacketsSent", "<init>", "(IJLjava/lang/String;IIIDDFIIJDDJJJZJJLjava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Long;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class OutboundAudio {
    private final int audioLevel;
    private final long bytesSent;
    private final String codecName;
    private final int codecPayloadType;
    private final int delayMedian;
    private final int delayStd;
    private final double echoReturnLoss;
    private final double echoReturnLossEnchancement;
    private final float fractionLost;
    private final long framesCaptured;
    private final long framesRendered;
    private final int jitter;
    private final Boolean noiseCancellerIsEnabled;
    private final Long noiseCancellerProcessTime;
    private final int packetsLost;
    private final long packetsSent;
    private final double residualEchoLikelihood;
    private final double residualEchoLikelihoodRecentMax;
    private final long rtt;
    private final long speaking;
    private final long ssrc;
    private final boolean typingNoiseDetected;
    private final Boolean voiceActivityDetectorIsEnabled;
    private final Long voiceActivityDetectorProcessTime;

    public OutboundAudio(int i, long j, String str, int i2, int i3, int i4, double d, double d2, float f, int i5, int i6, long j2, double d3, double d4, long j3, long j4, long j5, boolean z2, long j6, long j7, Boolean bool, Long l, Boolean bool2, Long l2) {
        Intrinsics3.checkNotNullParameter(str, "codecName");
        this.audioLevel = i;
        this.bytesSent = j;
        this.codecName = str;
        this.codecPayloadType = i2;
        this.delayMedian = i3;
        this.delayStd = i4;
        this.echoReturnLoss = d;
        this.echoReturnLossEnchancement = d2;
        this.fractionLost = f;
        this.jitter = i5;
        this.packetsLost = i6;
        this.packetsSent = j2;
        this.residualEchoLikelihood = d3;
        this.residualEchoLikelihoodRecentMax = d4;
        this.rtt = j3;
        this.speaking = j4;
        this.ssrc = j5;
        this.typingNoiseDetected = z2;
        this.framesCaptured = j6;
        this.framesRendered = j7;
        this.noiseCancellerIsEnabled = bool;
        this.noiseCancellerProcessTime = l;
        this.voiceActivityDetectorIsEnabled = bool2;
        this.voiceActivityDetectorProcessTime = l2;
    }

    public static /* synthetic */ OutboundAudio copy$default(OutboundAudio outboundAudio, int i, long j, String str, int i2, int i3, int i4, double d, double d2, float f, int i5, int i6, long j2, double d3, double d4, long j3, long j4, long j5, boolean z2, long j6, long j7, Boolean bool, Long l, Boolean bool2, Long l2, int i7, Object obj) {
        return outboundAudio.copy((i7 & 1) != 0 ? outboundAudio.audioLevel : i, (i7 & 2) != 0 ? outboundAudio.bytesSent : j, (i7 & 4) != 0 ? outboundAudio.codecName : str, (i7 & 8) != 0 ? outboundAudio.codecPayloadType : i2, (i7 & 16) != 0 ? outboundAudio.delayMedian : i3, (i7 & 32) != 0 ? outboundAudio.delayStd : i4, (i7 & 64) != 0 ? outboundAudio.echoReturnLoss : d, (i7 & 128) != 0 ? outboundAudio.echoReturnLossEnchancement : d2, (i7 & 256) != 0 ? outboundAudio.fractionLost : f, (i7 & 512) != 0 ? outboundAudio.jitter : i5, (i7 & 1024) != 0 ? outboundAudio.packetsLost : i6, (i7 & 2048) != 0 ? outboundAudio.packetsSent : j2, (i7 & 4096) != 0 ? outboundAudio.residualEchoLikelihood : d3, (i7 & 8192) != 0 ? outboundAudio.residualEchoLikelihoodRecentMax : d4, (i7 & 16384) != 0 ? outboundAudio.rtt : j3, (i7 & 32768) != 0 ? outboundAudio.speaking : j4, (i7 & 65536) != 0 ? outboundAudio.ssrc : j5, (i7 & 131072) != 0 ? outboundAudio.typingNoiseDetected : z2, (262144 & i7) != 0 ? outboundAudio.framesCaptured : j6, (i7 & 524288) != 0 ? outboundAudio.framesRendered : j7, (i7 & 1048576) != 0 ? outboundAudio.noiseCancellerIsEnabled : bool, (2097152 & i7) != 0 ? outboundAudio.noiseCancellerProcessTime : l, (i7 & 4194304) != 0 ? outboundAudio.voiceActivityDetectorIsEnabled : bool2, (i7 & 8388608) != 0 ? outboundAudio.voiceActivityDetectorProcessTime : l2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAudioLevel() {
        return this.audioLevel;
    }

    /* renamed from: component10, reason: from getter */
    public final int getJitter() {
        return this.jitter;
    }

    /* renamed from: component11, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    /* renamed from: component12, reason: from getter */
    public final long getPacketsSent() {
        return this.packetsSent;
    }

    /* renamed from: component13, reason: from getter */
    public final double getResidualEchoLikelihood() {
        return this.residualEchoLikelihood;
    }

    /* renamed from: component14, reason: from getter */
    public final double getResidualEchoLikelihoodRecentMax() {
        return this.residualEchoLikelihoodRecentMax;
    }

    /* renamed from: component15, reason: from getter */
    public final long getRtt() {
        return this.rtt;
    }

    /* renamed from: component16, reason: from getter */
    public final long getSpeaking() {
        return this.speaking;
    }

    /* renamed from: component17, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getTypingNoiseDetected() {
        return this.typingNoiseDetected;
    }

    /* renamed from: component19, reason: from getter */
    public final long getFramesCaptured() {
        return this.framesCaptured;
    }

    /* renamed from: component2, reason: from getter */
    public final long getBytesSent() {
        return this.bytesSent;
    }

    /* renamed from: component20, reason: from getter */
    public final long getFramesRendered() {
        return this.framesRendered;
    }

    /* renamed from: component21, reason: from getter */
    public final Boolean getNoiseCancellerIsEnabled() {
        return this.noiseCancellerIsEnabled;
    }

    /* renamed from: component22, reason: from getter */
    public final Long getNoiseCancellerProcessTime() {
        return this.noiseCancellerProcessTime;
    }

    /* renamed from: component23, reason: from getter */
    public final Boolean getVoiceActivityDetectorIsEnabled() {
        return this.voiceActivityDetectorIsEnabled;
    }

    /* renamed from: component24, reason: from getter */
    public final Long getVoiceActivityDetectorProcessTime() {
        return this.voiceActivityDetectorProcessTime;
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
    public final int getDelayMedian() {
        return this.delayMedian;
    }

    /* renamed from: component6, reason: from getter */
    public final int getDelayStd() {
        return this.delayStd;
    }

    /* renamed from: component7, reason: from getter */
    public final double getEchoReturnLoss() {
        return this.echoReturnLoss;
    }

    /* renamed from: component8, reason: from getter */
    public final double getEchoReturnLossEnchancement() {
        return this.echoReturnLossEnchancement;
    }

    /* renamed from: component9, reason: from getter */
    public final float getFractionLost() {
        return this.fractionLost;
    }

    public final OutboundAudio copy(int audioLevel, long bytesSent, String codecName, int codecPayloadType, int delayMedian, int delayStd, double echoReturnLoss, double echoReturnLossEnchancement, float fractionLost, int jitter, int packetsLost, long packetsSent, double residualEchoLikelihood, double residualEchoLikelihoodRecentMax, long rtt, long speaking, long ssrc, boolean typingNoiseDetected, long framesCaptured, long framesRendered, Boolean noiseCancellerIsEnabled, Long noiseCancellerProcessTime, Boolean voiceActivityDetectorIsEnabled, Long voiceActivityDetectorProcessTime) {
        Intrinsics3.checkNotNullParameter(codecName, "codecName");
        return new OutboundAudio(audioLevel, bytesSent, codecName, codecPayloadType, delayMedian, delayStd, echoReturnLoss, echoReturnLossEnchancement, fractionLost, jitter, packetsLost, packetsSent, residualEchoLikelihood, residualEchoLikelihoodRecentMax, rtt, speaking, ssrc, typingNoiseDetected, framesCaptured, framesRendered, noiseCancellerIsEnabled, noiseCancellerProcessTime, voiceActivityDetectorIsEnabled, voiceActivityDetectorProcessTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutboundAudio)) {
            return false;
        }
        OutboundAudio outboundAudio = (OutboundAudio) other;
        return this.audioLevel == outboundAudio.audioLevel && this.bytesSent == outboundAudio.bytesSent && Intrinsics3.areEqual(this.codecName, outboundAudio.codecName) && this.codecPayloadType == outboundAudio.codecPayloadType && this.delayMedian == outboundAudio.delayMedian && this.delayStd == outboundAudio.delayStd && Double.compare(this.echoReturnLoss, outboundAudio.echoReturnLoss) == 0 && Double.compare(this.echoReturnLossEnchancement, outboundAudio.echoReturnLossEnchancement) == 0 && Float.compare(this.fractionLost, outboundAudio.fractionLost) == 0 && this.jitter == outboundAudio.jitter && this.packetsLost == outboundAudio.packetsLost && this.packetsSent == outboundAudio.packetsSent && Double.compare(this.residualEchoLikelihood, outboundAudio.residualEchoLikelihood) == 0 && Double.compare(this.residualEchoLikelihoodRecentMax, outboundAudio.residualEchoLikelihoodRecentMax) == 0 && this.rtt == outboundAudio.rtt && this.speaking == outboundAudio.speaking && this.ssrc == outboundAudio.ssrc && this.typingNoiseDetected == outboundAudio.typingNoiseDetected && this.framesCaptured == outboundAudio.framesCaptured && this.framesRendered == outboundAudio.framesRendered && Intrinsics3.areEqual(this.noiseCancellerIsEnabled, outboundAudio.noiseCancellerIsEnabled) && Intrinsics3.areEqual(this.noiseCancellerProcessTime, outboundAudio.noiseCancellerProcessTime) && Intrinsics3.areEqual(this.voiceActivityDetectorIsEnabled, outboundAudio.voiceActivityDetectorIsEnabled) && Intrinsics3.areEqual(this.voiceActivityDetectorProcessTime, outboundAudio.voiceActivityDetectorProcessTime);
    }

    public final int getAudioLevel() {
        return this.audioLevel;
    }

    public final long getBytesSent() {
        return this.bytesSent;
    }

    public final String getCodecName() {
        return this.codecName;
    }

    public final int getCodecPayloadType() {
        return this.codecPayloadType;
    }

    public final int getDelayMedian() {
        return this.delayMedian;
    }

    public final int getDelayStd() {
        return this.delayStd;
    }

    public final double getEchoReturnLoss() {
        return this.echoReturnLoss;
    }

    public final double getEchoReturnLossEnchancement() {
        return this.echoReturnLossEnchancement;
    }

    public final float getFractionLost() {
        return this.fractionLost;
    }

    public final long getFramesCaptured() {
        return this.framesCaptured;
    }

    public final long getFramesRendered() {
        return this.framesRendered;
    }

    public final int getJitter() {
        return this.jitter;
    }

    public final Boolean getNoiseCancellerIsEnabled() {
        return this.noiseCancellerIsEnabled;
    }

    public final Long getNoiseCancellerProcessTime() {
        return this.noiseCancellerProcessTime;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsSent() {
        return this.packetsSent;
    }

    public final double getResidualEchoLikelihood() {
        return this.residualEchoLikelihood;
    }

    public final double getResidualEchoLikelihoodRecentMax() {
        return this.residualEchoLikelihoodRecentMax;
    }

    public final long getRtt() {
        return this.rtt;
    }

    public final long getSpeaking() {
        return this.speaking;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final boolean getTypingNoiseDetected() {
        return this.typingNoiseDetected;
    }

    public final Boolean getVoiceActivityDetectorIsEnabled() {
        return this.voiceActivityDetectorIsEnabled;
    }

    public final Long getVoiceActivityDetectorProcessTime() {
        return this.voiceActivityDetectorProcessTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = (b.a(this.bytesSent) + (this.audioLevel * 31)) * 31;
        String str = this.codecName;
        int iA2 = (b.a(this.ssrc) + ((b.a(this.speaking) + ((b.a(this.rtt) + ((a.a(this.residualEchoLikelihoodRecentMax) + ((a.a(this.residualEchoLikelihood) + ((b.a(this.packetsSent) + ((((((Float.floatToIntBits(this.fractionLost) + ((a.a(this.echoReturnLossEnchancement) + ((a.a(this.echoReturnLoss) + ((((((((iA + (str != null ? str.hashCode() : 0)) * 31) + this.codecPayloadType) * 31) + this.delayMedian) * 31) + this.delayStd) * 31)) * 31)) * 31)) * 31) + this.jitter) * 31) + this.packetsLost) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z2 = this.typingNoiseDetected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int iA3 = (b.a(this.framesRendered) + ((b.a(this.framesCaptured) + ((iA2 + i) * 31)) * 31)) * 31;
        Boolean bool = this.noiseCancellerIsEnabled;
        int iHashCode = (iA3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.noiseCancellerProcessTime;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.voiceActivityDetectorIsEnabled;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l2 = this.voiceActivityDetectorProcessTime;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("OutboundAudio(audioLevel=");
        sbU.append(this.audioLevel);
        sbU.append(", bytesSent=");
        sbU.append(this.bytesSent);
        sbU.append(", codecName=");
        sbU.append(this.codecName);
        sbU.append(", codecPayloadType=");
        sbU.append(this.codecPayloadType);
        sbU.append(", delayMedian=");
        sbU.append(this.delayMedian);
        sbU.append(", delayStd=");
        sbU.append(this.delayStd);
        sbU.append(", echoReturnLoss=");
        sbU.append(this.echoReturnLoss);
        sbU.append(", echoReturnLossEnchancement=");
        sbU.append(this.echoReturnLossEnchancement);
        sbU.append(", fractionLost=");
        sbU.append(this.fractionLost);
        sbU.append(", jitter=");
        sbU.append(this.jitter);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", packetsSent=");
        sbU.append(this.packetsSent);
        sbU.append(", residualEchoLikelihood=");
        sbU.append(this.residualEchoLikelihood);
        sbU.append(", residualEchoLikelihoodRecentMax=");
        sbU.append(this.residualEchoLikelihoodRecentMax);
        sbU.append(", rtt=");
        sbU.append(this.rtt);
        sbU.append(", speaking=");
        sbU.append(this.speaking);
        sbU.append(", ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", typingNoiseDetected=");
        sbU.append(this.typingNoiseDetected);
        sbU.append(", framesCaptured=");
        sbU.append(this.framesCaptured);
        sbU.append(", framesRendered=");
        sbU.append(this.framesRendered);
        sbU.append(", noiseCancellerIsEnabled=");
        sbU.append(this.noiseCancellerIsEnabled);
        sbU.append(", noiseCancellerProcessTime=");
        sbU.append(this.noiseCancellerProcessTime);
        sbU.append(", voiceActivityDetectorIsEnabled=");
        sbU.append(this.voiceActivityDetectorIsEnabled);
        sbU.append(", voiceActivityDetectorProcessTime=");
        return outline.G(sbU, this.voiceActivityDetectorProcessTime, ")");
    }
}
