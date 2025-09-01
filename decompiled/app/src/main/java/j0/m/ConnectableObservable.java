package j0.m;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: ConnectableObservable.java */
/* renamed from: j0.m.b, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ConnectableObservable<T> extends Observable<T> {
    public ConnectableObservable(Observable.a<T> aVar) {
        super(aVar);
    }

    public abstract void k0(Action1<? super Subscription> action1);
}
