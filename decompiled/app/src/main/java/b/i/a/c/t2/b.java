package b.i.a.c.t2;

import b.i.a.c.f3.Util2;
import b.i.a.c.t2.AudioRendererEventListener2;
import b.i.a.c.v2.DecoderCounters;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ AudioRendererEventListener2.a j;
    public final /* synthetic */ DecoderCounters k;

    public /* synthetic */ b(AudioRendererEventListener2.a aVar, DecoderCounters decoderCounters) {
        this.j = aVar;
        this.k = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.j;
        DecoderCounters decoderCounters = this.k;
        Objects.requireNonNull(aVar);
        synchronized (decoderCounters) {
        }
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f1126b;
        int i = Util2.a;
        audioRendererEventListener2.k(decoderCounters);
    }
}
