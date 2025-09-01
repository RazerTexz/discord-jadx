package b.o.a.n;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* compiled from: CameraEngine.java */
/* renamed from: b.o.a.n.n, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraEngine6 implements Callable<Task<Void>> {
    public final /* synthetic */ CameraEngine j;

    public CameraEngine6(CameraEngine cameraEngine) {
        this.j = cameraEngine;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        return this.j.T();
    }
}
