package com.discord.widgets.mobile_reports;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.databinding.ViewMobileReportsBottomButtonBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MobileReportsBottomButton.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsBottomButton;", "Landroid/widget/LinearLayout;", "Lcom/discord/api/report/ReportNodeBottomButton;", "bottomButton", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;", "submitState", "Lkotlin/Function1;", "", "handleButtonPress", "setup", "(Lcom/discord/api/report/ReportNodeBottomButton;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/databinding/ViewMobileReportsBottomButtonBinding;", "binding", "Lcom/discord/databinding/ViewMobileReportsBottomButtonBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MobileReportsBottomButton extends LinearLayout {
    private final ViewMobileReportsBottomButtonBinding binding;

    /* compiled from: MobileReportsBottomButton.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsBottomButton$setup$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ReportNodeBottomButton $bottomButton;
        public final /* synthetic */ Function1 $handleButtonPress;

        public AnonymousClass1(Function1 function1, ReportNodeBottomButton reportNodeBottomButton) {
            this.$handleButtonPress = function1;
            this.$bottomButton = reportNodeBottomButton;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.$handleButtonPress;
            if (function1 != null) {
            }
        }
    }

    /* compiled from: MobileReportsBottomButton.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsBottomButton$setup$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ ReportNodeBottomButton $bottomButton;
        public final /* synthetic */ Function1 $handleButtonPress;

        public AnonymousClass2(Function1 function1, ReportNodeBottomButton reportNodeBottomButton) {
            this.$handleButtonPress = function1;
            this.$bottomButton = reportNodeBottomButton;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.$handleButtonPress;
            if (function1 != null) {
            }
        }
    }

    /* compiled from: MobileReportsBottomButton.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsBottomButton$setup$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ ReportNodeBottomButton $bottomButton;
        public final /* synthetic */ Function1 $handleButtonPress;

        public AnonymousClass3(Function1 function1, ReportNodeBottomButton reportNodeBottomButton) {
            this.$handleButtonPress = function1;
            this.$bottomButton = reportNodeBottomButton;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.$handleButtonPress;
            if (function1 != null) {
            }
        }
    }

    /* compiled from: MobileReportsBottomButton.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsBottomButton$setup$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ ReportNodeBottomButton $bottomButton;
        public final /* synthetic */ Function1 $handleButtonPress;

        public AnonymousClass4(Function1 function1, ReportNodeBottomButton reportNodeBottomButton) {
            this.$handleButtonPress = function1;
            this.$bottomButton = reportNodeBottomButton;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.$handleButtonPress;
            if (function1 != null) {
            }
        }
    }

    public MobileReportsBottomButton(Context context) {
        this(context, null, 0, 6, null);
    }

    public MobileReportsBottomButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MobileReportsBottomButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setup(ReportNodeBottomButton bottomButton, MobileReportsViewModel.SubmitState submitState, Function1<? super ReportNodeBottomButton, Unit> handleButtonPress) {
        this.binding.c.setOnClickListener(null);
        this.binding.f2202b.setOnClickListener(null);
        LinkifiedTextView linkifiedTextView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.reportNodeBottomButtonDescription");
        boolean z2 = bottomButton instanceof ReportNodeBottomButton.Submit;
        linkifiedTextView.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.reportNodeBottomButtonCancel");
        boolean z3 = bottomButton instanceof ReportNodeBottomButton.Cancel;
        materialButton.setVisibility(z3 ? 0 : 8);
        LoadingButton loadingButton = this.binding.f2202b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportNodeBottomButton");
        MaterialButton materialButton2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.reportNodeBottomButtonCancel");
        loadingButton.setVisibility((materialButton2.getVisibility() == 0) ^ true ? 0 : 8);
        boolean z4 = submitState instanceof MobileReportsViewModel.SubmitState.Loading;
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.reportNodeBottomButtonErrorText");
        textView.setVisibility(submitState instanceof MobileReportsViewModel.SubmitState.Error ? 0 : 8);
        this.binding.f2202b.setIsLoading(z4);
        LoadingButton loadingButton2 = this.binding.f2202b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.reportNodeBottomButton");
        loadingButton2.setEnabled(!z4);
        if (z2) {
            LinkifiedTextView linkifiedTextView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.reportNodeBottomButtonDescription");
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            linkifiedTextView2.setText(FormatUtils.h(context, R.string.mobile_reports_submit_info_text, new Object[0], null, 4));
            this.binding.f2202b.setText(getContext().getString(R.string.mobile_reports_submit_report));
            this.binding.f2202b.setBackgroundColor(ColorCompat.getColor(getContext(), R.color.status_red));
            this.binding.f2202b.setOnClickListener(new AnonymousClass1(handleButtonPress, bottomButton));
            return;
        }
        if (bottomButton instanceof ReportNodeBottomButton.Done) {
            this.binding.f2202b.setText(getContext().getString(R.string.done));
            this.binding.f2202b.setOnClickListener(new AnonymousClass2(handleButtonPress, bottomButton));
        } else if (bottomButton instanceof ReportNodeBottomButton.Next) {
            this.binding.f2202b.setText(getContext().getString(R.string.next));
            this.binding.f2202b.setOnClickListener(new AnonymousClass3(handleButtonPress, bottomButton));
        } else if (z3) {
            this.binding.c.setOnClickListener(new AnonymousClass4(handleButtonPress, bottomButton));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsBottomButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_mobile_reports_bottom_button, this);
        int i2 = R.id.report_node_bottom_button;
        LoadingButton loadingButton = (LoadingButton) findViewById(R.id.report_node_bottom_button);
        if (loadingButton != null) {
            i2 = R.id.report_node_bottom_button_cancel;
            MaterialButton materialButton = (MaterialButton) findViewById(R.id.report_node_bottom_button_cancel);
            if (materialButton != null) {
                i2 = R.id.report_node_bottom_button_description;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) findViewById(R.id.report_node_bottom_button_description);
                if (linkifiedTextView != null) {
                    i2 = R.id.report_node_bottom_button_error_text;
                    TextView textView = (TextView) findViewById(R.id.report_node_bottom_button_error_text);
                    if (textView != null) {
                        ViewMobileReportsBottomButtonBinding viewMobileReportsBottomButtonBinding = new ViewMobileReportsBottomButtonBinding(this, loadingButton, materialButton, linkifiedTextView, textView);
                        Intrinsics3.checkNotNullExpressionValue(viewMobileReportsBottomButtonBinding, "ViewMobileReportsBottomB…ater.from(context), this)");
                        this.binding = viewMobileReportsBottomButtonBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
