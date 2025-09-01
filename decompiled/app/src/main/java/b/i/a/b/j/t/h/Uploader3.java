package b.i.a.b.j.t.h;

import b.i.a.b.j.TransportContext;
import b.i.a.b.j.q.BackendResponse;
import b.i.a.b.j.t.i.PersistedEvent;
import b.i.a.b.j.u.SynchronizationGuard;

/* compiled from: Uploader.java */
/* renamed from: b.i.a.b.j.t.h.i, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class Uploader3 implements SynchronizationGuard.a {
    public final Uploader6 a;

    /* renamed from: b, reason: collision with root package name */
    public final BackendResponse f789b;
    public final Iterable c;
    public final TransportContext d;
    public final int e;

    public Uploader3(Uploader6 uploader6, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i) {
        this.a = uploader6;
        this.f789b = backendResponse;
        this.c = iterable;
        this.d = transportContext;
        this.e = i;
    }

    @Override // b.i.a.b.j.u.SynchronizationGuard.a
    public Object execute() {
        Uploader6 uploader6 = this.a;
        BackendResponse backendResponse = this.f789b;
        Iterable<PersistedEvent> iterable = this.c;
        TransportContext transportContext = this.d;
        int i = this.e;
        if (backendResponse.c() == BackendResponse.a.TRANSIENT_ERROR) {
            uploader6.c.n0(iterable);
            uploader6.d.a(transportContext, i + 1);
            return null;
        }
        uploader6.c.m(iterable);
        if (backendResponse.c() == BackendResponse.a.OK) {
            uploader6.c.v(transportContext, backendResponse.b() + uploader6.g.a());
        }
        if (!uploader6.c.l0(transportContext)) {
            return null;
        }
        uploader6.d.a(transportContext, 1);
        return null;
    }
}
