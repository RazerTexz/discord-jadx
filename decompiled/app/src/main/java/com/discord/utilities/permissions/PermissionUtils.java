package com.discord.utilities.permissions;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreSlowMode;
import com.discord.utilities.PermissionOverwriteUtils;
import com.discord.utilities.guildmember.GuildMemberUtils;
import com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: PermissionUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bO\u0010PJ\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u0006\u001a\u00020\u00022\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u000bJ;\u0010\r\u001a\u00020\u00022\n\u0010\n\u001a\u00060\bj\u0002`\t2\u000e\u0010\f\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u000f\u001a\u00020\u00022\n\u0010\n\u001a\u00060\bj\u0002`\t2\u000e\u0010\f\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0007¢\u0006\u0004\b\u000f\u0010\u0010JC\u0010\u0017\u001a\u00020\u00022\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u001a\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJw\u0010&\u001a\u00060\bj\u0002`\t2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001e\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0018\u0010$\u001a\u0014\u0012\b\u0012\u00060\bj\u0002`\"\u0012\u0004\u0012\u00020#\u0018\u00010\u00142\u0006\u0010%\u001a\u00020\u0002H\u0007¢\u0006\u0004\b&\u0010'J[\u0010,\u001a\u00060\bj\u0002`\t2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0007¢\u0006\u0004\b,\u0010-J[\u00100\u001a\u00060\bj\u0002`\t2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010/\u001a\u00020\u0002H\u0007¢\u0006\u0004\b0\u00101J+\u00102\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0014H\u0007¢\u0006\u0004\b2\u00103J1\u00104\u001a\u00060\bj\u0002`\t2\u0006\u0010(\u001a\u00020\b2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0002¢\u0006\u0004\b4\u00105J?\u00106\u001a\u00060\bj\u0002`\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\n\u0010\u001a\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b6\u00107J5\u00109\u001a\u00060\bj\u0002`\t2\u0006\u0010(\u001a\u00020\b2\f\u00108\u001a\b\u0012\u0004\u0012\u00020*0)2\n\u0010\u001a\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b9\u0010:J?\u0010;\u001a\u00060\bj\u0002`\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\f\u00108\u001a\b\u0012\u0004\u0012\u00020*0)2\n\u0010\u001a\u001a\u00060\bj\u0002`\t2\u0006\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b;\u0010<J-\u0010?\u001a\u00020\u00022\n\u0010\n\u001a\u00060\bj\u0002`\t2\b\u0010=\u001a\u0004\u0018\u00010\u00152\b\u0010>\u001a\u0004\u0018\u00010*¢\u0006\u0004\b?\u0010@J5\u0010A\u001a\u00020\u00022\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\bA\u0010BJ%\u00102\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010C\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0004\b2\u0010DJ%\u0010E\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010C\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0004\bE\u0010DJ%\u0010I\u001a\u00020\u00022\u000e\u0010F\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\u0006\u0010H\u001a\u00020G¢\u0006\u0004\bI\u0010JJC\u0010M\u001a\u00060\bj\u0002`\t2\n\u0010\u001d\u001a\u00060\bj\u0002`K2\n\u0010(\u001a\u00060\bj\u0002`L2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)¢\u0006\u0004\bM\u0010N¨\u0006Q"}, d2 = {"Lcom/discord/utilities/permissions/PermissionUtils;", "", "", "userMfaEnabled", "", "guildMfaLevel", "isElevated", "(ZI)Z", "", "Lcom/discord/api/permission/PermissionBit;", "permission", "(JZI)Z", "computedPermissions", "canAndIsElevated", "(JLjava/lang/Long;ZI)Z", "can", "(JLjava/lang/Long;)Z", "Lcom/discord/api/channel/Channel;", "channel", "parentChannel", "", "Lcom/discord/api/role/GuildRole;", "roles", "canEveryone", "(JLcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Ljava/util/Map;)Z", "isOwner", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "canManageGuildMembers", "(ZZILjava/lang/Long;)Z", "userId", "guildOwnerId", "Lcom/discord/models/member/GuildMember;", "member", "guildRoles", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/stageinstance/StageInstance;", "stageInstances", "hasJoinedThread", "computePermissions", "(JLcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;JLcom/discord/models/member/GuildMember;Ljava/util/Map;Ljava/util/Map;Z)J", "guildId", "", "Lcom/discord/api/permission/PermissionOverwrite;", "permissionOverwrites", "computeNonThreadPermissions", "(JJJLcom/discord/models/member/GuildMember;Ljava/util/Map;Ljava/util/Collection;)J", "thread", "hasJoined", "computeThreadPermissions", "(JLcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;JLcom/discord/models/member/GuildMember;Ljava/util/Map;Z)J", "hasAccess", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;)Z", "applyEveryone", "(JLjava/util/Map;)J", "applyRoles", "(Lcom/discord/models/member/GuildMember;Ljava/util/Map;J)J", "overwrites", "applyEveryoneOverwrites", "(JLjava/util/Collection;J)J", "applyRoleOverwrites", "(Lcom/discord/models/member/GuildMember;Ljava/util/Collection;JJ)J", "role", "roleOverwrite", "canRole", "(JLcom/discord/api/role/GuildRole;Lcom/discord/api/permission/PermissionOverwrite;)Z", "canEveryoneRole", "(JLcom/discord/api/channel/Channel;Ljava/util/Map;)Z", "computedPermission", "(Lcom/discord/api/channel/Channel;Ljava/lang/Long;)Z", "hasAccessWrite", "channelPermissions", "Lcom/discord/stores/StoreSlowMode$Type;", "type", "hasBypassSlowmodePermissions", "(Ljava/lang/Long;Lcom/discord/stores/StoreSlowMode$Type;)Z", "Lcom/discord/primitives/UserId;", "Lcom/discord/primitives/GuildId;", "computeChannelOverwrite", "(JJLcom/discord/models/member/GuildMember;Ljava/util/Collection;)J", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PermissionUtils {
    public static final PermissionUtils INSTANCE = new PermissionUtils();

    private PermissionUtils() {
    }

    private final long applyEveryone(long guildId, Map<Long, GuildRole> guildRoles) {
        GuildRole guildRole = guildRoles != null ? guildRoles.get(Long.valueOf(guildId)) : null;
        return guildRole != null ? guildRole.getPermissions() : Permission.DEFAULT;
    }

    private final long applyEveryoneOverwrites(long guildId, Collection<PermissionOverwrite> overwrites, long permissions) {
        Object next;
        Iterator<T> it = overwrites.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((PermissionOverwrite) next).e() == guildId) {
                break;
            }
        }
        PermissionOverwrite permissionOverwrite = (PermissionOverwrite) next;
        return permissionOverwrite != null ? ((permissionOverwrite.getDeny() & permissions) ^ permissions) | permissionOverwrite.getAllow() : permissions;
    }

    private final long applyRoleOverwrites(GuildMember member, Collection<PermissionOverwrite> overwrites, long permissions, long userId) {
        long j;
        Object next;
        Object obj = null;
        long allow = 0;
        if (member != null) {
            Iterator<Long> it = member.getRoles().iterator();
            long deny = 0;
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                Iterator<T> it2 = overwrites.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    if (((PermissionOverwrite) next).e() == jLongValue) {
                        break;
                    }
                }
                PermissionOverwrite permissionOverwrite = (PermissionOverwrite) next;
                if (permissionOverwrite != null) {
                    allow |= permissionOverwrite.getAllow();
                    deny |= permissionOverwrite.getDeny();
                }
            }
            long j2 = allow;
            allow = deny;
            j = j2;
        } else {
            j = 0;
        }
        long j3 = (permissions ^ (permissions & allow)) | j;
        Iterator<T> it3 = overwrites.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next2 = it3.next();
            if (((PermissionOverwrite) next2).e() == userId) {
                obj = next2;
                break;
            }
        }
        PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) obj;
        return permissionOverwrite2 != null ? ((permissionOverwrite2.getDeny() & j3) ^ j3) | permissionOverwrite2.getAllow() : j3;
    }

    private final long applyRoles(GuildMember member, Map<Long, GuildRole> guildRoles, long permissions) {
        if (member != null) {
            Iterator<Long> it = member.getRoles().iterator();
            while (it.hasNext()) {
                GuildRole guildRole = guildRoles != null ? guildRoles.get(Long.valueOf(it.next().longValue())) : null;
                if (guildRole != null) {
                    permissions |= guildRole.getPermissions();
                }
            }
        }
        return permissions;
    }

    public static final boolean can(long permission, Long computedPermissions) {
        return ((computedPermissions != null ? computedPermissions.longValue() : 0L) & permission) == permission;
    }

    public static final boolean canAndIsElevated(long permission, Long computedPermissions, boolean userMfaEnabled, int guildMfaLevel) {
        return can(permission, computedPermissions) && isElevated(permission, userMfaEnabled, guildMfaLevel);
    }

    public static final boolean canEveryone(long permission, Channel channel, Channel parentChannel, Map<Long, GuildRole> roles) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(roles, "roles");
        if (ChannelUtils.H(channel)) {
            if (parentChannel == null || ChannelUtils.C(channel)) {
                return false;
            }
            return canEveryone(permission, parentChannel, null, roles);
        }
        GuildRole guildRole = (GuildRole) outline.c(channel, roles);
        if (guildRole != null && (guildRole.getPermissions() & permission) != permission) {
            return false;
        }
        List<PermissionOverwrite> listV = channel.v();
        if (listV == null) {
            return true;
        }
        Iterator<PermissionOverwrite> it = listV.iterator();
        while (it.hasNext()) {
            if (PermissionOverwriteUtils.denies(it.next(), permission)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean canEveryone$default(long j, Channel channel, Channel channel2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            channel2 = null;
        }
        return canEveryone(j, channel, channel2, map);
    }

    public static final boolean canManageGuildMembers(boolean isOwner, boolean userMfaEnabled, int guildMfaLevel, Long permissions) {
        return isOwner || canAndIsElevated(8L, permissions, userMfaEnabled, guildMfaLevel) || canAndIsElevated(2L, permissions, userMfaEnabled, guildMfaLevel) || canAndIsElevated(4L, permissions, userMfaEnabled, guildMfaLevel) || canAndIsElevated(Permission.MANAGE_ROLES, permissions, userMfaEnabled, guildMfaLevel) || can(Permission.MANAGE_NICKNAMES, permissions);
    }

    public static final long computeNonThreadPermissions(long userId, long guildId, long guildOwnerId, GuildMember member, Map<Long, GuildRole> guildRoles, Collection<PermissionOverwrite> permissionOverwrites) {
        if (guildOwnerId == userId) {
            return Permission.ALL;
        }
        PermissionUtils permissionUtils = INSTANCE;
        long jApplyRoles = permissionUtils.applyRoles(member, guildRoles, permissionUtils.applyEveryone(guildId, guildRoles));
        return (jApplyRoles & 8) == 8 ? Permission.ALL : (permissionOverwrites == null || !(permissionOverwrites.isEmpty() ^ true)) ? jApplyRoles : permissionUtils.applyRoleOverwrites(member, permissionOverwrites, permissionUtils.applyEveryoneOverwrites(guildId, permissionOverwrites, jApplyRoles), userId);
    }

    public static final long computePermissions(long userId, Channel channel, Channel parentChannel, long guildOwnerId, GuildMember member, Map<Long, GuildRole> guildRoles, Map<Long, StageInstance> stageInstances, boolean hasJoinedThread) {
        long jComputeNonThreadPermissions;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.H(channel)) {
            jComputeNonThreadPermissions = parentChannel == null ? 0L : computeThreadPermissions(userId, channel, parentChannel, guildOwnerId, member, guildRoles, hasJoinedThread);
        } else {
            long guildId = channel.getGuildId();
            List<PermissionOverwrite> listV = channel.v();
            if (listV == null) {
                listV = Collections2.emptyList();
            }
            jComputeNonThreadPermissions = computeNonThreadPermissions(userId, guildId, guildOwnerId, member, guildRoles, listV);
        }
        long j = 66560;
        if (!GuildMemberUtils.isLurker(member)) {
            return (member == null || !member.isCommunicationDisabled()) ? jComputeNonThreadPermissions : jComputeNonThreadPermissions & 66560;
        }
        Map<Long, StageInstance> mapEmptyMap = stageInstances != null ? stageInstances : Maps6.emptyMap();
        Intrinsics3.checkNotNullParameter(channel, "$this$computeLurkerPermissionsAllowList");
        Intrinsics3.checkNotNullParameter(mapEmptyMap, "stageInstances");
        if (ChannelUtils.D(channel)) {
            StageInstance stageInstance = (StageInstance) outline.d(channel, mapEmptyMap);
            if ((stageInstance != null ? stageInstance.getPrivacyLevel() : null) == StageInstancePrivacyLevel.PUBLIC) {
                j = Permission.AllowList.LURKER_STAGE_CHANNEL;
            }
        }
        return jComputeNonThreadPermissions & j;
    }

    public static final long computeThreadPermissions(long userId, Channel thread, Channel parentChannel, long guildOwnerId, GuildMember member, Map<Long, GuildRole> guildRoles, boolean hasJoined) {
        Intrinsics3.checkNotNullParameter(thread, "thread");
        Intrinsics3.checkNotNullParameter(parentChannel, "parentChannel");
        long guildId = parentChannel.getGuildId();
        List<PermissionOverwrite> listV = parentChannel.v();
        if (listV == null) {
            listV = Collections2.emptyList();
        }
        long jComputeNonThreadPermissions = computeNonThreadPermissions(userId, guildId, guildOwnerId, member, guildRoles, listV);
        if (NewThreadsPermissionsFeatureFlag.INSTANCE.getINSTANCE().isEnabled(thread.getGuildId())) {
            if (ChannelUtils.C(thread) && !hasJoined) {
                can(Permission.MANAGE_THREADS, Long.valueOf(jComputeNonThreadPermissions));
            }
            return can(Permission.SEND_MESSAGES_IN_THREADS, Long.valueOf(jComputeNonThreadPermissions)) ? jComputeNonThreadPermissions | Permission.SEND_MESSAGES : (-2049) & jComputeNonThreadPermissions;
        }
        if (ChannelUtils.C(thread)) {
            if (can(Permission.CREATE_PRIVATE_THREADS, Long.valueOf(jComputeNonThreadPermissions))) {
                jComputeNonThreadPermissions |= Permission.SEND_MESSAGES;
            }
            if (!hasJoined && !can(Permission.MANAGE_THREADS, Long.valueOf(jComputeNonThreadPermissions))) {
                return 0L;
            }
        } else if (can(Permission.CREATE_PUBLIC_THREADS, Long.valueOf(jComputeNonThreadPermissions))) {
            jComputeNonThreadPermissions |= Permission.SEND_MESSAGES;
        }
        return jComputeNonThreadPermissions;
    }

    public static final boolean hasAccess(Channel channel, Map<Long, Long> permissions) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(permissions, ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS);
        return INSTANCE.hasAccess(channel, (Long) outline.d(channel, permissions));
    }

    public static final boolean isElevated(long permission, boolean userMfaEnabled, int guildMfaLevel) {
        if ((Permission.ELEVATED & permission) != permission) {
            return true;
        }
        return isElevated(userMfaEnabled, guildMfaLevel);
    }

    public static final boolean isElevated(boolean userMfaEnabled, int guildMfaLevel) {
        if (guildMfaLevel == 0) {
            return true;
        }
        return userMfaEnabled;
    }

    public final boolean canEveryoneRole(long permission, Channel channel, Map<Long, GuildRole> roles) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(roles, "roles");
        long guildId = channel.getGuildId();
        GuildRole guildRole = roles.get(Long.valueOf(guildId));
        return canRole(permission, guildRole, guildRole != null ? ChannelUtils.f(channel, guildId) : null);
    }

    public final boolean canRole(long permission, GuildRole role, PermissionOverwrite roleOverwrite) {
        if (role == null) {
            return false;
        }
        long permissions = role.getPermissions();
        return ((((permissions & (roleOverwrite != null ? roleOverwrite.getDeny() : 0L)) ^ permissions) | (roleOverwrite != null ? roleOverwrite.getAllow() : 0L)) & permission) == permission;
    }

    public final long computeChannelOverwrite(long userId, long guildId, GuildMember member, Collection<PermissionOverwrite> permissionOverwrites) {
        if (permissionOverwrites == null || !(!permissionOverwrites.isEmpty())) {
            return 0L;
        }
        return applyRoleOverwrites(member, permissionOverwrites, applyEveryoneOverwrites(guildId, permissionOverwrites, 0L), userId);
    }

    public final boolean hasAccessWrite(Channel channel, Long computedPermission) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return ChannelUtils.B(channel) || can(3072L, computedPermission);
    }

    public final boolean hasBypassSlowmodePermissions(Long channelPermissions, StoreSlowMode.Type type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        return Intrinsics3.areEqual(type, StoreSlowMode.Type.MessageSend.INSTANCE) ? can(16L, channelPermissions) || can(Permission.MANAGE_MESSAGES, channelPermissions) : can(Permission.MANAGE_THREADS, channelPermissions);
    }

    public final boolean hasAccess(Channel channel, Long computedPermission) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (ChannelUtils.B(channel)) {
            return true;
        }
        long j = Permission.VIEW_CHANNEL;
        if (ChannelUtils.w(channel)) {
            j = 1049600;
        }
        return can(j, computedPermission);
    }
}
