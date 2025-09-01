package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetChatListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "isDetached", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/model/WidgetChatListModel$ChatListState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Z)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModel$ChatListState$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModel2<T, R> implements Func1<Boolean, Observable<? extends WidgetChatListModel.ChatListState>> {
    public final /* synthetic */ long $channelId;

    /* compiled from: WidgetChatListModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lcom/discord/widgets/chat/list/model/WidgetChatListModel$ChatListState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMessagesLoader$ChannelLoadedState;)Lcom/discord/widgets/chat/list/model/WidgetChatListModel$ChatListState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModel$ChatListState$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<StoreMessagesLoader.ChannelLoadedState, WidgetChatListModel.ChatListState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ WidgetChatListModel.ChatListState call(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
            return call2(channelLoadedState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChatListModel.ChatListState call2(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
            return channelLoadedState.getIsTouchedSinceLastJump() ? WidgetChatListModel.ChatListState.DETACHED : WidgetChatListModel.ChatListState.DETACHED_UNTOUCHED;
        }
    }

    public WidgetChatListModel2(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModel.ChatListState> call(Boolean bool) {
        return call(bool.booleanValue());
    }

    public final Observable<? extends WidgetChatListModel.ChatListState> call(boolean z2) {
        return z2 ? StoreStream.INSTANCE.getMessagesLoader().getMessagesLoadedState(this.$channelId).G(AnonymousClass1.INSTANCE).r() : new ScalarSynchronousObservable(WidgetChatListModel.ChatListState.ATTACHED);
    }
}
