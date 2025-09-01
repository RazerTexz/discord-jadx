package b.i.a.c.e3;

import b.i.a.c.f3.NetworkTypeObserver;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements NetworkTypeObserver.b {
    public final /* synthetic */ DefaultBandwidthMeter a;

    public /* synthetic */ b(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.a = defaultBandwidthMeter;
    }

    @Override // b.i.a.c.f3.NetworkTypeObserver.b
    public final void a(int i) {
        DefaultBandwidthMeter defaultBandwidthMeter = this.a;
        synchronized (defaultBandwidthMeter) {
            int i2 = defaultBandwidthMeter.p;
            if (i2 == 0 || defaultBandwidthMeter.l) {
                if (i2 == i) {
                    return;
                }
                defaultBandwidthMeter.p = i;
                if (i != 1 && i != 0 && i != 8) {
                    defaultBandwidthMeter.f946s = defaultBandwidthMeter.h(i);
                    long jD = defaultBandwidthMeter.k.d();
                    defaultBandwidthMeter.j(defaultBandwidthMeter.m > 0 ? (int) (jD - defaultBandwidthMeter.n) : 0, defaultBandwidthMeter.o, defaultBandwidthMeter.f946s);
                    defaultBandwidthMeter.n = jD;
                    defaultBandwidthMeter.o = 0L;
                    defaultBandwidthMeter.r = 0L;
                    defaultBandwidthMeter.q = 0L;
                    SlidingPercentile slidingPercentile = defaultBandwidthMeter.j;
                    slidingPercentile.c.clear();
                    slidingPercentile.e = -1;
                    slidingPercentile.f = 0;
                    slidingPercentile.g = 0;
                }
            }
        }
    }
}
