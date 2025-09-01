package b.i.a.g.d;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SmoothCalendarLayoutManager.java */
/* renamed from: b.i.a.g.d.j, reason: use source file name */
/* loaded from: classes3.dex */
public class SmoothCalendarLayoutManager extends LinearLayoutManager {

    /* compiled from: SmoothCalendarLayoutManager.java */
    /* renamed from: b.i.a.g.d.j$a */
    public class a extends LinearSmoothScroller {
        public a(SmoothCalendarLayoutManager smoothCalendarLayoutManager, Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public SmoothCalendarLayoutManager(Context context, int i, boolean z2) {
        super(context, i, z2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.setTargetPosition(i);
        startSmoothScroll(aVar);
    }
}
