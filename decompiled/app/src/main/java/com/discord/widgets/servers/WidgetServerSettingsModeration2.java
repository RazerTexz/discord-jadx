package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.WidgetServerSettingsModeration;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetServerSettingsModeration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/user/MeUser;", "me", "", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;Ljava/lang/Long;)Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsModeration2<T1, T2, T3, R> implements Func3<Guild, MeUser, Long, WidgetServerSettingsModeration.Model> {
    public static final WidgetServerSettingsModeration2 INSTANCE = new WidgetServerSettingsModeration2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetServerSettingsModeration.Model call(Guild guild, MeUser meUser, Long l) {
        return call2(guild, meUser, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsModeration.Model call2(Guild guild, MeUser meUser, Long l) {
        Intrinsics3.checkNotNullParameter(meUser, "me");
        if (guild == null) {
            return null;
        }
        if (guild.isOwner(meUser.getId()) || PermissionUtils.canAndIsElevated(32L, l, meUser.getMfaEnabled(), guild.getMfaLevel())) {
            return new WidgetServerSettingsModeration.Model(guild);
        }
        return null;
    }
}
