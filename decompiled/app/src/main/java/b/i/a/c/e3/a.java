package b.i.a.c.e3;

import androidx.core.view.PointerIconCompat;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.e3.BandwidthMeter;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.s2.AnalyticsCollector;
import b.i.a.c.s2.AnalyticsListener;
import b.i.a.c.s2.s0;
import b.i.b.b.ImmutableList2;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ BandwidthMeter.a.C0029a.C0030a j;
    public final /* synthetic */ int k;
    public final /* synthetic */ long l;
    public final /* synthetic */ long m;

    public /* synthetic */ a(BandwidthMeter.a.C0029a.C0030a c0030a, int i, long j, long j2) {
        this.j = c0030a;
        this.k = i;
        this.l = j;
        this.m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaSource2.a next;
        MediaSource2.a aVar;
        MediaSource2.a aVar2;
        BandwidthMeter.a.C0029a.C0030a c0030a = this.j;
        int i = this.k;
        long j = this.l;
        long j2 = this.m;
        AnalyticsCollector analyticsCollector = (AnalyticsCollector) c0030a.f940b;
        AnalyticsCollector.a aVar3 = analyticsCollector.m;
        if (aVar3.f1081b.isEmpty()) {
            aVar2 = null;
        } else {
            ImmutableList2<MediaSource2.a> immutableList2 = aVar3.f1081b;
            if (!(immutableList2 instanceof List)) {
                Iterator<MediaSource2.a> it = immutableList2.iterator();
                do {
                    next = it.next();
                } while (it.hasNext());
                aVar = next;
            } else {
                if (immutableList2.isEmpty()) {
                    throw new NoSuchElementException();
                }
                aVar = immutableList2.get(immutableList2.size() - 1);
            }
            aVar2 = aVar;
        }
        AnalyticsListener.a aVarM0 = analyticsCollector.m0(aVar2);
        s0 s0Var = new s0(aVarM0, i, j, j2);
        analyticsCollector.n.put(PointerIconCompat.TYPE_CELL, aVarM0);
        ListenerSet<AnalyticsListener> listenerSet = analyticsCollector.o;
        listenerSet.b(PointerIconCompat.TYPE_CELL, s0Var);
        listenerSet.a();
    }
}
