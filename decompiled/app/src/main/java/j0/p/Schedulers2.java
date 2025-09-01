package j0.p;

import j0.l.c.CachedThreadScheduler;
import j0.l.c.EventLoopsScheduler;
import j0.l.c.NewThreadScheduler;
import j0.l.c.SchedulerLifecycle;
import j0.l.e.RxThreadFactory;
import j0.o.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;

/* compiled from: Schedulers.java */
/* renamed from: j0.p.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class Schedulers2 {
    public static final AtomicReference<Schedulers2> a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    public final Scheduler f3803b;
    public final Scheduler c;
    public final Scheduler d;

    public Schedulers2() {
        Objects.requireNonNull(RxJavaPlugins.a.e());
        this.f3803b = new EventLoopsScheduler(new RxThreadFactory("RxComputationScheduler-"));
        this.c = new CachedThreadScheduler(new RxThreadFactory("RxIoScheduler-"));
        this.d = new NewThreadScheduler(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static Scheduler a() {
        return b().f3803b;
    }

    public static Schedulers2 b() {
        while (true) {
            AtomicReference<Schedulers2> atomicReference = a;
            Schedulers2 schedulers2 = atomicReference.get();
            if (schedulers2 != null) {
                return schedulers2;
            }
            Schedulers2 schedulers22 = new Schedulers2();
            if (atomicReference.compareAndSet(null, schedulers22)) {
                return schedulers22;
            }
            synchronized (schedulers22) {
                Object obj = schedulers22.f3803b;
                if (obj instanceof SchedulerLifecycle) {
                    ((SchedulerLifecycle) obj).shutdown();
                }
                Object obj2 = schedulers22.c;
                if (obj2 instanceof SchedulerLifecycle) {
                    ((SchedulerLifecycle) obj2).shutdown();
                }
                Object obj3 = schedulers22.d;
                if (obj3 instanceof SchedulerLifecycle) {
                    ((SchedulerLifecycle) obj3).shutdown();
                }
            }
        }
    }

    public static Scheduler c() {
        return b().c;
    }
}
