package com.discord.widgets.tos;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.api.report.ReportReason;
import com.discord.databinding.WidgetTosReportViolationReasonBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;

/* compiled from: WidgetTosReportViolationReasonView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR$\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\nR.\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolationReasonView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "onClickListener", "", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "", "enabled", "setEnabled", "(Z)V", "value", "isChecked", "()Z", "setChecked", "Lcom/discord/api/report/ReportReason;", ModelAuditLogEntry.CHANGE_KEY_REASON, "Lcom/discord/api/report/ReportReason;", "getReason", "()Lcom/discord/api/report/ReportReason;", "setReason", "(Lcom/discord/api/report/ReportReason;)V", "Lcom/discord/databinding/WidgetTosReportViolationReasonBinding;", "binding", "Lcom/discord/databinding/WidgetTosReportViolationReasonBinding;", "getBinding", "()Lcom/discord/databinding/WidgetTosReportViolationReasonBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetTosReportViolationReasonView extends RelativeLayout {
    private final WidgetTosReportViolationReasonBinding binding;
    private ReportReason reason;

    /* compiled from: WidgetTosReportViolationReasonView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolationReasonView$setOnClickListener$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Ref$BooleanRef $onClickInvoked;
        public final /* synthetic */ View.OnClickListener $onClickListener;

        public AnonymousClass1(Ref$BooleanRef ref$BooleanRef, View.OnClickListener onClickListener) {
            this.$onClickInvoked = ref$BooleanRef;
            this.$onClickListener = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onClickInvoked.element = true;
            View.OnClickListener onClickListener = this.$onClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(WidgetTosReportViolationReasonView.this);
            }
            this.$onClickInvoked.element = false;
        }
    }

    /* compiled from: WidgetTosReportViolationReasonView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "isChecked", "", "onCheckedChanged", "(Landroid/widget/CompoundButton;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolationReasonView$setOnClickListener$2, reason: invalid class name */
    public static final class AnonymousClass2 implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ Ref$BooleanRef $onClickInvoked;
        public final /* synthetic */ View.OnClickListener $onClickListener;

        public AnonymousClass2(Ref$BooleanRef ref$BooleanRef, View.OnClickListener onClickListener) {
            this.$onClickInvoked = ref$BooleanRef;
            this.$onClickListener = onClickListener;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            View.OnClickListener onClickListener;
            if (this.$onClickInvoked.element || !z2 || (onClickListener = this.$onClickListener) == null) {
                return;
            }
            onClickListener.onClick(WidgetTosReportViolationReasonView.this);
        }
    }

    public WidgetTosReportViolationReasonView(Context context) {
        this(context, null, 0, 6, null);
    }

    public WidgetTosReportViolationReasonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ WidgetTosReportViolationReasonView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final WidgetTosReportViolationReasonBinding getBinding() {
        return this.binding;
    }

    public final ReportReason getReason() {
        return this.reason;
    }

    public final boolean isChecked() {
        MaterialRadioButton materialRadioButton = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.reportReasonRadio");
        return materialRadioButton.isChecked();
    }

    public final void setChecked(boolean z2) {
        MaterialRadioButton materialRadioButton = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.reportReasonRadio");
        materialRadioButton.setChecked(z2);
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        RelativeLayout relativeLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.root");
        relativeLayout.setEnabled(enabled);
        MaterialRadioButton materialRadioButton = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.reportReasonRadio");
        materialRadioButton.setEnabled(enabled);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = false;
        this.binding.a.setOnClickListener(new AnonymousClass1(ref$BooleanRef, onClickListener));
        this.binding.d.setOnCheckedChangeListener(new AnonymousClass2(ref$BooleanRef, onClickListener));
    }

    public final void setReason(ReportReason reportReason) {
        this.reason = reportReason;
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.reportReasonHeader");
        textView.setText(reportReason != null ? reportReason.getLabel() : null);
        TextView textView2 = this.binding.f2676b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.reportReasonDescriptipn");
        textView2.setText(reportReason != null ? reportReason.getDescription() : null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTosReportViolationReasonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.widget_tos_report_violation_reason, (ViewGroup) this, false);
        addView(viewInflate);
        int i2 = R.id.report_reason_descriptipn;
        TextView textView = (TextView) viewInflate.findViewById(R.id.report_reason_descriptipn);
        if (textView != null) {
            i2 = R.id.report_reason_header;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.report_reason_header);
            if (textView2 != null) {
                i2 = R.id.report_reason_radio;
                MaterialRadioButton materialRadioButton = (MaterialRadioButton) viewInflate.findViewById(R.id.report_reason_radio);
                if (materialRadioButton != null) {
                    WidgetTosReportViolationReasonBinding widgetTosReportViolationReasonBinding = new WidgetTosReportViolationReasonBinding((RelativeLayout) viewInflate, textView, textView2, materialRadioButton);
                    Intrinsics3.checkNotNullExpressionValue(widgetTosReportViolationReasonBinding, "WidgetTosReportViolation…rom(context), this, true)");
                    this.binding = widgetTosReportViolationReasonBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }
}
