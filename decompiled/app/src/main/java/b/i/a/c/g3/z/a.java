package b.i.a.c.g3.z;

import android.graphics.SurfaceTexture;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements SurfaceTexture.OnFrameAvailableListener {
    public final /* synthetic */ SceneRenderer j;

    public /* synthetic */ a(SceneRenderer sceneRenderer) {
        this.j = sceneRenderer;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.j.j.set(true);
    }
}
