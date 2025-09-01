package b.i.a.c.s2;

import b.i.a.c.a3.MediaLoadData;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class g implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaLoadData f1079b;

    public /* synthetic */ g(AnalyticsListener.a aVar, MediaLoadData mediaLoadData) {
        this.a = aVar;
        this.f1079b = mediaLoadData;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).H();
    }
}
