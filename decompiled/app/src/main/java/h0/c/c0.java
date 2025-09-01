package h0.c;

import org.webrtc.EncodedImage;
import org.webrtc.VideoEncoder;
import org.webrtc.VideoEncoderWrapper;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c0 implements VideoEncoder.Callback {
    public final /* synthetic */ long a;

    public /* synthetic */ c0(long j) {
        this.a = j;
    }

    @Override // org.webrtc.VideoEncoder.Callback
    public final void onEncodedFrame(EncodedImage encodedImage, VideoEncoder.CodecSpecificInfo codecSpecificInfo) {
        VideoEncoderWrapper.lambda$createEncoderCallback$0(this.a, encodedImage, codecSpecificInfo);
    }
}
