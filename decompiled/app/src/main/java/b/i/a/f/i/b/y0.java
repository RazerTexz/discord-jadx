package b.i.a.f.i.b;

import b.c.a.a0.AnimatableValueParser;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class y0 implements Runnable {
    public final /* synthetic */ String j;
    public final /* synthetic */ long k;
    public final /* synthetic */ a l;

    public y0(a aVar, String str, long j) {
        this.l = aVar;
        this.j = str;
        this.k = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.l;
        String str = this.j;
        long j = this.k;
        aVar.b();
        AnimatableValueParser.w(str);
        if (aVar.c.isEmpty()) {
            aVar.d = j;
        }
        Integer num = aVar.c.get(str);
        if (num != null) {
            aVar.c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (aVar.c.size() >= 100) {
            aVar.g().i.a("Too many ads visible");
        } else {
            aVar.c.put(str, 1);
            aVar.f1512b.put(str, Long.valueOf(j));
        }
    }
}
