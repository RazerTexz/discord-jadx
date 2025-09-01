package b.i.a.c.s2;

import b.i.a.c.TracksInfo;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class w implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TracksInfo f1107b;

    public /* synthetic */ w(AnalyticsListener.a aVar, TracksInfo tracksInfo) {
        this.a = aVar;
        this.f1107b = tracksInfo;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).i();
    }
}
