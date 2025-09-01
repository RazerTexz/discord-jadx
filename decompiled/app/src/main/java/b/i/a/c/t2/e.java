package b.i.a.c.t2;

import b.i.a.c.Format2;
import b.i.a.c.f3.Util2;
import b.i.a.c.t2.AudioRendererEventListener2;
import b.i.a.c.v2.DecoderReuseEvaluation;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ AudioRendererEventListener2.a j;
    public final /* synthetic */ Format2 k;
    public final /* synthetic */ DecoderReuseEvaluation l;

    public /* synthetic */ e(AudioRendererEventListener2.a aVar, Format2 format2, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.j = aVar;
        this.k = format2;
        this.l = decoderReuseEvaluation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener2.a aVar = this.j;
        Format2 format2 = this.k;
        DecoderReuseEvaluation decoderReuseEvaluation = this.l;
        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f1126b;
        int i = Util2.a;
        audioRendererEventListener2.U(format2);
        aVar.f1126b.I(format2, decoderReuseEvaluation);
    }
}
