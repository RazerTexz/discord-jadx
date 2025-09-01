package com.discord.models.presence;

import b.d.b.a.outline;
import com.discord.api.activity.Activity;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.ClientStatuses;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Presence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u000b¨\u0006#"}, d2 = {"Lcom/discord/models/presence/Presence;", "", "Lcom/discord/api/presence/ClientStatus;", "component1", "()Lcom/discord/api/presence/ClientStatus;", "Lcom/discord/api/presence/ClientStatuses;", "component2", "()Lcom/discord/api/presence/ClientStatuses;", "", "Lcom/discord/api/activity/Activity;", "component3", "()Ljava/util/List;", "status", "clientStatuses", "activities", "copy", "(Lcom/discord/api/presence/ClientStatus;Lcom/discord/api/presence/ClientStatuses;Ljava/util/List;)Lcom/discord/models/presence/Presence;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/presence/ClientStatuses;", "getClientStatuses", "Lcom/discord/api/presence/ClientStatus;", "getStatus", "Ljava/util/List;", "getActivities", "<init>", "(Lcom/discord/api/presence/ClientStatus;Lcom/discord/api/presence/ClientStatuses;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Presence {
    private final List<Activity> activities;
    private final ClientStatuses clientStatuses;
    private final ClientStatus status;

    public Presence(ClientStatus clientStatus, ClientStatuses clientStatuses, List<Activity> list) {
        Intrinsics3.checkNotNullParameter(clientStatus, "status");
        this.status = clientStatus;
        this.clientStatuses = clientStatuses;
        this.activities = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Presence copy$default(Presence presence, ClientStatus clientStatus, ClientStatuses clientStatuses, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            clientStatus = presence.status;
        }
        if ((i & 2) != 0) {
            clientStatuses = presence.clientStatuses;
        }
        if ((i & 4) != 0) {
            list = presence.activities;
        }
        return presence.copy(clientStatus, clientStatuses, list);
    }

    /* renamed from: component1, reason: from getter */
    public final ClientStatus getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final ClientStatuses getClientStatuses() {
        return this.clientStatuses;
    }

    public final List<Activity> component3() {
        return this.activities;
    }

    public final Presence copy(ClientStatus status, ClientStatuses clientStatuses, List<Activity> activities) {
        Intrinsics3.checkNotNullParameter(status, "status");
        return new Presence(status, clientStatuses, activities);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Presence)) {
            return false;
        }
        Presence presence = (Presence) other;
        return Intrinsics3.areEqual(this.status, presence.status) && Intrinsics3.areEqual(this.clientStatuses, presence.clientStatuses) && Intrinsics3.areEqual(this.activities, presence.activities);
    }

    public final List<Activity> getActivities() {
        return this.activities;
    }

    public final ClientStatuses getClientStatuses() {
        return this.clientStatuses;
    }

    public final ClientStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        ClientStatus clientStatus = this.status;
        int iHashCode = (clientStatus != null ? clientStatus.hashCode() : 0) * 31;
        ClientStatuses clientStatuses = this.clientStatuses;
        int iHashCode2 = (iHashCode + (clientStatuses != null ? clientStatuses.hashCode() : 0)) * 31;
        List<Activity> list = this.activities;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Presence(status=");
        sbU.append(this.status);
        sbU.append(", clientStatuses=");
        sbU.append(this.clientStatuses);
        sbU.append(", activities=");
        return outline.L(sbU, this.activities, ")");
    }
}
