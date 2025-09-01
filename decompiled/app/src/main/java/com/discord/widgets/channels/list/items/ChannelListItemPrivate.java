package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.models.presence.Presence;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelListItemPrivate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b0\u00101J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJN\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u000eJ\u001a\u0010\u001f\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u00020\f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u000eR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\bR\u0019\u0010\u0011\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\u0005R\u0016\u0010(\u001a\u00020\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u000bR\u0019\u0010\u0016\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b*\u0010\u000bR\u0019\u0010\u0013\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b+\u0010\u000bR\u001c\u0010,\u001a\u00020\u00198\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u001bR\u001c\u0010\u0014\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b/\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b\u0015\u0010\u000b¨\u00062"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemPrivate;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$UnreadItem;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/presence/Presence;", "component2", "()Lcom/discord/models/presence/Presence;", "", "component3", "()Z", "", "component4", "()I", "component5", "component6", "channel", "presence", "selected", "mentionCount", "isApplicationStreaming", "muted", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/presence/Presence;ZIZZ)Lcom/discord/widgets/channels/list/items/ChannelListItemPrivate;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "Lcom/discord/models/presence/Presence;", "getPresence", "Lcom/discord/api/channel/Channel;", "getChannel", "isUnread", "Z", "getMuted", "getSelected", "key", "Ljava/lang/String;", "getKey", "getMentionCount", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/presence/Presence;ZIZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemPrivate implements ChannelListItem, WidgetChannelListUnreads.UnreadItem {
    private final Channel channel;
    private final boolean isApplicationStreaming;
    private final String key;
    private final int mentionCount;
    private final boolean muted;
    private final Presence presence;
    private final boolean selected;
    private final int type;

    public ChannelListItemPrivate(Channel channel, Presence presence, boolean z2, int i, boolean z3, boolean z4) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.presence = presence;
        this.selected = z2;
        this.mentionCount = i;
        this.isApplicationStreaming = z3;
        this.muted = z4;
        this.type = 3;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(channel.getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemPrivate copy$default(ChannelListItemPrivate channelListItemPrivate, Channel channel, Presence presence, boolean z2, int i, boolean z3, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = channelListItemPrivate.channel;
        }
        if ((i2 & 2) != 0) {
            presence = channelListItemPrivate.presence;
        }
        Presence presence2 = presence;
        if ((i2 & 4) != 0) {
            z2 = channelListItemPrivate.selected;
        }
        boolean z5 = z2;
        if ((i2 & 8) != 0) {
            i = channelListItemPrivate.getMentionCount();
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z3 = channelListItemPrivate.isApplicationStreaming;
        }
        boolean z6 = z3;
        if ((i2 & 32) != 0) {
            z4 = channelListItemPrivate.muted;
        }
        return channelListItemPrivate.copy(channel, presence2, z5, i3, z6, z4);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final int component4() {
        return getMentionCount();
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    public final ChannelListItemPrivate copy(Channel channel, Presence presence, boolean selected, int mentionCount, boolean isApplicationStreaming, boolean muted) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemPrivate(channel, presence, selected, mentionCount, isApplicationStreaming, muted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemPrivate)) {
            return false;
        }
        ChannelListItemPrivate channelListItemPrivate = (ChannelListItemPrivate) other;
        return Intrinsics3.areEqual(this.channel, channelListItemPrivate.channel) && Intrinsics3.areEqual(this.presence, channelListItemPrivate.presence) && this.selected == channelListItemPrivate.selected && getMentionCount() == channelListItemPrivate.getMentionCount() && this.isApplicationStreaming == channelListItemPrivate.isApplicationStreaming && this.muted == channelListItemPrivate.muted;
    }

    public final Channel getChannel() {
        return this.channel;
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

    public final Presence getPresence() {
        return this.presence;
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
        Presence presence = this.presence;
        int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
        boolean z2 = this.selected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int mentionCount = (getMentionCount() + ((iHashCode2 + i) * 31)) * 31;
        boolean z3 = this.isApplicationStreaming;
        int i2 = z3;
        if (z3 != 0) {
            i2 = 1;
        }
        int i3 = (mentionCount + i2) * 31;
        boolean z4 = this.muted;
        return i3 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final boolean isApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
    /* renamed from: isUnread */
    public boolean getIsUnread() {
        return false;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemPrivate(channel=");
        sbU.append(this.channel);
        sbU.append(", presence=");
        sbU.append(this.presence);
        sbU.append(", selected=");
        sbU.append(this.selected);
        sbU.append(", mentionCount=");
        sbU.append(getMentionCount());
        sbU.append(", isApplicationStreaming=");
        sbU.append(this.isApplicationStreaming);
        sbU.append(", muted=");
        return outline.O(sbU, this.muted, ")");
    }
}
