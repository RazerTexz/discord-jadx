package b.i.a.b.j.t.h;

import android.content.Context;
import b.i.a.b.j.q.BackendRegistry;
import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.u.SynchronizationGuard;
import b.i.a.b.j.v.Clock3;
import c0.a.Provider3;
import java.util.concurrent.Executor;

/* compiled from: Uploader_Factory.java */
/* renamed from: b.i.a.b.j.t.h.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class Uploader_Factory implements Provider3 {
    public final Provider3<Context> a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider3<BackendRegistry> f792b;
    public final Provider3<EventStore> c;
    public final Provider3<WorkScheduler> d;
    public final Provider3<Executor> e;
    public final Provider3<SynchronizationGuard> f;
    public final Provider3<Clock3> g;

    public Uploader_Factory(Provider3<Context> provider3, Provider3<BackendRegistry> provider32, Provider3<EventStore> provider33, Provider3<WorkScheduler> provider34, Provider3<Executor> provider35, Provider3<SynchronizationGuard> provider36, Provider3<Clock3> provider37) {
        this.a = provider3;
        this.f792b = provider32;
        this.c = provider33;
        this.d = provider34;
        this.e = provider35;
        this.f = provider36;
        this.g = provider37;
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new Uploader6(this.a.get(), this.f792b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
