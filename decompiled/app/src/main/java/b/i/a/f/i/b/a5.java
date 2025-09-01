package b.i.a.f.i.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public abstract class a5 extends z1 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f1518b;

    public a5(u4 u4Var) {
        super(u4Var);
        this.a.F++;
    }

    public final void t() {
        if (!this.f1518b) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void u() {
        if (this.f1518b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (v()) {
            return;
        }
        this.a.G.incrementAndGet();
        this.f1518b = true;
    }

    public abstract boolean v();
}
