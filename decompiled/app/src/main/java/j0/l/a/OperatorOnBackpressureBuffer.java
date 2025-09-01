package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.BackpressureOverflow;
import j0.l.e.BackpressureDrainManager;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;

/* compiled from: OperatorOnBackpressureBuffer.java */
/* renamed from: j0.l.a.a1, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorOnBackpressureBuffer<T> implements Observable.b<T, T> {
    public final BackpressureOverflow.b j;

    /* compiled from: OperatorOnBackpressureBuffer.java */
    /* renamed from: j0.l.a.a1$a */
    public static final class a<T> extends Subscriber<T> implements BackpressureDrainManager.a {
        public final Subscriber<? super T> l;
        public final BackpressureOverflow.b p;
        public final ConcurrentLinkedQueue<Object> j = new ConcurrentLinkedQueue<>();
        public final AtomicBoolean m = new AtomicBoolean(false);
        public final AtomicLong k = null;
        public final Action0 o = null;
        public final BackpressureDrainManager n = new BackpressureDrainManager(this);

        public a(Subscriber<? super T> subscriber, Long l, Action0 action0, BackpressureOverflow.b bVar) {
            this.l = subscriber;
            this.p = bVar;
        }

        @Override // j0.Observer2
        public void onCompleted() throws Throwable {
            if (this.m.get()) {
                return;
            }
            BackpressureDrainManager backpressureDrainManager = this.n;
            backpressureDrainManager.terminated = true;
            backpressureDrainManager.a();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) throws Throwable {
            if (this.m.get()) {
                return;
            }
            BackpressureDrainManager backpressureDrainManager = this.n;
            if (backpressureDrainManager.terminated) {
                return;
            }
            backpressureDrainManager.exception = th;
            backpressureDrainManager.terminated = true;
            backpressureDrainManager.a();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x006b A[EDGE_INSN: B:44:0x006b->B:33:0x006b BREAK  A[LOOP:0: B:5:0x0008->B:46:?], SYNTHETIC] */
        @Override // j0.Observer2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onNext(T t) throws Throwable {
            long j;
            boolean z2 = false;
            if (this.k == null) {
                z2 = true;
            } else {
                do {
                    j = this.k.get();
                    if (j <= 0) {
                        try {
                        } catch (MissingBackpressureException e) {
                            if (this.m.compareAndSet(false, true)) {
                                unsubscribe();
                                this.l.onError(e);
                            }
                        }
                        if (this.p.a()) {
                            Object objPoll = this.j.poll();
                            AtomicLong atomicLong = this.k;
                            if (atomicLong != null && objPoll != null) {
                                atomicLong.incrementAndGet();
                            }
                            boolean z3 = objPoll != null;
                            Action0 action0 = this.o;
                            if (action0 != null) {
                                try {
                                    action0.call();
                                    if (!z3) {
                                        break;
                                    }
                                } catch (Throwable th) {
                                    b.i.a.f.e.o.f.o1(th);
                                    BackpressureDrainManager backpressureDrainManager = this.n;
                                    if (!backpressureDrainManager.terminated) {
                                        backpressureDrainManager.exception = th;
                                        backpressureDrainManager.terminated = true;
                                        backpressureDrainManager.a();
                                    }
                                }
                            } else if (!z3) {
                            }
                            z2 = true;
                        }
                    }
                } while (!this.k.compareAndSet(j, j - 1));
                z2 = true;
            }
            if (z2) {
                ConcurrentLinkedQueue<Object> concurrentLinkedQueue = this.j;
                if (t == null) {
                    t = (T) NotificationLite.f3771b;
                }
                concurrentLinkedQueue.offer(t);
                this.n.a();
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(RecyclerView.FOREVER_NS);
        }
    }

    /* compiled from: OperatorOnBackpressureBuffer.java */
    /* renamed from: j0.l.a.a1$b */
    public static final class b {
        public static final OperatorOnBackpressureBuffer<?> a = new OperatorOnBackpressureBuffer<>();
    }

    public OperatorOnBackpressureBuffer() {
        int i = BackpressureOverflow.a;
        this.j = BackpressureOverflow.a.a;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, null, null, this.j);
        subscriber.add(aVar);
        subscriber.setProducer(aVar.n);
        return aVar;
    }
}
