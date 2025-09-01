package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetDirectoryCategoryBinding implements ViewBinding {

    @NonNull
    public final RecyclerView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f2364b;

    public WidgetDirectoryCategoryBinding(@NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.a = recyclerView;
        this.f2364b = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
