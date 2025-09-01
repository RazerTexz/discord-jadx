package b.i.a.c.g3;

import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoRendererEventListener2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ VideoRendererEventListener2.a j;
    public final /* synthetic */ int k;
    public final /* synthetic */ long l;

    public /* synthetic */ h(VideoRendererEventListener2.a aVar, int i, long j) {
        this.j = aVar;
        this.k = i;
        this.l = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.j;
        int i = this.k;
        long j = this.l;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f995b;
        int i2 = Util2.a;
        videoRendererEventListener2.F(i, j);
    }
}
