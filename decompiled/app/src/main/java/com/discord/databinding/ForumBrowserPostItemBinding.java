package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.forums.ForumBrowserPostView;

/* loaded from: classes.dex */
public final class ForumBrowserPostItemBinding implements ViewBinding {

    @NonNull
    public final ForumBrowserPostView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ForumBrowserPostView f2108b;

    public ForumBrowserPostItemBinding(@NonNull ForumBrowserPostView forumBrowserPostView, @NonNull ForumBrowserPostView forumBrowserPostView2) {
        this.a = forumBrowserPostView;
        this.f2108b = forumBrowserPostView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
