package com.discord.widgets.user.search;

import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;", "it", "", "invoke", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;)J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$1 extends Lambda implements Function1<WidgetGlobalSearchModel.SearchContext, Long> {
    public static final WidgetGlobalSearchModel$Companion$create$1 INSTANCE = new WidgetGlobalSearchModel$Companion$create$1();

    public WidgetGlobalSearchModel$Companion$create$1() {
        super(1);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(WidgetGlobalSearchModel.SearchContext searchContext) {
        Intrinsics3.checkNotNullParameter(searchContext, "it");
        return 0L;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(WidgetGlobalSearchModel.SearchContext searchContext) {
        return Long.valueOf(invoke2(searchContext));
    }
}
