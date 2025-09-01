package b.i.a.c.e3.b0;

import com.google.android.exoplayer2.upstream.cache.Cache;
import java.util.TreeSet;

/* compiled from: LeastRecentlyUsedCacheEvictor.java */
/* renamed from: b.i.a.c.e3.b0.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {
    public final TreeSet<CacheSpan> a = new TreeSet<>(b.j);

    /* renamed from: b, reason: collision with root package name */
    public long f937b;

    public LeastRecentlyUsedCacheEvictor(long j) {
    }

    @Override // b.i.a.c.e3.b0.CacheEvictor
    public void a(Cache cache, String str, long j, long j2) {
        if (j2 != -1) {
            f(cache, j2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void b(Cache cache, CacheSpan cacheSpan) {
        this.a.remove(cacheSpan);
        this.f937b -= cacheSpan.l;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void c(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        this.a.remove(cacheSpan);
        this.f937b -= cacheSpan.l;
        d(cache, cacheSpan2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void d(Cache cache, CacheSpan cacheSpan) {
        this.a.add(cacheSpan);
        this.f937b += cacheSpan.l;
        f(cache, 0L);
    }

    @Override // b.i.a.c.e3.b0.CacheEvictor
    public void e() {
    }

    public final void f(Cache cache, long j) {
        while (this.f937b + j > 104857600 && !this.a.isEmpty()) {
            cache.d(this.a.first());
        }
    }
}
