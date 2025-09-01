package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState;", "invoke", "()Lcom/discord/widgets/servers/creator_monetization_eligibility/onboarding/ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsCreatorMonetizationOnboardingViewModel5 extends Lambda implements Function0<ServerSettingsCreatorMonetizationOnboardingViewModel.StoreState> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $guilds;
    public final /* synthetic */ StoreUser $users;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel5(StoreGuilds storeGuilds, long j, StoreUser storeUser) {
        super(0);
        this.$guilds = storeGuilds;
        this.$guildId = j;
        this.$users = storeUser;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel.StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsCreatorMonetizationOnboardingViewModel.StoreState invoke() {
        Guild guild = this.$guilds.getGuild(this.$guildId);
        return new ServerSettingsCreatorMonetizationOnboardingViewModel.StoreState(guild, guild != null && guild.isOwner(this.$users.getMeSnapshot().getId()));
    }
}
