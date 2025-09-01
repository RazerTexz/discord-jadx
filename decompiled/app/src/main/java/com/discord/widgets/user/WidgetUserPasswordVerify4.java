package com.discord.widgets.user;

import com.discord.R;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetUserPasswordVerify.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/utilities/view/validators/ValidationManager;", "invoke", "()Lcom/discord/utilities/view/validators/ValidationManager;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$validationManager$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserPasswordVerify4 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetUserPasswordVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPasswordVerify4(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        super(0);
        this.this$0 = widgetUserPasswordVerify;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = WidgetUserPasswordVerify.access$getBinding$p(this.this$0).c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountPasswordWrap");
        return new ValidationManager(new Input.TextInputLayoutInput(WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, textInputLayout, BasicTextInputValidator.INSTANCE.createRequiredInputValidator(R.string.password_required), AuthUtils.INSTANCE.createPasswordInputValidator(R.string.password_length_error)));
    }
}
