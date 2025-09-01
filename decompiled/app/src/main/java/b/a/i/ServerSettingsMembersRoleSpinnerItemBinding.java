package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: ServerSettingsMembersRoleSpinnerItemBinding.java */
/* renamed from: b.a.i.k1, reason: use source file name */
/* loaded from: classes.dex */
public final class ServerSettingsMembersRoleSpinnerItemBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f145b;

    public ServerSettingsMembersRoleSpinnerItemBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.a = textView;
        this.f145b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
