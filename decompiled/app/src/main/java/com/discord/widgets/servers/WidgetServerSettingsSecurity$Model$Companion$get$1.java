package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.widgets.servers.WidgetServerSettingsSecurity;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetServerSettingsSecurity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;)Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity$Model$Companion$get$1<T1, T2, R> implements Func2<MeUser, Guild, WidgetServerSettingsSecurity.Model> {
    public static final WidgetServerSettingsSecurity$Model$Companion$get$1 INSTANCE = new WidgetServerSettingsSecurity$Model$Companion$get$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetServerSettingsSecurity.Model call(MeUser meUser, Guild guild) {
        return call2(meUser, guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsSecurity.Model call2(MeUser meUser, Guild guild) {
        if (meUser == null || guild == null || guild.getOwnerId() != meUser.getId()) {
            return null;
        }
        return new WidgetServerSettingsSecurity.Model(guild.getId(), guild.getName(), guild.getMfaLevel() > 0);
    }
}
