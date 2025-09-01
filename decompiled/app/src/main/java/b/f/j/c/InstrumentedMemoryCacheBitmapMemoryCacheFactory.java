package b.f.j.c;

import com.facebook.cache.common.CacheKey;
import java.util.Objects;

/* compiled from: InstrumentedMemoryCacheBitmapMemoryCacheFactory.java */
/* renamed from: b.f.j.c.t, reason: use source file name */
/* loaded from: classes.dex */
public final class InstrumentedMemoryCacheBitmapMemoryCacheFactory implements MemoryCacheTracker<CacheKey> {
    public final /* synthetic */ ImageCacheStatsTracker a;

    public InstrumentedMemoryCacheBitmapMemoryCacheFactory(ImageCacheStatsTracker imageCacheStatsTracker) {
        this.a = imageCacheStatsTracker;
    }

    @Override // b.f.j.c.MemoryCacheTracker
    public void a(CacheKey cacheKey) {
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.a);
    }

    @Override // b.f.j.c.MemoryCacheTracker
    public void b(CacheKey cacheKey) {
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.a);
    }

    @Override // b.f.j.c.MemoryCacheTracker
    public void c(CacheKey cacheKey) {
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.a);
    }
}
