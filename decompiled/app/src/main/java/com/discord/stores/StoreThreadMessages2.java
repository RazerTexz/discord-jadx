package com.discord.stores;

import com.discord.stores.StoreThreadMessages;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreThreadMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreThreadMessages$ThreadState;", "thread", "", "invoke", "(Lcom/discord/stores/StoreThreadMessages$ThreadState;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreThreadMessages$deleteForGuild$removed$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreThreadMessages2 extends Lambda implements Function1<StoreThreadMessages.ThreadState, Boolean> {
    public final /* synthetic */ long $guildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadMessages2(long j) {
        super(1);
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreThreadMessages.ThreadState threadState) {
        return Boolean.valueOf(invoke2(threadState));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreThreadMessages.ThreadState threadState) {
        Intrinsics3.checkNotNullParameter(threadState, "thread");
        return threadState.getGuildId() == this.$guildId;
    }
}
