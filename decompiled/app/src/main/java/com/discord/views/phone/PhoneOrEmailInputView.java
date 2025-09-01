package com.discord.views.phone;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.i.ViewPhoneOrEmailInputBinding;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.utilities.phone.PhoneUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: PhoneOrEmailInputView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u00018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J#\u0010$\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\"¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010*J\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010*R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00102¨\u00069"}, d2 = {"Lcom/discord/views/phone/PhoneOrEmailInputView;", "Landroid/widget/LinearLayout;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "", "setMainInputNextFocusForwardId", "(I)V", "Landroidx/fragment/app/Fragment;", "fragment", "b", "(Landroidx/fragment/app/Fragment;)V", "Lcom/discord/models/phone/PhoneCountryCode;", "countryCode", "setCountryCode", "(Lcom/discord/models/phone/PhoneCountryCode;)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "setText", "(Ljava/lang/CharSequence;)V", "hint", "setHint", "Lcom/discord/views/phone/PhoneOrEmailInputView$Mode;", "mode", "setMode", "(Lcom/discord/views/phone/PhoneOrEmailInputView$Mode;)V", "Lcom/google/android/material/textfield/TextInputLayout;", "getMainTextInputLayout", "()Lcom/google/android/material/textfield/TextInputLayout;", "Lcom/google/android/material/textfield/TextInputEditText;", "getMainEditText", "()Lcom/google/android/material/textfield/TextInputEditText;", "", "getTextOrEmpty", "()Ljava/lang/String;", "Lkotlin/Function0;", "onAfterTextChanged", "a", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function0;)V", "", "e", "()Z", "f", "()V", "c", "d", "Lb/a/i/u2;", "k", "Lb/a/i/u2;", "binding", "m", "Ljava/lang/CharSequence;", NotificationCompat.CATEGORY_EMAIL, "l", "Lcom/discord/views/phone/PhoneOrEmailInputView$Mode;", "n", "phone", "Mode", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PhoneOrEmailInputView extends LinearLayout {
    public static final /* synthetic */ int j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public final ViewPhoneOrEmailInputBinding binding;

    /* renamed from: l, reason: from kotlin metadata */
    public Mode mode;

    /* renamed from: m, reason: from kotlin metadata */
    public CharSequence email;

    /* renamed from: n, reason: from kotlin metadata */
    public CharSequence phone;

    /* compiled from: PhoneOrEmailInputView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/views/phone/PhoneOrEmailInputView$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "ADAPTIVE", "EMAIL", "PHONE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum Mode {
        ADAPTIVE,
        EMAIL,
        PHONE
    }

    /* compiled from: PhoneOrEmailInputView.kt */
    public static final class a extends Lambda implements Function1<Editable, Unit> {
        public final /* synthetic */ Function0 $onAfterTextChanged;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(1);
            this.$onAfterTextChanged = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            this.$onAfterTextChanged.invoke();
            return Unit.a;
        }
    }

    /* compiled from: PhoneOrEmailInputView.kt */
    public static final class b extends Lambda implements Function1<Editable, Unit> {
        public final /* synthetic */ Function0 $onAfterTextChanged;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Function0 function0) {
            super(1);
            this.$onAfterTextChanged = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            PhoneOrEmailInputView phoneOrEmailInputView = PhoneOrEmailInputView.this;
            int i = PhoneOrEmailInputView.j;
            phoneOrEmailInputView.c();
            this.$onAfterTextChanged.invoke();
            return Unit.a;
        }
    }

    /* compiled from: PhoneOrEmailInputView.kt */
    public static final class c extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Fragment $fragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(1);
            this.$fragment = fragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetPhoneCountryCodeBottomSheet.Companion companion = WidgetPhoneCountryCodeBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = this.$fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            companion.show(parentFragmentManager);
            return Unit.a;
        }
    }

    /* compiled from: PhoneOrEmailInputView.kt */
    public static final class d extends Lambda implements Function1<Editable, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            PhoneOrEmailInputView phoneOrEmailInputView = PhoneOrEmailInputView.this;
            int i = PhoneOrEmailInputView.j;
            phoneOrEmailInputView.f();
            PhoneOrEmailInputView.this.c();
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneOrEmailInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_phone_or_email_input, this);
        int i = R.id.phone_or_email_country_code_wrap;
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.phone_or_email_country_code_wrap);
        if (textInputLayout != null) {
            i = R.id.phone_or_email_main_input;
            TextInputEditText textInputEditText = (TextInputEditText) findViewById(R.id.phone_or_email_main_input);
            if (textInputEditText != null) {
                i = R.id.phone_or_email_main_input_wrap;
                TextInputLayout textInputLayout2 = (TextInputLayout) findViewById(R.id.phone_or_email_main_input_wrap);
                if (textInputLayout2 != null) {
                    ViewPhoneOrEmailInputBinding viewPhoneOrEmailInputBinding = new ViewPhoneOrEmailInputBinding(this, textInputLayout, textInputEditText, textInputLayout2);
                    Intrinsics3.checkNotNullExpressionValue(viewPhoneOrEmailInputBinding, "ViewPhoneOrEmailInputBin…ater.from(context), this)");
                    this.binding = viewPhoneOrEmailInputBinding;
                    Mode mode = Mode.ADAPTIVE;
                    this.mode = mode;
                    this.email = "";
                    this.phone = "";
                    setLayoutTransition(new LayoutTransition());
                    if (attributeSet != null) {
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.PhoneOrEmailInputView, 0, 0);
                        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…neOrEmailInputView, 0, 0)");
                        try {
                            setHint(typedArrayObtainStyledAttributes.getString(1));
                            setMode(Mode.values()[typedArrayObtainStyledAttributes.getInt(0, mode.ordinal())]);
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, -1);
                            if (resourceId != -1) {
                                setMainInputNextFocusForwardId(resourceId);
                            }
                            return;
                        } finally {
                            typedArrayObtainStyledAttributes.recycle();
                        }
                    }
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    private final void setMainInputNextFocusForwardId(int id2) {
        TextInputLayout textInputLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        textInputLayout.setNextFocusForwardId(id2);
    }

    public final void a(Fragment fragment, Function0<Unit> onAfterTextChanged) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(onAfterTextChanged, "onAfterTextChanged");
        TextInputLayout textInputLayout = this.binding.f210b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailCountryCodeWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout, fragment, new a(onAfterTextChanged));
        TextInputLayout textInputLayout2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.phoneOrEmailMainInputWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, fragment, new b(onAfterTextChanged));
    }

    public final void b(Fragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        TextInputLayout textInputLayout = this.binding.f210b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailCountryCodeWrap");
        ViewExtensions.setOnEditTextClickListener(textInputLayout, new c(fragment));
        TextInputLayout textInputLayout2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.phoneOrEmailMainInputWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, fragment, new d());
        c();
        d();
    }

    public final void c() {
        TextInputLayout textInputLayout = this.binding.f210b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailCountryCodeWrap");
        textInputLayout.setVisibility(e() ? 0 : 8);
    }

    public final void d() {
        if (this.mode.ordinal() != 2) {
            TextInputEditText textInputEditText = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.phoneOrEmailMainInput");
            textInputEditText.setInputType(32);
            if (Build.VERSION.SDK_INT >= 26) {
                this.binding.c.setAutofillHints(new String[]{"emailAddress"});
            }
            TextInputLayout textInputLayout = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
            ViewExtensions.setText(textInputLayout, this.email);
            this.binding.c.setSelection(this.email.length());
            return;
        }
        TextInputEditText textInputEditText2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText2, "binding.phoneOrEmailMainInput");
        textInputEditText2.setInputType(3);
        if (Build.VERSION.SDK_INT >= 26) {
            this.binding.c.setAutofillHints(new String[]{"phone"});
        }
        TextInputLayout textInputLayout2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.phoneOrEmailMainInputWrap");
        ViewExtensions.setText(textInputLayout2, this.phone);
        this.binding.c.setSelection(this.phone.length());
    }

    public final boolean e() {
        int iOrdinal = this.mode.ordinal();
        if (iOrdinal == 1) {
            return false;
        }
        if (iOrdinal == 2) {
            return true;
        }
        PhoneUtils phoneUtils = PhoneUtils.INSTANCE;
        TextInputLayout textInputLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        return phoneUtils.isLikelyToContainPhoneNumber(ViewExtensions.getTextOrEmpty(textInputLayout));
    }

    public final void f() {
        TextInputLayout textInputLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        if (this.mode == Mode.PHONE || PhoneUtils.INSTANCE.isLikelyToContainPhoneNumber(textOrEmpty)) {
            this.phone = textOrEmpty;
        } else {
            this.email = textOrEmpty;
        }
    }

    public final TextInputEditText getMainEditText() {
        TextInputEditText textInputEditText = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.phoneOrEmailMainInput");
        return textInputEditText;
    }

    public final TextInputLayout getMainTextInputLayout() {
        TextInputLayout textInputLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        return textInputLayout;
    }

    public final String getTextOrEmpty() {
        if (!e()) {
            TextInputLayout textInputLayout = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
            return ViewExtensions.getTextOrEmpty(textInputLayout);
        }
        StringBuilder sb = new StringBuilder();
        TextInputLayout textInputLayout2 = this.binding.f210b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.phoneOrEmailCountryCodeWrap");
        sb.append(ViewExtensions.getTextOrEmpty(textInputLayout2));
        TextInputLayout textInputLayout3 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.phoneOrEmailMainInputWrap");
        sb.append(ViewExtensions.getTextOrEmpty(textInputLayout3));
        return sb.toString();
    }

    public final void setCountryCode(PhoneCountryCode countryCode) {
        Intrinsics3.checkNotNullParameter(countryCode, "countryCode");
        TextInputLayout textInputLayout = this.binding.f210b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailCountryCodeWrap");
        ViewExtensions.setText(textInputLayout, countryCode.getPhoneCountryCode());
    }

    public final void setHint(CharSequence hint) {
        TextInputLayout textInputLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        textInputLayout.setHint(hint);
    }

    public final void setMode(Mode mode) {
        Intrinsics3.checkNotNullParameter(mode, "mode");
        this.mode = mode;
        c();
        d();
    }

    public final void setText(CharSequence text) {
        TextInputLayout textInputLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneOrEmailMainInputWrap");
        ViewExtensions.setText(textInputLayout, text);
        f();
    }
}
