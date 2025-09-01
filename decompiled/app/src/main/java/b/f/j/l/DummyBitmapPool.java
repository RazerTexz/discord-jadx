package b.f.j.l;

import android.graphics.Bitmap;
import java.util.Objects;

/* compiled from: DummyBitmapPool.java */
/* renamed from: b.f.j.l.l, reason: use source file name */
/* loaded from: classes3.dex */
public class DummyBitmapPool implements BitmapPool {
    @Override // b.f.d.g.Pool2
    public Bitmap get(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(i / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // b.f.d.g.Pool2, b.f.d.h.ResourceReleaser
    public void release(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Objects.requireNonNull(bitmap);
        bitmap.recycle();
    }
}
