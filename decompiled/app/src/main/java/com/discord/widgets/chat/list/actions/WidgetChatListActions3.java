package com.discord.widgets.chat.list.actions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.widgets.chat.list.actions.WidgetChatListActions;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.Observable;
import rx.functions.Func5;

/* compiled from: WidgetChatListActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u00062:\u0010\u0005\u001a6\u0012\f\u0012\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003 \u0004*\u001a\u0012\f\u0012\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlin/Pair;", "Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/actions/WidgetChatListActions$Model;", NotificationCompat.CATEGORY_CALL, "(Lkotlin/Pair;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListActions3<T, R> implements Func1<Tuples2<? extends Message, ? extends Channel>, Observable<? extends WidgetChatListActions.Model>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ CharSequence $messageContent;
    public final /* synthetic */ int $type;

    /* compiled from: WidgetChatListActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000426\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/models/member/GuildMember;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {
        public final /* synthetic */ long $authorId;

        public AnonymousClass1(long j) {
            this.$authorId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
            return call2((Map<Long, GuildMember>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildMember call2(Map<Long, GuildMember> map) {
            return map.get(Long.valueOf(this.$authorId));
        }
    }

    /* compiled from: WidgetChatListActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\r2\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\u0010\f\u001a\n \u0004*\u0004\u0018\u00010\u000b0\u000bH\n¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "guildMember", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/domain/emoji/EmojiSet;", "emojis", "Lcom/discord/widgets/chat/list/actions/WidgetChatListActions$Model;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Lcom/discord/models/user/MeUser;Lcom/discord/models/member/GuildMember;Lcom/discord/models/guild/Guild;Lcom/discord/models/domain/emoji/EmojiSet;)Lcom/discord/widgets/chat/list/actions/WidgetChatListActions$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, T3, T4, T5, R> implements Func5<Long, MeUser, GuildMember, Guild, EmojiSet, WidgetChatListActions.Model> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Message $message;

        public AnonymousClass2(Message message, Channel channel) {
            this.$message = message;
            this.$channel = channel;
        }

        @Override // rx.functions.Func5
        public /* bridge */ /* synthetic */ WidgetChatListActions.Model call(Long l, MeUser meUser, GuildMember guildMember, Guild guild, EmojiSet emojiSet) {
            return call2(l, meUser, guildMember, guild, emojiSet);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChatListActions.Model call2(Long l, MeUser meUser, GuildMember guildMember, Guild guild, EmojiSet emojiSet) {
            WidgetChatListActions.Model.Companion companion = WidgetChatListActions.Model.INSTANCE;
            Message message = this.$message;
            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
            Channel channel = this.$channel;
            WidgetChatListActions3 widgetChatListActions3 = WidgetChatListActions3.this;
            CharSequence charSequence = widgetChatListActions3.$messageContent;
            int i = widgetChatListActions3.$type;
            Intrinsics3.checkNotNullExpressionValue(emojiSet, "emojis");
            return WidgetChatListActions.Model.Companion.access$create(companion, message, guild, l, meUser, guildMember, channel, charSequence, i, emojiSet);
        }
    }

    public WidgetChatListActions3(long j, CharSequence charSequence, int i) {
        this.$channelId = j;
        this.$messageContent = charSequence;
        this.$type = i;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListActions.Model> call(Tuples2<? extends Message, ? extends Channel> tuples2) {
        return call2((Tuples2<Message, Channel>) tuples2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListActions.Model> call2(Tuples2<Message, Channel> tuples2) {
        User author;
        Message messageComponent1 = tuples2.component1();
        Channel channelComponent2 = tuples2.component2();
        long id2 = (messageComponent1 == null || (author = messageComponent1.getAuthor()) == null) ? 0L : author.getId();
        if (channelComponent2 == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.g(companion.getPermissions().observePermissionsForChannel(this.$channelId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeComputed(channelComponent2.getGuildId(), CollectionsJVM.listOf(Long.valueOf(id2))).G(new AnonymousClass1(id2)), companion.getGuilds().observeGuild(channelComponent2.getGuildId()).r(), StoreEmoji.getEmojiSet$default(companion.getEmojis(), channelComponent2.getGuildId(), channelComponent2.getId(), false, false, 12, null), new AnonymousClass2(messageComponent1, channelComponent2));
    }
}
