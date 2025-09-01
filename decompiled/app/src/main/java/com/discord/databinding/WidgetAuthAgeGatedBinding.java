package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetAuthAgeGatedBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2229b;

    public WidgetAuthAgeGatedBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull LinkifiedTextView linkifiedTextView) {
        this.a = coordinatorLayout;
        this.f2229b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
