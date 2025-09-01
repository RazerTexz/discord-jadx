package com.discord.widgets.settings.premium;

import android.view.View;
import com.discord.widgets.settings.premium.WidgetChoosePlanAdapter;
import kotlin.Metadata;

/* compiled from: WidgetChoosePlanAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.WidgetChoosePlanAdapter$PlanViewHeader$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter2 implements View.OnClickListener {
    public final /* synthetic */ WidgetChoosePlanAdapter.Item $data;
    public final /* synthetic */ WidgetChoosePlanAdapter.PlanViewHeader this$0;

    public WidgetChoosePlanAdapter2(WidgetChoosePlanAdapter.PlanViewHeader planViewHeader, WidgetChoosePlanAdapter.Item item) {
        this.this$0 = planViewHeader;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChoosePlanAdapter.access$getOnClickPlan$p(WidgetChoosePlanAdapter.PlanViewHeader.access$getAdapter$p(this.this$0)).invoke(((WidgetChoosePlanAdapter.Item.Plan) this.$data).getPurchaseSku(), ((WidgetChoosePlanAdapter.Item.Plan) this.$data).getOldSkuName(), ((WidgetChoosePlanAdapter.Item.Plan) this.$data).getUpgradeSkuDetails());
    }
}
