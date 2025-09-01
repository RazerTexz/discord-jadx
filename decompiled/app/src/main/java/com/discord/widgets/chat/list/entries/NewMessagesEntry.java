package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: NewMessagesEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J(\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u000e8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u001c\u0010\u001b\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\rR\u001d\u0010\u0007\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001e\u0010\u0005¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/list/entries/NewMessagesEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "component2", "channelId", "messageId", "copy", "(JJ)Lcom/discord/widgets/chat/list/entries/NewMessagesEntry;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "J", "getMessageId", "key", "Ljava/lang/String;", "getKey", "getChannelId", "<init>", "(JJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class NewMessagesEntry extends ChatListEntry {
    private final long channelId;
    private final String key;
    private final long messageId;
    private final int type = 8;

    public NewMessagesEntry(long j, long j2) {
        this.channelId = j;
        this.messageId = j2;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    public static /* synthetic */ NewMessagesEntry copy$default(NewMessagesEntry newMessagesEntry, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = newMessagesEntry.channelId;
        }
        if ((i & 2) != 0) {
            j2 = newMessagesEntry.messageId;
        }
        return newMessagesEntry.copy(j, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    public final NewMessagesEntry copy(long channelId, long messageId) {
        return new NewMessagesEntry(channelId, messageId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewMessagesEntry)) {
            return false;
        }
        NewMessagesEntry newMessagesEntry = (NewMessagesEntry) other;
        return this.channelId == newMessagesEntry.channelId && this.messageId == newMessagesEntry.messageId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return b.a(this.messageId) + (b.a(this.channelId) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("NewMessagesEntry(channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageId=");
        return outline.C(sbU, this.messageId, ")");
    }
}
