package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetServerSettingsSecurityBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2586b;

    @NonNull
    public final MaterialButton c;

    public WidgetServerSettingsSecurityBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialButton materialButton) {
        this.a = coordinatorLayout;
        this.f2586b = textView;
        this.c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
