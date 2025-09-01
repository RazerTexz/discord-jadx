package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.utilities.channel.ChannelSelector;
import kotlin.Metadata;

/* compiled from: StoreChannelConversions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/stores/StoreChannelConversions;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/channel/Channel;", "channel", "", "handleChannelCreateOrUpdate", "(Lcom/discord/api/channel/Channel;)V", "", "channelId", "handleChannelSelected", "(J)V", "selectedChannelId", "J", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreChannelConversions extends StoreV2 {
    private long selectedChannelId;

    @Store3
    public final void handleChannelCreateOrUpdate(Channel channel) {
        if (channel == null) {
            return;
        }
        long id2 = channel.getId();
        long originChannelId = channel.getOriginChannelId();
        if (originChannelId != 0 && this.selectedChannelId == originChannelId) {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), 0L, id2, null, null, 12, null);
        }
    }

    @Store3
    public final void handleChannelSelected(long channelId) {
        this.selectedChannelId = channelId;
    }
}
