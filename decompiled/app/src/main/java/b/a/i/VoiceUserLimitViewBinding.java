package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* compiled from: VoiceUserLimitViewBinding.java */
/* renamed from: b.a.i.k4, reason: use source file name */
/* loaded from: classes.dex */
public final class VoiceUserLimitViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f148b;

    @NonNull
    public final TextView c;

    public VoiceUserLimitViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = view;
        this.f148b = textView;
        this.c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
