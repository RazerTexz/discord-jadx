package co.discord.media_engine.internal;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJF\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\nR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\u0004R!\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\u000e¨\u0006)"}, d2 = {"Lco/discord/media_engine/internal/NativeStats;", "", "Lco/discord/media_engine/internal/Transport;", "component1", "()Lco/discord/media_engine/internal/Transport;", "Lco/discord/media_engine/internal/Outbound;", "component2", "()Lco/discord/media_engine/internal/Outbound;", "Lco/discord/media_engine/internal/Screenshare;", "component3", "()Lco/discord/media_engine/internal/Screenshare;", "", "Lco/discord/media_engine/internal/Inbound;", "component4", "()[Lco/discord/media_engine/internal/Inbound;", NotificationCompat.CATEGORY_TRANSPORT, "outbound", "screenshare", "inbound", "copy", "(Lco/discord/media_engine/internal/Transport;Lco/discord/media_engine/internal/Outbound;Lco/discord/media_engine/internal/Screenshare;[Lco/discord/media_engine/internal/Inbound;)Lco/discord/media_engine/internal/NativeStats;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lco/discord/media_engine/internal/Outbound;", "getOutbound", "Lco/discord/media_engine/internal/Screenshare;", "getScreenshare", "Lco/discord/media_engine/internal/Transport;", "getTransport", "[Lco/discord/media_engine/internal/Inbound;", "getInbound", "<init>", "(Lco/discord/media_engine/internal/Transport;Lco/discord/media_engine/internal/Outbound;Lco/discord/media_engine/internal/Screenshare;[Lco/discord/media_engine/internal/Inbound;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class NativeStats {
    private final Inbound[] inbound;
    private final Outbound outbound;
    private final Screenshare screenshare;
    private final Transport transport;

    public NativeStats(Transport transport, Outbound outbound, Screenshare screenshare, Inbound[] inboundArr) {
        this.transport = transport;
        this.outbound = outbound;
        this.screenshare = screenshare;
        this.inbound = inboundArr;
    }

    public static /* synthetic */ NativeStats copy$default(NativeStats nativeStats, Transport transport, Outbound outbound, Screenshare screenshare, Inbound[] inboundArr, int i, Object obj) {
        if ((i & 1) != 0) {
            transport = nativeStats.transport;
        }
        if ((i & 2) != 0) {
            outbound = nativeStats.outbound;
        }
        if ((i & 4) != 0) {
            screenshare = nativeStats.screenshare;
        }
        if ((i & 8) != 0) {
            inboundArr = nativeStats.inbound;
        }
        return nativeStats.copy(transport, outbound, screenshare, inboundArr);
    }

    /* renamed from: component1, reason: from getter */
    public final Transport getTransport() {
        return this.transport;
    }

    /* renamed from: component2, reason: from getter */
    public final Outbound getOutbound() {
        return this.outbound;
    }

    /* renamed from: component3, reason: from getter */
    public final Screenshare getScreenshare() {
        return this.screenshare;
    }

    /* renamed from: component4, reason: from getter */
    public final Inbound[] getInbound() {
        return this.inbound;
    }

    public final NativeStats copy(Transport transport, Outbound outbound, Screenshare screenshare, Inbound[] inbound) {
        return new NativeStats(transport, outbound, screenshare, inbound);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeStats)) {
            return false;
        }
        NativeStats nativeStats = (NativeStats) other;
        return Intrinsics3.areEqual(this.transport, nativeStats.transport) && Intrinsics3.areEqual(this.outbound, nativeStats.outbound) && Intrinsics3.areEqual(this.screenshare, nativeStats.screenshare) && Intrinsics3.areEqual(this.inbound, nativeStats.inbound);
    }

    public final Inbound[] getInbound() {
        return this.inbound;
    }

    public final Outbound getOutbound() {
        return this.outbound;
    }

    public final Screenshare getScreenshare() {
        return this.screenshare;
    }

    public final Transport getTransport() {
        return this.transport;
    }

    public int hashCode() {
        Transport transport = this.transport;
        int iHashCode = (transport != null ? transport.hashCode() : 0) * 31;
        Outbound outbound = this.outbound;
        int iHashCode2 = (iHashCode + (outbound != null ? outbound.hashCode() : 0)) * 31;
        Screenshare screenshare = this.screenshare;
        int iHashCode3 = (iHashCode2 + (screenshare != null ? screenshare.hashCode() : 0)) * 31;
        Inbound[] inboundArr = this.inbound;
        return iHashCode3 + (inboundArr != null ? Arrays.hashCode(inboundArr) : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("NativeStats(transport=");
        sbU.append(this.transport);
        sbU.append(", outbound=");
        sbU.append(this.outbound);
        sbU.append(", screenshare=");
        sbU.append(this.screenshare);
        sbU.append(", inbound=");
        sbU.append(Arrays.toString(this.inbound));
        sbU.append(")");
        return sbU.toString();
    }
}
