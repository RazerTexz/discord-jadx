package org.webrtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import android.os.Process;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.d.b.a.outline;
import h0.c.u0.a;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.webrtc.CalledByNative;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;
import org.webrtc.audio.JavaAudioDeviceModule;

/* loaded from: classes3.dex */
public class WebRtcAudioRecord {
    private static final int AUDIO_RECORD_START = 0;
    private static final int AUDIO_RECORD_STOP = 1;
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final int CHECK_REC_STATUS_DELAY_MS = 100;
    public static final int DEFAULT_AUDIO_FORMAT = 2;
    public static final int DEFAULT_AUDIO_SOURCE = 7;
    private static final String TAG = "WebRtcAudioRecordExternal";
    private static final AtomicInteger nextSchedulerId = new AtomicInteger(0);
    private final int audioFormat;
    private final AudioManager audioManager;

    @Nullable
    private AudioRecord audioRecord;

    @Nullable
    private final JavaAudioDeviceModule.SamplesReadyCallback audioSamplesReadyCallback;
    private final int audioSource;
    private final AtomicReference<Boolean> audioSourceMatchesRecordingSessionRef;

    @Nullable
    private AudioRecordThread audioThread;

    @Nullable
    private ByteBuffer byteBuffer;
    private final Context context;
    private final WebRtcAudioEffects effects;
    private byte[] emptyBytes;

    @Nullable
    private final JavaAudioDeviceModule.AudioRecordErrorCallback errorCallback;
    private final ScheduledExecutorService executor;

    @Nullable
    private ScheduledFuture<String> future;
    private final boolean isAcousticEchoCancelerSupported;
    private final boolean isNoiseSuppressorSupported;
    private volatile boolean microphoneMute;
    private long nativeAudioRecord;

    @Nullable
    private AudioDeviceInfo preferredDevice;

    @Nullable
    private final JavaAudioDeviceModule.AudioRecordStateCallback stateCallback;

    /* renamed from: org.webrtc.audio.WebRtcAudioRecord$1, reason: invalid class name */
    public class AnonymousClass1 implements ThreadFactory {
        public final /* synthetic */ AtomicInteger val$nextThreadId;

