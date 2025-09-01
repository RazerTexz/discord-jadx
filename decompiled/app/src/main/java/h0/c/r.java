package h0.c;

import android.graphics.SurfaceTexture;
import org.webrtc.SurfaceTextureHelper;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class r implements SurfaceTexture.OnFrameAvailableListener {
    public final /* synthetic */ SurfaceTextureHelper j;

    public /* synthetic */ r(SurfaceTextureHelper surfaceTextureHelper) {
        this.j = surfaceTextureHelper;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.j.c(surfaceTexture);
    }
}
