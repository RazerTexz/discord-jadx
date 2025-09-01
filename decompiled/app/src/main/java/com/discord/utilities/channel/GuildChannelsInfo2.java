package com.discord.utilities.channel;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.permissions.PermissionsContexts;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import rx.functions.Func8;

/* compiled from: GuildChannelsInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0018\u001a\n \u0001*\u0004\u0018\u00010\u00150\u00152\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072.\u0010\r\u001a*\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f \u0001*\u0014\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\t0\t2\u000e\u0010\u000f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000e26\u0010\u0011\u001a2\u0012\b\u0012\u00060\nj\u0002`\u0010\u0012\b\u0012\u00060\nj\u0002`\u000e \u0001*\u0018\u0012\b\u0012\u00060\nj\u0002`\u0010\u0012\b\u0012\u00060\nj\u0002`\u000e\u0018\u00010\t0\t2\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0013 \u0001*\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\u0012H\n¢\u0006\u0004\b\u0016\u0010\u0017"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/domain/ModelNotificationSettings;", "guildSettings", "", "hideMuted", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "Lcom/discord/api/permission/PermissionBit;", "guildPermissions", "Lcom/discord/primitives/ChannelId;", "channelPermissions", "", "Lcom/discord/api/channel/Channel;", "categories", "Lcom/discord/utilities/channel/GuildChannelsInfo;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/models/domain/ModelNotificationSettings;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/Long;Ljava/util/Map;Ljava/util/List;)Lcom/discord/utilities/channel/GuildChannelsInfo;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.channel.GuildChannelsInfo$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildChannelsInfo2<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<MeUser, Guild, ModelNotificationSettings, Boolean, Map<Long, ? extends GuildRole>, Long, Map<Long, ? extends Long>, List<? extends Channel>, GuildChannelsInfo> {
    public static final GuildChannelsInfo2 INSTANCE = new GuildChannelsInfo2();

    @Override // rx.functions.Func8
    public /* bridge */ /* synthetic */ GuildChannelsInfo call(MeUser meUser, Guild guild, ModelNotificationSettings modelNotificationSettings, Boolean bool, Map<Long, ? extends GuildRole> map, Long l, Map<Long, ? extends Long> map2, List<? extends Channel> list) {
        return call2(meUser, guild, modelNotificationSettings, bool, (Map<Long, GuildRole>) map, l, (Map<Long, Long>) map2, (List<Channel>) list);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final GuildChannelsInfo call2(MeUser meUser, Guild guild, ModelNotificationSettings modelNotificationSettings, Boolean bool, Map<Long, GuildRole> map, Long l, Map<Long, Long> map2, List<Channel> list) {
        boolean z2;
        Set<GuildFeature> features;
        boolean z3 = meUser != null && meUser.getMfaEnabled();
        int mfaLevel = guild != null ? guild.getMfaLevel() : 0;
        boolean zIsElevated = PermissionUtils.isElevated(16L, z3, mfaLevel);
        boolean z4 = zIsElevated && PermissionUtils.can(16L, l);
        if (PermissionUtils.can(1L, l)) {
            z2 = true;
        } else {
            if ((guild != null ? guild.getVanityUrlCode() : null) == null) {
                z2 = false;
            }
        }
        GuildRole guildRole = guild != null ? (GuildRole) outline.e(guild, map) : null;
        boolean z5 = !zIsElevated && z4;
        boolean zContains = (guild == null || (features = guild.getFeatures()) == null) ? false : features.contains(GuildFeature.VERIFIED);
        PermissionsContexts.Companion companion = PermissionsContexts.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(list, "categories");
        boolean z6 = ((guild != null ? Long.valueOf(guild.getOwnerId()) : null) == null || meUser == null || meUser.getId() != guild.getOwnerId()) ? false : true;
        Intrinsics3.checkNotNullExpressionValue(map2, "channelPermissions");
        PermissionsContexts permissionsContextsFrom = companion.from(list, z6, l, map2, mfaLevel, meUser != null ? meUser.getMfaEnabled() : false);
        boolean zCan = PermissionUtils.can(Permission.CHANGE_NICKNAME, l);
        Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "guildSettings");
        Intrinsics3.checkNotNullExpressionValue(bool, "hideMuted");
        return new GuildChannelsInfo(guild, guildRole, modelNotificationSettings, bool.booleanValue(), map2, z2, z5, zContains, permissionsContextsFrom, zCan, map);
    }
}
