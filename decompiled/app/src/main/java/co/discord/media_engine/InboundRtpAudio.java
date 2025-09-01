package co.discord.media_engine;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Statistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\bU\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0002\u0012\u0006\u00100\u001a\u00020\u0002\u0012\n\u00101\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u00102\u001a\u00020\t\u0012\u0006\u00103\u001a\u00020\u0005\u0012\u0006\u00104\u001a\u00020\u0005\u0012\u0006\u00105\u001a\u00020\u0005\u0012\u0006\u00106\u001a\u00020\u000f\u0012\u0006\u00107\u001a\u00020\u0012\u0012\u0006\u00108\u001a\u00020\u0005\u0012\u0006\u00109\u001a\u00020\u0005\u0012\u0006\u0010:\u001a\u00020\u0005\u0012\u0006\u0010;\u001a\u00020\u0005\u0012\u0006\u0010<\u001a\u00020\u0019\u0012\u0006\u0010=\u001a\u00020\u0019\u0012\u0006\u0010>\u001a\u00020\u0019\u0012\u0006\u0010?\u001a\u00020\u0019\u0012\u0006\u0010@\u001a\u00020\u0019\u0012\b\u0010A\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010C\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010D\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010E\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010G\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010H\u001a\u0004\u0018\u00010(\u0012\b\u0010I\u001a\u0004\u0018\u00010(\u0012\b\u0010J\u001a\u0004\u0018\u00010(\u0012\b\u0010K\u001a\u0004\u0018\u00010(\u0012\b\u0010L\u001a\u0004\u0018\u00010(\u0012\b\u0010M\u001a\u0004\u0018\u00010(¢\u0006\u0004\b{\u0010|J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001bJ\u0010\u0010\u001f\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001bJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b \u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010!J\u0012\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b#\u0010!J\u0012\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b$\u0010!J\u0012\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b%\u0010!J\u0012\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b&\u0010!J\u0012\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b'\u0010!J\u0012\u0010)\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0004\b)\u0010*J\u0012\u0010+\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0004\b+\u0010*J\u0012\u0010,\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0004\b,\u0010*J\u0012\u0010-\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0004\b-\u0010*J\u0012\u0010.\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0004\b.\u0010*J\u0012\u0010/\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0004\b/\u0010*JÚ\u0002\u0010N\u001a\u00020\u00002\b\b\u0002\u00100\u001a\u00020\u00022\f\b\u0002\u00101\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u00102\u001a\u00020\t2\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u00052\b\b\u0002\u00105\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u00122\b\b\u0002\u00108\u001a\u00020\u00052\b\b\u0002\u00109\u001a\u00020\u00052\b\b\u0002\u0010:\u001a\u00020\u00052\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00192\b\b\u0002\u0010=\u001a\u00020\u00192\b\b\u0002\u0010>\u001a\u00020\u00192\b\b\u0002\u0010?\u001a\u00020\u00192\b\b\u0002\u0010@\u001a\u00020\u00192\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010H\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010(HÆ\u0001¢\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bP\u0010\u0004J\u0010\u0010Q\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\bQ\u0010\u001bJ\u001a\u0010S\u001a\u00020\u00122\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bS\u0010TR\u0019\u00105\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010U\u001a\u0004\bV\u0010\bR\u001b\u0010J\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010W\u001a\u0004\bX\u0010*R\u001b\u0010I\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010W\u001a\u0004\bY\u0010*R\u001b\u0010E\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010Z\u001a\u0004\b[\u0010!R\u0019\u0010=\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\\\u001a\u0004\b]\u0010\u001bR\u001b\u0010B\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010Z\u001a\u0004\b^\u0010!R\u0019\u0010:\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010U\u001a\u0004\b_\u0010\bR\u0019\u0010;\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010U\u001a\u0004\b`\u0010\bR\u001b\u0010C\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010Z\u001a\u0004\ba\u0010!R\u0019\u00107\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010b\u001a\u0004\bc\u0010\u0014R\u001b\u0010L\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010W\u001a\u0004\bd\u0010*R\u0019\u00102\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010e\u001a\u0004\bf\u0010\u000bR\u0019\u0010<\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\\\u001a\u0004\bg\u0010\u001bR\u001b\u0010K\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010W\u001a\u0004\bh\u0010*R\u001d\u00101\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010U\u001a\u0004\bi\u0010\bR\u0019\u00100\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010j\u001a\u0004\bk\u0010\u0004R\u0019\u0010@\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\\\u001a\u0004\bl\u0010\u001bR\u001b\u0010G\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010Z\u001a\u0004\bm\u0010!R\u0019\u00109\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010U\u001a\u0004\bn\u0010\bR\u0019\u00106\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010o\u001a\u0004\bp\u0010\u0011R\u0019\u00104\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010U\u001a\u0004\bq\u0010\bR\u001b\u0010M\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010W\u001a\u0004\br\u0010*R\u001b\u0010F\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010Z\u001a\u0004\bs\u0010!R\u0019\u00108\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010U\u001a\u0004\bt\u0010\bR\u001b\u0010H\u001a\u0004\u0018\u00010(8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010W\u001a\u0004\bu\u0010*R\u0019\u0010?\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010\\\u001a\u0004\bv\u0010\u001bR\u0019\u0010>\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\\\u001a\u0004\bw\u0010\u001bR\u001b\u0010A\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010Z\u001a\u0004\bx\u0010!R\u0019\u00103\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010U\u001a\u0004\by\u0010\bR\u001b\u0010D\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010Z\u001a\u0004\bz\u0010!¨\u0006}"}, d2 = {"Lco/discord/media_engine/InboundRtpAudio;", "", "", "component1", "()Ljava/lang/String;", "", "Lco/discord/media_engine/U32;", "component2", "()J", "Lco/discord/media_engine/StatsCodec;", "component3", "()Lco/discord/media_engine/StatsCodec;", "component4", "component5", "component6", "", "component7", "()F", "", "component8", "()Z", "component9", "component10", "component11", "component12", "", "component13", "()I", "component14", "component15", "component16", "component17", "component18", "()Ljava/lang/Long;", "component19", "component20", "component21", "component22", "component23", "component24", "Lco/discord/media_engine/PlayoutMetric;", "component25", "()Lco/discord/media_engine/PlayoutMetric;", "component26", "component27", "component28", "component29", "component30", "type", "ssrc", "codec", "bytesReceived", "packetsReceived", "packetsLost", "audioLevel", "audioDetected", "jitter", "jitterBuffer", "jitterBufferPreferred", "delayEstimate", "decodingCNG", "decodingMutedOutput", "decodingNormal", "decodingPLC", "decodingPLCCNG", "opSilence", "opNormal", "opMerge", "opExpand", "opAccelerate", "opPreemptiveExpand", "opCNG", "audioJitterBuffer", "audioJitterDelay", "audioJitterTarget", "audioPlayoutUnderruns", "relativeReceptionDelay", "relativePlayoutDelay", "copy", "(Ljava/lang/String;JLco/discord/media_engine/StatsCodec;JJJFZJJJJIIIIILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;)Lco/discord/media_engine/InboundRtpAudio;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getPacketsLost", "Lco/discord/media_engine/PlayoutMetric;", "getAudioJitterTarget", "getAudioJitterDelay", "Ljava/lang/Long;", "getOpAccelerate", "I", "getDecodingMutedOutput", "getOpNormal", "getJitterBufferPreferred", "getDelayEstimate", "getOpMerge", "Z", "getAudioDetected", "getRelativeReceptionDelay", "Lco/discord/media_engine/StatsCodec;", "getCodec", "getDecodingCNG", "getAudioPlayoutUnderruns", "getSsrc", "Ljava/lang/String;", "getType", "getDecodingPLCCNG", "getOpCNG", "getJitterBuffer", "F", "getAudioLevel", "getPacketsReceived", "getRelativePlayoutDelay", "getOpPreemptiveExpand", "getJitter", "getAudioJitterBuffer", "getDecodingPLC", "getDecodingNormal", "getOpSilence", "getBytesReceived", "getOpExpand", "<init>", "(Ljava/lang/String;JLco/discord/media_engine/StatsCodec;JJJFZJJJJIIIIILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class InboundRtpAudio {
    private final boolean audioDetected;
    private final PlayoutMetric audioJitterBuffer;
    private final PlayoutMetric audioJitterDelay;
    private final PlayoutMetric audioJitterTarget;
    private final float audioLevel;
    private final PlayoutMetric audioPlayoutUnderruns;
    private final long bytesReceived;
    private final StatsCodec codec;
    private final int decodingCNG;
    private final int decodingMutedOutput;
    private final int decodingNormal;
    private final int decodingPLC;
    private final int decodingPLCCNG;
    private final long delayEstimate;
    private final long jitter;
    private final long jitterBuffer;
    private final long jitterBufferPreferred;
    private final Long opAccelerate;
    private final Long opCNG;
    private final Long opExpand;
    private final Long opMerge;
    private final Long opNormal;
    private final Long opPreemptiveExpand;
    private final Long opSilence;
    private final long packetsLost;
    private final long packetsReceived;
    private final PlayoutMetric relativePlayoutDelay;
    private final PlayoutMetric relativeReceptionDelay;
    private final long ssrc;
    private final String type;

    public InboundRtpAudio(String str, long j, StatsCodec statsCodec, long j2, long j3, long j4, float f, boolean z2, long j5, long j6, long j7, long j8, int i, int i2, int i3, int i4, int i5, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, PlayoutMetric playoutMetric, PlayoutMetric playoutMetric2, PlayoutMetric playoutMetric3, PlayoutMetric playoutMetric4, PlayoutMetric playoutMetric5, PlayoutMetric playoutMetric6) {
        Intrinsics3.checkNotNullParameter(str, "type");
        Intrinsics3.checkNotNullParameter(statsCodec, "codec");
        this.type = str;
        this.ssrc = j;
        this.codec = statsCodec;
        this.bytesReceived = j2;
        this.packetsReceived = j3;
        this.packetsLost = j4;
        this.audioLevel = f;
        this.audioDetected = z2;
        this.jitter = j5;
        this.jitterBuffer = j6;
        this.jitterBufferPreferred = j7;
        this.delayEstimate = j8;
        this.decodingCNG = i;
        this.decodingMutedOutput = i2;
        this.decodingNormal = i3;
        this.decodingPLC = i4;
        this.decodingPLCCNG = i5;
        this.opSilence = l;
        this.opNormal = l2;
        this.opMerge = l3;
        this.opExpand = l4;
        this.opAccelerate = l5;
        this.opPreemptiveExpand = l6;
        this.opCNG = l7;
        this.audioJitterBuffer = playoutMetric;
        this.audioJitterDelay = playoutMetric2;
        this.audioJitterTarget = playoutMetric3;
        this.audioPlayoutUnderruns = playoutMetric4;
        this.relativeReceptionDelay = playoutMetric5;
        this.relativePlayoutDelay = playoutMetric6;
    }

    public static /* synthetic */ InboundRtpAudio copy$default(InboundRtpAudio inboundRtpAudio, String str, long j, StatsCodec statsCodec, long j2, long j3, long j4, float f, boolean z2, long j5, long j6, long j7, long j8, int i, int i2, int i3, int i4, int i5, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, PlayoutMetric playoutMetric, PlayoutMetric playoutMetric2, PlayoutMetric playoutMetric3, PlayoutMetric playoutMetric4, PlayoutMetric playoutMetric5, PlayoutMetric playoutMetric6, int i6, Object obj) {
        return inboundRtpAudio.copy((i6 & 1) != 0 ? inboundRtpAudio.type : str, (i6 & 2) != 0 ? inboundRtpAudio.ssrc : j, (i6 & 4) != 0 ? inboundRtpAudio.codec : statsCodec, (i6 & 8) != 0 ? inboundRtpAudio.bytesReceived : j2, (i6 & 16) != 0 ? inboundRtpAudio.packetsReceived : j3, (i6 & 32) != 0 ? inboundRtpAudio.packetsLost : j4, (i6 & 64) != 0 ? inboundRtpAudio.audioLevel : f, (i6 & 128) != 0 ? inboundRtpAudio.audioDetected : z2, (i6 & 256) != 0 ? inboundRtpAudio.jitter : j5, (i6 & 512) != 0 ? inboundRtpAudio.jitterBuffer : j6, (i6 & 1024) != 0 ? inboundRtpAudio.jitterBufferPreferred : j7, (i6 & 2048) != 0 ? inboundRtpAudio.delayEstimate : j8, (i6 & 4096) != 0 ? inboundRtpAudio.decodingCNG : i, (i6 & 8192) != 0 ? inboundRtpAudio.decodingMutedOutput : i2, (i6 & 16384) != 0 ? inboundRtpAudio.decodingNormal : i3, (i6 & 32768) != 0 ? inboundRtpAudio.decodingPLC : i4, (i6 & 65536) != 0 ? inboundRtpAudio.decodingPLCCNG : i5, (i6 & 131072) != 0 ? inboundRtpAudio.opSilence : l, (i6 & 262144) != 0 ? inboundRtpAudio.opNormal : l2, (i6 & 524288) != 0 ? inboundRtpAudio.opMerge : l3, (i6 & 1048576) != 0 ? inboundRtpAudio.opExpand : l4, (i6 & 2097152) != 0 ? inboundRtpAudio.opAccelerate : l5, (i6 & 4194304) != 0 ? inboundRtpAudio.opPreemptiveExpand : l6, (i6 & 8388608) != 0 ? inboundRtpAudio.opCNG : l7, (i6 & 16777216) != 0 ? inboundRtpAudio.audioJitterBuffer : playoutMetric, (i6 & 33554432) != 0 ? inboundRtpAudio.audioJitterDelay : playoutMetric2, (i6 & 67108864) != 0 ? inboundRtpAudio.audioJitterTarget : playoutMetric3, (i6 & 134217728) != 0 ? inboundRtpAudio.audioPlayoutUnderruns : playoutMetric4, (i6 & 268435456) != 0 ? inboundRtpAudio.relativeReceptionDelay : playoutMetric5, (i6 & 536870912) != 0 ? inboundRtpAudio.relativePlayoutDelay : playoutMetric6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component10, reason: from getter */
    public final long getJitterBuffer() {
        return this.jitterBuffer;
    }

    /* renamed from: component11, reason: from getter */
    public final long getJitterBufferPreferred() {
        return this.jitterBufferPreferred;
    }

    /* renamed from: component12, reason: from getter */
    public final long getDelayEstimate() {
        return this.delayEstimate;
    }

    /* renamed from: component13, reason: from getter */
    public final int getDecodingCNG() {
        return this.decodingCNG;
    }

    /* renamed from: component14, reason: from getter */
    public final int getDecodingMutedOutput() {
        return this.decodingMutedOutput;
    }

    /* renamed from: component15, reason: from getter */
    public final int getDecodingNormal() {
        return this.decodingNormal;
    }

    /* renamed from: component16, reason: from getter */
    public final int getDecodingPLC() {
        return this.decodingPLC;
    }

    /* renamed from: component17, reason: from getter */
    public final int getDecodingPLCCNG() {
        return this.decodingPLCCNG;
    }

    /* renamed from: component18, reason: from getter */
    public final Long getOpSilence() {
        return this.opSilence;
    }

    /* renamed from: component19, reason: from getter */
    public final Long getOpNormal() {
        return this.opNormal;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* renamed from: component20, reason: from getter */
    public final Long getOpMerge() {
        return this.opMerge;
    }

    /* renamed from: component21, reason: from getter */
    public final Long getOpExpand() {
        return this.opExpand;
    }

    /* renamed from: component22, reason: from getter */
    public final Long getOpAccelerate() {
        return this.opAccelerate;
    }

    /* renamed from: component23, reason: from getter */
    public final Long getOpPreemptiveExpand() {
        return this.opPreemptiveExpand;
    }

    /* renamed from: component24, reason: from getter */
    public final Long getOpCNG() {
        return this.opCNG;
    }

    /* renamed from: component25, reason: from getter */
    public final PlayoutMetric getAudioJitterBuffer() {
        return this.audioJitterBuffer;
    }

    /* renamed from: component26, reason: from getter */
    public final PlayoutMetric getAudioJitterDelay() {
        return this.audioJitterDelay;
    }

    /* renamed from: component27, reason: from getter */
    public final PlayoutMetric getAudioJitterTarget() {
        return this.audioJitterTarget;
    }

    /* renamed from: component28, reason: from getter */
    public final PlayoutMetric getAudioPlayoutUnderruns() {
        return this.audioPlayoutUnderruns;
    }

    /* renamed from: component29, reason: from getter */
    public final PlayoutMetric getRelativeReceptionDelay() {
        return this.relativeReceptionDelay;
    }

    /* renamed from: component3, reason: from getter */
    public final StatsCodec getCodec() {
        return this.codec;
    }

    /* renamed from: component30, reason: from getter */
    public final PlayoutMetric getRelativePlayoutDelay() {
        return this.relativePlayoutDelay;
    }

    /* renamed from: component4, reason: from getter */
    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    /* renamed from: component5, reason: from getter */
    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    /* renamed from: component6, reason: from getter */
    public final long getPacketsLost() {
        return this.packetsLost;
    }

    /* renamed from: component7, reason: from getter */
    public final float getAudioLevel() {
        return this.audioLevel;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getAudioDetected() {
        return this.audioDetected;
    }

    /* renamed from: component9, reason: from getter */
    public final long getJitter() {
        return this.jitter;
    }

    public final InboundRtpAudio copy(String type, long ssrc, StatsCodec codec, long bytesReceived, long packetsReceived, long packetsLost, float audioLevel, boolean audioDetected, long jitter, long jitterBuffer, long jitterBufferPreferred, long delayEstimate, int decodingCNG, int decodingMutedOutput, int decodingNormal, int decodingPLC, int decodingPLCCNG, Long opSilence, Long opNormal, Long opMerge, Long opExpand, Long opAccelerate, Long opPreemptiveExpand, Long opCNG, PlayoutMetric audioJitterBuffer, PlayoutMetric audioJitterDelay, PlayoutMetric audioJitterTarget, PlayoutMetric audioPlayoutUnderruns, PlayoutMetric relativeReceptionDelay, PlayoutMetric relativePlayoutDelay) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(codec, "codec");
        return new InboundRtpAudio(type, ssrc, codec, bytesReceived, packetsReceived, packetsLost, audioLevel, audioDetected, jitter, jitterBuffer, jitterBufferPreferred, delayEstimate, decodingCNG, decodingMutedOutput, decodingNormal, decodingPLC, decodingPLCCNG, opSilence, opNormal, opMerge, opExpand, opAccelerate, opPreemptiveExpand, opCNG, audioJitterBuffer, audioJitterDelay, audioJitterTarget, audioPlayoutUnderruns, relativeReceptionDelay, relativePlayoutDelay);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundRtpAudio)) {
            return false;
        }
        InboundRtpAudio inboundRtpAudio = (InboundRtpAudio) other;
        return Intrinsics3.areEqual(this.type, inboundRtpAudio.type) && this.ssrc == inboundRtpAudio.ssrc && Intrinsics3.areEqual(this.codec, inboundRtpAudio.codec) && this.bytesReceived == inboundRtpAudio.bytesReceived && this.packetsReceived == inboundRtpAudio.packetsReceived && this.packetsLost == inboundRtpAudio.packetsLost && Float.compare(this.audioLevel, inboundRtpAudio.audioLevel) == 0 && this.audioDetected == inboundRtpAudio.audioDetected && this.jitter == inboundRtpAudio.jitter && this.jitterBuffer == inboundRtpAudio.jitterBuffer && this.jitterBufferPreferred == inboundRtpAudio.jitterBufferPreferred && this.delayEstimate == inboundRtpAudio.delayEstimate && this.decodingCNG == inboundRtpAudio.decodingCNG && this.decodingMutedOutput == inboundRtpAudio.decodingMutedOutput && this.decodingNormal == inboundRtpAudio.decodingNormal && this.decodingPLC == inboundRtpAudio.decodingPLC && this.decodingPLCCNG == inboundRtpAudio.decodingPLCCNG && Intrinsics3.areEqual(this.opSilence, inboundRtpAudio.opSilence) && Intrinsics3.areEqual(this.opNormal, inboundRtpAudio.opNormal) && Intrinsics3.areEqual(this.opMerge, inboundRtpAudio.opMerge) && Intrinsics3.areEqual(this.opExpand, inboundRtpAudio.opExpand) && Intrinsics3.areEqual(this.opAccelerate, inboundRtpAudio.opAccelerate) && Intrinsics3.areEqual(this.opPreemptiveExpand, inboundRtpAudio.opPreemptiveExpand) && Intrinsics3.areEqual(this.opCNG, inboundRtpAudio.opCNG) && Intrinsics3.areEqual(this.audioJitterBuffer, inboundRtpAudio.audioJitterBuffer) && Intrinsics3.areEqual(this.audioJitterDelay, inboundRtpAudio.audioJitterDelay) && Intrinsics3.areEqual(this.audioJitterTarget, inboundRtpAudio.audioJitterTarget) && Intrinsics3.areEqual(this.audioPlayoutUnderruns, inboundRtpAudio.audioPlayoutUnderruns) && Intrinsics3.areEqual(this.relativeReceptionDelay, inboundRtpAudio.relativeReceptionDelay) && Intrinsics3.areEqual(this.relativePlayoutDelay, inboundRtpAudio.relativePlayoutDelay);
    }

    public final boolean getAudioDetected() {
        return this.audioDetected;
    }

    public final PlayoutMetric getAudioJitterBuffer() {
        return this.audioJitterBuffer;
    }

    public final PlayoutMetric getAudioJitterDelay() {
        return this.audioJitterDelay;
    }

    public final PlayoutMetric getAudioJitterTarget() {
        return this.audioJitterTarget;
    }

    public final float getAudioLevel() {
        return this.audioLevel;
    }

    public final PlayoutMetric getAudioPlayoutUnderruns() {
        return this.audioPlayoutUnderruns;
    }

    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    public final StatsCodec getCodec() {
        return this.codec;
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

    public final Long getOpAccelerate() {
        return this.opAccelerate;
    }

    public final Long getOpCNG() {
        return this.opCNG;
    }

    public final Long getOpExpand() {
        return this.opExpand;
    }

    public final Long getOpMerge() {
        return this.opMerge;
    }

    public final Long getOpNormal() {
        return this.opNormal;
    }

    public final Long getOpPreemptiveExpand() {
        return this.opPreemptiveExpand;
    }

    public final Long getOpSilence() {
        return this.opSilence;
    }

    public final long getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    public final PlayoutMetric getRelativePlayoutDelay() {
        return this.relativePlayoutDelay;
    }

    public final PlayoutMetric getRelativeReceptionDelay() {
        return this.relativeReceptionDelay;
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
        int iFloatToIntBits = (Float.floatToIntBits(this.audioLevel) + ((b.a(this.packetsLost) + ((b.a(this.packetsReceived) + ((b.a(this.bytesReceived) + ((iA + (statsCodec != null ? statsCodec.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z2 = this.audioDetected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int iA2 = (((((((((((b.a(this.delayEstimate) + ((b.a(this.jitterBufferPreferred) + ((b.a(this.jitterBuffer) + ((b.a(this.jitter) + ((iFloatToIntBits + i) * 31)) * 31)) * 31)) * 31)) * 31) + this.decodingCNG) * 31) + this.decodingMutedOutput) * 31) + this.decodingNormal) * 31) + this.decodingPLC) * 31) + this.decodingPLCCNG) * 31;
        Long l = this.opSilence;
        int iHashCode = (iA2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.opNormal;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.opMerge;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.opExpand;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.opAccelerate;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.opPreemptiveExpand;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.opCNG;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric = this.audioJitterBuffer;
        int iHashCode8 = (iHashCode7 + (playoutMetric != null ? playoutMetric.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric2 = this.audioJitterDelay;
        int iHashCode9 = (iHashCode8 + (playoutMetric2 != null ? playoutMetric2.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric3 = this.audioJitterTarget;
        int iHashCode10 = (iHashCode9 + (playoutMetric3 != null ? playoutMetric3.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric4 = this.audioPlayoutUnderruns;
        int iHashCode11 = (iHashCode10 + (playoutMetric4 != null ? playoutMetric4.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric5 = this.relativeReceptionDelay;
        int iHashCode12 = (iHashCode11 + (playoutMetric5 != null ? playoutMetric5.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric6 = this.relativePlayoutDelay;
        return iHashCode12 + (playoutMetric6 != null ? playoutMetric6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundRtpAudio(type=");
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
        sbU.append(", audioLevel=");
        sbU.append(this.audioLevel);
        sbU.append(", audioDetected=");
        sbU.append(this.audioDetected);
        sbU.append(", jitter=");
        sbU.append(this.jitter);
        sbU.append(", jitterBuffer=");
        sbU.append(this.jitterBuffer);
        sbU.append(", jitterBufferPreferred=");
        sbU.append(this.jitterBufferPreferred);
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
        sbU.append(", audioJitterBuffer=");
        sbU.append(this.audioJitterBuffer);
        sbU.append(", audioJitterDelay=");
        sbU.append(this.audioJitterDelay);
        sbU.append(", audioJitterTarget=");
        sbU.append(this.audioJitterTarget);
        sbU.append(", audioPlayoutUnderruns=");
        sbU.append(this.audioPlayoutUnderruns);
        sbU.append(", relativeReceptionDelay=");
        sbU.append(this.relativeReceptionDelay);
        sbU.append(", relativePlayoutDelay=");
        sbU.append(this.relativePlayoutDelay);
        sbU.append(")");
        return sbU.toString();
    }
}
