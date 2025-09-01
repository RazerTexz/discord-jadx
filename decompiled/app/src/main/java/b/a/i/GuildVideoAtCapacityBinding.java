package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: GuildVideoAtCapacityBinding.java */
/* renamed from: b.a.i.z, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildVideoAtCapacityBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f238b;

    public GuildVideoAtCapacityBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout2) {
        this.a = linearLayout;
        this.f238b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
