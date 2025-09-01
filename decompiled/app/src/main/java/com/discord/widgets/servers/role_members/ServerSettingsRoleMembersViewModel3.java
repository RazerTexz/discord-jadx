package com.discord.widgets.servers.role_members;

import com.discord.models.member.GuildMember;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ServerSettingsRoleMembersViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "it", "", "invoke", "(Lcom/discord/models/member/GuildMember;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1$guildMembers$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel3 extends Lambda implements Function1<GuildMember, Boolean> {
    public final /* synthetic */ ServerSettingsRoleMembersViewModel2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel3(ServerSettingsRoleMembersViewModel2 serverSettingsRoleMembersViewModel2) {
        super(1);
        this.this$0 = serverSettingsRoleMembersViewModel2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(GuildMember guildMember) {
        return Boolean.valueOf(invoke2(guildMember));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(guildMember, "it");
        return guildMember.getRoles().contains(Long.valueOf(this.this$0.$guildRoleId));
    }
}
