package b.i.a.c.g3;

import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoRendererEventListener2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ VideoRendererEventListener2.a j;
    public final /* synthetic */ String k;
    public final /* synthetic */ long l;
    public final /* synthetic */ long m;

    public /* synthetic */ i(VideoRendererEventListener2.a aVar, String str, long j, long j2) {
        this.j = aVar;
        this.k = str;
        this.l = j;
        this.m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.j;
        String str = this.k;
        long j = this.l;
        long j2 = this.m;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f995b;
        int i = Util2.a;
        videoRendererEventListener2.n(str, j, j2);
    }
}
