package co.discord.media_engine;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: Statistics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012Jb\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u000eJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010\u000bR!\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b'\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b*\u0010\u0004R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\u000eR\u0019\u0010\u0014\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b-\u0010\u0007¨\u00060"}, d2 = {"Lco/discord/media_engine/Transport;", "", "", "component1", "()I", "", "component2", "()J", "component3", "component4", "component5", "()Ljava/lang/Integer;", "", "component6", "()Ljava/lang/String;", "", "Lco/discord/media_engine/ReceiverReport;", "component7", "()[Lco/discord/media_engine/ReceiverReport;", "availableOutgoingBitrate", "bytesReceived", "bytesSent", "ping", "decryptionFailures", "localAddress", "receiverReports", "copy", "(IJJILjava/lang/Integer;Ljava/lang/String;[Lco/discord/media_engine/ReceiverReport;)Lco/discord/media_engine/Transport;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getBytesSent", "Ljava/lang/Integer;", "getDecryptionFailures", "[Lco/discord/media_engine/ReceiverReport;", "getReceiverReports", "I", "getPing", "getAvailableOutgoingBitrate", "Ljava/lang/String;", "getLocalAddress", "getBytesReceived", "<init>", "(IJJILjava/lang/Integer;Ljava/lang/String;[Lco/discord/media_engine/ReceiverReport;)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Transport {
    private final int availableOutgoingBitrate;
    private final long bytesReceived;
    private final long bytesSent;
    private final Integer decryptionFailures;
    private final String localAddress;
    private final int ping;
    private final ReceiverReport[] receiverReports;

    public Transport(int i, long j, long j2, int i2, Integer num, String str, ReceiverReport[] receiverReportArr) {
        this.availableOutgoingBitrate = i;
        this.bytesReceived = j;
        this.bytesSent = j2;
        this.ping = i2;
        this.decryptionFailures = num;
        this.localAddress = str;
        this.receiverReports = receiverReportArr;
    }

    public static /* synthetic */ Transport copy$default(Transport transport, int i, long j, long j2, int i2, Integer num, String str, ReceiverReport[] receiverReportArr, int i3, Object obj) {
        return transport.copy((i3 & 1) != 0 ? transport.availableOutgoingBitrate : i, (i3 & 2) != 0 ? transport.bytesReceived : j, (i3 & 4) != 0 ? transport.bytesSent : j2, (i3 & 8) != 0 ? transport.ping : i2, (i3 & 16) != 0 ? transport.decryptionFailures : num, (i3 & 32) != 0 ? transport.localAddress : str, (i3 & 64) != 0 ? transport.receiverReports : receiverReportArr);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAvailableOutgoingBitrate() {
        return this.availableOutgoingBitrate;
    }

    /* renamed from: component2, reason: from getter */
    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    /* renamed from: component3, reason: from getter */
    public final long getBytesSent() {
        return this.bytesSent;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPing() {
        return this.ping;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getDecryptionFailures() {
        return this.decryptionFailures;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLocalAddress() {
        return this.localAddress;
    }

    /* renamed from: component7, reason: from getter */
    public final ReceiverReport[] getReceiverReports() {
        return this.receiverReports;
    }

    public final Transport copy(int availableOutgoingBitrate, long bytesReceived, long bytesSent, int ping, Integer decryptionFailures, String localAddress, ReceiverReport[] receiverReports) {
        return new Transport(availableOutgoingBitrate, bytesReceived, bytesSent, ping, decryptionFailures, localAddress, receiverReports);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Transport)) {
            return false;
        }
        Transport transport = (Transport) other;
        return this.availableOutgoingBitrate == transport.availableOutgoingBitrate && this.bytesReceived == transport.bytesReceived && this.bytesSent == transport.bytesSent && this.ping == transport.ping && Intrinsics3.areEqual(this.decryptionFailures, transport.decryptionFailures) && Intrinsics3.areEqual(this.localAddress, transport.localAddress) && Intrinsics3.areEqual(this.receiverReports, transport.receiverReports);
    }

    public final int getAvailableOutgoingBitrate() {
        return this.availableOutgoingBitrate;
    }

    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    public final long getBytesSent() {
        return this.bytesSent;
    }

    public final Integer getDecryptionFailures() {
        return this.decryptionFailures;
    }

    public final String getLocalAddress() {
        return this.localAddress;
    }

    public final int getPing() {
        return this.ping;
    }

    public final ReceiverReport[] getReceiverReports() {
        return this.receiverReports;
    }

    public int hashCode() {
        int iA = (((b.a(this.bytesSent) + ((b.a(this.bytesReceived) + (this.availableOutgoingBitrate * 31)) * 31)) * 31) + this.ping) * 31;
        Integer num = this.decryptionFailures;
        int iHashCode = (iA + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.localAddress;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        ReceiverReport[] receiverReportArr = this.receiverReports;
        return iHashCode2 + (receiverReportArr != null ? Arrays.hashCode(receiverReportArr) : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Transport(availableOutgoingBitrate=");
        sbU.append(this.availableOutgoingBitrate);
        sbU.append(", bytesReceived=");
        sbU.append(this.bytesReceived);
        sbU.append(", bytesSent=");
        sbU.append(this.bytesSent);
        sbU.append(", ping=");
        sbU.append(this.ping);
        sbU.append(", decryptionFailures=");
        sbU.append(this.decryptionFailures);
        sbU.append(", localAddress=");
        sbU.append(this.localAddress);
        sbU.append(", receiverReports=");
        sbU.append(Arrays.toString(this.receiverReports));
        sbU.append(")");
        return sbU.toString();
    }
}
