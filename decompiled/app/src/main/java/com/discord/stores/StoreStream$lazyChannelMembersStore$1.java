package com.discord.stores;

import com.discord.api.channel.Channel;
import d0.z.d.FunctionReferenceImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreStream.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "p1", "Lcom/discord/api/channel/Channel;", "invoke", "(J)Lcom/discord/api/channel/Channel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$lazyChannelMembersStore$1 extends FunctionReferenceImpl implements Function1<Long, Channel> {
    public StoreStream$lazyChannelMembersStore$1(StoreChannels storeChannels) {
        super(1, storeChannels, StoreChannels.class, "getChannel", "getChannel(J)Lcom/discord/api/channel/Channel;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Channel invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Channel invoke(long j) {
        return ((StoreChannels) this.receiver).getChannel(j);
    }
}
