package com.discord.widgets.channels.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetTextChannelSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/channels/settings/WidgetTextChannelSettings$Model;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetTextChannelSettings2<T, R> implements Func1<Channel, Observable<? extends WidgetTextChannelSettings.Model>> {
    public final /* synthetic */ long $channelId;

    /* compiled from: WidgetTextChannelSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "me", "", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/widgets/channels/settings/WidgetTextChannelSettings$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Lcom/discord/models/user/MeUser;Ljava/lang/Long;)Lcom/discord/widgets/channels/settings/WidgetTextChannelSettings$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Guild, MeUser, Long, WidgetTextChannelSettings.Model> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetTextChannelSettings.Model call(Guild guild, MeUser meUser, Long l) {
            return call2(guild, meUser, l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetTextChannelSettings.Model call2(Guild guild, MeUser meUser, Long l) {
            Long publicUpdatesChannelId;
            Long rulesChannelId;
            if (guild == null) {
                return null;
            }
            boolean zCanAndIsElevated = PermissionUtils.canAndIsElevated(16L, l, meUser.getMfaEnabled(), guild.getMfaLevel());
            boolean zCanAndIsElevated2 = PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, l, meUser.getMfaEnabled(), guild.getMfaLevel());
            boolean z2 = !this.$channel.getNsfw() || StoreStream.INSTANCE.getGuildsNsfw().isGuildNsfwGateAgreed(this.$channel.getGuildId());
            boolean zContains = guild.getFeatures().contains(GuildFeature.COMMUNITY);
            return new WidgetTextChannelSettings.Model(guild, this.$channel, zCanAndIsElevated, zCanAndIsElevated2, z2, zContains && (rulesChannelId = guild.getRulesChannelId()) != null && rulesChannelId.longValue() == WidgetTextChannelSettings2.this.$channelId, zContains && (publicUpdatesChannelId = guild.getPublicUpdatesChannelId()) != null && publicUpdatesChannelId.longValue() == WidgetTextChannelSettings2.this.$channelId, zContains);
        }
    }

    public WidgetTextChannelSettings2(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetTextChannelSettings.Model> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetTextChannelSettings.Model> call2(Channel channel) {
        if (channel == null || ChannelUtils.H(channel)) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.i(companion.getGuilds().observeGuild(channel.getGuildId()), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForChannel(this.$channelId), new AnonymousClass1(channel));
    }
}
