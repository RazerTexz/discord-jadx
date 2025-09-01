package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: AllowAccessibilityDetectionDialogBinding.java */
/* renamed from: b.a.i.a, reason: use source file name */
/* loaded from: classes.dex */
public final class AllowAccessibilityDetectionDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f72b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final MaterialButton d;

    public AllowAccessibilityDetectionDialogBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f72b = textView;
        this.c = materialButton;
        this.d = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
