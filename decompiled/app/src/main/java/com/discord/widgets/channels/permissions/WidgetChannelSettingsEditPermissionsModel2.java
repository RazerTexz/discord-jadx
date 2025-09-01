package com.discord.widgets.channels.permissions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel;
import d0.t.Collections2;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import rx.functions.Func7;

/* compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2.\u0010\r\u001a*\u0012\b\u0012\u00060\u0007j\u0002`\u000b\u0012\u0004\u0012\u00020\f \u0003*\u0014\u0012\b\u0012\u00060\u0007j\u0002`\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n0\n26\u0010\u0011\u001a2\u0012\b\u0012\u00060\u0007j\u0002`\u000e\u0012\b\u0012\u00060\u000fj\u0002`\u0010 \u0003*\u0018\u0012\b\u0012\u00060\u0007j\u0002`\u000e\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0018\u00010\n0\n2\u000e\u0010\u0013\u001a\n \u0003*\u0004\u0018\u00010\u00120\u0012H\n¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lcom/discord/models/guild/Guild;", "guild", "", "Lcom/discord/api/permission/PermissionBit;", "myPermissionsForChannel", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "guildMembers", "", "useNewThreadsPermissions", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissionsModel2<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Channel, MeUser, Guild, Long, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Boolean, WidgetChannelSettingsEditPermissionsModel> {
    public final /* synthetic */ long $targetRoleId;

    /* compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/permission/PermissionOverwrite;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "", "invoke", "(Lcom/discord/api/permission/PermissionOverwrite;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<PermissionOverwrite, Boolean> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
            return Boolean.valueOf(invoke2(permissionOverwrite));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
            return permissionOverwrite.getId() == WidgetChannelSettingsEditPermissionsModel2.this.$targetRoleId;
        }
    }

    /* compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/permission/PermissionOverwrite;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "", "invoke", "(Lcom/discord/api/permission/PermissionOverwrite;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel$Companion$getForRole$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<PermissionOverwrite, Boolean> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(PermissionOverwrite permissionOverwrite) {
            return Boolean.valueOf(invoke2(permissionOverwrite));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(PermissionOverwrite permissionOverwrite) {
            return permissionOverwrite.getId() == WidgetChannelSettingsEditPermissionsModel2.this.$targetRoleId;
        }
    }

    public WidgetChannelSettingsEditPermissionsModel2(long j) {
        this.$targetRoleId = j;
    }

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ WidgetChannelSettingsEditPermissionsModel call(Channel channel, MeUser meUser, Guild guild, Long l, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Boolean bool) {
        return call2(channel, meUser, guild, l, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsEditPermissionsModel call2(Channel channel, MeUser meUser, Guild guild, Long l, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Boolean bool) {
        GuildMember guildMember;
        List<Long> roles;
        GuildRole guildRole = map.get(Long.valueOf(this.$targetRoleId));
        if (channel != null && guild != null && guildRole != null && l != null) {
            WidgetChannelSettingsEditPermissionsModel.Companion companion = WidgetChannelSettingsEditPermissionsModel.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
            if (WidgetChannelSettingsEditPermissionsModel.Companion.access$isAbleToManagePerms(companion, guild, meUser, l.longValue())) {
                ArrayList arrayList = new ArrayList(channel.v() != null ? channel.v() : Collections2.emptyList());
                long j = this.$targetRoleId;
                PermissionOverwrite.Type type = PermissionOverwrite.Type.ROLE;
                PermissionOverwrite permissionOverwrite = new PermissionOverwrite(j, type, 0L, Permission.ALL);
                MutableCollections.removeAll((List) arrayList, (Function1) new AnonymousClass1());
                arrayList.add(permissionOverwrite);
                PermissionOverwrite permissionOverwrite2 = new PermissionOverwrite(this.$targetRoleId, type, 0L, 0L);
                MutableCollections.removeAll((List) arrayList, (Function1) new AnonymousClass2());
                arrayList.add(permissionOverwrite2);
                boolean z2 = false;
                boolean z3 = this.$targetRoleId == guild.getId();
                long jLongValue = l.longValue();
                long j2 = this.$targetRoleId;
                long jComputeNonThreadPermissions = PermissionUtils.computeNonThreadPermissions(meUser.getId(), guild.getId(), guild.getOwnerId(), map2.get(Long.valueOf(meUser.getId())), map, arrayList);
                long jComputeNonThreadPermissions2 = PermissionUtils.computeNonThreadPermissions(meUser.getId(), guild.getId(), guild.getOwnerId(), map2.get(Long.valueOf(meUser.getId())), map, arrayList);
                if (z3 || ((guildMember = map2.get(Long.valueOf(meUser.getId()))) != null && (roles = guildMember.getRoles()) != null && roles.contains(Long.valueOf(this.$targetRoleId)))) {
                    z2 = true;
                }
                Intrinsics3.checkNotNullExpressionValue(bool, "useNewThreadsPermissions");
                return new WidgetChannelSettingsEditPermissionsModel.ModelForRole(channel, jLongValue, guildRole, j2, jComputeNonThreadPermissions, jComputeNonThreadPermissions2, z2, z3, bool.booleanValue());
            }
        }
        return null;
    }
}
