package d0.e0.p.d.m0.m;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: locks.kt */
/* renamed from: d0.e0.p.d.m0.m.l, reason: use source file name */
/* loaded from: classes3.dex */
public interface locks4 {
    public static final /* synthetic */ int a = 0;

    /* compiled from: locks.kt */
    /* renamed from: d0.e0.p.d.m0.m.l$a */
    public static final class a {
        public static final /* synthetic */ a a = new a();

        public final locks2 simpleLock(Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
            return (runnable == null || function1 == null) ? new locks2(null, 1, null) : new locks(runnable, function1);
        }
    }

    void lock();

    void unlock();
}
