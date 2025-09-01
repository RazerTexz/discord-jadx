package com.discord.widgets.servers.guild_role_subscription.upsell;

import android.content.SharedPreferences;
import com.discord.api.guild.GuildFeature;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.servers.creator_monetization_eligibility.CreatorMonetizationCountryAllowlist;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildRoleSubscriptionOnboardingUpsellManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B/\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/upsell/GuildRoleSubscriptionOnboardingUpsellManager;", "", "", "hasBeenShown", "()Z", "Lcom/discord/models/guild/Guild;", "guild", "canShow", "(Lcom/discord/models/guild/Guild;)Z", "", "setHasBeenShown", "()V", "Lcom/discord/widgets/servers/creator_monetization_eligibility/CreatorMonetizationCountryAllowlist;", "countryAllowlist", "Lcom/discord/widgets/servers/creator_monetization_eligibility/CreatorMonetizationCountryAllowlist;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/widgets/guild_role_subscriptions/GuildRoleSubscriptionsFeatureFlag;", "featureFlag", "Lcom/discord/widgets/guild_role_subscriptions/GuildRoleSubscriptionsFeatureFlag;", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StorePermissions;", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "<init>", "(Landroid/content/SharedPreferences;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreExperiments;Lcom/discord/stores/StoreGuilds;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionOnboardingUpsellManager {
    public static final String SHOWN_CACHE_KEY = "HAS_GUILD_ROLE_SUBSCRIPTION_UPSELL_BEEN_SHOWN";
    private final CreatorMonetizationCountryAllowlist countryAllowlist;
    private final GuildRoleSubscriptionsFeatureFlag featureFlag;
    private final SharedPreferences sharedPreferences;
    private final StorePermissions storePermissions;
    private final StoreUser storeUser;

    public GuildRoleSubscriptionOnboardingUpsellManager(SharedPreferences sharedPreferences, StorePermissions storePermissions, StoreUser storeUser, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.sharedPreferences = sharedPreferences;
        this.storePermissions = storePermissions;
        this.storeUser = storeUser;
        this.featureFlag = new GuildRoleSubscriptionsFeatureFlag(storeExperiments, storeGuilds, storeUser, storePermissions, null, 16, null);
        this.countryAllowlist = new CreatorMonetizationCountryAllowlist(storeExperiments);
    }

    private final boolean hasBeenShown() {
        return this.sharedPreferences.getBoolean(SHOWN_CACHE_KEY, false);
    }

    public final boolean canShow(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        return (hasBeenShown() || guild.hasFeature(GuildFeature.CREATOR_MONETIZABLE) || guild.hasFeature(GuildFeature.CREATOR_MONETIZABLE_DISABLED) || !this.featureFlag.canGuildSeeGuildRoleSubscriptionSettings(guild.getId(), this.countryAllowlist)) ? false : true;
    }

    public final void setHasBeenShown() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(SHOWN_CACHE_KEY, true);
        editorEdit.apply();
    }
}
