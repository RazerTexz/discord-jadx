package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreMediaSettings;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.voice.VoiceEngineServiceController;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: VoiceEngineServiceController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/rtcconnection/RtcConnection$StateChange;", "kotlin.jvm.PlatformType", "stateChange", "Lrx/Observable;", "Lcom/discord/utilities/voice/VoiceEngineServiceController$NotificationData;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/rtcconnection/RtcConnection$StateChange;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.voice.VoiceEngineServiceController$notificationDataObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class VoiceEngineServiceController3<T, R> implements Func1<RtcConnection.StateChange, Observable<? extends VoiceEngineServiceController.NotificationData>> {
    public final /* synthetic */ VoiceEngineServiceController this$0;

    /* compiled from: VoiceEngineServiceController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", "selectedVoiceChannelId", "Lrx/Observable;", "Lcom/discord/utilities/voice/VoiceEngineServiceController$NotificationData;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.voice.VoiceEngineServiceController$notificationDataObservable$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Long, Observable<? extends VoiceEngineServiceController.NotificationData>> {
        public final /* synthetic */ RtcConnection.State $state;

        /* compiled from: VoiceEngineServiceController.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;", "kotlin.jvm.PlatformType", "voiceConfig", "Lcom/discord/stores/StoreAudioManagerV2$State;", "audioManagerState", "Lcom/discord/widgets/voice/model/CallModel;", "callModel", "Lcom/discord/utilities/voice/VoiceEngineServiceController$NotificationData;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreMediaSettings$VoiceConfiguration;Lcom/discord/stores/StoreAudioManagerV2$State;Lcom/discord/widgets/voice/model/CallModel;)Lcom/discord/utilities/voice/VoiceEngineServiceController$NotificationData;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.voice.VoiceEngineServiceController$notificationDataObservable$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02301<T1, T2, T3, R> implements Func3<StoreMediaSettings.VoiceConfiguration, StoreAudioManagerV2.State, CallModel, VoiceEngineServiceController.NotificationData> {
            public C02301() {
            }

            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ VoiceEngineServiceController.NotificationData call(StoreMediaSettings.VoiceConfiguration voiceConfiguration, StoreAudioManagerV2.State state, CallModel callModel) {
                return call2(voiceConfiguration, state, callModel);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final VoiceEngineServiceController.NotificationData call2(StoreMediaSettings.VoiceConfiguration voiceConfiguration, StoreAudioManagerV2.State state, CallModel callModel) {
                Channel channel;
                Channel channel2;
                Channel channel3;
                boolean z2 = false;
                boolean z3 = callModel != null && callModel.getIsVideoCall();
                boolean z4 = !z3 && (state.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.EARPIECE);
                boolean z5 = callModel == null || !callModel.isSuppressed();
                RtcConnection.State state2 = AnonymousClass1.this.$state;
                String strC = (callModel == null || (channel3 = callModel.getChannel()) == null) ? null : ChannelUtils.c(channel3);
                if (strC == null) {
                    strC = "";
                }
                boolean zIsSelfMuted = voiceConfiguration.isSelfMuted();
                boolean zIsSelfDeafened = voiceConfiguration.isSelfDeafened();
                boolean z6 = callModel != null && callModel.isStreaming();
                long id2 = (callModel == null || (channel2 = callModel.getChannel()) == null) ? -1L : channel2.getId();
                Long lValueOf = (callModel == null || (channel = callModel.getChannel()) == null) ? null : Long.valueOf(channel.getGuildId());
                if (lValueOf != null && lValueOf.longValue() > 0) {
                    z2 = true;
                }
                if (!z2) {
                    lValueOf = null;
                }
                return new VoiceEngineServiceController.NotificationData(state2, strC, zIsSelfMuted, zIsSelfDeafened, z6, z3, id2, lValueOf, z4, z5);
            }
        }

        public AnonymousClass1(RtcConnection.State state) {
            this.$state = state;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends VoiceEngineServiceController.NotificationData> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends VoiceEngineServiceController.NotificationData> call2(Long l) {
            Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = VoiceEngineServiceController.access$getMediaSettingsStore$p(VoiceEngineServiceController3.this.this$0).getVoiceConfig();
            Observable<StoreAudioManagerV2.State> observableObserveAudioManagerState = VoiceEngineServiceController.access$getAudioManagerStore$p(VoiceEngineServiceController3.this.this$0).observeAudioManagerState();
            CallModel.Companion companion = CallModel.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(l, "selectedVoiceChannelId");
            return ObservableWithLeadingEdgeThrottle.combineLatest(voiceConfig, observableObserveAudioManagerState, companion.get(l.longValue()), new C02301(), 300L, TimeUnit.MILLISECONDS);
        }
    }

    public VoiceEngineServiceController3(VoiceEngineServiceController voiceEngineServiceController) {
        this.this$0 = voiceEngineServiceController;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends VoiceEngineServiceController.NotificationData> call(RtcConnection.StateChange stateChange) {
        return call2(stateChange);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends VoiceEngineServiceController.NotificationData> call2(RtcConnection.StateChange stateChange) {
        RtcConnection.State state = stateChange.state;
        return Intrinsics3.areEqual(state, RtcConnection.State.h.a) ? new ScalarSynchronousObservable(VoiceEngineServiceController.access$getNOTIFICATION_DATA_DISCONNECTED$cp()) : VoiceEngineServiceController.access$getVoiceChannelSelectedStore$p(this.this$0).observeSelectedVoiceChannelId().Y(new AnonymousClass1(state));
    }
}
