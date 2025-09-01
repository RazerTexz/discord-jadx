package com.discord.widgets.tos;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetTosReportViolationBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetTosReportViolation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetTosReportViolationBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetTosReportViolationBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetTosReportViolation4 extends FunctionReferenceImpl implements Function1<View, WidgetTosReportViolationBinding> {
    public static final WidgetTosReportViolation4 INSTANCE = new WidgetTosReportViolation4();

    public WidgetTosReportViolation4() {
        super(1, WidgetTosReportViolationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetTosReportViolationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetTosReportViolationBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetTosReportViolationBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.report_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.report_button);
        if (loadingButton != null) {
            i = R.id.report_header;
            TextView textView = (TextView) view.findViewById(R.id.report_header);
            if (textView != null) {
                i = R.id.report_reasons_container;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.report_reasons_container);
                if (linearLayout != null) {
                    i = R.id.report_reasons_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.report_reasons_header);
                    if (textView2 != null) {
                        i = R.id.report_reasons_loading;
                        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.report_reasons_loading);
                        if (progressBar != null) {
                            i = R.id.report_tooltip;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.report_tooltip);
                            if (linkifiedTextView != null) {
                                return new WidgetTosReportViolationBinding((CoordinatorLayout) view, loadingButton, textView, linearLayout, textView2, progressBar, linkifiedTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