        public AnonymousClass1(AtomicInteger atomicInteger) {
            this.val$nextThreadId = atomicInteger;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
            threadNewThread.setName(String.format("WebRtcAudioRecordScheduler-%s-%s", Integer.valueOf(WebRtcAudioRecord.access$1000().getAndIncrement()), Integer.valueOf(this.val$nextThreadId.getAndIncrement())));
            return threadNewThread;
        }
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
            WebRtcAudioRecord.access$200(WebRtcAudioRecord.this, 0);
            System.nanoTime();
            while (this.keepAlive) {
                int i = WebRtcAudioRecord.access$000(WebRtcAudioRecord.this).read(WebRtcAudioRecord.access$300(WebRtcAudioRecord.this), WebRtcAudioRecord.access$300(WebRtcAudioRecord.this).capacity());
                if (i == WebRtcAudioRecord.access$300(WebRtcAudioRecord.this).capacity()) {
                    if (WebRtcAudioRecord.access$400(WebRtcAudioRecord.this)) {
                        WebRtcAudioRecord.access$300(WebRtcAudioRecord.this).clear();
                        WebRtcAudioRecord.access$300(WebRtcAudioRecord.this).put(WebRtcAudioRecord.access$500(WebRtcAudioRecord.this));
                    }
                    if (this.keepAlive) {
                        WebRtcAudioRecord webRtcAudioRecord = WebRtcAudioRecord.this;
                        WebRtcAudioRecord.access$700(webRtcAudioRecord, WebRtcAudioRecord.access$600(webRtcAudioRecord), i);
                    }
                    if (WebRtcAudioRecord.access$800(WebRtcAudioRecord.this) != null) {
                        WebRtcAudioRecord.access$800(WebRtcAudioRecord.this).onWebRtcAudioRecordSamplesReady(new JavaAudioDeviceModule.AudioSamples(WebRtcAudioRecord.access$000(WebRtcAudioRecord.this).getAudioFormat(), WebRtcAudioRecord.access$000(WebRtcAudioRecord.this).getChannelCount(), WebRtcAudioRecord.access$000(WebRtcAudioRecord.this).getSampleRate(), Arrays.copyOfRange(WebRtcAudioRecord.access$300(WebRtcAudioRecord.this).array(), WebRtcAudioRecord.access$300(WebRtcAudioRecord.this).arrayOffset(), WebRtcAudioRecord.access$300(WebRtcAudioRecord.this).arrayOffset() + WebRtcAudioRecord.access$300(WebRtcAudioRecord.this).capacity())));
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
                    WebRtcAudioRecord.access$200(WebRtcAudioRecord.this, 1);
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

    @CalledByNative
    public WebRtcAudioRecord(Context context, AudioManager audioManager) {
        this(context, newDefaultScheduler(), audioManager, 7, 2, null, null, null, WebRtcAudioEffects.isAcousticEchoCancelerSupported(), WebRtcAudioEffects.isNoiseSuppressorSupported());
    }

    public static /* synthetic */ AudioRecord access$000(WebRtcAudioRecord webRtcAudioRecord) {
        return webRtcAudioRecord.audioRecord;
    }

    public static /* synthetic */ void access$100(boolean z2) {
        assertTrue(z2);
    }

    public static /* synthetic */ AtomicInteger access$1000() {
        return nextSchedulerId;
    }

    public static /* synthetic */ void access$200(WebRtcAudioRecord webRtcAudioRecord, int i) {
        webRtcAudioRecord.doAudioRecordStateCallback(i);
    }

    public static /* synthetic */ ByteBuffer access$300(WebRtcAudioRecord webRtcAudioRecord) {
        return webRtcAudioRecord.byteBuffer;
    }

    public static /* synthetic */ boolean access$400(WebRtcAudioRecord webRtcAudioRecord) {
        return webRtcAudioRecord.microphoneMute;
    }

    public static /* synthetic */ byte[] access$500(WebRtcAudioRecord webRtcAudioRecord) {
        return webRtcAudioRecord.emptyBytes;
    }

    public static /* synthetic */ long access$600(WebRtcAudioRecord webRtcAudioRecord) {
        return webRtcAudioRecord.nativeAudioRecord;
    }

    public static /* synthetic */ void access$700(WebRtcAudioRecord webRtcAudioRecord, long j, int i) {
        webRtcAudioRecord.nativeDataIsRecorded(j, i);
    }

    public static /* synthetic */ JavaAudioDeviceModule.SamplesReadyCallback access$800(WebRtcAudioRecord webRtcAudioRecord) {
        return webRtcAudioRecord.audioSamplesReadyCallback;
    }

    public static /* synthetic */ void access$900(WebRtcAudioRecord webRtcAudioRecord, String str) {
        webRtcAudioRecord.reportWebRtcAudioRecordError(str);
    }

    private static void assertTrue(boolean z2) {
        if (!z2) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private static String audioStateToString(int i) {
        return i != 0 ? i != 1 ? "INVALID" : "STOP" : "START";
    }

    private int channelCountToConfiguration(int i) {
        return i == 1 ? 16 : 12;
    }

    @TargetApi(24)
    private static boolean checkDeviceMatch(AudioDeviceInfo audioDeviceInfo, AudioDeviceInfo audioDeviceInfo2) {
        return audioDeviceInfo.getId() == audioDeviceInfo2.getId() && audioDeviceInfo.getType() == audioDeviceInfo2.getType();
    }

    private static AudioRecord createAudioRecordOnLowerThanM(int i, int i2, int i3, int i4, int i5) {
        Logging.d(TAG, "createAudioRecordOnLowerThanM");
        return new AudioRecord(i, i2, i3, i4, i5);
    }

    @TargetApi(23)
    private static AudioRecord createAudioRecordOnMOrHigher(int i, int i2, int i3, int i4, int i5) {
        Logging.d(TAG, "createAudioRecordOnMOrHigher");
        return new AudioRecord.Builder().setAudioSource(i).setAudioFormat(new AudioFormat.Builder().setEncoding(i4).setSampleRate(i2).setChannelMask(i3).build()).setBufferSizeInBytes(i5).build();
    }

    private void doAudioRecordStateCallback(int i) {
        StringBuilder sbU = outline.U("doAudioRecordStateCallback: ");
        sbU.append(audioStateToString(i));
        Logging.d(TAG, sbU.toString());
        JavaAudioDeviceModule.AudioRecordStateCallback audioRecordStateCallback = this.stateCallback;
        if (audioRecordStateCallback != null) {
            if (i == 0) {
                audioRecordStateCallback.onWebRtcAudioRecordStart();
            } else if (i == 1) {
                audioRecordStateCallback.onWebRtcAudioRecordStop();
            } else {
                Logging.e(TAG, "Invalid audio state");
            }
        }
    }

    @CalledByNative
    private boolean enableBuiltInAEC(boolean z2) {
        Logging.d(TAG, "enableBuiltInAEC(" + z2 + ")");
        return this.effects.setAEC(z2);
    }

    @CalledByNative
    private boolean enableBuiltInNS(boolean z2) {
        Logging.d(TAG, "enableBuiltInNS(" + z2 + ")");
        return this.effects.setNS(z2);
    }

    private static int getBytesPerSample(int i) {
        int i2 = 1;
        if (i != 1 && i != 2) {
            if (i != 3) {
                i2 = 4;
                if (i != 4) {
                    if (i != 13) {
                        throw new IllegalArgumentException(outline.q("Bad audio format ", i));
                    }
                }
            }
            return i2;
        }
        return 2;
    }

    @CalledByNative
    private int initRecording(int i, int i2) {
        Logging.d(TAG, "initRecording(sampleRate=" + i + ", channels=" + i2 + ")");
        if (this.audioRecord != null) {
            reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
            return -1;
        }
        int i3 = i / 100;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(getBytesPerSample(this.audioFormat) * i2 * i3);
        this.byteBuffer = byteBufferAllocateDirect;
        if (!byteBufferAllocateDirect.hasArray()) {
            reportWebRtcAudioRecordInitError("ByteBuffer does not have backing array.");
            return -1;
        }
        StringBuilder sbU = outline.U("byteBuffer.capacity: ");
        sbU.append(this.byteBuffer.capacity());
        Logging.d(TAG, sbU.toString());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.nativeAudioRecord, this.byteBuffer);
        int iChannelCountToConfiguration = channelCountToConfiguration(i2);
        int minBufferSize = AudioRecord.getMinBufferSize(i, iChannelCountToConfiguration, this.audioFormat);
        if (minBufferSize == -1 || minBufferSize == -2) {
            reportWebRtcAudioRecordInitError(outline.q("AudioRecord.getMinBufferSize failed: ", minBufferSize));
            return -1;
        }
        Logging.d(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
        int iMax = Math.max(minBufferSize * 2, this.byteBuffer.capacity());
        Logging.d(TAG, "bufferSizeInBytes: " + iMax);
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                this.audioRecord = createAudioRecordOnMOrHigher(this.audioSource, i, iChannelCountToConfiguration, this.audioFormat, iMax);
                this.audioSourceMatchesRecordingSessionRef.set(null);
                AudioDeviceInfo audioDeviceInfo = this.preferredDevice;
                if (audioDeviceInfo != null) {
                    setPreferredDevice(audioDeviceInfo);
                }
            } else {
                this.audioRecord = createAudioRecordOnLowerThanM(this.audioSource, i, iChannelCountToConfiguration, this.audioFormat, iMax);
                this.audioSourceMatchesRecordingSessionRef.set(null);
            }
            AudioRecord audioRecord = this.audioRecord;
            if (audioRecord == null || audioRecord.getState() != 1) {
                reportWebRtcAudioRecordInitError("Creation or initialization of audio recorder failed.");
                releaseAudioResources();
                return -1;
            }
            this.effects.enable(this.audioRecord.getAudioSessionId());
            logMainParameters();
            logMainParametersExtended();
            int iLogRecordingConfigurations = logRecordingConfigurations(this.audioRecord, false);
            if (iLogRecordingConfigurations != 0) {
                Logging.w(TAG, "Potential microphone conflict. Active sessions: " + iLogRecordingConfigurations);
            }
            return i3;
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            reportWebRtcAudioRecordInitError(e.getMessage());
            releaseAudioResources();
            return -1;
        }
    }

    @TargetApi(24)
    private static boolean logActiveRecordingConfigs(int i, List<AudioRecordingConfiguration> list) {
        assertTrue(!list.isEmpty());
        Logging.d(TAG, "AudioRecordingConfigurations: ");
        for (AudioRecordingConfiguration audioRecordingConfiguration : list) {
            StringBuilder sb = new StringBuilder();
            int clientAudioSource = audioRecordingConfiguration.getClientAudioSource();
            sb.append("  client audio source=");
            sb.append(WebRtcAudioUtils.audioSourceToString(clientAudioSource));
            sb.append(", client session id=");
            sb.append(audioRecordingConfiguration.getClientAudioSessionId());
            sb.append(" (");
            sb.append(i);
            sb.append(")");
            sb.append("\n");
            AudioFormat format = audioRecordingConfiguration.getFormat();
            sb.append("  Device AudioFormat: ");
            sb.append("channel count=");
            sb.append(format.getChannelCount());
            sb.append(", channel index mask=");
            sb.append(format.getChannelIndexMask());
            sb.append(", channel mask=");
            sb.append(WebRtcAudioUtils.channelMaskToString(format.getChannelMask()));
            sb.append(", encoding=");
            sb.append(WebRtcAudioUtils.audioEncodingToString(format.getEncoding()));
            sb.append(", sample rate=");
            sb.append(format.getSampleRate());
            sb.append("\n");
            AudioFormat clientFormat = audioRecordingConfiguration.getClientFormat();
            sb.append("  Client AudioFormat: ");
            sb.append("channel count=");
            sb.append(clientFormat.getChannelCount());
            sb.append(", channel index mask=");
            sb.append(clientFormat.getChannelIndexMask());
            sb.append(", channel mask=");
            sb.append(WebRtcAudioUtils.channelMaskToString(clientFormat.getChannelMask()));
            sb.append(", encoding=");
            sb.append(WebRtcAudioUtils.audioEncodingToString(clientFormat.getEncoding()));
            sb.append(", sample rate=");
            sb.append(clientFormat.getSampleRate());
            sb.append("\n");
            AudioDeviceInfo audioDevice = audioRecordingConfiguration.getAudioDevice();
            if (audioDevice != null) {
                assertTrue(audioDevice.isSource());
                sb.append("  AudioDevice: ");
                sb.append("type=");
                sb.append(WebRtcAudioUtils.deviceTypeToString(audioDevice.getType()));
                sb.append(", id=");
                sb.append(audioDevice.getId());
            }
            Logging.d(TAG, sb.toString());
        }
        return true;
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

    @TargetApi(23)
    private void logMainParametersExtended() {
        if (Build.VERSION.SDK_INT >= 23) {
            StringBuilder sbU = outline.U("AudioRecord: buffer size in frames: ");
            sbU.append(this.audioRecord.getBufferSizeInFrames());
            Logging.d(TAG, sbU.toString());
        }
    }

    @TargetApi(24)
    private int logRecordingConfigurations(AudioRecord audioRecord, boolean z2) {
        if (Build.VERSION.SDK_INT < 24) {
            Logging.w(TAG, "AudioManager#getActiveRecordingConfigurations() requires N or higher");
            return 0;
        }
        if (audioRecord == null) {
            return 0;
        }
        List<AudioRecordingConfiguration> activeRecordingConfigurations = this.audioManager.getActiveRecordingConfigurations();
        int size = activeRecordingConfigurations.size();
        Logging.d(TAG, "Number of active recording sessions: " + size);
        if (size > 0) {
            logActiveRecordingConfigs(audioRecord.getAudioSessionId(), activeRecordingConfigurations);
            if (z2) {
                this.audioSourceMatchesRecordingSessionRef.set(Boolean.valueOf(verifyAudioConfig(audioRecord.getAudioSource(), audioRecord.getAudioSessionId(), audioRecord.getFormat(), audioRecord.getRoutedDevice(), activeRecordingConfigurations)));
            }
        }
        return size;
    }

    private native void nativeCacheDirectBufferAddress(long j, ByteBuffer byteBuffer);

    private native void nativeDataIsRecorded(long j, int i);

    public static ScheduledExecutorService newDefaultScheduler() {
        return Executors.newScheduledThreadPool(0, new AnonymousClass1(new AtomicInteger(0)));
    }

    private void releaseAudioResources() {
        Logging.d(TAG, "releaseAudioResources");
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            audioRecord.release();
            this.audioRecord = null;
        }
        this.audioSourceMatchesRecordingSessionRef.set(null);
    }

    private void reportWebRtcAudioRecordError(String str) {
        Logging.e(TAG, "Run-time recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordError(str);
        }
    }

    private void reportWebRtcAudioRecordInitError(String str) {
        Logging.e(TAG, "Init recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        logRecordingConfigurations(this.audioRecord, false);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordInitError(str);
        }
    }

    private void reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        Logging.e(TAG, "Start recording error: " + audioRecordStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        logRecordingConfigurations(this.audioRecord, false);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordStartError(audioRecordStartErrorCode, str);
        }
    }

    private void scheduleLogRecordingConfigurationsTask(AudioRecord audioRecord) {
        Logging.d(TAG, "scheduleLogRecordingConfigurationsTask");
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        a aVar = new a(this, audioRecord);
        ScheduledFuture<String> scheduledFuture = this.future;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.future.cancel(true);
        }
        this.future = this.executor.schedule(aVar, 100L, TimeUnit.MILLISECONDS);
    }

