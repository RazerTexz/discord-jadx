package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetChatListAdapterItemBlockedBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2312b;

    public WidgetChatListAdapterItemBlockedBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView) {
        this.a = relativeLayout;
        this.f2312b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
