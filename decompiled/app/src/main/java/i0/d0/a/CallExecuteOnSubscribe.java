package i0.d0.a;

import i0.Call3;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

/* compiled from: CallExecuteOnSubscribe.java */
/* renamed from: i0.d0.a.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class CallExecuteOnSubscribe<T> implements Observable.a<Response<T>> {
    public final Call3<T> j;

    public CallExecuteOnSubscribe(Call3<T> call3) {
        this.j = call3;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Call3<T> call3L = this.j.L();
        CallArbiter callArbiter = new CallArbiter(call3L, subscriber);
        subscriber.add(callArbiter);
        subscriber.setProducer(callArbiter);
        try {
            callArbiter.c(call3L.execute());
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            callArbiter.b(th);
        }
    }
}
