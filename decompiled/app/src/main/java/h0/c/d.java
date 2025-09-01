package h0.c;

import org.webrtc.Camera2Session;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements VideoSink {
    public final /* synthetic */ Camera2Session.CaptureSessionCallback j;

    public /* synthetic */ d(Camera2Session.CaptureSessionCallback captureSessionCallback) {
        this.j = captureSessionCallback;
    }

    @Override // org.webrtc.VideoSink
    public final void onFrame(VideoFrame videoFrame) {
        this.j.a(videoFrame);
    }
}
