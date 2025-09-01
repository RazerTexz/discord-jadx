package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreThreadDraft;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.SpacerEntry;
import com.discord.widgets.chat.list.entries.ThreadDraftFormEntry;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.functions.Func7;

/* compiled from: WidgetChatListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00172.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002\u0018\u0010\u0007\u001a\u0014 \u0004*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00060\u0001j\u0002`\u000626\u0010\n\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\b\u0012\u00060\bj\u0002`\t \u0004*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\b\u0012\u00060\bj\u0002`\t\u0018\u00010\u00000\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u000e\u001a\n \u0004*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0010\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u000f2^\u0010\u0016\u001aZ\u0012\f\u0012\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015 \u0004*\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u0014 \u0004*,\u0012\f\u0012\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015 \u0004*\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u0014\u0018\u00010\u00110\u0011H\n¢\u0006\u0004\b\u0018\u0010\u0019"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "", "kotlin.jvm.PlatformType", "channelNames", "Lcom/discord/primitives/UserId;", "myId", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "computed", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;", "threadDraft", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lkotlin/Pair;", "Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "messagePair", "Lcom/discord/widgets/chat/list/model/WidgetChatListModel;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/lang/Long;Ljava/util/Map;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreThreadDraft$ThreadDraftState;Ljava/lang/Long;Lkotlin/Pair;)Lcom/discord/widgets/chat/list/model/WidgetChatListModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$getThreadDraft$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModel7<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Map<Long, ? extends String>, Long, Map<Long, ? extends GuildMember>, Guild, StoreThreadDraft.ThreadDraftState, Long, Tuples2<? extends Message, ? extends List<? extends ChatListEntry>>, WidgetChatListModel> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Channel $parentChannel;
    public final /* synthetic */ Long $parentMessageId;

    public WidgetChatListModel7(Channel channel, Long l, long j) {
        this.$parentChannel = channel;
        this.$parentMessageId = l;
        this.$guildId = j;
    }

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ WidgetChatListModel call(Map<Long, ? extends String> map, Long l, Map<Long, ? extends GuildMember> map2, Guild guild, StoreThreadDraft.ThreadDraftState threadDraftState, Long l2, Tuples2<? extends Message, ? extends List<? extends ChatListEntry>> tuples2) {
        return call2((Map<Long, String>) map, l, (Map<Long, GuildMember>) map2, guild, threadDraftState, l2, (Tuples2<Message, ? extends List<? extends ChatListEntry>>) tuples2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListModel call2(Map<Long, String> map, Long l, Map<Long, GuildMember> map2, Guild guild, StoreThreadDraft.ThreadDraftState threadDraftState, Long l2, Tuples2<Message, ? extends List<? extends ChatListEntry>> tuples2) {
        List<Long> roles;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SpacerEntry(this.$parentChannel.getId()));
        if (threadDraftState.isSending()) {
            arrayList.add(new LoadingEntry());
        }
        arrayList.addAll(tuples2.getSecond());
        Channel channel = this.$parentChannel;
        Long l3 = this.$parentMessageId;
        long guildId = channel.getGuildId();
        Integer defaultAutoArchiveDuration = this.$parentChannel.getDefaultAutoArchiveDuration();
        Intrinsics3.checkNotNullExpressionValue(threadDraftState, "threadDraft");
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        arrayList.add(new ThreadDraftFormEntry(channel, l3, guildId, guild, defaultAutoArchiveDuration, threadDraftState, ThreadUtils.canCreatePrivateThread$default(threadUtils, l2, this.$parentChannel, guild, false, 8, null), threadUtils.canCreatePrivateThread(l2, this.$parentChannel, guild, false), threadUtils.canCreatePublicThread(l2, this.$parentChannel, tuples2.getFirst(), guild)));
        GuildMember guildMember = map2.get(l);
        Set setEmptySet = (guildMember == null || (roles = guildMember.getRoles()) == null) ? Sets5.emptySet() : new HashSet(roles);
        Intrinsics3.checkNotNullExpressionValue(l, "myId");
        long jLongValue = l.longValue();
        long j = this.$guildId;
        Intrinsics3.checkNotNullExpressionValue(map, "channelNames");
        return new WidgetChatListModel(jLongValue, -3L, guild, j, map, 0L, arrayList, setEmptySet, 0L, 0L, false, 800, null);
    }
}
