package co.discord.media_engine;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: Statistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\u0004\b+\u0010,J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ`\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u000bHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010\nR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\u0004R%\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010\u000fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010\u0007R%\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00100\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b*\u0010\u000f¨\u0006-"}, d2 = {"Lco/discord/media_engine/Stats;", "", "Lco/discord/media_engine/Transport;", "component1", "()Lco/discord/media_engine/Transport;", "Lco/discord/media_engine/OutboundRtpAudio;", "component2", "()Lco/discord/media_engine/OutboundRtpAudio;", "Lco/discord/media_engine/OutboundRtpVideo;", "component3", "()Lco/discord/media_engine/OutboundRtpVideo;", "", "", "Lco/discord/media_engine/InboundRtpAudio;", "component4", "()Ljava/util/Map;", "Lco/discord/media_engine/InboundRtpVideo;", "component5", NotificationCompat.CATEGORY_TRANSPORT, "outboundRtpAudio", "outboundRtpVideo", "inboundRtpAudio", "inboundRtpVideo", "copy", "(Lco/discord/media_engine/Transport;Lco/discord/media_engine/OutboundRtpAudio;Lco/discord/media_engine/OutboundRtpVideo;Ljava/util/Map;Ljava/util/Map;)Lco/discord/media_engine/Stats;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lco/discord/media_engine/OutboundRtpVideo;", "getOutboundRtpVideo", "Lco/discord/media_engine/Transport;", "getTransport", "Ljava/util/Map;", "getInboundRtpAudio", "Lco/discord/media_engine/OutboundRtpAudio;", "getOutboundRtpAudio", "getInboundRtpVideo", "<init>", "(Lco/discord/media_engine/Transport;Lco/discord/media_engine/OutboundRtpAudio;Lco/discord/media_engine/OutboundRtpVideo;Ljava/util/Map;Ljava/util/Map;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Stats {
    private final Map<String, InboundRtpAudio> inboundRtpAudio;
    private final Map<String, InboundRtpVideo> inboundRtpVideo;
    private final OutboundRtpAudio outboundRtpAudio;
    private final OutboundRtpVideo outboundRtpVideo;
    private final Transport transport;

    public Stats(Transport transport, OutboundRtpAudio outboundRtpAudio, OutboundRtpVideo outboundRtpVideo, Map<String, InboundRtpAudio> map, Map<String, InboundRtpVideo> map2) {
        Intrinsics3.checkNotNullParameter(map, "inboundRtpAudio");
        Intrinsics3.checkNotNullParameter(map2, "inboundRtpVideo");
        this.transport = transport;
        this.outboundRtpAudio = outboundRtpAudio;
        this.outboundRtpVideo = outboundRtpVideo;
        this.inboundRtpAudio = map;
        this.inboundRtpVideo = map2;
    }

    public static /* synthetic */ Stats copy$default(Stats stats, Transport transport, OutboundRtpAudio outboundRtpAudio, OutboundRtpVideo outboundRtpVideo, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            transport = stats.transport;
        }
        if ((i & 2) != 0) {
            outboundRtpAudio = stats.outboundRtpAudio;
        }
        OutboundRtpAudio outboundRtpAudio2 = outboundRtpAudio;
        if ((i & 4) != 0) {
            outboundRtpVideo = stats.outboundRtpVideo;
        }
        OutboundRtpVideo outboundRtpVideo2 = outboundRtpVideo;
        if ((i & 8) != 0) {
            map = stats.inboundRtpAudio;
        }
        Map map3 = map;
        if ((i & 16) != 0) {
            map2 = stats.inboundRtpVideo;
        }
        return stats.copy(transport, outboundRtpAudio2, outboundRtpVideo2, map3, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final Transport getTransport() {
        return this.transport;
    }

    /* renamed from: component2, reason: from getter */
    public final OutboundRtpAudio getOutboundRtpAudio() {
        return this.outboundRtpAudio;
    }

    /* renamed from: component3, reason: from getter */
    public final OutboundRtpVideo getOutboundRtpVideo() {
        return this.outboundRtpVideo;
    }

    public final Map<String, InboundRtpAudio> component4() {
        return this.inboundRtpAudio;
    }

    public final Map<String, InboundRtpVideo> component5() {
        return this.inboundRtpVideo;
    }

    public final Stats copy(Transport transport, OutboundRtpAudio outboundRtpAudio, OutboundRtpVideo outboundRtpVideo, Map<String, InboundRtpAudio> inboundRtpAudio, Map<String, InboundRtpVideo> inboundRtpVideo) {
        Intrinsics3.checkNotNullParameter(inboundRtpAudio, "inboundRtpAudio");
        Intrinsics3.checkNotNullParameter(inboundRtpVideo, "inboundRtpVideo");
        return new Stats(transport, outboundRtpAudio, outboundRtpVideo, inboundRtpAudio, inboundRtpVideo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Stats)) {
            return false;
        }
        Stats stats = (Stats) other;
        return Intrinsics3.areEqual(this.transport, stats.transport) && Intrinsics3.areEqual(this.outboundRtpAudio, stats.outboundRtpAudio) && Intrinsics3.areEqual(this.outboundRtpVideo, stats.outboundRtpVideo) && Intrinsics3.areEqual(this.inboundRtpAudio, stats.inboundRtpAudio) && Intrinsics3.areEqual(this.inboundRtpVideo, stats.inboundRtpVideo);
    }

    public final Map<String, InboundRtpAudio> getInboundRtpAudio() {
        return this.inboundRtpAudio;
    }

    public final Map<String, InboundRtpVideo> getInboundRtpVideo() {
        return this.inboundRtpVideo;
    }

    public final OutboundRtpAudio getOutboundRtpAudio() {
        return this.outboundRtpAudio;
    }

    public final OutboundRtpVideo getOutboundRtpVideo() {
        return this.outboundRtpVideo;
    }

    public final Transport getTransport() {
        return this.transport;
    }

    public int hashCode() {
        Transport transport = this.transport;
        int iHashCode = (transport != null ? transport.hashCode() : 0) * 31;
        OutboundRtpAudio outboundRtpAudio = this.outboundRtpAudio;
        int iHashCode2 = (iHashCode + (outboundRtpAudio != null ? outboundRtpAudio.hashCode() : 0)) * 31;
        OutboundRtpVideo outboundRtpVideo = this.outboundRtpVideo;
        int iHashCode3 = (iHashCode2 + (outboundRtpVideo != null ? outboundRtpVideo.hashCode() : 0)) * 31;
        Map<String, InboundRtpAudio> map = this.inboundRtpAudio;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, InboundRtpVideo> map2 = this.inboundRtpVideo;
        return iHashCode4 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Stats(transport=");
        sbU.append(this.transport);
        sbU.append(", outboundRtpAudio=");
        sbU.append(this.outboundRtpAudio);
        sbU.append(", outboundRtpVideo=");
        sbU.append(this.outboundRtpVideo);
        sbU.append(", inboundRtpAudio=");
        sbU.append(this.inboundRtpAudio);
        sbU.append(", inboundRtpVideo=");
        return outline.M(sbU, this.inboundRtpVideo, ")");
    }
}