    @CalledByNative
    private boolean startRecording() throws IllegalStateException {
        Logging.d(TAG, "startRecording");
        assertTrue(this.audioRecord != null);
        assertTrue(this.audioThread == null);
        try {
            this.audioRecord.startRecording();
            if (this.audioRecord.getRecordingState() != 3) {
                JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode = JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH;
                StringBuilder sbU = outline.U("AudioRecord.startRecording failed - incorrect state: ");
                sbU.append(this.audioRecord.getRecordingState());
                reportWebRtcAudioRecordStartError(audioRecordStartErrorCode, sbU.toString());
                return false;
            }
            AudioRecordThread audioRecordThread = new AudioRecordThread("AudioRecordJavaThread");
            this.audioThread = audioRecordThread;
            audioRecordThread.start();
            scheduleLogRecordingConfigurationsTask(this.audioRecord);
            return true;
        } catch (IllegalStateException e) {
            JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode2 = JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION;
            StringBuilder sbU2 = outline.U("AudioRecord.startRecording failed: ");
            sbU2.append(e.getMessage());
            reportWebRtcAudioRecordStartError(audioRecordStartErrorCode2, sbU2.toString());
            return false;
        }
    }

    @CalledByNative
    private boolean stopRecording() {
        Logging.d(TAG, "stopRecording");
        assertTrue(this.audioThread != null);
        ScheduledFuture<String> scheduledFuture = this.future;
        if (scheduledFuture != null) {
            if (!scheduledFuture.isDone()) {
                this.future.cancel(true);
            }
            this.future = null;
        }
        this.audioThread.stopThread();
        if (!ThreadUtils.joinUninterruptibly(this.audioThread, AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS)) {
            Logging.e(TAG, "Join of AudioRecordJavaThread timed out");
            WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        }
        this.audioThread = null;
        this.effects.release();
        releaseAudioResources();
        return true;
    }

