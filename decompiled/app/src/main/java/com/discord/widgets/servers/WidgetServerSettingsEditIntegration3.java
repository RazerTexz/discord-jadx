package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.WidgetServerSettingsEditIntegration;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func5;

/* compiled from: WidgetServerSettingsEditIntegration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032.\u0010\t\u001a*\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b \u0001*\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00050\u00052\u000e\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\n¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "Lcom/discord/models/guild/Guild;", "guild", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "Lcom/discord/models/domain/ModelGuildIntegration;", "integration", "Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/lang/Long;Lcom/discord/models/domain/ModelGuildIntegration;)Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration3<T1, T2, T3, T4, T5, R> implements Func5<MeUser, Guild, Map<Long, ? extends GuildRole>, Long, ModelGuildIntegration, WidgetServerSettingsEditIntegration.Model> {
    public static final WidgetServerSettingsEditIntegration3 INSTANCE = new WidgetServerSettingsEditIntegration3();

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetServerSettingsEditIntegration.Model call(MeUser meUser, Guild guild, Map<Long, ? extends GuildRole> map, Long l, ModelGuildIntegration modelGuildIntegration) {
        return call2(meUser, guild, (Map<Long, GuildRole>) map, l, modelGuildIntegration);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEditIntegration.Model call2(MeUser meUser, Guild guild, Map<Long, GuildRole> map, Long l, ModelGuildIntegration modelGuildIntegration) {
        if (guild == null || map == null || l == null || modelGuildIntegration == null) {
            return null;
        }
        GuildRole guildRole = map.get(Long.valueOf(modelGuildIntegration.getRoleId()));
        if (modelGuildIntegration.isEnabled() && PermissionUtils.canAndIsElevated(32L, l, meUser.getMfaEnabled(), guild.getMfaLevel())) {
            return new WidgetServerSettingsEditIntegration.Model(guild, modelGuildIntegration, guildRole);
        }
        return null;
    }
}
