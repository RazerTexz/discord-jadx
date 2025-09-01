package com.discord.widgets.voice.sheet;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.view.ViewModel3;
import b.a.d.AppViewModel;
import b.a.j.FloatingViewManager;
import b.a.v.AcknowledgedTooltipsCache;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreApplication;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreEmbeddedActivities;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.tooltips.TooltipManager;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.permissions.VideoPermissionsManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils2;
import com.discord.utilities.voice.VoiceEngineServiceController;
import com.discord.widgets.voice.fullscreen.ParticipantsListItemGenerator;
import com.discord.widgets.voice.model.CallModel;
import com.discord.widgets.voice.model.CameraState;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import d0.Result3;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetVoiceBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 w2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004wxyzBÁ\u0001\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010]\u001a\u00020\u0003\u0012\b\b\u0002\u0010b\u001a\u00020a\u0012\b\b\u0002\u0010n\u001a\u00020m\u0012\b\b\u0002\u0010=\u001a\u00020<\u0012\b\b\u0002\u0010M\u001a\u00020L\u0012\b\b\u0002\u0010e\u001a\u00020d\u0012\b\b\u0002\u0010k\u001a\u00020j\u0012\b\b\u0002\u0010Y\u001a\u00020X\u0012\b\b\u0002\u0010P\u001a\u00020O\u0012\b\b\u0002\u0010H\u001a\u00020G\u0012\b\b\u0002\u0010:\u001a\u000209\u0012\b\b\u0002\u0010S\u001a\u00020R\u0012\b\b\u0002\u0010C\u001a\u00020B\u0012\b\b\u0002\u0010h\u001a\u00020g\u0012\b\b\u0002\u0010V\u001a\u00020U\u0012\b\b\u0002\u0010_\u001a\u00020^\u0012\u000e\b\u0002\u0010t\u001a\b\u0012\u0004\u0012\u00020\f0\u0019¢\u0006\u0004\bu\u0010vJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\t2\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0007¢\u0006\u0004\b \u0010\u0011J\u000f\u0010!\u001a\u00020\tH\u0007¢\u0006\u0004\b!\u0010\u0011J\u000f\u0010\"\u001a\u00020\tH\u0007¢\u0006\u0004\b\"\u0010\u0011J\u000f\u0010#\u001a\u00020\tH\u0007¢\u0006\u0004\b#\u0010\u0011J\u000f\u0010$\u001a\u00020\tH\u0007¢\u0006\u0004\b$\u0010\u0011J\u000f\u0010%\u001a\u00020\tH\u0007¢\u0006\u0004\b%\u0010\u0011J\u000f\u0010&\u001a\u00020\tH\u0007¢\u0006\u0004\b&\u0010\u0011J\u0017\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\tH\u0007¢\u0006\u0004\b+\u0010\u0011J\u0015\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\t2\u0006\u00100\u001a\u00020\u0003H\u0007¢\u0006\u0004\b1\u0010\u001fJ\u001b\u00105\u001a\u00020\t2\n\u00104\u001a\u000602j\u0002`3H\u0007¢\u0006\u0004\b5\u00106R\u0018\u00107\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R \u0010@\u001a\f\u0012\b\u0012\u000602j\u0002`30?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010E\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u00020O8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010S\u001a\u00020R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010V\u001a\u00020U8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Y\u001a\u00020X8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010KR\u001a\u0010\b\u001a\u00060\u0006j\u0002`\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\\R\u0016\u0010]\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010KR\u0016\u0010_\u001a\u00020^8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010b\u001a\u00020a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010e\u001a\u00020d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010k\u001a\u00020j8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010n\u001a\u00020m8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR:\u0010r\u001a&\u0012\f\u0012\n q*\u0004\u0018\u00010\u001a0\u001a q*\u0012\u0012\f\u0012\n q*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010p0p8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010s¨\u0006{"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$ViewState;", "", "hasVideoPermission", "()Z", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "joinVoiceChannel", "(J)V", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState;)V", "emitSuppressedDialogEvent", "()V", "emitServerMutedDialogEvent", "emitServerDeafenedDialogEvent", "emitShowNoVideoPermissionDialogEvent", "emitShowNoScreenSharePermissionDialogEvent", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getGuildScheduledEventToEnd", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "Lrx/Observable;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "observeEvents", "()Lrx/Observable;", "useVideo", "tryConnectToVoice", "(Z)V", "onMutePressed", "onDeafenPressed", "onNoiseCancellationPressed", "onCameraButtonPressed", "onCameraPermissionsGranted", "onDisconnectPressed", "onDisconnect", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "voiceUser", "onToggleRingingPressed", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", "onScreenSharePressed", "Landroid/content/Intent;", "intent", "startStream", "(Landroid/content/Intent;)V", "pressed", "onPttPressed", "", "Lcom/discord/primitives/StreamKey;", "streamKey", "onStreamPreviewClicked", "(Ljava/lang/String;)V", "wasConnected", "Ljava/lang/Boolean;", "Lcom/discord/stores/StoreApplicationStreamPreviews;", "storeApplicationStreamPreviews", "Lcom/discord/stores/StoreApplicationStreamPreviews;", "Lcom/discord/stores/StoreVoiceChannelSelected;", "selectedVoiceChannelStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "", "fetchedPreviews", "Ljava/util/Set;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "mostRecentStoreState", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState;", "Lcom/discord/utilities/permissions/VideoPermissionsManager;", "videoPermissionsManager", "Lcom/discord/utilities/permissions/VideoPermissionsManager;", "wasEverMultiParticipant", "Z", "Lcom/discord/stores/StoreMediaSettings;", "mediaSettingsStore", "Lcom/discord/stores/StoreMediaSettings;", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/utilities/voice/VoiceEngineServiceController;", "voiceEngineServiceController", "Lcom/discord/utilities/voice/VoiceEngineServiceController;", "Lcom/discord/stores/StoreEmbeddedActivities;", "embeddedActivitiesStore", "Lcom/discord/stores/StoreEmbeddedActivities;", "Lcom/discord/stores/StoreCalls;", "callsStore", "Lcom/discord/stores/StoreCalls;", "wasEverConnected", "J", "forwardToFullscreenIfVideoActivated", "Lcom/discord/stores/StoreApplication;", "applicationStore", "Lcom/discord/stores/StoreApplication;", "Lcom/discord/stores/StoreChannels;", "channelStore", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreMediaEngine;", "mediaEngineStore", "Lcom/discord/stores/StoreMediaEngine;", "Lcom/discord/tooltips/TooltipManager;", "tooltipManager", "Lcom/discord/tooltips/TooltipManager;", "Lcom/discord/stores/StoreUserSettings;", "userSettingsStore", "Lcom/discord/stores/StoreUserSettings;", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StorePermissions;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "storeStateObservable", "<init>", "(JZLcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreMediaSettings;Lcom/discord/stores/StoreMediaEngine;Lcom/discord/stores/StoreUserSettings;Lcom/discord/stores/StoreCalls;Lcom/discord/stores/StoreGuilds;Lcom/discord/utilities/permissions/VideoPermissionsManager;Lcom/discord/stores/StoreApplicationStreamPreviews;Lcom/discord/utilities/voice/VoiceEngineServiceController;Lcom/discord/utilities/time/Clock;Lcom/discord/tooltips/TooltipManager;Lcom/discord/stores/StoreEmbeddedActivities;Lcom/discord/stores/StoreApplication;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetVoiceBottomSheetViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreApplication applicationStore;
    private final StoreCalls callsStore;
    private final long channelId;
    private final StoreChannels channelStore;
    private final Clock clock;
    private final StoreEmbeddedActivities embeddedActivitiesStore;
    private final PublishSubject<Event> eventSubject;
    private Set<String> fetchedPreviews;
    private final boolean forwardToFullscreenIfVideoActivated;
    private final StoreGuilds guildsStore;
    private final StoreMediaEngine mediaEngineStore;
    private final StoreMediaSettings mediaSettingsStore;
    private StoreState mostRecentStoreState;
    private final StorePermissions permissionsStore;
    private final StoreVoiceChannelSelected selectedVoiceChannelStore;
    private final StoreApplicationStreamPreviews storeApplicationStreamPreviews;
    private final TooltipManager tooltipManager;
    private final StoreUserSettings userSettingsStore;
    private final VideoPermissionsManager videoPermissionsManager;
    private final VoiceEngineServiceController voiceEngineServiceController;
    private Boolean wasConnected;
    private boolean wasEverConnected;
    private boolean wasEverMultiParticipant;

    /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel$1, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetVoiceBottomSheetViewModel.access$handleStoreState(WidgetVoiceBottomSheetViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lrx/Observable;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState;", "observeStoreState", "(JLcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreChannels;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StorePermissions storePermissions, StoreChannels storeChannels) {
            return companion.observeStoreState(j, storePermissions, storeChannels);
        }

        private final Observable<StoreState> observeStoreState(long channelId, StorePermissions permissionsStore, StoreChannels channelsStore) {
            Observable observableY = channelsStore.observeChannel(channelId).Y(new WidgetVoiceBottomSheetViewModel2(channelId, permissionsStore));
            Intrinsics3.checkNotNullExpressionValue(observableY, "channelsStore.observeCha…      }\n        }\n      }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0014\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0014\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+¨\u0006,"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "", "<init>", "()V", "AccessibilityAnnouncement", "Dismiss", "EnqueueCallFeedbackSheet", "ExpandSheet", "LaunchStageChannel", "LaunchVideoCall", "RequestStartStream", "ShowCameraCapacityDialog", "ShowEventEnd", "ShowGuildVideoAtCapacityDialog", "ShowNoScreenSharePermissionDialog", "ShowNoVideoDevicesAvailableToast", "ShowNoVideoPermissionDialog", "ShowNoiseCancellationBottomSheet", "ShowOverlayNux", "ShowRequestCameraPermissionsDialog", "ShowServerDeafenedDialog", "ShowServerMutedDialog", "ShowSuppressedDialog", "ShowToast", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowSuppressedDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowServerMutedDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowServerDeafenedDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowNoVideoPermissionDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowNoVideoDevicesAvailableToast;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowNoScreenSharePermissionDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowRequestCameraPermissionsDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowGuildVideoAtCapacityDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowOverlayNux;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowNoiseCancellationBottomSheet;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowToast;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$Dismiss;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$EnqueueCallFeedbackSheet;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$RequestStartStream;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ExpandSheet;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "", "component1", "()I", "messageResId", "copy", "(I)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$AccessibilityAnnouncement;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getMessageResId", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class AccessibilityAnnouncement extends Event {
            private final int messageResId;

            public AccessibilityAnnouncement(@StringRes int i) {
                super(null);
                this.messageResId = i;
            }

            public static /* synthetic */ AccessibilityAnnouncement copy$default(AccessibilityAnnouncement accessibilityAnnouncement, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = accessibilityAnnouncement.messageResId;
                }
                return accessibilityAnnouncement.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getMessageResId() {
                return this.messageResId;
            }

            public final AccessibilityAnnouncement copy(@StringRes int messageResId) {
                return new AccessibilityAnnouncement(messageResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof AccessibilityAnnouncement) && this.messageResId == ((AccessibilityAnnouncement) other).messageResId;
                }
                return true;
            }

            public final int getMessageResId() {
                return this.messageResId;
            }

            public int hashCode() {
                return this.messageResId;
            }

            public String toString() {
                return outline.B(outline.U("AccessibilityAnnouncement(messageResId="), this.messageResId, ")");
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$Dismiss;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\u0011\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\u000e\u0010\u0012\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b&\u0010'J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJV\u0010\u0015\u001a\u00020\u00002\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0017\u0010\tJ\u0010\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000fJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005R!\u0010\u0012\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\tR\u0019\u0010\u0014\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b$\u0010\u0005R!\u0010\u0011\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b%\u0010\t¨\u0006("}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$EnqueueCallFeedbackSheet;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "Lcom/discord/primitives/RtcConnectionId;", "component2", "()Ljava/lang/String;", "Lcom/discord/primitives/MediaSessionId;", "component3", "component4", "", "component5", "()I", "channelId", "rtcConnectionId", "mediaSessionId", "callDuration", "triggerRateDenominator", "copy", "(JLjava/lang/String;Ljava/lang/String;JI)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$EnqueueCallFeedbackSheet;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "Ljava/lang/String;", "getMediaSessionId", "I", "getTriggerRateDenominator", "getCallDuration", "getRtcConnectionId", "<init>", "(JLjava/lang/String;Ljava/lang/String;JI)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class EnqueueCallFeedbackSheet extends Event {
            private final long callDuration;
            private final long channelId;
            private final String mediaSessionId;
            private final String rtcConnectionId;
            private final int triggerRateDenominator;

            public EnqueueCallFeedbackSheet(long j, String str, String str2, long j2, int i) {
                super(null);
                this.channelId = j;
                this.rtcConnectionId = str;
                this.mediaSessionId = str2;
                this.callDuration = j2;
                this.triggerRateDenominator = i;
            }

            public static /* synthetic */ EnqueueCallFeedbackSheet copy$default(EnqueueCallFeedbackSheet enqueueCallFeedbackSheet, long j, String str, String str2, long j2, int i, int i2, Object obj) {
                return enqueueCallFeedbackSheet.copy((i2 & 1) != 0 ? enqueueCallFeedbackSheet.channelId : j, (i2 & 2) != 0 ? enqueueCallFeedbackSheet.rtcConnectionId : str, (i2 & 4) != 0 ? enqueueCallFeedbackSheet.mediaSessionId : str2, (i2 & 8) != 0 ? enqueueCallFeedbackSheet.callDuration : j2, (i2 & 16) != 0 ? enqueueCallFeedbackSheet.triggerRateDenominator : i);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getRtcConnectionId() {
                return this.rtcConnectionId;
            }

            /* renamed from: component3, reason: from getter */
            public final String getMediaSessionId() {
                return this.mediaSessionId;
            }

            /* renamed from: component4, reason: from getter */
            public final long getCallDuration() {
                return this.callDuration;
            }

            /* renamed from: component5, reason: from getter */
            public final int getTriggerRateDenominator() {
                return this.triggerRateDenominator;
            }

            public final EnqueueCallFeedbackSheet copy(long channelId, String rtcConnectionId, String mediaSessionId, long callDuration, int triggerRateDenominator) {
                return new EnqueueCallFeedbackSheet(channelId, rtcConnectionId, mediaSessionId, callDuration, triggerRateDenominator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EnqueueCallFeedbackSheet)) {
                    return false;
                }
                EnqueueCallFeedbackSheet enqueueCallFeedbackSheet = (EnqueueCallFeedbackSheet) other;
                return this.channelId == enqueueCallFeedbackSheet.channelId && Intrinsics3.areEqual(this.rtcConnectionId, enqueueCallFeedbackSheet.rtcConnectionId) && Intrinsics3.areEqual(this.mediaSessionId, enqueueCallFeedbackSheet.mediaSessionId) && this.callDuration == enqueueCallFeedbackSheet.callDuration && this.triggerRateDenominator == enqueueCallFeedbackSheet.triggerRateDenominator;
            }

            public final long getCallDuration() {
                return this.callDuration;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final String getMediaSessionId() {
                return this.mediaSessionId;
            }

            public final String getRtcConnectionId() {
                return this.rtcConnectionId;
            }

            public final int getTriggerRateDenominator() {
                return this.triggerRateDenominator;
            }

            public int hashCode() {
                int iA = b.a(this.channelId) * 31;
                String str = this.rtcConnectionId;
                int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.mediaSessionId;
                return ((b.a(this.callDuration) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31) + this.triggerRateDenominator;
            }

            public String toString() {
                StringBuilder sbU = outline.U("EnqueueCallFeedbackSheet(channelId=");
                sbU.append(this.channelId);
                sbU.append(", rtcConnectionId=");
                sbU.append(this.rtcConnectionId);
                sbU.append(", mediaSessionId=");
                sbU.append(this.mediaSessionId);
                sbU.append(", callDuration=");
                sbU.append(this.callDuration);
                sbU.append(", triggerRateDenominator=");
                return outline.B(sbU, this.triggerRateDenominator, ")");
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ExpandSheet;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ExpandSheet extends Event {
            public static final ExpandSheet INSTANCE = new ExpandSheet();

            private ExpandSheet() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "channelId", "copy", "(J)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$LaunchStageChannel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class LaunchStageChannel extends Event {
            private final long channelId;

            public LaunchStageChannel(long j) {
                super(null);
                this.channelId = j;
            }

            public static /* synthetic */ LaunchStageChannel copy$default(LaunchStageChannel launchStageChannel, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchStageChannel.channelId;
                }
                return launchStageChannel.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            public final LaunchStageChannel copy(long channelId) {
                return new LaunchStageChannel(channelId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LaunchStageChannel) && this.channelId == ((LaunchStageChannel) other).channelId;
                }
                return true;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public int hashCode() {
                return b.a(this.channelId);
            }

            public String toString() {
                return outline.C(outline.U("LaunchStageChannel(channelId="), this.channelId, ")");
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ0\u0010\f\u001a\u00020\u00002\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005R!\u0010\u000b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "Lcom/discord/primitives/StreamKey;", "component2", "()Ljava/lang/String;", "channelId", "autoTargetStreamKey", "copy", "(JLjava/lang/String;)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$LaunchVideoCall;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "Ljava/lang/String;", "getAutoTargetStreamKey", "<init>", "(JLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$RequestStartStream;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class RequestStartStream extends Event {
            public static final RequestStartStream INSTANCE = new RequestStartStream();

            private RequestStartStream() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "", "component1", "()I", "guildMaxVideoChannelUsers", "copy", "(I)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowCameraCapacityDialog;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getGuildMaxVideoChannelUsers", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowCameraCapacityDialog extends Event {
            private final int guildMaxVideoChannelUsers;

            public ShowCameraCapacityDialog(int i) {
                super(null);
                this.guildMaxVideoChannelUsers = i;
            }

            public static /* synthetic */ ShowCameraCapacityDialog copy$default(ShowCameraCapacityDialog showCameraCapacityDialog, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showCameraCapacityDialog.guildMaxVideoChannelUsers;
                }
                return showCameraCapacityDialog.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getGuildMaxVideoChannelUsers() {
                return this.guildMaxVideoChannelUsers;
            }

            public final ShowCameraCapacityDialog copy(int guildMaxVideoChannelUsers) {
                return new ShowCameraCapacityDialog(guildMaxVideoChannelUsers);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowCameraCapacityDialog) && this.guildMaxVideoChannelUsers == ((ShowCameraCapacityDialog) other).guildMaxVideoChannelUsers;
                }
                return true;
            }

            public final int getGuildMaxVideoChannelUsers() {
                return this.guildMaxVideoChannelUsers;
            }

            public int hashCode() {
                return this.guildMaxVideoChannelUsers;
            }

            public String toString() {
                return outline.B(outline.U("ShowCameraCapacityDialog(guildMaxVideoChannelUsers="), this.guildMaxVideoChannelUsers, ")");
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component1", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvent", "copy", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowEventEnd;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getGuildScheduledEvent", "<init>", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowEventEnd extends Event {
            private final GuildScheduledEvent guildScheduledEvent;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowEventEnd(GuildScheduledEvent guildScheduledEvent) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
                this.guildScheduledEvent = guildScheduledEvent;
            }

            public static /* synthetic */ ShowEventEnd copy$default(ShowEventEnd showEventEnd, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildScheduledEvent = showEventEnd.guildScheduledEvent;
                }
                return showEventEnd.copy(guildScheduledEvent);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildScheduledEvent getGuildScheduledEvent() {
                return this.guildScheduledEvent;
            }

            public final ShowEventEnd copy(GuildScheduledEvent guildScheduledEvent) {
                Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
                return new ShowEventEnd(guildScheduledEvent);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowEventEnd) && Intrinsics3.areEqual(this.guildScheduledEvent, ((ShowEventEnd) other).guildScheduledEvent);
                }
                return true;
            }

            public final GuildScheduledEvent getGuildScheduledEvent() {
                return this.guildScheduledEvent;
            }

            public int hashCode() {
                GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
                if (guildScheduledEvent != null) {
                    return guildScheduledEvent.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ShowEventEnd(guildScheduledEvent=");
                sbU.append(this.guildScheduledEvent);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowGuildVideoAtCapacityDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowGuildVideoAtCapacityDialog extends Event {
            public static final ShowGuildVideoAtCapacityDialog INSTANCE = new ShowGuildVideoAtCapacityDialog();

            private ShowGuildVideoAtCapacityDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowNoScreenSharePermissionDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowNoScreenSharePermissionDialog extends Event {
            public static final ShowNoScreenSharePermissionDialog INSTANCE = new ShowNoScreenSharePermissionDialog();

            private ShowNoScreenSharePermissionDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowNoVideoDevicesAvailableToast;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowNoVideoDevicesAvailableToast extends Event {
            public static final ShowNoVideoDevicesAvailableToast INSTANCE = new ShowNoVideoDevicesAvailableToast();

            private ShowNoVideoDevicesAvailableToast() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowNoVideoPermissionDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowNoVideoPermissionDialog extends Event {
            public static final ShowNoVideoPermissionDialog INSTANCE = new ShowNoVideoPermissionDialog();

            private ShowNoVideoPermissionDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowNoiseCancellationBottomSheet;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowNoiseCancellationBottomSheet extends Event {
            public static final ShowNoiseCancellationBottomSheet INSTANCE = new ShowNoiseCancellationBottomSheet();

            private ShowNoiseCancellationBottomSheet() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowOverlayNux;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowOverlayNux extends Event {
            public static final ShowOverlayNux INSTANCE = new ShowOverlayNux();

            private ShowOverlayNux() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowRequestCameraPermissionsDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowRequestCameraPermissionsDialog extends Event {
            public static final ShowRequestCameraPermissionsDialog INSTANCE = new ShowRequestCameraPermissionsDialog();

            private ShowRequestCameraPermissionsDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowServerDeafenedDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowServerDeafenedDialog extends Event {
            public static final ShowServerDeafenedDialog INSTANCE = new ShowServerDeafenedDialog();

            private ShowServerDeafenedDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowServerMutedDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowServerMutedDialog extends Event {
            public static final ShowServerMutedDialog INSTANCE = new ShowServerMutedDialog();

            private ShowServerMutedDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowSuppressedDialog;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowSuppressedDialog extends Event {
            public static final ShowSuppressedDialog INSTANCE = new ShowSuppressedDialog();

            private ShowSuppressedDialog() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowToast;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "", "component1", "()I", "toastResId", "copy", "(I)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event$ShowToast;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getToastResId", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowToast extends Event {
            private final int toastResId;

            public ShowToast(@StringRes int i) {
                super(null);
                this.toastResId = i;
            }

            public static /* synthetic */ ShowToast copy$default(ShowToast showToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showToast.toastResId;
                }
                return showToast.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getToastResId() {
                return this.toastResId;
            }

            public final ShowToast copy(@StringRes int toastResId) {
                return new ShowToast(toastResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowToast) && this.toastResId == ((ShowToast) other).toastResId;
                }
                return true;
            }

            public final int getToastResId() {
                return this.toastResId;
            }

            public int hashCode() {
                return this.toastResId;
            }

            public String toString() {
                return outline.B(outline.U("ShowToast(toastResId="), this.toastResId, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState$Invalid;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState$Valid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState$Invalid;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0010\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\rJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\rR!\u0010\u0010\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u000bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState$Valid;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState;", "Lcom/discord/widgets/voice/model/CallModel;", "component1", "()Lcom/discord/widgets/voice/model/CallModel;", "", "component2", "()Ljava/lang/Boolean;", "", "Lcom/discord/api/permission/PermissionBit;", "component3", "()Ljava/lang/Long;", "component4", "()Z", "callModel", "noiseCancellation", "myPermissions", "textInVoiceEnabled", "copy", "(Lcom/discord/widgets/voice/model/CallModel;Ljava/lang/Boolean;Ljava/lang/Long;Z)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$StoreState$Valid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getTextInVoiceEnabled", "Ljava/lang/Long;", "getMyPermissions", "Ljava/lang/Boolean;", "getNoiseCancellation", "Lcom/discord/widgets/voice/model/CallModel;", "getCallModel", "<init>", "(Lcom/discord/widgets/voice/model/CallModel;Ljava/lang/Boolean;Ljava/lang/Long;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Valid extends StoreState {
            private final CallModel callModel;
            private final Long myPermissions;
            private final Boolean noiseCancellation;
            private final boolean textInVoiceEnabled;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(CallModel callModel, Boolean bool, Long l, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(callModel, "callModel");
                this.callModel = callModel;
                this.noiseCancellation = bool;
                this.myPermissions = l;
                this.textInVoiceEnabled = z2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, CallModel callModel, Boolean bool, Long l, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    callModel = valid.callModel;
                }
                if ((i & 2) != 0) {
                    bool = valid.noiseCancellation;
                }
                if ((i & 4) != 0) {
                    l = valid.myPermissions;
                }
                if ((i & 8) != 0) {
                    z2 = valid.textInVoiceEnabled;
                }
                return valid.copy(callModel, bool, l, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final CallModel getCallModel() {
                return this.callModel;
            }

            /* renamed from: component2, reason: from getter */
            public final Boolean getNoiseCancellation() {
                return this.noiseCancellation;
            }

            /* renamed from: component3, reason: from getter */
            public final Long getMyPermissions() {
                return this.myPermissions;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getTextInVoiceEnabled() {
                return this.textInVoiceEnabled;
            }

            public final Valid copy(CallModel callModel, Boolean noiseCancellation, Long myPermissions, boolean textInVoiceEnabled) {
                Intrinsics3.checkNotNullParameter(callModel, "callModel");
                return new Valid(callModel, noiseCancellation, myPermissions, textInVoiceEnabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.callModel, valid.callModel) && Intrinsics3.areEqual(this.noiseCancellation, valid.noiseCancellation) && Intrinsics3.areEqual(this.myPermissions, valid.myPermissions) && this.textInVoiceEnabled == valid.textInVoiceEnabled;
            }

            public final CallModel getCallModel() {
                return this.callModel;
            }

            public final Long getMyPermissions() {
                return this.myPermissions;
            }

            public final Boolean getNoiseCancellation() {
                return this.noiseCancellation;
            }

            public final boolean getTextInVoiceEnabled() {
                return this.textInVoiceEnabled;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                CallModel callModel = this.callModel;
                int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
                Boolean bool = this.noiseCancellation;
                int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
                Long l = this.myPermissions;
                int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
                boolean z2 = this.textInVoiceEnabled;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode3 + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(callModel=");
                sbU.append(this.callModel);
                sbU.append(", noiseCancellation=");
                sbU.append(this.noiseCancellation);
                sbU.append(", myPermissions=");
                sbU.append(this.myPermissions);
                sbU.append(", textInVoiceEnabled=");
                return outline.O(sbU, this.textInVoiceEnabled, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u000f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014Jf\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004J\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0018\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010\u000bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\b*\u0010\u0014R\u001c\u0010\u001a\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b\u001a\u0010\u000bR\u001c\u0010\u0015\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\u0004R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010-\u001a\u0004\b\u0019\u0010\rR\u001c\u0010\u0017\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\bR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u001b\u001a\u00020\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\b2\u0010\u0011¨\u00065"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$ViewState;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$ViewState;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/discord/api/channel/Channel;", "component3", "()Lcom/discord/api/channel/Channel;", "", "component4", "()Z", "component5", "()Ljava/lang/Boolean;", "component6", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent;", "component7", "()Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent;", "component8", "()Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent;", "title", "subtitle", "channel", "showInviteOption", "isNoiseCancellationActive", "isDeafened", "centerContent", "bottomContent", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/channel/Channel;ZLjava/lang/Boolean;ZLcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent;Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent;)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$ViewState;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShowInviteOption", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent;", "getBottomContent", "Ljava/lang/String;", "getTitle", "Ljava/lang/Boolean;", "Lcom/discord/api/channel/Channel;", "getChannel", "getSubtitle", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent;", "getCenterContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/discord/api/channel/Channel;ZLjava/lang/Boolean;ZLcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent;Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState implements WidgetVoiceBottomSheet.ViewState {
        private final WidgetVoiceBottomSheet.BottomContent bottomContent;
        private final WidgetVoiceBottomSheet.CenterContent centerContent;
        private final Channel channel;
        private final boolean isDeafened;
        private final Boolean isNoiseCancellationActive;
        private final boolean showInviteOption;
        private final String subtitle;
        private final String title;

        public ViewState(String str, String str2, Channel channel, boolean z2, Boolean bool, boolean z3, WidgetVoiceBottomSheet.CenterContent centerContent, WidgetVoiceBottomSheet.BottomContent bottomContent) {
            Intrinsics3.checkNotNullParameter(str, "title");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(centerContent, "centerContent");
            this.title = str;
            this.subtitle = str2;
            this.channel = channel;
            this.showInviteOption = z2;
            this.isNoiseCancellationActive = bool;
            this.isDeafened = z3;
            this.centerContent = centerContent;
            this.bottomContent = bottomContent;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, String str, String str2, Channel channel, boolean z2, Boolean bool, boolean z3, WidgetVoiceBottomSheet.CenterContent centerContent, WidgetVoiceBottomSheet.BottomContent bottomContent, int i, Object obj) {
            return viewState.copy((i & 1) != 0 ? viewState.getTitle() : str, (i & 2) != 0 ? viewState.getSubtitle() : str2, (i & 4) != 0 ? viewState.getChannel() : channel, (i & 8) != 0 ? viewState.getShowInviteOption() : z2, (i & 16) != 0 ? viewState.getIsNoiseCancellationActive() : bool, (i & 32) != 0 ? viewState.getIsDeafened() : z3, (i & 64) != 0 ? viewState.getCenterContent() : centerContent, (i & 128) != 0 ? viewState.getBottomContent() : bottomContent);
        }

        public final String component1() {
            return getTitle();
        }

        public final String component2() {
            return getSubtitle();
        }

        public final Channel component3() {
            return getChannel();
        }

        public final boolean component4() {
            return getShowInviteOption();
        }

        public final Boolean component5() {
            return getIsNoiseCancellationActive();
        }

        public final boolean component6() {
            return getIsDeafened();
        }

        public final WidgetVoiceBottomSheet.CenterContent component7() {
            return getCenterContent();
        }

        public final WidgetVoiceBottomSheet.BottomContent component8() {
            return getBottomContent();
        }

        public final ViewState copy(String title, String subtitle, Channel channel, boolean showInviteOption, Boolean isNoiseCancellationActive, boolean isDeafened, WidgetVoiceBottomSheet.CenterContent centerContent, WidgetVoiceBottomSheet.BottomContent bottomContent) {
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(centerContent, "centerContent");
            return new ViewState(title, subtitle, channel, showInviteOption, isNoiseCancellationActive, isDeafened, centerContent, bottomContent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(getTitle(), viewState.getTitle()) && Intrinsics3.areEqual(getSubtitle(), viewState.getSubtitle()) && Intrinsics3.areEqual(getChannel(), viewState.getChannel()) && getShowInviteOption() == viewState.getShowInviteOption() && Intrinsics3.areEqual(getIsNoiseCancellationActive(), viewState.getIsNoiseCancellationActive()) && getIsDeafened() == viewState.getIsDeafened() && Intrinsics3.areEqual(getCenterContent(), viewState.getCenterContent()) && Intrinsics3.areEqual(getBottomContent(), viewState.getBottomContent());
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        public WidgetVoiceBottomSheet.BottomContent getBottomContent() {
            return this.bottomContent;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        public WidgetVoiceBottomSheet.CenterContent getCenterContent() {
            return this.centerContent;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        public Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        public boolean getShowInviteOption() {
            return this.showInviteOption;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        public String getSubtitle() {
            return this.subtitle;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String title = getTitle();
            int iHashCode = (title != null ? title.hashCode() : 0) * 31;
            String subtitle = getSubtitle();
            int iHashCode2 = (iHashCode + (subtitle != null ? subtitle.hashCode() : 0)) * 31;
            Channel channel = getChannel();
            int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean showInviteOption = getShowInviteOption();
            int i = showInviteOption;
            if (showInviteOption) {
                i = 1;
            }
            int i2 = (iHashCode3 + i) * 31;
            Boolean isNoiseCancellationActive = getIsNoiseCancellationActive();
            int iHashCode4 = (i2 + (isNoiseCancellationActive != null ? isNoiseCancellationActive.hashCode() : 0)) * 31;
            boolean isDeafened = getIsDeafened();
            int i3 = (iHashCode4 + (isDeafened ? 1 : isDeafened)) * 31;
            WidgetVoiceBottomSheet.CenterContent centerContent = getCenterContent();
            int iHashCode5 = (i3 + (centerContent != null ? centerContent.hashCode() : 0)) * 31;
            WidgetVoiceBottomSheet.BottomContent bottomContent = getBottomContent();
            return iHashCode5 + (bottomContent != null ? bottomContent.hashCode() : 0);
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        /* renamed from: isDeafened, reason: from getter */
        public boolean getIsDeafened() {
            return this.isDeafened;
        }

        @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.ViewState
        /* renamed from: isNoiseCancellationActive, reason: from getter */
        public Boolean getIsNoiseCancellationActive() {
            return this.isNoiseCancellationActive;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(title=");
            sbU.append(getTitle());
            sbU.append(", subtitle=");
            sbU.append(getSubtitle());
            sbU.append(", channel=");
            sbU.append(getChannel());
            sbU.append(", showInviteOption=");
            sbU.append(getShowInviteOption());
            sbU.append(", isNoiseCancellationActive=");
            sbU.append(getIsNoiseCancellationActive());
            sbU.append(", isDeafened=");
            sbU.append(getIsDeafened());
            sbU.append(", centerContent=");
            sbU.append(getCenterContent());
            sbU.append(", bottomContent=");
            sbU.append(getBottomContent());
            sbU.append(")");
            return sbU.toString();
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

    /* compiled from: WidgetVoiceBottomSheetViewModel.kt */
    @DebugMetadata(c = "com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel$tryConnectToVoice$1", f = "WidgetVoiceBottomSheetViewModel.kt", l = {Opcodes.IRETURN, 180}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel$tryConnectToVoice$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ StoreMediaEngine $mediaEngine;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreMediaEngine storeMediaEngine, Continuation continuation) {
            super(2, continuation);
            this.$mediaEngine = storeMediaEngine;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return WidgetVoiceBottomSheetViewModel.this.new AnonymousClass1(this.$mediaEngine, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                StoreMediaEngine storeMediaEngine = this.$mediaEngine;
                this.label = 1;
                obj = storeMediaEngine.getDefaultVideoDeviceGUID(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                    return Unit.a;
                }
                Result3.throwOnFailure(obj);
            }
            if (obj != null) {
                WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel = WidgetVoiceBottomSheetViewModel.this;
                WidgetVoiceBottomSheetViewModel.access$joinVoiceChannel(widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.access$getChannelId$p(widgetVoiceBottomSheetViewModel));
                StoreMediaEngine storeMediaEngine2 = this.$mediaEngine;
                this.label = 2;
                if (storeMediaEngine2.selectDefaultVideoDeviceAsync(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                WidgetVoiceBottomSheetViewModel.access$getEventSubject$p(WidgetVoiceBottomSheetViewModel.this).k.onNext(Event.ShowNoVideoDevicesAvailableToast.INSTANCE);
            }
            return Unit.a;
        }
    }

    public WidgetVoiceBottomSheetViewModel(long j, boolean z2, StoreChannels storeChannels, StorePermissions storePermissions, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreMediaSettings storeMediaSettings, StoreMediaEngine storeMediaEngine, StoreUserSettings storeUserSettings, StoreCalls storeCalls, StoreGuilds storeGuilds, VideoPermissionsManager videoPermissionsManager, StoreApplicationStreamPreviews storeApplicationStreamPreviews, VoiceEngineServiceController voiceEngineServiceController, Clock clock, TooltipManager tooltipManager, StoreEmbeddedActivities storeEmbeddedActivities, StoreApplication storeApplication, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TooltipManager tooltipManager2;
        TooltipManager tooltipManager3;
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StorePermissions permissions = (i & 8) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 16) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreMediaSettings mediaSettings = (i & 32) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings;
        StoreMediaEngine mediaEngine = (i & 64) != 0 ? StoreStream.INSTANCE.getMediaEngine() : storeMediaEngine;
        StoreUserSettings userSettings = (i & 128) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        StoreCalls calls = (i & 256) != 0 ? StoreStream.INSTANCE.getCalls() : storeCalls;
        StoreGuilds guilds = (i & 512) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        VideoPermissionsManager videoPermissionsManager2 = (i & 1024) != 0 ? new VideoPermissionsManager(null, 1, null) : videoPermissionsManager;
        StoreApplicationStreamPreviews applicationStreamPreviews = (i & 2048) != 0 ? StoreStream.INSTANCE.getApplicationStreamPreviews() : storeApplicationStreamPreviews;
        VoiceEngineServiceController instance = (i & 4096) != 0 ? VoiceEngineServiceController.INSTANCE.getINSTANCE() : voiceEngineServiceController;
        Clock clock2 = (i & 8192) != 0 ? ClockFactory.get() : clock;
        if ((i & 16384) != 0) {
            AppLog appLog = AppLog.g;
            Intrinsics3.checkNotNullParameter(appLog, "logger");
            WeakReference<FloatingViewManager> weakReference = FloatingViewManager.b.a;
            FloatingViewManager floatingViewManager = weakReference != null ? weakReference.get() : null;
            if (floatingViewManager == null) {
                floatingViewManager = new FloatingViewManager(appLog);
                FloatingViewManager.b.a = new WeakReference<>(floatingViewManager);
            }
            TooltipManager.a aVar = TooltipManager.a.d;
            Intrinsics3.checkNotNullParameter(floatingViewManager, "floatingViewManager");
            WeakReference<TooltipManager> weakReference2 = TooltipManager.a.a;
            TooltipManager tooltipManager4 = weakReference2 != null ? weakReference2.get() : null;
            if (tooltipManager4 == null) {
                tooltipManager3 = new TooltipManager((AcknowledgedTooltipsCache) TooltipManager.a.f2815b.getValue(), (Set) TooltipManager.a.c.getValue(), 0, floatingViewManager, 4);
                TooltipManager.a.a = new WeakReference<>(tooltipManager3);
            } else {
                tooltipManager3 = tooltipManager4;
            }
            tooltipManager2 = tooltipManager3;
        } else {
            tooltipManager2 = tooltipManager;
        }
        this(j, z2, channels, permissions, voiceChannelSelected, mediaSettings, mediaEngine, userSettings, calls, guilds, videoPermissionsManager2, applicationStreamPreviews, instance, clock2, tooltipManager2, (32768 & i) != 0 ? StoreStream.INSTANCE.getEmbeddedActivities() : storeEmbeddedActivities, (65536 & i) != 0 ? StoreStream.INSTANCE.getApplication() : storeApplication, (i & 131072) != 0 ? Companion.access$observeStoreState(INSTANCE, j, permissions, channels) : observable);
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
        return widgetVoiceBottomSheetViewModel.channelId;
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
        return widgetVoiceBottomSheetViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel, StoreState storeState) {
        widgetVoiceBottomSheetViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$joinVoiceChannel(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel, long j) {
        widgetVoiceBottomSheetViewModel.joinVoiceChannel(j);
    }

    private final void emitServerDeafenedDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowServerDeafenedDialog.INSTANCE);
    }

    private final void emitServerMutedDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowServerMutedDialog.INSTANCE);
    }

    private final void emitShowNoScreenSharePermissionDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowNoScreenSharePermissionDialog.INSTANCE);
    }

    private final void emitShowNoVideoPermissionDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowNoVideoPermissionDialog.INSTANCE);
    }

    private final void emitSuppressedDialogEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowSuppressedDialog.INSTANCE);
    }

    private final GuildScheduledEvent getGuildScheduledEventToEnd() {
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            return null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        return GuildScheduledEventUtilities.INSTANCE.getGuildScheduledEventToEndForCall(valid.getCallModel(), valid.getMyPermissions(), this.guildsStore);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        ModelApplicationStream stream;
        this.mostRecentStoreState = storeState;
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            boolean z2 = valid.getCallModel().isConnected() && this.forwardToFullscreenIfVideoActivated && (valid.getCallModel().getIsVideoCall() || valid.getTextInVoiceEnabled());
            if (valid.getCallModel().isConnected() && ChannelUtils.D(valid.getCallModel().getChannel())) {
                this.eventSubject.k.onNext(new Event.LaunchStageChannel(valid.getCallModel().getChannel().getId()));
            }
            String encodedStreamKey = null;
            if (z2) {
                this.eventSubject.k.onNext(new Event.LaunchVideoCall(valid.getCallModel().getChannel().getId(), null));
                return;
            }
            Channel channel = valid.getCallModel().getChannel();
            String strC = ChannelUtils.c(channel);
            Guild guild = valid.getCallModel().getGuild();
            String name = guild != null ? guild.getName() : null;
            StoreApplicationStreaming.ActiveApplicationStream activeStream = valid.getCallModel().getActiveStream();
            if (activeStream != null && (stream = activeStream.getStream()) != null) {
                encodedStreamKey = stream.getEncodedStreamKey();
            }
            String str = encodedStreamKey;
            Map<Long, EmbeddedActivity> embeddedActivitiesForChannel = valid.getCallModel().getEmbeddedActivitiesForChannel();
            List<CallParticipantsAdapter.ListItem> listCreateConnectedListItems = ParticipantsListItemGenerator.INSTANCE.createConnectedListItems(valid.getCallModel().getParticipants(), str, channel, valid.getCallModel(), _Collections.toList(embeddedActivitiesForChannel.values()), valid.getCallModel().getApplications());
            Iterator<Long> it = embeddedActivitiesForChannel.keySet().iterator();
            while (it.hasNext()) {
                this.applicationStore.fetchIfNonexisting(it.next().longValue());
            }
            WidgetVoiceBottomSheet.CenterContent listItems = ParticipantsListItemGenerator.INSTANCE.refreshStreams(listCreateConnectedListItems, this.fetchedPreviews, this.storeApplicationStreamPreviews) ? new WidgetVoiceBottomSheet.CenterContent.ListItems(listCreateConnectedListItems) : new WidgetVoiceBottomSheet.CenterContent.Empty(listCreateConnectedListItems);
            boolean zIsConnected = valid.getCallModel().isConnected();
            this.wasEverConnected = this.wasEverConnected || zIsConnected;
            boolean z3 = valid.getCallModel().getVoiceChannelJoinability() != VoiceChannelJoinabilityUtils2.PERMISSIONS_MISSING;
            Boolean bool = this.wasConnected;
            if (bool != null && !bool.booleanValue() && zIsConnected && valid.getCallModel().isSuppressed()) {
                emitSuppressedDialogEvent();
            }
            this.wasConnected = Boolean.valueOf(zIsConnected);
            this.wasEverMultiParticipant = this.wasEverMultiParticipant || valid.getCallModel().getNumUsersConnected() > 1;
            updateViewState(new ViewState(strC, name, valid.getCallModel().getChannel(), valid.getCallModel().canInvite() && !ChannelUtils.D(valid.getCallModel().getChannel()), valid.getNoiseCancellation(), valid.getCallModel().isDeafenedByAnySource(), listItems, !zIsConnected ? new WidgetVoiceBottomSheet.BottomContent.Connect(z3) : new WidgetVoiceBottomSheet.BottomContent.Controls(valid.getCallModel().getInputMode(), valid.getCallModel().getAudioManagerState(), valid.getCallModel().isMeMutedByAnySource(), valid.getCallModel().getCameraState(), hasVideoPermission(), valid.getCallModel().isStreaming())));
        }
    }

    private final boolean hasVideoPermission() {
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null) {
            return false;
        }
        VideoPermissionsManager videoPermissionsManager = this.videoPermissionsManager;
        Channel channel = valid.getCallModel().getChannel();
        Guild guild = valid.getCallModel().getGuild();
        return videoPermissionsManager.hasVideoPermission(channel, guild != null ? guild.getAfkChannelId() : null, valid.getMyPermissions());
    }

    @MainThread
    private final void joinVoiceChannel(long channelId) {
        this.selectedVoiceChannelStore.selectVoiceChannel(channelId);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ExpandSheet.INSTANCE);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onCameraButtonPressed() {
        if (!hasVideoPermission()) {
            emitShowNoVideoPermissionDialogEvent();
            return;
        }
        WidgetVoiceBottomSheet.BottomContent bottomContent = requireViewState().getBottomContent();
        if (!(bottomContent instanceof WidgetVoiceBottomSheet.BottomContent.Controls)) {
            bottomContent = null;
        }
        WidgetVoiceBottomSheet.BottomContent.Controls controls = (WidgetVoiceBottomSheet.BottomContent.Controls) bottomContent;
        CameraState cameraState = controls != null ? controls.getCameraState() : null;
        if (cameraState == CameraState.CAMERA_DISABLED) {
            return;
        }
        if (cameraState == CameraState.CAMERA_ON) {
            this.mediaEngineStore.selectVideoInputDevice(null);
            return;
        }
        StoreState storeState = this.mostRecentStoreState;
        StoreState.Valid valid = (StoreState.Valid) (storeState instanceof StoreState.Valid ? storeState : null);
        if (valid != null) {
            int numUsersConnected = valid.getCallModel().getNumUsersConnected();
            GuildMaxVideoChannelUsers guildMaxVideoChannelMembers = valid.getCallModel().getGuildMaxVideoChannelMembers();
            if (guildMaxVideoChannelMembers instanceof GuildMaxVideoChannelUsers.Limited) {
                GuildMaxVideoChannelUsers.Limited limited = (GuildMaxVideoChannelUsers.Limited) guildMaxVideoChannelMembers;
                if (numUsersConnected > limited.getLimit()) {
                    this.eventSubject.k.onNext(new Event.ShowCameraCapacityDialog(limited.getLimit()));
                    return;
                }
            }
            this.eventSubject.k.onNext(Event.ShowRequestCameraPermissionsDialog.INSTANCE);
        }
    }

    @MainThread
    public final void onCameraPermissionsGranted() {
        StoreMediaEngine.selectDefaultVideoDevice$default(this.mediaEngineStore, null, 1, null);
    }

    @MainThread
    public final void onDeafenPressed() {
        CallModel callModel;
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null || (callModel = valid.getCallModel()) == null) {
            return;
        }
        if (callModel.isServerDeafened()) {
            emitServerDeafenedDialogEvent();
            return;
        }
        this.mediaSettingsStore.toggleSelfDeafened();
        this.eventSubject.k.onNext(new Event.AccessibilityAnnouncement(callModel.isDeafenedByAnySource() ? R.string.voice_channel_undeafened : R.string.voice_channel_deafened));
    }

    @MainThread
    public final void onDisconnect() {
        this.selectedVoiceChannelStore.clear();
        this.eventSubject.k.onNext(Event.Dismiss.INSTANCE);
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid == null) {
            return;
        }
        if (!this.wasEverConnected || this.wasEverMultiParticipant) {
            CallModel callModel = valid.getCallModel();
            RtcConnection.Metadata rtcConnectionMetadata = callModel.getRtcConnectionMetadata();
            this.eventSubject.k.onNext(new Event.EnqueueCallFeedbackSheet(this.channelId, rtcConnectionMetadata != null ? rtcConnectionMetadata.rtcConnectionId : null, rtcConnectionMetadata != null ? rtcConnectionMetadata.mediaSessionId : null, callModel.getCallDurationMs(this.clock), callModel.getCallFeedbackTriggerRateDenominator()));
        }
    }

    @MainThread
    public final void onDisconnectPressed() {
        GuildScheduledEvent guildScheduledEventToEnd = getGuildScheduledEventToEnd();
        if (guildScheduledEventToEnd == null) {
            onDisconnect();
            return;
        }
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowEventEnd(guildScheduledEventToEnd));
    }

    @MainThread
    public final void onMutePressed() {
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            if (valid.getCallModel().isSuppressed()) {
                emitSuppressedDialogEvent();
                return;
            } else if (valid.getCallModel().isMuted()) {
                emitServerMutedDialogEvent();
                return;
            }
        }
        StoreMediaSettings.SelfMuteFailure selfMuteFailure = this.mediaSettingsStore.toggleSelfMuted();
        if (selfMuteFailure != null) {
            if (selfMuteFailure.ordinal() != 0) {
                return;
            }
            this.eventSubject.k.onNext(new Event.ShowToast(R.string.vad_permission_small));
            return;
        }
        WidgetVoiceBottomSheet.BottomContent bottomContent = requireViewState().getBottomContent();
        if (bottomContent == null || !(bottomContent instanceof WidgetVoiceBottomSheet.BottomContent.Controls)) {
            return;
        }
        this.eventSubject.k.onNext(new Event.AccessibilityAnnouncement(((WidgetVoiceBottomSheet.BottomContent.Controls) bottomContent).isMuted() ? R.string.voice_channel_unmuted : R.string.voice_channel_muted));
    }

    @MainThread
    public final void onNoiseCancellationPressed() {
        Boolean isNoiseCancellationActive = requireViewState().getIsNoiseCancellationActive();
        if (isNoiseCancellationActive != null) {
            boolean zBooleanValue = isNoiseCancellationActive.booleanValue();
            TooltipManager tooltipManager = this.tooltipManager;
            NoiseCancellationTooltip noiseCancellationTooltip = NoiseCancellationTooltip.INSTANCE;
            if (tooltipManager.b(noiseCancellationTooltip, true)) {
                this.tooltipManager.a(noiseCancellationTooltip);
                PublishSubject<Event> publishSubject = this.eventSubject;
                publishSubject.k.onNext(Event.ShowNoiseCancellationBottomSheet.INSTANCE);
                return;
            }
            this.mediaSettingsStore.toggleNoiseCancellation();
            if (zBooleanValue) {
                PublishSubject<Event> publishSubject2 = this.eventSubject;
                publishSubject2.k.onNext(new Event.ShowToast(R.string.noise_cancellation_off));
            } else {
                PublishSubject<Event> publishSubject3 = this.eventSubject;
                publishSubject3.k.onNext(new Event.ShowToast(R.string.noise_cancellation_on));
            }
        }
    }

    @MainThread
    public final void onPttPressed(boolean pressed) {
        this.mediaEngineStore.setPttActive(pressed);
    }

    @MainThread
    public final void onScreenSharePressed() {
        ViewState viewState = getViewState();
        WidgetVoiceBottomSheet.BottomContent bottomContent = viewState != null ? viewState.getBottomContent() : null;
        WidgetVoiceBottomSheet.BottomContent.Controls controls = (WidgetVoiceBottomSheet.BottomContent.Controls) (bottomContent instanceof WidgetVoiceBottomSheet.BottomContent.Controls ? bottomContent : null);
        if (controls != null) {
            if (controls.isScreensharing()) {
                this.voiceEngineServiceController.stopStream();
            } else if (!hasVideoPermission()) {
                emitShowNoScreenSharePermissionDialogEvent();
            } else {
                this.eventSubject.k.onNext(Event.RequestStartStream.INSTANCE);
            }
        }
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
    public final void onToggleRingingPressed(StoreVoiceParticipants.VoiceUser voiceUser) {
        Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
        if (voiceUser.isRinging()) {
            this.callsStore.stopRinging(this.channelId, CollectionsJVM.listOf(Long.valueOf(voiceUser.getUser().getId())));
        } else {
            this.callsStore.ring(this.channelId, CollectionsJVM.listOf(Long.valueOf(voiceUser.getUser().getId())));
        }
    }

    public final void startStream(Intent intent) {
        Intrinsics3.checkNotNullParameter(intent, "intent");
        this.voiceEngineServiceController.startStream(intent);
    }

    @MainThread
    public final void tryConnectToVoice(boolean useVideo) {
        StoreState storeState = this.mostRecentStoreState;
        if (!(storeState instanceof StoreState.Valid)) {
            storeState = null;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        if (valid != null) {
            if (valid.getCallModel().getVoiceChannelJoinability() == VoiceChannelJoinabilityUtils2.GUILD_VIDEO_AT_CAPACITY) {
                this.eventSubject.k.onNext(Event.ShowGuildVideoAtCapacityDialog.INSTANCE);
                return;
            }
            if (!this.userSettingsStore.getIsMobileOverlayEnabled()) {
                this.eventSubject.k.onNext(Event.ShowOverlayNux.INSTANCE);
            }
            if (!useVideo) {
                joinVoiceChannel(this.channelId);
            } else if (!hasVideoPermission()) {
                emitShowNoVideoPermissionDialogEvent();
            } else {
                f.H0(ViewModel3.getViewModelScope(this), null, null, new AnonymousClass1(StoreStream.INSTANCE.getMediaEngine(), null), 3, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheetViewModel(long j, boolean z2, StoreChannels storeChannels, StorePermissions storePermissions, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreMediaSettings storeMediaSettings, StoreMediaEngine storeMediaEngine, StoreUserSettings storeUserSettings, StoreCalls storeCalls, StoreGuilds storeGuilds, VideoPermissionsManager videoPermissionsManager, StoreApplicationStreamPreviews storeApplicationStreamPreviews, VoiceEngineServiceController voiceEngineServiceController, Clock clock, TooltipManager tooltipManager, StoreEmbeddedActivities storeEmbeddedActivities, StoreApplication storeApplication, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeChannels, "channelStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        Intrinsics3.checkNotNullParameter(storeMediaEngine, "mediaEngineStore");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        Intrinsics3.checkNotNullParameter(storeCalls, "callsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(videoPermissionsManager, "videoPermissionsManager");
        Intrinsics3.checkNotNullParameter(storeApplicationStreamPreviews, "storeApplicationStreamPreviews");
        Intrinsics3.checkNotNullParameter(voiceEngineServiceController, "voiceEngineServiceController");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(tooltipManager, "tooltipManager");
        Intrinsics3.checkNotNullParameter(storeEmbeddedActivities, "embeddedActivitiesStore");
        Intrinsics3.checkNotNullParameter(storeApplication, "applicationStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.forwardToFullscreenIfVideoActivated = z2;
        this.channelStore = storeChannels;
        this.permissionsStore = storePermissions;
        this.selectedVoiceChannelStore = storeVoiceChannelSelected;
        this.mediaSettingsStore = storeMediaSettings;
        this.mediaEngineStore = storeMediaEngine;
        this.userSettingsStore = storeUserSettings;
        this.callsStore = storeCalls;
        this.guildsStore = storeGuilds;
        this.videoPermissionsManager = videoPermissionsManager;
        this.storeApplicationStreamPreviews = storeApplicationStreamPreviews;
        this.voiceEngineServiceController = voiceEngineServiceController;
        this.clock = clock;
        this.tooltipManager = tooltipManager;
        this.embeddedActivitiesStore = storeEmbeddedActivities;
        this.applicationStore = storeApplication;
        this.eventSubject = PublishSubject.k0();
        this.fetchedPreviews = new LinkedHashSet();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetVoiceBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
