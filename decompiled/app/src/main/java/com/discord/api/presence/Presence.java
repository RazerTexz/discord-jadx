package com.discord.api.presence;

import b.d.b.a.outline;
import com.discord.api.activity.Activity;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Presence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/discord/api/presence/Presence;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/api/activity/Activity;", "activities", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/discord/api/presence/ClientStatus;", "status", "Lcom/discord/api/presence/ClientStatus;", "e", "()Lcom/discord/api/presence/ClientStatus;", "", "guildId", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "userId", "g", "Lcom/discord/api/user/User;", "user", "Lcom/discord/api/user/User;", "f", "()Lcom/discord/api/user/User;", "Lcom/discord/api/presence/ClientStatuses;", "clientStatus", "Lcom/discord/api/presence/ClientStatuses;", "c", "()Lcom/discord/api/presence/ClientStatuses;", "<init>", "(Lcom/discord/api/presence/ClientStatus;Ljava/util/List;Lcom/discord/api/presence/ClientStatuses;Lcom/discord/api/user/User;Ljava/lang/Long;Ljava/lang/Long;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Presence {
    private final List<Activity> activities;
    private final ClientStatuses clientStatus;
    private final Long guildId;
    private final ClientStatus status;
    private final User user;
    private final Long userId;

    public Presence(ClientStatus clientStatus, List<Activity> list, ClientStatuses clientStatuses, User user, Long l, Long l2) {
        Intrinsics3.checkNotNullParameter(clientStatus, "status");
        this.status = clientStatus;
        this.activities = list;
        this.clientStatus = clientStatuses;
        this.user = user;
        this.userId = l;
        this.guildId = l2;
    }

    public static Presence a(Presence presence, ClientStatus clientStatus, List list, ClientStatuses clientStatuses, User user, Long l, Long l2, int i) {
        ClientStatus clientStatus2 = (i & 1) != 0 ? presence.status : null;
        List<Activity> list2 = (i & 2) != 0 ? presence.activities : null;
        ClientStatuses clientStatuses2 = (i & 4) != 0 ? presence.clientStatus : null;
        if ((i & 8) != 0) {
            user = presence.user;
        }
        User user2 = user;
        Long l3 = (i & 16) != 0 ? presence.userId : null;
        Long l4 = (i & 32) != 0 ? presence.guildId : null;
        Intrinsics3.checkNotNullParameter(clientStatus2, "status");
        return new Presence(clientStatus2, list2, clientStatuses2, user2, l3, l4);
    }

    public final List<Activity> b() {
        return this.activities;
    }

    /* renamed from: c, reason: from getter */
    public final ClientStatuses getClientStatus() {
        return this.clientStatus;
    }

    /* renamed from: d, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* renamed from: e, reason: from getter */
    public final ClientStatus getStatus() {
        return this.status;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Presence)) {
            return false;
        }
        Presence presence = (Presence) other;
        return Intrinsics3.areEqual(this.status, presence.status) && Intrinsics3.areEqual(this.activities, presence.activities) && Intrinsics3.areEqual(this.clientStatus, presence.clientStatus) && Intrinsics3.areEqual(this.user, presence.user) && Intrinsics3.areEqual(this.userId, presence.userId) && Intrinsics3.areEqual(this.guildId, presence.guildId);
    }

    /* renamed from: f, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: g, reason: from getter */
    public final Long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        ClientStatus clientStatus = this.status;
        int iHashCode = (clientStatus != null ? clientStatus.hashCode() : 0) * 31;
        List<Activity> list = this.activities;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        ClientStatuses clientStatuses = this.clientStatus;
        int iHashCode3 = (iHashCode2 + (clientStatuses != null ? clientStatuses.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode4 = (iHashCode3 + (user != null ? user.hashCode() : 0)) * 31;
        Long l = this.userId;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.guildId;
        return iHashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Presence(status=");
        sbU.append(this.status);
        sbU.append(", activities=");
        sbU.append(this.activities);
        sbU.append(", clientStatus=");
        sbU.append(this.clientStatus);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", guildId=");
        return outline.G(sbU, this.guildId, ")");
    }
}
