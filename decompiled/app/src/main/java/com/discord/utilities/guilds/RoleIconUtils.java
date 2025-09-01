package com.discord.utilities.guilds;

import com.discord.api.guild.GuildFeature;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: RoleIconUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/utilities/guilds/RoleIconUtils;", "", "Lcom/discord/models/guild/Guild;", "Lcom/discord/api/role/GuildRole;", "role", "", "canUseRoleIcons", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/role/GuildRole;)Z", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RoleIconUtils {
    public static final RoleIconUtils INSTANCE = new RoleIconUtils();

    private RoleIconUtils() {
    }

    public final boolean canUseRoleIcons(Guild guild, GuildRole guildRole) {
        Intrinsics3.checkNotNullParameter(guild, "$this$canUseRoleIcons");
        if (guild.hasFeature(GuildFeature.ROLE_ICONS)) {
            return true;
        }
        return guildRole != null && RoleUtils.hasSubscriptionListingId(guildRole);
    }
}
