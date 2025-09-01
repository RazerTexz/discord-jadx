package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewGenericLoadingBinding.java */
/* renamed from: b.a.i.j2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewGenericLoadingBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    public ViewGenericLoadingBinding(@NonNull FrameLayout frameLayout) {
        this.a = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
