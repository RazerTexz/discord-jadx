package com.discord.widgets.channels.list.items;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.widgets.channels.list.items.ChannelListItem;
import kotlin.Metadata;

/* compiled from: ChannelListItemInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\n\u0010\bR\u001c\u0010\u001a\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemInvite;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "component2", "()Z", "guildId", "isHub", "copy", "(JZ)Lcom/discord/widgets/channels/list/items/ChannelListItemInvite;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getGuildId", "Z", "type", "I", "getType", "<init>", "(JZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemInvite implements ChannelListItem {
    private final long guildId;
    private final boolean isHub;
    private final int type;

    public ChannelListItemInvite(long j, boolean z2) {
        this.guildId = j;
        this.isHub = z2;
        this.type = z2 ? 20 : 9;
    }

    public static /* synthetic */ ChannelListItemInvite copy$default(ChannelListItemInvite channelListItemInvite, long j, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = channelListItemInvite.guildId;
        }
        if ((i & 2) != 0) {
            z2 = channelListItemInvite.isHub;
        }
        return channelListItemInvite.copy(j, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsHub() {
        return this.isHub;
    }

    public final ChannelListItemInvite copy(long guildId, boolean isHub) {
        return new ChannelListItemInvite(guildId, isHub);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemInvite)) {
            return false;
        }
        ChannelListItemInvite channelListItemInvite = (ChannelListItemInvite) other;
        return this.guildId == channelListItemInvite.guildId && this.isHub == channelListItemInvite.isHub;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return ChannelListItem.DefaultImpls.getKey(this);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        boolean z2 = this.isHub;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iA + i;
    }

    public final boolean isHub() {
        return this.isHub;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemInvite(guildId=");
        sbU.append(this.guildId);
        sbU.append(", isHub=");
        return outline.O(sbU, this.isHub, ")");
    }
}
