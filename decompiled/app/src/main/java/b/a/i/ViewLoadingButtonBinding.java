package b.a.i;

import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: ViewLoadingButtonBinding.java */
/* renamed from: b.a.i.n2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewLoadingButtonBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f166b;

    @NonNull
    public final ProgressBar c;

    public ViewLoadingButtonBinding(@NonNull View view, @NonNull MaterialButton materialButton, @NonNull ProgressBar progressBar) {
        this.a = view;
        this.f166b = materialButton;
        this.c = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
