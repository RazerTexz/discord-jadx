package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: CameraCapacityDialogBinding.java */
/* renamed from: b.a.i.e, reason: use source file name */
/* loaded from: classes.dex */
public final class CameraCapacityDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f102b;

    @NonNull
    public final MaterialButton c;

    public CameraCapacityDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout2) {
        this.a = linearLayout;
        this.f102b = textView;
        this.c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
