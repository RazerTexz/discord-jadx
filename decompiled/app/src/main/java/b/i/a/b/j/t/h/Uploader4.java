package b.i.a.b.j.t.h;

import b.i.a.b.j.t.i.EventStore;
import b.i.a.b.j.u.SynchronizationGuard;

/* compiled from: Uploader.java */
/* renamed from: b.i.a.b.j.t.h.j, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class Uploader4 implements SynchronizationGuard.a {
    public final EventStore a;

    public Uploader4(EventStore eventStore) {
        this.a = eventStore;
    }

    @Override // b.i.a.b.j.u.SynchronizationGuard.a
    public Object execute() {
        return Integer.valueOf(this.a.l());
    }
}
