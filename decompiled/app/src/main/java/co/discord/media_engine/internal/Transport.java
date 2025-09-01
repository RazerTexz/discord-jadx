package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.outline;
import co.discord.media_engine.ReceiverReport;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: NativeStatistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0080\b\u0018\u00002\u00020\u0001B[\u0012\n\u0010\u0015\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0016\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\u0017\u001a\u00060\u0002j\u0002`\n\u0012\n\u0010\u0018\u001a\u00060\u0006j\u0002`\u0007\u0012\n\u0010\u0019\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b/\u00100J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000b\u001a\u00060\u0002j\u0002`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0014\u0010\f\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\tJ\u0014\u0010\r\u001a\u00060\u0006j\u0002`\u0007HÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014Jr\u0010\u001c\u001a\u00020\u00002\f\b\u0002\u0010\u0015\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u0016\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u0010\u0017\u001a\u00060\u0002j\u0002`\n2\f\b\u0002\u0010\u0018\u001a\u00060\u0006j\u0002`\u00072\f\b\u0002\u0010\u0019\u001a\u00060\u0006j\u0002`\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0010J\u0010\u0010\u001f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001f\u0010\tJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001d\u0010\u0018\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b%\u0010\tR\u001d\u0010\u0015\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010\u0005R\u0019\u0010\u001a\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b)\u0010\u0010R\u001d\u0010\u0019\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b*\u0010\tR\u001d\u0010\u0016\u001a\u00060\u0006j\u0002`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b+\u0010\tR!\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b-\u0010\u0014R\u001d\u0010\u0017\u001a\u00060\u0002j\u0002`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b.\u0010\u0005¨\u00061"}, d2 = {"Lco/discord/media_engine/internal/Transport;", "", "", "Lco/discord/media_engine/internal/U32;", "component1", "()J", "", "Lco/discord/media_engine/internal/I32;", "component2", "()I", "Lco/discord/media_engine/internal/I64;", "component3", "component4", "component5", "", "component6", "()Ljava/lang/String;", "", "Lco/discord/media_engine/ReceiverReport;", "component7", "()[Lco/discord/media_engine/ReceiverReport;", "decryptionFailures", "maxPaddingBitrate", "pacerDelay", "rtt", "sendBandwidth", "localAddress", "receiverReports", "copy", "(JIJIILjava/lang/String;[Lco/discord/media_engine/ReceiverReport;)Lco/discord/media_engine/internal/Transport;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getRtt", "J", "getDecryptionFailures", "Ljava/lang/String;", "getLocalAddress", "getSendBandwidth", "getMaxPaddingBitrate", "[Lco/discord/media_engine/ReceiverReport;", "getReceiverReports", "getPacerDelay", "<init>", "(JIJIILjava/lang/String;[Lco/discord/media_engine/ReceiverReport;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Transport {
    private final long decryptionFailures;
    private final String localAddress;
    private final int maxPaddingBitrate;
    private final long pacerDelay;
    private final ReceiverReport[] receiverReports;
    private final int rtt;
    private final int sendBandwidth;

    public Transport(long j, int i, long j2, int i2, int i3, String str, ReceiverReport[] receiverReportArr) {
        Intrinsics3.checkNotNullParameter(str, "localAddress");
        this.decryptionFailures = j;
        this.maxPaddingBitrate = i;
        this.pacerDelay = j2;
        this.rtt = i2;
        this.sendBandwidth = i3;
        this.localAddress = str;
        this.receiverReports = receiverReportArr;
    }

    public static /* synthetic */ Transport copy$default(Transport transport, long j, int i, long j2, int i2, int i3, String str, ReceiverReport[] receiverReportArr, int i4, Object obj) {
        return transport.copy((i4 & 1) != 0 ? transport.decryptionFailures : j, (i4 & 2) != 0 ? transport.maxPaddingBitrate : i, (i4 & 4) != 0 ? transport.pacerDelay : j2, (i4 & 8) != 0 ? transport.rtt : i2, (i4 & 16) != 0 ? transport.sendBandwidth : i3, (i4 & 32) != 0 ? transport.localAddress : str, (i4 & 64) != 0 ? transport.receiverReports : receiverReportArr);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDecryptionFailures() {
        return this.decryptionFailures;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMaxPaddingBitrate() {
        return this.maxPaddingBitrate;
    }

    /* renamed from: component3, reason: from getter */
    public final long getPacerDelay() {
        return this.pacerDelay;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRtt() {
        return this.rtt;
    }

    /* renamed from: component5, reason: from getter */
    public final int getSendBandwidth() {
        return this.sendBandwidth;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLocalAddress() {
        return this.localAddress;
    }

    /* renamed from: component7, reason: from getter */
    public final ReceiverReport[] getReceiverReports() {
        return this.receiverReports;
    }

    public final Transport copy(long decryptionFailures, int maxPaddingBitrate, long pacerDelay, int rtt, int sendBandwidth, String localAddress, ReceiverReport[] receiverReports) {
        Intrinsics3.checkNotNullParameter(localAddress, "localAddress");
        return new Transport(decryptionFailures, maxPaddingBitrate, pacerDelay, rtt, sendBandwidth, localAddress, receiverReports);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Transport)) {
            return false;
        }
        Transport transport = (Transport) other;
        return this.decryptionFailures == transport.decryptionFailures && this.maxPaddingBitrate == transport.maxPaddingBitrate && this.pacerDelay == transport.pacerDelay && this.rtt == transport.rtt && this.sendBandwidth == transport.sendBandwidth && Intrinsics3.areEqual(this.localAddress, transport.localAddress) && Intrinsics3.areEqual(this.receiverReports, transport.receiverReports);
    }

    public final long getDecryptionFailures() {
        return this.decryptionFailures;
    }

    public final String getLocalAddress() {
        return this.localAddress;
    }

    public final int getMaxPaddingBitrate() {
        return this.maxPaddingBitrate;
    }

    public final long getPacerDelay() {
        return this.pacerDelay;
    }

    public final ReceiverReport[] getReceiverReports() {
        return this.receiverReports;
    }

    public final int getRtt() {
        return this.rtt;
    }

    public final int getSendBandwidth() {
        return this.sendBandwidth;
    }

    public int hashCode() {
        int iA = (((((b.a(this.pacerDelay) + (((b.a(this.decryptionFailures) * 31) + this.maxPaddingBitrate) * 31)) * 31) + this.rtt) * 31) + this.sendBandwidth) * 31;
        String str = this.localAddress;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        ReceiverReport[] receiverReportArr = this.receiverReports;
        return iHashCode + (receiverReportArr != null ? Arrays.hashCode(receiverReportArr) : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Transport(decryptionFailures=");
        sbU.append(this.decryptionFailures);
        sbU.append(", maxPaddingBitrate=");
        sbU.append(this.maxPaddingBitrate);
        sbU.append(", pacerDelay=");
        sbU.append(this.pacerDelay);
        sbU.append(", rtt=");
        sbU.append(this.rtt);
        sbU.append(", sendBandwidth=");
        sbU.append(this.sendBandwidth);
        sbU.append(", localAddress=");
        sbU.append(this.localAddress);
        sbU.append(", receiverReports=");
        sbU.append(Arrays.toString(this.receiverReports));
        sbU.append(")");
        return sbU.toString();
    }
}
