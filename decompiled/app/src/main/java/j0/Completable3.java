package j0;

import j0.k.Func1;
import j0.o.l;
import rx.functions.Action1;

/* compiled from: Completable.java */
/* renamed from: j0.d, reason: use source file name */
/* loaded from: classes3.dex */
public class Completable3 {
    public final a a;

    /* compiled from: Completable.java */
    /* renamed from: j0.d$a */
    public interface a extends Action1<CompletableSubscriber> {
    }

    public Completable3(a aVar) {
        Func1<a, a> func1 = l.d;
        this.a = func1 != null ? func1.call(aVar) : aVar;
    }
}
