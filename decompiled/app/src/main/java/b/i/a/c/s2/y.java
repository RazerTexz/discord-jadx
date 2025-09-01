package b.i.a.c.s2;

import b.i.a.c.a3.LoadEventInfo;
import b.i.a.c.a3.MediaLoadData;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class y implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoadEventInfo f1110b;
    public final /* synthetic */ MediaLoadData c;

    public /* synthetic */ y(AnalyticsListener.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.a = aVar;
        this.f1110b = loadEventInfo;
        this.c = mediaLoadData;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).p();
    }
}
