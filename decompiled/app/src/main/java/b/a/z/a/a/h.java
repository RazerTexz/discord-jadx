package b.a.z.a.a;

import j0.k.Func1;
import j0.l.a.OnSubscribeFlattenIterable2;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OperatorToObservableSortedList;
import j0.l.e.RxRingBuffer;
import j0.l.e.ScalarSynchronousObservable;
import j0.l.e.UtilityFunctions;
import java.util.List;
import java.util.Map;
import rx.Observable;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class h implements Func1 {
    public final /* synthetic */ List j;
    public final /* synthetic */ Map k;
    public final /* synthetic */ String l;

    public /* synthetic */ h(List list, Map map, String str) {
        this.j = list;
        this.k = map;
        this.l = str;
    }

    @Override // j0.k.Func1
    public final Object call(Object obj) {
        List list = this.j;
        Map map = this.k;
        Observable observableH0 = Observable.h0(new OnSubscribeLift(Observable.B(((Map) obj).values()).y(new l(list)).y(new m(map)).y(new k(this.l)).j, new OperatorToObservableSortedList(new f(map), 10)));
        UtilityFunctions.a aVar = UtilityFunctions.a.INSTANCE;
        return (observableH0 instanceof ScalarSynchronousObservable ? Observable.h0(new OnSubscribeFlattenIterable2.b(((ScalarSynchronousObservable) observableH0).l, aVar)) : Observable.h0(new OnSubscribeFlattenIterable2(observableH0, aVar, RxRingBuffer.j))).G(new d(map)).f0();
    }
}
