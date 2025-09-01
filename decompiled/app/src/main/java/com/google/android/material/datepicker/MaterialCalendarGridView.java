package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import b.i.a.g.d.CalendarStyle;
import b.i.a.g.d.MaterialCalendarGridView2;
import b.i.a.g.d.MonthAdapter;
import b.i.a.g.d.UtcDates;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;

/* loaded from: classes3.dex */
public final class MaterialCalendarGridView extends GridView {
    public final Calendar j;
    public final boolean k;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.j = UtcDates.i();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.k = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.setAccessibilityDelegate(this, new MaterialCalendarGridView2(this));
    }

    @NonNull
    public MonthAdapter a() {
        return (MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return a();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(@NonNull Canvas canvas) {
        int iA;
        int width;
        int iA2;
        int width2;
        int width3;
        int i;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter monthAdapterA = a();
        DateSelector<?> dateSelector = monthAdapterA.l;
        CalendarStyle calendarStyle = monthAdapterA.n;
        Long lC = monthAdapterA.c(monthAdapterA.b());
        Long lC2 = monthAdapterA.c(monthAdapterA.d());
        for (Pair<Long, Long> pair : dateSelector.getSelectedRanges()) {
            Long l = pair.first;
            if (l != null) {
                if (pair.second != null) {
                    long jLongValue = l.longValue();
                    long jLongValue2 = pair.second.longValue();
                    Long lValueOf = Long.valueOf(jLongValue);
                    Long lValueOf2 = Long.valueOf(jLongValue2);
                    if (!(lC == null || lC2 == null || lValueOf == null || lValueOf2 == null || lValueOf.longValue() > lC2.longValue() || lValueOf2.longValue() < lC.longValue())) {
                        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
                        if (jLongValue < lC.longValue()) {
                            iA = monthAdapterA.b();
                            width = iA % monthAdapterA.k.m == 0 ? 0 : !zIsLayoutRtl ? materialCalendarGridView.getChildAt(iA - 1).getRight() : materialCalendarGridView.getChildAt(iA - 1).getLeft();
                        } else {
                            materialCalendarGridView.j.setTimeInMillis(jLongValue);
                            iA = monthAdapterA.a(materialCalendarGridView.j.get(5));
                            View childAt = materialCalendarGridView.getChildAt(iA);
                            width = (childAt.getWidth() / 2) + childAt.getLeft();
                        }
                        if (jLongValue2 > lC2.longValue()) {
                            iA2 = Math.min(monthAdapterA.d(), getChildCount() - 1);
                            width2 = (iA2 + 1) % monthAdapterA.k.m == 0 ? getWidth() : !zIsLayoutRtl ? materialCalendarGridView.getChildAt(iA2).getRight() : materialCalendarGridView.getChildAt(iA2).getLeft();
                        } else {
                            materialCalendarGridView.j.setTimeInMillis(jLongValue2);
                            iA2 = monthAdapterA.a(materialCalendarGridView.j.get(5));
                            View childAt2 = materialCalendarGridView.getChildAt(iA2);
                            width2 = (childAt2.getWidth() / 2) + childAt2.getLeft();
                        }
                        int itemId = (int) monthAdapterA.getItemId(iA);
                        int itemId2 = (int) monthAdapterA.getItemId(iA2);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt3 = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt3.getTop() + calendarStyle.a.a.top;
                            int bottom = childAt3.getBottom() - calendarStyle.a.a.bottom;
                            if (zIsLayoutRtl) {
                                int i2 = iA2 > numColumns2 ? 0 : width2;
                                width3 = numColumns > iA ? getWidth() : width;
                                i = i2;
                            } else {
                                i = numColumns > iA ? 0 : width;
                                width3 = iA2 > numColumns2 ? getWidth() : width2;
                            }
                            canvas.drawRect(i, top, width3, bottom, calendarStyle.h);
                            itemId++;
                            materialCalendarGridView = this;
                            monthAdapterA = monthAdapterA;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
            monthAdapterA = monthAdapterA;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z2, int i, Rect rect) {
        if (!z2) {
            super.onFocusChanged(false, i, rect);
            return;
        }
        if (i == 33) {
            setSelection(a().d());
        } else if (i == 130) {
            setSelection(a().b());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= a().b()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(a().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (!this.k) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter adapter) {
        setAdapter((ListAdapter) adapter);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        if (i < a().b()) {
            super.setSelection(a().b());
        } else {
            super.setSelection(i);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public /* bridge */ /* synthetic */ ListAdapter getAdapter() {
        return a();
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof MonthAdapter)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
