package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* compiled from: ViewUserListItemBinding.java */
/* renamed from: b.a.i.d4, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewUserListItemBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f99b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final StatusView e;

    public ViewUserListItemBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull StatusView statusView) {
        this.a = view;
        this.f99b = simpleDraweeView;
        this.c = textView;
        this.d = textView2;
        this.e = statusView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
