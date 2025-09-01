package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: SpacerEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÂ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/chat/list/entries/SpacerEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "channelId", "copy", "(J)Lcom/discord/widgets/chat/list/entries/SpacerEntry;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class SpacerEntry extends ChatListEntry {
    private final long channelId;
    private final String key;
    private final int type = 7;

    public SpacerEntry(long j) {
        this.channelId = j;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    /* renamed from: component1, reason: from getter */
    private final long getChannelId() {
        return this.channelId;
    }

    public static /* synthetic */ SpacerEntry copy$default(SpacerEntry spacerEntry, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = spacerEntry.channelId;
        }
        return spacerEntry.copy(j);
    }

    public final SpacerEntry copy(long channelId) {
        return new SpacerEntry(channelId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SpacerEntry) && this.channelId == ((SpacerEntry) other).channelId;
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return b.a(this.channelId);
    }

    public String toString() {
        return outline.C(outline.U("SpacerEntry(channelId="), this.channelId, ")");
    }
}
