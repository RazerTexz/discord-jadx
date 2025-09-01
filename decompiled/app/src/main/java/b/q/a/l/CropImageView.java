package b.q.a.l;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import b.i.a.f.e.o.f;
import b.q.a.h.CropBoundsChangeListener;
import b.q.a.l.TransformImageView2;
import com.yalantis.ucrop.UCropActivity;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* compiled from: CropImageView.java */
/* renamed from: b.q.a.l.a, reason: use source file name */
/* loaded from: classes3.dex */
public class CropImageView extends TransformImageView2 {
    public float A;
    public float B;
    public CropBoundsChangeListener C;
    public Runnable D;
    public Runnable E;
    public float F;
    public float G;
    public int H;
    public int I;
    public long J;

    /* renamed from: y, reason: collision with root package name */
    public final RectF f1987y;

    /* renamed from: z, reason: collision with root package name */
    public final Matrix f1988z;

    /* compiled from: CropImageView.java */
    /* renamed from: b.q.a.l.a$a */
    public static class a implements Runnable {
        public final WeakReference<CropImageView> j;
        public final long k;
        public final long l = System.currentTimeMillis();
        public final float m;
        public final float n;
        public final float o;
        public final float p;
        public final float q;
        public final float r;

        /* renamed from: s, reason: collision with root package name */
        public final boolean f1989s;

        public a(CropImageView cropImageView, long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z2) {
            this.j = new WeakReference<>(cropImageView);
            this.k = j;
            this.m = f;
            this.n = f2;
            this.o = f3;
            this.p = f4;
            this.q = f5;
            this.r = f6;
            this.f1989s = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.j.get();
            if (cropImageView == null) {
                return;
            }
            float fMin = Math.min(this.k, System.currentTimeMillis() - this.l);
            float f = this.o;
            float f2 = this.k;
            float f3 = (fMin / f2) - 1.0f;
            float f4 = (f3 * f3 * f3) + 1.0f;
            float f5 = (f * f4) + 0.0f;
            float f6 = (f4 * this.p) + 0.0f;
            float fT = f.T(fMin, 0.0f, this.r, f2);
            if (fMin < this.k) {
                float[] fArr = cropImageView.k;
                cropImageView.g(f5 - (fArr[0] - this.m), f6 - (fArr[1] - this.n));
                if (!this.f1989s) {
                    cropImageView.l(this.q + fT, cropImageView.f1987y.centerX(), cropImageView.f1987y.centerY());
                }
                if (cropImageView.j(cropImageView.j)) {
                    return;
                }
                cropImageView.post(this);
            }
        }
    }

    /* compiled from: CropImageView.java */
    /* renamed from: b.q.a.l.a$b */
    public static class b implements Runnable {
        public final WeakReference<CropImageView> j;
        public final long k;
        public final long l = System.currentTimeMillis();
        public final float m;
        public final float n;
        public final float o;
        public final float p;

        public b(CropImageView cropImageView, long j, float f, float f2, float f3, float f4) {
            this.j = new WeakReference<>(cropImageView);
            this.k = j;
            this.m = f;
            this.n = f2;
            this.o = f3;
            this.p = f4;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = this.j.get();
            if (cropImageView == null) {
                return;
            }
            float fMin = Math.min(this.k, System.currentTimeMillis() - this.l);
            float fT = f.T(fMin, 0.0f, this.n, this.k);
            if (fMin >= this.k) {
                cropImageView.setImageToWrapCropBounds(true);
            } else {
                cropImageView.l(this.m + fT, this.o, this.p);
                cropImageView.post(this);
            }
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // b.q.a.l.TransformImageView2
    public void d() {
        super.d();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.A == 0.0f) {
            this.A = intrinsicWidth / intrinsicHeight;
        }
        int i = this.n;
        float f = i;
        float f2 = this.A;
        int i2 = (int) (f / f2);
        int i3 = this.o;
        if (i2 > i3) {
            float f3 = i3;
            this.f1987y.set((i - ((int) (f2 * f3))) / 2, 0.0f, r5 + r2, f3);
        } else {
            this.f1987y.set(0.0f, (i3 - i2) / 2, f, i2 + r7);
        }
        h(intrinsicWidth, intrinsicHeight);
        float fWidth = this.f1987y.width();
        float fHeight = this.f1987y.height();
        float fMax = Math.max(this.f1987y.width() / intrinsicWidth, this.f1987y.height() / intrinsicHeight);
        RectF rectF = this.f1987y;
        float f4 = ((fWidth - (intrinsicWidth * fMax)) / 2.0f) + rectF.left;
        float f5 = ((fHeight - (intrinsicHeight * fMax)) / 2.0f) + rectF.top;
        this.m.reset();
        this.m.postScale(fMax, fMax);
        this.m.postTranslate(f4, f5);
        setImageMatrix(this.m);
        CropBoundsChangeListener cropBoundsChangeListener = this.C;
        if (cropBoundsChangeListener != null) {
            ((UCropView2) cropBoundsChangeListener).a.k.setTargetAspectRatio(this.A);
        }
        TransformImageView2.a aVar = this.p;
        if (aVar != null) {
            ((UCropActivity.a) aVar).b(getCurrentScale());
            ((UCropActivity.a) this.p).a(getCurrentAngle());
        }
    }

    @Override // b.q.a.l.TransformImageView2
    public void f(float f, float f2, float f3) {
        if (f > 1.0f && getCurrentScale() * f <= getMaxScale()) {
            super.f(f, f2, f3);
        } else {
            if (f >= 1.0f || getCurrentScale() * f < getMinScale()) {
                return;
            }
            super.f(f, f2, f3);
        }
    }

    @Nullable
    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.C;
    }

    public float getMaxScale() {
        return this.F;
    }

