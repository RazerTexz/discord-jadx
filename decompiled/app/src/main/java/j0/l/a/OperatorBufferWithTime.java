package j0.l.a;

import j0.l.a.OperatorBufferWithTime2;
import java.util.ArrayList;
import java.util.Collection;
import rx.functions.Action0;

/* compiled from: OperatorBufferWithTime.java */
/* renamed from: j0.l.a.m0, reason: use source file name */
/* loaded from: classes3.dex */
public class OperatorBufferWithTime implements Action0 {
    public final /* synthetic */ OperatorBufferWithTime2.a j;

    public OperatorBufferWithTime(OperatorBufferWithTime2.a aVar) {
        this.j = aVar;
    }

    @Override // rx.functions.Action0
    public void call() {
        OperatorBufferWithTime2.a aVar = this.j;
        synchronized (aVar) {
            if (aVar.m) {
                return;
            }
            Collection collection = aVar.l;
            aVar.l = new ArrayList();
            try {
                aVar.j.onNext(collection);
            } catch (Throwable th) {
                b.i.a.f.e.o.f.o1(th);
                aVar.onError(th);
            }
        }
    }
}
