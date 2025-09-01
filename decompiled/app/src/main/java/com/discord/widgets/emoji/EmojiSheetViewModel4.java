package com.discord.widgets.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMediaFavorites;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.emoji.EmojiSheetViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import rx.functions.Func5;

/* compiled from: EmojiSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\n¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;", "customEmojGuildInfo", "Lcom/discord/models/user/MeUser;", "meUser", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "guilds", "Lcom/discord/api/channel/Channel;", "selectedChannel", "", "Lcom/discord/stores/StoreMediaFavorites$Favorite;", "favorites", "Lcom/discord/widgets/emoji/EmojiSheetViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/emoji/EmojiSheetViewModel$Companion$CustomEmojGuildInfo;Lcom/discord/models/user/MeUser;Ljava/util/Map;Lcom/discord/api/channel/Channel;Ljava/util/Set;)Lcom/discord/widgets/emoji/EmojiSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class EmojiSheetViewModel4<T1, T2, T3, T4, T5, R> implements Func5<EmojiSheetViewModel.Companion.CustomEmojGuildInfo, MeUser, Map<Long, ? extends Guild>, Channel, Set<? extends StoreMediaFavorites.Favorite>, EmojiSheetViewModel.StoreState> {
    public final /* synthetic */ EmojiNode.EmojiIdAndType $emojiIdAndType;

    public EmojiSheetViewModel4(EmojiNode.EmojiIdAndType emojiIdAndType) {
        this.$emojiIdAndType = emojiIdAndType;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ EmojiSheetViewModel.StoreState call(EmojiSheetViewModel.Companion.CustomEmojGuildInfo customEmojGuildInfo, MeUser meUser, Map<Long, ? extends Guild> map, Channel channel, Set<? extends StoreMediaFavorites.Favorite> set) {
        return call2(customEmojGuildInfo, meUser, (Map<Long, Guild>) map, channel, set);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final EmojiSheetViewModel.StoreState call2(EmojiSheetViewModel.Companion.CustomEmojGuildInfo customEmojGuildInfo, MeUser meUser, Map<Long, Guild> map, Channel channel, Set<? extends StoreMediaFavorites.Favorite> set) {
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        Intrinsics3.checkNotNullParameter(map, "guilds");
        Intrinsics3.checkNotNullParameter(set, "favorites");
        return new EmojiSheetViewModel.StoreState(customEmojGuildInfo, this.$emojiIdAndType, UserUtils.INSTANCE.isPremium(meUser), map.keySet(), channel, set);
    }
}
