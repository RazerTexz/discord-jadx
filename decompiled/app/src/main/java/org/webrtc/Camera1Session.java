package org.webrtc;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.SystemClock;
import b.d.b.a.outline;
import h0.c.CameraSession2;
import h0.c.b;
import h0.c.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraSession;

/* loaded from: classes3.dex */
public class Camera1Session implements CameraSession {
    private static final int NUMBER_OF_CAPTURE_BUFFERS = 3;
    private static final String TAG = "Camera1Session";
    private final Context applicationContext;
    private final Camera camera;
    private final int cameraId;
    private final Handler cameraThreadHandler;
    private final CameraEnumerationAndroid.CaptureFormat captureFormat;
    private final boolean captureToTexture;
    private final long constructionTimeNs;
    private final CameraSession.Events events;
    private boolean firstFrameReported;
    private final Camera.CameraInfo info;
    private SessionState state;
    private final SurfaceTextureHelper surfaceTextureHelper;
    private static final Histogram camera1StartTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera1.StartTimeMs", 1, 10000, 50);
    private static final Histogram camera1StopTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera1.StopTimeMs", 1, 10000, 50);
    private static final Histogram camera1ResolutionHistogram = Histogram.createEnumeration("WebRTC.Android.Camera1.Resolution", CameraEnumerationAndroid.COMMON_RESOLUTIONS.size());

    /* renamed from: org.webrtc.Camera1Session$1, reason: invalid class name */
    public class AnonymousClass1 implements Camera.ErrorCallback {
        public AnonymousClass1() {
        }

        @Override // android.hardware.Camera.ErrorCallback
        public void onError(int i, Camera camera) {
            String strQ = i == 100 ? "Camera server died!" : outline.q("Camera error: ", i);
            Logging.e(Camera1Session.TAG, strQ);
            Camera1Session.access$000(Camera1Session.this);
            if (i == 2) {
                Camera1Session.access$100(Camera1Session.this).onCameraDisconnected(Camera1Session.this);
            } else {
                Camera1Session.access$100(Camera1Session.this).onCameraError(Camera1Session.this, strQ);
            }
        }
    }

