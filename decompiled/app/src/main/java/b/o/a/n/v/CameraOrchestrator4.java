package b.o.a.n.v;

import com.google.android.gms.tasks.Task;

/* compiled from: CameraOrchestrator.java */
/* renamed from: b.o.a.n.v.d, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraOrchestrator4 implements Runnable {
    public final /* synthetic */ b.i.a.f.n.c j;
    public final /* synthetic */ Task k;

    public CameraOrchestrator4(b.i.a.f.n.c cVar, Task task) {
        this.j = cVar;
        this.k = task;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.onComplete(this.k);
    }
}
