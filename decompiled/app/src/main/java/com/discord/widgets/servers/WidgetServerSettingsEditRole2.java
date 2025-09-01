package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.chat.list.NewThreadsPermissionsFeatureFlag;
import com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledGuildsFeatureFlag;
import com.discord.widgets.servers.WidgetServerSettingsEditRole;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func6;

/* compiled from: WidgetServerSettingsEditRole.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/user/MeUser;", "meUser", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole2<T, R> implements Func1<MeUser, Observable<? extends WidgetServerSettingsEditRole.Model>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $roleId;

    /* compiled from: WidgetServerSettingsEditRole.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0001\u001a\u0004\u0018\u00010\u000026\u0010\b\u001a2\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u0006 \u0007*\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0018\u00010\u00020\u00022.\u0010\u000b\u001a*\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020\n \u0007*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00020\u00022\u000e\u0010\r\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\f2\u000e\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u000e0\u000e2\u000e\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u000e0\u000eH\n¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "computedMap", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "", "useNewThreadPermissions", "hasDisabledGuildCommunicationFeature", "Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/discord/widgets/servers/WidgetServerSettingsEditRole$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, R> implements Func6<Guild, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Long, Boolean, Boolean, WidgetServerSettingsEditRole.Model> {
        public final /* synthetic */ MeUser $meUser;

        public AnonymousClass1(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // rx.functions.Func6
        public /* bridge */ /* synthetic */ WidgetServerSettingsEditRole.Model call(Guild guild, Map<Long, ? extends GuildMember> map, Map<Long, ? extends GuildRole> map2, Long l, Boolean bool, Boolean bool2) {
            return call2(guild, (Map<Long, GuildMember>) map, (Map<Long, GuildRole>) map2, l, bool, bool2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsEditRole.Model call2(Guild guild, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Long l, Boolean bool, Boolean bool2) {
            GuildMember guildMember = map.get(Long.valueOf(this.$meUser.getId()));
            GuildRole guildRole = map2 != null ? map2.get(Long.valueOf(WidgetServerSettingsEditRole2.this.$roleId)) : null;
            if (guildRole == null || guild == null || guildMember == null) {
                return null;
            }
            GuildRole highestRole = RoleUtils.getHighestRole(map2, guildMember);
            boolean z2 = guild.getOwnerId() == this.$meUser.getId();
            boolean zIsElevated = PermissionUtils.isElevated(this.$meUser.getMfaEnabled(), guild.getMfaLevel());
            WidgetServerSettingsEditRole.Model.Companion companion = WidgetServerSettingsEditRole.Model.INSTANCE;
            WidgetServerSettingsEditRole.Model.ManageStatus manageStatusAccess$computeManageStatus = WidgetServerSettingsEditRole.Model.Companion.access$computeManageStatus(companion, z2, zIsElevated, l, highestRole, guildRole);
            long jAccess$computeMyOtherPermissions = WidgetServerSettingsEditRole.Model.Companion.access$computeMyOtherPermissions(companion, guildMember.getRoles(), map2, WidgetServerSettingsEditRole2.this.$roleId, guild.getId());
            boolean zContains = guild.getFeatures().contains(GuildFeature.COMMUNITY);
            long id2 = guild.getId();
            Intrinsics3.checkNotNullExpressionValue(bool, "useNewThreadPermissions");
            boolean zBooleanValue = bool.booleanValue();
            Intrinsics3.checkNotNullExpressionValue(bool2, "hasDisabledGuildCommunicationFeature");
            return new WidgetServerSettingsEditRole.Model(z2, id2, guildRole, manageStatusAccess$computeManageStatus, l, jAccess$computeMyOtherPermissions, zContains, zBooleanValue, bool2.booleanValue());
        }
    }

    public WidgetServerSettingsEditRole2(long j, long j2) {
        this.$guildId = j;
        this.$roleId = j2;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsEditRole.Model> call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsEditRole.Model> call2(MeUser meUser) {
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.f(companion.getGuilds().observeGuild(this.$guildId), companion.getGuilds().observeComputed(this.$guildId, CollectionsJVM.listOf(Long.valueOf(meUser.getId()))), companion.getGuilds().observeRoles(this.$guildId), companion.getPermissions().observePermissionsForGuild(this.$guildId), NewThreadsPermissionsFeatureFlag.INSTANCE.getINSTANCE().observeEnabled(this.$guildId), GuildCommunicationDisabledGuildsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildAccessCommunicationDisabled(this.$guildId), new AnonymousClass1(meUser));
    }
}
