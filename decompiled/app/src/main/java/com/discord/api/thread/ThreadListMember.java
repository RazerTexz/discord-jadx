package com.discord.api.thread;

import b.d.b.a.outline;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.presence.Presence;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ThreadListMember.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/discord/api/thread/ThreadListMember;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildmember/GuildMember;", "member", "Lcom/discord/api/guildmember/GuildMember;", "a", "()Lcom/discord/api/guildmember/GuildMember;", "", "userId", "J", "c", "()J", "Lcom/discord/api/presence/Presence;", "presence", "Lcom/discord/api/presence/Presence;", "b", "()Lcom/discord/api/presence/Presence;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ThreadListMember {
    private final GuildMember member;
    private final Presence presence;
    private final long userId;

    /* renamed from: a, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    /* renamed from: b, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* renamed from: c, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadListMember)) {
            return false;
        }
        ThreadListMember threadListMember = (ThreadListMember) other;
        return this.userId == threadListMember.userId && Intrinsics3.areEqual(this.member, threadListMember.member) && Intrinsics3.areEqual(this.presence, threadListMember.presence);
    }

    public int hashCode() {
        long j = this.userId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        GuildMember guildMember = this.member;
        int iHashCode = (i + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        Presence presence = this.presence;
        return iHashCode + (presence != null ? presence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ThreadListMember(userId=");
        sbU.append(this.userId);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(")");
        return sbU.toString();
    }
}
