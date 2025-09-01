package com.discord.widgets.user;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.widgets.user.WidgetPruneUsersViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetPruneUsersViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/user/WidgetPruneUsersViewModel$StoreData;", "invoke", "()Lcom/discord/widgets/user/WidgetPruneUsersViewModel$StoreData;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetPruneUsersViewModel2 extends Lambda implements Function0<WidgetPruneUsersViewModel.StoreData> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUsers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsersViewModel2(StorePermissions storePermissions, long j, StoreGuilds storeGuilds, StoreUser storeUser) {
        super(0);
        this.$storePermissions = storePermissions;
        this.$guildId = j;
        this.$storeGuilds = storeGuilds;
        this.$storeUsers = storeUser;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetPruneUsersViewModel.StoreData invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetPruneUsersViewModel.StoreData invoke() {
        return new WidgetPruneUsersViewModel.StoreData(this.$storePermissions.getGuildPermissions().get(Long.valueOf(this.$guildId)), this.$storeGuilds.getGuilds().get(Long.valueOf(this.$guildId)), this.$storeUsers.getMeSnapshot());
    }
}
