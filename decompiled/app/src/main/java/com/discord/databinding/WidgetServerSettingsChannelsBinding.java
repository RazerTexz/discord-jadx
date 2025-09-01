package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public final class WidgetServerSettingsChannelsBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final DimmerView f2550b;

    @NonNull
    public final FloatingActionButton c;

    @NonNull
    public final RecyclerView d;

    public WidgetServerSettingsChannelsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull FloatingActionButton floatingActionButton, @NonNull RecyclerView recyclerView, @NonNull FrameLayout frameLayout) {
        this.a = coordinatorLayout;
        this.f2550b = dimmerView;
        this.c = floatingActionButton;
        this.d = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
