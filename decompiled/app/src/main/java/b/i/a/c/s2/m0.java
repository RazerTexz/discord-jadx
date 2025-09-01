package b.i.a.c.s2;

import b.i.a.c.f3.ListenerSet;
import b.i.a.c.g3.VideoSize;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class m0 implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoSize f1094b;

    public /* synthetic */ m0(AnalyticsListener.a aVar, VideoSize videoSize) {
        this.a = aVar;
        this.f1094b = videoSize;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        VideoSize videoSize = this.f1094b;
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.n0();
        int i = videoSize.k;
        analyticsListener.r();
    }
}
