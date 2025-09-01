package b.f.j.p;

import b.f.j.c.BoundedLinkedHashSet;
import b.f.j.c.BufferedDiskCache2;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.c.MemoryCache;
import b.f.j.j.CloseableImage;
import b.f.j.r.FrescoSystrace;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Objects;

/* compiled from: BitmapProbeProducer.java */
/* renamed from: b.f.j.p.j, reason: use source file name */
/* loaded from: classes3.dex */
public class BitmapProbeProducer implements Producer2<CloseableReference<CloseableImage>> {
    public final MemoryCache<CacheKey, PooledByteBuffer> a;

    /* renamed from: b, reason: collision with root package name */
    public final BufferedDiskCache2 f617b;
    public final BufferedDiskCache2 c;
    public final CacheKeyFactory d;
    public final Producer2<CloseableReference<CloseableImage>> e;
    public final BoundedLinkedHashSet<CacheKey> f;
    public final BoundedLinkedHashSet<CacheKey> g;

    /* compiled from: BitmapProbeProducer.java */
    /* renamed from: b.f.j.p.j$a */
    public static class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final ProducerContext c;
        public final MemoryCache<CacheKey, PooledByteBuffer> d;
        public final BufferedDiskCache2 e;
        public final BufferedDiskCache2 f;
        public final CacheKeyFactory g;
        public final BoundedLinkedHashSet<CacheKey> h;
        public final BoundedLinkedHashSet<CacheKey> i;

        public a(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet2) {
            super(consumer2);
            this.c = producerContext;
            this.d = memoryCache;
            this.e = bufferedDiskCache2;
            this.f = bufferedDiskCache22;
            this.g = cacheKeyFactory;
            this.h = boundedLinkedHashSet;
            this.i = boundedLinkedHashSet2;
        }

        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            try {
                FrescoSystrace.b();
                if (BaseConsumer.f(i) || closeableReference == null || BaseConsumer.l(i, 8)) {
                    this.f632b.b(closeableReference, i);
                } else {
                    ImageRequest imageRequestE = this.c.e();
                    ((DefaultCacheKeyFactory) this.g).b(imageRequestE, this.c.b());
                    String str = (String) this.c.l("origin");
                    if (str != null && str.equals("memory_bitmap")) {
                        Objects.requireNonNull(this.c.g().getExperiments());
                        Objects.requireNonNull(this.c.g().getExperiments());
                    }
                    this.f632b.b(closeableReference, i);
                }
            } finally {
                FrescoSystrace.b();
            }
        }
    }

    public BitmapProbeProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet2, Producer2<CloseableReference<CloseableImage>> producer2) {
        this.a = memoryCache;
        this.f617b = bufferedDiskCache2;
        this.c = bufferedDiskCache22;
        this.d = cacheKeyFactory;
        this.f = boundedLinkedHashSet;
        this.g = boundedLinkedHashSet2;
        this.e = producer2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.b();
            ProducerListener2 producerListener2O = producerContext.o();
            producerListener2O.e(producerContext, "BitmapProbeProducer");
            a aVar = new a(consumer2, producerContext, this.a, this.f617b, this.c, this.d, this.f, this.g);
            producerListener2O.j(producerContext, "BitmapProbeProducer", null);
            FrescoSystrace.b();
            this.e.b(aVar, producerContext);
            FrescoSystrace.b();
        } finally {
            FrescoSystrace.b();
        }
    }
}
