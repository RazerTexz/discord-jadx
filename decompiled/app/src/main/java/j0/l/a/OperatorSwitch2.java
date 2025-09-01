package j0.l.a;

import android.R;
import androidx.recyclerview.widget.RecyclerView;
import j0.l.d.Unsubscribed;
import j0.l.e.RxRingBuffer;
import j0.l.e.n.SpscLinkedArrayQueue;
import j0.r.BooleanSubscription;
import j0.r.Subscriptions;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.subscriptions.SerialSubscription;

/* compiled from: OperatorSwitch.java */
/* renamed from: j0.l.a.y1, reason: use source file name */
/* loaded from: classes3.dex */
public final class OperatorSwitch2<T> implements Observable.b<T, Observable<? extends T>> {
    public final boolean j;

    /* compiled from: OperatorSwitch.java */
    /* renamed from: j0.l.a.y1$a */
    public static final class a {
        public static final OperatorSwitch2<Object> a = new OperatorSwitch2<>(false);
    }

    /* compiled from: OperatorSwitch.java */
    /* renamed from: j0.l.a.y1$b */
    public static final class b<T> extends Subscriber<T> {
        public final long j;
        public final c<T> k;

        public b(long j, c<T> cVar) {
            this.j = j;
            this.k = cVar;
        }

        @Override // j0.Observer2
        public void onCompleted() {
            c<T> cVar = this.k;
            long j = this.j;
            synchronized (cVar) {
                if (cVar.n.get() != j) {
                    return;
                }
                cVar.v = false;
                cVar.f3783s = null;
                cVar.b();
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            boolean zC;
            c<T> cVar = this.k;
            long j = this.j;
            synchronized (cVar) {
                if (cVar.n.get() == j) {
                    zC = cVar.c(th);
                    cVar.v = false;
                    cVar.f3783s = null;
                } else {
                    zC = true;
                }
            }
            if (zC) {
                cVar.b();
            } else {
                j0.o.l.b(th);
            }
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            c<T> cVar = this.k;
            synchronized (cVar) {
                if (cVar.n.get() != this.j) {
                    return;
                }
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = cVar.o;
                if (t == null) {
                    t = (T) NotificationLite.f3771b;
                }
                spscLinkedArrayQueue.e(this, t);
                cVar.b();
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            c<T> cVar = this.k;
            long j = this.j;
            synchronized (cVar) {
                if (cVar.n.get() != j) {
                    return;
                }
                long j2 = cVar.r;
                cVar.f3783s = producer;
                producer.j(j2);
            }
        }
    }

    /* compiled from: OperatorSwitch.java */
    /* renamed from: j0.l.a.y1$c */
    public static final class c<T> extends Subscriber<Observable<? extends T>> {
        public static final Throwable j = new Throwable("Terminal error");
        public final Subscriber<? super T> k;
        public final boolean m;
        public boolean p;
        public boolean q;
        public long r;

        /* renamed from: s, reason: collision with root package name */
        public Producer f3783s;
        public volatile boolean t;
        public Throwable u;
        public boolean v;
        public final SerialSubscription l = new SerialSubscription();
        public final AtomicLong n = new AtomicLong();
        public final SpscLinkedArrayQueue<Object> o = new SpscLinkedArrayQueue<>(RxRingBuffer.j);

        public c(Subscriber<? super T> subscriber, boolean z2) {
            this.k = subscriber;
            this.m = z2;
        }

        public boolean a(boolean z2, boolean z3, Throwable th, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue, Subscriber<? super T> subscriber, boolean z4) {
            if (this.m) {
                if (!z2 || z3 || !z4) {
                    return false;
                }
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onCompleted();
                }
                return true;
            }
            if (th != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th);
                return true;
            }
            if (!z2 || z3 || !z4) {
                return false;
            }
            subscriber.onCompleted();
            return true;
        }

        public void b() {
            Throwable th;
            Throwable th2;
            synchronized (this) {
                if (this.p) {
                    this.q = true;
                    return;
                }
                this.p = true;
                boolean z2 = this.v;
                long j2 = this.r;
                Throwable th3 = this.u;
                if (th3 != null && th3 != (th2 = j) && !this.m) {
                    this.u = th2;
                }
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.o;
                AtomicLong atomicLong = this.n;
                Subscriber<? super T> subscriber = this.k;
                long j3 = j2;
                Throwable th4 = th3;
                boolean z3 = this.t;
                while (true) {
                    long j4 = 0;
                    while (j4 != j3) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        boolean zIsEmpty = spscLinkedArrayQueue.isEmpty();
                        if (a(z3, z2, th4, spscLinkedArrayQueue, subscriber, zIsEmpty)) {
                            return;
                        }
                        if (zIsEmpty) {
                            break;
                        }
                        b bVar = (b) spscLinkedArrayQueue.poll();
                        R.anim animVar = (Object) NotificationLite.b(spscLinkedArrayQueue.poll());
                        if (atomicLong.get() == bVar.j) {
                            subscriber.onNext(animVar);
                            j4++;
                        }
                    }
                    if (j4 == j3) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        if (a(this.t, z2, th4, spscLinkedArrayQueue, subscriber, spscLinkedArrayQueue.isEmpty())) {
                            return;
                        }
                    }
                    synchronized (this) {
                        long j5 = this.r;
                        if (j5 != RecyclerView.FOREVER_NS) {
                            j5 -= j4;
                            this.r = j5;
                        }
                        j3 = j5;
                        if (!this.q) {
                            this.p = false;
                            return;
                        }
                        this.q = false;
                        z3 = this.t;
                        z2 = this.v;
                        th4 = this.u;
                        if (th4 != null && th4 != (th = j) && !this.m) {
                            this.u = th;
                        }
                    }
                }
            }
        }

        public boolean c(Throwable th) {
            Throwable th2 = this.u;
            if (th2 == j) {
                return false;
            }
            if (th2 == null) {
                this.u = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).b());
                arrayList.add(th);
                this.u = new CompositeException(arrayList);
            } else {
                this.u = new CompositeException(th2, th);
            }
            return true;
        }

        @Override // j0.Observer2
        public void onCompleted() {
            this.t = true;
            b();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            boolean zC;
            synchronized (this) {
                zC = c(th);
            }
            if (!zC) {
                j0.o.l.b(th);
            } else {
                this.t = true;
                b();
            }
        }

        @Override // j0.Observer2
        public void onNext(Object obj) {
            b bVar;
            Observable observable = (Observable) obj;
            long jIncrementAndGet = this.n.incrementAndGet();
            Subscription subscription = this.l.j.get();
            if (subscription == Unsubscribed.INSTANCE) {
                subscription = Subscriptions.a;
            }
            if (subscription != null) {
                subscription.unsubscribe();
            }
            synchronized (this) {
                bVar = new b(jIncrementAndGet, this);
                this.v = true;
                this.f3783s = null;
            }
            this.l.a(bVar);
            observable.i0(bVar);
        }
    }

    public OperatorSwitch2(boolean z2) {
        this.j = z2;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        c cVar = new c(subscriber, this.j);
        subscriber.add(cVar);
        cVar.k.add(cVar.l);
        cVar.k.add(new BooleanSubscription(new OperatorSwitch3(cVar)));
        cVar.k.setProducer(new OperatorSwitch(cVar));
        return cVar;
    }
}
