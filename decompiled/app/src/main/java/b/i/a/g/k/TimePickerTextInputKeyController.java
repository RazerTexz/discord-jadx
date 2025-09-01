package b.i.a.g.k;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.TimeModel;

/* compiled from: TimePickerTextInputKeyController.java */
/* renamed from: b.i.a.g.k.h, reason: use source file name */
/* loaded from: classes3.dex */
public class TimePickerTextInputKeyController implements TextView.OnEditorActionListener, View.OnKeyListener {
    public final ChipTextInputComboView j;
    public final ChipTextInputComboView k;
    public final TimeModel l;
    public boolean m = false;

    public TimePickerTextInputKeyController(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.j = chipTextInputComboView;
        this.k = chipTextInputComboView2;
        this.l = timeModel;
    }

    public final void a(int i) {
        this.k.setChecked(i == 12);
        this.j.setChecked(i == 10);
        this.l.o = i;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z2 = i == 5;
        if (z2) {
            a(12);
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    @Override // android.view.View.OnKeyListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.m) {
            return false;
        }
        boolean z2 = true;
        this.m = true;
        EditText editText = (EditText) view;
        if (this.l.o == 12) {
            if (i == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
                a(10);
            } else {
                z2 = false;
            }
        } else {
            Editable text = editText.getText();
            if (text != null) {
                if (i >= 7 && i <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
                    a(12);
                }
            }
        }
        this.m = false;
        return z2;
    }
}
