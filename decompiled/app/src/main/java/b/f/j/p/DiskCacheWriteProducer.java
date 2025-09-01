package b.f.j.p;

import b.f.i.ImageFormat;
import b.f.j.c.BufferedDiskCache2;
import b.f.j.c.CacheKeyFactory;
import b.f.j.c.DefaultCacheKeyFactory;
import b.f.j.j.EncodedImage2;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: DiskCacheWriteProducer.java */
/* renamed from: b.f.j.p.t, reason: use source file name */
/* loaded from: classes3.dex */
public class DiskCacheWriteProducer implements Producer2<EncodedImage2> {
    public final BufferedDiskCache2 a;

    /* renamed from: b, reason: collision with root package name */
    public final BufferedDiskCache2 f638b;
    public final CacheKeyFactory c;
    public final Producer2<EncodedImage2> d;

    /* compiled from: DiskCacheWriteProducer.java */
    /* renamed from: b.f.j.p.t$b */
    public static class b extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public final ProducerContext c;
        public final BufferedDiskCache2 d;
        public final BufferedDiskCache2 e;
        public final CacheKeyFactory f;

        public b(Consumer2 consumer2, ProducerContext producerContext, BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, a aVar) {
            super(consumer2);
            this.c = producerContext;
            this.d = bufferedDiskCache2;
            this.e = bufferedDiskCache22;
            this.f = cacheKeyFactory;
        }

        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) {
            EncodedImage2 encodedImage2 = (EncodedImage2) obj;
            this.c.o().e(this.c, "DiskCacheWriteProducer");
            if (!BaseConsumer.f(i) && encodedImage2 != null && !BaseConsumer.l(i, 10)) {
                encodedImage2.x();
                if (encodedImage2.l != ImageFormat.a) {
                    ImageRequest imageRequestE = this.c.e();
                    CacheKey cacheKeyB = ((DefaultCacheKeyFactory) this.f).b(imageRequestE, this.c.b());
                    if (imageRequestE.f2902b == ImageRequest.b.SMALL) {
                        this.e.f(cacheKeyB, encodedImage2);
                    } else {
                        this.d.f(cacheKeyB, encodedImage2);
                    }
                    this.c.o().j(this.c, "DiskCacheWriteProducer", null);
                    this.f632b.b(encodedImage2, i);
                    return;
                }
            }
            this.c.o().j(this.c, "DiskCacheWriteProducer", null);
            this.f632b.b(encodedImage2, i);
        }
    }

    public DiskCacheWriteProducer(BufferedDiskCache2 bufferedDiskCache2, BufferedDiskCache2 bufferedDiskCache22, CacheKeyFactory cacheKeyFactory, Producer2<EncodedImage2> producer2) {
        this.a = bufferedDiskCache2;
        this.f638b = bufferedDiskCache22;
        this.c = cacheKeyFactory;
        this.d = producer2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        if (producerContext.q().g() >= ImageRequest.c.DISK_CACHE.g()) {
            producerContext.i("disk", "nil-result_write");
            consumer2.b(null, 1);
        } else {
            if (producerContext.e().b(32)) {
                consumer2 = new b(consumer2, producerContext, this.a, this.f638b, this.c, null);
            }
            this.d.b(consumer2, producerContext);
        }
    }
}
