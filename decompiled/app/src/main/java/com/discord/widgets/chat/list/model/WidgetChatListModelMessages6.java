package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.message.Message;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import rx.Observable;
import rx.functions.Func6;

/* compiled from: WidgetChatListModelMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006 \u0003*\u0014\u0012\u000e\b\u0001\u0012\n \u0003*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052\"\u0010\u0004\u001a\u001e\u0012\b\u0012\u00060\u0001j\u0002`\u0002 \u0003*\u000e\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "kotlin.jvm.PlatformType", "messages", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModelMessages6<T, R> implements Func1<List<? extends Message>, Observable<? extends WidgetChatListModelMessages.MessagesWithMetadata>> {
    public final /* synthetic */ Channel $channel;

    /* compiled from: WidgetChatListModelMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0013\u001a\u00020\u00102\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0016\u0010\u0007\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00032\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\b\u0012\u0004\u0012\u00020\t0\u00032\u0016\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\r0\u00032\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"", "Lcom/discord/models/message/Message;", "p1", "", "", "Lcom/discord/primitives/MessageId;", "Lcom/discord/stores/StoreMessageState$State;", "p2", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "p3", "Lcom/discord/stores/StoreThreadMessages$ThreadState;", "p4", "Lcom/discord/stores/StoreMessageReplies$MessageState;", "p5", "p6", "Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;", "invoke", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function6<List<? extends Message>, Map<Long, ? extends StoreMessageState.State>, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadMessages.ThreadState>, Map<Long, ? extends StoreMessageReplies.MessageState>, Map<Long, ? extends StoreMessageReplies.MessageState>, WidgetChatListModelMessages.MessagesWithMetadata> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(6, WidgetChatListModelMessages.MessagesWithMetadata.class, "<init>", "<init>(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ WidgetChatListModelMessages.MessagesWithMetadata invoke(List<? extends Message> list, Map<Long, ? extends StoreMessageState.State> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends StoreThreadMessages.ThreadState> map3, Map<Long, ? extends StoreMessageReplies.MessageState> map4, Map<Long, ? extends StoreMessageReplies.MessageState> map5) {
            return invoke2((List<Message>) list, (Map<Long, StoreMessageState.State>) map, (Map<Long, Channel>) map2, (Map<Long, StoreThreadMessages.ThreadState>) map3, map4, map5);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetChatListModelMessages.MessagesWithMetadata invoke2(List<Message> list, Map<Long, StoreMessageState.State> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages.ThreadState> map3, Map<Long, ? extends StoreMessageReplies.MessageState> map4, Map<Long, ? extends StoreMessageReplies.MessageState> map5) {
            Intrinsics3.checkNotNullParameter(list, "p1");
            Intrinsics3.checkNotNullParameter(map, "p2");
            Intrinsics3.checkNotNullParameter(map2, "p3");
            Intrinsics3.checkNotNullParameter(map3, "p4");
            Intrinsics3.checkNotNullParameter(map4, "p5");
            Intrinsics3.checkNotNullParameter(map5, "p6");
            return new WidgetChatListModelMessages.MessagesWithMetadata(list, map, map2, map3, map4, map5);
        }
    }

    public WidgetChatListModelMessages6(Channel channel) {
        this.$channel = channel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.discord.widgets.chat.list.model.WidgetChatListModelMessages$sam$rx_functions_Func6$0] */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListModelMessages.MessagesWithMetadata> call2(List<Message> list) {
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(list);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Map<Long, StoreMessageState.State>> messageState = companion.getMessageState().getMessageState();
        StoreChannels channels = companion.getChannels();
        Intrinsics3.checkNotNullExpressionValue(list, "messages");
        Observable<Map<Long, Channel>> observableObserveThreadsFromMessages = channels.observeThreadsFromMessages(list);
        Observable<Map<Long, StoreThreadMessages.ThreadState>> observableObserveThreadCountAndLatestMessage = companion.getThreadMessages().observeThreadCountAndLatestMessage();
        Observable<Map<Long, StoreMessageReplies.MessageState>> observableObserveMessageReferencesForChannel = companion.getRepliedMessages().observeMessageReferencesForChannel(this.$channel.getId());
        Observable<Map<Long, StoreMessageReplies.MessageState>> observableObserveMessageReferencesForChannel2 = companion.getRepliedMessages().observeMessageReferencesForChannel(this.$channel.getParentId());
        AnonymousClass1 widgetChatListModelMessages7 = AnonymousClass1.INSTANCE;
        if (widgetChatListModelMessages7 != null) {
            widgetChatListModelMessages7 = new WidgetChatListModelMessages7(widgetChatListModelMessages7);
        }
        return Observable.f(scalarSynchronousObservable, messageState, observableObserveThreadsFromMessages, observableObserveThreadCountAndLatestMessage, observableObserveMessageReferencesForChannel, observableObserveMessageReferencesForChannel2, (Func6) widgetChatListModelMessages7);
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModelMessages.MessagesWithMetadata> call(List<? extends Message> list) {
        return call2((List<Message>) list);
    }
}
