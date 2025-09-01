package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.widgets.stickers.GuildStickerSheetViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func4;

/* compiled from: GuildStickerSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000f\u001a\n \u0001*\u0004\u0018\u00010\f0\f2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052.\u0010\u000b\u001a*\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\n \u0001*\u0014\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00070\u0007H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;", "kotlin.jvm.PlatformType", "guildStickerGuildInfo", "Lcom/discord/models/user/MeUser;", "meUser", "Lcom/discord/api/channel/Channel;", "selectedChannel", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "userGuilds", "Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo;Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Ljava/util/Map;)Lcom/discord/widgets/stickers/GuildStickerSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildStickerSheetViewModel4<T1, T2, T3, T4, R> implements Func4<GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo, MeUser, Channel, Map<Long, ? extends Guild>, GuildStickerSheetViewModel.StoreState> {
    public static final GuildStickerSheetViewModel4 INSTANCE = new GuildStickerSheetViewModel4();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.StoreState call(GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo guildStickerGuildInfo, MeUser meUser, Channel channel, Map<Long, ? extends Guild> map) {
        return call2(guildStickerGuildInfo, meUser, channel, (Map<Long, Guild>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildStickerSheetViewModel.StoreState call2(GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo guildStickerGuildInfo, MeUser meUser, Channel channel, Map<Long, Guild> map) {
        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
        Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
        Intrinsics3.checkNotNullExpressionValue(map, "userGuilds");
        Intrinsics3.checkNotNullExpressionValue(guildStickerGuildInfo, "guildStickerGuildInfo");
        return new GuildStickerSheetViewModel.StoreState(meUser, lValueOf, map, guildStickerGuildInfo);
    }
}
