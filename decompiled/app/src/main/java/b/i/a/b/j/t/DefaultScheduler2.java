package b.i.a.b.j.t;

import b.i.a.b.j.EventInternal;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.u.SynchronizationGuard;

/* compiled from: DefaultScheduler.java */
/* renamed from: b.i.a.b.j.t.b, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class DefaultScheduler2 implements SynchronizationGuard.a {
    public final DefaultScheduler3 a;

    /* renamed from: b, reason: collision with root package name */
    public final TransportContext f780b;
    public final EventInternal c;

    public DefaultScheduler2(DefaultScheduler3 defaultScheduler3, TransportContext transportContext, EventInternal eventInternal) {
        this.a = defaultScheduler3;
        this.f780b = transportContext;
        this.c = eventInternal;
    }

    @Override // b.i.a.b.j.u.SynchronizationGuard.a
    public Object execute() {
        DefaultScheduler3 defaultScheduler3 = this.a;
        TransportContext transportContext = this.f780b;
        defaultScheduler3.e.a0(transportContext, this.c);
        defaultScheduler3.f781b.a(transportContext, 1);
        return null;
    }
}
