package h0.c;

import org.webrtc.SurfaceTextureHelper;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class s implements Runnable {
    public final /* synthetic */ SurfaceTextureHelper j;

    public /* synthetic */ s(SurfaceTextureHelper surfaceTextureHelper) {
        this.j = surfaceTextureHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.a();
    }
}
