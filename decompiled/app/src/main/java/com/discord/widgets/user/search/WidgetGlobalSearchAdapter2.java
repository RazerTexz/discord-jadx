package com.discord.widgets.user.search;

import android.view.View;
import com.discord.widgets.user.search.WidgetGlobalSearchAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* compiled from: WidgetGlobalSearchAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchAdapter$HeaderViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter2 implements View.OnClickListener {
    public final /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchAdapter.HeaderViewHolder this$0;

    public WidgetGlobalSearchAdapter2(WidgetGlobalSearchAdapter.HeaderViewHolder headerViewHolder, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        this.this$0 = headerViewHolder;
        this.$position = i;
        this.$data = itemDataPayload;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> onSelectedListener = WidgetGlobalSearchAdapter.HeaderViewHolder.access$getAdapter$p(this.this$0).getOnSelectedListener();
        Intrinsics3.checkNotNullExpressionValue(view, "view");
        onSelectedListener.invoke(view, Integer.valueOf(this.$position), this.$data, Boolean.FALSE);
    }
}
