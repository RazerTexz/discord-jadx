package j0.l.a;

import rx.Observable;

/* compiled from: NeverObservableHolder.java */
/* renamed from: j0.l.a.d, reason: use source file name */
/* loaded from: classes3.dex */
public enum NeverObservableHolder implements Observable.a<Object> {
    INSTANCE;

    public static final Observable<Object> k = Observable.h0(INSTANCE);

    @Override // rx.functions.Action1
    public void call(Object obj) {
    }
}
