package b.i.a.c.s2;

import b.i.a.c.Player2;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class r implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1100b;
    public final /* synthetic */ Player2.f c;
    public final /* synthetic */ Player2.f d;

    public /* synthetic */ r(AnalyticsListener.a aVar, int i, Player2.f fVar, Player2.f fVar2) {
        this.a = aVar;
        this.f1100b = i;
        this.c = fVar;
        this.d = fVar2;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.S();
        analyticsListener.y();
    }
}
