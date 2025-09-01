package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.k.Func1;
import j0.l.a.OnSubscribeFromIterable;
import j0.l.e.ExceptionsUtils;
import j0.l.e.RxRingBuffer;
import j0.l.e.n.SpscAtomicArrayQueue;
import j0.l.e.n.SpscLinkedArrayQueue;
import j0.l.e.o.SpscArrayQueue;
import j0.l.e.o.UnsafeAccess;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;

/* compiled from: OnSubscribeFlattenIterable.java */
/* renamed from: j0.l.a.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class OnSubscribeFlattenIterable2<T, R> implements Observable.a<R> {
    public final Observable<? extends T> j;
    public final Func1<? super T, ? extends Iterable<? extends R>> k;
    public final int l;

    /* compiled from: OnSubscribeFlattenIterable.java */
    /* renamed from: j0.l.a.n$a */
    public static final class a<T, R> extends Subscriber<T> {
        public final Subscriber<? super R> j;
        public final Func1<? super T, ? extends Iterable<? extends R>> k;
        public final long l;
        public final Queue<Object> m;
        public volatile boolean q;
        public long r;

        /* renamed from: s, reason: collision with root package name */
        public Iterator<? extends R> f3777s;
        public final AtomicReference<Throwable> n = new AtomicReference<>();
        public final AtomicInteger p = new AtomicInteger();
        public final AtomicLong o = new AtomicLong();

        public a(Subscriber<? super R> subscriber, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
            this.j = subscriber;
            this.k = func1;
            if (i == Integer.MAX_VALUE) {
                this.l = RecyclerView.FOREVER_NS;
                this.m = new SpscLinkedArrayQueue(RxRingBuffer.j);
            } else {
                this.l = i - (i >> 2);
                if (UnsafeAccess.b()) {
                    this.m = new SpscArrayQueue(i);
                } else {
                    this.m = new SpscAtomicArrayQueue(i);
                }
            }
            request(i);
        }

        public boolean a(boolean z2, boolean z3, Subscriber<?> subscriber, Queue<?> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                this.f3777s = null;
                return true;
            }
            if (!z2) {
                return false;
            }
            if (this.n.get() == null) {
                if (!z3) {
                    return false;
                }
                subscriber.onCompleted();
                return true;
            }
            Throwable thH = ExceptionsUtils.h(this.n);
            unsubscribe();
            queue.clear();
            this.f3777s = null;
            subscriber.onError(thH);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b() {
            int i;
            if (this.p.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.j;
            Queue<?> queue = this.m;
            int iAddAndGet = 1;
            while (true) {
                Iterator<? extends R> it = this.f3777s;
                boolean z2 = false;
                if (it == null) {
                    boolean z3 = this.q;
                    Object objPoll = queue.poll();
                    boolean z4 = objPoll == null;
                    if (a(z3, z4, subscriber, queue)) {
                        return;
                    }
                    if (z4) {
                        i = iAddAndGet;
                    } else {
                        long j = this.r + 1;
                        i = iAddAndGet;
                        if (j == this.l) {
                            this.r = 0L;
                            request(j);
                        } else {
                            this.r = j;
                        }
                        try {
                            it = this.k.call((Object) NotificationLite.b(objPoll)).iterator();
                        } catch (Throwable th) {
                            b.i.a.f.e.o.f.o1(th);
                            onError(th);
                        }
                        if (it.hasNext()) {
                            this.f3777s = it;
                        } else {
                            iAddAndGet = i;
                        }
                    }
                    if (it != null) {
                        long j2 = this.o.get();
                        long j3 = 0;
                        while (j3 != j2) {
                            if (a(this.q, false, subscriber, queue)) {
                                return;
                            }
                            try {
                                subscriber.onNext(it.next());
                            } catch (Throwable th2) {
                                b.i.a.f.e.o.f.o1(th2);
                                this.f3777s = null;
                                onError(th2);
                            }
                            if (a(this.q, false, subscriber, queue)) {
                                return;
                            }
                            j3++;
                            try {
                            } catch (Throwable th3) {
                                b.i.a.f.e.o.f.o1(th3);
                                this.f3777s = null;
                                onError(th3);
                            }
                            if (!it.hasNext()) {
                                this.f3777s = null;
                                it = null;
                                break;
                            }
                        }
                        if (j3 == j2) {
                            boolean z5 = this.q;
                            if (queue.isEmpty() && it == null) {
                                z2 = true;
                            }
                            if (a(z5, z2, subscriber, queue)) {
                                return;
                            }
                        }
                        if (j3 != 0) {
                            b.i.a.f.e.o.f.U0(this.o, j3);
                        }
                        if (it == null) {
                            iAddAndGet = i;
                        }
                    }
                    iAddAndGet = this.p.addAndGet(-i);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // j0.Observer2
        public void onCompleted() {
            this.q = true;
            b();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            if (!ExceptionsUtils.f(this.n, th)) {
                j0.o.l.b(th);
            } else {
                this.q = true;
                b();
            }
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            Queue<Object> queue = this.m;
            if (t == null) {
                t = (T) NotificationLite.f3771b;
            }
            if (queue.offer(t)) {
                b();
            } else {
                unsubscribe();
                onError(new MissingBackpressureException());
            }
        }
    }

    /* compiled from: OnSubscribeFlattenIterable.java */
    /* renamed from: j0.l.a.n$b */
    public static final class b<T, R> implements Observable.a<R> {
        public final T j;
        public final Func1<? super T, ? extends Iterable<? extends R>> k;

        public b(T t, Func1<? super T, ? extends Iterable<? extends R>> func1) {
            this.j = t;
            this.k = func1;
        }

        @Override // rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            try {
                Iterator<? extends R> it = this.k.call(this.j).iterator();
                if (it.hasNext()) {
                    subscriber.setProducer(new OnSubscribeFromIterable.a(subscriber, it));
                } else {
                    subscriber.onCompleted();
                }
            } catch (Throwable th) {
                b.i.a.f.e.o.f.p1(th, subscriber, this.j);
            }
        }
    }

    public OnSubscribeFlattenIterable2(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        this.j = observable;
        this.k = func1;
        this.l = i;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, this.k, this.l);
        subscriber.add(aVar);
        subscriber.setProducer(new OnSubscribeFlattenIterable(this, aVar));
        this.j.i0(aVar);
    }
}
