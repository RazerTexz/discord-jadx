package b.i.a.f.i.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class i6 implements Runnable {
    public final /* synthetic */ long j;
    public final /* synthetic */ c6 k;

    public i6(c6 c6Var, long j) {
        this.k = c6Var;
        this.j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.k.l().q.b(this.j);
        this.k.g().m.b("Minimum session duration set", Long.valueOf(this.j));
    }
}
