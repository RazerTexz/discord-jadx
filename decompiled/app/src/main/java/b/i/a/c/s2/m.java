package b.i.a.c.s2;

import b.i.a.c.PlaybackParameters;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class m implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PlaybackParameters f1093b;

    public /* synthetic */ m(AnalyticsListener.a aVar, PlaybackParameters playbackParameters) {
        this.a = aVar;
        this.f1093b = playbackParameters;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).I();
    }
}