    @TargetApi(24)
    private static boolean verifyAudioConfig(int i, int i2, AudioFormat audioFormat, AudioDeviceInfo audioDeviceInfo, List<AudioRecordingConfiguration> list) {
        assertTrue(!list.isEmpty());
        for (AudioRecordingConfiguration audioRecordingConfiguration : list) {
            AudioDeviceInfo audioDevice = audioRecordingConfiguration.getAudioDevice();
            if (audioDevice != null && audioRecordingConfiguration.getClientAudioSource() == i && audioRecordingConfiguration.getClientAudioSessionId() == i2 && audioRecordingConfiguration.getClientFormat().getEncoding() == audioFormat.getEncoding() && audioRecordingConfiguration.getClientFormat().getSampleRate() == audioFormat.getSampleRate() && audioRecordingConfiguration.getClientFormat().getChannelMask() == audioFormat.getChannelMask() && audioRecordingConfiguration.getClientFormat().getChannelIndexMask() == audioFormat.getChannelIndexMask() && audioRecordingConfiguration.getFormat().getEncoding() != 0 && audioRecordingConfiguration.getFormat().getSampleRate() > 0 && (audioRecordingConfiguration.getFormat().getChannelMask() != 0 || audioRecordingConfiguration.getFormat().getChannelIndexMask() != 0)) {
                if (checkDeviceMatch(audioDevice, audioDeviceInfo)) {
                    Logging.d(TAG, "verifyAudioConfig: PASS");
                    return true;
                }
            }
        }
        Logging.e(TAG, "verifyAudioConfig: FAILED");
        return false;
    }

