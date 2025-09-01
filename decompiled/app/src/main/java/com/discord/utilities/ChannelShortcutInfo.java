package com.discord.utilities;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ShareUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u001a\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\r\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/discord/utilities/ChannelShortcutInfo;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()I", "", "component3", "()Z", "channel", "rank", "isPinnedOnly", "copy", "(Lcom/discord/api/channel/Channel;IZ)Lcom/discord/utilities/ChannelShortcutInfo;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getRank", "Lcom/discord/api/channel/Channel;", "getChannel", "Z", "<init>", "(Lcom/discord/api/channel/Channel;IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelShortcutInfo {
    private final Channel channel;
    private final boolean isPinnedOnly;
    private final int rank;

    public ChannelShortcutInfo(Channel channel, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.rank = i;
        this.isPinnedOnly = z2;
    }

    public static /* synthetic */ ChannelShortcutInfo copy$default(ChannelShortcutInfo channelShortcutInfo, Channel channel, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = channelShortcutInfo.channel;
        }
        if ((i2 & 2) != 0) {
            i = channelShortcutInfo.rank;
        }
        if ((i2 & 4) != 0) {
            z2 = channelShortcutInfo.isPinnedOnly;
        }
        return channelShortcutInfo.copy(channel, i, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRank() {
        return this.rank;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsPinnedOnly() {
        return this.isPinnedOnly;
    }

    public final ChannelShortcutInfo copy(Channel channel, int rank, boolean isPinnedOnly) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelShortcutInfo(channel, rank, isPinnedOnly);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelShortcutInfo)) {
            return false;
        }
        ChannelShortcutInfo channelShortcutInfo = (ChannelShortcutInfo) other;
        return Intrinsics3.areEqual(this.channel, channelShortcutInfo.channel) && this.rank == channelShortcutInfo.rank && this.isPinnedOnly == channelShortcutInfo.isPinnedOnly;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final int getRank() {
        return this.rank;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (((channel != null ? channel.hashCode() : 0) * 31) + this.rank) * 31;
        boolean z2 = this.isPinnedOnly;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public final boolean isPinnedOnly() {
        return this.isPinnedOnly;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelShortcutInfo(channel=");
        sbU.append(this.channel);
        sbU.append(", rank=");
        sbU.append(this.rank);
        sbU.append(", isPinnedOnly=");
        return outline.O(sbU, this.isPinnedOnly, ")");
    }
}
