package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.WidgetServerSettingsEmojis;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetServerSettingsEmojis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b2\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model$Permission;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;)Lcom/discord/widgets/servers/WidgetServerSettingsEmojis$Model$Permission;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Model$Companion$canManageEmojisAndStickers$1<T1, T2, T3, R> implements Func3<Long, Guild, MeUser, WidgetServerSettingsEmojis.Model.Permission> {
    public static final WidgetServerSettingsEmojis$Model$Companion$canManageEmojisAndStickers$1 INSTANCE = new WidgetServerSettingsEmojis$Model$Companion$canManageEmojisAndStickers$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetServerSettingsEmojis.Model.Permission call(Long l, Guild guild, MeUser meUser) {
        return call2(l, guild, meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEmojis.Model.Permission call2(Long l, Guild guild, MeUser meUser) {
        if (guild == null || l == null) {
            return null;
        }
        return new WidgetServerSettingsEmojis.Model.Permission(PermissionUtils.canAndIsElevated(Permission.MANAGE_EMOJIS_AND_STICKERS, l, meUser.getMfaEnabled(), guild.getMfaLevel()), guild);
    }
}
