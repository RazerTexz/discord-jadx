package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.viewbinding.ViewBinding;
import b.a.i.ViewCodeVerificationBinding;
import b.a.i.ViewCodeVerificationSpaceBinding;
import b.a.i.ViewCodeVerificationTextBinding;
import b.a.y.CodeVerificationView2;
import b.a.y.CodeVerificationView3;
import b.a.y.CodeVerificationView4;
import b.a.y.CodeVerificationView5;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.flexbox.FlexboxLayout;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CodeVerificationView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001>J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\bR\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010\u0003\u001a\u00020(2\u0006\u0010)\u001a\u00020(8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R.\u00105\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00040.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010&R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010+¨\u0006?"}, d2 = {"Lcom/discord/views/CodeVerificationView;", "Landroid/widget/LinearLayout;", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "", "setCode", "(Ljava/lang/CharSequence;)V", "b", "()V", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;", "", "onCheckIsTextEditor", "()Z", "", "char", "c", "(C)V", "d", "e", "Lcom/discord/views/CodeVerificationView$a;", "o", "Lcom/discord/views/CodeVerificationView$a;", "inputType", "", "getInputLength", "()I", "inputLength", "", "Landroid/widget/TextView;", "l", "Ljava/util/List;", "characterViews", "Landroid/graphics/drawable/Drawable;", "n", "Landroid/graphics/drawable/Drawable;", "charBackgroundDrawableFocused", "", "<set-?>", "q", "Ljava/lang/String;", "getCode", "()Ljava/lang/String;", "Lkotlin/Function1;", "r", "Lkotlin/jvm/functions/Function1;", "getOnCodeEntered", "()Lkotlin/jvm/functions/Function1;", "setOnCodeEntered", "(Lkotlin/jvm/functions/Function1;)V", "onCodeEntered", "m", "charBackgroundDrawableUnfocused", "Lb/a/i/e2;", "k", "Lb/a/i/e2;", "binding", "p", "inputFormat", "a", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class CodeVerificationView extends LinearLayout {
    public static final a j = a.NUMERIC;

    /* renamed from: k, reason: from kotlin metadata */
    public final ViewCodeVerificationBinding binding;

    /* renamed from: l, reason: from kotlin metadata */
    public final List<TextView> characterViews;

    /* renamed from: m, reason: from kotlin metadata */
    public final Drawable charBackgroundDrawableUnfocused;

    /* renamed from: n, reason: from kotlin metadata */
    public final Drawable charBackgroundDrawableFocused;

    /* renamed from: o, reason: from kotlin metadata */
    public a inputType;

    /* renamed from: p, reason: from kotlin metadata */
    public String inputFormat;

    /* renamed from: q, reason: from kotlin metadata */
    public String code;

    /* renamed from: r, reason: from kotlin metadata */
    public Function1<? super String, Unit> onCodeEntered;

    /* compiled from: CodeVerificationView.kt */
    public enum a {
        NUMERIC,
        ALPHANUMERIC;

        public static final C0232a n = new C0232a(null);
        public static final a[] m = values();

        /* compiled from: CodeVerificationView.kt */
        /* renamed from: com.discord.views.CodeVerificationView$a$a, reason: collision with other inner class name */
        public static final class C0232a {
            public C0232a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeVerificationView(Context context, AttributeSet attributeSet) {
        ViewBinding viewCodeVerificationSpaceBinding;
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_code_verification, (ViewGroup) this, false);
        addView(viewInflate);
        Objects.requireNonNull(viewInflate, "rootView");
        FlexboxLayout flexboxLayout = (FlexboxLayout) viewInflate;
        ViewCodeVerificationBinding viewCodeVerificationBinding = new ViewCodeVerificationBinding(flexboxLayout, flexboxLayout);
        Intrinsics3.checkNotNullExpressionValue(viewCodeVerificationBinding, "ViewCodeVerificationBind…rom(context), this, true)");
        this.binding = viewCodeVerificationBinding;
        this.code = "";
        this.onCodeEntered = CodeVerificationView5.j;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.CodeVerificationView, 0, 0);
            Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…deVerificationView, 0, 0)");
            try {
                int i = typedArrayObtainStyledAttributes.getInt(1, j.ordinal());
                a.C0232a c0232a = a.n;
                this.inputType = a.m[i];
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (string == null) {
                    string = "xxx-xxx";
                }
                this.inputFormat = string;
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        setClickable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnFocusChangeListener(new CodeVerificationView2(this));
        setOnClickListener(new CodeVerificationView3(this));
        setOnKeyListener(new CodeVerificationView4(this));
        String str = this.inputFormat;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("inputFormat");
        }
        ArrayList arrayList = new ArrayList(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            String strValueOf = String.valueOf(cCharAt);
            int iHashCode = strValueOf.hashCode();
            if (iHashCode != 45) {
                if (iHashCode != 120 || !strValueOf.equals("x")) {
                    throw new IllegalStateException("Invalid format for " + cCharAt);
                }
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
                FlexboxLayout flexboxLayout2 = this.binding.f104b;
                View viewInflate2 = layoutInflaterFrom.inflate(R.layout.view_code_verification_text, (ViewGroup) flexboxLayout2, false);
                flexboxLayout2.addView(viewInflate2);
                Objects.requireNonNull(viewInflate2, "rootView");
                viewCodeVerificationSpaceBinding = new ViewCodeVerificationTextBinding((TextView) viewInflate2);
                Intrinsics3.checkNotNullExpressionValue(viewCodeVerificationSpaceBinding, "ViewCodeVerificationText…t), binding.layout, true)");
                arrayList.add(viewCodeVerificationSpaceBinding.getRoot());
            } else {
                if (!strValueOf.equals("-")) {
                    throw new IllegalStateException("Invalid format for " + cCharAt);
                }
                LayoutInflater layoutInflaterFrom2 = LayoutInflater.from(context);
                FlexboxLayout flexboxLayout3 = this.binding.f104b;
                View viewInflate3 = layoutInflaterFrom2.inflate(R.layout.view_code_verification_space, (ViewGroup) flexboxLayout3, false);
                flexboxLayout3.addView(viewInflate3);
                Objects.requireNonNull(viewInflate3, "rootView");
                viewCodeVerificationSpaceBinding = new ViewCodeVerificationSpaceBinding((Space) viewInflate3);
                Intrinsics3.checkNotNullExpressionValue(viewCodeVerificationSpaceBinding, "ViewCodeVerificationSpac…t), binding.layout, true)");
                arrayList.add(viewCodeVerificationSpaceBinding.getRoot());
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof TextView) {
                arrayList2.add(next);
            }
        }
        this.characterViews = arrayList2;
        ((TextView) arrayList2.get(0)).requestFocus();
        View view = (View) arrayList2.get(0);
        if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new b.a.y.a(this));
        } else {
            a(this);
        }
        this.charBackgroundDrawableUnfocused = ContextCompat.getDrawable(context, R.drawable.drawable_uikit_background_tertiary_button);
        this.charBackgroundDrawableFocused = ContextCompat.getDrawable(context, R.drawable.drawable_uikit_background_tertiary_button_outline);
        e();
    }

    public static final void a(CodeVerificationView codeVerificationView) {
        Object systemService = codeVerificationView.getContext().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(codeVerificationView, 2);
    }

    private final int getInputLength() {
        String str = this.inputFormat;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("inputFormat");
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (Intrinsics3.areEqual(String.valueOf(str.charAt(i2)), "x")) {
                i++;
            }
        }
        return i;
    }

    public final void b() {
        if (this.code.length() > 0) {
            this.code = "";
            d();
        }
    }

    public final void c(char c) {
        if (this.code.length() < getInputLength()) {
            this.code = this.code + c;
            d();
        }
    }

    public final void d() {
        int i = 0;
        for (Object obj : this.characterViews) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            TextView textView = (TextView) obj;
            if (i <= Strings4.getLastIndex(this.code)) {
                textView.setText(String.valueOf(this.code.charAt(i)));
            } else {
                textView.setText("");
            }
            i = i2;
        }
        if (this.code.length() == getInputLength()) {
            this.onCodeEntered.invoke(this.code);
        }
        e();
    }

    public final void e() {
        int iMin = Math.min(this.code.length(), Collections2.getLastIndex(this.characterViews));
        int i = 0;
        for (Object obj : this.characterViews) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            ((TextView) obj).setBackground(i == iMin ? this.charBackgroundDrawableFocused : this.charBackgroundDrawableUnfocused);
            i = i2;
        }
    }

    public final String getCode() {
        return this.code;
    }

    public final Function1<String, Unit> getOnCodeEntered() {
        return this.onCodeEntered;
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Intrinsics3.checkNotNullParameter(outAttrs, "outAttrs");
        a aVar = this.inputType;
        if (aVar == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("inputType");
        }
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            BaseInputConnection baseInputConnection = new BaseInputConnection(this, false);
            outAttrs.inputType = 18;
            return baseInputConnection;
        }
        if (iOrdinal != 1) {
            throw new NoWhenBranchMatchedException();
        }
        BaseInputConnection baseInputConnection2 = new BaseInputConnection(this, false);
        outAttrs.inputType = 4224;
        return baseInputConnection2;
    }

    public final void setCode(CharSequence code) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        String str = this.code;
        this.code = code.toString();
        if (!Intrinsics3.areEqual(str, r2)) {
            d();
        }
    }

    public final void setOnCodeEntered(Function1<? super String, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onCodeEntered = function1;
    }
}
