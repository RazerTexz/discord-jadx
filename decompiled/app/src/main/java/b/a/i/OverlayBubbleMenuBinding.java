package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.OverlayMenuView;

/* compiled from: OverlayBubbleMenuBinding.java */
/* renamed from: b.a.i.y0, reason: use source file name */
/* loaded from: classes.dex */
public final class OverlayBubbleMenuBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f233b;

    @NonNull
    public final View c;

    @NonNull
    public final TextView d;

    @NonNull
    public final RecyclerView e;

    @NonNull
    public final OverlayMenuView f;

    public OverlayBubbleMenuBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull View view, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull OverlayMenuView overlayMenuView) {
        this.a = linearLayout;
        this.f233b = linearLayout2;
        this.c = view;
        this.d = textView;
        this.e = recyclerView;
        this.f = overlayMenuView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
