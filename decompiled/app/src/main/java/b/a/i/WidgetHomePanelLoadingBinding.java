package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: WidgetHomePanelLoadingBinding.java */
/* renamed from: b.a.i.m5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetHomePanelLoadingBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f162b;

    public WidgetHomePanelLoadingBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView) {
        this.a = frameLayout;
        this.f162b = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
