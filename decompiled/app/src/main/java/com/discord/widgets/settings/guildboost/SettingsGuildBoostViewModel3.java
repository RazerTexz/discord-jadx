package com.discord.widgets.settings.guildboost;

import com.discord.api.premium.PremiumTier;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

/* compiled from: SettingsGuildBoostViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/discord/stores/StoreGuildBoost$State;", "p1", "Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;", "p2", "", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/guild/Guild;", "p3", "Lcom/discord/api/premium/PremiumTier;", "p4", "Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$StoreState;", "invoke", "(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Ljava/util/Map;Lcom/discord/api/premium/PremiumTier;)Lcom/discord/widgets/settings/guildboost/SettingsGuildBoostViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel$Companion$observeStores$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class SettingsGuildBoostViewModel3 extends FunctionReferenceImpl implements Function4<StoreGuildBoost.State, StoreSubscriptions.SubscriptionsState, Map<Long, ? extends Guild>, PremiumTier, SettingsGuildBoostViewModel.StoreState> {
    public static final SettingsGuildBoostViewModel3 INSTANCE = new SettingsGuildBoostViewModel3();

    public SettingsGuildBoostViewModel3() {
        super(4, SettingsGuildBoostViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGuildBoost$State;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;Ljava/util/Map;Lcom/discord/api/premium/PremiumTier;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ SettingsGuildBoostViewModel.StoreState invoke(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, Map<Long, ? extends Guild> map, PremiumTier premiumTier) {
        return invoke2(state, subscriptionsState, (Map<Long, Guild>) map, premiumTier);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SettingsGuildBoostViewModel.StoreState invoke2(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, Map<Long, Guild> map, PremiumTier premiumTier) {
        Intrinsics3.checkNotNullParameter(state, "p1");
        Intrinsics3.checkNotNullParameter(subscriptionsState, "p2");
        Intrinsics3.checkNotNullParameter(map, "p3");
        Intrinsics3.checkNotNullParameter(premiumTier, "p4");
        return new SettingsGuildBoostViewModel.StoreState(state, subscriptionsState, map, premiumTier);
    }
}
