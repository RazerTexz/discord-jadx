package com.discord.utilities.search.suggestion.entries;

import b.d.b.a.outline;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: RecentQuerySuggestion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u00020\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/discord/utilities/search/suggestion/entries/RecentQuerySuggestion;", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion;", "", "Lcom/discord/utilities/search/query/node/QueryNode;", "component1", "()Ljava/util/List;", "query", "copy", "(Ljava/util/List;)Lcom/discord/utilities/search/suggestion/entries/RecentQuerySuggestion;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "category", "Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "getCategory", "()Lcom/discord/utilities/search/suggestion/entries/SearchSuggestion$Category;", "Ljava/util/List;", "getQuery", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class RecentQuerySuggestion implements SearchSuggestion {
    private final SearchSuggestion.Category category;
    private final List<QueryNode> query;

    /* JADX WARN: Multi-variable type inference failed */
    public RecentQuerySuggestion(List<? extends QueryNode> list) {
        Intrinsics3.checkNotNullParameter(list, "query");
        this.query = list;
        this.category = SearchSuggestion.Category.RECENT_QUERY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecentQuerySuggestion copy$default(RecentQuerySuggestion recentQuerySuggestion, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = recentQuerySuggestion.query;
        }
        return recentQuerySuggestion.copy(list);
    }

    public final List<QueryNode> component1() {
        return this.query;
    }

    public final RecentQuerySuggestion copy(List<? extends QueryNode> query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        return new RecentQuerySuggestion(query);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RecentQuerySuggestion) && Intrinsics3.areEqual(this.query, ((RecentQuerySuggestion) other).query);
        }
        return true;
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion.Category getCategory() {
        return this.category;
    }

    public final List<QueryNode> getQuery() {
        return this.query;
    }

    public int hashCode() {
        List<QueryNode> list = this.query;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.L(outline.U("RecentQuerySuggestion(query="), this.query, ")");
    }
}
