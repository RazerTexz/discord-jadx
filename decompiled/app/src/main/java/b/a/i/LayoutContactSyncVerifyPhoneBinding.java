package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CodeVerificationView;

/* compiled from: LayoutContactSyncVerifyPhoneBinding.java */
/* renamed from: b.a.i.p0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutContactSyncVerifyPhoneBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final CodeVerificationView f177b;

    public LayoutContactSyncVerifyPhoneBinding(@NonNull ConstraintLayout constraintLayout, @NonNull CodeVerificationView codeVerificationView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f177b = codeVerificationView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
