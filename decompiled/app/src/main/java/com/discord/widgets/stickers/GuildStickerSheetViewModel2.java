package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuilds;
import java.util.concurrent.Callable;
import kotlin.Metadata;

/* compiled from: GuildStickerSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/models/guild/Guild;", NotificationCompat.CATEGORY_CALL, "()Lcom/discord/models/guild/Guild;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$1, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildStickerSheetViewModel2<V> implements Callable<Guild> {
    public final /* synthetic */ Sticker $sticker;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    public GuildStickerSheetViewModel2(StoreGuilds storeGuilds, Sticker sticker) {
        this.$storeGuilds = storeGuilds;
        this.$sticker = sticker;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Guild call() {
        return call();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public final Guild call() {
        return this.$storeGuilds.getGuilds().get(this.$sticker.getGuildId());
    }
}
