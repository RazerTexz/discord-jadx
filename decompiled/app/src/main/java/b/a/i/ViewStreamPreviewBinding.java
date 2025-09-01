package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ViewStreamPreviewBinding.java */
/* renamed from: b.a.i.z3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewStreamPreviewBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f240b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public ViewStreamPreviewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f240b = simpleDraweeView;
        this.c = textView;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
