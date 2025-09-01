package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ChannelPermissionOwnerViewBinding.java */
/* renamed from: b.a.i.g, reason: use source file name */
/* loaded from: classes.dex */
public final class ChannelPermissionOwnerViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f116b;

    @NonNull
    public final TextView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final TextView e;

    public ChannelPermissionOwnerViewBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2) {
        this.a = view;
        this.f116b = imageView;
        this.c = textView;
        this.d = simpleDraweeView;
        this.e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
