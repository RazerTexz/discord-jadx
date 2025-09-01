package com.discord.utilities.channel;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ChannelUtils4;
import java.util.Comparator;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: GuildChannelsInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u00012\u0018\u0010\u0004\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", "o1", "o2", "", "compare", "(Ljava/lang/Long;Ljava/lang/Long;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.channel.GuildChannelsInfo$getSortedCategories$sortedCategories$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildChannelsInfo3<T> implements Comparator<Long> {
    public final /* synthetic */ Map $guildChannels;

    public GuildChannelsInfo3(Map map) {
        this.$guildChannels = map;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Long l, Long l2) {
        return compare2(l, l2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(Long l, Long l2) {
        return ((ChannelUtils4) ChannelUtils.h(Channel.INSTANCE)).compare(this.$guildChannels.get(l), this.$guildChannels.get(l2));
    }
}
