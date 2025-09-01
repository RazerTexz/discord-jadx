package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ApiGuildScheduledEventUser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\u00060\u0002j\u0002`\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/discord/api/guildscheduledevent/ApiGuildScheduledEventUser;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/api/guildmember/GuildMember;", "a", "(J)Lcom/discord/api/guildmember/GuildMember;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/user/User;", "user", "Lcom/discord/api/user/User;", "c", "()Lcom/discord/api/user/User;", "Lcom/discord/api/guildscheduledevent/ApiGuildScheduledEventUserGuildMember;", "member", "Lcom/discord/api/guildscheduledevent/ApiGuildScheduledEventUserGuildMember;", "getMember", "()Lcom/discord/api/guildscheduledevent/ApiGuildScheduledEventUserGuildMember;", "Lcom/discord/primitives/GuildScheduledEventId;", "guildScheduledEventId", "J", "b", "()J", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ApiGuildScheduledEventUser {
    private final long guildScheduledEventId;
    private final ApiGuildScheduledEventUser2 member;
    private final User user;

    public final GuildMember a(long guildId) {
        ApiGuildScheduledEventUser2 apiGuildScheduledEventUser2;
        User user = this.user;
        if (user == null || (apiGuildScheduledEventUser2 = this.member) == null) {
            return null;
        }
        return apiGuildScheduledEventUser2.a(user, guildId);
    }

    /* renamed from: b, reason: from getter */
    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    /* renamed from: c, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiGuildScheduledEventUser)) {
            return false;
        }
        ApiGuildScheduledEventUser apiGuildScheduledEventUser = (ApiGuildScheduledEventUser) other;
        return Intrinsics3.areEqual(this.user, apiGuildScheduledEventUser.user) && Intrinsics3.areEqual(this.member, apiGuildScheduledEventUser.member) && this.guildScheduledEventId == apiGuildScheduledEventUser.guildScheduledEventId;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        ApiGuildScheduledEventUser2 apiGuildScheduledEventUser2 = this.member;
        int iHashCode2 = (iHashCode + (apiGuildScheduledEventUser2 != null ? apiGuildScheduledEventUser2.hashCode() : 0)) * 31;
        long j = this.guildScheduledEventId;
        return iHashCode2 + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApiGuildScheduledEventUser(user=");
        sbU.append(this.user);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(", guildScheduledEventId=");
        return outline.C(sbU, this.guildScheduledEventId, ")");
    }
}
