package com.discord.utilities.view.validators;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: Input.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0003\u001c\u001d\u001eB;\u0012\n\u0010\u000e\u001a\u00060\fj\u0002`\r\u0012\u0006\u0010\u0016\u001a\u00028\u0000\u0012\u001e\u0010\u0014\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0012\"\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u00060\fj\u0002`\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/view/validators/Input;", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "showErrors", "validate", "(Z)Z", "", "errorMessage", "setErrorMessage", "(Ljava/lang/CharSequence;)Z", "", "Lcom/discord/utilities/view/validators/FieldName;", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "Lcom/discord/utilities/view/validators/InputValidator;", "validators", "[Lcom/discord/utilities/view/validators/InputValidator;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Ljava/lang/String;Landroid/view/View;[Lcom/discord/utilities/view/validators/InputValidator;)V", "EditTextInput", "GenericInput", "TextInputLayoutInput", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class Input<T extends View> {
    private final String name;
    private final InputValidator<T>[] validators;
    private final T view;

    /* compiled from: Input.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u001e\u0010\u000e\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\f\"\b\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/discord/utilities/view/validators/Input$EditTextInput;", "Lcom/discord/utilities/view/validators/Input;", "Lcom/google/android/material/textfield/TextInputLayout;", "", "errorMessage", "", "setErrorMessage", "(Ljava/lang/CharSequence;)Z", "", "Lcom/discord/utilities/view/validators/FieldName;", ModelAuditLogEntry.CHANGE_KEY_NAME, "view", "", "Lcom/discord/utilities/view/validators/InputValidator;", "validators", "<init>", "(Ljava/lang/String;Lcom/google/android/material/textfield/TextInputLayout;[Lcom/discord/utilities/view/validators/InputValidator;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class EditTextInput extends Input<TextInputLayout> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EditTextInput(String str, TextInputLayout textInputLayout, InputValidator<? super TextInputLayout>... inputValidatorArr) {
            super(str, textInputLayout, (InputValidator[]) Arrays.copyOf(inputValidatorArr, inputValidatorArr.length));
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(textInputLayout, "view");
            Intrinsics3.checkNotNullParameter(inputValidatorArr, "validators");
        }

        @Override // com.discord.utilities.view.validators.Input
        public boolean setErrorMessage(CharSequence errorMessage) {
            getView().setError(errorMessage);
            boolean z2 = !(errorMessage == null || StringsJVM.isBlank(errorMessage));
            if (z2) {
                getView().requestFocus();
            }
            return z2;
        }
    }

    /* compiled from: Input.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003BC\u0012\n\u0010\u000e\u001a\u00060\fj\u0002`\r\u0012\u0006\u0010\u000f\u001a\u00028\u0001\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR(\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/view/validators/Input$GenericInput;", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/discord/utilities/view/validators/Input;", "", "errorMessage", "", "setErrorMessage", "(Ljava/lang/CharSequence;)Z", "Lkotlin/Function2;", "onError", "Lkotlin/jvm/functions/Function2;", "", "Lcom/discord/utilities/view/validators/FieldName;", ModelAuditLogEntry.CHANGE_KEY_NAME, "view", "Lcom/discord/utilities/view/validators/InputValidator;", "validator", "<init>", "(Ljava/lang/String;Landroid/view/View;Lcom/discord/utilities/view/validators/InputValidator;Lkotlin/jvm/functions/Function2;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class GenericInput<T extends View> extends Input<T> {
        private final Function2<T, CharSequence, Boolean> onError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GenericInput(String str, T t, InputValidator<? super T> inputValidator, Function2<? super T, ? super CharSequence, Boolean> function2) {
            super(str, t, inputValidator);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(t, "view");
            Intrinsics3.checkNotNullParameter(inputValidator, "validator");
            Intrinsics3.checkNotNullParameter(function2, "onError");
            this.onError = function2;
        }

        @Override // com.discord.utilities.view.validators.Input
        public boolean setErrorMessage(CharSequence errorMessage) {
            if (errorMessage == null || StringsJVM.isBlank(errorMessage)) {
                return false;
            }
            return this.onError.invoke(getView(), errorMessage).booleanValue();
        }
    }

    /* compiled from: Input.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u001e\u0010\u000e\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\f\"\b\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/discord/utilities/view/validators/Input$TextInputLayoutInput;", "Lcom/discord/utilities/view/validators/Input;", "Lcom/google/android/material/textfield/TextInputLayout;", "", "errorMessage", "", "setErrorMessage", "(Ljava/lang/CharSequence;)Z", "", "Lcom/discord/utilities/view/validators/FieldName;", ModelAuditLogEntry.CHANGE_KEY_NAME, "view", "", "Lcom/discord/utilities/view/validators/InputValidator;", "validators", "<init>", "(Ljava/lang/String;Lcom/google/android/material/textfield/TextInputLayout;[Lcom/discord/utilities/view/validators/InputValidator;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class TextInputLayoutInput extends Input<TextInputLayout> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextInputLayoutInput(String str, TextInputLayout textInputLayout, InputValidator<? super TextInputLayout>... inputValidatorArr) {
            super(str, textInputLayout, (InputValidator[]) Arrays.copyOf(inputValidatorArr, inputValidatorArr.length));
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(textInputLayout, "view");
            Intrinsics3.checkNotNullParameter(inputValidatorArr, "validators");
        }

        @Override // com.discord.utilities.view.validators.Input
        public boolean setErrorMessage(CharSequence errorMessage) {
            getView().setError(errorMessage);
            if (getView().getEndIconMode() == 1) {
                getView().setErrorIconDrawable(0);
            }
            boolean z2 = !(errorMessage == null || StringsJVM.isBlank(errorMessage));
            getView().setErrorEnabled(z2);
            if (z2) {
                getView().requestFocus();
            }
            return z2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Input(String str, T t, InputValidator<? super T>... inputValidatorArr) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(t, "view");
        Intrinsics3.checkNotNullParameter(inputValidatorArr, "validators");
        this.name = str;
        this.view = t;
        this.validators = inputValidatorArr;
    }

    public static /* synthetic */ boolean validate$default(Input input, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validate");
        }
        if ((i & 1) != 0) {
            z2 = true;
        }
        return input.validate(z2);
    }

    public final String getName() {
        return this.name;
    }

    public final T getView() {
        return this.view;
    }

    public boolean setErrorMessage(CharSequence errorMessage) {
        return false;
    }

    public boolean validate(boolean showErrors) {
        boolean errorMessage;
        InputValidator<T>[] inputValidatorArr = this.validators;
        int length = inputValidatorArr.length;
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            CharSequence errorMessage2 = inputValidatorArr[i].getErrorMessage(this.view);
            if (showErrors) {
                errorMessage = setErrorMessage(errorMessage2);
            } else {
                errorMessage = !(errorMessage2 == null || errorMessage2.length() == 0);
            }
            if (errorMessage) {
                z2 = true;
                break;
            }
            i++;
        }
        return !z2;
    }
}
