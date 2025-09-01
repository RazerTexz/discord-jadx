package com.discord.api.guildmember;

import b.d.b.a.outline;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildMemberRemove.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/discord/api/guildmember/GuildMemberRemove;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "guildId", "J", "a", "()J", "Lcom/discord/api/user/User;", "user", "Lcom/discord/api/user/User;", "b", "()Lcom/discord/api/user/User;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildMemberRemove {
    private final long guildId;
    private final User user;

    /* renamed from: a, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: b, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMemberRemove)) {
            return false;
        }
        GuildMemberRemove guildMemberRemove = (GuildMemberRemove) other;
        return this.guildId == guildMemberRemove.guildId && Intrinsics3.areEqual(this.user, guildMemberRemove.user);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        User user = this.user;
        return i + (user != null ? user.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildMemberRemove(guildId=");
        sbU.append(this.guildId);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(")");
        return sbU.toString();
    }
}
