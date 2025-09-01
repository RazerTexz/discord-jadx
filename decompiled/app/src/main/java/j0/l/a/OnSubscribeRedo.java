package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.Notification;
import j0.l.b.ProducerArbiter;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subjects.Subject;
import rx.subscriptions.SerialSubscription;

/* compiled from: OnSubscribeRedo.java */
/* renamed from: j0.l.a.t, reason: use source file name */
/* loaded from: classes3.dex */
public class OnSubscribeRedo implements Action0 {
    public final /* synthetic */ Subscriber j;
    public final /* synthetic */ Subject k;
    public final /* synthetic */ ProducerArbiter l;
    public final /* synthetic */ AtomicLong m;
    public final /* synthetic */ SerialSubscription n;
    public final /* synthetic */ OnSubscribeRedo6 o;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: OnSubscribeRedo.java */
    /* renamed from: j0.l.a.t$a */
    public class a<T> extends Subscriber<T> {
        public boolean j;

        public a() {
        }

        @Override // j0.Observer2
        public void onCompleted() {
            if (this.j) {
                return;
            }
            this.j = true;
            unsubscribe();
            OnSubscribeRedo.this.k.onNext(Notification.a);
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            if (this.j) {
                return;
            }
            this.j = true;
            unsubscribe();
            OnSubscribeRedo.this.k.onNext(new Notification(Notification.a.OnError, null, th));
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            long j;
            if (this.j) {
                return;
            }
            OnSubscribeRedo.this.j.onNext(t);
            do {
                j = OnSubscribeRedo.this.m.get();
                if (j == RecyclerView.FOREVER_NS) {
                    break;
                }
            } while (!OnSubscribeRedo.this.m.compareAndSet(j, j - 1));
            OnSubscribeRedo.this.l.b(1L);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            OnSubscribeRedo.this.l.c(producer);
        }
    }

    public OnSubscribeRedo(OnSubscribeRedo6 onSubscribeRedo6, Subscriber subscriber, Subject subject, ProducerArbiter producerArbiter, AtomicLong atomicLong, SerialSubscription serialSubscription) {
        this.o = onSubscribeRedo6;
        this.j = subscriber;
        this.k = subject;
        this.l = producerArbiter;
        this.m = atomicLong;
        this.n = serialSubscription;
    }

    @Override // rx.functions.Action0
    public void call() {
        if (this.j.isUnsubscribed()) {
            return;
        }
        a aVar = new a();
        this.n.a(aVar);
        this.o.j.i0(aVar);
    }
}
