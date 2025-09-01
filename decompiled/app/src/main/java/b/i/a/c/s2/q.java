package b.i.a.c.s2;

import b.i.a.c.MediaItem2;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class q implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaItem2 f1098b;
    public final /* synthetic */ int c;

    public /* synthetic */ q(AnalyticsListener.a aVar, MediaItem2 mediaItem2, int i) {
        this.a = aVar;
        this.f1098b = mediaItem2;
        this.c = i;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).t();
    }
}
