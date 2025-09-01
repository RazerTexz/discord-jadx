package org.webrtc;

import androidx.annotation.Nullable;
import h0.c.VideoProcessor2;
import h0.c.i0;
import org.webrtc.VideoProcessor;

/* loaded from: classes3.dex */
public class VideoSource extends MediaSource {
    private final CapturerObserver capturerObserver;
    private boolean isCapturerRunning;
    private final NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource;

    @Nullable
    private VideoProcessor videoProcessor;
    private final Object videoProcessorLock;

    /* renamed from: org.webrtc.VideoSource$1, reason: invalid class name */
    public class AnonymousClass1 implements CapturerObserver {
        public AnonymousClass1() {
        }

        @Override // org.webrtc.CapturerObserver
        public void onCapturerStarted(boolean z2) {
            VideoSource.access$000(VideoSource.this).setState(z2);
            synchronized (VideoSource.access$100(VideoSource.this)) {
                VideoSource.access$202(VideoSource.this, z2);
                if (VideoSource.access$300(VideoSource.this) != null) {
                    VideoSource.access$300(VideoSource.this).onCapturerStarted(z2);
                }
            }
        }

        @Override // org.webrtc.CapturerObserver
        public void onCapturerStopped() {
            VideoSource.access$000(VideoSource.this).setState(false);
            synchronized (VideoSource.access$100(VideoSource.this)) {
                VideoSource.access$202(VideoSource.this, false);
                if (VideoSource.access$300(VideoSource.this) != null) {
                    VideoSource.access$300(VideoSource.this).onCapturerStopped();
                }
            }
        }

        @Override // org.webrtc.CapturerObserver
        public void onFrameCaptured(VideoFrame videoFrame) {
            VideoProcessor.FrameAdaptationParameters frameAdaptationParametersAdaptFrame = VideoSource.access$000(VideoSource.this).adaptFrame(videoFrame);
            synchronized (VideoSource.access$100(VideoSource.this)) {
                if (VideoSource.access$300(VideoSource.this) != null) {
                    VideoSource.access$300(VideoSource.this).onFrameCaptured(videoFrame, frameAdaptationParametersAdaptFrame);
                    return;
                }
                VideoFrame videoFrameB = VideoProcessor2.b(videoFrame, frameAdaptationParametersAdaptFrame);
                if (videoFrameB != null) {
                    VideoSource.access$000(VideoSource.this).onFrameCaptured(videoFrameB);
                    videoFrameB.release();
                }
            }
        }
    }

    public static class AspectRatio {
        public static final AspectRatio UNDEFINED = new AspectRatio(0, 0);
        public final int height;
        public final int width;

        public AspectRatio(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }

    public VideoSource(long j) {
        super(j);
        this.videoProcessorLock = new Object();
        this.capturerObserver = new AnonymousClass1();
        this.nativeAndroidVideoTrackSource = new NativeAndroidVideoTrackSource(j);
    }

    public static /* synthetic */ NativeAndroidVideoTrackSource access$000(VideoSource videoSource) {
        return videoSource.nativeAndroidVideoTrackSource;
    }

    public static /* synthetic */ Object access$100(VideoSource videoSource) {
        return videoSource.videoProcessorLock;
    }

    public static /* synthetic */ boolean access$202(VideoSource videoSource, boolean z2) {
        videoSource.isCapturerRunning = z2;
        return z2;
    }

    public static /* synthetic */ VideoProcessor access$300(VideoSource videoSource) {
        return videoSource.videoProcessor;
    }

    public /* synthetic */ void a(VideoFrame videoFrame) {
        this.nativeAndroidVideoTrackSource.onFrameCaptured(videoFrame);
    }

    public void adaptOutputFormat(int i, int i2, int i3) {
        int iMax = Math.max(i, i2);
        int iMin = Math.min(i, i2);
        adaptOutputFormat(iMax, iMin, iMin, iMax, i3);
    }

    @Override // org.webrtc.MediaSource
    public void dispose() {
        setVideoProcessor(null);
        super.dispose();
    }

    public CapturerObserver getCapturerObserver() {
        return this.capturerObserver;
    }

    public long getNativeVideoTrackSource() {
        return getNativeMediaSource();
    }

    public void setIsScreencast(boolean z2) {
        this.nativeAndroidVideoTrackSource.setIsScreencast(z2);
    }

    public void setVideoProcessor(@Nullable VideoProcessor videoProcessor) {
        synchronized (this.videoProcessorLock) {
            VideoProcessor videoProcessor2 = this.videoProcessor;
            if (videoProcessor2 != null) {
                videoProcessor2.setSink(null);
                if (this.isCapturerRunning) {
                    this.videoProcessor.onCapturerStopped();
                }
            }
            this.videoProcessor = videoProcessor;
            if (videoProcessor != null) {
                videoProcessor.setSink(new i0(this));
                if (this.isCapturerRunning) {
                    videoProcessor.onCapturerStarted(true);
                }
            }
        }
    }

    public void adaptOutputFormat(int i, int i2, int i3, int i4, int i5) {
        adaptOutputFormat(new AspectRatio(i, i2), Integer.valueOf(i * i2), new AspectRatio(i3, i4), Integer.valueOf(i3 * i4), Integer.valueOf(i5));
    }

    public void adaptOutputFormat(AspectRatio aspectRatio, @Nullable Integer num, AspectRatio aspectRatio2, @Nullable Integer num2, @Nullable Integer num3) {
        this.nativeAndroidVideoTrackSource.adaptOutputFormat(aspectRatio, num, aspectRatio2, num2, num3);
    }
}
