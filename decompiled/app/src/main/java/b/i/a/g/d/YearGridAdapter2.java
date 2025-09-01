package b.i.a.g.d;

import android.view.View;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.Month;
import com.google.android.material.datepicker.YearGridAdapter;

/* compiled from: YearGridAdapter.java */
/* renamed from: b.i.a.g.d.m, reason: use source file name */
/* loaded from: classes3.dex */
public class YearGridAdapter2 implements View.OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ YearGridAdapter k;

    public YearGridAdapter2(YearGridAdapter yearGridAdapter, int i) {
        this.k = yearGridAdapter;
        this.j = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.k.a.setCurrentMonth(this.k.a.getCalendarConstraints().clamp(Month.g(this.j, this.k.a.getCurrentMonth().k)));
        this.k.a.setSelector(MaterialCalendar.k.DAY);
    }
}
