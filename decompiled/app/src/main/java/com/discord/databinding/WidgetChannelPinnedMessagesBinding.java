package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetChannelPinnedMessagesBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f2265b;

    public WidgetChannelPinnedMessagesBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView) {
        this.a = coordinatorLayout;
        this.f2265b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
