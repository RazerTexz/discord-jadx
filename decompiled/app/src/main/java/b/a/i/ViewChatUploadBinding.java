package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* compiled from: ViewChatUploadBinding.java */
/* renamed from: b.a.i.c2, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewChatUploadBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f91b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    public ViewChatUploadBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f91b = textView;
        this.c = imageView2;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
