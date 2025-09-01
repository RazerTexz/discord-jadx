package b.c.a.y;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;

/* compiled from: CubicCurveData.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: b.c.a.y.a, reason: use source file name */
/* loaded from: classes.dex */
public class CubicCurveData {
    public final PointF a;

    /* renamed from: b, reason: collision with root package name */
    public final PointF f399b;
    public final PointF c;

    public CubicCurveData() {
        this.a = new PointF();
        this.f399b = new PointF();
        this.c = new PointF();
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.a = pointF;
        this.f399b = pointF2;
        this.c = pointF3;
    }
}
