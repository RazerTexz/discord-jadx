package s.a;

import java.util.Objects;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.e2.Dispatcher3;

/* compiled from: Dispatchers.kt */
/* renamed from: s.a.k0, reason: use source file name */
/* loaded from: classes3.dex */
public final class Dispatchers {
    public static final CoroutineDispatcher a;

    /* renamed from: b, reason: collision with root package name */
    public static final CoroutineDispatcher f3842b;

    static {
        a = CoroutineContext2.a ? Dispatcher3.p : CommonPool.k;
        Unconfined2 unconfined2 = Unconfined2.j;
        Objects.requireNonNull(Dispatcher3.p);
        f3842b = Dispatcher3.o;
    }
}
