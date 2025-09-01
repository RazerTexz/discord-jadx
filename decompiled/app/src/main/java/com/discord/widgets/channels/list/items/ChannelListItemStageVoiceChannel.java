package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelListItemStageVoiceChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u000e\u0010\u0019\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0015\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0016\u0010\bJt\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00062\u0010\b\u0002\u0010\u0019\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b%\u0010\u0010J\u001a\u0010(\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b(\u0010)R\u0019\u0010\u001a\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010*\u001a\u0004\b\u001a\u0010\bR\u0019\u0010\u001d\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010*\u001a\u0004\b+\u0010\bR\u0013\u0010-\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010\bR\u001c\u0010.\u001a\u00020\"8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010$R\u001c\u0010\u001b\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\b2\u0010\u0010R\u0019\u0010\u001f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010*\u001a\u0004\b\u001f\u0010\bR\u001c\u0010\u0017\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u00103\u001a\u0004\b4\u0010\u0005R\u0019\u0010\u001e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010*\u001a\u0004\b\u001e\u0010\bR\u0019\u0010\u0018\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b5\u0010\bR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00106\u001a\u0004\b7\u0010\u0013R\u001c\u00108\u001a\u00020\u000e8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u0010\u0010R!\u0010\u0019\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010:\u001a\u0004\b;\u0010\f¨\u0006>"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemStageVoiceChannel;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "Lcom/discord/widgets/channels/list/items/ChannelListVocalItem;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "", "Lcom/discord/api/permission/PermissionBit;", "component3", "()Ljava/lang/Long;", "component4", "", "component5", "()I", "Lcom/discord/api/stageinstance/StageInstance;", "component6", "()Lcom/discord/api/stageinstance/StageInstance;", "component7", "component8", "component9", "channel", "selected", "permission", "isLocked", "numUsersConnected", "stageInstance", "hasSpeakers", "isGuildRoleSubscriptionLockedChannel", "isGuildRoleSubscriptionChannel", "copy", "(Lcom/discord/api/channel/Channel;ZLjava/lang/Long;ZILcom/discord/api/stageinstance/StageInstance;ZZZ)Lcom/discord/widgets/channels/list/items/ChannelListItemStageVoiceChannel;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHasSpeakers", "getHasActiveEvent", "hasActiveEvent", "key", "Ljava/lang/String;", "getKey", "I", "getNumUsersConnected", "Lcom/discord/api/channel/Channel;", "getChannel", "getSelected", "Lcom/discord/api/stageinstance/StageInstance;", "getStageInstance", "type", "getType", "Ljava/lang/Long;", "getPermission", "<init>", "(Lcom/discord/api/channel/Channel;ZLjava/lang/Long;ZILcom/discord/api/stageinstance/StageInstance;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemStageVoiceChannel implements ChannelListItem, ChannelListVocalItem {
    private final Channel channel;
    private final boolean hasSpeakers;
    private final boolean isGuildRoleSubscriptionChannel;
    private final boolean isGuildRoleSubscriptionLockedChannel;
    private final boolean isLocked;
    private final String key;
    private final int numUsersConnected;
    private final Long permission;
    private final boolean selected;
    private final StageInstance stageInstance;
    private final int type;

    public ChannelListItemStageVoiceChannel(Channel channel, boolean z2, Long l, boolean z3, int i, StageInstance stageInstance, boolean z4, boolean z5, boolean z6) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.selected = z2;
        this.permission = l;
        this.isLocked = z3;
        this.numUsersConnected = i;
        this.stageInstance = stageInstance;
        this.hasSpeakers = z4;
        this.isGuildRoleSubscriptionLockedChannel = z5;
        this.isGuildRoleSubscriptionChannel = z6;
        this.type = 13;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(getChannel().getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemStageVoiceChannel copy$default(ChannelListItemStageVoiceChannel channelListItemStageVoiceChannel, Channel channel, boolean z2, Long l, boolean z3, int i, StageInstance stageInstance, boolean z4, boolean z5, boolean z6, int i2, Object obj) {
        return channelListItemStageVoiceChannel.copy((i2 & 1) != 0 ? channelListItemStageVoiceChannel.getChannel() : channel, (i2 & 2) != 0 ? channelListItemStageVoiceChannel.selected : z2, (i2 & 4) != 0 ? channelListItemStageVoiceChannel.permission : l, (i2 & 8) != 0 ? channelListItemStageVoiceChannel.isLocked : z3, (i2 & 16) != 0 ? channelListItemStageVoiceChannel.getNumUsersConnected() : i, (i2 & 32) != 0 ? channelListItemStageVoiceChannel.stageInstance : stageInstance, (i2 & 64) != 0 ? channelListItemStageVoiceChannel.hasSpeakers : z4, (i2 & 128) != 0 ? channelListItemStageVoiceChannel.isGuildRoleSubscriptionLockedChannel : z5, (i2 & 256) != 0 ? channelListItemStageVoiceChannel.isGuildRoleSubscriptionChannel : z6);
    }

    public final Channel component1() {
        return getChannel();
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getPermission() {
        return this.permission;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    public final int component5() {
        return getNumUsersConnected();
    }

    /* renamed from: component6, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getHasSpeakers() {
        return this.hasSpeakers;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    public final ChannelListItemStageVoiceChannel copy(Channel channel, boolean selected, Long permission, boolean isLocked, int numUsersConnected, StageInstance stageInstance, boolean hasSpeakers, boolean isGuildRoleSubscriptionLockedChannel, boolean isGuildRoleSubscriptionChannel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelListItemStageVoiceChannel(channel, selected, permission, isLocked, numUsersConnected, stageInstance, hasSpeakers, isGuildRoleSubscriptionLockedChannel, isGuildRoleSubscriptionChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemStageVoiceChannel)) {
            return false;
        }
        ChannelListItemStageVoiceChannel channelListItemStageVoiceChannel = (ChannelListItemStageVoiceChannel) other;
        return Intrinsics3.areEqual(getChannel(), channelListItemStageVoiceChannel.getChannel()) && this.selected == channelListItemStageVoiceChannel.selected && Intrinsics3.areEqual(this.permission, channelListItemStageVoiceChannel.permission) && this.isLocked == channelListItemStageVoiceChannel.isLocked && getNumUsersConnected() == channelListItemStageVoiceChannel.getNumUsersConnected() && Intrinsics3.areEqual(this.stageInstance, channelListItemStageVoiceChannel.stageInstance) && this.hasSpeakers == channelListItemStageVoiceChannel.hasSpeakers && this.isGuildRoleSubscriptionLockedChannel == channelListItemStageVoiceChannel.isGuildRoleSubscriptionLockedChannel && this.isGuildRoleSubscriptionChannel == channelListItemStageVoiceChannel.isGuildRoleSubscriptionChannel;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListVocalItem
    public Channel getChannel() {
        return this.channel;
    }

    public final boolean getHasActiveEvent() {
        return this.stageInstance != null;
    }

    public final boolean getHasSpeakers() {
        return this.hasSpeakers;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListVocalItem
    public int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    public final Long getPermission() {
        return this.permission;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = getChannel();
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.selected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        Long l = this.permission;
        int iHashCode2 = (i2 + (l != null ? l.hashCode() : 0)) * 31;
        boolean z3 = this.isLocked;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int numUsersConnected = (getNumUsersConnected() + ((iHashCode2 + i3) * 31)) * 31;
        StageInstance stageInstance = this.stageInstance;
        int iHashCode3 = (numUsersConnected + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
        boolean z4 = this.hasSpeakers;
        int i4 = z4;
        if (z4 != 0) {
            i4 = 1;
        }
        int i5 = (iHashCode3 + i4) * 31;
        boolean z5 = this.isGuildRoleSubscriptionLockedChannel;
        int i6 = z5;
        if (z5 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        boolean z6 = this.isGuildRoleSubscriptionChannel;
        return i7 + (z6 ? 1 : z6 ? 1 : 0);
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

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemStageVoiceChannel(channel=");
        sbU.append(getChannel());
        sbU.append(", selected=");
        sbU.append(this.selected);
        sbU.append(", permission=");
        sbU.append(this.permission);
        sbU.append(", isLocked=");
        sbU.append(this.isLocked);
        sbU.append(", numUsersConnected=");
        sbU.append(getNumUsersConnected());
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(", hasSpeakers=");
        sbU.append(this.hasSpeakers);
        sbU.append(", isGuildRoleSubscriptionLockedChannel=");
        sbU.append(this.isGuildRoleSubscriptionLockedChannel);
        sbU.append(", isGuildRoleSubscriptionChannel=");
        return outline.O(sbU, this.isGuildRoleSubscriptionChannel, ")");
    }
}
