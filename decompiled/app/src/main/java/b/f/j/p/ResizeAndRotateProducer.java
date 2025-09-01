package b.f.j.p;

import b.f.d.d.ImmutableList;
import b.f.d.d.ImmutableMap;
import b.f.d.g.PooledByteBufferFactory;
import b.f.d.g.PooledByteBufferOutputStream;
import b.f.d.l.TriState;
import b.f.i.DefaultImageFormats;
import b.f.i.ImageFormat;
import b.f.j.d.ResizeOptions;
import b.f.j.d.RotationOptions;
import b.f.j.j.EncodedImage2;
import b.f.j.p.JobScheduler;
import b.f.j.s.ImageTranscodeResult;
import b.f.j.s.ImageTranscoder;
import b.f.j.s.ImageTranscoderFactory;
import b.f.j.s.JpegTranscoderUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: ResizeAndRotateProducer.java */
/* renamed from: b.f.j.p.c1, reason: use source file name */
/* loaded from: classes3.dex */
public class ResizeAndRotateProducer implements Producer2<EncodedImage2> {
    public final Executor a;

    /* renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f607b;
    public final Producer2<EncodedImage2> c;
    public final boolean d;
    public final ImageTranscoderFactory e;

    /* compiled from: ResizeAndRotateProducer.java */
    /* renamed from: b.f.j.p.c1$a */
    public class a extends DelegatingConsumer<EncodedImage2, EncodedImage2> {
        public final boolean c;
        public final ImageTranscoderFactory d;
        public final ProducerContext e;
        public boolean f;
        public final JobScheduler g;

        /* compiled from: ResizeAndRotateProducer.java */
        /* renamed from: b.f.j.p.c1$a$a, reason: collision with other inner class name */
        public class C0025a implements JobScheduler.c {
            public C0025a(ResizeAndRotateProducer resizeAndRotateProducer) {
            }

            @Override // b.f.j.p.JobScheduler.c
            public void a(EncodedImage2 encodedImage2, int i) throws Throwable {
                ImageTranscodeResult imageTranscodeResultC;
                a aVar = a.this;
                ImageTranscoderFactory imageTranscoderFactory = aVar.d;
                encodedImage2.x();
                ImageTranscoder imageTranscoderCreateImageTranscoder = imageTranscoderFactory.createImageTranscoder(encodedImage2.l, a.this.c);
                Objects.requireNonNull(imageTranscoderCreateImageTranscoder);
                aVar.e.o().e(aVar.e, "ResizeAndRotateProducer");
                ImageRequest imageRequestE = aVar.e.e();
                PooledByteBufferOutputStream pooledByteBufferOutputStreamA = ResizeAndRotateProducer.this.f607b.a();
                try {
                    try {
                        imageTranscodeResultC = imageTranscoderCreateImageTranscoder.c(encodedImage2, pooledByteBufferOutputStreamA, imageRequestE.k, imageRequestE.j, null, 85);
                    } catch (Exception e) {
                        aVar.e.o().k(aVar.e, "ResizeAndRotateProducer", e, null);
                        if (BaseConsumer.e(i)) {
                            aVar.f632b.c(e);
                        }
                    }
                    if (imageTranscodeResultC.a == 2) {
                        throw new RuntimeException("Error while transcoding the image");
                    }
                    Map<String, String> mapN = aVar.n(encodedImage2, imageRequestE.j, imageTranscodeResultC, imageTranscoderCreateImageTranscoder.a());
                    CloseableReference closeableReferenceA = CloseableReference.A(((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStreamA).b());
                    try {
                        EncodedImage2 encodedImage22 = new EncodedImage2(closeableReferenceA);
                        encodedImage22.l = DefaultImageFormats.a;
                        try {
                            encodedImage22.q();
                            aVar.e.o().j(aVar.e, "ResizeAndRotateProducer", mapN);
                            if (imageTranscodeResultC.a != 1) {
                                i |= 16;
                            }
                            aVar.f632b.b(encodedImage22, i);
                        } finally {
                            encodedImage22.close();
                        }
                    } finally {
                        if (closeableReferenceA != null) {
                            closeableReferenceA.close();
                        }
                    }
                } finally {
                    pooledByteBufferOutputStreamA.close();
                }
            }
        }

        /* compiled from: ResizeAndRotateProducer.java */
        /* renamed from: b.f.j.p.c1$a$b */
        public class b extends BaseProducerContextCallbacks {
            public final /* synthetic */ Consumer2 a;

            public b(ResizeAndRotateProducer resizeAndRotateProducer, Consumer2 consumer2) {
                this.a = consumer2;
            }

            @Override // b.f.j.p.ProducerContextCallbacks
            public void a() {
                a.this.g.a();
                a.this.f = true;
                this.a.d();
            }

            @Override // b.f.j.p.BaseProducerContextCallbacks, b.f.j.p.ProducerContextCallbacks
            public void b() {
                if (a.this.e.p()) {
                    a.this.g.d();
                }
            }
        }

