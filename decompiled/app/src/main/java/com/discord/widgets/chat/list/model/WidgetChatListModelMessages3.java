package com.discord.widgets.chat.list.model;

import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import d0.t.Collections2;
import d0.t.ReversedViews3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function10;

/* compiled from: WidgetChatListModelMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00012\u0006\u0010\u0004\u001a\u00020\u000326\u0010\u000b\u001a2\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\b\u0012\u00060\bj\u0002`\t \n*\u0018\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\b\u0012\u00060\bj\u0002`\t\u0018\u00010\u00050\u00052\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\f\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\n\u0010\u0012\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000fH\n¢\u0006\u0004\b\u0019\u0010\u001a"}, d2 = {"Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "message", "Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;", "messagesWithMetadata", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "guildMembers", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "", "allowAnimatedEmojis", "autoPlayGifs", "meUserId", "renderEmbeds", "Lcom/discord/utilities/embed/InviteEmbedModel;", "inviteEmbedModel", "guildCanSeeRoleSubscriptionPurchaseSystemMessage", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "invoke", "(Lcom/discord/models/message/Message;Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;Ljava/util/Map;Ljava/util/Map;ZZJZLcom/discord/utilities/embed/InviteEmbedModel;Z)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$Companion$getSingleMessage$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModelMessages3 extends Lambda implements Function10<Message, WidgetChatListModelMessages.MessagesWithMetadata, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Boolean, Boolean, Long, Boolean, InviteEmbedModel, Boolean, List<? extends ChatListEntry>> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ long $messageId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListModelMessages3(Channel channel, long j) {
        super(10);
        this.$channel = channel;
        this.$messageId = j;
    }

    @Override // kotlin.jvm.functions.Function10
    public /* bridge */ /* synthetic */ List<? extends ChatListEntry> invoke(Message message, WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Map<Long, ? extends GuildMember> map, Map<Long, ? extends GuildRole> map2, Boolean bool, Boolean bool2, Long l, Boolean bool3, InviteEmbedModel inviteEmbedModel, Boolean bool4) {
        return invoke(message, messagesWithMetadata, (Map<Long, GuildMember>) map, (Map<Long, GuildRole>) map2, bool.booleanValue(), bool2.booleanValue(), l.longValue(), bool3.booleanValue(), inviteEmbedModel, bool4.booleanValue());
    }

    public final List<ChatListEntry> invoke(Message message, WidgetChatListModelMessages.MessagesWithMetadata messagesWithMetadata, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, boolean z2, boolean z3, long j, boolean z4, InviteEmbedModel inviteEmbedModel, boolean z5) {
        Intrinsics3.checkNotNullParameter(messagesWithMetadata, "messagesWithMetadata");
        Intrinsics3.checkNotNullParameter(map2, "guildRoles");
        Intrinsics3.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
        if (message != null) {
            WidgetChatListModelMessages.Companion companion = WidgetChatListModelMessages.INSTANCE;
            Channel channel = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(map, "guildMembers");
            List<ChatListEntry> listAsReversed = ReversedViews3.asReversed(WidgetChatListModelMessages.Companion.getMessageItems$default(companion, channel, map, map2, new HashMap(), null, null, message, messagesWithMetadata.getMessageState().get(Long.valueOf(this.$messageId)), messagesWithMetadata.getMessageReplyState(), false, false, null, z2, z3, z4, j, false, new HashMap(), inviteEmbedModel, false, z5, 524288, null));
            if (listAsReversed != null) {
                return listAsReversed;
            }
        }
        return Collections2.emptyList();
    }
}
