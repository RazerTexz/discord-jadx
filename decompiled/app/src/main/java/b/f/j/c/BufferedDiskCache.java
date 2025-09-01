package b.f.j.c;

import b.f.d.e.FLog;
import b.f.j.j.EncodedImage2;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: BufferedDiskCache.java */
/* renamed from: b.f.j.c.e, reason: use source file name */
/* loaded from: classes.dex */
public class BufferedDiskCache implements Callable<EncodedImage2> {
    public final /* synthetic */ AtomicBoolean j;
    public final /* synthetic */ CacheKey k;
    public final /* synthetic */ BufferedDiskCache2 l;

    public BufferedDiskCache(BufferedDiskCache2 bufferedDiskCache2, Object obj, AtomicBoolean atomicBoolean, CacheKey cacheKey) {
        this.l = bufferedDiskCache2;
        this.j = atomicBoolean;
        this.k = cacheKey;
    }

    @Override // java.util.concurrent.Callable
    public EncodedImage2 call() throws Exception {
        PooledByteBuffer pooledByteBufferA;
        try {
            if (this.j.get()) {
                throw new CancellationException();
            }
            EncodedImage2 encodedImage2A = this.l.f.a(this.k);
            if (encodedImage2A != null) {
                this.k.b();
                int i = FLog.a;
                Objects.requireNonNull((NoOpImageCacheStatsTracker) this.l.g);
            } else {
                this.k.b();
                int i2 = FLog.a;
                Objects.requireNonNull((NoOpImageCacheStatsTracker) this.l.g);
                encodedImage2A = null;
                try {
                    pooledByteBufferA = BufferedDiskCache2.a(this.l, this.k);
                } catch (Exception unused) {
                }
                if (pooledByteBufferA == null) {
                    return encodedImage2A;
                }
                CloseableReference closeableReferenceA = CloseableReference.A(pooledByteBufferA);
                try {
                    encodedImage2A = new EncodedImage2(closeableReferenceA);
                } finally {
                    if (closeableReferenceA != null) {
                        closeableReferenceA.close();
                    }
                }
            }
            if (!Thread.interrupted()) {
                return encodedImage2A;
            }
            FLog.i(BufferedDiskCache2.class, "Host thread was interrupted, decreasing reference count");
            encodedImage2A.close();
            throw new InterruptedException();
        } catch (Throwable th) {
            throw th;
        }
    }
}
