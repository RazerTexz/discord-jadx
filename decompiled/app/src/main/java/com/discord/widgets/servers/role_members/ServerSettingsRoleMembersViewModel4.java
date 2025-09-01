package com.discord.widgets.servers.role_members;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: ServerSettingsRoleMembersViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "filter", "Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$StoreState;", "storeState", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$StoreState;)Lcom/discord/widgets/servers/role_members/ServerSettingsRoleMembersViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel4<T1, T2, R> implements Func2<String, ServerSettingsRoleMembersViewModel.StoreState, ServerSettingsRoleMembersViewModel.StoreState> {
    public static final ServerSettingsRoleMembersViewModel4 INSTANCE = new ServerSettingsRoleMembersViewModel4();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ ServerSettingsRoleMembersViewModel.StoreState call(String str, ServerSettingsRoleMembersViewModel.StoreState storeState) {
        return call2(str, storeState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final ServerSettingsRoleMembersViewModel.StoreState call2(String str, ServerSettingsRoleMembersViewModel.StoreState storeState) {
        String nick;
        String username;
        Intrinsics3.checkNotNullParameter(str, "filter");
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        List<GuildMember> guildMembers = storeState.getGuildMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : guildMembers) {
            GuildMember guildMember = (GuildMember) obj;
            User user = storeState.getUsers().get(Long.valueOf(guildMember.getUserId()));
            boolean z2 = true;
            if ((user == null || (username = user.getUsername()) == null || !Strings4.contains((CharSequence) username, (CharSequence) str, true)) && ((nick = guildMember.getNick()) == null || !Strings4.contains((CharSequence) nick, (CharSequence) str, true))) {
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        return ServerSettingsRoleMembersViewModel.StoreState.copy$default(storeState, arrayList, null, null, 6, null);
    }
}
