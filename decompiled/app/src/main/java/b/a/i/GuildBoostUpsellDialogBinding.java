package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: GuildBoostUpsellDialogBinding.java */
/* renamed from: b.a.i.w, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildBoostUpsellDialogBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f220b;

    @NonNull
    public final TextView c;

    @NonNull
    public final MaterialButton d;

    public GuildBoostUpsellDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull MaterialButton materialButton) {
        this.a = relativeLayout;
        this.f220b = imageView;
        this.c = textView;
        this.d = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
