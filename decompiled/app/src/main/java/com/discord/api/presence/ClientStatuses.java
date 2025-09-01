package com.discord.api.presence;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ClientStatuses.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/discord/api/presence/ClientStatuses;", "", "Lcom/discord/api/presence/ClientStatus;", "a", "()Lcom/discord/api/presence/ClientStatus;", "c", "b", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "desktop", "Lcom/discord/api/presence/ClientStatus;", "web", "mobile", "<init>", "(Lcom/discord/api/presence/ClientStatus;Lcom/discord/api/presence/ClientStatus;Lcom/discord/api/presence/ClientStatus;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ClientStatuses {
    private final ClientStatus desktop;
    private final ClientStatus mobile;
    private final ClientStatus web;

    public ClientStatuses(ClientStatus clientStatus, ClientStatus clientStatus2, ClientStatus clientStatus3) {
        this.desktop = clientStatus;
        this.web = clientStatus2;
        this.mobile = clientStatus3;
    }

    public final ClientStatus a() {
        ClientStatus clientStatus = this.desktop;
        return clientStatus != null ? clientStatus : ClientStatus.OFFLINE;
    }

    public final ClientStatus b() {
        ClientStatus clientStatus = this.mobile;
        return clientStatus != null ? clientStatus : ClientStatus.OFFLINE;
    }

    public final ClientStatus c() {
        ClientStatus clientStatus = this.web;
        return clientStatus != null ? clientStatus : ClientStatus.OFFLINE;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClientStatuses)) {
            return false;
        }
        ClientStatuses clientStatuses = (ClientStatuses) other;
        return Intrinsics3.areEqual(this.desktop, clientStatuses.desktop) && Intrinsics3.areEqual(this.web, clientStatuses.web) && Intrinsics3.areEqual(this.mobile, clientStatuses.mobile);
    }

    public int hashCode() {
        ClientStatus clientStatus = this.desktop;
        int iHashCode = (clientStatus != null ? clientStatus.hashCode() : 0) * 31;
        ClientStatus clientStatus2 = this.web;
        int iHashCode2 = (iHashCode + (clientStatus2 != null ? clientStatus2.hashCode() : 0)) * 31;
        ClientStatus clientStatus3 = this.mobile;
        return iHashCode2 + (clientStatus3 != null ? clientStatus3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ClientStatuses(desktop=");
        sbU.append(this.desktop);
        sbU.append(", web=");
        sbU.append(this.web);
        sbU.append(", mobile=");
        sbU.append(this.mobile);
        sbU.append(")");
        return sbU.toString();
    }
}
