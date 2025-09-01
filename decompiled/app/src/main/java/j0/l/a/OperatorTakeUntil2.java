package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: OperatorTakeUntil.java */
/* renamed from: j0.l.a.e2, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorTakeUntil2<E> extends Subscriber<E> {
    public final /* synthetic */ Subscriber j;

    public OperatorTakeUntil2(OperatorTakeUntil3 operatorTakeUntil3, Subscriber subscriber) {
        this.j = subscriber;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.j.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.j.onError(th);
    }

    @Override // j0.Observer2
    public void onNext(E e) {
        this.j.onCompleted();
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
