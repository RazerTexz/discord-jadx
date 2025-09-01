package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.models.application.Unread;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: WidgetChatListModelMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0014 \u0001*\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00040\u0003j\u0002`\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/application/Unread;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "", "Lcom/discord/primitives/MessageId;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/application/Unread;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$Companion$observeUnreadMarkerMessageId$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModelMessages4<T, R> implements Func1<Unread, Long> {
    public static final WidgetChatListModelMessages4 INSTANCE = new WidgetChatListModelMessages4();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Long call(Unread unread) {
        return call2(unread);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Unread unread) {
        Long messageId = unread.getMarker().getMessageId();
        return Long.valueOf(messageId != null ? messageId.longValue() : 0L);
    }
}
