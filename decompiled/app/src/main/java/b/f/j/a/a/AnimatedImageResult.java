package b.f.j.a.a;

import android.graphics.Bitmap;
import b.f.j.t.BitmapTransformation;
import com.facebook.common.references.CloseableReference;
import java.util.List;
import java.util.Objects;

/* compiled from: AnimatedImageResult.java */
/* renamed from: b.f.j.a.a.e, reason: use source file name */
/* loaded from: classes2.dex */
public class AnimatedImageResult {
    public final AnimatedImage a;

    /* renamed from: b, reason: collision with root package name */
    public CloseableReference<Bitmap> f544b;
    public List<CloseableReference<Bitmap>> c;
    public BitmapTransformation d;

    public AnimatedImageResult(AnimatedImageResultBuilder animatedImageResultBuilder) {
        AnimatedImage animatedImage = animatedImageResultBuilder.a;
        Objects.requireNonNull(animatedImage);
        this.a = animatedImage;
        this.f544b = CloseableReference.n(animatedImageResultBuilder.f545b);
        this.c = CloseableReference.q(animatedImageResultBuilder.c);
        this.d = animatedImageResultBuilder.e;
    }
}
