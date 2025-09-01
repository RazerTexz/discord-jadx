package com.discord.api.guildscheduledevent;

import b.d.b.a.outline;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ApiGuildScheduledEventUser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\fR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\fR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010#\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\fR\u0019\u0010%\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/discord/api/guildscheduledevent/ApiGuildScheduledEventUserGuildMember;", "", "Lcom/discord/api/user/User;", "user", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/api/guildmember/GuildMember;", "a", "(Lcom/discord/api/user/User;J)Lcom/discord/api/guildmember/GuildMember;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "roles", "Ljava/util/List;", "getRoles", "()Ljava/util/List;", ModelAuditLogEntry.CHANGE_KEY_NICK, "Ljava/lang/String;", "getNick", "avatar", "getAvatar", "Lcom/discord/api/utcdatetime/UtcDateTime;", "joinedAt", "Lcom/discord/api/utcdatetime/UtcDateTime;", "getJoinedAt", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "premiumSince", "getPremiumSince", "pending", "Z", "getPending", "()Z", "discord_api"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.api.guildscheduledevent.ApiGuildScheduledEventUserGuildMember, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ApiGuildScheduledEventUser2 {
    private final String avatar;
    private final UtcDateTime joinedAt;
    private final String nick;
    private final boolean pending;
    private final String premiumSince;
    private final List<Long> roles;

    public final GuildMember a(User user, long guildId) {
        Intrinsics3.checkNotNullParameter(user, "user");
        return new GuildMember(guildId, user, this.roles, this.nick, this.premiumSince, this.joinedAt, this.pending, null, Long.valueOf(user.getId()), this.avatar, null, null, null, 4096);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiGuildScheduledEventUser2)) {
            return false;
        }
        ApiGuildScheduledEventUser2 apiGuildScheduledEventUser2 = (ApiGuildScheduledEventUser2) other;
        return Intrinsics3.areEqual(this.roles, apiGuildScheduledEventUser2.roles) && Intrinsics3.areEqual(this.nick, apiGuildScheduledEventUser2.nick) && Intrinsics3.areEqual(this.premiumSince, apiGuildScheduledEventUser2.premiumSince) && Intrinsics3.areEqual(this.joinedAt, apiGuildScheduledEventUser2.joinedAt) && this.pending == apiGuildScheduledEventUser2.pending && Intrinsics3.areEqual(this.avatar, apiGuildScheduledEventUser2.avatar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<Long> list = this.roles;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.nick;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.premiumSince;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.joinedAt;
        int iHashCode4 = (iHashCode3 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        boolean z2 = this.pending;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode4 + i) * 31;
        String str3 = this.avatar;
        return i2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApiGuildScheduledEventUserGuildMember(roles=");
        sbU.append(this.roles);
        sbU.append(", nick=");
        sbU.append(this.nick);
        sbU.append(", premiumSince=");
        sbU.append(this.premiumSince);
        sbU.append(", joinedAt=");
        sbU.append(this.joinedAt);
        sbU.append(", pending=");
        sbU.append(this.pending);
        sbU.append(", avatar=");
        return outline.J(sbU, this.avatar, ")");
    }
}
