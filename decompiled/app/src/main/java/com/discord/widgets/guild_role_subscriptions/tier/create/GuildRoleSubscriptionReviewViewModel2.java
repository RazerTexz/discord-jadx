package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionReviewViewModel;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: GuildRoleSubscriptionReviewViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionReviewViewModel$StoreState;", "invoke", "()Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionReviewViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionReviewViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionReviewViewModel2 extends Lambda implements Function0<GuildRoleSubscriptionReviewViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreChannels $storeChannels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionReviewViewModel2(StoreChannels storeChannels, long j) {
        super(0);
        this.$storeChannels = storeChannels;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildRoleSubscriptionReviewViewModel.StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildRoleSubscriptionReviewViewModel.StoreState invoke() {
        Collection<Channel> collectionValues = this.$storeChannels.getChannelsForGuild(this.$guildId).values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (!ChannelUtils.k((Channel) obj)) {
                arrayList.add(obj);
            }
        }
        return new GuildRoleSubscriptionReviewViewModel.StoreState(arrayList.size());
    }
}
