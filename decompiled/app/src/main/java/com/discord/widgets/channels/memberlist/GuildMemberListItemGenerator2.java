package com.discord.widgets.channels.memberlist;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildMemberListItemGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/lazy/memberlist/MemberListRow;", "row", "Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item;", "invoke", "(Lcom/discord/utilities/lazy/memberlist/MemberListRow;)Lcom/discord/widgets/channels/memberlist/adapter/ChannelMembersListAdapter$Item;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.memberlist.GuildMemberListItemGeneratorKt$generateGuildMemberListItems$listItems$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildMemberListItemGenerator2 extends Lambda implements Function1<MemberListRow, ChannelMembersListAdapter.Item> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ Map $guildRoles;
    public final /* synthetic */ StoreEmojiCustom $storeCustomEmojis;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMemberListItemGenerator2(StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, Guild guild, Channel channel, Map map) {
        super(1);
        this.$storeGuilds = storeGuilds;
        this.$storeCustomEmojis = storeEmojiCustom;
        this.$guild = guild;
        this.$channel = channel;
        this.$guildRoles = map;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ChannelMembersListAdapter.Item invoke2(MemberListRow memberListRow) {
        ChannelMembersListAdapter.Item roleHeader;
        ChannelMembersListAdapter.Item.Header.Type type;
        Intrinsics3.checkNotNullParameter(memberListRow, "row");
        if (memberListRow instanceof MemberListRow.StatusHeader) {
            String rowId = memberListRow.getRowId();
            MemberListRow.StatusHeader statusHeader = (MemberListRow.StatusHeader) memberListRow;
            int iOrdinal = statusHeader.getType().ordinal();
            if (iOrdinal == 0) {
                type = ChannelMembersListAdapter.Item.Header.Type.ONLINE;
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                type = ChannelMembersListAdapter.Item.Header.Type.OFFLINE;
            }
            roleHeader = new ChannelMembersListAdapter.Item.Header(rowId, type, statusHeader.getMemberCount());
        } else {
            if (memberListRow instanceof MemberListRow.Member) {
                MemberListRow.Member member = (MemberListRow.Member) memberListRow;
                boolean zAccess$calculateCanDisplayStatusEmoji = GuildMemberListItemGenerator.access$calculateCanDisplayStatusEmoji(this.$storeGuilds, this.$storeCustomEmojis, member.getUserId(), this.$guild, this.$channel, member.getPresence(), this.$guildRoles);
                long userId = member.getUserId();
                Guild guild = this.$guild;
                roleHeader = new ChannelMembersListAdapter.Item.Member(userId, guild != null ? Long.valueOf(guild.getId()) : null, member.getName(), member.isBot(), member.getTagText(), member.getTagVerified(), member.getPresence(), member.getColor(), member.getAvatarUrl(), member.getShowOwnerIndicator(), member.getPremiumSince(), member.isApplicationStreaming(), zAccess$calculateCanDisplayStatusEmoji, member.getUserFlags());
            } else {
                if (!(memberListRow instanceof MemberListRow.RoleHeader)) {
                    throw new NoWhenBranchMatchedException();
                }
                MemberListRow.RoleHeader roleHeader2 = (MemberListRow.RoleHeader) memberListRow;
                long roleId = roleHeader2.getRoleId();
                String roleName = roleHeader2.getRoleName();
                int memberCount = roleHeader2.getMemberCount();
                Guild guild2 = this.$guild;
                roleHeader = new ChannelMembersListAdapter.Item.RoleHeader(roleId, roleName, memberCount, guild2 != null ? Long.valueOf(guild2.getId()) : null);
            }
        }
        return roleHeader;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ChannelMembersListAdapter.Item invoke(MemberListRow memberListRow) {
        return invoke2(memberListRow);
    }
}
