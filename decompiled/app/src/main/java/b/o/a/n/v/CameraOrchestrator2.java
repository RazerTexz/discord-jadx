package b.o.a.n.v;

import b.o.a.n.CameraEngine;
import b.o.a.n.v.CameraOrchestrator;
import b.o.a.r.WorkerHandler;
import java.util.Iterator;

/* compiled from: CameraOrchestrator.java */
/* renamed from: b.o.a.n.v.b, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraOrchestrator2 implements Runnable {
    public final /* synthetic */ CameraOrchestrator j;

    public CameraOrchestrator2(CameraOrchestrator cameraOrchestrator) {
        this.j = cameraOrchestrator;
    }

    @Override // java.lang.Runnable
    public void run() {
        CameraOrchestrator.c<?> cVar;
        synchronized (this.j.e) {
            cVar = null;
            if (!this.j.d) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator<CameraOrchestrator.c<?>> it = this.j.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CameraOrchestrator.c<?> next = it.next();
                    if (next.e <= jCurrentTimeMillis) {
                        cVar = next;
                        break;
                    }
                }
                if (cVar != null) {
                    this.j.d = true;
                }
            }
        }
        if (cVar != null) {
            CameraOrchestrator cameraOrchestrator = this.j;
            WorkerHandler workerHandler = CameraEngine.this.k;
            workerHandler.c(new CameraOrchestrator3(cameraOrchestrator, cVar, workerHandler));
        }
    }
}
