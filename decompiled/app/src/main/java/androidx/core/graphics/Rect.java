package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Rect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\b*\u00020\u0007H\u0086\n¢\u0006\u0004\b\u0002\u0010\t\u001a\u0014\u0010\u0004\u001a\u00020\b*\u00020\u0007H\u0086\n¢\u0006\u0004\b\u0004\u0010\t\u001a\u0014\u0010\u0005\u001a\u00020\b*\u00020\u0007H\u0086\n¢\u0006\u0004\b\u0005\u0010\t\u001a\u0014\u0010\u0006\u001a\u00020\b*\u00020\u0007H\u0086\n¢\u0006\u0004\b\u0006\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0086\n¢\u0006\u0004\b\u000b\u0010\r\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u000b\u0010\u000f\u001a\u001c\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\bH\u0086\n¢\u0006\u0004\b\u000b\u0010\u0010\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0011H\u0086\n¢\u0006\u0004\b\u000b\u0010\u0012\u001a\u001c\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0013H\u0086\n¢\u0006\u0004\b\u000b\u0010\u0014\u001a\u001c\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001c\u0010\u0016\u001a\u00020\u0015*\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0086\n¢\u0006\u0004\b\u0016\u0010\u0018\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0016\u0010\u000f\u001a\u001c\u0010\u0016\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\bH\u0086\n¢\u0006\u0004\b\u0016\u0010\u0010\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0011H\u0086\n¢\u0006\u0004\b\u0016\u0010\u0012\u001a\u001c\u0010\u0016\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0013H\u0086\n¢\u0006\u0004\b\u0016\u0010\u0014\u001a\u001c\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u001a\u0010\u000f\u001a\u001c\u0010\u001a\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001a\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0019\u001a\u00020\bH\u0086\n¢\u0006\u0004\b\u001a\u0010\u0010\u001a\u001c\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\u001c\u0010\f\u001a\u001c\u0010\u001c\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0086\f¢\u0006\u0004\b\u001c\u0010\r\u001a\u001c\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\u001d\u0010\f\u001a\u001c\u0010\u001d\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0087\f¢\u0006\u0004\b\u001d\u0010\r\u001a\u001c\u0010\u001e\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\u001e\u0010\u0017\u001a\u001c\u0010\u001e\u001a\u00020\u0015*\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0086\f¢\u0006\u0004\b\u001e\u0010\u0018\u001a\u001c\u0010!\u001a\u00020 *\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0011H\u0086\n¢\u0006\u0004\b!\u0010\"\u001a\u001c\u0010!\u001a\u00020 *\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0013H\u0086\n¢\u0006\u0004\b!\u0010#\u001a\u0014\u0010$\u001a\u00020\u0007*\u00020\u0000H\u0086\b¢\u0006\u0004\b$\u0010%\u001a\u0014\u0010&\u001a\u00020\u0000*\u00020\u0007H\u0086\b¢\u0006\u0004\b&\u0010'\u001a\u0014\u0010(\u001a\u00020\u0015*\u00020\u0000H\u0086\b¢\u0006\u0004\b(\u0010)\u001a\u0014\u0010(\u001a\u00020\u0015*\u00020\u0007H\u0086\b¢\u0006\u0004\b(\u0010*\u001a\u001c\u0010-\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020+H\u0086\b¢\u0006\u0004\b-\u0010.¨\u0006/"}, d2 = {"Landroid/graphics/Rect;", "", "component1", "(Landroid/graphics/Rect;)I", "component2", "component3", "component4", "Landroid/graphics/RectF;", "", "(Landroid/graphics/RectF;)F", "r", "plus", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)Landroid/graphics/Rect;", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)Landroid/graphics/RectF;", "xy", "(Landroid/graphics/Rect;I)Landroid/graphics/Rect;", "(Landroid/graphics/RectF;F)Landroid/graphics/RectF;", "Landroid/graphics/Point;", "(Landroid/graphics/Rect;Landroid/graphics/Point;)Landroid/graphics/Rect;", "Landroid/graphics/PointF;", "(Landroid/graphics/RectF;Landroid/graphics/PointF;)Landroid/graphics/RectF;", "Landroid/graphics/Region;", "minus", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)Landroid/graphics/Region;", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)Landroid/graphics/Region;", "factor", "times", "(Landroid/graphics/RectF;I)Landroid/graphics/RectF;", "or", "and", "xor", "p", "", "contains", "(Landroid/graphics/Rect;Landroid/graphics/Point;)Z", "(Landroid/graphics/RectF;Landroid/graphics/PointF;)Z", "toRectF", "(Landroid/graphics/Rect;)Landroid/graphics/RectF;", "toRect", "(Landroid/graphics/RectF;)Landroid/graphics/Rect;", "toRegion", "(Landroid/graphics/Rect;)Landroid/graphics/Region;", "(Landroid/graphics/RectF;)Landroid/graphics/Region;", "Landroid/graphics/Matrix;", "m", "transform", "(Landroid/graphics/RectF;Landroid/graphics/Matrix;)Landroid/graphics/RectF;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.graphics.RectKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Rect {
    @SuppressLint({"CheckResult"})
    public static final android.graphics.Rect and(android.graphics.Rect rect, android.graphics.Rect rect2) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(rect2, "r");
        android.graphics.Rect rect3 = new android.graphics.Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    public static final int component1(android.graphics.Rect rect) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        return rect.left;
    }

    public static final int component2(android.graphics.Rect rect) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        return rect.top;
    }

    public static final int component3(android.graphics.Rect rect) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        return rect.right;
    }

    public static final int component4(android.graphics.Rect rect) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        return rect.bottom;
    }

    public static final boolean contains(android.graphics.Rect rect, Point point) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(point, "p");
        return rect.contains(point.x, point.y);
    }

    public static final Region minus(android.graphics.Rect rect, android.graphics.Rect rect2) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(rect2, "r");
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final android.graphics.Rect or(android.graphics.Rect rect, android.graphics.Rect rect2) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(rect2, "r");
        android.graphics.Rect rect3 = new android.graphics.Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    public static final android.graphics.Rect plus(android.graphics.Rect rect, android.graphics.Rect rect2) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(rect2, "r");
        android.graphics.Rect rect3 = new android.graphics.Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    public static final android.graphics.Rect times(android.graphics.Rect rect, int i) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        android.graphics.Rect rect2 = new android.graphics.Rect(rect);
        rect2.top *= i;
        rect2.left *= i;
        rect2.right *= i;
        rect2.bottom *= i;
        return rect2;
    }

    public static final android.graphics.Rect toRect(RectF rectF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        android.graphics.Rect rect = new android.graphics.Rect();
        rectF.roundOut(rect);
        return rect;
    }

    public static final RectF toRectF(android.graphics.Rect rect) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        return new RectF(rect);
    }

    public static final Region toRegion(android.graphics.Rect rect) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        return new Region(rect);
    }

    public static final RectF transform(RectF rectF, Matrix matrix) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(matrix, "m");
        matrix.mapRect(rectF);
        return rectF;
    }

    public static final Region xor(android.graphics.Rect rect, android.graphics.Rect rect2) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(rect2, "r");
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final float component1(RectF rectF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        return rectF.left;
    }

    public static final float component2(RectF rectF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        return rectF.top;
    }

    public static final float component3(RectF rectF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        return rectF.right;
    }

    public static final float component4(RectF rectF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        return rectF.bottom;
    }

    public static final boolean contains(RectF rectF, PointF pointF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(pointF, "p");
        return rectF.contains(pointF.x, pointF.y);
    }

    public static final Region toRegion(RectF rectF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        android.graphics.Rect rect = new android.graphics.Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    public static final RectF and(RectF rectF, RectF rectF2) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    public static final Region minus(RectF rectF, RectF rectF2) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(rectF2, "r");
        android.graphics.Rect rect = new android.graphics.Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        android.graphics.Rect rect2 = new android.graphics.Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final RectF or(RectF rectF, RectF rectF2) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    public static final RectF plus(RectF rectF, RectF rectF2) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    public static final Region xor(RectF rectF, RectF rectF2) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(rectF2, "r");
        android.graphics.Rect rect = new android.graphics.Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        android.graphics.Rect rect2 = new android.graphics.Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final android.graphics.Rect plus(android.graphics.Rect rect, int i) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        android.graphics.Rect rect2 = new android.graphics.Rect(rect);
        rect2.offset(i, i);
        return rect2;
    }

    public static final RectF times(RectF rectF, float f) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    public static final RectF plus(RectF rectF, float f) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f, f);
        return rectF2;
    }

    public static final android.graphics.Rect plus(android.graphics.Rect rect, Point point) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(point, "xy");
        android.graphics.Rect rect2 = new android.graphics.Rect(rect);
        rect2.offset(point.x, point.y);
        return rect2;
    }

    public static final android.graphics.Rect minus(android.graphics.Rect rect, int i) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        android.graphics.Rect rect2 = new android.graphics.Rect(rect);
        int i2 = -i;
        rect2.offset(i2, i2);
        return rect2;
    }

    public static final RectF plus(RectF rectF, PointF pointF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    public static final RectF times(RectF rectF, int i) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        float f = i;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    public static final RectF minus(RectF rectF, float f) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        float f2 = -f;
        rectF2.offset(f2, f2);
        return rectF2;
    }

    public static final android.graphics.Rect minus(android.graphics.Rect rect, Point point) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(point, "xy");
        android.graphics.Rect rect2 = new android.graphics.Rect(rect);
        rect2.offset(-point.x, -point.y);
        return rect2;
    }

    public static final RectF minus(RectF rectF, PointF pointF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }
}
