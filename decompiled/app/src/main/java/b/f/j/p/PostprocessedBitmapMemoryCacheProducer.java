package b.f.j.p;

import b.f.d.d.ImmutableMap;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.c.MemoryCache;
import b.f.j.j.CloseableImage;
import b.f.j.q.Postprocessor;
import b.f.j.q.RepeatedPostprocessor;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: PostprocessedBitmapMemoryCacheProducer.java */
/* renamed from: b.f.j.p.s0, reason: use source file name */
/* loaded from: classes3.dex */
public class PostprocessedBitmapMemoryCacheProducer implements Producer2<CloseableReference<CloseableImage>> {
    public final MemoryCache<CacheKey, CloseableImage> a;

    /* renamed from: b, reason: collision with root package name */
    public final CacheKeyFactory f637b;
    public final Producer2<CloseableReference<CloseableImage>> c;

    /* compiled from: PostprocessedBitmapMemoryCacheProducer.java */
    /* renamed from: b.f.j.p.s0$a */
    public static class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final CacheKey c;
        public final boolean d;
        public final MemoryCache<CacheKey, CloseableImage> e;
        public final boolean f;

        public a(Consumer2<CloseableReference<CloseableImage>> consumer2, CacheKey cacheKey, boolean z2, MemoryCache<CacheKey, CloseableImage> memoryCache, boolean z3) {
            super(consumer2);
            this.c = cacheKey;
            this.d = z2;
            this.e = memoryCache;
            this.f = z3;
        }

        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) {
            CloseableReference<CloseableImage> closeableReference = (CloseableReference) obj;
            if (closeableReference == null) {
                if (BaseConsumer.e(i)) {
                    this.f632b.b(null, i);
                }
            } else if (!BaseConsumer.f(i) || this.d) {
                CloseableReference<CloseableImage> closeableReferenceA = this.f ? this.e.a(this.c, closeableReference) : null;
                try {
                    this.f632b.a(1.0f);
                    Consumer2<O> consumer2 = this.f632b;
                    if (closeableReferenceA != null) {
                        closeableReference = closeableReferenceA;
                    }
                    consumer2.b(closeableReference, i);
                } finally {
                    Class<CloseableReference> cls = CloseableReference.j;
                    if (closeableReferenceA != null) {
                        closeableReferenceA.close();
                    }
                }
            }
        }
    }

    public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer2<CloseableReference<CloseableImage>> producer2) {
        this.a = memoryCache;
        this.f637b = cacheKeyFactory;
        this.c = producer2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        ProducerListener2 producerListener2O = producerContext.o();
        ImageRequest imageRequestE = producerContext.e();
        Object objB = producerContext.b();
        Postprocessor postprocessor = imageRequestE.f2903s;
        if (postprocessor == null || postprocessor.getPostprocessorCacheKey() == null) {
            this.c.b(consumer2, producerContext);
            return;
        }
        producerListener2O.e(producerContext, "PostprocessedBitmapMemoryCacheProducer");
        CacheKey cacheKeyC = ((DefaultCacheKeyFactory) this.f637b).c(imageRequestE, objB);
        CloseableReference<CloseableImage> closeableReference = producerContext.e().b(1) ? this.a.get(cacheKeyC) : null;
        if (closeableReference == null) {
            a aVar = new a(consumer2, cacheKeyC, postprocessor instanceof RepeatedPostprocessor, this.a, producerContext.e().b(2));
            producerListener2O.j(producerContext, "PostprocessedBitmapMemoryCacheProducer", producerListener2O.g(producerContext, "PostprocessedBitmapMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", "false") : null);
            this.c.b(aVar, producerContext);
        } else {
            producerListener2O.j(producerContext, "PostprocessedBitmapMemoryCacheProducer", producerListener2O.g(producerContext, "PostprocessedBitmapMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", "true") : null);
            producerListener2O.c(producerContext, "PostprocessedBitmapMemoryCacheProducer", true);
            producerContext.i("memory_bitmap", "postprocessed");
            consumer2.a(1.0f);
            consumer2.b(closeableReference, 1);
            closeableReference.close();
        }
    }
}
