package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreMessagesLoader;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.SpacerEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelTop;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetChatListModelTop.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "kotlin.jvm.PlatformType", "channelMessagesLoadedState", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/model/WidgetChatListModelTop;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModelTop2<T, R> implements Func1<StoreMessagesLoader.ChannelLoadedState, Observable<? extends WidgetChatListModelTop>> {
    public final /* synthetic */ Channel $channel;

    /* compiled from: WidgetChatListModelTop.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "kotlin.jvm.PlatformType", "it", "Lcom/discord/widgets/chat/list/model/WidgetChatListModelTop;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/chat/list/entries/ChatListEntry;)Lcom/discord/widgets/chat/list/model/WidgetChatListModelTop;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<ChatListEntry, WidgetChatListModelTop> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ WidgetChatListModelTop call(ChatListEntry chatListEntry) {
            return call2(chatListEntry);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChatListModelTop call2(ChatListEntry chatListEntry) {
            Intrinsics3.checkNotNullExpressionValue(chatListEntry, "it");
            return new WidgetChatListModelTop(chatListEntry);
        }
    }

    public WidgetChatListModelTop2(Channel channel) {
        this.$channel = channel;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModelTop> call(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        return call2(channelLoadedState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListModelTop> call2(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        Observable scalarSynchronousObservable;
        if (channelLoadedState.isOldestMessagesLoaded()) {
            scalarSynchronousObservable = WidgetChatListModelTop.Companion.access$getWelcomeEntry(WidgetChatListModelTop.INSTANCE, this.$channel);
        } else {
            scalarSynchronousObservable = (channelLoadedState.isTouchedSinceLastJump() || !channelLoadedState.isInitialMessagesLoaded()) ? new ScalarSynchronousObservable(new LoadingEntry()) : new ScalarSynchronousObservable(new SpacerEntry(this.$channel.getId()));
        }
        return scalarSynchronousObservable.G(AnonymousClass1.INSTANCE);
    }
}
