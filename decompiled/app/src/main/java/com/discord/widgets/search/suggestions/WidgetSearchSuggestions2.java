package com.discord.widgets.search.suggestions;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.SearchSuggestionEngine;
import com.discord.utilities.search.validation.SearchData;
import com.discord.widgets.search.suggestions.WidgetSearchSuggestions;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import rx.functions.Func3;

/* compiled from: WidgetSearchSuggestions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u00072\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/discord/utilities/search/validation/SearchData;", "searchData", "", "Lcom/discord/utilities/search/query/node/QueryNode;", "queryNodes", "", "history", "Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestions$Model;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/search/validation/SearchData;Ljava/util/List;Ljava/util/Collection;)Lcom/discord/widgets/search/suggestions/WidgetSearchSuggestions$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestions2<T1, T2, T3, R> implements Func3<SearchData, List<? extends QueryNode>, Collection<? extends List<? extends QueryNode>>, WidgetSearchSuggestions.Model> {
    public final /* synthetic */ SearchStringProvider $searchStringProvider;

    public WidgetSearchSuggestions2(SearchStringProvider searchStringProvider) {
        this.$searchStringProvider = searchStringProvider;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetSearchSuggestions.Model call(SearchData searchData, List<? extends QueryNode> list, Collection<? extends List<? extends QueryNode>> collection) {
        return call2(searchData, list, collection);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSearchSuggestions.Model call2(SearchData searchData, List<? extends QueryNode> list, Collection<? extends List<? extends QueryNode>> collection) {
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        Intrinsics3.checkNotNullParameter(list, "queryNodes");
        Intrinsics3.checkNotNullParameter(collection, "history");
        List<QueryNode> mutableList = _Collections.toMutableList((Collection) list);
        QueryNode.INSTANCE.preprocess(mutableList, searchData);
        return new WidgetSearchSuggestions.Model(mutableList, SearchSuggestionEngine.getSuggestions(mutableList, searchData, this.$searchStringProvider, collection));
    }
}
