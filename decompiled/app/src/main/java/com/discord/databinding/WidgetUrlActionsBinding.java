package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetUrlActionsBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2678b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public WidgetUrlActionsBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.a = linearLayout;
        this.f2678b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
