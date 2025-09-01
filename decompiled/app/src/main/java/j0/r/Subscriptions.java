package j0.r;

import rx.Subscription;

/* compiled from: Subscriptions.java */
/* renamed from: j0.r.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class Subscriptions {
    public static final a a = new a();

    /* compiled from: Subscriptions.java */
    /* renamed from: j0.r.c$a */
    public static final class a implements Subscription {
        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
        }
    }
}
