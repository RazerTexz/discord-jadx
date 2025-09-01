package b.i.a.c.g3.z;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import b.i.a.c.g3.z.SphericalGLSurfaceView;
import java.util.Iterator;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ SphericalGLSurfaceView j;
    public final /* synthetic */ SurfaceTexture k;

    public /* synthetic */ b(SphericalGLSurfaceView sphericalGLSurfaceView, SurfaceTexture surfaceTexture) {
        this.j = sphericalGLSurfaceView;
        this.k = surfaceTexture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SphericalGLSurfaceView sphericalGLSurfaceView = this.j;
        SurfaceTexture surfaceTexture = this.k;
        SurfaceTexture surfaceTexture2 = sphericalGLSurfaceView.q;
        Surface surface = sphericalGLSurfaceView.r;
        Surface surface2 = new Surface(surfaceTexture);
        sphericalGLSurfaceView.q = surfaceTexture;
        sphericalGLSurfaceView.r = surface2;
        Iterator<SphericalGLSurfaceView.b> it = sphericalGLSurfaceView.j.iterator();
        while (it.hasNext()) {
            it.next().u(surface2);
        }
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        if (surface != null) {
            surface.release();
        }
    }
}
