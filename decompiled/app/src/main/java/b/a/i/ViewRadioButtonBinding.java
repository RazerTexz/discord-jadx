package b.a.i;

import android.view.View;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewRadioButtonBinding.java */
/* renamed from: b.a.i.d3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewRadioButtonBinding implements ViewBinding {

    @NonNull
    public final RadioButton a;

    public ViewRadioButtonBinding(@NonNull RadioButton radioButton) {
        this.a = radioButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
