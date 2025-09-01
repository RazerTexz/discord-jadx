package org.webrtc;

import androidx.annotation.Nullable;
import h0.c.c0;
import org.webrtc.VideoEncoder;

/* loaded from: classes3.dex */
public class VideoEncoderWrapper {
    @CalledByNative
    public static VideoEncoder.Callback createEncoderCallback(long j) {
        return new c0(j);
    }

    @Nullable
    @CalledByNative
    public static Integer getScalingSettingsHigh(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.high;
    }

    @Nullable
    @CalledByNative
    public static Integer getScalingSettingsLow(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.low;
    }

    @CalledByNative
    public static boolean getScalingSettingsOn(VideoEncoder.ScalingSettings scalingSettings) {
        return scalingSettings.on;
    }

    public static /* synthetic */ void lambda$createEncoderCallback$0(long j, EncodedImage encodedImage, VideoEncoder.CodecSpecificInfo codecSpecificInfo) {
        nativeOnEncodedFrame(j, encodedImage);
    }

    private static native void nativeOnEncodedFrame(long j, EncodedImage encodedImage);
}
