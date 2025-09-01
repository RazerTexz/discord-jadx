package b.i.a.c.s2;

import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class p0 implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1097b;

    public /* synthetic */ p0(AnalyticsListener.a aVar, int i) {
        this.a = aVar;
        this.f1097b = i;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.p0();
        analyticsListener.X();
    }
}
