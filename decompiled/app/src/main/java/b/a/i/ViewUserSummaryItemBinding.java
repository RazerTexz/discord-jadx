package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.discord.views.CutoutView;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ViewUserSummaryItemBinding.java */
/* renamed from: b.a.i.f4, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewUserSummaryItemBinding implements ViewBinding {

    @NonNull
    public final CutoutView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f113b;

    public ViewUserSummaryItemBinding(@NonNull CutoutView cutoutView, @NonNull SimpleDraweeView simpleDraweeView) {
        this.a = cutoutView;
        this.f113b = simpleDraweeView;
    }

    @NonNull
    public static ViewUserSummaryItemBinding a(@NonNull View view) {
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.avatar);
        if (simpleDraweeView != null) {
            return new ViewUserSummaryItemBinding((CutoutView) view, simpleDraweeView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.avatar)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
