package com.discord.widgets.botuikit.views.select;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetSelectComponentBottomSheetBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: SelectComponentBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSelectComponentBottomSheetBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSelectComponentBottomSheetBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class SelectComponentBottomSheet4 extends FunctionReferenceImpl implements Function1<View, WidgetSelectComponentBottomSheetBinding> {
    public static final SelectComponentBottomSheet4 INSTANCE = new SelectComponentBottomSheet4();

    public SelectComponentBottomSheet4() {
        super(1, WidgetSelectComponentBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSelectComponentBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSelectComponentBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSelectComponentBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.widget_sheet_component_bottom_sheet_header;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.widget_sheet_component_bottom_sheet_header);
        if (constraintLayout != null) {
            i = R.id.widget_sheet_component_bottom_sheet_placeholder;
            TextView textView = (TextView) view.findViewById(R.id.widget_sheet_component_bottom_sheet_placeholder);
            if (textView != null) {
                i = R.id.widget_sheet_component_bottom_sheet_recycler;
                MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(R.id.widget_sheet_component_bottom_sheet_recycler);
                if (maxHeightRecyclerView != null) {
                    i = R.id.widget_sheet_component_bottom_sheet_select;
                    TextView textView2 = (TextView) view.findViewById(R.id.widget_sheet_component_bottom_sheet_select);
                    if (textView2 != null) {
                        i = R.id.widget_sheet_component_bottom_sheet_subtitle;
                        TextView textView3 = (TextView) view.findViewById(R.id.widget_sheet_component_bottom_sheet_subtitle);
                        if (textView3 != null) {
                            return new WidgetSelectComponentBottomSheetBinding((ConstraintLayout) view, constraintLayout, textView, maxHeightRecyclerView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
