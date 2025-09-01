package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewPremiumUpsellInfoBinding.java */
/* renamed from: b.a.i.c3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewPremiumUpsellInfoBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f92b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public ViewPremiumUpsellInfoBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = linearLayout;
        this.f92b = textView;
        this.c = textView2;
        this.d = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
