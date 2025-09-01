package h0.c;

import java.util.concurrent.CountDownLatch;
import org.webrtc.VideoFileRenderer;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class f0 implements Runnable {
    public final /* synthetic */ VideoFileRenderer j;
    public final /* synthetic */ CountDownLatch k;

    public /* synthetic */ f0(VideoFileRenderer videoFileRenderer, CountDownLatch countDownLatch) {
        this.j = videoFileRenderer;
        this.k = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.b(this.k);
    }
}
