package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionsContexts3;
import com.discord.widgets.servers.WidgetServerSettingsEditMember;
import com.discord.widgets.servers.WidgetServerSettingsEditMemberRolesAdapter;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func6;

/* compiled from: WidgetServerSettingsEditMember.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u000326\u0010\n\u001a2\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\b\u0012\u00060\bj\u0002`\t \u0001*\u0018\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\b\u0012\u00060\bj\u0002`\t\u0018\u00010\u00050\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2.\u0010\u000f\u001a*\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0004\u0012\u00020\u000e \u0001*\u0014\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00050\u00052\u000e\u0010\u0011\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0010H\n¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lcom/discord/models/user/User;", "user", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "members", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "Lcom/discord/widgets/servers/WidgetServerSettingsEditMember$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Lcom/discord/models/user/User;Ljava/util/Map;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/lang/Long;)Lcom/discord/widgets/servers/WidgetServerSettingsEditMember$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMember$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember2<T1, T2, T3, T4, T5, T6, R> implements Func6<MeUser, User, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends GuildRole>, Long, WidgetServerSettingsEditMember.Model> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $userId;

    public WidgetServerSettingsEditMember2(long j, long j2) {
        this.$guildId = j;
        this.$userId = j2;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetServerSettingsEditMember.Model call(MeUser meUser, User user, Map<Long, ? extends GuildMember> map, Guild guild, Map<Long, ? extends GuildRole> map2, Long l) {
        return call2(meUser, user, (Map<Long, GuildMember>) map, guild, (Map<Long, GuildRole>) map2, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEditMember.Model call2(MeUser meUser, User user, Map<Long, GuildMember> map, Guild guild, Map<Long, GuildRole> map2, Long l) {
        Intrinsics3.checkNotNullExpressionValue(map2, "guildRoles");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<Long, GuildRole>> it = map2.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Long, GuildRole> next = it.next();
            if (next.getKey().longValue() != this.$guildId) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        GuildMember guildMember = map.get(Long.valueOf(meUser.getId()));
        GuildMember guildMember2 = map.get(Long.valueOf(this.$userId));
        if (guild == null || user == null || l == null || guildMember == null || guildMember2 == null) {
            return null;
        }
        PermissionsContexts3.Companion companion = PermissionsContexts3.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
        PermissionsContexts3 permissionsContexts3From = companion.from(guild, meUser, user, guildMember.getRoles(), guildMember2.getRoles(), l, linkedHashMap);
        HashSet hashSet = new HashSet(guildMember2.getRoles());
        GuildRole highestRole = RoleUtils.getHighestRole(linkedHashMap, guildMember);
        ArrayList<GuildRole> arrayList = new ArrayList(linkedHashMap.values());
        Collections.sort(arrayList, RoleUtils.getROLE_COMPARATOR());
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        for (GuildRole guildRole : arrayList) {
            arrayList2.add(new WidgetServerSettingsEditMemberRolesAdapter.RoleItem(guildRole, hashSet.contains(Long.valueOf(guildRole.getId())), highestRole, meUser.getId() == guild.getOwnerId(), permissionsContexts3From.getCanManageRoles()));
        }
        return new WidgetServerSettingsEditMember.Model(meUser.getId(), guild, guildMember2, hashSet, user, arrayList2, permissionsContexts3From.canManage(), permissionsContexts3From.getCanKick(), permissionsContexts3From.getCanBan(), permissionsContexts3From.getCanChangeNickname(), meUser.getId() != this.$userId && meUser.getId() == guild.getOwnerId(), permissionsContexts3From.getCanDisableCommunication());
    }
}
