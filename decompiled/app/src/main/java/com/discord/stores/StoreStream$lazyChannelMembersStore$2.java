package com.discord.stores;

import d0.z.d.FunctionReferenceImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "p1", "", "invoke", "(J)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$lazyChannelMembersStore$2 extends FunctionReferenceImpl implements Function1<Long, Integer> {
    public StoreStream$lazyChannelMembersStore$2(StoreGuildMemberCounts storeGuildMemberCounts) {
        super(1, storeGuildMemberCounts, StoreGuildMemberCounts.class, "getApproximateMemberCount", "getApproximateMemberCount(J)I", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Long l) {
        return Integer.valueOf(invoke(l.longValue()));
    }

    public final int invoke(long j) {
        return ((StoreGuildMemberCounts) this.receiver).getApproximateMemberCount(j);
    }
}
