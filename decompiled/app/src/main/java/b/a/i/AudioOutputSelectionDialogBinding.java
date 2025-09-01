package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.radiobutton.MaterialRadioButton;

/* compiled from: AudioOutputSelectionDialogBinding.java */
/* renamed from: b.a.i.b, reason: use source file name */
/* loaded from: classes.dex */
public final class AudioOutputSelectionDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialRadioButton f80b;

    @NonNull
    public final RadioGroup c;

    @NonNull
    public final MaterialRadioButton d;

    @NonNull
    public final MaterialRadioButton e;

    @NonNull
    public final MaterialRadioButton f;

    public AudioOutputSelectionDialogBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialRadioButton materialRadioButton, @NonNull TextView textView, @NonNull RadioGroup radioGroup, @NonNull MaterialRadioButton materialRadioButton2, @NonNull MaterialRadioButton materialRadioButton3, @NonNull MaterialRadioButton materialRadioButton4) {
        this.a = linearLayout;
        this.f80b = materialRadioButton;
        this.c = radioGroup;
        this.d = materialRadioButton2;
        this.e = materialRadioButton3;
        this.f = materialRadioButton4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
