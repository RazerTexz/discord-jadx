package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionsContexts;
import com.discord.widgets.servers.WidgetServerSettings;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func6;

/* compiled from: WidgetServerSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\t \u0001*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\b26\u0010\r\u001a2\u0012\b\u0012\u00060\u0005j\u0002`\f\u0012\b\u0012\u00060\u0005j\u0002`\u0006 \u0001*\u0018\u0012\b\u0012\u00060\u0005j\u0002`\f\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0018\u00010\u000b0\u000b2\u000e\u0010\u000f\u001a\n \u0001*\u0004\u0018\u00010\u000e0\u000eH\n¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "Lcom/discord/models/guild/Guild;", "guild", "", "Lcom/discord/api/permission/PermissionBit;", "myPermissions", "", "Lcom/discord/api/channel/Channel;", "categories", "", "Lcom/discord/primitives/ChannelId;", "channelPermissions", "", "canGuildSeeRoleSubscriptionsSettings", "Lcom/discord/widgets/servers/WidgetServerSettings$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Ljava/lang/Long;Ljava/util/List;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/discord/widgets/servers/WidgetServerSettings$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettings$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettings2<T1, T2, T3, T4, T5, T6, R> implements Func6<MeUser, Guild, Long, List<? extends Channel>, Map<Long, ? extends Long>, Boolean, WidgetServerSettings.Model> {
    public static final WidgetServerSettings2 INSTANCE = new WidgetServerSettings2();

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetServerSettings.Model call(MeUser meUser, Guild guild, Long l, List<? extends Channel> list, Map<Long, ? extends Long> map, Boolean bool) {
        return call2(meUser, guild, l, (List<Channel>) list, (Map<Long, Long>) map, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettings.Model call2(MeUser meUser, Guild guild, Long l, List<Channel> list, Map<Long, Long> map, Boolean bool) {
        if (guild == null) {
            return null;
        }
        PermissionsContexts.Companion companion = PermissionsContexts.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(list, "categories");
        boolean z2 = guild.getOwnerId() == meUser.getId();
        Intrinsics3.checkNotNullExpressionValue(map, "channelPermissions");
        PermissionsContexts permissionsContextsFrom = companion.from(list, z2, l, map, guild.getMfaLevel(), meUser.getMfaEnabled());
        boolean zHasFeature = guild.hasFeature(GuildFeature.ROLE_SUBSCRIPTIONS_ENABLED);
        Intrinsics3.checkNotNullExpressionValue(bool, "canGuildSeeRoleSubscriptionsSettings");
        return new WidgetServerSettings.Model(guild, permissionsContextsFrom, bool.booleanValue() && permissionsContextsFrom.getCanManageServer(), zHasFeature);
    }
}
