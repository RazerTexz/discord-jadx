package com.discord.widgets.channels.memberlist;

import com.discord.api.channel.Channel;
import com.discord.api.presence.ClientStatus;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreChannelMembers;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreThreadsJoined;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.utilities.lazy.memberlist.ThreadMemberList;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import kotlin.Metadata;

/* compiled from: ThreadMemberListItemGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÃ\u0001\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0001\u001a\u00020\u00002\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020\n0\u00022\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020\f0\u00022\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020\u000e0\u00022\u0016\u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020\u00100\u00022\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\t0\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001c\u001aO\u0010!\u001a*\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001dj\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e` 2\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0002¢\u0006\u0004\b!\u0010\"\u001aw\u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\u001f2\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\t\u0012\u0004\u0012\u00020\n0\u00022\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022.\u0010$\u001a*\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001dj\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e` H\u0002¢\u0006\u0004\b&\u0010'\u001aa\u0010,\u001a\u00020+2\n\u0010*\u001a\u00060(j\u0002`)2\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022.\u0010$\u001a*\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001dj\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e` ¢\u0006\u0004\b,\u0010-\")\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u001f0.j\b\u0012\u0004\u0012\u00020\u001f`/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "guildMembers", "Lcom/discord/models/user/User;", "users", "Lcom/discord/models/presence/Presence;", "presences", "Lcom/discord/models/domain/ModelApplicationStream;", "streams", "", "threadMembers", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "joinedThread", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreEmojiCustom;", "storeEmojiCustom", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "generateThreadMemberListItems", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Lcom/discord/stores/StoreThreadsJoined$JoinedThread;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreEmojiCustom;)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "Ljava/util/LinkedHashMap;", "Ljava/util/SortedSet;", "Lcom/discord/utilities/lazy/memberlist/MemberListRow$Member;", "Lkotlin/collections/LinkedHashMap;", "initializeOrderedMap", "(Ljava/util/Map;)Ljava/util/LinkedHashMap;", "member", "threadMemberMap", "", "insertMemberIntoMap", "(Lcom/discord/utilities/lazy/memberlist/MemberListRow$Member;Ljava/util/Map;Ljava/util/Map;Ljava/util/LinkedHashMap;)V", "", "Lcom/discord/primitives/MemberListId;", "listId", "Lcom/discord/utilities/lazy/memberlist/ThreadMemberList;", "createThreadMemberList", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/LinkedHashMap;)Lcom/discord/utilities/lazy/memberlist/ThreadMemberList;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "ALPHABETICAL_COMPARATOR", "Ljava/util/Comparator;", "getALPHABETICAL_COMPARATOR", "()Ljava/util/Comparator;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.memberlist.ThreadMemberListItemGeneratorKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ThreadMemberListItemGenerator {
    private static final Comparator<MemberListRow.Member> ALPHABETICAL_COMPARATOR = ThreadMemberListItemGenerator2.INSTANCE;

    public static final ThreadMemberList createThreadMemberList(String str, Map<Long, GuildRole> map, LinkedHashMap<Long, SortedSet<MemberListRow.Member>> linkedHashMap) {
        String name;
        Intrinsics3.checkNotNullParameter(str, "listId");
        Intrinsics3.checkNotNullParameter(map, "roles");
        Intrinsics3.checkNotNullParameter(linkedHashMap, "threadMemberMap");
        int i = 0;
        ThreadMemberList threadMemberList = new ThreadMemberList(str, 0, 2, null);
        for (Map.Entry<Long, SortedSet<MemberListRow.Member>> entry : linkedHashMap.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            SortedSet<MemberListRow.Member> value = entry.getValue();
            if (!value.isEmpty()) {
                MemberListRow.StatusHeader.Type type = MemberListRow.StatusHeader.Type.ONLINE;
                if (jLongValue == type.getId()) {
                    threadMemberList.add(new MemberListRow.StatusHeader(type.name(), type, value.size()));
                } else {
                    MemberListRow.StatusHeader.Type type2 = MemberListRow.StatusHeader.Type.OFFLINE;
                    if (jLongValue == type2.getId()) {
                        threadMemberList.add(new MemberListRow.StatusHeader(type2.name(), type2, value.size()));
                    } else {
                        GuildRole guildRole = map.get(Long.valueOf(jLongValue));
                        if (guildRole == null || (name = guildRole.getName()) == null) {
                            name = "";
                        }
                        threadMemberList.add(new MemberListRow.RoleHeader(jLongValue, name, value.size()));
                    }
                }
                threadMemberList.getGroupIndices().put(Integer.valueOf(i), String.valueOf(jLongValue));
                int size = value.size() + 1 + i;
                Iterator<T> it = value.iterator();
                while (it.hasNext()) {
                    threadMemberList.add((MemberListRow.Member) it.next());
                }
                i = size;
            }
        }
        return threadMemberList;
    }

    public static final WidgetChannelMembersListViewModel.MemberList generateThreadMemberListItems(Channel channel, Map<Long, GuildRole> map, Guild guild, Map<Long, GuildMember> map2, Map<Long, ? extends User> map3, Map<Long, Presence> map4, Map<Long, ? extends ModelApplicationStream> map5, Set<Long> set, StoreThreadsJoined.JoinedThread joinedThread, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom) {
        Map<Long, Presence> map6 = map4;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(map, "roles");
        Intrinsics3.checkNotNullParameter(map2, "guildMembers");
        Intrinsics3.checkNotNullParameter(map3, "users");
        Intrinsics3.checkNotNullParameter(map6, "presences");
        Intrinsics3.checkNotNullParameter(map5, "streams");
        Intrinsics3.checkNotNullParameter(set, "threadMembers");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeEmojiCustom, "storeEmojiCustom");
        boolean z2 = joinedThread != null;
        if (set.isEmpty()) {
            return GuildMemberListItemGenerator.generateGuildMemberListItems(new ThreadMemberList(String.valueOf(channel.getId()), map2.size()), guild, channel, map, false, z2, storeGuilds, storeEmojiCustom);
        }
        LinkedHashMap<Long, SortedSet<MemberListRow.Member>> linkedHashMapInitializeOrderedMap = initializeOrderedMap(map);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            LinkedHashMap<Long, SortedSet<MemberListRow.Member>> linkedHashMap = linkedHashMapInitializeOrderedMap;
            MemberListRow.Member memberMakeRowMember = StoreChannelMembers.INSTANCE.makeRowMember(jLongValue, map2, map3, map6.get(Long.valueOf(jLongValue)), map5.containsKey(Long.valueOf(jLongValue)), false);
            if (memberMakeRowMember != null) {
                insertMemberIntoMap(memberMakeRowMember, map2, map, linkedHashMap);
            }
            linkedHashMapInitializeOrderedMap = linkedHashMap;
            map6 = map4;
        }
        return GuildMemberListItemGenerator.generateGuildMemberListItems(createThreadMemberList(String.valueOf(channel.getId()), map, linkedHashMapInitializeOrderedMap), guild, channel, map, false, z2, storeGuilds, storeEmojiCustom);
    }

    public static final Comparator<MemberListRow.Member> getALPHABETICAL_COMPARATOR() {
        return ALPHABETICAL_COMPARATOR;
    }

    private static final LinkedHashMap<Long, SortedSet<MemberListRow.Member>> initializeOrderedMap(Map<Long, GuildRole> map) {
        LinkedHashMap<Long, SortedSet<MemberListRow.Member>> linkedHashMap = new LinkedHashMap<>();
        Collection<GuildRole> collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((GuildRole) obj).getHoist()) {
                arrayList.add(obj);
            }
        }
        Iterator it = _Collections.sortedWith(arrayList, RoleUtils.getROLE_COMPARATOR()).iterator();
        while (it.hasNext()) {
            linkedHashMap.put(Long.valueOf(((GuildRole) it.next()).getId()), SetsJVM.sortedSetOf(ALPHABETICAL_COMPARATOR, new MemberListRow.Member[0]));
        }
        Long lValueOf = Long.valueOf(MemberListRow.StatusHeader.Type.ONLINE.getId());
        Comparator<MemberListRow.Member> comparator = ALPHABETICAL_COMPARATOR;
        linkedHashMap.put(lValueOf, SetsJVM.sortedSetOf(comparator, new MemberListRow.Member[0]));
        linkedHashMap.put(Long.valueOf(MemberListRow.StatusHeader.Type.OFFLINE.getId()), SetsJVM.sortedSetOf(comparator, new MemberListRow.Member[0]));
        return linkedHashMap;
    }

    private static final void insertMemberIntoMap(MemberListRow.Member member, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, LinkedHashMap<Long, SortedSet<MemberListRow.Member>> linkedHashMap) {
        SortedSet<MemberListRow.Member> sortedSet;
        GuildMember guildMember = map.get(Long.valueOf(member.getUserId()));
        Presence presence = member.getPresence();
        boolean z2 = false;
        boolean z3 = (presence != null ? presence.getStatus() : null) == null || member.getPresence().getStatus() == ClientStatus.INVISIBLE || member.getPresence().getStatus() == ClientStatus.OFFLINE;
        if ((guildMember != null ? Long.valueOf(guildMember.getHoistRoleId()) : null) != null && guildMember.getHoistRoleId() != 0) {
            z2 = true;
        }
        if (z3) {
            MemberListRow.StatusHeader.Type type = MemberListRow.StatusHeader.Type.OFFLINE;
            SortedSet<MemberListRow.Member> sortedSet2 = linkedHashMap.get(Long.valueOf(type.getId()));
            if (sortedSet2 != null) {
                sortedSet2.add(member);
                linkedHashMap.put(Long.valueOf(type.getId()), sortedSet2);
                return;
            }
        } else if (z2) {
            GuildRole guildRole = map2.get(guildMember != null ? Long.valueOf(guildMember.getHoistRoleId()) : null);
            if (guildRole != null && (sortedSet = linkedHashMap.get(Long.valueOf(guildRole.getId()))) != null) {
                sortedSet.add(member);
                linkedHashMap.put(Long.valueOf(guildRole.getId()), sortedSet);
                return;
            }
        }
        MemberListRow.StatusHeader.Type type2 = MemberListRow.StatusHeader.Type.ONLINE;
        SortedSet<MemberListRow.Member> sortedSet3 = linkedHashMap.get(Long.valueOf(type2.getId()));
        if (sortedSet3 != null) {
            sortedSet3.add(member);
            linkedHashMap.put(Long.valueOf(type2.getId()), sortedSet3);
        }
    }
}
