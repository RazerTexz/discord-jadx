package androidx.core.graphics;

import android.graphics.PointF;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Point.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0006*\u00020\u0005H\u0086\n¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0006*\u00020\u0005H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u001c\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\t\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0086\n¢\u0006\u0004\b\t\u0010\u000b\u001a\u001c\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\t\u0010\r\u001a\u001c\u0010\t\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\t\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u000f\u0010\n\u001a\u001c\u0010\u000f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0086\n¢\u0006\u0004\b\u000f\u0010\u000b\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\f\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u000f\u0010\r\u001a\u001c\u0010\u000f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\u0000*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0014\u0010\u0010\u001a\u00020\u0005*\u00020\u0005H\u0086\n¢\u0006\u0004\b\u0010\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0005*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0000*\u00020\u0005H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroid/graphics/Point;", "", "component1", "(Landroid/graphics/Point;)I", "component2", "Landroid/graphics/PointF;", "", "(Landroid/graphics/PointF;)F", "p", "plus", "(Landroid/graphics/Point;Landroid/graphics/Point;)Landroid/graphics/Point;", "(Landroid/graphics/PointF;Landroid/graphics/PointF;)Landroid/graphics/PointF;", "xy", "(Landroid/graphics/Point;I)Landroid/graphics/Point;", "(Landroid/graphics/PointF;F)Landroid/graphics/PointF;", "minus", "unaryMinus", "(Landroid/graphics/Point;)Landroid/graphics/Point;", "(Landroid/graphics/PointF;)Landroid/graphics/PointF;", "toPointF", "(Landroid/graphics/Point;)Landroid/graphics/PointF;", "toPoint", "(Landroid/graphics/PointF;)Landroid/graphics/Point;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.graphics.PointKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Point {
    public static final int component1(android.graphics.Point point) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        return point.x;
    }

    public static final int component2(android.graphics.Point point) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        return point.y;
    }

    public static final android.graphics.Point minus(android.graphics.Point point, android.graphics.Point point2) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        Intrinsics3.checkNotNullParameter(point2, "p");
        android.graphics.Point point3 = new android.graphics.Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    public static final android.graphics.Point plus(android.graphics.Point point, android.graphics.Point point2) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        Intrinsics3.checkNotNullParameter(point2, "p");
        android.graphics.Point point3 = new android.graphics.Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    public static final android.graphics.Point toPoint(PointF pointF) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        return new android.graphics.Point((int) pointF.x, (int) pointF.y);
    }

    public static final PointF toPointF(android.graphics.Point point) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        return new PointF(point);
    }

    public static final android.graphics.Point unaryMinus(android.graphics.Point point) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        return new android.graphics.Point(-point.x, -point.y);
    }

    public static final float component1(PointF pointF) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        return pointF.x;
    }

    public static final float component2(PointF pointF) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        return pointF.y;
    }

    public static final PointF unaryMinus(PointF pointF) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        return new PointF(-pointF.x, -pointF.y);
    }

    public static final PointF minus(PointF pointF, PointF pointF2) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        Intrinsics3.checkNotNullParameter(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    public static final PointF plus(PointF pointF, PointF pointF2) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        Intrinsics3.checkNotNullParameter(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    public static final android.graphics.Point minus(android.graphics.Point point, int i) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        android.graphics.Point point2 = new android.graphics.Point(point.x, point.y);
        int i2 = -i;
        point2.offset(i2, i2);
        return point2;
    }

    public static final android.graphics.Point plus(android.graphics.Point point, int i) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        android.graphics.Point point2 = new android.graphics.Point(point.x, point.y);
        point2.offset(i, i);
        return point2;
    }

    public static final PointF minus(PointF pointF, float f) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f2 = -f;
        pointF2.offset(f2, f2);
        return pointF2;
    }

    public static final PointF plus(PointF pointF, float f) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f, f);
        return pointF2;
    }
}
