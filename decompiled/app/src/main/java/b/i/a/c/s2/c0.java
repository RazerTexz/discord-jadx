package b.i.a.c.s2;

import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c0 implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1069b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ c0(AnalyticsListener.a aVar, int i, long j, long j2) {
        this.a = aVar;
        this.f1069b = i;
        this.c = j;
        this.d = j2;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).C();
    }
}
