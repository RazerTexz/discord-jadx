package b.i.a.g.d;

import android.view.View;
import android.widget.AdapterView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.MonthsPagerAdapter;
import com.google.android.material.datepicker.OnSelectionChangedListener;
import java.util.Iterator;

/* compiled from: MonthsPagerAdapter.java */
/* renamed from: b.i.a.g.d.h, reason: use source file name */
/* loaded from: classes3.dex */
public class MonthsPagerAdapter2 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ MaterialCalendarGridView j;
    public final /* synthetic */ MonthsPagerAdapter k;

    public MonthsPagerAdapter2(MonthsPagerAdapter monthsPagerAdapter, MaterialCalendarGridView materialCalendarGridView) {
        this.k = monthsPagerAdapter;
        this.j = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        MonthAdapter monthAdapterA = this.j.a();
        if (i >= monthAdapterA.b() && i <= monthAdapterA.d()) {
            MaterialCalendar.l lVar = this.k.d;
            long jLongValue = this.j.a().c(i).longValue();
            MaterialCalendar.d dVar = (MaterialCalendar.d) lVar;
            if (MaterialCalendar.access$100(MaterialCalendar.this).getDateValidator().isValid(jLongValue)) {
                MaterialCalendar.access$200(MaterialCalendar.this).select(jLongValue);
                Iterator it = MaterialCalendar.this.onSelectionChangedListeners.iterator();
                while (it.hasNext()) {
                    ((OnSelectionChangedListener) it.next()).onSelectionChanged(MaterialCalendar.access$200(MaterialCalendar.this).getSelection());
                }
                MaterialCalendar.access$000(MaterialCalendar.this).getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.access$300(MaterialCalendar.this) != null) {
                    MaterialCalendar.access$300(MaterialCalendar.this).getAdapter().notifyDataSetChanged();
                }
            }
        }
    }
}
