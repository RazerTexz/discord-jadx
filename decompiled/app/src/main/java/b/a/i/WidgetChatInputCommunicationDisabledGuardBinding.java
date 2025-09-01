package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;

/* compiled from: WidgetChatInputCommunicationDisabledGuardBinding.java */
/* renamed from: b.a.i.t4, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetChatInputCommunicationDisabledGuardBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f205b;

    @NonNull
    public final TextView c;

    public WidgetChatInputCommunicationDisabledGuardBinding(@NonNull RelativeLayout relativeLayout, @NonNull CardView cardView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = relativeLayout;
        this.f205b = textView2;
        this.c = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
