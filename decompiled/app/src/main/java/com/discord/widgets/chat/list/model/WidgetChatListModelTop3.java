package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: WidgetChatListModelTop.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Ljava/lang/Long;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$getWelcomeEntry$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModelTop3<T, R> implements Func1<Channel, Long> {
    public static final WidgetChatListModelTop3 INSTANCE = new WidgetChatListModelTop3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Long call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Channel channel) {
        return Long.valueOf(channel != null ? channel.getId() : 0L);
    }
}
