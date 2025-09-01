package b.i.a.c.s2;

import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class n0 implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1096b;

    public /* synthetic */ n0(AnalyticsListener.a aVar, long j) {
        this.a = aVar;
        this.f1096b = j;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).j();
    }
}
