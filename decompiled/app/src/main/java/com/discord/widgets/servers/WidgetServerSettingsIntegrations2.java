package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.WidgetServerSettingsIntegrations;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func5;

/* compiled from: WidgetServerSettingsIntegrations.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0018\u0010\u0004\u001a\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00002\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\t\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2.\u0010\u000e\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\f\u0012\u0004\u0012\u00020\r \u0006*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"", "", "Lcom/discord/primitives/IntegrationId;", "Lcom/discord/models/domain/ModelGuildIntegration;", "integrations", "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "Lcom/discord/widgets/servers/WidgetServerSettingsIntegrations$Model;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Lcom/discord/models/user/MeUser;Ljava/lang/Long;Lcom/discord/models/guild/Guild;Ljava/util/Map;)Lcom/discord/widgets/servers/WidgetServerSettingsIntegrations$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsIntegrations$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrations2<T1, T2, T3, T4, T5, R> implements Func5<Map<Long, ? extends ModelGuildIntegration>, MeUser, Long, Guild, Map<Long, ? extends GuildRole>, WidgetServerSettingsIntegrations.Model> {
    public static final WidgetServerSettingsIntegrations2 INSTANCE = new WidgetServerSettingsIntegrations2();

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetServerSettingsIntegrations.Model call(Map<Long, ? extends ModelGuildIntegration> map, MeUser meUser, Long l, Guild guild, Map<Long, ? extends GuildRole> map2) {
        return call2(map, meUser, l, guild, (Map<Long, GuildRole>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsIntegrations.Model call2(Map<Long, ? extends ModelGuildIntegration> map, MeUser meUser, Long l, Guild guild, Map<Long, GuildRole> map2) {
        boolean z2 = false;
        if (l != null && guild != null && (guild.isOwner(meUser.getId()) || PermissionUtils.canAndIsElevated(32L, l, meUser.getMfaEnabled(), guild.getMfaLevel()))) {
            z2 = true;
        }
        if (!z2 || map == null || map2 == null || guild == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, ? extends ModelGuildIntegration>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            ModelGuildIntegration value = it.next().getValue();
            String[] strArr = ModelGuildIntegration.SUPPORTED_TYPES;
            Intrinsics3.checkNotNullExpressionValue(strArr, "ModelGuildIntegration.SUPPORTED_TYPES");
            WidgetServerSettingsIntegrations.Model.IntegrationItem integrationItem = _Arrays.contains(strArr, value.getType()) ? new WidgetServerSettingsIntegrations.Model.IntegrationItem(value, guild.getId()) : null;
            if (integrationItem != null) {
                arrayList.add(integrationItem);
            }
        }
        return new WidgetServerSettingsIntegrations.Model(guild.getId(), guild.getName(), arrayList);
    }
}
