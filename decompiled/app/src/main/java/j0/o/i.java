package j0.o;

import j0.k.Func1;
import java.util.Objects;
import rx.functions.Action0;

/* compiled from: RxJavaHooks.java */
/* loaded from: classes3.dex */
public final class i implements Func1<Action0, Action0> {
    @Override // j0.k.Func1
    public Action0 call(Action0 action0) {
        Action0 action02 = action0;
        Objects.requireNonNull(RxJavaPlugins.a.e());
        return action02;
    }
}
