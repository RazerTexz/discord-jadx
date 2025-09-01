package j0.r;

import j0.l.d.SequentialSubscription;
import rx.Subscription;

/* compiled from: MultipleAssignmentSubscription.java */
/* renamed from: j0.r.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class MultipleAssignmentSubscription implements Subscription {
    public final SequentialSubscription j = new SequentialSubscription();

    public void a(Subscription subscription) {
        this.j.a(subscription);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.j.isUnsubscribed();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.j.unsubscribe();
    }
}
