package b.f.j.p;

import b.f.d.d.ImmutableMap;
import b.f.i.ImageFormat;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.c.MemoryCache;
import b.f.j.j.EncodedImage2;
import b.f.j.r.FrescoSystrace;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: EncodedMemoryCacheProducer.java */
/* renamed from: b.f.j.p.v, reason: use source file name */
/* loaded from: classes3.dex */
public class EncodedMemoryCacheProducer implements Producer2<EncodedImage2> {
    public final MemoryCache<CacheKey, PooledByteBuffer> a;

    /* renamed from: b, reason: collision with root package name */
    public final CacheKeyFactory f640b;
    public final Producer2<EncodedImage2> c;

    /* compiled from: EncodedMemoryCacheProducer.java */
    /* renamed from: b.f.j.p.v$a */
    public static class a extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public final MemoryCache<CacheKey, PooledByteBuffer> c;
        public final CacheKey d;
        public final boolean e;
        public final boolean f;

        public a(Consumer2<EncodedImage2> consumer2, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKey cacheKey, boolean z2, boolean z3) {
            super(consumer2);
            this.c = memoryCache;
            this.d = cacheKey;
            this.e = z2;
            this.f = z3;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0065 A[Catch: all -> 0x0074, TryCatch #1 {all -> 0x0074, blocks: (B:3:0x0002, B:6:0x000d, B:8:0x0015, B:11:0x001f, B:19:0x0036, B:22:0x0043, B:24:0x0052, B:26:0x0057, B:27:0x005a, B:29:0x005c, B:30:0x005f, B:32:0x0061, B:33:0x0064, B:34:0x0065, B:35:0x006b, B:14:0x0026, B:16:0x002a, B:18:0x002e, B:23:0x0046, B:21:0x003b), top: B:43:0x0002, inners: #0, #2, #3 }] */
        @Override // b.f.j.p.BaseConsumer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void i(Object obj, int i) {
            EncodedImage2 encodedImage2 = (EncodedImage2) obj;
            try {
                FrescoSystrace.b();
                if (BaseConsumer.f(i) || encodedImage2 == null || BaseConsumer.l(i, 10)) {
                    this.f632b.b(encodedImage2, i);
                } else {
                    encodedImage2.x();
                    if (encodedImage2.l == ImageFormat.a) {
                        this.f632b.b(encodedImage2, i);
                    } else {
                        CloseableReference<PooledByteBuffer> closeableReferenceC = encodedImage2.c();
                        if (closeableReferenceC != null) {
                            CloseableReference<PooledByteBuffer> closeableReferenceA = null;
                            try {
                                if (this.f && this.e) {
                                    closeableReferenceA = this.c.a(this.d, closeableReferenceC);
                                }
                                if (closeableReferenceA != null) {
                                    try {
                                        EncodedImage2 encodedImage22 = new EncodedImage2(closeableReferenceA);
                                        encodedImage22.b(encodedImage2);
                                        try {
                                            this.f632b.a(1.0f);
                                            this.f632b.b(encodedImage22, i);
                                            encodedImage22.close();
                                        } catch (Throwable th) {
                                            encodedImage22.close();
                                            throw th;
                                        }
                                    } finally {
                                        closeableReferenceA.close();
                                    }
                                } else {
                                    this.f632b.b(encodedImage2, i);
                                }
                            } finally {
                                closeableReferenceC.close();
                            }
                        }
                    }
                }
            } finally {
                FrescoSystrace.b();
            }
        }
    }

    public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKeyFactory cacheKeyFactory, Producer2<EncodedImage2> producer2) {
        this.a = memoryCache;
        this.f640b = cacheKeyFactory;
        this.c = producer2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.b();
            ProducerListener2 producerListener2O = producerContext.o();
            producerListener2O.e(producerContext, "EncodedMemoryCacheProducer");
            CacheKey cacheKeyB = ((DefaultCacheKeyFactory) this.f640b).b(producerContext.e(), producerContext.b());
            CloseableReference<PooledByteBuffer> closeableReference = producerContext.e().b(4) ? this.a.get(cacheKeyB) : null;
            try {
                if (closeableReference != null) {
                    EncodedImage2 encodedImage2 = new EncodedImage2(closeableReference);
                    try {
                        producerListener2O.j(producerContext, "EncodedMemoryCacheProducer", producerListener2O.g(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", "true") : null);
                        producerListener2O.c(producerContext, "EncodedMemoryCacheProducer", true);
                        producerContext.n("memory_encoded");
                        consumer2.a(1.0f);
                        consumer2.b(encodedImage2, 1);
                        closeableReference.close();
                        return;
                    } finally {
                        encodedImage2.close();
                    }
                }
                if (producerContext.q().g() >= ImageRequest.c.ENCODED_MEMORY_CACHE.g()) {
                    producerListener2O.j(producerContext, "EncodedMemoryCacheProducer", producerListener2O.g(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", "false") : null);
                    producerListener2O.c(producerContext, "EncodedMemoryCacheProducer", false);
                    producerContext.i("memory_encoded", "nil-result");
                    consumer2.b(null, 1);
                    return;
                }
                a aVar = new a(consumer2, this.a, cacheKeyB, producerContext.e().b(8), producerContext.g().getExperiments().e);
                producerListener2O.j(producerContext, "EncodedMemoryCacheProducer", producerListener2O.g(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.of("cached_value_found", "false") : null);
                this.c.b(aVar, producerContext);
                Class<CloseableReference> cls = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
            } finally {
                Class<CloseableReference> cls2 = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
            }
        } finally {
            FrescoSystrace.b();
        }
    }
}
