package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CutoutView;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ViewPileItemBinding.java */
/* renamed from: b.a.i.v2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewPileItemBinding implements ViewBinding {

    @NonNull
    public final CutoutView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f216b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final TextView d;

    public ViewPileItemBinding(@NonNull CutoutView cutoutView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView) {
        this.a = cutoutView;
        this.f216b = simpleDraweeView;
        this.c = simpleDraweeView2;
        this.d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
