package s.a;

import d0.w.h.IntrinsicsJvm;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Builders.common.kt */
/* loaded from: classes3.dex */
public final class k1 extends t1 {
    public final Continuation<Unit> m;

    public k1(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.m = IntrinsicsJvm.createCoroutineUnintercepted(function2, this, this);
    }

    @Override // s.a.AbstractCoroutine
    public void i0() {
        b.i.a.f.e.o.f.e1(this.m, this);
    }
}
