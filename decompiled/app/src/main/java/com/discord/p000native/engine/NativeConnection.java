package com.discord.p000native.engine;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.Metadata;
import org.webrtc.VideoCapturer;

/* compiled from: NativeConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0006XYZ[\\]B\u0007¢\u0006\u0004\bW\u0010\u0004J\u0010\u0010\u0003\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0086 ¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0086 ¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0086 ¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002H\u0086 ¢\u0006\u0004\b\u0019\u0010\u0004J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0086 ¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0006H\u0086 ¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0006H\u0086 ¢\u0006\u0004\b\"\u0010 J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0006H\u0086 ¢\u0006\u0004\b$\u0010 J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\bH\u0086 ¢\u0006\u0004\b&\u0010'J(\u0010+\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(H\u0086 ¢\u0006\u0004\b+\u0010,J \u0010.\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00062\u0006\u0010-\u001a\u00020(H\u0086 ¢\u0006\u0004\b.\u0010/J \u00101\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00062\u0006\u00100\u001a\u00020\bH\u0086 ¢\u0006\u0004\b1\u00102J\u0018\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u00020\bH\u0086 ¢\u0006\u0004\b4\u0010'J\u0018\u00106\u001a\u00020\u00022\u0006\u00105\u001a\u00020\bH\u0086 ¢\u0006\u0004\b6\u0010'J\u0018\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u00020\rH\u0086 ¢\u0006\u0004\b8\u00109J\u0018\u0010;\u001a\u00020\u00022\u0006\u0010:\u001a\u00020(H\u0086 ¢\u0006\u0004\b;\u0010<J \u0010?\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\bH\u0086 ¢\u0006\u0004\b?\u0010@J\u0018\u0010B\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020AH\u0086 ¢\u0006\u0004\bB\u0010CJ\u0018\u0010E\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\rH\u0086 ¢\u0006\u0004\bE\u00109J \u0010G\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020AH\u0086 ¢\u0006\u0004\bG\u0010HJ\u0018\u0010J\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020IH\u0086 ¢\u0006\u0004\bJ\u0010KJ\u0018\u0010M\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020LH\u0086 ¢\u0006\u0004\bM\u0010NJ\u0018\u0010P\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020OH\u0086 ¢\u0006\u0004\bP\u0010QJ\u0018\u0010S\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020RH\u0086 ¢\u0006\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020\u00158\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006^"}, d2 = {"Lcom/discord/native/engine/NativeConnection;", "", "", "nativeDestroyInstance", "()V", "dispose", "", "stringId", "", "useVideoHook", "type", "setDesktopSource", "(Ljava/lang/String;ZLjava/lang/String;)V", "", "baseDelayMs", "maxDelayMs", "maxAttempts", "configureConnectionRetries", "(III)V", "Lorg/webrtc/VideoCapturer;", "capturer", "", "soundshareNativeInstance", "startBroadcast", "(Lorg/webrtc/VideoCapturer;J)V", "stopBroadcast", "Lcom/discord/native/engine/NativeConnection$GetEncryptionModesCallback;", "callback", "getEncryptionModes", "(Lcom/discord/native/engine/NativeConnection$GetEncryptionModesCallback;)V", "optionsJSON", "setTransportOptions", "(Ljava/lang/String;)V", "usersJSON", "mergeUsers", "userId", "destroyUser", "broadcasting", "setVideoBroadcast", "(Z)V", "", "left", "right", "setLocalPan", "(Ljava/lang/String;FF)V", "volume", "setLocalVolume", "(Ljava/lang/String;F)V", ModelAuditLogEntry.CHANGE_KEY_MUTE, "setLocalMute", "(Ljava/lang/String;Z)V", "muted", "setSelfMute", "deafened", "setSelfDeafen", "delay", "setMinimumOutputDelay", "(I)V", "threshold", "setNoInputThreshold", "(F)V", "active", "priority", "setPTTActive", "(ZZ)V", "Lcom/discord/native/engine/NativeConnection$GetStatsCallback;", "getStats", "(Lcom/discord/native/engine/NativeConnection$GetStatsCallback;)V", "pingInterval", "setPingInterval", "filter", "getFilteredStats", "(ILcom/discord/native/engine/NativeConnection$GetStatsCallback;)V", "Lcom/discord/native/engine/NativeConnection$OnSpeakingCallback;", "setOnSpeakingCallback", "(Lcom/discord/native/engine/NativeConnection$OnSpeakingCallback;)V", "Lcom/discord/native/engine/NativeConnection$OnPingCallback;", "setOnPingCallback", "(Lcom/discord/native/engine/NativeConnection$OnPingCallback;)V", "Lcom/discord/native/engine/NativeConnection$OnPingTimeoutCallback;", "setOnPingTimeoutCallback", "(Lcom/discord/native/engine/NativeConnection$OnPingTimeoutCallback;)V", "Lcom/discord/native/engine/NativeConnection$OnVideoCallback;", "setOnVideoCallback", "(Lcom/discord/native/engine/NativeConnection$OnVideoCallback;)V", "nativeInstance", "J", "<init>", "GetEncryptionModesCallback", "GetStatsCallback", "OnPingCallback", "OnPingTimeoutCallback", "OnSpeakingCallback", "OnVideoCallback", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class NativeConnection {
    private final long nativeInstance;

    /* compiled from: NativeConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/native/engine/NativeConnection$GetEncryptionModesCallback;", "", "", "", "modes", "", "onEncryptionModes", "([Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface GetEncryptionModesCallback {
        void onEncryptionModes(String[] modes);
    }

    /* compiled from: NativeConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/native/engine/NativeConnection$GetStatsCallback;", "", "", "stats", "", "onStats", "(Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface GetStatsCallback {
        void onStats(String stats);
    }

    /* compiled from: NativeConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/discord/native/engine/NativeConnection$OnPingCallback;", "", "", "ping", "", "server", "port", "seq", "", "onPing", "(ILjava/lang/String;II)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface OnPingCallback {
        void onPing(int ping, String server, int port, int seq);
    }

    /* compiled from: NativeConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/discord/native/engine/NativeConnection$OnPingTimeoutCallback;", "", "", "server", "", "port", "seq", "timeout", "", "onPingTimeout", "(Ljava/lang/String;III)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface OnPingTimeoutCallback {
        void onPingTimeout(String server, int port, int seq, int timeout);
    }

    /* compiled from: NativeConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/discord/native/engine/NativeConnection$OnSpeakingCallback;", "", "", "userId", "", "speakingFlags", "", "onSpeaking", "(Ljava/lang/String;I)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface OnSpeakingCallback {
        void onSpeaking(String userId, int speakingFlags);
    }

    /* compiled from: NativeConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/discord/native/engine/NativeConnection$OnVideoCallback;", "", "", "userId", "", "ssrc", "streamId", "videoStreamParametersJson", "", "onVideo", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface OnVideoCallback {
        void onVideo(String userId, long ssrc, String streamId, String videoStreamParametersJson);
    }

    private final native void nativeDestroyInstance();

    public final native void configureConnectionRetries(int baseDelayMs, int maxDelayMs, int maxAttempts);

    public final native void destroyUser(String userId);

    public final void dispose() {
        nativeDestroyInstance();
    }

    public final native void getEncryptionModes(GetEncryptionModesCallback callback);

    public final native void getFilteredStats(int filter, GetStatsCallback callback);

    public final native void getStats(GetStatsCallback callback);

    public final native void mergeUsers(String usersJSON);

    public final native void setDesktopSource(String stringId, boolean useVideoHook, String type);

    public final native void setLocalMute(String userId, boolean mute);

    public final native void setLocalPan(String userId, float left, float right);

    public final native void setLocalVolume(String userId, float volume);

    public final native void setMinimumOutputDelay(int delay);

    public final native void setNoInputThreshold(float threshold);

    public final native void setOnPingCallback(OnPingCallback callback);

    public final native void setOnPingTimeoutCallback(OnPingTimeoutCallback callback);

    public final native void setOnSpeakingCallback(OnSpeakingCallback callback);

    public final native void setOnVideoCallback(OnVideoCallback callback);

    public final native void setPTTActive(boolean active, boolean priority);

    public final native void setPingInterval(int pingInterval);

    public final native void setSelfDeafen(boolean deafened);

    public final native void setSelfMute(boolean muted);

    public final native void setTransportOptions(String optionsJSON);

    public final native void setVideoBroadcast(boolean broadcasting);

    public final native void startBroadcast(VideoCapturer capturer, long soundshareNativeInstance);

    public final native void stopBroadcast();
}
