package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelListItemVoiceUser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010JL\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001c\u0010$\u001a\u00020\u001d8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u001fR\u0019\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b\u0016\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010\u0010R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\rR\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010-\u001a\u0004\b.\u0010\nR\u001c\u0010/\u001a\u00020\u001a8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u001cR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u00102\u001a\u0004\b3\u0010\u0004¨\u00066"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemVoiceUser;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/api/voice/state/VoiceState;", "component2", "()Lcom/discord/api/voice/state/VoiceState;", "Lcom/discord/models/user/User;", "component3", "()Lcom/discord/models/user/User;", "Lcom/discord/models/member/GuildMember;", "component4", "()Lcom/discord/models/member/GuildMember;", "", "component5", "()Z", "component6", "channel", "voiceState", "user", "computed", "isApplicationStreaming", "hasChannelConnectPermission", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/voice/state/VoiceState;Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;ZZ)Lcom/discord/widgets/channels/list/items/ChannelListItemVoiceUser;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "Z", "getHasChannelConnectPermission", "Lcom/discord/api/voice/state/VoiceState;", "getVoiceState", "Lcom/discord/models/member/GuildMember;", "getComputed", "Lcom/discord/models/user/User;", "getUser", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/voice/state/VoiceState;Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemVoiceUser implements ChannelListItem {
    private final Channel channel;
    private final GuildMember computed;
    private final boolean hasChannelConnectPermission;
    private final boolean isApplicationStreaming;
    private final String key;
    private final int type;
    private final User user;
    private final VoiceState voiceState;

    public ChannelListItemVoiceUser(Channel channel, VoiceState voiceState, User user, GuildMember guildMember, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(guildMember, "computed");
        this.channel = channel;
        this.voiceState = voiceState;
        this.user = user;
        this.computed = guildMember;
        this.isApplicationStreaming = z2;
        this.hasChannelConnectPermission = z3;
        this.type = 2;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(voiceState.getChannelId());
        sb.append(voiceState.getUserId());
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemVoiceUser copy$default(ChannelListItemVoiceUser channelListItemVoiceUser, Channel channel, VoiceState voiceState, User user, GuildMember guildMember, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = channelListItemVoiceUser.channel;
        }
        if ((i & 2) != 0) {
            voiceState = channelListItemVoiceUser.voiceState;
        }
        VoiceState voiceState2 = voiceState;
        if ((i & 4) != 0) {
            user = channelListItemVoiceUser.user;
        }
        User user2 = user;
        if ((i & 8) != 0) {
            guildMember = channelListItemVoiceUser.computed;
        }
        GuildMember guildMember2 = guildMember;
        if ((i & 16) != 0) {
            z2 = channelListItemVoiceUser.isApplicationStreaming;
        }
        boolean z4 = z2;
        if ((i & 32) != 0) {
            z3 = channelListItemVoiceUser.hasChannelConnectPermission;
        }
        return channelListItemVoiceUser.copy(channel, voiceState2, user2, guildMember2, z4, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component2, reason: from getter */
    public final VoiceState getVoiceState() {
        return this.voiceState;
    }

    /* renamed from: component3, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component4, reason: from getter */
    public final GuildMember getComputed() {
        return this.computed;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getHasChannelConnectPermission() {
        return this.hasChannelConnectPermission;
    }

    public final ChannelListItemVoiceUser copy(Channel channel, VoiceState voiceState, User user, GuildMember computed, boolean isApplicationStreaming, boolean hasChannelConnectPermission) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(computed, "computed");
        return new ChannelListItemVoiceUser(channel, voiceState, user, computed, isApplicationStreaming, hasChannelConnectPermission);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemVoiceUser)) {
            return false;
        }
        ChannelListItemVoiceUser channelListItemVoiceUser = (ChannelListItemVoiceUser) other;
        return Intrinsics3.areEqual(this.channel, channelListItemVoiceUser.channel) && Intrinsics3.areEqual(this.voiceState, channelListItemVoiceUser.voiceState) && Intrinsics3.areEqual(this.user, channelListItemVoiceUser.user) && Intrinsics3.areEqual(this.computed, channelListItemVoiceUser.computed) && this.isApplicationStreaming == channelListItemVoiceUser.isApplicationStreaming && this.hasChannelConnectPermission == channelListItemVoiceUser.hasChannelConnectPermission;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final GuildMember getComputed() {
        return this.computed;
    }

    public final boolean getHasChannelConnectPermission() {
        return this.hasChannelConnectPermission;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    public final VoiceState getVoiceState() {
        return this.voiceState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        VoiceState voiceState = this.voiceState;
        int iHashCode2 = (iHashCode + (voiceState != null ? voiceState.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
        GuildMember guildMember = this.computed;
        int iHashCode4 = (iHashCode3 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        boolean z2 = this.isApplicationStreaming;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode4 + i) * 31;
        boolean z3 = this.hasChannelConnectPermission;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public final boolean isApplicationStreaming() {
        return this.isApplicationStreaming;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemVoiceUser(channel=");
        sbU.append(this.channel);
        sbU.append(", voiceState=");
        sbU.append(this.voiceState);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", computed=");
        sbU.append(this.computed);
        sbU.append(", isApplicationStreaming=");
        sbU.append(this.isApplicationStreaming);
        sbU.append(", hasChannelConnectPermission=");
        return outline.O(sbU, this.hasChannelConnectPermission, ")");
    }
}
