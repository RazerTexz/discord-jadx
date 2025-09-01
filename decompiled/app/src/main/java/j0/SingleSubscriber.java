package j0;

import rx.Subscription;
import rx.internal.util.SubscriptionList;

/* compiled from: SingleSubscriber.java */
/* renamed from: j0.i, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class SingleSubscriber<T> implements Subscription {
    public final SubscriptionList j = new SubscriptionList();

    public abstract void a(Throwable th);

    public abstract void b(T t);

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.j.k;
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.j.unsubscribe();
    }
}
