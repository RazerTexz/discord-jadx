package com.discord.widgets.voice.fullscreen;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.stores.StoreApplication;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils2;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import d0.d0._Ranges;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005IJKLMB\u0087\u0001\u0012\n\u0010\u001d\u001a\u00060\u0003j\u0002`\u0004\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010-\u001a\u00020,\u0012\b\b\u0002\u0010D\u001a\u00020C\u0012\b\b\u0002\u00103\u001a\u000202\u0012\b\b\u0002\u00100\u001a\u00020/\u0012\b\b\u0002\u0010*\u001a\u00020)\u0012\b\b\u0002\u00106\u001a\u000205\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\b\b\u0002\u0010A\u001a\u00020@\u0012\u000e\b\u0002\u0010F\u001a\b\u0012\u0004\u0012\u00020\t0\r\u0012\b\b\u0002\u0010;\u001a\u00020:¢\u0006\u0004\bG\u0010HJ\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001b\u001a\u00020\u00062\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00060\u0003j\u0002`\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR:\u0010!\u001a&\u0012\f\u0012\n  *\u0004\u0018\u00010\u000e0\u000e  *\u0012\u0012\f\u0012\n  *\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00108\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R \u0010>\u001a\f\u0012\b\u0012\u00060\u0018j\u0002`\u00190=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006N"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ViewState;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "joinVoiceChannel", "(J)V", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState;)V", "Lrx/Observable;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;", "observeEvents", "()Lrx/Observable;", "selectTextChannelAfterFinish", "()V", "onTextInVoiceTapped", "", "muted", "tryConnectToVoice", "(Z)V", "", "Lcom/discord/primitives/StreamKey;", "streamKey", "onStreamPreviewClicked", "(Ljava/lang/String;)V", "voiceChannelId", "J", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreApplication;", "storeApplication", "Lcom/discord/stores/StoreApplication;", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreChannelsSelected;", "Lcom/discord/stores/StoreMentions;", "storeMentions", "Lcom/discord/stores/StoreMentions;", "Lcom/discord/stores/StoreVoiceChannelSelected;", "storeVoiceChannelSelected", "Lcom/discord/stores/StoreVoiceChannelSelected;", "Lcom/discord/stores/StoreUserSettings;", "storeUserSettings", "Lcom/discord/stores/StoreUserSettings;", "Lcom/discord/stores/StoreApplicationStreamPreviews;", "storeApplicationStreamPreviews", "Lcom/discord/stores/StoreApplicationStreamPreviews;", "mostRecentStoreState", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState;", "Lcom/discord/stores/StoreMediaSettings;", "mediaSettingsStore", "Lcom/discord/stores/StoreMediaSettings;", "", "fetchedPreviews", "Ljava/util/Set;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreNavigation;", "storeNavigation", "Lcom/discord/stores/StoreNavigation;", "storeStateObservable", "<init>", "(JLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreMentions;Lcom/discord/stores/StoreNavigation;Lcom/discord/stores/StoreUserSettings;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreApplicationStreamPreviews;Lcom/discord/stores/StoreApplication;Lcom/discord/stores/StoreUser;Lrx/Observable;Lcom/discord/stores/StoreMediaSettings;)V", "Companion", "Event", "ParticipantsList", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetCallPreviewFullscreenViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private Set<String> fetchedPreviews;
    private final StoreMediaSettings mediaSettingsStore;
    private StoreState mostRecentStoreState;
    private final StoreApplication storeApplication;
    private final StoreApplicationStreamPreviews storeApplicationStreamPreviews;
    private final StoreChannels storeChannels;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreMentions storeMentions;
    private final StoreNavigation storeNavigation;
    private final StoreUser storeUser;
    private final StoreUserSettings storeUserSettings;
    private final StoreVoiceChannelSelected storeVoiceChannelSelected;
    private long voiceChannelId;

    /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetCallPreviewFullscreenViewModel widgetCallPreviewFullscreenViewModel = WidgetCallPreviewFullscreenViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "it");
            WidgetCallPreviewFullscreenViewModel.access$handleStoreState(widgetCallPreviewFullscreenViewModel, storeState);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JI\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "voiceChannelId", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreMentions;", "storeMentions", "Lcom/discord/stores/StoreVoiceChannelSelected;", "storeVoiceChannelSelected", "Lrx/Observable;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StoreUser;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreMentions;Lcom/discord/stores/StoreVoiceChannelSelected;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreMentions storeMentions, StoreVoiceChannelSelected storeVoiceChannelSelected) {
            return companion.observeStoreState(j, storeUser, storeChannels, storeChannelsSelected, storeMentions, storeVoiceChannelSelected);
        }

        private final Observable<StoreState> observeStoreState(long voiceChannelId, StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreMentions storeMentions, StoreVoiceChannelSelected storeVoiceChannelSelected) {
            Observable observableY = storeChannels.observeChannel(voiceChannelId).Y(new WidgetCallPreviewFullscreenViewModel2(storeUser, storeChannelsSelected, storeMentions, voiceChannelId, storeVoiceChannelSelected));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannels.observeCha…  }\n          }\n        }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;", "", "<init>", "()V", "LaunchVideoCall", "ShowGuildVideoAtCapacityDialog", "ShowOverlayNux", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event$ShowGuildVideoAtCapacityDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event$ShowOverlayNux;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ0\u0010\f\u001a\u00020\u00002\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R!\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "Lcom/discord/primitives/StreamKey;", "component2", "()Ljava/lang/String;", "channelId", "autoTargetStreamKey", "copy", "(JLjava/lang/String;)Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event$LaunchVideoCall;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAutoTargetStreamKey", "J", "getChannelId", "<init>", "(JLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class LaunchVideoCall extends Event {
            private final String autoTargetStreamKey;
            private final long channelId;

            public LaunchVideoCall(long j, String str) {
                super(null);
                this.channelId = j;
                this.autoTargetStreamKey = str;
            }

            public static /* synthetic */ LaunchVideoCall copy$default(LaunchVideoCall launchVideoCall, long j, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchVideoCall.channelId;
                }
                if ((i & 2) != 0) {
                    str = launchVideoCall.autoTargetStreamKey;
                }
                return launchVideoCall.copy(j, str);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getAutoTargetStreamKey() {
                return this.autoTargetStreamKey;
            }

            public final LaunchVideoCall copy(long channelId, String autoTargetStreamKey) {
                return new LaunchVideoCall(channelId, autoTargetStreamKey);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchVideoCall)) {
                    return false;
                }
                LaunchVideoCall launchVideoCall = (LaunchVideoCall) other;
                return this.channelId == launchVideoCall.channelId && Intrinsics3.areEqual(this.autoTargetStreamKey, launchVideoCall.autoTargetStreamKey);
            }

            public final String getAutoTargetStreamKey() {
                return this.autoTargetStreamKey;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                int iA = b.a(this.channelId) * 31;
                String str = this.autoTargetStreamKey;
                return iA + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("LaunchVideoCall(channelId=");
                sbU.append(this.channelId);
                sbU.append(", autoTargetStreamKey=");
                return outline.J(sbU, this.autoTargetStreamKey, ")");
            }
        }

        /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event$ShowGuildVideoAtCapacityDialog;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowGuildVideoAtCapacityDialog extends Event {
            public static final ShowGuildVideoAtCapacityDialog INSTANCE = new ShowGuildVideoAtCapacityDialog();

            private ShowGuildVideoAtCapacityDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event$ShowOverlayNux;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowOverlayNux extends Event {
            public static final ShowOverlayNux INSTANCE = new ShowOverlayNux();

            private ShowOverlayNux() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList;", "", "<init>", "()V", "Empty", "ListItems", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList$Empty;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ParticipantsList {

        /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList$Empty;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList;", "", "Lcom/discord/widgets/voice/sheet/CallParticipantsAdapter$ListItem;", "component1", "()Ljava/util/List;", "items", "copy", "(Ljava/util/List;)Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList$Empty;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Empty extends ParticipantsList {
            private final List<CallParticipantsAdapter.ListItem> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Empty(List<? extends CallParticipantsAdapter.ListItem> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "items");
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Empty copy$default(Empty empty, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = empty.items;
                }
                return empty.copy(list);
            }

            public final List<CallParticipantsAdapter.ListItem> component1() {
                return this.items;
            }

            public final Empty copy(List<? extends CallParticipantsAdapter.ListItem> items) {
                Intrinsics3.checkNotNullParameter(items, "items");
                return new Empty(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Empty) && Intrinsics3.areEqual(this.items, ((Empty) other).items);
                }
                return true;
            }

            public final List<CallParticipantsAdapter.ListItem> getItems() {
                return this.items;
            }

            public int hashCode() {
                List<CallParticipantsAdapter.ListItem> list = this.items;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Empty(items="), this.items, ")");
            }
        }

        /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList;", "", "Lcom/discord/widgets/voice/sheet/CallParticipantsAdapter$ListItem;", "component1", "()Ljava/util/List;", "items", "copy", "(Ljava/util/List;)Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList$ListItems;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ListItems extends ParticipantsList {
            private final List<CallParticipantsAdapter.ListItem> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public ListItems(List<? extends CallParticipantsAdapter.ListItem> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "items");
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ListItems copy$default(ListItems listItems, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = listItems.items;
                }
                return listItems.copy(list);
            }

            public final List<CallParticipantsAdapter.ListItem> component1() {
                return this.items;
            }

            public final ListItems copy(List<? extends CallParticipantsAdapter.ListItem> items) {
                Intrinsics3.checkNotNullParameter(items, "items");
                return new ListItems(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ListItems) && Intrinsics3.areEqual(this.items, ((ListItems) other).items);
                }
                return true;
            }

            public final List<CallParticipantsAdapter.ListItem> getItems() {
                return this.items;
            }

            public int hashCode() {
                List<CallParticipantsAdapter.ListItem> list = this.items;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("ListItems(items="), this.items, ")");
            }
        }

        private ParticipantsList() {
        }

        public /* synthetic */ ParticipantsList(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState$Invalid;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState$Valid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState$Invalid;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0012\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004Jx\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u00122\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b%\u0010\u000bJ\u001a\u0010(\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b(\u0010)R\u0019\u0010\u001e\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010*\u001a\u0004\b+\u0010\u0014R\u0019\u0010\u0018\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b\u0018\u0010\bR\u0019\u0010\u001a\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b.\u0010\u000bR\u0019\u0010\u001b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b\u001b\u0010\bR\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010/\u001a\u0004\b0\u0010\u0004R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010/\u001a\u0004\b1\u0010\u0004R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010/\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b\u001c\u0010\bR\u0019\u0010\u0019\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010-\u001a\u0004\b3\u0010\u000bR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00104\u001a\u0004\b5\u0010\u0011¨\u00068"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState$Valid;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "component2", "", "component3", "()Z", "", "component4", "()I", "component5", "component6", "component7", "Lcom/discord/api/user/NsfwAllowance;", "component8", "()Lcom/discord/api/user/NsfwAllowance;", "Lcom/discord/widgets/voice/model/CallModel;", "component9", "()Lcom/discord/widgets/voice/model/CallModel;", "component10", "voiceChannel", "selectedTextChannel", "isTextInVoiceEnabled", "totalMentionsCount", "channelMentionsCount", "isNsfwUnconsented", "isChannelNsfw", "nsfwAllowed", "callModel", "selectedVoiceChannel", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;ZIIZZLcom/discord/api/user/NsfwAllowance;Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/api/channel/Channel;)Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$StoreState$Valid;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/voice/model/CallModel;", "getCallModel", "Z", "I", "getChannelMentionsCount", "Lcom/discord/api/channel/Channel;", "getVoiceChannel", "getSelectedVoiceChannel", "getSelectedTextChannel", "getTotalMentionsCount", "Lcom/discord/api/user/NsfwAllowance;", "getNsfwAllowed", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;ZIIZZLcom/discord/api/user/NsfwAllowance;Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends StoreState {
            private final CallModel callModel;
            private final int channelMentionsCount;
            private final boolean isChannelNsfw;
            private final boolean isNsfwUnconsented;
            private final boolean isTextInVoiceEnabled;
            private final NsfwAllowance nsfwAllowed;
            private final Channel selectedTextChannel;
            private final Channel selectedVoiceChannel;
            private final int totalMentionsCount;
            private final Channel voiceChannel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Channel channel, Channel channel2, boolean z2, int i, int i2, boolean z3, boolean z4, NsfwAllowance nsfwAllowance, CallModel callModel, Channel channel3) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "voiceChannel");
                Intrinsics3.checkNotNullParameter(channel2, "selectedTextChannel");
                Intrinsics3.checkNotNullParameter(callModel, "callModel");
                this.voiceChannel = channel;
                this.selectedTextChannel = channel2;
                this.isTextInVoiceEnabled = z2;
                this.totalMentionsCount = i;
                this.channelMentionsCount = i2;
                this.isNsfwUnconsented = z3;
                this.isChannelNsfw = z4;
                this.nsfwAllowed = nsfwAllowance;
                this.callModel = callModel;
                this.selectedVoiceChannel = channel3;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Channel channel, Channel channel2, boolean z2, int i, int i2, boolean z3, boolean z4, NsfwAllowance nsfwAllowance, CallModel callModel, Channel channel3, int i3, Object obj) {
                return valid.copy((i3 & 1) != 0 ? valid.voiceChannel : channel, (i3 & 2) != 0 ? valid.selectedTextChannel : channel2, (i3 & 4) != 0 ? valid.isTextInVoiceEnabled : z2, (i3 & 8) != 0 ? valid.totalMentionsCount : i, (i3 & 16) != 0 ? valid.channelMentionsCount : i2, (i3 & 32) != 0 ? valid.isNsfwUnconsented : z3, (i3 & 64) != 0 ? valid.isChannelNsfw : z4, (i3 & 128) != 0 ? valid.nsfwAllowed : nsfwAllowance, (i3 & 256) != 0 ? valid.callModel : callModel, (i3 & 512) != 0 ? valid.selectedVoiceChannel : channel3);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getVoiceChannel() {
                return this.voiceChannel;
            }

            /* renamed from: component10, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* renamed from: component2, reason: from getter */
            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsTextInVoiceEnabled() {
                return this.isTextInVoiceEnabled;
            }

            /* renamed from: component4, reason: from getter */
            public final int getTotalMentionsCount() {
                return this.totalMentionsCount;
            }

            /* renamed from: component5, reason: from getter */
            public final int getChannelMentionsCount() {
                return this.channelMentionsCount;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsNsfwUnconsented() {
                return this.isNsfwUnconsented;
            }

            /* renamed from: component7, reason: from getter */
            public final boolean getIsChannelNsfw() {
                return this.isChannelNsfw;
            }

            /* renamed from: component8, reason: from getter */
            public final NsfwAllowance getNsfwAllowed() {
                return this.nsfwAllowed;
            }

            /* renamed from: component9, reason: from getter */
            public final CallModel getCallModel() {
                return this.callModel;
            }

            public final Valid copy(Channel voiceChannel, Channel selectedTextChannel, boolean isTextInVoiceEnabled, int totalMentionsCount, int channelMentionsCount, boolean isNsfwUnconsented, boolean isChannelNsfw, NsfwAllowance nsfwAllowed, CallModel callModel, Channel selectedVoiceChannel) {
                Intrinsics3.checkNotNullParameter(voiceChannel, "voiceChannel");
                Intrinsics3.checkNotNullParameter(selectedTextChannel, "selectedTextChannel");
                Intrinsics3.checkNotNullParameter(callModel, "callModel");
                return new Valid(voiceChannel, selectedTextChannel, isTextInVoiceEnabled, totalMentionsCount, channelMentionsCount, isNsfwUnconsented, isChannelNsfw, nsfwAllowed, callModel, selectedVoiceChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.voiceChannel, valid.voiceChannel) && Intrinsics3.areEqual(this.selectedTextChannel, valid.selectedTextChannel) && this.isTextInVoiceEnabled == valid.isTextInVoiceEnabled && this.totalMentionsCount == valid.totalMentionsCount && this.channelMentionsCount == valid.channelMentionsCount && this.isNsfwUnconsented == valid.isNsfwUnconsented && this.isChannelNsfw == valid.isChannelNsfw && Intrinsics3.areEqual(this.nsfwAllowed, valid.nsfwAllowed) && Intrinsics3.areEqual(this.callModel, valid.callModel) && Intrinsics3.areEqual(this.selectedVoiceChannel, valid.selectedVoiceChannel);
            }

            public final CallModel getCallModel() {
                return this.callModel;
            }

            public final int getChannelMentionsCount() {
                return this.channelMentionsCount;
            }

            public final NsfwAllowance getNsfwAllowed() {
                return this.nsfwAllowed;
            }

            public final Channel getSelectedTextChannel() {
                return this.selectedTextChannel;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final int getTotalMentionsCount() {
                return this.totalMentionsCount;
            }

            public final Channel getVoiceChannel() {
                return this.voiceChannel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Channel channel = this.voiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Channel channel2 = this.selectedTextChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                boolean z2 = this.isTextInVoiceEnabled;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (((((iHashCode2 + i) * 31) + this.totalMentionsCount) * 31) + this.channelMentionsCount) * 31;
                boolean z3 = this.isNsfwUnconsented;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.isChannelNsfw;
                int i5 = (i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
                NsfwAllowance nsfwAllowance = this.nsfwAllowed;
                int iHashCode3 = (i5 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31;
                CallModel callModel = this.callModel;
                int iHashCode4 = (iHashCode3 + (callModel != null ? callModel.hashCode() : 0)) * 31;
                Channel channel3 = this.selectedVoiceChannel;
                return iHashCode4 + (channel3 != null ? channel3.hashCode() : 0);
            }

            public final boolean isChannelNsfw() {
                return this.isChannelNsfw;
            }

            public final boolean isNsfwUnconsented() {
                return this.isNsfwUnconsented;
            }

            public final boolean isTextInVoiceEnabled() {
                return this.isTextInVoiceEnabled;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(voiceChannel=");
                sbU.append(this.voiceChannel);
                sbU.append(", selectedTextChannel=");
                sbU.append(this.selectedTextChannel);
                sbU.append(", isTextInVoiceEnabled=");
                sbU.append(this.isTextInVoiceEnabled);
                sbU.append(", totalMentionsCount=");
                sbU.append(this.totalMentionsCount);
                sbU.append(", channelMentionsCount=");
                sbU.append(this.channelMentionsCount);
                sbU.append(", isNsfwUnconsented=");
                sbU.append(this.isNsfwUnconsented);
                sbU.append(", isChannelNsfw=");
                sbU.append(this.isChannelNsfw);
                sbU.append(", nsfwAllowed=");
                sbU.append(this.nsfwAllowed);
                sbU.append(", callModel=");
                sbU.append(this.callModel);
                sbU.append(", selectedVoiceChannel=");
                sbU.append(this.selectedVoiceChannel);
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

    /* compiled from: WidgetCallPreviewFullscreenViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u001d\u001a\u00020\f\u0012\u0006\u0010\u001e\u001a\u00020\f\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0011\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0007J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0082\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b&\u0010\u000bJ\u0010\u0010'\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b'\u0010\u000eJ\u001a\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0019\u0010\u001d\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b,\u0010\u000eR\u0019\u0010\"\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010-\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\u001a\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b/\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b0\u0010\u0007R\u0019\u0010 \u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b \u00101\u001a\u0004\b2\u0010\u0013R\u001b\u0010#\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b#\u00103\u001a\u0004\b4\u0010\u0018R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b6\u0010\u000bR\u0019\u0010\u001e\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b7\u0010\u000eR\u0019\u0010!\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010-\u001a\u0004\b!\u0010\u0007R\u0019\u0010\u001f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010-\u001a\u0004\b\u001f\u0010\u0007¨\u0006:"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ViewState;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "component2", "()Z", "component3", "", "component4", "()Ljava/lang/String;", "", "component5", "()I", "component6", "component7", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList;", "component8", "()Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList;", "component9", "component10", "Lcom/discord/api/user/NsfwAllowance;", "component11", "()Lcom/discord/api/user/NsfwAllowance;", "voiceChannel", "isTextInVoiceChannelSelected", "textInVoiceEnabled", "titleText", "otherChannelsMentionsCount", "channelMentionsCount", "isConnectEnabled", "participantsList", "isNsfwUnconsented", "isChannelNsfw", "nsfwAllowed", "copy", "(Lcom/discord/api/channel/Channel;ZZLjava/lang/String;IIZLcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList;ZZLcom/discord/api/user/NsfwAllowance;)Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ViewState;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getOtherChannelsMentionsCount", "Z", "Lcom/discord/api/channel/Channel;", "getVoiceChannel", "getTextInVoiceEnabled", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList;", "getParticipantsList", "Lcom/discord/api/user/NsfwAllowance;", "getNsfwAllowed", "Ljava/lang/String;", "getTitleText", "getChannelMentionsCount", "<init>", "(Lcom/discord/api/channel/Channel;ZZLjava/lang/String;IIZLcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList;ZZLcom/discord/api/user/NsfwAllowance;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final int channelMentionsCount;
        private final boolean isChannelNsfw;
        private final boolean isConnectEnabled;
        private final boolean isNsfwUnconsented;
        private final boolean isTextInVoiceChannelSelected;
        private final NsfwAllowance nsfwAllowed;
        private final int otherChannelsMentionsCount;
        private final ParticipantsList participantsList;
        private final boolean textInVoiceEnabled;
        private final String titleText;
        private final Channel voiceChannel;

        public ViewState(Channel channel, boolean z2, boolean z3, String str, int i, int i2, boolean z4, ParticipantsList participantsList, boolean z5, boolean z6, NsfwAllowance nsfwAllowance) {
            Intrinsics3.checkNotNullParameter(channel, "voiceChannel");
            Intrinsics3.checkNotNullParameter(participantsList, "participantsList");
            this.voiceChannel = channel;
            this.isTextInVoiceChannelSelected = z2;
            this.textInVoiceEnabled = z3;
            this.titleText = str;
            this.otherChannelsMentionsCount = i;
            this.channelMentionsCount = i2;
            this.isConnectEnabled = z4;
            this.participantsList = participantsList;
            this.isNsfwUnconsented = z5;
            this.isChannelNsfw = z6;
            this.nsfwAllowed = nsfwAllowance;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, Channel channel, boolean z2, boolean z3, String str, int i, int i2, boolean z4, ParticipantsList participantsList, boolean z5, boolean z6, NsfwAllowance nsfwAllowance, int i3, Object obj) {
            return viewState.copy((i3 & 1) != 0 ? viewState.voiceChannel : channel, (i3 & 2) != 0 ? viewState.isTextInVoiceChannelSelected : z2, (i3 & 4) != 0 ? viewState.textInVoiceEnabled : z3, (i3 & 8) != 0 ? viewState.titleText : str, (i3 & 16) != 0 ? viewState.otherChannelsMentionsCount : i, (i3 & 32) != 0 ? viewState.channelMentionsCount : i2, (i3 & 64) != 0 ? viewState.isConnectEnabled : z4, (i3 & 128) != 0 ? viewState.participantsList : participantsList, (i3 & 256) != 0 ? viewState.isNsfwUnconsented : z5, (i3 & 512) != 0 ? viewState.isChannelNsfw : z6, (i3 & 1024) != 0 ? viewState.nsfwAllowed : nsfwAllowance);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getVoiceChannel() {
            return this.voiceChannel;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getIsChannelNsfw() {
            return this.isChannelNsfw;
        }

        /* renamed from: component11, reason: from getter */
        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsTextInVoiceChannelSelected() {
            return this.isTextInVoiceChannelSelected;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getTextInVoiceEnabled() {
            return this.textInVoiceEnabled;
        }

        /* renamed from: component4, reason: from getter */
        public final String getTitleText() {
            return this.titleText;
        }

        /* renamed from: component5, reason: from getter */
        public final int getOtherChannelsMentionsCount() {
            return this.otherChannelsMentionsCount;
        }

        /* renamed from: component6, reason: from getter */
        public final int getChannelMentionsCount() {
            return this.channelMentionsCount;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsConnectEnabled() {
            return this.isConnectEnabled;
        }

        /* renamed from: component8, reason: from getter */
        public final ParticipantsList getParticipantsList() {
            return this.participantsList;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        public final ViewState copy(Channel voiceChannel, boolean isTextInVoiceChannelSelected, boolean textInVoiceEnabled, String titleText, int otherChannelsMentionsCount, int channelMentionsCount, boolean isConnectEnabled, ParticipantsList participantsList, boolean isNsfwUnconsented, boolean isChannelNsfw, NsfwAllowance nsfwAllowed) {
            Intrinsics3.checkNotNullParameter(voiceChannel, "voiceChannel");
            Intrinsics3.checkNotNullParameter(participantsList, "participantsList");
            return new ViewState(voiceChannel, isTextInVoiceChannelSelected, textInVoiceEnabled, titleText, otherChannelsMentionsCount, channelMentionsCount, isConnectEnabled, participantsList, isNsfwUnconsented, isChannelNsfw, nsfwAllowed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.voiceChannel, viewState.voiceChannel) && this.isTextInVoiceChannelSelected == viewState.isTextInVoiceChannelSelected && this.textInVoiceEnabled == viewState.textInVoiceEnabled && Intrinsics3.areEqual(this.titleText, viewState.titleText) && this.otherChannelsMentionsCount == viewState.otherChannelsMentionsCount && this.channelMentionsCount == viewState.channelMentionsCount && this.isConnectEnabled == viewState.isConnectEnabled && Intrinsics3.areEqual(this.participantsList, viewState.participantsList) && this.isNsfwUnconsented == viewState.isNsfwUnconsented && this.isChannelNsfw == viewState.isChannelNsfw && Intrinsics3.areEqual(this.nsfwAllowed, viewState.nsfwAllowed);
        }

        public final int getChannelMentionsCount() {
            return this.channelMentionsCount;
        }

        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        public final int getOtherChannelsMentionsCount() {
            return this.otherChannelsMentionsCount;
        }

        public final ParticipantsList getParticipantsList() {
            return this.participantsList;
        }

        public final boolean getTextInVoiceEnabled() {
            return this.textInVoiceEnabled;
        }

        public final String getTitleText() {
            return this.titleText;
        }

        public final Channel getVoiceChannel() {
            return this.voiceChannel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.voiceChannel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.isTextInVoiceChannelSelected;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.textInVoiceEnabled;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            String str = this.titleText;
            int iHashCode2 = (((((i4 + (str != null ? str.hashCode() : 0)) * 31) + this.otherChannelsMentionsCount) * 31) + this.channelMentionsCount) * 31;
            boolean z4 = this.isConnectEnabled;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (iHashCode2 + i5) * 31;
            ParticipantsList participantsList = this.participantsList;
            int iHashCode3 = (i6 + (participantsList != null ? participantsList.hashCode() : 0)) * 31;
            boolean z5 = this.isNsfwUnconsented;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int i8 = (iHashCode3 + i7) * 31;
            boolean z6 = this.isChannelNsfw;
            int i9 = (i8 + (z6 ? 1 : z6 ? 1 : 0)) * 31;
            NsfwAllowance nsfwAllowance = this.nsfwAllowed;
            return i9 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0);
        }

        public final boolean isChannelNsfw() {
            return this.isChannelNsfw;
        }

        public final boolean isConnectEnabled() {
            return this.isConnectEnabled;
        }

        public final boolean isNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        public final boolean isTextInVoiceChannelSelected() {
            return this.isTextInVoiceChannelSelected;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(voiceChannel=");
            sbU.append(this.voiceChannel);
            sbU.append(", isTextInVoiceChannelSelected=");
            sbU.append(this.isTextInVoiceChannelSelected);
            sbU.append(", textInVoiceEnabled=");
            sbU.append(this.textInVoiceEnabled);
            sbU.append(", titleText=");
            sbU.append(this.titleText);
            sbU.append(", otherChannelsMentionsCount=");
            sbU.append(this.otherChannelsMentionsCount);
            sbU.append(", channelMentionsCount=");
            sbU.append(this.channelMentionsCount);
            sbU.append(", isConnectEnabled=");
            sbU.append(this.isConnectEnabled);
            sbU.append(", participantsList=");
            sbU.append(this.participantsList);
            sbU.append(", isNsfwUnconsented=");
            sbU.append(this.isNsfwUnconsented);
            sbU.append(", isChannelNsfw=");
            sbU.append(this.isChannelNsfw);
            sbU.append(", nsfwAllowed=");
            sbU.append(this.nsfwAllowed);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetCallPreviewFullscreenViewModel(long j, StoreChannels storeChannels, StoreMentions storeMentions, StoreNavigation storeNavigation, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannelsSelected storeChannelsSelected, StoreApplicationStreamPreviews storeApplicationStreamPreviews, StoreApplication storeApplication, StoreUser storeUser, Observable observable, StoreMediaSettings storeMediaSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreMentions mentions = (i & 4) != 0 ? StoreStream.INSTANCE.getMentions() : storeMentions;
        StoreNavigation navigation = (i & 8) != 0 ? StoreStream.INSTANCE.getNavigation() : storeNavigation;
        StoreUserSettings userSettings = (i & 16) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreChannelsSelected channelsSelected = (i & 64) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreApplicationStreamPreviews applicationStreamPreviews = (i & 128) != 0 ? StoreStream.INSTANCE.getApplicationStreamPreviews() : storeApplicationStreamPreviews;
        StoreApplication application = (i & 256) != 0 ? StoreStream.INSTANCE.getApplication() : storeApplication;
        StoreUser users = (i & 512) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        this(j, channels, mentions, navigation, userSettings, voiceChannelSelected, channelsSelected, applicationStreamPreviews, application, users, (i & 1024) != 0 ? Companion.access$observeStoreState(INSTANCE, j, users, channels, channelsSelected, mentions, voiceChannelSelected) : observable, (i & 2048) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetCallPreviewFullscreenViewModel widgetCallPreviewFullscreenViewModel, StoreState storeState) {
        widgetCallPreviewFullscreenViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        ModelApplicationStream stream;
        if (storeState instanceof StoreState.Valid) {
            this.mostRecentStoreState = storeState;
            StoreState.Valid valid = (StoreState.Valid) storeState;
            Map<Long, EmbeddedActivity> embeddedActivitiesForChannel = valid.getCallModel().getEmbeddedActivitiesForChannel();
            StoreApplicationStreaming.ActiveApplicationStream activeStream = valid.getCallModel().getActiveStream();
            List<CallParticipantsAdapter.ListItem> listCreateConnectedListItems = ParticipantsListItemGenerator.INSTANCE.createConnectedListItems(valid.getCallModel().getParticipants(), (activeStream == null || (stream = activeStream.getStream()) == null) ? null : stream.getEncodedStreamKey(), valid.getVoiceChannel(), valid.getCallModel(), _Collections.toList(embeddedActivitiesForChannel.values()), valid.getCallModel().getApplications());
            Channel selectedVoiceChannel = valid.getSelectedVoiceChannel();
            if (selectedVoiceChannel != null) {
                long id2 = selectedVoiceChannel.getId();
                long j = this.voiceChannelId;
                if (id2 == j) {
                    this.eventSubject.k.onNext(new Event.LaunchVideoCall(j, null));
                    return;
                }
            }
            Iterator<Long> it = embeddedActivitiesForChannel.keySet().iterator();
            while (it.hasNext()) {
                this.storeApplication.fetchIfNonexisting(it.next().longValue());
            }
            updateViewState(new ViewState(valid.getVoiceChannel(), ChannelUtils.J(valid.getSelectedTextChannel()), valid.isTextInVoiceEnabled(), ChannelUtils.c(valid.getVoiceChannel()), _Ranges.coerceAtLeast(valid.getTotalMentionsCount() - valid.getChannelMentionsCount(), 0), valid.getChannelMentionsCount(), valid.getCallModel().getVoiceChannelJoinability() != VoiceChannelJoinabilityUtils2.PERMISSIONS_MISSING, ParticipantsListItemGenerator.INSTANCE.refreshStreams(listCreateConnectedListItems, this.fetchedPreviews, this.storeApplicationStreamPreviews) ? new ParticipantsList.ListItems(listCreateConnectedListItems) : new ParticipantsList.Empty(listCreateConnectedListItems), valid.isNsfwUnconsented(), valid.isChannelNsfw(), valid.getNsfwAllowed()));
        }
    }

    @MainThread
    private final void joinVoiceChannel(long channelId) {
        this.storeVoiceChannelSelected.selectVoiceChannel(channelId);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.LaunchVideoCall(this.voiceChannelId, null));
    }

    public static /* synthetic */ void tryConnectToVoice$default(WidgetCallPreviewFullscreenViewModel widgetCallPreviewFullscreenViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetCallPreviewFullscreenViewModel.tryConnectToVoice(z2);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onStreamPreviewClicked(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            if (valid.getCallModel().getVoiceChannelJoinability() == VoiceChannelJoinabilityUtils2.GUILD_VIDEO_AT_CAPACITY) {
                PublishSubject<Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(Event.ShowGuildVideoAtCapacityDialog.INSTANCE);
            } else {
                ModelApplicationStream modelApplicationStreamDecodeStreamKey = ModelApplicationStream.INSTANCE.decodeStreamKey(streamKey);
                PublishSubject<Event> publishSubject2 = this.eventSubject;
                publishSubject2.k.onNext(new Event.LaunchVideoCall(modelApplicationStreamDecodeStreamKey.getChannelId(), streamKey));
            }
        }
    }

    @MainThread
    public final void onTextInVoiceTapped() {
        ChannelSelector companion = ChannelSelector.INSTANCE.getInstance();
        ViewState viewState = getViewState();
        ChannelSelector.selectChannel$default(companion, viewState != null ? viewState.getVoiceChannel() : null, null, StoreChannelsSelected3.TEXT_IN_VOICE, 2, null);
        StoreNavigation.setNavigationPanelAction$default(this.storeNavigation, StoreNavigation.PanelAction.CLOSE, null, 2, null);
    }

    public final void selectTextChannelAfterFinish() {
        Channel voiceChannel;
        ViewState viewState = getViewState();
        if (viewState == null || (voiceChannel = viewState.getVoiceChannel()) == null) {
            return;
        }
        long guildId = voiceChannel.getGuildId();
        if (viewState.isTextInVoiceChannelSelected()) {
            ChannelSelector.INSTANCE.getInstance().selectPreviousChannel(guildId);
        }
    }

    @MainThread
    public final void tryConnectToVoice(boolean muted) {
        StoreState storeState = this.mostRecentStoreState;
        if (storeState instanceof StoreState.Valid) {
            if (((StoreState.Valid) storeState).getCallModel().getVoiceChannelJoinability() == VoiceChannelJoinabilityUtils2.GUILD_VIDEO_AT_CAPACITY) {
                this.eventSubject.k.onNext(Event.ShowGuildVideoAtCapacityDialog.INSTANCE);
                return;
            }
            if (!this.storeUserSettings.getIsMobileOverlayEnabled()) {
                this.eventSubject.k.onNext(Event.ShowOverlayNux.INSTANCE);
            }
            if (muted) {
                this.mediaSettingsStore.setSelfMuted(true);
            }
            joinVoiceChannel(this.voiceChannelId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreenViewModel(long j, StoreChannels storeChannels, StoreMentions storeMentions, StoreNavigation storeNavigation, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannelsSelected storeChannelsSelected, StoreApplicationStreamPreviews storeApplicationStreamPreviews, StoreApplication storeApplication, StoreUser storeUser, Observable<StoreState> observable, StoreMediaSettings storeMediaSettings) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeMentions, "storeMentions");
        Intrinsics3.checkNotNullParameter(storeNavigation, "storeNavigation");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "storeUserSettings");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "storeVoiceChannelSelected");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeApplicationStreamPreviews, "storeApplicationStreamPreviews");
        Intrinsics3.checkNotNullParameter(storeApplication, "storeApplication");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        this.voiceChannelId = j;
        this.storeChannels = storeChannels;
        this.storeMentions = storeMentions;
        this.storeNavigation = storeNavigation;
        this.storeUserSettings = storeUserSettings;
        this.storeVoiceChannelSelected = storeVoiceChannelSelected;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeApplicationStreamPreviews = storeApplicationStreamPreviews;
        this.storeApplication = storeApplication;
        this.storeUser = storeUser;
        this.mediaSettingsStore = storeMediaSettings;
        this.eventSubject = PublishSubject.k0();
        this.fetchedPreviews = new LinkedHashSet();
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetCallPreviewFullscreenViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
