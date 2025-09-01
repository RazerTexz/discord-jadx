package b.f.j.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import b.c.a.a0.AnimatableValueParser;
import b.f.j.e.CloseableReferenceFactory;
import b.f.j.l.BitmapPool;
import b.f.k.BitmapUtil;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;

/* compiled from: ArtBitmapFactory.java */
@TargetApi(21)
/* renamed from: b.f.j.b.a, reason: use source file name */
/* loaded from: classes2.dex */
public class ArtBitmapFactory extends PlatformBitmapFactory {
    public final BitmapPool a;

    /* renamed from: b, reason: collision with root package name */
    public final CloseableReferenceFactory f552b;

    public ArtBitmapFactory(BitmapPool bitmapPool, CloseableReferenceFactory closeableReferenceFactory) {
        this.a = bitmapPool;
        this.f552b = closeableReferenceFactory;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> b(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap = this.a.get(BitmapUtil.c(i, i2, config));
        AnimatableValueParser.i(Boolean.valueOf(bitmap.getAllocationByteCount() >= BitmapUtil.b(config) * (i * i2)));
        bitmap.reconfigure(i, i2, config);
        return CloseableReference.H(bitmap, this.a, this.f552b.a);
    }
}
