package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: OverlayVoiceBubbleBinding.java */
/* renamed from: b.a.i.a1, reason: use source file name */
/* loaded from: classes.dex */
public final class OverlayVoiceBubbleBinding implements ViewBinding {

    @NonNull
    public final SimpleDraweeView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f74b;

    public OverlayVoiceBubbleBinding(@NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeView simpleDraweeView2) {
        this.a = simpleDraweeView;
        this.f74b = simpleDraweeView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
