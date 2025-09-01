package b.i.a.b.j.t.h;

import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.u.SynchronizationGuard;
import c0.a.Provider3;
import java.util.concurrent.Executor;

/* compiled from: WorkInitializer_Factory.java */
/* renamed from: b.i.a.b.j.t.h.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class WorkInitializer_Factory implements Provider3 {
    public final Provider3<Executor> a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider3<EventStore> f794b;
    public final Provider3<WorkScheduler> c;
    public final Provider3<SynchronizationGuard> d;

    public WorkInitializer_Factory(Provider3<Executor> provider3, Provider3<EventStore> provider32, Provider3<WorkScheduler> provider33, Provider3<SynchronizationGuard> provider34) {
        this.a = provider3;
        this.f794b = provider32;
        this.c = provider33;
        this.d = provider34;
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new WorkInitializer3(this.a.get(), this.f794b.get(), this.c.get(), this.d.get());
    }
}
