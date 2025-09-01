package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class VoiceUserListItemHeaderBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2221b;

    public VoiceUserListItemHeaderBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.a = textView;
        this.f2221b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
