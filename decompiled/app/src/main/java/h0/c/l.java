package h0.c;

import org.webrtc.EglRenderer;
import org.webrtc.RendererCommon;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ EglRenderer j;
    public final /* synthetic */ RendererCommon.GlDrawer k;
    public final /* synthetic */ EglRenderer.FrameListener l;
    public final /* synthetic */ float m;
    public final /* synthetic */ boolean n;

    public /* synthetic */ l(EglRenderer eglRenderer, RendererCommon.GlDrawer glDrawer, EglRenderer.FrameListener frameListener, float f, boolean z2) {
        this.j = eglRenderer;
        this.k = glDrawer;
        this.l = frameListener;
        this.m = f;
        this.n = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.a(this.k, this.l, this.m, this.n);
    }
}
