package j0.n;

import j0.Observer2;
import rx.exceptions.OnErrorNotImplementedException;

/* compiled from: Observers.java */
/* renamed from: j0.n.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class Observers {
    public static final Observer2<Object> a = new a();

    /* compiled from: Observers.java */
    /* renamed from: j0.n.a$a */
    public static class a implements Observer2<Object> {
        @Override // j0.Observer2
        public final void onCompleted() {
        }

        @Override // j0.Observer2
        public final void onError(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }

        @Override // j0.Observer2
        public final void onNext(Object obj) {
        }
    }
}
