package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetChannelsListItemChannelActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$Model;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions$Model$Companion$get$1<T, R> implements Func1<Channel, Observable<? extends WidgetChannelsListItemChannelActions.Model>> {
    public final /* synthetic */ long $channelId;

    /* compiled from: WidgetChannelsListItemChannelActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\n \b*\u0004\u0018\u00010\n0\n2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032.\u0010\t\u001a*\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007 \b*\u0014\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/domain/ModelNotificationSettings;", "kotlin.jvm.PlatformType", "guildSettings", "Lcom/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Ljava/lang/Long;Ljava/util/Map;)Lcom/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Guild, Long, Map<Long, ? extends ModelNotificationSettings>, WidgetChannelsListItemChannelActions.Model> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetChannelsListItemChannelActions.Model call(Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map) {
            return call2(guild, l, map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelsListItemChannelActions.Model call2(Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map) {
            ModelNotificationSettings.ChannelOverride channelOverride;
            ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) outline.c(this.$channel, map);
            return new WidgetChannelsListItemChannelActions.Model(this.$channel, guild, l, (modelNotificationSettings == null || (channelOverride = modelNotificationSettings.getChannelOverride(this.$channel.getId())) == null || !channelOverride.isMuted()) ? false : true);
        }
    }

    public WidgetChannelsListItemChannelActions$Model$Companion$get$1(long j) {
        this.$channelId = j;
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelsListItemChannelActions.Model> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.i(companion.getGuilds().observeFromChannelId(this.$channelId), companion.getPermissions().observePermissionsForChannel(this.$channelId), companion.getUserGuildSettings().observeGuildSettings(), new AnonymousClass1(channel));
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelsListItemChannelActions.Model> call(Channel channel) {
        return call2(channel);
    }
}
