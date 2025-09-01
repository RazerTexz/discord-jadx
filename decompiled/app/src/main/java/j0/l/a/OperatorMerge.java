package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.l.e.RxRingBuffer;
import j0.l.e.ScalarSynchronousObservable;
import j0.l.e.n.SpscAtomicArrayQueue;
import j0.l.e.n.SpscExactAtomicArrayQueue;
import j0.l.e.n.SpscUnboundedAtomicArrayQueue;
import j0.l.e.o.SpscArrayQueue;
import j0.l.e.o.UnsafeAccess;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.subscriptions.CompositeSubscription;

/* compiled from: OperatorMerge.java */
/* renamed from: j0.l.a.x0, reason: use source file name */
/* loaded from: classes3.dex */
public final class OperatorMerge<T> implements Observable.b<T, Observable<? extends T>> {
    public final boolean j;

    /* compiled from: OperatorMerge.java */
    /* renamed from: j0.l.a.x0$a */
    public static final class a {
        public static final OperatorMerge<Object> a = new OperatorMerge<>(true, Integer.MAX_VALUE);
    }

    /* compiled from: OperatorMerge.java */
    /* renamed from: j0.l.a.x0$b */
    public static final class b {
        public static final OperatorMerge<Object> a = new OperatorMerge<>(false, Integer.MAX_VALUE);
    }

    /* compiled from: OperatorMerge.java */
    /* renamed from: j0.l.a.x0$c */
    public static final class c<T> extends Subscriber<T> {
        public static final int j = RxRingBuffer.j / 4;
        public final e<T> k;
        public final long l;
        public volatile boolean m;
        public volatile RxRingBuffer n;
        public int o;

        public c(e<T> eVar, long j2) {
            this.k = eVar;
            this.l = j2;
        }

        public void a(long j2) {
            int i = this.o - ((int) j2);
            if (i > j) {
                this.o = i;
                return;
            }
            int i2 = RxRingBuffer.j;
            this.o = i2;
            int i3 = i2 - i;
            if (i3 > 0) {
                request(i3);
            }
        }

        @Override // j0.Observer2
        public void onCompleted() throws Throwable {
            this.m = true;
            this.k.b();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) throws Throwable {
            this.k.d().offer(th);
            this.m = true;
            this.k.b();
        }

