package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.Message;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreThreadsJoined;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.threads.ThreadUtils;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: NotificationTextUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b6\u00107Jc\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015Jc\u0010\u001b\u001a\u00020\u0013*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u00102\u000e\u0010\u0018\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00172\n\u0010\u001a\u001a\u00060\u0005j\u0002`\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001f\u001a\u0004\u0018\u00010\u001e*\u00020\f2\n\u0010\u001d\u001a\u00060\u0005j\u0002`\u0019H\u0002¢\u0006\u0004\b\u001f\u0010 JE\u0010#\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u0013H\u0002¢\u0006\u0004\b#\u0010$Js\u0010&\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00102\u000e\u0010\u0018\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00172\n\u0010\u001a\u001a\u00060\u0005j\u0002`\u00192\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u0013H\u0002¢\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020\u0013*\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b(\u0010)JÅ\u0001\u00102\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00102\u0016\u0010-\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`,\u0012\u0004\u0012\u00020\u001e0+2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2&\u00100\u001a\"\u0012\b\u0012\u00060\u0005j\u0002`.\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`,\u0012\u0004\u0012\u00020/0+0+2\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`.\u0012\u0004\u0012\u00020\f0+2\u0016\u00101\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0019\u0012\u0004\u0012\u00020\n0+2\n\u0010\u001a\u001a\u00060\u0005j\u0002`\u00192\u000e\u0010\u0018\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0017¢\u0006\u0004\b2\u00103J)\u00104\u001a\u0004\u0018\u00010\u001e*\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/discord/stores/NotificationTextUtils;", "", "Lcom/discord/models/user/User;", "me", "", "", "Lcom/discord/primitives/RoleId;", "myRoleIds", "Lcom/discord/api/message/Message;", "message", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "joinedThread", "Lcom/discord/models/domain/ModelNotificationSettings;", "guildSettings", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/channel/Channel;", "thread", "parentChannel", "", "isThreadNotificationAllowed", "(Lcom/discord/models/user/User;Ljava/util/Collection;Lcom/discord/api/message/Message;Lcom/discord/stores/StoreThreadsJoined$JoinedThread;Lcom/discord/models/domain/ModelNotificationSettings;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;)Z", "channel", "Lcom/discord/api/permission/PermissionBit;", "channelPermissions", "Lcom/discord/primitives/ChannelId;", "selectedVoiceChannelId", "isNotificationAllowed", "(Lcom/discord/models/domain/ModelNotificationSettings;Lcom/discord/models/user/User;Ljava/util/Collection;Lcom/discord/api/message/Message;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/lang/Long;J)Z", "channelId", "", "messageNotifications", "(Lcom/discord/models/domain/ModelNotificationSettings;J)Ljava/lang/Integer;", "isSuppressEveryone", "isSuppressRoles", "messageContainsMention", "(Lcom/discord/models/user/User;Ljava/util/Collection;Lcom/discord/api/message/Message;ZZ)Z", "msgNotifLevel", "shouldNotifyForLevel", "(Ljava/lang/Integer;Lcom/discord/models/user/User;Ljava/util/Collection;Lcom/discord/api/message/Message;Lcom/discord/api/channel/Channel;Ljava/lang/Long;JZZ)Z", "isGuildOrCategoryOrChannelMuted", "(Lcom/discord/models/domain/ModelNotificationSettings;Lcom/discord/api/channel/Channel;)Z", NotificationCompat.CATEGORY_MESSAGE, "", "Lcom/discord/primitives/UserId;", "blockedRelationships", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/member/GuildMember;", "guildMembers", "joinedThreads", "shouldNotifyInAppPopup", "(Lcom/discord/models/user/User;Lcom/discord/api/message/Message;Lcom/discord/api/channel/Channel;Ljava/util/Map;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JLjava/lang/Long;)Z", "channelMessageNotificationLevel", "(Lcom/discord/models/domain/ModelNotificationSettings;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;)Ljava/lang/Integer;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class NotificationTextUtils {
    public static final NotificationTextUtils INSTANCE = new NotificationTextUtils();

    private NotificationTextUtils() {
    }

    private final boolean isNotificationAllowed(ModelNotificationSettings modelNotificationSettings, User user, Collection<Long> collection, Message message, Guild guild, Channel channel, Long l, long j) {
        if (modelNotificationSettings.isMobilePush() && !isGuildOrCategoryOrChannelMuted(modelNotificationSettings, channel)) {
            return shouldNotifyForLevel(channelMessageNotificationLevel(modelNotificationSettings, channel, guild), user, collection, message, channel, l, j, modelNotificationSettings.isSuppressEveryone(), modelNotificationSettings.isSuppressRoles());
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isThreadNotificationAllowed(User me2, Collection<Long> myRoleIds, Message message, StoreThreadsJoined.JoinedThread joinedThread, ModelNotificationSettings guildSettings, Guild guild, Channel thread, Channel parentChannel) {
        boolean z2;
        boolean z3;
        if (isGuildOrCategoryOrChannelMuted(guildSettings, thread)) {
            return false;
        }
        int iComputeThreadNotificationSetting = ThreadUtils.INSTANCE.computeThreadNotificationSetting(joinedThread, isGuildOrCategoryOrChannelMuted(guildSettings, parentChannel), channelMessageNotificationLevel(guildSettings, parentChannel, guild));
        if (iComputeThreadNotificationSetting != 2) {
            if (iComputeThreadNotificationSetting == 8) {
                return false;
            }
            if (!Intrinsics3.areEqual(message.getMentionEveryone(), Boolean.TRUE)) {
                List<com.discord.api.user.User> listT = message.t();
                if (listT == null) {
                    List<Long> listS = message.s();
                    if (listS == null) {
                        return false;
                    }
                    if (listS.isEmpty()) {
                        z2 = false;
                        if (z2) {
                            return false;
                        }
                    } else {
                        Iterator<T> it = listS.iterator();
                        while (it.hasNext()) {
                            if (myRoleIds.contains(Long.valueOf(((Number) it.next()).longValue()))) {
                                z2 = true;
                                break;
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                    }
                } else if (listT.isEmpty()) {
                    z3 = false;
                    if (!z3) {
                    }
                } else {
                    Iterator<T> it2 = listT.iterator();
                    while (it2.hasNext()) {
                        if (((com.discord.api.user.User) it2.next()).getId() == me2.getId()) {
                            z3 = true;
                            break;
                        }
                    }
                    z3 = false;
                    if (!z3) {
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean messageContainsMention(User me2, Collection<Long> myRoleIds, Message message, boolean isSuppressEveryone, boolean isSuppressRoles) {
        List<Long> listS;
        boolean z2;
        boolean z3;
        if (!Intrinsics3.areEqual(message.getMentionEveryone(), Boolean.TRUE) || isSuppressEveryone) {
            List<com.discord.api.user.User> listT = message.t();
            if (listT == null) {
                if (isSuppressRoles || (listS = message.s()) == null) {
                    return false;
                }
                if (listS.isEmpty()) {
                    z2 = false;
                    if (z2) {
                        return false;
                    }
                } else {
                    Iterator<T> it = listS.iterator();
                    while (it.hasNext()) {
                        if (myRoleIds.contains(Long.valueOf(((Number) it.next()).longValue()))) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
            } else if (listT.isEmpty()) {
                z3 = false;
                if (!z3) {
                }
            } else {
                Iterator<T> it2 = listT.iterator();
                while (it2.hasNext()) {
                    if (((com.discord.api.user.User) it2.next()).getId() == me2.getId()) {
                        z3 = true;
                        break;
                    }
                }
                z3 = false;
                if (!z3) {
                }
            }
        }
        return true;
    }

    public static /* synthetic */ boolean messageContainsMention$default(NotificationTextUtils notificationTextUtils, User user, Collection collection, Message message, boolean z2, boolean z3, int i, Object obj) {
        return notificationTextUtils.messageContainsMention(user, collection, message, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3);
    }

    private final Integer messageNotifications(ModelNotificationSettings modelNotificationSettings, long j) {
        ModelNotificationSettings.ChannelOverride channelOverride = modelNotificationSettings.getChannelOverride(j);
        if (channelOverride == null) {
            return null;
        }
        Integer numValueOf = Integer.valueOf(channelOverride.getMessageNotifications());
        if (numValueOf.intValue() == ModelNotificationSettings.FREQUENCY_UNSET) {
            return null;
        }
        return numValueOf;
    }

    private final boolean shouldNotifyForLevel(Integer msgNotifLevel, User me2, Collection<Long> myRoleIds, Message message, Channel channel, Long channelPermissions, long selectedVoiceChannelId, boolean isSuppressEveryone, boolean isSuppressRoles) {
        if (ChannelUtils.J(channel) && !PermissionUtils.can(Permission.CONNECT, channelPermissions)) {
            return false;
        }
        int i = ModelNotificationSettings.FREQUENCY_ALL;
        if (msgNotifLevel == null || msgNotifLevel.intValue() != i) {
            int i2 = ModelNotificationSettings.FREQUENCY_MENTIONS;
            if (msgNotifLevel != null && msgNotifLevel.intValue() == i2) {
                return messageContainsMention(me2, myRoleIds, message, isSuppressEveryone, isSuppressRoles);
            }
            int i3 = ModelNotificationSettings.FREQUENCY_NOTHING;
            if (msgNotifLevel != null && msgNotifLevel.intValue() == i3) {
                return false;
            }
        } else if (ChannelUtils.J(channel) && selectedVoiceChannelId != channel.getId() && !messageContainsMention(me2, myRoleIds, message, isSuppressEveryone, isSuppressRoles)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean shouldNotifyForLevel$default(NotificationTextUtils notificationTextUtils, Integer num, User user, Collection collection, Message message, Channel channel, Long l, long j, boolean z2, boolean z3, int i, Object obj) {
        return notificationTextUtils.shouldNotifyForLevel(num, user, collection, message, channel, l, j, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? false : z3);
    }

    public final Integer channelMessageNotificationLevel(ModelNotificationSettings modelNotificationSettings, Channel channel, Guild guild) {
        Integer num = null;
        Integer numValueOf = guild != null ? Integer.valueOf(guild.getDefaultMessageNotifications()) : null;
        if (channel == null || modelNotificationSettings == null) {
            return numValueOf;
        }
        Integer numMessageNotifications = messageNotifications(modelNotificationSettings, channel.getId());
        if (numMessageNotifications == null) {
            numMessageNotifications = messageNotifications(modelNotificationSettings, channel.getParentId());
        }
        if (numMessageNotifications != null) {
            num = numMessageNotifications;
        } else {
            Integer numValueOf2 = Integer.valueOf(modelNotificationSettings.getMessageNotifications());
            if (numValueOf2.intValue() != ModelNotificationSettings.FREQUENCY_UNSET) {
                num = numValueOf2;
            }
        }
        return num != null ? num : numValueOf;
    }

    public final boolean isGuildOrCategoryOrChannelMuted(ModelNotificationSettings modelNotificationSettings, Channel channel) {
        if (modelNotificationSettings == null) {
            return false;
        }
        if (modelNotificationSettings.isMuted()) {
            return true;
        }
        if (channel == null) {
            return false;
        }
        ModelNotificationSettings.ChannelOverride channelOverride = modelNotificationSettings.getChannelOverride(channel.getParentId());
        if (channelOverride != null && channelOverride.isMuted()) {
            return true;
        }
        ModelNotificationSettings.ChannelOverride channelOverride2 = modelNotificationSettings.getChannelOverride(channel.getId());
        return channelOverride2 != null && channelOverride2.isMuted();
    }

    public final boolean shouldNotifyInAppPopup(User me2, Message msg, Channel channel, Map<Long, Integer> blockedRelationships, Channel parentChannel, Guild guild, Map<Long, ? extends Map<Long, GuildMember>> guildMembers, Map<Long, ? extends ModelNotificationSettings> guildSettings, Map<Long, StoreThreadsJoined.JoinedThread> joinedThreads, long selectedVoiceChannelId, Long channelPermissions) {
        com.discord.api.user.User author;
        List<Long> listEmptyList;
        Intrinsics3.checkNotNullParameter(me2, "me");
        Intrinsics3.checkNotNullParameter(msg, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(blockedRelationships, "blockedRelationships");
        Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
        Intrinsics3.checkNotNullParameter(guildSettings, "guildSettings");
        Intrinsics3.checkNotNullParameter(joinedThreads, "joinedThreads");
        if (ChannelUtils.y(channel) || (author = msg.getAuthor()) == null || author.getId() == 0 || author.getId() == me2.getId() || blockedRelationships.containsKey(Long.valueOf(author.getId()))) {
            return false;
        }
        Integer type = msg.getType();
        if (type != null && type.intValue() == 3) {
            return false;
        }
        Map map = (Map) outline.c(channel, guildMembers);
        GuildMember guildMember = map != null ? (GuildMember) outline.f(me2, map) : null;
        if (guildMember == null || (listEmptyList = guildMember.getRoles()) == null) {
            listEmptyList = Collections2.emptyList();
        }
        List<Long> list = listEmptyList;
        ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) outline.c(channel, guildSettings);
        if (ChannelUtils.H(channel)) {
            return isThreadNotificationAllowed(me2, list, msg, (StoreThreadsJoined.JoinedThread) outline.d(channel, joinedThreads), modelNotificationSettings, guild, channel, parentChannel);
        }
        if (modelNotificationSettings != null) {
            return isNotificationAllowed(modelNotificationSettings, me2, list, msg, guild, channel, channelPermissions, selectedVoiceChannelId);
        }
        return shouldNotifyForLevel$default(this, guild != null ? Integer.valueOf(guild.getDefaultMessageNotifications()) : null, me2, list, msg, channel, channelPermissions, selectedVoiceChannelId, false, false, 384, null);
    }
}
