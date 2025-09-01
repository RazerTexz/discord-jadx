package b.f.j.n;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools;
import androidx.core.util.Preconditions;
import b.f.j.l.BitmapPool;
import b.f.k.BitmapUtil;

/* compiled from: ArtDecoder.java */
@TargetApi(21)
/* renamed from: b.f.j.n.a, reason: use source file name */
/* loaded from: classes3.dex */
public class ArtDecoder extends DefaultDecoder {
    public ArtDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        super(bitmapPool, i, synchronizedPool);
    }

    @Override // b.f.j.n.DefaultDecoder
    public int d(int i, int i2, BitmapFactory.Options options) {
        return BitmapUtil.c(i, i2, (Bitmap.Config) Preconditions.checkNotNull(options.inPreferredConfig));
    }
}
