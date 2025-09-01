package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.api.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildScheduledEventMeUser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u00060\fj\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEventMeUser;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/primitives/GuildScheduledEventId;", "guildScheduledEventId", "J", "a", "()J", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvent", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getGuildScheduledEvent", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "Lcom/discord/api/user/User;", "user", "Lcom/discord/api/user/User;", "getUser", "()Lcom/discord/api/user/User;", "userId", "getUserId", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildScheduledEventMeUser {
    private final GuildScheduledEvent guildScheduledEvent;
    private final long guildScheduledEventId;
    private final User user;
    private final long userId;

    /* renamed from: a, reason: from getter */
    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventMeUser)) {
            return false;
        }
        GuildScheduledEventMeUser guildScheduledEventMeUser = (GuildScheduledEventMeUser) other;
        return this.userId == guildScheduledEventMeUser.userId && this.guildScheduledEventId == guildScheduledEventMeUser.guildScheduledEventId && Intrinsics3.areEqual(this.user, guildScheduledEventMeUser.user) && Intrinsics3.areEqual(this.guildScheduledEvent, guildScheduledEventMeUser.guildScheduledEvent);
    }

    public int hashCode() {
        long j = this.userId;
        long j2 = this.guildScheduledEventId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        User user = this.user;
        int iHashCode = (i + (user != null ? user.hashCode() : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        return iHashCode + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventMeUser(userId=");
        sbU.append(this.userId);
        sbU.append(", guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(")");
        return sbU.toString();
    }
}
