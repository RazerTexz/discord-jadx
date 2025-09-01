package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* compiled from: WidgetBlockRussianPurchasesDialogBinding.java */
/* renamed from: b.a.i.o4, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetBlockRussianPurchasesDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkifiedTextView f175b;

    @NonNull
    public final MaterialButton c;

    public WidgetBlockRussianPurchasesDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull MaterialButton materialButton) {
        this.a = linearLayout;
        this.f175b = linkifiedTextView;
        this.c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
