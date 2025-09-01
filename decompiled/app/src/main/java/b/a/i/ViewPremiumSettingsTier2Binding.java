package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: ViewPremiumSettingsTier2Binding.java */
/* renamed from: b.a.i.b3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewPremiumSettingsTier2Binding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f84b;

    public ViewPremiumSettingsTier2Binding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull MaterialButton materialButton) {
        this.a = linearLayout;
        this.f84b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
