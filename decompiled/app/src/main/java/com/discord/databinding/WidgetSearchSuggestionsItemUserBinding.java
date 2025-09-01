package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.UserListItemView;

/* loaded from: classes.dex */
public final class WidgetSearchSuggestionsItemUserBinding implements ViewBinding {

    @NonNull
    public final UserListItemView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final UserListItemView f2531b;

    public WidgetSearchSuggestionsItemUserBinding(@NonNull UserListItemView userListItemView, @NonNull UserListItemView userListItemView2) {
        this.a = userListItemView;
        this.f2531b = userListItemView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
