package b.f.j.a.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import b.f.j.a.a.AnimatedDrawableBackend;
import b.f.j.a.a.AnimatedDrawableFrameInfo;
import b.f.j.a.a.AnimatedImageResult;
import b.f.j.t.BitmapTransformation;
import com.facebook.common.references.CloseableReference;

/* compiled from: AnimatedImageCompositor.java */
/* renamed from: b.f.j.a.c.d, reason: use source file name */
/* loaded from: classes2.dex */
public class AnimatedImageCompositor {
    public final AnimatedDrawableBackend a;

    /* renamed from: b, reason: collision with root package name */
    public final a f551b;
    public final Paint c;

    /* compiled from: AnimatedImageCompositor.java */
    /* renamed from: b.f.j.a.c.d$a */
    public interface a {
        void a(int i, Bitmap bitmap);

        CloseableReference<Bitmap> b(int i);
    }

    public AnimatedImageCompositor(AnimatedDrawableBackend animatedDrawableBackend, a aVar) {
        this.a = animatedDrawableBackend;
        this.f551b = aVar;
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public final void a(Canvas canvas, AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        canvas.drawRect(animatedDrawableFrameInfo.a, animatedDrawableFrameInfo.f543b, r0 + animatedDrawableFrameInfo.c, r1 + animatedDrawableFrameInfo.d, this.c);
    }

    public final boolean b(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.a == 0 && animatedDrawableFrameInfo.f543b == 0 && animatedDrawableFrameInfo.c == ((AnimatedDrawableBackendImpl) this.a).d.width() && animatedDrawableFrameInfo.d == ((AnimatedDrawableBackendImpl) this.a).d.height();
    }

    public final boolean c(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo[] animatedDrawableFrameInfoArr = ((AnimatedDrawableBackendImpl) this.a).f;
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo = animatedDrawableFrameInfoArr[i];
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo2 = animatedDrawableFrameInfoArr[i - 1];
        if (animatedDrawableFrameInfo.e == 2 && b(animatedDrawableFrameInfo)) {
            return true;
        }
        return animatedDrawableFrameInfo2.f == 2 && b(animatedDrawableFrameInfo2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i, Bitmap bitmap) {
        BitmapTransformation bitmapTransformation;
        Canvas canvas = new Canvas(bitmap);
        int i2 = 0;
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        if (c(i)) {
            i2 = i;
        } else {
            int i3 = i - 1;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                AnimatedDrawableFrameInfo animatedDrawableFrameInfo = ((AnimatedDrawableBackendImpl) this.a).f[i3];
                int i4 = animatedDrawableFrameInfo.f;
                if (i4 != 1) {
                    int i5 = i4 == 2 ? b(animatedDrawableFrameInfo) ? 2 : 1 : i4 == 3 ? 3 : 4;
                    int iH = b.c.a.y.b.h(i5);
                    if (iH == 0) {
                        AnimatedDrawableFrameInfo animatedDrawableFrameInfo2 = ((AnimatedDrawableBackendImpl) this.a).f[i3];
                        CloseableReference<Bitmap> closeableReferenceB = this.f551b.b(i3);
                        if (closeableReferenceB != null) {
                            try {
                                canvas.drawBitmap(closeableReferenceB.u(), 0.0f, 0.0f, (Paint) null);
                                if (animatedDrawableFrameInfo2.f == 2) {
                                    a(canvas, animatedDrawableFrameInfo2);
                                }
                                i2 = i3 + 1;
                            } finally {
                                closeableReferenceB.close();
                            }
                        } else if (c(i3)) {
                            break;
                        } else {
                            i3--;
                        }
                    } else if (iH == 1) {
                        i2 = i3 + 1;
                        break;
                    } else if (iH == 3) {
                        break;
                    } else {
                        i3--;
                    }
                }
            }
        }
        while (i2 < i) {
            AnimatedDrawableFrameInfo animatedDrawableFrameInfo3 = ((AnimatedDrawableBackendImpl) this.a).f[i2];
            int i6 = animatedDrawableFrameInfo3.f;
            if (i6 != 3) {
                if (animatedDrawableFrameInfo3.e == 2) {
                    a(canvas, animatedDrawableFrameInfo3);
                }
                ((AnimatedDrawableBackendImpl) this.a).d(i2, canvas);
                this.f551b.a(i2, bitmap);
                if (i6 == 2) {
                    a(canvas, animatedDrawableFrameInfo3);
                }
            }
            i2++;
        }
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo4 = ((AnimatedDrawableBackendImpl) this.a).f[i];
        if (animatedDrawableFrameInfo4.e == 2) {
            a(canvas, animatedDrawableFrameInfo4);
        }
        ((AnimatedDrawableBackendImpl) this.a).d(i, canvas);
        AnimatedImageResult animatedImageResult = ((AnimatedDrawableBackendImpl) this.a).f548b;
        if (animatedImageResult == null || (bitmapTransformation = animatedImageResult.d) == null) {
            return;
        }
        bitmapTransformation.a(bitmap);
    }
}
