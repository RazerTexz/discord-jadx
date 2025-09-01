package h0.c;

import org.webrtc.VideoFileRenderer;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class d0 implements Runnable {
    public final /* synthetic */ VideoFileRenderer j;

    public /* synthetic */ d0(VideoFileRenderer videoFileRenderer) {
        this.j = videoFileRenderer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.c();
    }
}
