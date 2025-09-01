package j0.l.e;

import j0.Observer2;
import rx.functions.Action0;
import rx.functions.Action1;

/* compiled from: ActionObserver.java */
/* renamed from: j0.l.e.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class ActionObserver<T> implements Observer2<T> {
    public final Action1<? super T> j;
    public final Action1<? super Throwable> k;
    public final Action0 l;

    public ActionObserver(Action1<? super T> action1, Action1<? super Throwable> action12, Action0 action0) {
        this.j = action1;
        this.k = action12;
        this.l = action0;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.l.call();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.k.call(th);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        this.j.call(t);
    }
}
