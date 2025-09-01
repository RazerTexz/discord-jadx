package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetChatListAdapterItemGift.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0018\u0010\u0004\u001a\u0014 \u0001*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00030\u0000j\u0002`\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "kotlin.jvm.PlatformType", "authorUserId", "Lcom/discord/primitives/UserId;", "meId", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGift$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$ModelProvider$getInvalidGift$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift4<T1, T2, R> implements Func2<Long, Long, WidgetChatListAdapterItemGift.Model> {
    public static final WidgetChatListAdapterItemGift4 INSTANCE = new WidgetChatListAdapterItemGift4();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemGift.Model call(Long l, Long l2) {
        return call2(l, l2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemGift.Model call2(Long l, Long l2) {
        Intrinsics3.checkNotNullExpressionValue(l2, "meId");
        return new WidgetChatListAdapterItemGift.Model.Invalid(l, l2.longValue());
    }
}
