package b.c.a.b0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Build;
import b.c.a.L;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: Utils.java */
/* renamed from: b.c.a.b0.g, reason: use source file name */
/* loaded from: classes.dex */
public final class Utils {
    public static final PathMeasure a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    public static final Path f346b = new Path();
    public static final Path c = new Path();
    public static final float[] d = new float[4];
    public static final float e = (float) (Math.sqrt(2.0d) / 2.0d);
    public static float f = -1.0f;

    public static void a(Path path, float f2, float f3, float f4) {
        PathMeasure pathMeasure = a;
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            L.a("applyTrimPathIfNeeded");
            return;
        }
        if (length < 1.0f || Math.abs((f3 - f2) - 1.0f) < 0.01d) {
            L.a("applyTrimPathIfNeeded");
            return;
        }
        float f5 = f2 * length;
        float f6 = f3 * length;
        float f7 = f4 * length;
        float fMin = Math.min(f5, f6) + f7;
        float fMax = Math.max(f5, f6) + f7;
        if (fMin >= length && fMax >= length) {
            fMin = MiscUtils.d(fMin, length);
            fMax = MiscUtils.d(fMax, length);
        }
        if (fMin < 0.0f) {
            fMin = MiscUtils.d(fMin, length);
        }
        if (fMax < 0.0f) {
            fMax = MiscUtils.d(fMax, length);
        }
        if (fMin == fMax) {
            path.reset();
            L.a("applyTrimPathIfNeeded");
            return;
        }
        if (fMin >= fMax) {
            fMin -= length;
        }
        Path path2 = f346b;
        path2.reset();
        pathMeasure.getSegment(fMin, fMax, path2, true);
        if (fMax > length) {
            Path path3 = c;
            path3.reset();
            pathMeasure.getSegment(0.0f, fMax % length, path3, true);
            path2.addPath(path3);
        } else if (fMin < 0.0f) {
            Path path4 = c;
            path4.reset();
            pathMeasure.getSegment(fMin + length, length, path4, true);
            path2.addPath(path4);
        }
        path.set(path2);
        L.a("applyTrimPathIfNeeded");
    }

    public static void b(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static float c() {
        if (f == -1.0f) {
            f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f;
    }

    public static float d(Matrix matrix) {
        float[] fArr = d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = e;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static Bitmap e(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static void f(Canvas canvas, RectF rectF, Paint paint, int i) {
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        L.a("Utils#saveLayer");
    }
}
