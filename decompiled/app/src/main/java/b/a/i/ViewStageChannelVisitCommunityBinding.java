package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ViewStageChannelVisitCommunityBinding.java */
/* renamed from: b.a.i.x3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewStageChannelVisitCommunityBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f229b;

    @NonNull
    public final TextView c;

    public ViewStageChannelVisitCommunityBinding(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f229b = simpleDraweeView;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
