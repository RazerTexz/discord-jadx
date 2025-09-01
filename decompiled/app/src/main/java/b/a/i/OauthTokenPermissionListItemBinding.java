package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: OauthTokenPermissionListItemBinding.java */
/* renamed from: b.a.i.x0, reason: use source file name */
/* loaded from: classes.dex */
public final class OauthTokenPermissionListItemBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    public OauthTokenPermissionListItemBinding(@NonNull TextView textView) {
        this.a = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
