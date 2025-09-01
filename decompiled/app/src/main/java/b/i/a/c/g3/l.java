package b.i.a.c.g3;

import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoRendererEventListener2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ VideoRendererEventListener2.a j;
    public final /* synthetic */ long k;
    public final /* synthetic */ int l;

    public /* synthetic */ l(VideoRendererEventListener2.a aVar, long j, int i) {
        this.j = aVar;
        this.k = j;
        this.l = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.j;
        long j = this.k;
        int i = this.l;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f995b;
        int i2 = Util2.a;
        videoRendererEventListener2.h0(j, i);
    }
}
