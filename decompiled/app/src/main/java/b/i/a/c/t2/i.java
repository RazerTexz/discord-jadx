package b.i.a.c.t2;

import b.i.a.c.f3.Util2;
import b.i.a.c.t2.AudioRendererEventListener2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ AudioRendererEventListener2.a j;
    public final /* synthetic */ int k;
    public final /* synthetic */ long l;
    public final /* synthetic */ long m;

    public /* synthetic */ i(AudioRendererEventListener2.a aVar, int i, long j, long j2) {
        this.j = aVar;
        this.k = i;
        this.l = j;
        this.m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.j;
        int i = this.k;
        long j = this.l;
        long j2 = this.m;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f1126b;
        int i2 = Util2.a;
        audioRendererEventListener2.e0(i, j, j2);
    }
}
