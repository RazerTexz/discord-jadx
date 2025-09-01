package com.discord.widgets.channels.memberlist;

import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.utilities.collections.SparseMutableList;
import com.discord.utilities.lazy.memberlist.MemberList;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import com.discord.widgets.forums.ForumUtils;
import d0.g0.StringNumberConversions;
import d0.t.Collections2;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;

/* compiled from: GuildMemberListItemGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a_\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014\u001a_\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0016\u001a\u00060\u0007j\u0002`\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\t0\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\"\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/lazy/memberlist/MemberList;", "channelMemberList", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/channel/Channel;", "channel", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "", "canInvite", "isThreadJoined", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreEmojiCustom;", "storeCustomEmojis", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "generateGuildMemberListItems", "(Lcom/discord/utilities/lazy/memberlist/MemberList;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Map;ZZLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreEmojiCustom;)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/models/presence/Presence;", "presence", "calculateCanDisplayStatusEmoji", "(Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreEmojiCustom;JLcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Lcom/discord/models/presence/Presence;Ljava/util/Map;)Z", "", "Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item$PlaceholderMember;", "PLACEHOLDER_INSTANCES", "Ljava/util/List;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.memberlist.GuildMemberListItemGeneratorKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildMemberListItemGenerator {
    private static final List<ChannelMembersListAdapter.Item.PlaceholderMember> PLACEHOLDER_INSTANCES = Collections2.listOf((Object[]) new ChannelMembersListAdapter.Item.PlaceholderMember[]{new ChannelMembersListAdapter.Item.PlaceholderMember(0.7f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.3f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.6f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.4f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.6f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.8f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.3f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.5f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.7f), new ChannelMembersListAdapter.Item.PlaceholderMember(0.4f)});

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.memberlist.GuildMemberListItemGeneratorKt$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            MemberListRow.StatusHeader.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[MemberListRow.StatusHeader.Type.ONLINE.ordinal()] = 1;
            iArr[MemberListRow.StatusHeader.Type.OFFLINE.ordinal()] = 2;
        }
    }

    public static final /* synthetic */ boolean access$calculateCanDisplayStatusEmoji(StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, long j, Guild guild, Channel channel, Presence presence, Map map) {
        return calculateCanDisplayStatusEmoji(storeGuilds, storeEmojiCustom, j, guild, channel, presence, map);
    }

    public static final /* synthetic */ List access$getPLACEHOLDER_INSTANCES$p() {
        return PLACEHOLDER_INSTANCES;
    }

    private static final boolean calculateCanDisplayStatusEmoji(StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, long j, Guild guild, Channel channel, Presence presence, Map<Long, GuildRole> map) {
        Activity customStatusActivity;
        ActivityEmoji emoji;
        String id2;
        Long longOrNull;
        long guildId = channel.getGuildId();
        if (PermissionUtils.can(Permission.USE_EXTERNAL_EMOJIS, Long.valueOf(PermissionUtils.computeNonThreadPermissions(j, channel.getGuildId(), guild != null ? guild.getOwnerId() : 0L, storeGuilds.getMember(guildId, j), map, channel.v()))) || presence == null || (customStatusActivity = PresenceUtils.INSTANCE.getCustomStatusActivity(presence)) == null || (emoji = customStatusActivity.getEmoji()) == null || (id2 = emoji.getId()) == null || (longOrNull = StringNumberConversions.toLongOrNull(id2)) == null) {
            return true;
        }
        return storeEmojiCustom.getEmojiForGuild(guildId).get(Long.valueOf(longOrNull.longValue())) != null;
    }

    public static final WidgetChannelMembersListViewModel.MemberList generateGuildMemberListItems(MemberList memberList, Guild guild, Channel channel, Map<Long, GuildRole> map, boolean z2, boolean z3, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom) {
        Intrinsics3.checkNotNullParameter(memberList, "channelMemberList");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(map, "guildRoles");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeEmojiCustom, "storeCustomEmojis");
        SparseMutableList<R> sparseMutableListDeepCopy = memberList.getRows().deepCopy(new GuildMemberListItemGenerator2(storeGuilds, storeEmojiCustom, guild, channel, map));
        if ((!sparseMutableListDeepCopy.isEmpty()) && _Collections.first((List) sparseMutableListDeepCopy) == null) {
            sparseMutableListDeepCopy.set(0, new ChannelMembersListAdapter.Item.PlaceholderHeader(memberList.getListId()));
        }
        SortedMap<Integer, String> groupIndices = memberList.getGroupIndices();
        int size = memberList.getSize();
        if (!z2) {
            if (ChannelUtils.H(channel) && (!ChannelUtils.s(channel, null, 1) || !ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, 2, null))) {
                sparseMutableListDeepCopy.add(0, new ChannelMembersListAdapter.Item.JoinLeaveThread(memberList.getListId(), z3));
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(groupIndices.size()));
                Iterator<T> it = groupIndices.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(Integer.valueOf(((Number) entry.getKey()).intValue() + 1), entry.getValue());
                }
                groupIndices = MapsJVM.toSortedMap(linkedHashMap);
            }
            return new GuildMemberListItemGenerator3(memberList.getListId(), size, sparseMutableListDeepCopy, groupIndices);
        }
        sparseMutableListDeepCopy.add(0, new ChannelMembersListAdapter.Item.AddMember(memberList.getListId(), R.string.invite_members));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(groupIndices.size()));
        Iterator<T> it2 = groupIndices.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(Integer.valueOf(((Number) entry2.getKey()).intValue() + 1), entry2.getValue());
        }
        groupIndices = MapsJVM.toSortedMap(linkedHashMap2);
        size++;
        return new GuildMemberListItemGenerator3(memberList.getListId(), size, sparseMutableListDeepCopy, groupIndices);
    }
}
