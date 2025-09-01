package com.discord.widgets.bugreports;

import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetBugReport.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/utilities/view/validators/ValidationManager;", "invoke", "()Lcom/discord/utilities/view/validators/ValidationManager;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetBugReport$validationManager$2 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetBugReport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBugReport$validationManager$2(WidgetBugReport widgetBugReport) {
        super(0);
        this.this$0 = widgetBugReport;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = WidgetBugReport.access$getBinding$p(this.this$0).h;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.bugReportName");
        BasicTextInputValidator.Companion companion = BasicTextInputValidator.INSTANCE;
        InputValidator[] inputValidatorArr = {companion.createRequiredInputValidator(R.string.bug_report_error_name_required)};
        TextInputLayout textInputLayout2 = WidgetBugReport.access$getBinding$p(this.this$0).j;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.bugReportPriority");
        return new ValidationManager(new Input.TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_NAME, textInputLayout, inputValidatorArr), new Input.TextInputLayoutInput("priority", textInputLayout2, companion.createRequiredInputValidator(R.string.bug_report_error_priority_required)));
    }
}
