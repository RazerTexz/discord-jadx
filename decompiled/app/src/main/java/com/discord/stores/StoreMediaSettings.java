package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.t._Arrays;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.PeerConnectionFactory;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreMediaSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004lmnoB3\u0012\u0006\u0010W\u001a\u00020V\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010[\u001a\u00020Z\u0012\b\b\u0002\u0010Q\u001a\u00020P\u0012\b\b\u0002\u0010h\u001a\u00020g¢\u0006\u0004\bj\u0010kJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u0011\u001a\u00020\u00042\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\bJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0006J!\u0010$\u001a\u00020\u00042\n\u0010!\u001a\u00060\u000ej\u0002` 2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\"¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u00020\u00042\n\u0010!\u001a\u00060\u000ej\u0002` ¢\u0006\u0004\b)\u0010\u0012J\u0015\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\"¢\u0006\u0004\b+\u0010(J\u0013\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\n¢\u0006\u0004\b-\u0010\fJ\r\u0010.\u001a\u00020,¢\u0006\u0004\b.\u0010/J#\u00101\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u000ej\u0002` \u0012\u0004\u0012\u00020\u0002000\n¢\u0006\u0004\b1\u0010\fJ\u0013\u00102\u001a\b\u0012\u0004\u0012\u00020\u00130\n¢\u0006\u0004\b2\u0010\fJ#\u00103\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u000ej\u0002` \u0012\u0004\u0012\u00020\"000\n¢\u0006\u0004\b3\u0010\fJ\u0013\u00104\u001a\b\u0012\u0004\u0012\u00020,0\n¢\u0006\u0004\b4\u0010\fJ\u001d\u00105\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002` \u0012\u0004\u0012\u00020\u000200¢\u0006\u0004\b5\u00106J!\u00108\u001a\u00020\u00042\n\u0010!\u001a\u00060\u000ej\u0002` 2\u0006\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u00109J#\u0010:\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u000ej\u0002` \u0012\u0004\u0012\u00020\u0002000\n¢\u0006\u0004\b:\u0010\fJ\r\u0010;\u001a\u00020\u0002¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u0004¢\u0006\u0004\b=\u0010\bJ\u0015\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ\u0015\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0002¢\u0006\u0004\bC\u0010\u0006J\r\u0010D\u001a\u00020\u0004¢\u0006\u0004\bD\u0010\bJ\r\u0010E\u001a\u00020\u0004¢\u0006\u0004\bE\u0010\bJ\u0015\u0010F\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>¢\u0006\u0004\bF\u0010AJ\u0015\u0010I\u001a\u00020\u00042\u0006\u0010H\u001a\u00020G¢\u0006\u0004\bI\u0010JJ\r\u0010K\u001a\u00020\u0004¢\u0006\u0004\bK\u0010\bJ\r\u0010L\u001a\u00020\u0004¢\u0006\u0004\bL\u0010\bJ\r\u0010M\u001a\u00020\u0004¢\u0006\u0004\bM\u0010\bJ\r\u0010N\u001a\u00020\u0004¢\u0006\u0004\bN\u0010\bJ\r\u0010O\u001a\u00020\u0004¢\u0006\u0004\bO\u0010\bR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R$\u0010^\u001a\u00020,2\u0006\u0010]\u001a\u00020,8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b^\u0010_\"\u0004\bF\u0010`R2\u0010c\u001a\u001e\u0012\f\u0012\n b*\u0004\u0018\u00010,0,\u0012\f\u0012\n b*\u0004\u0018\u00010,0,0a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010e\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006p"}, d2 = {"Lcom/discord/stores/StoreMediaSettings;", "Lcom/discord/stores/Store;", "", "canUseVad", "", "handleCanUseVad", "(Z)V", "updateForceMute", "()V", "init", "Lrx/Observable;", "isSelfMuted", "()Lrx/Observable;", "isSelfDeafened", "", "Lcom/discord/primitives/ChannelId;", "channelId", "handleVoiceChannelSelected", "(J)V", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "inputMode", "setVoiceInputMode", "(Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;)V", "Lcom/discord/stores/StoreMediaSettings$SelfMuteFailure;", "toggleSelfMuted", "()Lcom/discord/stores/StoreMediaSettings$SelfMuteFailure;", "isMuted", "setSelfMuted", "(Z)Lcom/discord/stores/StoreMediaSettings$SelfMuteFailure;", "toggleSelfDeafened", "isDeafened", "setSelfDeafen", "Lcom/discord/primitives/UserId;", "userId", "", "volume", "setUserOutputVolume", "(JF)V", "sensitivity", "setSensitivity", "(F)V", "toggleUserMuted", "outputVolume", "setOutputVolume", "Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "getVoiceConfiguration", "getVoiceConfigurationBlocking", "()Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "", "getUsersMuted", "getInputMode", "getUsersVolume", "getVoiceConfig", "getMutedUsers", "()Ljava/util/Map;", "offScreen", "setUserOffScreen", "(JZ)V", "getUsersOffScreen", "getVideoHardwareScalingBlocking", "()Z", "toggleAutomaticGainControl", "Lcom/discord/stores/StoreMediaSettings$NoiseProcessing;", "noiseProcessing", "setNoiseProcessing", "(Lcom/discord/stores/StoreMediaSettings$NoiseProcessing;)V", "hidden", "updateVoiceParticipantsHidden", "toggleNoiseSuppression", "toggleNoiseCancellation", "setVoiceConfiguration", "Lcom/discord/stores/StoreMediaSettings$VadUseKrisp;", "status", "setVADUseKrisp", "(Lcom/discord/stores/StoreMediaSettings$VadUseKrisp;)V", "toggleVADUseKrisp", "revertTemporaryDisableKrisp", "toggleEchoCancellation", "toggleAutomaticVAD", "toggleEnableVideoHardwareScaling", "Lcom/discord/stores/VoiceConfigurationCache;", "voiceConfigurationCache", "Lcom/discord/stores/VoiceConfigurationCache;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreVoiceChannelSelected;", "storeVoiceChannelSelected", "Lcom/discord/stores/StoreVoiceChannelSelected;", "Z", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StorePermissions;", "value", "voiceConfiguration", "Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;)V", "Lrx/subjects/SerializedSubject;", "kotlin.jvm.PlatformType", "voiceConfigurationSubject", "Lrx/subjects/SerializedSubject;", "forceSelfMuteReason", "Lcom/discord/stores/StoreMediaSettings$SelfMuteFailure;", "Lcom/discord/utilities/media/AppSoundManager;", "appSoundManager", "Lcom/discord/utilities/media/AppSoundManager;", "<init>", "(Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/VoiceConfigurationCache;Lcom/discord/utilities/media/AppSoundManager;)V", "NoiseProcessing", "SelfMuteFailure", "VadUseKrisp", "VoiceConfiguration", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMediaSettings extends Store {
    private final AppSoundManager appSoundManager;
    private boolean canUseVad;
    private SelfMuteFailure forceSelfMuteReason;
    private final StoreChannels storeChannels;
    private final StorePermissions storePermissions;
    private final StoreVoiceChannelSelected storeVoiceChannelSelected;
    private VoiceConfiguration voiceConfiguration;
    private final VoiceConfigurationCache voiceConfigurationCache;
    private final SerializedSubject<VoiceConfiguration, VoiceConfiguration> voiceConfigurationSubject;

    /* compiled from: StoreMediaSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/stores/StoreMediaSettings$NoiseProcessing;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Suppression", "Cancellation", "CancellationTemporarilyDisabled", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum NoiseProcessing {
        None,
        Suppression,
        Cancellation,
        CancellationTemporarilyDisabled
    }

    /* compiled from: StoreMediaSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/discord/stores/StoreMediaSettings$SelfMuteFailure;", "", "<init>", "(Ljava/lang/String;I)V", "CANNOT_USE_VAD", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum SelfMuteFailure {
        CANNOT_USE_VAD
    }

    /* compiled from: StoreMediaSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/stores/StoreMediaSettings$VadUseKrisp;", "", "<init>", "(Ljava/lang/String;I)V", "Disabled", PeerConnectionFactory.TRIAL_ENABLED, "TemporarilyDisabled", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum VadUseKrisp {
        Disabled,
        Enabled,
        TemporarilyDisabled
    }

    /* compiled from: StoreMediaSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u0000 Q2\u00020\u0001:\u0001QBÍ\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u000b\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0010\u0012\b\b\u0002\u0010)\u001a\u00020\u0013\u0012\b\b\u0002\u0010*\u001a\u00020\u0016\u0012\b\b\u0002\u0010+\u001a\u00020\u0013\u0012\u0018\b\u0002\u0010,\u001a\u0012\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u0004\u0012\u00020\u00020\u001a\u0012\u0018\b\u0002\u0010-\u001a\u0012\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u0004\u0012\u00020\u00130\u001a\u0012\u0018\b\u0002\u0010.\u001a\u0012\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u0004\u0012\u00020\u00020\u001a\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0002¢\u0006\u0004\bO\u0010PJ\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0015J \u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u0004\u0012\u00020\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010\u001f\u001a\u0012\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u0004\u0012\u00020\u00130\u001aHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001eJ \u0010 \u001a\u0012\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u0004\u0012\u00020\u00020\u001aHÆ\u0003¢\u0006\u0004\b \u0010\u001eJ\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0004JÖ\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020\u00162\b\b\u0002\u0010+\u001a\u00020\u00132\u0018\b\u0002\u0010,\u001a\u0012\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u0004\u0012\u00020\u00020\u001a2\u0018\b\u0002\u0010-\u001a\u0012\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u0004\u0012\u00020\u00130\u001a2\u0018\b\u0002\u0010.\u001a\u0012\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u0004\u0012\u00020\u00020\u001a2\b\b\u0002\u0010/\u001a\u00020\u00022\b\b\u0002\u00100\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00104\u001a\u000203HÖ\u0001¢\u0006\u0004\b4\u00105J\u0010\u00107\u001a\u000206HÖ\u0001¢\u0006\u0004\b7\u00108J\u001a\u0010:\u001a\u00020\u00022\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b:\u0010;R\u0019\u0010)\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010<\u001a\u0004\b=\u0010\u0015R\u0019\u0010&\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010>\u001a\u0004\b?\u0010\u0004R\u0019\u0010'\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010>\u001a\u0004\b@\u0010\u0004R\u0019\u0010/\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010>\u001a\u0004\bA\u0010\u0004R\u0019\u0010*\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010B\u001a\u0004\bC\u0010\u0018R)\u0010-\u001a\u0012\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u0004\u0012\u00020\u00130\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010D\u001a\u0004\bE\u0010\u001eR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010>R)\u0010,\u001a\u0012\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u0004\u0012\u00020\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010D\u001a\u0004\bF\u0010\u001eR\u0019\u0010$\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010>\u001a\u0004\bG\u0010\u0004R\u0019\u0010%\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010H\u001a\u0004\bI\u0010\rR\u0019\u0010+\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010<\u001a\u0004\bJ\u0010\u0015R)\u0010.\u001a\u0012\u0012\b\u0012\u00060\u001bj\u0002`\u001c\u0012\u0004\u0012\u00020\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010D\u001a\u0004\bK\u0010\u001eR\u0019\u0010(\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010L\u001a\u0004\bM\u0010\u0012R\u0019\u0010#\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010>\u001a\u0004\b#\u0010\u0004R\u0019\u00100\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010>\u001a\u0004\bN\u0010\u0004¨\u0006R"}, d2 = {"Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "", "", "component1", "()Z", "isSelfMuted", "Lcom/discord/rtcconnection/mediaengine/MediaEngine$VoiceConfig;", "toMediaEngineVoiceConfig", "()Lcom/discord/rtcconnection/mediaengine/MediaEngine$VoiceConfig;", "component2", "component3", "Lcom/discord/stores/StoreMediaSettings$VadUseKrisp;", "component4", "()Lcom/discord/stores/StoreMediaSettings$VadUseKrisp;", "component5", "component6", "Lcom/discord/stores/StoreMediaSettings$NoiseProcessing;", "component7", "()Lcom/discord/stores/StoreMediaSettings$NoiseProcessing;", "", "component8", "()F", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "component9", "()Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "component10", "", "", "Lcom/discord/primitives/UserId;", "component11", "()Ljava/util/Map;", "component12", "component13", "component14", "component15", "isSelfDeafened", "automaticVad", "vadUseKrisp", "automaticGainControl", "echoCancellation", "noiseProcessing", "sensitivity", "inputMode", "outputVolume", "mutedUsers", "userOutputVolumes", "offScreenUsers", "enableVideoHardwareScaling", "voiceParticipantsHidden", "copy", "(ZZZLcom/discord/stores/StoreMediaSettings$VadUseKrisp;ZZLcom/discord/stores/StoreMediaSettings$NoiseProcessing;FLcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;FLjava/util/Map;Ljava/util/Map;Ljava/util/Map;ZZ)Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "F", "getSensitivity", "Z", "getAutomaticGainControl", "getEchoCancellation", "getEnableVideoHardwareScaling", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "getInputMode", "Ljava/util/Map;", "getUserOutputVolumes", "getMutedUsers", "getAutomaticVad", "Lcom/discord/stores/StoreMediaSettings$VadUseKrisp;", "getVadUseKrisp", "getOutputVolume", "getOffScreenUsers", "Lcom/discord/stores/StoreMediaSettings$NoiseProcessing;", "getNoiseProcessing", "getVoiceParticipantsHidden", "<init>", "(ZZZLcom/discord/stores/StoreMediaSettings$VadUseKrisp;ZZLcom/discord/stores/StoreMediaSettings$NoiseProcessing;FLcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;FLjava/util/Map;Ljava/util/Map;Ljava/util/Map;ZZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class VoiceConfiguration {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int DEFAULT_NOISE_PROCESSING;
        public static final float DEFAULT_OUTPUT_VOLUME = 100.0f;
        public static final float DEFAULT_SENSITIVITY = -50.0f;
        private static final VoiceConfiguration DEFAULT_VOICE_CONFIG;
        private final boolean automaticGainControl;
        private final boolean automaticVad;
        private final boolean echoCancellation;
        private final boolean enableVideoHardwareScaling;
        private final MediaEngineConnection.InputMode inputMode;
        private final boolean isSelfDeafened;
        private final boolean isSelfMuted;
        private final Map<Long, Boolean> mutedUsers;
        private final NoiseProcessing noiseProcessing;
        private final Map<Long, Boolean> offScreenUsers;
        private final float outputVolume;
        private final float sensitivity;
        private final Map<Long, Float> userOutputVolumes;
        private final VadUseKrisp vadUseKrisp;
        private final boolean voiceParticipantsHidden;

        /* compiled from: StoreMediaSettings.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration$Companion;", "", "Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "DEFAULT_VOICE_CONFIG", "Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "getDEFAULT_VOICE_CONFIG", "()Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "", "DEFAULT_NOISE_PROCESSING", "I", "getDEFAULT_NOISE_PROCESSING", "()I", "", "DEFAULT_OUTPUT_VOLUME", "F", "DEFAULT_SENSITIVITY", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final int getDEFAULT_NOISE_PROCESSING() {
                return VoiceConfiguration.access$getDEFAULT_NOISE_PROCESSING$cp();
            }

            public final VoiceConfiguration getDEFAULT_VOICE_CONFIG() {
                return VoiceConfiguration.access$getDEFAULT_VOICE_CONFIG$cp();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            VoiceConfiguration voiceConfiguration = new VoiceConfiguration(false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32767, null);
            DEFAULT_VOICE_CONFIG = voiceConfiguration;
            DEFAULT_NOISE_PROCESSING = voiceConfiguration.noiseProcessing.ordinal();
        }

        public VoiceConfiguration() {
            this(false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32767, null);
        }

        public VoiceConfiguration(boolean z2, boolean z3, boolean z4, VadUseKrisp vadUseKrisp, boolean z5, boolean z6, NoiseProcessing noiseProcessing, float f, MediaEngineConnection.InputMode inputMode, float f2, Map<Long, Boolean> map, Map<Long, Float> map2, Map<Long, Boolean> map3, boolean z7, boolean z8) {
            Intrinsics3.checkNotNullParameter(vadUseKrisp, "vadUseKrisp");
            Intrinsics3.checkNotNullParameter(noiseProcessing, "noiseProcessing");
            Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
            Intrinsics3.checkNotNullParameter(map, "mutedUsers");
            Intrinsics3.checkNotNullParameter(map2, "userOutputVolumes");
            Intrinsics3.checkNotNullParameter(map3, "offScreenUsers");
            this.isSelfMuted = z2;
            this.isSelfDeafened = z3;
            this.automaticVad = z4;
            this.vadUseKrisp = vadUseKrisp;
            this.automaticGainControl = z5;
            this.echoCancellation = z6;
            this.noiseProcessing = noiseProcessing;
            this.sensitivity = f;
            this.inputMode = inputMode;
            this.outputVolume = f2;
            this.mutedUsers = map;
            this.userOutputVolumes = map2;
            this.offScreenUsers = map3;
            this.enableVideoHardwareScaling = z7;
            this.voiceParticipantsHidden = z8;
        }

        public static final /* synthetic */ int access$getDEFAULT_NOISE_PROCESSING$cp() {
            return DEFAULT_NOISE_PROCESSING;
        }

        public static final /* synthetic */ VoiceConfiguration access$getDEFAULT_VOICE_CONFIG$cp() {
            return DEFAULT_VOICE_CONFIG;
        }

        /* renamed from: component1, reason: from getter */
        private final boolean getIsSelfMuted() {
            return this.isSelfMuted;
        }

        public static /* synthetic */ VoiceConfiguration copy$default(VoiceConfiguration voiceConfiguration, boolean z2, boolean z3, boolean z4, VadUseKrisp vadUseKrisp, boolean z5, boolean z6, NoiseProcessing noiseProcessing, float f, MediaEngineConnection.InputMode inputMode, float f2, Map map, Map map2, Map map3, boolean z7, boolean z8, int i, Object obj) {
            return voiceConfiguration.copy((i & 1) != 0 ? voiceConfiguration.isSelfMuted : z2, (i & 2) != 0 ? voiceConfiguration.isSelfDeafened : z3, (i & 4) != 0 ? voiceConfiguration.automaticVad : z4, (i & 8) != 0 ? voiceConfiguration.vadUseKrisp : vadUseKrisp, (i & 16) != 0 ? voiceConfiguration.automaticGainControl : z5, (i & 32) != 0 ? voiceConfiguration.echoCancellation : z6, (i & 64) != 0 ? voiceConfiguration.noiseProcessing : noiseProcessing, (i & 128) != 0 ? voiceConfiguration.sensitivity : f, (i & 256) != 0 ? voiceConfiguration.inputMode : inputMode, (i & 512) != 0 ? voiceConfiguration.outputVolume : f2, (i & 1024) != 0 ? voiceConfiguration.mutedUsers : map, (i & 2048) != 0 ? voiceConfiguration.userOutputVolumes : map2, (i & 4096) != 0 ? voiceConfiguration.offScreenUsers : map3, (i & 8192) != 0 ? voiceConfiguration.enableVideoHardwareScaling : z7, (i & 16384) != 0 ? voiceConfiguration.voiceParticipantsHidden : z8);
        }

        /* renamed from: component10, reason: from getter */
        public final float getOutputVolume() {
            return this.outputVolume;
        }

        public final Map<Long, Boolean> component11() {
            return this.mutedUsers;
        }

        public final Map<Long, Float> component12() {
            return this.userOutputVolumes;
        }

        public final Map<Long, Boolean> component13() {
            return this.offScreenUsers;
        }

        /* renamed from: component14, reason: from getter */
        public final boolean getEnableVideoHardwareScaling() {
            return this.enableVideoHardwareScaling;
        }

        /* renamed from: component15, reason: from getter */
        public final boolean getVoiceParticipantsHidden() {
            return this.voiceParticipantsHidden;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSelfDeafened() {
            return this.isSelfDeafened;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAutomaticVad() {
            return this.automaticVad;
        }

        /* renamed from: component4, reason: from getter */
        public final VadUseKrisp getVadUseKrisp() {
            return this.vadUseKrisp;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getAutomaticGainControl() {
            return this.automaticGainControl;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getEchoCancellation() {
            return this.echoCancellation;
        }

        /* renamed from: component7, reason: from getter */
        public final NoiseProcessing getNoiseProcessing() {
            return this.noiseProcessing;
        }

        /* renamed from: component8, reason: from getter */
        public final float getSensitivity() {
            return this.sensitivity;
        }

        /* renamed from: component9, reason: from getter */
        public final MediaEngineConnection.InputMode getInputMode() {
            return this.inputMode;
        }

        public final VoiceConfiguration copy(boolean isSelfMuted, boolean isSelfDeafened, boolean automaticVad, VadUseKrisp vadUseKrisp, boolean automaticGainControl, boolean echoCancellation, NoiseProcessing noiseProcessing, float sensitivity, MediaEngineConnection.InputMode inputMode, float outputVolume, Map<Long, Boolean> mutedUsers, Map<Long, Float> userOutputVolumes, Map<Long, Boolean> offScreenUsers, boolean enableVideoHardwareScaling, boolean voiceParticipantsHidden) {
            Intrinsics3.checkNotNullParameter(vadUseKrisp, "vadUseKrisp");
            Intrinsics3.checkNotNullParameter(noiseProcessing, "noiseProcessing");
            Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
            Intrinsics3.checkNotNullParameter(mutedUsers, "mutedUsers");
            Intrinsics3.checkNotNullParameter(userOutputVolumes, "userOutputVolumes");
            Intrinsics3.checkNotNullParameter(offScreenUsers, "offScreenUsers");
            return new VoiceConfiguration(isSelfMuted, isSelfDeafened, automaticVad, vadUseKrisp, automaticGainControl, echoCancellation, noiseProcessing, sensitivity, inputMode, outputVolume, mutedUsers, userOutputVolumes, offScreenUsers, enableVideoHardwareScaling, voiceParticipantsHidden);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VoiceConfiguration)) {
                return false;
            }
            VoiceConfiguration voiceConfiguration = (VoiceConfiguration) other;
            return this.isSelfMuted == voiceConfiguration.isSelfMuted && this.isSelfDeafened == voiceConfiguration.isSelfDeafened && this.automaticVad == voiceConfiguration.automaticVad && Intrinsics3.areEqual(this.vadUseKrisp, voiceConfiguration.vadUseKrisp) && this.automaticGainControl == voiceConfiguration.automaticGainControl && this.echoCancellation == voiceConfiguration.echoCancellation && Intrinsics3.areEqual(this.noiseProcessing, voiceConfiguration.noiseProcessing) && Float.compare(this.sensitivity, voiceConfiguration.sensitivity) == 0 && Intrinsics3.areEqual(this.inputMode, voiceConfiguration.inputMode) && Float.compare(this.outputVolume, voiceConfiguration.outputVolume) == 0 && Intrinsics3.areEqual(this.mutedUsers, voiceConfiguration.mutedUsers) && Intrinsics3.areEqual(this.userOutputVolumes, voiceConfiguration.userOutputVolumes) && Intrinsics3.areEqual(this.offScreenUsers, voiceConfiguration.offScreenUsers) && this.enableVideoHardwareScaling == voiceConfiguration.enableVideoHardwareScaling && this.voiceParticipantsHidden == voiceConfiguration.voiceParticipantsHidden;
        }

        public final boolean getAutomaticGainControl() {
            return this.automaticGainControl;
        }

        public final boolean getAutomaticVad() {
            return this.automaticVad;
        }

        public final boolean getEchoCancellation() {
            return this.echoCancellation;
        }

        public final boolean getEnableVideoHardwareScaling() {
            return this.enableVideoHardwareScaling;
        }

        public final MediaEngineConnection.InputMode getInputMode() {
            return this.inputMode;
        }

        public final Map<Long, Boolean> getMutedUsers() {
            return this.mutedUsers;
        }

        public final NoiseProcessing getNoiseProcessing() {
            return this.noiseProcessing;
        }

        public final Map<Long, Boolean> getOffScreenUsers() {
            return this.offScreenUsers;
        }

        public final float getOutputVolume() {
            return this.outputVolume;
        }

        public final float getSensitivity() {
            return this.sensitivity;
        }

        public final Map<Long, Float> getUserOutputVolumes() {
            return this.userOutputVolumes;
        }

        public final VadUseKrisp getVadUseKrisp() {
            return this.vadUseKrisp;
        }

        public final boolean getVoiceParticipantsHidden() {
            return this.voiceParticipantsHidden;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v32 */
        /* JADX WARN: Type inference failed for: r0v33 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v27, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v7, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v9, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isSelfMuted;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.isSelfDeafened;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.automaticVad;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            VadUseKrisp vadUseKrisp = this.vadUseKrisp;
            int iHashCode = (i5 + (vadUseKrisp != null ? vadUseKrisp.hashCode() : 0)) * 31;
            ?? r23 = this.automaticGainControl;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (iHashCode + i6) * 31;
            ?? r24 = this.echoCancellation;
            int i8 = r24;
            if (r24 != 0) {
                i8 = 1;
            }
            int i9 = (i7 + i8) * 31;
            NoiseProcessing noiseProcessing = this.noiseProcessing;
            int iFloatToIntBits = (Float.floatToIntBits(this.sensitivity) + ((i9 + (noiseProcessing != null ? noiseProcessing.hashCode() : 0)) * 31)) * 31;
            MediaEngineConnection.InputMode inputMode = this.inputMode;
            int iFloatToIntBits2 = (Float.floatToIntBits(this.outputVolume) + ((iFloatToIntBits + (inputMode != null ? inputMode.hashCode() : 0)) * 31)) * 31;
            Map<Long, Boolean> map = this.mutedUsers;
            int iHashCode2 = (iFloatToIntBits2 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Float> map2 = this.userOutputVolumes;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, Boolean> map3 = this.offScreenUsers;
            int iHashCode4 = (iHashCode3 + (map3 != null ? map3.hashCode() : 0)) * 31;
            ?? r25 = this.enableVideoHardwareScaling;
            int i10 = r25;
            if (r25 != 0) {
                i10 = 1;
            }
            int i11 = (iHashCode4 + i10) * 31;
            boolean z3 = this.voiceParticipantsHidden;
            return i11 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isSelfDeafened() {
            return this.isSelfDeafened;
        }

        public final boolean isSelfMuted() {
            return this.isSelfMuted || this.isSelfDeafened;
        }

        public final MediaEngine.VoiceConfig toMediaEngineVoiceConfig() {
            int i = 63 & 1;
            int i2 = 63 & 8;
            int i3 = 63 & 16;
            return new MediaEngine.VoiceConfig(this.outputVolume, this.echoCancellation, _Arrays.contains(new NoiseProcessing[]{NoiseProcessing.Suppression, NoiseProcessing.CancellationTemporarilyDisabled}, this.noiseProcessing), this.noiseProcessing == NoiseProcessing.Cancellation, this.automaticGainControl, this.inputMode, new MediaEngineConnection.c((int) this.sensitivity, (2 & 63) != 0 ? 10 : 0, (63 & 4) != 0 ? 40 : 0, this.automaticVad, this.vadUseKrisp == VadUseKrisp.Enabled, (63 & 32) != 0 ? 5 : 0), this.isSelfDeafened, isSelfMuted());
        }

        public String toString() {
            StringBuilder sbU = outline.U("VoiceConfiguration(isSelfMuted=");
            sbU.append(this.isSelfMuted);
            sbU.append(", isSelfDeafened=");
            sbU.append(this.isSelfDeafened);
            sbU.append(", automaticVad=");
            sbU.append(this.automaticVad);
            sbU.append(", vadUseKrisp=");
            sbU.append(this.vadUseKrisp);
            sbU.append(", automaticGainControl=");
            sbU.append(this.automaticGainControl);
            sbU.append(", echoCancellation=");
            sbU.append(this.echoCancellation);
            sbU.append(", noiseProcessing=");
            sbU.append(this.noiseProcessing);
            sbU.append(", sensitivity=");
            sbU.append(this.sensitivity);
            sbU.append(", inputMode=");
            sbU.append(this.inputMode);
            sbU.append(", outputVolume=");
            sbU.append(this.outputVolume);
            sbU.append(", mutedUsers=");
            sbU.append(this.mutedUsers);
            sbU.append(", userOutputVolumes=");
            sbU.append(this.userOutputVolumes);
            sbU.append(", offScreenUsers=");
            sbU.append(this.offScreenUsers);
            sbU.append(", enableVideoHardwareScaling=");
            sbU.append(this.enableVideoHardwareScaling);
            sbU.append(", voiceParticipantsHidden=");
            return outline.O(sbU, this.voiceParticipantsHidden, ")");
        }

        public /* synthetic */ VoiceConfiguration(boolean z2, boolean z3, boolean z4, VadUseKrisp vadUseKrisp, boolean z5, boolean z6, NoiseProcessing noiseProcessing, float f, MediaEngineConnection.InputMode inputMode, float f2, Map map, Map map2, Map map3, boolean z7, boolean z8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? true : z4, (i & 8) != 0 ? VadUseKrisp.Enabled : vadUseKrisp, (i & 16) != 0 ? true : z5, (i & 32) == 0 ? z6 : true, (i & 64) != 0 ? NoiseProcessing.Cancellation : noiseProcessing, (i & 128) != 0 ? -50.0f : f, (i & 256) != 0 ? MediaEngineConnection.InputMode.VOICE_ACTIVITY : inputMode, (i & 512) != 0 ? 100.0f : f2, (i & 1024) != 0 ? Maps6.emptyMap() : map, (i & 2048) != 0 ? Maps6.emptyMap() : map2, (i & 4096) != 0 ? Maps6.emptyMap() : map3, (i & 8192) != 0 ? false : z7, (i & 16384) == 0 ? z8 : false);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            VadUseKrisp.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[VadUseKrisp.TemporarilyDisabled.ordinal()] = 1;
            NoiseProcessing.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[NoiseProcessing.CancellationTemporarilyDisabled.ordinal()] = 1;
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "kotlin.jvm.PlatformType", "it", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;)Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMediaSettings$getInputMode$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<VoiceConfiguration, MediaEngineConnection.InputMode> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ MediaEngineConnection.InputMode call(VoiceConfiguration voiceConfiguration) {
            return call2(voiceConfiguration);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final MediaEngineConnection.InputMode call2(VoiceConfiguration voiceConfiguration) {
            return voiceConfiguration.getInputMode();
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a*\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006 \u0001*\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "kotlin.jvm.PlatformType", "it", "", "", "Lcom/discord/primitives/UserId;", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMediaSettings$getUsersMuted$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<VoiceConfiguration, Map<Long, ? extends Boolean>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends Boolean> call(VoiceConfiguration voiceConfiguration) {
            return call2(voiceConfiguration);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Boolean> call2(VoiceConfiguration voiceConfiguration) {
            return voiceConfiguration.getMutedUsers();
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a*\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006 \u0001*\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "kotlin.jvm.PlatformType", "it", "", "", "Lcom/discord/primitives/UserId;", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMediaSettings$getUsersOffScreen$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<VoiceConfiguration, Map<Long, ? extends Boolean>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends Boolean> call(VoiceConfiguration voiceConfiguration) {
            return call2(voiceConfiguration);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Boolean> call2(VoiceConfiguration voiceConfiguration) {
            return voiceConfiguration.getOffScreenUsers();
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\t\u001a*\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006 \u0001*\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "kotlin.jvm.PlatformType", "it", "", "", "Lcom/discord/primitives/UserId;", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMediaSettings$getUsersVolume$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<VoiceConfiguration, Map<Long, ? extends Float>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends Float> call(VoiceConfiguration voiceConfiguration) {
            return call2(voiceConfiguration);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Float> call2(VoiceConfiguration voiceConfiguration) {
            return voiceConfiguration.getUserOutputVolumes();
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", ModelAuditLogEntry.CHANGE_KEY_ID, "Lrx/Observable;", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMediaSettings$init$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Long, Observable<? extends Boolean>> {

        /* compiled from: StoreMediaSettings.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMediaSettings$init$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01491<T, R> implements Func1<Channel, Observable<? extends Boolean>> {
            public final /* synthetic */ Long $id;

            /* compiled from: StoreMediaSettings.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/api/permission/PermissionBit;", "it", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreMediaSettings$init$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01501<T, R> implements Func1<Long, Boolean> {
                public static final C01501 INSTANCE = new C01501();

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Boolean call(Long l) {
                    return call2(l);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final Boolean call2(Long l) {
                    return Boolean.valueOf(PermissionUtils.can(Permission.USE_VAD, l));
                }
            }

            public C01491(Long l) {
                this.$id = l;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Channel channel) {
                return call2(channel);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Boolean> call2(Channel channel) {
                if (channel == null || ChannelUtils.B(channel) || ChannelUtils.D(channel)) {
                    return new ScalarSynchronousObservable(Boolean.TRUE);
                }
                StorePermissions storePermissionsAccess$getStorePermissions$p = StoreMediaSettings.access$getStorePermissions$p(StoreMediaSettings.this);
                Long l = this.$id;
                Intrinsics3.checkNotNullExpressionValue(l, ModelAuditLogEntry.CHANGE_KEY_ID);
                return storePermissionsAccess$getStorePermissions$p.observePermissionsForChannel(l.longValue()).G(C01501.INSTANCE);
            }
        }

        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Boolean> call2(Long l) {
            StoreChannels storeChannelsAccess$getStoreChannels$p = StoreMediaSettings.access$getStoreChannels$p(StoreMediaSettings.this);
            Intrinsics3.checkNotNullExpressionValue(l, ModelAuditLogEntry.CHANGE_KEY_ID);
            return storeChannelsAccess$getStoreChannels$p.observeChannel(l.longValue()).Y(new C01491(l));
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMediaSettings$init$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass2(StoreMediaSettings storeMediaSettings) {
            super(1, storeMediaSettings, StoreMediaSettings.class, "handleCanUseVad", "handleCanUseVad(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            StoreMediaSettings.access$handleCanUseVad((StoreMediaSettings) this.receiver, z2);
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMediaSettings$isSelfDeafened$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<VoiceConfiguration, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(VoiceConfiguration voiceConfiguration) {
            return call2(voiceConfiguration);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(VoiceConfiguration voiceConfiguration) {
            return Boolean.valueOf(voiceConfiguration.isSelfDeafened());
        }
    }

    /* compiled from: StoreMediaSettings.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMediaSettings$isSelfMuted$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<VoiceConfiguration, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(VoiceConfiguration voiceConfiguration) {
            return call2(voiceConfiguration);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(VoiceConfiguration voiceConfiguration) {
            return Boolean.valueOf(voiceConfiguration.isSelfMuted());
        }
    }

    public /* synthetic */ StoreMediaSettings(StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StorePermissions storePermissions, VoiceConfigurationCache voiceConfigurationCache, AppSoundManager appSoundManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeVoiceChannelSelected, storeChannels, storePermissions, (i & 8) != 0 ? new VoiceConfigurationCache(SharedPreferencesProvider.INSTANCE.get()) : voiceConfigurationCache, (i & 16) != 0 ? AppSoundManager.Provider.INSTANCE.get() : appSoundManager);
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(StoreMediaSettings storeMediaSettings) {
        return storeMediaSettings.storeChannels;
    }

    public static final /* synthetic */ StorePermissions access$getStorePermissions$p(StoreMediaSettings storeMediaSettings) {
        return storeMediaSettings.storePermissions;
    }

    public static final /* synthetic */ void access$handleCanUseVad(StoreMediaSettings storeMediaSettings, boolean z2) {
        storeMediaSettings.handleCanUseVad(z2);
    }

    private final synchronized void handleCanUseVad(boolean canUseVad) {
        this.canUseVad = canUseVad;
        updateForceMute();
    }

    private final void setVoiceConfiguration(VoiceConfiguration voiceConfiguration) {
        this.voiceConfiguration = voiceConfiguration;
        this.voiceConfigurationSubject.k.onNext(voiceConfiguration);
        this.voiceConfigurationCache.write(voiceConfiguration);
    }

    private final void updateForceMute() {
        this.forceSelfMuteReason = null;
        if (!this.canUseVad && this.voiceConfiguration.getInputMode() == MediaEngineConnection.InputMode.VOICE_ACTIVITY) {
            this.forceSelfMuteReason = SelfMuteFailure.CANNOT_USE_VAD;
        }
        if (this.forceSelfMuteReason != null) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, true, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32766, null));
        }
    }

    public final Observable<MediaEngineConnection.InputMode> getInputMode() {
        Observable<R> observableG = this.voiceConfigurationSubject.G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "voiceConfigurationSubjec…    .map { it.inputMode }");
        Observable<MediaEngineConnection.InputMode> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final synchronized Map<Long, Boolean> getMutedUsers() {
        return this.voiceConfiguration.getMutedUsers();
    }

    public final Observable<Map<Long, Boolean>> getUsersMuted() {
        Observable<R> observableG = this.voiceConfigurationSubject.G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "voiceConfigurationSubjec…   .map { it.mutedUsers }");
        Observable<Map<Long, Boolean>> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Boolean>> getUsersOffScreen() {
        Observable<R> observableG = this.voiceConfigurationSubject.G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "voiceConfigurationSubjec…map { it.offScreenUsers }");
        Observable<Map<Long, Boolean>> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Float>> getUsersVolume() {
        Observable<R> observableG = this.voiceConfigurationSubject.G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "voiceConfigurationSubjec… { it.userOutputVolumes }");
        Observable<Map<Long, Float>> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final synchronized boolean getVideoHardwareScalingBlocking() {
        return this.voiceConfiguration.getEnableVideoHardwareScaling();
    }

    public final Observable<VoiceConfiguration> getVoiceConfig() {
        Observable<VoiceConfiguration> observableR = ObservableExtensionsKt.computationLatest(this.voiceConfigurationSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<VoiceConfiguration> getVoiceConfiguration() {
        return this.voiceConfigurationSubject;
    }

    public final synchronized VoiceConfiguration getVoiceConfigurationBlocking() {
        return this.voiceConfiguration;
    }

    @Store3
    public final void handleVoiceChannelSelected(long channelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.storeChannels.findChannelByIdInternal$app_productionGoogleRelease(channelId);
        if (channelFindChannelByIdInternal$app_productionGoogleRelease == null || !ChannelUtils.B(channelFindChannelByIdInternal$app_productionGoogleRelease)) {
            return;
        }
        setSelfDeafen(false);
    }

    public final void init() {
        setVoiceConfiguration(this.voiceConfigurationCache.read());
        Observable<R> observableY = this.storeVoiceChannelSelected.observeSelectedVoiceChannelId().Y(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableY, "storeVoiceChannelSelecte…              }\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableY, StoreMediaSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }

    public final Observable<Boolean> isSelfDeafened() {
        Observable<R> observableG = this.voiceConfigurationSubject.G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "voiceConfigurationSubjec…map { it.isSelfDeafened }");
        Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> isSelfMuted() {
        Observable<R> observableG = this.voiceConfigurationSubject.G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "voiceConfigurationSubjec….map { it.isSelfMuted() }");
        Observable<Boolean> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "voiceConfigurationSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final synchronized void revertTemporaryDisableKrisp() {
        VadUseKrisp vadUseKrisp = this.voiceConfiguration.getVadUseKrisp().ordinal() != 2 ? this.voiceConfiguration.getVadUseKrisp() : VadUseKrisp.Enabled;
        NoiseProcessing noiseProcessing = this.voiceConfiguration.getNoiseProcessing().ordinal() != 3 ? this.voiceConfiguration.getNoiseProcessing() : NoiseProcessing.Cancellation;
        if (noiseProcessing != this.voiceConfiguration.getNoiseProcessing() || vadUseKrisp != this.voiceConfiguration.getVadUseKrisp()) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, vadUseKrisp, false, false, noiseProcessing, 0.0f, null, 0.0f, null, null, null, false, false, 32695, null));
        }
    }

    public final synchronized void setNoiseProcessing(NoiseProcessing noiseProcessing) {
        Intrinsics3.checkNotNullParameter(noiseProcessing, "noiseProcessing");
        if (noiseProcessing != this.voiceConfiguration.getNoiseProcessing()) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, noiseProcessing, 0.0f, null, 0.0f, null, null, null, false, false, 32703, null));
        }
    }

    public final synchronized void setOutputVolume(float outputVolume) {
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, outputVolume, null, null, null, false, false, 32255, null));
    }

    public final synchronized void setSelfDeafen(boolean isDeafened) {
        if (this.voiceConfiguration.isSelfDeafened() == isDeafened) {
            return;
        }
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, isDeafened, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32765, null));
        this.appSoundManager.play(isDeafened ? AppSound.INSTANCE.getSOUND_DEAFEN() : AppSound.INSTANCE.getSOUND_UNDEAFEN());
    }

    public final synchronized SelfMuteFailure setSelfMuted(boolean isMuted) {
        if (this.voiceConfiguration.isSelfMuted() == isMuted) {
            return null;
        }
        SelfMuteFailure selfMuteFailure = this.forceSelfMuteReason;
        if (selfMuteFailure != null) {
            return selfMuteFailure;
        }
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, isMuted, voiceConfiguration.isSelfDeafened() && isMuted, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32764, null));
        this.appSoundManager.play(isMuted ? AppSound.INSTANCE.getSOUND_MUTE() : AppSound.INSTANCE.getSOUND_UNMUTE());
        return null;
    }

    public final synchronized void setSensitivity(float sensitivity) {
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, sensitivity, null, 0.0f, null, null, null, false, false, 32639, null));
    }

    public final synchronized void setUserOffScreen(long userId, boolean offScreen) {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        HashMap map = new HashMap(this.voiceConfiguration.getOffScreenUsers());
        map.put(Long.valueOf(userId), Boolean.valueOf(offScreen));
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, map, false, false, 28671, null));
    }

    public final synchronized void setUserOutputVolume(long userId, float volume) {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        HashMap map = new HashMap(this.voiceConfiguration.getUserOutputVolumes());
        map.put(Long.valueOf(userId), Float.valueOf(volume));
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, map, null, false, false, 30719, null));
    }

    public final synchronized void setVADUseKrisp(VadUseKrisp status) {
        Intrinsics3.checkNotNullParameter(status, "status");
        if (status != this.voiceConfiguration.getVadUseKrisp()) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, status, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32759, null));
        }
    }

    public final synchronized void setVoiceInputMode(MediaEngineConnection.InputMode inputMode) {
        Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, 0.0f, inputMode, 0.0f, null, null, null, false, false, 32511, null));
        updateForceMute();
    }

    public final synchronized void toggleAutomaticGainControl() {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, !voiceConfiguration.getAutomaticGainControl(), false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32751, null));
    }

    public final synchronized void toggleAutomaticVAD() {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, !voiceConfiguration.getAutomaticVad(), null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32763, null));
    }

    public final synchronized void toggleEchoCancellation() {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, !voiceConfiguration.getEchoCancellation(), null, 0.0f, null, 0.0f, null, null, null, false, false, 32735, null));
    }

    public final synchronized void toggleEnableVideoHardwareScaling() {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, !voiceConfiguration.getEnableVideoHardwareScaling(), false, 24575, null));
    }

    public final synchronized void toggleNoiseCancellation() {
        NoiseProcessing noiseProcessing = this.voiceConfiguration.getNoiseProcessing();
        NoiseProcessing noiseProcessing2 = NoiseProcessing.Cancellation;
        if (noiseProcessing == noiseProcessing2) {
            setVoiceConfiguration(NoiseProcessing.Suppression);
        } else {
            setVoiceConfiguration(noiseProcessing2);
        }
    }

    public final synchronized void toggleNoiseSuppression() {
        NoiseProcessing noiseProcessing = this.voiceConfiguration.getNoiseProcessing();
        NoiseProcessing noiseProcessing2 = NoiseProcessing.Suppression;
        if (noiseProcessing == noiseProcessing2) {
            setVoiceConfiguration(NoiseProcessing.None);
        } else {
            setVoiceConfiguration(noiseProcessing2);
        }
    }

    public final synchronized void toggleSelfDeafened() {
        setSelfDeafen(!this.voiceConfiguration.isSelfDeafened());
    }

    public final synchronized SelfMuteFailure toggleSelfMuted() {
        return setSelfMuted(!this.voiceConfiguration.isSelfMuted());
    }

    public final synchronized void toggleUserMuted(long userId) {
        VoiceConfiguration voiceConfiguration = this.voiceConfiguration;
        HashMap map = new HashMap(this.voiceConfiguration.getMutedUsers());
        Boolean bool = (Boolean) map.get(Long.valueOf(userId));
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        Intrinsics3.checkNotNullExpressionValue(bool, "get(userId) ?: false");
        map.put(Long.valueOf(userId), Boolean.valueOf(!bool.booleanValue()));
        setVoiceConfiguration(VoiceConfiguration.copy$default(voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, map, null, null, false, false, 31743, null));
    }

    public final synchronized void toggleVADUseKrisp() {
        VadUseKrisp vadUseKrisp = this.voiceConfiguration.getVadUseKrisp();
        VadUseKrisp vadUseKrisp2 = VadUseKrisp.Enabled;
        if (vadUseKrisp == vadUseKrisp2) {
            vadUseKrisp2 = VadUseKrisp.Disabled;
        }
        setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, vadUseKrisp2, false, false, null, 0.0f, null, 0.0f, null, null, null, false, false, 32759, null));
    }

    public final synchronized void updateVoiceParticipantsHidden(boolean hidden) {
        if (this.voiceConfiguration.getVoiceParticipantsHidden() != hidden) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, null, 0.0f, null, 0.0f, null, null, null, false, hidden, 16383, null));
        }
    }

    public StoreMediaSettings(StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StorePermissions storePermissions, VoiceConfigurationCache voiceConfigurationCache, AppSoundManager appSoundManager) {
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "storeVoiceChannelSelected");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(voiceConfigurationCache, "voiceConfigurationCache");
        Intrinsics3.checkNotNullParameter(appSoundManager, "appSoundManager");
        this.storeVoiceChannelSelected = storeVoiceChannelSelected;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        this.voiceConfigurationCache = voiceConfigurationCache;
        this.appSoundManager = appSoundManager;
        VoiceConfiguration default_voice_config = VoiceConfiguration.INSTANCE.getDEFAULT_VOICE_CONFIG();
        this.voiceConfiguration = default_voice_config;
        this.voiceConfigurationSubject = new SerializedSubject<>(BehaviorSubject.l0(default_voice_config));
        this.canUseVad = true;
    }

    public final synchronized void setVoiceConfiguration(NoiseProcessing noiseProcessing) {
        Intrinsics3.checkNotNullParameter(noiseProcessing, "noiseProcessing");
        if (noiseProcessing != this.voiceConfiguration.getNoiseProcessing()) {
            setVoiceConfiguration(VoiceConfiguration.copy$default(this.voiceConfiguration, false, false, false, null, false, false, noiseProcessing, 0.0f, null, 0.0f, null, null, null, false, false, 32703, null));
        }
    }
}
