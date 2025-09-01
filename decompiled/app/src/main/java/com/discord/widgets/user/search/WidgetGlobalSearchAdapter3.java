package com.discord.widgets.user.search;

import android.view.View;
import com.discord.widgets.user.search.WidgetGlobalSearchAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchAdapter$HeaderViewHolder$onConfigure$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter3 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchAdapter.HeaderViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchAdapter3(WidgetGlobalSearchAdapter.HeaderViewHolder headerViewHolder, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        super(1);
        this.this$0 = headerViewHolder;
        this.$position = i;
        this.$data = itemDataPayload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        WidgetGlobalSearchAdapter.HeaderViewHolder.access$getAdapter$p(this.this$0).getOnSelectedListener().invoke(view, Integer.valueOf(this.$position), this.$data, Boolean.TRUE);
    }
}
