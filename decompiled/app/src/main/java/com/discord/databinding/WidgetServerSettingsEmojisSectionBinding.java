package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetServerSettingsEmojisSectionBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2566b;

    public WidgetServerSettingsEmojisSectionBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f2566b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
