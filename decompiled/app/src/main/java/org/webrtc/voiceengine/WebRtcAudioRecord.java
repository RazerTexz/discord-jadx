package org.webrtc.voiceengine;

import android.media.AudioRecord;
import android.os.Build;
import android.os.Process;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;

/* loaded from: classes3.dex */
public class WebRtcAudioRecord {
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_AUDIO_SOURCE;
    private static final String TAG = "WebRtcAudioRecord";

    @Nullable
    private static WebRtcAudioRecordSamplesReadyCallback audioSamplesReadyCallback;
    private static int audioSource;

    @Nullable
    private static WebRtcAudioRecordErrorCallback errorCallback;
    private static volatile boolean microphoneMute;

    @Nullable
    private AudioRecord audioRecord;

    @Nullable
    private AudioRecordThread audioThread;
    private ByteBuffer byteBuffer;

    @Nullable
    private WebRtcAudioEffects effects;
    private byte[] emptyBytes;
    private final long nativeAudioRecord;

    public enum AudioRecordStartErrorCode {
        AUDIO_RECORD_START_EXCEPTION,
        AUDIO_RECORD_START_STATE_MISMATCH
    }

    public class AudioRecordThread extends Thread {
        private volatile boolean keepAlive;

        public AudioRecordThread(String str) {
            super(str);
            this.keepAlive = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IllegalStateException, SecurityException, IllegalArgumentException {
            Process.setThreadPriority(-19);
            Logging.d(WebRtcAudioRecord.TAG, "AudioRecordThread" + WebRtcAudioUtils.getThreadInfo());
            WebRtcAudioRecord.access$100(WebRtcAudioRecord.access$000(WebRtcAudioRecord.this).getRecordingState() == 3);
            System.nanoTime();
            while (this.keepAlive) {
                int i = WebRtcAudioRecord.access$000(WebRtcAudioRecord.this).read(WebRtcAudioRecord.access$200(WebRtcAudioRecord.this), WebRtcAudioRecord.access$200(WebRtcAudioRecord.this).capacity());
                if (i == WebRtcAudioRecord.access$200(WebRtcAudioRecord.this).capacity()) {
                    if (WebRtcAudioRecord.access$300()) {
                        WebRtcAudioRecord.access$200(WebRtcAudioRecord.this).clear();
                        WebRtcAudioRecord.access$200(WebRtcAudioRecord.this).put(WebRtcAudioRecord.access$400(WebRtcAudioRecord.this));
                    }
                    if (this.keepAlive) {
                        WebRtcAudioRecord webRtcAudioRecord = WebRtcAudioRecord.this;
                        WebRtcAudioRecord.access$600(webRtcAudioRecord, i, WebRtcAudioRecord.access$500(webRtcAudioRecord));
                    }
                    if (WebRtcAudioRecord.access$700() != null) {
                        WebRtcAudioRecord.access$700().onWebRtcAudioRecordSamplesReady(new AudioSamples(WebRtcAudioRecord.access$000(WebRtcAudioRecord.this), Arrays.copyOf(WebRtcAudioRecord.access$200(WebRtcAudioRecord.this).array(), WebRtcAudioRecord.access$200(WebRtcAudioRecord.this).capacity()), null));
                    }
                } else {
                    String str = "AudioRecord.read failed: " + i;
                    Logging.e(WebRtcAudioRecord.TAG, str);
                    if (i == -3) {
                        this.keepAlive = false;
                        WebRtcAudioRecord.access$900(WebRtcAudioRecord.this, str);
                    }
                }
            }
            try {
                if (WebRtcAudioRecord.access$000(WebRtcAudioRecord.this) != null) {
                    WebRtcAudioRecord.access$000(WebRtcAudioRecord.this).stop();
                }
            } catch (IllegalStateException e) {
                StringBuilder sbU = outline.U("AudioRecord.stop failed: ");
                sbU.append(e.getMessage());
                Logging.e(WebRtcAudioRecord.TAG, sbU.toString());
            }
        }

        public void stopThread() {
            Logging.d(WebRtcAudioRecord.TAG, "stopThread");
            this.keepAlive = false;
        }
    }

    public static class AudioSamples {
        private final int audioFormat;
        private final int channelCount;
        private final byte[] data;
        private final int sampleRate;

        public /* synthetic */ AudioSamples(AudioRecord audioRecord, byte[] bArr, AnonymousClass1 anonymousClass1) {
            this(audioRecord, bArr);
        }

        public int getAudioFormat() {
            return this.audioFormat;
        }

