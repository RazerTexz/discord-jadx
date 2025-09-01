package co.discord.media_engine;

import android.media.AudioRecord;
import android.os.Process;
import android.util.Log;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.ThreadUtils;
import org.webrtc.TimestampAligner;

/* compiled from: SoundshareAudioSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u000276B\u0007¢\u0006\u0004\b5\u0010+J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0082 ¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0082 ¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0015\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0007H\u0082 ¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H\u0082 ¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b \u0010\u001eJ\u0015\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020#¢\u0006\u0004\b&\u0010'J%\u0010(\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\t¢\u0006\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010.\u001a\u0004\b/\u0010\u0018R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u00100R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u00101R\u001c\u00103\u001a\b\u0018\u000102R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lco/discord/media_engine/SoundshareAudioSource;", "", "", "channels", "channelCountToConfiguration", "(I)I", "bytes", "", "timestampNanos", "", "dataIsRecorded", "(IJ)V", "nativeInstance", "Ljava/nio/ByteBuffer;", "byteBuffer", "nativeCacheDirectBufferAddress", "(JLjava/nio/ByteBuffer;)V", "nativeDataIsRecorded", "(JIJ)V", "sampleRate", "bitDepth", "nativeSetSampleFormat", "(JIII)V", "nativeCreateInstance", "()J", "nativeDestroyInstance", "(J)V", "", "errorMessage", "reportSoundshareAudioSourceInitError", "(Ljava/lang/String;)V", "reportSoundshareAudioSourceStartError", "reportSoundshareAudioSourceError", "Landroid/media/AudioRecord;", "audioRecord", "", "startRecording", "(Landroid/media/AudioRecord;)Z", "stopRecording", "()Z", "setSampleFormat", "(III)V", "release", "()V", "released", "Z", "J", "getNativeInstance", "Landroid/media/AudioRecord;", "Ljava/nio/ByteBuffer;", "Lco/discord/media_engine/SoundshareAudioSource$AudioRecordThread;", "audioThread", "Lco/discord/media_engine/SoundshareAudioSource$AudioRecordThread;", "<init>", "Companion", "AudioRecordThread", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class SoundshareAudioSource {
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "SoundshareAudioSource";
    private static volatile boolean microphoneMute;
    private AudioRecord audioRecord;
    private AudioRecordThread audioThread;
    private ByteBuffer byteBuffer;
    private final long nativeInstance = nativeCreateInstance();
    private boolean released;

    /* compiled from: SoundshareAudioSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lco/discord/media_engine/SoundshareAudioSource$AudioRecordThread;", "Ljava/lang/Thread;", "", "run", "()V", "stopThread", "", "timestamp", "J", "", "emptyBytes", "[B", "Ljava/nio/ByteBuffer;", "byteBuffer", "Ljava/nio/ByteBuffer;", "", "keepAlive", "Z", "Landroid/media/AudioRecord;", "audioRecord", "Landroid/media/AudioRecord;", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "<init>", "(Lco/discord/media_engine/SoundshareAudioSource;Ljava/lang/String;Landroid/media/AudioRecord;Ljava/nio/ByteBuffer;J)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public final class AudioRecordThread extends Thread {
        private final AudioRecord audioRecord;
        private final ByteBuffer byteBuffer;
        private final byte[] emptyBytes;
        private volatile boolean keepAlive;
        public final /* synthetic */ SoundshareAudioSource this$0;
        private long timestamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudioRecordThread(SoundshareAudioSource soundshareAudioSource, String str, AudioRecord audioRecord, ByteBuffer byteBuffer, long j) {
            super(str);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(audioRecord, "audioRecord");
            Intrinsics3.checkNotNullParameter(byteBuffer, "byteBuffer");
            this.this$0 = soundshareAudioSource;
            this.audioRecord = audioRecord;
            this.byteBuffer = byteBuffer;
            this.timestamp = j;
            this.keepAlive = true;
            this.emptyBytes = new byte[byteBuffer.capacity()];
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws IllegalStateException, SecurityException, IllegalArgumentException {
            Process.setThreadPriority(-19);
            Companion.access$assertTrue(SoundshareAudioSource.INSTANCE, this.audioRecord.getRecordingState() == 3);
            while (this.keepAlive) {
                AudioRecord audioRecord = this.audioRecord;
                ByteBuffer byteBuffer = this.byteBuffer;
                int i = audioRecord.read(byteBuffer, byteBuffer.capacity());
                this.timestamp = TimestampAligner.getRtcTimeNanos();
                if (i == this.byteBuffer.capacity()) {
                    if (SoundshareAudioSource.access$getMicrophoneMute$cp()) {
                        this.byteBuffer.clear();
                        this.byteBuffer.put(this.emptyBytes);
                    }
                    if (this.keepAlive) {
                        SoundshareAudioSource.access$dataIsRecorded(this.this$0, i, this.timestamp);
                    }
                } else {
                    String str = "AudioRecord.read failed: " + i;
                    Log.e(SoundshareAudioSource.TAG, str);
                    if (i == -3) {
                        this.keepAlive = false;
                        SoundshareAudioSource.access$reportSoundshareAudioSourceError(this.this$0, str);
                    }
                }
            }
            try {
                this.audioRecord.stop();
            } catch (IllegalStateException e) {
                StringBuilder sbU = outline.U("AudioRecord.stop failed: ");
                sbU.append(e.getMessage());
                Log.e(SoundshareAudioSource.TAG, sbU.toString());
            }
        }

        public final void stopThread() {
            this.keepAlive = false;
        }
    }

    /* compiled from: SoundshareAudioSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lco/discord/media_engine/SoundshareAudioSource$Companion;", "", "", "condition", "", "assertTrue", "(Z)V", ModelAuditLogEntry.CHANGE_KEY_MUTE, "setMicrophoneMute", "", "AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS", "J", "", "BITS_PER_SAMPLE", "I", "BUFFERS_PER_SECOND", "BUFFER_SIZE_FACTOR", "CALLBACK_BUFFER_SIZE_MS", "", "TAG", "Ljava/lang/String;", "microphoneMute", "Z", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ void access$assertTrue(Companion companion, boolean z2) {
            companion.assertTrue(z2);
        }

        private final void assertTrue(boolean condition) {
            if (!condition) {
                throw new AssertionError("Expected condition to be true");
            }
        }

        public final void setMicrophoneMute(boolean mute) {
            Log.w(SoundshareAudioSource.TAG, "setMicrophoneMute(" + mute + ')');
            SoundshareAudioSource.access$setMicrophoneMute$cp(mute);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ void access$dataIsRecorded(SoundshareAudioSource soundshareAudioSource, int i, long j) {
        soundshareAudioSource.dataIsRecorded(i, j);
    }

    public static final /* synthetic */ boolean access$getMicrophoneMute$cp() {
        return microphoneMute;
    }

    public static final /* synthetic */ void access$reportSoundshareAudioSourceError(SoundshareAudioSource soundshareAudioSource, String str) {
        soundshareAudioSource.reportSoundshareAudioSourceError(str);
    }

    public static final /* synthetic */ void access$setMicrophoneMute$cp(boolean z2) {
        microphoneMute = z2;
    }

    private final int channelCountToConfiguration(int channels) {
        return channels == 1 ? 16 : 12;
    }

    private final synchronized void dataIsRecorded(int bytes, long timestampNanos) {
        if (!this.released) {
            nativeDataIsRecorded(this.nativeInstance, bytes, timestampNanos);
        }
    }

    private final native synchronized void nativeCacheDirectBufferAddress(long nativeInstance, ByteBuffer byteBuffer);

    private final native synchronized long nativeCreateInstance();

    private final native void nativeDataIsRecorded(long nativeInstance, int bytes, long timestampNanos);

    private final native synchronized void nativeDestroyInstance(long nativeInstance);

    private final native void nativeSetSampleFormat(long nativeInstance, int sampleRate, int bitDepth, int channels);

    private final void reportSoundshareAudioSourceError(String errorMessage) {
        Log.e(TAG, "Run-time recording error: " + errorMessage);
    }

    private final void reportSoundshareAudioSourceInitError(String errorMessage) {
        Log.e(TAG, "Init recording error: " + errorMessage);
    }

    private final void reportSoundshareAudioSourceStartError(String errorMessage) {
        Log.e(TAG, "Start recording error: " + errorMessage);
    }

    public final long getNativeInstance() {
        return this.nativeInstance;
    }

    public final synchronized void release() {
        if (!this.released) {
            AudioRecord audioRecord = this.audioRecord;
            if (audioRecord != null) {
                audioRecord.release();
            }
            this.audioRecord = null;
            nativeDestroyInstance(this.nativeInstance);
            this.released = true;
        }
    }

    public final void setSampleFormat(int sampleRate, int bitDepth, int channels) {
        nativeSetSampleFormat(this.nativeInstance, sampleRate, bitDepth, channels);
    }

    public final boolean startRecording(AudioRecord audioRecord) {
        Intrinsics3.checkNotNullParameter(audioRecord, "audioRecord");
        int channelCount = audioRecord.getChannelCount();
        int sampleRate = audioRecord.getSampleRate();
        if (this.audioRecord != null) {
            reportSoundshareAudioSourceInitError("StartRecording called twice without StopRecording.");
            return false;
        }
        this.audioRecord = audioRecord;
        setSampleFormat(sampleRate, 16, channelCount);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((sampleRate / 100) * channelCount * 2);
        this.byteBuffer = byteBufferAllocateDirect;
        nativeCacheDirectBufferAddress(this.nativeInstance, byteBufferAllocateDirect);
        int minBufferSize = AudioRecord.getMinBufferSize(sampleRate, channelCountToConfiguration(channelCount), 2);
        if (minBufferSize == -1 || minBufferSize == -2) {
            reportSoundshareAudioSourceInitError(outline.q("AudioRecord.getMinBufferSize failed: ", minBufferSize));
            return false;
        }
        Math.max(minBufferSize * 2, byteBufferAllocateDirect.capacity());
        if (audioRecord.getState() != 1) {
            reportSoundshareAudioSourceInitError("Failed to create a new AudioRecord instance");
            release();
            return false;
        }
        try {
            try {
                Companion.access$assertTrue(INSTANCE, this.audioThread == null);
                long rtcTimeNanos = TimestampAligner.getRtcTimeNanos();
                try {
                    audioRecord.startRecording();
                    if (audioRecord.getRecordingState() != 3) {
                        reportSoundshareAudioSourceStartError("AudioRecord.startRecording failed - incorrect state :" + audioRecord.getRecordingState());
                        return false;
                    }
                    Intrinsics3.checkNotNullExpressionValue(byteBufferAllocateDirect, "byteBuffer");
                    AudioRecordThread audioRecordThread = new AudioRecordThread(this, "SoundshareThread", audioRecord, byteBufferAllocateDirect, rtcTimeNanos);
                    this.audioThread = audioRecordThread;
                    Intrinsics3.checkNotNull(audioRecordThread);
                    audioRecordThread.start();
                    return true;
                } catch (IllegalStateException e) {
                    reportSoundshareAudioSourceStartError("AudioRecord.startRecording failed: " + e.getMessage());
                    return false;
                }
            } catch (Throwable th) {
                Log.e(TAG, "WebrtcAudioRecord.startRecording: audioThread != null!", th);
                throw th;
            }
        } catch (Throwable th2) {
            Log.e(TAG, "SoundshareAudioSource.startRecording fail hard!", th2);
            throw th2;
        }
    }

    public final boolean stopRecording() {
        AudioRecordThread audioRecordThread = this.audioThread;
        if (audioRecordThread == null) {
            return false;
        }
        audioRecordThread.stopThread();
        if (!ThreadUtils.joinUninterruptibly(audioRecordThread, AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS)) {
            Log.e(TAG, "Join of SoundshareThread timed out");
        }
        this.audioThread = null;
        return true;
    }
}
