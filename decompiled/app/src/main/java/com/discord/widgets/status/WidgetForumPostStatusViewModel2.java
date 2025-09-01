package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.models.message.Message;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreForumPostMessages;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.status.WidgetForumPostStatusViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func5;

/* compiled from: WidgetForumPostStatusViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetForumPostStatusViewModel.StoreState>> {
    public final /* synthetic */ StoreEmoji $storeEmoji;
    public final /* synthetic */ StoreForumPostMessages $storeForumPostMessages;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreThreadMessages $storeThreadMessages;
    public final /* synthetic */ StoreThreadsJoined $storeThreadsJoined;
    public final /* synthetic */ StoreUser $storeUser;

    /* compiled from: WidgetForumPostStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000f\u001a\n \u0002*\u0004\u0018\u00010\f0\f2\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000b\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\nH\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "myUserId", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "joinedThread", "Lcom/discord/models/message/Message;", "forumPostFirstMessage", "Lcom/discord/stores/StoreThreadMessages$ThreadState;", "messageCount", "Lcom/discord/api/permission/PermissionBit;", "channelPermissions", "Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState$Loaded;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Lcom/discord/stores/StoreThreadsJoined$JoinedThread;Lcom/discord/models/message/Message;Lcom/discord/stores/StoreThreadMessages$ThreadState;Ljava/lang/Long;)Lcom/discord/widgets/status/WidgetForumPostStatusViewModel$StoreState$Loaded;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetForumPostStatusViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, R> implements Func5<Long, StoreThreadsJoined.JoinedThread, Message, StoreThreadMessages.ThreadState, Long, WidgetForumPostStatusViewModel.StoreState.Loaded> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func5
        public /* bridge */ /* synthetic */ WidgetForumPostStatusViewModel.StoreState.Loaded call(Long l, StoreThreadsJoined.JoinedThread joinedThread, Message message, StoreThreadMessages.ThreadState threadState, Long l2) {
            return call2(l, joinedThread, message, threadState, l2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetForumPostStatusViewModel.StoreState.Loaded call2(Long l, StoreThreadsJoined.JoinedThread joinedThread, Message message, StoreThreadMessages.ThreadState threadState, Long l2) {
            boolean zCan = PermissionUtils.can(64L, l2);
            ForumUtils forumUtils = ForumUtils.INSTANCE;
            MessageReaction placeholderMessageReaction = forumUtils.getPlaceholderMessageReaction(WidgetForumPostStatusViewModel2.this.$storeEmoji);
            MessageReaction messageReactionMostCommonReaction = message != null ? forumUtils.mostCommonReaction(message, WidgetForumPostStatusViewModel2.this.$storeEmoji) : null;
            boolean z2 = messageReactionMostCommonReaction != null && forumUtils.isDefaultPostReaction(messageReactionMostCommonReaction, WidgetForumPostStatusViewModel2.this.$storeEmoji);
            Intrinsics3.checkNotNullExpressionValue(l, "myUserId");
            long jLongValue = l.longValue();
            long id2 = this.$channel.getId();
            long guildId = this.$channel.getGuildId();
            boolean zJ = ChannelUtils.j(this.$channel);
            boolean z3 = joinedThread != null;
            Long lValueOf = message != null ? Long.valueOf(message.getId()) : null;
            if (messageReactionMostCommonReaction != null) {
                placeholderMessageReaction = messageReactionMostCommonReaction;
            }
            return new WidgetForumPostStatusViewModel.StoreState.Loaded(jLongValue, id2, guildId, lValueOf, z3, zJ, threadState != null ? Integer.valueOf(threadState.getCount()) : null, zCan, z2, placeholderMessageReaction);
        }
    }

    public WidgetForumPostStatusViewModel2(StoreUser storeUser, StoreThreadsJoined storeThreadsJoined, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StorePermissions storePermissions, StoreEmoji storeEmoji) {
        this.$storeUser = storeUser;
        this.$storeThreadsJoined = storeThreadsJoined;
        this.$storeForumPostMessages = storeForumPostMessages;
        this.$storeThreadMessages = storeThreadMessages;
        this.$storePermissions = storePermissions;
        this.$storeEmoji = storeEmoji;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetForumPostStatusViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetForumPostStatusViewModel.StoreState> call2(Channel channel) {
        return channel == null ? new ScalarSynchronousObservable(WidgetForumPostStatusViewModel.StoreState.Invalid.INSTANCE) : Observable.g(this.$storeUser.observeMeId(), this.$storeThreadsJoined.observeJoinedThread(channel.getId()), this.$storeForumPostMessages.observeForumPostFirstMessage(channel.getParentId(), channel.getId(), true), this.$storeThreadMessages.observeThreadCountAndLatestMessage(channel.getId()), this.$storePermissions.observePermissionsForChannel(channel.getId()), new AnonymousClass1(channel));
    }
}
