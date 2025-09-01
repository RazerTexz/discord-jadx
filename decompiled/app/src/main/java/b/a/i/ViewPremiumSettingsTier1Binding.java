package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: ViewPremiumSettingsTier1Binding.java */
/* renamed from: b.a.i.a3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewPremiumSettingsTier1Binding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f76b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public ViewPremiumSettingsTier1Binding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f76b = materialButton;
        this.c = textView;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
