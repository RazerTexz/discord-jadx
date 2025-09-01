package b.a.y;

import android.widget.SeekBar;
import d0.z.d.Intrinsics3;

/* compiled from: OnSeekBarChangeListenerAdapter.kt */
/* renamed from: b.a.y.j, reason: use source file name */
/* loaded from: classes2.dex */
public class OnSeekBarChangeListenerAdapter implements SeekBar.OnSeekBarChangeListener {
    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
        Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
    }
}
