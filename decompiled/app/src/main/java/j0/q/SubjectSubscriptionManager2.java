package j0.q;

import j0.Observer2;
import j0.k.Actions2;
import j0.l.a.NotificationLite;
import j0.r.BooleanSubscription;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/* compiled from: SubjectSubscriptionManager.java */
/* renamed from: j0.q.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class SubjectSubscriptionManager2<T> extends AtomicReference<a<T>> implements Observable.a<T> {
    private static final long serialVersionUID = 6035251036011671568L;
    public boolean active;
    public volatile Object latest;
    public Action1<b<T>> onAdded;
    public Action1<b<T>> onStart;
    public Action1<b<T>> onTerminated;

    /* compiled from: SubjectSubscriptionManager.java */
    /* renamed from: j0.q.c$a */
    public static final class a<T> {
        public static final b[] a;

        /* renamed from: b, reason: collision with root package name */
        public static final a f3805b;
        public static final a c;
        public final boolean d;
        public final b[] e;

        static {
            b[] bVarArr = new b[0];
            a = bVarArr;
            f3805b = new a(true, bVarArr);
            c = new a(false, bVarArr);
        }

        public a(boolean z2, b[] bVarArr) {
            this.d = z2;
            this.e = bVarArr;
        }
    }

    /* compiled from: SubjectSubscriptionManager.java */
    /* renamed from: j0.q.c$b */
    public static final class b<T> implements Observer2<T> {
        public final Subscriber<? super T> j;
        public boolean k = true;
        public boolean l;
        public List<Object> m;
        public boolean n;

        public b(Subscriber<? super T> subscriber) {
            this.j = subscriber;
        }

        public void a(Object obj) {
            if (!this.n) {
                synchronized (this) {
                    this.k = false;
                    if (this.l) {
                        if (this.m == null) {
                            this.m = new ArrayList();
                        }
                        this.m.add(obj);
                        return;
                    }
                    this.n = true;
                }
            }
            NotificationLite.a(this.j, obj);
        }

        @Override // j0.Observer2
        public void onCompleted() {
            this.j.onCompleted();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            this.j.onError(th);
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            this.j.onNext(t);
        }
    }

    public SubjectSubscriptionManager2() {
        super(a.c);
        this.active = true;
        Actions2.a aVar = Actions2.a;
        this.onStart = aVar;
        this.onAdded = aVar;
        this.onTerminated = aVar;
    }

    public void a(b<T> bVar) {
        a<T> aVar;
        a<T> aVar2;
        do {
            aVar = get();
            if (aVar.d) {
                return;
            }
            b<T>[] bVarArr = aVar.e;
            int length = bVarArr.length;
            if (length == 1 && bVarArr[0] == bVar) {
                aVar2 = a.c;
            } else {
                if (length == 0) {
                    aVar2 = aVar;
                    break;
                }
                int i = length - 1;
                b[] bVarArr2 = new b[i];
                int i2 = 0;
                for (b<T> bVar2 : bVarArr) {
                    if (bVar2 != bVar) {
                        if (i2 == i) {
                            aVar2 = aVar;
                            break;
                        } else {
                            bVarArr2[i2] = bVar2;
                            i2++;
                        }
                    }
                }
                if (i2 == 0) {
                    aVar2 = a.c;
                } else {
                    if (i2 < i) {
                        b[] bVarArr3 = new b[i2];
                        System.arraycopy(bVarArr2, 0, bVarArr3, 0, i2);
                        bVarArr2 = bVarArr3;
                    }
                    aVar2 = new a<>(aVar.d, bVarArr2);
                }
            }
            if (aVar2 == aVar) {
                return;
            }
        } while (!compareAndSet(aVar, aVar2));
    }

    public b<T>[] b(Object obj) {
        this.latest = obj;
        this.active = false;
        return get().d ? a.a : getAndSet(a.f3805b).e;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        boolean z2;
        Subscriber subscriber = (Subscriber) obj;
        b<T> bVar = new b<>(subscriber);
        subscriber.add(new BooleanSubscription(new SubjectSubscriptionManager(this, bVar)));
        this.onStart.call(bVar);
        if (subscriber.isUnsubscribed()) {
            return;
        }
        while (true) {
            a<T> aVar = get();
            z2 = false;
            if (aVar.d) {
                this.onTerminated.call(bVar);
                break;
            }
            b[] bVarArr = aVar.e;
            int length = bVarArr.length;
            b[] bVarArr2 = new b[length + 1];
            System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
            bVarArr2[length] = bVar;
            if (compareAndSet(aVar, new a(aVar.d, bVarArr2))) {
                this.onAdded.call(bVar);
                z2 = true;
                break;
            }
        }
        if (z2 && subscriber.isUnsubscribed()) {
            a(bVar);
        }
    }
}
