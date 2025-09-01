package com.discord.utilities;

import com.discord.api.channel.Channel;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ShareUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "channelId", "Lcom/discord/api/channel/Channel;", "invoke", "(J)Lcom/discord/api/channel/Channel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$4 extends Lambda implements Function1<Long, Channel> {
    public final /* synthetic */ Map $channelsById;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$4(Map map) {
        super(1);
        this.$channelsById = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Channel invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Channel invoke(long j) {
        return (Channel) this.$channelsById.get(Long.valueOf(j));
    }
}
