package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewCallEventsButtonBinding.java */
/* renamed from: b.a.i.a2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewCallEventsButtonBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f75b;

    @NonNull
    public final TextView c;

    public ViewCallEventsButtonBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f75b = imageView;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