        public int getChannelCount() {
            return this.channelCount;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getSampleRate() {
            return this.sampleRate;
        }

        private AudioSamples(AudioRecord audioRecord, byte[] bArr) {
            this.audioFormat = audioRecord.getAudioFormat();
            this.channelCount = audioRecord.getChannelCount();
            this.sampleRate = audioRecord.getSampleRate();
            this.data = bArr;
        }
    }

    public interface WebRtcAudioRecordErrorCallback {
        void onWebRtcAudioRecordError(String str);

        void onWebRtcAudioRecordInitError(String str);

        void onWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str);
    }

    public interface WebRtcAudioRecordSamplesReadyCallback {
        void onWebRtcAudioRecordSamplesReady(AudioSamples audioSamples);
    }

    static {
        int defaultAudioSource = getDefaultAudioSource();
        DEFAULT_AUDIO_SOURCE = defaultAudioSource;
        audioSource = defaultAudioSource;
    }

    public WebRtcAudioRecord(long j) {
        StringBuilder sbU = outline.U("ctor");
        sbU.append(WebRtcAudioUtils.getThreadInfo());
        Logging.d(TAG, sbU.toString());
        this.nativeAudioRecord = j;
        this.effects = WebRtcAudioEffects.create();
    }

    public static /* synthetic */ AudioRecord access$000(WebRtcAudioRecord webRtcAudioRecord) {
        return webRtcAudioRecord.audioRecord;
    }

    public static /* synthetic */ void access$100(boolean z2) {
        assertTrue(z2);
    }

    public static /* synthetic */ ByteBuffer access$200(WebRtcAudioRecord webRtcAudioRecord) {
        return webRtcAudioRecord.byteBuffer;
    }

    public static /* synthetic */ boolean access$300() {
        return microphoneMute;
    }

    public static /* synthetic */ byte[] access$400(WebRtcAudioRecord webRtcAudioRecord) {
        return webRtcAudioRecord.emptyBytes;
    }

    public static /* synthetic */ long access$500(WebRtcAudioRecord webRtcAudioRecord) {
        return webRtcAudioRecord.nativeAudioRecord;
    }

    public static /* synthetic */ void access$600(WebRtcAudioRecord webRtcAudioRecord, int i, long j) {
        webRtcAudioRecord.nativeDataIsRecorded(i, j);
    }

    public static /* synthetic */ WebRtcAudioRecordSamplesReadyCallback access$700() {
        return audioSamplesReadyCallback;
    }

    public static /* synthetic */ void access$900(WebRtcAudioRecord webRtcAudioRecord, String str) {
        webRtcAudioRecord.reportWebRtcAudioRecordError(str);
    }

    private static void assertTrue(boolean z2) {
        if (!z2) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private int channelCountToConfiguration(int i) {
        return i == 1 ? 16 : 12;
    }

    private boolean enableBuiltInAEC(boolean z2) {
        Logging.d(TAG, "enableBuiltInAEC(" + z2 + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            return webRtcAudioEffects.setAEC(z2);
        }
        Logging.e(TAG, "Built-in AEC is not supported on this platform");
        return false;
    }

    private boolean enableBuiltInNS(boolean z2) {
        Logging.d(TAG, "enableBuiltInNS(" + z2 + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            return webRtcAudioEffects.setNS(z2);
        }
        Logging.e(TAG, "Built-in NS is not supported on this platform");
        return false;
    }

    private static int getDefaultAudioSource() {
        return 7;
    }

    private int initRecording(int i, int i2) {
        Logging.d(TAG, "initRecording(sampleRate=" + i + ", channels=" + i2 + ")");
        if (this.audioRecord != null) {
            reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
            return -1;
        }
        int i3 = i / 100;
        this.byteBuffer = ByteBuffer.allocateDirect(i2 * 2 * i3);
        StringBuilder sbU = outline.U("byteBuffer.capacity: ");
        sbU.append(this.byteBuffer.capacity());
        Logging.d(TAG, sbU.toString());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioRecord);
        int iChannelCountToConfiguration = channelCountToConfiguration(i2);
        int minBufferSize = AudioRecord.getMinBufferSize(i, iChannelCountToConfiguration, 2);
        if (minBufferSize == -1 || minBufferSize == -2) {
            reportWebRtcAudioRecordInitError(outline.q("AudioRecord.getMinBufferSize failed: ", minBufferSize));
            return -1;
        }
        Logging.d(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
        int iMax = Math.max(minBufferSize * 2, this.byteBuffer.capacity());
        Logging.d(TAG, "bufferSizeInBytes: " + iMax);
        try {
            AudioRecord audioRecord = new AudioRecord(audioSource, i, iChannelCountToConfiguration, 2, iMax);
            this.audioRecord = audioRecord;
            if (audioRecord.getState() != 1) {
                reportWebRtcAudioRecordInitError("Failed to create a new AudioRecord instance");
                releaseAudioResources();
                return -1;
            }
            WebRtcAudioEffects webRtcAudioEffects = this.effects;
            if (webRtcAudioEffects != null) {
                webRtcAudioEffects.enable(this.audioRecord.getAudioSessionId());
            }
            logMainParameters();
            logMainParametersExtended();
            return i3;
        } catch (IllegalArgumentException e) {
            StringBuilder sbU2 = outline.U("AudioRecord ctor error: ");
            sbU2.append(e.getMessage());
            reportWebRtcAudioRecordInitError(sbU2.toString());
            releaseAudioResources();
            return -1;
        }
    }

    private void logMainParameters() {
        StringBuilder sbU = outline.U("AudioRecord: session ID: ");
        sbU.append(this.audioRecord.getAudioSessionId());
        sbU.append(", channels: ");
        sbU.append(this.audioRecord.getChannelCount());
        sbU.append(", sample rate: ");
        sbU.append(this.audioRecord.getSampleRate());
        Logging.d(TAG, sbU.toString());
    }

    private void logMainParametersExtended() {
        if (Build.VERSION.SDK_INT >= 23) {
            StringBuilder sbU = outline.U("AudioRecord: buffer size in frames: ");
            sbU.append(this.audioRecord.getBufferSizeInFrames());
            Logging.d(TAG, sbU.toString());
        }
    }

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long j);

