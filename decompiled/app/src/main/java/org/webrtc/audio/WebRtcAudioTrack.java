package org.webrtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import java.nio.ByteBuffer;
import org.webrtc.CalledByNative;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;
import org.webrtc.audio.JavaAudioDeviceModule;

/* loaded from: classes3.dex */
public class WebRtcAudioTrack {
    private static final int AUDIO_TRACK_START = 0;
    private static final int AUDIO_TRACK_STOP = 1;
    private static final long AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final int DEFAULT_USAGE = getDefaultUsageAttribute();
    private static final String TAG = "WebRtcAudioTrackExternal";

    @Nullable
    private final AudioAttributes audioAttributes;
    private final AudioManager audioManager;

    @Nullable
    private AudioTrackThread audioThread;

    @Nullable
    private AudioTrack audioTrack;
    private ByteBuffer byteBuffer;
    private final Context context;
    private byte[] emptyBytes;

    @Nullable
    private final JavaAudioDeviceModule.AudioTrackErrorCallback errorCallback;
    private int initialBufferSizeInFrames;
    private long nativeAudioTrack;
    private volatile boolean speakerMute;

    @Nullable
    private final JavaAudioDeviceModule.AudioTrackStateCallback stateCallback;
    private final ThreadUtils.ThreadChecker threadChecker;
    private boolean useLowLatency;
    private final VolumeLogger volumeLogger;

    public class AudioTrackThread extends Thread {
        private LowLatencyAudioBufferManager bufferManager;
        private volatile boolean keepAlive;

        public AudioTrackThread(String str) {
            super(str);
            this.keepAlive = true;
            this.bufferManager = new LowLatencyAudioBufferManager();
        }

        private int writeBytes(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
            return audioTrack.write(byteBuffer, i, 0);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(-19);
            Logging.d(WebRtcAudioTrack.TAG, "AudioTrackThread" + WebRtcAudioUtils.getThreadInfo());
            WebRtcAudioTrack.access$100(WebRtcAudioTrack.access$000(WebRtcAudioTrack.this).getPlayState() == 3);
            WebRtcAudioTrack.access$200(WebRtcAudioTrack.this, 0);
            int iCapacity = WebRtcAudioTrack.access$300(WebRtcAudioTrack.this).capacity();
            while (this.keepAlive) {
                WebRtcAudioTrack.access$500(WebRtcAudioTrack.access$400(WebRtcAudioTrack.this), iCapacity);
                WebRtcAudioTrack.access$100(iCapacity <= WebRtcAudioTrack.access$300(WebRtcAudioTrack.this).remaining());
                if (WebRtcAudioTrack.access$600(WebRtcAudioTrack.this)) {
                    WebRtcAudioTrack.access$300(WebRtcAudioTrack.this).clear();
                    WebRtcAudioTrack.access$300(WebRtcAudioTrack.this).put(WebRtcAudioTrack.access$700(WebRtcAudioTrack.this));
                    WebRtcAudioTrack.access$300(WebRtcAudioTrack.this).position(0);
                }
                int iWriteBytes = writeBytes(WebRtcAudioTrack.access$000(WebRtcAudioTrack.this), WebRtcAudioTrack.access$300(WebRtcAudioTrack.this), iCapacity);
                if (iWriteBytes != iCapacity) {
                    Logging.e(WebRtcAudioTrack.TAG, "AudioTrack.write played invalid number of bytes: " + iWriteBytes);
                    if (iWriteBytes < 0) {
                        this.keepAlive = false;
                        WebRtcAudioTrack.access$800(WebRtcAudioTrack.this, "AudioTrack.write failed: " + iWriteBytes);
                    }
                }
                if (WebRtcAudioTrack.access$900(WebRtcAudioTrack.this)) {
                    this.bufferManager.maybeAdjustBufferSize(WebRtcAudioTrack.access$000(WebRtcAudioTrack.this));
                }
                WebRtcAudioTrack.access$300(WebRtcAudioTrack.this).rewind();
            }
        }

