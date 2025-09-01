package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelListItemTextChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b2\u00103J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000f\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0011\u0010\bJj\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010\u000bJ\u001a\u0010#\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b#\u0010$R\u001c\u0010%\u001a\u00020\u001d8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u001fR\u0019\u0010\u0018\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b)\u0010\bR\u0019\u0010\u0019\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b\u0019\u0010\bR\u001c\u0010\u0014\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010\u000bR\u0019\u0010\u0017\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b\u0017\u0010\bR\u001c\u0010,\u001a\u00020\t8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b,\u0010*\u001a\u0004\b-\u0010\u000bR\u0019\u0010\u0016\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b.\u0010\bR\u0019\u0010\u0013\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b/\u0010\bR\u0019\u0010\u001a\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b\u001a\u0010\bR\u0019\u0010\u0012\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u00100\u001a\u0004\b1\u0010\u0005R\u001c\u0010\u0015\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b\u0015\u0010\b¨\u00064"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemTextChannel;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$UnreadItem;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "", "component3", "()I", "component4", "component5", "component6", "component7", "component8", "component9", "channel", "selected", "mentionCount", "isUnread", "muted", "isLocked", "hasActiveThreads", "isGuildRoleSubscriptionLockedChannel", "isGuildRoleSubscriptionChannel", "copy", "(Lcom/discord/api/channel/Channel;ZIZZZZZZ)Lcom/discord/widgets/channels/list/items/ChannelListItemTextChannel;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "Z", "getHasActiveThreads", "I", "getMentionCount", "type", "getType", "getMuted", "getSelected", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;ZIZZZZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemTextChannel implements ChannelListItem, WidgetChannelListUnreads.UnreadItem {
    private final Channel channel;
    private final boolean hasActiveThreads;
    private final boolean isGuildRoleSubscriptionChannel;
    private final boolean isGuildRoleSubscriptionLockedChannel;
    private final boolean isLocked;
    private final boolean isUnread;
    private final String key;
    private final int mentionCount;
    private final boolean muted;
    private final boolean selected;
    private final int type;

    public ChannelListItemTextChannel(Channel channel, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.selected = z2;
        this.mentionCount = i;
        this.isUnread = z3;
        this.muted = z4;
        this.isLocked = z5;
        this.hasActiveThreads = z6;
        this.isGuildRoleSubscriptionLockedChannel = z7;
        this.isGuildRoleSubscriptionChannel = z8;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(channel.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemTextChannel copy$default(ChannelListItemTextChannel channelListItemTextChannel, Channel channel, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i2, Object obj) {
        return channelListItemTextChannel.copy((i2 & 1) != 0 ? channelListItemTextChannel.channel : channel, (i2 & 2) != 0 ? channelListItemTextChannel.selected : z2, (i2 & 4) != 0 ? channelListItemTextChannel.getMentionCount() : i, (i2 & 8) != 0 ? channelListItemTextChannel.getIsUnread() : z3, (i2 & 16) != 0 ? channelListItemTextChannel.muted : z4, (i2 & 32) != 0 ? channelListItemTextChannel.isLocked : z5, (i2 & 64) != 0 ? channelListItemTextChannel.hasActiveThreads : z6, (i2 & 128) != 0 ? channelListItemTextChannel.isGuildRoleSubscriptionLockedChannel : z7, (i2 & 256) != 0 ? channelListItemTextChannel.isGuildRoleSubscriptionChannel : z8);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final int component3() {
        return getMentionCount();
    }

    public final boolean component4() {
        return getIsUnread();
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getHasActiveThreads() {
        return this.hasActiveThreads;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    public final ChannelListItemTextChannel copy(Channel channel, boolean selected, int mentionCount, boolean isUnread, boolean muted, boolean isLocked, boolean hasActiveThreads, boolean isGuildRoleSubscriptionLockedChannel, boolean isGuildRoleSubscriptionChannel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemTextChannel(channel, selected, mentionCount, isUnread, muted, isLocked, hasActiveThreads, isGuildRoleSubscriptionLockedChannel, isGuildRoleSubscriptionChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemTextChannel)) {
            return false;
        }
        ChannelListItemTextChannel channelListItemTextChannel = (ChannelListItemTextChannel) other;
        return Intrinsics3.areEqual(this.channel, channelListItemTextChannel.channel) && this.selected == channelListItemTextChannel.selected && getMentionCount() == channelListItemTextChannel.getMentionCount() && getIsUnread() == channelListItemTextChannel.getIsUnread() && this.muted == channelListItemTextChannel.muted && this.isLocked == channelListItemTextChannel.isLocked && this.hasActiveThreads == channelListItemTextChannel.hasActiveThreads && this.isGuildRoleSubscriptionLockedChannel == channelListItemTextChannel.isGuildRoleSubscriptionLockedChannel && this.isGuildRoleSubscriptionChannel == channelListItemTextChannel.isGuildRoleSubscriptionChannel;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final boolean getHasActiveThreads() {
        return this.hasActiveThreads;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
    public int getMentionCount() {
        return this.mentionCount;
    }

    public final boolean getMuted() {
        return this.muted;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
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
        int mentionCount = (getMentionCount() + ((iHashCode + i) * 31)) * 31;
        boolean isUnread = getIsUnread();
        int i2 = isUnread;
        if (isUnread) {
            i2 = 1;
        }
        int i3 = (mentionCount + i2) * 31;
        boolean z3 = this.muted;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z4 = this.isLocked;
        int i6 = z4;
        if (z4 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        boolean z5 = this.hasActiveThreads;
        int i8 = z5;
        if (z5 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        boolean z6 = this.isGuildRoleSubscriptionLockedChannel;
        int i10 = z6;
        if (z6 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        boolean z7 = this.isGuildRoleSubscriptionChannel;
        return i11 + (z7 ? 1 : z7 ? 1 : 0);
    }

    public final boolean isGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    public final boolean isGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
    /* renamed from: isUnread, reason: from getter */
    public boolean getIsUnread() {
        return this.isUnread;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemTextChannel(channel=");
        sbU.append(this.channel);
        sbU.append(", selected=");
        sbU.append(this.selected);
        sbU.append(", mentionCount=");
        sbU.append(getMentionCount());
        sbU.append(", isUnread=");
        sbU.append(getIsUnread());
        sbU.append(", muted=");
        sbU.append(this.muted);
        sbU.append(", isLocked=");
        sbU.append(this.isLocked);
        sbU.append(", hasActiveThreads=");
        sbU.append(this.hasActiveThreads);
        sbU.append(", isGuildRoleSubscriptionLockedChannel=");
        sbU.append(this.isGuildRoleSubscriptionLockedChannel);
        sbU.append(", isGuildRoleSubscriptionChannel=");
        return outline.O(sbU, this.isGuildRoleSubscriptionChannel, ")");
    }
}
