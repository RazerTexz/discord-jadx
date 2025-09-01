package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.NotificationTextUtils;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func7;

/* compiled from: WidgetChannelsListItemThreadActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/channels/list/WidgetChannelsListItemThreadActions$Model;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions2<T, R> implements Func1<Channel, Observable<? extends WidgetChannelsListItemThreadActions.Model>> {
    public static final WidgetChannelsListItemThreadActions2 INSTANCE = new WidgetChannelsListItemThreadActions2();

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Channel>, Boolean> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Map<Long, ? extends Channel> map) {
            return call2((Map<Long, Channel>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Map<Long, Channel> map) {
            return Boolean.valueOf(outline.d(this.$channel, map) != null);
        }
    }

    /* compiled from: WidgetChannelsListItemThreadActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0015\u001a\n \u0001*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2.\u0010\r\u001a*\u0012\b\u0012\u00060\u0007j\u0002`\u000b\u0012\u0004\u0012\u00020\f \u0001*\u0014\u0012\b\u0012\u00060\u0007j\u0002`\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n0\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n \u0001*\u0004\u0018\u00010\u00100\u0010H\n¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"Lcom/discord/models/user/MeUser;", "kotlin.jvm.PlatformType", "meUser", "Lcom/discord/api/channel/Channel;", "parentChannel", "Lcom/discord/models/guild/Guild;", "guild", "", "Lcom/discord/api/permission/PermissionBit;", "parentPermissions", "", "Lcom/discord/primitives/GuildId;", "Lcom/discord/models/domain/ModelNotificationSettings;", "guildSettings", "Lcom/discord/stores/StoreThreadsJoined$JoinedThread;", "joinedThread", "", "isActiveThread", "Lcom/discord/widgets/channels/list/WidgetChannelsListItemThreadActions$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/MeUser;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Ljava/lang/Long;Ljava/util/Map;Lcom/discord/stores/StoreThreadsJoined$JoinedThread;Ljava/lang/Boolean;)Lcom/discord/widgets/channels/list/WidgetChannelsListItemThreadActions$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions$Model$Companion$get$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<MeUser, Channel, Guild, Long, Map<Long, ? extends ModelNotificationSettings>, StoreThreadsJoined.JoinedThread, Boolean, WidgetChannelsListItemThreadActions.Model> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass2(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func7
        public /* bridge */ /* synthetic */ WidgetChannelsListItemThreadActions.Model call(MeUser meUser, Channel channel, Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined.JoinedThread joinedThread, Boolean bool) {
            return call2(meUser, channel, guild, l, map, joinedThread, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChannelsListItemThreadActions.Model call2(MeUser meUser, Channel channel, Guild guild, Long l, Map<Long, ? extends ModelNotificationSettings> map, StoreThreadsJoined.JoinedThread joinedThread, Boolean bool) {
            NotificationTextUtils notificationTextUtils = NotificationTextUtils.INSTANCE;
            boolean zIsGuildOrCategoryOrChannelMuted = notificationTextUtils.isGuildOrCategoryOrChannelMuted((ModelNotificationSettings) outline.c(this.$channel, map), channel);
            Integer numChannelMessageNotificationLevel = notificationTextUtils.channelMessageNotificationLevel((ModelNotificationSettings) outline.c(this.$channel, map), this.$channel, guild);
            ThreadUtils threadUtils = ThreadUtils.INSTANCE;
            int iComputeThreadNotificationSetting = threadUtils.computeThreadNotificationSetting(joinedThread, zIsGuildOrCategoryOrChannelMuted, numChannelMessageNotificationLevel);
            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
            boolean zCanManageThread = threadUtils.canManageThread(meUser, this.$channel, Long.valueOf(l != null ? l.longValue() : 0L));
            boolean zCanUnarchiveThread = threadUtils.canUnarchiveThread(this.$channel, Long.valueOf(l != null ? l.longValue() : 0L));
            boolean zIsThreadModerator = threadUtils.isThreadModerator(Long.valueOf(l != null ? l.longValue() : 0L));
            boolean z2 = joinedThread != null && joinedThread.getMuted();
            Channel channel2 = this.$channel;
            Intrinsics3.checkNotNullExpressionValue(bool, "isActiveThread");
            return new WidgetChannelsListItemThreadActions.Model(meUser, channel2, guild, channel, iComputeThreadNotificationSetting, joinedThread, bool.booleanValue(), zIsThreadModerator, zCanManageThread, zCanUnarchiveThread, z2);
        }
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelsListItemThreadActions.Model> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.e(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getChannels().observeChannel(channel.getParentId()), companion.getGuilds().observeGuild(channel.getGuildId()), companion.getPermissions().observePermissionsForChannel(channel.getParentId()), companion.getUserGuildSettings().observeGuildSettings(), companion.getThreadsJoined().observeJoinedThread(channel.getId()), companion.getThreadsActive().observeActiveThreadsForGuild(channel.getGuildId()).G(new AnonymousClass1(channel)).r(), new AnonymousClass2(channel));
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelsListItemThreadActions.Model> call(Channel channel) {
        return call2(channel);
    }
}
