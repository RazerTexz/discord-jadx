package com.discord.utilities.search.network;

import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.AnswerNode;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import com.discord.utilities.search.validation.SearchData;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: SearchQuery.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0011B)\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u0002\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010R+\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\n\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/discord/utilities/search/network/SearchQuery;", "", "", "", "", "params", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "", "isValid", "()Z", "includeNsfw", "Z", "getIncludeNsfw", "<init>", "(Ljava/util/Map;Z)V", "Builder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SearchQuery {
    private final boolean includeNsfw;
    private final Map<String, List<String>> params;

    /* compiled from: SearchQuery.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0011\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00060\u0018j\u0002`\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001cR>\u0010 \u001a*\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001dj\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e`\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/discord/utilities/search/network/SearchQuery$Builder;", "", "", "content", "", "appendContent", "(Ljava/lang/CharSequence;)V", "", "includeNsfw", "setIncludeNsfw", "(Z)Lcom/discord/utilities/search/network/SearchQuery$Builder;", "", "Lcom/discord/utilities/search/query/node/QueryNode;", "queryNodes", "Lcom/discord/utilities/search/validation/SearchData;", "searchData", "Lcom/discord/utilities/search/network/SearchQuery;", "buildFrom", "(Ljava/util/List;Lcom/discord/utilities/search/validation/SearchData;)Lcom/discord/utilities/search/network/SearchQuery;", "", "paramKey", "param", "appendParam", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "contentBuilder", "Ljava/lang/StringBuilder;", "Z", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "paramsMap", "Ljava/util/HashMap;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Builder {
        private boolean includeNsfw;
        private final StringBuilder contentBuilder = new StringBuilder();
        private final HashMap<String, List<String>> paramsMap = new HashMap<>();

        private final void appendContent(CharSequence content) {
            StringBuilder sb = this.contentBuilder;
            sb.append(content);
            sb.append(' ');
        }

        public final void appendParam(String paramKey, String param) {
            Intrinsics3.checkNotNullParameter(paramKey, "paramKey");
            Intrinsics3.checkNotNullParameter(param, "param");
            List<String> arrayList = this.paramsMap.get(paramKey);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(param);
            this.paramsMap.put(paramKey, arrayList);
        }

        public final SearchQuery buildFrom(List<? extends QueryNode> queryNodes, SearchData searchData) {
            Intrinsics3.checkNotNullParameter(queryNodes, "queryNodes");
            Intrinsics3.checkNotNullParameter(searchData, "searchData");
            loop0: while (true) {
                FilterType filterType = null;
                for (QueryNode queryNode : queryNodes) {
                    if (queryNode instanceof FilterNode) {
                        filterType = ((FilterNode) queryNode).getFilterType();
                    } else if (queryNode instanceof AnswerNode) {
                        AnswerNode answerNode = (AnswerNode) queryNode;
                        if (_Collections.contains(answerNode.getValidFilters(), filterType)) {
                            answerNode.updateQuery(this, searchData, filterType);
                        } else {
                            appendContent(queryNode.getText());
                        }
                    } else if (queryNode instanceof ContentNode) {
                        appendContent(((ContentNode) queryNode).getText());
                    }
                }
                break loop0;
            }
            String string = this.contentBuilder.toString();
            Intrinsics3.checkNotNullExpressionValue(string, "contentBuilder.toString()");
            Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
            String string2 = Strings4.trim(string).toString();
            if (string2.length() > 0) {
                this.paramsMap.put("content", Collections2.mutableListOf(string2));
            }
            return new SearchQuery(this.paramsMap, this.includeNsfw);
        }

        public final Builder setIncludeNsfw(boolean includeNsfw) {
            this.includeNsfw = includeNsfw;
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchQuery(Map<String, ? extends List<String>> map, boolean z2) {
        Intrinsics3.checkNotNullParameter(map, "params");
        this.params = map;
        this.includeNsfw = z2;
    }

    public final boolean getIncludeNsfw() {
        return this.includeNsfw;
    }

    public final Map<String, List<String>> getParams() {
        return this.params;
    }

    public final boolean isValid() {
        return !this.params.isEmpty();
    }
}
