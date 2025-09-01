package org.webrtc;

import android.media.MediaRecorder;

/* loaded from: classes3.dex */
public interface CameraVideoCapturer extends VideoCapturer {

    public interface CameraEventsHandler {
        void onCameraClosed();

        void onCameraDisconnected();

        void onCameraError(String str);

        void onCameraFreezed(String str);

        void onCameraOpening(String str);

        void onFirstFrameAvailable();
    }

    public static class CameraStatistics {
        private static final int CAMERA_FREEZE_REPORT_TIMOUT_MS = 4000;
        private static final int CAMERA_OBSERVER_PERIOD_MS = 2000;
        private static final String TAG = "CameraStatistics";
        private final Runnable cameraObserver;
        private final CameraEventsHandler eventsHandler;
        private int frameCount;
        private int freezePeriodCount;
        private final SurfaceTextureHelper surfaceTextureHelper;

        /* renamed from: org.webrtc.CameraVideoCapturer$CameraStatistics$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Logging.d(CameraStatistics.TAG, "Camera fps: " + Math.round((CameraStatistics.access$000(CameraStatistics.this) * 1000.0f) / 2000.0f) + ".");
                if (CameraStatistics.access$000(CameraStatistics.this) == 0) {
                    CameraStatistics.access$104(CameraStatistics.this);
                    if (CameraStatistics.access$100(CameraStatistics.this) * 2000 >= 4000 && CameraStatistics.access$200(CameraStatistics.this) != null) {
                        Logging.e(CameraStatistics.TAG, "Camera freezed.");
                        if (CameraStatistics.access$300(CameraStatistics.this).isTextureInUse()) {
                            CameraStatistics.access$200(CameraStatistics.this).onCameraFreezed("Camera failure. Client must return video buffers.");
                            return;
                        } else {
                            CameraStatistics.access$200(CameraStatistics.this).onCameraFreezed("Camera failure.");
                            return;
                        }
                    }
                } else {
                    CameraStatistics.access$102(CameraStatistics.this, 0);
                }
                CameraStatistics.access$002(CameraStatistics.this, 0);
                CameraStatistics.access$300(CameraStatistics.this).getHandler().postDelayed(this, 2000L);
            }
        }

        public CameraStatistics(SurfaceTextureHelper surfaceTextureHelper, CameraEventsHandler cameraEventsHandler) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            this.cameraObserver = anonymousClass1;
            if (surfaceTextureHelper == null) {
                throw new IllegalArgumentException("SurfaceTextureHelper is null");
            }
            this.surfaceTextureHelper = surfaceTextureHelper;
            this.eventsHandler = cameraEventsHandler;
            this.frameCount = 0;
            this.freezePeriodCount = 0;
            surfaceTextureHelper.getHandler().postDelayed(anonymousClass1, 2000L);
        }

        public static /* synthetic */ int access$000(CameraStatistics cameraStatistics) {
            return cameraStatistics.frameCount;
        }

        public static /* synthetic */ int access$002(CameraStatistics cameraStatistics, int i) {
            cameraStatistics.frameCount = i;
            return i;
        }

        public static /* synthetic */ int access$100(CameraStatistics cameraStatistics) {
            return cameraStatistics.freezePeriodCount;
        }

        public static /* synthetic */ int access$102(CameraStatistics cameraStatistics, int i) {
            cameraStatistics.freezePeriodCount = i;
            return i;
        }

        public static /* synthetic */ int access$104(CameraStatistics cameraStatistics) {
            int i = cameraStatistics.freezePeriodCount + 1;
            cameraStatistics.freezePeriodCount = i;
            return i;
        }

        public static /* synthetic */ CameraEventsHandler access$200(CameraStatistics cameraStatistics) {
            return cameraStatistics.eventsHandler;
        }

        public static /* synthetic */ SurfaceTextureHelper access$300(CameraStatistics cameraStatistics) {
            return cameraStatistics.surfaceTextureHelper;
        }

        private void checkThread() {
            if (Thread.currentThread() != this.surfaceTextureHelper.getHandler().getLooper().getThread()) {
                throw new IllegalStateException("Wrong thread");
            }
        }

        public void addFrame() {
            checkThread();
            this.frameCount++;
        }

        public void release() {
            this.surfaceTextureHelper.getHandler().removeCallbacks(this.cameraObserver);
        }
    }

    public interface CameraSwitchHandler {
        void onCameraSwitchDone(boolean z2);

        void onCameraSwitchError(String str);
    }

    @Deprecated
    public interface MediaRecorderHandler {
        void onMediaRecorderError(String str);

        void onMediaRecorderSuccess();
    }

    @Deprecated
    void addMediaRecorderToCamera(MediaRecorder mediaRecorder, MediaRecorderHandler mediaRecorderHandler);

    @Deprecated
    void removeMediaRecorderFromCamera(MediaRecorderHandler mediaRecorderHandler);

    void switchCamera(CameraSwitchHandler cameraSwitchHandler);

    void switchCamera(CameraSwitchHandler cameraSwitchHandler, String str);
}
