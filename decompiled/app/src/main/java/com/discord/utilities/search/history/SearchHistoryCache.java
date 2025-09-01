package com.discord.utilities.search.history;

import com.discord.stores.StoreSearch;
import com.discord.utilities.search.query.node.QueryNode;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: SearchHistoryCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/discord/utilities/search/history/SearchHistoryCache;", "", "Lcom/discord/stores/StoreSearch$SearchTarget;", "searchTarget", "Lrx/Observable;", "", "", "Lcom/discord/utilities/search/query/node/QueryNode;", "getHistory", "(Lcom/discord/stores/StoreSearch$SearchTarget;)Lrx/Observable;", "query", "", "persistQuery", "(Lcom/discord/stores/StoreSearch$SearchTarget;Ljava/util/List;)V", "clear", "(Lcom/discord/stores/StoreSearch$SearchTarget;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface SearchHistoryCache {
    void clear(StoreSearch.SearchTarget searchTarget);

    Observable<Collection<List<QueryNode>>> getHistory(StoreSearch.SearchTarget searchTarget);

    void persistQuery(StoreSearch.SearchTarget searchTarget, List<? extends QueryNode> query);
}
