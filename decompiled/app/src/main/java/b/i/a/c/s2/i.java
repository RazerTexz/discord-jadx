package b.i.a.c.s2;

import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.c3.TrackSelectionArray;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements ListenerSet.a {
    public final /* synthetic */ AnalyticsListener.a a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TrackGroupArray f1085b;
    public final /* synthetic */ TrackSelectionArray c;

    public /* synthetic */ i(AnalyticsListener.a aVar, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        this.a = aVar;
        this.f1085b = trackGroupArray;
        this.c = trackSelectionArray;
    }

    @Override // b.i.a.c.f3.ListenerSet.a
    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).m0();
    }
}
