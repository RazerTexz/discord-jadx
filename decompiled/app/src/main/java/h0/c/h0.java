package h0.c;

import org.webrtc.VideoFrame;
import org.webrtc.VideoSource;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class h0 implements Runnable {
    public final /* synthetic */ VideoSource j;
    public final /* synthetic */ VideoFrame k;

    public /* synthetic */ h0(VideoSource videoSource, VideoFrame videoFrame) {
        this.j = videoSource;
        this.k = videoFrame;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.a(this.k);
    }
}
