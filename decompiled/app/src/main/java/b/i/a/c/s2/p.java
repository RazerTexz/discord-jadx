package b.i.a.c.s2;

import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ AnalyticsCollector j;

    public /* synthetic */ p(AnalyticsCollector analyticsCollector) {
        this.j = analyticsCollector;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnalyticsCollector analyticsCollector = this.j;
        AnalyticsListener.a aVarK0 = analyticsCollector.k0();
        x0 x0Var = new x0(aVarK0);
        analyticsCollector.n.put(1036, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = analyticsCollector.o;
        listenerSet.b(1036, x0Var);
        listenerSet.a();
        analyticsCollector.o.c();
    }
}
