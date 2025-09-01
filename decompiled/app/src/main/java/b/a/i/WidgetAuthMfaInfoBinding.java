package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* compiled from: WidgetAuthMfaInfoBinding.java */
/* renamed from: b.a.i.n4, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetAuthMfaInfoBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f168b;

    @NonNull
    public final LinkifiedTextView c;

    public WidgetAuthMfaInfoBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull LinkifiedTextView linkifiedTextView) {
        this.a = linearLayout;
        this.f168b = materialButton;
        this.c = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
