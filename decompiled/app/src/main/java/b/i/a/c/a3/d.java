package b.i.a.c.a3;

import b.i.a.c.a3.MediaSourceEventListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ MediaSourceEventListener.a j;
    public final /* synthetic */ MediaSourceEventListener k;
    public final /* synthetic */ MediaLoadData l;

    public /* synthetic */ d(MediaSourceEventListener.a aVar, MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
        this.j = aVar;
        this.k = mediaSourceEventListener;
        this.l = mediaLoadData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaSourceEventListener.a aVar = this.j;
        this.k.o(aVar.a, aVar.f807b, this.l);
    }
}
