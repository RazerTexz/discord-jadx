package b.i.a.c.a3;

import b.i.a.c.a3.MediaSourceEventListener;
import java.io.IOException;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ MediaSourceEventListener.a j;
    public final /* synthetic */ MediaSourceEventListener k;
    public final /* synthetic */ LoadEventInfo l;
    public final /* synthetic */ MediaLoadData m;
    public final /* synthetic */ IOException n;
    public final /* synthetic */ boolean o;

    public /* synthetic */ b(MediaSourceEventListener.a aVar, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        this.j = aVar;
        this.k = mediaSourceEventListener;
        this.l = loadEventInfo;
        this.m = mediaLoadData;
        this.n = iOException;
        this.o = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaSourceEventListener.a aVar = this.j;
        this.k.g0(aVar.a, aVar.f807b, this.l, this.m, this.n, this.o);
    }
}
