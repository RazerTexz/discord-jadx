package b.i.a.c.f3;

import b.i.a.c.f3.NetworkTypeObserver;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ NetworkTypeObserver j;
    public final /* synthetic */ NetworkTypeObserver.b k;

    public /* synthetic */ c(NetworkTypeObserver networkTypeObserver, NetworkTypeObserver.b bVar) {
        this.j = networkTypeObserver;
        this.k = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        NetworkTypeObserver networkTypeObserver = this.j;
        NetworkTypeObserver.b bVar = this.k;
        synchronized (networkTypeObserver.d) {
            i = networkTypeObserver.e;
        }
        bVar.a(i);
    }
}
