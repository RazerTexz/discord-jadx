package com.discord.api.user;

import b.d.b.a.outline;
import com.discord.api.application.ProfileApplication;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.guildmember.GuildMember;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import org.objectweb.asm.Opcodes;

/* compiled from: UserProfile.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001+Ba\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011\u0012\b\b\u0002\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R\u001b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010%\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/discord/api/user/UserProfile;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "premiumSince", "Ljava/lang/String;", "f", "premiumGuildSince", "e", "", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "connectedAccounts", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/discord/api/application/ProfileApplication;", "application", "Lcom/discord/api/application/ProfileApplication;", "a", "()Lcom/discord/api/application/ProfileApplication;", "Lcom/discord/api/user/UserProfile$GuildReference;", "mutualGuilds", "d", "Lcom/discord/api/guildmember/GuildMember;", "guildMember", "Lcom/discord/api/guildmember/GuildMember;", "c", "()Lcom/discord/api/guildmember/GuildMember;", "Lcom/discord/api/user/User;", "user", "Lcom/discord/api/user/User;", "g", "()Lcom/discord/api/user/User;", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/discord/api/user/User;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/guildmember/GuildMember;Lcom/discord/api/application/ProfileApplication;)V", "GuildReference", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class UserProfile {
    private final ProfileApplication application;
    private final List<ConnectedAccount> connectedAccounts;
    private final GuildMember guildMember;
    private final List<GuildReference> mutualGuilds;
    private final String premiumGuildSince;
    private final String premiumSince;
    private final User user;

    /* compiled from: UserProfile.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001d\u0010\u0011\u001a\u00060\u000fj\u0002`\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/discord/api/user/UserProfile$GuildReference;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_NICK, "Ljava/lang/String;", "b", "", "Lcom/discord/primitives/GuildId;", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "a", "()J", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildReference {
        private final long id;
        private final String nick;

        /* renamed from: a, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: b, reason: from getter */
        public final String getNick() {
            return this.nick;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildReference)) {
                return false;
            }
            GuildReference guildReference = (GuildReference) other;
            return this.id == guildReference.id && Intrinsics3.areEqual(this.nick, guildReference.nick);
        }

        public int hashCode() {
            long j = this.id;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.nick;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildReference(id=");
            sbU.append(this.id);
            sbU.append(", nick=");
            return outline.J(sbU, this.nick, ")");
        }
    }

    public UserProfile() {
        this(null, null, null, null, null, null, null, Opcodes.LAND);
    }

    public UserProfile(List<ConnectedAccount> list, List<GuildReference> list2, User user, String str, String str2, GuildMember guildMember, ProfileApplication profileApplication) {
        Intrinsics3.checkNotNullParameter(list, "connectedAccounts");
        Intrinsics3.checkNotNullParameter(list2, "mutualGuilds");
        Intrinsics3.checkNotNullParameter(user, "user");
        this.connectedAccounts = list;
        this.mutualGuilds = list2;
        this.user = user;
        this.premiumSince = str;
        this.premiumGuildSince = str2;
        this.guildMember = guildMember;
        this.application = profileApplication;
    }

    /* renamed from: a, reason: from getter */
    public final ProfileApplication getApplication() {
        return this.application;
    }

    public final List<ConnectedAccount> b() {
        return this.connectedAccounts;
    }

    /* renamed from: c, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final List<GuildReference> d() {
        return this.mutualGuilds;
    }

    /* renamed from: e, reason: from getter */
    public final String getPremiumGuildSince() {
        return this.premiumGuildSince;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserProfile)) {
            return false;
        }
        UserProfile userProfile = (UserProfile) other;
        return Intrinsics3.areEqual(this.connectedAccounts, userProfile.connectedAccounts) && Intrinsics3.areEqual(this.mutualGuilds, userProfile.mutualGuilds) && Intrinsics3.areEqual(this.user, userProfile.user) && Intrinsics3.areEqual(this.premiumSince, userProfile.premiumSince) && Intrinsics3.areEqual(this.premiumGuildSince, userProfile.premiumGuildSince) && Intrinsics3.areEqual(this.guildMember, userProfile.guildMember) && Intrinsics3.areEqual(this.application, userProfile.application);
    }

    /* renamed from: f, reason: from getter */
    public final String getPremiumSince() {
        return this.premiumSince;
    }

    /* renamed from: g, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        List<ConnectedAccount> list = this.connectedAccounts;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<GuildReference> list2 = this.mutualGuilds;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
        String str = this.premiumSince;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.premiumGuildSince;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildMember guildMember = this.guildMember;
        int iHashCode6 = (iHashCode5 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        ProfileApplication profileApplication = this.application;
        return iHashCode6 + (profileApplication != null ? profileApplication.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("UserProfile(connectedAccounts=");
        sbU.append(this.connectedAccounts);
        sbU.append(", mutualGuilds=");
        sbU.append(this.mutualGuilds);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", premiumSince=");
        sbU.append(this.premiumSince);
        sbU.append(", premiumGuildSince=");
        sbU.append(this.premiumGuildSince);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserProfile(List list, List list2, User user, String str, String str2, GuildMember guildMember, ProfileApplication profileApplication, int i) {
        this((i & 1) != 0 ? Collections2.emptyList() : null, (i & 2) != 0 ? Collections2.emptyList() : null, (i & 4) != 0 ? new User(0L, "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194300) : null, null, null, null, null);
        int i2 = i & 8;
        int i3 = i & 16;
        int i4 = i & 32;
        int i5 = i & 64;
    }
}
