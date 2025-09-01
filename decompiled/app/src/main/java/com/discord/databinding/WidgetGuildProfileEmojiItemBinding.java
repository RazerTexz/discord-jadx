package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class WidgetGuildProfileEmojiItemBinding implements ViewBinding {

    @NonNull
    public final SimpleDraweeView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2430b;

    public WidgetGuildProfileEmojiItemBinding(@NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2) {
        this.a = simpleDraweeView;
        this.f2430b = simpleDraweeView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
