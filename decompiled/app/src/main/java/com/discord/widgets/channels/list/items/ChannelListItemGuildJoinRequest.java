package com.discord.widgets.channels.list.items;

import b.d.b.a.outline;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.member.GuildMember;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ChannelListItemGuildJoinRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u000eR\u001c\u0010\u001a\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0011R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u0007¨\u0006#"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemGuildJoinRequest;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "component1", "()Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "Lcom/discord/models/member/GuildMember;", "component2", "()Lcom/discord/models/member/GuildMember;", "guildJoinRequest", "member", "copy", "(Lcom/discord/api/guildjoinrequest/GuildJoinRequest;Lcom/discord/models/member/GuildMember;)Lcom/discord/widgets/channels/list/items/ChannelListItemGuildJoinRequest;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "Lcom/discord/api/guildjoinrequest/GuildJoinRequest;", "getGuildJoinRequest", "Lcom/discord/models/member/GuildMember;", "getMember", "<init>", "(Lcom/discord/api/guildjoinrequest/GuildJoinRequest;Lcom/discord/models/member/GuildMember;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemGuildJoinRequest implements ChannelListItem {
    private final GuildJoinRequest guildJoinRequest;
    private final String key;
    private final GuildMember member;
    private final int type;

    public ChannelListItemGuildJoinRequest(GuildJoinRequest guildJoinRequest, GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(guildJoinRequest, "guildJoinRequest");
        Intrinsics3.checkNotNullParameter(guildMember, "member");
        this.guildJoinRequest = guildJoinRequest;
        this.member = guildMember;
        this.type = 22;
        this.key = String.valueOf(getType());
    }

    public static /* synthetic */ ChannelListItemGuildJoinRequest copy$default(ChannelListItemGuildJoinRequest channelListItemGuildJoinRequest, GuildJoinRequest guildJoinRequest, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            guildJoinRequest = channelListItemGuildJoinRequest.guildJoinRequest;
        }
        if ((i & 2) != 0) {
            guildMember = channelListItemGuildJoinRequest.member;
        }
        return channelListItemGuildJoinRequest.copy(guildJoinRequest, guildMember);
    }

    /* renamed from: component1, reason: from getter */
    public final GuildJoinRequest getGuildJoinRequest() {
        return this.guildJoinRequest;
    }

    /* renamed from: component2, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    public final ChannelListItemGuildJoinRequest copy(GuildJoinRequest guildJoinRequest, GuildMember member) {
        Intrinsics3.checkNotNullParameter(guildJoinRequest, "guildJoinRequest");
        Intrinsics3.checkNotNullParameter(member, "member");
        return new ChannelListItemGuildJoinRequest(guildJoinRequest, member);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemGuildJoinRequest)) {
            return false;
        }
        ChannelListItemGuildJoinRequest channelListItemGuildJoinRequest = (ChannelListItemGuildJoinRequest) other;
        return Intrinsics3.areEqual(this.guildJoinRequest, channelListItemGuildJoinRequest.guildJoinRequest) && Intrinsics3.areEqual(this.member, channelListItemGuildJoinRequest.member);
    }

    public final GuildJoinRequest getGuildJoinRequest() {
        return this.guildJoinRequest;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final GuildMember getMember() {
        return this.member;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        GuildJoinRequest guildJoinRequest = this.guildJoinRequest;
        int iHashCode = (guildJoinRequest != null ? guildJoinRequest.hashCode() : 0) * 31;
        GuildMember guildMember = this.member;
        return iHashCode + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemGuildJoinRequest(guildJoinRequest=");
        sbU.append(this.guildJoinRequest);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(")");
        return sbU.toString();
    }
}
