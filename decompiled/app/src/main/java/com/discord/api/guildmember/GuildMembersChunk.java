package com.discord.api.guildmember;

import b.d.b.a.outline;
import com.discord.api.presence.Presence;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: GuildMembersChunk.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/discord/api/guildmember/GuildMembersChunk;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/api/presence/Presence;", "presences", "Ljava/util/List;", "d", "()Ljava/util/List;", "", "guildId", "J", "a", "()J", "notFound", "c", "Lcom/discord/api/guildmember/GuildMember;", "members", "b", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildMembersChunk {
    private final long guildId;
    private final List<GuildMember> members;
    private final List<Long> notFound;
    private final List<Presence> presences;

    /* renamed from: a, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final List<GuildMember> b() {
        return this.members;
    }

    public final List<Long> c() {
        return this.notFound;
    }

    public final List<Presence> d() {
        return this.presences;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMembersChunk)) {
            return false;
        }
        GuildMembersChunk guildMembersChunk = (GuildMembersChunk) other;
        return this.guildId == guildMembersChunk.guildId && Intrinsics3.areEqual(this.members, guildMembersChunk.members) && Intrinsics3.areEqual(this.presences, guildMembersChunk.presences) && Intrinsics3.areEqual(this.notFound, guildMembersChunk.notFound);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<GuildMember> list = this.members;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<Presence> list2 = this.presences;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Long> list3 = this.notFound;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildMembersChunk(guildId=");
        sbU.append(this.guildId);
        sbU.append(", members=");
        sbU.append(this.members);
        sbU.append(", presences=");
        sbU.append(this.presences);
        sbU.append(", notFound=");
        return outline.L(sbU, this.notFound, ")");
    }
}
