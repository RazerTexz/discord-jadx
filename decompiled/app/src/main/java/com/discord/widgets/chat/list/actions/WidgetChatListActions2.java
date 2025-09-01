package com.discord.widgets.chat.list.actions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.message.Message;
import d0.Tuples;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: WidgetChatListActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a6\u0012\f\u0012\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003 \u0006*\u001a\u0012\f\u0012\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "message", "Lcom/discord/api/channel/Channel;", "channel", "Lkotlin/Pair;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/message/Message;Lcom/discord/api/channel/Channel;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListActions2<T1, T2, R> implements Func2<Message, Channel, Tuples2<? extends Message, ? extends Channel>> {
    public static final WidgetChatListActions2 INSTANCE = new WidgetChatListActions2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends Message, ? extends Channel> call(Message message, Channel channel) {
        return call2(message, channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<Message, Channel> call2(Message message, Channel channel) {
        return Tuples.to(message, channel);
    }
}
