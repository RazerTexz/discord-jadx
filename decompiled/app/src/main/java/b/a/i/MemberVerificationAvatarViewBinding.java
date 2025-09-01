package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: MemberVerificationAvatarViewBinding.java */
/* renamed from: b.a.i.v0, reason: use source file name */
/* loaded from: classes.dex */
public final class MemberVerificationAvatarViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f214b;

    @NonNull
    public final TextView c;

    public MemberVerificationAvatarViewBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.a = view;
        this.f214b = simpleDraweeView;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
