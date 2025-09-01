package j0.l.a;

import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorDistinctUntilChanged.java */
/* renamed from: j0.l.a.t0, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorDistinctUntilChanged<T> extends Subscriber<T> {
    public U j;
    public boolean k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ OperatorDistinctUntilChanged2 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorDistinctUntilChanged(OperatorDistinctUntilChanged2 operatorDistinctUntilChanged2, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.m = operatorDistinctUntilChanged2;
        this.l = subscriber2;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.l.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.l.onError(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [U, java.lang.Object] */
    @Override // j0.Observer2
    public void onNext(T t) {
        try {
            ?? Call = this.m.j.call(t);
            U u = this.j;
            this.j = Call;
            if (!this.k) {
                this.k = true;
                this.l.onNext(t);
                return;
            }
            try {
                if (this.m.k.call(u, Call).booleanValue()) {
                    request(1L);
                } else {
                    this.l.onNext(t);
                }
            } catch (Throwable th) {
                b.i.a.f.e.o.f.p1(th, this.l, Call);
            }
        } catch (Throwable th2) {
            b.i.a.f.e.o.f.p1(th2, this.l, t);
        }
    }
}
