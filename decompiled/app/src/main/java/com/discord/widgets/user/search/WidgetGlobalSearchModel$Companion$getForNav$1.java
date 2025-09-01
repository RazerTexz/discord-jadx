package com.discord.widgets.user.search;

import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;", "it", "", "Lcom/discord/primitives/ChannelId;", "invoke", "(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;)J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getForNav$1 extends Lambda implements Function1<WidgetGlobalSearchModel.SearchContext, Long> {
    public static final WidgetGlobalSearchModel$Companion$getForNav$1 INSTANCE = new WidgetGlobalSearchModel$Companion$getForNav$1();

    public WidgetGlobalSearchModel$Companion$getForNav$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(WidgetGlobalSearchModel.SearchContext searchContext) {
        return Long.valueOf(invoke2(searchContext));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(WidgetGlobalSearchModel.SearchContext searchContext) {
        Intrinsics3.checkNotNullParameter(searchContext, "it");
        return searchContext.getPrevSelectedChannelId();
    }
}
