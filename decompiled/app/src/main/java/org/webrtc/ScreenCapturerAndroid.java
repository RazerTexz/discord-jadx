package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.view.Surface;
import androidx.annotation.Nullable;

@TargetApi(21)
/* loaded from: classes3.dex */
public class ScreenCapturerAndroid implements VideoCapturer, VideoSink {
    private static final int DISPLAY_FLAGS = 3;
    private static final int VIRTUAL_DISPLAY_DPI = 400;

    @Nullable
    private CapturerObserver capturerObserver;
    private int height;
    private boolean isDisposed;

    @Nullable
    public MediaProjection mediaProjection;
    private final MediaProjection.Callback mediaProjectionCallback;

    @Nullable
    private MediaProjectionManager mediaProjectionManager;
    private final Intent mediaProjectionPermissionResultData;
    private long numCapturedFrames;

    @Nullable
    private SurfaceTextureHelper surfaceTextureHelper;

    @Nullable
    private VirtualDisplay virtualDisplay;
    private int width;

    /* renamed from: org.webrtc.ScreenCapturerAndroid$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScreenCapturerAndroid.access$000(ScreenCapturerAndroid.this).stopListening();
            ScreenCapturerAndroid.access$100(ScreenCapturerAndroid.this).onCapturerStopped();
            if (ScreenCapturerAndroid.access$200(ScreenCapturerAndroid.this) != null) {
                ScreenCapturerAndroid.access$200(ScreenCapturerAndroid.this).release();
                ScreenCapturerAndroid.access$202(ScreenCapturerAndroid.this, null);
            }
            ScreenCapturerAndroid screenCapturerAndroid = ScreenCapturerAndroid.this;
            MediaProjection mediaProjection = screenCapturerAndroid.mediaProjection;
            if (mediaProjection != null) {
                mediaProjection.unregisterCallback(ScreenCapturerAndroid.access$300(screenCapturerAndroid));
                ScreenCapturerAndroid.this.mediaProjection.stop();
                ScreenCapturerAndroid.this.mediaProjection = null;
            }
        }
    }

    /* renamed from: org.webrtc.ScreenCapturerAndroid$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScreenCapturerAndroid.access$200(ScreenCapturerAndroid.this).release();
            ScreenCapturerAndroid.this.createVirtualDisplay();
        }
    }

    public ScreenCapturerAndroid(Intent intent, MediaProjection.Callback callback) {
        this.mediaProjectionPermissionResultData = intent;
        this.mediaProjectionCallback = callback;
    }

    public static /* synthetic */ SurfaceTextureHelper access$000(ScreenCapturerAndroid screenCapturerAndroid) {
        return screenCapturerAndroid.surfaceTextureHelper;
    }

    public static /* synthetic */ CapturerObserver access$100(ScreenCapturerAndroid screenCapturerAndroid) {
        return screenCapturerAndroid.capturerObserver;
    }

    public static /* synthetic */ VirtualDisplay access$200(ScreenCapturerAndroid screenCapturerAndroid) {
        return screenCapturerAndroid.virtualDisplay;
    }

    public static /* synthetic */ VirtualDisplay access$202(ScreenCapturerAndroid screenCapturerAndroid, VirtualDisplay virtualDisplay) {
        screenCapturerAndroid.virtualDisplay = virtualDisplay;
        return virtualDisplay;
    }

    public static /* synthetic */ MediaProjection.Callback access$300(ScreenCapturerAndroid screenCapturerAndroid) {
        return screenCapturerAndroid.mediaProjectionCallback;
    }

    private void checkNotDisposed() {
        if (this.isDisposed) {
            throw new RuntimeException("capturer is disposed.");
        }
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void changeCaptureFormat(int i, int i2, int i3) {
        checkNotDisposed();
        this.width = i;
        this.height = i2;
        if (this.virtualDisplay == null) {
            return;
        }
        ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new AnonymousClass2());
    }

    public void createVirtualDisplay() {
        this.surfaceTextureHelper.setTextureSize(this.width, this.height);
        this.virtualDisplay = this.mediaProjection.createVirtualDisplay("WebRTC_ScreenCapture", this.width, this.height, VIRTUAL_DISPLAY_DPI, 3, new Surface(this.surfaceTextureHelper.getSurfaceTexture()), null, null);
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void dispose() {
        this.isDisposed = true;
    }

    @Nullable
    public MediaProjection getMediaProjection() {
        return this.mediaProjection;
    }

    public long getNumCapturedFrames() {
        return this.numCapturedFrames;
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        checkNotDisposed();
        if (capturerObserver == null) {
            throw new RuntimeException("capturerObserver not set.");
        }
        this.capturerObserver = capturerObserver;
        if (surfaceTextureHelper == null) {
            throw new RuntimeException("surfaceTextureHelper not set.");
        }
        this.surfaceTextureHelper = surfaceTextureHelper;
        this.mediaProjectionManager = (MediaProjectionManager) context.getSystemService("media_projection");
    }

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        return true;
    }

    public void onFrame(VideoFrame videoFrame) {
        this.numCapturedFrames++;
        this.capturerObserver.onFrameCaptured(videoFrame);
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void startCapture(int i, int i2, int i3) {
        checkNotDisposed();
        this.width = i;
        this.height = i2;
        MediaProjection mediaProjection = this.mediaProjectionManager.getMediaProjection(-1, this.mediaProjectionPermissionResultData);
        this.mediaProjection = mediaProjection;
        mediaProjection.registerCallback(this.mediaProjectionCallback, this.surfaceTextureHelper.getHandler());
        createVirtualDisplay();
        this.capturerObserver.onCapturerStarted(true);
        this.surfaceTextureHelper.startListening(this);
    }

    @Override // org.webrtc.VideoCapturer
    public synchronized void stopCapture() {
        checkNotDisposed();
        ThreadUtils.invokeAtFrontUninterruptibly(this.surfaceTextureHelper.getHandler(), new AnonymousClass1());
    }
}
