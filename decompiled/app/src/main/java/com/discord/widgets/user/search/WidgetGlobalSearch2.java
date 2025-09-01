package com.discord.widgets.user.search;

import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGlobalSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "Lcom/discord/widgets/user/search/WidgetGlobalSearchModel$ItemDataPayload;", "<anonymous parameter 0>", "<anonymous parameter 1>", "", "invoke", "(Ljava/util/List;Ljava/util/List;)V", "com/discord/widgets/user/search/WidgetGlobalSearch$configureUI$3$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$configureUI$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGlobalSearch2 extends Lambda implements Function2<List<? extends WidgetGlobalSearchModel.ItemDataPayload>, List<? extends WidgetGlobalSearchModel.ItemDataPayload>, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel $model$inlined;
    public final /* synthetic */ WidgetGlobalSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearch2(WidgetGlobalSearch widgetGlobalSearch, WidgetGlobalSearchModel widgetGlobalSearchModel) {
        super(2);
        this.this$0 = widgetGlobalSearch;
        this.$model$inlined = widgetGlobalSearchModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetGlobalSearchModel.ItemDataPayload> list, List<? extends WidgetGlobalSearchModel.ItemDataPayload> list2) {
        invoke2(list, list2);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends WidgetGlobalSearchModel.ItemDataPayload> list, List<? extends WidgetGlobalSearchModel.ItemDataPayload> list2) {
        Intrinsics3.checkNotNullParameter(list, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(list2, "<anonymous parameter 1>");
        if (!Intrinsics3.areEqual(WidgetGlobalSearch.access$getFilterString$p(this.this$0), this.$model$inlined.getFilter())) {
            WidgetGlobalSearch.access$getBinding$p(this.this$0).g.scrollToPosition(0);
            WidgetGlobalSearch.access$setFilterString$p(this.this$0, this.$model$inlined.getFilter());
        }
    }
}
