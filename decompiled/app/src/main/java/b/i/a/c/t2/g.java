package b.i.a.c.t2;

import b.i.a.c.f3.Util2;
import b.i.a.c.t2.AudioRendererEventListener2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ AudioRendererEventListener2.a j;
    public final /* synthetic */ String k;

    public /* synthetic */ g(AudioRendererEventListener2.a aVar, String str) {
        this.j = aVar;
        this.k = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.j;
        String str = this.k;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f1126b;
        int i = Util2.a;
        audioRendererEventListener2.B(str);
    }
}
