package com.discord.stores;

import com.discord.stores.StoreThreadsJoined;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreThreadsJoined.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "joinedThread", "", "invoke", "(Lcom/discord/stores/StoreThreadsJoined$JoinedThread;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreThreadsJoined$deleteThreads$removed$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreThreadsJoined2 extends Lambda implements Function1<StoreThreadsJoined.JoinedThread, Boolean> {
    public final /* synthetic */ long $guildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsJoined2(long j) {
        super(1);
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StoreThreadsJoined.JoinedThread joinedThread) {
        return Boolean.valueOf(invoke2(joinedThread));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StoreThreadsJoined.JoinedThread joinedThread) {
        Intrinsics3.checkNotNullParameter(joinedThread, "joinedThread");
        return joinedThread.getGuildId() == this.$guildId;
    }
}