        public void stopThread() {
            Logging.d(WebRtcAudioTrack.TAG, "stopThread");
            this.keepAlive = false;
        }
    }

    @CalledByNative
    public WebRtcAudioTrack(Context context, AudioManager audioManager) {
        this(context, audioManager, null, null, null, false);
    }

    @CalledByNative
    private int GetPlayoutUnderrunCount() {
        if (Build.VERSION.SDK_INT < 24) {
            return -2;
        }
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            return audioTrack.getUnderrunCount();
        }
        return -1;
    }

    public static /* synthetic */ AudioTrack access$000(WebRtcAudioTrack webRtcAudioTrack) {
        return webRtcAudioTrack.audioTrack;
    }

    public static /* synthetic */ void access$100(boolean z2) {
        assertTrue(z2);
    }

    public static /* synthetic */ void access$200(WebRtcAudioTrack webRtcAudioTrack, int i) {
        webRtcAudioTrack.doAudioTrackStateCallback(i);
    }

    public static /* synthetic */ ByteBuffer access$300(WebRtcAudioTrack webRtcAudioTrack) {
        return webRtcAudioTrack.byteBuffer;
    }

    public static /* synthetic */ long access$400(WebRtcAudioTrack webRtcAudioTrack) {
        return webRtcAudioTrack.nativeAudioTrack;
    }

    public static /* synthetic */ void access$500(long j, int i) {
        nativeGetPlayoutData(j, i);
    }

    public static /* synthetic */ boolean access$600(WebRtcAudioTrack webRtcAudioTrack) {
        return webRtcAudioTrack.speakerMute;
    }

    public static /* synthetic */ byte[] access$700(WebRtcAudioTrack webRtcAudioTrack) {
        return webRtcAudioTrack.emptyBytes;
    }

    public static /* synthetic */ void access$800(WebRtcAudioTrack webRtcAudioTrack, String str) {
        webRtcAudioTrack.reportWebRtcAudioTrackError(str);
    }

    public static /* synthetic */ boolean access$900(WebRtcAudioTrack webRtcAudioTrack) {
        return webRtcAudioTrack.useLowLatency;
    }

    @TargetApi(29)
    private static AudioAttributes.Builder applyAttributesOnQOrHigher(AudioAttributes.Builder builder, AudioAttributes audioAttributes) {
        return builder.setAllowedCapturePolicy(audioAttributes.getAllowedCapturePolicy());
    }

    private static void assertTrue(boolean z2) {
        if (!z2) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private int channelCountToConfiguration(int i) {
        return i == 1 ? 4 : 12;
    }

    @TargetApi(21)
    private static AudioTrack createAudioTrackOnLollipopOrHigher(int i, int i2, int i3, @Nullable AudioAttributes audioAttributes) {
        Logging.d(TAG, "createAudioTrackOnLollipopOrHigher");
        logNativeOutputSampleRate(i);
        return new AudioTrack(getAudioAttributes(audioAttributes), new AudioFormat.Builder().setEncoding(2).setSampleRate(i).setChannelMask(i2).build(), i3, 1, 0);
    }

    private static AudioTrack createAudioTrackOnLowerThanLollipop(int i, int i2, int i3) {
        return new AudioTrack(0, i, i2, 2, i3, 1);
    }

    @TargetApi(26)
    private static AudioTrack createAudioTrackOnOreoOrHigher(int i, int i2, int i3, @Nullable AudioAttributes audioAttributes) {
        Logging.d(TAG, "createAudioTrackOnOreoOrHigher");
        logNativeOutputSampleRate(i);
        return new AudioTrack.Builder().setAudioAttributes(getAudioAttributes(audioAttributes)).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(i).setChannelMask(i2).build()).setBufferSizeInBytes(i3).setPerformanceMode(1).setTransferMode(1).setSessionId(0).build();
    }

    private void doAudioTrackStateCallback(int i) {
        Logging.d(TAG, "doAudioTrackStateCallback: " + i);
        JavaAudioDeviceModule.AudioTrackStateCallback audioTrackStateCallback = this.stateCallback;
        if (audioTrackStateCallback != null) {
            if (i == 0) {
                audioTrackStateCallback.onWebRtcAudioTrackStart();
            } else if (i == 1) {
                audioTrackStateCallback.onWebRtcAudioTrackStop();
            } else {
                Logging.e(TAG, "Invalid audio state");
            }
        }
    }

    private static AudioAttributes getAudioAttributes(@Nullable AudioAttributes audioAttributes) {
        AudioAttributes.Builder contentType = new AudioAttributes.Builder().setUsage(DEFAULT_USAGE).setContentType(1);
        if (audioAttributes != null) {
            if (audioAttributes.getUsage() != 0) {
                contentType.setUsage(audioAttributes.getUsage());
            }
            if (audioAttributes.getContentType() != 0) {
                contentType.setContentType(audioAttributes.getContentType());
            }
            contentType.setFlags(audioAttributes.getFlags());
            if (Build.VERSION.SDK_INT >= 29) {
                contentType = applyAttributesOnQOrHigher(contentType, audioAttributes);
            }
        }
        return contentType.build();
    }

    @CalledByNative
    private int getBufferSizeInFrames() {
        if (Build.VERSION.SDK_INT >= 23) {
            return this.audioTrack.getBufferSizeInFrames();
        }
        return -1;
    }

    private static int getDefaultUsageAttribute() {
        return 2;
    }

    @CalledByNative
    private int getInitialBufferSizeInFrames() {
        return this.initialBufferSizeInFrames;
    }

    @CalledByNative
    private int getStreamMaxVolume() {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "getStreamMaxVolume");
        return this.audioManager.getStreamMaxVolume(0);
    }

    @CalledByNative
    private int getStreamVolume() {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "getStreamVolume");
        return this.audioManager.getStreamVolume(0);
    }

    @CalledByNative
    private int initPlayout(int i, int i2, double d) {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "initPlayout(sampleRate=" + i + ", channels=" + i2 + ", bufferSizeFactor=" + d + ")");
        this.byteBuffer = ByteBuffer.allocateDirect((i / 100) * i2 * 2);
        StringBuilder sbU = outline.U("byteBuffer.capacity: ");
        sbU.append(this.byteBuffer.capacity());
        Logging.d(TAG, sbU.toString());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.nativeAudioTrack, this.byteBuffer);
        int iChannelCountToConfiguration = channelCountToConfiguration(i2);
        int minBufferSize = (int) (((double) AudioTrack.getMinBufferSize(i, iChannelCountToConfiguration, 2)) * d);
        Logging.d(TAG, "minBufferSizeInBytes: " + minBufferSize);
        if (minBufferSize < this.byteBuffer.capacity()) {
            reportWebRtcAudioTrackInitError("AudioTrack.getMinBufferSize returns an invalid value.");
            return -1;
        }
        if (d > 1.0d) {
            this.useLowLatency = false;
        }
        if (this.audioTrack != null) {
            reportWebRtcAudioTrackInitError("Conflict with existing AudioTrack.");
            return -1;
        }
        try {
            if (!this.useLowLatency || Build.VERSION.SDK_INT < 26) {
                this.audioTrack = createAudioTrackOnLollipopOrHigher(i, iChannelCountToConfiguration, minBufferSize, this.audioAttributes);
            } else {
                this.audioTrack = createAudioTrackOnOreoOrHigher(i, iChannelCountToConfiguration, minBufferSize, this.audioAttributes);
            }
            AudioTrack audioTrack = this.audioTrack;
            if (audioTrack == null || audioTrack.getState() != 1) {
                reportWebRtcAudioTrackInitError("Initialization of audio track failed.");
                releaseAudioResources();
                return -1;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                this.initialBufferSizeInFrames = this.audioTrack.getBufferSizeInFrames();
            } else {
                this.initialBufferSizeInFrames = -1;
            }
            logMainParameters();
            logMainParametersExtended();
            return minBufferSize;
        } catch (IllegalArgumentException e) {
            reportWebRtcAudioTrackInitError(e.getMessage());
            releaseAudioResources();
            return -1;
        }
    }

    private boolean isVolumeFixed() {
        return this.audioManager.isVolumeFixed();
    }

    private void logBufferCapacityInFrames() {
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sbU = outline.U("AudioTrack: buffer capacity in frames: ");
            sbU.append(this.audioTrack.getBufferCapacityInFrames());
            Logging.d(TAG, sbU.toString());
        }
    }

    private void logBufferSizeInFrames() {
        if (Build.VERSION.SDK_INT >= 23) {
            StringBuilder sbU = outline.U("AudioTrack: buffer size in frames: ");
            sbU.append(this.audioTrack.getBufferSizeInFrames());
            Logging.d(TAG, sbU.toString());
        }
    }

    private void logMainParameters() {
        StringBuilder sbU = outline.U("AudioTrack: session ID: ");
        sbU.append(this.audioTrack.getAudioSessionId());
        sbU.append(", channels: ");
        sbU.append(this.audioTrack.getChannelCount());
        sbU.append(", sample rate: ");
        sbU.append(this.audioTrack.getSampleRate());
        sbU.append(", max gain: ");
        sbU.append(AudioTrack.getMaxVolume());
        Logging.d(TAG, sbU.toString());
    }

    private void logMainParametersExtended() {
        logBufferSizeInFrames();
        logBufferCapacityInFrames();
    }

    private static void logNativeOutputSampleRate(int i) {
        int nativeOutputSampleRate = AudioTrack.getNativeOutputSampleRate(0);
        Logging.d(TAG, "nativeOutputSampleRate: " + nativeOutputSampleRate);
        if (i != nativeOutputSampleRate) {
            Logging.w(TAG, "Unable to use fast mode since requested sample rate is not native");
        }
    }

    private void logUnderrunCount() {
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sbU = outline.U("underrun count: ");
            sbU.append(this.audioTrack.getUnderrunCount());
            Logging.d(TAG, sbU.toString());
        }
    }

    private static native void nativeCacheDirectBufferAddress(long j, ByteBuffer byteBuffer);

    private static native void nativeGetPlayoutData(long j, int i);

    private void releaseAudioResources() {
        Logging.d(TAG, "releaseAudioResources");
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this.audioTrack = null;
        }
    }

    private void reportWebRtcAudioTrackError(String str) {
        Logging.e(TAG, "Run-time playback error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback = this.errorCallback;
        if (audioTrackErrorCallback != null) {
            audioTrackErrorCallback.onWebRtcAudioTrackError(str);
        }
    }

    private void reportWebRtcAudioTrackInitError(String str) {
        Logging.e(TAG, "Init playout error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback = this.errorCallback;
        if (audioTrackErrorCallback != null) {
            audioTrackErrorCallback.onWebRtcAudioTrackInitError(str);
        }
    }

    private void reportWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode audioTrackStartErrorCode, String str) {
        Logging.e(TAG, "Start playout error: " + audioTrackStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback = this.errorCallback;
        if (audioTrackErrorCallback != null) {
            audioTrackErrorCallback.onWebRtcAudioTrackStartError(audioTrackStartErrorCode, str);
        }
    }

    @CalledByNative
    private boolean setStreamVolume(int i) {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "setStreamVolume(" + i + ")");
        if (isVolumeFixed()) {
            Logging.e(TAG, "The device implements a fixed volume policy.");
            return false;
        }
        this.audioManager.setStreamVolume(0, i, 0);
        return true;
    }

    @CalledByNative
    private boolean startPlayout() throws IllegalStateException {
        this.threadChecker.checkIsOnValidThread();
        this.volumeLogger.start();
        Logging.d(TAG, "startPlayout");
        assertTrue(this.audioTrack != null);
        assertTrue(this.audioThread == null);
        try {
            this.audioTrack.play();
            if (this.audioTrack.getPlayState() == 3) {
                AudioTrackThread audioTrackThread = new AudioTrackThread("AudioTrackJavaThread");
                this.audioThread = audioTrackThread;
                audioTrackThread.start();
                return true;
            }
            JavaAudioDeviceModule.AudioTrackStartErrorCode audioTrackStartErrorCode = JavaAudioDeviceModule.AudioTrackStartErrorCode.AUDIO_TRACK_START_STATE_MISMATCH;
            StringBuilder sbU = outline.U("AudioTrack.play failed - incorrect state :");
            sbU.append(this.audioTrack.getPlayState());
            reportWebRtcAudioTrackStartError(audioTrackStartErrorCode, sbU.toString());
            releaseAudioResources();
            return false;
        } catch (IllegalStateException e) {
            JavaAudioDeviceModule.AudioTrackStartErrorCode audioTrackStartErrorCode2 = JavaAudioDeviceModule.AudioTrackStartErrorCode.AUDIO_TRACK_START_EXCEPTION;
            StringBuilder sbU2 = outline.U("AudioTrack.play failed: ");
            sbU2.append(e.getMessage());
            reportWebRtcAudioTrackStartError(audioTrackStartErrorCode2, sbU2.toString());
            releaseAudioResources();
            return false;
        }
    }

    @CalledByNative
    private boolean stopPlayout() throws IllegalStateException {
        this.threadChecker.checkIsOnValidThread();
        this.volumeLogger.stop();
        Logging.d(TAG, "stopPlayout");
        assertTrue(this.audioThread != null);
        logUnderrunCount();
        this.audioThread.stopThread();
        Logging.d(TAG, "Stopping the AudioTrackThread...");
        this.audioThread.interrupt();
        if (!ThreadUtils.joinUninterruptibly(this.audioThread, AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS)) {
            Logging.e(TAG, "Join of AudioTrackThread timed out.");
            WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        }
        Logging.d(TAG, "AudioTrackThread has now been stopped.");
        this.audioThread = null;
        if (this.audioTrack != null) {
            Logging.d(TAG, "Calling AudioTrack.stop...");
            try {
                this.audioTrack.stop();
                Logging.d(TAG, "AudioTrack.stop is done.");
                doAudioTrackStateCallback(1);
            } catch (IllegalStateException e) {
                StringBuilder sbU = outline.U("AudioTrack.stop failed: ");
                sbU.append(e.getMessage());
                Logging.e(TAG, sbU.toString());
            }
        }
        releaseAudioResources();
        return true;
    }

    @CalledByNative
    public void setNativeAudioTrack(long j) {
        this.nativeAudioTrack = j;
    }

    public void setSpeakerMute(boolean z2) {
        Logging.w(TAG, "setSpeakerMute(" + z2 + ")");
        this.speakerMute = z2;
    }

    public WebRtcAudioTrack(Context context, AudioManager audioManager, @Nullable AudioAttributes audioAttributes, @Nullable JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback, @Nullable JavaAudioDeviceModule.AudioTrackStateCallback audioTrackStateCallback, boolean z2) {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        threadChecker.detachThread();
        this.context = context;
        this.audioManager = audioManager;
        this.audioAttributes = audioAttributes;
        this.errorCallback = audioTrackErrorCallback;
        this.stateCallback = audioTrackStateCallback;
        this.volumeLogger = new VolumeLogger(audioManager);
        this.useLowLatency = z2;
        StringBuilder sbU = outline.U("ctor");
        sbU.append(WebRtcAudioUtils.getThreadInfo());
        Logging.d(TAG, sbU.toString());
    }
}
