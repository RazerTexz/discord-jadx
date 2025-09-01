package com.discord.widgets.chat.list.model;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.user.UserMutualGuildsManager;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetChatListModelTop.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModelTop;", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "component1", "()Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "item", "copy", "(Lcom/discord/widgets/chat/list/entries/ChatListEntry;)Lcom/discord/widgets/chat/list/model/WidgetChatListModelTop;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "getItem", "<init>", "(Lcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class WidgetChatListModelTop {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ChatListEntry item;

    /* compiled from: WidgetChatListModelTop.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\n\u001a\u0010\u0012\f\u0012\n\u0018\u00010\bj\u0004\u0018\u0001`\t0\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/list/model/WidgetChatListModelTop$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/UserId;", "userId", "Lrx/Observable;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "observeGuildMember", "(JJ)Lrx/Observable;", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "getWelcomeEntry", "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "Lcom/discord/widgets/chat/list/model/WidgetChatListModelTop;", "get", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$getWelcomeEntry(Companion companion, Channel channel) {
            return companion.getWelcomeEntry(channel);
        }

        private final Observable<ChatListEntry> getWelcomeEntry(Channel channel) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(channel.getGuildId());
            Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
            Observable<Long> observableObservePermissionsForChannel = companion.getPermissions().observePermissionsForChannel(channel.getId());
            Observable observableR = companion.getChannels().observeDefaultChannel(channel.getGuildId()).G(WidgetChatListModelTop3.INSTANCE).r();
            Observable<GuildMember> observableObserveGuildMember = observeGuildMember(channel.getGuildId(), channel.getOwnerId());
            Observable<User> observableObserveUser = companion.getUsers().observeUser(channel.getOwnerId());
            UserMutualGuildsManager userMutualGuildsManager = new UserMutualGuildsManager(null, null, null, 7, null);
            User userA = ChannelUtils.a(channel);
            Observable<ChatListEntry> observableC = Observable.c(observableObserveGuild, observableObserveMe$default, observableObservePermissionsForChannel, observableR, observableObserveGuildMember, observableObserveUser, userMutualGuildsManager.observeMutualGuilds(CollectionsJVM.listOf(Long.valueOf(userA != null ? userA.getId() : 0L))), companion.getChannels().observeChannel(channel.getParentId()), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, null, 6, null), new WidgetChatListModelTop4(channel));
            Intrinsics3.checkNotNullExpressionValue(observableC, "Observable.combineLatest…      )\n        }\n      }");
            return observableC;
        }

        private final Observable<GuildMember> observeGuildMember(long guildId, long userId) {
            Observable<GuildMember> observableObserveGuildMember = StoreStream.INSTANCE.getGuilds().observeGuildMember(guildId, userId);
            Intrinsics3.checkNotNullExpressionValue(observableObserveGuildMember, "StoreStream.getGuilds().…ldMember(guildId, userId)");
            return ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(observableObserveGuildMember, 1L, TimeUnit.SECONDS));
        }

        public final Observable<WidgetChatListModelTop> get(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Observable<WidgetChatListModelTop> observableR = StoreStream.INSTANCE.getMessagesLoader().getMessagesLoadedState(channel.getId()).Y(new WidgetChatListModelTop2(channel)).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n          .g…  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetChatListModelTop(ChatListEntry chatListEntry) {
        Intrinsics3.checkNotNullParameter(chatListEntry, "item");
        this.item = chatListEntry;
    }

    public static /* synthetic */ WidgetChatListModelTop copy$default(WidgetChatListModelTop widgetChatListModelTop, ChatListEntry chatListEntry, int i, Object obj) {
        if ((i & 1) != 0) {
            chatListEntry = widgetChatListModelTop.item;
        }
        return widgetChatListModelTop.copy(chatListEntry);
    }

    public static final Observable<WidgetChatListModelTop> get(Channel channel) {
        return INSTANCE.get(channel);
    }

    /* renamed from: component1, reason: from getter */
    public final ChatListEntry getItem() {
        return this.item;
    }

    public final WidgetChatListModelTop copy(ChatListEntry item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        return new WidgetChatListModelTop(item);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChatListModelTop) && Intrinsics3.areEqual(this.item, ((WidgetChatListModelTop) other).item);
        }
        return true;
    }

    public final ChatListEntry getItem() {
        return this.item;
    }

    public int hashCode() {
        ChatListEntry chatListEntry = this.item;
        if (chatListEntry != null) {
            return chatListEntry.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetChatListModelTop(item=");
        sbU.append(this.item);
        sbU.append(")");
        return sbU.toString();
    }
}
