package b.i.a.c.s2;

import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class d1 implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1073b;
    public final /* synthetic */ int c;

    public /* synthetic */ d1(AnalyticsListener.a aVar, boolean z2, int i) {
        this.a = aVar;
        this.f1073b = z2;
        this.c = i;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).e();
    }
}
