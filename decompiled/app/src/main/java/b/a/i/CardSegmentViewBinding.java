package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: CardSegmentViewBinding.java */
/* renamed from: b.a.i.f, reason: use source file name */
/* loaded from: classes.dex */
public final class CardSegmentViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f109b;

    @NonNull
    public final TextView c;

    public CardSegmentViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = view;
        this.f109b = textView;
        this.c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
