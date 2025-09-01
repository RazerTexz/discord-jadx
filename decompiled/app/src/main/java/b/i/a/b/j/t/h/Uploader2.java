package b.i.a.b.j.t.h;

import b.i.a.b.j.TransportContext;
import b.i.a.b.j.u.SynchronizationGuard;

/* compiled from: Uploader.java */
/* renamed from: b.i.a.b.j.t.h.h, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class Uploader2 implements SynchronizationGuard.a {
    public final Uploader6 a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f788b;

    public Uploader2(Uploader6 uploader6, TransportContext transportContext) {
        this.a = uploader6;
        this.f788b = transportContext;
    }

    @Override // b.i.a.b.j.u.SynchronizationGuard.a
    public Object execute() {
        Uploader6 uploader6 = this.a;
        return uploader6.c.r(this.f788b);
    }
}
