package b.i.a.c.s2;

import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b1 implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1067b;

    public /* synthetic */ b1(AnalyticsListener.a aVar, int i) {
        this.a = aVar;
        this.f1067b = i;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).e0();
    }
}
