package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.widgets.channels.WidgetChannelTopicViewModel;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetChannelTopicViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/channels/WidgetChannelTopicViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel8<T, R> implements Func1<Channel, Observable<? extends WidgetChannelTopicViewModel.StoreState>> {
    public final /* synthetic */ WidgetChannelTopicViewModel.Companion.NavState $navState;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;
    public final /* synthetic */ StoreUser $storeUsers;

    public WidgetChannelTopicViewModel8(WidgetChannelTopicViewModel.Companion.NavState navState, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings, StoreChannels storeChannels, StoreUser storeUser) {
        this.$navState = navState;
        this.$storeGuilds = storeGuilds;
        this.$storeUserSettings = storeUserSettings;
        this.$storeChannels = storeChannels;
        this.$storeUsers = storeUser;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelTopicViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelTopicViewModel.StoreState> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(new WidgetChannelTopicViewModel.StoreState.NoChannel(this.$navState.isRightPanelOpened(), this.$navState.isOnHomeTab()));
        }
        if (ChannelUtils.B(channel)) {
            return WidgetChannelTopicViewModel.Companion.access$mapChannelToPrivateStoreState(WidgetChannelTopicViewModel.INSTANCE, channel, this.$navState, this.$storeGuilds, this.$storeUserSettings);
        }
        if (channel.getTopic() != null) {
            String topic = channel.getTopic();
            if (!(topic == null || topic.length() == 0)) {
                return WidgetChannelTopicViewModel.Companion.access$mapChannelToGuildStoreState(WidgetChannelTopicViewModel.INSTANCE, channel, this.$navState, this.$storeChannels, this.$storeUsers, this.$storeGuilds, this.$storeUserSettings);
            }
        }
        return new ScalarSynchronousObservable(new WidgetChannelTopicViewModel.StoreState.Guild.DefaultTopic(channel, GuildChannelIconUtils2.getChannelType(channel), this.$navState.isRightPanelOpened(), this.$navState.isOnHomeTab()));
    }
}
