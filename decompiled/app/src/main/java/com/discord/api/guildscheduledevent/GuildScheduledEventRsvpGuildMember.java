package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildScheduledEventRsvpGuildMember.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEventRsvpGuildMember;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "avatar", "Ljava/lang/String;", "getAvatar", ModelAuditLogEntry.CHANGE_KEY_NICK, "getNick", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildScheduledEventRsvpGuildMember {
    private final String avatar;
    private final String nick;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventRsvpGuildMember)) {
            return false;
        }
        GuildScheduledEventRsvpGuildMember guildScheduledEventRsvpGuildMember = (GuildScheduledEventRsvpGuildMember) other;
        return Intrinsics3.areEqual(this.avatar, guildScheduledEventRsvpGuildMember.avatar) && Intrinsics3.areEqual(this.nick, guildScheduledEventRsvpGuildMember.nick);
    }

    public int hashCode() {
        String str = this.avatar;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nick;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventRsvpGuildMember(avatar=");
        sbU.append(this.avatar);
        sbU.append(", nick=");
        return outline.J(sbU, this.nick, ")");
    }
}
