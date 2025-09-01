package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;

/* compiled from: WidgetHubEmailFlowWaitlistBinding.java */
/* renamed from: b.a.i.p5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetHubEmailFlowWaitlistBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f182b;

    public WidgetHubEmailFlowWaitlistBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView) {
        this.a = nestedScrollView;
        this.f182b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
