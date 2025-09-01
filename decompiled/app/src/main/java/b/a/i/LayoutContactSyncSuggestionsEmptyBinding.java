package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: LayoutContactSyncSuggestionsEmptyBinding.java */
/* renamed from: b.a.i.n0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutContactSyncSuggestionsEmptyBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f164b;

    @NonNull
    public final MaterialButton c;

    public LayoutContactSyncSuggestionsEmptyBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2) {
        this.a = constraintLayout;
        this.f164b = materialButton;
        this.c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
