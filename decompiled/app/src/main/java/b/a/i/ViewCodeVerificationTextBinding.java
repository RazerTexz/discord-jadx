package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewCodeVerificationTextBinding.java */
/* renamed from: b.a.i.g2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewCodeVerificationTextBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    public ViewCodeVerificationTextBinding(@NonNull TextView textView) {
        this.a = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
