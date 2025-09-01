package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.steps.StepsView;

/* loaded from: classes.dex */
public final class WidgetCreateGuildRoleSubscriptionTierBinding implements ViewBinding {

    @NonNull
    public final StepsView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final StepsView f2359b;

    public WidgetCreateGuildRoleSubscriptionTierBinding(@NonNull StepsView stepsView, @NonNull StepsView stepsView2) {
        this.a = stepsView;
        this.f2359b = stepsView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
