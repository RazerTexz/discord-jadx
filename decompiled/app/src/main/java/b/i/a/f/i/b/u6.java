package b.i.a.f.i.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class u6 implements Runnable {
    public final /* synthetic */ Boolean j;
    public final /* synthetic */ c6 k;

    public u6(c6 c6Var, Boolean bool) {
        this.k = c6Var;
        this.j = bool;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.k.D(this.j, true);
    }
}
