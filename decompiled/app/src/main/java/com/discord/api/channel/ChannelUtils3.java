package com.discord.api.channel;

import com.discord.utilities.message.MessageUtils;
import java.util.Comparator;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ChannelUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.api.channel.ChannelUtils$getSortByMostRecent$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ChannelUtils3<T> implements Comparator<Channel> {
    public final /* synthetic */ Map $mostRecentMessageIds;

    public ChannelUtils3(Map map) {
        this.$mostRecentMessageIds = map;
    }

    @Override // java.util.Comparator
    public int compare(Channel channel, Channel channel2) {
        long id2 = channel.getId();
        long id3 = channel2.getId();
        return MessageUtils.compareMessages(this.$mostRecentMessageIds.containsKey(Long.valueOf(id3)) ? (Long) this.$mostRecentMessageIds.get(Long.valueOf(id3)) : Long.valueOf(id3), this.$mostRecentMessageIds.containsKey(Long.valueOf(id2)) ? (Long) this.$mostRecentMessageIds.get(Long.valueOf(id2)) : Long.valueOf(id2));
    }
}
