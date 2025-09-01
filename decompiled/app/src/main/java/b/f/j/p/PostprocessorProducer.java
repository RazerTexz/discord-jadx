package b.f.j.p;

import android.graphics.Bitmap;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.ImmutableMap;
import b.f.j.j.CloseableImage;
import b.f.j.j.CloseableStaticBitmap;
import b.f.j.q.Postprocessor;
import b.f.j.q.RepeatedPostprocessor;
import b.f.j.q.RepeatedPostprocessorRunner;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: PostprocessorProducer.java */
/* renamed from: b.f.j.p.t0, reason: use source file name */
/* loaded from: classes3.dex */
public class PostprocessorProducer implements Producer2<CloseableReference<CloseableImage>> {
    public final Producer2<CloseableReference<CloseableImage>> a;

    /* renamed from: b, reason: collision with root package name */
    public final PlatformBitmapFactory f639b;
    public final Executor c;

    /* compiled from: PostprocessorProducer.java */
    /* renamed from: b.f.j.p.t0$b */
    public class b extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final ProducerListener2 c;
        public final ProducerContext d;
        public final Postprocessor e;
        public boolean f;
        public CloseableReference<CloseableImage> g;
        public int h;
        public boolean i;
        public boolean j;

        /* compiled from: PostprocessorProducer.java */
        /* renamed from: b.f.j.p.t0$b$a */
        public class a extends BaseProducerContextCallbacks {
            public a(PostprocessorProducer postprocessorProducer) {
            }

            @Override // b.f.j.p.ProducerContextCallbacks
            public void a() {
                b bVar = b.this;
                if (bVar.o()) {
                    bVar.f632b.d();
                }
            }
        }

