package h0.c;

import org.webrtc.SurfaceTextureHelper;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class v implements Runnable {
    public final /* synthetic */ SurfaceTextureHelper j;
    public final /* synthetic */ int k;

    public /* synthetic */ v(SurfaceTextureHelper surfaceTextureHelper, int i) {
        this.j = surfaceTextureHelper;
        this.k = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.e(this.k);
    }
}
