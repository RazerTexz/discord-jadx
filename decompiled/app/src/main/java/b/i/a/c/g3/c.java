package b.i.a.c.g3;

import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoRendererEventListener2;
import b.i.a.c.v2.DecoderCounters;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ VideoRendererEventListener2.a j;
    public final /* synthetic */ DecoderCounters k;

    public /* synthetic */ c(VideoRendererEventListener2.a aVar, DecoderCounters decoderCounters) {
        this.j = aVar;
        this.k = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.j;
        DecoderCounters decoderCounters = this.k;
        Objects.requireNonNull(aVar);
        synchronized (decoderCounters) {
        }
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f995b;
        int i = Util2.a;
        videoRendererEventListener2.Z(decoderCounters);
    }
}
