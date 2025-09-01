package com.discord.widgets.guilds.invite;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: TargetChannelSelector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\b\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u000e\u0010\u0007\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guilds/invite/TargetChannelSelector;", "", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "invitableChannels", "channelId", "getTargetChannel", "(Ljava/util/Map;Ljava/lang/Long;)Lcom/discord/api/channel/Channel;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class TargetChannelSelector {
    public final Channel getTargetChannel(Map<Long, Channel> invitableChannels, Long channelId) {
        Intrinsics3.checkNotNullParameter(invitableChannels, "invitableChannels");
        ArrayList arrayList = new ArrayList(invitableChannels.values());
        Collections.sort(arrayList, ChannelUtils.h(Channel.INSTANCE));
        if (invitableChannels.containsKey(channelId)) {
            return invitableChannels.get(channelId);
        }
        if (!arrayList.isEmpty()) {
            return (Channel) arrayList.get(0);
        }
        return null;
    }
}
