package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: LayoutContactSyncNameInputBinding.java */
/* renamed from: b.a.i.l0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutContactSyncNameInputBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextInputEditText f150b;

    @NonNull
    public final TextInputLayout c;

    @NonNull
    public final LoadingButton d;

    @NonNull
    public final TextView e;

    public LayoutContactSyncNameInputBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = constraintLayout;
        this.f150b = textInputEditText;
        this.c = textInputLayout;
        this.d = loadingButton;
        this.e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
