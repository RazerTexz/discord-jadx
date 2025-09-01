package b.i.a.c.t2;

import b.i.a.c.f3.Util2;
import b.i.a.c.t2.AudioRendererEventListener2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ AudioRendererEventListener2.a j;
    public final /* synthetic */ String k;
    public final /* synthetic */ long l;
    public final /* synthetic */ long m;

    public /* synthetic */ f(AudioRendererEventListener2.a aVar, String str, long j, long j2) {
        this.j = aVar;
        this.k = str;
        this.l = j;
        this.m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.j;
        String str = this.k;
        long j = this.l;
        long j2 = this.m;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f1126b;
        int i = Util2.a;
        audioRendererEventListener2.C(str, j, j2);
    }
}
