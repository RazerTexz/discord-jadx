package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: WidgetPremiumUpsellBinding.java */
/* renamed from: b.a.i.u5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetPremiumUpsellBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f212b;

    @NonNull
    public final TextView c;

    @NonNull
    public final ImageView d;

    public WidgetPremiumUpsellBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.a = linearLayout;
        this.f212b = textView;
        this.c = textView2;
        this.d = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
