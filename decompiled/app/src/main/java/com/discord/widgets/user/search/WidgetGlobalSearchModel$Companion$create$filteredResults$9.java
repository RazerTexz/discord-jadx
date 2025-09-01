package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "it", "Lcom/discord/api/channel/Channel;", "invoke", "(J)Lcom/discord/api/channel/Channel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$9 extends Lambda implements Function1<Long, Channel> {
    public final /* synthetic */ WidgetGlobalSearchModel.ChannelContext $channelContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$9(WidgetGlobalSearchModel.ChannelContext channelContext) {
        super(1);
        this.$channelContext = channelContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Channel invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Channel invoke(long j) {
        return this.$channelContext.getChannels().get(Long.valueOf(j));
    }
}
