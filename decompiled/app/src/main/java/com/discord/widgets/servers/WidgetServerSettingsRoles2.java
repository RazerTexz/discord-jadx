package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.WidgetServerSettingsRoles;
import com.discord.widgets.servers.WidgetServerSettingsRolesAdapter;
import d0.t.CollectionsJVM;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: WidgetServerSettingsRoles.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004 \u0001*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lrx/Observable;", "Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRoles2<T, R> implements Func1<MeUser, Observable<? extends WidgetServerSettingsRoles.Model>> {
    public final /* synthetic */ long $guildId;

    /* compiled from: WidgetServerSettingsRoles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000426\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "computedMap", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/models/member/GuildMember;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {
        public final /* synthetic */ MeUser $meUser;

        public AnonymousClass1(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
            return call2((Map<Long, GuildMember>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildMember call2(Map<Long, GuildMember> map) {
            return map.get(Long.valueOf(this.$meUser.getId()));
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062.\u0010\f\u001a*\u0012\b\u0012\u00060\u0005j\u0002`\t\u0012\u0004\u0012\u00020\n \u000b*\u0014\u0012\b\u0012\u00060\u0005j\u0002`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\bH\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "meComputed", "", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "kotlin.jvm.PlatformType", "guildRoles", "Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/models/member/GuildMember;Ljava/lang/Long;Ljava/util/Map;)Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$Model$Companion$get$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, T3, T4, R> implements Func4<Guild, GuildMember, Long, Map<Long, ? extends GuildRole>, WidgetServerSettingsRoles.Model> {
        public final /* synthetic */ MeUser $meUser;

        public AnonymousClass2(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetServerSettingsRoles.Model call(Guild guild, GuildMember guildMember, Long l, Map<Long, ? extends GuildRole> map) {
            return call2(guild, guildMember, l, (Map<Long, GuildRole>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsRoles.Model call2(Guild guild, GuildMember guildMember, Long l, Map<Long, GuildRole> map) {
            if (guild == null || guildMember == null || l == null || map == null) {
                return null;
            }
            boolean zCan = PermissionUtils.can(Permission.MANAGE_ROLES, l);
            boolean zIsElevated = PermissionUtils.isElevated(this.$meUser.getMfaEnabled(), guild.getMfaLevel());
            GuildRole highestRole = RoleUtils.getHighestRole(map, guildMember);
            ArrayList<GuildRole> arrayList = new ArrayList(map.values());
            Collections.sort(arrayList, RoleUtils.getROLE_COMPARATOR());
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(new WidgetServerSettingsRolesAdapter.HelpItem(WidgetServerSettingsRoles2.this.$guildId));
            for (GuildRole guildRole : arrayList) {
                arrayList2.add(new WidgetServerSettingsRolesAdapter.RoleItem(guildRole, WidgetServerSettingsRoles2.this.$guildId == guildRole.getId(), (guild.getOwnerId() == this.$meUser.getId() || RoleUtils.rankIsHigher(highestRole, guildRole)) ? false : true, zCan, zIsElevated, WidgetServerSettingsRoles2.this.$guildId));
            }
            return new WidgetServerSettingsRoles.Model(WidgetServerSettingsRoles2.this.$guildId, guild.getName(), zCan, zIsElevated, arrayList2);
        }
    }

    public WidgetServerSettingsRoles2(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsRoles.Model> call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsRoles.Model> call2(MeUser meUser) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.h(companion.getGuilds().observeGuild(this.$guildId), companion.getGuilds().observeComputed(this.$guildId, CollectionsJVM.listOf(Long.valueOf(meUser.getId()))).G(new AnonymousClass1(meUser)), companion.getPermissions().observePermissionsForGuild(this.$guildId), companion.getGuilds().observeRoles(this.$guildId), new AnonymousClass2(meUser));
    }
}
