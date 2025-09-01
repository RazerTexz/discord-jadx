package com.discord.widgets.channels.memberlist;

import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelRecipientNick;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import kotlin.Metadata;

/* compiled from: PrivateChannelMemberListItemGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ae\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00070\u00022\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a;\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "users", "Lcom/discord/models/presence/Presence;", "presences", "Lcom/discord/models/domain/ModelApplicationStream;", "applicationStreams", "", "canInvite", "Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "generateGroupDmMemberListItems", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Z)Lcom/discord/widgets/channels/memberlist/WidgetChannelMembersListViewModel$MemberList;", "user", "presence", "isOwner", "", ModelAuditLogEntry.CHANGE_KEY_NICK, "isApplicationStreaming", "Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item$Member;", "createMemberListItem", "(Lcom/discord/models/user/User;Lcom/discord/models/presence/Presence;ZLjava/lang/String;Z)Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item$Member;", "", "memberCount", "Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item$Header;", "createGroupDmHeader", "(I)Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item$Header;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListItemGeneratorKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class PrivateChannelMemberListItemGenerator {
    private static final ChannelMembersListAdapter.Item.Header createGroupDmHeader(int i) {
        return new ChannelMembersListAdapter.Item.Header("%group_header_key", ChannelMembersListAdapter.Item.Header.Type.GROUP_DM, i);
    }

    private static final ChannelMembersListAdapter.Item.Member createMemberListItem(User user, Presence presence, boolean z2, String str, boolean z3) {
        return new ChannelMembersListAdapter.Item.Member(user.getId(), null, str != null ? str : user.getUsername(), user.getIsBot(), Integer.valueOf(user.getIsSystemUser() ? R.string.system_dm_tag_system : R.string.bot_tag_bot), UserUtils.INSTANCE.isVerifiedBot(user), presence, null, IconUtils.getForUser$default(user, false, null, 6, null), z2, null, z3, true, user.getFlags() | user.getPublicFlags());
    }

    public static final WidgetChannelMembersListViewModel.MemberList generateGroupDmMemberListItems(Channel channel, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3, boolean z2) {
        Object next;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(map, "users");
        Intrinsics3.checkNotNullParameter(map2, "presences");
        Intrinsics3.checkNotNullParameter(map3, "applicationStreams");
        PrivateChannelMemberListItemGenerator2 privateChannelMemberListItemGenerator2 = PrivateChannelMemberListItemGenerator2.INSTANCE;
        Object privateChannelMemberListItemGenerator3 = privateChannelMemberListItemGenerator2;
        if (privateChannelMemberListItemGenerator2 != null) {
            privateChannelMemberListItemGenerator3 = new PrivateChannelMemberListItemGenerator3(privateChannelMemberListItemGenerator2);
        }
        TreeMap treeMap = new TreeMap((Comparator) privateChannelMemberListItemGenerator3);
        Iterator<T> it = map.values().iterator();
        while (true) {
            boolean z3 = false;
            if (!it.hasNext()) {
                break;
            }
            User user = (User) it.next();
            StringBuilder sb = new StringBuilder();
            String username = user.getUsername();
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(username, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = username.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            sb.append(lowerCase);
            sb.append(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
            String string = sb.toString();
            List<ChannelRecipientNick> listQ = channel.q();
            String nick = null;
            if (listQ != null) {
                Iterator<T> it2 = listQ.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    if (((ChannelRecipientNick) next).b() == user.getId()) {
                        break;
                    }
                }
                ChannelRecipientNick channelRecipientNick = (ChannelRecipientNick) next;
                if (channelRecipientNick != null) {
                    nick = channelRecipientNick.getNick();
                }
            }
            if (channel.getOwnerId() == user.getId()) {
                z3 = true;
            }
            treeMap.put(string, createMemberListItem(user, (Presence) outline.f(user, map2), z3, nick, map3.containsKey(Long.valueOf(user.getId()))));
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size + 1);
        if (z2) {
            arrayList.add(0, new ChannelMembersListAdapter.Item.AddMember(String.valueOf(channel.getId()), ChannelUtils.p(channel) ? R.string.group_dm_add_friends : R.string.create_group_dm));
        }
        arrayList.add(createGroupDmHeader(size));
        arrayList.addAll(treeMap.values());
        return new PrivateChannelMemberListItemGenerator4(String.valueOf(channel.getId()), arrayList);
    }
}
