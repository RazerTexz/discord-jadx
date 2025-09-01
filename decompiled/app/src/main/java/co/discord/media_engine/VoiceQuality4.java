package co.discord.media_engine;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: VoiceQuality.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JL\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lco/discord/media_engine/InboundBufferStats;", "", "Lco/discord/media_engine/PlayoutMetric;", "component1", "()Lco/discord/media_engine/PlayoutMetric;", "component2", "component3", "component4", "component5", "audioJitterBuffer", "audioJitterTarget", "audioJitterDelay", "relativeReceptionDelay", "relativePlayoutDelay", "copy", "(Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;)Lco/discord/media_engine/InboundBufferStats;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lco/discord/media_engine/PlayoutMetric;", "getRelativePlayoutDelay", "getAudioJitterBuffer", "getAudioJitterDelay", "getRelativeReceptionDelay", "getAudioJitterTarget", "<init>", "(Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;Lco/discord/media_engine/PlayoutMetric;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: co.discord.media_engine.InboundBufferStats, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class VoiceQuality4 {
    private final PlayoutMetric audioJitterBuffer;
    private final PlayoutMetric audioJitterDelay;
    private final PlayoutMetric audioJitterTarget;
    private final PlayoutMetric relativePlayoutDelay;
    private final PlayoutMetric relativeReceptionDelay;

    public VoiceQuality4(PlayoutMetric playoutMetric, PlayoutMetric playoutMetric2, PlayoutMetric playoutMetric3, PlayoutMetric playoutMetric4, PlayoutMetric playoutMetric5) {
        this.audioJitterBuffer = playoutMetric;
        this.audioJitterTarget = playoutMetric2;
        this.audioJitterDelay = playoutMetric3;
        this.relativeReceptionDelay = playoutMetric4;
        this.relativePlayoutDelay = playoutMetric5;
    }

    public static /* synthetic */ VoiceQuality4 copy$default(VoiceQuality4 voiceQuality4, PlayoutMetric playoutMetric, PlayoutMetric playoutMetric2, PlayoutMetric playoutMetric3, PlayoutMetric playoutMetric4, PlayoutMetric playoutMetric5, int i, Object obj) {
        if ((i & 1) != 0) {
            playoutMetric = voiceQuality4.audioJitterBuffer;
        }
        if ((i & 2) != 0) {
            playoutMetric2 = voiceQuality4.audioJitterTarget;
        }
        PlayoutMetric playoutMetric6 = playoutMetric2;
        if ((i & 4) != 0) {
            playoutMetric3 = voiceQuality4.audioJitterDelay;
        }
        PlayoutMetric playoutMetric7 = playoutMetric3;
        if ((i & 8) != 0) {
            playoutMetric4 = voiceQuality4.relativeReceptionDelay;
        }
        PlayoutMetric playoutMetric8 = playoutMetric4;
        if ((i & 16) != 0) {
            playoutMetric5 = voiceQuality4.relativePlayoutDelay;
        }
        return voiceQuality4.copy(playoutMetric, playoutMetric6, playoutMetric7, playoutMetric8, playoutMetric5);
    }

    /* renamed from: component1, reason: from getter */
    public final PlayoutMetric getAudioJitterBuffer() {
        return this.audioJitterBuffer;
    }

    /* renamed from: component2, reason: from getter */
    public final PlayoutMetric getAudioJitterTarget() {
        return this.audioJitterTarget;
    }

    /* renamed from: component3, reason: from getter */
    public final PlayoutMetric getAudioJitterDelay() {
        return this.audioJitterDelay;
    }

    /* renamed from: component4, reason: from getter */
    public final PlayoutMetric getRelativeReceptionDelay() {
        return this.relativeReceptionDelay;
    }

    /* renamed from: component5, reason: from getter */
    public final PlayoutMetric getRelativePlayoutDelay() {
        return this.relativePlayoutDelay;
    }

    public final VoiceQuality4 copy(PlayoutMetric audioJitterBuffer, PlayoutMetric audioJitterTarget, PlayoutMetric audioJitterDelay, PlayoutMetric relativeReceptionDelay, PlayoutMetric relativePlayoutDelay) {
        return new VoiceQuality4(audioJitterBuffer, audioJitterTarget, audioJitterDelay, relativeReceptionDelay, relativePlayoutDelay);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceQuality4)) {
            return false;
        }
        VoiceQuality4 voiceQuality4 = (VoiceQuality4) other;
        return Intrinsics3.areEqual(this.audioJitterBuffer, voiceQuality4.audioJitterBuffer) && Intrinsics3.areEqual(this.audioJitterTarget, voiceQuality4.audioJitterTarget) && Intrinsics3.areEqual(this.audioJitterDelay, voiceQuality4.audioJitterDelay) && Intrinsics3.areEqual(this.relativeReceptionDelay, voiceQuality4.relativeReceptionDelay) && Intrinsics3.areEqual(this.relativePlayoutDelay, voiceQuality4.relativePlayoutDelay);
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

    public final PlayoutMetric getRelativePlayoutDelay() {
        return this.relativePlayoutDelay;
    }

    public final PlayoutMetric getRelativeReceptionDelay() {
        return this.relativeReceptionDelay;
    }

    public int hashCode() {
        PlayoutMetric playoutMetric = this.audioJitterBuffer;
        int iHashCode = (playoutMetric != null ? playoutMetric.hashCode() : 0) * 31;
        PlayoutMetric playoutMetric2 = this.audioJitterTarget;
        int iHashCode2 = (iHashCode + (playoutMetric2 != null ? playoutMetric2.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric3 = this.audioJitterDelay;
        int iHashCode3 = (iHashCode2 + (playoutMetric3 != null ? playoutMetric3.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric4 = this.relativeReceptionDelay;
        int iHashCode4 = (iHashCode3 + (playoutMetric4 != null ? playoutMetric4.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric5 = this.relativePlayoutDelay;
        return iHashCode4 + (playoutMetric5 != null ? playoutMetric5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundBufferStats(audioJitterBuffer=");
        sbU.append(this.audioJitterBuffer);
        sbU.append(", audioJitterTarget=");
        sbU.append(this.audioJitterTarget);
        sbU.append(", audioJitterDelay=");
        sbU.append(this.audioJitterDelay);
        sbU.append(", relativeReceptionDelay=");
        sbU.append(this.relativeReceptionDelay);
        sbU.append(", relativePlayoutDelay=");
        sbU.append(this.relativePlayoutDelay);
        sbU.append(")");
        return sbU.toString();
    }
}
