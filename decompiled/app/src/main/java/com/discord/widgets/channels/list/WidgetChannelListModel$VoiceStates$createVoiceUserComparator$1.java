package com.discord.widgets.channels.list;

import com.discord.models.member.GuildMember;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: WidgetChannelListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemVoiceUser;", "kotlin.jvm.PlatformType", "item1", "item2", "", "compare", "(Lcom/discord/widgets/channels/list/items/ChannelListItemVoiceUser;Lcom/discord/widgets/channels/list/items/ChannelListItemVoiceUser;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$VoiceStates$createVoiceUserComparator$1<T> implements Comparator<ChannelListItemVoiceUser> {
    public static final WidgetChannelListModel$VoiceStates$createVoiceUserComparator$1 INSTANCE = new WidgetChannelListModel$VoiceStates$createVoiceUserComparator$1();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(ChannelListItemVoiceUser channelListItemVoiceUser, ChannelListItemVoiceUser channelListItemVoiceUser2) {
        return compare2(channelListItemVoiceUser, channelListItemVoiceUser2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(ChannelListItemVoiceUser channelListItemVoiceUser, ChannelListItemVoiceUser channelListItemVoiceUser2) {
        if (channelListItemVoiceUser.isApplicationStreaming() && !channelListItemVoiceUser2.isApplicationStreaming()) {
            return -1;
        }
        if (!channelListItemVoiceUser2.isApplicationStreaming() || channelListItemVoiceUser.isApplicationStreaming()) {
            return GuildMember.INSTANCE.compareUserNames(channelListItemVoiceUser.getUser(), channelListItemVoiceUser2.getUser(), channelListItemVoiceUser.getComputed(), channelListItemVoiceUser2.getComputed());
        }
        return 1;
    }
}
