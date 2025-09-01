package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetMemberVerificationParagraphItemBinding implements ViewBinding {

    @NonNull
    public final TextInputLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextInputEditText f2491b;

    public WidgetMemberVerificationParagraphItemBinding(@NonNull TextInputLayout textInputLayout, @NonNull TextInputEditText textInputEditText) {
        this.a = textInputLayout;
        this.f2491b = textInputEditText;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
