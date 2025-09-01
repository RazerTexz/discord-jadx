package b.i.a.b.j;

import b.i.a.b.j.t.Scheduler2;
import b.i.a.b.j.t.h.Uploader6;
import b.i.a.b.j.t.h.WorkInitializer3;
import b.i.a.b.j.v.Clock3;
import c0.a.Provider3;

/* compiled from: TransportRuntime_Factory.java */
/* renamed from: b.i.a.b.j.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class TransportRuntime_Factory implements Provider3 {
    public final Provider3<Clock3> a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider3<Clock3> f770b;
    public final Provider3<Scheduler2> c;
    public final Provider3<Uploader6> d;
    public final Provider3<WorkInitializer3> e;

    public TransportRuntime_Factory(Provider3<Clock3> provider3, Provider3<Clock3> provider32, Provider3<Scheduler2> provider33, Provider3<Uploader6> provider34, Provider3<WorkInitializer3> provider35) {
        this.a = provider3;
        this.f770b = provider32;
        this.c = provider33;
        this.d = provider34;
        this.e = provider35;
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new TransportRuntime(this.a.get(), this.f770b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
