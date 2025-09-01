package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.util.Range;
import android.view.Surface;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import h0.c.CameraSession2;
import h0.c.d;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraSession;

@TargetApi(21)
/* loaded from: classes3.dex */
public class Camera2Session implements CameraSession {
    private static final String TAG = "Camera2Session";
    private final Context applicationContext;
    private final CameraSession.CreateSessionCallback callback;
    private CameraCharacteristics cameraCharacteristics;

    @Nullable
    private CameraDevice cameraDevice;
    private final String cameraId;
    private final CameraManager cameraManager;
    private int cameraOrientation;
    private final Handler cameraThreadHandler;
    private CameraEnumerationAndroid.CaptureFormat captureFormat;

    @Nullable
    private CameraCaptureSession captureSession;
    private final long constructionTimeNs;
    private final CameraSession.Events events;
    private boolean firstFrameReported;
    private int fpsUnitFactor;
    private final int framerate;
    private final int height;
    private boolean isCameraFrontFacing;
    private SessionState state = SessionState.RUNNING;

    @Nullable
    private Surface surface;
    private final SurfaceTextureHelper surfaceTextureHelper;
    private final int width;
    private static final Histogram camera2StartTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera2.StartTimeMs", 1, 10000, 50);
    private static final Histogram camera2StopTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera2.StopTimeMs", 1, 10000, 50);
    private static final Histogram camera2ResolutionHistogram = Histogram.createEnumeration("WebRTC.Android.Camera2.Resolution", CameraEnumerationAndroid.COMMON_RESOLUTIONS.size());

    public static class CameraCaptureCallback extends CameraCaptureSession.CaptureCallback {
        private CameraCaptureCallback() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            Logging.d(Camera2Session.TAG, "Capture failed: " + captureFailure);
        }

        public /* synthetic */ CameraCaptureCallback(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class CameraStateCallback extends CameraDevice.StateCallback {
        private CameraStateCallback() {
        }

        private String getErrorDescription(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? outline.q("Unknown camera error: ", i) : "Camera service has encountered a fatal error." : "Camera device has encountered a fatal error." : "Camera device could not be opened due to a device policy." : "Camera device could not be opened because there are too many other open camera devices." : "Camera device is in use already.";
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            Camera2Session.access$000(Camera2Session.this);
            Logging.d(Camera2Session.TAG, "Camera device closed.");
            Camera2Session.access$500(Camera2Session.this).onCameraClosed(Camera2Session.this);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            Camera2Session.access$000(Camera2Session.this);
            boolean z2 = Camera2Session.access$100(Camera2Session.this) == null && Camera2Session.access$200(Camera2Session.this) != SessionState.STOPPED;
            Camera2Session.access$202(Camera2Session.this, SessionState.STOPPED);
            Camera2Session.access$300(Camera2Session.this);
            if (z2) {
                Camera2Session.access$400(Camera2Session.this).onFailure(CameraSession.FailureType.DISCONNECTED, "Camera disconnected / evicted.");
            } else {
                Camera2Session.access$500(Camera2Session.this).onCameraDisconnected(Camera2Session.this);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            Camera2Session.access$000(Camera2Session.this);
            Camera2Session.access$600(Camera2Session.this, getErrorDescription(i));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) throws CameraAccessException {
            Camera2Session.access$000(Camera2Session.this);
            Logging.d(Camera2Session.TAG, "Camera opened.");
            Camera2Session.access$702(Camera2Session.this, cameraDevice);
            Camera2Session.access$900(Camera2Session.this).setTextureSize(Camera2Session.access$800(Camera2Session.this).width, Camera2Session.access$800(Camera2Session.this).height);
            Camera2Session.access$1002(Camera2Session.this, new Surface(Camera2Session.access$900(Camera2Session.this).getSurfaceTexture()));
            try {
                cameraDevice.createCaptureSession(Arrays.asList(Camera2Session.access$1000(Camera2Session.this)), new CaptureSessionCallback(Camera2Session.this, null), Camera2Session.access$1200(Camera2Session.this));
            } catch (CameraAccessException e) {
                Camera2Session.access$600(Camera2Session.this, "Failed to create capture session. " + e);
            }
        }

        public /* synthetic */ CameraStateCallback(Camera2Session camera2Session, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class CaptureSessionCallback extends CameraCaptureSession.StateCallback {
        private CaptureSessionCallback() {
        }

        private void chooseFocusMode(CaptureRequest.Builder builder) {
            for (int i : (int[]) Camera2Session.access$1500(Camera2Session.this).get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES)) {
                if (i == 3) {
                    builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
                    Logging.d(Camera2Session.TAG, "Using continuous video auto-focus.");
                    return;
                }
            }
            Logging.d(Camera2Session.TAG, "Auto-focus is not available.");
        }

        private void chooseStabilizationMode(CaptureRequest.Builder builder) {
            int[] iArr = (int[]) Camera2Session.access$1500(Camera2Session.this).get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
            if (iArr != null) {
                for (int i : iArr) {
                    if (i == 1) {
                        builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 1);
                        builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
                        Logging.d(Camera2Session.TAG, "Using optical stabilization.");
                        return;
                    }
                }
            }
            for (int i2 : (int[]) Camera2Session.access$1500(Camera2Session.this).get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) {
                if (i2 == 1) {
                    builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
                    builder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 0);
                    Logging.d(Camera2Session.TAG, "Using video stabilization.");
                    return;
                }
            }
            Logging.d(Camera2Session.TAG, "Stabilization not available.");
        }

        private /* synthetic */ void lambda$onConfigured$0(VideoFrame videoFrame) {
            Camera2Session.access$000(Camera2Session.this);
            if (Camera2Session.access$200(Camera2Session.this) != SessionState.RUNNING) {
                Logging.d(Camera2Session.TAG, "Texture frame captured but camera is no longer running.");
                return;
            }
            if (!Camera2Session.access$1600(Camera2Session.this)) {
                Camera2Session.access$1602(Camera2Session.this, true);
                Camera2Session.access$1800().addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - Camera2Session.access$1700(Camera2Session.this)));
            }
            VideoFrame videoFrame2 = new VideoFrame(CameraSession2.a((TextureBufferImpl) videoFrame.getBuffer(), Camera2Session.access$1900(Camera2Session.this), -Camera2Session.access$2000(Camera2Session.this)), Camera2Session.access$2100(Camera2Session.this), videoFrame.getTimestampNs());
            Camera2Session.access$500(Camera2Session.this).onFrameCaptured(Camera2Session.this, videoFrame2);
            videoFrame2.release();
        }

