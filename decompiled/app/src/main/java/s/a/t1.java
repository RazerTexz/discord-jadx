package s.a;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Builders.common.kt */
/* loaded from: classes3.dex */
public class t1 extends AbstractCoroutine<Unit> {
    public t1(CoroutineContext coroutineContext, boolean z2) {
        super(coroutineContext, z2);
    }

    @Override // s.a.h1
    public boolean N(Throwable th) {
        b.i.a.f.e.o.f.u0(this.k, th);
        return true;
    }
}
