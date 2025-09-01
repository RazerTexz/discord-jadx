package b.a.i;

import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* compiled from: DialogDatePickerBinding.java */
/* renamed from: b.a.i.k, reason: use source file name */
/* loaded from: classes.dex */
public final class DialogDatePickerBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f143b;

    @NonNull
    public final DatePicker c;

    @NonNull
    public final TextView d;

    public DialogDatePickerBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull DatePicker datePicker, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f143b = materialButton;
        this.c = datePicker;
        this.d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
