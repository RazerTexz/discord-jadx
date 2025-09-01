package b.i.a.c;

import android.content.Context;
import b.i.a.c.e3.DefaultBandwidthMeter;
import b.i.b.a.Supplier2;
import b.i.b.b.ImmutableList2;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Supplier2 {
    public final /* synthetic */ Context j;

    public /* synthetic */ e(Context context) {
        this.j = context;
    }

    @Override // b.i.b.a.Supplier2
    public final Object get() {
        DefaultBandwidthMeter defaultBandwidthMeter;
        Context context = this.j;
        ImmutableList2<Long> immutableList2 = DefaultBandwidthMeter.a;
        synchronized (DefaultBandwidthMeter.class) {
            if (DefaultBandwidthMeter.g == null) {
                DefaultBandwidthMeter.b bVar = new DefaultBandwidthMeter.b(context);
                DefaultBandwidthMeter.g = new DefaultBandwidthMeter(bVar.a, bVar.f947b, bVar.c, bVar.d, bVar.e, null);
            }
            defaultBandwidthMeter = DefaultBandwidthMeter.g;
        }
        return defaultBandwidthMeter;
    }
}
