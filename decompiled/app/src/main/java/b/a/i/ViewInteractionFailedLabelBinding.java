package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewInteractionFailedLabelBinding.java */
/* renamed from: b.a.i.m2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewInteractionFailedLabelBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f159b;

    public ViewInteractionFailedLabelBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f159b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
