package com.discord.models.guild;

import b.d.b.a.outline;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UserGuildMember.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ&\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lcom/discord/models/guild/UserGuildMember;", "", "", "getNickOrUserName", "()Ljava/lang/String;", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "Lcom/discord/models/member/GuildMember;", "component2", "()Lcom/discord/models/member/GuildMember;", "user", "guildMember", "copy", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)Lcom/discord/models/guild/UserGuildMember;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "nickname", "Ljava/lang/String;", "getNickname", "Lcom/discord/models/member/GuildMember;", "getGuildMember", "Lcom/discord/models/user/User;", "getUser", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class UserGuildMember {
    private final GuildMember guildMember;
    private final String nickname;
    private final User user;

    public UserGuildMember(User user, GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(user, "user");
        this.user = user;
        this.guildMember = guildMember;
        this.nickname = guildMember != null ? guildMember.getNick() : null;
    }

    public static /* synthetic */ UserGuildMember copy$default(UserGuildMember userGuildMember, User user, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            user = userGuildMember.user;
        }
        if ((i & 2) != 0) {
            guildMember = userGuildMember.guildMember;
        }
        return userGuildMember.copy(user, guildMember);
    }

    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final UserGuildMember copy(User user, GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(user, "user");
        return new UserGuildMember(user, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserGuildMember)) {
            return false;
        }
        UserGuildMember userGuildMember = (UserGuildMember) other;
        return Intrinsics3.areEqual(this.user, userGuildMember.user) && Intrinsics3.areEqual(this.guildMember, userGuildMember.guildMember);
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final String getNickOrUserName() {
        return GuildMember.INSTANCE.getNickOrUsername(this.guildMember, this.user);
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        GuildMember guildMember = this.guildMember;
        return iHashCode + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("UserGuildMember(user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ UserGuildMember(User user, GuildMember guildMember, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, (i & 2) != 0 ? null : guildMember);
    }
}
