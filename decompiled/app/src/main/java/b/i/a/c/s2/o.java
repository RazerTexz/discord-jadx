package b.i.a.c.s2;

import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class o implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    public /* synthetic */ o(AnalyticsListener.a aVar) {
        this.a = aVar;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).j0();
    }
}
