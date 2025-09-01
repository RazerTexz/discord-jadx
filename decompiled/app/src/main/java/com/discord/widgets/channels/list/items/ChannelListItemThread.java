package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelListItemThread.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b1\u00102J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJL\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u000bJ\u001a\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u00178V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019R\u0019\u0010\u0014\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\bR\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0019\u0010\u0010\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b*\u0010\bR\u0019\u0010\u0013\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\u0013\u0010\bR\u001c\u0010\u0011\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\u0012\u0010\bR\u001c\u0010-\u001a\u00020\t8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b-\u0010+\u001a\u0004\b.\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b0\u0010\u0005¨\u00063"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemThread;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$UnreadItem;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "", "component3", "()I", "component4", "component5", "component6", "channel", "selected", "mentionCount", "isUnread", "isLocked", "muted", "copy", "(Lcom/discord/api/channel/Channel;ZIZZZ)Lcom/discord/widgets/channels/list/items/ChannelListItemThread;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "getKey", "key", "Z", "getMuted", "Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType;", "spineType", "Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType;", "getSpineType", "()Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType;", "setSpineType", "(Lcom/discord/widgets/channels/list/WidgetChannelListModel$ThreadSpineType;)V", "getSelected", "I", "getMentionCount", "type", "getType", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;ZIZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemThread implements ChannelListItem, WidgetChannelListUnreads.UnreadItem {
    private final Channel channel;
    private final boolean isLocked;
    private final boolean isUnread;
    private final int mentionCount;
    private final boolean muted;
    private final boolean selected;
    private WidgetChannelListModel.ThreadSpineType spineType;
    private final int type;

    public ChannelListItemThread(Channel channel, boolean z2, int i, boolean z3, boolean z4, boolean z5) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.selected = z2;
        this.mentionCount = i;
        this.isUnread = z3;
        this.isLocked = z4;
        this.muted = z5;
        this.spineType = WidgetChannelListModel.ThreadSpineType.Single.INSTANCE;
        this.type = 12;
    }

    public static /* synthetic */ ChannelListItemThread copy$default(ChannelListItemThread channelListItemThread, Channel channel, boolean z2, int i, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = channelListItemThread.channel;
        }
        if ((i2 & 2) != 0) {
            z2 = channelListItemThread.selected;
        }
        boolean z6 = z2;
        if ((i2 & 4) != 0) {
            i = channelListItemThread.getMentionCount();
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z3 = channelListItemThread.getIsUnread();
        }
        boolean z7 = z3;
        if ((i2 & 16) != 0) {
            z4 = channelListItemThread.isLocked;
        }
        boolean z8 = z4;
        if ((i2 & 32) != 0) {
            z5 = channelListItemThread.muted;
        }
        return channelListItemThread.copy(channel, z6, i3, z7, z8, z5);
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
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    public final ChannelListItemThread copy(Channel channel, boolean selected, int mentionCount, boolean isUnread, boolean isLocked, boolean muted) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemThread(channel, selected, mentionCount, isUnread, isLocked, muted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemThread)) {
            return false;
        }
        ChannelListItemThread channelListItemThread = (ChannelListItemThread) other;
        return Intrinsics3.areEqual(this.channel, channelListItemThread.channel) && this.selected == channelListItemThread.selected && getMentionCount() == channelListItemThread.getMentionCount() && getIsUnread() == channelListItemThread.getIsUnread() && this.isLocked == channelListItemThread.isLocked && this.muted == channelListItemThread.muted;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(this.channel.getId());
        sb.append(this.spineType);
        sb.append(this.muted);
        return sb.toString();
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

    public final WidgetChannelListModel.ThreadSpineType getSpineType() {
        return this.spineType;
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
        boolean z3 = this.isLocked;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z4 = this.muted;
        return i5 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
    /* renamed from: isUnread, reason: from getter */
    public boolean getIsUnread() {
        return this.isUnread;
    }

    public final void setSpineType(WidgetChannelListModel.ThreadSpineType threadSpineType) {
        Intrinsics3.checkNotNullParameter(threadSpineType, "<set-?>");
        this.spineType = threadSpineType;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemThread(channel=");
        sbU.append(this.channel);
        sbU.append(", selected=");
        sbU.append(this.selected);
        sbU.append(", mentionCount=");
        sbU.append(getMentionCount());
        sbU.append(", isUnread=");
        sbU.append(getIsUnread());
        sbU.append(", isLocked=");
        sbU.append(this.isLocked);
        sbU.append(", muted=");
        return outline.O(sbU, this.muted, ")");
    }
}
