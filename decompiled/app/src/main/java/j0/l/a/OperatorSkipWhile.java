package j0.l.a;

import rx.Subscriber;
import rx.functions.Func2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorSkipWhile.java */
/* renamed from: j0.l.a.u1, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorSkipWhile<T> extends Subscriber<T> {
    public boolean j;
    public int k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ OperatorSkipWhile3 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperatorSkipWhile(OperatorSkipWhile3 operatorSkipWhile3, Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.m = operatorSkipWhile3;
        this.l = subscriber2;
        this.j = true;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.l.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.l.onError(th);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        if (!this.j) {
            this.l.onNext(t);
            return;
        }
        try {
            Func2<? super T, Integer, Boolean> func2 = this.m.j;
            int i = this.k;
            this.k = i + 1;
            if (func2.call(t, Integer.valueOf(i)).booleanValue()) {
                request(1L);
            } else {
                this.j = false;
                this.l.onNext(t);
            }
        } catch (Throwable th) {
            b.i.a.f.e.o.f.p1(th, this.l, t);
        }
    }
}
