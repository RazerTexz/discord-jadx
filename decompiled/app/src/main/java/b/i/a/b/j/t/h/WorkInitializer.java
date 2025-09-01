package b.i.a.b.j.t.h;

/* compiled from: WorkInitializer.java */
/* renamed from: b.i.a.b.j.t.h.n, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class WorkInitializer implements Runnable {
    public final WorkInitializer3 j;

    public WorkInitializer(WorkInitializer3 workInitializer3) {
        this.j = workInitializer3;
    }

    @Override // java.lang.Runnable
    public void run() {
        WorkInitializer3 workInitializer3 = this.j;
        workInitializer3.d.a(new WorkInitializer2(workInitializer3));
    }
}
