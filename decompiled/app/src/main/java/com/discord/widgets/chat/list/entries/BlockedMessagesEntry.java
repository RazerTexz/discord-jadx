package com.discord.widgets.chat.list.entries;

import b.d.b.a.outline;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: BlockedMessagesEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ.\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000bJ\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0013R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u0019\u0010\r\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u001c\u0010 \u001a\u00020\t8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\"¨\u0006%"}, d2 = {"Lcom/discord/widgets/chat/list/entries/BlockedMessagesEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "component3", "()Z", "isInExpandedBlockedMessageChunk", "Lcom/discord/models/message/Message;", "component1", "()Lcom/discord/models/message/Message;", "", "component2", "()I", "message", "blockedCount", "isExpandedBlock", "copy", "(Lcom/discord/models/message/Message;IZ)Lcom/discord/widgets/chat/list/entries/BlockedMessagesEntry;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/models/message/Message;", "getMessage", "I", "getBlockedCount", "type", "getType", "Z", "<init>", "(Lcom/discord/models/message/Message;IZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class BlockedMessagesEntry extends ChatListEntry {
    private final int blockedCount;
    private final boolean isExpandedBlock;
    private final String key;
    private final Message message;
    private final int type;

    public BlockedMessagesEntry(Message message, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(message, "message");
        this.message = message;
        this.blockedCount = i;
        this.isExpandedBlock = z2;
        this.type = 10;
        this.key = String.valueOf(getType());
    }

    /* renamed from: component3, reason: from getter */
    private final boolean getIsExpandedBlock() {
        return this.isExpandedBlock;
    }

    public static /* synthetic */ BlockedMessagesEntry copy$default(BlockedMessagesEntry blockedMessagesEntry, Message message, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            message = blockedMessagesEntry.message;
        }
        if ((i2 & 2) != 0) {
            i = blockedMessagesEntry.blockedCount;
        }
        if ((i2 & 4) != 0) {
            z2 = blockedMessagesEntry.isExpandedBlock;
        }
        return blockedMessagesEntry.copy(message, i, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final Message getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final int getBlockedCount() {
        return this.blockedCount;
    }

    public final BlockedMessagesEntry copy(Message message, int blockedCount, boolean isExpandedBlock) {
        Intrinsics3.checkNotNullParameter(message, "message");
        return new BlockedMessagesEntry(message, blockedCount, isExpandedBlock);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlockedMessagesEntry)) {
            return false;
        }
        BlockedMessagesEntry blockedMessagesEntry = (BlockedMessagesEntry) other;
        return Intrinsics3.areEqual(this.message, blockedMessagesEntry.message) && this.blockedCount == blockedMessagesEntry.blockedCount && this.isExpandedBlock == blockedMessagesEntry.isExpandedBlock;
    }

    public final int getBlockedCount() {
        return this.blockedCount;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Message getMessage() {
        return this.message;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Message message = this.message;
        int iHashCode = (((message != null ? message.hashCode() : 0) * 31) + this.blockedCount) * 31;
        boolean z2 = this.isExpandedBlock;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    @Override // com.discord.widgets.chat.list.entries.ChatListEntry
    public boolean isInExpandedBlockedMessageChunk() {
        return this.isExpandedBlock;
    }

    public String toString() {
        StringBuilder sbU = outline.U("BlockedMessagesEntry(message=");
        sbU.append(this.message);
        sbU.append(", blockedCount=");
        sbU.append(this.blockedCount);
        sbU.append(", isExpandedBlock=");
        return outline.O(sbU, this.isExpandedBlock, ")");
    }
}
