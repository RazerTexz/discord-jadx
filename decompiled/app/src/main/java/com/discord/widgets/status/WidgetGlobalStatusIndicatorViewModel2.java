package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreConnectivity;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import rx.Observable;

/* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicatorViewModel2<T, R> implements Func1<Channel, Observable<? extends WidgetGlobalStatusIndicatorViewModel.StoreState>> {
    public final /* synthetic */ ObservationDeck $observationDeck;
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreConnectivity $storeConnectivity;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreRtcConnection $storeRtcConnection;
    public final /* synthetic */ StoreStageChannels $storeStageChannels;
    public final /* synthetic */ StoreStageInstances $storeStageInstances;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;
    public final /* synthetic */ StoreVoiceParticipants $storeVoiceParticipants;
    public final /* synthetic */ StreamContextService $streamContextService;

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreConnectivity$DelayedState;", "p1", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState;", "invoke", "(Lcom/discord/stores/StoreConnectivity$DelayedState;)Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreConnectivity.DelayedState, WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1, WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState.class, "<init>", "<init>(Lcom/discord/stores/StoreConnectivity$DelayedState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState invoke(StoreConnectivity.DelayedState delayedState) {
            return invoke2(delayedState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState invoke2(StoreConnectivity.DelayedState delayedState) {
            Intrinsics3.checkNotNullParameter(delayedState, "p1");
            return new WidgetGlobalStatusIndicatorViewModel.StoreState.ConnectivityState(delayedState);
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Integer> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Channel channel) {
            super(0);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            Map<Long, StageRoles> channelRoles = WidgetGlobalStatusIndicatorViewModel2.this.$storeStageChannels.getChannelRoles(this.$channel.getId());
            Map<Long, Integer> relationships = WidgetGlobalStatusIndicatorViewModel2.this.$storeUserRelationships.getRelationships();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Integer> entry : relationships.entrySet()) {
                if (entry.getValue().intValue() == 2 && channelRoles != null && channelRoles.containsKey(Long.valueOf(entry.getKey().longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap.size();
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0016\u0010\r\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0017\u0010\u0018"}, d2 = {"Lcom/discord/api/channel/Channel;", "p1", "p2", "Lcom/discord/rtcconnection/RtcConnection$StateChange;", "p3", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "p4", "Lcom/discord/models/guild/Guild;", "p5", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "p6", "Lcom/discord/utilities/streams/StreamContext;", "p7", "Lcom/discord/api/voice/state/StageRequestToSpeakState;", "p8", "", "p9", "Lcom/discord/api/stageinstance/StageInstance;", "p10", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing;", "invoke", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/RtcConnection$StateChange;Lcom/discord/rtcconnection/RtcConnection$Quality;Lcom/discord/models/guild/Guild;Ljava/util/Map;Lcom/discord/utilities/streams/StreamContext;Lcom/discord/api/voice/state/StageRequestToSpeakState;ILcom/discord/api/stageinstance/StageInstance;)Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function10<Channel, Channel, RtcConnection.StateChange, RtcConnection.Quality, Guild, Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, StreamContext, StageRequestToSpeakState, Integer, StageInstance, WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(10, WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing.class, "<init>", "<init>(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/RtcConnection$StateChange;Lcom/discord/rtcconnection/RtcConnection$Quality;Lcom/discord/models/guild/Guild;Ljava/util/Map;Lcom/discord/utilities/streams/StreamContext;Lcom/discord/api/voice/state/StageRequestToSpeakState;ILcom/discord/api/stageinstance/StageInstance;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing invoke(Channel channel, Channel channel2, RtcConnection.StateChange stateChange, RtcConnection.Quality quality, Guild guild, Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, Integer num, StageInstance stageInstance) {
            return invoke(channel, channel2, stateChange, quality, guild, (Map<Long, StoreVoiceParticipants.VoiceUser>) map, streamContext, stageRequestToSpeakState, num.intValue(), stageInstance);
        }

        public final WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing invoke(Channel channel, Channel channel2, RtcConnection.StateChange stateChange, RtcConnection.Quality quality, Guild guild, Map<Long, StoreVoiceParticipants.VoiceUser> map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, int i, StageInstance stageInstance) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            Intrinsics3.checkNotNullParameter(stateChange, "p3");
            Intrinsics3.checkNotNullParameter(quality, "p4");
            Intrinsics3.checkNotNullParameter(map, "p6");
            Intrinsics3.checkNotNullParameter(stageRequestToSpeakState, "p8");
            return new WidgetGlobalStatusIndicatorViewModel.StoreState.CallOngoing(channel, channel2, stateChange, quality, guild, map, streamContext, stageRequestToSpeakState, i, stageInstance);
        }
    }

    public WidgetGlobalStatusIndicatorViewModel2(StoreConnectivity storeConnectivity, StoreChannelsSelected storeChannelsSelected, StoreRtcConnection storeRtcConnection, StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, StreamContextService streamContextService, StoreStageChannels storeStageChannels, ObservationDeck observationDeck, StoreUserRelationships storeUserRelationships, StoreStageInstances storeStageInstances) {
        this.$storeConnectivity = storeConnectivity;
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storeRtcConnection = storeRtcConnection;
        this.$storeGuilds = storeGuilds;
        this.$storeVoiceParticipants = storeVoiceParticipants;
        this.$streamContextService = streamContextService;
        this.$storeStageChannels = storeStageChannels;
        this.$observationDeck = observationDeck;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storeStageInstances = storeStageInstances;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGlobalStatusIndicatorViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$1, kotlin.jvm.functions.Function1] */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGlobalStatusIndicatorViewModel.StoreState> call2(Channel channel) {
        if (channel != null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(channel);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n                        .just(channel)");
            return ObservableCombineLatestOverloads2.combineLatest(scalarSynchronousObservable, this.$storeChannelsSelected.observeSelectedChannel(), this.$storeRtcConnection.getConnectionState(), this.$storeRtcConnection.getQuality(), this.$storeGuilds.observeGuild(channel.getGuildId()), this.$storeVoiceParticipants.get(channel.getId()), this.$streamContextService.getForActiveStream(), this.$storeStageChannels.observeMyRequestToSpeakState(channel.getId()), ObservationDeck.connectRx$default(this.$observationDeck, new ObservationDeck.UpdateSource[]{this.$storeUserRelationships, this.$storeStageChannels}, false, null, null, new AnonymousClass2(channel), 14, null), this.$storeStageInstances.observeStageInstanceForChannel(channel.getId()), AnonymousClass3.INSTANCE);
        }
        Observable<StoreConnectivity.DelayedState> observableObserveState = this.$storeConnectivity.observeState();
        ?? r2 = AnonymousClass1.INSTANCE;
        WidgetGlobalStatusIndicatorViewModel3 widgetGlobalStatusIndicatorViewModel3 = r2;
        if (r2 != 0) {
            widgetGlobalStatusIndicatorViewModel3 = new WidgetGlobalStatusIndicatorViewModel3(r2);
        }
        return observableObserveState.G(widgetGlobalStatusIndicatorViewModel3);
    }
}