    public /* synthetic */ String a(AudioRecord audioRecord) {
        if (this.audioRecord == audioRecord) {
            logRecordingConfigurations(audioRecord, true);
            return "Scheduled task is done";
        }
        Logging.d(TAG, "audio record has changed");
        return "Scheduled task is done";
    }

    @CalledByNative
    public boolean isAcousticEchoCancelerSupported() {
        return this.isAcousticEchoCancelerSupported;
    }

    @CalledByNative
    public boolean isAudioConfigVerified() {
        return this.audioSourceMatchesRecordingSessionRef.get() != null;
    }

    @CalledByNative
    public boolean isAudioSourceMatchingRecordingSession() {
        Boolean bool = this.audioSourceMatchesRecordingSessionRef.get();
        if (bool != null) {
            return bool.booleanValue();
        }
        Logging.w(TAG, "Audio configuration has not yet been verified");
        return false;
    }

    @CalledByNative
    public boolean isNoiseSuppressorSupported() {
        return this.isNoiseSuppressorSupported;
    }

    public void setMicrophoneMute(boolean z2) {
        Logging.w(TAG, "setMicrophoneMute(" + z2 + ")");
        this.microphoneMute = z2;
    }

    @CalledByNative
    public void setNativeAudioRecord(long j) {
        this.nativeAudioRecord = j;
    }

