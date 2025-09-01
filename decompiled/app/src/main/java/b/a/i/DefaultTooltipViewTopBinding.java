package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* compiled from: DefaultTooltipViewTopBinding.java */
/* renamed from: b.a.i.j, reason: use source file name */
/* loaded from: classes.dex */
public final class DefaultTooltipViewTopBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f137b;

    public DefaultTooltipViewTopBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f137b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
