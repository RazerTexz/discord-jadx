package com.discord.rtcconnection.mediaengine;

import androidx.annotation.AnyThread;
import androidx.core.app.FrameMetricsAggregator;
import b.a.q.MediaEngineExecutorService;
import b.d.b.a.outline;
import co.discord.media_engine.DeviceDescription4;
import co.discord.media_engine.RtcRegion;
import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.hammerandchisel.libdiscord.Discord;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: MediaEngine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001:\t=\b/>:?@ABJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\b\u0010\tJA\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0011j\u0002`\u0012\u0012\u0004\u0012\u00020\u00070\u0010H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J)\u0010)\u001a\u00020\u00072\u0018\u0010(\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&\u0012\u0004\u0012\u00020\u00070\u0010H&¢\u0006\u0004\b)\u0010*J7\u0010/\u001a\u00020\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0&2\u0018\u0010.\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0&\u0012\u0004\u0012\u00020\u00070\u0010H&¢\u0006\u0004\b/\u00100J%\u00103\u001a\u00020\u00072\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010H&¢\u0006\u0004\b3\u0010*J\u0011\u00105\u001a\u0004\u0018\u000104H&¢\u0006\u0004\b5\u00106J\u0015\u00108\u001a\b\u0012\u0004\u0012\u0002070\u0006H&¢\u0006\u0004\b8\u0010\tR\u0016\u0010<\u001a\u0002098&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006C"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngine;", "", "", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection;", "getConnections", "()Ljava/util/List;", "Lrx/Observable;", "", "a", "()Lrx/Observable;", "", "userId", "Lcom/discord/rtcconnection/mediaengine/MediaEngine$a;", "options", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$Type;", "type", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onFailure", "g", "(JLcom/discord/rtcconnection/mediaengine/MediaEngine$a;Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$Type;Lkotlin/jvm/functions/Function1;)Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection;", "", "deviceIndex", "f", "(I)V", "Lcom/discord/rtcconnection/mediaengine/MediaEngine$VoiceConfig;", "voiceConfig", "d", "(Lcom/discord/rtcconnection/mediaengine/MediaEngine$VoiceConfig;)V", "", "enabled", "k", "(Z)V", "Lcom/discord/rtcconnection/mediaengine/MediaEngine$OpenSLUsageMode;", "openSLUsageMode", "h", "(Lcom/discord/rtcconnection/mediaengine/MediaEngine$OpenSLUsageMode;)V", "", "Lco/discord/media_engine/VideoInputDeviceDescription;", "devicesCallback", "j", "(Lkotlin/jvm/functions/Function1;)V", "Lco/discord/media_engine/RtcRegion;", "regionsWithIps", "", "callback", "b", "([Lco/discord/media_engine/RtcRegion;Lkotlin/jvm/functions/Function1;)V", "Lcom/discord/rtcconnection/mediaengine/MediaEngine$LocalVoiceStatus;", "voiceStatusListener", "l", "Lcom/hammerandchisel/libdiscord/Discord;", "i", "()Lcom/hammerandchisel/libdiscord/Discord;", "Lcom/discord/rtcconnection/mediaengine/MediaEngine$AudioInfo;", "e", "Lb/a/q/c;", "c", "()Lb/a/q/c;", "mediaEngineThreadExecutor", "AudioInfo", "EchoCancellationInfo", "LocalVoiceStatus", "OpenSLESConfig", "OpenSLUsageMode", "VoiceConfig", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public interface MediaEngine {

    /* compiled from: MediaEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngine$AudioInfo;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Ljava/lang/String;", "getAudioLayer", "audioLayer", "a", "getAudioSubsystem", "audioSubsystem", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class AudioInfo {

        /* renamed from: a, reason: from kotlin metadata */
        public final String audioSubsystem;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String audioLayer;

        public AudioInfo(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, "audioSubsystem");
            Intrinsics3.checkNotNullParameter(str2, "audioLayer");
            this.audioSubsystem = str;
            this.audioLayer = str2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AudioInfo)) {
                return false;
            }
            AudioInfo audioInfo = (AudioInfo) other;
            return Intrinsics3.areEqual(this.audioSubsystem, audioInfo.audioSubsystem) && Intrinsics3.areEqual(this.audioLayer, audioInfo.audioLayer);
        }

        public int hashCode() {
            String str = this.audioSubsystem;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.audioLayer;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("AudioInfo(audioSubsystem=");
            sbU.append(this.audioSubsystem);
            sbU.append(", audioLayer=");
            return outline.J(sbU, this.audioLayer, ")");
        }
    }

    /* compiled from: MediaEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010%\u001a\u00020\t\u0012\b\b\u0002\u0010(\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\t\u0012\b\b\u0002\u0010\u001f\u001a\u00020\t\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u0019\u0010\u0019\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u001c\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u0019\u0010\u001f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000fR\u0019\u0010\"\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000fR\u0019\u0010%\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b$\u0010\u000fR\u0019\u0010(\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u000f¨\u0006+"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngine$EchoCancellationInfo;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "getBuiltinAecRequested", "()Z", "builtinAecRequested", "d", "getBuiltinAecEnabled", "builtinAecEnabled", "e", "getAecEnabledInSettings", "aecEnabledInSettings", "i", "getAecMobileModeByDefault", "aecMobileModeByDefault", "f", "getAecEnabledInNativeConfig", "aecEnabledInNativeConfig", "g", "getAecMobileMode", "aecMobileMode", "h", "getAecEnabledByDefault", "aecEnabledByDefault", "b", "getBuiltinAecSupportedNative", "builtinAecSupportedNative", "c", "getBuiltinAecSupportedJava", "builtinAecSupportedJava", "<init>", "(ZZZZZZZZZ)V", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class EchoCancellationInfo {

        /* renamed from: a, reason: from kotlin metadata */
        public final boolean builtinAecRequested;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final boolean builtinAecSupportedNative;

        /* renamed from: c, reason: from kotlin metadata */
        public final boolean builtinAecSupportedJava;

        /* renamed from: d, reason: from kotlin metadata */
        public final boolean builtinAecEnabled;

        /* renamed from: e, reason: from kotlin metadata */
        public final boolean aecEnabledInSettings;

        /* renamed from: f, reason: from kotlin metadata */
        public final boolean aecEnabledInNativeConfig;

        /* renamed from: g, reason: from kotlin metadata */
        public final boolean aecMobileMode;

        /* renamed from: h, reason: from kotlin metadata */
        public final boolean aecEnabledByDefault;

        /* renamed from: i, reason: from kotlin metadata */
        public final boolean aecMobileModeByDefault;

        public EchoCancellationInfo() {
            this(false, false, false, false, false, false, false, false, false, FrameMetricsAggregator.EVERY_DURATION);
        }

        public EchoCancellationInfo(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
            this.builtinAecRequested = z2;
            this.builtinAecSupportedNative = z3;
            this.builtinAecSupportedJava = z4;
            this.builtinAecEnabled = z5;
            this.aecEnabledInSettings = z6;
            this.aecEnabledInNativeConfig = z7;
            this.aecMobileMode = z8;
            this.aecEnabledByDefault = z9;
            this.aecMobileModeByDefault = z10;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EchoCancellationInfo)) {
                return false;
            }
            EchoCancellationInfo echoCancellationInfo = (EchoCancellationInfo) other;
            return this.builtinAecRequested == echoCancellationInfo.builtinAecRequested && this.builtinAecSupportedNative == echoCancellationInfo.builtinAecSupportedNative && this.builtinAecSupportedJava == echoCancellationInfo.builtinAecSupportedJava && this.builtinAecEnabled == echoCancellationInfo.builtinAecEnabled && this.aecEnabledInSettings == echoCancellationInfo.aecEnabledInSettings && this.aecEnabledInNativeConfig == echoCancellationInfo.aecEnabledInNativeConfig && this.aecMobileMode == echoCancellationInfo.aecMobileMode && this.aecEnabledByDefault == echoCancellationInfo.aecEnabledByDefault && this.aecMobileModeByDefault == echoCancellationInfo.aecMobileModeByDefault;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.builtinAecRequested;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.builtinAecSupportedNative;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.builtinAecSupportedJava;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            ?? r23 = this.builtinAecEnabled;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (i5 + i6) * 31;
            ?? r24 = this.aecEnabledInSettings;
            int i8 = r24;
            if (r24 != 0) {
                i8 = 1;
            }
            int i9 = (i7 + i8) * 31;
            ?? r25 = this.aecEnabledInNativeConfig;
            int i10 = r25;
            if (r25 != 0) {
                i10 = 1;
            }
            int i11 = (i9 + i10) * 31;
            ?? r26 = this.aecMobileMode;
            int i12 = r26;
            if (r26 != 0) {
                i12 = 1;
            }
            int i13 = (i11 + i12) * 31;
            ?? r27 = this.aecEnabledByDefault;
            int i14 = r27;
            if (r27 != 0) {
                i14 = 1;
            }
            int i15 = (i13 + i14) * 31;
            boolean z3 = this.aecMobileModeByDefault;
            return i15 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("EchoCancellationInfo(builtinAecRequested=");
            sbU.append(this.builtinAecRequested);
            sbU.append(", builtinAecSupportedNative=");
            sbU.append(this.builtinAecSupportedNative);
            sbU.append(", builtinAecSupportedJava=");
            sbU.append(this.builtinAecSupportedJava);
            sbU.append(", builtinAecEnabled=");
            sbU.append(this.builtinAecEnabled);
            sbU.append(", aecEnabledInSettings=");
            sbU.append(this.aecEnabledInSettings);
            sbU.append(", aecEnabledInNativeConfig=");
            sbU.append(this.aecEnabledInNativeConfig);
            sbU.append(", aecMobileMode=");
            sbU.append(this.aecMobileMode);
            sbU.append(", aecEnabledByDefault=");
            sbU.append(this.aecEnabledByDefault);
            sbU.append(", aecMobileModeByDefault=");
            return outline.O(sbU, this.aecMobileModeByDefault, ")");
        }

        public /* synthetic */ EchoCancellationInfo(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) != 0 ? false : z6, (i & 32) != 0 ? false : z7, (i & 64) != 0 ? false : z8, (i & 128) != 0 ? false : z9, (i & 256) == 0 ? z10 : false);
        }
    }

    /* compiled from: MediaEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngine$LocalVoiceStatus;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Z", "isSpeaking", "()Z", "", "a", "F", "getAmplitude", "()F", "amplitude", "<init>", "(FZ)V", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class LocalVoiceStatus {

        /* renamed from: a, reason: from kotlin metadata */
        public final float amplitude;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final boolean isSpeaking;

        public LocalVoiceStatus(float f, boolean z2) {
            this.amplitude = f;
            this.isSpeaking = z2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LocalVoiceStatus)) {
                return false;
            }
            LocalVoiceStatus localVoiceStatus = (LocalVoiceStatus) other;
            return Float.compare(this.amplitude, localVoiceStatus.amplitude) == 0 && this.isSpeaking == localVoiceStatus.isSpeaking;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iFloatToIntBits = Float.floatToIntBits(this.amplitude) * 31;
            boolean z2 = this.isSpeaking;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iFloatToIntBits + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("LocalVoiceStatus(amplitude=");
            sbU.append(this.amplitude);
            sbU.append(", isSpeaking=");
            return outline.O(sbU, this.isSpeaking, ")");
        }
    }

    /* compiled from: MediaEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngine$OpenSLESConfig;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "FORCE_ENABLED", "FORCE_DISABLED", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public enum OpenSLESConfig {
        DEFAULT,
        FORCE_ENABLED,
        FORCE_DISABLED
    }

    /* compiled from: MediaEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngine$OpenSLUsageMode;", "", "<init>", "(Ljava/lang/String;I)V", "ALLOW_LIST", "EXCLUDE_LIST", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public enum OpenSLUsageMode {
        ALLOW_LIST,
        EXCLUDE_LIST
    }

    /* compiled from: MediaEngine.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010/\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010*\u001a\u00020%\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010,\u001a\u00020\t¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0018\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\u001b\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015R\u0019\u0010!\u001a\u00020\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010$\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015R\u0019\u0010*\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010,\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010\u0015R\u0019\u0010/\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0013\u001a\u0004\b.\u0010\u0015¨\u00062"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngine$VoiceConfig;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$c;", "g", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$c;", "getInputModeOptions", "()Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$c;", "inputModeOptions", "e", "Z", "getAutomaticGainControl", "()Z", "automaticGainControl", "h", "isSelfDeafened", "d", "getNoiseCancellation", "noiseCancellation", "", "a", "F", "getOutputVolume", "()F", "outputVolume", "c", "getNoiseSuppression", "noiseSuppression", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "f", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "getInputMode", "()Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "inputMode", "i", "isSelfMuted", "b", "getEchoCancellation", "echoCancellation", "<init>", "(FZZZZLcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$c;ZZ)V", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class VoiceConfig {

        /* renamed from: a, reason: from kotlin metadata */
        public final float outputVolume;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final boolean echoCancellation;

        /* renamed from: c, reason: from kotlin metadata */
        public final boolean noiseSuppression;

        /* renamed from: d, reason: from kotlin metadata */
        public final boolean noiseCancellation;

        /* renamed from: e, reason: from kotlin metadata */
        public final boolean automaticGainControl;

        /* renamed from: f, reason: from kotlin metadata */
        public final MediaEngineConnection.InputMode inputMode;

        /* renamed from: g, reason: from kotlin metadata */
        public final MediaEngineConnection.c inputModeOptions;

        /* renamed from: h, reason: from kotlin metadata */
        public final boolean isSelfDeafened;

        /* renamed from: i, reason: from kotlin metadata */
        public final boolean isSelfMuted;

        public VoiceConfig(float f, boolean z2, boolean z3, boolean z4, boolean z5, MediaEngineConnection.InputMode inputMode, MediaEngineConnection.c cVar, boolean z6, boolean z7) {
            Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
            Intrinsics3.checkNotNullParameter(cVar, "inputModeOptions");
            this.outputVolume = f;
            this.echoCancellation = z2;
            this.noiseSuppression = z3;
            this.noiseCancellation = z4;
            this.automaticGainControl = z5;
            this.inputMode = inputMode;
            this.inputModeOptions = cVar;
            this.isSelfDeafened = z6;
            this.isSelfMuted = z7;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceConfig)) {
                return false;
            }
            VoiceConfig voiceConfig = (VoiceConfig) other;
            return Float.compare(this.outputVolume, voiceConfig.outputVolume) == 0 && this.echoCancellation == voiceConfig.echoCancellation && this.noiseSuppression == voiceConfig.noiseSuppression && this.noiseCancellation == voiceConfig.noiseCancellation && this.automaticGainControl == voiceConfig.automaticGainControl && Intrinsics3.areEqual(this.inputMode, voiceConfig.inputMode) && Intrinsics3.areEqual(this.inputModeOptions, voiceConfig.inputModeOptions) && this.isSelfDeafened == voiceConfig.isSelfDeafened && this.isSelfMuted == voiceConfig.isSelfMuted;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iFloatToIntBits = Float.floatToIntBits(this.outputVolume) * 31;
            boolean z2 = this.echoCancellation;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iFloatToIntBits + i) * 31;
            boolean z3 = this.noiseSuppression;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.noiseCancellation;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.automaticGainControl;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            MediaEngineConnection.InputMode inputMode = this.inputMode;
            int iHashCode = (i8 + (inputMode != null ? inputMode.hashCode() : 0)) * 31;
            MediaEngineConnection.c cVar = this.inputModeOptions;
            int iHashCode2 = (iHashCode + (cVar != null ? cVar.hashCode() : 0)) * 31;
            boolean z6 = this.isSelfDeafened;
            int i9 = z6;
            if (z6 != 0) {
                i9 = 1;
            }
            int i10 = (iHashCode2 + i9) * 31;
            boolean z7 = this.isSelfMuted;
            return i10 + (z7 ? 1 : z7 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("VoiceConfig(outputVolume=");
            sbU.append(this.outputVolume);
            sbU.append(", echoCancellation=");
            sbU.append(this.echoCancellation);
            sbU.append(", noiseSuppression=");
            sbU.append(this.noiseSuppression);
            sbU.append(", noiseCancellation=");
            sbU.append(this.noiseCancellation);
            sbU.append(", automaticGainControl=");
            sbU.append(this.automaticGainControl);
            sbU.append(", inputMode=");
            sbU.append(this.inputMode);
            sbU.append(", inputModeOptions=");
            sbU.append(this.inputModeOptions);
            sbU.append(", isSelfDeafened=");
            sbU.append(this.isSelfDeafened);
            sbU.append(", isSelfMuted=");
            return outline.O(sbU, this.isSelfMuted, ")");
        }
    }

    /* compiled from: MediaEngine.kt */
    public static final class a {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final String f2797b;
        public final int c;
        public final List<StreamParameters> d;

        public a(int i, String str, int i2, List<StreamParameters> list) {
            Intrinsics3.checkNotNullParameter(str, "ip");
            Intrinsics3.checkNotNullParameter(list, "streams");
            this.a = i;
            this.f2797b = str;
            this.c = i2;
            this.d = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && Intrinsics3.areEqual(this.f2797b, aVar.f2797b) && this.c == aVar.c && Intrinsics3.areEqual(this.d, aVar.d);
        }

        public int hashCode() {
            int i = this.a * 31;
            String str = this.f2797b;
            int iHashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.c) * 31;
            List<StreamParameters> list = this.d;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ConnectionOptions(ssrc=");
            sbU.append(this.a);
            sbU.append(", ip=");
            sbU.append(this.f2797b);
            sbU.append(", port=");
            sbU.append(this.c);
            sbU.append(", streams=");
            return outline.L(sbU, this.d, ")");
        }
    }

    /* compiled from: MediaEngine.kt */
    public interface b {
        void onEchoCancellationUpdated(EchoCancellationInfo echoCancellationInfo);
    }

    /* compiled from: MediaEngine.kt */
    public interface c {
        void onConnected();

        void onConnecting();

        void onNativeEngineInitialized();

        void onNewConnection(MediaEngineConnection mediaEngineConnection);
    }

    Observable<Unit> a();

    void b(RtcRegion[] regionsWithIps, Function1<? super String[], Unit> callback);

    MediaEngineExecutorService c();

    @AnyThread
    void d(VoiceConfig voiceConfig);

    Observable<AudioInfo> e();

    void f(int deviceIndex);

    MediaEngineConnection g(long userId, a options, MediaEngineConnection.Type type, Function1<? super Exception, Unit> onFailure);

    List<MediaEngineConnection> getConnections();

    void h(OpenSLUsageMode openSLUsageMode);

    Discord i();

    void j(Function1<? super DeviceDescription4[], Unit> devicesCallback);

    void k(boolean enabled);

    void l(Function1<? super LocalVoiceStatus, Unit> voiceStatusListener);
}
