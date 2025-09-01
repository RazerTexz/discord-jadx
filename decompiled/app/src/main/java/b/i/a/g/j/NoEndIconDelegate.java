package b.i.a.g.j;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: NoEndIconDelegate.java */
/* renamed from: b.i.a.g.j.o, reason: use source file name */
/* loaded from: classes3.dex */
public class NoEndIconDelegate extends EndIconDelegate {
    public NoEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // b.i.a.g.j.EndIconDelegate
    public void a() {
        this.a.setEndIconOnClickListener(null);
        this.a.setEndIconDrawable((Drawable) null);
        this.a.setEndIconContentDescription((CharSequence) null);
    }
}
