package com.discord.widgets.tos;

import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroup;
import com.discord.api.report.ReportReason;
import com.discord.views.LoadingButton;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: WidgetTosReportViolation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/tos/WidgetTosReportViolation$$special$$inlined$doOnLayout$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetTosReportViolation2 implements View.OnClickListener {
    public final /* synthetic */ ReportReason $reason$inlined;
    public final /* synthetic */ WidgetTosReportViolationReasonView $reasonView$inlined;
    public final /* synthetic */ WidgetTosReportViolation this$0;

    public WidgetTosReportViolation2(WidgetTosReportViolationReasonView widgetTosReportViolationReasonView, ReportReason reportReason, WidgetTosReportViolation widgetTosReportViolation) {
        this.$reasonView$inlined = widgetTosReportViolationReasonView;
        this.$reason$inlined = reportReason;
        this.this$0 = widgetTosReportViolation;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!Intrinsics3.areEqual(WidgetTosReportViolation.access$getViewModel$p(this.this$0).getReasonSelected(), this.$reasonView$inlined.getReason())) {
            WidgetTosReportViolation.access$getViewModel$p(this.this$0).setReasonSelected(this.$reasonView$inlined.getReason());
            LoadingButton loadingButton = WidgetTosReportViolation.access$getBinding$p(this.this$0).f2675b;
            Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
            loadingButton.setEnabled(false);
            LinearLayout linearLayout = WidgetTosReportViolation.access$getBinding$p(this.this$0).d;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
            for (View view2 : ViewGroup.getChildren(linearLayout)) {
                Objects.requireNonNull(view2, "null cannot be cast to non-null type com.discord.widgets.tos.WidgetTosReportViolationReasonView");
                ((WidgetTosReportViolationReasonView) view2).setChecked(false);
            }
            this.$reasonView$inlined.setChecked(true);
        }
        LoadingButton loadingButton2 = WidgetTosReportViolation.access$getBinding$p(this.this$0).f2675b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.reportButton");
        loadingButton2.setEnabled(WidgetTosReportViolation.access$getViewModel$p(this.this$0).getReasonSelected() != null);
    }
}
