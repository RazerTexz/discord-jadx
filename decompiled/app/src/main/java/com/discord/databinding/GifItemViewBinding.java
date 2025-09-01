package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class GifItemViewBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2112b;

    public GifItemViewBinding(@NonNull CardView cardView, @NonNull SimpleDraweeView simpleDraweeView) {
        this.a = cardView;
        this.f2112b = simpleDraweeView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