    @RequiresApi(23)
    @TargetApi(23)
    public void setPreferredDevice(@Nullable AudioDeviceInfo audioDeviceInfo) {
        StringBuilder sbU = outline.U("setPreferredDevice ");
        sbU.append(audioDeviceInfo != null ? Integer.valueOf(audioDeviceInfo.getId()) : null);
        Logging.d(TAG, sbU.toString());
        this.preferredDevice = audioDeviceInfo;
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord == null || audioRecord.setPreferredDevice(audioDeviceInfo)) {
            return;
        }
        Logging.e(TAG, "setPreferredDevice failed");
    }

    public WebRtcAudioRecord(Context context, ScheduledExecutorService scheduledExecutorService, AudioManager audioManager, int i, int i2, @Nullable JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback, @Nullable JavaAudioDeviceModule.AudioRecordStateCallback audioRecordStateCallback, @Nullable JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback, boolean z2, boolean z3) {
        this.effects = new WebRtcAudioEffects();
        this.audioSourceMatchesRecordingSessionRef = new AtomicReference<>();
        if (z2 && !WebRtcAudioEffects.isAcousticEchoCancelerSupported()) {
            throw new IllegalArgumentException("HW AEC not supported");
        }
        if (z3 && !WebRtcAudioEffects.isNoiseSuppressorSupported()) {
            throw new IllegalArgumentException("HW NS not supported");
        }
        this.context = context;
        this.executor = scheduledExecutorService;
        this.audioManager = audioManager;
        this.audioSource = i;
        this.audioFormat = i2;
        this.errorCallback = audioRecordErrorCallback;
        this.stateCallback = audioRecordStateCallback;
        this.audioSamplesReadyCallback = samplesReadyCallback;
        this.isAcousticEchoCancelerSupported = z2;
        this.isNoiseSuppressorSupported = z3;
        StringBuilder sbU = outline.U("ctor");
        sbU.append(WebRtcAudioUtils.getThreadInfo());
        Logging.d(TAG, sbU.toString());
    }
}
