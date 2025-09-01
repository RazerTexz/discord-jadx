package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelListItemVoiceChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0081\u0001\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0007\u0012\u0006\u0010!\u001a\u00020\u0007\u0012\u000e\u0010\"\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u0012\u0006\u0010#\u001a\u00020\u000f\u0012\u0006\u0010$\u001a\u00020\u0007\u0012\u0006\u0010%\u001a\u00020\u000f\u0012\u0006\u0010&\u001a\u00020\u0007\u0012\u0006\u0010'\u001a\u00020\u0007\u0012\u0006\u0010(\u001a\u00020\u0007\u0012\u0006\u0010)\u001a\u00020\u0017\u0012\u0006\u0010*\u001a\u00020\u0007\u0012\u0006\u0010+\u001a\u00020\u0007\u0012\b\u0010,\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\bJ\u0010KJ\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0018\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0012\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0014\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0015\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0016\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\tJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ¦\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u00072\u0010\b\u0002\u0010\"\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020\u00072\b\b\u0002\u0010(\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001cHÆ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u00100\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b2\u0010\u0011J\u001a\u00105\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b5\u00106R\u0019\u0010*\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b*\u00107\u001a\u0004\b*\u0010\tR\u0019\u0010&\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b&\u00107\u001a\u0004\b&\u0010\tR\u0019\u0010(\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b(\u00107\u001a\u0004\b(\u0010\tR\u001c\u0010$\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u00107\u001a\u0004\b$\u0010\tR\u0019\u0010'\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b'\u00107\u001a\u0004\b'\u0010\tR\u001c\u0010%\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u00108\u001a\u0004\b9\u0010\u0011R\u0019\u0010+\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b+\u00107\u001a\u0004\b+\u0010\tR\u001b\u0010,\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010:\u001a\u0004\b;\u0010\u001eR\u001c\u0010\u001f\u001a\u00020\u00048\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010<\u001a\u0004\b=\u0010\u0006R\u0019\u0010)\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010>\u001a\u0004\b?\u0010\u0019R\u001c\u0010@\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b@\u00108\u001a\u0004\bA\u0010\u0011R\u0019\u0010!\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\bB\u0010\tR\u001c\u0010C\u001a\u00020/8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u00101R\u001c\u0010#\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u00108\u001a\u0004\bF\u0010\u0011R\u0019\u0010 \u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b \u00107\u001a\u0004\bG\u0010\tR!\u0010\"\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010H\u001a\u0004\bI\u0010\u000e¨\u0006L"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemVoiceChannel;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "Lcom/discord/widgets/channels/list/items/ChannelListVocalItem;", "Lcom/discord/widgets/channels/list/WidgetChannelListUnreads$UnreadItem;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "component3", "", "Lcom/discord/api/permission/PermissionBit;", "component4", "()Ljava/lang/Long;", "", "component5", "()I", "component6", "component7", "component8", "component9", "component10", "Lcom/discord/api/guild/GuildMaxVideoChannelUsers;", "component11", "()Lcom/discord/api/guild/GuildMaxVideoChannelUsers;", "component12", "component13", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component14", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "channel", "textSelected", "voiceSelected", "permission", "mentionCount", "isUnread", "numUsersConnected", "isLocked", "isNsfw", "isAnyoneUsingVideo", "guildMaxVideoChannelUsers", "isGuildRoleSubscriptionLockedChannel", "isGuildRoleSubscriptionChannel", "guildScheduledEvent", "copy", "(Lcom/discord/api/channel/Channel;ZZLjava/lang/Long;IZIZZZLcom/discord/api/guild/GuildMaxVideoChannelUsers;ZZLcom/discord/api/guildscheduledevent/GuildScheduledEvent;)Lcom/discord/widgets/channels/list/items/ChannelListItemVoiceChannel;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "I", "getNumUsersConnected", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getGuildScheduledEvent", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/api/guild/GuildMaxVideoChannelUsers;", "getGuildMaxVideoChannelUsers", "type", "getType", "getVoiceSelected", "key", "Ljava/lang/String;", "getKey", "getMentionCount", "getTextSelected", "Ljava/lang/Long;", "getPermission", "<init>", "(Lcom/discord/api/channel/Channel;ZZLjava/lang/Long;IZIZZZLcom/discord/api/guild/GuildMaxVideoChannelUsers;ZZLcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemVoiceChannel implements ChannelListItem, ChannelListVocalItem, WidgetChannelListUnreads.UnreadItem {
    private final Channel channel;
    private final GuildMaxVideoChannelUsers guildMaxVideoChannelUsers;
    private final GuildScheduledEvent guildScheduledEvent;
    private final boolean isAnyoneUsingVideo;
    private final boolean isGuildRoleSubscriptionChannel;
    private final boolean isGuildRoleSubscriptionLockedChannel;
    private final boolean isLocked;
    private final boolean isNsfw;
    private final boolean isUnread;
    private final String key;
    private final int mentionCount;
    private final int numUsersConnected;
    private final Long permission;
    private final boolean textSelected;
    private final int type;
    private final boolean voiceSelected;

    public ChannelListItemVoiceChannel(Channel channel, boolean z2, boolean z3, Long l, int i, boolean z4, int i2, boolean z5, boolean z6, boolean z7, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, boolean z8, boolean z9, GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(guildMaxVideoChannelUsers, "guildMaxVideoChannelUsers");
        this.channel = channel;
        this.textSelected = z2;
        this.voiceSelected = z3;
        this.permission = l;
        this.mentionCount = i;
        this.isUnread = z4;
        this.numUsersConnected = i2;
        this.isLocked = z5;
        this.isNsfw = z6;
        this.isAnyoneUsingVideo = z7;
        this.guildMaxVideoChannelUsers = guildMaxVideoChannelUsers;
        this.isGuildRoleSubscriptionLockedChannel = z8;
        this.isGuildRoleSubscriptionChannel = z9;
        this.guildScheduledEvent = guildScheduledEvent;
        this.type = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(getChannel().getId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemVoiceChannel copy$default(ChannelListItemVoiceChannel channelListItemVoiceChannel, Channel channel, boolean z2, boolean z3, Long l, int i, boolean z4, int i2, boolean z5, boolean z6, boolean z7, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, boolean z8, boolean z9, GuildScheduledEvent guildScheduledEvent, int i3, Object obj) {
        return channelListItemVoiceChannel.copy((i3 & 1) != 0 ? channelListItemVoiceChannel.getChannel() : channel, (i3 & 2) != 0 ? channelListItemVoiceChannel.textSelected : z2, (i3 & 4) != 0 ? channelListItemVoiceChannel.voiceSelected : z3, (i3 & 8) != 0 ? channelListItemVoiceChannel.permission : l, (i3 & 16) != 0 ? channelListItemVoiceChannel.getMentionCount() : i, (i3 & 32) != 0 ? channelListItemVoiceChannel.getIsUnread() : z4, (i3 & 64) != 0 ? channelListItemVoiceChannel.getNumUsersConnected() : i2, (i3 & 128) != 0 ? channelListItemVoiceChannel.isLocked : z5, (i3 & 256) != 0 ? channelListItemVoiceChannel.isNsfw : z6, (i3 & 512) != 0 ? channelListItemVoiceChannel.isAnyoneUsingVideo : z7, (i3 & 1024) != 0 ? channelListItemVoiceChannel.guildMaxVideoChannelUsers : guildMaxVideoChannelUsers, (i3 & 2048) != 0 ? channelListItemVoiceChannel.isGuildRoleSubscriptionLockedChannel : z8, (i3 & 4096) != 0 ? channelListItemVoiceChannel.isGuildRoleSubscriptionChannel : z9, (i3 & 8192) != 0 ? channelListItemVoiceChannel.guildScheduledEvent : guildScheduledEvent);
    }

    public final Channel component1() {
        return getChannel();
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsAnyoneUsingVideo() {
        return this.isAnyoneUsingVideo;
    }

    /* renamed from: component11, reason: from getter */
    public final GuildMaxVideoChannelUsers getGuildMaxVideoChannelUsers() {
        return this.guildMaxVideoChannelUsers;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionLockedChannel() {
        return this.isGuildRoleSubscriptionLockedChannel;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsGuildRoleSubscriptionChannel() {
        return this.isGuildRoleSubscriptionChannel;
    }

    /* renamed from: component14, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getTextSelected() {
        return this.textSelected;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getVoiceSelected() {
        return this.voiceSelected;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getPermission() {
        return this.permission;
    }

    public final int component5() {
        return getMentionCount();
    }

    public final boolean component6() {
        return getIsUnread();
    }

    public final int component7() {
        return getNumUsersConnected();
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsNsfw() {
        return this.isNsfw;
    }

    public final ChannelListItemVoiceChannel copy(Channel channel, boolean textSelected, boolean voiceSelected, Long permission, int mentionCount, boolean isUnread, int numUsersConnected, boolean isLocked, boolean isNsfw, boolean isAnyoneUsingVideo, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, boolean isGuildRoleSubscriptionLockedChannel, boolean isGuildRoleSubscriptionChannel, GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(guildMaxVideoChannelUsers, "guildMaxVideoChannelUsers");
        return new ChannelListItemVoiceChannel(channel, textSelected, voiceSelected, permission, mentionCount, isUnread, numUsersConnected, isLocked, isNsfw, isAnyoneUsingVideo, guildMaxVideoChannelUsers, isGuildRoleSubscriptionLockedChannel, isGuildRoleSubscriptionChannel, guildScheduledEvent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemVoiceChannel)) {
            return false;
        }
        ChannelListItemVoiceChannel channelListItemVoiceChannel = (ChannelListItemVoiceChannel) other;
        return Intrinsics3.areEqual(getChannel(), channelListItemVoiceChannel.getChannel()) && this.textSelected == channelListItemVoiceChannel.textSelected && this.voiceSelected == channelListItemVoiceChannel.voiceSelected && Intrinsics3.areEqual(this.permission, channelListItemVoiceChannel.permission) && getMentionCount() == channelListItemVoiceChannel.getMentionCount() && getIsUnread() == channelListItemVoiceChannel.getIsUnread() && getNumUsersConnected() == channelListItemVoiceChannel.getNumUsersConnected() && this.isLocked == channelListItemVoiceChannel.isLocked && this.isNsfw == channelListItemVoiceChannel.isNsfw && this.isAnyoneUsingVideo == channelListItemVoiceChannel.isAnyoneUsingVideo && Intrinsics3.areEqual(this.guildMaxVideoChannelUsers, channelListItemVoiceChannel.guildMaxVideoChannelUsers) && this.isGuildRoleSubscriptionLockedChannel == channelListItemVoiceChannel.isGuildRoleSubscriptionLockedChannel && this.isGuildRoleSubscriptionChannel == channelListItemVoiceChannel.isGuildRoleSubscriptionChannel && Intrinsics3.areEqual(this.guildScheduledEvent, channelListItemVoiceChannel.guildScheduledEvent);
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListVocalItem
    public Channel getChannel() {
        return this.channel;
    }

    public final GuildMaxVideoChannelUsers getGuildMaxVideoChannelUsers() {
        return this.guildMaxVideoChannelUsers;
    }

    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
    public int getMentionCount() {
        return this.mentionCount;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListVocalItem
    public int getNumUsersConnected() {
        return this.numUsersConnected;
    }

    public final Long getPermission() {
        return this.permission;
    }

    public final boolean getTextSelected() {
        return this.textSelected;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final boolean getVoiceSelected() {
        return this.voiceSelected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = getChannel();
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.textSelected;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z3 = this.voiceSelected;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        Long l = this.permission;
        int mentionCount = (getMentionCount() + ((i4 + (l != null ? l.hashCode() : 0)) * 31)) * 31;
        boolean isUnread = getIsUnread();
        int i5 = isUnread;
        if (isUnread) {
            i5 = 1;
        }
        int numUsersConnected = (getNumUsersConnected() + ((mentionCount + i5) * 31)) * 31;
        boolean z4 = this.isLocked;
        int i6 = z4;
        if (z4 != 0) {
            i6 = 1;
        }
        int i7 = (numUsersConnected + i6) * 31;
        boolean z5 = this.isNsfw;
        int i8 = z5;
        if (z5 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        boolean z6 = this.isAnyoneUsingVideo;
        int i10 = z6;
        if (z6 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers = this.guildMaxVideoChannelUsers;
        int iHashCode2 = (i11 + (guildMaxVideoChannelUsers != null ? guildMaxVideoChannelUsers.hashCode() : 0)) * 31;
        boolean z7 = this.isGuildRoleSubscriptionLockedChannel;
        int i12 = z7;
        if (z7 != 0) {
            i12 = 1;
        }
        int i13 = (iHashCode2 + i12) * 31;
        boolean z8 = this.isGuildRoleSubscriptionChannel;
        int i14 = (i13 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        return i14 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public final boolean isAnyoneUsingVideo() {
        return this.isAnyoneUsingVideo;
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

    public final boolean isNsfw() {
        return this.isNsfw;
    }

    @Override // com.discord.widgets.channels.list.WidgetChannelListUnreads.UnreadItem
    /* renamed from: isUnread, reason: from getter */
    public boolean getIsUnread() {
        return this.isUnread;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemVoiceChannel(channel=");
        sbU.append(getChannel());
        sbU.append(", textSelected=");
        sbU.append(this.textSelected);
        sbU.append(", voiceSelected=");
        sbU.append(this.voiceSelected);
        sbU.append(", permission=");
        sbU.append(this.permission);
        sbU.append(", mentionCount=");
        sbU.append(getMentionCount());
        sbU.append(", isUnread=");
        sbU.append(getIsUnread());
        sbU.append(", numUsersConnected=");
        sbU.append(getNumUsersConnected());
        sbU.append(", isLocked=");
        sbU.append(this.isLocked);
        sbU.append(", isNsfw=");
        sbU.append(this.isNsfw);
        sbU.append(", isAnyoneUsingVideo=");
        sbU.append(this.isAnyoneUsingVideo);
        sbU.append(", guildMaxVideoChannelUsers=");
        sbU.append(this.guildMaxVideoChannelUsers);
        sbU.append(", isGuildRoleSubscriptionLockedChannel=");
        sbU.append(this.isGuildRoleSubscriptionLockedChannel);
        sbU.append(", isGuildRoleSubscriptionChannel=");
        sbU.append(this.isGuildRoleSubscriptionChannel);
        sbU.append(", guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(")");
        return sbU.toString();
    }
}