        public b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerListener2 producerListener2, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer2);
            this.g = null;
            this.h = 0;
            this.i = false;
            this.j = false;
            this.c = producerListener2;
            this.e = postprocessor;
            this.d = producerContext;
            producerContext.f(new a(PostprocessorProducer.this));
        }

        public static void n(b bVar, CloseableReference closeableReference, int i) {
            Objects.requireNonNull(bVar);
            AnimatableValueParser.i(Boolean.valueOf(CloseableReference.y(closeableReference)));
            if (!(((CloseableImage) closeableReference.u()) instanceof CloseableStaticBitmap)) {
                bVar.q(closeableReference, i);
                return;
            }
            bVar.c.e(bVar.d, "PostprocessorProducer");
            CloseableReference<CloseableImage> closeableReferenceR = null;
            try {
                try {
                    closeableReferenceR = bVar.r((CloseableImage) closeableReference.u());
                    ProducerListener2 producerListener2 = bVar.c;
                    ProducerContext producerContext = bVar.d;
                    producerListener2.j(producerContext, "PostprocessorProducer", bVar.p(producerListener2, producerContext, bVar.e));
                    bVar.q(closeableReferenceR, i);
                } catch (Exception e) {
                    ProducerListener2 producerListener22 = bVar.c;
                    ProducerContext producerContext2 = bVar.d;
                    producerListener22.k(producerContext2, "PostprocessorProducer", e, bVar.p(producerListener22, producerContext2, bVar.e));
                    if (bVar.o()) {
                        bVar.f632b.c(e);
                    }
                }
            } finally {
                if (closeableReferenceR != null) {
                    closeableReferenceR.close();
                }
            }
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void g() {
            if (o()) {
                this.f632b.d();
            }
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void h(Throwable th) {
            if (o()) {
                this.f632b.c(th);
            }
        }

        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (!CloseableReference.y(closeableReference)) {
                if (BaseConsumer.e(i)) {
                    q(null, i);
                    return;
                }
                return;
            }
            synchronized (this) {
                if (!this.f) {
                    CloseableReference<CloseableImage> closeableReference2 = this.g;
                    this.g = CloseableReference.n(closeableReference);
                    this.h = i;
                    this.i = true;
                    boolean zS = s();
                    if (closeableReference2 != null) {
                        closeableReference2.close();
                    }
                    if (zS) {
                        PostprocessorProducer.this.c.execute(new PostprocessorProducer2(this));
                    }
                }
            }
        }

        public final boolean o() {
            synchronized (this) {
                if (this.f) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.g;
                this.g = null;
                this.f = true;
                Class<CloseableReference> cls = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return true;
            }
        }

        public final Map<String, String> p(ProducerListener2 producerListener2, ProducerContext producerContext, Postprocessor postprocessor) {
            if (producerListener2.g(producerContext, "PostprocessorProducer")) {
                return ImmutableMap.of("Postprocessor", postprocessor.getName());
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0010  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void q(CloseableReference<CloseableImage> closeableReference, int i) {
            boolean z2;
            boolean zE = BaseConsumer.e(i);
            if (!zE) {
                synchronized (this) {
                    z2 = this.f;
                }
                if (z2) {
                    if (!zE || !o()) {
                        return;
                    }
                }
            }
            this.f632b.b(closeableReference, i);
        }

        public final CloseableReference<CloseableImage> r(CloseableImage closeableImage) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            CloseableReference<Bitmap> closeableReferenceProcess = this.e.process(closeableStaticBitmap.m, PostprocessorProducer.this.f639b);
            try {
                CloseableStaticBitmap closeableStaticBitmap2 = new CloseableStaticBitmap(closeableReferenceProcess, closeableImage.b(), closeableStaticBitmap.o, closeableStaticBitmap.p);
                closeableStaticBitmap2.e(closeableStaticBitmap.k);
                CloseableReference<CloseableImage> closeableReferenceA = CloseableReference.A(closeableStaticBitmap2);
                if (closeableReferenceProcess != null) {
                    closeableReferenceProcess.close();
                }
                return closeableReferenceA;
            } catch (Throwable th) {
                Class<CloseableReference> cls = CloseableReference.j;
                if (closeableReferenceProcess != null) {
                    closeableReferenceProcess.close();
                }
                throw th;
            }
        }

        public final synchronized boolean s() {
            if (this.f || !this.i || this.j || !CloseableReference.y(this.g)) {
                return false;
            }
            this.j = true;
            return true;
        }
    }

    /* compiled from: PostprocessorProducer.java */
    /* renamed from: b.f.j.p.t0$c */
    public class c extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        public boolean c;
        public CloseableReference<CloseableImage> d;

        public c(PostprocessorProducer postprocessorProducer, b bVar, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext, a aVar) {
            super(bVar);
            this.c = false;
            this.d = null;
            repeatedPostprocessor.a(this);
            producerContext.f(new PostprocessorProducer3(this, postprocessorProducer));
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void g() {
            if (n()) {
                this.f632b.d();
            }
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void h(Throwable th) {
            if (n()) {
                this.f632b.c(th);
            }
        }

        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (BaseConsumer.f(i)) {
                return;
            }
            synchronized (this) {
                if (!this.c) {
                    CloseableReference<CloseableImage> closeableReference2 = this.d;
                    this.d = CloseableReference.n(closeableReference);
                    if (closeableReference2 != null) {
                        closeableReference2.close();
                    }
                }
            }
            synchronized (this) {
                if (!this.c) {
                    CloseableReference closeableReferenceN = CloseableReference.n(this.d);
                    try {
                        this.f632b.b(closeableReferenceN, 0);
                    } finally {
                        if (closeableReferenceN != null) {
                            closeableReferenceN.close();
                        }
                    }
                }
            }
        }

        public final boolean n() {
            synchronized (this) {
                if (this.c) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.d;
                this.d = null;
                this.c = true;
                Class<CloseableReference> cls = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return true;
            }
        }
    }

    /* compiled from: PostprocessorProducer.java */
    /* renamed from: b.f.j.p.t0$d */
    public class d extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public d(PostprocessorProducer postprocessorProducer, b bVar, a aVar) {
            super(bVar);
        }

        @Override // b.f.j.p.BaseConsumer
        public void i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (BaseConsumer.f(i)) {
                return;
            }
            this.f632b.b(closeableReference, i);
        }
    }

    public PostprocessorProducer(Producer2<CloseableReference<CloseableImage>> producer2, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        Objects.requireNonNull(producer2);
        this.a = producer2;
        this.f639b = platformBitmapFactory;
        Objects.requireNonNull(executor);
        this.c = executor;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        ProducerListener2 producerListener2O = producerContext.o();
        Postprocessor postprocessor = producerContext.e().f2903s;
        Objects.requireNonNull(postprocessor);
        b bVar = new b(consumer2, producerListener2O, postprocessor, producerContext);
        this.a.b(postprocessor instanceof RepeatedPostprocessor ? new c(this, bVar, (RepeatedPostprocessor) postprocessor, producerContext, null) : new d(this, bVar, null), producerContext);
    }
}
