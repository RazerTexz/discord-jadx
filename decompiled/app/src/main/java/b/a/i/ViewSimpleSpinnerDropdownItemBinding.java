package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewSimpleSpinnerDropdownItemBinding.java */
/* renamed from: b.a.i.u3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewSimpleSpinnerDropdownItemBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    public ViewSimpleSpinnerDropdownItemBinding(@NonNull TextView textView) {
        this.a = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
