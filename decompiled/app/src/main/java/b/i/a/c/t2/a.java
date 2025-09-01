package b.i.a.c.t2;

import b.i.a.c.f3.Util2;
import b.i.a.c.t2.AudioRendererEventListener2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ AudioRendererEventListener2.a j;
    public final /* synthetic */ boolean k;

    public /* synthetic */ a(AudioRendererEventListener2.a aVar, boolean z2) {
        this.j = aVar;
        this.k = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.j;
        boolean z2 = this.k;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f1126b;
        int i = Util2.a;
        audioRendererEventListener2.d(z2);
    }
}
