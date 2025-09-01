package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: DirectoryChannelTabBinding.java */
/* renamed from: b.a.i.m, reason: use source file name */
/* loaded from: classes.dex */
public final class DirectoryChannelTabBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f156b;

    public DirectoryChannelTabBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.a = textView;
        this.f156b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
