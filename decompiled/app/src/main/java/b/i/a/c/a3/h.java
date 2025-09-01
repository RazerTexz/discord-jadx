package b.i.a.c.a3;

import b.i.a.c.x2.SeekMap;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ ProgressiveMediaPeriod j;
    public final /* synthetic */ SeekMap k;

    public /* synthetic */ h(ProgressiveMediaPeriod progressiveMediaPeriod, SeekMap seekMap) {
        this.j = progressiveMediaPeriod;
        this.k = seekMap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProgressiveMediaPeriod progressiveMediaPeriod = this.j;
        SeekMap seekMap = this.k;
        progressiveMediaPeriod.J = progressiveMediaPeriod.C == null ? seekMap : new SeekMap.b(-9223372036854775807L, 0L);
        progressiveMediaPeriod.K = seekMap.i();
        boolean z2 = progressiveMediaPeriod.Q == -1 && seekMap.i() == -9223372036854775807L;
        progressiveMediaPeriod.L = z2;
        progressiveMediaPeriod.M = z2 ? 7 : 1;
        ((ProgressiveMediaSource) progressiveMediaPeriod.r).u(progressiveMediaPeriod.K, seekMap.c(), progressiveMediaPeriod.L);
        if (progressiveMediaPeriod.G) {
            return;
        }
        progressiveMediaPeriod.x();
    }
}
