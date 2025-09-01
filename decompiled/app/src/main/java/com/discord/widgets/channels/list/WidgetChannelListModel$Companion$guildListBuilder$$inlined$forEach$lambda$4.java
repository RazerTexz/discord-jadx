package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreThreadsJoined;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import com.discord.widgets.channels.list.items.ChannelListItemThread;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetChannelListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/api/channel/Channel;", "thread", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "joinedThread", "Lcom/discord/widgets/channels/list/items/ChannelListItemThread;", "invoke", "(Lcom/discord/api/channel/Channel;Lcom/discord/stores/StoreThreadsJoined$JoinedThread;)Lcom/discord/widgets/channels/list/items/ChannelListItemThread;", "com/discord/widgets/channels/list/WidgetChannelListModel$Companion$guildListBuilder$6$4", "toChannelListItemThread"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4 extends Lambda implements Function2<Channel, StoreThreadsJoined.JoinedThread, ChannelListItemThread> {
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$4 $areAllChildThreadsRead$4$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$5 $areAnyChildThreadsSelected$5$inlined;
    public final /* synthetic */ boolean $canSeeGuildRoleSubscriptions$inlined;
    public final /* synthetic */ Set $channelsWithActiveThreads$inlined;
    public final /* synthetic */ Set $collapsedCategories$inlined;
    public final /* synthetic */ Map $directories$inlined;
    public final /* synthetic */ Map $directoryEvents$inlined;
    public final /* synthetic */ HashSet $forceViewCategories$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 $getTextLikeChannelData$1;
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
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$2 $tryRemoveEmptyCategory$2$inlined;
    public final /* synthetic */ Set $unreadChannelIds$inlined;
    public final /* synthetic */ Map $voiceStates$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$4(WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1, GuildChannelsInfo guildChannelsInfo, HashSet hashSet, boolean z2, Channel channel, Map map, Set set, long j, WidgetChannelListModel$Companion$guildListBuilder$5 widgetChannelListModel$Companion$guildListBuilder$5, Set set2, WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$3, HashSet hashSet2, WidgetChannelListModel$Companion$guildListBuilder$4 widgetChannelListModel$Companion$guildListBuilder$4, long j2, Map map2, boolean z3, Set set3, List list, Map map3, Map map4, Map map5, Map map6, ArrayList arrayList, WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$2, Map map7, Map map8, Map map9) {
        super(2);
        this.$getTextLikeChannelData$1 = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$1;
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

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ChannelListItemThread invoke(Channel channel, StoreThreadsJoined.JoinedThread joinedThread) {
        return invoke2(channel, joinedThread);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ChannelListItemThread invoke2(Channel channel, StoreThreadsJoined.JoinedThread joinedThread) {
        Intrinsics3.checkNotNullParameter(channel, "thread");
        Long l = this.$guild$inlined.getChannelPermissions().get(Long.valueOf(channel.getId()));
        ModelNotificationSettings.ChannelOverride channelOverride = this.$guild$inlined.getNotificationSettings().getChannelOverride(channel.getParentId());
        boolean z2 = channelOverride != null && channelOverride.isMuted();
        boolean z3 = joinedThread != null && joinedThread.getMuted();
        if (!PermissionUtils.INSTANCE.hasAccess(channel, l)) {
            return null;
        }
        WidgetChannelListModel.Companion.TextLikeChannelData textLikeChannelDataInvoke = this.$getTextLikeChannelData$1.invoke(channel, z3, Boolean.valueOf(z2));
        if (textLikeChannelDataInvoke.getHide()) {
            return null;
        }
        return new ChannelListItemThread(channel, textLikeChannelDataInvoke.getSelected(), textLikeChannelDataInvoke.getMentionCount(), textLikeChannelDataInvoke.getUnread(), textLikeChannelDataInvoke.getLocked(), z3);
    }
}
