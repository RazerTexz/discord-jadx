package com.discord.utilities.view.validators;

import androidx.annotation.StringRes;
import b.a.k.FormatUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BasicTextInputValidator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B%\u0012\b\b\u0001\u0010\r\u001a\u00020\f\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/view/validators/BasicTextInputValidator;", "Lcom/discord/utilities/view/validators/InputValidator;", "Lcom/google/android/material/textfield/TextInputLayout;", "view", "", "getErrorMessage", "(Lcom/google/android/material/textfield/TextInputLayout;)Ljava/lang/CharSequence;", "Lkotlin/Function1;", "", "", "inputPredicate", "Lkotlin/jvm/functions/Function1;", "", "messageResId", "I", "getMessageResId", "()I", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "Companion", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class BasicTextInputValidator implements InputValidator<TextInputLayout> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function1<String, Boolean> inputPredicate;
    private final int messageResId;

    /* compiled from: BasicTextInputValidator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/utilities/view/validators/BasicTextInputValidator$Companion;", "", "", "messageResId", "Lcom/discord/utilities/view/validators/BasicTextInputValidator;", "createRequiredInputValidator", "(I)Lcom/discord/utilities/view/validators/BasicTextInputValidator;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final BasicTextInputValidator createRequiredInputValidator(@StringRes int messageResId) {
            return new BasicTextInputValidator(messageResId, BasicTextInputValidator2.INSTANCE);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BasicTextInputValidator(@StringRes int i, Function1<? super String, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(function1, "inputPredicate");
        this.messageResId = i;
        this.inputPredicate = function1;
    }

    @Override // com.discord.utilities.view.validators.InputValidator
    public /* bridge */ /* synthetic */ CharSequence getErrorMessage(TextInputLayout textInputLayout) {
        return getErrorMessage2(textInputLayout);
    }

    public final int getMessageResId() {
        return this.messageResId;
    }

    /* renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
    public CharSequence getErrorMessage2(TextInputLayout view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        if (this.inputPredicate.invoke(ViewExtensions.getTextOrEmpty(view)).booleanValue()) {
            return null;
        }
        return FormatUtils.j(view, this.messageResId, new Object[0], null, 4);
    }
}