    public float getMinScale() {
        return this.G;
    }

    public float getTargetAspectRatio() {
        return this.A;
    }

    public final void h(float f, float f2) {
        float fMin = Math.min(Math.min(this.f1987y.width() / f, this.f1987y.width() / f2), Math.min(this.f1987y.height() / f2, this.f1987y.height() / f));
        this.G = fMin;
        this.F = fMin * this.B;
    }

    public void i() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
    }

    public boolean j(float[] fArr) {
        this.f1988z.reset();
        this.f1988z.setRotate(-getCurrentAngle());
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        this.f1988z.mapPoints(fArrCopyOf);
        float[] fArrF0 = f.f0(this.f1987y);
        this.f1988z.mapPoints(fArrF0);
        return f.y1(fArrCopyOf).contains(f.y1(fArrF0));
    }

    public void k(float f) {
        e(f, this.f1987y.centerX(), this.f1987y.centerY());
    }

    public void l(float f, float f2, float f3) {
        if (f <= getMaxScale()) {
            f(f / getCurrentScale(), f2, f3);
        }
    }

    public void setCropBoundsChangeListener(@Nullable CropBoundsChangeListener cropBoundsChangeListener) {
        this.C = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.A = rectF.width() / rectF.height();
        this.f1987y.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        if (getDrawable() != null) {
            h(r6.getIntrinsicWidth(), r6.getIntrinsicHeight());
        }
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean z2) {
        float f;
        float f2;
        float fMax;
        float f3;
        if (!this.t || j(this.j)) {
            return;
        }
        float[] fArr = this.k;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float currentScale = getCurrentScale();
        float fCenterX = this.f1987y.centerX() - f4;
        float fCenterY = this.f1987y.centerY() - f5;
        this.f1988z.reset();
        this.f1988z.setTranslate(fCenterX, fCenterY);
        float[] fArr2 = this.j;
        float[] fArrCopyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.f1988z.mapPoints(fArrCopyOf);
        boolean zJ = j(fArrCopyOf);
        if (zJ) {
            this.f1988z.reset();
            this.f1988z.setRotate(-getCurrentAngle());
            float[] fArr3 = this.j;
            float[] fArrCopyOf2 = Arrays.copyOf(fArr3, fArr3.length);
            float[] fArrF0 = f.f0(this.f1987y);
            this.f1988z.mapPoints(fArrCopyOf2);
            this.f1988z.mapPoints(fArrF0);
            RectF rectFY1 = f.y1(fArrCopyOf2);
            RectF rectFY12 = f.y1(fArrF0);
            float f6 = rectFY1.left - rectFY12.left;
            float f7 = rectFY1.top - rectFY12.top;
            float f8 = rectFY1.right - rectFY12.right;
            float f9 = rectFY1.bottom - rectFY12.bottom;
            float[] fArr4 = new float[4];
            if (f6 <= 0.0f) {
                f6 = 0.0f;
            }
            fArr4[0] = f6;
            if (f7 <= 0.0f) {
                f7 = 0.0f;
            }
            fArr4[1] = f7;
            if (f8 >= 0.0f) {
                f8 = 0.0f;
            }
            fArr4[2] = f8;
            if (f9 >= 0.0f) {
                f9 = 0.0f;
            }
            fArr4[3] = f9;
            this.f1988z.reset();
            this.f1988z.setRotate(getCurrentAngle());
            this.f1988z.mapPoints(fArr4);
            f2 = -(fArr4[0] + fArr4[2]);
            f3 = -(fArr4[1] + fArr4[3]);
            f = currentScale;
            fMax = 0.0f;
        } else {
            RectF rectF = new RectF(this.f1987y);
            this.f1988z.reset();
            this.f1988z.setRotate(getCurrentAngle());
            this.f1988z.mapRect(rectF);
            float[] fArr5 = this.j;
            f = currentScale;
            float[] fArr6 = {(float) Math.sqrt(Math.pow(fArr5[1] - fArr5[3], 2.0d) + Math.pow(fArr5[0] - fArr5[2], 2.0d)), (float) Math.sqrt(Math.pow(fArr5[3] - fArr5[5], 2.0d) + Math.pow(fArr5[2] - fArr5[4], 2.0d))};
            f2 = fCenterX;
            fMax = (Math.max(rectF.width() / fArr6[0], rectF.height() / fArr6[1]) * f) - f;
            f3 = fCenterY;
        }
        if (z2) {
            a aVar = new a(this, this.J, f4, f5, f2, f3, f, fMax, zJ);
            this.D = aVar;
            post(aVar);
        } else {
            g(f2, f3);
            if (zJ) {
                return;
            }
            l(f + fMax, this.f1987y.centerX(), this.f1987y.centerY());
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(@IntRange(from = 100) long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative value.");
        }
        this.J = j;
    }

    public void setMaxResultImageSizeX(@IntRange(from = 10) int i) {
        this.H = i;
    }

    public void setMaxResultImageSizeY(@IntRange(from = 10) int i) {
        this.I = i;
    }

    public void setMaxScaleMultiplier(float f) {
        this.B = f;
    }

    public void setTargetAspectRatio(float f) {
        if (getDrawable() == null) {
            this.A = f;
            return;
        }
        if (f == 0.0f) {
            this.A = r0.getIntrinsicWidth() / r0.getIntrinsicHeight();
        } else {
            this.A = f;
        }
        CropBoundsChangeListener cropBoundsChangeListener = this.C;
        if (cropBoundsChangeListener != null) {
            ((UCropView2) cropBoundsChangeListener).a.k.setTargetAspectRatio(this.A);
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1987y = new RectF();
        this.f1988z = new Matrix();
        this.B = 10.0f;
        this.E = null;
        this.H = 0;
        this.I = 0;
        this.J = 500L;
    }
}
