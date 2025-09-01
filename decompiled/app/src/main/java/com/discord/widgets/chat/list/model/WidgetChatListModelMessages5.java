package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreThreadMessages;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetChatListModelMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a\n \u0004*\u0004\u0018\u00010\u000b0\u000b2.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002.\u0010\b\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00000\u00002.\u0010\n\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0004\u0012\u00020\t \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"", "", "Lcom/discord/primitives/MessageId;", "Lcom/discord/stores/StoreMessageState$State;", "kotlin.jvm.PlatformType", "messageState", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "messageThreads", "Lcom/discord/stores/StoreThreadMessages$ThreadState;", "threadCountsAndLatestMessages", "Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/chat/list/model/WidgetChatListModelMessages$MessagesWithMetadata;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModelMessages5<T1, T2, T3, R> implements Func3<Map<Long, ? extends StoreMessageState.State>, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadMessages.ThreadState>, WidgetChatListModelMessages.MessagesWithMetadata> {
    public final /* synthetic */ List $messages;

    public WidgetChatListModelMessages5(List list) {
        this.$messages = list;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetChatListModelMessages.MessagesWithMetadata call(Map<Long, ? extends StoreMessageState.State> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends StoreThreadMessages.ThreadState> map3) {
        return call2((Map<Long, StoreMessageState.State>) map, (Map<Long, Channel>) map2, (Map<Long, StoreThreadMessages.ThreadState>) map3);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListModelMessages.MessagesWithMetadata call2(Map<Long, StoreMessageState.State> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages.ThreadState> map3) {
        List list = this.$messages;
        Intrinsics3.checkNotNullExpressionValue(map, "messageState");
        Intrinsics3.checkNotNullExpressionValue(map2, "messageThreads");
        Intrinsics3.checkNotNullExpressionValue(map3, "threadCountsAndLatestMessages");
        return new WidgetChatListModelMessages.MessagesWithMetadata(list, map, map2, map3, Maps6.emptyMap(), Maps6.emptyMap());
    }
}
