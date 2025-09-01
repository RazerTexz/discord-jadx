package com.discord.api.guildmember;

import b.d.b.a.outline;
import com.discord.api.presence.Presence;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: GuildMember.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u00102\u001a\u00020\u0016\u0012\u0006\u0010.\u001a\u00020-\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160(\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u00106\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u0004R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u0004R\u001b\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010\u0004R\u001b\u0010&\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001fR\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010.\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0019\u00102\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0019\u00106\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/discord/api/guildmember/GuildMember;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "avatar", "Ljava/lang/String;", "b", "bio", "d", "Lcom/discord/api/presence/Presence;", "presence", "Lcom/discord/api/presence/Presence;", "k", "()Lcom/discord/api/presence/Presence;", "", "userId", "Ljava/lang/Long;", "n", "()Ljava/lang/Long;", "Lcom/discord/api/utcdatetime/UtcDateTime;", "communicationDisabledUntil", "Lcom/discord/api/utcdatetime/UtcDateTime;", "e", "()Lcom/discord/api/utcdatetime/UtcDateTime;", ModelAuditLogEntry.CHANGE_KEY_NICK, "h", "premiumSince", "j", "banner", "c", "joinedAt", "g", "", "roles", "Ljava/util/List;", "l", "()Ljava/util/List;", "Lcom/discord/api/user/User;", "user", "Lcom/discord/api/user/User;", "m", "()Lcom/discord/api/user/User;", "guildId", "J", "f", "()J", "pending", "Z", "i", "()Z", "<init>", "(JLcom/discord/api/user/User;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/utcdatetime/UtcDateTime;ZLcom/discord/api/presence/Presence;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/utcdatetime/UtcDateTime;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildMember {
    private final String avatar;
    private final String banner;
    private final String bio;
    private final UtcDateTime communicationDisabledUntil;
    private final long guildId;
    private final UtcDateTime joinedAt;
    private final String nick;
    private final boolean pending;
    private final String premiumSince;
    private final Presence presence;
    private final List<Long> roles;
    private final User user;
    private final Long userId;

    public GuildMember(long j, User user, List<Long> list, String str, String str2, UtcDateTime utcDateTime, boolean z2, Presence presence, Long l, String str3, String str4, String str5, UtcDateTime utcDateTime2) {
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(list, "roles");
        this.guildId = j;
        this.user = user;
        this.roles = list;
        this.nick = str;
        this.premiumSince = str2;
        this.joinedAt = utcDateTime;
        this.pending = z2;
        this.presence = presence;
        this.userId = l;
        this.avatar = str3;
        this.bio = str4;
        this.banner = str5;
        this.communicationDisabledUntil = utcDateTime2;
    }

    public static GuildMember a(GuildMember guildMember, long j, User user, List list, String str, String str2, UtcDateTime utcDateTime, boolean z2, Presence presence, Long l, String str3, String str4, String str5, UtcDateTime utcDateTime2, int i) {
        long j2 = (i & 1) != 0 ? guildMember.guildId : j;
        User user2 = (i & 2) != 0 ? guildMember.user : user;
        List<Long> list2 = (i & 4) != 0 ? guildMember.roles : null;
        String str6 = (i & 8) != 0 ? guildMember.nick : null;
        String str7 = (i & 16) != 0 ? guildMember.premiumSince : null;
        UtcDateTime utcDateTime3 = (i & 32) != 0 ? guildMember.joinedAt : null;
        boolean z3 = (i & 64) != 0 ? guildMember.pending : z2;
        Presence presence2 = (i & 128) != 0 ? guildMember.presence : null;
        Long l2 = (i & 256) != 0 ? guildMember.userId : null;
        String str8 = (i & 512) != 0 ? guildMember.avatar : null;
        String str9 = (i & 1024) != 0 ? guildMember.bio : str4;
        String str10 = (i & 2048) != 0 ? guildMember.banner : str5;
        UtcDateTime utcDateTime4 = (i & 4096) != 0 ? guildMember.communicationDisabledUntil : null;
        Objects.requireNonNull(guildMember);
        Intrinsics3.checkNotNullParameter(user2, "user");
        Intrinsics3.checkNotNullParameter(list2, "roles");
        return new GuildMember(j2, user2, list2, str6, str7, utcDateTime3, z3, presence2, l2, str8, str9, str10, utcDateTime4);
    }

    /* renamed from: b, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: c, reason: from getter */
    public final String getBanner() {
        return this.banner;
    }

    /* renamed from: d, reason: from getter */
    public final String getBio() {
        return this.bio;
    }

    /* renamed from: e, reason: from getter */
    public final UtcDateTime getCommunicationDisabledUntil() {
        return this.communicationDisabledUntil;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMember)) {
            return false;
        }
        GuildMember guildMember = (GuildMember) other;
        return this.guildId == guildMember.guildId && Intrinsics3.areEqual(this.user, guildMember.user) && Intrinsics3.areEqual(this.roles, guildMember.roles) && Intrinsics3.areEqual(this.nick, guildMember.nick) && Intrinsics3.areEqual(this.premiumSince, guildMember.premiumSince) && Intrinsics3.areEqual(this.joinedAt, guildMember.joinedAt) && this.pending == guildMember.pending && Intrinsics3.areEqual(this.presence, guildMember.presence) && Intrinsics3.areEqual(this.userId, guildMember.userId) && Intrinsics3.areEqual(this.avatar, guildMember.avatar) && Intrinsics3.areEqual(this.bio, guildMember.bio) && Intrinsics3.areEqual(this.banner, guildMember.banner) && Intrinsics3.areEqual(this.communicationDisabledUntil, guildMember.communicationDisabledUntil);
    }

    /* renamed from: f, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: g, reason: from getter */
    public final UtcDateTime getJoinedAt() {
        return this.joinedAt;
    }

    /* renamed from: h, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        User user = this.user;
        int iHashCode = (i + (user != null ? user.hashCode() : 0)) * 31;
        List<Long> list = this.roles;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.nick;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.premiumSince;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime = this.joinedAt;
        int iHashCode5 = (iHashCode4 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        boolean z2 = this.pending;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode5 + i2) * 31;
        Presence presence = this.presence;
        int iHashCode6 = (i3 + (presence != null ? presence.hashCode() : 0)) * 31;
        Long l = this.userId;
        int iHashCode7 = (iHashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        String str3 = this.avatar;
        int iHashCode8 = (iHashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.bio;
        int iHashCode9 = (iHashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.banner;
        int iHashCode10 = (iHashCode9 + (str5 != null ? str5.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime2 = this.communicationDisabledUntil;
        return iHashCode10 + (utcDateTime2 != null ? utcDateTime2.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final boolean getPending() {
        return this.pending;
    }

    /* renamed from: j, reason: from getter */
    public final String getPremiumSince() {
        return this.premiumSince;
    }

    /* renamed from: k, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    public final List<Long> l() {
        return this.roles;
    }

    /* renamed from: m, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: n, reason: from getter */
    public final Long getUserId() {
        return this.userId;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildMember(guildId=");
        sbU.append(this.guildId);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", nick=");
        sbU.append(this.nick);
        sbU.append(", premiumSince=");
        sbU.append(this.premiumSince);
        sbU.append(", joinedAt=");
        sbU.append(this.joinedAt);
        sbU.append(", pending=");
        sbU.append(this.pending);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", avatar=");
        sbU.append(this.avatar);
        sbU.append(", bio=");
        sbU.append(this.bio);
        sbU.append(", banner=");
        sbU.append(this.banner);
        sbU.append(", communicationDisabledUntil=");
        sbU.append(this.communicationDisabledUntil);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GuildMember(long j, User user, List list, String str, String str2, UtcDateTime utcDateTime, boolean z2, Presence presence, Long l, String str3, String str4, String str5, UtcDateTime utcDateTime2, int i) {
        this(j, user, list, str, str2, utcDateTime, z2, null, l, str3, null, null, (i & 4096) != 0 ? null : utcDateTime2);
        int i2 = i & 1024;
        int i3 = i & 2048;
    }
}
