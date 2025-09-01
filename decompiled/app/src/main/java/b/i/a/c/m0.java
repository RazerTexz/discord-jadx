package b.i.a.c;

import b.i.a.c.a3.MediaSource2;
import b.i.a.c.s2.AnalyticsCollector;
import b.i.b.b.ImmutableList2;
import java.util.Objects;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class m0 implements Runnable {
    public final /* synthetic */ MediaPeriodQueue j;
    public final /* synthetic */ ImmutableList2.a k;
    public final /* synthetic */ MediaSource2.a l;

    public /* synthetic */ m0(MediaPeriodQueue mediaPeriodQueue, ImmutableList2.a aVar, MediaSource2.a aVar2) {
        this.j = mediaPeriodQueue;
        this.k = aVar;
        this.l = aVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        MediaPeriodQueue mediaPeriodQueue = this.j;
        ImmutableList2.a aVar = this.k;
        MediaSource2.a aVar2 = this.l;
        AnalyticsCollector analyticsCollector = mediaPeriodQueue.c;
        ImmutableList2 immutableList2C = aVar.c();
        AnalyticsCollector.a aVar3 = analyticsCollector.m;
        Player2 player2 = analyticsCollector.p;
        Objects.requireNonNull(player2);
        Objects.requireNonNull(aVar3);
        aVar3.f1081b = ImmutableList2.n(immutableList2C);
        if (!immutableList2C.isEmpty()) {
            aVar3.e = (MediaSource2.a) immutableList2C.get(0);
            Objects.requireNonNull(aVar2);
            aVar3.f = aVar2;
        }
        if (aVar3.d == null) {
            aVar3.d = AnalyticsCollector.a.b(player2, aVar3.f1081b, aVar3.e, aVar3.a);
        }
        aVar3.d(player2.K());
    }
}
