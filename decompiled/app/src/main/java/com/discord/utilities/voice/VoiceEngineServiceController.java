package com.discord.utilities.voice;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.StringRes;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.VoiceEngineForegroundService;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: VoiceEngineServiceController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0002\"#B'\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR:\u0010\u0013\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011 \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00100\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006$"}, d2 = {"Lcom/discord/utilities/voice/VoiceEngineServiceController;", "", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", "Landroid/content/Intent;", "permissionIntent", "startStream", "(Landroid/content/Intent;)V", "stopStream", "()V", "Lcom/discord/stores/StoreVoiceChannelSelected;", "voiceChannelSelectedStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "Lrx/Observable;", "Lcom/discord/utilities/voice/VoiceEngineServiceController$NotificationData;", "kotlin.jvm.PlatformType", "notificationDataObservable", "Lrx/Observable;", "Lcom/discord/stores/StoreMediaSettings;", "mediaSettingsStore", "Lcom/discord/stores/StoreMediaSettings;", "Lcom/discord/utilities/voice/VoiceEngineForegroundService$Connection;", "serviceBinding", "Lcom/discord/utilities/voice/VoiceEngineForegroundService$Connection;", "Lcom/discord/stores/StoreAudioManagerV2;", "audioManagerStore", "Lcom/discord/stores/StoreAudioManagerV2;", "Lcom/discord/stores/StoreRtcConnection;", "rtcConnectionStore", "<init>", "(Lcom/discord/stores/StoreAudioManagerV2;Lcom/discord/stores/StoreMediaSettings;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreRtcConnection;)V", "Companion", "NotificationData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class VoiceEngineServiceController {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(VoiceEngineServiceController2.INSTANCE);
    private static final NotificationData NOTIFICATION_DATA_DISCONNECTED = new NotificationData(new RtcConnection.State.d(false), "", false, false, false, false, -1, null, false, false);
    private final StoreAudioManagerV2 audioManagerStore;
    private final StoreMediaSettings mediaSettingsStore;
    private final Observable<NotificationData> notificationDataObservable;
    private VoiceEngineForegroundService.Connection serviceBinding;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    /* compiled from: VoiceEngineServiceController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/utilities/voice/VoiceEngineServiceController$Companion;", "", "Lcom/discord/utilities/voice/VoiceEngineServiceController;", "INSTANCE$delegate", "Lkotlin/Lazy;", "getINSTANCE", "()Lcom/discord/utilities/voice/VoiceEngineServiceController;", "INSTANCE", "Lcom/discord/utilities/voice/VoiceEngineServiceController$NotificationData;", "NOTIFICATION_DATA_DISCONNECTED", "Lcom/discord/utilities/voice/VoiceEngineServiceController$NotificationData;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final VoiceEngineServiceController getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = VoiceEngineServiceController.access$getINSTANCE$cp();
            Companion companion = VoiceEngineServiceController.INSTANCE;
            return (VoiceEngineServiceController) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: VoiceEngineServiceController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0016\b\u0082\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\n\u0010\u001d\u001a\u00060\u000ej\u0002`\u000f\u0012\u000e\u0010\u001e\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020\b¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJ\u0014\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\nJ\u0010\u0010\u0016\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\nJ\u0080\u0001\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\f\b\u0002\u0010\u001d\u001a\u00060\u000ej\u0002`\u000f2\u0010\b\u0002\u0010\u001e\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u00122\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\bHÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b#\u0010\u0007J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010(\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)R\u001c\u0010*\u001a\u00020$8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010&R\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b.\u0010\u0007R\u001d\u0010\u001d\u001a\u00060\u000ej\u0002`\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b0\u0010\u0011R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u00101\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b\u001a\u0010\nR\u0019\u0010\u001f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00103\u001a\u0004\b4\u0010\nR\u0019\u0010\u0019\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00103\u001a\u0004\b\u0019\u0010\nR\u0019\u0010\u001c\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00103\u001a\u0004\b\u001c\u0010\nR\u0019\u0010 \u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u00103\u001a\u0004\b5\u0010\nR\u0019\u0010\u001b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00103\u001a\u0004\b\u001b\u0010\nR!\u0010\u001e\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00106\u001a\u0004\b7\u0010\u0014¨\u0006:"}, d2 = {"Lcom/discord/utilities/voice/VoiceEngineServiceController$NotificationData;", "", "Lcom/discord/rtcconnection/RtcConnection$State;", "component1", "()Lcom/discord/rtcconnection/RtcConnection$State;", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "component4", "component5", "component6", "", "Lcom/discord/primitives/ChannelId;", "component7", "()J", "Lcom/discord/primitives/GuildId;", "component8", "()Ljava/lang/Long;", "component9", "component10", "rtcConnectionState", "channelName", "isSelfMuted", "isSelfDeafened", "isSelfStreaming", "isVideo", "channelId", "guildId", "proximityLockEnabled", "canSpeak", "copy", "(Lcom/discord/rtcconnection/RtcConnection$State;Ljava/lang/String;ZZZZJLjava/lang/Long;ZZ)Lcom/discord/utilities/voice/VoiceEngineServiceController$NotificationData;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "stateString", "I", "getStateString", "Ljava/lang/String;", "getChannelName", "J", "getChannelId", "Lcom/discord/rtcconnection/RtcConnection$State;", "getRtcConnectionState", "Z", "getProximityLockEnabled", "getCanSpeak", "Ljava/lang/Long;", "getGuildId", "<init>", "(Lcom/discord/rtcconnection/RtcConnection$State;Ljava/lang/String;ZZZZJLjava/lang/Long;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class NotificationData {
        private final boolean canSpeak;
        private final long channelId;
        private final String channelName;
        private final Long guildId;
        private final boolean isSelfDeafened;
        private final boolean isSelfMuted;
        private final boolean isSelfStreaming;
        private final boolean isVideo;
        private final boolean proximityLockEnabled;
        private final RtcConnection.State rtcConnectionState;

        @StringRes
        private final int stateString;

        public NotificationData(RtcConnection.State state, String str, boolean z2, boolean z3, boolean z4, boolean z5, long j, Long l, boolean z6, boolean z7) {
            int i;
            Intrinsics3.checkNotNullParameter(state, "rtcConnectionState");
            Intrinsics3.checkNotNullParameter(str, "channelName");
            this.rtcConnectionState = state;
            this.channelName = str;
            this.isSelfMuted = z2;
            this.isSelfDeafened = z3;
            this.isSelfStreaming = z4;
            this.isVideo = z5;
            this.channelId = j;
            this.guildId = l;
            this.proximityLockEnabled = z6;
            this.canSpeak = z7;
            if (state instanceof RtcConnection.State.d) {
                i = R.string.connection_status_disconnected;
            } else if (Intrinsics3.areEqual(state, RtcConnection.State.b.a)) {
                i = R.string.connection_status_awaiting_endpoint;
            } else if (Intrinsics3.areEqual(state, RtcConnection.State.a.a)) {
                i = R.string.connection_status_authenticating;
            } else if (Intrinsics3.areEqual(state, RtcConnection.State.c.a)) {
                i = R.string.connection_status_connecting;
            } else if (Intrinsics3.areEqual(state, RtcConnection.State.h.a)) {
                i = R.string.connection_status_rtc_disconnected;
            } else if (Intrinsics3.areEqual(state, RtcConnection.State.g.a)) {
                i = R.string.connection_status_rtc_connecting;
            } else if (Intrinsics3.areEqual(state, RtcConnection.State.f.a)) {
                i = z4 ? R.string.connection_status_stream_self_connected : z5 ? R.string.connection_status_video_connected : R.string.connection_status_voice_connected;
            } else {
                if (!Intrinsics3.areEqual(state, RtcConnection.State.e.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                i = R.string.connection_status_no_route;
            }
            this.stateString = i;
        }

        public static /* synthetic */ NotificationData copy$default(NotificationData notificationData, RtcConnection.State state, String str, boolean z2, boolean z3, boolean z4, boolean z5, long j, Long l, boolean z6, boolean z7, int i, Object obj) {
            return notificationData.copy((i & 1) != 0 ? notificationData.rtcConnectionState : state, (i & 2) != 0 ? notificationData.channelName : str, (i & 4) != 0 ? notificationData.isSelfMuted : z2, (i & 8) != 0 ? notificationData.isSelfDeafened : z3, (i & 16) != 0 ? notificationData.isSelfStreaming : z4, (i & 32) != 0 ? notificationData.isVideo : z5, (i & 64) != 0 ? notificationData.channelId : j, (i & 128) != 0 ? notificationData.guildId : l, (i & 256) != 0 ? notificationData.proximityLockEnabled : z6, (i & 512) != 0 ? notificationData.canSpeak : z7);
        }

        /* renamed from: component1, reason: from getter */
        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getCanSpeak() {
            return this.canSpeak;
        }

        /* renamed from: component2, reason: from getter */
        public final String getChannelName() {
            return this.channelName;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsSelfMuted() {
            return this.isSelfMuted;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsSelfDeafened() {
            return this.isSelfDeafened;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsSelfStreaming() {
            return this.isSelfStreaming;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsVideo() {
            return this.isVideo;
        }

        /* renamed from: component7, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component8, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getProximityLockEnabled() {
            return this.proximityLockEnabled;
        }

        public final NotificationData copy(RtcConnection.State rtcConnectionState, String channelName, boolean isSelfMuted, boolean isSelfDeafened, boolean isSelfStreaming, boolean isVideo, long channelId, Long guildId, boolean proximityLockEnabled, boolean canSpeak) {
            Intrinsics3.checkNotNullParameter(rtcConnectionState, "rtcConnectionState");
            Intrinsics3.checkNotNullParameter(channelName, "channelName");
            return new NotificationData(rtcConnectionState, channelName, isSelfMuted, isSelfDeafened, isSelfStreaming, isVideo, channelId, guildId, proximityLockEnabled, canSpeak);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotificationData)) {
                return false;
            }
            NotificationData notificationData = (NotificationData) other;
            return Intrinsics3.areEqual(this.rtcConnectionState, notificationData.rtcConnectionState) && Intrinsics3.areEqual(this.channelName, notificationData.channelName) && this.isSelfMuted == notificationData.isSelfMuted && this.isSelfDeafened == notificationData.isSelfDeafened && this.isSelfStreaming == notificationData.isSelfStreaming && this.isVideo == notificationData.isVideo && this.channelId == notificationData.channelId && Intrinsics3.areEqual(this.guildId, notificationData.guildId) && this.proximityLockEnabled == notificationData.proximityLockEnabled && this.canSpeak == notificationData.canSpeak;
        }

        public final boolean getCanSpeak() {
            return this.canSpeak;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final String getChannelName() {
            return this.channelName;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final boolean getProximityLockEnabled() {
            return this.proximityLockEnabled;
        }

        public final RtcConnection.State getRtcConnectionState() {
            return this.rtcConnectionState;
        }

        public final int getStateString() {
            return this.stateString;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            RtcConnection.State state = this.rtcConnectionState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            String str = this.channelName;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.isSelfMuted;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.isSelfDeafened;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.isSelfStreaming;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.isVideo;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int iA = (b.a(this.channelId) + ((i6 + i7) * 31)) * 31;
            Long l = this.guildId;
            int iHashCode3 = (iA + (l != null ? l.hashCode() : 0)) * 31;
            boolean z6 = this.proximityLockEnabled;
            int i8 = z6;
            if (z6 != 0) {
                i8 = 1;
            }
            int i9 = (iHashCode3 + i8) * 31;
            boolean z7 = this.canSpeak;
            return i9 + (z7 ? 1 : z7 ? 1 : 0);
        }

        public final boolean isSelfDeafened() {
            return this.isSelfDeafened;
        }

        public final boolean isSelfMuted() {
            return this.isSelfMuted;
        }

        public final boolean isSelfStreaming() {
            return this.isSelfStreaming;
        }

        public final boolean isVideo() {
            return this.isVideo;
        }

        public String toString() {
            StringBuilder sbU = outline.U("NotificationData(rtcConnectionState=");
            sbU.append(this.rtcConnectionState);
            sbU.append(", channelName=");
            sbU.append(this.channelName);
            sbU.append(", isSelfMuted=");
            sbU.append(this.isSelfMuted);
            sbU.append(", isSelfDeafened=");
            sbU.append(this.isSelfDeafened);
            sbU.append(", isSelfStreaming=");
            sbU.append(this.isSelfStreaming);
            sbU.append(", isVideo=");
            sbU.append(this.isVideo);
            sbU.append(", channelId=");
            sbU.append(this.channelId);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", proximityLockEnabled=");
            sbU.append(this.proximityLockEnabled);
            sbU.append(", canSpeak=");
            return outline.O(sbU, this.canSpeak, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreMediaSettings.SelfMuteFailure.values();
            int[] iArr = new int[1];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreMediaSettings.SelfMuteFailure.CANNOT_USE_VAD.ordinal()] = 1;
        }
    }

    /* compiled from: VoiceEngineServiceController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.VoiceEngineServiceController$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            VoiceEngineServiceController.access$getVoiceChannelSelectedStore$p(VoiceEngineServiceController.this).clear();
        }
    }

    /* compiled from: VoiceEngineServiceController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.VoiceEngineServiceController$init$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            VoiceEngineServiceController.access$getMediaSettingsStore$p(VoiceEngineServiceController.this).toggleSelfDeafened();
        }
    }

    /* compiled from: VoiceEngineServiceController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.VoiceEngineServiceController$init$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMediaSettings.SelfMuteFailure selfMuteFailure = VoiceEngineServiceController.access$getMediaSettingsStore$p(VoiceEngineServiceController.this).toggleSelfMuted();
            if (selfMuteFailure == null || selfMuteFailure.ordinal() != 0) {
                return;
            }
            AppToast.g(this.$context, R.string.vad_permission_small, 0, null, 12);
        }
    }

    /* compiled from: VoiceEngineServiceController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/voice/VoiceEngineServiceController$NotificationData;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/utilities/voice/VoiceEngineServiceController$NotificationData;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.VoiceEngineServiceController$init$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<NotificationData, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NotificationData notificationData) {
            invoke2(notificationData);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NotificationData notificationData) {
            if (notificationData.getRtcConnectionState() instanceof RtcConnection.State.d) {
                DiscordOverlayService.INSTANCE.launchForClose(this.$context);
                VoiceEngineForegroundService.INSTANCE.stopForegroundAndUnbind(VoiceEngineServiceController.access$getServiceBinding$p(VoiceEngineServiceController.this));
                return;
            }
            Context context = this.$context;
            VoiceEngineForegroundService.INSTANCE.startForegroundAndBind(VoiceEngineServiceController.access$getServiceBinding$p(VoiceEngineServiceController.this), FormatUtils.h(context, R.string.call_mobile_tap_to_return, new Object[]{FormatUtils.h(context, notificationData.getStateString(), new Object[0], null, 4)}, null, 4), notificationData.getChannelName(), notificationData.isSelfMuted(), notificationData.isSelfDeafened(), notificationData.isSelfStreaming(), notificationData.getChannelId(), notificationData.getGuildId(), notificationData.getProximityLockEnabled(), notificationData.getCanSpeak());
            if (Intrinsics3.areEqual(notificationData.getRtcConnectionState(), RtcConnection.State.f.a)) {
                DiscordOverlayService.INSTANCE.launchForVoice(this.$context);
            }
        }
    }

    public VoiceEngineServiceController(StoreAudioManagerV2 storeAudioManagerV2, StoreMediaSettings storeMediaSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreRtcConnection storeRtcConnection) {
        Intrinsics3.checkNotNullParameter(storeAudioManagerV2, "audioManagerStore");
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeRtcConnection, "rtcConnectionStore");
        this.audioManagerStore = storeAudioManagerV2;
        this.mediaSettingsStore = storeMediaSettings;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        Observable<R> observableY = storeRtcConnection.getConnectionState().Y(new VoiceEngineServiceController3(this));
        Intrinsics3.checkNotNullExpressionValue(observableY, "rtcConnectionStore\n     …            }\n          }");
        this.notificationDataObservable = ObservableExtensionsKt.computationLatest(observableY).r();
    }

    public static final /* synthetic */ StoreAudioManagerV2 access$getAudioManagerStore$p(VoiceEngineServiceController voiceEngineServiceController) {
        return voiceEngineServiceController.audioManagerStore;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ StoreMediaSettings access$getMediaSettingsStore$p(VoiceEngineServiceController voiceEngineServiceController) {
        return voiceEngineServiceController.mediaSettingsStore;
    }

    public static final /* synthetic */ NotificationData access$getNOTIFICATION_DATA_DISCONNECTED$cp() {
        return NOTIFICATION_DATA_DISCONNECTED;
    }

    public static final /* synthetic */ VoiceEngineForegroundService.Connection access$getServiceBinding$p(VoiceEngineServiceController voiceEngineServiceController) {
        VoiceEngineForegroundService.Connection connection = voiceEngineServiceController.serviceBinding;
        if (connection == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("serviceBinding");
        }
        return connection;
    }

    public static final /* synthetic */ StoreVoiceChannelSelected access$getVoiceChannelSelectedStore$p(VoiceEngineServiceController voiceEngineServiceController) {
        return voiceEngineServiceController.voiceChannelSelectedStore;
    }

    public static final /* synthetic */ void access$setServiceBinding$p(VoiceEngineServiceController voiceEngineServiceController, VoiceEngineForegroundService.Connection connection) {
        voiceEngineServiceController.serviceBinding = connection;
    }

    public final void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        VoiceEngineForegroundService.Companion companion = VoiceEngineForegroundService.INSTANCE;
        companion.setOnDisconnect(new AnonymousClass1());
        companion.setOnToggleSelfDeafen(new AnonymousClass2());
        companion.setOnToggleSelfMute(new AnonymousClass3(context));
        this.serviceBinding = new VoiceEngineForegroundService.Connection(context);
        Observable<NotificationData> observable = this.notificationDataObservable;
        Intrinsics3.checkNotNullExpressionValue(observable, "notificationDataObservable");
        ObservableExtensionsKt.appSubscribe$default(observable, VoiceEngineServiceController.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(context), 62, (Object) null);
    }

    public final void startStream(Intent permissionIntent) {
        Intrinsics3.checkNotNullParameter(permissionIntent, "permissionIntent");
        VoiceEngineForegroundService.Companion companion = VoiceEngineForegroundService.INSTANCE;
        VoiceEngineForegroundService.Connection connection = this.serviceBinding;
        if (connection == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("serviceBinding");
        }
        companion.startStream(connection, permissionIntent);
    }

    public final void stopStream() {
        VoiceEngineForegroundService.Companion companion = VoiceEngineForegroundService.INSTANCE;
        VoiceEngineForegroundService.Connection connection = this.serviceBinding;
        if (connection == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("serviceBinding");
        }
        companion.stopStream(connection);
    }
}
