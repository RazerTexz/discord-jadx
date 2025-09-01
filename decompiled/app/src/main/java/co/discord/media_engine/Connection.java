package co.discord.media_engine;

import co.discord.media_engine.internal.TransformStats;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import org.webrtc.MediaStreamTrack;
import org.webrtc.VideoCapturer;

/* compiled from: Connection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0006nopqrsB\u0011\b\u0002\u0012\u0006\u0010g\u001a\u00020\u001a¢\u0006\u0004\bm\u0010$J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u0086 ¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0086 ¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0086 ¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0017H\u0086 ¢\u0006\u0004\b\u0018\u0010\u0019J@\u0010!\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000bH\u0086 ¢\u0006\u0004\b!\u0010\"J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0086 ¢\u0006\u0004\b#\u0010$J \u0010%\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u000bH\u0086 ¢\u0006\u0004\b%\u0010&J \u0010(\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\b(\u0010)J \u0010+\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\b+\u0010)J\u0018\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\b-\u0010\u0012J\u0018\u0010.\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\b.\u0010\u0012J\u0018\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0004H\u0086 ¢\u0006\u0004\b0\u00101J\u0018\u00102\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\b2\u0010\u0012J\u0018\u00103\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\b3\u0010\u0012J\u0018\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u000bH\u0086 ¢\u0006\u0004\b5\u0010\u000eJ<\u0010?\u001a\u00020\u00062\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u0002082\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0:H\u0086 ¢\u0006\u0004\b?\u0010@J\u0018\u0010B\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020AH\u0086 ¢\u0006\u0004\bB\u0010CJ\u0018\u0010E\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\bE\u0010\u0012J \u0010I\u001a\u00020\u00062\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020\u001aH\u0086 ¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020\u0006H\u0086 ¢\u0006\u0004\bK\u0010\nJ\u0018\u0010M\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u0004H\u0086 ¢\u0006\u0004\bM\u00101J\u0018\u0010O\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0004H\u0086 ¢\u0006\u0004\bO\u00101J\u0018\u0010P\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0004H\u0086 ¢\u0006\u0004\bP\u00101J\u0018\u0010R\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u000bH\u0086 ¢\u0006\u0004\bR\u0010\u000eJ\u0018\u0010T\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\u0004H\u0086 ¢\u0006\u0004\bT\u00101J\u0018\u0010V\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\bV\u0010\u0012J\u0018\u0010X\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\bX\u0010\u0012J8\u0010^\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u0004H\u0086 ¢\u0006\u0004\b^\u0010_J\u0015\u0010a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020`¢\u0006\u0004\ba\u0010bJ\u0015\u0010d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020c¢\u0006\u0004\bd\u0010eJ\u001d\u0010d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020c2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bd\u0010fR\u0019\u0010g\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010l¨\u0006t"}, d2 = {"Lco/discord/media_engine/Connection;", "", "Lco/discord/media_engine/Connection$GetStatsCallbackNative;", "callback", "", "filter", "", "getStatsNative", "(Lco/discord/media_engine/Connection$GetStatsCallbackNative;I)V", "dispose", "()V", "", "packetLossRate", "simulatePacketLoss", "(F)V", "", "enabled", "setQoS", "(Z)V", "Lco/discord/media_engine/EncryptionSettings;", "settings", "setEncryptionSettings", "(Lco/discord/media_engine/EncryptionSettings;)V", "Lco/discord/media_engine/Connection$EncryptionModesCallback;", "getEncryptionModes", "(Lco/discord/media_engine/Connection$EncryptionModesCallback;)V", "", "userId", "audioSsrc", "videoSsrc", "rtxSsrc", "isMuted", "volume", "connectUser", "(JIIIZF)V", "disconnectUser", "(J)V", "setUserPlayoutVolume", "(JF)V", "willBeMuted", "muteUser", "(JZ)V", "willBeDisabled", "disableVideo", "willBeDeafened", "deafenLocalUser", "muteLocalUser", "delayMs", "setMinimumPlayoutDelay", "(I)V", "enableForwardErrorCorrection", "enableDiscontinuousTransmission", "expectedPacketLossRate", "setExpectedPacketLossRate", "Lco/discord/media_engine/AudioEncoder;", "audioEncoder", "Lco/discord/media_engine/VideoEncoder;", "videoEncoder", "", "Lco/discord/media_engine/AudioDecoder;", "audioDecoders", "Lco/discord/media_engine/VideoDecoder;", "videoDecoder", "setCodecs", "(Lco/discord/media_engine/AudioEncoder;Lco/discord/media_engine/VideoEncoder;[Lco/discord/media_engine/AudioDecoder;[Lco/discord/media_engine/VideoDecoder;)V", "Lco/discord/media_engine/Connection$OnVideoCallback;", "setOnVideoCallback", "(Lco/discord/media_engine/Connection$OnVideoCallback;)V", "broadcastVideo", "setVideoBroadcast", "Lorg/webrtc/VideoCapturer;", "capturer", MediaStreamTrack.AUDIO_TRACK_KIND, "startScreenshareBroadcast", "(Lorg/webrtc/VideoCapturer;J)V", "stopScreenshareBroadcast", "mode", "setAudioInputMode", "numFrames", "setVADLeadingFramesToBuffer", "setVADTrailingFramesToSend", "thresholdDb", "setVADTriggerThreshold", "autoThreshold", "setVADAutoThreshold", "useKrisp", "setVADUseKrisp", "active", "setPTTActive", "minBitrate", "maxBitrate", "width", "height", "framerate", "setEncodingQuality", "(IIIII)V", "Lco/discord/media_engine/Connection$UserSpeakingStatusChangedCallback;", "setUserSpeakingStatusChangedCallback", "(Lco/discord/media_engine/Connection$UserSpeakingStatusChangedCallback;)V", "Lco/discord/media_engine/Connection$GetStatsCallback;", "getStats", "(Lco/discord/media_engine/Connection$GetStatsCallback;)V", "(Lco/discord/media_engine/Connection$GetStatsCallback;I)V", "nativeInstance", "J", "getNativeInstance", "()J", "userSpeakingStatusChangedCallback", "Lco/discord/media_engine/Connection$UserSpeakingStatusChangedCallback;", "<init>", "EncryptionModesCallback", "GetStatsCallback", "GetStatsCallbackNative", "OnVideoCallback", "StatsFilter", "UserSpeakingStatusChangedCallback", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class Connection {
    private final long nativeInstance;
    private UserSpeakingStatusChangedCallback userSpeakingStatusChangedCallback;

    /* compiled from: Connection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lco/discord/media_engine/Connection$EncryptionModesCallback;", "", "", "", "modes", "", "onEncryptionModes", "([Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface EncryptionModesCallback {
        void onEncryptionModes(String[] modes);
    }

    /* compiled from: Connection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lco/discord/media_engine/Connection$GetStatsCallback;", "", "Lco/discord/media_engine/Stats;", "stats", "", "onStats", "(Lco/discord/media_engine/Stats;)V", "", "t", "onStatsError", "(Ljava/lang/Throwable;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface GetStatsCallback {
        void onStats(Stats stats);

        void onStatsError(Throwable t);
    }

    /* compiled from: Connection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lco/discord/media_engine/Connection$GetStatsCallbackNative;", "", "", "stats", "", "onStats", "(Ljava/lang/String;)V", "Lco/discord/media_engine/Connection$GetStatsCallback;", "callback", "Lco/discord/media_engine/Connection$GetStatsCallback;", "getCallback", "()Lco/discord/media_engine/Connection$GetStatsCallback;", "<init>", "(Lco/discord/media_engine/Connection$GetStatsCallback;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class GetStatsCallbackNative {
        private final GetStatsCallback callback;

        public GetStatsCallbackNative(GetStatsCallback getStatsCallback) {
            Intrinsics3.checkNotNullParameter(getStatsCallback, "callback");
            this.callback = getStatsCallback;
        }

        public final GetStatsCallback getCallback() {
            return this.callback;
        }

        public final void onStats(String stats) {
            Intrinsics3.checkNotNullParameter(stats, "stats");
            try {
                this.callback.onStats(TransformStats.transform(stats));
            } catch (Exception e) {
                this.callback.onStatsError(e);
            }
        }
    }

    /* compiled from: Connection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lco/discord/media_engine/Connection$OnVideoCallback;", "", "", "userId", "", "ssrc", "", "streamIdentifier", "", "Lco/discord/media_engine/StreamParameters;", "streams", "", "onVideo", "(JILjava/lang/String;[Lco/discord/media_engine/StreamParameters;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface OnVideoCallback {
        void onVideo(long userId, int ssrc, String streamIdentifier, StreamParameters[] streams);
    }

    /* compiled from: Connection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lco/discord/media_engine/Connection$StatsFilter;", "", "<init>", "()V", "Companion", "android_release"}, k = 1, mv = {1, 4, 2})
    public static final class StatsFilter {
        public static final int ALL = -1;
        public static final int INBOUND = 4;
        public static final int OUTBOUND = 2;
        public static final int TRANSPORT = 1;
    }

    /* compiled from: Connection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lco/discord/media_engine/Connection$UserSpeakingStatusChangedCallback;", "", "", "userId", "", "isUserSpeakingNow", "wantsPriority", "", "onUserSpeakingStatusChanged", "(JZZ)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface UserSpeakingStatusChangedCallback {
        void onUserSpeakingStatusChanged(long userId, boolean isUserSpeakingNow, boolean wantsPriority);
    }

    private Connection(long j) {
        this.nativeInstance = j;
    }

    private final native void getStatsNative(GetStatsCallbackNative callback, int filter);

    public final native void connectUser(long userId, int audioSsrc, int videoSsrc, int rtxSsrc, boolean isMuted, float volume);

    public final native void deafenLocalUser(boolean willBeDeafened);

    public final native void disableVideo(long userId, boolean willBeDisabled);

    public final native void disconnectUser(long userId);

    public final native void dispose();

    public final native void enableDiscontinuousTransmission(boolean enabled);

    public final native void enableForwardErrorCorrection(boolean enabled);

    public final native void getEncryptionModes(EncryptionModesCallback callback);

    public final long getNativeInstance() {
        return this.nativeInstance;
    }

    public final void getStats(GetStatsCallback callback) {
        Intrinsics3.checkNotNullParameter(callback, "callback");
        getStatsNative(new GetStatsCallbackNative(callback), -1);
    }

    public final native void muteLocalUser(boolean willBeMuted);

    public final native void muteUser(long userId, boolean willBeMuted);

    public final native void setAudioInputMode(int mode);

    public final native void setCodecs(Codecs3 audioEncoder, Codecs5 videoEncoder, Codecs2[] audioDecoders, Codecs4[] videoDecoder);

    public final native void setEncodingQuality(int minBitrate, int maxBitrate, int width, int height, int framerate);

    public final native void setEncryptionSettings(EncryptionSettings settings);

    public final native void setExpectedPacketLossRate(float expectedPacketLossRate);

    public final native void setMinimumPlayoutDelay(int delayMs);

    public final native void setOnVideoCallback(OnVideoCallback callback);

    public final native void setPTTActive(boolean active);

    public final native void setQoS(boolean enabled);

    public final native void setUserPlayoutVolume(long userId, float volume);

    public final void setUserSpeakingStatusChangedCallback(UserSpeakingStatusChangedCallback callback) {
        Intrinsics3.checkNotNullParameter(callback, "callback");
        this.userSpeakingStatusChangedCallback = callback;
    }

    public final native void setVADAutoThreshold(int autoThreshold);

    public final native void setVADLeadingFramesToBuffer(int numFrames);

    public final native void setVADTrailingFramesToSend(int numFrames);

    public final native void setVADTriggerThreshold(float thresholdDb);

    public final native void setVADUseKrisp(boolean useKrisp);

    public final native void setVideoBroadcast(boolean broadcastVideo);

    public final native void simulatePacketLoss(float packetLossRate);

    public final native void startScreenshareBroadcast(VideoCapturer capturer, long audio);

    public final native void stopScreenshareBroadcast();

    public final void getStats(GetStatsCallback callback, int filter) {
        Intrinsics3.checkNotNullParameter(callback, "callback");
        getStatsNative(new GetStatsCallbackNative(callback), filter);
    }
}
