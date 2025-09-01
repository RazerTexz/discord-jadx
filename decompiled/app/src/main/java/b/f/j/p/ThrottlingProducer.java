package b.f.j.p;

import android.util.Pair;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* compiled from: ThrottlingProducer.java */
/* renamed from: b.f.j.p.i1, reason: use source file name */
/* loaded from: classes3.dex */
public class ThrottlingProducer<T> implements Producer2<T> {
    public final Producer2<T> a;

    /* renamed from: b, reason: collision with root package name */
    public int f616b;
    public final ConcurrentLinkedQueue<Pair<Consumer2<T>, ProducerContext>> c;
    public final Executor d;

    /* compiled from: ThrottlingProducer.java */
    /* renamed from: b.f.j.p.i1$b */
    public class b extends DelegatingConsumer<T, T> {

        /* compiled from: ThrottlingProducer.java */
        /* renamed from: b.f.j.p.i1$b$a */
        public class a implements Runnable {
            public final /* synthetic */ Pair j;

            public a(Pair pair) {
                this.j = pair;
            }

            @Override // java.lang.Runnable
            public void run() {
                ThrottlingProducer throttlingProducer = ThrottlingProducer.this;
                Pair pair = this.j;
                Consumer2 consumer2 = (Consumer2) pair.first;
                ProducerContext producerContext = (ProducerContext) pair.second;
                Objects.requireNonNull(throttlingProducer);
                producerContext.o().j(producerContext, "ThrottlingProducer", null);
                throttlingProducer.a.b(new b(consumer2, null), producerContext);
            }
        }

        public b(Consumer2 consumer2, a aVar) {
            super(consumer2);
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void g() {
            this.f632b.d();
            n();
        }

        @Override // b.f.j.p.DelegatingConsumer, b.f.j.p.BaseConsumer
        public void h(Throwable th) {
            this.f632b.c(th);
            n();
        }

        @Override // b.f.j.p.BaseConsumer
        public void i(T t, int i) {
            this.f632b.b(t, i);
            if (BaseConsumer.e(i)) {
                n();
            }
        }

        public final void n() {
            Pair<Consumer2<T>, ProducerContext> pairPoll;
            synchronized (ThrottlingProducer.this) {
                pairPoll = ThrottlingProducer.this.c.poll();
                if (pairPoll == null) {
                    ThrottlingProducer throttlingProducer = ThrottlingProducer.this;
                    throttlingProducer.f616b--;
                }
            }
            if (pairPoll != null) {
                ThrottlingProducer.this.d.execute(new a(pairPoll));
            }
        }
    }

    public ThrottlingProducer(int i, Executor executor, Producer2<T> producer2) {
        Objects.requireNonNull(executor);
        this.d = executor;
        Objects.requireNonNull(producer2);
        this.a = producer2;
        this.c = new ConcurrentLinkedQueue<>();
        this.f616b = 0;
    }

    @Override // b.f.j.p.Producer2
    public void b(Consumer2<T> consumer2, ProducerContext producerContext) {
        boolean z2;
        producerContext.o().e(producerContext, "ThrottlingProducer");
        synchronized (this) {
            int i = this.f616b;
            z2 = true;
            if (i >= 5) {
                this.c.add(Pair.create(consumer2, producerContext));
            } else {
                this.f616b = i + 1;
                z2 = false;
            }
        }
        if (z2) {
            return;
        }
        producerContext.o().j(producerContext, "ThrottlingProducer", null);
        this.a.b(new b(consumer2, null), producerContext);
    }
}
