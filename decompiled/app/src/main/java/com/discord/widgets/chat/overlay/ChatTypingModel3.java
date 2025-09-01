package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: ChatTypingModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0007\u001a\u001a\u0012\u0006\b\u0001\u0012\u00020\u0004 \u0001*\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)[Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChatTypingModel3<T, R> implements Func1<Channel, Object[]> {
    public static final ChatTypingModel3 INSTANCE = new ChatTypingModel3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Object[] call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Object[] call2(Channel channel) {
        return channel != null ? new Object[]{Long.valueOf(channel.getId()), Long.valueOf(channel.getGuildId()), Integer.valueOf(channel.getRateLimitPerUser())} : new Object[0];
    }
}
