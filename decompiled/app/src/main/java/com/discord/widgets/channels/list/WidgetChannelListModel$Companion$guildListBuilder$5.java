package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "parentChannelId", "", "invoke", "(J)Z", "areAnyChildThreadsSelected"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$5 extends Lambda implements Function1<Long, Boolean> {
    public final /* synthetic */ Channel $selectedChannel;
    public final /* synthetic */ Map $threadParentMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListModel$Companion$guildListBuilder$5(Map map, Channel channel) {
        super(1);
        this.$threadParentMap = map;
        this.$selectedChannel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
        return Boolean.valueOf(invoke(l.longValue()));
    }

    public final boolean invoke(long j) {
        Collection collection = (Collection) this.$threadParentMap.get(Long.valueOf(j));
        if (collection == null) {
            return false;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            long id2 = ((Channel) it.next()).getId();
            Channel channel = this.$selectedChannel;
            if (channel != null && id2 == channel.getId()) {
                return true;
            }
        }
        return false;
    }
}
