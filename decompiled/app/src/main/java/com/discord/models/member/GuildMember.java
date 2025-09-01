package com.discord.models.member;

import a0.a.a.b;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipientNick;
import com.discord.api.role.GuildRole;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.stores.StoreGuilds;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildMember.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\b\u0086\b\u0018\u0000 K2\u00020\u0001:\u0001KB\u009f\u0001\u0012\b\b\u0001\u0010\"\u001a\u00020\r\u0012\n\u0010#\u001a\u00060\u0003j\u0002`\u0004\u0012\u0012\u0010$\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010'\u001a\u00020\b\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0017\u0012\n\u0010)\u001a\u00060\u0003j\u0002`\u001a\u0012\n\u0010*\u001a\u00060\u0003j\u0002`\u001c\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\bH\u0010IB\t\b\u0016¢\u0006\u0004\bH\u0010JJ\u001c\u0010\u0005\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0010\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\nJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001b\u001a\u00060\u0003j\u0002`\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0011J\u0014\u0010\u001d\u001a\u00060\u0003j\u0002`\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0011J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0014J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0014J\u0012\u0010 \u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b \u0010\u0014J\u0012\u0010!\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b!\u0010\u0019J¸\u0001\u0010/\u001a\u00020\u00002\b\b\u0003\u0010\"\u001a\u00020\r2\f\b\u0002\u0010#\u001a\u00060\u0003j\u0002`\u00042\u0014\b\u0002\u0010$\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010'\u001a\u00020\b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00172\f\b\u0002\u0010)\u001a\u00060\u0003j\u0002`\u001a2\f\b\u0002\u0010*\u001a\u00060\u0003j\u0002`\u001c2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b1\u0010\u0014J\u0010\u00102\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b2\u0010\u000fJ\u001a\u00104\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b4\u00105R\"\u0010$\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u00106R\u001b\u0010&\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b&\u00107\u001a\u0004\b8\u0010\u0014R\u0019\u0010\"\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00109\u001a\u0004\b:\u0010\u000fR\u001b\u0010.\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010;\u001a\u0004\b<\u0010\u0019R\u001b\u0010%\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b%\u00107\u001a\u0004\b=\u0010\u0014R\u001d\u0010)\u001a\u00060\u0003j\u0002`\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010>\u001a\u0004\b?\u0010\u0011R\u001b\u0010,\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b,\u00107\u001a\u0004\b@\u0010\u0014R\u001d\u0010*\u001a\u00060\u0003j\u0002`\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010>\u001a\u0004\bA\u0010\u0011R\u0019\u0010'\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010B\u001a\u0004\bC\u0010\nR\u001b\u0010-\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b-\u00107\u001a\u0004\bD\u0010\u0014R\u001b\u0010(\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010;\u001a\u0004\bE\u0010\u0019R\u001d\u0010#\u001a\u00060\u0003j\u0002`\u00048\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010>\u001a\u0004\bF\u0010\u0011R\u001b\u0010+\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b+\u00107\u001a\u0004\bG\u0010\u0014¨\u0006L"}, d2 = {"Lcom/discord/models/member/GuildMember;", "", "", "", "Lcom/discord/primitives/RoleId;", "component3", "()Ljava/util/List;", "getRoles", "", "hasAvatar", "()Z", "hasBanner", "isCommunicationDisabled", "", "component1", "()I", "component2", "()J", "", "component4", "()Ljava/lang/String;", "component5", "component6", "Lcom/discord/api/utcdatetime/UtcDateTime;", "component7", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "Lcom/discord/primitives/GuildId;", "component8", "Lcom/discord/primitives/UserId;", "component9", "component10", "component11", "component12", "component13", ModelAuditLogEntry.CHANGE_KEY_COLOR, "hoistRoleId", "roles", ModelAuditLogEntry.CHANGE_KEY_NICK, "premiumSince", "pending", "joinedAt", "guildId", "userId", "avatarHash", "bannerHash", "bio", "communicationDisabledUntil", "copy", "(IJLjava/util/List;Ljava/lang/String;Ljava/lang/String;ZLcom/discord/api/utcdatetime/UtcDateTime;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/utcdatetime/UtcDateTime;)Lcom/discord/models/member/GuildMember;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "Ljava/lang/String;", "getPremiumSince", "I", "getColor", "Lcom/discord/api/utcdatetime/UtcDateTime;", "getCommunicationDisabledUntil", "getNick", "J", "getGuildId", "getBannerHash", "getUserId", "Z", "getPending", "getBio", "getJoinedAt", "getHoistRoleId", "getAvatarHash", "<init>", "(IJLjava/util/List;Ljava/lang/String;Ljava/lang/String;ZLcom/discord/api/utcdatetime/UtcDateTime;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/utcdatetime/UtcDateTime;)V", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GuildMember {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Long> emptyRoles = new ArrayList();
    private final String avatarHash;
    private final String bannerHash;
    private final String bio;
    private final int color;
    private final UtcDateTime communicationDisabledUntil;
    private final long guildId;
    private final long hoistRoleId;
    private final UtcDateTime joinedAt;
    private final String nick;
    private final boolean pending;
    private final String premiumSince;
    private final List<Long> roles;
    private final long userId;

    /* compiled from: GuildMember.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b-\u0010.J7\u0010\t\u001a\u0004\u0018\u00010\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0018\u0010\b\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJI\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\u000e\u001a\u00060\u0003j\u0002`\r2\u001a\b\u0002\u0010\b\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0017\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\b\u0001\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0017\u001a\u00020\u00152\b\b\u0001\u0010\u0019\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u001aJ7\u0010 \u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b \u0010!J!\u0010$\u001a\u00020#2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\"\u001a\u00020\u001bH\u0007¢\u0006\u0004\b$\u0010%J;\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010'\u001a\u0004\u0018\u00010&2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0002¢\u0006\u0004\b$\u0010*R \u0010+\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00060\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/discord/models/member/GuildMember$Companion;", "", "", "", "roles", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "getHighestRoleIconRole", "(Ljava/util/List;Ljava/util/Map;)Lcom/discord/api/role/GuildRole;", "Lcom/discord/api/guildmember/GuildMember;", "apiGuildMember", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/models/member/GuildMember;", "from", "(Lcom/discord/api/guildmember/GuildMember;JLjava/util/Map;Lcom/discord/stores/StoreGuilds;)Lcom/discord/models/member/GuildMember;", "member", "", "defaultColor", "getColor", "(Lcom/discord/models/member/GuildMember;I)I", ModelAuditLogEntry.CHANGE_KEY_COLOR, "(II)I", "Lcom/discord/models/user/User;", "user1", "user2", "member1", "member2", "compareUserNames", "(Lcom/discord/models/user/User;Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;Lcom/discord/models/member/GuildMember;)I", "user", "", "getNickOrUsername", "(Lcom/discord/models/member/GuildMember;Lcom/discord/models/user/User;)Ljava/lang/String;", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/api/channel/ChannelRecipientNick;", "nicks", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;Lcom/discord/api/channel/Channel;Ljava/util/List;)Ljava/lang/String;", "emptyRoles", "Ljava/util/List;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ GuildMember from$default(Companion companion, com.discord.api.guildmember.GuildMember guildMember, long j, Map map, StoreGuilds storeGuilds, int i, Object obj) {
            return companion.from(guildMember, j, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : storeGuilds);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ String getNickOrUsername$default(Companion companion, User user, GuildMember guildMember, Channel channel, List list, int i, Object obj) {
            if ((i & 8) != 0) {
                list = null;
            }
            return companion.getNickOrUsername(user, guildMember, channel, list);
        }

        public final int compareUserNames(User user1, User user2, GuildMember member1, GuildMember member2) {
            return UserUtils.INSTANCE.compareUserNames(user1, user2, member1 != null ? member1.getNick() : null, member2 != null ? member2.getNick() : null);
        }

        public final GuildMember from(com.discord.api.guildmember.GuildMember apiGuildMember, long guildId, Map<Long, GuildRole> guildRoles, StoreGuilds storeGuilds) {
            Map<Long, Map<Long, GuildRole>> roles;
            GuildRole guildRole;
            Intrinsics3.checkNotNullParameter(apiGuildMember, "apiGuildMember");
            List<Long> listL = apiGuildMember.l();
            Iterator<Long> it = listL.iterator();
            GuildRole guildRole2 = null;
            GuildRole guildRole3 = null;
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                Map<Long, GuildRole> map = guildRoles != null ? guildRoles : (storeGuilds == null || (roles = storeGuilds.getRoles()) == null) ? null : roles.get(Long.valueOf(guildId));
                if (map != null && (guildRole = map.get(Long.valueOf(jLongValue))) != null) {
                    if (!RoleUtils.isDefaultColor(guildRole) && RoleUtils.rankIsHigher(guildRole, guildRole2)) {
                        guildRole2 = guildRole;
                    }
                    if (guildRole.getHoist() && RoleUtils.rankIsHigher(guildRole, guildRole3)) {
                        guildRole3 = guildRole;
                    }
                }
            }
            return new GuildMember(RoleUtils.getOpaqueColor(guildRole2), guildRole3 != null ? guildRole3.getId() : 0L, listL.isEmpty() ^ true ? listL : null, apiGuildMember.getNick(), apiGuildMember.getPremiumSince(), apiGuildMember.getPending(), apiGuildMember.getJoinedAt(), guildId, apiGuildMember.getUser().getId(), apiGuildMember.getAvatar(), apiGuildMember.getBanner(), apiGuildMember.getBio(), apiGuildMember.getCommunicationDisabledUntil());
        }

        public final int getColor(@ColorInt int color, @ColorInt int defaultColor) {
            return color != -16777216 ? color : defaultColor;
        }

        public final int getColor(GuildMember member, @ColorInt int defaultColor) {
            return getColor(member != null ? member.getColor() : ViewCompat.MEASURED_STATE_MASK, defaultColor);
        }

        public final GuildRole getHighestRoleIconRole(List<Long> roles, Map<Long, GuildRole> guildRoles) {
            GuildRole guildRole;
            Intrinsics3.checkNotNullParameter(roles, "roles");
            Iterator<Long> it = roles.iterator();
            GuildRole guildRole2 = null;
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                if (guildRoles != null && (guildRole = guildRoles.get(Long.valueOf(jLongValue))) != null) {
                    if (((guildRole.getIcon() == null && guildRole.getUnicodeEmoji() == null) ? false : true) && RoleUtils.rankIsHigher(guildRole, guildRole2)) {
                        guildRole2 = guildRole;
                    }
                }
            }
            return guildRole2;
        }

        public final String getNickOrUsername(GuildMember member, User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return getNickOrUsername(user, member, null, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getNickOrUsername(User user, GuildMember member, Channel channel, List<ChannelRecipientNick> nicks) {
            ChannelRecipientNick channelRecipientNick;
            String nick;
            Object next;
            Intrinsics3.checkNotNullParameter(user, "user");
            String nick2 = null;
            if (nicks == null) {
                nicks = channel != null ? channel.q() : null;
            }
            if (nicks != null) {
                Iterator<T> it = nicks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((ChannelRecipientNick) next).b() == user.getId()) {
                        break;
                    }
                }
                channelRecipientNick = (ChannelRecipientNick) next;
            } else {
                channelRecipientNick = null;
            }
            if (channelRecipientNick != null && (nick = channelRecipientNick.getNick()) != null) {
                nick2 = nick;
            } else if (member != null) {
                nick2 = member.getNick();
            }
            return nick2 != null ? nick2 : user.getUsername();
        }
    }

    public GuildMember(@ColorInt int i, long j, List<Long> list, String str, String str2, boolean z2, UtcDateTime utcDateTime, long j2, long j3, String str3, String str4, String str5, UtcDateTime utcDateTime2) {
        this.color = i;
        this.hoistRoleId = j;
        this.roles = list;
        this.nick = str;
        this.premiumSince = str2;
        this.pending = z2;
        this.joinedAt = utcDateTime;
        this.guildId = j2;
        this.userId = j3;
        this.avatarHash = str3;
        this.bannerHash = str4;
        this.bio = str5;
        this.communicationDisabledUntil = utcDateTime2;
    }

    public static final int compareUserNames(User user, User user2, GuildMember guildMember, GuildMember guildMember2) {
        return INSTANCE.compareUserNames(user, user2, guildMember, guildMember2);
    }

    private final List<Long> component3() {
        return this.roles;
    }

    public static /* synthetic */ GuildMember copy$default(GuildMember guildMember, int i, long j, List list, String str, String str2, boolean z2, UtcDateTime utcDateTime, long j2, long j3, String str3, String str4, String str5, UtcDateTime utcDateTime2, int i2, Object obj) {
        return guildMember.copy((i2 & 1) != 0 ? guildMember.color : i, (i2 & 2) != 0 ? guildMember.hoistRoleId : j, (i2 & 4) != 0 ? guildMember.roles : list, (i2 & 8) != 0 ? guildMember.nick : str, (i2 & 16) != 0 ? guildMember.premiumSince : str2, (i2 & 32) != 0 ? guildMember.pending : z2, (i2 & 64) != 0 ? guildMember.joinedAt : utcDateTime, (i2 & 128) != 0 ? guildMember.guildId : j2, (i2 & 256) != 0 ? guildMember.userId : j3, (i2 & 512) != 0 ? guildMember.avatarHash : str3, (i2 & 1024) != 0 ? guildMember.bannerHash : str4, (i2 & 2048) != 0 ? guildMember.bio : str5, (i2 & 4096) != 0 ? guildMember.communicationDisabledUntil : utcDateTime2);
    }

    public static final int getColor(@ColorInt int i, @ColorInt int i2) {
        return INSTANCE.getColor(i, i2);
    }

    public static final int getColor(GuildMember guildMember, @ColorInt int i) {
        return INSTANCE.getColor(guildMember, i);
    }

    public static final String getNickOrUsername(GuildMember guildMember, User user) {
        return INSTANCE.getNickOrUsername(guildMember, user);
    }

    /* renamed from: component1, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* renamed from: component10, reason: from getter */
    public final String getAvatarHash() {
        return this.avatarHash;
    }

    /* renamed from: component11, reason: from getter */
    public final String getBannerHash() {
        return this.bannerHash;
    }

    /* renamed from: component12, reason: from getter */
    public final String getBio() {
        return this.bio;
    }

    /* renamed from: component13, reason: from getter */
    public final UtcDateTime getCommunicationDisabledUntil() {
        return this.communicationDisabledUntil;
    }

    /* renamed from: component2, reason: from getter */
    public final long getHoistRoleId() {
        return this.hoistRoleId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPremiumSince() {
        return this.premiumSince;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getPending() {
        return this.pending;
    }

    /* renamed from: component7, reason: from getter */
    public final UtcDateTime getJoinedAt() {
        return this.joinedAt;
    }

    /* renamed from: component8, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component9, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public final GuildMember copy(@ColorInt int color, long hoistRoleId, List<Long> roles, String nick, String premiumSince, boolean pending, UtcDateTime joinedAt, long guildId, long userId, String avatarHash, String bannerHash, String bio, UtcDateTime communicationDisabledUntil) {
        return new GuildMember(color, hoistRoleId, roles, nick, premiumSince, pending, joinedAt, guildId, userId, avatarHash, bannerHash, bio, communicationDisabledUntil);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildMember)) {
            return false;
        }
        GuildMember guildMember = (GuildMember) other;
        return this.color == guildMember.color && this.hoistRoleId == guildMember.hoistRoleId && Intrinsics3.areEqual(this.roles, guildMember.roles) && Intrinsics3.areEqual(this.nick, guildMember.nick) && Intrinsics3.areEqual(this.premiumSince, guildMember.premiumSince) && this.pending == guildMember.pending && Intrinsics3.areEqual(this.joinedAt, guildMember.joinedAt) && this.guildId == guildMember.guildId && this.userId == guildMember.userId && Intrinsics3.areEqual(this.avatarHash, guildMember.avatarHash) && Intrinsics3.areEqual(this.bannerHash, guildMember.bannerHash) && Intrinsics3.areEqual(this.bio, guildMember.bio) && Intrinsics3.areEqual(this.communicationDisabledUntil, guildMember.communicationDisabledUntil);
    }

    public final String getAvatarHash() {
        return this.avatarHash;
    }

    public final String getBannerHash() {
        return this.bannerHash;
    }

    public final String getBio() {
        return this.bio;
    }

    public final int getColor() {
        return this.color;
    }

    public final UtcDateTime getCommunicationDisabledUntil() {
        return this.communicationDisabledUntil;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final long getHoistRoleId() {
        return this.hoistRoleId;
    }

    public final UtcDateTime getJoinedAt() {
        return this.joinedAt;
    }

    public final String getNick() {
        return this.nick;
    }

    public final boolean getPending() {
        return this.pending;
    }

    public final String getPremiumSince() {
        return this.premiumSince;
    }

    public final List<Long> getRoles() {
        List<Long> list = this.roles;
        return list != null ? list : emptyRoles;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final boolean hasAvatar() {
        String str = this.avatarHash;
        if (str != null) {
            return (str.length() > 0) && this.guildId > 0 && this.userId > 0;
        }
        return false;
    }

    public final boolean hasBanner() {
        String str = this.bannerHash;
        if (str != null) {
            return (str.length() > 0) && this.guildId > 0 && this.userId > 0;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = (b.a(this.hoistRoleId) + (this.color * 31)) * 31;
        List<Long> list = this.roles;
        int iHashCode = (iA + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.nick;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.premiumSince;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.pending;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        UtcDateTime utcDateTime = this.joinedAt;
        int iA2 = (b.a(this.userId) + ((b.a(this.guildId) + ((i2 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31)) * 31)) * 31;
        String str3 = this.avatarHash;
        int iHashCode4 = (iA2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.bannerHash;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.bio;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime2 = this.communicationDisabledUntil;
        return iHashCode6 + (utcDateTime2 != null ? utcDateTime2.hashCode() : 0);
    }

    public final boolean isCommunicationDisabled() {
        UtcDateTime utcDateTime = this.communicationDisabledUntil;
        return utcDateTime != null && utcDateTime.getDateTimeMillis() > ClockFactory.get().currentTimeMillis();
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildMember(color=");
        sbU.append(this.color);
        sbU.append(", hoistRoleId=");
        sbU.append(this.hoistRoleId);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", nick=");
        sbU.append(this.nick);
        sbU.append(", premiumSince=");
        sbU.append(this.premiumSince);
        sbU.append(", pending=");
        sbU.append(this.pending);
        sbU.append(", joinedAt=");
        sbU.append(this.joinedAt);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", avatarHash=");
        sbU.append(this.avatarHash);
        sbU.append(", bannerHash=");
        sbU.append(this.bannerHash);
        sbU.append(", bio=");
        sbU.append(this.bio);
        sbU.append(", communicationDisabledUntil=");
        sbU.append(this.communicationDisabledUntil);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ GuildMember(int i, long j, List list, String str, String str2, boolean z2, UtcDateTime utcDateTime, long j2, long j3, String str3, String str4, String str5, UtcDateTime utcDateTime2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, j, list, str, str2, z2, utcDateTime, j2, j3, (i2 & 512) != 0 ? null : str3, (i2 & 1024) != 0 ? null : str4, (i2 & 2048) != 0 ? null : str5, (i2 & 4096) != 0 ? null : utcDateTime2);
    }

    public GuildMember() {
        this(0, 0L, null, null, null, false, null, 0L, 0L, null, null, null, null);
    }
}
