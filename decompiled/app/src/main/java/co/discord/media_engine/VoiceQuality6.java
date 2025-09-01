package co.discord.media_engine;

import a0.a.a.b;
import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: VoiceQuality.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lco/discord/media_engine/OutboundAudio;", "", "", "component1", "()J", "", "component2", "()I", "packetsSent", "packetsLost", "copy", "(JI)Lco/discord/media_engine/OutboundAudio;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getPacketsLost", "J", "getPacketsSent", "<init>", "(JI)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: co.discord.media_engine.OutboundAudio, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class VoiceQuality6 {
    private final int packetsLost;
    private final long packetsSent;

    public VoiceQuality6(long j, int i) {
        this.packetsSent = j;
        this.packetsLost = i;
    }

    public static /* synthetic */ VoiceQuality6 copy$default(VoiceQuality6 voiceQuality6, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = voiceQuality6.packetsSent;
        }
        if ((i2 & 2) != 0) {
            i = voiceQuality6.packetsLost;
        }
        return voiceQuality6.copy(j, i);
    }

    /* renamed from: component1, reason: from getter */
    public final long getPacketsSent() {
        return this.packetsSent;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final VoiceQuality6 copy(long packetsSent, int packetsLost) {
        return new VoiceQuality6(packetsSent, packetsLost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceQuality6)) {
            return false;
        }
        VoiceQuality6 voiceQuality6 = (VoiceQuality6) other;
        return this.packetsSent == voiceQuality6.packetsSent && this.packetsLost == voiceQuality6.packetsLost;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsSent() {
        return this.packetsSent;
    }

    public int hashCode() {
        return (b.a(this.packetsSent) * 31) + this.packetsLost;
    }

    public String toString() {
        StringBuilder sbU = outline.U("OutboundAudio(packetsSent=");
        sbU.append(this.packetsSent);
        sbU.append(", packetsLost=");
        return outline.B(sbU, this.packetsLost, ")");
    }
}
