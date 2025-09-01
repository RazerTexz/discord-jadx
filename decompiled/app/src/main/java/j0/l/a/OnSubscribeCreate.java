package j0.l.a;

import j0.l.e.RxRingBuffer;
import j0.l.e.n.SpscUnboundedAtomicArrayQueue;
import j0.l.e.o.SpscUnboundedArrayQueue;
import j0.l.e.o.UnsafeAccess;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Emitter;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action1;
import rx.subscriptions.SerialSubscription;

/* compiled from: OnSubscribeCreate.java */
/* renamed from: j0.l.a.i, reason: use source file name */
/* loaded from: classes3.dex */
public final class OnSubscribeCreate<T> implements Observable.a<T> {
    public final Action1<Emitter<T>> j;
    public final Emitter.BackpressureMode k;

    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: j0.l.a.i$a */
    public static abstract class a<T> extends AtomicLong implements Emitter<T>, Producer, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        public final Subscriber<? super T> actual;
        public final SerialSubscription serial = new SerialSubscription();

        public a(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        public void a() {
        }

        public void b() {
        }

        @Override // rx.Subscription
        public final boolean isUnsubscribed() {
            return this.serial.isUnsubscribed();
        }

        @Override // rx.Producer
        public final void j(long j) {
            if (b.i.a.f.e.o.f.A1(j)) {
                b.i.a.f.e.o.f.c0(this, j);
                a();
            }
        }

        @Override // j0.Observer2
        public void onCompleted() {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            try {
                this.actual.onCompleted();
            } finally {
                this.serial.unsubscribe();
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            try {
                this.actual.onError(th);
            } finally {
                this.serial.unsubscribe();
            }
        }

        @Override // rx.Subscription
        public final void unsubscribe() {
            this.serial.j.unsubscribe();
            b();
        }
    }

    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: j0.l.a.i$b */
    public static final class b<T> extends a<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        public volatile boolean done;
        public Throwable error;
        public final Queue<Object> queue;
        public final AtomicInteger wip;

        public b(Subscriber<? super T> subscriber, int i) {
            super(subscriber);
            this.queue = UnsafeAccess.b() ? new SpscUnboundedArrayQueue<>(i) : new SpscUnboundedAtomicArrayQueue<>(i);
            this.wip = new AtomicInteger();
        }

        @Override // j0.l.a.OnSubscribeCreate.a
        public void a() {
            c();
        }

        @Override // j0.l.a.OnSubscribeCreate.a
        public void b() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void c() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.actual;
            Queue<Object> queue = this.queue;
            int iAddAndGet = 1;
            do {
                long j = get();
                long j2 = 0;
                while (j2 != j) {
                    if (subscriber.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z2 = this.done;
                    Object objPoll = queue.poll();
                    boolean z3 = objPoll == null;
                    if (z2 && z3) {
                        Throwable th = this.error;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.onNext((Object) NotificationLite.b(objPoll));
                    j2++;
                }
                if (j2 == j) {
                    if (subscriber.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z4 = this.done;
                    boolean zIsEmpty = queue.isEmpty();
                    if (z4 && zIsEmpty) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            super.onError(th2);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    b.i.a.f.e.o.f.U0(this, j2);
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // j0.l.a.OnSubscribeCreate.a, j0.Observer2
        public void onCompleted() {
            this.done = true;
            c();
        }

        @Override // j0.l.a.OnSubscribeCreate.a, j0.Observer2
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            c();
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            Queue<Object> queue = this.queue;
            if (t == null) {
                t = (T) NotificationLite.f3771b;
            }
            queue.offer(t);
            c();
        }
    }

    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: j0.l.a.i$c */
    public static final class c<T> extends f<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public c(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // j0.l.a.OnSubscribeCreate.f
        public void c() {
        }
    }

    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: j0.l.a.i$d */
    public static final class d<T> extends f<T> {
        private static final long serialVersionUID = 338953216916120960L;
        private boolean done;

        public d(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // j0.l.a.OnSubscribeCreate.f
        public void c() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }

        @Override // j0.l.a.OnSubscribeCreate.a, j0.Observer2
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            super.onCompleted();
        }

        @Override // j0.l.a.OnSubscribeCreate.a, j0.Observer2
        public void onError(Throwable th) {
            if (this.done) {
                j0.o.l.b(th);
            } else {
                this.done = true;
                super.onError(th);
            }
        }

        @Override // j0.l.a.OnSubscribeCreate.f, j0.Observer2
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            super.onNext(t);
        }
    }

    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: j0.l.a.i$e */
    public static final class e<T> extends a<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        public volatile boolean done;
        public Throwable error;
        public final AtomicReference<Object> queue;
        public final AtomicInteger wip;

        public e(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        @Override // j0.l.a.OnSubscribeCreate.a
        public void a() {
            c();
        }

        @Override // j0.l.a.OnSubscribeCreate.a
        public void b() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
        
            if (r9 != r5) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
        
            if (r1.isUnsubscribed() == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x005b, code lost:
        
            r2.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
        
            r5 = r17.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
        
            if (r2.get() != null) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
        
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        
            if (r5 == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
        
            if (r11 == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
        
            r1 = r17.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
        
            if (r1 == null) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
        
            super.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0074, code lost:
        
            super.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x007a, code lost:
        
            if (r9 == 0) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x007c, code lost:
        
            b.i.a.f.e.o.f.U0(r17, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x007f, code lost:
        
            r4 = r17.wip.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.actual;
            AtomicReference<Object> atomicReference = this.queue;
            int iAddAndGet = 1;
            do {
                long j = get();
                long j2 = 0;
                while (true) {
                    boolean z2 = false;
                    if (j2 == j) {
                        break;
                    }
                    if (subscriber.isUnsubscribed()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z3 = this.done;
                    Object andSet = atomicReference.getAndSet(null);
                    boolean z4 = andSet == null;
                    if (z3 && z4) {
                        Throwable th = this.error;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                    if (z4) {
                        break;
                    }
                    subscriber.onNext((Object) NotificationLite.b(andSet));
                    j2++;
                }
            } while (iAddAndGet != 0);
        }

        @Override // j0.l.a.OnSubscribeCreate.a, j0.Observer2
        public void onCompleted() {
            this.done = true;
            c();
        }

        @Override // j0.l.a.OnSubscribeCreate.a, j0.Observer2
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            c();
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            AtomicReference<Object> atomicReference = this.queue;
            if (t == null) {
                t = (T) NotificationLite.f3771b;
            }
            atomicReference.set(t);
            c();
        }
    }

    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: j0.l.a.i$f */
    public static abstract class f<T> extends a<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        public f(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public abstract void c();

        public void onNext(T t) {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            if (get() == 0) {
                c();
            } else {
                this.actual.onNext(t);
                b.i.a.f.e.o.f.U0(this, 1L);
            }
        }
    }

    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: j0.l.a.i$g */
    public static final class g<T> extends a<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public g(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            long j;
            if (this.actual.isUnsubscribed()) {
                return;
            }
            this.actual.onNext(t);
            do {
                j = get();
                if (j == 0) {
                    return;
                }
            } while (!compareAndSet(j, j - 1));
        }
    }

    public OnSubscribeCreate(Action1<Emitter<T>> action1, Emitter.BackpressureMode backpressureMode) {
        this.j = action1;
        this.k = backpressureMode;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        int iOrdinal = this.k.ordinal();
        a bVar = iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 3 ? iOrdinal != 4 ? new b(subscriber, RxRingBuffer.j) : new e(subscriber) : new c(subscriber) : new d(subscriber) : new g(subscriber);
        subscriber.add(bVar);
        subscriber.setProducer(bVar);
        this.j.call(bVar);
    }
}
