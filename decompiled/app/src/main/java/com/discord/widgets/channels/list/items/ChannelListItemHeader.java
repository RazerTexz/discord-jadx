package com.discord.widgets.channels.list.items;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.Metadata;

/* compiled from: ChannelListItemHeader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u001a\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u001c\u0010\u001f\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007R\u001c\u0010\"\u001a\u00020\u00128\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0014R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b%\u0010\u0007¨\u0006("}, d2 = {"Lcom/discord/widgets/channels/list/items/ChannelListItemHeader;", "Lcom/discord/widgets/channels/list/items/ChannelListItem;", "", "component1", "()J", "", "component2", "()I", "", "component3", "()Z", "component4", ModelAuditLogEntry.CHANGE_KEY_ID, "textResId", "ableToManageChannel", "selectedGuildId", "copy", "(JIZJ)Lcom/discord/widgets/channels/list/items/ChannelListItemHeader;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getId", "getSelectedGuildId", "Z", "getAbleToManageChannel", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "getTextResId", "<init>", "(JIZJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ChannelListItemHeader implements ChannelListItem {
    private final boolean ableToManageChannel;
    private final long id;
    private final String key;
    private final long selectedGuildId;
    private final int textResId;
    private final int type = 6;

    public ChannelListItemHeader(long j, int i, boolean z2, long j2) {
        this.id = j;
        this.textResId = i;
        this.ableToManageChannel = z2;
        this.selectedGuildId = j2;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        sb.append(i);
        this.key = sb.toString();
    }

    public static /* synthetic */ ChannelListItemHeader copy$default(ChannelListItemHeader channelListItemHeader, long j, int i, boolean z2, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = channelListItemHeader.id;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            i = channelListItemHeader.textResId;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            z2 = channelListItemHeader.ableToManageChannel;
        }
        boolean z3 = z2;
        if ((i2 & 8) != 0) {
            j2 = channelListItemHeader.selectedGuildId;
        }
        return channelListItemHeader.copy(j3, i3, z3, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTextResId() {
        return this.textResId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAbleToManageChannel() {
        return this.ableToManageChannel;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final ChannelListItemHeader copy(long id2, int textResId, boolean ableToManageChannel, long selectedGuildId) {
        return new ChannelListItemHeader(id2, textResId, ableToManageChannel, selectedGuildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemHeader)) {
            return false;
        }
        ChannelListItemHeader channelListItemHeader = (ChannelListItemHeader) other;
        return this.id == channelListItemHeader.id && this.textResId == channelListItemHeader.textResId && this.ableToManageChannel == channelListItemHeader.ableToManageChannel && this.selectedGuildId == channelListItemHeader.selectedGuildId;
    }

    public final boolean getAbleToManageChannel() {
        return this.ableToManageChannel;
    }

    public final long getId() {
        return this.id;
    }

    @Override // com.discord.widgets.channels.list.items.ChannelListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final int getTextResId() {
        return this.textResId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = ((b.a(this.id) * 31) + this.textResId) * 31;
        boolean z2 = this.ableToManageChannel;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return b.a(this.selectedGuildId) + ((iA + i) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ChannelListItemHeader(id=");
        sbU.append(this.id);
        sbU.append(", textResId=");
        sbU.append(this.textResId);
        sbU.append(", ableToManageChannel=");
        sbU.append(this.ableToManageChannel);
        sbU.append(", selectedGuildId=");
        return outline.C(sbU, this.selectedGuildId, ")");
    }
}
