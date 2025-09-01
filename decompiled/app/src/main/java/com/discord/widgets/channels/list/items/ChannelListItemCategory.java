package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelListItemCategory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0012R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001c\u0010\u001f\u001a\u00020\u00138\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u000b\u0010\u0007R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemCategory;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "component3", "component4", "channel", "isCollapsed", "isMuted", "canManageChannels", "copy", "(Lcom/discord/api/channel/Channel;ZZZ)Lcom/discord/widgets/channels/list/items/ChannelListItemCategory;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "Z", "getCanManageChannels", "type", "I", "getType", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemCategory implements ChannelListItem {
    private final boolean canManageChannels;
    private final Channel channel;
    private final boolean isCollapsed;
    private final boolean isMuted;
    private final String key;
    private final int type;

    public ChannelListItemCategory(Channel channel, boolean z2, boolean z3, boolean z4) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.isCollapsed = z2;
        this.isMuted = z3;
        this.canManageChannels = z4;
        this.type = 8;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(channel.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemCategory copy$default(ChannelListItemCategory channelListItemCategory, Channel channel, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = channelListItemCategory.channel;
        }
        if ((i & 2) != 0) {
            z2 = channelListItemCategory.isCollapsed;
        }
        if ((i & 4) != 0) {
            z3 = channelListItemCategory.isMuted;
        }
        if ((i & 8) != 0) {
            z4 = channelListItemCategory.canManageChannels;
        }
        return channelListItemCategory.copy(channel, z2, z3, z4);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsCollapsed() {
        return this.isCollapsed;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getCanManageChannels() {
        return this.canManageChannels;
    }

    public final ChannelListItemCategory copy(Channel channel, boolean isCollapsed, boolean isMuted, boolean canManageChannels) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemCategory(channel, isCollapsed, isMuted, canManageChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemCategory)) {
            return false;
        }
        ChannelListItemCategory channelListItemCategory = (ChannelListItemCategory) other;
        return Intrinsics3.areEqual(this.channel, channelListItemCategory.channel) && this.isCollapsed == channelListItemCategory.isCollapsed && this.isMuted == channelListItemCategory.isMuted && this.canManageChannels == channelListItemCategory.canManageChannels;
    }

    public final boolean getCanManageChannels() {
        return this.canManageChannels;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.isCollapsed;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z3 = this.isMuted;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.canManageChannels;
        return i4 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final boolean isCollapsed() {
        return this.isCollapsed;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemCategory(channel=");
        sbU.append(this.channel);
        sbU.append(", isCollapsed=");
        sbU.append(this.isCollapsed);
        sbU.append(", isMuted=");
        sbU.append(this.isMuted);
        sbU.append(", canManageChannels=");
        return outline.O(sbU, this.canManageChannels, ")");
    }
}
