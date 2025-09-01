package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* compiled from: WidgetHubEmailFlowConfirmationBinding.java */
/* renamed from: b.a.i.o5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetHubEmailFlowConfirmationBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkifiedTextView f176b;

    @NonNull
    public final TextView c;

    @NonNull
    public final LinkifiedTextView d;

    public WidgetHubEmailFlowConfirmationBinding(@NonNull NestedScrollView nestedScrollView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView2) {
        this.a = nestedScrollView;
        this.f176b = linkifiedTextView;
        this.c = textView;
        this.d = linkifiedTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
