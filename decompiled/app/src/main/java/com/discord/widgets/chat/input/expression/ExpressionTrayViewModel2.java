package com.discord.widgets.chat.input.expression;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected;
import com.discord.widgets.chat.input.expression.ExpressionTrayViewModel;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func5;

/* compiled from: ExpressionTrayViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0013\u001a\n \u0001*\u0004\u0018\u00010\u00100\u00102\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052V\u0010\r\u001aR\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\bj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u0007j\u0002`\f \u0001*(\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\bj\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u0007j\u0002`\f\u0018\u00010\u00070\u00072.\u0010\u000f\u001a*\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u000e \u0001*\u0014\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00070\u0007H\n¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "kotlin.jvm.PlatformType", "lastSelectedTab", "Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "resolvedSelectedChannel", "Lcom/discord/models/user/MeUser;", "meUser", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/StickerId;", "Lcom/discord/api/sticker/Sticker;", "Lcom/discord/stores/StickerMap;", "guildStickers", "Lcom/discord/models/guild/Guild;", "userGuilds", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;Lcom/discord/models/user/MeUser;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.expression.ExpressionTrayViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ExpressionTrayViewModel2<T1, T2, T3, T4, T5, R> implements Func5<ExpressionTrayTab, StoreChannelsSelected.ResolvedSelectedChannel, MeUser, Map<Long, ? extends Map<Long, ? extends Sticker>>, Map<Long, ? extends Guild>, ExpressionTrayViewModel.StoreState> {
    public static final ExpressionTrayViewModel2 INSTANCE = new ExpressionTrayViewModel2();

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ ExpressionTrayViewModel.StoreState call(ExpressionTrayTab expressionTrayTab, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, MeUser meUser, Map<Long, ? extends Map<Long, ? extends Sticker>> map, Map<Long, ? extends Guild> map2) {
        return call2(expressionTrayTab, resolvedSelectedChannel, meUser, (Map<Long, ? extends Map<Long, Sticker>>) map, (Map<Long, Guild>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final ExpressionTrayViewModel.StoreState call2(ExpressionTrayTab expressionTrayTab, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, MeUser meUser, Map<Long, ? extends Map<Long, Sticker>> map, Map<Long, Guild> map2) {
        Intrinsics3.checkNotNullExpressionValue(expressionTrayTab, "lastSelectedTab");
        Channel channelOrParent = resolvedSelectedChannel.getChannelOrParent();
        Long lValueOf = channelOrParent != null ? Long.valueOf(channelOrParent.getGuildId()) : null;
        Intrinsics3.checkNotNullExpressionValue(map, "guildStickers");
        return new ExpressionTrayViewModel.StoreState(expressionTrayTab, lValueOf, meUser, map, _Collections.toSet(map2.keySet()), resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft);
    }
}
