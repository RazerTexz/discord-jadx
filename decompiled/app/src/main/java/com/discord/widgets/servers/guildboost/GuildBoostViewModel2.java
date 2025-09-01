package com.discord.widgets.servers.guildboost;

import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.servers.guildboost.GuildBoostViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function5;

/* compiled from: GuildBoostViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/discord/stores/StoreGuildBoost$State;", "p1", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "p2", "Lcom/discord/models/user/MeUser;", "p3", "Lcom/discord/models/guild/Guild;", "p4", "Lcom/discord/stores/StoreGooglePlayPurchases$State;", "p5", "Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$StoreState;", "invoke", "(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGooglePlayPurchases$State;)Lcom/discord/widgets/servers/guildboost/GuildBoostViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guildboost.GuildBoostViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class GuildBoostViewModel2 extends FunctionReferenceImpl implements Function5<StoreGuildBoost.State, StoreSubscriptions.SubscriptionsState, MeUser, Guild, StoreGooglePlayPurchases.State, GuildBoostViewModel.StoreState> {
    public static final GuildBoostViewModel2 INSTANCE = new GuildBoostViewModel2();

    public GuildBoostViewModel2() {
        super(5, GuildBoostViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGooglePlayPurchases$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ GuildBoostViewModel.StoreState invoke(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, MeUser meUser, Guild guild, StoreGooglePlayPurchases.State state2) {
        return invoke2(state, subscriptionsState, meUser, guild, state2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GuildBoostViewModel.StoreState invoke2(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, MeUser meUser, Guild guild, StoreGooglePlayPurchases.State state2) {
        Intrinsics3.checkNotNullParameter(state, "p1");
        Intrinsics3.checkNotNullParameter(subscriptionsState, "p2");
        Intrinsics3.checkNotNullParameter(meUser, "p3");
        Intrinsics3.checkNotNullParameter(state2, "p5");
        return new GuildBoostViewModel.StoreState(state, subscriptionsState, meUser, guild, state2);
    }
}
