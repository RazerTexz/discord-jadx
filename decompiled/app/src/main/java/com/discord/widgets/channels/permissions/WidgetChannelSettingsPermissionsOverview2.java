package com.discord.widgets.channels.permissions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverview$Model;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview2<T, R> implements Func1<Channel, Observable<? extends WidgetChannelSettingsPermissionsOverview.Model>> {
    public final /* synthetic */ long $channelId;

    /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062.\u0010\u000b\u001a*\u0012\b\u0012\u00060\u0005j\u0002`\t\u0012\u0004\u0012\u00020\n \u0003*\u0014\u0012\b\u0012\u00060\u0005j\u0002`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\bH\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "", "Lcom/discord/api/permission/PermissionBit;", "myPermissionsForChannel", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverview$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;Ljava/lang/Long;Ljava/util/Map;)Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsPermissionsOverview$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<Guild, MeUser, Long, Map<Long, ? extends GuildRole>, WidgetChannelSettingsPermissionsOverview.Model> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetChannelSettingsPermissionsOverview.Model call(Guild guild, MeUser meUser, Long l, Map<Long, ? extends GuildRole> map) {
            return call2(guild, meUser, l, (Map<Long, GuildRole>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelSettingsPermissionsOverview.Model call2(Guild guild, MeUser meUser, Long l, Map<Long, GuildRole> map) {
            if (!WidgetChannelSettingsPermissionsOverview.Model.INSTANCE.isValid(meUser, guild, this.$channel, l)) {
                return null;
            }
            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
            Intrinsics3.checkNotNull(guild);
            Channel channel = this.$channel;
            Intrinsics3.checkNotNull(l);
            long jLongValue = l.longValue();
            Intrinsics3.checkNotNullExpressionValue(map, "roles");
            return new WidgetChannelSettingsPermissionsOverview.Model(meUser, guild, channel, jLongValue, map);
        }
    }

    public WidgetChannelSettingsPermissionsOverview2(long j) {
        this.$channelId = j;
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelSettingsPermissionsOverview.Model> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.h(companion.getGuilds().observeGuild(channel.getGuildId()), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForChannel(this.$channelId), companion.getGuilds().observeRoles(channel.getGuildId()), new AnonymousClass1(channel));
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelSettingsPermissionsOverview.Model> call(Channel channel) {
        return call2(channel);
    }
}
