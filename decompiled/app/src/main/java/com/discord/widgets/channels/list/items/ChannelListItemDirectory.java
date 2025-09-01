package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelListItemDirectory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\nJ\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0012R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001c\u0010!\u001a\u00020\b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\n¨\u0006%"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemDirectory;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "", "component3", "()I", "channel", "selected", "unreadCount", "copy", "(Lcom/discord/api/channel/Channel;ZI)Lcom/discord/widgets/channels/list/items/ChannelListItemDirectory;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/api/channel/Channel;", "getChannel", "I", "getUnreadCount", "Z", "getSelected", "type", "getType", "<init>", "(Lcom/discord/api/channel/Channel;ZI)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemDirectory implements ChannelListItem {
    private final Channel channel;
    private final String key;
    private final boolean selected;
    private final int type;
    private final int unreadCount;

    public ChannelListItemDirectory(Channel channel, boolean z2, int i) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.selected = z2;
        this.unreadCount = i;
        this.type = 17;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(channel.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemDirectory copy$default(ChannelListItemDirectory channelListItemDirectory, Channel channel, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = channelListItemDirectory.channel;
        }
        if ((i2 & 2) != 0) {
            z2 = channelListItemDirectory.selected;
        }
        if ((i2 & 4) != 0) {
            i = channelListItemDirectory.unreadCount;
        }
        return channelListItemDirectory.copy(channel, z2, i);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* renamed from: component3, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public final ChannelListItemDirectory copy(Channel channel, boolean selected, int unreadCount) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemDirectory(channel, selected, unreadCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemDirectory)) {
            return false;
        }
        ChannelListItemDirectory channelListItemDirectory = (ChannelListItemDirectory) other;
        return Intrinsics3.areEqual(this.channel, channelListItemDirectory.channel) && this.selected == channelListItemDirectory.selected && this.unreadCount == channelListItemDirectory.unreadCount;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.selected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return ((iHashCode + i) * 31) + this.unreadCount;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemDirectory(channel=");
        sbU.append(this.channel);
        sbU.append(", selected=");
        sbU.append(this.selected);
        sbU.append(", unreadCount=");
        return outline.B(sbU, this.unreadCount, ")");
    }
}
