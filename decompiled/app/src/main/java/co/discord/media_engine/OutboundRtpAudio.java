package co.discord.media_engine;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Statistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b6\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\n\u0010\u001f\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010 \u001a\u00020\t\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\u000e\u0012\u0006\u0010$\u001a\u00020\u0011\u0012\u0006\u0010%\u001a\u00020\u0011\u0012\u0006\u0010&\u001a\u00020\u0015\u0012\u0006\u0010'\u001a\u00020\u0005\u0012\u0006\u0010(\u001a\u00020\u0005\u0012\u0006\u0010)\u001a\u00020\u0015\u0012\u0006\u0010*\u001a\u00020\u0005\u0012\u0006\u0010+\u001a\u00020\u0015\u0012\u0006\u0010,\u001a\u00020\u0005¢\u0006\u0004\bI\u0010JJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\bJ\u0010\u0010\u0019\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0017J\u0010\u0010\u001b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\bJ\u0010\u0010\u001c\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0017J\u0010\u0010\u001d\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\bJª\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00022\f\b\u0002\u0010\u001f\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010&\u001a\u00020\u00152\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\b\b\u0002\u0010)\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00152\b\b\u0002\u0010,\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b/\u0010\u0004J\u0010\u00100\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b0\u0010\u0010J\u001a\u00102\u001a\u00020\u00152\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b2\u00103R\u0019\u0010)\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b)\u00104\u001a\u0004\b5\u0010\u0017R\u0019\u0010*\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u00106\u001a\u0004\b7\u0010\bR\u0019\u0010,\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u00106\u001a\u0004\b8\u0010\bR\u0019\u0010(\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u00106\u001a\u0004\b9\u0010\bR\u0019\u0010\u001e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010:\u001a\u0004\b;\u0010\u0004R\u0019\u0010#\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010<\u001a\u0004\b=\u0010\u0010R\u0019\u0010!\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u00106\u001a\u0004\b>\u0010\bR\u001d\u0010\u001f\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00106\u001a\u0004\b?\u0010\bR\u0019\u0010'\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b'\u00106\u001a\u0004\b@\u0010\bR\u0019\u0010%\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010A\u001a\u0004\bB\u0010\u0013R\u0019\u0010&\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b&\u00104\u001a\u0004\bC\u0010\u0017R\u0019\u0010$\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010A\u001a\u0004\bD\u0010\u0013R\u0019\u0010 \u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010E\u001a\u0004\bF\u0010\u000bR\u0019\u0010\"\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00106\u001a\u0004\bG\u0010\bR\u0019\u0010+\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b+\u00104\u001a\u0004\bH\u0010\u0017¨\u0006K"}, d2 = {"Lco/discord/media_engine/OutboundRtpAudio;", "", "", "component1", "()Ljava/lang/String;", "", "Lco/discord/media_engine/U32;", "component2", "()J", "Lco/discord/media_engine/StatsCodec;", "component3", "()Lco/discord/media_engine/StatsCodec;", "component4", "component5", "", "component6", "()I", "", "component7", "()F", "component8", "", "component9", "()Z", "component10", "component11", "component12", "component13", "component14", "component15", "type", "ssrc", "codec", "bytesSent", "packetsSent", "packetsLost", "fractionLost", "audioLevel", "audioDetected", "framesCaptured", "framesRendered", "noiseCancellerIsEnabled", "noiseCancellerProcessTime", "voiceActivityDetectorIsEnabled", "voiceActivityDetectorProcessTime", "copy", "(Ljava/lang/String;JLco/discord/media_engine/StatsCodec;JJIFFZJJZJZJ)Lco/discord/media_engine/OutboundRtpAudio;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getNoiseCancellerIsEnabled", "J", "getNoiseCancellerProcessTime", "getVoiceActivityDetectorProcessTime", "getFramesRendered", "Ljava/lang/String;", "getType", "I", "getPacketsLost", "getBytesSent", "getSsrc", "getFramesCaptured", "F", "getAudioLevel", "getAudioDetected", "getFractionLost", "Lco/discord/media_engine/StatsCodec;", "getCodec", "getPacketsSent", "getVoiceActivityDetectorIsEnabled", "<init>", "(Ljava/lang/String;JLco/discord/media_engine/StatsCodec;JJIFFZJJZJZJ)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class OutboundRtpAudio {
    private final boolean audioDetected;
    private final float audioLevel;
    private final long bytesSent;
    private final StatsCodec codec;
    private final float fractionLost;
    private final long framesCaptured;
    private final long framesRendered;
    private final boolean noiseCancellerIsEnabled;
    private final long noiseCancellerProcessTime;
    private final int packetsLost;
    private final long packetsSent;
    private final long ssrc;
    private final String type;
    private final boolean voiceActivityDetectorIsEnabled;
    private final long voiceActivityDetectorProcessTime;

    public OutboundRtpAudio(String str, long j, StatsCodec statsCodec, long j2, long j3, int i, float f, float f2, boolean z2, long j4, long j5, boolean z3, long j6, boolean z4, long j7) {
        Intrinsics3.checkNotNullParameter(str, "type");
        Intrinsics3.checkNotNullParameter(statsCodec, "codec");
        this.type = str;
        this.ssrc = j;
        this.codec = statsCodec;
        this.bytesSent = j2;
        this.packetsSent = j3;
        this.packetsLost = i;
        this.fractionLost = f;
        this.audioLevel = f2;
        this.audioDetected = z2;
        this.framesCaptured = j4;
        this.framesRendered = j5;
        this.noiseCancellerIsEnabled = z3;
        this.noiseCancellerProcessTime = j6;
        this.voiceActivityDetectorIsEnabled = z4;
        this.voiceActivityDetectorProcessTime = j7;
    }

    public static /* synthetic */ OutboundRtpAudio copy$default(OutboundRtpAudio outboundRtpAudio, String str, long j, StatsCodec statsCodec, long j2, long j3, int i, float f, float f2, boolean z2, long j4, long j5, boolean z3, long j6, boolean z4, long j7, int i2, Object obj) {
        return outboundRtpAudio.copy((i2 & 1) != 0 ? outboundRtpAudio.type : str, (i2 & 2) != 0 ? outboundRtpAudio.ssrc : j, (i2 & 4) != 0 ? outboundRtpAudio.codec : statsCodec, (i2 & 8) != 0 ? outboundRtpAudio.bytesSent : j2, (i2 & 16) != 0 ? outboundRtpAudio.packetsSent : j3, (i2 & 32) != 0 ? outboundRtpAudio.packetsLost : i, (i2 & 64) != 0 ? outboundRtpAudio.fractionLost : f, (i2 & 128) != 0 ? outboundRtpAudio.audioLevel : f2, (i2 & 256) != 0 ? outboundRtpAudio.audioDetected : z2, (i2 & 512) != 0 ? outboundRtpAudio.framesCaptured : j4, (i2 & 1024) != 0 ? outboundRtpAudio.framesRendered : j5, (i2 & 2048) != 0 ? outboundRtpAudio.noiseCancellerIsEnabled : z3, (i2 & 4096) != 0 ? outboundRtpAudio.noiseCancellerProcessTime : j6, (i2 & 8192) != 0 ? outboundRtpAudio.voiceActivityDetectorIsEnabled : z4, (i2 & 16384) != 0 ? outboundRtpAudio.voiceActivityDetectorProcessTime : j7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component10, reason: from getter */
    public final long getFramesCaptured() {
        return this.framesCaptured;
    }

    /* renamed from: component11, reason: from getter */
    public final long getFramesRendered() {
        return this.framesRendered;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getNoiseCancellerIsEnabled() {
        return this.noiseCancellerIsEnabled;
    }

    /* renamed from: component13, reason: from getter */
    public final long getNoiseCancellerProcessTime() {
        return this.noiseCancellerProcessTime;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getVoiceActivityDetectorIsEnabled() {
        return this.voiceActivityDetectorIsEnabled;
    }

    /* renamed from: component15, reason: from getter */
    public final long getVoiceActivityDetectorProcessTime() {
        return this.voiceActivityDetectorProcessTime;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
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
    public final float getAudioLevel() {
        return this.audioLevel;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getAudioDetected() {
        return this.audioDetected;
    }

    public final OutboundRtpAudio copy(String type, long ssrc, StatsCodec codec, long bytesSent, long packetsSent, int packetsLost, float fractionLost, float audioLevel, boolean audioDetected, long framesCaptured, long framesRendered, boolean noiseCancellerIsEnabled, long noiseCancellerProcessTime, boolean voiceActivityDetectorIsEnabled, long voiceActivityDetectorProcessTime) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(codec, "codec");
        return new OutboundRtpAudio(type, ssrc, codec, bytesSent, packetsSent, packetsLost, fractionLost, audioLevel, audioDetected, framesCaptured, framesRendered, noiseCancellerIsEnabled, noiseCancellerProcessTime, voiceActivityDetectorIsEnabled, voiceActivityDetectorProcessTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutboundRtpAudio)) {
            return false;
        }
        OutboundRtpAudio outboundRtpAudio = (OutboundRtpAudio) other;
        return Intrinsics3.areEqual(this.type, outboundRtpAudio.type) && this.ssrc == outboundRtpAudio.ssrc && Intrinsics3.areEqual(this.codec, outboundRtpAudio.codec) && this.bytesSent == outboundRtpAudio.bytesSent && this.packetsSent == outboundRtpAudio.packetsSent && this.packetsLost == outboundRtpAudio.packetsLost && Float.compare(this.fractionLost, outboundRtpAudio.fractionLost) == 0 && Float.compare(this.audioLevel, outboundRtpAudio.audioLevel) == 0 && this.audioDetected == outboundRtpAudio.audioDetected && this.framesCaptured == outboundRtpAudio.framesCaptured && this.framesRendered == outboundRtpAudio.framesRendered && this.noiseCancellerIsEnabled == outboundRtpAudio.noiseCancellerIsEnabled && this.noiseCancellerProcessTime == outboundRtpAudio.noiseCancellerProcessTime && this.voiceActivityDetectorIsEnabled == outboundRtpAudio.voiceActivityDetectorIsEnabled && this.voiceActivityDetectorProcessTime == outboundRtpAudio.voiceActivityDetectorProcessTime;
    }

    public final boolean getAudioDetected() {
        return this.audioDetected;
    }

    public final float getAudioLevel() {
        return this.audioLevel;
    }

    public final long getBytesSent() {
        return this.bytesSent;
    }

    public final StatsCodec getCodec() {
        return this.codec;
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

    public final boolean getNoiseCancellerIsEnabled() {
        return this.noiseCancellerIsEnabled;
    }

    public final long getNoiseCancellerProcessTime() {
        return this.noiseCancellerProcessTime;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsSent() {
        return this.packetsSent;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean getVoiceActivityDetectorIsEnabled() {
        return this.voiceActivityDetectorIsEnabled;
    }

    public final long getVoiceActivityDetectorProcessTime() {
        return this.voiceActivityDetectorProcessTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.type;
        int iA = (b.a(this.ssrc) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        StatsCodec statsCodec = this.codec;
        int iFloatToIntBits = (Float.floatToIntBits(this.audioLevel) + ((Float.floatToIntBits(this.fractionLost) + ((((b.a(this.packetsSent) + ((b.a(this.bytesSent) + ((iA + (statsCodec != null ? statsCodec.hashCode() : 0)) * 31)) * 31)) * 31) + this.packetsLost) * 31)) * 31)) * 31;
        boolean z2 = this.audioDetected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int iA2 = (b.a(this.framesRendered) + ((b.a(this.framesCaptured) + ((iFloatToIntBits + i) * 31)) * 31)) * 31;
        boolean z3 = this.noiseCancellerIsEnabled;
        int i2 = z3;
        if (z3 != 0) {
            i2 = 1;
        }
        int iA3 = (b.a(this.noiseCancellerProcessTime) + ((iA2 + i2) * 31)) * 31;
        boolean z4 = this.voiceActivityDetectorIsEnabled;
        return b.a(this.voiceActivityDetectorProcessTime) + ((iA3 + (z4 ? 1 : z4 ? 1 : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("OutboundRtpAudio(type=");
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
        sbU.append(", audioLevel=");
        sbU.append(this.audioLevel);
        sbU.append(", audioDetected=");
        sbU.append(this.audioDetected);
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
        return outline.C(sbU, this.voiceActivityDetectorProcessTime, ")");
    }
}
