package com.discord.utilities.guilds;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.voice.Bitrate;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.Regex;

/* compiled from: GuildUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u00050\u0006*\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0010\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001f\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\u0018¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0015\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001d\u0010!\u001a\u00020\u0013*\u00020\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"", ModelAuditLogEntry.CHANGE_KEY_NAME, "computeShortName", "(Ljava/lang/String;)Ljava/lang/String;", "", "Lcom/discord/api/guildmember/GuildMember;", "", "", "Lcom/discord/primitives/UserId;", "asMap", "(Ljava/util/List;)Ljava/util/Map;", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/api/channel/Channel;", "channel", "", "getMaxVoiceBitrateKbps", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;)I", "guildPremiumTier", "", "isVip", "(IZ)I", "getMaxFileSizeMB", "(Lcom/discord/models/guild/Guild;)I", "Lcom/discord/primitives/RoleId;", "roleId", "Lcom/discord/api/role/GuildRole;", "getGuildRole", "(Ljava/lang/Long;)Lcom/discord/api/role/GuildRole;", "Lcom/discord/api/guild/Guild;", "createApiGuild", "(Lcom/discord/models/guild/Guild;)Lcom/discord/api/guild/Guild;", "everyoneRole", "isFullyGatedGuildRoleSubscriptionGuild", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/role/GuildRole;)Z", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.guilds.GuildUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildUtils {
    public static final Map<Long, GuildMember> asMap(List<GuildMember> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$asMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(Long.valueOf(((GuildMember) obj).getUser().getId()), obj);
        }
        return linkedHashMap;
    }

    public static final String computeShortName(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new Regex("\\s").replace(new Regex("(\\w)(\\w*)").replace(new Regex("'s ").replace(str, " "), "$1"), "");
    }

    public static final Guild createApiGuild(com.discord.models.guild.Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        return new Guild(guild.getRoles(), guild.getEmojis(), guild.getStickers(), guild.getName(), guild.getDescription(), Integer.valueOf(guild.getDefaultMessageNotifications()), guild.getId(), guild.getRegion(), guild.getOwnerId(), guild.getIcon(), guild.getVerificationLevel(), guild.getExplicitContentFilter(), null, null, null, null, guild.getUnavailable(), guild.getMfaLevel(), guild.getAfkTimeout(), guild.getAfkChannelId(), guild.getSystemChannelId(), _Collections.toList(guild.getFeatures()), guild.getMemberCount(), guild.getBanner(), guild.getSplash(), guild.getPremiumTier(), guild.getPremiumSubscriptionCount(), guild.getSystemChannelFlags(), guild.getJoinedAt(), guild.getRulesChannelId(), guild.getPublicUpdatesChannelId(), guild.getPreferredLocale(), guild.getWelcomeScreen(), guild.getMaxVideoChannelUsers(), guild.getVanityUrlCode(), 0, guild.getApproximatePresenceCount(), null, null, null, null, guild.getNsfw(), null, null, Collections2.emptyList(), guild.getHubType());
    }

    public static final GuildRole getGuildRole(Long l) {
        if (l == null) {
            return null;
        }
        for (Map.Entry<Long, Map<Long, GuildRole>> entry : StoreStream.INSTANCE.getGuilds().getRoles().entrySet()) {
            if (entry.getValue().containsKey(l)) {
                return entry.getValue().get(l);
            }
        }
        return null;
    }

    public static final int getMaxFileSizeMB(com.discord.models.guild.Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        return PremiumUtils.INSTANCE.getGuildMaxFileSizeMB(guild.getPremiumTier());
    }

    public static final int getMaxVoiceBitrateKbps(com.discord.models.guild.Guild guild, Channel channel) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        return (channel == null || !ChannelUtils.D(channel)) ? getMaxVoiceBitrateKbps(guild.getPremiumTier(), guild.getFeatures().contains(GuildFeature.VIP_REGIONS)) : Bitrate.DEFAULT.getKbps();
    }

    public static final boolean isFullyGatedGuildRoleSubscriptionGuild(com.discord.models.guild.Guild guild, GuildRole guildRole) {
        Intrinsics3.checkNotNullParameter(guild, "$this$isFullyGatedGuildRoleSubscriptionGuild");
        return guild.hasFeature(GuildFeature.ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE) && !PermissionUtils.INSTANCE.canRole(Permission.VIEW_CHANNEL, guildRole, null);
    }

    public static /* synthetic */ boolean isFullyGatedGuildRoleSubscriptionGuild$default(com.discord.models.guild.Guild guild, GuildRole guildRole, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRole = getGuildRole(Long.valueOf(guild.getId()));
        }
        return isFullyGatedGuildRoleSubscriptionGuild(guild, guildRole);
    }

    public static final int getMaxVoiceBitrateKbps(int i, boolean z2) {
        if (z2) {
            return Bitrate.PREMIUM_TIER_3.getKbps();
        }
        if (i == 1) {
            return Bitrate.PREMIUM_TIER_1.getKbps();
        }
        if (i == 2) {
            return Bitrate.PREMIUM_TIER_2.getKbps();
        }
        if (i != 3) {
            return Bitrate.MAX.getKbps();
        }
        return Bitrate.PREMIUM_TIER_3.getKbps();
    }
}
