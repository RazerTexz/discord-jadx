package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: WidgetRemoteAuthNotFoundBinding.java */
/* renamed from: b.a.i.v5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetRemoteAuthNotFoundBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f219b;

    public WidgetRemoteAuthNotFoundBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton) {
        this.a = linearLayout;
        this.f219b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
