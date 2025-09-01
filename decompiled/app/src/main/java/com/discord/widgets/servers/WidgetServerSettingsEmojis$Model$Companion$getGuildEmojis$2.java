package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreEmojiGuild;
import kotlin.Metadata;
import rx.functions.Action0;

/* compiled from: WidgetServerSettingsEmojis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", NotificationCompat.CATEGORY_CALL, "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$2 implements Action0 {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreEmojiGuild $storeGuildEmoji;

    public WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$2(StoreEmojiGuild storeEmojiGuild, long j) {
        this.$storeGuildEmoji = storeEmojiGuild;
        this.$guildId = j;
    }

    @Override // rx.functions.Action0
    public final void call() {
        this.$storeGuildEmoji.fetchGuildEmoji(this.$guildId);
    }
}
