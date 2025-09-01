package co.discord.media_engine;

import a0.a.a.a;
import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: VoiceQuality.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\r\u0012\u0006\u0010\u001c\u001a\u00020\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0013¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015Jf\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\n2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\r2\b\b\u0002\u0010\u001c\u001a\u00020\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b#\u0010\fJ\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b)\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b-\u0010\bR\u0019\u0010\u001a\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b/\u0010\fR\u0019\u0010\u0019\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b0\u0010\bR\u0019\u0010\u001d\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00101\u001a\u0004\b2\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00103\u001a\u0004\b4\u0010\u0012R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b5\u0010\u0004¨\u00068"}, d2 = {"Lco/discord/media_engine/InboundAudio;", "", "", "component1", "()J", "component2", "", "component3", "()D", "component4", "", "component5", "()I", "", "component6", "()[Ljava/lang/Integer;", "Lco/discord/media_engine/InboundBufferStats;", "component7", "()Lco/discord/media_engine/InboundBufferStats;", "Lco/discord/media_engine/InboundFrameOpStats;", "component8", "()Lco/discord/media_engine/InboundFrameOpStats;", "packetsReceived", "packetsLost", "mos", "mosSum", "mosCount", "mosBuckets", "bufferStats", "frameOpStats", "copy", "(JJDDI[Ljava/lang/Integer;Lco/discord/media_engine/InboundBufferStats;Lco/discord/media_engine/InboundFrameOpStats;)Lco/discord/media_engine/InboundAudio;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "[Ljava/lang/Integer;", "getMosBuckets", "J", "getPacketsReceived", "D", "getMos", "I", "getMosCount", "getMosSum", "Lco/discord/media_engine/InboundFrameOpStats;", "getFrameOpStats", "Lco/discord/media_engine/InboundBufferStats;", "getBufferStats", "getPacketsLost", "<init>", "(JJDDI[Ljava/lang/Integer;Lco/discord/media_engine/InboundBufferStats;Lco/discord/media_engine/InboundFrameOpStats;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: co.discord.media_engine.InboundAudio, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class VoiceQuality3 {
    private final VoiceQuality4 bufferStats;
    private final VoiceQuality5 frameOpStats;
    private final double mos;
    private final Integer[] mosBuckets;
    private final int mosCount;
    private final double mosSum;
    private final long packetsLost;
    private final long packetsReceived;

    public VoiceQuality3(long j, long j2, double d, double d2, int i, Integer[] numArr, VoiceQuality4 voiceQuality4, VoiceQuality5 voiceQuality5) {
        Intrinsics3.checkNotNullParameter(numArr, "mosBuckets");
        Intrinsics3.checkNotNullParameter(voiceQuality4, "bufferStats");
        Intrinsics3.checkNotNullParameter(voiceQuality5, "frameOpStats");
        this.packetsReceived = j;
        this.packetsLost = j2;
        this.mos = d;
        this.mosSum = d2;
        this.mosCount = i;
        this.mosBuckets = numArr;
        this.bufferStats = voiceQuality4;
        this.frameOpStats = voiceQuality5;
    }

    public static /* synthetic */ VoiceQuality3 copy$default(VoiceQuality3 voiceQuality3, long j, long j2, double d, double d2, int i, Integer[] numArr, VoiceQuality4 voiceQuality4, VoiceQuality5 voiceQuality5, int i2, Object obj) {
        return voiceQuality3.copy((i2 & 1) != 0 ? voiceQuality3.packetsReceived : j, (i2 & 2) != 0 ? voiceQuality3.packetsLost : j2, (i2 & 4) != 0 ? voiceQuality3.mos : d, (i2 & 8) != 0 ? voiceQuality3.mosSum : d2, (i2 & 16) != 0 ? voiceQuality3.mosCount : i, (i2 & 32) != 0 ? voiceQuality3.mosBuckets : numArr, (i2 & 64) != 0 ? voiceQuality3.bufferStats : voiceQuality4, (i2 & 128) != 0 ? voiceQuality3.frameOpStats : voiceQuality5);
    }

    /* renamed from: component1, reason: from getter */
    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    /* renamed from: component2, reason: from getter */
    public final long getPacketsLost() {
        return this.packetsLost;
    }

    /* renamed from: component3, reason: from getter */
    public final double getMos() {
        return this.mos;
    }

    /* renamed from: component4, reason: from getter */
    public final double getMosSum() {
        return this.mosSum;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMosCount() {
        return this.mosCount;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer[] getMosBuckets() {
        return this.mosBuckets;
    }

    /* renamed from: component7, reason: from getter */
    public final VoiceQuality4 getBufferStats() {
        return this.bufferStats;
    }

    /* renamed from: component8, reason: from getter */
    public final VoiceQuality5 getFrameOpStats() {
        return this.frameOpStats;
    }

    public final VoiceQuality3 copy(long packetsReceived, long packetsLost, double mos, double mosSum, int mosCount, Integer[] mosBuckets, VoiceQuality4 bufferStats, VoiceQuality5 frameOpStats) {
        Intrinsics3.checkNotNullParameter(mosBuckets, "mosBuckets");
        Intrinsics3.checkNotNullParameter(bufferStats, "bufferStats");
        Intrinsics3.checkNotNullParameter(frameOpStats, "frameOpStats");
        return new VoiceQuality3(packetsReceived, packetsLost, mos, mosSum, mosCount, mosBuckets, bufferStats, frameOpStats);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceQuality3)) {
            return false;
        }
        VoiceQuality3 voiceQuality3 = (VoiceQuality3) other;
        return this.packetsReceived == voiceQuality3.packetsReceived && this.packetsLost == voiceQuality3.packetsLost && Double.compare(this.mos, voiceQuality3.mos) == 0 && Double.compare(this.mosSum, voiceQuality3.mosSum) == 0 && this.mosCount == voiceQuality3.mosCount && Intrinsics3.areEqual(this.mosBuckets, voiceQuality3.mosBuckets) && Intrinsics3.areEqual(this.bufferStats, voiceQuality3.bufferStats) && Intrinsics3.areEqual(this.frameOpStats, voiceQuality3.frameOpStats);
    }

    public final VoiceQuality4 getBufferStats() {
        return this.bufferStats;
    }

    public final VoiceQuality5 getFrameOpStats() {
        return this.frameOpStats;
    }

    public final double getMos() {
        return this.mos;
    }

    public final Integer[] getMosBuckets() {
        return this.mosBuckets;
    }

    public final int getMosCount() {
        return this.mosCount;
    }

    public final double getMosSum() {
        return this.mosSum;
    }

    public final long getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    public int hashCode() {
        int iA = (((a.a(this.mosSum) + ((a.a(this.mos) + ((b.a(this.packetsLost) + (b.a(this.packetsReceived) * 31)) * 31)) * 31)) * 31) + this.mosCount) * 31;
        Integer[] numArr = this.mosBuckets;
        int iHashCode = (iA + (numArr != null ? Arrays.hashCode(numArr) : 0)) * 31;
        VoiceQuality4 voiceQuality4 = this.bufferStats;
        int iHashCode2 = (iHashCode + (voiceQuality4 != null ? voiceQuality4.hashCode() : 0)) * 31;
        VoiceQuality5 voiceQuality5 = this.frameOpStats;
        return iHashCode2 + (voiceQuality5 != null ? voiceQuality5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundAudio(packetsReceived=");
        sbU.append(this.packetsReceived);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", mos=");
        sbU.append(this.mos);
        sbU.append(", mosSum=");
        sbU.append(this.mosSum);
        sbU.append(", mosCount=");
        sbU.append(this.mosCount);
        sbU.append(", mosBuckets=");
        sbU.append(Arrays.toString(this.mosBuckets));
        sbU.append(", bufferStats=");
        sbU.append(this.bufferStats);
        sbU.append(", frameOpStats=");
        sbU.append(this.frameOpStats);
        sbU.append(")");
        return sbU.toString();
    }
}
