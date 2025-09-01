package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetChannelSidebarActionsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/panels/PanelState;", "kotlin.jvm.PlatformType", "panelState", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/panels/PanelState;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSidebarActionsViewModel2<T, R> implements Func1<PanelState, Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState>> {
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreGuildsNsfw $storeGuildNSFW;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserGuildSettings $storeUserGuildSettings;

    /* compiled from: WidgetChannelSidebarActionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetChannelSidebarActionsViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Channel, Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState>> {
        public final /* synthetic */ PanelState $panelState;

        public AnonymousClass1(PanelState panelState) {
            this.$panelState = panelState;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> call2(Channel channel) {
            Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> scalarSynchronousObservable = channel == null ? new ScalarSynchronousObservable<>(WidgetChannelSidebarActionsViewModel.StoreState.ChannelNotFound.INSTANCE) : Observable.i(WidgetChannelSidebarActionsViewModel2.this.$storeUserGuildSettings.observeGuildSettings(), StoreUser.observeMe$default(WidgetChannelSidebarActionsViewModel2.this.$storeUser, false, 1, null), WidgetChannelSidebarActionsViewModel2.this.$storeChannels.observeChannel(channel.getParentId()), new WidgetChannelSidebarActionsViewModel3(this, channel));
            return Intrinsics3.areEqual(this.$panelState, PanelState.c.a) ? scalarSynchronousObservable : scalarSynchronousObservable.Z(1);
        }
    }

    public WidgetChannelSidebarActionsViewModel2(StoreChannelsSelected storeChannelsSelected, StoreUserGuildSettings storeUserGuildSettings, StoreUser storeUser, StoreChannels storeChannels, StoreGuildsNsfw storeGuildsNsfw) {
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storeUserGuildSettings = storeUserGuildSettings;
        this.$storeUser = storeUser;
        this.$storeChannels = storeChannels;
        this.$storeGuildNSFW = storeGuildsNsfw;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> call(PanelState panelState) {
        return call2(panelState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> call2(PanelState panelState) {
        return this.$storeChannelsSelected.observeSelectedChannel().Y(new AnonymousClass1(panelState));
    }
}
