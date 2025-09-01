package com.discord.widgets.mobile_reports;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetMobileReportsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetMobileReports.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetMobileReportsBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetMobileReportsBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetMobileReports3 extends FunctionReferenceImpl implements Function1<View, WidgetMobileReportsBinding> {
    public static final WidgetMobileReports3 INSTANCE = new WidgetMobileReports3();

    public WidgetMobileReports3() {
        super(1, WidgetMobileReportsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMobileReportsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetMobileReportsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetMobileReportsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.menu_reports_node_view_holder;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.menu_reports_node_view_holder);
        if (frameLayout != null) {
            i = R.id.mobile_reports_progress_bar;
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.mobile_reports_progress_bar);
            if (progressBar != null) {
                return new WidgetMobileReportsBinding((CoordinatorLayout) view, frameLayout, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
