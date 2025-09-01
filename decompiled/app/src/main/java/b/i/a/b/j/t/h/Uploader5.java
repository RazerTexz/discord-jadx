package b.i.a.b.j.t.h;

import b.i.a.b.j.TransportContext;
import b.i.a.b.j.u.SynchronizationGuard;

/* compiled from: Uploader.java */
/* renamed from: b.i.a.b.j.t.h.k, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class Uploader5 implements SynchronizationGuard.a {
    public final Uploader6 a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f790b;
    public final int c;

    public Uploader5(Uploader6 uploader6, TransportContext transportContext, int i) {
        this.a = uploader6;
        this.f790b = transportContext;
        this.c = i;
    }

    @Override // b.i.a.b.j.u.SynchronizationGuard.a
    public Object execute() {
        Uploader6 uploader6 = this.a;
        uploader6.d.a(this.f790b, this.c + 1);
        return null;
    }
}
