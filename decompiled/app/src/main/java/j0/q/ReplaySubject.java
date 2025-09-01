package j0.q;

import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import j0.Observer2;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.subjects.Subject;

/* compiled from: ReplaySubject.java */
/* renamed from: j0.q.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReplaySubject<T> extends Subject<T, T> {
    public static final Object[] k = new Object[0];
    public final d<T> l;

    /* compiled from: ReplaySubject.java */
    /* renamed from: j0.q.a$a */
    public interface a<T> {
    }

    /* compiled from: ReplaySubject.java */
    /* renamed from: j0.q.a$b */
    public static final class b<T> extends AtomicInteger implements Producer, Subscription {
        private static final long serialVersionUID = -5006209596735204567L;
        public final Subscriber<? super T> actual;
        public int index;
        public Object node;
        public final AtomicLong requested = new AtomicLong();
        public final d<T> state;
        public int tailIndex;

        public b(Subscriber<? super T> subscriber, d<T> dVar) {
            this.actual = subscriber;
            this.state = dVar;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.actual.isUnsubscribed();
        }

        @Override // rx.Producer
        public void j(long j) {
            if (j > 0) {
                f.c0(this.requested, j);
                ((c) this.state.buffer).a(this);
            } else if (j < 0) {
                throw new IllegalArgumentException(outline.t("n >= required but it was ", j));
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.state.a(this);
        }
    }

    /* compiled from: ReplaySubject.java */
    /* renamed from: j0.q.a$c */
    public static final class c<T> implements a<T> {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public volatile a<T> f3804b;
        public a<T> c;
        public int d;
        public volatile boolean e;
        public Throwable f;

        /* compiled from: ReplaySubject.java */
        /* renamed from: j0.q.a$c$a */
        public static final class a<T> extends AtomicReference<a<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            public final T value;

            public a(T t) {
                this.value = t;
            }
        }

        public c(int i) {
            this.a = i;
            a<T> aVar = new a<>(null);
            this.c = aVar;
            this.f3804b = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
        
            if (r10 != r5) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
        
            if (r2.isUnsubscribed() == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
        
            r18.node = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
        
            r3 = r17.e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006f, code lost:
        
            if (r7.get() != null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0071, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0072, code lost:
        
            if (r3 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0074, code lost:
        
            if (r12 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0076, code lost:
        
            r18.node = null;
            r1 = r17.f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x007a, code lost:
        
            if (r1 == null) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x007c, code lost:
        
            r2.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
        
            r2.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0086, code lost:
        
            if (r10 == 0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x008f, code lost:
        
            if (r5 == androidx.recyclerview.widget.RecyclerView.FOREVER_NS) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0091, code lost:
        
            b.i.a.f.e.o.f.U0(r18.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0096, code lost:
        
            r18.node = r7;
            r4 = r18.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(b<T> bVar) {
            if (bVar.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = bVar.actual;
            int iAddAndGet = 1;
            do {
                long j = bVar.requested.get();
                a<T> aVar = (a) bVar.node;
                if (aVar == null) {
                    aVar = this.f3804b;
                }
                long j2 = 0;
                while (true) {
                    boolean z2 = false;
                    if (j2 == j) {
                        break;
                    }
                    if (subscriber.isUnsubscribed()) {
                        bVar.node = null;
                        return;
                    }
                    boolean z3 = this.e;
                    a<T> aVar2 = aVar.get();
                    boolean z4 = aVar2 == null;
                    if (z3 && z4) {
                        bVar.node = null;
                        Throwable th = this.f;
                        if (th != null) {
                            subscriber.onError(th);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    if (z4) {
                        break;
                    }
                    subscriber.onNext(aVar2.value);
                    j2++;
                    aVar = aVar2;
                }
            } while (iAddAndGet != 0);
        }
    }

    /* compiled from: ReplaySubject.java */
    /* renamed from: j0.q.a$d */
    public static final class d<T> extends AtomicReference<b<T>[]> implements Observable.a<T>, Observer2<T> {
        public static final b[] j = new b[0];
        public static final b[] k = new b[0];
        private static final long serialVersionUID = 5952362471246910544L;
        public final a<T> buffer;

        public d(a<T> aVar) {
            this.buffer = aVar;
            lazySet(j);
        }

        public void a(b<T> bVar) {
            b<T>[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = get();
                if (bVarArr == k || bVarArr == j) {
                    return;
                }
                int length = bVarArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (bVarArr[i] == bVar) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = j;
                } else {
                    b[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i);
                    System.arraycopy(bVarArr, i + 1, bVarArr3, i, (length - i) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!compareAndSet(bVarArr, bVarArr2));
        }

        @Override // rx.functions.Action1
        public void call(Object obj) {
            boolean z2;
            Subscriber subscriber = (Subscriber) obj;
            b<T> bVar = new b<>(subscriber, this);
            subscriber.add(bVar);
            subscriber.setProducer(bVar);
            while (true) {
                b<T>[] bVarArr = get();
                z2 = false;
                if (bVarArr == k) {
                    break;
                }
                int length = bVarArr.length;
                b[] bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
                if (compareAndSet(bVarArr, bVarArr2)) {
                    z2 = true;
                    break;
                }
            }
            if (z2 && bVar.isUnsubscribed()) {
                a(bVar);
            } else {
                ((c) this.buffer).a(bVar);
            }
        }

        @Override // j0.Observer2
        public void onCompleted() {
            a<T> aVar = this.buffer;
            ((c) aVar).e = true;
            for (b<T> bVar : getAndSet(k)) {
                ((c) aVar).a(bVar);
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            a<T> aVar = this.buffer;
            c cVar = (c) aVar;
            cVar.f = th;
            cVar.e = true;
            ArrayList arrayList = null;
            for (b<T> bVar : getAndSet(k)) {
                try {
                    ((c) aVar).a(bVar);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            f.n1(arrayList);
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            a<T> aVar = this.buffer;
            c cVar = (c) aVar;
            Objects.requireNonNull(cVar);
            c.a<T> aVar2 = new c.a<>(t);
            cVar.c.set(aVar2);
            cVar.c = aVar2;
            int i = cVar.d;
            if (i == cVar.a) {
                cVar.f3804b = cVar.f3804b.get();
            } else {
                cVar.d = i + 1;
            }
            for (b<T> bVar : get()) {
                ((c) aVar).a(bVar);
            }
        }
    }

    public ReplaySubject(d<T> dVar) {
        super(dVar);
        this.l = dVar;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.l.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.l.onError(th);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        this.l.onNext(t);
    }
}
