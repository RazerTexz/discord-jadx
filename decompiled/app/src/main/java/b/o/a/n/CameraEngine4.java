package b.o.a.n;

import b.o.a.CameraOptions;
import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraException;
import java.util.concurrent.Callable;

/* compiled from: CameraEngine.java */
/* renamed from: b.o.a.n.l, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraEngine4 implements Callable<Task<CameraOptions>> {
    public final /* synthetic */ CameraEngine j;

    public CameraEngine4(CameraEngine cameraEngine) {
        this.j = cameraEngine;
    }

    @Override // java.util.concurrent.Callable
    public Task<CameraOptions> call() throws Exception {
        CameraEngine cameraEngine = this.j;
        if (cameraEngine.c(cameraEngine.l())) {
            return this.j.Q();
        }
        CameraEngine.j.a(3, "onStartEngine:", "No camera available for facing", this.j.l());
        throw new CameraException(6);
    }
}
