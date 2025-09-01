package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: PremiumUpgradeYearlyDialogBinding.java */
/* renamed from: b.a.i.f1, reason: use source file name */
/* loaded from: classes.dex */
public final class PremiumUpgradeYearlyDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f111b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final MaterialButton f;

    public PremiumUpgradeYearlyDialogBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull MaterialButton materialButton) {
        this.a = linearLayout;
        this.f111b = imageView;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
