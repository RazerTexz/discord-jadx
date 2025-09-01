package com.discord.stores;

import com.discord.stores.StoreMessagesLoader;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreMessagesLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "it", "invoke", "(Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;)Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$5$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreMessagesLoader5 extends Lambda implements Function1<StoreMessagesLoader.ChannelLoadedState, StoreMessagesLoader.ChannelLoadedState> {
    public static final StoreMessagesLoader5 INSTANCE = new StoreMessagesLoader5();

    public StoreMessagesLoader5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreMessagesLoader.ChannelLoadedState invoke(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        return invoke2(channelLoadedState);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreMessagesLoader.ChannelLoadedState invoke2(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
        return StoreMessagesLoader.ChannelLoadedState.copy$default(channelLoadedState, false, false, true, false, null, 27, null);
    }
}
