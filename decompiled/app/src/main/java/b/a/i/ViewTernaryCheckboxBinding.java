package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckableImageView;

/* compiled from: ViewTernaryCheckboxBinding.java */
/* renamed from: b.a.i.a4, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewTernaryCheckboxBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77b;

    @NonNull
    public final View c;

    @NonNull
    public final View d;

    @NonNull
    public final TextView e;

    @NonNull
    public final LinkifiedTextView f;

    @NonNull
    public final CheckableImageView g;

    @NonNull
    public final CheckableImageView h;

    @NonNull
    public final CheckableImageView i;

    public ViewTernaryCheckboxBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout2, @NonNull View view, @NonNull View view2, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull CheckableImageView checkableImageView, @NonNull CheckableImageView checkableImageView2, @NonNull CheckableImageView checkableImageView3) {
        this.a = linearLayout;
        this.f77b = frameLayout;
        this.c = view;
        this.d = view2;
        this.e = textView;
        this.f = linkifiedTextView;
        this.g = checkableImageView;
        this.h = checkableImageView2;
        this.i = checkableImageView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
