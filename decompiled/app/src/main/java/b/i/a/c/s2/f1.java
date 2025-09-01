package b.i.a.c.s2;

import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class f1 implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1078b;
    public final /* synthetic */ long c;

    public /* synthetic */ f1(AnalyticsListener.a aVar, Object obj, long j) {
        this.a = aVar;
        this.f1078b = obj;
        this.c = j;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).c();
    }
}
