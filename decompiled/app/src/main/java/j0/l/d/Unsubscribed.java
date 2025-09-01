package j0.l.d;

import rx.Subscription;

/* compiled from: Unsubscribed.java */
/* renamed from: j0.l.d.b, reason: use source file name */
/* loaded from: classes3.dex */
public enum Unsubscribed implements Subscription {
    INSTANCE;

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
    }
}
