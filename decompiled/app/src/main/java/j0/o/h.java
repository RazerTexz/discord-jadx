package j0.o;

import j0.k.Func1;
import java.util.Objects;
import rx.Subscription;

/* compiled from: RxJavaHooks.java */
/* loaded from: classes3.dex */
public final class h implements Func1<Subscription, Subscription> {
    @Override // j0.k.Func1
    public Subscription call(Subscription subscription) {
        Subscription subscription2 = subscription;
        Objects.requireNonNull(RxJavaPlugins.a.c());
        return subscription2;
    }
}
