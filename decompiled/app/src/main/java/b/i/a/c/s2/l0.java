package b.i.a.c.s2;

import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class l0 implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1092b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ l0(AnalyticsListener.a aVar, String str, long j, long j2) {
        this.a = aVar;
        this.f1092b = str;
        this.c = j;
        this.d = j2;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.k0();
        analyticsListener.U();
        analyticsListener.T();
    }
}
