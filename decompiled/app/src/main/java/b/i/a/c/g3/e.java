package b.i.a.c.g3;

import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoRendererEventListener2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ VideoRendererEventListener2.a j;
    public final /* synthetic */ Exception k;

    public /* synthetic */ e(VideoRendererEventListener2.a aVar, Exception exc) {
        this.j = aVar;
        this.k = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.j;
        Exception exc = this.k;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f995b;
        int i = Util2.a;
        videoRendererEventListener2.V(exc);
    }
}
