package b.f.j.l;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import b.f.d.g.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool;

/* compiled from: BucketsBitmapPool.java */
@TargetApi(21)
/* renamed from: b.f.j.l.h, reason: use source file name */
/* loaded from: classes3.dex */
public class BucketsBitmapPool extends BasePool<Bitmap> implements BitmapPool {
    public BucketsBitmapPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker, boolean z2) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        this.j = z2;
        m();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public Bitmap e(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(i / 2.0d), Bitmap.Config.RGB_565);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public void g(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int i(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int j(Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int k(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public Bitmap l(Bucket2<Bitmap> bucket2) {
        Bitmap bitmap = (Bitmap) super.l(bucket2);
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
        return bitmap;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public boolean o(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        return !bitmap2.isRecycled() && bitmap2.isMutable();
    }
}
