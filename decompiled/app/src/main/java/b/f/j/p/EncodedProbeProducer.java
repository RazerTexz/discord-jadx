package b.f.j.p;

import b.f.i.ImageFormat;
import b.f.j.c.BoundedLinkedHashSet;
import b.f.j.c.BufferedDiskCache2;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.j.EncodedImage2;
import b.f.j.r.FrescoSystrace;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: EncodedProbeProducer.java */
/* renamed from: b.f.j.p.w, reason: use source file name */
/* loaded from: classes3.dex */
public class EncodedProbeProducer implements Producer2<EncodedImage2> {
    public final BufferedDiskCache2 a;

    /* renamed from: b, reason: collision with root package name */
    public final BufferedDiskCache2 f641b;
    public final CacheKeyFactory c;
    public final Producer2<EncodedImage2> d;
    public final BoundedLinkedHashSet<CacheKey> e;
    public final BoundedLinkedHashSet<CacheKey> f;

    /* compiled from: EncodedProbeProducer.java */
    /* renamed from: b.f.j.p.w$a */
    public static class a extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public final ProducerContext c;
        public final BufferedDiskCache2 d;
        public final BufferedDiskCache2 e;
        public final CacheKeyFactory f;
        public final BoundedLinkedHashSet<CacheKey> g;
        public final BoundedLinkedHashSet<CacheKey> h;

        public a(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet, BoundedLinkedHashSet<CacheKey> boundedLinkedHashSet2) {
            super(consumer2);
            this.c = producerContext;
            this.d = bufferedDiskCache2;
            this.e = bufferedDiskCache22;
            this.f = cacheKeyFactory;
            this.g = boundedLinkedHashSet;
            this.h = boundedLinkedHashSet2;
        }

        @Override // b.f.j.p.BaseConsumer
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
                        ImageRequest imageRequestE = this.c.e();
                        CacheKey cacheKeyB = ((DefaultCacheKeyFactory) this.f).b(imageRequestE, this.c.b());
                        this.g.a(cacheKeyB);
                        if ("memory_encoded".equals(this.c.l("origin"))) {
                            if (!this.h.b(cacheKeyB)) {
                                (imageRequestE.f2902b == ImageRequest.b.SMALL ? this.e : this.d).c(cacheKeyB);
                                this.h.a(cacheKeyB);
                            }
                        } else if ("disk".equals(this.c.l("origin"))) {
                            this.h.a(cacheKeyB);
                        }
                        this.f632b.b(encodedImage2, i);
                    }
                }
            } finally {
                FrescoSystrace.b();
            }
        }
    }

    public EncodedProbeProducer(BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet boundedLinkedHashSet, BoundedLinkedHashSet boundedLinkedHashSet2, Producer2<EncodedImage2> producer2) {
        this.a = bufferedDiskCache2;
        this.f641b = bufferedDiskCache22;
        this.c = cacheKeyFactory;
        this.e = boundedLinkedHashSet;
        this.f = boundedLinkedHashSet2;
        this.d = producer2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.b();
            ProducerListener2 producerListener2O = producerContext.o();
            producerListener2O.e(producerContext, "EncodedProbeProducer");
            a aVar = new a(consumer2, producerContext, this.a, this.f641b, this.c, this.e, this.f);
            producerListener2O.j(producerContext, "EncodedProbeProducer", null);
            FrescoSystrace.b();
            this.d.b(aVar, producerContext);
            FrescoSystrace.b();
        } finally {
            FrescoSystrace.b();
        }
    }
}