    /* renamed from: org.webrtc.Camera1Session$2, reason: invalid class name */
    public class AnonymousClass2 implements Camera.PreviewCallback {
        public AnonymousClass2() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Camera1Session.access$200(Camera1Session.this);
            if (camera != Camera1Session.access$300(Camera1Session.this)) {
                Logging.e(Camera1Session.TAG, "Callback from a different camera. This should never happen.");
                return;
            }
            if (Camera1Session.access$400(Camera1Session.this) != SessionState.RUNNING) {
                Logging.d(Camera1Session.TAG, "Bytebuffer frame captured but camera is no longer running.");
                return;
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
            if (!Camera1Session.access$500(Camera1Session.this)) {
                Camera1Session.access$700().addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - Camera1Session.access$600(Camera1Session.this)));
                Camera1Session.access$502(Camera1Session.this, true);
            }
            VideoFrame videoFrame = new VideoFrame(new NV21Buffer(bArr, Camera1Session.access$800(Camera1Session.this).width, Camera1Session.access$800(Camera1Session.this).height, new b(this, bArr)), Camera1Session.access$900(Camera1Session.this), nanos);
            Camera1Session.access$100(Camera1Session.this).onFrameCaptured(Camera1Session.this, videoFrame);
            videoFrame.release();
        }
    }

    public enum SessionState {
        RUNNING,
        STOPPED
    }

    private Camera1Session(CameraSession.Events events, boolean z2, Context context, SurfaceTextureHelper surfaceTextureHelper, int i, Camera camera, Camera.CameraInfo cameraInfo, CameraEnumerationAndroid.CaptureFormat captureFormat, long j) {
        Logging.d(TAG, "Create new camera1 session on camera " + i);
        this.cameraThreadHandler = new Handler();
        this.events = events;
        this.captureToTexture = z2;
        this.applicationContext = context;
        this.surfaceTextureHelper = surfaceTextureHelper;
        this.cameraId = i;
        this.camera = camera;
        this.info = cameraInfo;
        this.captureFormat = captureFormat;
        this.constructionTimeNs = j;
        surfaceTextureHelper.setTextureSize(captureFormat.width, captureFormat.height);
        startCapturing();
    }

    public static /* synthetic */ void access$000(Camera1Session camera1Session) {
        camera1Session.stopInternal();
    }

    public static /* synthetic */ CameraSession.Events access$100(Camera1Session camera1Session) {
        return camera1Session.events;
    }

    public static /* synthetic */ Handler access$1000(Camera1Session camera1Session) {
        return camera1Session.cameraThreadHandler;
    }

    public static /* synthetic */ void access$200(Camera1Session camera1Session) {
        camera1Session.checkIsOnCameraThread();
    }

    public static /* synthetic */ Camera access$300(Camera1Session camera1Session) {
        return camera1Session.camera;
    }

    public static /* synthetic */ SessionState access$400(Camera1Session camera1Session) {
        return camera1Session.state;
    }

    public static /* synthetic */ boolean access$500(Camera1Session camera1Session) {
        return camera1Session.firstFrameReported;
    }

    public static /* synthetic */ boolean access$502(Camera1Session camera1Session, boolean z2) {
        camera1Session.firstFrameReported = z2;
        return z2;
    }

    public static /* synthetic */ long access$600(Camera1Session camera1Session) {
        return camera1Session.constructionTimeNs;
    }

    public static /* synthetic */ Histogram access$700() {
        return camera1StartTimeMsHistogram;
    }

    public static /* synthetic */ CameraEnumerationAndroid.CaptureFormat access$800(Camera1Session camera1Session) {
        return camera1Session.captureFormat;
    }

    public static /* synthetic */ int access$900(Camera1Session camera1Session) {
        return camera1Session.getFrameOrientation();
    }

    private static void cameraReleaseSafe(Camera camera) {
        try {
            camera.release();
        } catch (RuntimeException unused) {
        }
    }

    private void checkIsOnCameraThread() {
        if (Thread.currentThread() != this.cameraThreadHandler.getLooper().getThread()) {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public static void create(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, boolean z2, Context context, SurfaceTextureHelper surfaceTextureHelper, int i, int i2, int i3, int i4) throws IOException {
        long jNanoTime = System.nanoTime();
        Logging.d(TAG, "Open camera " + i);
        events.onCameraOpening();
        try {
            Camera cameraOpen = Camera.open(i);
            if (cameraOpen == null) {
                createSessionCallback.onFailure(CameraSession.FailureType.ERROR, "android.hardware.Camera.open returned null for camera id = " + i);
                return;
            }
            try {
                cameraOpen.setPreviewTexture(surfaceTextureHelper.getSurfaceTexture());
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                try {
                    Camera.Parameters parameters = cameraOpen.getParameters();
                    CameraEnumerationAndroid.CaptureFormat captureFormatFindClosestCaptureFormat = findClosestCaptureFormat(parameters, i2, i3, i4);
                    updateCameraParameters(cameraOpen, parameters, captureFormatFindClosestCaptureFormat, findClosestPictureSize(parameters, i2, i3), z2);
                    if (!z2) {
                        int iFrameSize = captureFormatFindClosestCaptureFormat.frameSize();
                        for (int i5 = 0; i5 < 3; i5++) {
                            cameraOpen.addCallbackBuffer(ByteBuffer.allocateDirect(iFrameSize).array());
                        }
                    }
                    cameraOpen.setDisplayOrientation(0);
                    createSessionCallback.onDone(new Camera1Session(events, z2, context, surfaceTextureHelper, i, cameraOpen, cameraInfo, captureFormatFindClosestCaptureFormat, jNanoTime));
                } catch (RuntimeException e) {
                    cameraReleaseSafe(cameraOpen);
                    createSessionCallback.onFailure(CameraSession.FailureType.ERROR, e.getMessage());
                }
            } catch (IOException | RuntimeException e2) {
                cameraReleaseSafe(cameraOpen);
                createSessionCallback.onFailure(CameraSession.FailureType.ERROR, e2.getMessage());
            }
        } catch (RuntimeException e3) {
            createSessionCallback.onFailure(CameraSession.FailureType.ERROR, e3.getMessage());
        }
    }

    private static CameraEnumerationAndroid.CaptureFormat findClosestCaptureFormat(Camera.Parameters parameters, int i, int i2, int i3) {
        List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> listConvertFramerates = Camera1Enumerator.convertFramerates(parameters.getSupportedPreviewFpsRange());
        Logging.d(TAG, "Available fps ranges: " + listConvertFramerates);
        CameraEnumerationAndroid.CaptureFormat.FramerateRange closestSupportedFramerateRange = CameraEnumerationAndroid.getClosestSupportedFramerateRange(listConvertFramerates, i3);
        Size closestSupportedSize = CameraEnumerationAndroid.getClosestSupportedSize(Camera1Enumerator.convertSizes(parameters.getSupportedPreviewSizes()), i, i2);
        CameraEnumerationAndroid.reportCameraResolution(camera1ResolutionHistogram, closestSupportedSize);
        return new CameraEnumerationAndroid.CaptureFormat(closestSupportedSize.width, closestSupportedSize.height, closestSupportedFramerateRange);
    }

    private static Size findClosestPictureSize(Camera.Parameters parameters, int i, int i2) {
        return CameraEnumerationAndroid.getClosestSupportedSize(Camera1Enumerator.convertSizes(parameters.getSupportedPictureSizes()), i, i2);
    }

    private int getFrameOrientation() {
        int iB = CameraSession2.b(this.applicationContext);
        Camera.CameraInfo cameraInfo = this.info;
        if (cameraInfo.facing == 0) {
            iB = 360 - iB;
        }
        return (cameraInfo.orientation + iB) % 360;
    }

    private /* synthetic */ void lambda$listenForTextureFrames$0(VideoFrame videoFrame) {
        checkIsOnCameraThread();
        if (this.state != SessionState.RUNNING) {
            Logging.d(TAG, "Texture frame captured but camera is no longer running.");
            return;
        }
        if (!this.firstFrameReported) {
            camera1StartTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.constructionTimeNs));
            this.firstFrameReported = true;
        }
        VideoFrame videoFrame2 = new VideoFrame(CameraSession2.a((TextureBufferImpl) videoFrame.getBuffer(), this.info.facing == 1, 0), getFrameOrientation(), videoFrame.getTimestampNs());
        this.events.onFrameCaptured(this, videoFrame2);
        videoFrame2.release();
    }

    private void listenForBytebufferFrames() {
        this.camera.setPreviewCallbackWithBuffer(new AnonymousClass2());
    }

    private void listenForTextureFrames() {
        this.surfaceTextureHelper.startListening(new c(this));
    }

    private void startCapturing() {
        Logging.d(TAG, "Start capturing");
        checkIsOnCameraThread();
        this.state = SessionState.RUNNING;
        this.camera.setErrorCallback(new AnonymousClass1());
        if (this.captureToTexture) {
            listenForTextureFrames();
        } else {
            listenForBytebufferFrames();
        }
        try {
            this.camera.startPreview();
        } catch (RuntimeException e) {
            stopInternal();
            this.events.onCameraError(this, e.getMessage());
        }
    }

    private void stopInternal() {
        Logging.d(TAG, "Stop internal");
        checkIsOnCameraThread();
        SessionState sessionState = this.state;
        SessionState sessionState2 = SessionState.STOPPED;
        if (sessionState == sessionState2) {
            Logging.d(TAG, "Camera is already stopped");
            return;
        }
        this.state = sessionState2;
        this.surfaceTextureHelper.stopListening();
        this.camera.stopPreview();
        cameraReleaseSafe(this.camera);
        this.events.onCameraClosed(this);
        Logging.d(TAG, "Stop done");
    }

    private static void updateCameraParameters(Camera camera, Camera.Parameters parameters, CameraEnumerationAndroid.CaptureFormat captureFormat, Size size, boolean z2) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        CameraEnumerationAndroid.CaptureFormat.FramerateRange framerateRange = captureFormat.framerate;
        parameters.setPreviewFpsRange(framerateRange.min, framerateRange.max);
        parameters.setPreviewSize(captureFormat.width, captureFormat.height);
        parameters.setPictureSize(size.width, size.height);
        if (!z2) {
            parameters.setPreviewFormat(17);
        }
        if (parameters.isVideoStabilizationSupported()) {
            parameters.setVideoStabilization(true);
        }
        if (supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
        camera.setParameters(parameters);
    }

    public /* synthetic */ void a(VideoFrame videoFrame) {
        lambda$listenForTextureFrames$0(videoFrame);
    }

    @Override // org.webrtc.CameraSession
    public void stop() {
        StringBuilder sbU = outline.U("Stop camera1 session on camera ");
        sbU.append(this.cameraId);
        Logging.d(TAG, sbU.toString());
        checkIsOnCameraThread();
        if (this.state != SessionState.STOPPED) {
            long jNanoTime = System.nanoTime();
            stopInternal();
            camera1StopTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime));
        }
    }
}
