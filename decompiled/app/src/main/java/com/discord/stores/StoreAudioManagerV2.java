package com.discord.stores;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.voice.state.VoiceState;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import d0.a0.MathJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreAudioManagerV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\u00020\u0001:\u0003STUB?\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010;\u001a\u00020:¢\u0006\u0004\bQ\u0010RJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0003¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u000eJ\u0015\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH\u0007¢\u0006\u0004\b!\u0010\u001bJ\u0017\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\u001bR\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u0014\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\"\u0010#\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010+\u001a\u0004\bF\u0010\u0004\"\u0004\bG\u0010HR$\u0010J\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00068\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006V"}, d2 = {"Lcom/discord/stores/StoreAudioManagerV2;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/stores/StoreAudioManagerV2$State;", "getAudioManagerState", "()Lcom/discord/stores/StoreAudioManagerV2$State;", "", "Lcom/discord/rtcconnection/audio/DiscordAudioManager$AudioDevice;", "devices", "", "updateAudioDevices", "(Ljava/util/List;)V", "Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;", "device", "updateActiveAudioDevice", "(Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;)V", "", "currentMediaVolumeIndex", "updateCurrentMediaVolume", "(I)V", "Landroid/app/Application;", "context", "init", "(Landroid/app/Application;)V", "Lrx/Observable;", "observeAudioManagerState", "()Lrx/Observable;", "toggleSpeakerOutput", "()V", "selectOutputDevice", "", "ratio", "updateMediaVolume", "(F)V", "handleVoiceStatesUpdated", "Lcom/discord/rtcconnection/RtcConnection$State;", "state", "handleRtcConnectionState", "(Lcom/discord/rtcconnection/RtcConnection$State;)V", "snapshotData", "Lcom/discord/stores/StoreVoiceChannelSelected;", "voiceChannelSelectedStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "stateSnapshot", "Lcom/discord/stores/StoreAudioManagerV2$State;", "Lcom/discord/stores/StoreAudioManagerV2$VideoUseDetector;", "videoUseDetector", "Lcom/discord/stores/StoreAudioManagerV2$VideoUseDetector;", "Landroid/os/Handler;", "audioManagerHandler", "Landroid/os/Handler;", "", "prevMyVideoOn", "Z", "Landroid/content/Context;", "Landroid/content/Context;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/StoreExperiments;", "experimentsStore", "Lcom/discord/stores/StoreExperiments;", "Landroid/os/HandlerThread;", "audioManagerThread", "Landroid/os/HandlerThread;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/StoreStreamRtcConnection;", "streamRtcConnectionStore", "Lcom/discord/stores/StoreStreamRtcConnection;", "getState$app_productionGoogleRelease", "setState$app_productionGoogleRelease", "(Lcom/discord/stores/StoreAudioManagerV2$State;)V", "<set-?>", "lastActiveAudioDevice", "Lcom/discord/rtcconnection/audio/DiscordAudioManager$AudioDevice;", "getLastActiveAudioDevice$app_productionGoogleRelease", "()Lcom/discord/rtcconnection/audio/DiscordAudioManager$AudioDevice;", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreChannels;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreStreamRtcConnection;Lcom/discord/stores/StoreAudioManagerV2$VideoUseDetector;Lcom/discord/stores/StoreExperiments;)V", "Companion", "State", "VideoUseDetector", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreAudioManagerV2 extends StoreV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final State DEFAULT_STATE;
    private Handler audioManagerHandler;
    private final HandlerThread audioManagerThread;
    private final StoreChannels channelsStore;
    private Context context;
    private final Dispatcher dispatcher;
    private final StoreExperiments experimentsStore;
    private DiscordAudioManager.AudioDevice lastActiveAudioDevice;
    private final ObservationDeck observationDeck;
    private boolean prevMyVideoOn;
    private State state;
    private State stateSnapshot;
    private final StoreStreamRtcConnection streamRtcConnectionStore;
    private final VideoUseDetector videoUseDetector;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    /* compiled from: StoreAudioManagerV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0001X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreAudioManagerV2$Companion;", "", "Lcom/discord/stores/StoreAudioManagerV2$State;", "DEFAULT_STATE", "Lcom/discord/stores/StoreAudioManagerV2$State;", "getDEFAULT_STATE$app_productionGoogleRelease", "()Lcom/discord/stores/StoreAudioManagerV2$State;", "getDEFAULT_STATE$app_productionGoogleRelease$annotations", "()V", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getDEFAULT_STATE$app_productionGoogleRelease$annotations() {
        }

        public final State getDEFAULT_STATE$app_productionGoogleRelease() {
            return StoreAudioManagerV2.access$getDEFAULT_STATE$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u001aR(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/discord/stores/StoreAudioManagerV2$State;", "", "", "Lcom/discord/rtcconnection/audio/DiscordAudioManager$AudioDevice;", "component1", "()Ljava/util/List;", "Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;", "component2", "()Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;", "audioDevices", "activeAudioDevice", "copy", "(Ljava/util/List;Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;)Lcom/discord/stores/StoreAudioManagerV2$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;", "getActiveAudioDevice", "setActiveAudioDevice", "(Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;)V", "Ljava/util/List;", "getAudioDevices", "setAudioDevices", "(Ljava/util/List;)V", "<init>", "(Ljava/util/List;Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class State {
        private DiscordAudioManager.DeviceTypes activeAudioDevice;
        private List<DiscordAudioManager.AudioDevice> audioDevices;

        public State() {
            this(null, null, 3, null);
        }

        public State(List<DiscordAudioManager.AudioDevice> list, DiscordAudioManager.DeviceTypes deviceTypes) {
            Intrinsics3.checkNotNullParameter(list, "audioDevices");
            Intrinsics3.checkNotNullParameter(deviceTypes, "activeAudioDevice");
            this.audioDevices = list;
            this.activeAudioDevice = deviceTypes;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, List list, DiscordAudioManager.DeviceTypes deviceTypes, int i, Object obj) {
            if ((i & 1) != 0) {
                list = state.audioDevices;
            }
            if ((i & 2) != 0) {
                deviceTypes = state.activeAudioDevice;
            }
            return state.copy(list, deviceTypes);
        }

        public final List<DiscordAudioManager.AudioDevice> component1() {
            return this.audioDevices;
        }

        /* renamed from: component2, reason: from getter */
        public final DiscordAudioManager.DeviceTypes getActiveAudioDevice() {
            return this.activeAudioDevice;
        }

        public final State copy(List<DiscordAudioManager.AudioDevice> audioDevices, DiscordAudioManager.DeviceTypes activeAudioDevice) {
            Intrinsics3.checkNotNullParameter(audioDevices, "audioDevices");
            Intrinsics3.checkNotNullParameter(activeAudioDevice, "activeAudioDevice");
            return new State(audioDevices, activeAudioDevice);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.audioDevices, state.audioDevices) && Intrinsics3.areEqual(this.activeAudioDevice, state.activeAudioDevice);
        }

        public final DiscordAudioManager.DeviceTypes getActiveAudioDevice() {
            return this.activeAudioDevice;
        }

        public final List<DiscordAudioManager.AudioDevice> getAudioDevices() {
            return this.audioDevices;
        }

        public int hashCode() {
            List<DiscordAudioManager.AudioDevice> list = this.audioDevices;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            DiscordAudioManager.DeviceTypes deviceTypes = this.activeAudioDevice;
            return iHashCode + (deviceTypes != null ? deviceTypes.hashCode() : 0);
        }

        public final void setActiveAudioDevice(DiscordAudioManager.DeviceTypes deviceTypes) {
            Intrinsics3.checkNotNullParameter(deviceTypes, "<set-?>");
            this.activeAudioDevice = deviceTypes;
        }

        public final void setAudioDevices(List<DiscordAudioManager.AudioDevice> list) {
            Intrinsics3.checkNotNullParameter(list, "<set-?>");
            this.audioDevices = list;
        }

        public String toString() {
            StringBuilder sbU = outline.U("State(audioDevices=");
            sbU.append(this.audioDevices);
            sbU.append(", activeAudioDevice=");
            sbU.append(this.activeAudioDevice);
            sbU.append(")");
            return sbU.toString();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ State(List list, DiscordAudioManager.DeviceTypes deviceTypes, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
                list = DiscordAudioManager.f();
            }
            this(list, (i & 2) != 0 ? DiscordAudioManager.DeviceTypes.INVALID : deviceTypes);
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0003¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/discord/stores/StoreAudioManagerV2$VideoUseDetector;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/api/voice/state/VoiceState;", "getVoiceStatesForChannel", "(J)Ljava/util/Map;", "", "isMyVideoOn", "(J)Z", "Lcom/discord/stores/StoreVoiceStates;", "voiceStatesStore", "Lcom/discord/stores/StoreVoiceStates;", "Lcom/discord/stores/StoreUser;", "usersStore", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreChannels;", "<init>", "(Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreVoiceStates;Lcom/discord/stores/StoreUser;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class VideoUseDetector {
        private final StoreChannels channelsStore;
        private final StoreUser usersStore;
        private final StoreVoiceStates voiceStatesStore;

        public VideoUseDetector(StoreChannels storeChannels, StoreVoiceStates storeVoiceStates, StoreUser storeUser) {
            Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
            Intrinsics3.checkNotNullParameter(storeVoiceStates, "voiceStatesStore");
            Intrinsics3.checkNotNullParameter(storeUser, "usersStore");
            this.channelsStore = storeChannels;
            this.voiceStatesStore = storeVoiceStates;
            this.usersStore = storeUser;
        }

        @Store3
        private final Map<Long, VoiceState> getVoiceStatesForChannel(long channelId) {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.channelsStore.findChannelByIdInternal$app_productionGoogleRelease(channelId);
            Map<Long, VoiceState> map = this.voiceStatesStore.getInternal$app_productionGoogleRelease().get(channelFindChannelByIdInternal$app_productionGoogleRelease != null ? Long.valueOf(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId()) : null);
            if (map == null) {
                return Maps6.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, VoiceState> entry : map.entrySet()) {
                Long channelId2 = entry.getValue().getChannelId();
                if (channelId2 != null && channelId2.longValue() == channelId) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }

        @Store3
        public final boolean isMyVideoOn(long channelId) {
            VoiceState voiceState = getVoiceStatesForChannel(channelId).get(Long.valueOf(this.usersStore.getMe().getId()));
            if (voiceState == null) {
                return false;
            }
            Intrinsics3.checkNotNullParameter(voiceState, "$this$hasVideo");
            return voiceState.getSelfStream() || voiceState.getSelfVideo();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            DiscordAudioManager.DeviceTypes.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            iArr[DiscordAudioManager.DeviceTypes.SPEAKERPHONE.ordinal()] = 1;
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAudioManagerV2$handleRtcConnectionState$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            DiscordAudioManager.d().h(true);
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAudioManagerV2$handleRtcConnectionState$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Runnable {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            DiscordAudioManager.d().h(false);
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {

        /* compiled from: StoreAudioManagerV2.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/rtcconnection/audio/DiscordAudioManager$AudioDevice;", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00871 extends Lambda implements Function1<List<? extends DiscordAudioManager.AudioDevice>, Unit> {

            /* compiled from: StoreAudioManagerV2.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00881 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00881(List list) {
                    super(0);
                    this.$it = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreAudioManagerV2.access$updateAudioDevices(StoreAudioManagerV2.this, this.$it);
                }
            }

            public C00871() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends DiscordAudioManager.AudioDevice> list) {
                invoke2((List<DiscordAudioManager.AudioDevice>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<DiscordAudioManager.AudioDevice> list) {
                Intrinsics3.checkNotNullParameter(list, "it");
                StoreAudioManagerV2.access$getDispatcher$p(StoreAudioManagerV2.this).schedule(new C00881(list));
            }
        }

        /* compiled from: StoreAudioManagerV2.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;", "it", "", "invoke", "(Lcom/discord/rtcconnection/audio/DiscordAudioManager$DeviceTypes;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<DiscordAudioManager.DeviceTypes, Unit> {

            /* compiled from: StoreAudioManagerV2.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C00891 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ DiscordAudioManager.DeviceTypes $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00891(DiscordAudioManager.DeviceTypes deviceTypes) {
                    super(0);
                    this.$it = deviceTypes;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreAudioManagerV2.access$updateActiveAudioDevice(StoreAudioManagerV2.this, this.$it);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DiscordAudioManager.DeviceTypes deviceTypes) {
                invoke2(deviceTypes);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DiscordAudioManager.DeviceTypes deviceTypes) {
                Intrinsics3.checkNotNullParameter(deviceTypes, "it");
                StoreAudioManagerV2.access$getDispatcher$p(StoreAudioManagerV2.this).schedule(new C00891(deviceTypes));
            }
        }

        /* compiled from: StoreAudioManagerV2.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(I)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function1<Integer, Unit> {

            /* compiled from: StoreAudioManagerV2.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreAudioManagerV2$init$1$3$1, reason: invalid class name and collision with other inner class name */
            public static final class C00901 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ int $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00901(int i) {
                    super(0);
                    this.$it = i;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreAudioManagerV2.access$updateCurrentMediaVolume(StoreAudioManagerV2.this, this.$it);
                }
            }

            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.a;
            }

            public final void invoke(int i) {
                StoreAudioManagerV2.access$getDispatcher$p(StoreAudioManagerV2.this).schedule(new C00901(i));
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            Observable<List<DiscordAudioManager.AudioDevice>> observableR = DiscordAudioManager.d().f2785s.r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "audioDevicesSubject.distinctUntilChanged()");
            ObservableExtensionsKt.appSubscribe$default(observableR, StoreAudioManagerV2.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C00871(), 62, (Object) null);
            Observable<DiscordAudioManager.DeviceTypes> observableR2 = DiscordAudioManager.d().u.r();
            Intrinsics3.checkNotNullExpressionValue(observableR2, "activeAudioDeviceSubject.distinctUntilChanged()");
            ObservableExtensionsKt.appSubscribe$default(observableR2, StoreAudioManagerV2.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
            Observable<Integer> observableR3 = DiscordAudioManager.d().f2787y.r();
            Intrinsics3.checkNotNullExpressionValue(observableR3, "currentMediaVolumeSubject.distinctUntilChanged()");
            ObservableExtensionsKt.appSubscribe$default(observableR3, StoreAudioManagerV2.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreAudioManagerV2$State;", "invoke", "()Lcom/discord/stores/StoreAudioManagerV2$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAudioManagerV2$observeAudioManagerState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<State> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreAudioManagerV2.access$getAudioManagerState(StoreAudioManagerV2.this);
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAudioManagerV2$selectOutputDevice$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ DiscordAudioManager.DeviceTypes $device;

        public AnonymousClass1(DiscordAudioManager.DeviceTypes deviceTypes) {
            this.$device = deviceTypes;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList;
            boolean z2;
            boolean z3;
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            DiscordAudioManager discordAudioManagerD = DiscordAudioManager.d();
            DiscordAudioManager.DeviceTypes deviceTypes = this.$device;
            Objects.requireNonNull(discordAudioManagerD);
            Intrinsics3.checkNotNullParameter(deviceTypes, "deviceType");
            discordAudioManagerD.c();
            if (!discordAudioManagerD.e().f262b) {
                AnimatableValueParser.f1("DiscordAudioManager", "Can't setDevice, requires MODIFY_AUDIO_SETTINGS.");
                return;
            }
            AnimatableValueParser.b1("DiscordAudioManager", "setDevice(deviceType=" + deviceTypes + ')');
            synchronized (discordAudioManagerD.i) {
                List<DiscordAudioManager.AudioDevice> list = discordAudioManagerD.r;
                arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(DiscordAudioManager.AudioDevice.a((DiscordAudioManager.AudioDevice) it.next(), null, false, null, null, 15));
                }
            }
            DiscordAudioManager.DeviceTypes deviceTypes2 = DiscordAudioManager.DeviceTypes.DEFAULT;
            if (deviceTypes == deviceTypes2) {
                synchronized (discordAudioManagerD.i) {
                    discordAudioManagerD.f2788z = deviceTypes2;
                }
                discordAudioManagerD.a(arrayList);
                return;
            }
            int iOrdinal = deviceTypes.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                z2 = false;
            } else {
                if (iOrdinal != 2 && iOrdinal != 3 && iOrdinal != 4 && iOrdinal != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                z2 = true;
            }
            if (z2) {
                synchronized (discordAudioManagerD.i) {
                    z3 = true ^ discordAudioManagerD.r.get(deviceTypes.getValue()).isAvailable;
                }
                if (z3) {
                    return;
                }
                synchronized (discordAudioManagerD.i) {
                    discordAudioManagerD.f2788z = deviceTypes;
                }
                discordAudioManagerD.b(deviceTypes);
            }
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAudioManagerV2$toggleSpeakerOutput$1, reason: invalid class name */
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
            DiscordAudioManager.DeviceTypes deviceTypesPrevious;
            if (StoreAudioManagerV2.this.getState().getActiveAudioDevice().ordinal() != 2) {
                StoreAudioManagerV2.this.selectOutputDevice(DiscordAudioManager.DeviceTypes.SPEAKERPHONE);
                return;
            }
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            List<DiscordAudioManager.DeviceTypes> list = DiscordAudioManager.c;
            ListIterator<DiscordAudioManager.DeviceTypes> listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    deviceTypesPrevious = null;
                    break;
                }
                deviceTypesPrevious = listIterator.previous();
                DiscordAudioManager.DeviceTypes deviceTypes = deviceTypesPrevious;
                if (deviceTypes != DiscordAudioManager.DeviceTypes.SPEAKERPHONE && StoreAudioManagerV2.this.getState().getAudioDevices().get(deviceTypes.getValue()).isAvailable) {
                    break;
                }
            }
            Intrinsics3.checkNotNull(deviceTypesPrevious);
            StoreAudioManagerV2.this.selectOutputDevice(deviceTypesPrevious);
        }
    }

    /* compiled from: StoreAudioManagerV2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreAudioManagerV2$updateMediaVolume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ float $ratio;

        public AnonymousClass1(float f) {
            this.$ratio = f;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            DiscordAudioManager discordAudioManagerD = DiscordAudioManager.d();
            float f = this.$ratio;
            discordAudioManagerD.c();
            if (f < 0.0f || f > 1.0f) {
                AnimatableValueParser.f1("DiscordAudioManager", "Unexpected media volume ratio: " + f);
                return;
            }
            try {
                discordAudioManagerD.e.setStreamVolume(3, MathJVM.roundToInt(f * discordAudioManagerD.f2786x), 0);
            } catch (SecurityException e) {
                AnimatableValueParser.f1("DiscordAudioManager", "Failed to set stream volume: " + e);
            }
        }
    }

    static {
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        DEFAULT_STATE = new State(DiscordAudioManager.f(), DiscordAudioManager.DeviceTypes.EARPIECE);
    }

    public StoreAudioManagerV2(ObservationDeck observationDeck, Dispatcher dispatcher, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StoreStreamRtcConnection storeStreamRtcConnection, VideoUseDetector videoUseDetector, StoreExperiments storeExperiments) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeStreamRtcConnection, "streamRtcConnectionStore");
        Intrinsics3.checkNotNullParameter(videoUseDetector, "videoUseDetector");
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.channelsStore = storeChannels;
        this.streamRtcConnectionStore = storeStreamRtcConnection;
        this.videoUseDetector = videoUseDetector;
        this.experimentsStore = storeExperiments;
        State state = new State(null, null, 3, null);
        this.state = state;
        this.stateSnapshot = state;
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        this.lastActiveAudioDevice = DiscordAudioManager.f2784b;
        this.audioManagerThread = new HandlerThread("AudioManagerThread", -1);
    }

    public static final /* synthetic */ State access$getAudioManagerState(StoreAudioManagerV2 storeAudioManagerV2) {
        return storeAudioManagerV2.getStateSnapshot();
    }

    public static final /* synthetic */ State access$getDEFAULT_STATE$cp() {
        return DEFAULT_STATE;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreAudioManagerV2 storeAudioManagerV2) {
        return storeAudioManagerV2.dispatcher;
    }

    public static final /* synthetic */ void access$updateActiveAudioDevice(StoreAudioManagerV2 storeAudioManagerV2, DiscordAudioManager.DeviceTypes deviceTypes) {
        storeAudioManagerV2.updateActiveAudioDevice(deviceTypes);
    }

    public static final /* synthetic */ void access$updateAudioDevices(StoreAudioManagerV2 storeAudioManagerV2, List list) {
        storeAudioManagerV2.updateAudioDevices(list);
    }

    public static final /* synthetic */ void access$updateCurrentMediaVolume(StoreAudioManagerV2 storeAudioManagerV2, int i) {
        storeAudioManagerV2.updateCurrentMediaVolume(i);
    }

    /* renamed from: getAudioManagerState, reason: from getter */
    private final State getStateSnapshot() {
        return this.stateSnapshot;
    }

    @Store3
    private final void updateActiveAudioDevice(DiscordAudioManager.DeviceTypes device) {
        State stateCopy$default = State.copy$default(this.state, null, device, 1, null);
        this.state = stateCopy$default;
        if (device != DiscordAudioManager.DeviceTypes.INVALID && device != DiscordAudioManager.DeviceTypes.DEFAULT) {
            this.lastActiveAudioDevice = stateCopy$default.getAudioDevices().get(device.getValue());
        }
        markChanged();
    }

    @Store3
    private final void updateAudioDevices(List<DiscordAudioManager.AudioDevice> devices) {
        this.state = State.copy$default(this.state, devices, null, 2, null);
        markChanged();
    }

    private final void updateCurrentMediaVolume(int currentMediaVolumeIndex) {
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        this.streamRtcConnectionStore.updateStreamVolume(PerceptualVolumeUtils.INSTANCE.perceptualToAmplitude((currentMediaVolumeIndex / DiscordAudioManager.d().f2786x) * 300.0f, 300.0f));
    }

    /* renamed from: getLastActiveAudioDevice$app_productionGoogleRelease, reason: from getter */
    public final DiscordAudioManager.AudioDevice getLastActiveAudioDevice() {
        return this.lastActiveAudioDevice;
    }

    /* renamed from: getState$app_productionGoogleRelease, reason: from getter */
    public final State getState() {
        return this.state;
    }

    @Store3
    public final void handleRtcConnectionState(RtcConnection.State state) {
        Intrinsics3.checkNotNullParameter(state, "state");
        if (Intrinsics3.areEqual(state, RtcConnection.State.f.a)) {
            Handler handler = this.audioManagerHandler;
            if (handler == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("audioManagerHandler");
            }
            handler.post(AnonymousClass1.INSTANCE);
            return;
        }
        if (!(state instanceof RtcConnection.State.d) || ((RtcConnection.State.d) state).a) {
            return;
        }
        Handler handler2 = this.audioManagerHandler;
        if (handler2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler2.post(AnonymousClass2.INSTANCE);
    }

    @Store3
    public final void handleVoiceStatesUpdated() {
        boolean zIsMyVideoOn = this.videoUseDetector.isMyVideoOn(this.voiceChannelSelectedStore.getSelectedVoiceChannelId());
        if (zIsMyVideoOn == this.prevMyVideoOn) {
            return;
        }
        if (zIsMyVideoOn) {
            DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
            DiscordAudioManager discordAudioManagerD = DiscordAudioManager.d();
            synchronized (discordAudioManagerD) {
                if (discordAudioManagerD.r.get(DiscordAudioManager.DeviceTypes.EARPIECE.getValue()).isAvailable) {
                    List<DiscordAudioManager.AudioDevice> list = discordAudioManagerD.r;
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                    for (DiscordAudioManager.AudioDevice audioDevice : list) {
                        arrayList.add(audioDevice.type.ordinal() != 4 ? DiscordAudioManager.AudioDevice.a(audioDevice, null, false, null, null, 15) : DiscordAudioManager.AudioDevice.a(audioDevice, null, false, null, null, 13));
                    }
                    discordAudioManagerD.r = arrayList;
                    discordAudioManagerD.f2785s.k.onNext(arrayList);
                    discordAudioManagerD.l();
                }
            }
        } else {
            DiscordAudioManager discordAudioManager2 = DiscordAudioManager.d;
            DiscordAudioManager discordAudioManagerD2 = DiscordAudioManager.d();
            synchronized (discordAudioManagerD2) {
                if (discordAudioManagerD2.r.get(DiscordAudioManager.DeviceTypes.EARPIECE.getValue()).isAvailable != discordAudioManagerD2.h) {
                    List<DiscordAudioManager.AudioDevice> list2 = discordAudioManagerD2.r;
                    ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
                    for (DiscordAudioManager.AudioDevice audioDevice2 : list2) {
                        arrayList2.add(audioDevice2.type.ordinal() != 4 ? DiscordAudioManager.AudioDevice.a(audioDevice2, null, false, null, null, 15) : DiscordAudioManager.AudioDevice.a(audioDevice2, null, discordAudioManagerD2.h, null, null, 13));
                    }
                    discordAudioManagerD2.r = arrayList2;
                    discordAudioManagerD2.f2785s.k.onNext(arrayList2);
                    discordAudioManagerD2.l();
                }
            }
        }
        this.prevMyVideoOn = zIsMyVideoOn;
    }

    public final void init(Application context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.context = context;
        if (!this.audioManagerThread.isAlive()) {
            this.audioManagerThread.start();
        }
        Handler handler = new Handler(this.audioManagerThread.getLooper());
        this.audioManagerHandler = handler;
        if (handler == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler.post(new AnonymousClass1());
    }

    public final Observable<State> observeAudioManagerState() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final void selectOutputDevice(DiscordAudioManager.DeviceTypes device) {
        Intrinsics3.checkNotNullParameter(device, "device");
        Handler handler = this.audioManagerHandler;
        if (handler == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler.post(new AnonymousClass1(device));
    }

    public final void setState$app_productionGoogleRelease(State state) {
        Intrinsics3.checkNotNullParameter(state, "<set-?>");
        this.state = state;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        List<DiscordAudioManager.AudioDevice> audioDevices = this.state.getAudioDevices();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(audioDevices, 10));
        Iterator<T> it = audioDevices.iterator();
        while (it.hasNext()) {
            arrayList.add(DiscordAudioManager.AudioDevice.a((DiscordAudioManager.AudioDevice) it.next(), null, false, null, null, 15));
        }
        this.stateSnapshot = this.state.copy(arrayList, this.state.getActiveAudioDevice());
    }

    public final void toggleSpeakerOutput() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void updateMediaVolume(float ratio) {
        Handler handler = this.audioManagerHandler;
        if (handler == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("audioManagerHandler");
        }
        handler.post(new AnonymousClass1(ratio));
    }
}
