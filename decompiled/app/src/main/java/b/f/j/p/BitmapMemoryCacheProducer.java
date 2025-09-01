package b.f.j.p;

import b.f.d.d.ImmutableMap;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.c.MemoryCache;
import b.f.j.j.CloseableImage;
import b.f.j.j.ImmutableQualityInfo;
import b.f.j.j.QualityInfo;
import b.f.j.r.FrescoSystrace;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: BitmapMemoryCacheProducer.java */
/* renamed from: b.f.j.p.h, reason: use source file name */
/* loaded from: classes3.dex */
public class BitmapMemoryCacheProducer implements Producer2<CloseableReference<CloseableImage>> {
    public final MemoryCache<CacheKey, CloseableImage> a;

    /* renamed from: b, reason: collision with root package name */
    public final CacheKeyFactory f613b;
    public final Producer2<CloseableReference<CloseableImage>> c;

    /* compiled from: BitmapMemoryCacheProducer.java */
    /* renamed from: b.f.j.p.h$a */
    public class a extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final /* synthetic */ CacheKey c;
        public final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer2 consumer2, CacheKey cacheKey, boolean z2) {
            super(consumer2);
            this.c = cacheKey;
            this.d = z2;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0078 A[Catch: all -> 0x00a9, TRY_LEAVE, TryCatch #0 {all -> 0x00a9, blocks: (B:3:0x0002, B:6:0x000e, B:8:0x0018, B:10:0x0024, B:14:0x0030, B:21:0x0062, B:24:0x006b, B:26:0x0070, B:27:0x0073, B:28:0x0074, B:30:0x0078, B:38:0x0095, B:41:0x009d, B:42:0x00a0, B:43:0x00a1, B:32:0x0084, B:33:0x008b, B:36:0x0090, B:16:0x003c, B:18:0x0057, B:23:0x0066), top: B:49:0x0002, inners: #1, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0095 A[Catch: all -> 0x00a9, TRY_ENTER, TryCatch #0 {all -> 0x00a9, blocks: (B:3:0x0002, B:6:0x000e, B:8:0x0018, B:10:0x0024, B:14:0x0030, B:21:0x0062, B:24:0x006b, B:26:0x0070, B:27:0x0073, B:28:0x0074, B:30:0x0078, B:38:0x0095, B:41:0x009d, B:42:0x00a0, B:43:0x00a1, B:32:0x0084, B:33:0x008b, B:36:0x0090, B:16:0x003c, B:18:0x0057, B:23:0x0066), top: B:49:0x0002, inners: #1, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // b.f.j.p.BaseConsumer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void i(Object obj, int i) {
            CloseableReference<CloseableImage> closeableReferenceA;
            CloseableReference<CloseableImage> closeableReference;
            CloseableReference<CloseableImage> closeableReference2 = (CloseableReference) obj;
            try {
                FrescoSystrace.b();
                boolean zE = BaseConsumer.e(i);
                if (closeableReference2 == null) {
                    if (zE) {
                        this.f632b.b(null, i);
                    }
                } else if (closeableReference2.u().d() || BaseConsumer.m(i, 8)) {
                    this.f632b.b(closeableReference2, i);
                } else if (zE || (closeableReference = BitmapMemoryCacheProducer.this.a.get(this.c)) == null) {
                    closeableReferenceA = this.d ? BitmapMemoryCacheProducer.this.a.a(this.c, closeableReference2) : null;
                    if (zE) {
                        try {
                            this.f632b.a(1.0f);
                        } catch (Throwable th) {
                            if (closeableReferenceA != null) {
                                closeableReferenceA.close();
                            }
                            throw th;
                        }
                    }
                    Consumer2<O> consumer2 = this.f632b;
                    if (closeableReferenceA != null) {
                        closeableReference2 = closeableReferenceA;
                    }
                    consumer2.b(closeableReference2, i);
                    if (closeableReferenceA != null) {
                        closeableReferenceA.close();
                    }
                } else {
                    try {
                        QualityInfo qualityInfoB = closeableReference2.u().b();
                        QualityInfo qualityInfoB2 = closeableReference.u().b();
                        if (((ImmutableQualityInfo) qualityInfoB2).d || ((ImmutableQualityInfo) qualityInfoB2).f591b >= ((ImmutableQualityInfo) qualityInfoB).f591b) {
                            this.f632b.b(closeableReference, i);
                            closeableReference.close();
                        } else {
                            if (this.d) {
                            }
                            if (zE) {
                            }
                            Consumer2<O> consumer22 = this.f632b;
                            if (closeableReferenceA != null) {
                            }
                            consumer22.b(closeableReference2, i);
                            if (closeableReferenceA != null) {
                            }
                        }
                    } finally {
                        closeableReference.close();
                    }
                }
            } finally {
                FrescoSystrace.b();
            }
        }
    }

    public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer2<CloseableReference<CloseableImage>> producer2) {
        this.a = memoryCache;
        this.f613b = cacheKeyFactory;
        this.c = producer2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.b();
            ProducerListener2 producerListener2O = producerContext.o();
            producerListener2O.e(producerContext, d());
            CacheKey cacheKeyA = ((DefaultCacheKeyFactory) this.f613b).a(producerContext.e(), producerContext.b());
            CloseableReference<CloseableImage> closeableReference = producerContext.e().b(1) ? this.a.get(cacheKeyA) : null;
            if (closeableReference != null) {
                producerContext.j(closeableReference.u().a());
                boolean z2 = ((ImmutableQualityInfo) closeableReference.u().b()).d;
                if (z2) {
                    producerListener2O.j(producerContext, d(), producerListener2O.g(producerContext, d()) ? ImmutableMap.of("cached_value_found", "true") : null);
                    producerListener2O.c(producerContext, d(), true);
                    producerContext.i("memory_bitmap", c());
                    consumer2.a(1.0f);
                }
                consumer2.b(closeableReference, z2 ? 1 : 0);
                closeableReference.close();
                if (z2) {
                    return;
                }
            }
            if (producerContext.q().g() >= ImageRequest.c.BITMAP_MEMORY_CACHE.g()) {
                producerListener2O.j(producerContext, d(), producerListener2O.g(producerContext, d()) ? ImmutableMap.of("cached_value_found", "false") : null);
                producerListener2O.c(producerContext, d(), false);
                producerContext.i("memory_bitmap", c());
                consumer2.b(null, 1);
                return;
            }
            Consumer2<CloseableReference<CloseableImage>> consumer2E = e(consumer2, cacheKeyA, producerContext.e().b(2));
            producerListener2O.j(producerContext, d(), producerListener2O.g(producerContext, d()) ? ImmutableMap.of("cached_value_found", "false") : null);
            FrescoSystrace.b();
            this.c.b(consumer2E, producerContext);
            FrescoSystrace.b();
        } finally {
            FrescoSystrace.b();
        }
    }

    public String c() {
        return "pipe_bg";
    }

    public String d() {
        return "BitmapMemoryCacheProducer";
    }

    public Consumer2<CloseableReference<CloseableImage>> e(Consumer2<CloseableReference<CloseableImage>> consumer2, CacheKey cacheKey, boolean z2) {
        return new a(consumer2, cacheKey, z2);
    }
}
