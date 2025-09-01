package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class ThreadBrowserItemHeaderBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2158b;

    public ThreadBrowserItemHeaderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f2158b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
