package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.google.android.material.button.MaterialButton;

/* compiled from: LayoutContactSyncAddPhoneBinding.java */
/* renamed from: b.a.i.j0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutContactSyncAddPhoneBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final PhoneOrEmailInputView f138b;

    @NonNull
    public final MaterialButton c;

    public LayoutContactSyncAddPhoneBinding(@NonNull ConstraintLayout constraintLayout, @NonNull PhoneOrEmailInputView phoneOrEmailInputView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f138b = phoneOrEmailInputView;
        this.c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
