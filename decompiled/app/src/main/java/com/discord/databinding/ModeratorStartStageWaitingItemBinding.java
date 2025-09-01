package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.user.UserSummaryView;

/* loaded from: classes.dex */
public final class ModeratorStartStageWaitingItemBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final UserSummaryView f2129b;

    @NonNull
    public final TextView c;

    public ModeratorStartStageWaitingItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull UserSummaryView userSummaryView, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f2129b = userSummaryView;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
