package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: GuildBoostUpgradeDialogBinding.java */
/* renamed from: b.a.i.v, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildBoostUpgradeDialogBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f213b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final MaterialButton f;

    public GuildBoostUpgradeDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull MaterialButton materialButton) {
        this.a = relativeLayout;
        this.f213b = textView;
        this.c = imageView;
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
