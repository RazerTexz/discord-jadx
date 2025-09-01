package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* compiled from: ViewMobileReportBlockUserBinding.java */
/* renamed from: b.a.i.o2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewMobileReportBlockUserBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f173b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final TextView d;

    public ViewMobileReportBlockUserBinding(@NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = linearLayout;
        this.f173b = simpleDraweeView;
        this.c = materialButton;
        this.d = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
