package b.i.c.m.d.k;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes3.dex */
public class r implements Callable<Void> {
    public final /* synthetic */ x j;

    public r(x xVar) {
        this.j = xVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        x.a(this.j);
        return null;
    }
}
