package com.discord.widgets.tos;

import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroup;
import com.discord.api.report.ReportReason;
import com.discord.views.LoadingButton;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: View.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010¸\u0006\u0011"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release", "com/discord/widgets/tos/WidgetTosReportViolation$$special$$inlined$doOnLayout$1"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2 implements View.OnLayoutChangeListener {
    public final /* synthetic */ ReportReason $reason$inlined;
    public final /* synthetic */ WidgetTosReportViolationReasonView $reasonView$inlined;
    public final /* synthetic */ WidgetTosReportViolation this$0;

    /* compiled from: WidgetTosReportViolation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "com/discord/widgets/tos/WidgetTosReportViolation$$special$$inlined$doOnLayout$1$lambda$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!Intrinsics3.areEqual(WidgetTosReportViolation.access$getViewModel$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).getReasonSelected(), WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.$reasonView$inlined.getReason())) {
                WidgetTosReportViolation.access$getViewModel$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).setReasonSelected(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.$reasonView$inlined.getReason());
                LoadingButton loadingButton = WidgetTosReportViolation.access$getBinding$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).f2675b;
                Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
                loadingButton.setEnabled(false);
                LinearLayout linearLayout = WidgetTosReportViolation.access$getBinding$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).d;
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
                for (View view2 : ViewGroup.getChildren(linearLayout)) {
                    Objects.requireNonNull(view2, "null cannot be cast to non-null type com.discord.widgets.tos.WidgetTosReportViolationReasonView");
                    ((WidgetTosReportViolationReasonView) view2).setChecked(false);
                }
                WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.$reasonView$inlined.setChecked(true);
            }
            LoadingButton loadingButton2 = WidgetTosReportViolation.access$getBinding$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).f2675b;
            Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.reportButton");
            loadingButton2.setEnabled(WidgetTosReportViolation.access$getViewModel$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).getReasonSelected() != null);
        }
    }

    public WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2(WidgetTosReportViolationReasonView widgetTosReportViolationReasonView, ReportReason reportReason, WidgetTosReportViolation widgetTosReportViolation) {
        this.$reasonView$inlined = widgetTosReportViolationReasonView;
        this.$reason$inlined = reportReason;
        this.this$0 = widgetTosReportViolation;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        this.$reasonView$inlined.setReason(this.$reason$inlined);
        this.$reasonView$inlined.setChecked(Intrinsics3.areEqual(this.$reason$inlined, WidgetTosReportViolation.access$getViewModel$p(this.this$0).getReasonSelected()));
        this.$reasonView$inlined.setOnClickListener(new AnonymousClass1());
    }
}
