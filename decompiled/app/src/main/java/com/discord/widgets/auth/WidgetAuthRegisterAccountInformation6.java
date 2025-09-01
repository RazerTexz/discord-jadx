package com.discord.widgets.auth;

import android.widget.CheckBox;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetAuthRegisterAccountInformation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/utilities/view/validators/ValidationManager;", "invoke", "()Lcom/discord/utilities/view/validators/ValidationManager;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$validationManager$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation6 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthRegisterAccountInformation this$0;

    /* compiled from: WidgetAuthRegisterAccountInformation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/auth/WidgetAuthRegisterAccountInformation$validationManager$2$1", "Lcom/discord/utilities/view/validators/InputValidator;", "Landroid/widget/CheckBox;", "view", "", "getErrorMessage", "(Landroid/widget/CheckBox;)Ljava/lang/CharSequence;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$validationManager$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements InputValidator<CheckBox> {
        public AnonymousClass1() {
        }

        @Override // com.discord.utilities.view.validators.InputValidator
        public /* bridge */ /* synthetic */ CharSequence getErrorMessage(CheckBox checkBox) {
            return getErrorMessage2(checkBox);
        }

        /* renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
        public CharSequence getErrorMessage2(CheckBox view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            if ((WidgetAuthRegisterAccountInformation.access$isConsentRequired$p(WidgetAuthRegisterAccountInformation6.this.this$0) && view.isChecked()) || !WidgetAuthRegisterAccountInformation.access$isConsentRequired$p(WidgetAuthRegisterAccountInformation6.this.this$0)) {
                return null;
            }
            return view.getContext().getString(R.string.terms_privacy_opt_in_tooltip);
        }
    }

    /* compiled from: WidgetAuthRegisterAccountInformation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/material/checkbox/MaterialCheckBox;", "checkBox", "", "errorMessage", "", "invoke", "(Lcom/google/android/material/checkbox/MaterialCheckBox;Ljava/lang/CharSequence;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$validationManager$2$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function2<MaterialCheckBox, CharSequence, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(MaterialCheckBox materialCheckBox, CharSequence charSequence) {
            return Boolean.valueOf(invoke2(materialCheckBox, charSequence));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(MaterialCheckBox materialCheckBox, CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(materialCheckBox, "checkBox");
            Intrinsics3.checkNotNullParameter(charSequence, "errorMessage");
            AppToast.h(materialCheckBox.getContext(), charSequence, 0, null, 12);
            ViewExtensions.hintWithRipple$default(materialCheckBox, 0L, 1, null);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterAccountInformation6(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation) {
        super(0);
        this.this$0 = widgetAuthRegisterAccountInformation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = WidgetAuthRegisterAccountInformation.access$getBinding$p(this.this$0).e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterAccountInformationUsernameWrap");
        BasicTextInputValidator.Companion companion = BasicTextInputValidator.INSTANCE;
        InputValidator[] inputValidatorArr = {companion.createRequiredInputValidator(R.string.username_required)};
        TextInputLayout textInputLayout2 = WidgetAuthRegisterAccountInformation.access$getBinding$p(this.this$0).d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.authRegisterAccountInformationPasswordWrap");
        return new ValidationManager(new Input.TextInputLayoutInput("username", textInputLayout, inputValidatorArr), new Input.TextInputLayoutInput(WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, textInputLayout2, companion.createRequiredInputValidator(R.string.password_required), AuthUtils.INSTANCE.createPasswordInputValidator(R.string.password_length_error)), new Input.GenericInput("tos", WidgetAuthRegisterAccountInformation.access$getBinding$p(this.this$0).f, new AnonymousClass1(), AnonymousClass2.INSTANCE));
    }
}
