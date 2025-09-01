package com.discord.widgets.servers.role_members;

import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.sequences.Sequence;

/* compiled from: ServerSettingsRoleMembersViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$StoreState;", "invoke", "()Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel2 extends Lambda implements Function0<ServerSettingsRoleMembersViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $guildRoleId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreUser $storeUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel2(StoreGuilds storeGuilds, long j, long j2, StoreUser storeUser) {
        super(0);
        this.$storeGuilds = storeGuilds;
        this.$guildId = j;
        this.$guildRoleId = j2;
        this.$storeUser = storeUser;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ServerSettingsRoleMembersViewModel.StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsRoleMembersViewModel.StoreState invoke() {
        List listEmptyList;
        Collection<GuildMember> collectionValues;
        Sequence sequenceAsSequence;
        Sequence sequenceFilter;
        Map<Long, GuildMember> map = this.$storeGuilds.getMembers().get(Long.valueOf(this.$guildId));
        if (map == null || (collectionValues = map.values()) == null || (sequenceAsSequence = _Collections.asSequence(collectionValues)) == null || (sequenceFilter = _Sequences2.filter(sequenceAsSequence, new ServerSettingsRoleMembersViewModel3(this))) == null || (listEmptyList = _Sequences2.toList(sequenceFilter)) == null) {
            listEmptyList = Collections2.emptyList();
        }
        Map<Long, User> users = this.$storeUser.getUsers();
        Map<Long, GuildRole> map2 = this.$storeGuilds.getRoles().get(Long.valueOf(this.$guildId));
        return new ServerSettingsRoleMembersViewModel.StoreState(listEmptyList, users, map2 != null ? map2.get(Long.valueOf(this.$guildRoleId)) : null);
    }
}
