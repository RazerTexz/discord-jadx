package b.i.a.c.s2;

import b.i.a.c.Format2;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;
import b.i.a.c.v2.DecoderReuseEvaluation;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class y0 implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Format2 f1111b;
    public final /* synthetic */ DecoderReuseEvaluation c;

    public /* synthetic */ y0(AnalyticsListener.a aVar, Format2 format2, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.a = aVar;
        this.f1111b = format2;
        this.c = decoderReuseEvaluation;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        analyticsListener.h0();
        analyticsListener.B();
        analyticsListener.x();
    }
}
