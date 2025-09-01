package b.o.a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: CameraView.java */
/* renamed from: b.o.a.h, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraView4 implements Runnable {
    public final /* synthetic */ CameraView.b j;

    public CameraView4(CameraView.b bVar) {
        this.j = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<CameraListener> it = CameraView.this.D.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
        }
    }
}
