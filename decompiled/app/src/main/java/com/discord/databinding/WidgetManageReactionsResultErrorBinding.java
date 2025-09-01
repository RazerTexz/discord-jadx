package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetManageReactionsResultErrorBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2484b;

    public WidgetManageReactionsResultErrorBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.a = relativeLayout;
        this.f2484b = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
