package com.discord.p000native.engine;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ConnectionInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u000bJ\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u0018\u0010\u000bR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\f\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/discord/native/engine/ConnectionInfo;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "", "component4", "()I", "isConnected", "protocol", "localAddress", "localPort", "copy", "(ZLjava/lang/String;Ljava/lang/String;I)Lcom/discord/native/engine/ConnectionInfo;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getLocalPort", "Ljava/lang/String;", "getProtocol", "getLocalAddress", "Z", "<init>", "(ZLjava/lang/String;Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ConnectionInfo {
    private final boolean isConnected;
    private final String localAddress;
    private final int localPort;
    private final String protocol;

    public ConnectionInfo(boolean z2, String str, String str2, int i) {
        Intrinsics3.checkNotNullParameter(str, "protocol");
        Intrinsics3.checkNotNullParameter(str2, "localAddress");
        this.isConnected = z2;
        this.protocol = str;
        this.localAddress = str2;
        this.localPort = i;
    }

    public static /* synthetic */ ConnectionInfo copy$default(ConnectionInfo connectionInfo, boolean z2, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = connectionInfo.isConnected;
        }
        if ((i2 & 2) != 0) {
            str = connectionInfo.protocol;
        }
        if ((i2 & 4) != 0) {
            str2 = connectionInfo.localAddress;
        }
        if ((i2 & 8) != 0) {
            i = connectionInfo.localPort;
        }
        return connectionInfo.copy(z2, str, str2, i);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsConnected() {
        return this.isConnected;
    }

    /* renamed from: component2, reason: from getter */
    public final String getProtocol() {
        return this.protocol;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLocalAddress() {
        return this.localAddress;
    }

    /* renamed from: component4, reason: from getter */
    public final int getLocalPort() {
        return this.localPort;
    }

    public final ConnectionInfo copy(boolean isConnected, String protocol, String localAddress, int localPort) {
        Intrinsics3.checkNotNullParameter(protocol, "protocol");
        Intrinsics3.checkNotNullParameter(localAddress, "localAddress");
        return new ConnectionInfo(isConnected, protocol, localAddress, localPort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectionInfo)) {
            return false;
        }
        ConnectionInfo connectionInfo = (ConnectionInfo) other;
        return this.isConnected == connectionInfo.isConnected && Intrinsics3.areEqual(this.protocol, connectionInfo.protocol) && Intrinsics3.areEqual(this.localAddress, connectionInfo.localAddress) && this.localPort == connectionInfo.localPort;
    }

    public final String getLocalAddress() {
        return this.localAddress;
    }

    public final int getLocalPort() {
        return this.localPort;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z2 = this.isConnected;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.protocol;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.localAddress;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.localPort;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ConnectionInfo(isConnected=");
        sbU.append(this.isConnected);
        sbU.append(", protocol=");
        sbU.append(this.protocol);
        sbU.append(", localAddress=");
        sbU.append(this.localAddress);
        sbU.append(", localPort=");
        return outline.B(sbU, this.localPort, ")");
    }
}