        /* JADX WARN: Removed duplicated region for block: B:60:0x0090  */
        @Override // j0.Observer2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onNext(T t) throws Throwable {
            boolean z2;
            e<T> eVar = this.k;
            long j2 = eVar.n.get();
            boolean z3 = true;
            if (j2 != 0) {
                synchronized (eVar) {
                    j2 = eVar.n.get();
                    if (eVar.f3779s || j2 == 0) {
                        z2 = false;
                    } else {
                        eVar.f3779s = true;
                        z2 = true;
                    }
                }
            } else {
                z2 = false;
            }
            if (!z2) {
                eVar.f(this, t);
                eVar.b();
                return;
            }
            RxRingBuffer rxRingBuffer = this.n;
            if (rxRingBuffer != null) {
                Queue<Object> queue = rxRingBuffer.k;
                if (!(queue == null || queue.isEmpty())) {
                    eVar.f(this, t);
                    eVar.c();
                    return;
                }
            }
            try {
                try {
                    try {
                        eVar.k.onNext(t);
                    } catch (Throwable th) {
                        th = th;
                        z3 = false;
                        if (!z3) {
                            synchronized (eVar) {
                                eVar.f3779s = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (!z3) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (!eVar.l) {
                    b.i.a.f.e.o.f.o1(th3);
                    unsubscribe();
                    onError(th3);
                    return;
                }
                eVar.d().offer(th3);
            }
            if (j2 != RecyclerView.FOREVER_NS) {
                eVar.n.a(1);
            }
            a(1L);
            synchronized (eVar) {
                if (eVar.t) {
                    eVar.t = false;
                    eVar.c();
                } else {
                    eVar.f3779s = false;
                }
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            int i = RxRingBuffer.j;
            this.o = i;
            request(i);
        }
    }

    /* compiled from: OperatorMerge.java */
    /* renamed from: j0.l.a.x0$d */
    public static final class d<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1214379189873595503L;
        public final e<T> subscriber;

        public d(e<T> eVar) {
            this.subscriber = eVar;
        }

        public long a(int i) {
            return addAndGet(-i);
        }

        @Override // rx.Producer
        public void j(long j) throws Throwable {
            if (j <= 0) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            } else {
                if (get() == RecyclerView.FOREVER_NS) {
                    return;
                }
                b.i.a.f.e.o.f.c0(this, j);
                this.subscriber.b();
            }
        }
    }

    /* compiled from: OperatorMerge.java */
    /* renamed from: j0.l.a.x0$e */
    public static final class e<T> extends Subscriber<Observable<? extends T>> {
        public static final c<?>[] j = new c[0];
        public int A;
        public final Subscriber<? super T> k;
        public final boolean l;
        public final int m;
        public d<T> n;
        public volatile Queue<Object> o;
        public volatile CompositeSubscription p;
        public volatile ConcurrentLinkedQueue<Throwable> q;
        public volatile boolean r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f3779s;
        public boolean t;
        public final Object u = new Object();
        public volatile c<?>[] v = j;
        public long w;

        /* renamed from: x, reason: collision with root package name */
        public long f3780x;

        /* renamed from: y, reason: collision with root package name */
        public int f3781y;

        /* renamed from: z, reason: collision with root package name */
        public final int f3782z;

        public e(Subscriber<? super T> subscriber, boolean z2, int i) {
            this.k = subscriber;
            this.l = z2;
            this.m = i;
            if (i == Integer.MAX_VALUE) {
                this.f3782z = Integer.MAX_VALUE;
                request(RecyclerView.FOREVER_NS);
            } else {
                this.f3782z = Math.max(1, i >> 1);
                request(i);
            }
        }

        public boolean a() {
            if (this.k.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.q;
            if (this.l || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                h();
                return true;
            } finally {
                unsubscribe();
            }
        }

        public void b() throws Throwable {
            synchronized (this) {
                if (this.f3779s) {
                    this.t = true;
                } else {
                    this.f3779s = true;
                    c();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:143:0x0186, code lost:
        
            r23.f3781y = r0;
            r23.f3780x = r5[r0].l;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x006f, code lost:
        
            if (r7 <= 0) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0071, code lost:
        
            if (r10 == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0073, code lost:
        
            r16 = Long.MAX_VALUE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0076, code lost:
        
            r16 = r23.n.a(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x007e, code lost:
        
            if (r16 == 0) goto L209;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
        
            if (r0 != null) goto L45;
         */
        /* JADX WARN: Removed duplicated region for block: B:132:0x0169 A[Catch: all -> 0x01b8, TryCatch #7 {all -> 0x01b8, blocks: (B:3:0x0002, B:4:0x0004, B:7:0x000b, B:17:0x002f, B:22:0x003f, B:36:0x0066, B:27:0x004a, B:29:0x004e, B:35:0x005f, B:40:0x0076, B:47:0x008a, B:50:0x0095, B:53:0x009d, B:55:0x00a1, B:58:0x00a8, B:59:0x00ac, B:62:0x00b2, B:64:0x00b8, B:80:0x00e3, B:83:0x00ea, B:87:0x00f2, B:90:0x00f9, B:93:0x00fe, B:96:0x0105, B:112:0x012e, B:114:0x013e, B:121:0x0151, B:124:0x0159, B:126:0x015d, B:132:0x0169, B:135:0x0173, B:143:0x0186, B:146:0x0194, B:149:0x019e, B:138:0x0179, B:141:0x017e, B:70:0x00c6, B:73:0x00cf, B:76:0x00d4, B:77:0x00d7, B:23:0x0043), top: B:196:0x0002, inners: #5 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c() throws Throwable {
            boolean z2;
            Subscriber<? super T> subscriber;
            long jA;
            int i;
            Subscriber<? super T> subscriber2;
            boolean z3;
            long jA2;
            try {
                subscriber = this.k;
            } catch (Throwable th) {
                th = th;
                z2 = false;
            }
            while (!a()) {
                Queue<Object> queue = this.o;
                long j2 = this.n.get();
                boolean z4 = j2 == RecyclerView.FOREVER_NS;
                if (queue != null) {
                    int i2 = 0;
                    while (true) {
                        jA = j2;
                        int i3 = 0;
                        i = i2;
                        Object obj = null;
                        while (true) {
                            if (jA <= 0) {
                                break;
                            }
                            Object objPoll = queue.poll();
                            if (a()) {
                                return;
                            }
                            if (objPoll == null) {
                                obj = objPoll;
                                break;
                            }
                            try {
                                subscriber.onNext((Object) NotificationLite.b(objPoll));
                            } catch (Throwable th2) {
                                if (!this.l) {
                                    b.i.a.f.e.o.f.o1(th2);
                                    unsubscribe();
                                    subscriber.onError(th2);
                                    return;
                                }
                                d().offer(th2);
                            }
                            i++;
                            i3++;
                            jA--;
                            obj = objPoll;
                        }
                        i2 = i;
                        j2 = jA;
                    }
                } else {
                    jA = j2;
                    i = 0;
                }
                boolean z5 = this.r;
                Queue<Object> queue2 = this.o;
                c<?>[] cVarArr = this.v;
                int length = cVarArr.length;
                if (z5 && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                    ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.q;
                    if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                        h();
                        return;
                    }
                    subscriber.onCompleted();
                    return;
                }
                if (length > 0) {
                    long j3 = this.f3780x;
                    int i4 = this.f3781y;
                    if (length <= i4 || cVarArr[i4].l != j3) {
                        if (length <= i4) {
                            i4 = 0;
                        }
                        for (int i5 = 0; i5 < length && cVarArr[i4].l != j3; i5++) {
                            i4++;
                            if (i4 == length) {
                                i4 = 0;
                            }
                        }
                        this.f3781y = i4;
                        this.f3780x = cVarArr[i4].l;
                    }
                    int i6 = 0;
                    z3 = false;
                    while (true) {
                        if (i6 >= length) {
                            subscriber2 = subscriber;
                            break;
                        }
                        if (a()) {
                            return;
                        }
                        c<?> cVar = cVarArr[i4];
                        Object objC = null;
                        while (true) {
                            int i7 = 0;
                            while (jA > 0) {
                                if (a()) {
                                    return;
                                }
                                RxRingBuffer rxRingBuffer = cVar.n;
                                if (rxRingBuffer != null && (objC = rxRingBuffer.c()) != null) {
                                    try {
                                        try {
                                            subscriber.onNext((Object) NotificationLite.b(objC));
                                            jA--;
                                            i7++;
                                        } catch (Throwable th3) {
                                            b.i.a.f.e.o.f.o1(th3);
                                            try {
                                                subscriber.onError(th3);
                                                return;
                                            } finally {
                                                unsubscribe();
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        z2 = true;
                                    }
                                }
                            }
                            if (i7 > 0) {
                                if (z4) {
                                    subscriber2 = subscriber;
                                    jA2 = RecyclerView.FOREVER_NS;
                                } else {
                                    jA2 = this.n.a(i7);
                                    subscriber2 = subscriber;
                                }
                                cVar.a(i7);
                                jA = jA2;
                            } else {
                                subscriber2 = subscriber;
                            }
                            if (jA == 0 || objC == null) {
                                break;
                            } else {
                                subscriber = subscriber2;
                            }
                        }
                        boolean z6 = cVar.m;
                        RxRingBuffer rxRingBuffer2 = cVar.n;
                        if (z6) {
                            if (rxRingBuffer2 == null) {
                                g(cVar);
                                if (a()) {
                                    return;
                                }
                                i++;
                                z3 = true;
                            } else {
                                Queue<Object> queue3 = rxRingBuffer2.k;
                                if (queue3 == null || queue3.isEmpty()) {
                                }
                            }
                            if (!z2) {
                                synchronized (this) {
                                    this.f3779s = false;
                                }
                            }
                            throw th;
                        }
                        if (jA == 0) {
                            break;
                        }
                        i4++;
                        if (i4 == length) {
                            i4 = 0;
                        }
                        i6++;
                        subscriber = subscriber2;
                    }
                } else {
                    subscriber2 = subscriber;
                    z3 = false;
                }
                if (i > 0) {
                    request(i);
                }
                if (!z3) {
                    synchronized (this) {
                        try {
                            if (!this.t) {
                                try {
                                    this.f3779s = false;
                                    return;
                                } catch (Throwable th5) {
                                    th = th5;
                                    z2 = true;
                                    while (true) {
                                        try {
                                            break;
                                        } catch (Throwable th6) {
                                            th = th6;
                                        }
                                    }
                                    throw th;
                                }
                            }
                            this.t = false;
                        } catch (Throwable th7) {
                            th = th7;
                            z2 = false;
                        }
                    }
                    try {
                        break;
                        throw th;
                    } catch (Throwable th8) {
                        th = th8;
                    }
                }
                subscriber = subscriber2;
            }
        }

        public Queue<Throwable> d() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.q;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.q;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.q = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        public void e(T t) throws Throwable {
            Queue<Object> spscArrayQueue = this.o;
            if (spscArrayQueue == null) {
                int i = this.m;
                if (i == Integer.MAX_VALUE) {
                    spscArrayQueue = new SpscUnboundedAtomicArrayQueue<>(RxRingBuffer.j);
                } else {
                    spscArrayQueue = ((i + (-1)) & i) == 0 ? UnsafeAccess.b() ? new SpscArrayQueue<>(i) : new SpscAtomicArrayQueue<>(i) : new SpscExactAtomicArrayQueue<>(i);
                }
                this.o = spscArrayQueue;
            }
            if (spscArrayQueue.offer(t == null ? NotificationLite.f3771b : t)) {
                return;
            }
            unsubscribe();
            d().offer(OnErrorThrowable.a(new MissingBackpressureException(), t));
            this.r = true;
            b();
        }

        public void f(c<T> cVar, T t) throws Throwable {
            RxRingBuffer rxRingBuffer = cVar.n;
            if (rxRingBuffer == null) {
                rxRingBuffer = UnsafeAccess.b() ? new RxRingBuffer(false, RxRingBuffer.j) : new RxRingBuffer();
                cVar.add(rxRingBuffer);
                cVar.n = rxRingBuffer;
            }
            if (t == null) {
                try {
                    t = (T) NotificationLite.f3771b;
                } catch (IllegalStateException e) {
                    if (cVar.isUnsubscribed()) {
                        return;
                    }
                    cVar.unsubscribe();
                    cVar.onError(e);
                    return;
                } catch (MissingBackpressureException e2) {
                    cVar.unsubscribe();
                    cVar.onError(e2);
                    return;
                }
            }
            rxRingBuffer.a(t);
        }

        public void g(c<T> cVar) {
            RxRingBuffer rxRingBuffer = cVar.n;
            if (rxRingBuffer != null) {
                synchronized (rxRingBuffer) {
                }
            }
            this.p.c(cVar);
            synchronized (this.u) {
                c<?>[] cVarArr = this.v;
                int length = cVarArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (cVar.equals(cVarArr[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    this.v = j;
                    return;
                }
                c<?>[] cVarArr2 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, i);
                System.arraycopy(cVarArr, i + 1, cVarArr2, i, (length - i) - 1);
                this.v = cVarArr2;
            }
        }

        public final void h() {
            ArrayList arrayList = new ArrayList(this.q);
            if (arrayList.size() == 1) {
                this.k.onError((Throwable) arrayList.get(0));
            } else {
                this.k.onError(new CompositeException(arrayList));
            }
        }

        @Override // j0.Observer2
        public void onCompleted() throws Throwable {
            this.r = true;
            b();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) throws Throwable {
            d().offer(th);
            this.r = true;
            b();
        }

        /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
        @Override // j0.Observer2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onNext(Object obj) throws Throwable {
            boolean z2;
            Observable<Object> observable = (Observable) obj;
            if (observable == null) {
                return;
            }
            boolean z3 = true;
            if (observable == EmptyObservableHolder.k) {
                int i = this.A + 1;
                if (i != this.f3782z) {
                    this.A = i;
                    return;
                } else {
                    this.A = 0;
                    request(i);
                    return;
                }
            }
            if (!(observable instanceof ScalarSynchronousObservable)) {
                long j2 = this.w;
                this.w = 1 + j2;
                c<?> cVar = new c<>(this, j2);
                CompositeSubscription compositeSubscription = this.p;
                if (compositeSubscription == null) {
                    synchronized (this) {
                        compositeSubscription = this.p;
                        if (compositeSubscription == null) {
                            compositeSubscription = new CompositeSubscription();
                            this.p = compositeSubscription;
                        } else {
                            z3 = false;
                        }
                    }
                    if (z3) {
                        add(compositeSubscription);
                    }
                }
                compositeSubscription.a(cVar);
                synchronized (this.u) {
                    c<?>[] cVarArr = this.v;
                    int length = cVarArr.length;
                    c<?>[] cVarArr2 = new c[length + 1];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                    cVarArr2[length] = cVar;
                    this.v = cVarArr2;
                }
                observable.i0(cVar);
                b();
                return;
            }
            T t = ((ScalarSynchronousObservable) observable).l;
            long j3 = this.n.get();
            if (j3 != 0) {
                synchronized (this) {
                    j3 = this.n.get();
                    if (this.f3779s || j3 == 0) {
                        z2 = false;
                    } else {
                        this.f3779s = true;
                        z2 = true;
                    }
                }
            } else {
                z2 = false;
            }
            if (!z2) {
                e(t);
                b();
                return;
            }
            Queue<Object> queue = this.o;
            if (queue != null && !queue.isEmpty()) {
                e(t);
                c();
                return;
            }
            try {
                try {
                    this.k.onNext(t);
                } catch (Throwable th) {
                    try {
                        if (!this.l) {
                            b.i.a.f.e.o.f.o1(th);
                            unsubscribe();
                            d().offer(th);
                            this.r = true;
                            b();
                            return;
                        }
                        d().offer(th);
                    } catch (Throwable th2) {
                        th = th2;
                        z3 = false;
                        if (!z3) {
                        }
                        throw th;
                    }
                }
                if (j3 != RecyclerView.FOREVER_NS) {
                    this.n.a(1);
                }
                int i2 = this.A + 1;
                if (i2 == this.f3782z) {
                    this.A = 0;
                    request(i2);
                } else {
                    this.A = i2;
                }
                synchronized (this) {
                    if (this.t) {
                        this.t = false;
                        c();
                    } else {
                        this.f3779s = false;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (!z3) {
                    synchronized (this) {
                        this.f3779s = false;
                    }
                }
                throw th;
            }
        }
    }

    public OperatorMerge(boolean z2, int i) {
        this.j = z2;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        e eVar = new e(subscriber, this.j, Integer.MAX_VALUE);
        d<T> dVar = new d<>(eVar);
        eVar.n = dVar;
        subscriber.add(eVar);
        subscriber.setProducer(dVar);
        return eVar;
    }
}
