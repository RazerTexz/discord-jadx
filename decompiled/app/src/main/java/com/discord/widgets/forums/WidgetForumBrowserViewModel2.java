package com.discord.widgets.forums;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreThreadsActive;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import com.discord.widgets.tabs.NavigationTab;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Map;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetForumBrowserViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;", "kotlin.jvm.PlatformType", "resolvedSelectedChannel", "Lrx/Observable;", "Lcom/discord/widgets/forums/WidgetForumBrowserViewModel$MinimalStoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreChannelsSelected$ResolvedSelectedChannel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$Companion$observeMinimalStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel2<T, R> implements Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends WidgetForumBrowserViewModel.MinimalStoreState>> {
    public final /* synthetic */ StoreExperiments $storeExperiments;
    public final /* synthetic */ StoreTabsNavigation $storeTabsNavigation;
    public final /* synthetic */ StoreThreadsActive $storeThreadsActive;

    /* compiled from: WidgetForumBrowserViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\n \u0001*\u0004\u0018\u00010\n0\n2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002.\u0010\u0007\u001a*\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006 \u0001*\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u00032\u000e\u0010\t\u001a\n \u0001*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/discord/widgets/tabs/NavigationTab;", "kotlin.jvm.PlatformType", "selectedTab", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "activeThreads", "", "canAccess", "Lcom/discord/widgets/forums/WidgetForumBrowserViewModel$MinimalStoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/tabs/NavigationTab;Ljava/util/Map;Ljava/lang/Boolean;)Lcom/discord/widgets/forums/WidgetForumBrowserViewModel$MinimalStoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$Companion$observeMinimalStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<NavigationTab, Map<Long, ? extends Channel>, Boolean, WidgetForumBrowserViewModel.MinimalStoreState> {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass1(Channel channel) {
            this.$channel = channel;
        }

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetForumBrowserViewModel.MinimalStoreState call(NavigationTab navigationTab, Map<Long, ? extends Channel> map, Boolean bool) {
            return call2(navigationTab, (Map<Long, Channel>) map, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetForumBrowserViewModel.MinimalStoreState call2(NavigationTab navigationTab, Map<Long, Channel> map, Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "canAccess");
            if (!bool.booleanValue() || navigationTab != NavigationTab.HOME || !ChannelUtils.q(this.$channel)) {
                return WidgetForumBrowserViewModel.MinimalStoreState.Invalid.INSTANCE;
            }
            Intrinsics3.checkNotNullExpressionValue(map, "activeThreads");
            return new WidgetForumBrowserViewModel.MinimalStoreState.Valid(this.$channel, map);
        }
    }

    public WidgetForumBrowserViewModel2(StoreTabsNavigation storeTabsNavigation, StoreThreadsActive storeThreadsActive, StoreExperiments storeExperiments) {
        this.$storeTabsNavigation = storeTabsNavigation;
        this.$storeThreadsActive = storeThreadsActive;
        this.$storeExperiments = storeExperiments;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetForumBrowserViewModel.MinimalStoreState> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(resolvedSelectedChannel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetForumBrowserViewModel.MinimalStoreState> call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
        return maybeChannel == null ? new ScalarSynchronousObservable(WidgetForumBrowserViewModel.MinimalStoreState.Invalid.INSTANCE) : Observable.i(this.$storeTabsNavigation.observeSelectedTab(), this.$storeThreadsActive.observeActiveThreadsForChannel(maybeChannel.getGuildId(), Long.valueOf(maybeChannel.getId())), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, maybeChannel.getGuildId(), this.$storeExperiments, null, 4, null), new AnonymousClass1(maybeChannel));
    }
}
