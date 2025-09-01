package com.discord.widgets.hubs;

import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.FormatUtils;
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
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetHubDescription.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/utilities/view/validators/ValidationManager;", "invoke", "()Lcom/discord/utilities/view/validators/ValidationManager;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.WidgetHubDescription$validationManager$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubDescription7 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* compiled from: WidgetHubDescription.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/hubs/WidgetHubDescription$validationManager$2$1", "Lcom/discord/utilities/view/validators/InputValidator;", "Landroid/widget/LinearLayout;", "view", "", "getErrorMessage", "(Landroid/widget/LinearLayout;)Ljava/lang/CharSequence;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$validationManager$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements InputValidator<LinearLayout> {
        public AnonymousClass1() {
        }

        @Override // com.discord.utilities.view.validators.InputValidator
        public /* bridge */ /* synthetic */ CharSequence getErrorMessage(LinearLayout linearLayout) {
            return getErrorMessage2(linearLayout);
        }

        /* renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
        public CharSequence getErrorMessage2(LinearLayout view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            if (WidgetHubDescription7.this.this$0.getViewModel().getCategory() != null) {
                return null;
            }
            return view.getContext().getString(R.string.billing_address_address_error_required);
        }
    }

    /* compiled from: WidgetHubDescription.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/widget/LinearLayout;", "<anonymous parameter 0>", "", "errorMessage", "", "invoke", "(Landroid/widget/LinearLayout;Ljava/lang/CharSequence;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubDescription$validationManager$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function2<LinearLayout, CharSequence, Boolean> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(LinearLayout linearLayout, CharSequence charSequence) {
            return Boolean.valueOf(invoke2(linearLayout, charSequence));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(LinearLayout linearLayout, CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(linearLayout, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(charSequence, "errorMessage");
            TextView textView = WidgetHubDescription7.this.this$0.getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.categoryError");
            FormatUtils.a(textView, charSequence);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription7(WidgetHubDescription widgetHubDescription) {
        super(0);
        this.this$0 = widgetHubDescription;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.descriptionLayout");
        InputValidator[] inputValidatorArr = {BasicTextInputValidator.INSTANCE.createRequiredInputValidator(R.string.member_verification_form_required_item)};
        LinearLayout linearLayout = this.this$0.getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.categoryLayout");
        return new ValidationManager(new Input.TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, textInputLayout, inputValidatorArr), new Input.GenericInput("category", linearLayout, new AnonymousClass1(), new AnonymousClass2()));
    }
}
