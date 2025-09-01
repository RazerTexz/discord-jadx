package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: IntegrationSyncSettingsBinding.java */
/* renamed from: b.a.i.d0, reason: use source file name */
/* loaded from: classes.dex */
public final class IntegrationSyncSettingsBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f96b;

    @NonNull
    public final TextView c;

    @NonNull
    public final RelativeLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final RelativeLayout f;

    public IntegrationSyncSettingsBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView3, @NonNull RelativeLayout relativeLayout2) {
        this.a = linearLayout;
        this.f96b = textView;
        this.c = textView2;
        this.d = relativeLayout;
        this.e = textView3;
        this.f = relativeLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
