package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* compiled from: LayoutFullscreenCallPreviewEmptyBinding.java */
/* renamed from: b.a.i.q0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutFullscreenCallPreviewEmptyBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f183b;

    public LayoutFullscreenCallPreviewEmptyBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f183b = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
