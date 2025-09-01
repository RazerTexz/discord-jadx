package com.discord.p000native.engine;

import android.content.Context;
import co.discord.media_engine.CameraEnumeratorProvider;
import co.discord.media_engine.SharedEglBaseContext;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import org.webrtc.EglBase;
import org.webrtc.VideoFrame;

/* compiled from: NativeEngine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 Z2\u00020\u0001:\fZ[\\]^_`abcdeB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\bX\u0010YJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0082 ¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0082 ¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0086 ¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0086 ¢\u0006\u0004\b\u0017\u0010\u0016J(\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0086 ¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0006H\u0086 ¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\b$\u0010\u0012J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020%H\u0086 ¢\u0006\u0004\b&\u0010'J\u0018\u0010(\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0006H\u0086 ¢\u0006\u0004\b(\u0010#J\u0018\u0010)\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\b)\u0010\u0012J\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020*H\u0086 ¢\u0006\u0004\b+\u0010,J\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0006H\u0086 ¢\u0006\u0004\b-\u0010#J\u0018\u0010.\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000fH\u0086 ¢\u0006\u0004\b.\u0010\u0012J\u0018\u00100\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020/H\u0086 ¢\u0006\u0004\b0\u00101J\"\u00104\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u000103H\u0086 ¢\u0006\u0004\b4\u00105J\u0018\u00107\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u0013H\u0086 ¢\u0006\u0004\b7\u0010\u0016J\u0018\u00109\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u000208H\u0086 ¢\u0006\u0004\b9\u0010:J\u0018\u0010<\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020;H\u0086 ¢\u0006\u0004\b<\u0010=J\u0018\u0010?\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020>H\u0086 ¢\u0006\u0004\b?\u0010@J\u0018\u0010B\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020AH\u0086 ¢\u0006\u0004\bB\u0010CJ \u0010F\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020EH\u0086 ¢\u0006\u0004\bF\u0010GJ\u0018\u0010H\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0086 ¢\u0006\u0004\bH\u0010IJ\u0018\u0010J\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0086 ¢\u0006\u0004\bJ\u0010IJH\u0010S\u001a\u00020R2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020QH\u0086 ¢\u0006\u0004\bS\u0010TR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010UR\u0016\u0010V\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006f"}, d2 = {"Lcom/discord/native/engine/NativeEngine;", "", "Landroid/content/Context;", "context", "Lorg/webrtc/EglBase$Context;", "eglContext", "", "logLevel", "", "nativeCreateInstance", "(Landroid/content/Context;Lorg/webrtc/EglBase$Context;I)J", "", "nativeDestroyInstance", "()V", "dispose", "", "optionsJSON", "setTransportOptions", "(Ljava/lang/String;)V", "", "volume", "setInputVolume", "(F)V", "setOutputVolume", "", "enable", "playback", "setEmitVADLevel", "(ZZLjava/lang/String;)V", "Lcom/discord/native/engine/NativeEngine$GetAudioInputDevicesCallback;", "callback", "getInputDevices", "(Lcom/discord/native/engine/NativeEngine$GetAudioInputDevicesCallback;)V", "deviceIndex", "setInputDeviceIndex", "(I)V", "setInputDevice", "Lcom/discord/native/engine/NativeEngine$GetAudioOutputDevicesCallback;", "getOutputDevices", "(Lcom/discord/native/engine/NativeEngine$GetAudioOutputDevicesCallback;)V", "setOutputDeviceIndex", "setOutputDevice", "Lcom/discord/native/engine/NativeEngine$GetVideoInputDevicesCallback;", "getVideoInputDevices", "(Lcom/discord/native/engine/NativeEngine$GetVideoInputDevicesCallback;)V", "setVideoInputDeviceIndex", "setVideoInputDevice", "Lcom/discord/native/engine/NativeEngine$DeviceChangeCallback;", "setOnDeviceChangeCallback", "(Lcom/discord/native/engine/NativeEngine$DeviceChangeCallback;)V", "streamIdentifier", "Lcom/discord/native/engine/NativeEngine$VideoFrameCallback;", "setVideoOutputSink", "(Ljava/lang/String;Lcom/discord/native/engine/NativeEngine$VideoFrameCallback;)V", "threshold", "setNoInputThreshold", "Lcom/discord/native/engine/NativeEngine$OnNoInputCallback;", "setOnNoInputCallback", "(Lcom/discord/native/engine/NativeEngine$OnNoInputCallback;)V", "Lcom/discord/native/engine/NativeEngine$OnVoiceCallback;", "setOnVoiceCallback", "(Lcom/discord/native/engine/NativeEngine$OnVoiceCallback;)V", "Lcom/discord/native/engine/NativeEngine$GetAudioSubsystemCallback;", "getAudioSubsystem", "(Lcom/discord/native/engine/NativeEngine$GetAudioSubsystemCallback;)V", "Lcom/discord/native/engine/NativeEngine$GetSupportedVideoCodecsCallback;", "getSupportedVideoCodecs", "(Lcom/discord/native/engine/NativeEngine$GetSupportedVideoCodecsCallback;)V", "regionsWithIpsJSON", "Lcom/discord/native/engine/NativeEngine$GetRankedRtcRegionsCallback;", "rankRtcRegions", "(Ljava/lang/String;Lcom/discord/native/engine/NativeEngine$GetRankedRtcRegionsCallback;)V", "enableBuiltInAEC", "(Z)V", "setAudioInputEnabled", "ssrc", "userId", "serverIp", "port", "experimentsJSON", "streamParametersJSON", "Lcom/discord/native/engine/NativeEngine$ConnectToServerCallback;", "Lcom/discord/native/engine/NativeConnection;", "createVoiceConnection", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/discord/native/engine/NativeEngine$ConnectToServerCallback;)Lcom/discord/native/engine/NativeConnection;", "I", "nativeInstance", "J", "<init>", "(Landroid/content/Context;I)V", "Companion", "ConnectToServerCallback", "DeviceChangeCallback", "GetAudioInputDevicesCallback", "GetAudioOutputDevicesCallback", "GetAudioSubsystemCallback", "GetRankedRtcRegionsCallback", "GetSupportedVideoCodecsCallback", "GetVideoInputDevicesCallback", "OnNoInputCallback", "OnVoiceCallback", "VideoFrameCallback", "android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class NativeEngine {
    public static final int LOGLEVEL_DEBUG = 2;
    public static final int LOGLEVEL_DEFAULT = -1;
    private final int logLevel;
    private final long nativeInstance;

    /* compiled from: NativeEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/discord/native/engine/NativeEngine$ConnectToServerCallback;", "", "Lcom/discord/native/engine/ConnectionInfo;", "info", "", "error", "", "onConnectToServer", "(Lcom/discord/native/engine/ConnectionInfo;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface ConnectToServerCallback {
        void onConnectToServer(ConnectionInfo info, String error);
    }

    /* compiled from: NativeEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J9\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/discord/native/engine/NativeEngine$DeviceChangeCallback;", "", "", "Lcom/discord/native/engine/AudioInputDeviceDescription;", "audioInputDevices", "Lcom/discord/native/engine/AudioOutputDeviceDescription;", "audioOutputDevices", "Lcom/discord/native/engine/VideoInputDeviceDescription;", "videoInputDevices", "", "onChange", "([Lcom/discord/native/engine/AudioInputDeviceDescription;[Lcom/discord/native/engine/AudioOutputDeviceDescription;[Lcom/discord/native/engine/VideoInputDeviceDescription;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface DeviceChangeCallback {
        void onChange(AudioInputDeviceDescription[] audioInputDevices, AudioOutputDeviceDescription[] audioOutputDevices, VideoInputDeviceDescription[] videoInputDevices);
    }

    /* compiled from: NativeEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/native/engine/NativeEngine$GetAudioInputDevicesCallback;", "", "", "Lcom/discord/native/engine/AudioInputDeviceDescription;", "devices", "", "onDevices", "([Lcom/discord/native/engine/AudioInputDeviceDescription;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface GetAudioInputDevicesCallback {
        void onDevices(AudioInputDeviceDescription[] devices);
    }

    /* compiled from: NativeEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/native/engine/NativeEngine$GetAudioOutputDevicesCallback;", "", "", "Lcom/discord/native/engine/AudioOutputDeviceDescription;", "devices", "", "onDevices", "([Lcom/discord/native/engine/AudioOutputDeviceDescription;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface GetAudioOutputDevicesCallback {
        void onDevices(AudioOutputDeviceDescription[] devices);
    }

    /* compiled from: NativeEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/native/engine/NativeEngine$GetAudioSubsystemCallback;", "", "", "subsystem", "audioLayer", "", "onAudioSubsystem", "(Ljava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface GetAudioSubsystemCallback {
        void onAudioSubsystem(String subsystem, String audioLayer);
    }

    /* compiled from: NativeEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/native/engine/NativeEngine$GetRankedRtcRegionsCallback;", "", "", "", "regions", "", "onRankedRtcRegions", "([Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface GetRankedRtcRegionsCallback {
        void onRankedRtcRegions(String[] regions);
    }

    /* compiled from: NativeEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/native/engine/NativeEngine$GetSupportedVideoCodecsCallback;", "", "", "", "codecs", "", "onSupportedVideoCodecs", "([Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface GetSupportedVideoCodecsCallback {
        void onSupportedVideoCodecs(String[] codecs);
    }

    /* compiled from: NativeEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/discord/native/engine/NativeEngine$GetVideoInputDevicesCallback;", "", "", "Lcom/discord/native/engine/VideoInputDeviceDescription;", "devices", "", "onDevices", "([Lcom/discord/native/engine/VideoInputDeviceDescription;)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface GetVideoInputDevicesCallback {
        void onDevices(VideoInputDeviceDescription[] devices);
    }

    /* compiled from: NativeEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/native/engine/NativeEngine$OnNoInputCallback;", "", "", "input", "", "onNoInput", "(Z)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface OnNoInputCallback {
        void onNoInput(boolean input);
    }

    /* compiled from: NativeEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/discord/native/engine/NativeEngine$OnVoiceCallback;", "", "", "level", "", "speaking", "", "onVoice", "(FI)V", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface OnVoiceCallback {
        void onVoice(float level, int speaking);
    }

    /* compiled from: NativeEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/native/engine/NativeEngine$VideoFrameCallback;", "", "Lorg/webrtc/VideoFrame;", "frame", "", "onFrame", "(Lorg/webrtc/VideoFrame;)Z", "android_release"}, k = 1, mv = {1, 4, 2})
    public interface VideoFrameCallback {
        boolean onFrame(VideoFrame frame);
    }

    static {
        System.loadLibrary("discord");
    }

    public NativeEngine(Context context, int i) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.logLevel = i;
        Context applicationContext = context.getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        CameraEnumeratorProvider.maybeInit(applicationContext);
        Context applicationContext2 = context.getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
        EglBase.Context eglContext = SharedEglBaseContext.getEglContext();
        Intrinsics3.checkNotNullExpressionValue(eglContext, "SharedEglBaseContext.getEglContext()");
        this.nativeInstance = nativeCreateInstance(applicationContext2, eglContext, i);
    }

    private final native long nativeCreateInstance(Context context, EglBase.Context eglContext, int logLevel);

    private final native void nativeDestroyInstance();

    public final native NativeConnection createVoiceConnection(long ssrc, String userId, String serverIp, int port, String experimentsJSON, String streamParametersJSON, ConnectToServerCallback callback);

    public final void dispose() {
        nativeDestroyInstance();
    }

    public final native void enableBuiltInAEC(boolean enable);

    public final native void getAudioSubsystem(GetAudioSubsystemCallback callback);

    public final native void getInputDevices(GetAudioInputDevicesCallback callback);

    public final native void getOutputDevices(GetAudioOutputDevicesCallback callback);

    public final native void getSupportedVideoCodecs(GetSupportedVideoCodecsCallback callback);

    public final native void getVideoInputDevices(GetVideoInputDevicesCallback callback);

    public final native void rankRtcRegions(String regionsWithIpsJSON, GetRankedRtcRegionsCallback callback);

    public final native void setAudioInputEnabled(boolean enable);

    public final native void setEmitVADLevel(boolean enable, boolean playback, String optionsJSON);

    public final native void setInputDevice(String deviceIndex);

    public final native void setInputDeviceIndex(int deviceIndex);

    public final native void setInputVolume(float volume);

    public final native void setNoInputThreshold(float threshold);

    public final native void setOnDeviceChangeCallback(DeviceChangeCallback callback);

    public final native void setOnNoInputCallback(OnNoInputCallback callback);

    public final native void setOnVoiceCallback(OnVoiceCallback callback);

    public final native void setOutputDevice(String deviceIndex);

    public final native void setOutputDeviceIndex(int deviceIndex);

    public final native void setOutputVolume(float volume);

    public final native void setTransportOptions(String optionsJSON);

    public final native void setVideoInputDevice(String deviceIndex);

    public final native void setVideoInputDeviceIndex(int deviceIndex);

    public final native void setVideoOutputSink(String streamIdentifier, VideoFrameCallback callback);
}
