package b.o.a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;

/* compiled from: CameraView.java */
/* renamed from: b.o.a.g, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraView3 implements Runnable {
    public final /* synthetic */ CameraView.b j;

    public CameraView3(CameraView.b bVar) {
        this.j = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<CameraListener> it = CameraView.this.D.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }
}