        public /* synthetic */ void a(VideoFrame videoFrame) {
            lambda$onConfigured$0(videoFrame);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Camera2Session.access$000(Camera2Session.this);
            cameraCaptureSession.close();
            Camera2Session.access$600(Camera2Session.this, "Failed to configure capture session.");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) throws CameraAccessException {
            Camera2Session.access$000(Camera2Session.this);
            Logging.d(Camera2Session.TAG, "Camera capture session configured.");
            Camera2Session.access$102(Camera2Session.this, cameraCaptureSession);
            try {
                CaptureRequest.Builder builderCreateCaptureRequest = Camera2Session.access$700(Camera2Session.this).createCaptureRequest(3);
                builderCreateCaptureRequest.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range(Integer.valueOf(Camera2Session.access$800(Camera2Session.this).framerate.min / Camera2Session.access$1300(Camera2Session.this)), Integer.valueOf(Camera2Session.access$800(Camera2Session.this).framerate.max / Camera2Session.access$1300(Camera2Session.this))));
                builderCreateCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 1);
                builderCreateCaptureRequest.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
                chooseStabilizationMode(builderCreateCaptureRequest);
                chooseFocusMode(builderCreateCaptureRequest);
                builderCreateCaptureRequest.addTarget(Camera2Session.access$1000(Camera2Session.this));
                cameraCaptureSession.setRepeatingRequest(builderCreateCaptureRequest.build(), new CameraCaptureCallback(null), Camera2Session.access$1200(Camera2Session.this));
                Camera2Session.access$900(Camera2Session.this).startListening(new d(this));
                Logging.d(Camera2Session.TAG, "Camera device successfully started.");
                Camera2Session.access$400(Camera2Session.this).onDone(Camera2Session.this);
            } catch (CameraAccessException e) {
                Camera2Session.access$600(Camera2Session.this, "Failed to start capture request. " + e);
            }
        }

        public /* synthetic */ CaptureSessionCallback(Camera2Session camera2Session, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public enum SessionState {
        RUNNING,
        STOPPED
    }

    private Camera2Session(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, Context context, CameraManager cameraManager, SurfaceTextureHelper surfaceTextureHelper, String str, int i, int i2, int i3) throws CameraAccessException {
        Logging.d(TAG, "Create new camera2 session on camera " + str);
        this.constructionTimeNs = System.nanoTime();
        this.cameraThreadHandler = new Handler();
        this.callback = createSessionCallback;
        this.events = events;
        this.applicationContext = context;
        this.cameraManager = cameraManager;
        this.surfaceTextureHelper = surfaceTextureHelper;
        this.cameraId = str;
        this.width = i;
        this.height = i2;
        this.framerate = i3;
        start();
    }

    public static /* synthetic */ void access$000(Camera2Session camera2Session) {
        camera2Session.checkIsOnCameraThread();
    }

    public static /* synthetic */ CameraCaptureSession access$100(Camera2Session camera2Session) {
        return camera2Session.captureSession;
    }

    public static /* synthetic */ Surface access$1000(Camera2Session camera2Session) {
        return camera2Session.surface;
    }

    public static /* synthetic */ Surface access$1002(Camera2Session camera2Session, Surface surface) {
        camera2Session.surface = surface;
        return surface;
    }

    public static /* synthetic */ CameraCaptureSession access$102(Camera2Session camera2Session, CameraCaptureSession cameraCaptureSession) {
        camera2Session.captureSession = cameraCaptureSession;
        return cameraCaptureSession;
    }

    public static /* synthetic */ Handler access$1200(Camera2Session camera2Session) {
        return camera2Session.cameraThreadHandler;
    }

    public static /* synthetic */ int access$1300(Camera2Session camera2Session) {
        return camera2Session.fpsUnitFactor;
    }

    public static /* synthetic */ CameraCharacteristics access$1500(Camera2Session camera2Session) {
        return camera2Session.cameraCharacteristics;
    }

    public static /* synthetic */ boolean access$1600(Camera2Session camera2Session) {
        return camera2Session.firstFrameReported;
    }

    public static /* synthetic */ boolean access$1602(Camera2Session camera2Session, boolean z2) {
        camera2Session.firstFrameReported = z2;
        return z2;
    }

    public static /* synthetic */ long access$1700(Camera2Session camera2Session) {
        return camera2Session.constructionTimeNs;
    }

    public static /* synthetic */ Histogram access$1800() {
        return camera2StartTimeMsHistogram;
    }

    public static /* synthetic */ boolean access$1900(Camera2Session camera2Session) {
        return camera2Session.isCameraFrontFacing;
    }

    public static /* synthetic */ SessionState access$200(Camera2Session camera2Session) {
        return camera2Session.state;
    }

    public static /* synthetic */ int access$2000(Camera2Session camera2Session) {
        return camera2Session.cameraOrientation;
    }

    public static /* synthetic */ SessionState access$202(Camera2Session camera2Session, SessionState sessionState) {
        camera2Session.state = sessionState;
        return sessionState;
    }

    public static /* synthetic */ int access$2100(Camera2Session camera2Session) {
        return camera2Session.getFrameOrientation();
    }

    public static /* synthetic */ void access$300(Camera2Session camera2Session) {
        camera2Session.stopInternal();
    }

    public static /* synthetic */ CameraSession.CreateSessionCallback access$400(Camera2Session camera2Session) {
        return camera2Session.callback;
    }

    public static /* synthetic */ CameraSession.Events access$500(Camera2Session camera2Session) {
        return camera2Session.events;
    }

    public static /* synthetic */ void access$600(Camera2Session camera2Session, String str) {
        camera2Session.reportError(str);
    }

    public static /* synthetic */ CameraDevice access$700(Camera2Session camera2Session) {
        return camera2Session.cameraDevice;
    }

    public static /* synthetic */ CameraDevice access$702(Camera2Session camera2Session, CameraDevice cameraDevice) {
        camera2Session.cameraDevice = cameraDevice;
        return cameraDevice;
    }

    public static /* synthetic */ CameraEnumerationAndroid.CaptureFormat access$800(Camera2Session camera2Session) {
        return camera2Session.captureFormat;
    }

    public static /* synthetic */ SurfaceTextureHelper access$900(Camera2Session camera2Session) {
        return camera2Session.surfaceTextureHelper;
    }

    private void checkIsOnCameraThread() {
        if (Thread.currentThread() != this.cameraThreadHandler.getLooper().getThread()) {
            throw new IllegalStateException("Wrong thread");
        }
    }

    public static void create(CameraSession.CreateSessionCallback createSessionCallback, CameraSession.Events events, Context context, CameraManager cameraManager, SurfaceTextureHelper surfaceTextureHelper, String str, int i, int i2, int i3) {
        new Camera2Session(createSessionCallback, events, context, cameraManager, surfaceTextureHelper, str, i, i2, i3);
    }

    private void findCaptureFormat() {
        checkIsOnCameraThread();
        Range[] rangeArr = (Range[]) this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        int fpsUnitFactor = Camera2Enumerator.getFpsUnitFactor(rangeArr);
        this.fpsUnitFactor = fpsUnitFactor;
        List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> listConvertFramerates = Camera2Enumerator.convertFramerates(rangeArr, fpsUnitFactor);
        List<Size> supportedSizes = Camera2Enumerator.getSupportedSizes(this.cameraCharacteristics);
        Logging.d(TAG, "Available preview sizes: " + supportedSizes);
        Logging.d(TAG, "Available fps ranges: " + listConvertFramerates);
        if (listConvertFramerates.isEmpty() || supportedSizes.isEmpty()) {
            reportError("No supported capture formats.");
            return;
        }
        CameraEnumerationAndroid.CaptureFormat.FramerateRange closestSupportedFramerateRange = CameraEnumerationAndroid.getClosestSupportedFramerateRange(listConvertFramerates, this.framerate);
        Size closestSupportedSize = CameraEnumerationAndroid.getClosestSupportedSize(supportedSizes, this.width, this.height);
        CameraEnumerationAndroid.reportCameraResolution(camera2ResolutionHistogram, closestSupportedSize);
        this.captureFormat = new CameraEnumerationAndroid.CaptureFormat(closestSupportedSize.width, closestSupportedSize.height, closestSupportedFramerateRange);
        StringBuilder sbU = outline.U("Using capture format: ");
        sbU.append(this.captureFormat);
        Logging.d(TAG, sbU.toString());
    }

    private int getFrameOrientation() {
        int iB = CameraSession2.b(this.applicationContext);
        if (!this.isCameraFrontFacing) {
            iB = 360 - iB;
        }
        return (this.cameraOrientation + iB) % 360;
    }

    private void openCamera() throws CameraAccessException {
        checkIsOnCameraThread();
        StringBuilder sbU = outline.U("Opening camera ");
        sbU.append(this.cameraId);
        Logging.d(TAG, sbU.toString());
        this.events.onCameraOpening();
        try {
            this.cameraManager.openCamera(this.cameraId, new CameraStateCallback(this, null), this.cameraThreadHandler);
        } catch (CameraAccessException e) {
            reportError("Failed to open camera: " + e);
        }
    }

    private void reportError(String str) {
        checkIsOnCameraThread();
        Logging.e(TAG, "Error: " + str);
        boolean z2 = this.captureSession == null && this.state != SessionState.STOPPED;
        this.state = SessionState.STOPPED;
        stopInternal();
        if (z2) {
            this.callback.onFailure(CameraSession.FailureType.ERROR, str);
        } else {
            this.events.onCameraError(this, str);
        }
    }

    private void start() throws CameraAccessException {
        checkIsOnCameraThread();
        Logging.d(TAG, "start");
        try {
            CameraCharacteristics cameraCharacteristics = this.cameraManager.getCameraCharacteristics(this.cameraId);
            this.cameraCharacteristics = cameraCharacteristics;
            this.cameraOrientation = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
            this.isCameraFrontFacing = ((Integer) this.cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
            findCaptureFormat();
            openCamera();
        } catch (CameraAccessException e) {
            StringBuilder sbU = outline.U("getCameraCharacteristics(): ");
            sbU.append(e.getMessage());
            reportError(sbU.toString());
        }
    }

    private void stopInternal() {
        Logging.d(TAG, "Stop internal");
        checkIsOnCameraThread();
        this.surfaceTextureHelper.stopListening();
        CameraCaptureSession cameraCaptureSession = this.captureSession;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.captureSession = null;
        }
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
            this.surface = null;
        }
        CameraDevice cameraDevice = this.cameraDevice;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.cameraDevice = null;
        }
        Logging.d(TAG, "Stop done");
    }

    @Override // org.webrtc.CameraSession
    public void stop() {
        StringBuilder sbU = outline.U("Stop camera2 session on camera ");
        sbU.append(this.cameraId);
        Logging.d(TAG, sbU.toString());
        checkIsOnCameraThread();
        SessionState sessionState = this.state;
        SessionState sessionState2 = SessionState.STOPPED;
        if (sessionState != sessionState2) {
            long jNanoTime = System.nanoTime();
            this.state = sessionState2;
            stopInternal();
            camera2StopTimeMsHistogram.addSample((int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime));
        }
    }
}
