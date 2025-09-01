package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.list.items.ChannelListItem;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelListItemStageAudienceCount.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\u0019\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemStageAudienceCount;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()I", "channel", "audienceSize", "copy", "(Lcom/discord/api/channel/Channel;I)Lcom/discord/widgets/channels/list/items/ChannelListItemStageAudienceCount;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getAudienceSize", "Lcom/discord/api/channel/Channel;", "getChannel", "type", "getType", "<init>", "(Lcom/discord/api/channel/Channel;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemStageAudienceCount implements ChannelListItem {
    private final int audienceSize;
    private final Channel channel;
    private final int type;

    public ChannelListItemStageAudienceCount(Channel channel, int i) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.audienceSize = i;
        this.type = 16;
    }

    public static /* synthetic */ ChannelListItemStageAudienceCount copy$default(ChannelListItemStageAudienceCount channelListItemStageAudienceCount, Channel channel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = channelListItemStageAudienceCount.channel;
        }
        if ((i2 & 2) != 0) {
            i = channelListItemStageAudienceCount.audienceSize;
        }
        return channelListItemStageAudienceCount.copy(channel, i);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final ChannelListItemStageAudienceCount copy(Channel channel, int audienceSize) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemStageAudienceCount(channel, audienceSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemStageAudienceCount)) {
            return false;
        }
        ChannelListItemStageAudienceCount channelListItemStageAudienceCount = (ChannelListItemStageAudienceCount) other;
        return Intrinsics3.areEqual(this.channel, channelListItemStageAudienceCount.channel) && this.audienceSize == channelListItemStageAudienceCount.audienceSize;
    }

    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return ChannelListItem.DefaultImpls.getKey(this);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Channel channel = this.channel;
        return ((channel != null ? channel.hashCode() : 0) * 31) + this.audienceSize;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemStageAudienceCount(channel=");
        sbU.append(this.channel);
        sbU.append(", audienceSize=");
        return outline.B(sbU, this.audienceSize, ")");
    }
}
