package b.i.a.c.g3;

import b.i.a.c.Format2;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoRendererEventListener2;
import b.i.a.c.v2.DecoderReuseEvaluation;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ VideoRendererEventListener2.a j;
    public final /* synthetic */ Format2 k;
    public final /* synthetic */ DecoderReuseEvaluation l;

    public /* synthetic */ k(VideoRendererEventListener2.a aVar, Format2 format2, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.j = aVar;
        this.k = format2;
        this.l = decoderReuseEvaluation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoRendererEventListener2.a aVar = this.j;
        Format2 format2 = this.k;
        DecoderReuseEvaluation decoderReuseEvaluation = this.l;
        VideoRendererEventListener2 videoRendererEventListener2 = aVar.f995b;
        int i = Util2.a;
        videoRendererEventListener2.O(format2);
        aVar.f995b.Q(format2, decoderReuseEvaluation);
    }
}
