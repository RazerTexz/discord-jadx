package b.a.i;

import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;

/* compiled from: ReactionViewBinding.java */
/* renamed from: b.a.i.i1, reason: use source file name */
/* loaded from: classes.dex */
public final class ReactionViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f132b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextSwitcher d;

    @NonNull
    public final SimpleDraweeSpanTextView e;

    public ReactionViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextSwitcher textSwitcher, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView) {
        this.a = view;
        this.f132b = textView;
        this.c = textView2;
        this.d = textSwitcher;
        this.e = simpleDraweeSpanTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
