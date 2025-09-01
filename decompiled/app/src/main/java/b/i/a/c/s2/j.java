package b.i.a.c.s2;

import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;
import b.i.a.c.v2.DecoderCounters;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class j implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f1087b;

    public /* synthetic */ j(AnalyticsListener.a aVar, DecoderCounters decoderCounters) {
        this.a = aVar;
        this.f1087b = decoderCounters;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.m();
        analyticsListener.g();
    }
}