        public a(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext, boolean z2, ImageTranscoderFactory imageTranscoderFactory) {
            super(consumer2);
            this.f = false;
            this.e = producerContext;
            Objects.requireNonNull(producerContext.e());
            this.c = z2;
            this.d = imageTranscoderFactory;
            this.g = new JobScheduler(ResizeAndRotateProducer.this.a, new C0025a(ResizeAndRotateProducer.this), 100);
            producerContext.f(new b(ResizeAndRotateProducer.this, consumer2));
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
        @Override // b.f.j.p.BaseConsumer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void i(Object obj, int i) {
            boolean z2;
            TriState triStateF;
            boolean zContains;
            EncodedImage2 encodedImage2A = (EncodedImage2) obj;
            TriState triState = TriState.UNSET;
            if (this.f) {
                return;
            }
            boolean zE = BaseConsumer.e(i);
            boolean z3 = true;
            if (encodedImage2A == null) {
                if (zE) {
                    this.f632b.b(null, 1);
                    return;
                }
                return;
            }
            encodedImage2A.x();
            ImageFormat imageFormat = encodedImage2A.l;
            ImageRequest imageRequestE = this.e.e();
            ImageTranscoder imageTranscoderCreateImageTranscoder = this.d.createImageTranscoder(imageFormat, this.c);
            Objects.requireNonNull(imageTranscoderCreateImageTranscoder);
            encodedImage2A.x();
            if (encodedImage2A.l == ImageFormat.a) {
                triStateF = triState;
            } else {
                encodedImage2A.x();
                if (imageTranscoderCreateImageTranscoder.d(encodedImage2A.l)) {
                    RotationOptions rotationOptions = imageRequestE.k;
                    if (rotationOptions.d) {
                        z2 = false;
                        if (!z2 && !imageTranscoderCreateImageTranscoder.b(encodedImage2A, imageRequestE.k, imageRequestE.j)) {
                            z3 = false;
                        }
                        triStateF = TriState.f(z3);
                    } else {
                        if (JpegTranscoderUtils.b(rotationOptions, encodedImage2A) == 0) {
                            if (!rotationOptions.b() || rotationOptions.d) {
                                encodedImage2A.n = 0;
                                zContains = false;
                            } else {
                                ImmutableList<Integer> immutableList = JpegTranscoderUtils.a;
                                encodedImage2A.x();
                                zContains = immutableList.contains(Integer.valueOf(encodedImage2A.n));
                            }
                            if (zContains) {
                            }
                            if (!z2) {
                                z3 = false;
                            }
                            triStateF = TriState.f(z3);
                        }
                        z2 = true;
                        if (!z2) {
                        }
                        triStateF = TriState.f(z3);
                    }
                } else {
                    triStateF = TriState.NO;
                }
            }
            if (zE || triStateF != triState) {
                if (triStateF == TriState.YES) {
                    if (this.g.f(encodedImage2A, i)) {
                        if (zE || this.e.p()) {
                            this.g.d();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (imageFormat != DefaultImageFormats.a && imageFormat != DefaultImageFormats.k) {
                    RotationOptions rotationOptions2 = this.e.e().k;
                    if (!rotationOptions2.c() && rotationOptions2.b()) {
                        int iA = rotationOptions2.a();
                        encodedImage2A = EncodedImage2.a(encodedImage2A);
                        if (encodedImage2A != null) {
                            encodedImage2A.m = iA;
                        }
                    }
                } else if (!this.e.e().k.d) {
                    encodedImage2A.x();
                    if (encodedImage2A.m != 0) {
                        encodedImage2A.x();
                        if (encodedImage2A.m != -1 && (encodedImage2A = EncodedImage2.a(encodedImage2A)) != null) {
                            encodedImage2A.m = 0;
                        }
                    }
                }
                this.f632b.b(encodedImage2A, i);
            }
        }

        public final Map<String, String> n(EncodedImage2 encodedImage2, ResizeOptions resizeOptions, ImageTranscodeResult imageTranscodeResult, String str) {
            String str2;
            long j;
            if (!this.e.o().g(this.e, "ResizeAndRotateProducer")) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            encodedImage2.x();
            sb.append(encodedImage2.o);
            sb.append("x");
            encodedImage2.x();
            sb.append(encodedImage2.p);
            String string = sb.toString();
            if (resizeOptions != null) {
                str2 = resizeOptions.a + "x" + resizeOptions.f566b;
            } else {
                str2 = "Unspecified";
            }
            HashMap map = new HashMap();
            encodedImage2.x();
            map.put("Image format", String.valueOf(encodedImage2.l));
            map.put("Original size", string);
            map.put("Requested size", str2);
            JobScheduler jobScheduler = this.g;
            synchronized (jobScheduler) {
                j = jobScheduler.j - jobScheduler.i;
            }
            map.put("queueTime", String.valueOf(j));
            map.put("Transcoder id", str);
            map.put("Transcoding result", String.valueOf(imageTranscodeResult));
            return new ImmutableMap(map);
        }
    }

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer2<EncodedImage2> producer2, boolean z2, ImageTranscoderFactory imageTranscoderFactory) {
        Objects.requireNonNull(executor);
        this.a = executor;
        Objects.requireNonNull(pooledByteBufferFactory);
        this.f607b = pooledByteBufferFactory;
        Objects.requireNonNull(producer2);
        this.c = producer2;
        Objects.requireNonNull(imageTranscoderFactory);
        this.e = imageTranscoderFactory;
        this.d = z2;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        this.c.b(new a(consumer2, producerContext, this.d, this.e), producerContext);
    }
}
