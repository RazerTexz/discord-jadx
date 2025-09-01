package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* compiled from: DefaultTooltipViewBottomBinding.java */
/* renamed from: b.a.i.i, reason: use source file name */
/* loaded from: classes.dex */
public final class DefaultTooltipViewBottomBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f130b;

    public DefaultTooltipViewBottomBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f130b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
