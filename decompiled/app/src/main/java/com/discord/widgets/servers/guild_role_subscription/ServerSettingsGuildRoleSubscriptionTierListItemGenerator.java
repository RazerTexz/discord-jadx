package com.discord.widgets.servers.guild_role_subscription;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.ImageAsset;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils2;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter2;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ServerSettingsGuildRoleSubscriptionTierListItemGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00002\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Lcom/discord/api/guildrolesubscription/GuildRoleSubscriptionTierListing;", "tierListings", "", "maxTierCount", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsGuildRoleSubscriptionTierAdapterItem;", "generateServerSettingsGuildRoleSubscriptionTierListItems", "(Ljava/util/List;I)Ljava/util/List;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierListItemGeneratorKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierListItemGenerator {
    public static final List<ServerSettingsGuildRoleSubscriptionTierAdapter2> generateServerSettingsGuildRoleSubscriptionTierListItems(List<GuildRoleSubscriptionTierListing> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing : list) {
                long id2 = guildRoleSubscriptionTierListing.getId();
                String name = guildRoleSubscriptionTierListing.getName();
                int price = GuildRoleSubscriptionUtils2.getPrice(guildRoleSubscriptionTierListing);
                ImageAsset imageAsset = guildRoleSubscriptionTierListing.getImageAsset();
                arrayList.add(new ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier(id2, name, price, guildRoleSubscriptionTierListing.getApplicationId(), guildRoleSubscriptionTierListing.getPublished(), imageAsset != null ? Long.valueOf(imageAsset.getId()) : null));
            }
        }
        if ((list != null ? list.size() : 0) < i) {
            arrayList.add(ServerSettingsGuildRoleSubscriptionTierAdapter2.AddTier.INSTANCE);
        }
        return arrayList;
    }
}
