package com.discord.api.channel;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.CoreUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.PermissionOverwriteUtils;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.user.UserUtils;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ChannelUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0006\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\n\u0010\u0007\u001a\u0011\u0010\u000b\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u000b\u0010\u0007\u001a\u0011\u0010\f\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\f\u0010\u0007\u001a\u0011\u0010\r\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\r\u0010\u0007\u001a\u0011\u0010\u000e\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u0007\u001a\u0011\u0010\u000f\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0007\u001a\u0011\u0010\u0010\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0007\u001a\u0011\u0010\u0011\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u0011\u0010\u0012\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0007\u001a\u0011\u0010\u0013\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0007\u001a\u0011\u0010\u0014\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0007\u001a\u0011\u0010\u0015\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0007\u001a\u0011\u0010\u0016\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0007\u001a\u0011\u0010\u0017\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0007\u001a\u0011\u0010\u0018\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0007\u001a\u0011\u0010\u0019\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u0007\u001a\u0011\u0010\u001a\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u0007\u001a\u0011\u0010\u001b\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u0007\u001a\u0011\u0010\u001c\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u0007\u001a?\u0010%\u001a\u00020\u0002*\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0018\u0010$\u001a\u0014\u0012\b\u0012\u00060\"j\u0002`#\u0012\u0004\u0012\u00020\u001f\u0018\u00010!¢\u0006\u0004\b%\u0010&\u001a\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'*\u00020\u0005¢\u0006\u0004\b)\u0010*\u001a\u0013\u0010+\u001a\u0004\u0018\u00010(*\u00020\u0005¢\u0006\u0004\b+\u0010,\u001a\u001b\u0010/\u001a\u00020\u0002*\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100\u001a\u0011\u00101\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\b1\u0010\u0007\u001a\u0011\u00103\u001a\u000202*\u00020\u0005¢\u0006\u0004\b3\u00104\u001a#\u00108\u001a\u000202*\u00020\u00052\u0006\u00106\u001a\u0002052\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u00109\u001a\u0013\u0010:\u001a\u0004\u0018\u00010\u0000*\u00020\u0005¢\u0006\u0004\b:\u0010;\u001a\u0019\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050=*\u00020<¢\u0006\u0004\b>\u0010?\u001a\u001b\u0010B\u001a\u0004\u0018\u00010A*\u00020\u00052\u0006\u0010@\u001a\u00020\"¢\u0006\u0004\bB\u0010C\u001a\u001d\u0010E\u001a\u00020\u0002*\u00020\u00052\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\bE\u0010F\u001a\u0011\u0010G\u001a\u00020\u0002*\u00020\u0005¢\u0006\u0004\bG\u0010\u0007\"\u0016\u0010H\u001a\u00020\"8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010\n¨\u0006I"}, d2 = {"", "type", "", "l", "(I)Z", "Lcom/discord/api/channel/Channel;", "F", "(Lcom/discord/api/channel/Channel;)Z", "G", "v", "J", "w", "D", "i", "u", "k", "m", "p", "z", "q", ExifInterface.LONGITUDE_EAST, "B", "I", "H", "o", "C", "j", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/role/GuildRole;", "everyoneRole", "", "", "Lcom/discord/primitives/RoleId;", "guildRoles", "t", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/api/role/GuildRole;Ljava/util/Map;)Z", "", "Lcom/discord/models/user/User;", "g", "(Lcom/discord/api/channel/Channel;)Ljava/util/List;", "a", "(Lcom/discord/api/channel/Channel;)Lcom/discord/models/user/User;", "Lcom/discord/models/presence/Presence;", "presence", "n", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/presence/Presence;)Z", "K", "", "c", "(Lcom/discord/api/channel/Channel;)Ljava/lang/String;", "Landroid/content/Context;", "context", "includePrefix", "d", "(Lcom/discord/api/channel/Channel;Landroid/content/Context;Z)Ljava/lang/String;", "b", "(Lcom/discord/api/channel/Channel;)Ljava/lang/Integer;", "Lcom/discord/api/channel/Channel$Companion;", "Ljava/util/Comparator;", "h", "(Lcom/discord/api/channel/Channel$Companion;)Ljava/util/Comparator;", ModelAuditLogEntry.CHANGE_KEY_ID, "Lcom/discord/api/permission/PermissionOverwrite;", "f", "(Lcom/discord/api/channel/Channel;J)Lcom/discord/api/permission/PermissionOverwrite;", "parentChannel", "r", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)Z", "x", "HQ_DIRECTORY_CHANNEL_ID", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ChannelUtils {
    private static final long HQ_DIRECTORY_CHANNEL_ID = 883060064561299456L;

    public static final boolean A(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isPinned");
        Intrinsics3.checkNotNullParameter(channel, "$this$hasFlag");
        Long flags = channel.getFlags();
        return ((flags != null ? flags.longValue() : 0L) & 2) == 2;
    }

    public static final boolean B(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isPrivate");
        return channel.getType() == 1 || channel.getType() == 3;
    }

    public static final boolean C(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isPrivateThread");
        return channel.getType() == 12;
    }

    public static final boolean D(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isStageVoiceChannel");
        return channel.getType() == 13;
    }

    public static final boolean E(Channel channel) {
        User user;
        Intrinsics3.checkNotNullParameter(channel, "$this$isSystemDM");
        if (channel.getType() == 1) {
            List<User> listZ = channel.z();
            if (Intrinsics3.areEqual((listZ == null || (user = (User) _Collections.firstOrNull((List) listZ)) == null) ? null : user.getSystem(), Boolean.TRUE)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean F(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isTextChannel");
        return B(channel) || v(channel);
    }

    public static final boolean G(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isTextOrVoiceChannel");
        return F(channel) || J(channel);
    }

    public static final boolean H(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isThread");
        return channel.getType() == 10 || channel.getType() == 11 || channel.getType() == 12;
    }

    public static final boolean I(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isThreaded");
        return channel.getType() == 0 || channel.getType() == 5 || channel.getType() == 15;
    }

    public static final boolean J(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isVoiceChannel");
        return channel.getType() == 2;
    }

    public static final boolean K(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$shouldPlayJoinLeaveSounds");
        return J(channel) || B(channel);
    }

    public static final com.discord.models.user.User a(Channel channel) {
        List<User> listZ;
        List<User> listZ2;
        User user;
        Intrinsics3.checkNotNullParameter(channel, "$this$getDMRecipient");
        if (!m(channel) || (listZ = channel.z()) == null || listZ.size() != 1 || (listZ2 = channel.z()) == null || (user = (User) _Collections.first((List) listZ2)) == null) {
            return null;
        }
        return new CoreUser(user);
    }

    public static final Integer b(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$getDeletedMessage");
        if (k(channel)) {
            return Integer.valueOf(R.string.category_has_been_deleted);
        }
        if (H(channel)) {
            return Integer.valueOf(R.string.thread_has_been_deleted);
        }
        if (B(channel)) {
            return null;
        }
        return Integer.valueOf(R.string.channel_has_been_deleted);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String c(Channel channel) {
        String name;
        Intrinsics3.checkNotNullParameter(channel, "$this$getDisplayName");
        if (B(channel)) {
            String name2 = channel.getName();
            if (name2 == null || name2.length() == 0) {
                List<User> listZ = channel.z();
                name = listZ != null ? _Collections.joinToString$default(listZ, null, null, null, 0, null, ChannelUtils2.INSTANCE, 31, null) : null;
                if (name == null) {
                    return "";
                }
            }
        } else {
            name = channel.getName();
            if (name == null) {
                return "";
            }
        }
        return name;
    }

    public static final String d(Channel channel, Context context, boolean z2) {
        Intrinsics3.checkNotNullParameter(channel, "$this$getDisplayNameOrDefault");
        Intrinsics3.checkNotNullParameter(context, "context");
        String strC = c(channel);
        if (u(channel) || i(channel)) {
            if (strC.length() == 0) {
                String string = context.getString(R.string.invalid_text_channel);
                Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.string.invalid_text_channel)");
                return string;
            }
            if (z2) {
                StringBuilder sb = new StringBuilder();
                Intrinsics3.checkNotNullParameter(Channel.INSTANCE, "$this$DISPLAY_PREFIX_GUILD");
                sb.append("#");
                sb.append(strC);
                return sb.toString();
            }
        } else if (w(channel)) {
            if (strC.length() == 0) {
                String string2 = context.getString(R.string.invalid_voice_channel);
                Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.string.invalid_voice_channel)");
                return string2;
            }
        } else if (p(channel)) {
            if (strC.length() == 0) {
                String string3 = context.getString(R.string.unnamed);
                Intrinsics3.checkNotNullExpressionValue(string3, "context.getString(R.string.unnamed)");
                return string3;
            }
        } else if (m(channel)) {
            if (strC.length() == 0) {
                String string4 = context.getString(R.string.direct_message);
                Intrinsics3.checkNotNullExpressionValue(string4, "context.getString(R.string.direct_message)");
                return string4;
            }
            if (z2) {
                StringBuilder sb2 = new StringBuilder();
                Intrinsics3.checkNotNullParameter(Channel.INSTANCE, "$this$DISPLAY_PREFIX_DM");
                sb2.append("@");
                sb2.append(strC);
                return sb2.toString();
            }
        }
        return strC;
    }

    public static /* synthetic */ String e(Channel channel, Context context, boolean z2, int i) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return d(channel, context, z2);
    }

    public static final PermissionOverwrite f(Channel channel, long j) {
        Intrinsics3.checkNotNullParameter(channel, "$this$getPermissionOverwriteForId");
        List<PermissionOverwrite> listV = channel.v();
        Object obj = null;
        if (listV == null) {
            return null;
        }
        Iterator<T> it = listV.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((PermissionOverwrite) next).e() == j) {
                obj = next;
                break;
            }
        }
        return (PermissionOverwrite) obj;
    }

    public static final List<com.discord.models.user.User> g(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$getRecipients");
        List<User> listZ = channel.z();
        if (listZ == null) {
            return Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listZ, 10));
        Iterator<T> it = listZ.iterator();
        while (it.hasNext()) {
            arrayList.add(new CoreUser((User) it.next()));
        }
        return arrayList;
    }

    public static final Comparator<Channel> h(Channel.Companion companion) {
        Intrinsics3.checkNotNullParameter(companion, "$this$getSortByNameAndType");
        return new ChannelUtils4(companion);
    }

    public static final boolean i(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isAnnouncementChannel");
        return channel.getType() == 5;
    }

    public static final boolean j(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isArchivedThread");
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        return threadMetadata != null && threadMetadata.getArchived();
    }

    public static final boolean k(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isCategory");
        return channel.getType() == 4;
    }

    public static final boolean l(int i) {
        return i == 0 || i == 5 || i == 10 || i == 11 || i == 12 || i == 14 || i == 15;
    }

    public static final boolean m(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isDM");
        return channel.getType() == 1;
    }

    public static final boolean n(Channel channel, Presence presence) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isDMStatusVisible");
        com.discord.models.user.User userA = a(channel);
        return m(channel) && !E(channel) && (userA != null ? UserUtils.INSTANCE.isStatusVisible(userA, presence, true) : false);
    }

    public static final boolean o(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isDirectory");
        return channel.getType() == 14;
    }

    public static final boolean p(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isGroup");
        return channel.getType() == 3;
    }

    public static final boolean q(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isGuildForumChannel");
        return channel.getType() == 15;
    }

    public static final boolean r(Channel channel, Channel channel2) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isGuildForumPost");
        return channel2 != null && channel2.getType() == 15;
    }

    public static /* synthetic */ boolean s(Channel channel, Channel channel2, int i) {
        return r(channel, (i & 1) != 0 ? StoreStream.INSTANCE.getChannels().getChannel(channel.getParentId()) : null);
    }

    public static final boolean t(Channel channel, Guild guild, GuildRole guildRole, Map<Long, GuildRole> map) {
        Object next;
        Intrinsics3.checkNotNullParameter(channel, "$this$isGuildRoleSubscriptionChannel");
        if (guild != null && guild.hasFeature(GuildFeature.ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE)) {
            List<PermissionOverwrite> listV = channel.v();
            if (listV == null) {
                listV = Collections2.emptyList();
            }
            for (PermissionOverwrite permissionOverwrite : listV) {
                GuildRole guildRole2 = GuildUtils.getGuildRole(Long.valueOf(permissionOverwrite.e()));
                if (guildRole2 != null && RoleUtils.isSubscriptionRolePurchasableOrHasSubscribers(guildRole2) && PermissionOverwriteUtils.grantsAccessTo(permissionOverwrite, channel)) {
                    return true;
                }
            }
            boolean zIsFullyGatedGuildRoleSubscriptionGuild = GuildUtils.isFullyGatedGuildRoleSubscriptionGuild(guild, guildRole);
            Iterator<T> it = listV.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((PermissionOverwrite) next).e() == guild.getId()) {
                    break;
                }
            }
            PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) next;
            boolean zDeniesAccessTo = permissionOverwrite2 != null ? PermissionOverwriteUtils.deniesAccessTo(permissionOverwrite2, channel) : false;
            if (map != null && !zDeniesAccessTo && zIsFullyGatedGuildRoleSubscriptionGuild) {
                for (GuildRole guildRole3 : map.values()) {
                    if (RoleUtils.isSubscriptionRolePurchasableOrHasSubscribers(guildRole3) && PermissionUtils.INSTANCE.canRole(Permission.VIEW_CHANNEL, guildRole3, null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean u(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isGuildTextChannel");
        return channel.getType() == 0 || channel.getType() == 15;
    }

    public static final boolean v(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isGuildTextyChannel");
        return l(channel.getType());
    }

    public static final boolean w(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isGuildVocalChannel");
        return channel.getType() == 2 || channel.getType() == 13;
    }

    public static final boolean x(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isHQDirectoryChannel");
        return channel.getId() == HQ_DIRECTORY_CHANNEL_ID;
    }

    public static final boolean y(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isManaged");
        return channel.getApplicationId() != 0;
    }

    public static final boolean z(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$isMultiUserDM");
        return channel.getType() == 3;
    }
}
