package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreMessagesLoader;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.SpacerEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import rx.functions.Func9;

/* compiled from: WidgetChatListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052.\u0010\u000b\u001a*\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\n \u0001*\u0014\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00070\u00072\u0018\u0010\r\u001a\u0014 \u0001*\n\u0018\u00010\bj\u0004\u0018\u0001`\f0\bj\u0002`\f26\u0010\u0010\u001a2\u0012\b\u0012\u00060\bj\u0002`\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f \u0001*\u0018\u0012\b\u0012\u00060\bj\u0002`\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0018\u00010\u00070\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u001126\u0010\u0015\u001a2\u0012\b\u0012\u00060\bj\u0002`\f\u0012\b\u0012\u00060\u0013j\u0002`\u0014 \u0001*\u0018\u0012\b\u0012\u00060\bj\u0002`\f\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0018\u00010\u00070\u00072\u000e\u0010\u0017\u001a\n \u0001*\u0004\u0018\u00010\u00160\u0016H\n¢\u0006\u0004\b\u0019\u0010\u001a"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModelTop;", "kotlin.jvm.PlatformType", "top", "Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages;", "messages", "Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "loadingState", "", "", "Lcom/discord/primitives/ChannelId;", "", "channelNames", "Lcom/discord/primitives/UserId;", "myId", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "computed", "Lcom/discord/models/guild/Guild;", "guild", "", "Lcom/discord/primitives/RelationshipType;", "relationships", "Lcom/discord/widgets/chat/list/model/WidgetChatListModel$ChatListState;", "chatListState", "Lcom/discord/widgets/chat/list/model/WidgetChatListModel;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/chat/list/model/WidgetChatListModelTop;Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages;Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;Ljava/util/Map;Ljava/lang/Long;Ljava/util/Map;Lcom/discord/models/guild/Guild;Ljava/util/Map;Lcom/discord/widgets/chat/list/model/WidgetChatListModel$ChatListState;)Lcom/discord/widgets/chat/list/model/WidgetChatListModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$getChannel$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModel4<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<WidgetChatListModelTop, WidgetChatListModelMessages, StoreMessagesLoader.ChannelLoadedState, Map<Long, ? extends String>, Long, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends Integer>, WidgetChatListModel.ChatListState, WidgetChatListModel> {
    public final /* synthetic */ Channel $channel;

    public WidgetChatListModel4(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func9
    public /* bridge */ /* synthetic */ WidgetChatListModel call(WidgetChatListModelTop widgetChatListModelTop, WidgetChatListModelMessages widgetChatListModelMessages, StoreMessagesLoader.ChannelLoadedState channelLoadedState, Map<Long, ? extends String> map, Long l, Map<Long, ? extends GuildMember> map2, Guild guild, Map<Long, ? extends Integer> map3, WidgetChatListModel.ChatListState chatListState) {
        return call2(widgetChatListModelTop, widgetChatListModelMessages, channelLoadedState, (Map<Long, String>) map, l, (Map<Long, GuildMember>) map2, guild, (Map<Long, Integer>) map3, chatListState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListModel call2(WidgetChatListModelTop widgetChatListModelTop, WidgetChatListModelMessages widgetChatListModelMessages, StoreMessagesLoader.ChannelLoadedState channelLoadedState, Map<Long, String> map, Long l, Map<Long, GuildMember> map2, Guild guild, Map<Long, Integer> map3, WidgetChatListModel.ChatListState chatListState) {
        ChatListEntry chatListEntryAccess$getGreetMessageItem;
        List<Long> roles;
        WidgetChatListModel.Companion companion = WidgetChatListModel.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(channelLoadedState, "loadingState");
        Intrinsics3.checkNotNullExpressionValue(widgetChatListModelMessages, "messages");
        Channel channel = this.$channel;
        Intrinsics3.checkNotNullExpressionValue(map3, "relationships");
        boolean zAccess$shouldShowStickerGreet = WidgetChatListModel.Companion.access$shouldShowStickerGreet(companion, channelLoadedState, widgetChatListModelMessages, channel, map3);
        int size = widgetChatListModelMessages.getItems().size() + 2;
        if (zAccess$shouldShowStickerGreet) {
            size++;
        }
        ArrayList arrayList = new ArrayList(size);
        if (chatListState == WidgetChatListModel.ChatListState.DETACHED) {
            arrayList.add(new LoadingEntry());
        } else {
            arrayList.add(new SpacerEntry(this.$channel.getId()));
            if (zAccess$shouldShowStickerGreet && (chatListEntryAccess$getGreetMessageItem = WidgetChatListModel.Companion.access$getGreetMessageItem(companion, widgetChatListModelMessages, this.$channel)) != null) {
                arrayList.add(chatListEntryAccess$getGreetMessageItem);
            }
        }
        arrayList.addAll(widgetChatListModelMessages.getItems());
        arrayList.add(widgetChatListModelTop.getItem());
        GuildMember guildMember = map2.get(l);
        Set setEmptySet = (guildMember == null || (roles = guildMember.getRoles()) == null) ? Sets5.emptySet() : new HashSet(roles);
        Intrinsics3.checkNotNullExpressionValue(l, "myId");
        long jLongValue = l.longValue();
        long id2 = this.$channel.getId();
        long guildId = this.$channel.getGuildId();
        Intrinsics3.checkNotNullExpressionValue(map, "channelNames");
        return new WidgetChatListModel(jLongValue, id2, guild, guildId, map, widgetChatListModelMessages.getOldestMessageId(), arrayList, setEmptySet, widgetChatListModelMessages.getNewMessagesMarkerMessageId(), widgetChatListModelMessages.getNewestKnownMessageId(), channelLoadedState.isLoadingMessages());
    }
}
