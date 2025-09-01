package h0.c;

import java.util.concurrent.CountDownLatch;
import org.webrtc.EglRenderer;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ EglRenderer j;
    public final /* synthetic */ CountDownLatch k;
    public final /* synthetic */ EglRenderer.FrameListener l;

    public /* synthetic */ g(EglRenderer eglRenderer, CountDownLatch countDownLatch, EglRenderer.FrameListener frameListener) {
        this.j = eglRenderer;
        this.k = countDownLatch;
        this.l = frameListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.h(this.k, this.l);
    }
}
