package b.i.a.b.j.t.h;

import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.u.SynchronizationGuard;
import java.util.concurrent.Executor;

/* compiled from: WorkInitializer.java */
/* renamed from: b.i.a.b.j.t.h.p, reason: use source file name */
/* loaded from: classes3.dex */
public class WorkInitializer3 {
    public final Executor a;

    /* renamed from: b, reason: collision with root package name */
    public final EventStore f793b;
    public final WorkScheduler c;
    public final SynchronizationGuard d;

    public WorkInitializer3(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.a = executor;
        this.f793b = eventStore;
        this.c = workScheduler;
        this.d = synchronizationGuard;
    }
}
