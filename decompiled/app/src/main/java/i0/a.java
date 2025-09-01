package i0;

import i0.DefaultCallAdapterFactory;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ DefaultCallAdapterFactory.b.a j;
    public final /* synthetic */ Callback3 k;
    public final /* synthetic */ Throwable l;

    public /* synthetic */ a(DefaultCallAdapterFactory.b.a aVar, Callback3 callback3, Throwable th) {
        this.j = aVar;
        this.k = callback3;
        this.l = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultCallAdapterFactory.b.a aVar = this.j;
        this.k.a(DefaultCallAdapterFactory.b.this, this.l);
    }
}
