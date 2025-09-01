package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.thread.ThreadMetadata;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildWelcomeEntry;
import com.discord.widgets.chat.list.entries.StartOfChatEntry;
import com.discord.widgets.chat.list.entries.StartOfPrivateChatEntry;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func9;

/* compiled from: WidgetChatListModelTop.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0019\u001a\n \u0003*\u0004\u0018\u00010\u00160\u00162\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u000e\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2:\u0010\u0011\u001a6\u0012\b\u0012\u00060\u0005j\u0002`\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0010 \u0003*\u001a\u0012\b\u0012\u00060\u0005j\u0002`\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0010\u0018\u00010\u000e0\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0015\u001a\n \u0003*\u0004\u0018\u00010\u00140\u0014H\n¢\u0006\u0004\b\u0017\u0010\u0018"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "", "Lcom/discord/api/permission/PermissionBit;", "channelPermissions", "guildDefaultChannelId", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "channelOwnerMember", "Lcom/discord/models/user/User;", "channelOwnerUser", "", "Lcom/discord/primitives/UserId;", "", "mutualGuildsByUser", "Lcom/discord/api/channel/Channel;", "parentChannel", "", "canAccessRedesignedForumChannels", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;Ljava/lang/Long;Ljava/lang/Long;Lcom/discord/models/member/GuildMember;Lcom/discord/models/user/User;Ljava/util/Map;Lcom/discord/api/channel/Channel;Ljava/lang/Boolean;)Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$getWelcomeEntry$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModelTop4<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Guild, MeUser, Long, Long, GuildMember, User, Map<Long, ? extends List<? extends Guild>>, Channel, Boolean, ChatListEntry> {
    public final /* synthetic */ Channel $channel;

    public WidgetChatListModelTop4(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func9
    public /* bridge */ /* synthetic */ ChatListEntry call(Guild guild, MeUser meUser, Long l, Long l2, GuildMember guildMember, User user, Map<Long, ? extends List<? extends Guild>> map, Channel channel, Boolean bool) {
        return call2(guild, meUser, l, l2, guildMember, user, (Map<Long, ? extends List<Guild>>) map, channel, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final ChatListEntry call2(Guild guild, MeUser meUser, Long l, Long l2, GuildMember guildMember, User user, Map<Long, ? extends List<Guild>> map, Channel channel, Boolean bool) {
        boolean z2 = l2 != null && this.$channel.getId() == l2.longValue();
        boolean z3 = guild != null && guild.hasIcon();
        boolean zCan = PermissionUtils.can(Permission.READ_MESSAGE_HISTORY, l);
        boolean zCan2 = PermissionUtils.can(1L, l);
        boolean zCan3 = PermissionUtils.can(16L, l);
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        boolean zCanManageThread = threadUtils.canManageThread(meUser, this.$channel, l);
        User userA = ChannelUtils.a(this.$channel);
        List<Guild> listEmptyList = map.get(Long.valueOf(userA != null ? userA.getId() : 0L));
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        boolean zIsOwner = guild != null ? guild.isOwner(meUser.getId()) : false;
        if (ChannelUtils.v(this.$channel) && guild != null && z2 && zCan && (zCan2 || !z3)) {
            long id2 = guild.getId();
            String name = guild.getName();
            return new GuildWelcomeEntry(zIsOwner, z3, zCan2, id2, name != null ? name : "");
        }
        if (ChannelUtils.B(this.$channel)) {
            return new StartOfPrivateChatEntry(this.$channel.getId(), ChannelUtils.c(this.$channel), this.$channel.getType(), IconUtils.getForChannel$default(this.$channel, null, 2, null), ChannelUtils.E(this.$channel), listEmptyList);
        }
        long id3 = this.$channel.getId();
        String strC = ChannelUtils.c(this.$channel);
        boolean zJ = ChannelUtils.J(this.$channel);
        boolean zH = ChannelUtils.H(this.$channel);
        ThreadMetadata threadMetadata = this.$channel.getThreadMetadata();
        Integer numValueOf = threadMetadata != null ? Integer.valueOf(threadMetadata.getAutoArchiveDuration()) : null;
        String nickOrUsername = user != null ? GuildMember.INSTANCE.getNickOrUsername(guildMember, user) : "";
        boolean z4 = channel != null && ChannelUtils.q(channel);
        Intrinsics3.checkNotNullExpressionValue(bool, "canAccessRedesignedForumChannels");
        return new StartOfChatEntry(id3, strC, zCan, zCan3, zCanManageThread, zH, numValueOf, guildMember, nickOrUsername, zJ, z4, bool.booleanValue(), channel != null ? channel.d() : null, this.$channel.c());
    }
}
