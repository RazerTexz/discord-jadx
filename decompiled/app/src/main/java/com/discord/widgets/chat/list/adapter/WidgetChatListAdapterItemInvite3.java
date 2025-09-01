package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetChatListAdapterItemInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "meId", "Lcom/discord/models/user/User;", "authorUser", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Lcom/discord/models/user/User;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$ModelProvider$getInvalidInvite$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite3<T1, T2, R> implements Func2<Long, User, WidgetChatListAdapterItemInvite.Model> {
    public static final WidgetChatListAdapterItemInvite3 INSTANCE = new WidgetChatListAdapterItemInvite3();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemInvite.Model call(Long l, User user) {
        return call2(l, user);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemInvite.Model call2(Long l, User user) {
        Intrinsics3.checkNotNullExpressionValue(l, "meId");
        return new WidgetChatListAdapterItemInvite.Model.Invalid(user, l.longValue(), null);
    }
}
