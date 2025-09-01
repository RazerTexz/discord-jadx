package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.status.WidgetThreadStatusViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func4;

/* compiled from: WidgetThreadStatusViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "selectedChannel", "Lrx/Observable;", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.status.WidgetThreadStatusViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel6<T, R> implements Func1<Channel, Observable<? extends WidgetThreadStatusViewModel.StoreState>> {
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreExperiments $storeExperiments;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreThreadsActiveJoined $storeThreadsActiveJoined;

    /* compiled from: WidgetThreadStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000f\u001a\n \u0004*\u0004\u0018\u00010\f0\f2N\u0010\u0005\u001aJ\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000 \u0004*$\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000\u0018\u00010\u00000\u00002\u000e\u0010\u0007\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "kotlin.jvm.PlatformType", "activeJoinedThreads", "Lcom/discord/api/permission/PermissionBit;", "channelPermissions", "Lcom/discord/api/channel/Channel;", "parentChannel", "", "canAccessRedesignedForumChannels", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/lang/Long;Lcom/discord/api/channel/Channel;Ljava/lang/Boolean;)Lcom/discord/widgets/status/WidgetThreadStatusViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetThreadStatusViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, R> implements Func4<Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>>, Long, Channel, Boolean, WidgetThreadStatusViewModel.StoreState> {
        public final /* synthetic */ Channel $selectedChannel;

        public AnonymousClass1(Channel channel) {
            this.$selectedChannel = channel;
        }

        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ WidgetThreadStatusViewModel.StoreState call(Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>> map, Long l, Channel channel, Boolean bool) {
            return call2((Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>>) map, l, channel, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetThreadStatusViewModel.StoreState call2(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> map, Long l, Channel channel, Boolean bool) {
            ThreadUtils threadUtils = ThreadUtils.INSTANCE;
            Channel channel2 = this.$selectedChannel;
            Intrinsics3.checkNotNullExpressionValue(channel2, "selectedChannel");
            boolean zCanUnarchiveThread = threadUtils.canUnarchiveThread(channel2, l);
            boolean zIsThreadModerator = threadUtils.isThreadModerator(Long.valueOf(l != null ? l.longValue() : 0L));
            Intrinsics3.checkNotNullExpressionValue(map, "activeJoinedThreads");
            Channel channel3 = this.$selectedChannel;
            Intrinsics3.checkNotNullExpressionValue(bool, "canAccessRedesignedForumChannels");
            return new WidgetThreadStatusViewModel.StoreState(map, channel3, channel, zCanUnarchiveThread, zIsThreadModerator, bool.booleanValue());
        }
    }

    public WidgetThreadStatusViewModel6(StoreThreadsActiveJoined storeThreadsActiveJoined, StorePermissions storePermissions, StoreChannels storeChannels, StoreExperiments storeExperiments) {
        this.$storeThreadsActiveJoined = storeThreadsActiveJoined;
        this.$storePermissions = storePermissions;
        this.$storeChannels = storeChannels;
        this.$storeExperiments = storeExperiments;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadStatusViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetThreadStatusViewModel.StoreState> call2(Channel channel) {
        return Observable.h(this.$storeThreadsActiveJoined.observeActiveJoinedThreadsForGuild(channel.getGuildId()), this.$storePermissions.observePermissionsForChannel(channel.getId()), this.$storeChannels.observeChannel(channel.getParentId()), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), this.$storeExperiments, null, 4, null), new AnonymousClass1(channel)).r();
    }
}
