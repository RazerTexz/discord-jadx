package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import com.discord.widgets.channels.list.items.ChannelListBottomNavSpaceItem;
import com.discord.widgets.channels.list.items.ChannelListItemVoiceUser;
import com.discord.widgets.stage.model.StageChannel;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function22;

/* compiled from: WidgetChannelListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u00100\u001a\u00020-2\u0006\u0010\u0001\u001a\u00020\u00002\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00070\u00022&\u0010\n\u001a\"\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\t0\u00020\u00022\u0010\u0010\f\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\n\u0010\u000e\u001a\u00060\u0003j\u0002`\u00042\u001c\u0010\u0011\u001a\u0018\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00022\u0016\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00120\u00022\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u000b2\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u000b2\u0006\u0010\u0017\u001a\u00020\u00162\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00180\u00022\u0016\u0010\u001b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u001a0\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\"\u0010#\u001a\u001e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u000f0!0\u00022\u0016\u0010%\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020$0\u00022\"\u0010'\u001a\u001e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u000f0!0\u00022\b\u0010)\u001a\u0004\u0018\u00010(2\u000e\u0010,\u001a\n\u0018\u00010*j\u0004\u0018\u0001`+H\n¢\u0006\u0004\b.\u0010/"}, d2 = {"Lcom/discord/utilities/channel/GuildChannelsInfo;", "guildChannelsInfo", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "guildChannels", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "joinedThreads", "Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "activeJoinedGuildThreads", "", "channelsWithActiveThreads", "selectedChannel", "selectedVoiceChannelId", "", "Lcom/discord/widgets/channels/list/items/ChannelListItemVoiceUser;", "voiceStates", "", "mentionCounts", "unreadChannelIds", "collapsedCategories", "Lcom/discord/stores/StoreNux$NuxState;", "nuxState", "Lcom/discord/widgets/stage/model/StageChannel;", "stageChannels", "Lcom/discord/api/stageinstance/StageInstance;", "stageInstances", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvents", "", "canCreateAnyEvent", "canGuildSeeGuildRoleSubscriptions", "Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/directory/DirectoryEntryGuild;", "directories", "Lcom/discord/stores/StoreMessageAck$Ack;", "messageAcks", "Lcom/discord/api/directory/DirectoryEntryEvent;", "directoryEvents", "Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "guildJoinRequest", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "member", "Lcom/discord/widgets/channels/list/WidgetChannelListModel;", "invoke", "(Lcom/discord/utilities/channel/GuildChannelsInfo;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Lcom/discord/api/channel/Channel;JLjava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;Lcom/discord/stores/StoreNux$NuxState;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;ZZLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/discord/api/guildjoinrequest/GuildJoinRequest;Lcom/discord/models/member/GuildMember;)Lcom/discord/widgets/channels/list/WidgetChannelListModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$getSelectedGuildChannelList$1 extends Lambda implements Function22<GuildChannelsInfo, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadsJoined.JoinedThread>, Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>>, Set<? extends Long>, Channel, Long, Map<Long, ? extends List<? extends ChannelListItemVoiceUser>>, Map<Long, ? extends Integer>, Set<? extends Long>, Set<? extends Long>, StoreNux.NuxState, Map<Long, ? extends StageChannel>, Map<Long, ? extends StageInstance>, List<? extends GuildScheduledEvent>, Boolean, Boolean, Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild>>>, Map<Long, ? extends StoreMessageAck.Ack>, Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild2>>>, GuildJoinRequest, GuildMember, WidgetChannelListModel> {
    public final /* synthetic */ long $selectedGuildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListModel$Companion$getSelectedGuildChannelList$1(long j) {
        super(22);
        this.$selectedGuildId = j;
    }

    @Override // kotlin.jvm.functions.Function22
    public /* bridge */ /* synthetic */ WidgetChannelListModel invoke(GuildChannelsInfo guildChannelsInfo, Map<Long, ? extends Channel> map, Map<Long, ? extends StoreThreadsJoined.JoinedThread> map2, Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>> map3, Set<? extends Long> set, Channel channel, Long l, Map<Long, ? extends List<? extends ChannelListItemVoiceUser>> map4, Map<Long, ? extends Integer> map5, Set<? extends Long> set2, Set<? extends Long> set3, StoreNux.NuxState nuxState, Map<Long, ? extends StageChannel> map6, Map<Long, ? extends StageInstance> map7, List<? extends GuildScheduledEvent> list, Boolean bool, Boolean bool2, Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild>>> map8, Map<Long, ? extends StoreMessageAck.Ack> map9, Map<Long, ? extends RestCallState<? extends List<? extends DirectoryEntryGuild2>>> map10, GuildJoinRequest guildJoinRequest, GuildMember guildMember) {
        return invoke(guildChannelsInfo, (Map<Long, Channel>) map, (Map<Long, StoreThreadsJoined.JoinedThread>) map2, (Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>>) map3, (Set<Long>) set, channel, l.longValue(), (Map<Long, ? extends List<ChannelListItemVoiceUser>>) map4, (Map<Long, Integer>) map5, (Set<Long>) set2, (Set<Long>) set3, nuxState, (Map<Long, StageChannel>) map6, (Map<Long, StageInstance>) map7, (List<GuildScheduledEvent>) list, bool.booleanValue(), bool2.booleanValue(), (Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild>>>) map8, (Map<Long, StoreMessageAck.Ack>) map9, (Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild2>>>) map10, guildJoinRequest, guildMember);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WidgetChannelListModel invoke(GuildChannelsInfo guildChannelsInfo, Map<Long, Channel> map, Map<Long, StoreThreadsJoined.JoinedThread> map2, Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> map3, Set<Long> set, Channel channel, long j, Map<Long, ? extends List<ChannelListItemVoiceUser>> map4, Map<Long, Integer> map5, Set<Long> set2, Set<Long> set3, StoreNux.NuxState nuxState, Map<Long, StageChannel> map6, Map<Long, StageInstance> map7, List<GuildScheduledEvent> list, boolean z2, boolean z3, Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild>>> map8, Map<Long, StoreMessageAck.Ack> map9, Map<Long, ? extends RestCallState<? extends List<DirectoryEntryGuild2>>> map10, GuildJoinRequest guildJoinRequest, GuildMember guildMember) {
        boolean z4;
        Intrinsics3.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
        Intrinsics3.checkNotNullParameter(map, "guildChannels");
        Intrinsics3.checkNotNullParameter(map2, "joinedThreads");
        Intrinsics3.checkNotNullParameter(map3, "activeJoinedGuildThreads");
        Intrinsics3.checkNotNullParameter(set, "channelsWithActiveThreads");
        Intrinsics3.checkNotNullParameter(map4, "voiceStates");
        Intrinsics3.checkNotNullParameter(map5, "mentionCounts");
        Intrinsics3.checkNotNullParameter(set2, "unreadChannelIds");
        Intrinsics3.checkNotNullParameter(set3, "collapsedCategories");
        Intrinsics3.checkNotNullParameter(nuxState, "nuxState");
        Intrinsics3.checkNotNullParameter(map6, "stageChannels");
        Intrinsics3.checkNotNullParameter(map7, "stageInstances");
        Intrinsics3.checkNotNullParameter(list, "guildScheduledEvents");
        Intrinsics3.checkNotNullParameter(map8, "directories");
        Intrinsics3.checkNotNullParameter(map9, "messageAcks");
        Intrinsics3.checkNotNullParameter(map10, "directoryEvents");
        List listPlus = _Collections.plus((Collection<? extends ChannelListBottomNavSpaceItem>) WidgetChannelListModel.Companion.access$guildListBuilder(WidgetChannelListModel.INSTANCE, this.$selectedGuildId, guildChannelsInfo, map, map3, map2, set, channel, j, map4, map5, set2, set3, map6, map7, list, z2, z3, map8, map9, map10, guildJoinRequest, guildMember), new ChannelListBottomNavSpaceItem(this.$selectedGuildId));
        if (nuxState.getGuildBoostHintGuildId() != null) {
            Long guildBoostHintGuildId = nuxState.getGuildBoostHintGuildId();
            Guild guild = guildChannelsInfo.getGuild();
            z4 = Intrinsics3.areEqual(guildBoostHintGuildId, guild != null ? Long.valueOf(guild.getId()) : null);
        }
        return new WidgetChannelListModel(guildChannelsInfo.getGuild(), listPlus, true, z4, false, null, 32, null);
    }
}
