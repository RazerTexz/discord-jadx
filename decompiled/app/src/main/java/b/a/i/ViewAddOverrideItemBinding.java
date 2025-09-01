package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewAddOverrideItemBinding.java */
/* renamed from: b.a.i.z1, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewAddOverrideItemBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    public ViewAddOverrideItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull Guideline guideline, @NonNull ImageView imageView) {
        this.a = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
