package com.discord.widgets.user.search;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import rx.functions.Func2;

/* compiled from: WidgetGlobalSearchModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "filterStr", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;", "partialSearchContext", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;)Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$SearchContext;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$get$searchContextObservable$1<T1, T2, R> implements Func2<String, WidgetGlobalSearchModel.SearchContext, WidgetGlobalSearchModel.SearchContext> {
    public static final WidgetGlobalSearchModel$Companion$get$searchContextObservable$1 INSTANCE = new WidgetGlobalSearchModel$Companion$get$searchContextObservable$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.SearchContext call(String str, WidgetGlobalSearchModel.SearchContext searchContext) {
        return call2(str, searchContext);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.SearchContext call2(String str, WidgetGlobalSearchModel.SearchContext searchContext) {
        Intrinsics3.checkNotNullExpressionValue(str, "filterStr");
        return WidgetGlobalSearchModel.SearchContext.copy$default(searchContext, str, null, 0L, 0L, 0L, null, null, 126, null);
    }
}
