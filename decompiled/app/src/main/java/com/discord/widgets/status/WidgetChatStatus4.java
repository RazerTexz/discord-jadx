package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessageAck;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetChatStatus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0018\u0010\u0005\u001a\u0014 \u0004*\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00030\u0002j\u0002`\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/stores/StoreMessageAck$Ack;", "lastAck", "", "Lcom/discord/primitives/MessageId;", "kotlin.jvm.PlatformType", "mostRecentIdSnapshot", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMessageAck$Ack;Ljava/lang/Long;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.status.WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatStatus4<T1, T2, R> implements Func2<StoreMessageAck.Ack, Long, Boolean> {
    public static final WidgetChatStatus4 INSTANCE = new WidgetChatStatus4();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(StoreMessageAck.Ack ack, Long l) {
        return call2(ack, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(StoreMessageAck.Ack ack, Long l) {
        long messageId = ack != null ? ack.getMessageId() : 0L;
        Intrinsics3.checkNotNullExpressionValue(l, "mostRecentIdSnapshot");
        return Boolean.valueOf(messageId < l.longValue());
    }
}
