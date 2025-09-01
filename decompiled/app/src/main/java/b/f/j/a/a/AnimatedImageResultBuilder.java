package b.f.j.a.a;

import android.graphics.Bitmap;
import b.f.j.t.BitmapTransformation;
import com.facebook.common.references.CloseableReference;
import java.util.List;

/* compiled from: AnimatedImageResultBuilder.java */
/* renamed from: b.f.j.a.a.f, reason: use source file name */
/* loaded from: classes2.dex */
public class AnimatedImageResultBuilder {
    public final AnimatedImage a;

    /* renamed from: b, reason: collision with root package name */
    public CloseableReference<Bitmap> f545b;
    public List<CloseableReference<Bitmap>> c;
    public int d;
    public BitmapTransformation e;

    public AnimatedImageResultBuilder(AnimatedImage animatedImage) {
        this.a = animatedImage;
    }

    public AnimatedImageResult a() {
        try {
            AnimatedImageResult animatedImageResult = new AnimatedImageResult(this);
            CloseableReference<Bitmap> closeableReference = this.f545b;
            if (closeableReference != null) {
                closeableReference.close();
            }
            this.f545b = null;
            CloseableReference.t(this.c);
            this.c = null;
            return animatedImageResult;
        } catch (Throwable th) {
            CloseableReference<Bitmap> closeableReference2 = this.f545b;
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
            this.f545b = null;
            CloseableReference.t(this.c);
            this.c = null;
            throw th;
        }
    }
}
