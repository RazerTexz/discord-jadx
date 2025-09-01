package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.query.node.answer.HasNode2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSearchSuggestionsAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "it", "", "invoke", "(Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$onHasClicked$1 extends Lambda implements Function1<HasNode2, Unit> {
    public static final WidgetSearchSuggestionsAdapter$onHasClicked$1 INSTANCE = new WidgetSearchSuggestionsAdapter$onHasClicked$1();

    public WidgetSearchSuggestionsAdapter$onHasClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HasNode2 hasNode2) {
        invoke2(hasNode2);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HasNode2 hasNode2) {
        Intrinsics3.checkNotNullParameter(hasNode2, "it");
    }
}
