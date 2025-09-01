package b.i.a.b.j.t.h;

import b.i.a.b.j.TransportContext;
import b.i.a.b.j.u.SynchronizationGuard;
import java.util.Iterator;

/* compiled from: WorkInitializer.java */
/* renamed from: b.i.a.b.j.t.h.o, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class WorkInitializer2 implements SynchronizationGuard.a {
    public final WorkInitializer3 a;

    public WorkInitializer2(WorkInitializer3 workInitializer3) {
        this.a = workInitializer3;
    }

    @Override // b.i.a.b.j.u.SynchronizationGuard.a
    public Object execute() {
        WorkInitializer3 workInitializer3 = this.a;
        Iterator<TransportContext> it = workInitializer3.f793b.z().iterator();
        while (it.hasNext()) {
            workInitializer3.c.a(it.next(), 1);
        }
        return null;
    }
}
