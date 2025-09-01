package b.i.a.c.w2;

import b.i.a.c.w2.DrmSessionEventListener;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ DrmSessionEventListener.a j;
    public final /* synthetic */ DrmSessionEventListener k;

    public /* synthetic */ g(DrmSessionEventListener.a aVar, DrmSessionEventListener drmSessionEventListener) {
        this.j = aVar;
        this.k = drmSessionEventListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DrmSessionEventListener.a aVar = this.j;
        this.k.d0(aVar.a, aVar.f1156b);
    }
}
