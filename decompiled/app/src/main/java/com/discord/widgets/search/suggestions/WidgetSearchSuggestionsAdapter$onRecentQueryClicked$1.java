package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.query.node.QueryNode;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSearchSuggestionsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/utilities/search/query/node/QueryNode;", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1 extends Lambda implements Function1<List<? extends QueryNode>, Unit> {
    public static final WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1 INSTANCE = new WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1();

    public WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends QueryNode> list) {
        invoke2(list);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends QueryNode> list) {
        Intrinsics3.checkNotNullParameter(list, "it");
    }
}
