package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: GuildScheduledEventUserUpdate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\u0013\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEventUserUpdate;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "guildId", "J", "getGuildId", "()J", "userId", "b", "guildScheduledEventId", "a", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildScheduledEventUserUpdate {
    private final long guildId;
    private final long guildScheduledEventId;
    private final long userId;

    /* renamed from: a, reason: from getter */
    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    /* renamed from: b, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventUserUpdate)) {
            return false;
        }
        GuildScheduledEventUserUpdate guildScheduledEventUserUpdate = (GuildScheduledEventUserUpdate) other;
        return this.guildScheduledEventId == guildScheduledEventUserUpdate.guildScheduledEventId && this.guildId == guildScheduledEventUserUpdate.guildId && this.userId == guildScheduledEventUserUpdate.userId;
    }

    public int hashCode() {
        long j = this.guildScheduledEventId;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.userId;
        return i + ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventUserUpdate(guildScheduledEventId=");
        sbU.append(this.guildScheduledEventId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", userId=");
        return outline.C(sbU, this.userId, ")");
    }
}
