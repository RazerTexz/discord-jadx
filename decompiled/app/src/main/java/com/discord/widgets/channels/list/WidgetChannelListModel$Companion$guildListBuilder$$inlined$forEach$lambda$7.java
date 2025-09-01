package com.discord.widgets.channels.list;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreThreadsJoined;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.channels.list.items.ChannelListItemThread;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "parentChannel", "", "Lcom/discord/widgets/channels/list/items/ChannelListItemThread;", "invoke", "(Lcom/discord/api/channel/Channel;)Ljava/util/Collection;", "com/discord/widgets/channels/list/WidgetChannelListModel$Companion$guildListBuilder$6$7", "createChannelListItemThreads"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7 extends Lambda implements Function1<Channel, Collection<? extends ChannelListItemThread>> {
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$4 $areAllChildThreadsRead$4$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$5 $areAnyChildThreadsSelected$5$inlined;
    public final /* synthetic */ boolean $canSeeGuildRoleSubscriptions$inlined;
    public final /* synthetic */ Set $channelsWithActiveThreads$inlined;
    public final /* synthetic */ Set $collapsedCategories$inlined;
    public final /* synthetic */ Map $directories$inlined;
    public final /* synthetic */ Map $directoryEvents$inlined;
    public final /* synthetic */ HashSet $forceViewCategories$inlined;
    public final /* synthetic */ GuildChannelsInfo $guild$inlined;
    public final /* synthetic */ List $guildScheduledEvents$inlined;
    public final /* synthetic */ HashSet $hiddenChannelsIds$inlined;
    public final /* synthetic */ boolean $isGuildHub$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$3 $isThreadUnread$3$inlined;
    public final /* synthetic */ ArrayList $items$inlined;
    public final /* synthetic */ Map $joinedThreads$inlined;
    public final /* synthetic */ Map $mentionCounts$inlined;
    public final /* synthetic */ Map $messageAcks$inlined;
    public final /* synthetic */ Channel $selectedChannel$inlined;
    public final /* synthetic */ long $selectedGuildId$inlined;
    public final /* synthetic */ long $selectedVoiceChannelId$inlined;
    public final /* synthetic */ Map $stageChannels$inlined;
    public final /* synthetic */ Map $stageInstances$inlined;
    public final /* synthetic */ Map $threadParentMap$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4 $toChannelListItemThread$4;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$2 $tryRemoveEmptyCategory$2$inlined;
    public final /* synthetic */ Set $unreadChannelIds$inlined;
    public final /* synthetic */ Map $voiceStates$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$7(WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4, GuildChannelsInfo guildChannelsInfo, HashSet hashSet, boolean z2, Channel channel, Map map, Set set, long j, WidgetChannelListModel$Companion$guildListBuilder$5 widgetChannelListModel$Companion$guildListBuilder$5, Set set2, WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$3, HashSet hashSet2, WidgetChannelListModel$Companion$guildListBuilder$4 widgetChannelListModel$Companion$guildListBuilder$4, long j2, Map map2, boolean z3, Set set3, List list, Map map3, Map map4, Map map5, Map map6, ArrayList arrayList, WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$2, Map map7, Map map8, Map map9) {
        super(1);
        this.$toChannelListItemThread$4 = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4;
        this.$guild$inlined = guildChannelsInfo;
        this.$forceViewCategories$inlined = hashSet;
        this.$isGuildHub$inlined = z2;
        this.$selectedChannel$inlined = channel;
        this.$mentionCounts$inlined = map;
        this.$unreadChannelIds$inlined = set;
        this.$selectedGuildId$inlined = j;
        this.$areAnyChildThreadsSelected$5$inlined = widgetChannelListModel$Companion$guildListBuilder$5;
        this.$collapsedCategories$inlined = set2;
        this.$isThreadUnread$3$inlined = widgetChannelListModel$Companion$guildListBuilder$3;
        this.$hiddenChannelsIds$inlined = hashSet2;
        this.$areAllChildThreadsRead$4$inlined = widgetChannelListModel$Companion$guildListBuilder$4;
        this.$selectedVoiceChannelId$inlined = j2;
        this.$voiceStates$inlined = map2;
        this.$canSeeGuildRoleSubscriptions$inlined = z3;
        this.$channelsWithActiveThreads$inlined = set3;
        this.$guildScheduledEvents$inlined = list;
        this.$stageInstances$inlined = map3;
        this.$stageChannels$inlined = map4;
        this.$threadParentMap$inlined = map5;
        this.$joinedThreads$inlined = map6;
        this.$items$inlined = arrayList;
        this.$tryRemoveEmptyCategory$2$inlined = widgetChannelListModel$Companion$guildListBuilder$2;
        this.$messageAcks$inlined = map7;
        this.$directories$inlined = map8;
        this.$directoryEvents$inlined = map9;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Collection<? extends ChannelListItemThread> invoke(Channel channel) {
        return invoke2(channel);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Collection<ChannelListItemThread> invoke2(Channel channel) {
        List listEmptyList;
        Intrinsics3.checkNotNullParameter(channel, "parentChannel");
        Collection<Channel> collection = (Collection) outline.d(channel, this.$threadParentMap$inlined);
        if (collection != null) {
            listEmptyList = new ArrayList();
            for (Channel channel2 : collection) {
                ChannelListItemThread channelListItemThreadInvoke2 = this.$toChannelListItemThread$4.invoke2(channel2, (StoreThreadsJoined.JoinedThread) outline.d(channel2, this.$joinedThreads$inlined));
                if (channelListItemThreadInvoke2 != null) {
                    listEmptyList.add(channelListItemThreadInvoke2);
                }
            }
        } else {
            listEmptyList = Collections2.emptyList();
        }
        int size = listEmptyList.size();
        WidgetChannelListModel$Companion$guildListBuilder$6$7$1 widgetChannelListModel$Companion$guildListBuilder$6$7$1 = WidgetChannelListModel$Companion$guildListBuilder$6$7$1.INSTANCE;
        int i = 0;
        for (Object obj : listEmptyList) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            ((ChannelListItemThread) obj).setSpineType(WidgetChannelListModel$Companion$guildListBuilder$6$7$1.INSTANCE.invoke(i, size));
            i = i2;
        }
        return listEmptyList;
    }
}
