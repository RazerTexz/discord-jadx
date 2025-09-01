package com.discord.widgets.channels.list;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.models.guild.Guild;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceChannel;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemVoiceChannel;", "invoke", "()Lcom/discord/widgets/channels/list/items/ChannelListItemVoiceChannel;", "com/discord/widgets/channels/list/WidgetChannelListModel$Companion$guildListBuilder$6$5", "toChannelListItemVoiceChannel"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$5 extends Lambda implements Function0<ChannelListItemVoiceChannel> {
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$4 $areAllChildThreadsRead$4$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$5 $areAnyChildThreadsSelected$5$inlined;
    public final /* synthetic */ boolean $canSeeGuildRoleSubscriptions$inlined;
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Set $channelsWithActiveThreads$inlined;
    public final /* synthetic */ Set $collapsedCategories$inlined;
    public final /* synthetic */ Map $directories$inlined;
    public final /* synthetic */ Map $directoryEvents$inlined;
    public final /* synthetic */ HashSet $forceViewCategories$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2 $getVocalChannelData$2;
    public final /* synthetic */ GuildChannelsInfo $guild$inlined;
    public final /* synthetic */ List $guildScheduledEvents$inlined;
    public final /* synthetic */ HashSet $hiddenChannelsIds$inlined;
    public final /* synthetic */ boolean $isGuildHub$inlined;
    public final /* synthetic */ WidgetChannelListModel$Companion$guildListBuilder$3 $isThreadUnread$3$inlined;
    public final /* synthetic */ ArrayList $items$inlined;
    public final /* synthetic */ Map $joinedThreads$inlined;
    public final /* synthetic */ Map $mentionCounts$inlined;
    public final /* synthetic */ Map $messageAcks$inlined;
    public final /* synthetic */ Long $permissions;
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
    public WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$5(WidgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2 widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2, Channel channel, Long l, GuildChannelsInfo guildChannelsInfo, HashSet hashSet, boolean z2, Channel channel2, Map map, Set set, long j, WidgetChannelListModel$Companion$guildListBuilder$5 widgetChannelListModel$Companion$guildListBuilder$5, Set set2, WidgetChannelListModel$Companion$guildListBuilder$3 widgetChannelListModel$Companion$guildListBuilder$3, HashSet hashSet2, WidgetChannelListModel$Companion$guildListBuilder$4 widgetChannelListModel$Companion$guildListBuilder$4, long j2, Map map2, boolean z3, Set set3, List list, Map map3, Map map4, Map map5, Map map6, ArrayList arrayList, WidgetChannelListModel$Companion$guildListBuilder$2 widgetChannelListModel$Companion$guildListBuilder$2, Map map7, Map map8, Map map9) {
        super(0);
        this.$getVocalChannelData$2 = widgetChannelListModel$Companion$guildListBuilder$$inlined$forEach$lambda$2;
        this.$channel = channel;
        this.$permissions = l;
        this.$guild$inlined = guildChannelsInfo;
        this.$forceViewCategories$inlined = hashSet;
        this.$isGuildHub$inlined = z2;
        this.$selectedChannel$inlined = channel2;
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

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ChannelListItemVoiceChannel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b2  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ChannelListItemVoiceChannel invoke() {
        boolean z2;
        Guild guild;
        boolean z3;
        WidgetChannelListModel.Companion.VocalChannelData vocalChannelDataInvoke2 = this.$getVocalChannelData$2.invoke2(this.$channel);
        ChannelListItemVoiceChannel channelListItemVoiceChannel = null;
        if (vocalChannelDataInvoke2 != null) {
            Iterator it = this.$guildScheduledEvents$inlined.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
                if (guildScheduledEvent.getStatus() == GuildScheduledEventStatus.ACTIVE) {
                    Long channelId = guildScheduledEvent.getChannelId();
                    boolean z4 = channelId != null && channelId.longValue() == this.$channel.getId();
                    if (z4) {
                        channelListItemVoiceChannel = next;
                        break;
                    }
                }
            }
            GuildScheduledEvent guildScheduledEvent2 = (GuildScheduledEvent) channelListItemVoiceChannel;
            Collection collection = (Collection) outline.d(this.$channel, this.$voiceStates$inlined);
            if (collection == null) {
                z2 = false;
                Channel channel = this.$channel;
                boolean textChannelSelected = vocalChannelDataInvoke2.getTextChannelSelected();
                boolean voiceChannelSelected = vocalChannelDataInvoke2.getVoiceChannelSelected();
                Long l = this.$permissions;
                int mentionCount = vocalChannelDataInvoke2.getMentionCount();
                boolean unread = vocalChannelDataInvoke2.getUnread();
                int numUsersConnected = vocalChannelDataInvoke2.getNumUsersConnected();
                boolean locked = vocalChannelDataInvoke2.getLocked();
                boolean nsfw = vocalChannelDataInvoke2.getNsfw();
                guild = this.$guild$inlined.getGuild();
                if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
                    GuildMaxVideoChannelUsers maxVideoChannelUsers = GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
                }
                channelListItemVoiceChannel = new ChannelListItemVoiceChannel(channel, textChannelSelected, voiceChannelSelected, l, mentionCount, unread, numUsersConnected, locked, nsfw, z2, maxVideoChannelUsers, vocalChannelDataInvoke2.isGuildRoleSubscriptionLockedChannel(), vocalChannelDataInvoke2.isGuildRoleSubscriptionChannel(), guildScheduledEvent2);
            } else if (collection.isEmpty()) {
                z3 = false;
                if (!z3) {
                    z2 = true;
                }
                Channel channel2 = this.$channel;
                boolean textChannelSelected2 = vocalChannelDataInvoke2.getTextChannelSelected();
                boolean voiceChannelSelected2 = vocalChannelDataInvoke2.getVoiceChannelSelected();
                Long l2 = this.$permissions;
                int mentionCount2 = vocalChannelDataInvoke2.getMentionCount();
                boolean unread2 = vocalChannelDataInvoke2.getUnread();
                int numUsersConnected2 = vocalChannelDataInvoke2.getNumUsersConnected();
                boolean locked2 = vocalChannelDataInvoke2.getLocked();
                boolean nsfw2 = vocalChannelDataInvoke2.getNsfw();
                guild = this.$guild$inlined.getGuild();
                if (guild == null) {
                    GuildMaxVideoChannelUsers maxVideoChannelUsers2 = GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
                    channelListItemVoiceChannel = new ChannelListItemVoiceChannel(channel2, textChannelSelected2, voiceChannelSelected2, l2, mentionCount2, unread2, numUsersConnected2, locked2, nsfw2, z2, maxVideoChannelUsers2, vocalChannelDataInvoke2.isGuildRoleSubscriptionLockedChannel(), vocalChannelDataInvoke2.isGuildRoleSubscriptionChannel(), guildScheduledEvent2);
                }
            } else {
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (((ChannelListItemVoiceUser) it2.next()).getVoiceState().getSelfVideo()) {
                        z3 = true;
                        break;
                    }
                }
                z3 = false;
                if (!z3) {
                }
                Channel channel22 = this.$channel;
                boolean textChannelSelected22 = vocalChannelDataInvoke2.getTextChannelSelected();
                boolean voiceChannelSelected22 = vocalChannelDataInvoke2.getVoiceChannelSelected();
                Long l22 = this.$permissions;
                int mentionCount22 = vocalChannelDataInvoke2.getMentionCount();
                boolean unread22 = vocalChannelDataInvoke2.getUnread();
                int numUsersConnected22 = vocalChannelDataInvoke2.getNumUsersConnected();
                boolean locked22 = vocalChannelDataInvoke2.getLocked();
                boolean nsfw22 = vocalChannelDataInvoke2.getNsfw();
                guild = this.$guild$inlined.getGuild();
                if (guild == null) {
                }
            }
        }
        return channelListItemVoiceChannel;
    }
}
