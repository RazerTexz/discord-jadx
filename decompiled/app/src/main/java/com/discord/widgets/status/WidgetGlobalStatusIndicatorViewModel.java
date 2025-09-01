package com.discord.widgets.status;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreConnectivity;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreRtcConnection;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.stage.StageChannelAPI;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0010\u0011\u0012B\u0017\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState;)V", "", "accept", "ackStageInvitationToSpeak", "(Z)V", "Lrx/Observable;", "storeStateObservable", "<init>", "(Lrx/Observable;)V", "Companion", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicatorViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel) {
            super(1, widgetGlobalStatusIndicatorViewModel, WidgetGlobalStatusIndicatorViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            WidgetGlobalStatusIndicatorViewModel.access$handleStoreState((WidgetGlobalStatusIndicatorViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u008d\u0001\u0010\u001b\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u00180\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$Companion;", "", "Lcom/discord/utilities/streams/StreamContextService;", "streamContextService", "Lcom/discord/stores/StoreVoiceChannelSelected;", "storeVoiceChannelSelected", "Lcom/discord/stores/StoreConnectivity;", "storeConnectivity", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreRtcConnection;", "storeRtcConnection", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreVoiceParticipants;", "storeVoiceParticipants", "Lcom/discord/stores/StoreStageChannels;", "storeStageChannels", "Lcom/discord/stores/StoreUserRelationships;", "storeUserRelationships", "Lcom/discord/stores/StoreStageInstances;", "storeStageInstances", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lrx/Observable;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState;", "kotlin.jvm.PlatformType", "observeStoreState", "(Lcom/discord/utilities/streams/StreamContextService;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreConnectivity;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreRtcConnection;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreVoiceParticipants;Lcom/discord/stores/StoreStageChannels;Lcom/discord/stores/StoreUserRelationships;Lcom/discord/stores/StoreStageInstances;Lcom/discord/stores/updates/ObservationDeck;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StreamContextService streamContextService, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreConnectivity storeConnectivity, StoreChannelsSelected storeChannelsSelected, StoreRtcConnection storeRtcConnection, StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, StoreStageChannels storeStageChannels, StoreUserRelationships storeUserRelationships, StoreStageInstances storeStageInstances, ObservationDeck observationDeck) {
            return storeVoiceChannelSelected.observeSelectedChannel().Y(new WidgetGlobalStatusIndicatorViewModel2(storeConnectivity, storeChannelsSelected, storeRtcConnection, storeGuilds, storeVoiceParticipants, streamContextService, storeStageChannels, observationDeck, storeUserRelationships, storeStageInstances));
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StreamContextService streamContextService, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreConnectivity storeConnectivity, StoreChannelsSelected storeChannelsSelected, StoreRtcConnection storeRtcConnection, StoreGuilds storeGuilds, StoreVoiceParticipants storeVoiceParticipants, StoreStageChannels storeStageChannels, StoreUserRelationships storeUserRelationships, StoreStageInstances storeStageInstances, ObservationDeck observationDeck, int i, Object obj) {
            return companion.observeStoreState(streamContextService, storeVoiceChannelSelected, storeConnectivity, storeChannelsSelected, storeRtcConnection, storeGuilds, storeVoiceParticipants, storeStageChannels, storeUserRelationships, storeStageInstances, (i & 1024) != 0 ? ObservationDeck4.get() : observationDeck);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState;", "", "<init>", "()V", "CallOngoing", "ConnectivityState", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010#\u001a\u00020\u0006\u0012\u0006\u0010$\u001a\u00020\t\u0012\b\u0010%\u001a\u0004\u0018\u00010\f\u0012\u0016\u0010&\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u000f\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010(\u001a\u00020\u0018\u0012\u0006\u0010)\u001a\u00020\u001b\u0012\b\u0010*\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\bI\u0010JJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0013\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u000fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u008c\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f2\u0018\b\u0002\u0010&\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u000f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010(\u001a\u00020\u00182\b\b\u0002\u0010)\u001a\u00020\u001b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001eHÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b0\u0010\u001dJ\u001a\u00104\u001a\u0002032\b\u00102\u001a\u0004\u0018\u000101HÖ\u0003¢\u0006\u0004\b4\u00105R\u0019\u0010(\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b(\u00106\u001a\u0004\b7\u0010\u001aR\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u00108\u001a\u0004\b9\u0010\u0004R\u0019\u0010)\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010:\u001a\u0004\b;\u0010\u001dR\u001b\u0010*\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010<\u001a\u0004\b=\u0010 R)\u0010&\u001a\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\u00120\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010>\u001a\u0004\b?\u0010\u0014R\u001b\u0010'\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010@\u001a\u0004\bA\u0010\u0017R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00108\u001a\u0004\bB\u0010\u0004R\u0019\u0010#\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010C\u001a\u0004\bD\u0010\bR\u0019\u0010$\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010E\u001a\u0004\bF\u0010\u000bR\u001b\u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010G\u001a\u0004\bH\u0010\u000e¨\u0006K"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "component2", "Lcom/discord/rtcconnection/RtcConnection$StateChange;", "component3", "()Lcom/discord/rtcconnection/RtcConnection$StateChange;", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "component4", "()Lcom/discord/rtcconnection/RtcConnection$Quality;", "Lcom/discord/models/guild/Guild;", "component5", "()Lcom/discord/models/guild/Guild;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "component6", "()Ljava/util/Map;", "Lcom/discord/utilities/streams/StreamContext;", "component7", "()Lcom/discord/utilities/streams/StreamContext;", "Lcom/discord/api/voice/state/StageRequestToSpeakState;", "component8", "()Lcom/discord/api/voice/state/StageRequestToSpeakState;", "", "component9", "()I", "Lcom/discord/api/stageinstance/StageInstance;", "component10", "()Lcom/discord/api/stageinstance/StageInstance;", "selectedVoiceChannel", "selectedTextChannel", "connectionStateChange", "connectionQuality", "guild", "participants", "streamContext", "requestToSpeakState", "blockedUsersOnStage", "stageInstance", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/RtcConnection$StateChange;Lcom/discord/rtcconnection/RtcConnection$Quality;Lcom/discord/models/guild/Guild;Ljava/util/Map;Lcom/discord/utilities/streams/StreamContext;Lcom/discord/api/voice/state/StageRequestToSpeakState;ILcom/discord/api/stageinstance/StageInstance;)Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/voice/state/StageRequestToSpeakState;", "getRequestToSpeakState", "Lcom/discord/api/channel/Channel;", "getSelectedVoiceChannel", "I", "getBlockedUsersOnStage", "Lcom/discord/api/stageinstance/StageInstance;", "getStageInstance", "Ljava/util/Map;", "getParticipants", "Lcom/discord/utilities/streams/StreamContext;", "getStreamContext", "getSelectedTextChannel", "Lcom/discord/rtcconnection/RtcConnection$StateChange;", "getConnectionStateChange", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "getConnectionQuality", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/RtcConnection$StateChange;Lcom/discord/rtcconnection/RtcConnection$Quality;Lcom/discord/models/guild/Guild;Ljava/util/Map;Lcom/discord/utilities/streams/StreamContext;Lcom/discord/api/voice/state/StageRequestToSpeakState;ILcom/discord/api/stageinstance/StageInstance;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class CallOngoing extends StoreState {
            private final int blockedUsersOnStage;
            private final RtcConnection.Quality connectionQuality;
            private final RtcConnection.StateChange connectionStateChange;
            private final Guild guild;
            private final Map<Long, StoreVoiceParticipants.VoiceUser> participants;
            private final StageRequestToSpeakState requestToSpeakState;
            private final Channel selectedTextChannel;
            private final Channel selectedVoiceChannel;
            private final StageInstance stageInstance;
            private final StreamContext streamContext;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallOngoing(Channel channel, Channel channel2, RtcConnection.StateChange stateChange, RtcConnection.Quality quality, Guild guild, Map<Long, StoreVoiceParticipants.VoiceUser> map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, int i, StageInstance stageInstance) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(stateChange, "connectionStateChange");
                Intrinsics3.checkNotNullParameter(quality, "connectionQuality");
                Intrinsics3.checkNotNullParameter(map, "participants");
                Intrinsics3.checkNotNullParameter(stageRequestToSpeakState, "requestToSpeakState");
                this.selectedVoiceChannel = channel;
                this.selectedTextChannel = channel2;
                this.connectionStateChange = stateChange;
                this.connectionQuality = quality;
                this.guild = guild;
                this.participants = map;
                this.streamContext = streamContext;
                this.requestToSpeakState = stageRequestToSpeakState;
                this.blockedUsersOnStage = i;
                this.stageInstance = stageInstance;
            }

            public static /* synthetic */ CallOngoing copy$default(CallOngoing callOngoing, Channel channel, Channel channel2, RtcConnection.StateChange stateChange, RtcConnection.Quality quality, Guild guild, Map map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, int i, StageInstance stageInstance, int i2, Object obj) {
                return callOngoing.copy((i2 & 1) != 0 ? callOngoing.selectedVoiceChannel : channel, (i2 & 2) != 0 ? callOngoing.selectedTextChannel : channel2, (i2 & 4) != 0 ? callOngoing.connectionStateChange : stateChange, (i2 & 8) != 0 ? callOngoing.connectionQuality : quality, (i2 & 16) != 0 ? callOngoing.guild : guild, (i2 & 32) != 0 ? callOngoing.participants : map, (i2 & 64) != 0 ? callOngoing.streamContext : streamContext, (i2 & 128) != 0 ? callOngoing.requestToSpeakState : stageRequestToSpeakState, (i2 & 256) != 0 ? callOngoing.blockedUsersOnStage : i, (i2 & 512) != 0 ? callOngoing.stageInstance : stageInstance);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* renamed from: component10, reason: from getter */
            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            /* renamed from: component2, reason: from getter */
            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            /* renamed from: component3, reason: from getter */
            public final RtcConnection.StateChange getConnectionStateChange() {
                return this.connectionStateChange;
            }

            /* renamed from: component4, reason: from getter */
            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            /* renamed from: component5, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, StoreVoiceParticipants.VoiceUser> component6() {
                return this.participants;
            }

            /* renamed from: component7, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* renamed from: component8, reason: from getter */
            public final StageRequestToSpeakState getRequestToSpeakState() {
                return this.requestToSpeakState;
            }

            /* renamed from: component9, reason: from getter */
            public final int getBlockedUsersOnStage() {
                return this.blockedUsersOnStage;
            }

            public final CallOngoing copy(Channel selectedVoiceChannel, Channel selectedTextChannel, RtcConnection.StateChange connectionStateChange, RtcConnection.Quality connectionQuality, Guild guild, Map<Long, StoreVoiceParticipants.VoiceUser> participants, StreamContext streamContext, StageRequestToSpeakState requestToSpeakState, int blockedUsersOnStage, StageInstance stageInstance) {
                Intrinsics3.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(connectionStateChange, "connectionStateChange");
                Intrinsics3.checkNotNullParameter(connectionQuality, "connectionQuality");
                Intrinsics3.checkNotNullParameter(participants, "participants");
                Intrinsics3.checkNotNullParameter(requestToSpeakState, "requestToSpeakState");
                return new CallOngoing(selectedVoiceChannel, selectedTextChannel, connectionStateChange, connectionQuality, guild, participants, streamContext, requestToSpeakState, blockedUsersOnStage, stageInstance);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CallOngoing)) {
                    return false;
                }
                CallOngoing callOngoing = (CallOngoing) other;
                return Intrinsics3.areEqual(this.selectedVoiceChannel, callOngoing.selectedVoiceChannel) && Intrinsics3.areEqual(this.selectedTextChannel, callOngoing.selectedTextChannel) && Intrinsics3.areEqual(this.connectionStateChange, callOngoing.connectionStateChange) && Intrinsics3.areEqual(this.connectionQuality, callOngoing.connectionQuality) && Intrinsics3.areEqual(this.guild, callOngoing.guild) && Intrinsics3.areEqual(this.participants, callOngoing.participants) && Intrinsics3.areEqual(this.streamContext, callOngoing.streamContext) && Intrinsics3.areEqual(this.requestToSpeakState, callOngoing.requestToSpeakState) && this.blockedUsersOnStage == callOngoing.blockedUsersOnStage && Intrinsics3.areEqual(this.stageInstance, callOngoing.stageInstance);
            }

            public final int getBlockedUsersOnStage() {
                return this.blockedUsersOnStage;
            }

            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            public final RtcConnection.StateChange getConnectionStateChange() {
                return this.connectionStateChange;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, StoreVoiceParticipants.VoiceUser> getParticipants() {
                return this.participants;
            }

            public final StageRequestToSpeakState getRequestToSpeakState() {
                return this.requestToSpeakState;
            }

            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public int hashCode() {
                Channel channel = this.selectedVoiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Channel channel2 = this.selectedTextChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                RtcConnection.StateChange stateChange = this.connectionStateChange;
                int iHashCode3 = (iHashCode2 + (stateChange != null ? stateChange.hashCode() : 0)) * 31;
                RtcConnection.Quality quality = this.connectionQuality;
                int iHashCode4 = (iHashCode3 + (quality != null ? quality.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                int iHashCode5 = (iHashCode4 + (guild != null ? guild.hashCode() : 0)) * 31;
                Map<Long, StoreVoiceParticipants.VoiceUser> map = this.participants;
                int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
                StreamContext streamContext = this.streamContext;
                int iHashCode7 = (iHashCode6 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
                StageRequestToSpeakState stageRequestToSpeakState = this.requestToSpeakState;
                int iHashCode8 = (((iHashCode7 + (stageRequestToSpeakState != null ? stageRequestToSpeakState.hashCode() : 0)) * 31) + this.blockedUsersOnStage) * 31;
                StageInstance stageInstance = this.stageInstance;
                return iHashCode8 + (stageInstance != null ? stageInstance.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("CallOngoing(selectedVoiceChannel=");
                sbU.append(this.selectedVoiceChannel);
                sbU.append(", selectedTextChannel=");
                sbU.append(this.selectedTextChannel);
                sbU.append(", connectionStateChange=");
                sbU.append(this.connectionStateChange);
                sbU.append(", connectionQuality=");
                sbU.append(this.connectionQuality);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", participants=");
                sbU.append(this.participants);
                sbU.append(", streamContext=");
                sbU.append(this.streamContext);
                sbU.append(", requestToSpeakState=");
                sbU.append(this.requestToSpeakState);
                sbU.append(", blockedUsersOnStage=");
                sbU.append(this.blockedUsersOnStage);
                sbU.append(", stageInstance=");
                sbU.append(this.stageInstance);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState;", "Lcom/discord/stores/StoreConnectivity$DelayedState;", "component1", "()Lcom/discord/stores/StoreConnectivity$DelayedState;", "connectivityState", "copy", "(Lcom/discord/stores/StoreConnectivity$DelayedState;)Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$StoreState$ConnectivityState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreConnectivity$DelayedState;", "getConnectivityState", "<init>", "(Lcom/discord/stores/StoreConnectivity$DelayedState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ConnectivityState extends StoreState {
            private final StoreConnectivity.DelayedState connectivityState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConnectivityState(StoreConnectivity.DelayedState delayedState) {
                super(null);
                Intrinsics3.checkNotNullParameter(delayedState, "connectivityState");
                this.connectivityState = delayedState;
            }

            public static /* synthetic */ ConnectivityState copy$default(ConnectivityState connectivityState, StoreConnectivity.DelayedState delayedState, int i, Object obj) {
                if ((i & 1) != 0) {
                    delayedState = connectivityState.connectivityState;
                }
                return connectivityState.copy(delayedState);
            }

            /* renamed from: component1, reason: from getter */
            public final StoreConnectivity.DelayedState getConnectivityState() {
                return this.connectivityState;
            }

            public final ConnectivityState copy(StoreConnectivity.DelayedState connectivityState) {
                Intrinsics3.checkNotNullParameter(connectivityState, "connectivityState");
                return new ConnectivityState(connectivityState);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ConnectivityState) && Intrinsics3.areEqual(this.connectivityState, ((ConnectivityState) other).connectivityState);
                }
                return true;
            }

            public final StoreConnectivity.DelayedState getConnectivityState() {
                return this.connectivityState;
            }

            public int hashCode() {
                StoreConnectivity.DelayedState delayedState = this.connectivityState;
                if (delayedState != null) {
                    return delayedState.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ConnectivityState(connectivityState=");
                sbU.append(this.connectivityState);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;", "", "", "isSpeakingInOngoingCall", "Z", "()Z", "<init>", "()V", "CallOngoing", "Connecting", "Inactive", "Offline", "StageChannelOngoing", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$Inactive;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$Offline;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {
        private final boolean isSpeakingInOngoingCall;

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0012\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017Jf\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b%\u0010\u0011J\u001a\u0010(\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b(\u0010)R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\b+\u0010\u000eR\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b-\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b/\u0010\u0014R\u0019\u0010\u001b\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u00100\u001a\u0004\b1\u0010\u000bR\u0019\u0010\u001a\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b3\u0010\bR\u0019\u0010\u001d\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00104\u001a\u0004\b5\u0010\u0011R\u001c\u00106\u001a\u00020\u00128\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b6\u0010.\u001a\u0004\b6\u0010\u0014R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b8\u0010\u0017R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\b9\u0010\u0004¨\u0006<"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "component2", "Lcom/discord/rtcconnection/RtcConnection$State;", "component3", "()Lcom/discord/rtcconnection/RtcConnection$State;", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "component4", "()Lcom/discord/rtcconnection/RtcConnection$Quality;", "Lcom/discord/models/guild/Guild;", "component5", "()Lcom/discord/models/guild/Guild;", "", "component6", "()I", "", "component7", "()Z", "Lcom/discord/utilities/streams/StreamContext;", "component8", "()Lcom/discord/utilities/streams/StreamContext;", "selectedVoiceChannel", "selectedTextChannel", "connectionState", "connectionQuality", "guild", "participants", "hasVideo", "streamContext", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/RtcConnection$State;Lcom/discord/rtcconnection/RtcConnection$Quality;Lcom/discord/models/guild/Guild;IZLcom/discord/utilities/streams/StreamContext;)Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/api/channel/Channel;", "getSelectedVoiceChannel", "Z", "getHasVideo", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "getConnectionQuality", "Lcom/discord/rtcconnection/RtcConnection$State;", "getConnectionState", "I", "getParticipants", "isSpeakingInOngoingCall", "Lcom/discord/utilities/streams/StreamContext;", "getStreamContext", "getSelectedTextChannel", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/RtcConnection$State;Lcom/discord/rtcconnection/RtcConnection$Quality;Lcom/discord/models/guild/Guild;IZLcom/discord/utilities/streams/StreamContext;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class CallOngoing extends ViewState {
            private final RtcConnection.Quality connectionQuality;
            private final RtcConnection.State connectionState;
            private final Guild guild;
            private final boolean hasVideo;
            private final boolean isSpeakingInOngoingCall;
            private final int participants;
            private final Channel selectedTextChannel;
            private final Channel selectedVoiceChannel;
            private final StreamContext streamContext;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallOngoing(Channel channel, Channel channel2, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, int i, boolean z2, StreamContext streamContext) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(state, "connectionState");
                Intrinsics3.checkNotNullParameter(quality, "connectionQuality");
                this.selectedVoiceChannel = channel;
                this.selectedTextChannel = channel2;
                this.connectionState = state;
                this.connectionQuality = quality;
                this.guild = guild;
                this.participants = i;
                this.hasVideo = z2;
                this.streamContext = streamContext;
                this.isSpeakingInOngoingCall = true;
            }

            public static /* synthetic */ CallOngoing copy$default(CallOngoing callOngoing, Channel channel, Channel channel2, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, int i, boolean z2, StreamContext streamContext, int i2, Object obj) {
                return callOngoing.copy((i2 & 1) != 0 ? callOngoing.selectedVoiceChannel : channel, (i2 & 2) != 0 ? callOngoing.selectedTextChannel : channel2, (i2 & 4) != 0 ? callOngoing.connectionState : state, (i2 & 8) != 0 ? callOngoing.connectionQuality : quality, (i2 & 16) != 0 ? callOngoing.guild : guild, (i2 & 32) != 0 ? callOngoing.participants : i, (i2 & 64) != 0 ? callOngoing.hasVideo : z2, (i2 & 128) != 0 ? callOngoing.streamContext : streamContext);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* renamed from: component2, reason: from getter */
            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            /* renamed from: component3, reason: from getter */
            public final RtcConnection.State getConnectionState() {
                return this.connectionState;
            }

            /* renamed from: component4, reason: from getter */
            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            /* renamed from: component5, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component6, reason: from getter */
            public final int getParticipants() {
                return this.participants;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getHasVideo() {
                return this.hasVideo;
            }

            /* renamed from: component8, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public final CallOngoing copy(Channel selectedVoiceChannel, Channel selectedTextChannel, RtcConnection.State connectionState, RtcConnection.Quality connectionQuality, Guild guild, int participants, boolean hasVideo, StreamContext streamContext) {
                Intrinsics3.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(connectionState, "connectionState");
                Intrinsics3.checkNotNullParameter(connectionQuality, "connectionQuality");
                return new CallOngoing(selectedVoiceChannel, selectedTextChannel, connectionState, connectionQuality, guild, participants, hasVideo, streamContext);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CallOngoing)) {
                    return false;
                }
                CallOngoing callOngoing = (CallOngoing) other;
                return Intrinsics3.areEqual(this.selectedVoiceChannel, callOngoing.selectedVoiceChannel) && Intrinsics3.areEqual(this.selectedTextChannel, callOngoing.selectedTextChannel) && Intrinsics3.areEqual(this.connectionState, callOngoing.connectionState) && Intrinsics3.areEqual(this.connectionQuality, callOngoing.connectionQuality) && Intrinsics3.areEqual(this.guild, callOngoing.guild) && this.participants == callOngoing.participants && this.hasVideo == callOngoing.hasVideo && Intrinsics3.areEqual(this.streamContext, callOngoing.streamContext);
            }

            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            public final RtcConnection.State getConnectionState() {
                return this.connectionState;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final boolean getHasVideo() {
                return this.hasVideo;
            }

            public final int getParticipants() {
                return this.participants;
            }

            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Channel channel = this.selectedVoiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Channel channel2 = this.selectedTextChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                RtcConnection.State state = this.connectionState;
                int iHashCode3 = (iHashCode2 + (state != null ? state.hashCode() : 0)) * 31;
                RtcConnection.Quality quality = this.connectionQuality;
                int iHashCode4 = (iHashCode3 + (quality != null ? quality.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                int iHashCode5 = (((iHashCode4 + (guild != null ? guild.hashCode() : 0)) * 31) + this.participants) * 31;
                boolean z2 = this.hasVideo;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode5 + i) * 31;
                StreamContext streamContext = this.streamContext;
                return i2 + (streamContext != null ? streamContext.hashCode() : 0);
            }

            @Override // com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel.ViewState
            /* renamed from: isSpeakingInOngoingCall, reason: from getter */
            public boolean getIsSpeakingInOngoingCall() {
                return this.isSpeakingInOngoingCall;
            }

            public String toString() {
                StringBuilder sbU = outline.U("CallOngoing(selectedVoiceChannel=");
                sbU.append(this.selectedVoiceChannel);
                sbU.append(", selectedTextChannel=");
                sbU.append(this.selectedTextChannel);
                sbU.append(", connectionState=");
                sbU.append(this.connectionState);
                sbU.append(", connectionQuality=");
                sbU.append(this.connectionQuality);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", participants=");
                sbU.append(this.participants);
                sbU.append(", hasVideo=");
                sbU.append(this.hasVideo);
                sbU.append(", streamContext=");
                sbU.append(this.streamContext);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;", "", "component1", "()J", "delay", "copy", "(J)Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$Connecting;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getDelay", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Connecting extends ViewState {
            private final long delay;

            public Connecting(long j) {
                super(null);
                this.delay = j;
            }

            public static /* synthetic */ Connecting copy$default(Connecting connecting, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = connecting.delay;
                }
                return connecting.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getDelay() {
                return this.delay;
            }

            public final Connecting copy(long delay) {
                return new Connecting(delay);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Connecting) && this.delay == ((Connecting) other).delay;
                }
                return true;
            }

            public final long getDelay() {
                return this.delay;
            }

            public int hashCode() {
                return b.a(this.delay);
            }

            public String toString() {
                return outline.C(outline.U("Connecting(delay="), this.delay, ")");
            }
        }

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$Inactive;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Inactive extends ViewState {
            public static final Inactive INSTANCE = new Inactive();

            private Inactive() {
                super(null);
            }
        }

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$Offline;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;", "", "component1", "()J", "", "component2", "()Z", "delay", "airplaneMode", "copy", "(JZ)Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$Offline;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getDelay", "Z", "getAirplaneMode", "<init>", "(JZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Offline extends ViewState {
            private final boolean airplaneMode;
            private final long delay;

            public Offline(long j, boolean z2) {
                super(null);
                this.delay = j;
                this.airplaneMode = z2;
            }

            public static /* synthetic */ Offline copy$default(Offline offline, long j, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = offline.delay;
                }
                if ((i & 2) != 0) {
                    z2 = offline.airplaneMode;
                }
                return offline.copy(j, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final long getDelay() {
                return this.delay;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getAirplaneMode() {
                return this.airplaneMode;
            }

            public final Offline copy(long delay, boolean airplaneMode) {
                return new Offline(delay, airplaneMode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Offline)) {
                    return false;
                }
                Offline offline = (Offline) other;
                return this.delay == offline.delay && this.airplaneMode == offline.airplaneMode;
            }

            public final boolean getAirplaneMode() {
                return this.airplaneMode;
            }

            public final long getDelay() {
                return this.delay;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iA = b.a(this.delay) * 31;
                boolean z2 = this.airplaneMode;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iA + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Offline(delay=");
                sbU.append(this.delay);
                sbU.append(", airplaneMode=");
                return outline.O(sbU, this.airplaneMode, ")");
            }
        }

        /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010!\u001a\u00020\u0011\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010#\u001a\u00020\u0011\u0012\b\b\u0002\u0010$\u001a\u00020\u0011\u0012\b\b\u0002\u0010%\u001a\u00020\u0019¢\u0006\u0004\b@\u0010AJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0013J\u0010\u0010\u0018\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0013J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJz\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010!\u001a\u00020\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010#\u001a\u00020\u00112\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u0019HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b+\u0010\u001bJ\u001a\u0010.\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003¢\u0006\u0004\b.\u0010/R\u0019\u0010!\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b!\u00100\u001a\u0004\b!\u0010\u0013R\u001b\u0010\"\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b2\u0010\u0016R\u0019\u0010$\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b$\u00100\u001a\u0004\b$\u0010\u0013R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00103\u001a\u0004\b4\u0010\rR\u001c\u00105\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b5\u00100\u001a\u0004\b5\u0010\u0013R\u0019\u0010%\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b%\u00106\u001a\u0004\b7\u0010\u001bR\u0019\u0010\u001d\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00108\u001a\u0004\b9\u0010\u0007R\u0019\u0010\u001e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010:\u001a\u0004\b;\u0010\nR\u0019\u0010#\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b#\u00100\u001a\u0004\b#\u0010\u0013R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010<\u001a\u0004\b=\u0010\u0004R\u001b\u0010 \u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010>\u001a\u0004\b?\u0010\u0010¨\u0006B"}, d2 = {"Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing;", "Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/rtcconnection/RtcConnection$State;", "component2", "()Lcom/discord/rtcconnection/RtcConnection$State;", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "component3", "()Lcom/discord/rtcconnection/RtcConnection$Quality;", "Lcom/discord/models/guild/Guild;", "component4", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/utilities/streams/StreamContext;", "component5", "()Lcom/discord/utilities/streams/StreamContext;", "", "component6", "()Z", "Lcom/discord/api/stageinstance/StageInstance;", "component7", "()Lcom/discord/api/stageinstance/StageInstance;", "component8", "component9", "", "component10", "()I", "selectedVoiceChannel", "connectionState", "connectionQuality", "guild", "streamContext", "isSpeaking", "stageInstance", "isInvitedToSpeak", "isAckingInvitation", "blockedUsersOnStage", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/RtcConnection$State;Lcom/discord/rtcconnection/RtcConnection$Quality;Lcom/discord/models/guild/Guild;Lcom/discord/utilities/streams/StreamContext;ZLcom/discord/api/stageinstance/StageInstance;ZZI)Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/api/stageinstance/StageInstance;", "getStageInstance", "Lcom/discord/models/guild/Guild;", "getGuild", "isSpeakingInOngoingCall", "I", "getBlockedUsersOnStage", "Lcom/discord/rtcconnection/RtcConnection$State;", "getConnectionState", "Lcom/discord/rtcconnection/RtcConnection$Quality;", "getConnectionQuality", "Lcom/discord/api/channel/Channel;", "getSelectedVoiceChannel", "Lcom/discord/utilities/streams/StreamContext;", "getStreamContext", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/RtcConnection$State;Lcom/discord/rtcconnection/RtcConnection$Quality;Lcom/discord/models/guild/Guild;Lcom/discord/utilities/streams/StreamContext;ZLcom/discord/api/stageinstance/StageInstance;ZZI)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class StageChannelOngoing extends ViewState {
            private final int blockedUsersOnStage;
            private final RtcConnection.Quality connectionQuality;
            private final RtcConnection.State connectionState;
            private final Guild guild;
            private final boolean isAckingInvitation;
            private final boolean isInvitedToSpeak;
            private final boolean isSpeaking;
            private final boolean isSpeakingInOngoingCall;
            private final Channel selectedVoiceChannel;
            private final StageInstance stageInstance;
            private final StreamContext streamContext;

            public /* synthetic */ StageChannelOngoing(Channel channel, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, StreamContext streamContext, boolean z2, StageInstance stageInstance, boolean z3, boolean z4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(channel, state, quality, guild, streamContext, z2, stageInstance, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? false : z4, (i2 & 512) != 0 ? 0 : i);
            }

            public static /* synthetic */ StageChannelOngoing copy$default(StageChannelOngoing stageChannelOngoing, Channel channel, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, StreamContext streamContext, boolean z2, StageInstance stageInstance, boolean z3, boolean z4, int i, int i2, Object obj) {
                return stageChannelOngoing.copy((i2 & 1) != 0 ? stageChannelOngoing.selectedVoiceChannel : channel, (i2 & 2) != 0 ? stageChannelOngoing.connectionState : state, (i2 & 4) != 0 ? stageChannelOngoing.connectionQuality : quality, (i2 & 8) != 0 ? stageChannelOngoing.guild : guild, (i2 & 16) != 0 ? stageChannelOngoing.streamContext : streamContext, (i2 & 32) != 0 ? stageChannelOngoing.isSpeaking : z2, (i2 & 64) != 0 ? stageChannelOngoing.stageInstance : stageInstance, (i2 & 128) != 0 ? stageChannelOngoing.isInvitedToSpeak : z3, (i2 & 256) != 0 ? stageChannelOngoing.isAckingInvitation : z4, (i2 & 512) != 0 ? stageChannelOngoing.blockedUsersOnStage : i);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* renamed from: component10, reason: from getter */
            public final int getBlockedUsersOnStage() {
                return this.blockedUsersOnStage;
            }

            /* renamed from: component2, reason: from getter */
            public final RtcConnection.State getConnectionState() {
                return this.connectionState;
            }

            /* renamed from: component3, reason: from getter */
            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            /* renamed from: component4, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component5, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsSpeaking() {
                return this.isSpeaking;
            }

            /* renamed from: component7, reason: from getter */
            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            /* renamed from: component8, reason: from getter */
            public final boolean getIsInvitedToSpeak() {
                return this.isInvitedToSpeak;
            }

            /* renamed from: component9, reason: from getter */
            public final boolean getIsAckingInvitation() {
                return this.isAckingInvitation;
            }

            public final StageChannelOngoing copy(Channel selectedVoiceChannel, RtcConnection.State connectionState, RtcConnection.Quality connectionQuality, Guild guild, StreamContext streamContext, boolean isSpeaking, StageInstance stageInstance, boolean isInvitedToSpeak, boolean isAckingInvitation, int blockedUsersOnStage) {
                Intrinsics3.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(connectionState, "connectionState");
                Intrinsics3.checkNotNullParameter(connectionQuality, "connectionQuality");
                return new StageChannelOngoing(selectedVoiceChannel, connectionState, connectionQuality, guild, streamContext, isSpeaking, stageInstance, isInvitedToSpeak, isAckingInvitation, blockedUsersOnStage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StageChannelOngoing)) {
                    return false;
                }
                StageChannelOngoing stageChannelOngoing = (StageChannelOngoing) other;
                return Intrinsics3.areEqual(this.selectedVoiceChannel, stageChannelOngoing.selectedVoiceChannel) && Intrinsics3.areEqual(this.connectionState, stageChannelOngoing.connectionState) && Intrinsics3.areEqual(this.connectionQuality, stageChannelOngoing.connectionQuality) && Intrinsics3.areEqual(this.guild, stageChannelOngoing.guild) && Intrinsics3.areEqual(this.streamContext, stageChannelOngoing.streamContext) && this.isSpeaking == stageChannelOngoing.isSpeaking && Intrinsics3.areEqual(this.stageInstance, stageChannelOngoing.stageInstance) && this.isInvitedToSpeak == stageChannelOngoing.isInvitedToSpeak && this.isAckingInvitation == stageChannelOngoing.isAckingInvitation && this.blockedUsersOnStage == stageChannelOngoing.blockedUsersOnStage;
            }

            public final int getBlockedUsersOnStage() {
                return this.blockedUsersOnStage;
            }

            public final RtcConnection.Quality getConnectionQuality() {
                return this.connectionQuality;
            }

            public final RtcConnection.State getConnectionState() {
                return this.connectionState;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final StageInstance getStageInstance() {
                return this.stageInstance;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Channel channel = this.selectedVoiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                RtcConnection.State state = this.connectionState;
                int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
                RtcConnection.Quality quality = this.connectionQuality;
                int iHashCode3 = (iHashCode2 + (quality != null ? quality.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                int iHashCode4 = (iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31;
                StreamContext streamContext = this.streamContext;
                int iHashCode5 = (iHashCode4 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
                boolean z2 = this.isSpeaking;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode5 + i) * 31;
                StageInstance stageInstance = this.stageInstance;
                int iHashCode6 = (i2 + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
                boolean z3 = this.isInvitedToSpeak;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (iHashCode6 + i3) * 31;
                boolean z4 = this.isAckingInvitation;
                return ((i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31) + this.blockedUsersOnStage;
            }

            public final boolean isAckingInvitation() {
                return this.isAckingInvitation;
            }

            public final boolean isInvitedToSpeak() {
                return this.isInvitedToSpeak;
            }

            public final boolean isSpeaking() {
                return this.isSpeaking;
            }

            @Override // com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel.ViewState
            /* renamed from: isSpeakingInOngoingCall, reason: from getter */
            public boolean getIsSpeakingInOngoingCall() {
                return this.isSpeakingInOngoingCall;
            }

            public String toString() {
                StringBuilder sbU = outline.U("StageChannelOngoing(selectedVoiceChannel=");
                sbU.append(this.selectedVoiceChannel);
                sbU.append(", connectionState=");
                sbU.append(this.connectionState);
                sbU.append(", connectionQuality=");
                sbU.append(this.connectionQuality);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", streamContext=");
                sbU.append(this.streamContext);
                sbU.append(", isSpeaking=");
                sbU.append(this.isSpeaking);
                sbU.append(", stageInstance=");
                sbU.append(this.stageInstance);
                sbU.append(", isInvitedToSpeak=");
                sbU.append(this.isInvitedToSpeak);
                sbU.append(", isAckingInvitation=");
                sbU.append(this.isAckingInvitation);
                sbU.append(", blockedUsersOnStage=");
                return outline.B(sbU, this.blockedUsersOnStage, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StageChannelOngoing(Channel channel, RtcConnection.State state, RtcConnection.Quality quality, Guild guild, StreamContext streamContext, boolean z2, StageInstance stageInstance, boolean z3, boolean z4, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(state, "connectionState");
                Intrinsics3.checkNotNullParameter(quality, "connectionQuality");
                this.selectedVoiceChannel = channel;
                this.connectionState = state;
                this.connectionQuality = quality;
                this.guild = guild;
                this.streamContext = streamContext;
                this.isSpeaking = z2;
                this.stageInstance = stageInstance;
                this.isInvitedToSpeak = z3;
                this.isAckingInvitation = z4;
                this.blockedUsersOnStage = i;
                this.isSpeakingInOngoingCall = z2 || z3;
            }
        }

        private ViewState() {
        }

        /* renamed from: isSpeakingInOngoingCall, reason: from getter */
        public boolean getIsSpeakingInOngoingCall() {
            return this.isSpeakingInOngoingCall;
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreConnectivity.State.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreConnectivity.State.ONLINE.ordinal()] = 1;
            iArr[StoreConnectivity.State.CONNECTING.ordinal()] = 2;
            iArr[StoreConnectivity.State.OFFLINE.ordinal()] = 3;
            iArr[StoreConnectivity.State.OFFLINE_AIRPLANE_MODE.ordinal()] = 4;
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$ackStageInvitationToSpeak$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ boolean $accept;
        public final /* synthetic */ ViewState.StageChannelOngoing $stageState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, ViewState.StageChannelOngoing stageChannelOngoing) {
            super(1);
            this.$accept = z2;
            this.$stageState = stageChannelOngoing;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r14) {
            if (this.$accept) {
                AnalyticsTracker.INSTANCE.promotedToSpeaker(this.$stageState.getSelectedVoiceChannel().getId());
            }
            ViewState viewStateAccess$getViewState$p = WidgetGlobalStatusIndicatorViewModel.access$getViewState$p(WidgetGlobalStatusIndicatorViewModel.this);
            if (!(viewStateAccess$getViewState$p instanceof ViewState.StageChannelOngoing)) {
                viewStateAccess$getViewState$p = null;
            }
            ViewState.StageChannelOngoing stageChannelOngoing = (ViewState.StageChannelOngoing) viewStateAccess$getViewState$p;
            if (stageChannelOngoing != null) {
                WidgetGlobalStatusIndicatorViewModel.access$updateViewState(WidgetGlobalStatusIndicatorViewModel.this, ViewState.StageChannelOngoing.copy$default(stageChannelOngoing, null, null, null, null, null, false, null, false, false, 0, 767, null));
            }
        }
    }

    public WidgetGlobalStatusIndicatorViewModel() {
        this(null, 1, null);
    }

    public /* synthetic */ WidgetGlobalStatusIndicatorViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observableObserveStoreState$default;
        if ((i & 1) != 0) {
            Companion companion = INSTANCE;
            StreamContextService streamContextService = new StreamContextService(null, null, null, null, null, null, null, null, 255, null);
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStoreState$default = Companion.observeStoreState$default(companion, streamContextService, companion2.getVoiceChannelSelected(), companion2.getConnectivity(), companion2.getChannelsSelected(), companion2.getRtcConnection(), companion2.getGuilds(), companion2.getVoiceParticipants(), companion2.getStageChannels(), companion2.getUserRelationships(), companion2.getStageInstances(), null, 1024, null);
            Intrinsics3.checkNotNullExpressionValue(observableObserveStoreState$default, "observeStoreState(\n     ….getStageInstances(),\n  )");
        } else {
            observableObserveStoreState$default = observable;
        }
        this(observableObserveStoreState$default);
    }

    public static final /* synthetic */ ViewState access$getViewState$p(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel) {
        return widgetGlobalStatusIndicatorViewModel.getViewState();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel, StoreState storeState) {
        widgetGlobalStatusIndicatorViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel, ViewState viewState) {
        widgetGlobalStatusIndicatorViewModel.updateViewState(viewState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        if (storeState instanceof StoreState.ConnectivityState) {
            StoreState.ConnectivityState connectivityState = (StoreState.ConnectivityState) storeState;
            int iOrdinal = connectivityState.getConnectivityState().getState().ordinal();
            if (iOrdinal == 0) {
                updateViewState(ViewState.Inactive.INSTANCE);
                return;
            }
            if (iOrdinal == 1) {
                updateViewState(new ViewState.Offline(connectivityState.getConnectivityState().getDelay(), false));
                return;
            } else if (iOrdinal == 2) {
                updateViewState(new ViewState.Offline(connectivityState.getConnectivityState().getDelay(), true));
                return;
            } else {
                if (iOrdinal != 3) {
                    return;
                }
                updateViewState(new ViewState.Connecting(connectivityState.getConnectivityState().getDelay()));
                return;
            }
        }
        if (storeState instanceof StoreState.CallOngoing) {
            StoreState.CallOngoing callOngoing = (StoreState.CallOngoing) storeState;
            if (ChannelUtils.D(callOngoing.getSelectedVoiceChannel())) {
                boolean z3 = callOngoing.getRequestToSpeakState() == StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK;
                boolean z4 = callOngoing.getRequestToSpeakState() == StageRequestToSpeakState.ON_STAGE;
                ViewState viewState = getViewState();
                if (!(viewState instanceof ViewState.StageChannelOngoing)) {
                    viewState = null;
                }
                ViewState.StageChannelOngoing stageChannelOngoing = (ViewState.StageChannelOngoing) viewState;
                if (stageChannelOngoing != null && !stageChannelOngoing.isInvitedToSpeak() && z3) {
                    AppSoundManager.Provider.INSTANCE.get().play(AppSound.INSTANCE.getSOUND_RECONNECT());
                }
                updateViewState(new ViewState.StageChannelOngoing(callOngoing.getSelectedVoiceChannel(), callOngoing.getConnectionStateChange().state, callOngoing.getConnectionQuality(), callOngoing.getGuild(), callOngoing.getStreamContext(), z4, callOngoing.getStageInstance(), z3, false, callOngoing.getBlockedUsersOnStage(), 256, null));
                return;
            }
            int size = callOngoing.getParticipants().size();
            Collection<StoreVoiceParticipants.VoiceUser> collectionValues = callOngoing.getParticipants().values();
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it = collectionValues.iterator();
                while (it.hasNext()) {
                    VoiceState voiceState = ((StoreVoiceParticipants.VoiceUser) it.next()).getVoiceState();
                    if (voiceState != null && voiceState.getSelfVideo()) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            updateViewState(new ViewState.CallOngoing(callOngoing.getSelectedVoiceChannel(), callOngoing.getSelectedTextChannel(), callOngoing.getConnectionStateChange().state, callOngoing.getConnectionQuality(), callOngoing.getGuild(), size, z2, callOngoing.getStreamContext()));
        }
    }

    public final void ackStageInvitationToSpeak(boolean accept) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.StageChannelOngoing)) {
            viewState = null;
        }
        ViewState.StageChannelOngoing stageChannelOngoing = (ViewState.StageChannelOngoing) viewState;
        if (stageChannelOngoing != null) {
            updateViewState(ViewState.StageChannelOngoing.copy$default(stageChannelOngoing, null, null, null, null, null, false, null, false, true, 0, 767, null));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.INSTANCE.ackInvitationToSpeak(stageChannelOngoing.getSelectedVoiceChannel(), accept), false, 1, null), this, null, 2, null), WidgetGlobalStatusIndicatorViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(accept, stageChannelOngoing), 62, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalStatusIndicatorViewModel(Observable<StoreState> observable) {
        super(ViewState.Inactive.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetGlobalStatusIndicatorViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
