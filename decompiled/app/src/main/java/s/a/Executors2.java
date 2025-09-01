package s.a;

import b.d.b.a.outline;
import java.util.concurrent.Future;

/* compiled from: Executors.kt */
/* renamed from: s.a.l0, reason: use source file name */
/* loaded from: classes3.dex */
public final class Executors2 implements Job2 {
    public final Future<?> j;

    public Executors2(Future<?> future) {
        this.j = future;
    }

    @Override // s.a.Job2
    public void dispose() {
        this.j.cancel(false);
    }

    public String toString() {
        StringBuilder sbU = outline.U("DisposableFutureHandle[");
        sbU.append(this.j);
        sbU.append(']');
        return sbU.toString();
    }
}
