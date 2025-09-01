package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.ChatActionItem;

/* compiled from: WidgetDirectoryChannelEmptyBinding.java */
/* renamed from: b.a.i.d5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetDirectoryChannelEmptyBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f100b;

    @NonNull
    public final ChatActionItem c;

    @NonNull
    public final ChatActionItem d;

    public WidgetDirectoryChannelEmptyBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull ChatActionItem chatActionItem, @NonNull ChatActionItem chatActionItem2) {
        this.a = linearLayout;
        this.f100b = textView;
        this.c = chatActionItem;
        this.d = chatActionItem2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
