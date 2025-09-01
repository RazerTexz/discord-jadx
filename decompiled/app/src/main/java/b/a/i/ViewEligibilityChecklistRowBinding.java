package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* compiled from: ViewEligibilityChecklistRowBinding.java */
/* renamed from: b.a.i.h2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewEligibilityChecklistRowBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkifiedTextView f125b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    public ViewEligibilityChecklistRowBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.a = constraintLayout;
        this.f125b = linkifiedTextView;
        this.c = imageView;
        this.d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
