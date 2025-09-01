package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildProfiles;
import com.discord.widgets.servers.WidgetServerNotifications;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetServerNotifications.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/domain/ModelNotificationSettings;", "kotlin.jvm.PlatformType", "guildSettings", "Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;", "guildProfile", "Lcom/discord/widgets/servers/WidgetServerNotifications$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/models/domain/ModelNotificationSettings;Lcom/discord/stores/StoreGuildProfiles$GuildProfileData;)Lcom/discord/widgets/servers/WidgetServerNotifications$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerNotifications$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerNotifications4<T1, T2, T3, R> implements Func3<Guild, ModelNotificationSettings, StoreGuildProfiles.GuildProfileData, WidgetServerNotifications.Model> {
    public static final WidgetServerNotifications4 INSTANCE = new WidgetServerNotifications4();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetServerNotifications.Model call(Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData) {
        return call2(guild, modelNotificationSettings, guildProfileData);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerNotifications.Model call2(Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData) {
        if (guild == null || modelNotificationSettings == null) {
            return null;
        }
        return new WidgetServerNotifications.Model(guild, modelNotificationSettings, guildProfileData);
    }
}
