package com.discord.api.guildjoinrequest;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildJoinRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/discord/api/guildjoinrequest/GuildJoinRequestCreateOrUpdate;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "guildId", "J", "a", "()J", "Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "request", "Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "b", "()Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.guildjoinrequest.GuildJoinRequestCreateOrUpdate, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class GuildJoinRequest2 {
    private final long guildId;
    private final GuildJoinRequest request;

    /* renamed from: a, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: b, reason: from getter */
    public final GuildJoinRequest getRequest() {
        return this.request;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildJoinRequest2)) {
            return false;
        }
        GuildJoinRequest2 guildJoinRequest2 = (GuildJoinRequest2) other;
        return this.guildId == guildJoinRequest2.guildId && Intrinsics3.areEqual(this.request, guildJoinRequest2.request);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        GuildJoinRequest guildJoinRequest = this.request;
        return i + (guildJoinRequest != null ? guildJoinRequest.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildJoinRequestCreateOrUpdate(guildId=");
        sbU.append(this.guildId);
        sbU.append(", request=");
        sbU.append(this.request);
        sbU.append(")");
        return sbU.toString();
    }
}
