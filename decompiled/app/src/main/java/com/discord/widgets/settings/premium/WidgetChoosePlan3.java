package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChoosePlanBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChoosePlan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetChoosePlanBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetChoosePlanBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChoosePlan3 extends FunctionReferenceImpl implements Function1<View, WidgetChoosePlanBinding> {
    public static final WidgetChoosePlan3 INSTANCE = new WidgetChoosePlan3();

    public WidgetChoosePlan3() {
        super(1, WidgetChoosePlanBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChoosePlanBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChoosePlanBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChoosePlanBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.choose_plan_empty_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.choose_plan_empty_container);
        if (linearLayout != null) {
            i = R.id.choose_plan_empty_description;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.choose_plan_empty_description);
            if (linkifiedTextView != null) {
                i = R.id.choose_plan_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.choose_plan_recycler);
                if (recyclerView != null) {
                    i = R.id.dimmer_view;
                    DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                    if (dimmerView != null) {
                        return new WidgetChoosePlanBinding((CoordinatorLayout) view, linearLayout, linkifiedTextView, recyclerView, dimmerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
