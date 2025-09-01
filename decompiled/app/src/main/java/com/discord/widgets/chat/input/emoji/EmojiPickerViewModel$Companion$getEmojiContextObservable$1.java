package com.discord.widgets.chat.input.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import j0.k.Func1;
import kotlin.Metadata;

/* compiled from: EmojiPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "kotlin.jvm.PlatformType", "selectedChannel", "Lcom/discord/stores/StoreEmoji$EmojiContext;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;)Lcom/discord/stores/StoreEmoji$EmojiContext;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion$getEmojiContextObservable$1<T, R> implements Func1<StoreChannelsSelected.ResolvedSelectedChannel, StoreEmoji.EmojiContext> {
    public static final EmojiPickerViewModel$Companion$getEmojiContextObservable$1 INSTANCE = new EmojiPickerViewModel$Companion$getEmojiContextObservable$1();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ StoreEmoji.EmojiContext call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(resolvedSelectedChannel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final StoreEmoji.EmojiContext call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
        if (channelOrParent == null) {
            return null;
        }
        return new StoreEmoji.EmojiContext.Chat(channelOrParent.getGuildId(), resolvedSelectedChannel.getId());
    }
}
