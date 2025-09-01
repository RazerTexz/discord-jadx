package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.checkbox.MaterialCheckBox;

/* compiled from: ViewSettingCheckBinding.java */
/* renamed from: b.a.i.p3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewSettingCheckBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialCheckBox f180b;

    @NonNull
    public final ConstraintLayout c;

    public ViewSettingCheckBinding(@NonNull View view, @NonNull MaterialCheckBox materialCheckBox, @NonNull ConstraintLayout constraintLayout) {
        this.a = view;
        this.f180b = materialCheckBox;
        this.c = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
