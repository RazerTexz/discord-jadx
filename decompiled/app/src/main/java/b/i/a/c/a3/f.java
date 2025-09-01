package b.i.a.c.a3;

import b.i.a.c.a3.MediaSourceEventListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ MediaSourceEventListener.a j;
    public final /* synthetic */ MediaSourceEventListener k;
    public final /* synthetic */ LoadEventInfo l;
    public final /* synthetic */ MediaLoadData m;

    public /* synthetic */ f(MediaSourceEventListener.a aVar, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.j = aVar;
        this.k = mediaSourceEventListener;
        this.l = loadEventInfo;
        this.m = mediaLoadData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaSourceEventListener.a aVar = this.j;
        this.k.q(aVar.a, aVar.f807b, this.l, this.m);
    }
}
