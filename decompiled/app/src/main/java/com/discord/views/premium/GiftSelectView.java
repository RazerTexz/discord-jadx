package com.discord.views.premium;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.discord.R;
import com.discord.databinding.WidgetChoosePlanAdapterPlanItemBinding;
import com.discord.utilities.billing.GooglePlayInAppSku;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GiftSelectView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/discord/views/premium/GiftSelectView;", "Landroid/widget/FrameLayout;", "Lcom/discord/utilities/billing/GooglePlayInAppSku;", "l", "Lcom/discord/utilities/billing/GooglePlayInAppSku;", "inAppSku", "Lkotlin/Function1;", "", "k", "Lkotlin/jvm/functions/Function1;", "onClickPlan", "Lcom/discord/databinding/WidgetChoosePlanAdapterPlanItemBinding;", "j", "Lcom/discord/databinding/WidgetChoosePlanAdapterPlanItemBinding;", "binding", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GiftSelectView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final WidgetChoosePlanAdapterPlanItemBinding binding;

    /* renamed from: k, reason: from kotlin metadata */
    public Function1<? super GooglePlayInAppSku, Unit> onClickPlan;

    /* renamed from: l, reason: from kotlin metadata */
    public GooglePlayInAppSku inAppSku;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.widget_choose_plan_adapter_plan_item, (ViewGroup) this, false);
        addView(viewInflate);
        WidgetChoosePlanAdapterPlanItemBinding widgetChoosePlanAdapterPlanItemBindingA = WidgetChoosePlanAdapterPlanItemBinding.a(viewInflate);
        Intrinsics3.checkNotNullExpressionValue(widgetChoosePlanAdapterPlanItemBindingA, "WidgetChoosePlanAdapterP…rom(context), this, true)");
        this.binding = widgetChoosePlanAdapterPlanItemBindingA;
    }
}
