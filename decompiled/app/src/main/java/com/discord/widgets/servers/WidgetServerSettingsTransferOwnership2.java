package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.widgets.servers.WidgetServerSettingsTransferOwnership;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetServerSettingsTransferOwnership.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/user/User;", "user", "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lcom/discord/widgets/servers/WidgetServerSettingsTransferOwnership$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/User;Lcom/discord/models/user/MeUser;)Lcom/discord/widgets/servers/WidgetServerSettingsTransferOwnership$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsTransferOwnership2<T1, T2, T3, R> implements Func3<Guild, User, MeUser, WidgetServerSettingsTransferOwnership.Model> {
    public static final WidgetServerSettingsTransferOwnership2 INSTANCE = new WidgetServerSettingsTransferOwnership2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetServerSettingsTransferOwnership.Model call(Guild guild, User user, MeUser meUser) {
        return call2(guild, user, meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsTransferOwnership.Model call2(Guild guild, User user, MeUser meUser) {
        if (guild == null || meUser == null || user == null) {
            return null;
        }
        return new WidgetServerSettingsTransferOwnership.Model(user, guild, meUser.getMfaEnabled(), guild.getOwnerId() == meUser.getId());
    }
}
