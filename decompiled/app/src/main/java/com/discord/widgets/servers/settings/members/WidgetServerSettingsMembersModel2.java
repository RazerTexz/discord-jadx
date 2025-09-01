package com.discord.widgets.servers.settings.members;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.permissions.PermissionsContexts3;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func7;

/* compiled from: WidgetServerSettingsMembersModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b \u0005*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u000726\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "members", "Lrx/Observable;", "Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsMembersModel2<T, R> implements Func1<Map<Long, ? extends GuildMember>, Observable<? extends WidgetServerSettingsMembersModel>> {
    public final /* synthetic */ Observable $filterPublisher;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Observable $roleFilterPublisher;

    /* compiled from: WidgetServerSettingsMembersModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052.\u0010\u000b\u001a*\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u0004\u0012\u00020\n \u0006*\u0014\u0012\b\u0012\u00060\u0002j\u0002`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\b2.\u0010\u000e\u001a*\u0012\b\u0012\u00060\u0002j\u0002`\f\u0012\u0004\u0012\u00020\r \u0006*\u0014\u0012\b\u0012\u00060\u0002j\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u00010\b0\b2\u000e\u0010\u0010\u001a\n \u0006*\u0004\u0018\u00010\u000f0\u000f2\u000e\u0010\u0011\u001a\n \u0006*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "users", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "", "filter", "roleIdFilter", "Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Ljava/lang/Long;Lcom/discord/models/user/MeUser;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Long;)Lcom/discord/widgets/servers/settings/members/WidgetServerSettingsMembersModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Guild, Long, MeUser, Map<Long, ? extends User>, Map<Long, ? extends GuildRole>, String, Long, WidgetServerSettingsMembersModel> {
        public final /* synthetic */ Map $members;

        public AnonymousClass1(Map map) {
            this.$members = map;
        }

        @Override // rx.functions.Func7
        public /* bridge */ /* synthetic */ WidgetServerSettingsMembersModel call(Guild guild, Long l, MeUser meUser, Map<Long, ? extends User> map, Map<Long, ? extends GuildRole> map2, String str, Long l2) {
            return call2(guild, l, meUser, map, (Map<Long, GuildRole>) map2, str, l2);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0108  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final WidgetServerSettingsMembersModel call2(Guild guild, Long l, MeUser meUser, Map<Long, ? extends User> map, Map<Long, GuildRole> map2, String str, Long l2) {
            TreeSet treeSet;
            String nick;
            AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, R> anonymousClass1 = this;
            String str2 = str;
            Long l3 = l2;
            GuildMember guildMember = (GuildMember) anonymousClass1.$members.get(Long.valueOf(meUser.getId()));
            if (guild == null || l == null || guildMember == null) {
                return null;
            }
            TreeSet treeSet2 = new TreeSet(WidgetServerSettingsMembersModel.Companion.access$sortMembersComparator(WidgetServerSettingsMembersModel.INSTANCE));
            for (User user : map.values()) {
                GuildMember guildMember2 = (GuildMember) outline.f(user, anonymousClass1.$members);
                if (guildMember2 != null) {
                    long id2 = guild.getId();
                    if ((l3 != null && l2.longValue() == id2) || guildMember2.getRoles().contains(l3)) {
                        long id3 = user.getId();
                        Intrinsics3.checkNotNullExpressionValue(str2, "filter");
                        Long longOrNull = StringNumberConversions.toLongOrNull(str);
                        if ((longOrNull != null && id3 == longOrNull.longValue()) || Strings4.contains((CharSequence) user.getUsername(), (CharSequence) str2, true) || ((nick = guildMember2.getNick()) != null && Strings4.contains((CharSequence) nick, (CharSequence) str2, true))) {
                            PermissionsContexts3.Companion companion = PermissionsContexts3.INSTANCE;
                            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                            List<Long> roles = guildMember.getRoles();
                            List<Long> roles2 = guildMember2.getRoles();
                            Intrinsics3.checkNotNullExpressionValue(map2, "roles");
                            treeSet = treeSet2;
                            PermissionsContexts3 permissionsContexts3From = companion.from(guild, meUser, user, roles, roles2, l, map2);
                            String nickOrUsername = GuildMember.INSTANCE.getNickOrUsername(guildMember2, user);
                            List<Long> roles3 = guildMember2.getRoles();
                            ArrayList arrayList = new ArrayList();
                            Iterator<T> it = roles3.iterator();
                            while (it.hasNext()) {
                                GuildRole guildRole = map2.get(Long.valueOf(((Number) it.next()).longValue()));
                                if (guildRole != null) {
                                    arrayList.add(guildRole);
                                }
                            }
                            treeSet.add(new WidgetServerSettingsMembersModel.MemberItem(user, nickOrUsername, arrayList, permissionsContexts3From.canManage(), guildMember2));
                        } else {
                            treeSet = treeSet2;
                        }
                    }
                }
                anonymousClass1 = this;
                str2 = str;
                treeSet2 = treeSet;
                l3 = l2;
            }
            WidgetServerSettingsMembersModel.Companion companion2 = WidgetServerSettingsMembersModel.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(map2, "roles");
            Map mapAccess$sortRoles = WidgetServerSettingsMembersModel.Companion.access$sortRoles(companion2, map2);
            ArrayList arrayList2 = new ArrayList(treeSet2);
            GuildRole highestRole = RoleUtils.getHighestRole(map2, guildMember);
            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
            return new WidgetServerSettingsMembersModel(guild, mapAccess$sortRoles, arrayList2, highestRole, meUser, guild.isOwner(meUser.getId()) || PermissionUtils.canAndIsElevated(2L, l, meUser.getMfaEnabled(), guild.getMfaLevel()), PermissionUtils.canManageGuildMembers(guild.isOwner(meUser.getId()), meUser.getMfaEnabled(), guild.getMfaLevel(), l));
        }
    }

    public WidgetServerSettingsMembersModel2(long j, Observable observable, Observable observable2) {
        this.$guildId = j;
        this.$filterPublisher = observable;
        this.$roleFilterPublisher = observable2;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsMembersModel> call(Map<Long, ? extends GuildMember> map) {
        return call2((Map<Long, GuildMember>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsMembersModel> call2(Map<Long, GuildMember> map) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.e(companion.getGuilds().observeGuild(this.$guildId), companion.getPermissions().observePermissionsForGuild(this.$guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getUsers().observeUsers(map.keySet()), companion.getGuilds().observeRoles(this.$guildId), this.$filterPublisher.p(300L, TimeUnit.MILLISECONDS), this.$roleFilterPublisher, new AnonymousClass1(map));
    }
}
