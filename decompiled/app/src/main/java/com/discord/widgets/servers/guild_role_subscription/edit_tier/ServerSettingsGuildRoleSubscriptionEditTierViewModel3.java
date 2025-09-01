package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples2;
import rx.functions.Func2;

/* compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\n \u0001*\u0004\u0018\u00010\n0\n2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002F\u0010\t\u001aB\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005 \u0001* \u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/discord/models/domain/emoji/EmojiSet;", "kotlin.jvm.PlatformType", "emojiSet", "Lkotlin/Pair;", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData;", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "<name for destructuring parameter 1>", "Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/emoji/EmojiSet;Lkotlin/Pair;)Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionEditTierViewModel3<T1, T2, R> implements Func2<EmojiSet, Tuples2<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>>, ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState> {
    public static final ServerSettingsGuildRoleSubscriptionEditTierViewModel3 INSTANCE = new ServerSettingsGuildRoleSubscriptionEditTierViewModel3();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState call(EmojiSet emojiSet, Tuples2<? extends ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, ? extends Channel>> tuples2) {
        return call2(emojiSet, (Tuples2<ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, Channel>>) tuples2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState call2(EmojiSet emojiSet, Tuples2<ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData, ? extends Map<Long, Channel>> tuples2) {
        ServerSettingsGuildRoleSubscriptionEditTierViewModel.GuildRoleSubscriptionStoreData guildRoleSubscriptionStoreDataComponent1 = tuples2.component1();
        Map<Long, Channel> mapComponent2 = tuples2.component2();
        Intrinsics3.checkNotNullExpressionValue(emojiSet, "emojiSet");
        return new ServerSettingsGuildRoleSubscriptionEditTierViewModel.StoreState(mapComponent2, emojiSet, guildRoleSubscriptionStoreDataComponent1);
    }
}
