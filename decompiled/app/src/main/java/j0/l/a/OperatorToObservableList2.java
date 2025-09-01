package j0.l.a;

import j0.l.b.SingleDelayedProducer;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

/* compiled from: OperatorToObservableList.java */
/* renamed from: j0.l.a.n2, reason: use source file name */
/* loaded from: classes3.dex */
public final class OperatorToObservableList2<T> implements Observable.b<List<T>, T> {

    /* compiled from: OperatorToObservableList.java */
    /* renamed from: j0.l.a.n2$a */
    public static final class a {
        public static final OperatorToObservableList2<Object> a = new OperatorToObservableList2<>();
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        OperatorToObservableList operatorToObservableList = new OperatorToObservableList(this, singleDelayedProducer, subscriber);
        subscriber.add(operatorToObservableList);
        subscriber.setProducer(singleDelayedProducer);
        return operatorToObservableList;
    }
}