    private native void nativeDataIsRecorded(int i, long j);

    private void releaseAudioResources() {
        Logging.d(TAG, "releaseAudioResources");
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            audioRecord.release();
            this.audioRecord = null;
        }
    }

    private void reportWebRtcAudioRecordError(String str) {
        Logging.e(TAG, "Run-time recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordError(str);
        }
    }

    private void reportWebRtcAudioRecordInitError(String str) {
        Logging.e(TAG, "Init recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordInitError(str);
        }
    }

    private void reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        Logging.e(TAG, "Start recording error: " + audioRecordStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordStartError(audioRecordStartErrorCode, str);
        }
    }

    public static synchronized void setAudioSource(int i) {
        Logging.w(TAG, "Audio source is changed from: " + audioSource + " to " + i);
        audioSource = i;
    }

    public static void setErrorCallback(WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback) {
        Logging.d(TAG, "Set error callback");
        errorCallback = webRtcAudioRecordErrorCallback;
    }

    public static void setMicrophoneMute(boolean z2) {
        Logging.w(TAG, "setMicrophoneMute(" + z2 + ")");
        microphoneMute = z2;
    }

    public static void setOnAudioSamplesReady(WebRtcAudioRecordSamplesReadyCallback webRtcAudioRecordSamplesReadyCallback) {
        audioSamplesReadyCallback = webRtcAudioRecordSamplesReadyCallback;
    }

    private boolean startRecording() {
        try {
            Logging.d(TAG, "startRecording");
            try {
                assertTrue(this.audioRecord != null);
                try {
                    assertTrue(this.audioThread == null);
                    try {
                        this.audioRecord.startRecording();
                        if (this.audioRecord.getRecordingState() == 3) {
                            AudioRecordThread audioRecordThread = new AudioRecordThread("AudioRecordJavaThread");
                            this.audioThread = audioRecordThread;
                            audioRecordThread.start();
                            return true;
                        }
                        reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state :" + this.audioRecord.getRecordingState());
                        return false;
                    } catch (IllegalStateException e) {
                        reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e.getMessage());
                        return false;
                    }
                } catch (Throwable th) {
                    Logging.e(TAG, "WebrtcAudioRecord.startRecording: audioThread != null!", th);
                    throw th;
                }
            } catch (Throwable th2) {
                Logging.e(TAG, "WebrtcAudioRecord.startRecording: audioRecord == null!", th2);
                throw th2;
            }
        } catch (Throwable th3) {
            Logging.e(TAG, "WebrtcAudioRecord.startRecording fail hard!", th3);
            throw th3;
        }
    }

    private boolean stopRecording() {
        Logging.d(TAG, "stopRecording");
        assertTrue(this.audioThread != null);
        this.audioThread.stopThread();
        if (!ThreadUtils.joinUninterruptibly(this.audioThread, AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS)) {
            Logging.e(TAG, "Join of AudioRecordJavaThread timed out");
            WebRtcAudioUtils.logAudioState(TAG);
        }
        this.audioThread = null;
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            webRtcAudioEffects.release();
        }
        releaseAudioResources();
        return true;
    }
}
