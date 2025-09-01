package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: ViewServerSettingsUploadBannerAnimatedUpsellBinding.java */
/* renamed from: b.a.i.m3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewServerSettingsUploadBannerAnimatedUpsellBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f160b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final TextView d;

    public ViewServerSettingsUploadBannerAnimatedUpsellBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout2, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f160b = materialButton;
        this.c = linearLayout2;
        this.d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
