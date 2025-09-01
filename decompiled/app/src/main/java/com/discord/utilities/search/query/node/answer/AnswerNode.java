package com.discord.utilities.search.query.node.answer;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.validation.SearchData;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: AnswerNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/discord/utilities/search/query/node/answer/AnswerNode;", "Lcom/discord/utilities/search/query/node/QueryNode;", "Landroid/text/SpannableStringBuilder;", "builder", "Landroid/content/Context;", "renderContext", "", "render", "(Landroid/text/SpannableStringBuilder;Landroid/content/Context;)V", "Lcom/discord/utilities/search/validation/SearchData;", "searchData", "", "isValid", "(Lcom/discord/utilities/search/validation/SearchData;)Z", "Lcom/discord/utilities/search/network/SearchQuery$Builder;", "queryBuilder", "Lcom/discord/utilities/search/query/FilterType;", "filterType", "updateQuery", "(Lcom/discord/utilities/search/network/SearchQuery$Builder;Lcom/discord/utilities/search/validation/SearchData;Lcom/discord/utilities/search/query/FilterType;)V", "", "getValidFilters", "()Ljava/util/Set;", "validFilters", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class AnswerNode extends QueryNode {
    public abstract Set<FilterType> getValidFilters();

    public abstract boolean isValid(SearchData searchData);

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Context context) {
        render2(spannableStringBuilder, context);
    }

    public abstract void updateQuery(SearchQuery.Builder queryBuilder, SearchData searchData, FilterType filterType);

    /* renamed from: render, reason: avoid collision after fix types in other method */
    public void render2(SpannableStringBuilder builder, Context renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        builder.append(getText()).append(' ');
    }
}
