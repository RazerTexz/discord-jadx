package b.i.a.g.k;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimePickerView;

/* compiled from: TimePickerView.java */
/* renamed from: b.i.a.g.k.l, reason: use source file name */
/* loaded from: classes3.dex */
public class TimePickerView3 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ TimePickerView j;

    public TimePickerView3(TimePickerView timePickerView) {
        this.j = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean zOnDoubleTap = super.onDoubleTap(motionEvent);
        TimePickerView.b bVar = this.j.r;
        if (bVar != null) {
            MaterialTimePicker.a aVar = (MaterialTimePicker.a) bVar;
            MaterialTimePicker.access$402(MaterialTimePicker.this, 1);
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            MaterialTimePicker.access$600(materialTimePicker, MaterialTimePicker.access$500(materialTimePicker));
            TimePickerTextInputPresenter timePickerTextInputPresenterAccess$700 = MaterialTimePicker.access$700(MaterialTimePicker.this);
            timePickerTextInputPresenterAccess$700.n.setChecked(timePickerTextInputPresenterAccess$700.k.o == 12);
            timePickerTextInputPresenterAccess$700.o.setChecked(timePickerTextInputPresenterAccess$700.k.o == 10);
        }
        return zOnDoubleTap;
    }
}
