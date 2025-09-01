package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.premium.ShinyButton;
import com.google.android.material.button.MaterialButton;

/* compiled from: SingleValuePropPremiumUpsellDialogBinding.java */
/* renamed from: b.a.i.p1, reason: use source file name */
/* loaded from: classes.dex */
public final class SingleValuePropPremiumUpsellDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f178b;

    @NonNull
    public final ShinyButton c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ImageView f;

    public SingleValuePropPremiumUpsellDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull MaterialButton materialButton, @NonNull View view, @NonNull ShinyButton shinyButton, @NonNull View view2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.a = linearLayout;
        this.f178b = materialButton;
        this.c = shinyButton;
        this.d = textView;
        this.e = textView2;
        this.f = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
