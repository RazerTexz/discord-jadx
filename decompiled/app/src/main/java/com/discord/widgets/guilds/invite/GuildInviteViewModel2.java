package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreInstantInvites;
import com.discord.widgets.guilds.invite.GuildInviteViewModel;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: GuildInviteViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreInstantInvites$InviteState;", "kotlin.jvm.PlatformType", "instantInviteState", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreInstantInvites$InviteState;)Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.invite.GuildInviteViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildInviteViewModel2<T, R> implements Func1<StoreInstantInvites.InviteState, GuildInviteViewModel.StoreState> {
    public static final GuildInviteViewModel2 INSTANCE = new GuildInviteViewModel2();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ GuildInviteViewModel.StoreState call(StoreInstantInvites.InviteState inviteState) {
        return call2(inviteState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildInviteViewModel.StoreState call2(StoreInstantInvites.InviteState inviteState) {
        return inviteState instanceof StoreInstantInvites.InviteState.Loading ? GuildInviteViewModel.StoreState.Loading.INSTANCE : inviteState instanceof StoreInstantInvites.InviteState.Resolved ? new GuildInviteViewModel.StoreState.Loaded(((StoreInstantInvites.InviteState.Resolved) inviteState).getInvite()) : GuildInviteViewModel.StoreState.Invalid.INSTANCE;
    }
}
