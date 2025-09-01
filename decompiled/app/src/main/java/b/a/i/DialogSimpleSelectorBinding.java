package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.google.android.material.button.MaterialButton;

/* compiled from: DialogSimpleSelectorBinding.java */
/* renamed from: b.a.i.l, reason: use source file name */
/* loaded from: classes.dex */
public final class DialogSimpleSelectorBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f149b;

    @NonNull
    public final MaxHeightRecyclerView c;

    @NonNull
    public final TextView d;

    public DialogSimpleSelectorBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaxHeightRecyclerView maxHeightRecyclerView, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f149b = materialButton;
        this.c = maxHeightRecyclerView;
        this.d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
