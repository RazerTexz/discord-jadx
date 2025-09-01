package j0.l.a;

import rx.Observable;
import rx.Subscriber;

/* compiled from: OnSubscribeThrow.java */
/* renamed from: j0.l.a.f0, reason: use source file name */
/* loaded from: classes3.dex */
public final class OnSubscribeThrow<T> implements Observable.a<T> {
    public final Throwable j;

    public OnSubscribeThrow(Throwable th) {
        this.j = th;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        ((Subscriber) obj).onError(this.j);
    }
}
