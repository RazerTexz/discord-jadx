package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetUserMutualFriendsBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f2684b;

    public WidgetUserMutualFriendsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView) {
        this.a = coordinatorLayout;
        this.f2684b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
