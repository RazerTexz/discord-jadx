package b.f.j.c;

import b.f.b.b.DiskStorageCache;
import com.facebook.cache.common.CacheKey;
import java.util.concurrent.Callable;

/* compiled from: BufferedDiskCache.java */
/* renamed from: b.f.j.c.g, reason: use source file name */
/* loaded from: classes.dex */
public class BufferedDiskCache3 implements Callable<Void> {
    public final /* synthetic */ CacheKey j;
    public final /* synthetic */ BufferedDiskCache2 k;

    public BufferedDiskCache3(BufferedDiskCache2 bufferedDiskCache2, Object obj, CacheKey cacheKey) {
        this.k = bufferedDiskCache2;
        this.j = cacheKey;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.k.f.c(this.j);
            ((DiskStorageCache) this.k.a).f(this.j);
            return null;
        } finally {
        }
    }
}
