package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetSettingsItemBackupCodeHeaderBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2624b;

    public WidgetSettingsItemBackupCodeHeaderBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.a = textView;
        this.f2624b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
