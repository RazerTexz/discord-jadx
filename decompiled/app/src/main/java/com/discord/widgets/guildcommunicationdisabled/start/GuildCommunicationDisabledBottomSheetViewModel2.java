package com.discord.widgets.guildcommunicationdisabled.start;

import com.discord.stores.StoreGuilds;
import com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledBottomSheetViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/GuildCommunicationDisabledBottomSheetViewModel$StoreState;", "invoke", "()Lcom/discord/widgets/guildcommunicationdisabled/start/GuildCommunicationDisabledBottomSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guildcommunicationdisabled.start.GuildCommunicationDisabledBottomSheetViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildCommunicationDisabledBottomSheetViewModel2 extends Lambda implements Function0<GuildCommunicationDisabledBottomSheetViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $guildStore;
    public final /* synthetic */ long $userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCommunicationDisabledBottomSheetViewModel2(StoreGuilds storeGuilds, long j, long j2) {
        super(0);
        this.$guildStore = storeGuilds;
        this.$guildId = j;
        this.$userId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildCommunicationDisabledBottomSheetViewModel.StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildCommunicationDisabledBottomSheetViewModel.StoreState invoke() {
        return new GuildCommunicationDisabledBottomSheetViewModel.StoreState(this.$guildStore.getGuild(this.$guildId), this.$guildStore.getMember(this.$guildId, this.$userId));
    }
}
