package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: WidgetDiscoveryOtherSpeakersCountBinding.java */
/* renamed from: b.a.i.f5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetDiscoveryOtherSpeakersCountBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f114b;

    public WidgetDiscoveryOtherSpeakersCountBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f114b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
