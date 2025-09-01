package com.discord.widgets.chat.list.entries;

import b.d.b.a.outline;
import kotlin.Metadata;

/* compiled from: SearchResultCountEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/chat/list/entries/SearchResultCountEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "component1", "()I", "totalResults", "copy", "(I)Lcom/discord/widgets/chat/list/entries/SearchResultCountEntry;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "getTotalResults", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class SearchResultCountEntry extends ChatListEntry {
    private final int totalResults;
    private final int type = 11;
    private final String key = String.valueOf(getType());

    public SearchResultCountEntry(int i) {
        this.totalResults = i;
    }

    public static /* synthetic */ SearchResultCountEntry copy$default(SearchResultCountEntry searchResultCountEntry, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = searchResultCountEntry.totalResults;
        }
        return searchResultCountEntry.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTotalResults() {
        return this.totalResults;
    }

    public final SearchResultCountEntry copy(int totalResults) {
        return new SearchResultCountEntry(totalResults);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SearchResultCountEntry) && this.totalResults == ((SearchResultCountEntry) other).totalResults;
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final int getTotalResults() {
        return this.totalResults;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.totalResults;
    }

    public String toString() {
        return outline.B(outline.U("SearchResultCountEntry(totalResults="), this.totalResults, ")");
    }
}
