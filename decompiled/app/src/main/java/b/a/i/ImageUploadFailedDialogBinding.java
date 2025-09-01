package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* compiled from: ImageUploadFailedDialogBinding.java */
/* renamed from: b.a.i.c0, reason: use source file name */
/* loaded from: classes.dex */
public final class ImageUploadFailedDialogBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f89b;

    @NonNull
    public final SwitchMaterial c;

    @NonNull
    public final RelativeLayout d;

    @NonNull
    public final View e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final RelativeLayout g;

    @NonNull
    public final MaterialButton h;

    @NonNull
    public final MaterialButton i;

    @NonNull
    public final TextView j;

    public ImageUploadFailedDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull SwitchMaterial switchMaterial, @NonNull RelativeLayout relativeLayout2, @NonNull View view, @NonNull MaterialButton materialButton2, @NonNull RelativeLayout relativeLayout3, @NonNull MaterialButton materialButton3, @NonNull MaterialButton materialButton4, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = relativeLayout;
        this.f89b = materialButton;
        this.c = switchMaterial;
        this.d = relativeLayout2;
        this.e = view;
        this.f = materialButton2;
        this.g = relativeLayout3;
        this.h = materialButton3;
        this.i = materialButton4;
        this.j = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
