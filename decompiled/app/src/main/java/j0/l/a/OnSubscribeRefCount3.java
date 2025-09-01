package j0.l.a;

import j0.m.ConnectableObservable;
import j0.r.BooleanSubscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

/* compiled from: OnSubscribeRefCount.java */
/* renamed from: j0.l.a.c0, reason: use source file name */
/* loaded from: classes3.dex */
public final class OnSubscribeRefCount3<T> implements Observable.a<T> {
    public final ConnectableObservable<? extends T> j;
    public volatile CompositeSubscription k = new CompositeSubscription();
    public final AtomicInteger l = new AtomicInteger(0);
    public final ReentrantLock m = new ReentrantLock();

    public OnSubscribeRefCount3(ConnectableObservable<? extends T> connectableObservable) {
        this.j = connectableObservable;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        boolean z2;
        Subscriber subscriber = (Subscriber) obj;
        this.m.lock();
        if (this.l.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.j.k0(new OnSubscribeRefCount4(this, subscriber, atomicBoolean));
                if (z2) {
                    return;
                } else {
                    return;
                }
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
        try {
            CompositeSubscription compositeSubscription = this.k;
            subscriber.add(new BooleanSubscription(new OnSubscribeRefCount2(this, compositeSubscription)));
            this.j.i0(new OnSubscribeRefCount(this, subscriber, subscriber, compositeSubscription));
        } finally {
            this.m.unlock();
        }
    }
}
