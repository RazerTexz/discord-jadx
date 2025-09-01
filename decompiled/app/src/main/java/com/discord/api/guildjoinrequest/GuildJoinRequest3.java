package com.discord.api.guildjoinrequest;

import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: GuildJoinRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u00060\fj\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u00060\fj\u0002`\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/discord/api/guildjoinrequest/GuildJoinRequestDelete;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/primitives/UserId;", "userId", "J", "b", "()J", "Lcom/discord/primitives/GuildId;", "guildId", "a", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.guildjoinrequest.GuildJoinRequestDelete, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class GuildJoinRequest3 {
    private final long guildId;
    private final long userId;

    /* renamed from: a, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: b, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildJoinRequest3)) {
            return false;
        }
        GuildJoinRequest3 guildJoinRequest3 = (GuildJoinRequest3) other;
        return this.userId == guildJoinRequest3.userId && this.guildId == guildJoinRequest3.guildId;
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.guildId;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildJoinRequestDelete(userId=");
        sbU.append(this.userId);
        sbU.append(", guildId=");
        return outline.C(sbU, this.guildId, ")");
    }
}
