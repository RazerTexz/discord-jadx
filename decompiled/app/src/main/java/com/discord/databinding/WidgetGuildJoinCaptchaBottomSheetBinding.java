package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetGuildJoinCaptchaBottomSheetBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2424b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final TextView d;

    public WidgetGuildJoinCaptchaBottomSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.a = nestedScrollView;
        this.f2424b = textView;
        this.c = materialButton;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
