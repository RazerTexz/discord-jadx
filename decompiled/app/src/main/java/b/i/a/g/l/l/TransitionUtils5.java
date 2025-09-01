package b.i.a.g.l.l;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.d.b.a.outline;

/* compiled from: TransitionUtils.java */
@RequiresApi(21)
/* renamed from: b.i.a.g.l.l.k, reason: use source file name */
/* loaded from: classes3.dex */
public class TransitionUtils5 {
    public static final RectF a = new RectF();

    /* compiled from: TransitionUtils.java */
    /* renamed from: b.i.a.g.l.l.k$a */
    public interface a {
        void a(Canvas canvas);
    }

    @NonNull
    public static <T> T a(@Nullable T t, @NonNull T t2) {
        return t != null ? t : t2;
    }

    public static View b(View view, @IdRes int i) throws Resources.NotFoundException {
        String resourceName = view.getResources().getResourceName(i);
        while (view != null) {
            if (view.getId() != i) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(outline.w(resourceName, " is not a valid ancestor"));
    }

    public static RectF c(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    public static float d(float f, float f2, float f3) {
        return outline.a(f2, f, f3, f);
    }

    public static float e(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5) {
        return f(f, f2, f3, f4, f5, false);
    }

    public static float f(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d) float f5, boolean z2) {
        return (!z2 || (f5 >= 0.0f && f5 <= 1.0f)) ? f5 < f3 ? f : f5 > f4 ? f2 : d(f, f2, (f5 - f3) / (f4 - f3)) : d(f, f2, f5);
    }

    public static int g(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return f3 < f ? i : f3 > f2 ? i2 : (int) d(i, i2, (f3 - f) / (f2 - f));
    }

    public static void h(Canvas canvas, Rect rect, float f, float f2, float f3, int i, a aVar) {
        if (i <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(f, f2);
        canvas.scale(f3, f3);
        if (i < 255) {
            RectF rectF = a;
            rectF.set(rect);
            canvas.saveLayerAlpha(rectF, i);
        }
        aVar.a(canvas);
        canvas.restoreToCount(iSave);
    }
}
