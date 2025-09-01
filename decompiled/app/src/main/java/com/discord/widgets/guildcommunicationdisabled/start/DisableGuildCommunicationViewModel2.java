package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.widgets.guildcommunicationdisabled.start.DisableGuildCommunicationViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: DisableGuildCommunicationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$StoreState;", "invoke", "()Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildcommunicationdisabled.start.DisableGuildCommunicationViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class DisableGuildCommunicationViewModel2 extends Lambda implements Function0<DisableGuildCommunicationViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ StoreUser $userStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisableGuildCommunicationViewModel2(StoreUser storeUser, long j, StoreGuilds storeGuilds, long j2) {
        super(0);
        this.$userStore = storeUser;
        this.$userId = j;
        this.$guildsStore = storeGuilds;
        this.$guildId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ DisableGuildCommunicationViewModel.StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DisableGuildCommunicationViewModel.StoreState invoke() {
        return new DisableGuildCommunicationViewModel.StoreState(this.$userStore.getUsers().get(Long.valueOf(this.$userId)), this.$guildsStore.getGuild(this.$guildId));
    }
}
